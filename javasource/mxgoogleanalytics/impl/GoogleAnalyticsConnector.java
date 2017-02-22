package mxgoogleanalytics.impl;

import com.mendix.logging.ILogNode;
import okhttp3.*;

/**
 * Created by ako on 1/21/2017.
 */
public class GoogleAnalyticsConnector {
    public static final String LOGNODE = "GoogleAnalytics";
    private static final String ContentType = "application/x-www-form-urlencoded";

    public GoogleAnalyticsConnector() {

    }

    public void trackPageView(String trackingId, String clientId, String userId, String documentHostname, String page, String title) {
        try {
            OkHttpClient client = new OkHttpClient();
            String payload = null;
            if (clientId == null || clientId.equals("")) {
                payload = String.format("v=%d&tid=%s&uid=%s&t=%s&dh=%s&dp=%s&dt=%s",
                        1, trackingId, userId, "pageview", documentHostname, page, title);
            } else {
                payload = String.format("v=%d&tid=%s&cid=%s&t=%s&dh=%s&dp=%s&dt=%s",
                        1, trackingId, clientId, "pageview", documentHostname, page, title);
            }
            RequestBody body = RequestBody.create(MediaType.parse(ContentType), payload);
            Request request = new Request.Builder().url(gaUrl).post(body).build();
            info(String.format("request: %s, payload: %s", request, payload));
            Response response = client.newCall(request).execute();
            info(response.body().string());
        } catch (Exception e) {
            info(e.toString());
        }
    }

    public void trackEvent(String trackingId, String clientId, String userId, String eventCategory, String eventAction, String eventLabel, Long eventValue) {
        try {
            OkHttpClient client = new OkHttpClient();
            String payload = null;
            if (clientId == null || clientId.equals("")) {
                payload = String.format("v=%d&tid=%s&uid=%s&t=%s&ec=%s&ea=%s",
                        1, trackingId, userId, "event", eventCategory, eventAction);
            } else {
                payload = String.format("v=%d&tid=%s&cid=%s&t=%s&ec=%s&ea=%s",
                        1, trackingId, clientId, "event", eventCategory, eventAction);
            }
            if(eventLabel != null && !eventLabel.equals("")){
                payload += String.format("&el=%s&ev=%d", eventLabel, eventValue);
            }
            RequestBody body = RequestBody.create(MediaType.parse(ContentType), payload);
            Request request = new Request.Builder().url(gaUrl).post(body).build();
            info(String.format("request: %s, payload: %s", request, payload));
            Response response = client.newCall(request).execute();
            info(response.body().string());
        } catch (Exception e) {
            info(e.toString());
        }
    }

    public void trackException(String trackingId, String clientId, String userId, String exceptionDescription, Boolean isFatal) {
        try {
            OkHttpClient client = new OkHttpClient();
            String payload = null;
            if (clientId == null || clientId.equals("")) {
                payload = String.format("v=%d&tid=%s&uid=%s&t=%s&exd=%s&exf=%d",
                        1, trackingId, userId, "exception", exceptionDescription, (isFatal ? 1 : 0));
            } else {
                payload = String.format("v=%d&tid=%s&cid=%s&t=%s&exd=%s&exf=%d",
                        1, trackingId, clientId, "exception", exceptionDescription, (isFatal ? 1 : 0));
            }
            RequestBody body = RequestBody.create(MediaType.parse(ContentType), payload);
            Request request = new Request.Builder().url(gaUrl).post(body).build();
            info(String.format("request: %s, payload: %s", request, payload));
            Response response = client.newCall(request).execute();
            info(response.body().string());
        } catch (Exception e) {
            info(e.toString());
        }
    }

    private void info(String message) {
        if (logger == null) {
            System.out.println(message);
        } else {
            logger.info(message);
        }
    }

    public void setLogger(ILogNode logger) {
        this.logger = logger;
    }

    private ILogNode logger = null;

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        if (debug) {
            gaUrl = "https://www.google-analytics.com/debug/collect";
        } else {
            gaUrl = "https://www.google-analytics.com/collect";
        }
        isDebug = debug;
    }

    private boolean isDebug = false;
    private String gaUrl = "https://www.google-analytics.com/collect";

}
