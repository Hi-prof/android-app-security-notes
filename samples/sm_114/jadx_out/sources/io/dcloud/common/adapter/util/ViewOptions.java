package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ViewOptions extends io.dcloud.common.adapter.util.ViewRect {
    public static final int BG_NONE = -1;
    public java.lang.String animationAlphaBackground;
    public int coverage;
    public java.util.HashMap<java.lang.String, io.dcloud.common.adapter.util.DragBean> dragData;
    public org.json.JSONObject mPullToRefresh;
    public org.json.JSONArray mSubNViews;
    public java.lang.Object mTag;
    public boolean mUseHardwave;
    public java.lang.String name;
    public org.json.JSONObject titleNView;
    public org.json.JSONObject transform;
    public org.json.JSONObject transition;
    public boolean scalable = false;
    public java.lang.String mInjection = io.dcloud.common.constant.AbsoluteConst.TRUE;
    public java.lang.String mPlusrequire = "normal";
    public boolean mDisablePlus = false;
    private java.lang.String mScrollIndicator = "all";
    public float opacity = -1.0f;
    public int background = -1;
    public int maskColor = -1;
    public java.lang.String strBackground = null;
    public boolean webviewBGTransparent = false;
    public java.lang.String strTabBG = null;
    public java.lang.String errorPage = null;
    public boolean mBounce = false;
    public java.lang.String mCacheMode = "default";
    public java.lang.String mVideoFullscree = "auto";
    public java.lang.String popGesture = "none";
    public java.lang.String historyBack = "none";
    public java.lang.String mGeoInject = "none";
    public boolean dragH5NeedTouchEvent = false;
    public java.lang.String backButtonAutoControl = "none";
    public boolean isAnimationOptimization = false;
    public boolean isUserSelect = true;
    public java.lang.String softinputMode = "adjustResize";
    public org.json.JSONObject mUniNViewJson = null;
    public org.json.JSONObject mProgressJson = null;
    public org.json.JSONObject mDebugRefresh = null;
    public org.json.JSONObject mUniPageUrl = null;
    public java.lang.Boolean isTabItem = java.lang.Boolean.FALSE;
    public boolean isUniH5 = false;

    public ViewOptions() {
        this.mUseHardwave = true;
        this.mUseHardwave = io.dcloud.common.adapter.util.MobilePhoneModel.checkPhoneBanAcceleration(android.os.Build.BRAND);
    }

    public static io.dcloud.common.adapter.util.ViewOptions createViewOptionsData(io.dcloud.common.adapter.util.ViewOptions viewOptions, io.dcloud.common.adapter.util.ViewRect viewRect) {
        return createViewOptionsData(viewOptions, null, viewRect);
    }

    public java.lang.String getScrollIndicator() {
        return this.mScrollIndicator;
    }

    public boolean hasBackground() {
        if (this.background == -1) {
            return (io.dcloud.common.util.PdrUtil.isEmpty(this.strBackground) || this.strBackground.equals("transparent")) ? false : true;
        }
        return true;
    }

    public boolean hasMask() {
        return this.maskColor != -1;
    }

    public boolean hasTransparentValue() {
        if (isTransparent() || io.dcloud.common.util.PdrUtil.checkAlphaTransparent(this.background)) {
            return true;
        }
        float f = this.opacity;
        return f >= 0.0f && f < 1.0f;
    }

    public boolean isTabHasBg() {
        return this.isTabItem.booleanValue() && !io.dcloud.common.util.PdrUtil.isEmpty(this.strTabBG);
    }

    public boolean isTransparent() {
        return io.dcloud.common.util.PdrUtil.isEquals("transparent", this.strBackground);
    }

    public void setBackButtonAutoControl(org.json.JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("backButtonAutoControl")) {
            return;
        }
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject, "backButtonAutoControl");
        if ("none".equals(string) || "hide".equals(string) || io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE.equals(string) || "quit".equals(string)) {
            this.backButtonAutoControl = string;
        }
    }

    public void setDragData(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, io.dcloud.common.DHInterface.IFrameView iFrameView, io.dcloud.common.DHInterface.IFrameView iFrameView2, java.lang.String str, android.view.View view) {
        try {
            if (this.dragData == null) {
                this.dragData = new java.util.HashMap<>();
            }
            io.dcloud.common.adapter.util.DragBean dragBean = new io.dcloud.common.adapter.util.DragBean();
            dragBean.dragCurrentViewOp = jSONObject;
            dragBean.dragBindViewOp = jSONObject2;
            dragBean.dragBindWebView = iFrameView;
            dragBean.dragCallBackWebView = iFrameView2;
            dragBean.dragCbId = str;
            dragBean.nativeView = view;
            if (jSONObject.has("direction")) {
                java.lang.String string = jSONObject.getString("direction");
                if (android.text.TextUtils.isEmpty(string)) {
                    return;
                }
                this.dragData.put(string.toLowerCase(java.util.Locale.ENGLISH), dragBean);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void setTitleNView(org.json.JSONObject jSONObject, io.dcloud.common.DHInterface.IWebview iWebview) {
        java.lang.String strOptString;
        if (jSONObject != null) {
            if ("transparent".equals(jSONObject.optString("type"))) {
                if (jSONObject.has("titleColor")) {
                    strOptString = jSONObject.optString("titleColor");
                } else {
                    strOptString = jSONObject.has("titlecolor") ? jSONObject.optString("titlecolor") : null;
                }
                if (!android.text.TextUtils.isEmpty(strOptString)) {
                    try {
                        int color = android.graphics.Color.parseColor(strOptString);
                        java.lang.String hexString = java.lang.Integer.toHexString(0);
                        if (1 == hexString.length()) {
                            hexString = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString.toUpperCase();
                        }
                        java.lang.String hexString2 = java.lang.Integer.toHexString(android.graphics.Color.red(color));
                        if (1 == hexString2.length()) {
                            hexString2 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString2.toUpperCase();
                        }
                        java.lang.String hexString3 = java.lang.Integer.toHexString(android.graphics.Color.green(color));
                        if (1 == hexString3.length()) {
                            hexString3 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString3.toUpperCase();
                        }
                        java.lang.String hexString4 = java.lang.Integer.toHexString(android.graphics.Color.blue(color));
                        if (1 == hexString4.length()) {
                            hexString4 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString4.toUpperCase();
                        }
                        java.lang.String str = "#" + hexString + hexString2 + hexString3 + hexString4;
                        if (jSONObject.has("titleColor")) {
                            jSONObject.put("titleColor", str);
                        } else if (jSONObject.has("titlecolor")) {
                            jSONObject.put("titlecolor", str);
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.coverage = io.dcloud.common.util.PdrUtil.convertToScreenInt("136px", io.dcloud.common.adapter.util.PlatformUtil.SCREEN_WIDTH(iWebview.getContext()), 0, iWebview.getScale());
            this.coverage = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObject.optString("coverage"), io.dcloud.common.adapter.util.PlatformUtil.SCREEN_WIDTH(iWebview.getContext()), this.coverage, iWebview.getScale());
            this.titleNView = jSONObject;
        }
    }

    @Override // io.dcloud.common.adapter.util.ViewRect
    public void updateViewData(io.dcloud.common.adapter.util.ViewRect viewRect) {
        super.updateViewData(viewRect);
    }

    public static io.dcloud.common.adapter.util.ViewOptions createViewOptionsData(io.dcloud.common.adapter.util.ViewOptions viewOptions, io.dcloud.common.adapter.util.ViewRect viewRect, io.dcloud.common.adapter.util.ViewRect viewRect2) {
        if (viewOptions == null) {
            return null;
        }
        io.dcloud.common.adapter.util.ViewOptions viewOptions2 = new io.dcloud.common.adapter.util.ViewOptions();
        if (viewRect != null) {
            viewOptions2.setFrameParentViewRect(viewRect);
        }
        viewOptions2.mWebviewScale = viewOptions.mWebviewScale;
        viewOptions2.setParentViewRect(viewRect2);
        viewOptions2.updateViewData(viewOptions.mJsonViewOption);
        return viewOptions2;
    }

    @Override // io.dcloud.common.adapter.util.ViewRect
    public boolean updateViewData(org.json.JSONObject jSONObject) {
        boolean zUpdateViewData = super.updateViewData(jSONObject);
        if (jSONObject != null) {
            if (!jSONObject.isNull("isTab")) {
                this.isTabItem = java.lang.Boolean.valueOf(jSONObject.optBoolean("isTab", false));
            }
            if (!jSONObject.isNull("isUniH5")) {
                this.isUniH5 = jSONObject.optBoolean("isUniH5", false);
            }
            if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SCROLLINDICATOR)) {
                this.mScrollIndicator = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SCROLLINDICATOR);
            }
            java.lang.String lowerCase = null;
            if (!jSONObject.isNull("background")) {
                try {
                    java.lang.String lowerCase2 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "background").toLowerCase(java.util.Locale.ENGLISH);
                    try {
                        if (this.isTabItem.booleanValue()) {
                            jSONObject.remove("background");
                            this.strTabBG = lowerCase2;
                            this.strBackground = null;
                            this.background = -1;
                        } else {
                            this.strBackground = lowerCase2;
                            this.background = io.dcloud.common.util.PdrUtil.stringToColor(lowerCase2);
                        }
                        lowerCase = lowerCase2;
                    } catch (java.lang.Exception e) {
                        e = e;
                        lowerCase = lowerCase2;
                        e.printStackTrace();
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                }
            }
            if (!jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_WEBBG_TRANSPARENT)) {
                this.webviewBGTransparent = io.dcloud.common.util.JSONUtil.getBoolean(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_WEBBG_TRANSPARENT);
            }
            if (!jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TABBG)) {
                lowerCase = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TABBG).toLowerCase(java.util.Locale.ENGLISH);
                this.strTabBG = lowerCase;
            }
            if (!jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ANIMATION_ALPHA_BG)) {
                try {
                    this.animationAlphaBackground = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ANIMATION_ALPHA_BG).toLowerCase(java.util.Locale.ENGLISH);
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                }
            } else if (!android.text.TextUtils.isEmpty(lowerCase)) {
                try {
                    this.animationAlphaBackground = lowerCase;
                } catch (java.lang.Exception e4) {
                    e4.printStackTrace();
                }
            }
            if (!jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_MASK)) {
                try {
                    this.maskColor = io.dcloud.common.util.PdrUtil.stringToColor(io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_MASK).toLowerCase(java.util.Locale.ENGLISH));
                } catch (java.lang.Exception e5) {
                    e5.printStackTrace();
                }
            }
            if (!jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_CACHEMODE)) {
                this.mCacheMode = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_CACHEMODE);
            }
            this.mUseHardwave = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_HARDWARE_ACCELERATED), this.mUseHardwave, false);
            this.opacity = io.dcloud.common.util.PdrUtil.parseFloat(io.dcloud.common.util.JSONUtil.getString(jSONObject, "opacity"), this.opacity);
            this.scalable = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SCALABLE), this.scalable, false);
            this.transition = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TRANSITION);
            this.transform = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject, "transform");
            this.errorPage = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ERROR_PAGE);
            this.mInjection = io.dcloud.common.util.JSONUtil.getString(jSONObject, "injection");
            this.mPlusrequire = jSONObject.optString("plusrequire", this.mPlusrequire);
            this.mDisablePlus = jSONObject.optBoolean(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_DISABLE_PLUS, this.mDisablePlus);
            this.popGesture = jSONObject.optString("popGesture", this.popGesture);
            this.historyBack = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_HISTORYBACK, this.historyBack);
            this.isUserSelect = jSONObject.optBoolean("userSelect", true);
            this.softinputMode = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SOFTINPUT_MODE, this.softinputMode);
            if (jSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_UNINVIEW)) {
                this.mUniNViewJson = jSONObject.optJSONObject(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_UNINVIEW);
            }
            if (jSONObject.has("replacewebapi")) {
                org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("replacewebapi");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("geolocation")) {
                    this.mGeoInject = jSONObjectOptJSONObject.optString("geolocation", this.mGeoInject);
                }
            } else if (jSONObject.has("geolocation")) {
                this.mGeoInject = jSONObject.optString("geolocation", this.mGeoInject);
            }
            this.mProgressJson = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject, "progress");
            org.json.JSONObject jSONObject2 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_DEBUG_REFRESH);
            this.mDebugRefresh = jSONObject2;
            if (jSONObject2 != null && jSONObject2.has("arguments")) {
                this.mUniPageUrl = io.dcloud.common.util.JSONUtil.createJSONObject(this.mDebugRefresh.optString("arguments"));
            }
            if (jSONObject.has("uniPageUrl")) {
                this.mUniPageUrl = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject, "uniPageUrl");
            }
            java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject, "bounce");
            if ("vertical".equalsIgnoreCase(string) || com.taobao.weex.common.Constants.Value.HORIZONTAL.equalsIgnoreCase(string) || "all".equalsIgnoreCase(string)) {
                this.mBounce = true;
            } else {
                this.mBounce = false;
            }
            this.mVideoFullscree = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_VIDEO_FULL_SCREEN);
            setBackButtonAutoControl(jSONObject);
            if (jSONObject.has("titleNView")) {
                this.titleNView = io.dcloud.common.util.JSONUtil.combinJSONObject(this.titleNView, io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject, "titleNView"));
            } else if (jSONObject.has("navigationbar")) {
                this.titleNView = io.dcloud.common.util.JSONUtil.combinJSONObject(this.titleNView, io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject, "navigationbar"));
            }
            if (jSONObject.has(io.dcloud.common.constant.AbsoluteConst.EVENTS_PULL_TO_REFRESH)) {
                this.mPullToRefresh = io.dcloud.common.util.JSONUtil.combinJSONObject(this.mPullToRefresh, io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject, io.dcloud.common.constant.AbsoluteConst.EVENTS_PULL_TO_REFRESH));
            }
            if (jSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SUB_NVIEWS)) {
                this.mSubNViews = io.dcloud.common.util.JSONUtil.getJSONArray(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SUB_NVIEWS);
            }
            if (jSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ANIMATION_OPTIMIZATION) && "auto".equals(jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ANIMATION_OPTIMIZATION))) {
                this.isAnimationOptimization = true;
            }
        }
        return zUpdateViewData;
    }
}
