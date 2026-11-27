package com.facebook.drawee.drawable;

/* JADX INFO: compiled from: DrawableUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u000b\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J&\u0010\u000e\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0007J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¨\u0006\u0018"}, d2 = {"Lcom/facebook/drawee/drawable/DrawableUtils;", "", "<init>", "()V", "cloneDrawable", "Landroid/graphics/drawable/Drawable;", "drawable", "copyProperties", "", "to", "from", "setDrawableProperties", "properties", "Lcom/facebook/drawee/drawable/DrawableProperties;", "setCallbacks", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "Landroid/graphics/drawable/Drawable$Callback;", "transformCallback", "Lcom/facebook/drawee/drawable/TransformCallback;", "multiplyColorAlpha", "", "color", "alpha", "getOpacityFromColor", "drawee_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DrawableUtils {
    public static final com.facebook.drawee.drawable.DrawableUtils INSTANCE = new com.facebook.drawee.drawable.DrawableUtils();

    @kotlin.jvm.JvmStatic
    public static final int getOpacityFromColor(int color) {
        int i = color >>> 24;
        if (i != 0) {
            return i != 255 ? -3 : -1;
        }
        return -2;
    }

    @kotlin.jvm.JvmStatic
    public static final int multiplyColorAlpha(int color, int alpha) {
        if (alpha == 255) {
            return color;
        }
        if (alpha == 0) {
            return color & 16777215;
        }
        return (color & 16777215) | ((((color >>> 24) * (alpha + (alpha >> 7))) >> 8) << 24);
    }

    private DrawableUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.jvm.JvmStatic
    public static final android.graphics.drawable.Drawable cloneDrawable(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawableCloneDrawable;
        if (drawable == 0) {
            return null;
        }
        com.facebook.drawee.drawable.CloneableDrawable cloneableDrawable = drawable instanceof com.facebook.drawee.drawable.CloneableDrawable ? (com.facebook.drawee.drawable.CloneableDrawable) drawable : null;
        if (cloneableDrawable != null && (drawableCloneDrawable = cloneableDrawable.cloneDrawable()) != null) {
            return drawableCloneDrawable;
        }
        android.graphics.drawable.Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            return constantState.newDrawable();
        }
        return null;
    }

    @kotlin.jvm.JvmStatic
    public static final void copyProperties(android.graphics.drawable.Drawable to, android.graphics.drawable.Drawable from) {
        if (from == null || to == null || to == from) {
            return;
        }
        to.setBounds(from.getBounds());
        to.setChangingConfigurations(from.getChangingConfigurations());
        to.setLevel(from.getLevel());
        to.setVisible(from.isVisible(), false);
        to.setState(from.getState());
    }

    @kotlin.jvm.JvmStatic
    public static final void setDrawableProperties(android.graphics.drawable.Drawable drawable, com.facebook.drawee.drawable.DrawableProperties properties) {
        if (drawable == null || properties == null) {
            return;
        }
        properties.applyTo(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.jvm.JvmStatic
    public static final void setCallbacks(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable.Callback callback, com.facebook.drawee.drawable.TransformCallback transformCallback) {
        if (drawable == 0) {
            return;
        }
        drawable.setCallback(callback);
        com.facebook.drawee.drawable.TransformAwareDrawable transformAwareDrawable = drawable instanceof com.facebook.drawee.drawable.TransformAwareDrawable ? (com.facebook.drawee.drawable.TransformAwareDrawable) drawable : null;
        if (transformAwareDrawable != null) {
            transformAwareDrawable.setTransformCallback(transformCallback);
        }
    }
}
