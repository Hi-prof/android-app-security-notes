package com.facebook.drawee.generic;

/* JADX INFO: loaded from: classes.dex */
public class RoundingParams {
    private com.facebook.drawee.generic.RoundingParams.RoundingMethod mRoundingMethod = com.facebook.drawee.generic.RoundingParams.RoundingMethod.BITMAP_ONLY;
    private boolean mRoundAsCircle = false;

    @javax.annotation.Nullable
    private float[] mCornersRadii = null;
    private int mOverlayColor = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean mScaleDownInsideBorders = false;
    private boolean mPaintFilterBitmap = false;
    private boolean mRepeatEdgePixels = false;

    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public com.facebook.drawee.generic.RoundingParams setRoundAsCircle(boolean z) {
        this.mRoundAsCircle = z;
        return this;
    }

    public boolean getRoundAsCircle() {
        return this.mRoundAsCircle;
    }

    public com.facebook.drawee.generic.RoundingParams setRepeatEdgePixels(boolean z) {
        this.mRepeatEdgePixels = z;
        return this;
    }

    public boolean getRepeatEdgePixels() {
        return this.mRepeatEdgePixels;
    }

    public com.facebook.drawee.generic.RoundingParams setCornersRadius(float f) {
        java.util.Arrays.fill(getOrCreateRoundedCornersRadii(), f);
        return this;
    }

    public com.facebook.drawee.generic.RoundingParams setCornersRadii(float f, float f2, float f3, float f4) {
        float[] orCreateRoundedCornersRadii = getOrCreateRoundedCornersRadii();
        orCreateRoundedCornersRadii[1] = f;
        orCreateRoundedCornersRadii[0] = f;
        orCreateRoundedCornersRadii[3] = f2;
        orCreateRoundedCornersRadii[2] = f2;
        orCreateRoundedCornersRadii[5] = f3;
        orCreateRoundedCornersRadii[4] = f3;
        orCreateRoundedCornersRadii[7] = f4;
        orCreateRoundedCornersRadii[6] = f4;
        return this;
    }

    public com.facebook.drawee.generic.RoundingParams setCornersRadii(float[] fArr) {
        com.facebook.common.internal.Preconditions.checkNotNull(fArr);
        com.facebook.common.internal.Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
        java.lang.System.arraycopy(fArr, 0, getOrCreateRoundedCornersRadii(), 0, 8);
        return this;
    }

    @javax.annotation.Nullable
    public float[] getCornersRadii() {
        return this.mCornersRadii;
    }

    public com.facebook.drawee.generic.RoundingParams setRoundingMethod(com.facebook.drawee.generic.RoundingParams.RoundingMethod roundingMethod) {
        this.mRoundingMethod = roundingMethod;
        return this;
    }

    public com.facebook.drawee.generic.RoundingParams.RoundingMethod getRoundingMethod() {
        return this.mRoundingMethod;
    }

    public com.facebook.drawee.generic.RoundingParams setOverlayColor(int i) {
        this.mOverlayColor = i;
        this.mRoundingMethod = com.facebook.drawee.generic.RoundingParams.RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int getOverlayColor() {
        return this.mOverlayColor;
    }

    private float[] getOrCreateRoundedCornersRadii() {
        if (this.mCornersRadii == null) {
            this.mCornersRadii = new float[8];
        }
        return this.mCornersRadii;
    }

    public static com.facebook.drawee.generic.RoundingParams asCircle() {
        return new com.facebook.drawee.generic.RoundingParams().setRoundAsCircle(true);
    }

    public static com.facebook.drawee.generic.RoundingParams fromCornersRadius(float f) {
        return new com.facebook.drawee.generic.RoundingParams().setCornersRadius(f);
    }

    public static com.facebook.drawee.generic.RoundingParams fromCornersRadii(float f, float f2, float f3, float f4) {
        return new com.facebook.drawee.generic.RoundingParams().setCornersRadii(f, f2, f3, f4);
    }

    public static com.facebook.drawee.generic.RoundingParams fromCornersRadii(float[] fArr) {
        return new com.facebook.drawee.generic.RoundingParams().setCornersRadii(fArr);
    }

    public com.facebook.drawee.generic.RoundingParams setBorderWidth(float f) {
        com.facebook.common.internal.Preconditions.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public com.facebook.drawee.generic.RoundingParams setBorderColor(int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public com.facebook.drawee.generic.RoundingParams setBorder(int i, float f) {
        com.facebook.common.internal.Preconditions.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        this.mBorderColor = i;
        return this;
    }

    public com.facebook.drawee.generic.RoundingParams setPadding(float f) {
        com.facebook.common.internal.Preconditions.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public com.facebook.drawee.generic.RoundingParams setScaleDownInsideBorders(boolean z) {
        this.mScaleDownInsideBorders = z;
        return this;
    }

    public boolean getScaleDownInsideBorders() {
        return this.mScaleDownInsideBorders;
    }

    public com.facebook.drawee.generic.RoundingParams setPaintFilterBitmap(boolean z) {
        this.mPaintFilterBitmap = z;
        return this;
    }

    public boolean getPaintFilterBitmap() {
        return this.mPaintFilterBitmap;
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.facebook.drawee.generic.RoundingParams roundingParams = (com.facebook.drawee.generic.RoundingParams) obj;
        if (this.mRoundAsCircle == roundingParams.mRoundAsCircle && this.mOverlayColor == roundingParams.mOverlayColor && java.lang.Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && java.lang.Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.mRoundingMethod == roundingParams.mRoundingMethod && this.mScaleDownInsideBorders == roundingParams.mScaleDownInsideBorders && this.mPaintFilterBitmap == roundingParams.mPaintFilterBitmap) {
            return java.util.Arrays.equals(this.mCornersRadii, roundingParams.mCornersRadii);
        }
        return false;
    }

    public int hashCode() {
        com.facebook.drawee.generic.RoundingParams.RoundingMethod roundingMethod = this.mRoundingMethod;
        int iHashCode = (((roundingMethod != null ? roundingMethod.hashCode() : 0) * 31) + (this.mRoundAsCircle ? 1 : 0)) * 31;
        float[] fArr = this.mCornersRadii;
        int iHashCode2 = (((iHashCode + (fArr != null ? java.util.Arrays.hashCode(fArr) : 0)) * 31) + this.mOverlayColor) * 31;
        float f = this.mBorderWidth;
        int iFloatToIntBits = (((iHashCode2 + (f != 0.0f ? java.lang.Float.floatToIntBits(f) : 0)) * 31) + this.mBorderColor) * 31;
        float f2 = this.mPadding;
        return ((((iFloatToIntBits + (f2 != 0.0f ? java.lang.Float.floatToIntBits(f2) : 0)) * 31) + (this.mScaleDownInsideBorders ? 1 : 0)) * 31) + (this.mPaintFilterBitmap ? 1 : 0);
    }
}
