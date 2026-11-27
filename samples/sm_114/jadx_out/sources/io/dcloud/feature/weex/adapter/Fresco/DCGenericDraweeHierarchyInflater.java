package io.dcloud.feature.weex.adapter.Fresco;

/* JADX INFO: loaded from: classes2.dex */
public class DCGenericDraweeHierarchyInflater {
    public static io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchy inflateHierarchy(android.content.Context context, android.util.AttributeSet attributeSet) {
        return inflateBuilder(context, attributeSet).build();
    }

    public static io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder inflateBuilder(android.content.Context context, android.util.AttributeSet attributeSet) {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("GenericDraweeHierarchyBuilder#inflateBuilder");
        }
        io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder dCGenericDraweeHierarchyBuilderUpdateBuilder = updateBuilder(new io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder(context.getResources()), context, attributeSet);
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
        return dCGenericDraweeHierarchyBuilderUpdateBuilder;
    }

    public static io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder updateBuilder(io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder dCGenericDraweeHierarchyBuilder, android.content.Context context, android.util.AttributeSet attributeSet) {
        dCGenericDraweeHierarchyBuilder.getProgressBarImage();
        return dCGenericDraweeHierarchyBuilder;
    }

    private static com.facebook.drawee.generic.RoundingParams getRoundingParams(io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder dCGenericDraweeHierarchyBuilder) {
        if (dCGenericDraweeHierarchyBuilder.getRoundingParams() == null) {
            dCGenericDraweeHierarchyBuilder.setRoundingParams(new com.facebook.drawee.generic.RoundingParams());
        }
        return dCGenericDraweeHierarchyBuilder.getRoundingParams();
    }

    private static android.graphics.drawable.Drawable getDrawable(android.content.Context context, android.content.res.TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getResources().getDrawable(resourceId);
    }

    private static com.facebook.drawee.drawable.ScalingUtils.ScaleType getScaleTypeFromXml(android.content.res.TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_XY;
            case 1:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_START;
            case 2:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_CENTER;
            case 3:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_END;
            case 4:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER;
            case 5:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_INSIDE;
            case 6:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_CROP;
            case 7:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.FOCUS_CROP;
            case 8:
                return com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_BOTTOM_START;
            default:
                throw new java.lang.RuntimeException("XML attribute not specified!");
        }
    }
}
