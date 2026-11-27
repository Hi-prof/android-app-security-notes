package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class WXViewUtils {
    public static final int DIMENSION_UNSET = -1;

    @java.lang.Deprecated
    public static final int OPAQUE = -1;

    @java.lang.Deprecated
    public static final int TRANSLUCENT = -3;

    @java.lang.Deprecated
    public static final int TRANSPARENT = -2;
    private static int mScreenHeight = 0;
    private static int mScreenWidth = 0;
    private static final boolean mUseWebPx = false;
    private static final java.util.concurrent.atomic.AtomicInteger sNextGeneratedId = new java.util.concurrent.atomic.AtomicInteger(1);

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Opacity {
    }

    private static boolean clipCanvasDueToAndroidVersion(android.graphics.Canvas canvas) {
        return true;
    }

    public static int getOpacityFromColor(int i) {
        int i2 = i >>> 24;
        if (i2 == 255) {
            return -1;
        }
        return i2 == 0 ? -2 : -3;
    }

    public static int multiplyColorAlpha(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & 16777215;
        }
        return (i & 16777215) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24);
    }

    public static int generateViewId() {
        return android.view.View.generateViewId();
    }

    public static int getWeexHeight(java.lang.String str) {
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
        if (sDKInstance == null) {
            return -3;
        }
        int weexHeight = sDKInstance.getWeexHeight();
        return (weexHeight >= 0 || weexHeight == -2) ? weexHeight : getScreenHeight(com.taobao.weex.WXEnvironment.sApplication);
    }

    public static int getWeexWidth(java.lang.String str) {
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
        if (sDKInstance == null) {
            return -3;
        }
        int weexWidth = sDKInstance.getWeexWidth();
        return (weexWidth >= 0 || weexWidth == -2) ? weexWidth : getScreenWidth(com.taobao.weex.WXEnvironment.sApplication);
    }

    @java.lang.Deprecated
    public static int getScreenWidth() {
        return getScreenWidth(com.taobao.weex.WXEnvironment.sApplication);
    }

    @java.lang.Deprecated
    public static int setScreenWidth(int i) {
        mScreenWidth = i;
        return i;
    }

    public static float getScreenDensity(android.content.Context context) {
        if (context == null) {
            return 3.0f;
        }
        try {
            return context.getResources().getDisplayMetrics().density;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("getScreenDensityDpi exception:" + e.getMessage());
            return 3.0f;
        }
    }

    public static void updateApplicationScreen(android.content.Context context) {
        if (context == null || com.taobao.weex.WXEnvironment.sApplication == null) {
            return;
        }
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        android.util.DisplayMetrics displayMetrics2 = com.taobao.weex.WXEnvironment.sApplication.getResources().getDisplayMetrics();
        displayMetrics2.heightPixels = displayMetrics.heightPixels;
        displayMetrics2.widthPixels = displayMetrics.widthPixels;
        displayMetrics2.density = displayMetrics.density;
        displayMetrics2.densityDpi = displayMetrics.densityDpi;
        displayMetrics2.scaledDensity = displayMetrics.scaledDensity;
        displayMetrics2.xdpi = displayMetrics.xdpi;
    }

    public static int getScreenWidth(android.content.Context context) {
        if (context != null) {
            android.content.res.Resources resources = context.getResources();
            mScreenWidth = resources.getDisplayMetrics().widthPixels;
            if (com.taobao.weex.WXEnvironment.SETTING_FORCE_VERTICAL_SCREEN) {
                int i = resources.getDisplayMetrics().heightPixels;
                mScreenHeight = i;
                int i2 = mScreenWidth;
                if (i > i2) {
                    i = i2;
                }
                mScreenWidth = i;
            }
        } else if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            throw new com.taobao.weex.common.WXRuntimeException("Error Context is null When getScreenHeight");
        }
        return mScreenWidth;
    }

    public static int getStatusBarHeight(android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", com.taobao.weex.WXEnvironment.OS);
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return -1;
    }

    @java.lang.Deprecated
    public static int getScreenHeight() {
        return getScreenHeight(com.taobao.weex.WXEnvironment.sApplication);
    }

    public static int getScreenHeight(java.lang.String str) {
        return com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str).isFullScreenHeightEnabled() ? getFullScreenHeight(com.taobao.weex.WXEnvironment.sApplication) : getScreenHeight(com.taobao.weex.WXEnvironment.sApplication);
    }

    public static int getFullScreenHeight(android.content.Context context) {
        if (context != null) {
            android.content.res.Resources resources = context.getResources();
            android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
            if (windowManager != null && windowManager.getDefaultDisplay() != null) {
                android.graphics.Point point = new android.graphics.Point();
                windowManager.getDefaultDisplay().getRealSize(point);
                mScreenHeight = point.y;
            } else {
                mScreenHeight = context.getResources().getDisplayMetrics().heightPixels;
            }
            if (com.taobao.weex.WXEnvironment.SETTING_FORCE_VERTICAL_SCREEN) {
                int i = resources.getDisplayMetrics().widthPixels;
                mScreenWidth = i;
                int i2 = mScreenHeight;
                if (i2 > i) {
                    i = i2;
                }
                mScreenHeight = i;
            }
        } else if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            throw new com.taobao.weex.common.WXRuntimeException("Error Context is null When getScreenHeight");
        }
        return mScreenHeight;
    }

    public static int getScreenHeight(android.content.Context context) {
        if (context != null) {
            android.content.res.Resources resources = context.getResources();
            mScreenHeight = resources.getDisplayMetrics().heightPixels;
            if (com.taobao.weex.WXEnvironment.SETTING_FORCE_VERTICAL_SCREEN) {
                int i = resources.getDisplayMetrics().widthPixels;
                mScreenWidth = i;
                int i2 = mScreenHeight;
                if (i2 > i) {
                    i = i2;
                }
                mScreenHeight = i;
            }
        } else if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            throw new com.taobao.weex.common.WXRuntimeException("Error Context is null When getScreenHeight");
        }
        return mScreenHeight;
    }

    @java.lang.Deprecated
    public static float getRealPxByWidth(float f) {
        return realPxByWidth(f, 750.0f);
    }

    public static float getRealPxByWidth(float f, float f2) {
        return realPxByWidth(f, f2);
    }

    public static float getRealPxByWidth(float f, int i) {
        return realPxByWidth(f, i);
    }

    private static float realPxByWidth(float f, float f2) {
        if (java.lang.Float.isNaN(f)) {
            return f;
        }
        float screenWidth = (f * getScreenWidth()) / f2;
        double d = screenWidth;
        if (d <= 0.005d || screenWidth >= 1.0f) {
            return (float) java.lang.Math.rint(d);
        }
        return 1.0f;
    }

    @java.lang.Deprecated
    public static float getRealSubPxByWidth(float f) {
        return realSubPxByWidth(f, 750.0f);
    }

    public static float getRealSubPxByWidth(float f, float f2) {
        return realSubPxByWidth(f, f2);
    }

    public static float getRealSubPxByWidth(float f, int i) {
        return realSubPxByWidth(f, i);
    }

    private static float realSubPxByWidth(float f, float f2) {
        if (java.lang.Float.isNaN(f)) {
            return f;
        }
        float screenWidth = (f * getScreenWidth()) / f2;
        if (screenWidth <= 0.005d || screenWidth >= 1.0f) {
            return screenWidth;
        }
        return 1.0f;
    }

    @java.lang.Deprecated
    public static float getWeexPxByReal(float f) {
        return weexPxByReal(f, 750.0f);
    }

    public static float getWeexPxByReal(float f, float f2) {
        return weexPxByReal(f, f2);
    }

    public static float getWeexPxByReal(float f, int i) {
        return weexPxByReal(f, i);
    }

    private static float weexPxByReal(float f, float f2) {
        return java.lang.Float.isNaN(f) ? f : (f * f2) / getScreenWidth();
    }

    @java.lang.Deprecated
    public static float getRealPxByWidth2(float f) {
        return realPxByWidth2(f, 750.0f);
    }

    public static int getRealPxByWidth2(float f, float f2) {
        return realPxByWidth2(f, f2);
    }

    public static int getRealPxByWidth2(float f, int i) {
        return realPxByWidth2(f, i);
    }

    private static int realPxByWidth2(float f, float f2) {
        float screenWidth = (f * getScreenWidth()) / f2;
        if (screenWidth <= 0.005d || screenWidth >= 1.0f) {
            return ((int) screenWidth) - 1;
        }
        return 1;
    }

    @java.lang.Deprecated
    public static float getWebPxByWidth(float f) {
        return webPxByWidth(f, 750.0f);
    }

    public static float getWebPxByWidth(float f, float f2) {
        return webPxByWidth(f, f2);
    }

    public static float getWebPxByWidth(float f, int i) {
        return webPxByWidth(f, i);
    }

    private static float webPxByWidth(float f, float f2) {
        double d = f;
        if (d < -1.9999d && d > -2.005d) {
            return Float.NaN;
        }
        float screenWidth = (f * f2) / getScreenWidth();
        if (screenWidth <= 0.005d || screenWidth >= 1.0f) {
            return screenWidth;
        }
        return 1.0f;
    }

    public static int dip2px(float f) {
        float f2;
        try {
            f2 = com.taobao.weex.WXEnvironment.getApplication().getResources().getDisplayMetrics().density;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXViewUtils] dip2px:", e);
            f2 = 2.0f;
        }
        float f3 = (f * f2) + 0.5f;
        if (f3 <= 0.0f || f3 >= 1.0f) {
            return (int) f3;
        }
        return 1;
    }

    public static boolean onScreenArea(android.view.View view) {
        int height;
        if (view != null && view.getVisibility() == 0) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                height = layoutParams.height;
            } else {
                height = view.getHeight();
            }
            int i = iArr[1];
            if (i <= 0 || i - getScreenHeight(com.taobao.weex.WXEnvironment.sApplication) >= 0) {
                int i2 = iArr[1];
                if (height + i2 <= 0 || i2 > 0) {
                }
            }
            return true;
        }
        return false;
    }

    public static void setBackGround(android.view.View view, android.graphics.drawable.Drawable drawable, com.taobao.weex.ui.component.WXComponent wXComponent) {
        try {
            view.setBackground(drawable);
        } catch (java.lang.Exception unused) {
            if (wXComponent == null) {
                return;
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(wXComponent.getInstanceId(), com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_TEXTURE_SETBACKGROUND, wXComponent.getComponentType() + " setBackGround for android view", com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_TEXTURE_SETBACKGROUND.getErrorMsg() + ": TextureView doesn't support displaying a background drawable!", null);
        }
    }

    public static com.taobao.weex.ui.view.border.BorderDrawable getBorderDrawable(android.view.View view) {
        android.graphics.drawable.Drawable background = view.getBackground();
        if (background instanceof com.taobao.weex.ui.view.border.BorderDrawable) {
            return (com.taobao.weex.ui.view.border.BorderDrawable) background;
        }
        if (!(background instanceof android.graphics.drawable.LayerDrawable)) {
            return null;
        }
        android.graphics.drawable.LayerDrawable layerDrawable = (android.graphics.drawable.LayerDrawable) background;
        if (layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        for (int i = 0; i < layerDrawable.getNumberOfLayers(); i++) {
            android.graphics.drawable.Drawable drawable = layerDrawable.getDrawable(i);
            if (drawable instanceof com.taobao.weex.ui.view.border.BorderDrawable) {
                return (com.taobao.weex.ui.view.border.BorderDrawable) drawable;
            }
        }
        return null;
    }

    public static void clipCanvasWithinBorderBox(android.view.View view, android.graphics.Canvas canvas) {
        if (clipCanvasDueToAndroidVersion(canvas) && clipCanvasIfAnimationExist(view)) {
            com.taobao.weex.ui.view.border.BorderDrawable borderDrawable = getBorderDrawable(view);
            if ((borderDrawable instanceof com.taobao.weex.ui.view.border.BorderDrawable) && borderDrawable.isRounded() && clipCanvasIfBackgroundImageExist(view, borderDrawable)) {
                android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
                android.graphics.Path contentPath = borderDrawable.getContentPath(rectF);
                if (view instanceof com.taobao.weex.ui.view.WXFrameLayout) {
                    com.taobao.weex.ui.component.WXDiv component = ((com.taobao.weex.ui.view.WXFrameLayout) view).getComponent();
                    if (component != null) {
                        java.lang.Object obj = component.getAttrs().get(com.taobao.weex.common.Constants.Name.ROTATE_FIX);
                        if (obj != null && obj.toString().equals(io.dcloud.common.constant.AbsoluteConst.TRUE)) {
                            canvas.clipRect(rectF);
                            return;
                        } else {
                            if ((component.getStyles() == null || !"hidden".equals(component.getStyles().getOverflow())) && android.os.Build.VERSION.SDK_INT >= 24) {
                                return;
                            }
                            canvas.clipPath(contentPath);
                            return;
                        }
                    }
                    return;
                }
                canvas.clipPath(contentPath);
            }
        }
    }

    public static void clipCanvasWithinBorderBox(com.taobao.weex.ui.flat.widget.Widget widget, android.graphics.Canvas canvas) {
        com.taobao.weex.ui.view.border.BorderDrawable backgroundAndBorder;
        if (clipCanvasDueToAndroidVersion(canvas) && clipCanvasIfAnimationExist(null) && (backgroundAndBorder = widget.getBackgroundAndBorder()) != null) {
            if (backgroundAndBorder.isRounded() && clipCanvasIfBackgroundImageExist(widget, backgroundAndBorder)) {
                canvas.clipPath(backgroundAndBorder.getContentPath(new android.graphics.RectF(0.0f, 0.0f, widget.getBorderBox().width(), widget.getBorderBox().height())));
            } else {
                canvas.clipRect(widget.getBorderBox());
            }
        }
    }

    private static boolean clipCanvasIfAnimationExist(android.view.View view) {
        return android.os.Build.VERSION.SDK_INT < 24;
    }

    private static boolean clipCanvasIfBackgroundImageExist(android.view.View view, com.taobao.weex.ui.view.border.BorderDrawable borderDrawable) {
        if (!(view instanceof android.view.ViewGroup)) {
            return true;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            com.taobao.weex.ui.view.border.BorderDrawable borderDrawable2 = getBorderDrawable(viewGroup.getChildAt(i));
            if (borderDrawable2 != null) {
                borderDrawable2.hasImage();
            }
        }
        return true;
    }

    private static boolean clipCanvasIfBackgroundImageExist(com.taobao.weex.ui.flat.widget.Widget widget, com.taobao.weex.ui.view.border.BorderDrawable borderDrawable) {
        if (!(widget instanceof com.taobao.weex.ui.flat.widget.WidgetGroup)) {
            return true;
        }
        java.util.Iterator<com.taobao.weex.ui.flat.widget.Widget> it = ((com.taobao.weex.ui.flat.widget.WidgetGroup) widget).getChildren().iterator();
        while (it.hasNext()) {
            it.next().getBackgroundAndBorder().hasImage();
        }
        return true;
    }
}
