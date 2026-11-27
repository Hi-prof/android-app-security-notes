package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class i1 extends io.dcloud.common.DHInterface.AbsMgr implements io.dcloud.common.DHInterface.IMgr.FeatureEvent {
    private java.util.HashMap a;
    private java.util.HashMap b;
    private java.util.HashMap c;
    private java.util.HashMap d;
    private java.util.HashMap e;
    private java.lang.String f;
    private java.util.ArrayList g;
    java.util.HashMap h;

    public i1(io.dcloud.common.DHInterface.ICore iCore) {
        super(iCore, "featuremgr", io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new java.util.ArrayList();
        this.h = new java.util.HashMap();
        b();
        if (c()) {
            return;
        }
        c();
    }

    private java.lang.Object a(java.lang.String str, android.app.Activity activity) {
        return null;
    }

    private java.lang.String a(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IFrameView iFrameView) {
        java.lang.String str = (java.lang.String) this.h.get(iApp.obtainAppId() + "_" + iApp.obtainAppVersionName());
        if (str != null) {
            return str;
        }
        java.lang.String strA = a(iApp, iFrameView.obtainWebView());
        this.h.put(iApp.obtainAppId() + "_" + iApp.obtainAppVersionName(), strA);
        return strA;
    }

    private java.util.HashMap a(java.util.HashMap map) {
        return map;
    }

    private void c(java.lang.String str) {
        if (((io.dcloud.common.DHInterface.IFeature) this.c.get(str)) == null) {
            try {
                io.dcloud.common.DHInterface.IFeature iFeature = (io.dcloud.common.DHInterface.IFeature) java.lang.Class.forName(str).newInstance();
                this.c.put(str, iFeature);
                iFeature.init(this, str);
            } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException unused) {
            }
        }
    }

    java.util.HashMap d() {
        io.dcloud.common.DHInterface.IBoot iBoot;
        java.lang.InstantiationException e;
        java.lang.IllegalAccessException e2;
        java.lang.ClassNotFoundException e3;
        java.lang.ClassCastException e4;
        java.util.HashMap map = this.e;
        java.util.HashMap map2 = this.d;
        io.dcloud.common.util.PdrUtil.loadProperties2HashMap(map2, this.b, this.a, io.dcloud.common.util.BaseInfo.s_properties);
        java.util.Set<java.lang.String> setKeySet = map2.keySet();
        if (setKeySet != null) {
            map = new java.util.HashMap(2);
            this.e = map;
            for (java.lang.String str : setKeySet) {
                io.dcloud.common.DHInterface.IBoot iBootB = io.dcloud.p.g1.b(this, str);
                if (iBootB == null) {
                    try {
                        iBoot = (io.dcloud.common.DHInterface.IBoot) java.lang.Class.forName((java.lang.String) map2.get(str)).newInstance();
                        try {
                            if (iBoot instanceof io.dcloud.common.DHInterface.BaseFeature) {
                                ((io.dcloud.common.DHInterface.BaseFeature) iBoot).init(this, str);
                            }
                        } catch (java.lang.ClassCastException e5) {
                            e4 = e5;
                            io.dcloud.common.adapter.util.Logger.e(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "FeatureMgr.loadBootOptions " + e4.getMessage());
                        } catch (java.lang.ClassNotFoundException e6) {
                            e3 = e6;
                            io.dcloud.common.adapter.util.Logger.e(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "FeatureMgr.loadBootOptions " + e3.getMessage());
                        } catch (java.lang.IllegalAccessException e7) {
                            e2 = e7;
                            io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "FeatureMgr.loadBootOptions " + e2.getMessage());
                        } catch (java.lang.InstantiationException e8) {
                            e = e8;
                            io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "FeatureMgr.loadBootOptions " + e.getMessage());
                        }
                    } catch (java.lang.ClassCastException e9) {
                        iBoot = iBootB;
                        e4 = e9;
                    } catch (java.lang.ClassNotFoundException e10) {
                        iBoot = iBootB;
                        e3 = e10;
                    } catch (java.lang.IllegalAccessException e11) {
                        iBoot = iBootB;
                        e2 = e11;
                    } catch (java.lang.InstantiationException e12) {
                        iBoot = iBootB;
                        e = e12;
                    }
                    iBootB = iBoot;
                }
                if (iBootB != null) {
                    map.put(str, iBootB);
                }
            }
        }
        java.util.HashMap mapA = a(map);
        a(this.b.values().iterator());
        java.util.Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            a(((java.util.HashMap) it.next()).values().iterator());
        }
        return mapA;
    }

    @Override // io.dcloud.common.DHInterface.AbsMgr
    public void dispose() {
        java.util.HashMap map = this.c;
        if (map != null) {
            java.util.Collection collectionValues = map.values();
            if (collectionValues != null) {
                java.util.Iterator it = collectionValues.iterator();
                while (it.hasNext()) {
                    ((io.dcloud.common.DHInterface.IFeature) it.next()).dispose(null);
                }
            }
            this.c.clear();
            this.c = null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IMgr
    public java.lang.Object processEvent(io.dcloud.common.DHInterface.IMgr.MgrType mgrType, int i, java.lang.Object obj) {
        try {
            if (!checkMgrId(mgrType)) {
                return this.mCore.dispatchEvent(mgrType, i, obj);
            }
            switch (i) {
                case 0:
                    this.c = new java.util.HashMap(1);
                    this.b = new java.util.HashMap(1);
                    this.a = new java.util.HashMap(1);
                    this.e = new java.util.HashMap();
                    this.d = new java.util.HashMap(1);
                    return d();
                case 1:
                    java.lang.Object[] objArr = (java.lang.Object[]) obj;
                    return io.dcloud.common.constant.AbsoluteConst.UNI_SYNC_EXEC_METHOD.equalsIgnoreCase(java.lang.String.valueOf(objArr[2])) ? a(objArr) : b(objArr);
                case 2:
                    java.lang.Object[] objArr2 = (java.lang.Object[]) obj;
                    java.lang.String strA = a((io.dcloud.common.DHInterface.IApp) objArr2[0], (io.dcloud.common.DHInterface.IFrameView) objArr2[1]);
                    if (strA == null) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                    return strA;
                case 3:
                    a(java.lang.String.valueOf(obj));
                    break;
                case 4:
                    return this.a.get(java.lang.String.valueOf(obj));
                case 5:
                    java.lang.String[] strArr = (java.lang.String[]) obj;
                    java.lang.String str = strArr[0];
                    java.lang.String str2 = strArr[1];
                    java.lang.String str3 = strArr[2];
                    if (!io.dcloud.common.util.PdrUtil.isEmpty(str) && !io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
                        this.b.put(str.toLowerCase(java.util.Locale.ENGLISH), str2);
                    }
                    if (!io.dcloud.common.util.PdrUtil.isEmpty(str3)) {
                        this.g.add(str3);
                    }
                    break;
                case 6:
                case 7:
                default:
                    break;
                case 8:
                    java.lang.String[] strArr2 = (java.lang.String[]) obj;
                    return java.lang.Boolean.valueOf(io.dcloud.common.core.permission.PermissionControler.checkPermission(strArr2[0], strArr2[1]));
                case 9:
                    return java.lang.Boolean.valueOf(b(java.lang.String.valueOf(obj)));
                case 10:
                    try {
                        java.lang.Object[] objArr3 = (java.lang.Object[]) obj;
                        java.lang.Object obj2 = objArr3[0];
                        io.dcloud.common.DHInterface.IFeature iFeatureB = b(java.lang.String.valueOf(objArr3[1]), obj2 instanceof io.dcloud.common.DHInterface.IWebview ? ((io.dcloud.common.DHInterface.IWebview) obj2).getActivity() : obj2 instanceof io.dcloud.common.DHInterface.IApp ? ((io.dcloud.common.DHInterface.IApp) obj2).getActivity() : null);
                        if (iFeatureB instanceof io.dcloud.common.DHInterface.IWaiter) {
                            return ((io.dcloud.common.DHInterface.IWaiter) iFeatureB).doForFeature(java.lang.String.valueOf(objArr3[2]), objArr3[3]);
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 11:
                    c((java.lang.String) ((java.lang.Object[]) obj)[0]);
                    break;
            }
        } catch (java.lang.Throwable th) {
            io.dcloud.common.adapter.util.Logger.w("FeatureMgr.processEvent", th);
        }
        return null;
    }

    private java.lang.String b(io.dcloud.common.DHInterface.IApp iApp) {
        java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_UNIPUSH");
        return (io.dcloud.common.util.PdrUtil.isEmpty(metaValue) || !java.lang.Boolean.valueOf(metaValue).booleanValue()) ? "" : "window.__isUniPush__ = true;";
    }

    private synchronized java.lang.String b(java.lang.Object[] objArr) {
        return a(objArr);
    }

    public java.lang.String a(io.dcloud.common.DHInterface.IWebview iWebview) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.String webviewUUID = iWebview.getWebviewUUID();
        if (io.dcloud.common.util.PdrUtil.isEmpty(webviewUUID)) {
            webviewUUID = java.lang.String.valueOf(iWebview.obtainFrameView().hashCode());
        }
        stringBuffer.append("window.__HtMl_Id__= '" + webviewUUID + "';");
        if (io.dcloud.common.util.PdrUtil.isEmpty(iWebview.obtainFrameId())) {
            stringBuffer.append("window.__WebVieW_Id__= undefined;");
        } else {
            stringBuffer.append("window.__WebVieW_Id__= '" + iWebview.obtainFrameId() + "';");
        }
        stringBuffer.append("try{window.plus.__tag__='_plus_all_'}catch(e){}");
        return stringBuffer.toString();
    }

    public boolean c() {
        try {
            if (io.dcloud.common.util.BaseInfo.ISDEBUG && io.dcloud.common.adapter.io.DHFile.isExist("/sdcard/dcloud/all.js")) {
                this.f = new java.lang.String(io.dcloud.common.adapter.util.PlatformUtil.getFileContent("/sdcard/dcloud/all.js", 2));
            } else {
                this.f = new java.lang.String(io.dcloud.common.adapter.util.PlatformUtil.getFileContent(io.src.dcloud.adapter.DCloudAdapterUtil.getRuntimeJsPath(), 1));
            }
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    io.dcloud.common.DHInterface.IFeature b(java.lang.String str, android.app.Activity activity) {
        java.lang.String str2;
        java.lang.ClassNotFoundException e;
        io.dcloud.common.DHInterface.IFeature iFeature;
        if (str.contains(",")) {
            java.lang.String[] strArrSplit = str.split(",");
            java.lang.String str3 = strArrSplit[0];
            str2 = strArrSplit[1];
            str = str3;
        } else {
            str2 = null;
        }
        io.dcloud.common.DHInterface.IFeature iFeature2 = (io.dcloud.common.DHInterface.IFeature) this.c.get(str);
        if (iFeature2 == null) {
            java.lang.String str4 = (java.lang.String) this.b.get(str);
            if (!io.dcloud.common.util.PdrUtil.isEmpty(str4)) {
                str2 = str4;
            }
            if (str2 != null && this.e.containsKey(str)) {
                io.dcloud.common.DHInterface.IBoot iBoot = (io.dcloud.common.DHInterface.IBoot) this.e.get(str);
                if ((iBoot instanceof io.dcloud.common.DHInterface.BaseFeature) && str2.equals(iBoot.getClass().getName())) {
                    iFeature2 = (io.dcloud.common.DHInterface.BaseFeature) iBoot;
                }
            }
            if (iFeature2 == null) {
                if (str2 != null) {
                    try {
                        io.dcloud.common.DHInterface.IFeature iFeatureA = io.dcloud.p.g1.a(this, str);
                        if (iFeatureA == null) {
                            iFeature = (io.dcloud.common.DHInterface.IFeature) java.lang.Class.forName(str2).newInstance();
                            try {
                                this.c.put(str, iFeature);
                                iFeature.init(this, str);
                                return iFeature;
                            } catch (java.lang.ClassNotFoundException e2) {
                                e = e2;
                                io.dcloud.common.adapter.util.Logger.i("featuremgr", "loadFeature error " + e.toString());
                                try {
                                    io.dcloud.common.DHInterface.IFeature iFeature3 = (io.dcloud.common.DHInterface.IFeature) a(str, activity);
                                    if (iFeature3 == null) {
                                        return iFeature3;
                                    }
                                    try {
                                        this.c.put(str, iFeature3);
                                        iFeature3.init(this, str);
                                        return iFeature3;
                                    } catch (java.lang.Exception e3) {
                                        e = e3;
                                        iFeature = iFeature3;
                                        e.printStackTrace();
                                        return iFeature;
                                    }
                                } catch (java.lang.Exception e4) {
                                    e = e4;
                                }
                            } catch (java.lang.IllegalAccessException e5) {
                                e = e5;
                                iFeature2 = iFeature;
                                e.printStackTrace();
                                return iFeature2;
                            } catch (java.lang.InstantiationException e6) {
                                e = e6;
                                iFeature2 = iFeature;
                                e.printStackTrace();
                                return iFeature2;
                            }
                        } else {
                            this.c.put(str, iFeatureA);
                            return iFeatureA;
                        }
                    } catch (java.lang.ClassNotFoundException e7) {
                        io.dcloud.common.DHInterface.IFeature iFeature4 = iFeature2;
                        e = e7;
                        iFeature = iFeature4;
                    } catch (java.lang.IllegalAccessException e8) {
                        e = e8;
                    } catch (java.lang.InstantiationException e9) {
                        e = e9;
                    }
                } else {
                    try {
                        io.dcloud.common.DHInterface.IFeature iFeature5 = (io.dcloud.common.DHInterface.IFeature) a(str, activity);
                        if (iFeature5 == null) {
                            return iFeature5;
                        }
                        try {
                            this.c.put(str, iFeature5);
                            iFeature5.init(this, str);
                            return iFeature5;
                        } catch (java.lang.Exception e10) {
                            e = e10;
                            iFeature2 = iFeature5;
                            e.printStackTrace();
                            return iFeature2;
                        }
                    } catch (java.lang.Exception e11) {
                        e = e11;
                    }
                }
                return iFeature2;
            }
            this.c.put(str, iFeature2);
        }
        return iFeature2;
    }

    private java.lang.String a(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IWebview iWebview) {
        java.lang.String str;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("javascript:function __load__plus__(){try{");
        int i = android.os.Build.VERSION.SDK_INT;
        if (android.text.TextUtils.isEmpty(this.f) || this.f.length() < 400) {
            return null;
        }
        stringBuffer.append("window._____isDebug_____=" + io.dcloud.common.util.BaseInfo.ISDEBUG + ";");
        stringBuffer.append("window._____platform_____=1;");
        stringBuffer.append("window._____platform_os_version_____=" + i + ";");
        stringBuffer.append(this.f);
        if (io.dcloud.common.core.permission.PermissionControler.checkPermission(iApp.obtainAppId(), io.dcloud.common.DHInterface.IFeature.F_DEVICE.toLowerCase(java.util.Locale.ENGLISH)) || !iApp.manifestBeParsed()) {
            if (io.dcloud.common.util.PdrUtil.isEmpty(io.dcloud.common.adapter.util.DeviceInfo.DEVICESTATUS_JS)) {
                io.dcloud.common.adapter.util.DeviceInfo.getDevicestatus_js(iApp);
            }
            stringBuffer.append(io.dcloud.common.adapter.util.DeviceInfo.DEVICESTATUS_JS);
        }
        io.dcloud.feature.internal.sdk.SDK.IntegratedMode integratedMode = io.dcloud.common.util.BaseInfo.sRuntimeMode;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("window.__NWin_Enable__=");
        sb.append(integratedMode == io.dcloud.feature.internal.sdk.SDK.IntegratedMode.WEBVIEW ? java.lang.String.valueOf(false) : java.lang.String.valueOf(true));
        sb.append(";");
        stringBuffer.append(sb.toString());
        if (io.dcloud.common.core.permission.PermissionControler.checkPermission(iApp.obtainAppId(), io.dcloud.common.DHInterface.IFeature.F_RUNTIME) || !iApp.manifestBeParsed()) {
            java.lang.String strObtainConfigProperty = iApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LOADED_TIME);
            if (io.dcloud.common.util.BaseInfo.ISAMU) {
                str = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_VERSIONs, iApp.obtainAppVersionName(), "1.9.9.82680", iApp.obtainAppId(), strObtainConfigProperty);
            } else {
                str = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_VERSIONs, io.dcloud.common.adapter.util.AndroidResources.mApplicationInfo.versionName, "1.9.9.82680", iApp.obtainAppId(), strObtainConfigProperty);
            }
            stringBuffer.append(io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_BASE, str));
            stringBuffer.append(io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_BASE, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_ARGUMENTS, io.dcloud.common.util.DataUtil.utf8ToUnicode(iApp.obtainRuntimeArgs(true)))));
            java.lang.String launcherData = io.dcloud.common.util.BaseInfo.getLauncherData(iApp.obtainAppId());
            if (!io.dcloud.common.util.PdrUtil.isEmpty(iApp.obtainWebAppIntent())) {
                java.lang.String stringExtra = iApp.obtainWebAppIntent().getStringExtra(io.dcloud.common.constant.IntentConst.FROM_STREAM_OPEN_FLAG);
                if (!android.text.TextUtils.isEmpty(stringExtra) && !android.text.TextUtils.equals(stringExtra, iApp.obtainAppId())) {
                    launcherData = launcherData + ":" + stringExtra;
                }
            }
            stringBuffer.append(io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_BASE, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_LAUNCHER, launcherData)));
            stringBuffer.append(io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_BASE, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_CHANNEL, io.dcloud.common.util.BaseInfo.getAnalysisChannel())));
            java.lang.String bundleData = io.dcloud.common.adapter.util.SP.getBundleData(iApp.getActivity(), "pdr", iApp.obtainAppId() + io.dcloud.common.constant.AbsoluteConst.LAUNCHTYPE);
            if (android.text.TextUtils.isEmpty(bundleData)) {
                bundleData = "default";
            }
            stringBuffer.append(io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_BASE, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_ORIGIN, bundleData)));
            stringBuffer.append(io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_BASE, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_STARTUPTIME, java.lang.String.valueOf(io.dcloud.common.util.BaseInfo.getStartupTimeData(iApp.obtainAppId())))));
            stringBuffer.append(io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_BASE, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_PROCESSID, java.lang.Long.valueOf(io.dcloud.common.util.BaseInfo.sProcessId))));
            stringBuffer.append(io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_BASE, io.dcloud.common.util.StringUtil.format("p.runtime.versionCode = %d;", java.lang.Integer.valueOf(io.dcloud.common.adapter.util.AndroidResources.versionCode))));
            if (io.dcloud.common.util.BaseInfo.isUniAppAppid(iApp)) {
                stringBuffer.append(io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_BASE, io.dcloud.common.util.StringUtil.format("p.runtime.uniVersion = '%s';", io.dcloud.common.util.BaseInfo.uniVersionV3)));
            }
        }
        if (io.dcloud.common.core.permission.PermissionControler.checkPermission(iApp.obtainAppId(), io.dcloud.common.DHInterface.IFeature.F_NAVIGATOR)) {
            io.dcloud.common.adapter.util.DeviceInfo.updateStatusBarHeight(iWebview.getActivity());
            stringBuffer.append(java.lang.String.format(java.util.Locale.UK, io.dcloud.common.constant.AbsoluteConst.JS_NAVIGATOR_STATUSBAR_HEIGHT, java.lang.Float.valueOf(io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight / iWebview.getScale())));
        }
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            stringBuffer.append((java.lang.String) this.g.get(i2));
        }
        stringBuffer.append(a());
        stringBuffer.append("}catch(e){console.log('__load__plus__ function error=' + e);}}window.__load__plus__&&window.__load__plus__();");
        stringBuffer.append(a(iApp));
        stringBuffer.append(b(iApp));
        return stringBuffer.toString();
    }

    private void b() {
        try {
            io.dcloud.p.h1.a(java.lang.Class.forName("io.dcloud.feature.d").getConstructor(android.content.Context.class).newInstance(getContext()));
        } catch (java.lang.Exception unused) {
            io.dcloud.common.adapter.util.Logger.e("fmgr no dp");
        }
    }

    private boolean b(java.lang.String str) {
        return this.b.containsKey(str);
    }

    private java.lang.String a(io.dcloud.common.DHInterface.IApp iApp) {
        if (!io.dcloud.common.util.BaseInfo.isUniNViewBackgroud()) {
            return "";
        }
        java.lang.String str = (java.lang.String) processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iApp, "weex,io.dcloud.feature.weex.WeexFeature", "getUniNViewModules", null});
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return "";
        }
        return "window.__NATIVE_PLUGINS__ = " + str + ";window.__NATIVE_PLUGINS_REGISTERED__ = true;";
    }

    private java.lang.String a() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(";Object.defineProperty(plus.screen,\"resolutionHeight\",{get:function(){var e=window,l=e.__html5plus__&&e.__html5plus__.isReady?e.__html5plus__:n.plus&&n.plus.isReady?n.plus:window.plus;return l.bridge.execSync(\"Device\",\"s.resolutionHeight\",[])}}),Object.defineProperty(plus.screen,\"resolutionWidth\",{get:function(){var e=window,l=e.__html5plus__&&e.__html5plus__.isReady?e.__html5plus__:n.plus&&n.plus.isReady?n.plus:window.plus;return l.bridge.execSync(\"Device\",\"s.resolutionWidth\",[])}}),Object.defineProperty(plus.display,\"resolutionHeight\",{get:function(){var e=window,l=e.__html5plus__&&e.__html5plus__.isReady?e.__html5plus__:n.plus&&n.plus.isReady?n.plus:window.plus;return l.bridge.execSync(\"Device\",\"d.resolutionHeight\",[])}}),Object.defineProperty(plus.display,\"resolutionWidth\",{get:function(){var e=window,l=e.__html5plus__&&e.__html5plus__.isReady?e.__html5plus__:n.plus&&n.plus.isReady?n.plus:window.plus;return l.bridge.execSync(\"Device\",\"d.resolutionWidth\",[])}});;plus.webview.__test__('save');");
        stringBuffer.append("plus.webview.__test__('update');");
        return stringBuffer.toString();
    }

    private java.lang.String a(java.lang.Object[] objArr) {
        io.dcloud.common.DHInterface.IWebview iWebview = (io.dcloud.common.DHInterface.IWebview) objArr[0];
        java.lang.String lowerCase = java.lang.String.valueOf(objArr[1]).toLowerCase(java.util.Locale.ENGLISH);
        java.lang.String strValueOf = java.lang.String.valueOf(objArr[2]);
        org.json.JSONArray jSONArray = (org.json.JSONArray) objArr[3];
        java.lang.String str = null;
        strArrJsonArrayToStringArr = null;
        java.lang.String[] strArrJsonArrayToStringArr = null;
        str = null;
        str = null;
        str = null;
        if (iWebview != null && iWebview.obtainApp() != null && iWebview.obtainFrameView() != null && iWebview.obtainFrameView().obtainWebView() != null) {
            io.dcloud.common.DHInterface.IFeature iFeatureB = b(lowerCase, iWebview.getActivity());
            if (iFeatureB != null) {
                if (iFeatureB instanceof io.dcloud.common.DHInterface.BaseFeature) {
                    io.dcloud.common.DHInterface.BaseFeature baseFeature = (io.dcloud.common.DHInterface.BaseFeature) iFeatureB;
                    if (!baseFeature.isOldMode()) {
                        return baseFeature.execute(iWebview, strValueOf, jSONArray);
                    }
                }
                if (jSONArray != null) {
                    try {
                        strArrJsonArrayToStringArr = io.dcloud.common.util.JSUtil.jsonArrayToStringArr(jSONArray);
                    } catch (org.json.JSONException e) {
                        e.printStackTrace();
                    }
                }
                return iFeatureB.execute(iWebview, strValueOf, strArrJsonArrayToStringArr);
            }
            str = "";
            if (iWebview.obtainFrameView().getFrameType() != 3 && !io.dcloud.common.core.permission.PermissionControler.checkSafePermission(iWebview.obtainApp().obtainAppId(), lowerCase)) {
                io.dcloud.common.adapter.util.Logger.e("featuremgr", "not found " + lowerCase + " feature plugin ; action=" + strValueOf + ";" + io.dcloud.common.util.StringUtil.format(getContext().getString(io.dcloud.base.R.string.dcloud_feature_error_tips), lowerCase));
                a(iWebview, lowerCase);
            }
        }
        return str;
    }

    private void a(java.util.Iterator it) {
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            return;
        }
        while (it.hasNext()) {
            java.lang.String strValueOf = java.lang.String.valueOf(io.dcloud.common.adapter.util.PlatformUtil.invokeMethod((java.lang.String) it.next(), "getJsContent"));
            if (!io.dcloud.common.util.PdrUtil.isEmpty(strValueOf)) {
                this.g.add(strValueOf);
            }
        }
    }

    public void a(java.lang.String str) {
        java.lang.String str2;
        java.util.Collection collectionValues;
        java.util.HashMap map = this.c;
        if (map != null && (collectionValues = map.values()) != null) {
            java.util.Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                try {
                    ((io.dcloud.common.DHInterface.IFeature) it.next()).dispose(str);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
        java.util.HashMap map2 = this.h;
        if (map2 != null) {
            java.util.Iterator it2 = map2.keySet().iterator();
            do {
                if (!it2.hasNext()) {
                    str2 = null;
                    break;
                }
                str2 = (java.lang.String) it2.next();
            } while (!str2.startsWith(str + "_"));
            if (android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            this.h.remove(str2);
        }
    }

    public void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        android.app.Dialog lossDialog = io.dcloud.common.util.ErrorDialogUtil.getLossDialog(iWebview, io.dcloud.common.util.StringUtil.format(iWebview.getContext().getString(io.dcloud.base.R.string.dcloud_feature_error_tips2) + "https://ask.dcloud.net.cn/article/283", str), "https://ask.dcloud.net.cn/article/283", str);
        if (lossDialog != null) {
            lossDialog.show();
        }
    }
}
