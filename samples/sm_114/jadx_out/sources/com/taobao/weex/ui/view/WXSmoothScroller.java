package com.taobao.weex.ui.view;

/* JADX INFO: loaded from: classes.dex */
public class WXSmoothScroller extends android.widget.Scroller {
    private double mScrollFactor;

    public WXSmoothScroller(android.content.Context context) {
        super(context);
        this.mScrollFactor = 1.0d;
    }

    public WXSmoothScroller(android.content.Context context, android.view.animation.Interpolator interpolator) {
        super(context, interpolator);
        this.mScrollFactor = 1.0d;
    }

    public WXSmoothScroller(android.content.Context context, android.view.animation.Interpolator interpolator, boolean z) {
        super(context, interpolator, z);
        this.mScrollFactor = 1.0d;
    }

    public void setScrollDurationFactor(double d) {
        this.mScrollFactor = d;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, (int) (((double) i5) * this.mScrollFactor));
    }
}
