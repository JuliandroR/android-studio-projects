package com.example.a3712n2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView_ = findViewById(R.id.viewPages);

        WebSettings ws = webView_.getSettings();

        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(false);

        webView_.setWebViewClient(new WebViewClient());

        webView_.loadUrl("http://www.republiquedesmangues.fr/");

        Configuration config = getResources().getConfiguration();

        if((config.screenLayout & config.SCREENLAYOUT_SIZE_MASK) == config.SCREENLAYOUT_SIZE_XLARGE)
            webView_.loadUrl("https://puginarug.com/");
    }
}