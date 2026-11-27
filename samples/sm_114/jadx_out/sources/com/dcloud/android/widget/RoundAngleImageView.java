package com.dcloud.android.widget;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class RoundAngleImageView extends android.widget.ImageView {
    android.graphics.Path path;

    public RoundAngleImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.path = new android.graphics.Path();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        canvas.save();
        this.path.addRoundRect(new android.graphics.RectF(0.0f, 0.0f, getWidth(), getHeight()), io.dcloud.common.adapter.util.CanvasHelper.dip2px(getContext(), 8.0f), io.dcloud.common.adapter.util.CanvasHelper.dip2px(getContext(), 8.0f), android.graphics.Path.Direction.CCW);
        canvas.clipPath(this.path);
        if (getDrawable() == null) {
            canvas.drawColor(-3355444);
        }
        super.onDraw(canvas);
        canvas.restore();
    }
}
