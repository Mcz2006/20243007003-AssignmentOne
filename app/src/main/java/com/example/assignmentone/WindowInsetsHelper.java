package com.example.assignmentone;

import android.view.View;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Small helper that keeps content clear of the system navigation bar.
 *
 * <p>The theme is edge-to-edge on Android 15+, so the banner is deliberately drawn
 * behind the status bar, but the bottom of the screen has to be padded or the
 * button labels end up underneath the navigation bar.</p>
 */
final class WindowInsetsHelper {

    private WindowInsetsHelper() {
        // Utility class: no instances.
    }

    /**
     * Adds left/right/bottom system bar padding to the given root view.
     *
     * @param root root view of the activity
     */
    static void applyBottomInset(View root) {
        ViewCompat.setOnApplyWindowInsetsListener(root, (view, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(bars.left, 0, bars.right, bars.bottom);
            return insets;
        });
    }
}
