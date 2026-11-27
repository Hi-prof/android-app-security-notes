package com.taobao.weex.ui.view.border;

/* JADX INFO: loaded from: classes.dex */
class BorderEdge {
    private float mBorderWidth;
    private com.taobao.weex.dom.CSSShorthand.EDGE mEdge;
    private com.taobao.weex.ui.view.border.BorderCorner mPostCorner;
    private com.taobao.weex.ui.view.border.BorderCorner mPreCorner;

    BorderEdge() {
    }

    com.taobao.weex.ui.view.border.BorderEdge set(com.taobao.weex.ui.view.border.BorderCorner borderCorner, com.taobao.weex.ui.view.border.BorderCorner borderCorner2, float f, com.taobao.weex.dom.CSSShorthand.EDGE edge) {
        this.mPreCorner = borderCorner;
        this.mPostCorner = borderCorner2;
        this.mBorderWidth = f;
        this.mEdge = edge;
        return this;
    }

    void drawEdge(android.graphics.Canvas canvas, android.graphics.Paint paint) {
        paint.setStrokeWidth(this.mBorderWidth);
        com.taobao.weex.ui.view.border.BorderCorner borderCorner = this.mPreCorner;
        borderCorner.drawRoundedCorner(canvas, paint, borderCorner.getAngleBisectorDegree());
        paint.setStrokeWidth(this.mBorderWidth);
        canvas.drawLine(this.mPreCorner.getRoundCornerEndX(), this.mPreCorner.getRoundCornerEndY(), this.mPostCorner.getRoundCornerStartX(), this.mPostCorner.getRoundCornerStartY(), paint);
        com.taobao.weex.ui.view.border.BorderCorner borderCorner2 = this.mPostCorner;
        borderCorner2.drawRoundedCorner(canvas, paint, borderCorner2.getAngleBisectorDegree() - 45.0f);
    }

    public com.taobao.weex.dom.CSSShorthand.EDGE getEdge() {
        return this.mEdge;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }
}
