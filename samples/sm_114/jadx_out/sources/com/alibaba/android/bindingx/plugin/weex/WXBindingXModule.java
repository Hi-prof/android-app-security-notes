package com.alibaba.android.bindingx.plugin.weex;

/* JADX INFO: loaded from: classes.dex */
public class WXBindingXModule extends com.taobao.weex.WXSDKEngine.DestroyableModule {
    private com.alibaba.android.bindingx.core.BindingXCore mBindingXCore;
    private com.alibaba.android.bindingx.core.PlatformManager mPlatformManager;

    public WXBindingXModule() {
    }

    WXBindingXModule(com.alibaba.android.bindingx.core.BindingXCore bindingXCore) {
        this.mBindingXCore = bindingXCore;
    }

    private void prepareInternal() {
        if (this.mPlatformManager == null) {
            this.mPlatformManager = createPlatformManager(this.mWXSDKInstance);
        }
        if (this.mBindingXCore == null) {
            com.alibaba.android.bindingx.core.BindingXCore bindingXCore = new com.alibaba.android.bindingx.core.BindingXCore(this.mPlatformManager);
            this.mBindingXCore = bindingXCore;
            bindingXCore.registerEventHandler("scroll", new com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator<com.alibaba.android.bindingx.core.IEventHandler, android.content.Context, com.alibaba.android.bindingx.core.PlatformManager>() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.1
                @Override // com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator
                public com.alibaba.android.bindingx.core.IEventHandler createWith(android.content.Context context, com.alibaba.android.bindingx.core.PlatformManager platformManager, java.lang.Object... objArr) {
                    return new com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler(context, platformManager, objArr);
                }
            });
            this.mBindingXCore.registerEventHandler("pan", new com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator<com.alibaba.android.bindingx.core.IEventHandler, android.content.Context, com.alibaba.android.bindingx.core.PlatformManager>() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.2
                @Override // com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator
                public com.alibaba.android.bindingx.core.IEventHandler createWith(android.content.Context context, com.alibaba.android.bindingx.core.PlatformManager platformManager, java.lang.Object... objArr) {
                    return new com.alibaba.android.bindingx.plugin.weex.BindingXGestureHandler(context, platformManager, objArr);
                }
            });
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void prepare(java.util.Map<java.lang.String, java.lang.Object> map) {
        prepareInternal();
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public java.util.Map<java.lang.String, java.lang.String> bind(java.util.Map<java.lang.String, java.lang.Object> map, final com.taobao.weex.bridge.JSCallback jSCallback) {
        prepareInternal();
        com.alibaba.android.bindingx.core.BindingXCore bindingXCore = this.mBindingXCore;
        android.content.Context context = this.mWXSDKInstance == null ? null : this.mWXSDKInstance.getContext();
        java.lang.String instanceId = this.mWXSDKInstance != null ? this.mWXSDKInstance.getInstanceId() : null;
        if (map == null) {
            map = java.util.Collections.EMPTY_MAP;
        }
        java.lang.String strDoBind = bindingXCore.doBind(context, instanceId, map, new com.alibaba.android.bindingx.core.BindingXCore.JavaScriptCallback() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.3
            @Override // com.alibaba.android.bindingx.core.BindingXCore.JavaScriptCallback
            public void callback(java.lang.Object obj) {
                if (jSCallback != null) {
                    android.util.Log.e("触发去往前端的回调", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK);
                    jSCallback.invokeAndKeepAlive(obj);
                }
            }
        }, new java.lang.Object[0]);
        java.util.HashMap map2 = new java.util.HashMap(2);
        map2.put(com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_TOKEN, strDoBind);
        return map2;
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void bindAsync(java.util.Map<java.lang.String, java.lang.Object> map, com.taobao.weex.bridge.JSCallback jSCallback, com.taobao.weex.bridge.JSCallback jSCallback2) {
        java.util.Map<java.lang.String, java.lang.String> mapBind = bind(map, jSCallback);
        if (jSCallback2 == null || mapBind == null) {
            return;
        }
        jSCallback2.invoke(mapBind);
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void unbind(java.util.Map<java.lang.String, java.lang.Object> map) {
        com.alibaba.android.bindingx.core.BindingXCore bindingXCore = this.mBindingXCore;
        if (bindingXCore != null) {
            bindingXCore.doUnbind(map);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void unbindAll() {
        com.alibaba.android.bindingx.core.BindingXCore bindingXCore = this.mBindingXCore;
        if (bindingXCore != null) {
            bindingXCore.doRelease();
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public java.util.List<java.lang.String> supportFeatures() {
        return java.util.Arrays.asList("pan", "orientation", com.alibaba.android.bindingx.core.BindingXEventType.TYPE_TIMING, "scroll", "experimentalGestureFeatures");
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void getComputedStyleAsync(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback) {
        java.util.Map<java.lang.String, java.lang.Object> computedStyle = getComputedStyle(str);
        if (jSCallback != null) {
            jSCallback.invoke(computedStyle);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x01e4  */
    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public java.util.Map<java.lang.String, java.lang.Object> getComputedStyle(java.lang.String str) {
        char c;
        double d;
        double d2;
        double d3;
        double d4;
        char c2;
        android.text.Layout textLayout;
        java.lang.CharSequence text;
        android.text.style.ForegroundColorSpan[] foregroundColorSpanArr;
        int color;
        prepareInternal();
        com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator resolutionTranslator = this.mPlatformManager.getResolutionTranslator();
        com.taobao.weex.ui.component.WXComponent wXComponentFindComponentByRef = com.alibaba.android.bindingx.plugin.weex.WXModuleUtils.findComponentByRef(this.mWXSDKInstance.getInstanceId(), str);
        if (wXComponentFindComponentByRef == null) {
            return java.util.Collections.EMPTY_MAP;
        }
        android.view.View hostView = wXComponentFindComponentByRef.getHostView();
        if (hostView == null) {
            return java.util.Collections.EMPTY_MAP;
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put("width", java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getLayoutWidth(), new java.lang.Object[0])));
        map.put("height", java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getLayoutHeight(), new java.lang.Object[0])));
        map.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_PADDING_LEFT, java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getPadding().get(io.dcloud.feature.uniapp.dom.AbsCSSShorthand.EDGE.LEFT), new java.lang.Object[0])));
        map.put("padding-top", java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getPadding().get(io.dcloud.feature.uniapp.dom.AbsCSSShorthand.EDGE.TOP), new java.lang.Object[0])));
        map.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_PADDING_RIGHT, java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getPadding().get(io.dcloud.feature.uniapp.dom.AbsCSSShorthand.EDGE.RIGHT), new java.lang.Object[0])));
        map.put("padding-bottom", java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getPadding().get(io.dcloud.feature.uniapp.dom.AbsCSSShorthand.EDGE.BOTTOM), new java.lang.Object[0])));
        map.put("margin-left", java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getMargin().get(io.dcloud.feature.uniapp.dom.AbsCSSShorthand.EDGE.LEFT), new java.lang.Object[0])));
        map.put("margin-top", java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getMargin().get(io.dcloud.feature.uniapp.dom.AbsCSSShorthand.EDGE.TOP), new java.lang.Object[0])));
        map.put("margin-right", java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getMargin().get(io.dcloud.feature.uniapp.dom.AbsCSSShorthand.EDGE.RIGHT), new java.lang.Object[0])));
        map.put("margin-bottom", java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(wXComponentFindComponentByRef.getMargin().get(io.dcloud.feature.uniapp.dom.AbsCSSShorthand.EDGE.BOTTOM), new java.lang.Object[0])));
        map.put("translateX", java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(hostView.getTranslationX(), new java.lang.Object[0])));
        map.put("translateY", java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(hostView.getTranslationY(), new java.lang.Object[0])));
        map.put("rotateX", java.lang.Float.valueOf(com.alibaba.android.bindingx.core.internal.Utils.normalizeRotation(hostView.getRotationX())));
        map.put("rotateY", java.lang.Float.valueOf(com.alibaba.android.bindingx.core.internal.Utils.normalizeRotation(hostView.getRotationY())));
        map.put(com.taobao.weex.ui.animation.TransformParser.WX_ROTATE_Z, java.lang.Float.valueOf(com.alibaba.android.bindingx.core.internal.Utils.normalizeRotation(hostView.getRotation())));
        map.put("scaleX", java.lang.Float.valueOf(hostView.getScaleX()));
        map.put("scaleY", java.lang.Float.valueOf(hostView.getScaleY()));
        map.put("opacity", java.lang.Float.valueOf(hostView.getAlpha()));
        android.graphics.drawable.Drawable background = hostView.getBackground();
        if (background == null || !(background instanceof com.taobao.weex.ui.view.border.BorderDrawable)) {
            c = 2;
            d = 0.0d;
            d2 = 0.0d;
            d3 = 0.0d;
            d4 = 0.0d;
        } else {
            float[] borderRadius = ((com.taobao.weex.ui.view.border.BorderDrawable) background).getBorderRadius(new android.graphics.RectF(0.0f, 0.0f, hostView.getWidth(), hostView.getHeight()));
            if (borderRadius.length == 8) {
                double d5 = borderRadius[0];
                double d6 = borderRadius[2];
                double d7 = borderRadius[6];
                c = 2;
                d3 = borderRadius[4];
                d = d6;
                d4 = d5;
                d2 = d7;
            } else {
                c = 2;
                d = 0.0d;
                d2 = 0.0d;
                d3 = 0.0d;
                d4 = 0.0d;
            }
        }
        map.put("border-top-left-radius", java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(d4, new java.lang.Object[0])));
        map.put("border-top-right-radius", java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(d, new java.lang.Object[0])));
        map.put("border-bottom-left-radius", java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(d2, new java.lang.Object[0])));
        map.put("border-bottom-right-radius", java.lang.Double.valueOf(resolutionTranslator.nativeToWeb(d3, new java.lang.Object[0])));
        if (hostView.getBackground() != null) {
            if (hostView.getBackground() instanceof android.graphics.drawable.ColorDrawable) {
                color = ((android.graphics.drawable.ColorDrawable) hostView.getBackground()).getColor();
            } else {
                color = hostView.getBackground() instanceof com.taobao.weex.ui.view.border.BorderDrawable ? ((com.taobao.weex.ui.view.border.BorderDrawable) hostView.getBackground()).getColor() : -16777216;
            }
            double dAlpha = ((double) android.graphics.Color.alpha(color)) / 255.0d;
            int iRed = android.graphics.Color.red(color);
            int iGreen = android.graphics.Color.green(color);
            int iBlue = android.graphics.Color.blue(color);
            c2 = 3;
            java.util.Locale locale = java.util.Locale.getDefault();
            java.lang.Integer numValueOf = java.lang.Integer.valueOf(iRed);
            java.lang.Integer numValueOf2 = java.lang.Integer.valueOf(iGreen);
            java.lang.Integer numValueOf3 = java.lang.Integer.valueOf(iBlue);
            java.lang.Double dValueOf = java.lang.Double.valueOf(dAlpha);
            java.lang.Object[] objArr = new java.lang.Object[4];
            objArr[0] = numValueOf;
            objArr[1] = numValueOf2;
            objArr[c] = numValueOf3;
            objArr[3] = dValueOf;
            map.put("background-color", java.lang.String.format(locale, "rgba(%d,%d,%d,%f)", objArr));
        } else {
            c2 = 3;
        }
        if ((wXComponentFindComponentByRef instanceof com.taobao.weex.ui.component.WXText) && (hostView instanceof com.taobao.weex.ui.view.WXTextView) && (textLayout = ((com.taobao.weex.ui.view.WXTextView) hostView).getTextLayout()) != null && (text = textLayout.getText()) != null && (text instanceof android.text.SpannableString) && (foregroundColorSpanArr = (android.text.style.ForegroundColorSpan[]) ((android.text.SpannableString) text).getSpans(0, text.length(), android.text.style.ForegroundColorSpan.class)) != null && foregroundColorSpanArr.length == 1) {
            int foregroundColor = foregroundColorSpanArr[0].getForegroundColor();
            double dAlpha2 = ((double) android.graphics.Color.alpha(foregroundColor)) / 255.0d;
            int iRed2 = android.graphics.Color.red(foregroundColor);
            int iGreen2 = android.graphics.Color.green(foregroundColor);
            int iBlue2 = android.graphics.Color.blue(foregroundColor);
            java.util.Locale locale2 = java.util.Locale.getDefault();
            java.lang.Integer numValueOf4 = java.lang.Integer.valueOf(iRed2);
            java.lang.Integer numValueOf5 = java.lang.Integer.valueOf(iGreen2);
            java.lang.Integer numValueOf6 = java.lang.Integer.valueOf(iBlue2);
            java.lang.Double dValueOf2 = java.lang.Double.valueOf(dAlpha2);
            java.lang.Object[] objArr2 = new java.lang.Object[4];
            objArr2[0] = numValueOf4;
            objArr2[1] = numValueOf5;
            objArr2[c] = numValueOf6;
            objArr2[c2] = dValueOf2;
            map.put("color", java.lang.String.format(locale2, "rgba(%d,%d,%d,%f)", objArr2));
        }
        return map;
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.this.mBindingXCore != null) {
                    com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.this.mBindingXCore.doRelease();
                    com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.this.mBindingXCore = null;
                }
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.clearCallbacks();
            }
        }, null);
    }

    static com.alibaba.android.bindingx.core.PlatformManager createPlatformManager(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        final int instanceViewPortWidth = wXSDKInstance == null ? 750 : wXSDKInstance.getInstanceViewPortWidth();
        return new com.alibaba.android.bindingx.core.PlatformManager.Builder().withViewFinder(new com.alibaba.android.bindingx.core.PlatformManager.IViewFinder() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.7
            @Override // com.alibaba.android.bindingx.core.PlatformManager.IViewFinder
            public android.view.View findViewBy(java.lang.String str, java.lang.Object... objArr) {
                if (objArr.length <= 0) {
                    return null;
                }
                java.lang.Object obj = objArr[0];
                if (obj instanceof java.lang.String) {
                    return com.alibaba.android.bindingx.plugin.weex.WXModuleUtils.findViewByRef((java.lang.String) obj, str);
                }
                return null;
            }
        }).withViewUpdater(new com.alibaba.android.bindingx.core.PlatformManager.IViewUpdater() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.6
            @Override // com.alibaba.android.bindingx.core.PlatformManager.IViewUpdater
            public void synchronouslyUpdateViewOnUIThread(android.view.View view, java.lang.String str, java.lang.Object obj, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.Object... objArr) {
                if (objArr == null || objArr.length < 2) {
                    return;
                }
                java.lang.Object obj2 = objArr[0];
                if (obj2 instanceof java.lang.String) {
                    java.lang.Object obj3 = objArr[1];
                    if (obj3 instanceof java.lang.String) {
                        java.lang.String str2 = (java.lang.String) obj2;
                        java.lang.String str3 = (java.lang.String) obj3;
                        com.taobao.weex.ui.component.WXComponent wXComponentFindComponentByRef = com.alibaba.android.bindingx.plugin.weex.WXModuleUtils.findComponentByRef(str3, str2);
                        if (wXComponentFindComponentByRef == null) {
                            com.alibaba.android.bindingx.core.LogProxy.e("unexpected error. component not found [ref:" + str2 + ",instanceId:" + str3 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
                            return;
                        }
                        com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.findUpdater(str).update(wXComponentFindComponentByRef, view, obj, iDeviceResolutionTranslator, map);
                    }
                }
            }
        }).withDeviceResolutionTranslator(new com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.5
            @Override // com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator
            public double webToNative(double d, java.lang.Object... objArr) {
                return com.taobao.weex.utils.WXViewUtils.getRealPxByWidth((float) d, instanceViewPortWidth);
            }

            @Override // com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator
            public double nativeToWeb(double d, java.lang.Object... objArr) {
                return com.taobao.weex.utils.WXViewUtils.getWebPxByWidth((float) d, instanceViewPortWidth);
            }
        }).build();
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityPause() {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.8
            @Override // java.lang.Runnable
            public void run() {
                if (com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.this.mBindingXCore != null) {
                    com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.this.mBindingXCore.onActivityPause();
                }
            }
        }, null);
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityResume() {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.9
            @Override // java.lang.Runnable
            public void run() {
                if (com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.this.mBindingXCore != null) {
                    com.alibaba.android.bindingx.plugin.weex.WXBindingXModule.this.mBindingXCore.onActivityResume();
                }
            }
        }, null);
    }
}
