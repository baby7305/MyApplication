package com.example.myapplication10131750;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = findViewById(R.id.wb);
        WebSettings webSettings = webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        // 设置可以访问文件
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setDomStorageEnabled(true);

        webView.getSettings().setAllowFileAccessFromFileURLs(true);

        try {
            Class<?> clazz = webView.getSettings().getClass();
            Method method = clazz.getMethod(
                    "setAllowUniversalAccessFromFileURLs", boolean.class);
            method.invoke(webView.getSettings(), true);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //js与android调用
        webView.loadUrl("file:///android_asset/web/电锭的功耗-纺纱.html");
    }
}
