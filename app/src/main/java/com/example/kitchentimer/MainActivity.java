package com.example.kitchentimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView timerView;
    private CountDown countDown;
    private boolean _start = false;
    private long _millisInFuture = 0;
    private SimpleDateFormat _dataFormat = new SimpleDateFormat("mm:ss.SSS", Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerView = (TextView)findViewById(R.id.timerView);
        timerView.setText(_dataFormat.format(_millisInFuture));
    }

    public void onStart(View view) {
        if (_millisInFuture == 0) return;

        if (_start == false) {
            _start = true;
            countDown = new CountDown(timerView, _millisInFuture, 300);
            countDown.start();
        }
    }

    public void onStop(View view) {
        if (_start == true) {
            countDown.cancel();
            _millisInFuture = 0;
            timerView.setText(_dataFormat.format(_millisInFuture));
            _start = false;
        }
    }

    public void onReset(View view) {
        if (_start == false) {
            _millisInFuture = 0;
            timerView.setText(_dataFormat.format(_millisInFuture));
        }
    }

    public void onTenSeconds(View view) {
        if (_start == false) {
            _millisInFuture += 10 * 1000;
            timerView.setText(_dataFormat.format(_millisInFuture));
        }
    }

    public void onOneSecond(View view) {
        if (_start == false) {
            _millisInFuture += 1 * 1000;
            timerView.setText(_dataFormat.format(_millisInFuture));
        }
    }

    public void onTenMinutes(View view) {
        if (_start == false) {
            _millisInFuture += 10 * 60 * 1000;
            timerView.setText(_dataFormat.format(_millisInFuture));
        }
    }

    public void onOneMinute(View view) {
        if (_start == false) {
            _millisInFuture += 1 * 60 * 1000;
            timerView.setText(_dataFormat.format(_millisInFuture));
        }
    }
}
