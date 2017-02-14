package mixpaneltest;

import mixpanel.impl.MixPanelConnector;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by ako on 1/20/2017.
 */
public class TestMixPanelConnector {
    @Test
    public void testSendEvent() throws IOException {
        MixPanelConnector conn = new MixPanelConnector();
        conn.sendEvent("d026150fca3d53c5efbaaee78aed9323",
                "test",
                "sendevent",
                "a=b;c=d;e=1;f=true"
        );
    }
}
