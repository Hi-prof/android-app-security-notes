package io.dcloud.feature.weex;

/* JADX INFO: loaded from: classes2.dex */
public class WeexFeature extends io.dcloud.common.DHInterface.StandardFeature implements io.dcloud.common.DHInterface.IWaiter, io.dcloud.common.DHInterface.ReceiveSystemEventVoucher {
    boolean isRegisterAllEvent = false;
    io.dcloud.common.DHInterface.IApp mApp;

    @Override // io.dcloud.common.DHInterface.StandardFeature, io.dcloud.common.DHInterface.BaseFeature, io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        super.init(absMgr, str);
        io.dcloud.feature.weex.WeexInstanceMgr.self().init(absMgr);
    }

    @Override // io.dcloud.common.DHInterface.BaseFeature, io.dcloud.common.DHInterface.IBoot
    public void onStart(android.content.Context context, android.os.Bundle bundle, java.lang.String[] strArr) {
        super.onStart(context, bundle, strArr);
        if (context instanceof android.app.Application) {
            io.dcloud.feature.weex.WeexInstanceMgr.self().initWeexEnv((android.app.Application) context);
        }
    }

    @Override // io.dcloud.common.DHInterface.BaseFeature, io.dcloud.common.DHInterface.IBoot
    public void onResume() {
        super.onResume();
        io.dcloud.feature.weex.WeexInstanceMgr.self().onActivityResume();
    }

    @Override // io.dcloud.common.DHInterface.BaseFeature, io.dcloud.common.DHInterface.IBoot
    public void onPause() {
        super.onPause();
        io.dcloud.feature.weex.WeexInstanceMgr.self().onActivityPause();
    }

    @Override // io.dcloud.common.DHInterface.BaseFeature
    protected void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        io.dcloud.feature.weex.WeexInstanceMgr.self().onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onDestroy() {
        io.dcloud.common.DHInterface.IApp iApp = this.mApp;
        if (iApp != null && iApp.getQuitModel() == 2) {
            io.dcloud.feature.weex.WeexInstanceMgr.self().onActivityDestroy(false);
        } else {
            io.dcloud.feature.weex.WeexInstanceMgr.self().onActivityDestroy();
        }
        io.dcloud.feature.weex.WeexInstanceMgr.self().setUniServiceCreated(false, null);
    }

    @Override // io.dcloud.common.DHInterface.BaseFeature
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        io.dcloud.feature.weex.WeexInstanceMgr.self().onActivityResult(i, i2, intent);
    }

    public void registerAllEvent(io.dcloud.common.DHInterface.IApp iApp) {
        this.mApp = iApp;
        if (this.isRegisterAllEvent) {
            return;
        }
        this.isRegisterAllEvent = true;
        unregisterSysEvent(iApp);
        registerSysEvent(this.mApp);
    }

    @Override // io.dcloud.common.DHInterface.BaseFeature, io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
        super.dispose(str);
        if (this.mApp != null) {
            onDestroy();
            if (this.isRegisterAllEvent) {
                unregisterSysEvent(this.mApp);
                this.isRegisterAllEvent = false;
                this.mApp = null;
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.IWaiter
    public java.lang.Object doForFeature(java.lang.String str, java.lang.Object obj) {
        com.alibaba.fastjson.JSONObject registerJsModules;
        com.taobao.weex.WXSDKInstance wXSDKInstanceFindWXSDKInstance;
        io.dcloud.feature.weex.WXBaseWrapper wXBaseWrapperFindWXBaseWrapper;
        str.hashCode();
        switch (str) {
            case "onKeyboardHeightChange":
                java.lang.Object[] objArr = (java.lang.Object[]) obj;
                java.lang.String str2 = (java.lang.String) objArr[0];
                int iIntValue = ((java.lang.Integer) objArr[1]).intValue();
                io.dcloud.feature.weex.WXBaseWrapper wXBaseWrapperFindWXBaseWrapper2 = io.dcloud.feature.weex.WeexInstanceMgr.self().findWXBaseWrapper(str2);
                if (wXBaseWrapperFindWXBaseWrapper2 != null) {
                    int scale = (int) (iIntValue / wXBaseWrapperFindWXBaseWrapper2.mWebview.getScale());
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("height", java.lang.Integer.valueOf(scale));
                    wXBaseWrapperFindWXBaseWrapper2.fireGlobalEvent("KeyboardHeightChange", map);
                    break;
                }
                break;
            case "setUniNViewModuleReladyCallBack":
                io.dcloud.feature.weex.WeexInstanceMgr.self().setUniNViewModuleReladyCallBack((io.dcloud.common.DHInterface.ICallBack) ((java.lang.Object[]) obj)[0]);
                return null;
            case "updateReload":
                io.dcloud.feature.weex.WXViewWrapper wXViewWrapperFindPathByWrapper = io.dcloud.feature.weex.WeexInstanceMgr.self().findPathByWrapper((java.lang.String) ((java.lang.Object[]) obj)[0]);
                if (wXViewWrapperFindPathByWrapper == null) {
                    return null;
                }
                wXViewWrapperFindPathByWrapper.reload();
                return null;
            case "findWebviewByInstanceId":
                break;
            case "getUniNViewModules":
                java.lang.String uniNViewModules = io.dcloud.feature.weex.WeexInstanceMgr.self().getUniNViewModules();
                return (uniNViewModules != null || (registerJsModules = com.taobao.weex.bridge.WXModuleManager.getRegisterJsModules()) == null) ? uniNViewModules : registerJsModules.toJSONString();
            case "callNativeModuleSync":
                java.lang.Object[] objArr2 = (java.lang.Object[]) obj;
                java.lang.String str3 = (java.lang.String) objArr2[1];
                java.lang.String str4 = (java.lang.String) objArr2[2];
                java.lang.String str5 = (java.lang.String) objArr2[3];
                com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject((java.lang.String) objArr2[4]);
                if (io.dcloud.common.util.PdrUtil.isEmpty(str3)) {
                    str3 = str4;
                }
                if (str5.equalsIgnoreCase(str3)) {
                    wXSDKInstanceFindWXSDKInstance = io.dcloud.feature.weex.WeexInstanceMgr.self().findWXSDKInstance(str5);
                } else {
                    wXSDKInstanceFindWXSDKInstance = io.dcloud.feature.weex.WeexInstanceMgr.self().findWXSDKInstance(str3);
                }
                if (wXSDKInstanceFindWXSDKInstance != null) {
                    return callNativeModule(wXSDKInstanceFindWXSDKInstance.getInstanceId(), object);
                }
                return null;
            case "weexViewUpdate":
                java.lang.Object[] objArr3 = (java.lang.Object[]) obj;
                io.dcloud.common.DHInterface.IWebview iWebview = (io.dcloud.common.DHInterface.IWebview) objArr3[0];
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) objArr3[1];
                org.json.JSONObject jSONObject = (org.json.JSONObject) objArr3[2];
                java.lang.String strObtainAppId = (java.lang.String) objArr3[3];
                if (io.dcloud.common.util.PdrUtil.isEmpty(strObtainAppId)) {
                    strObtainAppId = iWebview.obtainApp().obtainAppId();
                }
                if (!jSONObject.has(io.dcloud.common.constant.AbsoluteConst.XML_PATH) || io.dcloud.common.util.PdrUtil.isEmpty(jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.XML_PATH))) {
                    return null;
                }
                io.dcloud.feature.weex.WXBaseWrapper wXBaseWrapperFindWXBaseWrapper3 = io.dcloud.feature.weex.WeexInstanceMgr.self().findWXBaseWrapper(strObtainAppId);
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                java.lang.String strOptString = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.XML_PATH);
                if (iWebview.isUniWebView()) {
                    ((io.dcloud.common.adapter.ui.AdaUniWebView) iWebview).setNVuePath(strOptString);
                }
                try {
                    jSONObject2.put("js", strOptString);
                    jSONObject2.put("data", jSONObject);
                    break;
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
                if (wXBaseWrapperFindWXBaseWrapper3 != null) {
                    wXBaseWrapperFindWXBaseWrapper3.loadTemplate(jSONObject2);
                    return null;
                }
                createUniNView(iWebview, viewGroup, strObtainAppId, jSONObject2);
                return null;
            case "postMessageToUniNView":
                java.lang.Object[] objArr4 = (java.lang.Object[]) obj;
                io.dcloud.common.DHInterface.IWebview iWebview2 = (io.dcloud.common.DHInterface.IWebview) objArr4[0];
                java.lang.String str6 = (java.lang.String) objArr4[1];
                java.lang.String str7 = (java.lang.String) objArr4[2];
                java.lang.String str8 = (java.lang.String) objArr4[3];
                com.alibaba.fastjson.JSONObject object2 = com.alibaba.fastjson.JSON.parseObject((java.lang.String) objArr4[4]);
                java.util.HashMap map2 = new java.util.HashMap();
                map2.put("targetId", str7);
                map2.put("originId", iWebview2.getWebviewUUID());
                map2.put("data", object2);
                if (io.dcloud.common.util.PdrUtil.isEmpty(str6)) {
                    str6 = str7;
                }
                if (str8.equalsIgnoreCase(str6)) {
                    wXBaseWrapperFindWXBaseWrapper = io.dcloud.feature.weex.WeexInstanceMgr.self().findWXBaseWrapper(str8);
                } else {
                    wXBaseWrapperFindWXBaseWrapper = io.dcloud.feature.weex.WeexInstanceMgr.self().findWXBaseWrapper(str6);
                }
                if (wXBaseWrapperFindWXBaseWrapper == null) {
                    return null;
                }
                wXBaseWrapperFindWXBaseWrapper.fireGlobalEvent("plusMessage", map2);
                return null;
            case "createUniNView":
                return createWeexWindow((java.lang.Object[]) obj);
            case "createServiceUniNView":
                return createWeexService((java.lang.Object[]) obj);
            case "updateServiceReload":
                io.dcloud.feature.weex.WeexInstanceMgr.self().reloadWXServiceWrapper();
                return null;
            default:
                return null;
        }
        return io.dcloud.feature.weex.WeexInstanceMgr.self().findWebviewByInstanceId((java.lang.String) ((java.lang.Object[]) obj)[0]);
    }

    private void createUniNView(io.dcloud.common.DHInterface.IWebview iWebview, android.view.ViewGroup viewGroup, java.lang.String str, org.json.JSONObject jSONObject) {
        createUniNView(iWebview, viewGroup, str, jSONObject, io.dcloud.feature.weex.WXBaseWrapper.DE_INDEX);
    }

    private void createUniNView(io.dcloud.common.DHInterface.IWebview iWebview, android.view.ViewGroup viewGroup, java.lang.String str, org.json.JSONObject jSONObject, int i) {
        io.dcloud.feature.weex.WeexInstanceMgr.self().createWeexView(iWebview, viewGroup, jSONObject, str, i);
    }

    private java.lang.Object createWeexWindow(java.lang.Object[] objArr) {
        io.dcloud.common.DHInterface.IWebview iWebview = (io.dcloud.common.DHInterface.IWebview) objArr[0];
        registerAllEvent(iWebview.obtainApp());
        return io.dcloud.feature.weex.WeexInstanceMgr.self().createWeexView(iWebview, (android.view.ViewGroup) objArr[1], (org.json.JSONObject) objArr[2], (java.lang.String) objArr[3], io.dcloud.feature.weex.WXViewWrapper.DE_INDEX);
    }

    private java.lang.Object createWeexService(java.lang.Object[] objArr) {
        io.dcloud.common.DHInterface.IApp iApp = (io.dcloud.common.DHInterface.IApp) objArr[0];
        registerAllEvent(iApp);
        org.json.JSONObject jSONObject = (org.json.JSONObject) objArr[1];
        return io.dcloud.feature.weex.WeexInstanceMgr.self().createWeexService(iApp, (android.view.ViewGroup) objArr[2], (java.lang.String) objArr[3], jSONObject);
    }

    public java.lang.String callNativeModule(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject) {
        java.lang.Object objCallNativeModule = com.taobao.weex.bridge.WXBridgeManager.getInstance().callNativeModule(str, jSONObject.getString("plugin"), jSONObject.getString("method"), com.alibaba.fastjson.JSON.parseArray(jSONObject.getString("args")), (com.alibaba.fastjson.JSONObject) null);
        if (objCallNativeModule != null) {
            if (objCallNativeModule instanceof com.alibaba.fastjson.JSONObject) {
                return io.dcloud.common.util.JSUtil.wrapJsVar(io.dcloud.common.util.JSONUtil.createJSONObject(((com.alibaba.fastjson.JSONObject) objCallNativeModule).toJSONString()));
            }
            if (objCallNativeModule instanceof java.util.HashMap) {
                return io.dcloud.common.util.JSUtil.wrapJsVar(io.dcloud.common.util.JSONUtil.createJSONObject(new com.alibaba.fastjson.JSONObject((java.util.HashMap) objCallNativeModule).toJSONString()));
            }
            if (objCallNativeModule instanceof com.alibaba.fastjson.JSONArray) {
                return io.dcloud.common.util.JSUtil.wrapJsVar(io.dcloud.common.util.JSONUtil.createJSONArray(((com.alibaba.fastjson.JSONArray) objCallNativeModule).toJSONString()));
            }
            if (objCallNativeModule instanceof java.lang.String) {
                return io.dcloud.common.util.JSUtil.wrapJsVar(java.lang.String.valueOf(objCallNativeModule));
            }
            if (objCallNativeModule instanceof org.json.JSONObject) {
                return io.dcloud.common.util.JSUtil.wrapJsVar((org.json.JSONObject) objCallNativeModule);
            }
            if (objCallNativeModule instanceof org.json.JSONArray) {
                return io.dcloud.common.util.JSUtil.wrapJsVar((org.json.JSONArray) objCallNativeModule);
            }
        }
        return io.dcloud.common.util.JSUtil.wrapJsVar("");
    }
}
