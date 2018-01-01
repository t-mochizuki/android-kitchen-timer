package com.example.kitchentimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView timerView;
    private CountDown countDown;
    private boolean _start = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerView = (TextView)findViewById(R.id.timerView);
    }

    public void onStart(View view) {
        if (_start == false) {
            _start = true;
            countDown = new CountDown(timerView, 3 * 1000, 300);
            countDown.start();
        }
    }

    public void onStop(View view) {
        countDown.onStop();
        _start = false;
    }
}
