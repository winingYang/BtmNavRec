package com.surkaa.btmnavrec;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public class MyChronometer extends Chronometer implements LifecycleEventObserver {

    private long elapsedTime = 0;

    public MyChronometer(Context context) {
        super(context);
    }

    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyChronometer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
/*
    // 实现DefaultLifecycleObserver接口方法
    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        elapsedTime = SystemClock.elapsedRealtime() - getBase();
        stop();
        DefaultLifecycleObserver.super.onPause(owner);
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        setBase(SystemClock.elapsedRealtime() - elapsedTime);
        start();
        DefaultLifecycleObserver.super.onResume(owner);
    }
*/
    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
        switch (event) {
            case ON_START:
                setBase(SystemClock.elapsedRealtime() - elapsedTime);
                start();
                break;
            case ON_STOP:
                stop();
                elapsedTime = SystemClock.elapsedRealtime() - getBase();
                break;
        }
    }
}
