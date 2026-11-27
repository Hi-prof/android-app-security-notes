package com.taobao.weex.ui.component.richtext.span;

/* JADX INFO: loaded from: classes.dex */
public class ImgSpan extends android.text.style.ReplacementSpan implements com.taobao.weex.adapter.IDrawableLoader.StaticTarget {
    private int height;
    private java.lang.String instanceId;
    private android.graphics.drawable.Drawable mDrawable;
    private android.view.View mView;
    private java.lang.String ref;
    private int width;

    public ImgSpan(int i, int i2, java.lang.String str, java.lang.String str2) {
        this.width = i;
        this.height = i2;
        this.instanceId = str;
        this.ref = str2;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(android.graphics.Paint paint, java.lang.CharSequence charSequence, int i, int i2, android.graphics.Paint.FontMetricsInt fontMetricsInt) {
        com.taobao.weex.ui.component.WXComponent wXComponent;
        if (this.mView == null && (wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(this.instanceId, this.ref)) != null && wXComponent.getHostView() != null && this.width > wXComponent.getHostView().getWidth() && wXComponent.getHostView().getWidth() > 0) {
            int width = wXComponent.getHostView().getWidth();
            int i3 = (this.height * width) / this.width;
            this.height = i3;
            this.width = width;
            android.graphics.drawable.Drawable drawable = this.mDrawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, width, i3);
            }
        }
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = -this.height;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = 0;
        }
        return this.width;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(android.graphics.Canvas canvas, java.lang.CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, android.graphics.Paint paint) {
        if (this.mDrawable != null) {
            canvas.save();
            canvas.translate(f, (i5 - this.mDrawable.getBounds().bottom) - paint.getFontMetricsInt().descent);
            this.mDrawable.draw(canvas);
            canvas.restore();
        }
    }

    @Override // com.taobao.weex.adapter.IDrawableLoader.StaticTarget, com.taobao.weex.adapter.IDrawableLoader.DrawableTarget
    public void setDrawable(android.graphics.drawable.Drawable drawable, boolean z) {
        this.mDrawable = drawable;
        if (z) {
            drawable.setBounds(0, 0, this.width, this.height);
        }
        setCallback();
        this.mDrawable.invalidateSelf();
    }

    public void setView(android.view.View view) {
        this.mView = view;
        setCallback();
    }

    private void setCallback() {
        android.view.View view;
        android.graphics.drawable.Drawable drawable = this.mDrawable;
        if (drawable == null || (view = this.mView) == null) {
            return;
        }
        drawable.setCallback(view);
    }
}
