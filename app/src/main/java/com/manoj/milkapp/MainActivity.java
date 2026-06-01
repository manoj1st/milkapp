package com.manoj.milkapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the WebView programmatically to keep the code simple and avoid XML layout files
        webView = new WebView(this);
        setContentView(webView);

        // Configure vital WebSettings
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true); // CRUCIAL: Enables localStorage for caching prices & daily inputs!
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);

        // Prevent opening link requests in external default browser
        webView.setWebViewClient(new WebViewClient());

        // Load the local HTML file from the assets folder
        webView.loadUrl("file:///android_asset/index1.html");
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
