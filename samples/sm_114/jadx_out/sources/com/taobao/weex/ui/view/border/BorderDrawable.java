package com.taobao.weex.ui.view.border;

/* JADX INFO: loaded from: classes.dex */
public class BorderDrawable extends android.graphics.drawable.Drawable {
    public static final int BORDER_BOTTOM_LEFT_RADIUS = 3;
    public static final int BORDER_BOTTOM_RIGHT_RADIUS = 2;
    public static final int BORDER_RADIUS_ALL = 5;
    public static final int BORDER_TOP_LEFT_RADIUS = 0;
    public static final int BORDER_TOP_RIGHT_RADIUS = 1;
    static final int DEFAULT_BORDER_COLOR = -16777216;
    static final float DEFAULT_BORDER_WIDTH = 0.0f;
    private static final java.lang.String TAG = "Border";
    private android.util.SparseIntArray mBorderColor;
    private com.taobao.weex.dom.CSSShorthand<com.taobao.weex.dom.CSSShorthand.CORNER> mBorderRadius;
    private android.util.SparseIntArray mBorderStyle;
    private com.taobao.weex.dom.CSSShorthand<com.taobao.weex.dom.CSSShorthand.EDGE> mBorderWidth;
    private com.taobao.weex.ui.view.border.BottomLeftCorner mBottomLeftCorner;
    private com.taobao.weex.ui.view.border.BottomRightCorner mBottomRightCorner;
    private com.taobao.weex.dom.CSSShorthand<com.taobao.weex.dom.CSSShorthand.CORNER> mOverlappingBorderRadius;
    private android.graphics.Path mPathForBorderOutline;
    private android.graphics.RectF mRectBounds;
    private com.taobao.weex.ui.view.border.TopLeftCorner mTopLeftCorner;
    private com.taobao.weex.ui.view.border.TopRightCorner mTopRightCorner;
    private static final com.taobao.weex.ui.view.border.BorderStyle DEFAULT_BORDER_STYLE = com.taobao.weex.ui.view.border.BorderStyle.SOLID;
    private static com.taobao.weex.ui.view.border.BorderStyle[] sBorderStyle = com.taobao.weex.ui.view.border.BorderStyle.values();
    private final android.graphics.Paint mPaint = new android.graphics.Paint(1);
    private boolean mNeedUpdatePath = false;
    private int mColor = 0;
    private android.graphics.Shader mShader = null;
    private int mAlpha = 255;
    private final com.taobao.weex.ui.view.border.BorderEdge mBorderEdge = new com.taobao.weex.ui.view.border.BorderEdge();
    io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData mBoxShadowData = null;

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        canvas.save();
        updateBorderOutline();
        this.mPaint.setAlpha(255);
        if (this.mPathForBorderOutline != null) {
            int iMultiplyColorAlpha = com.taobao.weex.utils.WXViewUtils.multiplyColorAlpha(this.mColor, this.mAlpha);
            android.graphics.Shader shader = this.mShader;
            if (shader != null) {
                this.mPaint.setShader(shader);
                this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
                canvas.drawPath(this.mPathForBorderOutline, this.mPaint);
                this.mPaint.setShader(null);
            } else if ((iMultiplyColorAlpha >>> 24) != 0) {
                this.mPaint.setColor(iMultiplyColorAlpha);
                this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
                canvas.drawPath(this.mPathForBorderOutline, this.mPaint);
                this.mPaint.setShader(null);
            }
        }
        this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        drawBorders(canvas);
        this.mPaint.setShader(null);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        this.mNeedUpdatePath = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    public void updateBoxShadowData(io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData uniBoxShadowData) {
        this.mBoxShadowData = uniBoxShadowData;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.mShader != null) {
            return -1;
        }
        return com.taobao.weex.utils.WXViewUtils.getOpacityFromColor(com.taobao.weex.utils.WXViewUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(android.graphics.Outline outline) {
        if (this.mPathForBorderOutline == null) {
            this.mNeedUpdatePath = true;
        }
        updateBorderOutline();
        outline.setConvexPath(this.mPathForBorderOutline);
    }

    public void setBorderWidth(com.taobao.weex.dom.CSSShorthand.EDGE edge, float f) {
        if (this.mBorderWidth == null) {
            this.mBorderWidth = new com.taobao.weex.dom.CSSShorthand<>();
        }
        if (this.mBorderWidth.get(edge) != f) {
            this.mBorderWidth.set(edge, f);
            this.mNeedUpdatePath = true;
            invalidateSelf();
        }
    }

    float getBorderWidth(com.taobao.weex.dom.CSSShorthand.EDGE edge) {
        return this.mBorderWidth.get(edge);
    }

    public void setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER corner, float f) {
        if (this.mBorderRadius == null) {
            this.mBorderRadius = new com.taobao.weex.dom.CSSShorthand<>();
        }
        if (this.mBorderRadius.get(corner) == f) {
            if (corner != com.taobao.weex.dom.CSSShorthand.CORNER.ALL) {
                return;
            }
            if (f == this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT) && f == this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT) && f == this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT) && f == this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT)) {
                return;
            }
        }
        this.mBorderRadius.set(corner, f);
        this.mNeedUpdatePath = true;
        invalidateSelf();
    }

    public float[] getBorderRadius(android.graphics.RectF rectF) {
        prepareBorderRadius(rectF);
        if (this.mOverlappingBorderRadius == null) {
            this.mOverlappingBorderRadius = new com.taobao.weex.dom.CSSShorthand<>();
        }
        float f = this.mOverlappingBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT);
        float f2 = this.mOverlappingBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT);
        float f3 = this.mOverlappingBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT);
        float f4 = this.mOverlappingBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT);
        return new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    public float[] getBorderInnerRadius(android.graphics.RectF rectF) {
        prepareBorderRadius(rectF);
        if (this.mOverlappingBorderRadius == null) {
            this.mOverlappingBorderRadius = new com.taobao.weex.dom.CSSShorthand<>();
        }
        float fMax = this.mOverlappingBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT);
        float fMax2 = this.mOverlappingBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT);
        float fMax3 = this.mOverlappingBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT);
        float fMax4 = this.mOverlappingBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT);
        com.taobao.weex.dom.CSSShorthand<com.taobao.weex.dom.CSSShorthand.EDGE> cSSShorthand = this.mBorderWidth;
        if (cSSShorthand != null) {
            fMax = java.lang.Math.max(fMax - cSSShorthand.get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP), 0.0f);
            fMax2 = java.lang.Math.max(fMax2 - this.mBorderWidth.get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP), 0.0f);
            fMax3 = java.lang.Math.max(fMax3 - this.mBorderWidth.get(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM), 0.0f);
            fMax4 = java.lang.Math.max(fMax4 - this.mBorderWidth.get(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM), 0.0f);
        }
        return new float[]{fMax, fMax, fMax2, fMax2, fMax3, fMax3, fMax4, fMax4};
    }

    public void setBorderColor(com.taobao.weex.dom.CSSShorthand.EDGE edge, int i) {
        if (this.mBorderColor == null) {
            android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray(5);
            this.mBorderColor = sparseIntArray;
            sparseIntArray.put(com.taobao.weex.dom.CSSShorthand.EDGE.ALL.ordinal(), -16777216);
        }
        if (getBorderColor(edge) != i) {
            com.taobao.weex.ui.view.border.BorderUtil.updateSparseArray(this.mBorderColor, edge.ordinal(), i);
            invalidateSelf();
        }
    }

    int getBorderColor(com.taobao.weex.dom.CSSShorthand.EDGE edge) {
        return com.taobao.weex.ui.view.border.BorderUtil.fetchFromSparseArray(this.mBorderColor, edge.ordinal(), -16777216);
    }

    public void setBorderStyle(com.taobao.weex.dom.CSSShorthand.EDGE edge, java.lang.String str) {
        if (this.mBorderStyle == null) {
            android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray(5);
            this.mBorderStyle = sparseIntArray;
            sparseIntArray.put(com.taobao.weex.dom.CSSShorthand.EDGE.ALL.ordinal(), DEFAULT_BORDER_STYLE.ordinal());
        }
        try {
            int iOrdinal = com.taobao.weex.ui.view.border.BorderStyle.valueOf(str.toUpperCase(java.util.Locale.US)).ordinal();
            if (getBorderStyle(edge) != iOrdinal) {
                com.taobao.weex.ui.view.border.BorderUtil.updateSparseArray(this.mBorderStyle, edge.ordinal(), iOrdinal);
                invalidateSelf();
            }
        } catch (java.lang.IllegalArgumentException e) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
        }
    }

    int getBorderStyle(com.taobao.weex.dom.CSSShorthand.EDGE edge) {
        return com.taobao.weex.ui.view.border.BorderUtil.fetchFromSparseArray(this.mBorderStyle, edge.ordinal(), com.taobao.weex.ui.view.border.BorderStyle.SOLID.ordinal());
    }

    public int getColor() {
        return this.mColor;
    }

    public void setColor(int i) {
        this.mColor = i;
        invalidateSelf();
    }

    public void setImage(android.graphics.Shader shader) {
        this.mShader = shader;
        invalidateSelf();
    }

    public boolean hasImage() {
        return this.mShader != null;
    }

    public boolean isRounded() {
        com.taobao.weex.dom.CSSShorthand<com.taobao.weex.dom.CSSShorthand.CORNER> cSSShorthand = this.mBorderRadius;
        if (cSSShorthand != null) {
            return (cSSShorthand.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT) == 0.0f && this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT) == 0.0f && this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT) == 0.0f && this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT) == 0.0f) ? false : true;
        }
        return false;
    }

    public android.graphics.Path getContentPath(android.graphics.RectF rectF) {
        android.graphics.Path path = new android.graphics.Path();
        prepareBorderPath(0, 0, 0, 0, rectF, path);
        return path;
    }

    private void updateBorderOutline() {
        if (this.mNeedUpdatePath) {
            this.mNeedUpdatePath = false;
            if (this.mPathForBorderOutline == null) {
                this.mPathForBorderOutline = new android.graphics.Path();
            }
            this.mPathForBorderOutline.reset();
            prepareBorderPath(0, 0, 0, 0, new android.graphics.RectF(getBounds()), this.mPathForBorderOutline);
        }
    }

    private void prepareBorderPath(int i, int i2, int i3, int i4, android.graphics.RectF rectF, android.graphics.Path path) {
        io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData uniBoxShadowData = this.mBoxShadowData;
        if (uniBoxShadowData != null) {
            rectF.inset(this.mBoxShadowData.getNormalLeft() > 0 ? this.mBoxShadowData.getNormalLeft() / 2 : 0, uniBoxShadowData.getNormalTop() > 0 ? this.mBoxShadowData.getNormalTop() / 2 : 0);
        }
        if (this.mBorderRadius != null) {
            prepareBorderRadius(rectF);
            if (this.mOverlappingBorderRadius == null) {
                this.mOverlappingBorderRadius = new com.taobao.weex.dom.CSSShorthand<>();
            }
            float f = this.mOverlappingBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT);
            float f2 = this.mOverlappingBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT);
            float f3 = this.mOverlappingBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT);
            float f4 = this.mOverlappingBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT);
            float f5 = i4;
            float f6 = f - f5;
            float f7 = i;
            float f8 = f - f7;
            float f9 = i2;
            float f10 = f2 - f9;
            float f11 = f2 - f7;
            float f12 = f3 - f9;
            float f13 = i3;
            path.addRoundRect(rectF, new float[]{f6, f8, f10, f11, f12, f3 - f13, f4 - f5, f4 - f13}, android.graphics.Path.Direction.CW);
            return;
        }
        path.addRect(rectF, android.graphics.Path.Direction.CW);
    }

    private void prepareBorderRadius(android.graphics.RectF rectF) {
        if (this.mBorderRadius != null) {
            float scaleFactor = getScaleFactor(rectF);
            if (this.mOverlappingBorderRadius == null) {
                this.mOverlappingBorderRadius = new com.taobao.weex.dom.CSSShorthand<>();
            }
            if (!java.lang.Float.isNaN(scaleFactor) && scaleFactor < 1.0f) {
                this.mOverlappingBorderRadius.set(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT, this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT) * scaleFactor);
                this.mOverlappingBorderRadius.set(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT, this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT) * scaleFactor);
                this.mOverlappingBorderRadius.set(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT, this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT) * scaleFactor);
                this.mOverlappingBorderRadius.set(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT, this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT) * scaleFactor);
                return;
            }
            this.mOverlappingBorderRadius.set(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT, this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT));
            this.mOverlappingBorderRadius.set(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT, this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT));
            this.mOverlappingBorderRadius.set(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT, this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT));
            this.mOverlappingBorderRadius.set(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT, this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT));
        }
    }

    private float getScaleFactor(android.graphics.RectF rectF) {
        float f = this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT) + this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT);
        float f2 = this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT) + this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT);
        float f3 = this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT) + this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT);
        float f4 = this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT) + this.mBorderRadius.get(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT);
        java.util.ArrayList arrayList = new java.util.ArrayList(4);
        updateFactor(arrayList, rectF.width(), f);
        updateFactor(arrayList, rectF.height(), f2);
        updateFactor(arrayList, rectF.width(), f3);
        updateFactor(arrayList, rectF.height(), f4);
        if (arrayList.isEmpty()) {
            return Float.NaN;
        }
        return ((java.lang.Float) java.util.Collections.min(arrayList)).floatValue();
    }

    private void updateFactor(java.util.List<java.lang.Float> list, float f, float f2) {
        if (f2 != 0.0f) {
            list.add(java.lang.Float.valueOf(f / f2));
        }
    }

    private void drawBorders(android.graphics.Canvas canvas) {
        int normalTop;
        android.graphics.RectF rectF = this.mRectBounds;
        if (rectF == null) {
            this.mRectBounds = new android.graphics.RectF(getBounds());
        } else {
            rectF.set(getBounds());
        }
        io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData uniBoxShadowData = this.mBoxShadowData;
        int normalLeft = 0;
        if (uniBoxShadowData != null) {
            normalTop = uniBoxShadowData.getNormalTop() > 0 ? this.mBoxShadowData.getNormalTop() / 2 : 0;
            normalLeft = this.mBoxShadowData.getNormalLeft() > 0 ? this.mBoxShadowData.getNormalLeft() / 2 : 0;
            this.mRectBounds.inset(normalLeft, normalTop);
        } else {
            normalTop = 0;
        }
        com.taobao.weex.dom.CSSShorthand<com.taobao.weex.dom.CSSShorthand.EDGE> cSSShorthand = this.mBorderWidth;
        if (cSSShorthand == null) {
            return;
        }
        float f = cSSShorthand.get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT);
        float f2 = this.mBorderWidth.get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP);
        float f3 = this.mBorderWidth.get(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM);
        float f4 = this.mBorderWidth.get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT);
        if (this.mTopLeftCorner == null) {
            this.mTopLeftCorner = new com.taobao.weex.ui.view.border.TopLeftCorner();
        }
        this.mTopLeftCorner.set(getBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT), f, f2, this.mRectBounds);
        if (this.mTopRightCorner == null) {
            this.mTopRightCorner = new com.taobao.weex.ui.view.border.TopRightCorner();
        }
        this.mTopRightCorner.set(getBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT), f2, f4, this.mRectBounds);
        if (this.mBottomRightCorner == null) {
            this.mBottomRightCorner = new com.taobao.weex.ui.view.border.BottomRightCorner();
        }
        this.mBottomRightCorner.set(getBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT), f4, f3, this.mRectBounds);
        if (this.mBottomLeftCorner == null) {
            this.mBottomLeftCorner = new com.taobao.weex.ui.view.border.BottomLeftCorner();
        }
        this.mBottomLeftCorner.set(getBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT), f3, f, this.mRectBounds);
        if (isDefAllDrawRoundRect(canvas, f, f2, f3, f4)) {
            return;
        }
        canvas.translate(normalLeft, normalTop);
        drawOneSide(canvas, this.mBorderEdge.set(this.mTopLeftCorner, this.mTopRightCorner, f2, com.taobao.weex.dom.CSSShorthand.EDGE.TOP));
        drawOneSide(canvas, this.mBorderEdge.set(this.mTopRightCorner, this.mBottomRightCorner, f4, com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT));
        drawOneSide(canvas, this.mBorderEdge.set(this.mBottomRightCorner, this.mBottomLeftCorner, f3, com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM));
        drawOneSide(canvas, this.mBorderEdge.set(this.mBottomLeftCorner, this.mTopLeftCorner, f, com.taobao.weex.dom.CSSShorthand.EDGE.LEFT));
    }

    private boolean isDefAllDrawRoundRect(android.graphics.Canvas canvas, float f, float f2, float f3, float f4) {
        float outerCornerRadius = this.mTopLeftCorner.getOuterCornerRadius();
        if (outerCornerRadius <= 0.0f || outerCornerRadius != this.mTopRightCorner.getOuterCornerRadius() || outerCornerRadius != this.mBottomLeftCorner.getOuterCornerRadius() || outerCornerRadius != this.mBottomRightCorner.getOuterCornerRadius() || f <= 0.0f || f != f2 || f != f3 || f != f4) {
            return false;
        }
        int iMultiplyColorAlpha = com.taobao.weex.utils.WXViewUtils.multiplyColorAlpha(getBorderColor(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT), this.mAlpha);
        int iMultiplyColorAlpha2 = com.taobao.weex.utils.WXViewUtils.multiplyColorAlpha(getBorderColor(com.taobao.weex.dom.CSSShorthand.EDGE.TOP), this.mAlpha);
        int iMultiplyColorAlpha3 = com.taobao.weex.utils.WXViewUtils.multiplyColorAlpha(getBorderColor(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM), this.mAlpha);
        int iMultiplyColorAlpha4 = com.taobao.weex.utils.WXViewUtils.multiplyColorAlpha(getBorderColor(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT), this.mAlpha);
        if (iMultiplyColorAlpha != iMultiplyColorAlpha2 || iMultiplyColorAlpha != iMultiplyColorAlpha3 || iMultiplyColorAlpha != iMultiplyColorAlpha4) {
            return false;
        }
        preparePaint(this.mBorderEdge.set(this.mTopLeftCorner, this.mTopRightCorner, f2, com.taobao.weex.dom.CSSShorthand.EDGE.TOP).getEdge());
        this.mPaint.setStrokeWidth(f);
        android.graphics.RectF rectF = new android.graphics.RectF();
        float f5 = f / 2.0f;
        rectF.top = this.mRectBounds.top + f5;
        rectF.bottom = this.mRectBounds.bottom - f5;
        rectF.left = this.mRectBounds.left + f5;
        rectF.right = this.mRectBounds.right - f5;
        canvas.drawRoundRect(rectF, outerCornerRadius, outerCornerRadius, this.mPaint);
        return true;
    }

    private float getBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER corner) {
        com.taobao.weex.dom.CSSShorthand<com.taobao.weex.dom.CSSShorthand.CORNER> cSSShorthand = this.mOverlappingBorderRadius;
        if (cSSShorthand != null) {
            return cSSShorthand.get(corner);
        }
        return 0.0f;
    }

    private void drawOneSide(android.graphics.Canvas canvas, com.taobao.weex.ui.view.border.BorderEdge borderEdge) {
        if (0.0f != borderEdge.getBorderWidth()) {
            preparePaint(borderEdge.getEdge());
            borderEdge.drawEdge(canvas, this.mPaint);
        }
    }

    private void preparePaint(com.taobao.weex.dom.CSSShorthand.EDGE edge) {
        float f = this.mBorderWidth.get(edge);
        int iMultiplyColorAlpha = com.taobao.weex.utils.WXViewUtils.multiplyColorAlpha(getBorderColor(edge), this.mAlpha);
        this.mPaint.setShader(sBorderStyle[getBorderStyle(edge)].getLineShader(f, iMultiplyColorAlpha, edge));
        this.mPaint.setColor(iMultiplyColorAlpha);
        this.mPaint.setStrokeCap(android.graphics.Paint.Cap.BUTT);
    }
}
