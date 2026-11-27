package com.taobao.weex.appfram.navigator;

/* JADX INFO: loaded from: classes.dex */
public class WXNavigatorModule extends com.taobao.weex.common.WXModule {
    public static final java.lang.String CALLBACK_MESSAGE = "message";
    public static final java.lang.String CALLBACK_RESULT = "result";
    private static final java.lang.String INSTANCE_ID = "instanceId";
    public static final java.lang.String MSG_FAILED = "WX_FAILED";
    public static final java.lang.String MSG_PARAM_ERR = "WX_PARAM_ERR";
    public static final java.lang.String MSG_SUCCESS = "WX_SUCCESS";
    private static final java.lang.String TAG = "Navigator";
    private static final java.lang.String URL = "url";
    private static final java.lang.String WEEX = "com.taobao.android.intent.category.WEEX";

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void open(com.alibaba.fastjson.JSONObject jSONObject, com.taobao.weex.bridge.JSCallback jSCallback, com.taobao.weex.bridge.JSCallback jSCallback2) {
        if (jSONObject != null) {
            java.lang.String string = jSONObject.getString("url");
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            if (!android.text.TextUtils.isEmpty(string)) {
                android.net.Uri uri = android.net.Uri.parse(string);
                java.lang.String scheme = uri.getScheme();
                if (android.text.TextUtils.isEmpty(scheme) || "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    push(jSONObject.toJSONString(), jSCallback);
                } else {
                    try {
                        this.mWXSDKInstance.getContext().startActivity(new android.content.Intent("android.intent.action.VIEW", uri));
                        jSONObject2.put("result", (java.lang.Object) MSG_SUCCESS);
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                        jSONObject2.put("result", (java.lang.Object) MSG_FAILED);
                        jSONObject2.put("message", (java.lang.Object) "Open page failed.");
                        jSCallback = jSCallback2;
                    }
                }
                jSCallback2 = jSCallback;
            } else {
                jSONObject2.put("result", (java.lang.Object) MSG_PARAM_ERR);
                jSONObject2.put("message", (java.lang.Object) "The URL parameter is empty.");
            }
            if (jSCallback2 != null) {
                jSCallback2.invoke(jSONObject2);
            }
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void close(com.alibaba.fastjson.JSONObject jSONObject, com.taobao.weex.bridge.JSCallback jSCallback, com.taobao.weex.bridge.JSCallback jSCallback2) {
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        if (this.mWXSDKInstance.getContext() instanceof android.app.Activity) {
            ((android.app.Activity) this.mWXSDKInstance.getContext()).finish();
        } else {
            jSONObject2.put("result", (java.lang.Object) MSG_FAILED);
            jSONObject2.put("message", (java.lang.Object) "Close page failed.");
            jSCallback = jSCallback2;
        }
        if (jSCallback != null) {
            jSCallback.invoke(jSONObject2);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void push(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            if (jSCallback != null) {
                jSCallback.invoke(MSG_FAILED);
                return;
            }
            return;
        }
        if (com.taobao.weex.WXSDKEngine.getActivityNavBarSetter() != null && com.taobao.weex.WXSDKEngine.getActivityNavBarSetter().push(str)) {
            if (jSCallback != null) {
                jSCallback.invoke(MSG_SUCCESS);
                return;
            }
            return;
        }
        if (this.mWXSDKInstance.getContext() instanceof android.app.Activity) {
            android.app.Activity activity = (android.app.Activity) this.mWXSDKInstance.getContext();
            if (com.taobao.weex.WXSDKEngine.getNavigator() != null && com.taobao.weex.WXSDKEngine.getNavigator().push(activity, str)) {
                if (jSCallback != null) {
                    jSCallback.invoke(MSG_SUCCESS);
                    return;
                }
                return;
            }
        }
        try {
            java.lang.String string = com.alibaba.fastjson.JSON.parseObject(str).getString("url");
            if (android.text.TextUtils.isEmpty(string)) {
                return;
            }
            android.net.Uri uri = android.net.Uri.parse(string);
            java.lang.String scheme = uri.getScheme();
            android.net.Uri.Builder builderBuildUpon = uri.buildUpon();
            if (android.text.TextUtils.isEmpty(scheme)) {
                builderBuildUpon.scheme("http");
            }
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", builderBuildUpon.build());
            intent.addCategory(WEEX);
            intent.putExtra("instanceId", this.mWXSDKInstance.getInstanceId());
            this.mWXSDKInstance.getContext().startActivity(intent);
            if (jSCallback != null) {
                jSCallback.invoke(MSG_SUCCESS);
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.eTag("Navigator", e);
            if (jSCallback != null) {
                jSCallback.invoke(MSG_FAILED);
            }
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void pop(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (com.taobao.weex.WXSDKEngine.getActivityNavBarSetter() != null && com.taobao.weex.WXSDKEngine.getActivityNavBarSetter().pop(str)) {
            if (jSCallback != null) {
                jSCallback.invoke(MSG_SUCCESS);
            }
        } else if (this.mWXSDKInstance.getContext() instanceof android.app.Activity) {
            android.app.Activity activity = (android.app.Activity) this.mWXSDKInstance.getContext();
            if (com.taobao.weex.WXSDKEngine.getNavigator() == null || !com.taobao.weex.WXSDKEngine.getNavigator().pop(activity, str)) {
                if (jSCallback != null) {
                    jSCallback.invoke(MSG_SUCCESS);
                }
                ((android.app.Activity) this.mWXSDKInstance.getContext()).finish();
            } else if (jSCallback != null) {
                jSCallback.invoke(MSG_SUCCESS);
            }
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void setNavBarRightItem(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (android.text.TextUtils.isEmpty(str) || com.taobao.weex.WXSDKEngine.getActivityNavBarSetter() == null || !com.taobao.weex.WXSDKEngine.getActivityNavBarSetter().setNavBarRightItem(str)) {
            if (jSCallback != null) {
                jSCallback.invoke(MSG_FAILED);
            }
        } else if (jSCallback != null) {
            jSCallback.invoke(MSG_SUCCESS);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void clearNavBarRightItem(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (com.taobao.weex.WXSDKEngine.getActivityNavBarSetter() == null || !com.taobao.weex.WXSDKEngine.getActivityNavBarSetter().clearNavBarRightItem(str)) {
            if (jSCallback != null) {
                jSCallback.invoke(MSG_FAILED);
            }
        } else if (jSCallback != null) {
            jSCallback.invoke(MSG_SUCCESS);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void setNavBarLeftItem(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (android.text.TextUtils.isEmpty(str) || com.taobao.weex.WXSDKEngine.getActivityNavBarSetter() == null || !com.taobao.weex.WXSDKEngine.getActivityNavBarSetter().setNavBarLeftItem(str)) {
            if (jSCallback != null) {
                jSCallback.invoke(MSG_FAILED);
            }
        } else if (jSCallback != null) {
            jSCallback.invoke(MSG_SUCCESS);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void clearNavBarLeftItem(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (com.taobao.weex.WXSDKEngine.getActivityNavBarSetter() == null || !com.taobao.weex.WXSDKEngine.getActivityNavBarSetter().clearNavBarLeftItem(str)) {
            if (jSCallback != null) {
                jSCallback.invoke(MSG_FAILED);
            }
        } else if (jSCallback != null) {
            jSCallback.invoke(MSG_SUCCESS);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void setNavBarMoreItem(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (android.text.TextUtils.isEmpty(str) || com.taobao.weex.WXSDKEngine.getActivityNavBarSetter() == null || !com.taobao.weex.WXSDKEngine.getActivityNavBarSetter().setNavBarMoreItem(str)) {
            if (jSCallback != null) {
                jSCallback.invoke(MSG_FAILED);
            }
        } else if (jSCallback != null) {
            jSCallback.invoke(MSG_SUCCESS);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void clearNavBarMoreItem(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (com.taobao.weex.WXSDKEngine.getActivityNavBarSetter() == null || !com.taobao.weex.WXSDKEngine.getActivityNavBarSetter().clearNavBarMoreItem(str)) {
            if (jSCallback != null) {
                jSCallback.invoke(MSG_FAILED);
            }
        } else if (jSCallback != null) {
            jSCallback.invoke(MSG_SUCCESS);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void setNavBarTitle(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (android.text.TextUtils.isEmpty(str) || com.taobao.weex.WXSDKEngine.getActivityNavBarSetter() == null || !com.taobao.weex.WXSDKEngine.getActivityNavBarSetter().setNavBarTitle(str)) {
            if (jSCallback != null) {
                jSCallback.invoke(MSG_FAILED);
            }
        } else if (jSCallback != null) {
            jSCallback.invoke(MSG_SUCCESS);
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void setNavBarHidden(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = MSG_FAILED;
        try {
            if (changeVisibilityOfActionBar(this.mWXSDKInstance.getContext(), com.alibaba.fastjson.JSON.parseObject(str).getInteger("hidden").intValue())) {
                str3 = MSG_SUCCESS;
            }
        } catch (com.alibaba.fastjson.JSONException e) {
            com.taobao.weex.utils.WXLogUtils.e("Navigator", com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
        }
        com.taobao.weex.bridge.WXBridgeManager.getInstance().callback(this.mWXSDKInstance.getInstanceId(), str2, str3);
    }

    private boolean changeVisibilityOfActionBar(android.content.Context context, int i) {
        android.app.ActionBar actionBar;
        try {
            java.lang.Class.forName("android.support.v7.app.AppCompatActivity");
            if (this.mWXSDKInstance.getContext() instanceof androidx.appcompat.app.AppCompatActivity) {
                androidx.appcompat.app.ActionBar supportActionBar = ((androidx.appcompat.app.AppCompatActivity) this.mWXSDKInstance.getContext()).getSupportActionBar();
                if (supportActionBar != null) {
                    if (i == 0) {
                        supportActionBar.show();
                        return true;
                    }
                    if (i == 1) {
                        supportActionBar.hide();
                        return true;
                    }
                }
                return false;
            }
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        }
        if ((this.mWXSDKInstance.getContext() instanceof android.app.Activity) && (actionBar = ((android.app.Activity) this.mWXSDKInstance.getContext()).getActionBar()) != null) {
            if (i == 0) {
                actionBar.show();
                return true;
            }
            if (i == 1) {
                actionBar.hide();
                return true;
            }
        }
        return false;
    }
}
