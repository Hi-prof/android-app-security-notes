package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
public interface OnWXScrollListener {
    public static final int DRAGGING = 1;
    public static final int IDLE = 0;
    public static final int SETTLING = 2;

    void onScrollStateChanged(android.view.View view, int i, int i2, int i3);

    void onScrolled(android.view.View view, int i, int i2);
}
