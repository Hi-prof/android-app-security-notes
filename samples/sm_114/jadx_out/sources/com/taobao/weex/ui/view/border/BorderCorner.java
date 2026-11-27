package com.taobao.weex.ui.view.border;

/* JADX INFO: loaded from: classes.dex */
abstract class BorderCorner {
    static final float SWEEP_ANGLE = 45.0f;
    protected float mAngleBisector;
    private android.graphics.RectF mBorderBox;
    private float mOvalBottom;
    private float mOvalLeft;
    private float mOvalRight;
    private float mOvalTop;
    private float mRoundCornerEndX;
    private float mRoundCornerEndY;
    private float mRoundCornerStartX;
    private float mRoundCornerStartY;
    private float mCornerRadius = 0.0f;
    private float mPreBorderWidth = 0.0f;
    private float mPostBorderWidth = 0.0f;
    private boolean hasInnerCorner = false;
    private boolean hasOuterCorner = false;

    protected abstract void prepareOval();

    protected abstract void prepareRoundCorner();

    BorderCorner() {
    }

    final void set(float f, float f2, float f3, android.graphics.RectF rectF, float f4) {
        android.graphics.RectF rectF2;
        if (com.taobao.weex.base.FloatUtil.floatsEqual(this.mCornerRadius, f) && com.taobao.weex.base.FloatUtil.floatsEqual(this.mPreBorderWidth, f2) && com.taobao.weex.base.FloatUtil.floatsEqual(this.mPostBorderWidth, f3) && com.taobao.weex.base.FloatUtil.floatsEqual(this.mAngleBisector, f4) && ((rectF2 = this.mBorderBox) == null || !rectF2.equals(rectF))) {
            return;
        }
        this.mCornerRadius = f;
        this.mPreBorderWidth = f2;
        this.mPostBorderWidth = f3;
        this.mBorderBox = rectF;
        this.mAngleBisector = f4;
        boolean z = f > 0.0f && !com.taobao.weex.base.FloatUtil.floatsEqual(0.0f, f);
        this.hasOuterCorner = z;
        this.hasInnerCorner = z && getPreBorderWidth() >= 0.0f && getPostBorderWidth() >= 0.0f && getOuterCornerRadius() > getPreBorderWidth() && getOuterCornerRadius() > getPostBorderWidth();
        if (this.hasOuterCorner) {
            prepareOval();
        }
        prepareRoundCorner();
    }

    public final void drawRoundedCorner(android.graphics.Canvas canvas, android.graphics.Paint paint, float f) {
        if (!hasOuterCorner()) {
            if (getRoundCornerStartX() == getRoundCornerEndX() && getRoundCornerStartY() == getRoundCornerEndY()) {
                return;
            }
            canvas.drawLine(getRoundCornerStartX(), getRoundCornerStartY(), getRoundCornerEndX(), getRoundCornerEndY(), paint);
            return;
        }
        android.graphics.Paint paint2 = new android.graphics.Paint(paint);
        float fAbs = java.lang.Math.abs(this.mOvalLeft - this.mOvalRight);
        if (paint.getStrokeWidth() > fAbs) {
            paint2.setStrokeWidth(fAbs);
        }
        paint2.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        canvas.drawArc(this.mOvalLeft, this.mOvalTop, this.mOvalRight, this.mOvalBottom, f, SWEEP_ANGLE, false, paint2);
    }

    public final float getRoundCornerStartX() {
        return this.mRoundCornerStartX;
    }

    final void setRoundCornerStartX(float f) {
        this.mRoundCornerStartX = f;
    }

    public final float getRoundCornerStartY() {
        return this.mRoundCornerStartY;
    }

    final void setRoundCornerStartY(float f) {
        this.mRoundCornerStartY = f;
    }

    public final float getRoundCornerEndX() {
        return this.mRoundCornerEndX;
    }

    final void setRoundCornerEndX(float f) {
        this.mRoundCornerEndX = f;
    }

    public final float getRoundCornerEndY() {
        return this.mRoundCornerEndY;
    }

    final void setRoundCornerEndY(float f) {
        this.mRoundCornerEndY = f;
    }

    final void setOvalLeft(float f) {
        this.mOvalLeft = f;
    }

    final void setOvalTop(float f) {
        this.mOvalTop = f;
    }

    final void setOvalRight(float f) {
        this.mOvalRight = f;
    }

    final void setOvalBottom(float f) {
        this.mOvalBottom = f;
    }

    boolean hasInnerCorner() {
        return this.hasInnerCorner;
    }

    boolean hasOuterCorner() {
        return this.hasOuterCorner;
    }

    protected final float getPreBorderWidth() {
        return this.mPreBorderWidth;
    }

    protected final float getPostBorderWidth() {
        return this.mPostBorderWidth;
    }

    protected final float getOuterCornerRadius() {
        return this.mCornerRadius;
    }

    protected final float getAngleBisectorDegree() {
        return this.mAngleBisector;
    }

    protected final android.graphics.RectF getBorderBox() {
        return this.mBorderBox;
    }
}
