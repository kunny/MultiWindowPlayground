package com.androidhuman.example.multiwindowplayground;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends LifecycleActivity {

    Button btnBasicActivity;

    Button btnUnresizableActivity;

    Button btnAdjacentActivity;

    Button btnConfigChangesActivity;

    Button btnMinimumSizeActivity;

    Button btnFullScreenLifecycle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View layout = LayoutInflater.from(this)
                .inflate(R.layout.activity_main, getFrameView(), true);

        btnBasicActivity = (Button) layout.findViewById(
                R.id.btn_activity_main_basic_activity);
        btnUnresizableActivity = (Button) layout.findViewById(
                R.id.btn_activity_main_unresizable_activity);
        btnAdjacentActivity = (Button) layout.findViewById(
                R.id.btn_activity_main_adjacent_activity);
        btnConfigChangesActivity = (Button) layout.findViewById(
                R.id.btn_activity_main_config_changes_activity);
        btnMinimumSizeActivity = (Button) layout.findViewById(
                R.id.btn_activity_main_minimum_size_activity);
        btnFullScreenLifecycle = (Button) layout.findViewById(
                R.id.btn_activity_main_full_screen_lifecycle);

        btnBasicActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BasicActivity.class));
            }
        });

        btnUnresizableActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UnresizableActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        btnAdjacentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdjacentActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT);
                startActivity(intent);
            }
        });

        btnConfigChangesActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ConfigChangesActivity.class));
            }
        });

        btnMinimumSizeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MinimumSizeActivity.class));
            }
        });

        btnFullScreenLifecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FullScreenLifecycleActivity.class));
            }
        });

    }
}
