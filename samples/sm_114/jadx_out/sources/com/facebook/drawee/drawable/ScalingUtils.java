package com.facebook.drawee.drawable;

/* JADX INFO: loaded from: classes.dex */
public class ScalingUtils {

    public interface ScaleType {
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType FIT_XY = com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFitXY.INSTANCE;
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType FIT_X = com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFitX.INSTANCE;
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType FIT_Y = com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFitY.INSTANCE;
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType FIT_START = com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFitStart.INSTANCE;
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType FIT_CENTER = com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFitCenter.INSTANCE;
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType FIT_END = com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFitEnd.INSTANCE;
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType CENTER = com.facebook.drawee.drawable.ScalingUtils.ScaleTypeCenter.INSTANCE;
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType CENTER_INSIDE = com.facebook.drawee.drawable.ScalingUtils.ScaleTypeCenterInside.INSTANCE;
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType CENTER_CROP = com.facebook.drawee.drawable.ScalingUtils.ScaleTypeCenterCrop.INSTANCE;
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType FOCUS_CROP = com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFocusCrop.INSTANCE;
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType FIT_BOTTOM_START = com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFitBottomStart.INSTANCE;

        android.graphics.Matrix getTransform(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2);
    }

    public interface StatefulScaleType {
        java.lang.Object getState();
    }

