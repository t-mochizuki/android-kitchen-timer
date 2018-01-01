package com.example.kitchentimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView timerView;
    private CountDown countDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerView = (TextView)findViewById(R.id.timerView);
        countDown = new CountDown(timerView, 0, 300);
    }

    public void onStart(View view) {
        countDown.start();
    }

    public void onStop(View view) {
        countDown.cancel();
    }
}
