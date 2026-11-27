package io.dcloud.weex;

/* JADX INFO: loaded from: classes2.dex */
public class MoudlesLoader {
    private static io.dcloud.weex.MoudlesLoader sLoader;
    private boolean isInitHooksClass = false;

    public static io.dcloud.weex.MoudlesLoader getInstance() {
        if (sLoader == null) {
            synchronized (io.dcloud.weex.MoudlesLoader.class) {
                if (sLoader == null) {
                    sLoader = new io.dcloud.weex.MoudlesLoader();
                }
            }
        }
        return sLoader;
    }

    public void onCreate(android.app.Application application) {
        com.alibaba.fastjson.JSONArray jSONArray;
        com.alibaba.fastjson.JSONObject pluginsValue = getPluginsValue(application);
        initHooksClass(application, java.lang.Boolean.valueOf(application.getPackageName().equals(io.dcloud.common.util.RuningAcitvityUtil.getAppName(application))));
        if (pluginsValue == null || (jSONArray = pluginsValue.getJSONArray("nativePlugins")) == null || jSONArray.size() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.size(); i++) {
            initMoudle(jSONArray.getJSONObject(i), application);
        }
    }

    public void onCreate(android.app.Application application, java.lang.String str) {
        if (application == null || io.dcloud.common.util.PdrUtil.isEmpty(str) || !io.dcloud.common.adapter.io.DHFile.exists(str)) {
            return;
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(new java.lang.String(io.dcloud.common.adapter.io.DHFile.readAll(new java.io.File(str))));
        if (io.dcloud.common.util.PdrUtil.isEmpty(object)) {
            return;
        }
        com.alibaba.fastjson.JSONArray jSONArray = object.getJSONArray("components");
        if (io.dcloud.common.util.PdrUtil.isEmpty(jSONArray)) {
            return;
        }
        for (int i = 0; i < jSONArray.size(); i++) {
            com.alibaba.fastjson.JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                registerMoudle(jSONObject.getString("name"), jSONObject.getString("class"), com.taobao.weex.bridge.WXBridgeManager.COMPONENT);
            }
        }
    }

    private void initMoudle(com.alibaba.fastjson.JSONObject jSONObject, android.app.Application application) {
        com.alibaba.fastjson.JSONArray jSONArray;
        if (jSONObject == null || (jSONArray = jSONObject.getJSONArray("plugins")) == null || jSONArray == null || jSONArray.size() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.size(); i++) {
            com.alibaba.fastjson.JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 != null) {
                registerMoudle(jSONObject2.getString("name"), jSONObject2.getString("class"), jSONObject2.getString("type"));
            }
        }
    }

    private void executeOnCreateProcess(com.alibaba.fastjson.JSONObject jSONObject, android.app.Application application, boolean z) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(jSONObject.getString("hooksClass"));
            java.lang.Object objNewInstance = cls.newInstance();
            if (!(objNewInstance instanceof io.dcloud.weex.AppHookProxy)) {
                java.lang.reflect.Method method = cls.getMethod("onCreate", android.app.Application.class);
                if (method != null) {
                    method.setAccessible(true);
                    method.invoke(objNewInstance, application);
                    return;
                }
                return;
            }
            if (z) {
                ((io.dcloud.weex.AppHookProxy) objNewInstance).onCreate(application);
            } else if (objNewInstance instanceof io.dcloud.feature.uniapp.UniAppHookProxy) {
                ((io.dcloud.feature.uniapp.UniAppHookProxy) objNewInstance).onSubProcessCreate(application);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private void registerMoudle(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str2);
            if (!android.text.TextUtils.isEmpty(str3) && !str3.equalsIgnoreCase("module")) {
                if (str3.equalsIgnoreCase(com.taobao.weex.bridge.WXBridgeManager.COMPONENT)) {
                    com.taobao.weex.WXSDKEngine.registerComponent(str, (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) cls);
                    return;
                }
                return;
            }
            com.taobao.weex.WXSDKEngine.registerModule(str, cls);
        } catch (java.lang.Throwable unused) {
        }
    }

    private com.alibaba.fastjson.JSONObject getPluginsValue(android.app.Application application) {
        java.lang.String strLoadAsset = com.taobao.weex.utils.WXFileUtils.loadAsset("dcloud_uniplugins.json", application);
        if (android.text.TextUtils.isEmpty(strLoadAsset)) {
            return null;
        }
        return com.alibaba.fastjson.JSONObject.parseObject(strLoadAsset);
    }

    public void initHooksClass(android.app.Application application, java.lang.Boolean bool) {
        com.alibaba.fastjson.JSONArray jSONArray;
        if (this.isInitHooksClass) {
            return;
        }
        com.alibaba.fastjson.JSONObject pluginsValue = getPluginsValue(application);
        if (pluginsValue != null && (jSONArray = pluginsValue.getJSONArray("nativePlugins")) != null && jSONArray.size() > 0) {
            this.isInitHooksClass = true;
            for (int i = 0; i < jSONArray.size(); i++) {
                executeOnCreateProcess(jSONArray.getJSONObject(i), application, bool.booleanValue());
            }
        }
        io.dcloud.common.util.AppRuntime.initUTSHooksClassArray(application);
    }
}
