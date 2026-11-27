package io.dcloud.feature.nativeObj;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NativeImageSlider extends io.dcloud.feature.nativeObj.NativeView {
    static final java.lang.String TF = "{clientX:%d,clientY:%d,pageX:%d,pageY:%d,screenX:%d,screenY:%d,currentImageIndex:%d}";
    com.nostra13.dcloudimageloader.core.DisplayImageOptions defaultOptions;
    boolean isAutoplay;
    boolean isFullscreen;
    boolean isLoop;
    android.view.View mBackgroundView;
    io.dcloud.feature.nativeObj.BannerLayout mBannerLayout;
    int mFistBitmapHeight;
    int mFistBitmapWidth;
    java.lang.String mIndicator;
    int mInterval;
    int mSliderHeight;
    int measureTop;

    public NativeImageSlider(android.content.Context context, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
        super(context, iWebview, str, str2, jSONObject);
        this.isLoop = false;
        this.isFullscreen = true;
        this.isAutoplay = false;
        this.mInterval = androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat.MAX_NUM_POINTS;
        this.mSliderHeight = 0;
        this.mFistBitmapWidth = 0;
        this.mFistBitmapHeight = 0;
        this.measureTop = 0;
        this.mIndicator = "default";
        addBannerView(iWebview);
        this.mIntercept = false;
    }

    private java.util.ArrayList<io.dcloud.feature.nativeObj.data.NativeImageDataItem> toArrayList(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        java.util.ArrayList<io.dcloud.feature.nativeObj.data.NativeImageDataItem> arrayList = new java.util.ArrayList<>();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                io.dcloud.feature.nativeObj.data.NativeImageDataItem nativeImageDataItem = new io.dcloud.feature.nativeObj.data.NativeImageDataItem();
                org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                java.lang.String strConvertAppPath = io.dcloud.common.util.PdrUtil.convertAppPath(iWebview, jSONObjectOptJSONObject.optString("src"));
                io.dcloud.common.util.ImageLoaderUtil.addNetIconDownloadUrl(strConvertAppPath);
                nativeImageDataItem.setUrl(strConvertAppPath);
                if (jSONObjectOptJSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ALIGN)) {
                    nativeImageDataItem.align = jSONObjectOptJSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ALIGN);
                }
                if (jSONObjectOptJSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_VERTICAL_ALIGN)) {
                    nativeImageDataItem.verticalAlign = jSONObjectOptJSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_VERTICAL_ALIGN);
                }
                if (jSONObjectOptJSONObject.has("height")) {
                    nativeImageDataItem.height = jSONObjectOptJSONObject.optString("height");
                }
                if (jSONObjectOptJSONObject.has("width")) {
                    nativeImageDataItem.width = jSONObjectOptJSONObject.optString("width");
                }
                arrayList.add(nativeImageDataItem);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSliderHeight(int i, int i2) {
        int i3 = i2 * (this.mInnerWidth / i);
        if (this.mBannerLayout != null) {
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(this.mInnerWidth, i3);
            layoutParams.topMargin = this.mInnerTop + this.measureTop;
            layoutParams.bottomMargin = this.mInnerBottom;
            this.mBackgroundView.setLayoutParams(layoutParams);
            this.mBannerLayout.setLayoutParams(layoutParams);
            this.mSliderHeight = i3 + this.mInnerTop;
        }
    }

    public void addBannerView(io.dcloud.common.DHInterface.IWebview iWebview) {
        org.json.JSONObject jSONObject = this.mStyle;
        org.json.JSONArray jSONArrayOptJSONArray = null;
        if (jSONObject != null) {
            jSONArrayOptJSONArray = jSONObject.has("images") ? this.mStyle.optJSONArray("images") : null;
            if (this.mStyle.has("loop")) {
                this.isLoop = this.mStyle.optBoolean("loop");
            }
            if (this.mStyle.has(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_FULLSCREEN)) {
                this.isFullscreen = this.mStyle.optBoolean(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_FULLSCREEN);
            }
            if (this.mStyle.has(com.taobao.weex.common.Constants.Name.AUTOPLAY)) {
                this.isAutoplay = this.mStyle.optBoolean(com.taobao.weex.common.Constants.Name.AUTOPLAY);
                if (this.mStyle.has("interval")) {
                    this.mInterval = this.mStyle.optInt("interval", this.mInterval);
                }
            }
            if (this.mStyle.has(com.taobao.weex.ui.component.WXBasicComponentType.INDICATOR)) {
                this.mIndicator = this.mStyle.optString(com.taobao.weex.ui.component.WXBasicComponentType.INDICATOR);
            }
        }
        this.mWebView = iWebview;
        io.dcloud.feature.nativeObj.BannerLayout bannerLayout = new io.dcloud.feature.nativeObj.BannerLayout(getContext(), this.isLoop, false);
        this.mBannerLayout = bannerLayout;
        boolean z = this.isAutoplay;
        if (z) {
            bannerLayout.setAutoPlay(z, this.mInterval);
        }
        this.defaultOptions = new com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder().cacheOnDisc(true).cacheInMemory(true).imageScaleType(com.nostra13.dcloudimageloader.core.assist.ImageScaleType.NONE).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).showImageOnLoading(new android.graphics.drawable.ColorDrawable(0)).build();
        this.mBannerLayout.setImageLoader(new io.dcloud.feature.nativeObj.BannerLayout.ImageLoader() { // from class: io.dcloud.feature.nativeObj.NativeImageSlider.1
            @Override // io.dcloud.feature.nativeObj.BannerLayout.ImageLoader
            public void displayImage(android.content.Context context, java.lang.String str, final android.view.View view, final int i) {
                com.nostra13.dcloudimageloader.core.ImageLoaderL.getInstance().loadImage(str, io.dcloud.feature.nativeObj.NativeImageSlider.this.defaultOptions, new com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener() { // from class: io.dcloud.feature.nativeObj.NativeImageSlider.1.1
                    long startTime;

                    @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                    public void onLoadingCancelled(java.lang.String str2, android.view.View view2) {
                    }

                    @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                    public void onLoadingComplete(java.lang.String str2, android.view.View view2, android.graphics.Bitmap bitmap) {
                        io.dcloud.feature.nativeObj.NativeImageSlider nativeImageSlider = io.dcloud.feature.nativeObj.NativeImageSlider.this;
                        if (nativeImageSlider.isLayoutAdapt && i == 0) {
                            nativeImageSlider.mFistBitmapWidth = bitmap.getWidth();
                            io.dcloud.feature.nativeObj.NativeImageSlider.this.mFistBitmapHeight = bitmap.getHeight();
                            io.dcloud.feature.nativeObj.NativeImageSlider nativeImageSlider2 = io.dcloud.feature.nativeObj.NativeImageSlider.this;
                            nativeImageSlider2.updateSliderHeight(nativeImageSlider2.mFistBitmapWidth, nativeImageSlider2.mFistBitmapHeight);
                            io.dcloud.feature.nativeObj.NativeImageSlider.this.mCanvasView.requestLayout();
                        }
                        try {
                            if (!android.webkit.URLUtil.isNetworkUrl(str2) || java.lang.System.currentTimeMillis() - this.startTime <= 500) {
                                ((android.widget.ImageView) view).setImageBitmap(bitmap);
                                return;
                            }
                            ((android.widget.ImageView) view).setImageBitmap(bitmap);
                            android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.5f, 1.0f);
                            alphaAnimation.setDuration(500L);
                            view.startAnimation(alphaAnimation);
                        } catch (java.lang.Exception unused) {
                        }
                    }

                    @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                    public void onLoadingFailed(java.lang.String str2, android.view.View view2, com.nostra13.dcloudimageloader.core.assist.FailReason failReason) {
                    }

                    @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                    public void onLoadingStarted(java.lang.String str2, android.view.View view2) {
                        this.startTime = java.lang.System.currentTimeMillis();
                    }
                });
            }
        });
        this.mBannerLayout.setOnBannerItemClickListener(new io.dcloud.feature.nativeObj.BannerLayout.OnBannerItemClickListener() { // from class: io.dcloud.feature.nativeObj.NativeImageSlider.2
            @Override // io.dcloud.feature.nativeObj.BannerLayout.OnBannerItemClickListener
            public void onItemClick(int i) {
                io.dcloud.feature.nativeObj.NativeImageSlider nativeImageSlider = io.dcloud.feature.nativeObj.NativeImageSlider.this;
                if (!nativeImageSlider.isFullscreen) {
                    if (nativeImageSlider.mCanvasView.listenClick()) {
                        io.dcloud.feature.nativeObj.NativeImageSlider.this.mCanvasView.doTypeEvent(com.taobao.weex.common.Constants.Event.CLICK);
                        return;
                    }
                    return;
                }
                android.content.Intent intent = new android.content.Intent(io.dcloud.feature.nativeObj.NativeImageSlider.this.getContext(), (java.lang.Class<?>) io.dcloud.feature.nativeObj.photoview.PhotoActivity.class);
                intent.putParcelableArrayListExtra(io.dcloud.feature.nativeObj.photoview.PhotoActivity.IMAGE_URLS_KEY, io.dcloud.feature.nativeObj.NativeImageSlider.this.mBannerLayout.getUrls());
                intent.putExtra(io.dcloud.feature.nativeObj.photoview.PhotoActivity.IMAGE_CURRENT_INDEX_KEY, i);
                intent.putExtra(io.dcloud.feature.nativeObj.photoview.PhotoActivity.IMAGE_LOOP_KEY, true);
                intent.putExtra(io.dcloud.feature.nativeObj.photoview.PhotoActivity.IMAGE_PHOTO_KEY, true);
                intent.putExtra(io.dcloud.feature.nativeObj.photoview.PhotoActivity.IMAGE_PHOTO_TOP, io.dcloud.feature.nativeObj.NativeImageSlider.this.getTop());
                io.dcloud.feature.nativeObj.NativeImageSlider.this.getContext().startActivity(intent);
                android.content.Context context = io.dcloud.feature.nativeObj.NativeImageSlider.this.getContext();
                if (context instanceof android.app.Activity) {
                    ((android.app.Activity) context).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            }

            @Override // io.dcloud.feature.nativeObj.BannerLayout.OnBannerItemClickListener
            public void onItemLongClick(int i) {
            }
        });
        this.mBannerLayout.setIndicatorContainerData(io.dcloud.feature.nativeObj.BannerLayout.Position.centerBottom, 20, 10, 18, this.mIndicator);
        java.util.ArrayList<io.dcloud.feature.nativeObj.data.NativeImageDataItem> arrayList = toArrayList(iWebview, jSONArrayOptJSONArray);
        if (arrayList.size() > 0) {
            this.mBannerLayout.setViewUrls(arrayList, 0);
        }
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(this.mInnerWidth, this.isLayoutAdapt ? 0 : this.mInnerHeight);
        layoutParams.topMargin = this.mInnerTop + this.measureTop;
        layoutParams.bottomMargin = this.mInnerBottom;
        if (this.mBackgroundView == null) {
            this.mBackgroundView = new android.view.View(getContext());
        }
        addView(this.mBackgroundView, layoutParams);
        addView(this.mBannerLayout, layoutParams);
        super.attachCanvasView();
    }

    public void addImages(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        if (this.mBannerLayout != null) {
            this.mBannerLayout.addViewUrls(toArrayList(iWebview, jSONArray), 0);
        }
    }

    @Override // io.dcloud.feature.nativeObj.NativeView
    protected void attachCanvasView() {
    }

    @Override // io.dcloud.feature.nativeObj.NativeView
    public void clearNativeViewData() {
        super.clearNativeViewData();
        this.mFistBitmapHeight = 0;
        this.mFistBitmapWidth = 0;
        this.mSliderHeight = 0;
        io.dcloud.feature.nativeObj.BannerLayout bannerLayout = this.mBannerLayout;
        if (bannerLayout != null) {
            bannerLayout.clearBannerData();
        }
    }

    @Override // io.dcloud.feature.nativeObj.NativeView
    protected void configurationCange() {
        super.configurationCange();
        if (this.mBannerLayout != null) {
            if (this.isLayoutAdapt) {
                int i = this.mFistBitmapHeight;
                if (i != 0) {
                    updateSliderHeight(this.mFistBitmapWidth, i);
                    return;
                }
                return;
            }
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(this.mInnerWidth, this.mInnerHeight);
            layoutParams.topMargin = this.mInnerTop + this.measureTop;
            layoutParams.bottomMargin = this.mInnerBottom;
            this.mBackgroundView.setLayoutParams(layoutParams);
            this.mBannerLayout.setLayoutParams(layoutParams);
            this.mBannerLayout.requestLayout();
        }
    }

    @Override // io.dcloud.feature.nativeObj.NativeView, io.dcloud.common.DHInterface.IWaiter
    public java.lang.Object doForFeature(java.lang.String str, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equals("setAllowImageDownload")) {
            return super.doForFeature(str, obj);
        }
        java.lang.Object[] objArr = (java.lang.Object[]) obj;
        boolean zBooleanValue = ((java.lang.Boolean) objArr[0]).booleanValue();
        boolean zBooleanValue2 = ((java.lang.Boolean) objArr[1]).booleanValue();
        io.dcloud.feature.nativeObj.BannerLayout bannerLayout = this.mBannerLayout;
        if (bannerLayout == null) {
            return null;
        }
        bannerLayout.setAllowImageDownload(zBooleanValue, zBooleanValue2);
        return null;
    }

    public int getCurrentImageIndex() {
        io.dcloud.feature.nativeObj.BannerLayout bannerLayout = this.mBannerLayout;
        if (bannerLayout != null) {
            return bannerLayout.getCurrentPosition();
        }
        return 0;
    }

    @Override // io.dcloud.feature.nativeObj.NativeView
    java.lang.String getEventJSON() {
        return io.dcloud.common.util.StringUtil.format(TF, java.lang.Integer.valueOf((int) ((this.mTouchX - this.mInnerLeft) / this.mCreateScale)), java.lang.Integer.valueOf((int) ((this.mTouchY - this.mInnerTop) / this.mCreateScale)), java.lang.Integer.valueOf((int) (this.mTouchX / this.mCreateScale)), java.lang.Integer.valueOf((int) (this.mTouchY / this.mCreateScale)), java.lang.Integer.valueOf((int) (this.mTouchX / this.mCreateScale)), java.lang.Integer.valueOf((int) (this.mTouchY / this.mCreateScale)), java.lang.Integer.valueOf(getCurrentImageIndex()));
    }

    @Override // io.dcloud.feature.nativeObj.NativeView
    protected int getNViewContentHeight() {
        java.util.ArrayList<io.dcloud.feature.nativeObj.NativeView.Overlay> arrayList = this.mOverlays;
        if (arrayList == null) {
            return this.mAppScreenHeight;
        }
        this.mInnerHeight = this.mAppScreenHeight;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            io.dcloud.feature.nativeObj.NativeView.Overlay overlay = arrayList.get(i);
            i++;
            io.dcloud.feature.nativeObj.NativeView.Overlay overlay2 = overlay;
            int i3 = makeRect(this, overlay2.mDestJson, overlay2).bottom;
            if (i3 > i2) {
                i2 = i3;
            }
        }
        int i4 = this.mSliderHeight;
        return i4 > i2 ? i4 : i2;
    }

    @Override // io.dcloud.feature.nativeObj.NativeView, io.dcloud.common.DHInterface.INativeView
    public java.lang.String getViewType() {
        return io.dcloud.common.constant.AbsoluteConst.NATIVE_IMAGESLIDER;
    }

    @Override // io.dcloud.feature.nativeObj.NativeView
    protected void init() {
        super.init();
        if (this.mBackgroundView == null) {
            this.mBackgroundView = new android.view.View(getContext());
        }
        this.mBackgroundView.setBackgroundColor(this.mBackGroundColor);
    }

    @Override // io.dcloud.feature.nativeObj.NativeView
    void interceptTouchEvent(boolean z) {
        this.mIntercept = false;
    }

    @Override // io.dcloud.feature.nativeObj.NativeView
    protected void measureChildViewToTop(int i) {
        super.measureChildViewToTop(i);
        this.measureTop = i;
        if (this.mBannerLayout != null) {
            configurationCange();
        }
    }

    public void setImages(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        if (this.mBannerLayout != null) {
            this.mBannerLayout.setViewUrls(toArrayList(iWebview, jSONArray), 0);
        }
    }

    @Override // io.dcloud.feature.nativeObj.NativeView
    public void setStyle(org.json.JSONObject jSONObject, boolean z) {
        super.setStyle(jSONObject, z);
        if (this.mBannerLayout != null) {
            org.json.JSONObject jSONObject2 = this.mStyle;
            org.json.JSONArray jSONArrayOptJSONArray = null;
            if (jSONObject2 != null) {
                jSONArrayOptJSONArray = jSONObject2.has("images") ? this.mStyle.optJSONArray("images") : null;
                if (this.mStyle.has("loop")) {
                    this.isLoop = this.mStyle.optBoolean("loop");
                }
                if (this.mStyle.has(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_FULLSCREEN)) {
                    this.isFullscreen = this.mStyle.optBoolean(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_FULLSCREEN);
                }
                if (this.mStyle.has(com.taobao.weex.ui.component.WXBasicComponentType.INDICATOR)) {
                    this.mIndicator = this.mStyle.optString(com.taobao.weex.ui.component.WXBasicComponentType.INDICATOR);
                }
            }
            java.util.ArrayList<io.dcloud.feature.nativeObj.data.NativeImageDataItem> arrayList = toArrayList(this.mWebView, jSONArrayOptJSONArray);
            this.mBannerLayout.setImageLoop(java.lang.Boolean.valueOf(this.isLoop));
            this.mBannerLayout.setIndicatorType(this.mIndicator);
            this.mBannerLayout.setViewUrls(arrayList, 0);
        }
    }

    @Override // io.dcloud.feature.nativeObj.NativeView, io.dcloud.common.DHInterface.INativeView
    public void setStyleBackgroundColor(int i) {
        super.setStyleBackgroundColor(i);
        this.mBackgroundView.setBackgroundColor(this.mBackGroundColor);
    }
}
