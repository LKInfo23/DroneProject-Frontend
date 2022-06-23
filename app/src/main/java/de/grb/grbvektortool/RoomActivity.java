package de.grb.grbvektortool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        WebView webView = findViewById(R.id.room_webview);
        webView.loadUrl("file:///android_asset/index.html");
    }
}