    /* JADX INFO: renamed from: com.facebook.drawee.drawable.ScalingUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[android.widget.ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[android.widget.ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
        }
    }

    @javax.annotation.Nullable
    public static com.facebook.drawee.drawable.ScalingUtils.ScaleType convertFromImageViewScaleType(android.widget.ImageView.ScaleType scaleType) {
        switch (com.facebook.drawee.drawable.ScalingUtils.AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[scaleType.ordinal()]) {
            case 1:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER;
            case 2:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_CROP;
            case 3:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_INSIDE;
            case 4:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_CENTER;
            case 5:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_START;
            case 6:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_END;
            case 7:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_XY;
            default:
                return null;
        }
    }

    public static abstract class AbstractScaleType implements com.facebook.drawee.drawable.ScalingUtils.ScaleType {
        public abstract void getTransformImpl(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2, float f3, float f4);

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public android.graphics.Matrix getTransform(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2) {
            getTransformImpl(matrix, rect, i, i2, f, f2, rect.width() / i, rect.height() / i2);
            return matrix;
        }
    }

    private static class ScaleTypeFitXY extends com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType {
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType INSTANCE = new com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFitXY();

        private ScaleTypeFitXY() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float f5 = rect.left;
            float f6 = rect.top;
            matrix.setScale(f3, f4);
            matrix.postTranslate((int) (f5 + 0.5f), (int) (f6 + 0.5f));
        }

        public java.lang.String toString() {
            return "fit_xy";
        }
    }

    private static class ScaleTypeFitStart extends com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType {
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType INSTANCE = new com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFitStart();

        private ScaleTypeFitStart() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float fMin = java.lang.Math.min(f3, f4);
            float f5 = rect.left;
            float f6 = rect.top;
            matrix.setScale(fMin, fMin);
            matrix.postTranslate((int) (f5 + 0.5f), (int) (f6 + 0.5f));
        }

        public java.lang.String toString() {
            return "fit_start";
        }
    }

    private static class ScaleTypeFitBottomStart extends com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType {
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType INSTANCE = new com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFitBottomStart();

        private ScaleTypeFitBottomStart() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float fMin = java.lang.Math.min(f3, f4);
            float f5 = rect.left;
            float fHeight = rect.top + (rect.height() - (i2 * fMin));
            matrix.setScale(fMin, fMin);
            matrix.postTranslate((int) (f5 + 0.5f), (int) (fHeight + 0.5f));
        }

        public java.lang.String toString() {
            return "fit_bottom_start";
        }
    }

    private static class ScaleTypeFitCenter extends com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType {
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType INSTANCE = new com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFitCenter();

        private ScaleTypeFitCenter() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float fMin = java.lang.Math.min(f3, f4);
            float fWidth = rect.left + ((rect.width() - (i * fMin)) * 0.5f);
            float fHeight = rect.top + ((rect.height() - (i2 * fMin)) * 0.5f);
            matrix.setScale(fMin, fMin);
            matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
        }

        public java.lang.String toString() {
            return "fit_center";
        }
    }

    private static class ScaleTypeFitEnd extends com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType {
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType INSTANCE = new com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFitEnd();

        private ScaleTypeFitEnd() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float fMin = java.lang.Math.min(f3, f4);
            float fWidth = rect.left + (rect.width() - (i * fMin));
            float fHeight = rect.top + (rect.height() - (i2 * fMin));
            matrix.setScale(fMin, fMin);
            matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
        }

        public java.lang.String toString() {
            return "fit_end";
        }
    }

    private static class ScaleTypeCenter extends com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType {
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType INSTANCE = new com.facebook.drawee.drawable.ScalingUtils.ScaleTypeCenter();

        private ScaleTypeCenter() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            matrix.setTranslate((int) (rect.left + ((rect.width() - i) * 0.5f) + 0.5f), (int) (rect.top + ((rect.height() - i2) * 0.5f) + 0.5f));
        }

        public java.lang.String toString() {
            return "center";
        }
    }

    private static class ScaleTypeCenterInside extends com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType {
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType INSTANCE = new com.facebook.drawee.drawable.ScalingUtils.ScaleTypeCenterInside();

        private ScaleTypeCenterInside() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float fMin = java.lang.Math.min(java.lang.Math.min(f3, f4), 1.0f);
            float fWidth = rect.left + ((rect.width() - (i * fMin)) * 0.5f);
            float fHeight = rect.top + ((rect.height() - (i2 * fMin)) * 0.5f);
            matrix.setScale(fMin, fMin);
            matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
        }

        public java.lang.String toString() {
            return "center_inside";
        }
    }

    private static class ScaleTypeCenterCrop extends com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType {
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType INSTANCE = new com.facebook.drawee.drawable.ScalingUtils.ScaleTypeCenterCrop();

        private ScaleTypeCenterCrop() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float fHeight;
            float fWidth;
            if (f4 > f3) {
                fWidth = rect.left + ((rect.width() - (i * f4)) * 0.5f);
                fHeight = rect.top;
                f3 = f4;
            } else {
                float f5 = rect.left;
                fHeight = ((rect.height() - (i2 * f3)) * 0.5f) + rect.top;
                fWidth = f5;
            }
            matrix.setScale(f3, f3);
            matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
        }

        public java.lang.String toString() {
            return "center_crop";
        }
    }

    private static class ScaleTypeFocusCrop extends com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType {
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType INSTANCE = new com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFocusCrop();

        private ScaleTypeFocusCrop() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float fMax;
            float fMax2;
            if (f4 > f3) {
                float f5 = i * f4;
                fMax = rect.left + java.lang.Math.max(java.lang.Math.min((rect.width() * 0.5f) - (f * f5), 0.0f), rect.width() - f5);
                fMax2 = rect.top;
                f3 = f4;
            } else {
                fMax = rect.left;
                float f6 = i2 * f3;
                fMax2 = java.lang.Math.max(java.lang.Math.min((rect.height() * 0.5f) - (f2 * f6), 0.0f), rect.height() - f6) + rect.top;
            }
            matrix.setScale(f3, f3);
            matrix.postTranslate((int) (fMax + 0.5f), (int) (fMax2 + 0.5f));
        }

        public java.lang.String toString() {
            return "focus_crop";
        }
    }

    private static class ScaleTypeFitX extends com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType {
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType INSTANCE = new com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFitX();

        private ScaleTypeFitX() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float f5 = rect.left;
            float fHeight = rect.top + ((rect.height() - (i2 * f3)) * 0.5f);
            matrix.setScale(f3, f3);
            matrix.postTranslate((int) (f5 + 0.5f), (int) (fHeight + 0.5f));
        }

        public java.lang.String toString() {
            return "fit_x";
        }
    }

    private static class ScaleTypeFitY extends com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType {
        public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType INSTANCE = new com.facebook.drawee.drawable.ScalingUtils.ScaleTypeFitY();

        private ScaleTypeFitY() {
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float fWidth = rect.left + ((rect.width() - (i * f4)) * 0.5f);
            float f5 = rect.top;
            matrix.setScale(f4, f4);
            matrix.postTranslate((int) (fWidth + 0.5f), (int) (f5 + 0.5f));
        }

        public java.lang.String toString() {
            return "fit_y";
        }
    }

    public static class InterpolatingScaleType implements com.facebook.drawee.drawable.ScalingUtils.ScaleType, com.facebook.drawee.drawable.ScalingUtils.StatefulScaleType {

        @javax.annotation.Nullable
        private final android.graphics.Rect mBoundsFrom;

        @javax.annotation.Nullable
        private final android.graphics.Rect mBoundsTo;

        @javax.annotation.Nullable
        private final android.graphics.PointF mFocusPointFrom;

        @javax.annotation.Nullable
        private final android.graphics.PointF mFocusPointTo;
        private float mInterpolatingValue;
        private final float[] mMatrixValuesFrom;
        private final float[] mMatrixValuesInterpolated;
        private final float[] mMatrixValuesTo;
        private final com.facebook.drawee.drawable.ScalingUtils.ScaleType mScaleTypeFrom;
        private final com.facebook.drawee.drawable.ScalingUtils.ScaleType mScaleTypeTo;

        public InterpolatingScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType2, @javax.annotation.Nullable android.graphics.Rect rect, @javax.annotation.Nullable android.graphics.Rect rect2, @javax.annotation.Nullable android.graphics.PointF pointF, @javax.annotation.Nullable android.graphics.PointF pointF2) {
            this.mMatrixValuesFrom = new float[9];
            this.mMatrixValuesTo = new float[9];
            this.mMatrixValuesInterpolated = new float[9];
            this.mScaleTypeFrom = scaleType;
            this.mScaleTypeTo = scaleType2;
            this.mBoundsFrom = rect;
            this.mBoundsTo = rect2;
            this.mFocusPointFrom = pointF;
            this.mFocusPointTo = pointF2;
        }

        public InterpolatingScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType2, @javax.annotation.Nullable android.graphics.Rect rect, @javax.annotation.Nullable android.graphics.Rect rect2) {
            this(scaleType, scaleType2, rect, rect2, null, null);
        }

        public InterpolatingScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType2) {
            this(scaleType, scaleType2, null, null);
        }

        public com.facebook.drawee.drawable.ScalingUtils.ScaleType getScaleTypeFrom() {
            return this.mScaleTypeFrom;
        }

        public com.facebook.drawee.drawable.ScalingUtils.ScaleType getScaleTypeTo() {
            return this.mScaleTypeTo;
        }

        @javax.annotation.Nullable
        public android.graphics.Rect getBoundsFrom() {
            return this.mBoundsFrom;
        }

        @javax.annotation.Nullable
        public android.graphics.Rect getBoundsTo() {
            return this.mBoundsTo;
        }

        @javax.annotation.Nullable
        public android.graphics.PointF getFocusPointFrom() {
            return this.mFocusPointFrom;
        }

        @javax.annotation.Nullable
        public android.graphics.PointF getFocusPointTo() {
            return this.mFocusPointTo;
        }

        public void setValue(float f) {
            this.mInterpolatingValue = f;
        }

        public float getValue() {
            return this.mInterpolatingValue;
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.StatefulScaleType
        public java.lang.Object getState() {
            return java.lang.Float.valueOf(this.mInterpolatingValue);
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public android.graphics.Matrix getTransform(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2) {
            android.graphics.Rect rect2 = this.mBoundsFrom;
            android.graphics.Rect rect3 = rect2 != null ? rect2 : rect;
            android.graphics.Rect rect4 = this.mBoundsTo;
            android.graphics.Rect rect5 = rect4 != null ? rect4 : rect;
            com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType = this.mScaleTypeFrom;
            android.graphics.PointF pointF = this.mFocusPointFrom;
            float f3 = pointF == null ? f : pointF.x;
            android.graphics.PointF pointF2 = this.mFocusPointFrom;
            scaleType.getTransform(matrix, rect3, i, i2, f3, pointF2 == null ? f2 : pointF2.y);
            matrix.getValues(this.mMatrixValuesFrom);
            com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType2 = this.mScaleTypeTo;
            android.graphics.PointF pointF3 = this.mFocusPointTo;
            float f4 = pointF3 == null ? f : pointF3.x;
            android.graphics.PointF pointF4 = this.mFocusPointTo;
            scaleType2.getTransform(matrix, rect5, i, i2, f4, pointF4 == null ? f2 : pointF4.y);
            matrix.getValues(this.mMatrixValuesTo);
            for (int i3 = 0; i3 < 9; i3++) {
                float[] fArr = this.mMatrixValuesInterpolated;
                float f5 = this.mMatrixValuesFrom[i3];
                float f6 = this.mInterpolatingValue;
                fArr[i3] = (f5 * (1.0f - f6)) + (this.mMatrixValuesTo[i3] * f6);
            }
            matrix.setValues(this.mMatrixValuesInterpolated);
            return matrix;
        }

        public java.lang.String toString() {
            return java.lang.String.format("InterpolatingScaleType(%s (%s) -> %s (%s))", java.lang.String.valueOf(this.mScaleTypeFrom), java.lang.String.valueOf(this.mFocusPointFrom), java.lang.String.valueOf(this.mScaleTypeTo), java.lang.String.valueOf(this.mFocusPointTo));
        }
    }
}
