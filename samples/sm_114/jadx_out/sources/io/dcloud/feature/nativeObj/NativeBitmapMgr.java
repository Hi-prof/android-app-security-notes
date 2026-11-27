package io.dcloud.feature.nativeObj;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NativeBitmapMgr {
    private java.util.HashMap<java.lang.String, io.dcloud.common.DHInterface.INativeBitmap> mSnaps = new java.util.HashMap<>();
    private java.util.HashMap<java.lang.String, java.lang.String> mIds = new java.util.HashMap<>();
    protected java.util.LinkedHashMap<java.lang.String, io.dcloud.feature.nativeObj.NativeView> mNativeViews = new java.util.LinkedHashMap<>();
    public final java.lang.String SUCCESS_INFO = "{path:'file://%s', w:%d, h:%d, size:%d}";

    /* JADX INFO: renamed from: io.dcloud.feature.nativeObj.NativeBitmapMgr$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action;

        static {
            int[] iArr = new int[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.values().length];
            $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action = iArr;
            try {
                iArr[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.View.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.setStyle.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.addEventListener.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.interceptTouchEvent.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.setTouchEventRect.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.getViewById.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.evalWeexJS.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.drawRichText.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.drawBitmap.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.drawText.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.drawInput.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.getInputValueById.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.getInputFocusById.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.setInputFocusById.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.show.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.hide.ordinal()] = 16;
            } catch (java.lang.NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.view_close.ordinal()] = 17;
            } catch (java.lang.NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.view_animate.ordinal()] = 18;
            } catch (java.lang.NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.view_reset.ordinal()] = 19;
            } catch (java.lang.NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.view_restore.ordinal()] = 20;
            } catch (java.lang.NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.view_drawRect.ordinal()] = 21;
            } catch (java.lang.NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.isVisible.ordinal()] = 22;
            } catch (java.lang.NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.Bitmap.ordinal()] = 23;
            } catch (java.lang.NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.getItems.ordinal()] = 24;
            } catch (java.lang.NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.getBitmapById.ordinal()] = 25;
            } catch (java.lang.NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.clear.ordinal()] = 26;
            } catch (java.lang.NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.bitmapRecycle.ordinal()] = 27;
            } catch (java.lang.NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.load.ordinal()] = 28;
            } catch (java.lang.NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.loadBase64Data.ordinal()] = 29;
            } catch (java.lang.NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.save.ordinal()] = 30;
            } catch (java.lang.NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.toBase64Data.ordinal()] = 31;
            } catch (java.lang.NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.startAnimation.ordinal()] = 32;
            } catch (java.lang.NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.clearAnimation.ordinal()] = 33;
            } catch (java.lang.NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.view_clearRect.ordinal()] = 34;
            } catch (java.lang.NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.view_draw.ordinal()] = 35;
            } catch (java.lang.NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.setImages.ordinal()] = 36;
            } catch (java.lang.NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.addImages.ordinal()] = 37;
            } catch (java.lang.NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.currentImageIndex.ordinal()] = 38;
            } catch (java.lang.NoSuchFieldError unused38) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    protected enum Action {
        Bitmap,
        getItems,
        getBitmapById,
        clear,
        load,
        loadBase64Data,
        save,
        toBase64Data,
        View,
        startAnimation,
        clearAnimation,
        getViewById,
        drawBitmap,
        drawText,
        evalWeexJS,
        drawRichText,
        show,
        hide,
        setImages,
        addImages,
        view_animate,
        view_reset,
        view_restore,
        view_drawRect,
        isVisible,
        addEventListener,
        interceptTouchEvent,
        setTouchEventRect,
        bitmapRecycle,
        setStyle,
        view_clearRect,
        view_draw,
        view_close,
        currentImageIndex,
        drawInput,
        getInputValueById,
        getInputFocusById,
        setInputFocusById
    }

    private void createBitmap(io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = "" + java.lang.System.currentTimeMillis();
        }
        if (this.mSnaps.containsKey(str)) {
            return;
        }
        this.mSnaps.put(str, new io.dcloud.feature.nativeObj.NativeBitmap(iApp, str2, str, str3));
        this.mIds.put(str2, str);
    }

    private io.dcloud.feature.nativeObj.NativeView getNativeView(java.lang.String str, java.lang.String str2) {
        io.dcloud.feature.nativeObj.NativeView nativeView = this.mNativeViews.get(str2);
        if (nativeView == null && !android.text.TextUtils.isEmpty(str)) {
            for (io.dcloud.feature.nativeObj.NativeView nativeView2 : this.mNativeViews.values()) {
                if (android.text.TextUtils.equals(nativeView2.mID, str)) {
                    return nativeView2;
                }
            }
        }
        return nativeView;
    }

    private void load(final io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap, java.lang.String str, final java.lang.String str2) {
        nativeBitmap.load(iWebview, iWebview.obtainFrameView().obtainMainView().getContext(), str, android.text.TextUtils.isEmpty(str2) ? null : new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.nativeObj.NativeBitmapMgr.1
            @Override // io.dcloud.common.DHInterface.ICallBack
            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, null, io.dcloud.common.util.JSUtil.OK, false, false);
                return null;
            }
        }, android.text.TextUtils.isEmpty(str2) ? null : new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.nativeObj.NativeBitmapMgr.2
            @Override // io.dcloud.common.DHInterface.ICallBack
            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                java.lang.String string = obj == null ? iWebview.getContext().getString(io.dcloud.base.R.string.dcloud_native_obj_load_failed) : obj.toString();
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, "{\"code\":-100,\"message\":\"" + string + "\"}", io.dcloud.common.util.JSUtil.ERROR, true, false);
                return null;
            }
        });
    }

    private void loadBase64Data(final io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap, java.lang.String str, final java.lang.String str2) {
        nativeBitmap.loadBase64Data(str, android.text.TextUtils.isEmpty(str2) ? null : new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.nativeObj.NativeBitmapMgr.3
            @Override // io.dcloud.common.DHInterface.ICallBack
            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, null, io.dcloud.common.util.JSUtil.OK, false, false);
                return null;
            }
        }, android.text.TextUtils.isEmpty(str2) ? null : new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.nativeObj.NativeBitmapMgr.4
            @Override // io.dcloud.common.DHInterface.ICallBack
            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, "{\"code\":-100,\"message\":\"" + iWebview.getContext().getString(io.dcloud.base.R.string.dcloud_native_obj_load_failed) + "\"}", io.dcloud.common.util.JSUtil.ERROR, true, false);
                return null;
            }
        });
    }

    private void save(final io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap, java.lang.String str, org.json.JSONObject jSONObject, final java.lang.String str2) {
        nativeBitmap.save(iWebview.obtainFrameView().obtainApp(), str, new io.dcloud.feature.nativeObj.NativeBitmapSaveOptions(jSONObject.toString()), iWebview.getScale(), android.text.TextUtils.isEmpty(str2) ? null : new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.nativeObj.NativeBitmapMgr.5
            @Override // io.dcloud.common.DHInterface.ICallBack
            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                java.lang.String str3;
                if (obj == null || !(obj instanceof io.dcloud.feature.nativeObj.NativeBitmapSaveOptions)) {
                    str3 = null;
                } else {
                    io.dcloud.feature.nativeObj.NativeBitmapSaveOptions nativeBitmapSaveOptions = (io.dcloud.feature.nativeObj.NativeBitmapSaveOptions) obj;
                    str3 = io.dcloud.common.util.StringUtil.format("{path:'file://%s', w:%d, h:%d, size:%d}", nativeBitmapSaveOptions.path, java.lang.Integer.valueOf(nativeBitmapSaveOptions.width), java.lang.Integer.valueOf(nativeBitmapSaveOptions.height), java.lang.Long.valueOf(nativeBitmapSaveOptions.size));
                }
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, str3, io.dcloud.common.util.JSUtil.OK, true, false);
                return null;
            }
        }, android.text.TextUtils.isEmpty(str2) ? null : new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.nativeObj.NativeBitmapMgr.6
            @Override // io.dcloud.common.DHInterface.ICallBack
            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, "{\"code\":-100,\"message\":\"\"+webview.getContext().getString(R.string.dcloud_native_obj_load_failed)+\"\"}", io.dcloud.common.util.JSUtil.ERROR, true, false);
                return null;
            }
        });
    }

    public void destroy() {
        try {
            java.util.Iterator<io.dcloud.common.DHInterface.INativeBitmap> it = this.mSnaps.values().iterator();
            while (it.hasNext()) {
                try {
                    it.next().clear();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            this.mIds.clear();
            this.mSnaps.clear();
            for (io.dcloud.feature.nativeObj.NativeView nativeView : this.mNativeViews.values()) {
                if (nativeView != null) {
                    nativeView.clearNativeViewData();
                }
            }
            this.mNativeViews.clear();
            io.dcloud.feature.nativeObj.NativeTypefaceFactory.clearCache();
            java.lang.System.gc();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public void destroyNativeView(io.dcloud.feature.nativeObj.NativeView nativeView) {
        io.dcloud.feature.nativeObj.NativeView nativeView2 = this.mNativeViews.get(nativeView.mUUID);
        nativeView.clearNativeViewData();
        if (nativeView2 == nativeView) {
            this.mNativeViews.remove(nativeView.mUUID);
        } else {
            this.mNativeViews.remove(nativeView.mID);
        }
    }

    public java.lang.Object doForFeature(java.lang.String str, java.lang.Object obj) {
        io.dcloud.feature.nativeObj.NativeView nativeView;
        if ("addNativeView".equals(str)) {
            java.lang.Object[] objArr = (java.lang.Object[]) obj;
            io.dcloud.common.DHInterface.IFrameView iFrameView = (io.dcloud.common.DHInterface.IFrameView) objArr[0];
            java.lang.String str2 = (java.lang.String) objArr[1];
            io.dcloud.feature.nativeObj.NativeView nativeView2 = getNativeView(str2, str2);
            io.dcloud.common.adapter.util.Logger.d("adadad", "addNativeView outter" + nativeView2);
            if (nativeView2 != null) {
                io.dcloud.common.adapter.util.Logger.d("adadad", "addNativeView inner" + iFrameView);
                nativeView2.attachToViewGroup(iFrameView);
                return null;
            }
        } else if ("removeNativeView".equals(str)) {
            java.lang.String str3 = (java.lang.String) ((java.lang.Object[]) obj)[1];
            io.dcloud.feature.nativeObj.NativeView nativeView3 = getNativeView(str3, str3);
            if (nativeView3 != null) {
                nativeView3.removeFromViewGroup();
                return null;
            }
        } else if ("getNativeView".equals(str)) {
            try {
                java.lang.Object[] objArr2 = (java.lang.Object[]) obj;
                java.lang.String str4 = (java.lang.String) objArr2[1];
                return getNativeView(str4, str4);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } else {
            if ("makeRichText".equals(str)) {
                return io.dcloud.feature.nativeObj.richtext.RichTextLayout.makeRichText((java.lang.Object[]) obj);
            }
            if ("View".equals(str)) {
                try {
                    java.lang.Object[] objArr3 = (java.lang.Object[]) obj;
                    io.dcloud.common.DHInterface.IWebview iWebview = (io.dcloud.common.DHInterface.IWebview) objArr3[1];
                    java.lang.String str5 = (java.lang.String) objArr3[2];
                    java.lang.String str6 = (java.lang.String) objArr3[3];
                    org.json.JSONObject jSONObject = (org.json.JSONObject) objArr3[4];
                    if (jSONObject == null) {
                        jSONObject = new org.json.JSONObject();
                    }
                    org.json.JSONObject jSONObject2 = jSONObject;
                    org.json.JSONArray jSONArray = objArr3.length > 5 ? (org.json.JSONArray) objArr3[5] : null;
                    java.lang.String str7 = io.dcloud.common.constant.AbsoluteConst.NATIVE_NVIEW;
                    if (objArr3.length > 6) {
                        str7 = (java.lang.String) objArr3[6];
                    }
                    if (!this.mNativeViews.containsKey(str6)) {
                        io.dcloud.feature.nativeObj.NativeView nativeImageSlider = str7.equals(io.dcloud.common.constant.AbsoluteConst.NATIVE_IMAGESLIDER) ? new io.dcloud.feature.nativeObj.NativeImageSlider(iWebview.getContext(), iWebview, str6, str5, jSONObject2) : io.dcloud.common.constant.AbsoluteConst.NATIVE_TITLE_N_VIEW.equals(str7) ? new io.dcloud.feature.nativeObj.TitleNView(iWebview.getContext(), iWebview, str6, str5, jSONObject2) : new io.dcloud.feature.nativeObj.NativeView(iWebview.getContext(), iWebview, str6, str5, jSONObject2);
                        this.mNativeViews.put(nativeImageSlider.mUUID, nativeImageSlider);
                        initViewDrawItme(iWebview, nativeImageSlider, jSONArray);
                        return nativeImageSlider;
                    }
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            } else if ("updateSubNViews".equals(str)) {
                java.lang.Object[] objArr4 = (java.lang.Object[]) obj;
                io.dcloud.common.DHInterface.IWebview iWebview2 = (io.dcloud.common.DHInterface.IWebview) objArr4[1];
                org.json.JSONArray jSONArray2 = (org.json.JSONArray) objArr4[2];
                io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = (io.dcloud.common.adapter.ui.AdaFrameView) iWebview2.obtainFrameView();
                for (int i = 0; i < jSONArray2.length(); i++) {
                    try {
                        org.json.JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                        java.lang.String strOptString = jSONObject3.optString("id");
                        if (!io.dcloud.common.util.PdrUtil.isEmpty(strOptString)) {
                            java.util.ArrayList<io.dcloud.common.DHInterface.INativeView> arrayList = adaFrameView.mChildNativeViewList;
                            int size = arrayList.size();
                            int i2 = 0;
                            while (true) {
                                if (i2 >= size) {
                                    nativeView = null;
                                    break;
                                }
                                io.dcloud.common.DHInterface.INativeView iNativeView = arrayList.get(i2);
                                i2++;
                                io.dcloud.common.DHInterface.INativeView iNativeView2 = iNativeView;
                                if (strOptString.equals(iNativeView2.getViewId())) {
                                    nativeView = (io.dcloud.feature.nativeObj.NativeView) iNativeView2;
                                    break;
                                }
                            }
                            if (nativeView != null) {
                                org.json.JSONArray jSONArrayOptJSONArray = jSONObject3.optJSONArray("tags");
                                nativeView.setStyle(jSONObject3.optJSONObject("styles"), jSONArrayOptJSONArray == null);
                                initViewDrawItme(iWebview2, nativeView, jSONArrayOptJSONArray);
                            }
                        }
                    } catch (org.json.JSONException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:112:0x028b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r4v6, types: [io.dcloud.common.DHInterface.AbsMgr, io.dcloud.common.DHInterface.IMgr] */
    /* JADX WARN: Type inference failed for: r6v6 */
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        io.dcloud.feature.nativeObj.NativeBitmapMgr.Action actionValueOf;
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2;
        int iStringToColor;
        org.json.JSONObject jSONObject3;
        org.json.JSONArray jSONArray;
        io.dcloud.feature.nativeObj.NativeView nativeView;
        io.dcloud.common.DHInterface.IWebview iWebview2;
        org.json.JSONObject jSONObject4;
        org.json.JSONObject jSONObject5;
        org.json.JSONObject jSONObject6;
        io.dcloud.feature.nativeObj.NativeBitmap srcNativeBitmap;
        org.json.JSONObject jSONObject7;
        org.json.JSONObject jSONObject8;
        org.json.JSONObject jSONObject9;
        org.json.JSONObject jSONObject10;
        org.json.JSONObject jSONObject11;
        org.json.JSONObject jSONObject12;
        java.lang.String str2;
        java.lang.String strWrapJsVar;
        io.dcloud.feature.nativeObj.NativeBitmapMgr nativeBitmapMgr;
        java.lang.String strConvert2AbsFullPath;
        java.lang.String strOptString;
        java.lang.Object bitmapByUuid;
        java.lang.Object bitmapByUuid2;
        java.lang.String strOptString2;
        java.lang.String str3 = null;
        try {
            io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
            if (iAppObtainApp == null) {
                return null;
            }
            iAppObtainApp.obtainAppId();
            try {
                actionValueOf = io.dcloud.feature.nativeObj.NativeBitmapMgr.Action.valueOf(str);
            } catch (java.lang.Exception unused) {
                actionValueOf = null;
            }
            ?? r12 = 3;
            boolean z = true;
            try {
                try {
                    try {
                        try {
                            switch (io.dcloud.feature.nativeObj.NativeBitmapMgr.AnonymousClass7.$SwitchMap$io$dcloud$feature$nativeObj$NativeBitmapMgr$Action[actionValueOf.ordinal()]) {
                                case 1:
                                    java.lang.String str4 = strArr[0];
                                    java.lang.String str5 = strArr[1];
                                    java.lang.String str6 = io.dcloud.common.constant.AbsoluteConst.NATIVE_NVIEW;
                                    if (strArr.length > 4) {
                                        str6 = strArr[4];
                                    }
                                    try {
                                        jSONObject3 = new org.json.JSONObject(strArr[2]);
                                        break;
                                    } catch (org.json.JSONException unused2) {
                                        jSONObject3 = new org.json.JSONObject();
                                    }
                                    if (strArr.length > 3) {
                                        try {
                                            jSONArray = new org.json.JSONArray(strArr[3]);
                                        } catch (org.json.JSONException unused3) {
                                            jSONArray = null;
                                        }
                                        break;
                                    } else {
                                        jSONArray = null;
                                    }
                                    if (this.mNativeViews.containsKey(str5)) {
                                        return null;
                                    }
                                    if (str6.equals(io.dcloud.common.constant.AbsoluteConst.NATIVE_IMAGESLIDER)) {
                                        nativeView = new io.dcloud.feature.nativeObj.NativeImageSlider(iWebview.getContext(), iWebview, str5, str4, jSONObject3);
                                        iWebview2 = iWebview;
                                    } else {
                                        iWebview2 = iWebview;
                                        nativeView = new io.dcloud.feature.nativeObj.NativeView(iWebview.getContext(), iWebview2, str5, str4, jSONObject3);
                                    }
                                    initViewDrawItme(iWebview2, nativeView, jSONArray);
                                    this.mNativeViews.put(nativeView.mUUID, nativeView);
                                    return null;
                                case 2:
                                    java.lang.String str7 = strArr[0];
                                    java.lang.String str8 = strArr[1];
                                    try {
                                        jSONObject4 = new org.json.JSONObject(strArr[2]);
                                        break;
                                    } catch (org.json.JSONException unused4) {
                                        jSONObject4 = new org.json.JSONObject();
                                    }
                                    io.dcloud.feature.nativeObj.NativeView nativeView2 = getNativeView(str7, str8);
                                    if (nativeView2 == null) {
                                        return null;
                                    }
                                    nativeView2.setStyle(jSONObject4, true);
                                    return null;
                                case 3:
                                    io.dcloud.feature.nativeObj.NativeView nativeView3 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView3 == null) {
                                        return null;
                                    }
                                    nativeView3.addEventListener(strArr[2], iWebview, strArr[3]);
                                    return null;
                                case 4:
                                    io.dcloud.feature.nativeObj.NativeView nativeView4 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView4 == null) {
                                        return null;
                                    }
                                    nativeView4.interceptTouchEvent(io.dcloud.common.util.PdrUtil.parseBoolean(strArr[2], true, false));
                                    return null;
                                case 5:
                                    io.dcloud.feature.nativeObj.NativeView nativeView5 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView5 == null) {
                                        return null;
                                    }
                                    java.lang.String str9 = strArr[2];
                                    if (android.text.TextUtils.isEmpty(str9) || str9.equals("null")) {
                                        return null;
                                    }
                                    nativeView5.setTouchEventRect(str9);
                                    return null;
                                case 6:
                                    io.dcloud.feature.nativeObj.NativeView nativeView6 = getNativeView(strArr[0], strArr.length > 1 ? strArr[1] : null);
                                    if (nativeView6 != null) {
                                        return io.dcloud.common.util.JSUtil.wrapJsVar(nativeView6.toJSON());
                                    }
                                    return null;
                                case 7:
                                    java.lang.String str10 = strArr[0];
                                    java.lang.String str11 = strArr[1];
                                    iWebview.obtainFrameView().obtainWindowMgr().processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview.obtainApp(), "weex,io.dcloud.feature.weex.WeexFeature", "evalWeexJS", new java.lang.Object[]{iWebview, strArr[2], strArr[3], strArr[4]}});
                                    return null;
                                case 8:
                                    io.dcloud.feature.nativeObj.NativeView nativeView7 = getNativeView(strArr[0], strArr[1]);
                                    java.lang.String str12 = strArr[2];
                                    if (nativeView7 == null || android.text.TextUtils.isEmpty(str12)) {
                                        return null;
                                    }
                                    try {
                                        jSONObject5 = new org.json.JSONObject(strArr[3]);
                                        break;
                                    } catch (org.json.JSONException unused5) {
                                        jSONObject5 = new org.json.JSONObject();
                                    }
                                    try {
                                        jSONObject6 = new org.json.JSONObject(strArr[4]);
                                        break;
                                    } catch (org.json.JSONException unused6) {
                                        jSONObject6 = new org.json.JSONObject();
                                    }
                                    nativeView7.makeRichText(iWebview, str12, jSONObject5, jSONObject6, strArr[5]);
                                    return null;
                                case 9:
                                    io.dcloud.feature.nativeObj.NativeView nativeView8 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView8 != null && (srcNativeBitmap = getSrcNativeBitmap(iWebview, iAppObtainApp, strArr[2])) != null && srcNativeBitmap.getBitmap() != null) {
                                        try {
                                            jSONObject7 = new org.json.JSONObject(strArr[3]);
                                        } catch (org.json.JSONException unused7) {
                                            jSONObject7 = new org.json.JSONObject();
                                        }
                                        try {
                                            jSONObject8 = new org.json.JSONObject(strArr[4]);
                                        } catch (org.json.JSONException unused8) {
                                            jSONObject8 = new org.json.JSONObject();
                                        }
                                        nativeView8.makeOverlay(iWebview, srcNativeBitmap, null, -1, jSONObject7, jSONObject8, null, strArr[5], com.taobao.weex.ui.component.WXBasicComponentType.IMG, true);
                                        break;
                                    }
                                    return null;
                                case 10:
                                    io.dcloud.feature.nativeObj.NativeView nativeView9 = getNativeView(strArr[0], strArr[1]);
                                    java.lang.String str13 = strArr[2];
                                    if (nativeView9 != null && str13 != null) {
                                        try {
                                            jSONObject9 = new org.json.JSONObject(strArr[3]);
                                        } catch (org.json.JSONException unused9) {
                                            jSONObject9 = new org.json.JSONObject();
                                        }
                                        org.json.JSONObject jSONObject13 = jSONObject9;
                                        try {
                                            jSONObject10 = new org.json.JSONObject(strArr[4]);
                                        } catch (org.json.JSONException unused10) {
                                            jSONObject10 = new org.json.JSONObject();
                                        }
                                        nativeView9.makeOverlay(iWebview, null, str13, -1, null, jSONObject13, jSONObject10, strArr[5], io.dcloud.feature.uniapp.adapter.AbsURIAdapter.FONT, !io.dcloud.common.constant.AbsoluteConst.FALSE.equals(strArr[6]));
                                        break;
                                    }
                                    return null;
                                case 11:
                                    io.dcloud.feature.nativeObj.NativeView nativeView10 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView10 != null) {
                                        try {
                                            jSONObject11 = new org.json.JSONObject(strArr[2]);
                                        } catch (org.json.JSONException unused11) {
                                            jSONObject11 = new org.json.JSONObject();
                                        }
                                        org.json.JSONObject jSONObject14 = jSONObject11;
                                        try {
                                            jSONObject12 = new org.json.JSONObject(strArr[3]);
                                        } catch (org.json.JSONException unused12) {
                                            jSONObject12 = new org.json.JSONObject();
                                        }
                                        org.json.JSONObject jSONObject15 = jSONObject12;
                                        try {
                                            str2 = strArr[4];
                                        } catch (java.lang.Exception unused13) {
                                            str2 = null;
                                        }
                                        nativeView10.makeOverlay(iWebview, null, null, -1, null, jSONObject14, jSONObject15, str2, "input", true);
                                        break;
                                    }
                                    return null;
                                case 12:
                                    io.dcloud.feature.nativeObj.NativeView nativeView11 = getNativeView(strArr[0], strArr[1]);
                                    java.lang.String str14 = strArr[2];
                                    if (nativeView11 != null) {
                                        strWrapJsVar = io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(nativeView11.getInputValueById(str14), true);
                                        str3 = strWrapJsVar;
                                    }
                                    return str3;
                                case 13:
                                    io.dcloud.feature.nativeObj.NativeView nativeView12 = getNativeView(strArr[0], strArr[1]);
                                    java.lang.String str15 = strArr[2];
                                    if (nativeView12 != null) {
                                        strWrapJsVar = io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(nativeView12.getInputFocusById(str15)), false);
                                        str3 = strWrapJsVar;
                                    }
                                    return str3;
                                case 14:
                                    io.dcloud.feature.nativeObj.NativeView nativeView13 = getNativeView(strArr[0], strArr[1]);
                                    java.lang.String str16 = strArr[2];
                                    boolean zBooleanValue = 4 <= strArr.length ? java.lang.Boolean.valueOf(strArr[3]).booleanValue() : false;
                                    if (nativeView13 != null) {
                                        nativeView13.setInputFocusById(str16, zBooleanValue);
                                    }
                                    return str3;
                                case 15:
                                    io.dcloud.feature.nativeObj.NativeView nativeView14 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView14 != null) {
                                        nativeView14.setVisibility(0);
                                        android.view.ViewGroup viewGroup = (android.view.ViewGroup) iWebview.obtainApp().obtainWebAppRootView().obtainMainView().getParent();
                                        if (nativeView14.getParent() == null) {
                                            nativeView14.mShow = true;
                                            int childCount = viewGroup.getChildCount();
                                            for (int i = 0; i < childCount; i++) {
                                                if (viewGroup.getChildAt(i) instanceof io.dcloud.feature.internal.splash.ISplash) {
                                                    childCount = i;
                                                    viewGroup.addView(nativeView14, childCount);
                                                }
                                            }
                                            viewGroup.addView(nativeView14, childCount);
                                        }
                                    }
                                    return str3;
                                case 16:
                                    io.dcloud.feature.nativeObj.NativeView nativeView15 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView15 != null) {
                                        nativeView15.setVisibility(4);
                                        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) nativeView15.getParent();
                                        if (viewGroup2 != null && (viewGroup2 instanceof io.dcloud.common.adapter.ui.DHImageView)) {
                                            io.dcloud.common.adapter.ui.DHImageView dHImageView = (io.dcloud.common.adapter.ui.DHImageView) viewGroup2;
                                            dHImageView.clear();
                                            dHImageView.setVisibility(4);
                                        }
                                    }
                                    return str3;
                                case 17:
                                    java.lang.String str17 = strArr[0];
                                    java.lang.String str18 = strArr[1];
                                    io.dcloud.feature.nativeObj.NativeView nativeView16 = getNativeView(str17, str18);
                                    if (nativeView16 != null) {
                                        this.mNativeViews.remove(str18);
                                        nativeView16.removeFromViewGroup();
                                    }
                                    return str3;
                                case 18:
                                    io.dcloud.feature.nativeObj.NativeView nativeView17 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView17 != null) {
                                        nativeView17.StartAnimate(iWebview, strArr[2], strArr[3]);
                                    }
                                    return str3;
                                case 19:
                                    nativeBitmapMgr = this;
                                    io.dcloud.feature.nativeObj.NativeView nativeView18 = nativeBitmapMgr.getNativeView(strArr[0], strArr[1]);
                                    if (nativeView18 != null) {
                                        nativeView18.resetNativeView();
                                    }
                                    return null;
                                case 20:
                                    nativeBitmapMgr = this;
                                    io.dcloud.feature.nativeObj.NativeView nativeView19 = nativeBitmapMgr.getNativeView(strArr[0], strArr[1]);
                                    if (nativeView19 != null) {
                                        nativeView19.clearAnimate();
                                    }
                                    return null;
                                case 21:
                                    try {
                                        io.dcloud.feature.nativeObj.NativeView nativeView20 = getNativeView(strArr[0], strArr[1]);
                                        if (nativeView20 != null) {
                                            java.lang.String strOptString3 = io.dcloud.common.util.TitleNViewUtil.TRANSPARENT_BUTTON_TEXT_COLOR;
                                            if (!io.dcloud.common.util.PdrUtil.isEmpty(strArr[2])) {
                                                try {
                                                    jSONObject = new org.json.JSONObject(strArr[2]);
                                                    try {
                                                        if (jSONObject.has("color")) {
                                                            strOptString3 = jSONObject.optString("color");
                                                        }
                                                    } catch (org.json.JSONException e) {
                                                        e = e;
                                                        e.printStackTrace();
                                                        strOptString3 = strArr[2];
                                                    }
                                                } catch (org.json.JSONException e2) {
                                                    e = e2;
                                                    jSONObject = null;
                                                }
                                                jSONObject2 = jSONObject;
                                                break;
                                            } else {
                                                jSONObject2 = null;
                                            }
                                            java.lang.String str19 = strArr[3];
                                            org.json.JSONObject jSONObject16 = (android.text.TextUtils.isEmpty(str19) || str19.equals("null")) ? null : new org.json.JSONObject(str19);
                                            java.lang.String str20 = strArr[4];
                                            try {
                                                iStringToColor = android.graphics.Color.parseColor(strOptString3);
                                                break;
                                            } catch (java.lang.Exception unused14) {
                                                iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(strOptString3);
                                            }
                                            nativeView20.makeOverlay(iWebview, null, null, iStringToColor, null, jSONObject16, jSONObject2, str20, "rect", !io.dcloud.common.constant.AbsoluteConst.FALSE.equals(strArr[5]));
                                            return null;
                                        }
                                        return str3;
                                    } catch (java.lang.Exception e3) {
                                        e = e3;
                                        r12 = this;
                                        io.dcloud.common.adapter.util.Logger.e("NativeBitmapMgr", e.toString());
                                        e.printStackTrace();
                                        return null;
                                    }
                                case 22:
                                    io.dcloud.feature.nativeObj.NativeView nativeView21 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView21 == null || nativeView21.getParent() == null) {
                                        strWrapJsVar = io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(false), false);
                                    } else {
                                        if (nativeView21.getVisibility() != 0) {
                                            z = false;
                                        }
                                        strWrapJsVar = io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(z), false);
                                    }
                                    str3 = strWrapJsVar;
                                    return str3;
                                case 23:
                                    if (strArr.length > 2) {
                                        strConvert2AbsFullPath = strArr[2];
                                        if (!io.dcloud.common.util.PdrUtil.isNetPath(strConvert2AbsFullPath)) {
                                            if (android.text.TextUtils.isEmpty(strConvert2AbsFullPath) || strConvert2AbsFullPath.equals("null")) {
                                                strConvert2AbsFullPath = null;
                                            } else {
                                                strConvert2AbsFullPath = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strConvert2AbsFullPath);
                                            }
                                        }
                                    } else {
                                        strConvert2AbsFullPath = null;
                                    }
                                    createBitmap(iAppObtainApp, strArr[0], strArr[1], strConvert2AbsFullPath);
                                    return str3;
                                case 24:
                                    strWrapJsVar = io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(getItems().toString(), false);
                                    str3 = strWrapJsVar;
                                    return str3;
                                case 25:
                                    io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap = (io.dcloud.feature.nativeObj.NativeBitmap) getBitmapById(strArr[0]);
                                    strWrapJsVar = io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(nativeBitmap != null ? nativeBitmap.toJsString() : null, false);
                                    str3 = strWrapJsVar;
                                    return str3;
                                case 26:
                                    io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap2 = (io.dcloud.feature.nativeObj.NativeBitmap) getBitmapByUuid(strArr[0]);
                                    this.mSnaps.remove(this.mIds.get(nativeBitmap2.getId()));
                                    this.mIds.remove(nativeBitmap2.getId());
                                    nativeBitmap2.clear();
                                    return str3;
                                case 27:
                                    io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap3 = (io.dcloud.feature.nativeObj.NativeBitmap) getBitmapByUuid(strArr[0]);
                                    if (nativeBitmap3 != null) {
                                        nativeBitmap3.recycle();
                                    }
                                    return str3;
                                case 28:
                                    io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap4 = (io.dcloud.feature.nativeObj.NativeBitmap) getBitmapByUuid(strArr[0]);
                                    java.lang.String str21 = strArr[1];
                                    java.lang.String str22 = strArr[2];
                                    if (nativeBitmap4 != null) {
                                        load(iWebview, nativeBitmap4, str21, str22);
                                    }
                                    return str3;
                                case 29:
                                    io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap5 = (io.dcloud.feature.nativeObj.NativeBitmap) getBitmapByUuid(strArr[0]);
                                    java.lang.String str23 = strArr[1];
                                    java.lang.String str24 = strArr[2];
                                    if (nativeBitmap5 != null) {
                                        loadBase64Data(iWebview, nativeBitmap5, str23, str24);
                                    }
                                    return str3;
                                case 30:
                                    io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap6 = (io.dcloud.feature.nativeObj.NativeBitmap) getBitmapByUuid(strArr[0]);
                                    java.lang.String str25 = strArr[1];
                                    org.json.JSONObject jSONObject17 = new org.json.JSONObject(strArr[2]);
                                    java.lang.String str26 = strArr[3];
                                    java.lang.String strConvert2AbsFullPath2 = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), str25);
                                    if (nativeBitmap6 != null) {
                                        save(iWebview, nativeBitmap6, strConvert2AbsFullPath2, jSONObject17, str26);
                                    }
                                    return str3;
                                case 31:
                                    io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap7 = (io.dcloud.feature.nativeObj.NativeBitmap) getBitmapByUuid(strArr[0]);
                                    strWrapJsVar = io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(nativeBitmap7 != null ? nativeBitmap7.toBase64Data() : null, true);
                                    str3 = strWrapJsVar;
                                    return str3;
                                case 32:
                                    java.lang.String str27 = strArr[0];
                                    java.lang.String str28 = strArr[1];
                                    java.lang.String str29 = strArr.length > 2 ? strArr[2] : null;
                                    java.lang.String str30 = strArr.length > 3 ? strArr[3] : null;
                                    org.json.JSONObject jSONObject18 = new org.json.JSONObject(str28);
                                    java.lang.String strOptString4 = jSONObject18.optString("viewId", null);
                                    if (android.text.TextUtils.isEmpty(strOptString4)) {
                                        strOptString = jSONObject18.optString("texts", null);
                                        bitmapByUuid = getBitmapByUuid(jSONObject18.optString("uuid", null));
                                    } else if (this.mNativeViews.containsKey(strOptString4)) {
                                        bitmapByUuid = this.mNativeViews.get(strOptString4);
                                        this.mNativeViews.get(strOptString4).mShow = true;
                                        strOptString = null;
                                    } else {
                                        strOptString = null;
                                        bitmapByUuid = null;
                                    }
                                    if (android.text.TextUtils.isEmpty(str29) || str29.equals("null")) {
                                        bitmapByUuid2 = null;
                                        strOptString2 = null;
                                    } else {
                                        org.json.JSONObject jSONObject19 = new org.json.JSONObject(str29);
                                        java.lang.String strOptString5 = jSONObject19.optString("viewId", null);
                                        if (android.text.TextUtils.isEmpty(strOptString5)) {
                                            strOptString2 = jSONObject19.optString("texts", null);
                                            bitmapByUuid2 = getBitmapByUuid(jSONObject19.optString("uuid", null));
                                        } else {
                                            io.dcloud.feature.nativeObj.NativeView nativeView22 = this.mNativeViews.get(strOptString5);
                                            this.mNativeViews.get(strOptString5).mShow = true;
                                            bitmapByUuid2 = nativeView22;
                                            strOptString2 = null;
                                        }
                                    }
                                    io.dcloud.common.adapter.ui.FrameSwitchView frameSwitchView = io.dcloud.common.adapter.ui.FrameSwitchView.getInstance(iAppObtainApp.getActivity());
                                    if (!frameSwitchView.isInit()) {
                                        frameSwitchView.initView();
                                    }
                                    frameSwitchView.startAnimation(iWebview, str27, bitmapByUuid, strOptString, bitmapByUuid2, strOptString2, str30);
                                    return str3;
                                case 33:
                                    io.dcloud.common.adapter.ui.FrameSwitchView frameSwitchView2 = io.dcloud.common.adapter.ui.FrameSwitchView.getInstance(iAppObtainApp.getActivity());
                                    if (!frameSwitchView2.isInit()) {
                                        frameSwitchView2.initView();
                                    }
                                    frameSwitchView2.clearSwitchAnimation(strArr[0]);
                                    return str3;
                                case 34:
                                    io.dcloud.feature.nativeObj.NativeView nativeView23 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView23 != null) {
                                        java.lang.String str31 = strArr[2];
                                        nativeView23.makeOverlay(iWebview, null, null, -1, null, (android.text.TextUtils.isEmpty(str31) || str31.equals("null")) ? null : new org.json.JSONObject(str31), null, strArr[3], "clear", false, true);
                                        return null;
                                    }
                                    return str3;
                                case 35:
                                    io.dcloud.feature.nativeObj.NativeView nativeView24 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView24 != null) {
                                        initViewDrawItme(iWebview, nativeView24, new org.json.JSONArray(strArr[2]));
                                    }
                                    return str3;
                                case 36:
                                    java.lang.String str32 = strArr[0];
                                    java.lang.String str33 = strArr[1];
                                    java.lang.String str34 = strArr[2];
                                    io.dcloud.feature.nativeObj.NativeView nativeView25 = getNativeView(str32, str33);
                                    if (!io.dcloud.common.util.PdrUtil.isEmpty(str34) && nativeView25 != null && nativeView25.getViewType().equals(io.dcloud.common.constant.AbsoluteConst.NATIVE_IMAGESLIDER)) {
                                        ((io.dcloud.feature.nativeObj.NativeImageSlider) nativeView25).setImages(iWebview, new org.json.JSONArray(str34));
                                    }
                                    return str3;
                                case 37:
                                    java.lang.String str35 = strArr[0];
                                    java.lang.String str36 = strArr[1];
                                    java.lang.String str37 = strArr[2];
                                    io.dcloud.feature.nativeObj.NativeView nativeView26 = getNativeView(str35, str36);
                                    if (!io.dcloud.common.util.PdrUtil.isEmpty(str37) && nativeView26 != null && nativeView26.getViewType().equals(io.dcloud.common.constant.AbsoluteConst.NATIVE_IMAGESLIDER)) {
                                        ((io.dcloud.feature.nativeObj.NativeImageSlider) nativeView26).addImages(iWebview, new org.json.JSONArray(str37));
                                    }
                                    return str3;
                                case 38:
                                    io.dcloud.feature.nativeObj.NativeView nativeView27 = getNativeView(strArr[0], strArr[1]);
                                    if (nativeView27 != null && nativeView27.getViewType().equals(io.dcloud.common.constant.AbsoluteConst.NATIVE_IMAGESLIDER)) {
                                        strWrapJsVar = java.lang.String.valueOf(((io.dcloud.feature.nativeObj.NativeImageSlider) nativeView27).getCurrentImageIndex());
                                        str3 = strWrapJsVar;
                                    }
                                    return str3;
                                default:
                                    return str3;
                            }
                        } catch (java.lang.Exception e4) {
                            e = e4;
                        }
                    } catch (org.json.JSONException | java.lang.Exception unused15) {
                    }
                } catch (java.lang.Exception e5) {
                    e = e5;
                    io.dcloud.common.adapter.util.Logger.e("NativeBitmapMgr", e.toString());
                    e.printStackTrace();
                    return null;
                }
            } catch (java.lang.Exception e6) {
                e = e6;
                io.dcloud.common.adapter.util.Logger.e("NativeBitmapMgr", e.toString());
                e.printStackTrace();
                return null;
            }
        } catch (java.lang.Exception e7) {
            e = e7;
        }
    }

    public io.dcloud.common.DHInterface.INativeBitmap getBitmapById(java.lang.String str) {
        return getBitmapByUuid(this.mIds.get(str));
    }

    public io.dcloud.common.DHInterface.INativeBitmap getBitmapByUuid(java.lang.String str) {
        return this.mSnaps.get(str);
    }

    public org.json.JSONArray getItems() {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<java.util.Map.Entry<java.lang.String, io.dcloud.common.DHInterface.INativeBitmap>> it = this.mSnaps.entrySet().iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(new org.json.JSONObject(((io.dcloud.feature.nativeObj.NativeBitmap) it.next().getValue()).toJsString()));
            } catch (java.lang.Exception unused) {
            }
        }
        return jSONArray;
    }

    public io.dcloud.feature.nativeObj.NativeBitmap getSrcNativeBitmap(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.common.DHInterface.IApp iApp, java.lang.String str) {
        org.json.JSONObject jSONObject;
        try {
            jSONObject = new org.json.JSONObject(str);
        } catch (org.json.JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return (io.dcloud.feature.nativeObj.NativeBitmap) getBitmapById(jSONObject.optString("id"));
        }
        if (!io.dcloud.common.util.PdrUtil.isNetPath(str)) {
            str = (android.text.TextUtils.isEmpty(str) || str.equals("null")) ? null : iApp.convert2AbsFullPath(iWebview.obtainFullUrl(), str);
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return null;
        }
        java.lang.String str2 = iApp.obtainAppId() + str.hashCode();
        return new io.dcloud.feature.nativeObj.NativeBitmap(iApp, str2, str2, str);
    }

    protected void initViewDrawItme(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.feature.nativeObj.NativeView nativeView, org.json.JSONArray jSONArray) {
        java.lang.String str;
        int i;
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2;
        int iStringToColor;
        org.json.JSONObject jSONObject3;
        org.json.JSONObject jSONObject4;
        org.json.JSONObject jSONObject5;
        org.json.JSONObject jSONObject6;
        io.dcloud.common.DHInterface.IWebview iWebview2 = iWebview;
        org.json.JSONArray jSONArray2 = jSONArray;
        java.lang.String str2 = "color";
        if (jSONArray2 == null || nativeView == null) {
            return;
        }
        int i2 = 0;
        while (i2 < jSONArray2.length()) {
            try {
                org.json.JSONObject jSONObject7 = jSONArray2.getJSONObject(i2);
                org.json.JSONObject jSONObjectOptJSONObject = null;
                java.lang.String strOptString = jSONObject7.has("id") ? jSONObject7.optString("id") : null;
                java.lang.String strOptString2 = jSONObject7.optString("tag");
                if (strOptString2.equals(com.taobao.weex.ui.component.WXBasicComponentType.IMG)) {
                    io.dcloud.feature.nativeObj.NativeBitmap srcNativeBitmap = getSrcNativeBitmap(iWebview2, iWebview2.obtainApp(), jSONObject7.optString("src"));
                    try {
                        jSONObject5 = new org.json.JSONObject(jSONObject7.optString("sprite"));
                    } catch (org.json.JSONException unused) {
                        jSONObject5 = new org.json.JSONObject();
                    }
                    try {
                        jSONObject6 = new org.json.JSONObject(jSONObject7.optString("position"));
                    } catch (org.json.JSONException unused2) {
                        jSONObject6 = new org.json.JSONObject();
                    }
                    i = i2;
                    str = str2;
                    nativeView.makeOverlay(iWebview2, srcNativeBitmap, null, -1, jSONObject5, jSONObject6, null, strOptString, com.taobao.weex.ui.component.WXBasicComponentType.IMG, false, true);
                } else {
                    str = str2;
                    i = i2;
                    if (strOptString2.equals(io.dcloud.feature.uniapp.adapter.AbsURIAdapter.FONT)) {
                        java.lang.String strOptString3 = jSONObject7.optString("text");
                        if (strOptString3 != null) {
                            try {
                                jSONObject3 = new org.json.JSONObject(jSONObject7.optString("position"));
                            } catch (org.json.JSONException unused3) {
                                jSONObject3 = new org.json.JSONObject();
                            }
                            org.json.JSONObject jSONObject8 = jSONObject3;
                            try {
                                jSONObject4 = new org.json.JSONObject(jSONObject7.optString("textStyles"));
                            } catch (org.json.JSONException unused4) {
                                jSONObject4 = new org.json.JSONObject();
                            }
                            nativeView.makeOverlay(iWebview, null, strOptString3, -1, null, jSONObject8, jSONObject4, strOptString, io.dcloud.feature.uniapp.adapter.AbsURIAdapter.FONT, false, true);
                        }
                    } else if (strOptString2.equals("rect")) {
                        java.lang.String strOptString4 = io.dcloud.common.util.TitleNViewUtil.TRANSPARENT_BUTTON_TEXT_COLOR;
                        if (jSONObject7.has(str)) {
                            strOptString4 = jSONObject7.optString(str);
                        }
                        java.lang.String strOptString5 = jSONObject7.optString("position");
                        org.json.JSONObject jSONObject9 = (android.text.TextUtils.isEmpty(strOptString5) || strOptString5.equals("null")) ? null : new org.json.JSONObject(strOptString5);
                        if (jSONObject7.has("rectStyles")) {
                            jSONObjectOptJSONObject = jSONObject7.optJSONObject("rectStyles");
                            if (jSONObjectOptJSONObject.has(str)) {
                                strOptString4 = jSONObjectOptJSONObject.optString(str);
                            }
                        }
                        org.json.JSONObject jSONObject10 = jSONObjectOptJSONObject;
                        try {
                            iStringToColor = android.graphics.Color.parseColor(strOptString4);
                        } catch (java.lang.Exception unused5) {
                            iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(strOptString4);
                        }
                        nativeView.makeOverlay(iWebview, null, null, iStringToColor, null, jSONObject9, jSONObject10, strOptString, "rect", false, true);
                    } else {
                        if (strOptString2.equals(com.taobao.weex.ui.component.WXBasicComponentType.RICHTEXT)) {
                            java.lang.String strOptString6 = jSONObject7.optString("text");
                            java.lang.String strOptString7 = jSONObject7.optString("position");
                            nativeView.makeRichText(iWebview, strOptString6, (android.text.TextUtils.isEmpty(strOptString7) || strOptString7.equals("null")) ? null : new org.json.JSONObject(strOptString7), jSONObject7.has("richTextStyles") ? jSONObject7.optJSONObject("richTextStyles") : null, strOptString);
                        } else if (strOptString2.equals("input")) {
                            try {
                                jSONObject = new org.json.JSONObject(jSONObject7.optString("position"));
                            } catch (org.json.JSONException unused6) {
                                jSONObject = new org.json.JSONObject();
                            }
                            org.json.JSONObject jSONObject11 = jSONObject;
                            try {
                                jSONObject2 = new org.json.JSONObject(jSONObject7.optString("inputStyles"));
                            } catch (org.json.JSONException unused7) {
                                jSONObject2 = new org.json.JSONObject();
                            }
                            iWebview2 = iWebview;
                            nativeView.makeOverlay(iWebview2, null, null, -1, null, jSONObject11, jSONObject2, strOptString, "input", false, true);
                        } else {
                            iWebview2 = iWebview;
                            if (strOptString2.equals("weex")) {
                                nativeView.makeWeexView(iWebview2, jSONObject7, strOptString);
                            }
                        }
                        i2 = i + 1;
                        str2 = str;
                        jSONArray2 = jSONArray;
                    }
                }
                iWebview2 = iWebview;
                i2 = i + 1;
                str2 = str;
                jSONArray2 = jSONArray;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return;
            }
        }
        nativeView.nativeInvalidate(true);
    }
}
