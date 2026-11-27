package com.taobao.weex.ui.flat.widget;

/* JADX INFO: loaded from: classes.dex */
public interface Widget {
    public static final java.lang.String TAG = "Widget";

    void draw(android.graphics.Canvas canvas);

    com.taobao.weex.ui.view.border.BorderDrawable getBackgroundAndBorder();

    android.graphics.Rect getBorderBox();

    android.graphics.Point getLocInFlatContainer();

    void onDraw(android.graphics.Canvas canvas);

    void setBackgroundAndBorder(com.taobao.weex.ui.view.border.BorderDrawable borderDrawable);

    void setContentBox(int i, int i2, int i3, int i4);

    void setLayout(int i, int i2, int i3, int i4, int i5, int i6, android.graphics.Point point);
}
