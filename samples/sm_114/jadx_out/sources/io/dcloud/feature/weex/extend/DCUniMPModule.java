package io.dcloud.feature.weex.extend;

/* JADX INFO: loaded from: classes2.dex */
public class DCUniMPModule extends io.dcloud.feature.uniapp.common.UniModule {
    @com.taobao.weex.annotation.JSMethod
    public void showUniMP(final java.lang.String str, final com.taobao.weex.bridge.JSCallback jSCallback) {
        io.dcloud.common.adapter.util.MessageHandler.post(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.extend.DCUniMPModule.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (io.dcloud.feature.internal.sdk.SDK.isUniMP) {
                        com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                        if (jSCallback2 != null) {
                            jSCallback2.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_NO_PERMISSION));
                            return;
                        }
                        return;
                    }
                    if (android.text.TextUtils.isEmpty(str)) {
                        com.taobao.weex.bridge.JSCallback jSCallback3 = jSCallback;
                        if (jSCallback3 != null) {
                            jSCallback3.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_INVALID_PARAMETER));
                            return;
                        }
                        return;
                    }
                    io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(io.dcloud.feature.weex.extend.DCUniMPModule.this.mWXSDKInstance);
                    if (iWebviewFindWebview != null) {
                        io.dcloud.feature.weex.WeexInstanceMgr.self().doForFeature(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebviewFindWebview.obtainApp(), io.dcloud.feature.weex.WeexInstanceMgr.self().getUniMPFeature(), "showUniMP", new java.lang.Object[]{str, new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.weex.extend.DCUniMPModule.1.1
                            @Override // io.dcloud.common.DHInterface.ICallBack
                            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                                java.util.HashMap map = new java.util.HashMap();
                                if (i >= 0) {
                                    map.put("type", com.taobao.weex.ui.component.WXImage.SUCCEED);
                                    map.put("code", 0);
                                } else {
                                    map.put("type", com.taobao.weex.common.Constants.Event.FAIL);
                                    map.put("code", java.lang.Integer.valueOf(i));
                                    map.put("message", obj != null ? obj.toString() : "Unknown error");
                                }
                                if (jSCallback == null) {
                                    return null;
                                }
                                jSCallback.invoke(map);
                                return null;
                            }
                        }}});
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @com.taobao.weex.annotation.JSMethod
    public void closeUniMP(final java.lang.String str, final com.taobao.weex.bridge.JSCallback jSCallback) {
        io.dcloud.common.adapter.util.MessageHandler.post(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.extend.DCUniMPModule.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (io.dcloud.feature.internal.sdk.SDK.isUniMP) {
                        com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                        if (jSCallback2 != null) {
                            jSCallback2.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_NO_PERMISSION));
                            return;
                        }
                        return;
                    }
                    if (android.text.TextUtils.isEmpty(str)) {
                        com.taobao.weex.bridge.JSCallback jSCallback3 = jSCallback;
                        if (jSCallback3 != null) {
                            jSCallback3.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_INVALID_PARAMETER));
                            return;
                        }
                        return;
                    }
                    io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(io.dcloud.feature.weex.extend.DCUniMPModule.this.mWXSDKInstance);
                    if (iWebviewFindWebview != null) {
                        io.dcloud.feature.weex.WeexInstanceMgr.self().doForFeature(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebviewFindWebview.obtainApp(), io.dcloud.feature.weex.WeexInstanceMgr.self().getUniMPFeature(), "closeUniMP", new java.lang.Object[]{str, new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.weex.extend.DCUniMPModule.2.1
                            @Override // io.dcloud.common.DHInterface.ICallBack
                            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                                java.util.HashMap map = new java.util.HashMap();
                                if (i >= 0) {
                                    map.put("type", com.taobao.weex.ui.component.WXImage.SUCCEED);
                                    map.put("code", 0);
                                } else {
                                    map.put("type", com.taobao.weex.common.Constants.Event.FAIL);
                                    map.put("code", java.lang.Integer.valueOf(i));
                                    map.put("message", obj != null ? obj.toString() : "Unknown error");
                                }
                                if (jSCallback == null) {
                                    return null;
                                }
                                jSCallback.invoke(map);
                                return null;
                            }
                        }}});
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @com.taobao.weex.annotation.JSMethod
    public void hideUniMP(final java.lang.String str, final com.taobao.weex.bridge.JSCallback jSCallback) {
        io.dcloud.common.adapter.util.MessageHandler.post(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.extend.DCUniMPModule.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (io.dcloud.feature.internal.sdk.SDK.isUniMP) {
                        com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                        if (jSCallback2 != null) {
                            jSCallback2.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_NO_PERMISSION));
                            return;
                        }
                        return;
                    }
                    if (android.text.TextUtils.isEmpty(str)) {
                        com.taobao.weex.bridge.JSCallback jSCallback3 = jSCallback;
                        if (jSCallback3 != null) {
                            jSCallback3.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_INVALID_PARAMETER));
                            return;
                        }
                        return;
                    }
                    io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(io.dcloud.feature.weex.extend.DCUniMPModule.this.mWXSDKInstance);
                    if (iWebviewFindWebview != null) {
                        io.dcloud.feature.weex.WeexInstanceMgr.self().doForFeature(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebviewFindWebview.obtainApp(), io.dcloud.feature.weex.WeexInstanceMgr.self().getUniMPFeature(), "hideUniMP", new java.lang.Object[]{str, new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.weex.extend.DCUniMPModule.3.1
                            @Override // io.dcloud.common.DHInterface.ICallBack
                            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                                java.util.HashMap map = new java.util.HashMap();
                                if (i >= 0) {
                                    map.put("type", com.taobao.weex.ui.component.WXImage.SUCCEED);
                                    map.put("code", 0);
                                } else {
                                    map.put("type", com.taobao.weex.common.Constants.Event.FAIL);
                                    map.put("code", java.lang.Integer.valueOf(i));
                                    map.put("message", obj != null ? obj.toString() : "Unknown error");
                                }
                                if (jSCallback == null) {
                                    return null;
                                }
                                jSCallback.invoke(map);
                                return null;
                            }
                        }}});
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @com.taobao.weex.annotation.JSMethod
    public void setDefaultMenuItems(java.lang.String str, final com.taobao.weex.bridge.JSCallback jSCallback) {
        com.alibaba.fastjson.JSONObject object;
        try {
            object = com.alibaba.fastjson.JSON.parseObject(str);
        } catch (java.lang.Exception unused) {
            object = null;
        }
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            return;
        }
        if (object == null) {
            if (jSCallback != null) {
                jSCallback.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_INVALID_PARAMETER));
            }
        } else {
            io.dcloud.common.DHInterface.ICallBack iCallBack = new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.weex.extend.DCUniMPModule.4
                @Override // io.dcloud.common.DHInterface.ICallBack
                public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                    com.alibaba.fastjson.JSONObject object2 = com.alibaba.fastjson.JSON.parseObject(java.lang.String.valueOf(obj));
                    java.lang.String string = object2.getString("appId");
                    java.lang.String string2 = object2.getString("id");
                    if (!android.text.TextUtils.isEmpty(string) && !android.text.TextUtils.isEmpty(string2)) {
                        java.util.HashMap map = new java.util.HashMap();
                        map.put("appId", string);
                        map.put("id", string2);
                        com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                        if (jSCallback2 != null) {
                            jSCallback2.invokeAndKeepAlive(map);
                        }
                    }
                    return null;
                }
            };
            io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(this.mWXSDKInstance);
            if (iWebviewFindWebview != null) {
                io.dcloud.feature.weex.WeexInstanceMgr.self().doForFeature(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebviewFindWebview.obtainApp(), io.dcloud.feature.weex.WeexInstanceMgr.self().getUniMPFeature(), "setDefaultMenuItems", new java.lang.Object[]{str, iCallBack}});
            }
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void openUniMP(final java.lang.String str, final com.taobao.weex.bridge.JSCallback jSCallback) {
        io.dcloud.common.adapter.util.MessageHandler.post(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.extend.DCUniMPModule.5
            @Override // java.lang.Runnable
            public void run() {
                com.alibaba.fastjson.JSONObject object;
                try {
                    object = com.alibaba.fastjson.JSON.parseObject(str);
                } catch (java.lang.Exception unused) {
                    object = null;
                }
                try {
                    if (io.dcloud.feature.internal.sdk.SDK.isUniMP) {
                        com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                        if (jSCallback2 != null) {
                            jSCallback2.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_NO_PERMISSION));
                            return;
                        }
                        return;
                    }
                    if (object == null) {
                        com.taobao.weex.bridge.JSCallback jSCallback3 = jSCallback;
                        if (jSCallback3 != null) {
                            jSCallback3.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_INVALID_PARAMETER));
                            return;
                        }
                        return;
                    }
                    io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(io.dcloud.feature.weex.extend.DCUniMPModule.this.mWXSDKInstance);
                    if (iWebviewFindWebview != null) {
                        io.dcloud.common.DHInterface.ICallBack iCallBack = new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.weex.extend.DCUniMPModule.5.1
                            @Override // io.dcloud.common.DHInterface.ICallBack
                            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                                java.util.HashMap map = new java.util.HashMap();
                                if (i >= 0) {
                                    map.put("type", com.taobao.weex.ui.component.WXImage.SUCCEED);
                                    map.put("code", 0);
                                } else {
                                    map.put("type", com.taobao.weex.common.Constants.Event.FAIL);
                                    map.put("code", java.lang.Integer.valueOf(i));
                                    map.put("message", obj != null ? obj.toString() : "Unknown error");
                                }
                                if (jSCallback == null) {
                                    return null;
                                }
                                jSCallback.invoke(map);
                                return null;
                            }
                        };
                        object.put("appInfo", (java.lang.Object) iWebviewFindWebview.obtainApp().obtainAppInfo());
                        io.dcloud.feature.weex.WeexInstanceMgr.self().doForFeature(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebviewFindWebview.obtainApp(), io.dcloud.feature.weex.WeexInstanceMgr.self().getUniMPFeature(), "openUniMP", new java.lang.Object[]{object.toJSONString(), iCallBack}});
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @com.taobao.weex.annotation.JSMethod
    public void installUniMP(java.lang.String str, final com.taobao.weex.bridge.JSCallback jSCallback) {
        com.alibaba.fastjson.JSONObject object;
        java.lang.String string;
        try {
            object = com.alibaba.fastjson.JSON.parseObject(str);
        } catch (java.lang.Exception unused) {
            object = null;
        }
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            if (jSCallback != null) {
                jSCallback.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_NO_PERMISSION));
                return;
            }
            return;
        }
        if (object == null) {
            if (jSCallback != null) {
                jSCallback.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_INVALID_PARAMETER));
                return;
            }
            return;
        }
        java.lang.String string2 = object.getString("appid");
        java.lang.String string3 = object.getString("wgtFile");
        if (!object.containsKey(com.taobao.weex.common.Constants.Value.PASSWORD)) {
            string = "";
        } else {
            string = object.getString(com.taobao.weex.common.Constants.Value.PASSWORD);
        }
        if (!android.text.TextUtils.isEmpty(string3)) {
            android.net.Uri uriRewriteUri = this.mUniSDKInstance.rewriteUri(android.net.Uri.parse(string3), "file");
            if (uriRewriteUri != null) {
                string3 = uriRewriteUri.getPath();
            }
        } else if (jSCallback != null) {
            jSCallback.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_NO_RESOURCE_EXIST));
        }
        io.dcloud.common.DHInterface.ICallBack iCallBack = new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.weex.extend.DCUniMPModule.6
            @Override // io.dcloud.common.DHInterface.ICallBack
            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                java.util.HashMap map = new java.util.HashMap();
                if (i >= 0) {
                    map.put("type", com.taobao.weex.ui.component.WXImage.SUCCEED);
                    map.put("code", 0);
                } else {
                    map.put("type", com.taobao.weex.common.Constants.Event.FAIL);
                    map.put("code", java.lang.Integer.valueOf(i));
                    map.put("message", obj != null ? obj.toString() : "Unknown error");
                }
                com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                if (jSCallback2 == null) {
                    return null;
                }
                jSCallback2.invoke(map);
                return null;
            }
        };
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(this.mWXSDKInstance);
        if (iWebviewFindWebview != null) {
            io.dcloud.feature.weex.WeexInstanceMgr.self().doForFeature(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebviewFindWebview.obtainApp(), io.dcloud.feature.weex.WeexInstanceMgr.self().getUniMPFeature(), "installUniMP", new java.lang.Object[]{string2, string3, string, iCallBack}});
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void sendUniMPEvent(java.lang.String str, java.lang.String str2, java.lang.String str3, final com.taobao.weex.bridge.JSCallback jSCallback) {
        java.lang.Object obj;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            if (jSCallback != null) {
                jSCallback.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_INVALID_PARAMETER));
                return;
            }
            return;
        }
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            if (jSCallback != null) {
                jSCallback.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_NO_PERMISSION));
                return;
            }
            return;
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str3);
        if (object != null) {
            obj = str3;
            obj = object;
        }
        obj = str3;
        io.dcloud.common.DHInterface.ICallBack iCallBack = new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.weex.extend.DCUniMPModule.7
            @Override // io.dcloud.common.DHInterface.ICallBack
            public java.lang.Object onCallBack(int i, java.lang.Object obj2) {
                java.util.HashMap map = new java.util.HashMap();
                if (i >= 0) {
                    map.put("type", com.taobao.weex.ui.component.WXImage.SUCCEED);
                    map.put("code", 0);
                } else {
                    map.put("type", com.taobao.weex.common.Constants.Event.FAIL);
                    map.put("code", java.lang.Integer.valueOf(i));
                    map.put("message", obj2 != null ? obj2.toString() : "Unknown error");
                }
                com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                if (jSCallback2 == null) {
                    return null;
                }
                jSCallback2.invoke(map);
                return null;
            }
        };
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(this.mWXSDKInstance);
        if (iWebviewFindWebview != null) {
            io.dcloud.feature.weex.WeexInstanceMgr.self().doForFeature(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebviewFindWebview.obtainApp(), io.dcloud.feature.weex.WeexInstanceMgr.self().getUniMPFeature(), "sendUniMPEvent", new java.lang.Object[]{str, str2, obj, iCallBack}});
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void getUniMPVersion(java.lang.String str, final com.taobao.weex.bridge.JSCallback jSCallback) {
        new java.util.HashMap();
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            if (jSCallback != null) {
                jSCallback.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_NO_PERMISSION));
                return;
            }
            return;
        }
        if ((android.text.TextUtils.isEmpty(str) || !str.startsWith("__UNI__")) && jSCallback != null) {
            jSCallback.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_INVALID_PARAMETER));
        }
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(this.mWXSDKInstance);
        if (iWebviewFindWebview != null) {
            io.dcloud.feature.weex.WeexInstanceMgr.self().doForFeature(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebviewFindWebview.obtainApp(), io.dcloud.feature.weex.WeexInstanceMgr.self().getUniMPFeature(), "getUniMPVersion", new java.lang.Object[]{str, new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.weex.extend.DCUniMPModule.8
                @Override // io.dcloud.common.DHInterface.ICallBack
                public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                    if (obj == null) {
                        com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                        if (jSCallback2 == null) {
                            return null;
                        }
                        jSCallback2.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.FAIL_BY_NO_RESOURCE_EXIST));
                        return null;
                    }
                    com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(obj.toString());
                    com.taobao.weex.bridge.JSCallback jSCallback3 = jSCallback;
                    if (jSCallback3 == null) {
                        return null;
                    }
                    jSCallback3.invoke(io.dcloud.feature.weex.EnumStateCode.obtainMap(io.dcloud.feature.weex.EnumStateCode.SUCCESS_NO_BODY, "versionInfo", object));
                    return null;
                }
            }}});
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void onUniMPEventReceive(com.taobao.weex.bridge.JSCallback jSCallback) {
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview;
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || (iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(this.mWXSDKInstance)) == null || !(jSCallback instanceof com.taobao.weex.bridge.SimpleJSCallback)) {
            return;
        }
        io.dcloud.feature.weex.WeexInstanceMgr.self().doForFeature(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebviewFindWebview.obtainApp(), io.dcloud.feature.weex.WeexInstanceMgr.self().getUniMPFeature(), "onUniMPEventReceive", new java.lang.Object[]{iWebviewFindWebview.obtainApp().obtainAppId(), this.mWXSDKInstance.getInstanceId(), ((com.taobao.weex.bridge.SimpleJSCallback) jSCallback).getCallbackId()}});
    }
}
