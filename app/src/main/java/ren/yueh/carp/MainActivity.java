package ren.yueh.carp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;

import ren.yueh.crap.Carp;

public class MainActivity extends AppCompatActivity {
    Carp carp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    carp = new Carp(getApplication());
                    carp.connect("http://news.swust.edu.cn/s/108/t/1012/a/67612/info.htm");
                    carp.convert();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
