package io.dcloud.feature.weex.adapter.Fresco;

/* JADX INFO: loaded from: classes2.dex */
public class DCWrappingUtils {
    private static final java.lang.String TAG = "WrappingUtils";
    private static final android.graphics.drawable.Drawable sEmptyDrawable = new android.graphics.drawable.ColorDrawable(0);

    static android.graphics.drawable.Drawable maybeWrapWithScaleType(android.graphics.drawable.Drawable drawable, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        return maybeWrapWithScaleType(drawable, scaleType, null);
    }

    static android.graphics.drawable.Drawable maybeWrapWithScaleType(android.graphics.drawable.Drawable drawable, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType, android.graphics.PointF pointF) {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("WrappingUtils#maybeWrapWithScaleType");
        }
        if (drawable == null || scaleType == null) {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
            return drawable;
        }
        com.facebook.drawee.drawable.ScaleTypeDrawable scaleTypeDrawable = new com.facebook.drawee.drawable.ScaleTypeDrawable(drawable, scaleType);
        if (pointF != null) {
            scaleTypeDrawable.setFocusPoint(pointF);
        }
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
        return scaleTypeDrawable;
    }

    static android.graphics.drawable.Drawable maybeWrapWithMatrix(android.graphics.drawable.Drawable drawable, android.graphics.Matrix matrix) {
        return (drawable == null || matrix == null) ? drawable : new com.facebook.drawee.drawable.MatrixDrawable(drawable, matrix);
    }

    static com.facebook.drawee.drawable.ScaleTypeDrawable wrapChildWithScaleType(com.facebook.drawee.drawable.DrawableParent drawableParent, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        android.graphics.drawable.Drawable drawableMaybeWrapWithScaleType = maybeWrapWithScaleType(drawableParent.setDrawable(sEmptyDrawable), scaleType);
        drawableParent.setDrawable(drawableMaybeWrapWithScaleType);
        com.facebook.common.internal.Preconditions.checkNotNull(drawableMaybeWrapWithScaleType, "Parent has no child drawable!");
        return (com.facebook.drawee.drawable.ScaleTypeDrawable) drawableMaybeWrapWithScaleType;
    }

    static void updateOverlayColorRounding(com.facebook.drawee.drawable.DrawableParent drawableParent, com.facebook.drawee.generic.RoundingParams roundingParams) {
        android.graphics.drawable.Drawable drawable = drawableParent.getDrawable();
        if (roundingParams != null && roundingParams.getRoundingMethod() == com.facebook.drawee.generic.RoundingParams.RoundingMethod.OVERLAY_COLOR) {
            if (drawable instanceof com.facebook.drawee.drawable.RoundedCornersDrawable) {
                com.facebook.drawee.drawable.RoundedCornersDrawable roundedCornersDrawable = (com.facebook.drawee.drawable.RoundedCornersDrawable) drawable;
                applyRoundingParams(roundedCornersDrawable, roundingParams);
                roundedCornersDrawable.setOverlayColor(roundingParams.getOverlayColor());
                return;
            }
            drawableParent.setDrawable(maybeWrapWithRoundedOverlayColor(drawableParent.setDrawable(sEmptyDrawable), roundingParams));
            return;
        }
        if (drawable instanceof com.facebook.drawee.drawable.RoundedCornersDrawable) {
            android.graphics.drawable.Drawable drawable2 = sEmptyDrawable;
            drawableParent.setDrawable(((com.facebook.drawee.drawable.RoundedCornersDrawable) drawable).setCurrent(drawable2));
            drawable2.setCallback(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void updateLeafRounding(com.facebook.drawee.drawable.DrawableParent drawableParent, com.facebook.drawee.generic.RoundingParams roundingParams, android.content.res.Resources resources) {
        com.facebook.drawee.drawable.DrawableParent drawableParentFindDrawableParentForLeaf = findDrawableParentForLeaf(drawableParent);
        android.graphics.drawable.Drawable drawable = drawableParentFindDrawableParentForLeaf.getDrawable();
        if (roundingParams != null && roundingParams.getRoundingMethod() == com.facebook.drawee.generic.RoundingParams.RoundingMethod.BITMAP_ONLY) {
            if (drawable instanceof com.facebook.drawee.drawable.Rounded) {
                applyRoundingParams((com.facebook.drawee.drawable.Rounded) drawable, roundingParams);
                return;
            } else {
                if (drawable != 0) {
                    drawableParentFindDrawableParentForLeaf.setDrawable(sEmptyDrawable);
                    drawableParentFindDrawableParentForLeaf.setDrawable(applyLeafRounding(drawable, roundingParams, resources));
                    return;
                }
                return;
            }
        }
        if (drawable instanceof com.facebook.drawee.drawable.Rounded) {
            resetRoundingParams((com.facebook.drawee.drawable.Rounded) drawable);
        }
    }

    static android.graphics.drawable.Drawable maybeWrapWithRoundedOverlayColor(android.graphics.drawable.Drawable drawable, com.facebook.drawee.generic.RoundingParams roundingParams) {
        try {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("WrappingUtils#maybeWrapWithRoundedOverlayColor");
            }
            if (drawable != null && roundingParams != null && roundingParams.getRoundingMethod() == com.facebook.drawee.generic.RoundingParams.RoundingMethod.OVERLAY_COLOR) {
                com.facebook.drawee.drawable.RoundedCornersDrawable roundedCornersDrawable = new com.facebook.drawee.drawable.RoundedCornersDrawable(drawable);
                applyRoundingParams(roundedCornersDrawable, roundingParams);
                roundedCornersDrawable.setOverlayColor(roundingParams.getOverlayColor());
                return roundedCornersDrawable;
            }
            return drawable;
        } finally {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
        }
    }

    static android.graphics.drawable.Drawable maybeApplyLeafRounding(android.graphics.drawable.Drawable drawable, com.facebook.drawee.generic.RoundingParams roundingParams, android.content.res.Resources resources) {
        boolean zIsTracing;
        try {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("WrappingUtils#maybeApplyLeafRounding");
            }
            if (drawable != null && roundingParams != null && roundingParams.getRoundingMethod() == com.facebook.drawee.generic.RoundingParams.RoundingMethod.BITMAP_ONLY) {
                if (!(drawable instanceof com.facebook.drawee.drawable.ForwardingDrawable)) {
                    return applyLeafRounding(drawable, roundingParams, resources);
                }
                com.facebook.drawee.drawable.DrawableParent drawableParentFindDrawableParentForLeaf = findDrawableParentForLeaf((com.facebook.drawee.drawable.ForwardingDrawable) drawable);
                drawableParentFindDrawableParentForLeaf.setDrawable(applyLeafRounding(drawableParentFindDrawableParentForLeaf.setDrawable(sEmptyDrawable), roundingParams, resources));
                if (zIsTracing) {
                    return drawable;
                }
            }
            return drawable;
        } finally {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
        }
    }

    private static android.graphics.drawable.Drawable applyLeafRounding(android.graphics.drawable.Drawable drawable, com.facebook.drawee.generic.RoundingParams roundingParams, android.content.res.Resources resources) {
        if (drawable instanceof android.graphics.drawable.BitmapDrawable) {
            android.graphics.drawable.BitmapDrawable bitmapDrawable = (android.graphics.drawable.BitmapDrawable) drawable;
            com.facebook.drawee.drawable.RoundedBitmapDrawable roundedBitmapDrawable = new com.facebook.drawee.drawable.RoundedBitmapDrawable(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
            applyRoundingParams(roundedBitmapDrawable, roundingParams);
            return roundedBitmapDrawable;
        }
        if (drawable instanceof android.graphics.drawable.NinePatchDrawable) {
            com.facebook.drawee.drawable.RoundedNinePatchDrawable roundedNinePatchDrawable = new com.facebook.drawee.drawable.RoundedNinePatchDrawable((android.graphics.drawable.NinePatchDrawable) drawable);
            applyRoundingParams(roundedNinePatchDrawable, roundingParams);
            return roundedNinePatchDrawable;
        }
        if (drawable instanceof android.graphics.drawable.ColorDrawable) {
            com.facebook.drawee.drawable.RoundedColorDrawable roundedColorDrawableFromColorDrawable = com.facebook.drawee.drawable.RoundedColorDrawable.fromColorDrawable((android.graphics.drawable.ColorDrawable) drawable);
            applyRoundingParams(roundedColorDrawableFromColorDrawable, roundingParams);
            return roundedColorDrawableFromColorDrawable;
        }
        com.facebook.common.logging.FLog.w(TAG, "Don't know how to round that drawable: %s", drawable);
        return drawable;
    }

    static void applyRoundingParams(com.facebook.drawee.drawable.Rounded rounded, com.facebook.drawee.generic.RoundingParams roundingParams) {
        rounded.setCircle(roundingParams.getRoundAsCircle());
        rounded.setRadii(roundingParams.getCornersRadii());
        rounded.setBorder(roundingParams.getBorderColor(), roundingParams.getBorderWidth());
        rounded.setPadding(roundingParams.getPadding());
        rounded.setScaleDownInsideBorders(roundingParams.getScaleDownInsideBorders());
    }

    static void resetRoundingParams(com.facebook.drawee.drawable.Rounded rounded) {
        rounded.setCircle(false);
        rounded.setRadius(0.0f);
        rounded.setBorder(0, 0.0f);
        rounded.setPadding(0.0f);
        rounded.setScaleDownInsideBorders(false);
    }

    static com.facebook.drawee.drawable.DrawableParent findDrawableParentForLeaf(com.facebook.drawee.drawable.DrawableParent drawableParent) {
        while (true) {
            java.lang.Object drawable = drawableParent.getDrawable();
            if (drawable == drawableParent || !(drawable instanceof com.facebook.drawee.drawable.DrawableParent)) {
                break;
            }
            drawableParent = (com.facebook.drawee.drawable.DrawableParent) drawable;
        }
        return drawableParent;
    }
}
