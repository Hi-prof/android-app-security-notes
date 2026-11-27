package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class BaseFeature implements io.dcloud.common.DHInterface.IFeature, io.dcloud.common.DHInterface.IBoot, io.dcloud.common.DHInterface.IDPlugin, io.dcloud.common.DHInterface.ISysEventListener, io.dcloud.common.DHInterface.IReflectAble {
    protected java.lang.String mFeatureName = null;
    protected io.dcloud.common.DHInterface.AbsMgr mFeatureMgr = null;
    protected android.content.Context mApplicationContext = null;
    private android.content.Context mDPluginContext = null;
    private android.app.Activity mDPluginActivity = null;
    protected java.util.ArrayList<io.dcloud.common.DHInterface.BaseFeature.BaseModule> mModules = null;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static abstract class BaseModule {
        public android.content.Context mApplicationContext;
        public java.lang.String featureName = null;
        public java.lang.String name = null;
        public java.lang.String id = null;
        public java.lang.String description = null;

        public java.lang.String getFullDescription() {
            return this.featureName + this.description;
        }

        public void init(android.content.Context context) {
            this.mApplicationContext = context;
        }

        public abstract org.json.JSONObject toJSONObject() throws org.json.JSONException;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
    }

    public boolean doHandleAction(java.lang.String str) {
        return false;
    }

    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONArray jSONArray) {
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        return null;
    }

    public io.dcloud.common.DHInterface.BaseFeature.BaseModule getBaseModuleById(java.lang.String str) {
        java.util.ArrayList<io.dcloud.common.DHInterface.BaseFeature.BaseModule> arrayList = this.mModules;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            io.dcloud.common.DHInterface.BaseFeature.BaseModule baseModule = arrayList.get(i);
            i++;
            io.dcloud.common.DHInterface.BaseFeature.BaseModule baseModule2 = baseModule;
            if (baseModule2.id.equals(str)) {
                return baseModule2;
            }
        }
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IDPlugin
    public android.app.Activity getDPluginActivity() {
        return this.mDPluginActivity;
    }

    @Override // io.dcloud.common.DHInterface.IDPlugin
    public android.content.Context getDPluginContext() {
        android.content.Context context = this.mDPluginContext;
        return context == null ? this.mApplicationContext : context;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.mFeatureMgr = absMgr;
        this.mApplicationContext = absMgr.getContext();
        this.mFeatureName = str;
    }

    @Override // io.dcloud.common.DHInterface.IDPlugin
    public void initDPlugin(android.content.Context context, android.app.Activity activity) {
        this.mDPluginContext = context;
        this.mDPluginActivity = activity;
    }

    public boolean isOldMode() {
        return false;
    }

    public java.util.ArrayList<io.dcloud.common.DHInterface.BaseFeature.BaseModule> loadModules() {
        java.util.ArrayList<io.dcloud.common.DHInterface.BaseFeature.BaseModule> arrayList = this.mModules;
        if (arrayList != null) {
            return arrayList;
        }
        this.mModules = new java.util.ArrayList<>();
        java.util.HashMap map = (java.util.HashMap) this.mFeatureMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 4, this.mFeatureName);
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() && map != null && map.containsKey("oauth-igetui")) {
            map.remove("oauth-igetui");
        }
        if (map != null && !map.isEmpty()) {
            for (java.lang.String str : map.keySet()) {
                try {
                    java.lang.Object objNewInstance = java.lang.Class.forName((java.lang.String) map.get(str)).newInstance();
                    if (objNewInstance instanceof io.dcloud.common.DHInterface.BaseFeature.BaseModule) {
                        io.dcloud.common.DHInterface.BaseFeature.BaseModule baseModule = (io.dcloud.common.DHInterface.BaseFeature.BaseModule) objNewInstance;
                        baseModule.init(this.mApplicationContext);
                        baseModule.name = str;
                        baseModule.featureName = this.mFeatureName;
                        if (baseModule.id == null) {
                            baseModule.id = str;
                        }
                        this.mModules.add(baseModule);
                    }
                } catch (java.lang.ClassNotFoundException e) {
                    io.dcloud.common.adapter.util.Logger.e(e.getLocalizedMessage());
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return this.mModules;
    }

    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
    }

    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
    }

    public boolean onEventExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        return false;
    }

    @Override // io.dcloud.common.DHInterface.ISysEventListener
    public final boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult) {
            java.lang.Object[] objArr = (java.lang.Object[]) obj;
            onActivityResult(((java.lang.Integer) objArr[0]).intValue(), ((java.lang.Integer) objArr[1]).intValue(), (android.content.Intent) objArr[2]);
        } else if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStart) {
            java.lang.Object[] objArr2 = (java.lang.Object[]) obj;
            onStart((android.content.Context) objArr2[0], (android.os.Bundle) objArr2[1], (java.lang.String[]) objArr2[3]);
        } else if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onPause) {
            onPause();
        } else if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStop) {
            onStop();
        } else if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume) {
            onResume();
        } else if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onNewIntent) {
            onNewIntent();
        } else if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onSaveInstanceState) {
            if (obj instanceof android.os.Bundle) {
                onSaveInstanceState((android.os.Bundle) obj);
            }
        } else {
            if (sysEventType != io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onRequestPermissionsResult) {
                return onEventExecute(sysEventType, obj);
            }
            java.lang.Object[] objArr3 = (java.lang.Object[]) obj;
            onRequestPermissionsResult(((java.lang.Integer) objArr3[0]).intValue(), (java.lang.String[]) objArr3[1], (int[]) objArr3[2]);
        }
        return false;
    }

    protected void onLowMemory() {
    }

    protected void onNewIntent() {
    }

    @Override // io.dcloud.common.DHInterface.IBoot
    public void onPause() {
    }

    public void onReceiver(android.content.Intent intent) {
    }

    protected void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
    }

    @Override // io.dcloud.common.DHInterface.IBoot
    public void onRestart(android.content.Context context) {
    }

    @Override // io.dcloud.common.DHInterface.IBoot
    public void onResume() {
    }

    protected void onSaveInstanceState(android.os.Bundle bundle) {
    }

    @Override // io.dcloud.common.DHInterface.IBoot
    public void onStart(android.content.Context context, android.os.Bundle bundle, java.lang.String[] strArr) {
    }

    @Override // io.dcloud.common.DHInterface.IBoot
    public void onStop() {
    }

    public final void registerSysEvent(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType) {
        registerSysEvent(iWebview.obtainApp(), sysEventType);
    }

    protected org.json.JSONArray toModuleJSONArray() throws org.json.JSONException {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.ArrayList<io.dcloud.common.DHInterface.BaseFeature.BaseModule> arrayList = this.mModules;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                jSONArray.put(this.mModules.get(i).toJSONObject());
            }
        }
        return jSONArray;
    }

    public final void unregisterSysEvent(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType) {
        unregisterSysEvent(iWebview.obtainApp(), sysEventType);
    }

    public final void registerSysEvent(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType) {
        iApp.registerSysEventListener(this, sysEventType);
    }

    public final void unregisterSysEvent(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType) {
        iApp.unregisterSysEventListener(this, sysEventType);
    }

    public final void registerSysEvent(io.dcloud.common.DHInterface.IWebview iWebview) {
        registerSysEvent(iWebview, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.AllSystemEvent);
    }

    public final void unregisterSysEvent(io.dcloud.common.DHInterface.IWebview iWebview) {
        unregisterSysEvent(iWebview, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.AllSystemEvent);
    }

    public final void registerSysEvent(io.dcloud.common.DHInterface.IApp iApp) {
        registerSysEvent(iApp, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.AllSystemEvent);
    }

    public final void unregisterSysEvent(io.dcloud.common.DHInterface.IApp iApp) {
        unregisterSysEvent(iApp, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.AllSystemEvent);
    }
}
