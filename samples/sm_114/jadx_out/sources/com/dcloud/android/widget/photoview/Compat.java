package com.dcloud.android.widget.photoview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class Compat {
    private static final int SIXTY_FPS_INTERVAL = 16;

    Compat() {
    }

    private static void postOnAnimationJellyBean(android.view.View view, java.lang.Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void postOnAnimation(android.view.View view, java.lang.Runnable runnable) {
        postOnAnimationJellyBean(view, runnable);
    }
}
