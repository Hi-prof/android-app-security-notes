package com.taobao.weex.ui.animation;

/* JADX INFO: loaded from: classes.dex */
public class BackgroundColorProperty extends android.util.Property<android.view.View, java.lang.Integer> {
    private static final java.lang.String TAG = "BackgroundColorAnimation";

    public BackgroundColorProperty() {
        super(java.lang.Integer.class, "backgroundColor");
    }

    @Override // android.util.Property
    public java.lang.Integer get(android.view.View view) {
        int color;
        com.taobao.weex.ui.view.border.BorderDrawable borderDrawable = com.taobao.weex.utils.WXViewUtils.getBorderDrawable(view);
        if (borderDrawable != null) {
            color = borderDrawable.getColor();
        } else if (view.getBackground() instanceof android.graphics.drawable.ColorDrawable) {
            color = ((android.graphics.drawable.ColorDrawable) view.getBackground()).getColor();
        } else {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "Unsupported background type");
            color = 0;
        }
        return java.lang.Integer.valueOf(color);
    }

    @Override // android.util.Property
    public void set(android.view.View view, java.lang.Integer num) {
        com.taobao.weex.ui.view.border.BorderDrawable borderDrawable = com.taobao.weex.utils.WXViewUtils.getBorderDrawable(view);
        if (borderDrawable != null) {
            borderDrawable.setColor(num.intValue());
        } else if (view.getBackground() instanceof android.graphics.drawable.ColorDrawable) {
            ((android.graphics.drawable.ColorDrawable) view.getBackground()).setColor(num.intValue());
        } else {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "Unsupported background type");
        }
    }
}
