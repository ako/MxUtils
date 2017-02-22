package mxgoogleanalyticstests;

import mxgoogleanalytics.impl.GoogleAnalyticsConnector;
import org.junit.Test;

/**
 * Created by ako on 1/21/2017.
 */
public class GoogleAnalyticsConnectorTests {
    private static final boolean debug = false;
    @Test
    public void testTrackPageView(){
        GoogleAnalyticsConnector conn = new GoogleAnalyticsConnector();
        conn.setDebug(debug);
        conn.trackPageView("UA-180552-6",null,"123","mxblog.eu","index.html","Homepage");
    }
    @Test
    public void testTrackEvent(){
        GoogleAnalyticsConnector conn = new GoogleAnalyticsConnector();
        conn.setDebug(debug);
        conn.trackEvent("UA-180552-6",null,"123","video","play","holiday",new Long(300));
    }
    @Test
    public void testTrackEvent2(){
        GoogleAnalyticsConnector conn = new GoogleAnalyticsConnector();
        conn.setDebug(debug);
        conn.trackEvent("UA-180552-5",null,"123","video","play","holiday",new Long(300));
    }
    @Test
    public void testTrackException(){
        GoogleAnalyticsConnector conn = new GoogleAnalyticsConnector();
        conn.setDebug(debug);
        conn.trackException("UA-180552-6",null,"123","IOException",true);
    }
}
