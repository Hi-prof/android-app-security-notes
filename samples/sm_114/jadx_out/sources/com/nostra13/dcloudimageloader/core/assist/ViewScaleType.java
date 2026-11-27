package com.nostra13.dcloudimageloader.core.assist;

/* JADX INFO: loaded from: classes.dex */
public enum ViewScaleType {
    FIT_INSIDE,
    CROP;

    /* JADX INFO: renamed from: com.nostra13.dcloudimageloader.core.assist.ViewScaleType$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[android.widget.ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_XY.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.MATRIX.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.CENTER_CROP.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
        }
    }

    public static com.nostra13.dcloudimageloader.core.assist.ViewScaleType fromImageView(android.widget.ImageView imageView) {
        int i = com.nostra13.dcloudimageloader.core.assist.ViewScaleType.AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
            return FIT_INSIDE;
        }
        return CROP;
    }
}
