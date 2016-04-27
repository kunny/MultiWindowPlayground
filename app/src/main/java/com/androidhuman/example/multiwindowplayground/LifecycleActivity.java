package com.androidhuman.example.multiwindowplayground;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

public class LifecycleActivity extends AppCompatActivity {

    private static final String TAG = "Lifecycle";

    FrameLayout flFrame;

    TextView tvLifecycle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        flFrame = (FrameLayout) findViewById(R.id.fl_activity_lifecycle_frame);
        tvLifecycle = (TextView) findViewById(R.id.tv_activity_lifecycle);

        updateLifecycleLabel("onCreate()");
        log("onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateLifecycleLabel("onStart()");
        log("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateLifecycleLabel("onResume()", R.color.stateResume);
        log("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        updateLifecycleLabel("onPause()", R.color.statePause);
        log("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        updateLifecycleLabel("onStop()");
        log("onStop()");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateLifecycleLabel("onConfigurationChanged()");
        log("onConfigurationChanged()");
    }

    protected FrameLayout getFrameView() {
        return flFrame;
    }

    protected TextView getLifecycleView() {
        return tvLifecycle;
    }

    protected String getPrefix() {
        return this.getClass().getSimpleName();
    }

    private void updateLifecycleLabel(@NonNull String name) {
        updateLifecycleLabel(name, R.color.stateOthers);
    }

    private void updateLifecycleLabel(@NonNull String name, @ColorRes int color) {
        tvLifecycle.setBackgroundColor(ContextCompat.getColor(this, color));
        tvLifecycle.setText(name);
    }

    private void log(String value) {
        Log.d(TAG, String.format("%s - %s", getPrefix(), value));
    }

}
