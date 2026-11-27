package com.dmcbig.mediapicker.utils;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ScreenUtils {
    private ScreenUtils() {
        throw new java.lang.UnsupportedOperationException("本屏幕工具类不能被实例化,直接调用静态方法就好");
    }

    public static int dp2px(android.content.Context context, float f) {
        return (int) android.util.TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static void fitAndroid16WindowInsets(android.app.Activity activity, android.view.View view, final int i) {
        if (android.os.Build.VERSION.SDK_INT < 36 || io.dcloud.common.adapter.util.AndroidResources.sAppTargetSdkVersion < 36) {
            return;
        }
        activity.getWindow().setNavigationBarContrastEnforced(false);
        androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(view, new androidx.core.view.OnApplyWindowInsetsListener() { // from class: com.dmcbig.mediapicker.utils.ScreenUtils$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view2, androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
                return com.dmcbig.mediapicker.utils.ScreenUtils.lambda$fitAndroid16WindowInsets$0(i, view2, windowInsetsCompat);
            }
        });
    }

    public static int getBottomStatusHeight(android.content.Context context) {
        return getDpi(context) - getScreenHeight(context);
    }

    public static int getDpi(android.content.Context context) {
        android.view.Display defaultDisplay = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay();
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        try {
            java.lang.Class.forName("android.view.Display").getMethod("getRealMetrics", android.util.DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getScreenHeight(android.content.Context context) {
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(android.content.Context context) {
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getTitleHeight(android.app.Activity activity) {
        return activity.getWindow().findViewById(android.R.id.content).getTop();
    }

    public static boolean isScreenOriatationPortrait(android.content.Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    static /* synthetic */ androidx.core.view.WindowInsetsCompat lambda$fitAndroid16WindowInsets$0(int i, android.view.View view, androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            androidx.core.graphics.Insets insets = windowInsetsCompat.getInsets(i);
            view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        }
        return androidx.core.view.WindowInsetsCompat.CONSUMED;
    }

    public static float px2dp(android.content.Context context, float f) {
        return f / context.getResources().getDisplayMetrics().density;
    }

    public static float px2sp(android.content.Context context, float f) {
        return f / context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static int sp2px(android.content.Context context, float f) {
        return (int) android.util.TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }
}
