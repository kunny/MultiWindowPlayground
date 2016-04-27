package com.androidhuman.example.multiwindowplayground;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;

public class ConfigChangesActivity extends AppCompatActivity {

    TextView tvConfiguration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvConfiguration = new TextView(this);
        tvConfiguration.setGravity(Gravity.CENTER);
        tvConfiguration.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20.f);
        setContentView(tvConfiguration);
        tvConfiguration.setText(configurationToString(getResources().getConfiguration()));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        tvConfiguration.setText(configurationToString(newConfig));
    }

    private String configurationToString(@NonNull Configuration config) {
        StringBuilder b = new StringBuilder();
        b.append("orientation=");
        b.append(parseOrientation(config)).append('\n');
        b.append("screenSize=");
        b.append(parseScreenSize(config)).append('\n');
        b.append("screenLong=");
        b.append(parseScreenLong(config)).append('\n');
        b.append("smallestScreenWidth=");
        b.append(parseScreenSmallestWidth(config));
        return b.toString();
    }

    private String parseOrientation(Configuration config) {
        return Configuration.ORIENTATION_PORTRAIT == config.orientation ? "Portrait" : "Landscape";
    }

    private String parseScreenSize(Configuration config) {
        int size = Configuration.SCREENLAYOUT_SIZE_MASK & config.screenLayout;
        switch (size) {
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                return "small";
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                return "normal";
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                return "large";
            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                return "xlarge";
        }
        return "Undefined";
    }

    private String parseScreenLong(Configuration config) {
        int screenLong = Configuration.SCREENLAYOUT_LONG_MASK & config.screenLayout;
        switch (screenLong) {
            case Configuration.SCREENLAYOUT_LONG_YES:
                return "long";
            case Configuration.SCREENLAYOUT_LONG_NO:
                return "notlong";
        }
        return "Undefined";
    }

    private String parseScreenSmallestWidth(Configuration config) {
        return String.valueOf(config.smallestScreenWidthDp);
    }
}
