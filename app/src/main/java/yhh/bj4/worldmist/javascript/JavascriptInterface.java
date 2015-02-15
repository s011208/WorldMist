package yhh.bj4.worldmist.javascript;

import android.util.Log;
import android.webkit.WebView;

/**
 * Created by yenhsunhuang on 15/2/15.
 */
public class JavascriptInterface {
    private static final String TAG = "QQQQ";
    private double mLatitude = 25.033146;
    private double mLongtitude = 121.5637343;
    private int mZoom = 10;
    private WebView mWebView;

    public void setWebView(WebView wv) {
        mWebView = wv;
    }

    @android.webkit.JavascriptInterface
    public double getLatitude() {
        return mLatitude;
    }

    @android.webkit.JavascriptInterface
    public double getLongitude() {
        return mLongtitude;
    }

    @android.webkit.JavascriptInterface
    public int getZoom() {
        return mZoom;
    }

    @android.webkit.JavascriptInterface
    public void onCenterChanged(double lat, double lng) {
        Log.d(TAG, "centerCallback, lat: " + lat + ", lng: " + lng);
    }

    @android.webkit.JavascriptInterface
    public void onBoundChanged(double left, double top, double right, double bottom) {
        Log.d(TAG, "l: " + left + ", t: " + top
                + ", r: " + right
                + ", b: " + bottom);
    }

    @android.webkit.JavascriptInterface
    public void moveCenter() {
        mWebView.loadUrl("javascript:moveCenterTest(40, 60)");
    }
}
