package com.marolix.androidonlinequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class TermOfUsage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_of_usage);
        WebView webView=findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/webview.html");

    }
}
