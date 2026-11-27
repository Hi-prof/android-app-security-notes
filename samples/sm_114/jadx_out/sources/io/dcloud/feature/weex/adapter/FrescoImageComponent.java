package io.dcloud.feature.weex.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class FrescoImageComponent extends com.taobao.weex.ui.component.WXImage {
    private int mBitmapHeight;
    private int mBitmapWidth;
    private java.lang.String mResizeMode;

    public FrescoImageComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, final com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mResizeMode = "scaleToFill";
        this.mBitmapWidth = 0;
        this.mBitmapHeight = 0;
        setContentBoxMeasurement(new com.taobao.weex.layout.ContentBoxMeasurement() { // from class: io.dcloud.feature.weex.adapter.FrescoImageComponent.1
            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutAfter(float f, float f2) {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutBefore() {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void measureInternal(float f, float f2, int i, int i2) {
                boolean zContainsKey = basicComponentData.getStyles().containsKey(com.taobao.weex.common.Constants.Name.FLEX);
                this.mMeasureExactly = false;
                if (i == 0) {
                    if (io.dcloud.feature.weex.adapter.FrescoImageComponent.this.mResizeMode.equals("heightFix") && io.dcloud.feature.weex.adapter.FrescoImageComponent.this.mBitmapHeight > 0 && io.dcloud.feature.weex.adapter.FrescoImageComponent.this.mBitmapWidth > 0 && !java.lang.Float.isNaN(f2)) {
                        this.mMeasureWidth = io.dcloud.feature.weex.adapter.FrescoImageComponent.this.mBitmapWidth * (f2 / io.dcloud.feature.weex.adapter.FrescoImageComponent.this.mBitmapHeight);
                        this.mMeasureExactly = true;
                    } else if (!zContainsKey) {
                        this.mMeasureWidth = (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(320.0f, io.dcloud.feature.weex.adapter.FrescoImageComponent.this.getInstance().getInstanceViewPortWidthWithFloat());
                    }
                }
                if (i2 == 0) {
                    if (!io.dcloud.feature.weex.adapter.FrescoImageComponent.this.mResizeMode.equals("widthFix") || io.dcloud.feature.weex.adapter.FrescoImageComponent.this.mBitmapHeight <= 0 || io.dcloud.feature.weex.adapter.FrescoImageComponent.this.mBitmapWidth <= 0 || java.lang.Float.isNaN(f)) {
                        if (zContainsKey) {
                            return;
                        }
                        this.mMeasureHeight = (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(240.0f, io.dcloud.feature.weex.adapter.FrescoImageComponent.this.getInstance().getInstanceViewPortWidthWithFloat());
                    } else {
                        this.mMeasureHeight = io.dcloud.feature.weex.adapter.FrescoImageComponent.this.mBitmapHeight * (f / io.dcloud.feature.weex.adapter.FrescoImageComponent.this.mBitmapWidth);
                        this.mMeasureExactly = true;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXImage, com.taobao.weex.ui.component.WXComponent
    public android.widget.ImageView initComponentHostView(android.content.Context context) {
        io.dcloud.feature.weex.adapter.FrescoImageView frescoImageView = new io.dcloud.feature.weex.adapter.FrescoImageView(context);
        frescoImageView.getHierarchy().setActualImageScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_XY);
        return frescoImageView;
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "fadeShow")
    public void setFadeAnim(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || getHostView() == null) {
            return;
        }
        ((io.dcloud.feature.weex.adapter.FrescoImageView) getHostView()).setFadeShow(java.lang.Boolean.valueOf(str).booleanValue());
    }

    @Override // com.taobao.weex.ui.component.WXImage, com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "resize":
                java.lang.String string = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string != null) {
                    setResizeMode(string);
                }
                return true;
            case "mode":
                java.lang.String string2 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string2 != null) {
                    setResizeMode(string2);
                }
                return true;
            case "resizeMode":
                java.lang.String string3 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string3 != null) {
                    setResizeMode(string3);
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @Override // com.taobao.weex.ui.component.WXImage
    public void setResizeMode(java.lang.String str) {
        io.dcloud.feature.weex.adapter.FrescoImageView frescoImageView = (io.dcloud.feature.weex.adapter.FrescoImageView) getHostView();
        com.facebook.drawee.drawable.ScalingUtils.ScaleType customScaleType = com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_XY;
        this.mResizeMode = str;
        if (!android.text.TextUtils.isEmpty(str)) {
            str.hashCode();
            switch (str) {
                case "stretch":
                    customScaleType = com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_XY;
                    break;
                case "top right":
                    customScaleType = new io.dcloud.feature.weex.adapter.FrescoImageComponent.CustomScaleType(1.0f, 0.0f);
                    break;
                case "heightFix":
                case "widthFix":
                    customScaleType = com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_CENTER;
                    break;
                case "bottom":
                    customScaleType = new io.dcloud.feature.weex.adapter.FrescoImageComponent.CustomScaleType(0.5f, 1.0f);
                    break;
                case "center":
                    customScaleType = new io.dcloud.feature.weex.adapter.FrescoImageComponent.CustomScaleType(0.5f, 0.5f);
                    break;
                case "aspectFit":
                    customScaleType = com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_CENTER;
                    break;
                case "top left":
                    customScaleType = new io.dcloud.feature.weex.adapter.FrescoImageComponent.CustomScaleType(0.0f, 0.0f);
                    break;
                case "scaleToFill":
                    customScaleType = com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_XY;
                    break;
                case "bottom left":
                    customScaleType = new io.dcloud.feature.weex.adapter.FrescoImageComponent.CustomScaleType(0.0f, 1.0f);
                    break;
                case "top":
                    customScaleType = new io.dcloud.feature.weex.adapter.FrescoImageComponent.CustomScaleType(0.5f, 0.0f);
                    break;
                case "left":
                    customScaleType = new io.dcloud.feature.weex.adapter.FrescoImageComponent.CustomScaleType(0.0f, 0.5f);
                    break;
                case "cover":
                    customScaleType = com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_CROP;
                    break;
                case "right":
                    customScaleType = new io.dcloud.feature.weex.adapter.FrescoImageComponent.CustomScaleType(1.0f, 0.5f);
                    break;
                case "aspectFill":
                    customScaleType = com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_CROP;
                    break;
                case "bottom right":
                    customScaleType = new io.dcloud.feature.weex.adapter.FrescoImageComponent.CustomScaleType(1.0f, 1.0f);
                    break;
                case "contain":
                    customScaleType = com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_CENTER;
                    break;
            }
        }
        frescoImageView.getHierarchy().setActualImageScaleType(customScaleType);
    }

    @Override // com.taobao.weex.ui.component.WXImage
    public void onImageFinish(boolean z, java.util.Map map) {
        super.onImageFinish(z, map);
        if (map != null) {
            java.lang.String str = this.mResizeMode;
            str.hashCode();
            if (str.equals("heightFix")) {
                this.mBitmapWidth = java.lang.Integer.parseInt(map.get("width").toString());
                this.mBitmapHeight = java.lang.Integer.parseInt(map.get("height").toString());
                float layoutHeight = this.mBitmapWidth * (getLayoutHeight() / this.mBitmapHeight);
                if (getLayoutWidth() != layoutHeight) {
                    setStyleWidth(layoutHeight);
                    return;
                }
                return;
            }
            if (str.equals("widthFix")) {
                this.mBitmapWidth = java.lang.Integer.parseInt(map.get("width").toString());
                this.mBitmapHeight = java.lang.Integer.parseInt(map.get("height").toString());
                float layoutWidth = this.mBitmapHeight * (getLayoutWidth() / this.mBitmapWidth);
                if (getLayoutHeight() != layoutWidth) {
                    setStyleHeight(layoutWidth);
                }
            }
        }
    }

    private void setStyleHeight(final float f) {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.adapter.FrescoImageComponent.2
            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.feature.weex.adapter.FrescoImageComponent.this.getInstance() != null) {
                    com.taobao.weex.bridge.WXBridgeManager.getInstance().setStyleHeight(io.dcloud.feature.weex.adapter.FrescoImageComponent.this.getInstanceId(), io.dcloud.feature.weex.adapter.FrescoImageComponent.this.getRef(), f);
                }
            }
        });
    }

    private void setStyleWidth(final float f) {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.adapter.FrescoImageComponent.3
            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.feature.weex.adapter.FrescoImageComponent.this.getInstance() != null) {
                    com.taobao.weex.bridge.WXBridgeManager.getInstance().setStyleWidth(io.dcloud.feature.weex.adapter.FrescoImageComponent.this.getInstanceId(), io.dcloud.feature.weex.adapter.FrescoImageComponent.this.getRef(), f);
                }
            }
        });
    }

    public class CustomScaleType implements com.facebook.drawee.drawable.ScalingUtils.ScaleType {
        private float dxf;
        private float dyf;

        public CustomScaleType(float f, float f2) {
            this.dxf = f;
            this.dyf = f2;
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public android.graphics.Matrix getTransform(android.graphics.Matrix matrix, android.graphics.Rect rect, int i, int i2, float f, float f2) {
            float f3 = i;
            float realPxByWidth = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(f3, io.dcloud.feature.weex.adapter.FrescoImageComponent.this.getInstance().getInstanceViewPortWidthWithFloat()) / f3;
            float fWidth = rect.left + ((rect.width() - (f3 * realPxByWidth)) * this.dxf);
            float fHeight = rect.top + ((rect.height() - (i2 * realPxByWidth)) * this.dyf);
            matrix.setScale(realPxByWidth, realPxByWidth);
            matrix.postTranslate(fWidth, fHeight);
            return matrix;
        }
    }

    @Override // com.taobao.weex.ui.component.WXImage, com.taobao.weex.ui.component.WXComponent
    public void updateProperties(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (getHostView() != null) {
            super.updateProperties(map);
            updateBorderRadius();
        }
    }

    private void updateBorderRadius() {
        float[] borderInnerRadius;
        com.taobao.weex.ui.view.border.BorderDrawable borderDrawable = com.taobao.weex.utils.WXViewUtils.getBorderDrawable(getHostView());
        com.facebook.drawee.generic.RoundingParams roundingParams = new com.facebook.drawee.generic.RoundingParams();
        if (borderDrawable != null) {
            borderInnerRadius = borderDrawable.getBorderInnerRadius(new android.graphics.RectF(0.0f, 0.0f, com.taobao.weex.utils.WXDomUtils.getContentWidth(this), com.taobao.weex.utils.WXDomUtils.getContentHeight(this)));
        } else {
            borderInnerRadius = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        roundingParams.setCornersRadii(borderInnerRadius);
        ((io.dcloud.feature.weex.adapter.FrescoImageView) getHostView()).getHierarchy().setRoundingParams(roundingParams);
    }
}
