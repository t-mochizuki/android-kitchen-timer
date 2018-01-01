package com.example.kitchentimer;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

final class CountDown extends CountDownTimer {

    private SimpleDateFormat _dataFormat;
    private TextView _timer;

    CountDown(TextView timer, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);

        _timer = timer;
        _dataFormat = new SimpleDateFormat("mm:ss.SSS", Locale.US);
        _timer.setText(_dataFormat.format(millisInFuture));
    }

    @Override
    public void onFinish() {
        _timer.setText(_dataFormat.format(0));
    }

    @Override
    public void onTick(long millisUntilFinished) {
        _timer.setText(_dataFormat.format(millisUntilFinished));

    }
}
