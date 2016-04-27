package com.androidhuman.example.multiwindowplayground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

public class FullScreenLifecycleActivity extends LifecycleActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout.LayoutParams lp =
                (LinearLayout.LayoutParams) getLifecycleView().getLayoutParams();
        lp.height = LinearLayout.LayoutParams.MATCH_PARENT;
        getLifecycleView().setLayoutParams(lp);
    }
}
