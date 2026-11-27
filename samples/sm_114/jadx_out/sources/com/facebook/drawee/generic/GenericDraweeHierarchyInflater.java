package com.facebook.drawee.generic;

/* JADX INFO: loaded from: classes.dex */
public class GenericDraweeHierarchyInflater {
    public static com.facebook.drawee.generic.GenericDraweeHierarchy inflateHierarchy(android.content.Context context, @javax.annotation.Nullable android.util.AttributeSet attributeSet) {
        return inflateBuilder(context, attributeSet).build();
    }

    public static com.facebook.drawee.generic.GenericDraweeHierarchyBuilder inflateBuilder(android.content.Context context, @javax.annotation.Nullable android.util.AttributeSet attributeSet) throws java.lang.Throwable {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("GenericDraweeHierarchyBuilder#inflateBuilder");
        }
        com.facebook.drawee.generic.GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilderUpdateBuilder = updateBuilder(new com.facebook.drawee.generic.GenericDraweeHierarchyBuilder(context.getResources()), context, attributeSet);
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
        return genericDraweeHierarchyBuilderUpdateBuilder;
    }

    /* JADX WARN: Code duplicated, block: B:131:0x01e0 A[PHI: r1 r2 r3
  0x01e0: PHI (r1v18 boolean) = (r1v14 boolean), (r1v20 boolean) binds: [B:130:0x01de, B:115:0x01c4] A[DONT_GENERATE, DONT_INLINE]
  0x01e0: PHI (r2v13 boolean) = (r2v10 boolean), (r2v15 boolean) binds: [B:130:0x01de, B:115:0x01c4] A[DONT_GENERATE, DONT_INLINE]
  0x01e0: PHI (r3v9 boolean) = (r3v6 boolean), (r3v11 boolean) binds: [B:130:0x01de, B:115:0x01c4] A[DONT_GENERATE, DONT_INLINE]] */
    public static com.facebook.drawee.generic.GenericDraweeHierarchyBuilder updateBuilder(com.facebook.drawee.generic.GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder, android.content.Context context, @javax.annotation.Nullable android.util.AttributeSet attributeSet) throws java.lang.Throwable {
        boolean z;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        android.content.Context context2 = context;
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, com.facebook.drawee.R.styleable.GenericDraweeHierarchy);
            try {
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                int integer = 0;
                int i3 = 0;
                boolean z6 = true;
                boolean z7 = true;
                boolean z8 = true;
                boolean z9 = true;
                boolean z10 = true;
                boolean z11 = true;
                boolean z12 = true;
                boolean z13 = true;
                int dimensionPixelSize = 0;
                while (i3 < indexCount) {
                    try {
                        int index = typedArrayObtainStyledAttributes.getIndex(i3);
                        if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_actualImageScaleType) {
                            genericDraweeHierarchyBuilder.setActualImageScaleType(getScaleTypeFromXml(typedArrayObtainStyledAttributes, index));
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_placeholderImage) {
                            genericDraweeHierarchyBuilder.setPlaceholderImage(getDrawable(context2, typedArrayObtainStyledAttributes, index));
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_pressedStateOverlayImage) {
                            genericDraweeHierarchyBuilder.setPressedStateOverlay(getDrawable(context2, typedArrayObtainStyledAttributes, index));
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_progressBarImage) {
                            genericDraweeHierarchyBuilder.setProgressBarImage(getDrawable(context2, typedArrayObtainStyledAttributes, index));
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_fadeDuration) {
                            genericDraweeHierarchyBuilder.setFadeDuration(typedArrayObtainStyledAttributes.getInt(index, 0));
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_viewAspectRatio) {
                            genericDraweeHierarchyBuilder.setDesiredAspectRatio(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_placeholderImageScaleType) {
                            genericDraweeHierarchyBuilder.setPlaceholderImageScaleType(getScaleTypeFromXml(typedArrayObtainStyledAttributes, index));
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_retryImage) {
                            genericDraweeHierarchyBuilder.setRetryImage(getDrawable(context2, typedArrayObtainStyledAttributes, index));
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_retryImageScaleType) {
                            genericDraweeHierarchyBuilder.setRetryImageScaleType(getScaleTypeFromXml(typedArrayObtainStyledAttributes, index));
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_failureImage) {
                            genericDraweeHierarchyBuilder.setFailureImage(getDrawable(context2, typedArrayObtainStyledAttributes, index));
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_failureImageScaleType) {
                            genericDraweeHierarchyBuilder.setFailureImageScaleType(getScaleTypeFromXml(typedArrayObtainStyledAttributes, index));
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_progressBarImageScaleType) {
                            genericDraweeHierarchyBuilder.setProgressBarImageScaleType(getScaleTypeFromXml(typedArrayObtainStyledAttributes, index));
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_progressBarAutoRotateInterval) {
                            integer = typedArrayObtainStyledAttributes.getInteger(index, integer);
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_backgroundImage) {
                            genericDraweeHierarchyBuilder.setBackground(getDrawable(context2, typedArrayObtainStyledAttributes, index));
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_overlayImage) {
                            genericDraweeHierarchyBuilder.setOverlay(getDrawable(context2, typedArrayObtainStyledAttributes, index));
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundAsCircle) {
                            getRoundingParams(genericDraweeHierarchyBuilder).setRoundAsCircle(typedArrayObtainStyledAttributes.getBoolean(index, false));
                        } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundedCornerRadius) {
                            dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize);
                        } else {
                            int i4 = dimensionPixelSize;
                            if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopLeft) {
                                z6 = typedArrayObtainStyledAttributes.getBoolean(index, z6);
                            } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopRight) {
                                z8 = typedArrayObtainStyledAttributes.getBoolean(index, z8);
                            } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomLeft) {
                                z12 = typedArrayObtainStyledAttributes.getBoolean(index, z12);
                            } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomRight) {
                                z10 = typedArrayObtainStyledAttributes.getBoolean(index, z10);
                            } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopStart) {
                                z7 = typedArrayObtainStyledAttributes.getBoolean(index, z7);
                            } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundTopEnd) {
                                z9 = typedArrayObtainStyledAttributes.getBoolean(index, z9);
                            } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomStart) {
                                z13 = typedArrayObtainStyledAttributes.getBoolean(index, z13);
                            } else {
                                if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundBottomEnd) {
                                    z11 = typedArrayObtainStyledAttributes.getBoolean(index, z11);
                                } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundWithOverlayColor) {
                                    dimensionPixelSize = i4;
                                    getRoundingParams(genericDraweeHierarchyBuilder).setOverlayColor(typedArrayObtainStyledAttributes.getColor(index, 0));
                                } else {
                                    dimensionPixelSize = i4;
                                    if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundingBorderWidth) {
                                        getRoundingParams(genericDraweeHierarchyBuilder).setBorderWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                                    } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundingBorderColor) {
                                        getRoundingParams(genericDraweeHierarchyBuilder).setBorderColor(typedArrayObtainStyledAttributes.getColor(index, 0));
                                    } else if (index == com.facebook.drawee.R.styleable.GenericDraweeHierarchy_roundingBorderPadding) {
                                        getRoundingParams(genericDraweeHierarchyBuilder).setPadding(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                                    }
                                }
                                i3++;
                                context2 = context;
                            }
                            dimensionPixelSize = i4;
                        }
                        i3++;
                        context2 = context;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        typedArrayObtainStyledAttributes.recycle();
                        context.getResources().getConfiguration().getLayoutDirection();
                        throw th;
                    }
                }
                boolean z14 = false;
                typedArrayObtainStyledAttributes.recycle();
                if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
                    z5 = z6 && z9;
                    z = z8 && z7;
                    z2 = z10 && z13;
                    if (z12 && z11) {
                        z14 = true;
                    }
                } else {
                    z5 = z6 && z7;
                    z = z8 && z9;
                    z2 = z10 && z11;
                    if (z12 && z13) {
                        z14 = true;
                    }
                }
                z4 = z14;
                i = integer;
                z3 = z5;
                i2 = dimensionPixelSize;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } else {
            z = true;
            i = 0;
            i2 = 0;
            z2 = true;
            z3 = true;
            z4 = true;
        }
        if (genericDraweeHierarchyBuilder.getProgressBarImage() != null && i > 0) {
            genericDraweeHierarchyBuilder.setProgressBarImage(new com.facebook.drawee.drawable.AutoRotateDrawable(genericDraweeHierarchyBuilder.getProgressBarImage(), i));
        }
        if (i2 > 0) {
            getRoundingParams(genericDraweeHierarchyBuilder).setCornersRadii(z3 ? i2 : 0.0f, z ? i2 : 0.0f, z2 ? i2 : 0.0f, z4 ? i2 : 0.0f);
        }
        return genericDraweeHierarchyBuilder;
    }

    private static com.facebook.drawee.generic.RoundingParams getRoundingParams(com.facebook.drawee.generic.GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        if (genericDraweeHierarchyBuilder.getRoundingParams() == null) {
            genericDraweeHierarchyBuilder.setRoundingParams(new com.facebook.drawee.generic.RoundingParams());
        }
        return genericDraweeHierarchyBuilder.getRoundingParams();
    }

    @javax.annotation.Nullable
    public static android.graphics.drawable.Drawable getDrawable(android.content.Context context, android.content.res.TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getDrawable(resourceId);
    }

    @javax.annotation.Nullable
    public static com.facebook.drawee.drawable.ScalingUtils.ScaleType getScaleTypeFromXml(android.content.res.TypedArray typedArray, int i) {
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
