package io.dcloud.media.weex.weex_video.ijkplayer.utils;

/* JADX INFO: loaded from: classes2.dex */
public final class WindowUtils {
    private WindowUtils() {
        throw new java.lang.Error("Do not need instantiate!");
    }

    public static int getDisplayRotation(android.app.Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }

    public static final boolean isLandscape(android.content.Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static final boolean isPortrait(android.content.Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public static void dimBackground(float f, float f2, android.app.Activity activity) {
        final android.view.Window window = activity.getWindow();
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(f, f2);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: io.dcloud.media.weex.weex_video.ijkplayer.utils.WindowUtils.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                android.view.WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.alpha = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                window.setAttributes(attributes);
            }
        });
        valueAnimatorOfFloat.start();
    }

    public static int getScreenOrientation(android.app.Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (((rotation == 0 || rotation == 2) && i2 > i) || ((rotation == 1 || rotation == 3) && i > i2)) {
            if (rotation == 0) {
                return 1;
            }
            if (rotation == 1) {
                return 0;
            }
            if (rotation != 2) {
                return rotation != 3 ? 1 : 8;
            }
            return 9;
        }
        if (rotation == 0) {
            return 0;
        }
        if (rotation == 1) {
            return 1;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 9;
        }
        return 8;
    }
}
