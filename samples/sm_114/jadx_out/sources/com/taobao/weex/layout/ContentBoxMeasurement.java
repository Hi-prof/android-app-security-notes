package com.taobao.weex.layout;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContentBoxMeasurement implements java.io.Serializable, com.taobao.weex.common.Destroyable {
    protected com.taobao.weex.ui.component.WXComponent mComponent;
    protected boolean mMeasureExactly;
    protected float mMeasureHeight;
    protected float mMeasureWidth;

    public abstract void layoutAfter(float f, float f2);

    public abstract void layoutBefore();

    public abstract void measureInternal(float f, float f2, int i, int i2);

    public ContentBoxMeasurement() {
        this.mMeasureExactly = false;
        this.mComponent = null;
    }

    public ContentBoxMeasurement(com.taobao.weex.ui.component.WXComponent wXComponent) {
        this.mMeasureExactly = false;
        this.mComponent = wXComponent;
    }

    public final void measure(float f, float f2, int i, int i2) {
        measureInternal(f, f2, i, i2);
    }

    public float getWidth() {
        return this.mMeasureWidth;
    }

    public boolean getMeasureExactly() {
        return this.mMeasureExactly;
    }

    public float getHeight() {
        return this.mMeasureHeight;
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        this.mComponent = null;
    }
}
