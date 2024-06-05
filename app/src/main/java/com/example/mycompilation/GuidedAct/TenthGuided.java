package com.example.mycompilation.GuidedAct;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.mycompilation.R;

public class TenthGuided extends AppCompatActivity {

    WebView browser;
    AutoCompleteTextView suggestedURL;
    ArrayAdapter adapter;
    Button submit;
    ImageView ivReturn;
    String [] urls = {"google.com","yahoo.com","facebook.com","youtube.com"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth);

        browser = findViewById(R.id.webView);
        suggestedURL = findViewById(R.id.actvURLGE10);
        submit = findViewById(R.id.btnOpenURLGE10);

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,urls);
        suggestedURL.setThreshold(2);
        suggestedURL.setAdapter(adapter);

        initializeWebView();
        loadWebURL();

    }

    public void initializeWebView(){
        browser.getSettings().setLoadsImagesAutomatically(true);
        // enabled java script
        browser.getSettings().setJavaScriptEnabled(true);
        // Android webview launches browser when calling loadurl
        browser.setWebViewClient(new WebViewClient());
        // enabled Scrollbar
        browser.setScrollBarStyle(browser.SCROLLBARS_INSIDE_OVERLAY);
    }

    public void loadWebURL(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = suggestedURL.getText().toString();

                if(!url.startsWith("www.") && !url.startsWith("https://") ){
                    url = "www." + url;
                }
                if(!url.startsWith("https://") ){
                    url = "https://" + url;
                }
                browser.loadUrl(url);
            }
        });
    }
    public void returnClicked(){
        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
