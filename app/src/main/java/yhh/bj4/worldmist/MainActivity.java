package yhh.bj4.worldmist;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import yhh.bj4.worldmist.javascript.JavascriptInterface;


public class MainActivity extends ActionBarActivity {
    private static final String MAIN_MAP_HTML_PATH = "file:///android_asset/main_map.html";
    private WebView mMapView;
    private static final JavascriptInterface mJavascriptInterface = new JavascriptInterface();
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mHandler.postDelayed(new Runnable(){
            @Override
            public void run() {
                mJavascriptInterface.moveCenter();
            }
        }, 5000);
    }

    private void initView() {
        mMapView = (WebView) findViewById(R.id.webView);
        mMapView.setWebViewClient(new WebViewClient());
        mMapView.getSettings().setJavaScriptEnabled(true);
        mMapView.loadUrl(MAIN_MAP_HTML_PATH);
        mMapView.addJavascriptInterface(mJavascriptInterface, "android");
        mJavascriptInterface.setWebView(mMapView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
