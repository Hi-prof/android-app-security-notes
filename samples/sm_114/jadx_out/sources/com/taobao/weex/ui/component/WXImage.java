package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXImage extends com.taobao.weex.ui.component.WXComponent<android.widget.ImageView> {
    private static com.taobao.weex.utils.SingleFunctionParser.FlatMapper<java.lang.Integer> BLUR_RADIUS_MAPPER = new com.taobao.weex.utils.SingleFunctionParser.FlatMapper<java.lang.Integer>() { // from class: com.taobao.weex.ui.component.WXImage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.taobao.weex.utils.SingleFunctionParser.FlatMapper
        public java.lang.Integer map(java.lang.String str) {
            return com.taobao.weex.utils.WXUtils.getInteger(str, 0);
        }
    };
    public static final java.lang.String ERRORDESC = "errorDesc";
    public static final java.lang.String SUCCEED = "success";
    private static final int WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 2;
    private boolean mAutoRecycle;
    private int mBlurRadius;
    private com.taobao.weex.WXSDKInstance.FrameViewEventListener mFrameViewEventListener;
    protected boolean mIsUni;
    private java.lang.String mSrc;
    private java.lang.String preImgUrlStr;

    public interface Measurable {
        int getNaturalHeight();

        int getNaturalWidth();
    }

    public void onImageFinish(boolean z, java.util.Map map) {
    }

    public static class Creator implements com.taobao.weex.ui.ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public com.taobao.weex.ui.component.WXComponent createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
            return new com.taobao.weex.ui.component.WXImage(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    @java.lang.Deprecated
    public WXImage(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    public WXImage(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mAutoRecycle = true;
        this.mIsUni = false;
        this.preImgUrlStr = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public android.widget.ImageView initComponentHostView(android.content.Context context) {
        com.taobao.weex.ui.view.WXImageView wXImageView = new com.taobao.weex.ui.view.WXImageView(context);
        wXImageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        wXImageView.setCropToPadding(true);
        wXImageView.holdComponent(this);
        return wXImageView;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        int blurRadius = 0;
        switch (str) {
            case "autoBitmapRecycle":
                boolean zBooleanValue = com.taobao.weex.utils.WXUtils.getBoolean(obj, java.lang.Boolean.valueOf(this.mAutoRecycle)).booleanValue();
                this.mAutoRecycle = zBooleanValue;
                if (!zBooleanValue && getInstance() != null) {
                    getInstance().getApmForInstance().updateDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_IMG_UN_RECYCLE_NUM, 1.0d);
                }
                return true;
            case "filter":
                if (obj != null && (obj instanceof java.lang.String)) {
                    blurRadius = parseBlurRadius((java.lang.String) obj);
                }
                if (!android.text.TextUtils.isEmpty(this.mSrc)) {
                    setBlurRadius(this.mSrc, blurRadius);
                }
                return true;
            case "resize":
                java.lang.String string = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string != null) {
                    setResize(string);
                }
                return true;
            case "src":
                java.lang.String string2 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string2 != null) {
                    setSrc(string2);
                }
                return true;
            case "resizeMode":
                java.lang.String string3 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string3 != null) {
                    setResizeMode(string3);
                    break;
                }
            case "imageQuality":
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void refreshData(com.taobao.weex.ui.component.WXComponent wXComponent) {
        super.refreshData(wXComponent);
        if (wXComponent instanceof com.taobao.weex.ui.component.WXImage) {
            setSrc(wXComponent.getAttrs().getImageSrc());
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.RESIZE_MODE)
    public void setResizeMode(java.lang.String str) {
        getHostView().setScaleType(getResizeMode(str));
        getHostView().setImageDrawable(getHostView().getDrawable());
    }

    protected android.widget.ImageView.ScaleType getResizeMode(java.lang.String str) {
        android.widget.ImageView.ScaleType scaleType = android.widget.ImageView.ScaleType.FIT_XY;
        if (!android.text.TextUtils.isEmpty(str)) {
            str.hashCode();
            switch (str) {
                case "stretch":
                    return android.widget.ImageView.ScaleType.FIT_XY;
                case "cover":
                    return android.widget.ImageView.ScaleType.CENTER_CROP;
                case "contain":
                    return android.widget.ImageView.ScaleType.FIT_CENTER;
            }
        }
        return scaleType;
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "resize")
    public void setResize(java.lang.String str) {
        setResizeMode(str);
    }

    private void setLocalSrc(android.net.Uri uri) {
        android.widget.ImageView hostView;
        android.graphics.drawable.Drawable drawableFromLoaclSrc = com.taobao.weex.utils.ImgURIUtil.getDrawableFromLoaclSrc(getContext(), uri);
        if (drawableFromLoaclSrc == null || (hostView = getHostView()) == null) {
            return;
        }
        hostView.setImageDrawable(drawableFromLoaclSrc);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "src")
    public void setSrc(java.lang.String str) {
        runSrc(str);
    }

    private void runSrc(java.lang.String str) {
        if (getHostView() == null || getInstance() == null) {
            return;
        }
        if (getInstance().getImageNetworkHandler() != null) {
            java.lang.String strFetchLocal = getInstance().getImageNetworkHandler().fetchLocal(str);
            if (!android.text.TextUtils.isEmpty(strFetchLocal)) {
                str = strFetchLocal;
            }
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return;
        }
        android.widget.ImageView hostView = getHostView();
        if (hostView != null && hostView.getDrawable() != null && !android.text.TextUtils.equals(this.mSrc, str)) {
            hostView.setImageDrawable(null);
        }
        this.mSrc = str;
        android.net.Uri uriRewriteUri = getInstance().rewriteUri(android.net.Uri.parse(str), "image");
        if (com.taobao.weex.common.Constants.Scheme.LOCAL.equals(uriRewriteUri.getScheme())) {
            setLocalSrc(uriRewriteUri);
        } else {
            setRemoteSrc(uriRewriteUri, parseBlurRadius(getStyles().getBlur()));
        }
    }

    private void setBlurRadius(java.lang.String str, int i) {
        if (getInstance() == null || i == this.mBlurRadius) {
            return;
        }
        android.net.Uri uriRewriteUri = getInstance().rewriteUri(android.net.Uri.parse(str), "image");
        if (com.taobao.weex.common.Constants.Scheme.LOCAL.equals(uriRewriteUri.getScheme())) {
            return;
        }
        setRemoteSrc(uriRewriteUri, i);
    }

    private int parseBlurRadius(java.lang.String str) {
        if (str == null) {
            return 0;
        }
        try {
            java.util.List list = new com.taobao.weex.utils.SingleFunctionParser(str, BLUR_RADIUS_MAPPER).parse(com.taobao.weex.common.Constants.Event.BLUR);
            if (list != null && !list.isEmpty()) {
                return ((java.lang.Integer) list.get(0)).intValue();
            }
        } catch (java.lang.Exception unused) {
        }
        return 0;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void recycled() {
        super.recycled();
        if (getHostView() != null && getInstance() != null && getInstance().getImgLoaderAdapter() != null) {
            getInstance().getImgLoaderAdapter().setImage(null, (android.widget.ImageView) this.mHost, null, null);
        } else {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                throw new com.taobao.weex.common.WXRuntimeException("getImgLoaderAdapter() == null");
            }
            com.taobao.weex.utils.WXLogUtils.e("Error getImgLoaderAdapter() == null");
        }
    }

    public void autoReleaseImage() {
        if (!this.mAutoRecycle || getHostView() == null || getInstance() == null || getInstance().getImgLoaderAdapter() == null) {
            return;
        }
        getInstance().getImgLoaderAdapter().setImage(null, (android.widget.ImageView) this.mHost, null, null);
    }

    public void autoRecoverImage() {
        if (this.mAutoRecycle) {
            setSrc(this.mSrc);
        }
    }

    private void setRemoteSrc(android.net.Uri uri, int i) {
        java.lang.String str;
        com.taobao.weex.common.WXImageStrategy wXImageStrategy = new com.taobao.weex.common.WXImageStrategy(getInstanceId());
        wXImageStrategy.isClipping = true;
        wXImageStrategy.isSharpen = getAttrs().getImageSharpen() == com.taobao.weex.common.WXImageSharpen.SHARPEN;
        wXImageStrategy.blurRadius = java.lang.Math.max(0, i);
        this.mBlurRadius = i;
        java.lang.String string = uri.toString();
        wXImageStrategy.setImageListener(new com.taobao.weex.ui.component.WXImage.MyImageListener(this, string));
        if (getAttrs().containsKey("autoCompression")) {
            wXImageStrategy.setAutoCompression(com.taobao.weex.utils.WXUtils.getBoolean(getAttrs().get("autoCompression"), true).booleanValue());
        }
        if (getAttrs().containsKey(com.taobao.weex.common.Constants.Name.PLACEHOLDER)) {
            str = (java.lang.String) getAttrs().get(com.taobao.weex.common.Constants.Name.PLACEHOLDER);
        } else {
            str = getAttrs().containsKey(com.taobao.weex.common.Constants.Name.PLACE_HOLDER) ? (java.lang.String) getAttrs().get(com.taobao.weex.common.Constants.Name.PLACE_HOLDER) : null;
        }
        if (str != null) {
            wXImageStrategy.placeHolder = getInstance().rewriteUri(android.net.Uri.parse(str), "image").toString();
        }
        wXImageStrategy.instanceId = getInstanceId();
        setImage(string, wXImageStrategy);
    }

    protected void setImage(java.lang.String str, com.taobao.weex.common.WXImageStrategy wXImageStrategy) {
        com.taobao.weex.adapter.IWXImgLoaderAdapter imgLoaderAdapter = getInstance().getImgLoaderAdapter();
        if (imgLoaderAdapter != null) {
            imgLoaderAdapter.setImage(str, getHostView(), getImageQuality(), wXImageStrategy);
        }
    }

    protected com.taobao.weex.dom.WXImageQuality getImageQuality() {
        return getAttrs().getImageQuality();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected void onFinishLayout() {
        super.onFinishLayout();
        updateBorderRadius();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void updateProperties(java.util.Map<java.lang.String, java.lang.Object> map) {
        super.updateProperties(map);
        updateBorderRadius();
    }

    private void updateBorderRadius() {
        float[] borderInnerRadius;
        if (getHostView() instanceof com.taobao.weex.ui.view.WXImageView) {
            com.taobao.weex.ui.view.WXImageView wXImageView = (com.taobao.weex.ui.view.WXImageView) getHostView();
            com.taobao.weex.ui.view.border.BorderDrawable borderDrawable = com.taobao.weex.utils.WXViewUtils.getBorderDrawable(getHostView());
            if (borderDrawable != null) {
                borderInnerRadius = borderDrawable.getBorderInnerRadius(new android.graphics.RectF(0.0f, 0.0f, com.taobao.weex.utils.WXDomUtils.getContentWidth(this), com.taobao.weex.utils.WXDomUtils.getContentHeight(this)));
            } else {
                borderInnerRadius = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            }
            wXImageView.setBorderRadius(borderInnerRadius);
            if (wXImageView.getDrawable() instanceof com.taobao.weex.utils.ImageDrawable) {
                com.taobao.weex.utils.ImageDrawable imageDrawable = (com.taobao.weex.utils.ImageDrawable) wXImageView.getDrawable();
                if (java.util.Arrays.equals(imageDrawable.getCornerRadii(), borderInnerRadius)) {
                    return;
                }
                imageDrawable.setCornerRadii(borderInnerRadius);
            }
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void save(final com.taobao.weex.bridge.JSCallback jSCallback) {
        if (androidx.core.content.ContextCompat.checkSelfPermission(getContext(), com.hjq.permissions.Permission.WRITE_EXTERNAL_STORAGE) != 0 && (getContext() instanceof android.app.Activity)) {
            androidx.core.app.ActivityCompat.requestPermissions((android.app.Activity) getContext(), new java.lang.String[]{com.hjq.permissions.Permission.WRITE_EXTERNAL_STORAGE}, 2);
        }
        if (androidx.core.content.ContextCompat.checkSelfPermission(getContext(), com.hjq.permissions.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            if (jSCallback != null) {
                java.util.HashMap map = new java.util.HashMap();
                map.put(SUCCEED, false);
                map.put(ERRORDESC, "Permission denied: android.permission.WRITE_EXTERNAL_STORAGE");
                jSCallback.invoke(map);
                return;
            }
            return;
        }
        if (this.mHost == 0) {
            if (jSCallback != null) {
                java.util.HashMap map2 = new java.util.HashMap();
                map2.put(SUCCEED, false);
                map2.put(ERRORDESC, "Image component not initialized");
                jSCallback.invoke(map2);
                return;
            }
            return;
        }
        java.lang.String str = this.mSrc;
        if (str != null && !str.equals("")) {
            com.taobao.weex.utils.WXViewToImageUtil.generateImage(this.mHost, 0, -460552, new com.taobao.weex.utils.WXViewToImageUtil.OnImageSavedCallback() { // from class: com.taobao.weex.ui.component.WXImage.2
                @Override // com.taobao.weex.utils.WXViewToImageUtil.OnImageSavedCallback
                public void onSaveSucceed(java.lang.String str2) {
                    if (jSCallback != null) {
                        java.util.HashMap map3 = new java.util.HashMap();
                        map3.put(com.taobao.weex.ui.component.WXImage.SUCCEED, true);
                        jSCallback.invoke(map3);
                    }
                }

                @Override // com.taobao.weex.utils.WXViewToImageUtil.OnImageSavedCallback
                public void onSaveFailed(java.lang.String str2) {
                    if (jSCallback != null) {
                        java.util.HashMap map3 = new java.util.HashMap();
                        map3.put(com.taobao.weex.ui.component.WXImage.SUCCEED, false);
                        map3.put(com.taobao.weex.ui.component.WXImage.ERRORDESC, str2);
                        jSCallback.invoke(map3);
                    }
                }
            });
        } else if (jSCallback != null) {
            java.util.HashMap map3 = new java.util.HashMap();
            map3.put(SUCCEED, false);
            map3.put(ERRORDESC, "Image does not have the correct src");
            jSCallback.invoke(map3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void monitorImgSize(android.widget.ImageView imageView, java.lang.String str) {
        com.taobao.weex.WXSDKInstance wXImage;
        if (imageView == null || (wXImage = getInstance()) == null) {
            return;
        }
        android.view.ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        android.graphics.drawable.Drawable drawable = imageView.getDrawable();
        if (layoutParams == null || drawable == null) {
            return;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (this.preImgUrlStr.equals(str)) {
            return;
        }
        this.preImgUrlStr = str;
        if (intrinsicHeight > 1081 && intrinsicWidth > 721) {
            wXImage.getApmForInstance().updateDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_LARGE_IMG_COUNT, 1.0d);
            if (com.taobao.weex.performance.WXAnalyzerDataTransfer.isOpenPerformance) {
                com.taobao.weex.performance.WXAnalyzerDataTransfer.transferPerformance(getInstanceId(), "details", com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_LARGE_IMG_COUNT, intrinsicWidth + "*" + intrinsicHeight + "," + str);
            }
        }
        long j = intrinsicHeight * intrinsicWidth;
        long measuredHeight = imageView.getMeasuredHeight() * imageView.getMeasuredWidth();
        if (measuredHeight != 0 && j / measuredHeight > 1.2d && j - measuredHeight > 1600) {
            wXImage.getWXPerformance().wrongImgSizeCount += 1.0d;
            wXImage.getApmForInstance().updateDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_WRONG_IMG_SIZE_COUNT, 1.0d);
            if (com.taobao.weex.performance.WXAnalyzerDataTransfer.isOpenPerformance) {
                com.taobao.weex.performance.WXAnalyzerDataTransfer.transferPerformance(getInstanceId(), "details", com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_WRONG_IMG_SIZE_COUNT, io.dcloud.common.util.StringUtil.format("imgSize:[%d,%d],viewSize:[%d,%d],urL:%s", java.lang.Integer.valueOf(intrinsicWidth), java.lang.Integer.valueOf(intrinsicHeight), java.lang.Integer.valueOf(imageView.getMeasuredWidth()), java.lang.Integer.valueOf(imageView.getMeasuredHeight()), str));
            }
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        if (getHostView() != null && getInstance() != null && (getHostView() instanceof com.taobao.weex.ui.view.WXImageView) && getInstance().getImgLoaderAdapter() != null) {
            getInstance().getImgLoaderAdapter().setImage(null, (android.widget.ImageView) this.mHost, null, null);
        }
        super.destroy();
    }

    public class MyImageListener implements com.taobao.weex.common.WXImageStrategy.ImageListener {
        private java.lang.String rewritedStr;
        private java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXImage> wxImageWeakReference;

        MyImageListener(com.taobao.weex.ui.component.WXImage wXImage, java.lang.String str) {
            this.wxImageWeakReference = new java.lang.ref.WeakReference<>(wXImage);
            this.rewritedStr = str;
        }

        @Override // com.taobao.weex.common.WXImageStrategy.ImageListener
        public void onImageFinish(java.lang.String str, android.widget.ImageView imageView, boolean z, java.util.Map map) {
            com.taobao.weex.ui.component.WXImage wXImage = this.wxImageWeakReference.get();
            if (wXImage == null) {
                return;
            }
            if (map == null) {
                java.util.HashMap map2 = new java.util.HashMap();
                map2.put(com.taobao.weex.ui.component.WXImage.SUCCEED, false);
                wXImage.fireEvent("error", map2);
                return;
            }
            wXImage.onImageFinish(z, map);
            java.util.HashMap map3 = new java.util.HashMap();
            java.util.HashMap map4 = new java.util.HashMap(2);
            map4.put("width", map.get("width"));
            map4.put("height", map.get("height"));
            if (com.taobao.weex.ui.component.WXImage.this.mIsUni) {
                if (!z && wXImage.containsEvent("error")) {
                    map3.put(com.taobao.weex.ui.component.WXImage.SUCCEED, java.lang.Boolean.valueOf(z));
                    map3.put("detail", map4);
                    wXImage.fireEvent("error", map3);
                }
                if (z && wXImage.containsEvent("load")) {
                    map3.put(com.taobao.weex.ui.component.WXImage.SUCCEED, java.lang.Boolean.valueOf(z));
                    map3.put("detail", map4);
                    wXImage.fireEvent("load", map3);
                }
            } else if (wXImage.containsEvent("load")) {
                map3.put(com.taobao.weex.ui.component.WXImage.SUCCEED, java.lang.Boolean.valueOf(z));
                map3.put("detail", map4);
                wXImage.fireEvent("load", map3);
            }
            wXImage.monitorImgSize(imageView, this.rewritedStr);
        }
    }
}
