package mixpanel.impl;

import com.mendix.logging.ILogNode;
import com.mixpanel.mixpanelapi.ClientDelivery;
import com.mixpanel.mixpanelapi.MessageBuilder;
import com.mixpanel.mixpanelapi.MixpanelAPI;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by ako on 1/20/2017.
 */
public class MixPanelConnector {
    public MixPanelConnector() {

    }

    public void sendEvent(String projectToken, String distinctId, String eventName, String properties) throws IOException {
        Runnable task = () -> {
            try {
                MessageBuilder messageBuilder =
                        new MessageBuilder(projectToken);
                JSONObject props = new JSONObject();
                if (properties != null) {
                    Arrays.stream(properties.split(";")).
                            map(s -> s.split("=")).
                            forEach(kv -> {
                                try {
                                    props.put(kv[0], kv[1]);
                                } catch (Exception e) {
                                    info("Failed to set property" + e.toString());
                                }
                            });
                }
                JSONObject sentEvent =
                        messageBuilder.event(distinctId, eventName, props);
                ClientDelivery delivery = new ClientDelivery();
                delivery.addMessage(sentEvent);
                MixpanelAPI mixpanel = new MixpanelAPI();
                mixpanel.deliver(delivery);
            } catch (Exception e) {
                info("Failed to send event to MixPanel: " + e.toString());
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    private void info(String message) {
        if (logger == null) {
            System.out.println(message);
        } else {
            logger.info(message);
        }
    }

    private ILogNode logger = null;

    public void setLogger(ILogNode logger) {
        this.logger = logger;
    }

    public static final String LOGNODE = "MixPanel";
}
