
package com.aalam.compiler;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    static {
        System.loadLibrary("aalam_core");
    }

    public native String nativeGetStatus();

    private int gold = Color.rgb(246, 189, 53);
    private int background = Color.rgb(8, 10, 14);

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(24, 32, 24, 24);
        root.setBackgroundColor(background);

        TextView brand = new TextView(this);
        brand.setText("AALAM COMPILER");
        brand.setTextColor(gold);
        brand.setTextSize(25);
        brand.setGravity(Gravity.CENTER);
        brand.setPadding(0, 18, 0, 12);
        root.addView(brand);

        TextView subtitle = new TextView(this);
        subtitle.setText("C/C++ APP & GAME BUILD STUDIO");
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setTextSize(12);
        subtitle.setGravity(Gravity.CENTER);
        root.addView(subtitle);

        TextView status = new TextView(this);
        status.setTextColor(Color.WHITE);
        status.setTextSize(15);
        status.setPadding(0, 32, 0, 24);
        status.setText(nativeGetStatus());
        root.addView(status);

        addSection(root, "PROJECT TYPE");
        addSection(root, "Android App");
        addSection(root, "Game Project");

        addSection(root, "TARGET PLATFORMS");
        addSection(root, "Android  |  iOS  |  Windows");
        addSection(root, "macOS  |  Linux");

        TextView info = new TextView(this);
        info.setText(
            "\nBuild dashboard initialized.\n" +
            "Native compilation toolchains are not yet connected."
        );
        info.setTextColor(Color.LTGRAY);
        info.setTextSize(13);
        info.setPadding(0, 24, 0, 0);
        root.addView(info);

        setContentView(root);
    }

    private void addSection(
        LinearLayout root,
        String text
    ) {
        TextView view = new TextView(this);
        view.setText(text);
        view.setTextColor(gold);
        view.setTextSize(16);
        view.setPadding(0, 12, 0, 12);
        root.addView(view);
    }
}
