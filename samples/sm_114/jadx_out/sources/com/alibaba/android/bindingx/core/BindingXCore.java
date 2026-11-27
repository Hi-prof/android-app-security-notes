package com.alibaba.android.bindingx.core;

/* JADX INFO: loaded from: classes.dex */
public class BindingXCore {
    private static final java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator<com.alibaba.android.bindingx.core.IEventHandler, android.content.Context, com.alibaba.android.bindingx.core.PlatformManager>> sGlobalEventHandlerCreatorMap = new java.util.HashMap(4);
    private java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.IEventHandler>> mBindingCouples;
    private final java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator<com.alibaba.android.bindingx.core.IEventHandler, android.content.Context, com.alibaba.android.bindingx.core.PlatformManager>> mInternalEventHandlerCreatorMap = new java.util.HashMap(8);
    private final com.alibaba.android.bindingx.core.PlatformManager mPlatformManager;

    public interface JavaScriptCallback {
        void callback(java.lang.Object obj);
    }

    public interface ObjectCreator<Type, ParamA, ParamB> {
        Type createWith(ParamA parama, ParamB paramb, java.lang.Object... objArr);
    }

    public BindingXCore(com.alibaba.android.bindingx.core.PlatformManager platformManager) {
        this.mPlatformManager = platformManager;
        registerEventHandler("pan", new com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator<com.alibaba.android.bindingx.core.IEventHandler, android.content.Context, com.alibaba.android.bindingx.core.PlatformManager>() { // from class: com.alibaba.android.bindingx.core.BindingXCore.1
            @Override // com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator
            public com.alibaba.android.bindingx.core.IEventHandler createWith(android.content.Context context, com.alibaba.android.bindingx.core.PlatformManager platformManager2, java.lang.Object... objArr) {
                return new com.alibaba.android.bindingx.core.internal.BindingXTouchHandler(context, platformManager2, objArr);
            }
        });
        registerEventHandler("orientation", new com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator<com.alibaba.android.bindingx.core.IEventHandler, android.content.Context, com.alibaba.android.bindingx.core.PlatformManager>() { // from class: com.alibaba.android.bindingx.core.BindingXCore.2
            @Override // com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator
            public com.alibaba.android.bindingx.core.IEventHandler createWith(android.content.Context context, com.alibaba.android.bindingx.core.PlatformManager platformManager2, java.lang.Object... objArr) {
                return new com.alibaba.android.bindingx.core.internal.BindingXOrientationHandler(context, platformManager2, objArr);
            }
        });
        registerEventHandler(com.alibaba.android.bindingx.core.BindingXEventType.TYPE_TIMING, new com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator<com.alibaba.android.bindingx.core.IEventHandler, android.content.Context, com.alibaba.android.bindingx.core.PlatformManager>() { // from class: com.alibaba.android.bindingx.core.BindingXCore.3
            @Override // com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator
            public com.alibaba.android.bindingx.core.IEventHandler createWith(android.content.Context context, com.alibaba.android.bindingx.core.PlatformManager platformManager2, java.lang.Object... objArr) {
                return new com.alibaba.android.bindingx.core.internal.BindingXTimingHandler(context, platformManager2, objArr);
            }
        });
    }

    public java.lang.String doBind(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, com.alibaba.android.bindingx.core.BindingXCore.JavaScriptCallback javaScriptCallback, java.lang.Object... objArr) {
        java.util.Map<java.lang.String, java.lang.Object> map2;
        java.lang.String stringValue = com.alibaba.android.bindingx.core.internal.Utils.getStringValue(map, com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_EVENT_TYPE);
        java.lang.String stringValue2 = com.alibaba.android.bindingx.core.internal.Utils.getStringValue(map, "instanceId");
        com.alibaba.android.bindingx.core.LogProxy.enableLogIfNeeded(map);
        java.lang.Object obj = map.get("options");
        if (obj == null || !(obj instanceof java.util.Map)) {
            map2 = null;
        } else {
            try {
                map2 = com.alibaba.android.bindingx.core.internal.Utils.toMap(new org.json.JSONObject((java.util.Map) obj));
            } catch (java.lang.Exception e) {
                com.alibaba.android.bindingx.core.LogProxy.e("parse external config failed.\n", e);
                map2 = null;
            }
        }
        com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair = com.alibaba.android.bindingx.core.internal.Utils.getExpressionPair(map, com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_EXIT_EXPRESSION);
        return doBind(com.alibaba.android.bindingx.core.internal.Utils.getStringValue(map, com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_ANCHOR), stringValue2, stringValue, map2, expressionPair, com.alibaba.android.bindingx.core.internal.Utils.getRuntimeProps(map), com.alibaba.android.bindingx.core.internal.Utils.getCustomInterceptors(map), javaScriptCallback, context, str, objArr);
    }

