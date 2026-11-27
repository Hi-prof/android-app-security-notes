package com.facebook.common.activitylistener;

/* JADX INFO: loaded from: classes.dex */
public interface ActivityListener {
    public static final int MAX_PRIORITY = 10;
    public static final int MIN_PRIORITY = 1;

    int getPriority();

    void onActivityCreate(android.app.Activity activity);

    void onDestroy(android.app.Activity activity);

    void onPause(android.app.Activity activity);

    void onResume(android.app.Activity activity);

    void onStart(android.app.Activity activity);

    void onStop(android.app.Activity activity);
}
