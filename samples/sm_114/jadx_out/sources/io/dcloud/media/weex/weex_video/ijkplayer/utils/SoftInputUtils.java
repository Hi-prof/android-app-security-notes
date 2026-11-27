package io.dcloud.media.weex.weex_video.ijkplayer.utils;

/* JADX INFO: loaded from: classes2.dex */
public class SoftInputUtils {
    private SoftInputUtils() {
        throw new java.lang.AssertionError();
    }

    public static void closeSoftInput(android.content.Context context) {
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            android.app.Activity activity = (android.app.Activity) context;
            if (activity.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
            }
        }
    }

    public static void setEditFocusable(android.content.Context context, android.view.View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        ((android.view.inputmethod.InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
    }
}