    public void doUnbind(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null) {
            return;
        }
        doUnbind(com.alibaba.android.bindingx.core.internal.Utils.getStringValue(map, com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_TOKEN), com.alibaba.android.bindingx.core.internal.Utils.getStringValue(map, com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_EVENT_TYPE));
    }

    public void doUnbind(java.lang.String str, java.lang.String str2) {
        com.alibaba.android.bindingx.core.LogProxy.d("disable binding [" + str + "," + str2 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.alibaba.android.bindingx.core.LogProxy.d("disable binding failed(0x1) [" + str + "," + str2 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            return;
        }
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.IEventHandler>> map = this.mBindingCouples;
        if (map == null || map.isEmpty()) {
            com.alibaba.android.bindingx.core.LogProxy.d("disable binding failed(0x2) [" + str + "," + str2 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            return;
        }
        java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.IEventHandler> map2 = this.mBindingCouples.get(str);
        if (map2 == null || map2.isEmpty()) {
            com.alibaba.android.bindingx.core.LogProxy.d("disable binding failed(0x3) [" + str + "," + str2 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            return;
        }
        com.alibaba.android.bindingx.core.IEventHandler iEventHandler = map2.get(str2);
        if (iEventHandler == null) {
            com.alibaba.android.bindingx.core.LogProxy.d("disable binding failed(0x4) [" + str + "," + str2 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            return;
        }
        if (iEventHandler.onDisable(str, str2)) {
            this.mBindingCouples.remove(str);
            com.alibaba.android.bindingx.core.LogProxy.d("disable binding success[" + str + "," + str2 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            return;
        }
        com.alibaba.android.bindingx.core.LogProxy.d("disabled failed(0x4) [" + str + "," + str2 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
    }

    public void doRelease() {
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.IEventHandler>> map = this.mBindingCouples;
        if (map != null) {
            try {
                for (java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.IEventHandler> map2 : map.values()) {
                    if (map2 != null && !map2.isEmpty()) {
                        for (com.alibaba.android.bindingx.core.IEventHandler iEventHandler : map2.values()) {
                            if (iEventHandler != null) {
                                iEventHandler.onDestroy();
                            }
                        }
                    }
                }
                this.mBindingCouples.clear();
                this.mBindingCouples = null;
            } catch (java.lang.Exception e) {
                com.alibaba.android.bindingx.core.LogProxy.e("release failed", e);
            }
        }
    }

    public java.lang.String doPrepare(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.alibaba.android.bindingx.core.IEventHandler iEventHandler;
        if (android.text.TextUtils.isEmpty(str4)) {
            com.alibaba.android.bindingx.core.LogProxy.e("[doPrepare] failed. can not found eventType");
            return null;
        }
        if (context == null) {
            com.alibaba.android.bindingx.core.LogProxy.e("[doPrepare] failed. context or wxInstance is null");
            return null;
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = generateToken();
        }
        if (this.mBindingCouples == null) {
            this.mBindingCouples = new java.util.HashMap();
        }
        java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.IEventHandler> map2 = this.mBindingCouples.get(str2);
        if (map2 != null && (iEventHandler = map2.get(str4)) != null) {
            com.alibaba.android.bindingx.core.LogProxy.d("you have already enabled binding,[token:" + str2 + ",type:" + str4 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            iEventHandler.onStart(str2, str4);
            com.alibaba.android.bindingx.core.LogProxy.d("enableBinding success.[token:" + str2 + ",type:" + str4 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            return str2;
        }
        if (map2 == null) {
            map2 = new java.util.HashMap<>(4);
            this.mBindingCouples.put(str2, map2);
        }
        com.alibaba.android.bindingx.core.IEventHandler iEventHandlerCreateEventHandler = createEventHandler(context, str, str4);
        if (iEventHandlerCreateEventHandler != null) {
            iEventHandlerCreateEventHandler.setAnchorInstanceId(str3);
            iEventHandlerCreateEventHandler.setToken(str2);
            iEventHandlerCreateEventHandler.setGlobalConfig(map);
            if (iEventHandlerCreateEventHandler.onCreate(str2, str4)) {
                iEventHandlerCreateEventHandler.onStart(str2, str4);
                map2.put(str4, iEventHandlerCreateEventHandler);
                com.alibaba.android.bindingx.core.LogProxy.d("enableBinding success.[token:" + str2 + ",type:" + str4 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
                return str2;
            }
            com.alibaba.android.bindingx.core.LogProxy.e("expression enabled failed. [token:" + str2 + ",type:" + str4 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            return null;
        }
        com.alibaba.android.bindingx.core.LogProxy.e("unknown eventType: " + str4);
        return null;
    }

    public java.lang.String doBind(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list, java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.internal.ExpressionPair> map2, com.alibaba.android.bindingx.core.BindingXCore.JavaScriptCallback javaScriptCallback, android.content.Context context, java.lang.String str4, java.lang.Object... objArr) {
        com.alibaba.android.bindingx.core.IEventHandler iEventHandler;
        java.lang.String str5;
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.IEventHandler>> map3;
        java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.IEventHandler> map4;
        java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.IEventHandler> map5;
        com.alibaba.android.bindingx.core.IEventHandler iEventHandler2 = null;
        if (android.text.TextUtils.isEmpty(str3) || list == null) {
            com.alibaba.android.bindingx.core.LogProxy.e("doBind failed,illegal argument.[" + str3 + "," + list + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            return null;
        }
        if (this.mBindingCouples != null && !android.text.TextUtils.isEmpty(str) && (map5 = this.mBindingCouples.get(str)) != null) {
            iEventHandler2 = map5.get(str3);
        }
        com.alibaba.android.bindingx.core.IEventHandler iEventHandler3 = iEventHandler2;
        if (iEventHandler3 == null) {
            com.alibaba.android.bindingx.core.LogProxy.d("binding not enabled,try auto enable it.[sourceRef:" + str + ",eventType:" + str3 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            java.lang.String strDoPrepare = doPrepare(context, str4, str, str2, str3, map);
            if (!android.text.TextUtils.isEmpty(strDoPrepare) && (map3 = this.mBindingCouples) != null && (map4 = map3.get(strDoPrepare)) != null) {
                iEventHandler3 = map4.get(str3);
            }
            iEventHandler = iEventHandler3;
            str5 = strDoPrepare;
        } else {
            iEventHandler = iEventHandler3;
            str5 = str;
        }
        if (iEventHandler != null) {
            iEventHandler.onBindExpression(str3, map, expressionPair, list, javaScriptCallback);
            com.alibaba.android.bindingx.core.LogProxy.d("createBinding success.[exitExp:" + expressionPair + ",args:" + list + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            iEventHandler.setInterceptors(map2);
            iEventHandler.setExtensionParams(objArr);
            return str5;
        }
        com.alibaba.android.bindingx.core.LogProxy.e("internal error.binding failed for ref:" + str + ",type:" + str3);
        return str5;
    }

    public void onActivityPause() {
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.IEventHandler>> map = this.mBindingCouples;
        if (map == null) {
            return;
        }
        try {
            java.util.Iterator<java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.IEventHandler>> it = map.values().iterator();
            while (it.hasNext()) {
                java.util.Iterator<com.alibaba.android.bindingx.core.IEventHandler> it2 = it.next().values().iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().onActivityPause();
                    } catch (java.lang.Exception e) {
                        com.alibaba.android.bindingx.core.LogProxy.e("execute activity pause failed.", e);
                    }
                }
            }
        } catch (java.lang.Exception e2) {
            com.alibaba.android.bindingx.core.LogProxy.e("activity pause failed", e2);
        }
    }

    public void onActivityResume() {
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.IEventHandler>> map = this.mBindingCouples;
        if (map == null) {
            return;
        }
        try {
            java.util.Iterator<java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.IEventHandler>> it = map.values().iterator();
            while (it.hasNext()) {
                java.util.Iterator<com.alibaba.android.bindingx.core.IEventHandler> it2 = it.next().values().iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().onActivityResume();
                    } catch (java.lang.Exception e) {
                        com.alibaba.android.bindingx.core.LogProxy.e("execute activity pause failed.", e);
                    }
                }
            }
        } catch (java.lang.Exception e2) {
            com.alibaba.android.bindingx.core.LogProxy.e("activity pause failed", e2);
        }
    }

    public void registerEventHandler(java.lang.String str, com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator<com.alibaba.android.bindingx.core.IEventHandler, android.content.Context, com.alibaba.android.bindingx.core.PlatformManager> objectCreator) {
        if (android.text.TextUtils.isEmpty(str) || objectCreator == null) {
            return;
        }
        this.mInternalEventHandlerCreatorMap.put(str, objectCreator);
    }

    public static void registerGlobalEventHandler(java.lang.String str, com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator<com.alibaba.android.bindingx.core.IEventHandler, android.content.Context, com.alibaba.android.bindingx.core.PlatformManager> objectCreator) {
        if (android.text.TextUtils.isEmpty(str) || objectCreator == null) {
            return;
        }
        sGlobalEventHandlerCreatorMap.put(str, objectCreator);
    }

    public static boolean unregisterGlobalEventHandler(java.lang.String str) {
        return sGlobalEventHandlerCreatorMap.remove(str) != null;
    }

    private java.lang.String generateToken() {
        return java.util.UUID.randomUUID().toString();
    }

    private com.alibaba.android.bindingx.core.IEventHandler createEventHandler(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (!this.mInternalEventHandlerCreatorMap.isEmpty() && this.mPlatformManager != null) {
            com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator<com.alibaba.android.bindingx.core.IEventHandler, android.content.Context, com.alibaba.android.bindingx.core.PlatformManager> objectCreator = this.mInternalEventHandlerCreatorMap.get(str2);
            if (objectCreator == null) {
                objectCreator = sGlobalEventHandlerCreatorMap.get(str2);
            }
            if (objectCreator != null) {
                return objectCreator.createWith(context, this.mPlatformManager, str);
            }
        }
        return null;
    }
}
