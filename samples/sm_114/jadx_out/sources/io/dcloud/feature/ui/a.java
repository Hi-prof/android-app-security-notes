package io.dcloud.feature.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class a implements io.dcloud.common.DHInterface.ISysEventListener {
    io.dcloud.common.DHInterface.AbsMgr d;
    io.dcloud.common.DHInterface.IApp f;
    io.dcloud.common.DHInterface.IActivityHandler g;
    android.content.SharedPreferences k;
    private io.dcloud.feature.ui.c l;
    io.dcloud.common.DHInterface.IWebview a = null;
    java.util.List b = null;
    java.util.List c = new java.util.ArrayList(1);
    java.util.HashMap e = new java.util.HashMap();
    boolean h = false;
    boolean i = false;
    boolean j = false;
    private java.util.List m = new java.util.ArrayList();
    boolean n = false;
    java.util.ArrayList o = null;
    private io.dcloud.feature.ui.a.C0045a p = new io.dcloud.feature.ui.a.C0045a();
    java.lang.StringBuffer q = new java.lang.StringBuffer();
    java.util.HashMap r = new java.util.HashMap();

    /* JADX INFO: renamed from: io.dcloud.feature.ui.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class C0045a implements java.util.Comparator {
        C0045a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(io.dcloud.feature.ui.c cVar, io.dcloud.feature.ui.c cVar2) {
            int i = cVar.E - cVar2.E;
            if (i == 0) {
                return cVar.u > cVar2.u ? 1 : -1;
            }
            return i;
        }
    }

    a(io.dcloud.common.DHInterface.AbsMgr absMgr, io.dcloud.common.DHInterface.IApp iApp) {
        this.f = null;
        this.g = null;
        io.dcloud.common.adapter.util.Logger.e("IAN", "new AppWidgetMgr   " + java.lang.System.currentTimeMillis() + "appid==" + iApp.obtainAppId());
        this.d = absMgr;
        this.f = iApp;
        this.k = io.dcloud.application.DCLoudApplicationImpl.self().getContext().getApplicationContext().getSharedPreferences("pdr", 0);
        io.dcloud.common.DHInterface.IActivityHandler iActivityHandler = io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(iApp.getActivity());
        if (iActivityHandler != null) {
            this.g = iActivityHandler;
        }
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp);
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyDown);
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyLongPress);
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppSrcUpZip);
    }

    private void h() {
        for (io.dcloud.feature.ui.c cVar : this.c) {
            if (cVar.D) {
                cVar.y.obtainWebView().loadUrl(cVar.z);
                cVar.D = false;
            }
        }
    }

    void a(java.lang.String str, io.dcloud.feature.ui.b bVar) {
        this.e.put(str, bVar);
    }

    public void b(io.dcloud.common.DHInterface.IFrameView iFrameView) {
        this.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 8, iFrameView);
    }

    boolean c(java.lang.String str) {
        return false;
    }

    io.dcloud.feature.ui.c d() {
        return a(3);
    }

    void e(io.dcloud.feature.ui.c cVar) {
        if (this.c.contains(cVar)) {
            return;
        }
        this.c.add(cVar);
    }

    void f(io.dcloud.feature.ui.c cVar) {
        if (cVar.C) {
            return;
        }
        io.dcloud.common.adapter.util.Logger.d("AppWidgetMgr.showMaskLayer " + cVar.z);
        if (this.o == null) {
            this.o = new java.util.ArrayList();
        }
        cVar.C = true;
        this.o.add(cVar);
        this.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 29, cVar.y);
    }

    void g(io.dcloud.feature.ui.c cVar) {
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.MAP_TAG, "sortNWindowByZIndex beign");
        java.util.Collections.sort(this.c, this.p);
        java.util.Collections.sort(this.b, this.p);
        this.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 26, cVar.y.obtainWebAppRootView());
    }

    void i() {
        io.dcloud.common.DHInterface.IFrameView iFrameView = (io.dcloud.common.DHInterface.IFrameView) this.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 44, this.f);
        int frameType = iFrameView.getFrameType();
        if (frameType != 2 && frameType != 4 && frameType != 5) {
            iFrameView.obtainApp().setNeedRefreshApp(true);
            return;
        }
        iFrameView.obtainApp().setNeedRefreshApp(false);
        int size = this.c.size();
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        for (int i = size - 1; i >= 0; i--) {
            io.dcloud.feature.ui.c cVar = (io.dcloud.feature.ui.c) this.c.get(i);
            int frameType2 = cVar.y.getFrameType();
            if (frameType2 == 2) {
                a(cVar.y.obtainApp(), cVar.y.obtainWebView());
            } else if (frameType2 == 4 || frameType2 == 5) {
                cVar.a(cVar, true);
            } else {
                cVar.b(cVar.y.obtainWebView(), jSONArray, cVar);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0115 A[PHI: r2
  0x0115: PHI (r2v1 boolean) = (r2v0 boolean), (r2v8 boolean) binds: [B:24:0x0053, B:52:0x0107] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // io.dcloud.common.DHInterface.ISysEventListener
    public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType2;
        java.lang.String str;
        io.dcloud.common.DHInterface.IFrameView iFrameView;
        boolean z = true;
        if (io.dcloud.common.util.BaseInfo.sDoingAnimation) {
            return true;
        }
        io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType3 = io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp;
        boolean zA = false;
        if (sysEventType != sysEventType3 && sysEventType != io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyDown && sysEventType != io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyLongPress) {
            if (sysEventType != io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStop) {
                if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppSrcUpZip) {
                    f();
                    h();
                }
                return false;
            }
            for (io.dcloud.feature.ui.c cVar : this.c) {
                cVar.d().onDispose();
                cVar.d().dispose();
            }
            return true;
        }
        java.lang.Integer num = (java.lang.Integer) ((java.lang.Object[]) obj)[0];
        int iIntValue = num.intValue();
        if (sysEventType != sysEventType3) {
            sysEventType2 = sysEventType;
        } else if (iIntValue == 4) {
            io.dcloud.feature.ui.c cVarD = d();
            if (cVarD != null) {
                iFrameView = cVarD.y;
                boolean zB = cVarD.b("back", io.dcloud.common.util.StringUtil.format("{keyType:'%s',keyCode:%d}", "back", num), false);
                if (zB || this.c.size() != 1) {
                    zA = zB;
                } else {
                    this.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 20, this.f);
                    zA = true;
                }
            } else {
                iFrameView = (io.dcloud.common.DHInterface.IFrameView) this.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 43, this.f);
            }
            if (!zA && iFrameView != null) {
                io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = iFrameView.obtainWebView();
                if (iWebviewObtainWebView.canGoBack()) {
                    iWebviewObtainWebView.goBackOrForward(-1);
                    zA = true;
                } else if (cVarD != null) {
                    b(cVarD);
                    cVarD.e();
                }
                if (!zA) {
                    java.util.Collections.sort(this.c, this.p);
                    java.util.Collections.sort(this.b, this.p);
                    io.dcloud.common.DHInterface.AbsMgr absMgr = this.d;
                    io.dcloud.common.DHInterface.IMgr.MgrType mgrType = io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr;
                    absMgr.processEvent(mgrType, 26, this.f.obtainWebAppRootView());
                    io.dcloud.common.adapter.util.AnimOptions animOptions = ((io.dcloud.common.adapter.ui.AdaFrameItem) iFrameView).getAnimOptions();
                    if (io.dcloud.common.util.PdrUtil.isEmpty(com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT)) {
                        animOptions.duration_close = animOptions.duration_show;
                    } else {
                        animOptions.duration_close = io.dcloud.common.util.PdrUtil.parseInt(com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT, animOptions.duration_close);
                    }
                    animOptions.mOption = (byte) 1;
                    animOptions.setCloseAnimType(io.dcloud.common.util.PdrUtil.isEmpty("none") ? "auto" : "none");
                    this.d.processEvent(mgrType, 2, iFrameView);
                    zA = true;
                }
            }
            if (zA) {
                sysEventType2 = sysEventType;
            } else {
                sysEventType2 = sysEventType;
                zA = a("back", sysEventType2, "back", iIntValue, false);
            }
        } else {
            sysEventType2 = sysEventType;
            if (iIntValue == 82) {
                zA = a(io.dcloud.common.constant.AbsoluteConst.EVENTS_MENU, sysEventType2, io.dcloud.common.constant.AbsoluteConst.EVENTS_MENU, iIntValue, false);
            } else if (iIntValue == 24) {
                zA = a(io.dcloud.common.constant.AbsoluteConst.EVENTS_VOLUME_UP, sysEventType2, io.dcloud.common.constant.AbsoluteConst.EVENTS_VOLUME_UP, iIntValue, false);
            } else if (iIntValue == 25) {
                zA = a(io.dcloud.common.constant.AbsoluteConst.EVENTS_VOLUME_DOWN, sysEventType2, io.dcloud.common.constant.AbsoluteConst.EVENTS_VOLUME_DOWN, iIntValue, false);
            } else if (iIntValue == 84) {
                zA = a("search", sysEventType2, "search", iIntValue, false);
            }
        }
        if (sysEventType2 == sysEventType3) {
            str = io.dcloud.common.constant.AbsoluteConst.EVENTS_KEY_UP;
        } else if (sysEventType2 == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyDown) {
            str = io.dcloud.common.constant.AbsoluteConst.EVENTS_KEY_DOWN;
        } else {
            str = sysEventType2 == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyLongPress ? io.dcloud.common.constant.AbsoluteConst.EVENTS_LONG_PRESSED : null;
        }
        java.lang.String str2 = str;
        if (io.dcloud.common.adapter.util.DeviceInfo.isVolumeButtonEnabled || (iIntValue != 24 && iIntValue != 25)) {
            z = zA;
        }
        return a(str2, sysEventType2, str2, iIntValue, false) | z;
    }

    io.dcloud.feature.ui.b a(java.lang.String str) {
        return (io.dcloud.feature.ui.b) this.e.get(str);
    }

    boolean b(io.dcloud.common.DHInterface.IWebview iWebview) {
        return this.a == iWebview;
    }

    public void c(io.dcloud.common.DHInterface.IFrameView iFrameView) {
        this.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 22, iFrameView);
    }

    void d(io.dcloud.feature.ui.c cVar) {
        if (cVar == null) {
            return;
        }
        io.dcloud.common.adapter.util.Logger.d("AppWidgetMgr.hideMaskLayer " + cVar.z);
        this.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 30, cVar.y);
        cVar.C = false;
        java.util.ArrayList arrayList = this.o;
        if (arrayList != null) {
            arrayList.remove(cVar);
        }
    }

    void a() {
        this.c.clear();
    }

    synchronized java.lang.String b() {
        java.lang.StringBuffer stringBuffer;
        stringBuffer = new java.lang.StringBuffer(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
        boolean z = false;
        for (io.dcloud.feature.ui.c cVar : this.c) {
            if (!a(cVar.r()) && !cVar.p()) {
                stringBuffer.append(cVar.h()).append(",");
                z = true;
            }
        }
        if (z) {
            stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        }
        stringBuffer.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        return stringBuffer.toString();
    }

    int c(io.dcloud.feature.ui.c cVar) {
        int size = this.b.size();
        for (int i = size - 1; i >= 0; i--) {
            if (((io.dcloud.feature.ui.c) this.b.get(i)).E <= cVar.E) {
                return i + 1;
            }
        }
        return size;
    }

    synchronized java.lang.String e() {
        java.lang.StringBuffer stringBuffer;
        stringBuffer = new java.lang.StringBuffer(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
        boolean z = false;
        for (io.dcloud.feature.ui.c cVar : this.c) {
            if (cVar.o() && !cVar.p()) {
                stringBuffer.append(cVar.h()).append(",");
                z = true;
            }
        }
        if (z) {
            stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        }
        stringBuffer.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        return stringBuffer.toString();
    }

    void a(java.lang.String str, io.dcloud.feature.ui.c cVar, int i) {
        if (this.b == null) {
            this.b = java.util.Collections.synchronizedList(new java.util.ArrayList(1));
        }
        if (!this.b.contains(cVar)) {
            this.b.add(i, cVar);
        }
        java.util.Collections.sort(this.c, this.p);
        java.util.Collections.sort(this.b, this.p);
    }

    void g() {
        this.a = null;
    }

    private void f() {
        d(this.l);
    }

    void c(io.dcloud.common.DHInterface.IWebview iWebview) {
        this.a = iWebview;
    }

    io.dcloud.feature.ui.c c() {
        return a(2);
    }

    boolean a(io.dcloud.common.DHInterface.IWebview iWebview) {
        return iWebview.obtainFrameView().getFrameType() == 6 && !b(iWebview);
    }

    io.dcloud.feature.ui.c a(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            io.dcloud.feature.ui.c cVar = (io.dcloud.feature.ui.c) this.c.get(i2);
            if (cVar.y.getFrameType() == i) {
                return cVar;
            }
        }
        return null;
    }

    void b(io.dcloud.feature.ui.c cVar) {
        this.b.remove(cVar);
        this.c.remove(cVar);
    }

    public boolean b(java.lang.String str) {
        boolean z = true;
        if (this.g != null && str != null) {
            if (!io.dcloud.common.util.PdrUtil.isNetPath(str.toLowerCase(java.util.Locale.getDefault())) && c(this.f.obtainAppId()) && io.dcloud.common.util.BaseInfo.isWap2AppAppid(this.f.obtainAppId())) {
                if (str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                    str = str.substring(7);
                }
                str = io.dcloud.common.util.PdrUtil.stripQuery(io.dcloud.common.util.PdrUtil.stripAnchor(str));
                java.lang.String strConvert2RelPath = this.f.convert2RelPath(str);
                if (strConvert2RelPath.startsWith(io.dcloud.common.util.BaseInfo.REL_PRIVATE_WWW_DIR)) {
                    strConvert2RelPath = strConvert2RelPath.substring(5);
                }
                if (!io.dcloud.common.util.BaseInfo.containsInTemplate(this.f, strConvert2RelPath) && !new java.io.File(str).exists()) {
                    z = false;
                }
            }
            io.dcloud.common.adapter.util.Logger.d("hasFile = " + z + ";filePath=" + str);
        }
        return z;
    }

    io.dcloud.feature.ui.c a(io.dcloud.common.DHInterface.IFrameView iFrameView) {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            io.dcloud.feature.ui.c cVar = (io.dcloud.feature.ui.c) this.c.get(i);
            if (cVar.y.equals(iFrameView)) {
                return cVar;
            }
        }
        return null;
    }

    synchronized io.dcloud.feature.ui.c a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            io.dcloud.feature.ui.c cVar = (io.dcloud.feature.ui.c) this.c.get(i);
            java.lang.String strValueOf = java.lang.String.valueOf(cVar.y.hashCode());
            java.lang.String strM = cVar.m();
            if ((io.dcloud.common.util.PdrUtil.isEquals(str, strValueOf) || io.dcloud.common.util.PdrUtil.isEquals(str2, cVar.e) || io.dcloud.common.util.PdrUtil.isEquals(str3, strM)) && !a(cVar.r())) {
                return cVar;
            }
        }
        return null;
    }

    private boolean a(java.lang.String str, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.String str2, int i, boolean z) {
        java.lang.String str3 = io.dcloud.common.util.StringUtil.format("{keyType:'%s',keyCode:%d}", str2, java.lang.Integer.valueOf(i));
        java.util.List list = this.b;
        if (list != null) {
            int size = list.size();
            io.dcloud.common.adapter.util.Logger.d("AppWidgetMgr", "syncExecBaseEvent windowCount = " + size);
            int i2 = size - 1;
            for (int i3 = i2; i3 >= 0; i3--) {
                io.dcloud.feature.ui.c cVar = (io.dcloud.feature.ui.c) this.b.get(i3);
                if (cVar != null && cVar.a == null && ((cVar.p() || cVar.F) && cVar.y.getFrameType() != 6)) {
                    if ((i2 == i3 && "back".equals(str) && cVar.c(str, str3, z)) || cVar.b(str, str3, z)) {
                        return true;
                    }
                    if (!io.dcloud.common.util.BaseInfo.USE_ACTIVITY_HANDLE_KEYEVENT && str2 != null && (cVar.b(str2) || (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyDown && ((cVar.b("back") && i == 4) || ((cVar.b(io.dcloud.common.constant.AbsoluteConst.EVENTS_MENU) && i == 82) || ((cVar.b(io.dcloud.common.constant.AbsoluteConst.EVENTS_VOLUME_DOWN) && i == 25) || ((cVar.b(io.dcloud.common.constant.AbsoluteConst.EVENTS_VOLUME_UP) && i == 24) || (cVar.b("search") && i == 84)))))))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean a(io.dcloud.feature.ui.c cVar) {
        if (!c(this.f.obtainAppId())) {
            cVar.D = false;
        }
        if (cVar.D && b(cVar.z)) {
            cVar.r().loadUrl(cVar.z);
            cVar.D = false;
        }
        return cVar.D;
    }

    void a(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IWebview iWebview) {
        if (!iWebview.getWebviewProperty("plusrequire").equals("none")) {
            iWebview.appendPreloadJsFile(iApp.convert2AbsFullPath(null, "_www/__wap2app.js"));
            iWebview.appendPreloadJsFile(iApp.convert2AbsFullPath(null, "_www/__wap2appconfig.js"));
        }
        iWebview.setPreloadJsFile(iApp.convert2AbsFullPath(iWebview.obtainFullUrl(), "_www/server_index_append.js"), true);
        java.lang.String strConvert2AbsFullPath = iApp.convert2AbsFullPath(null, "_www/server_index_append.css");
        if (new java.io.File(strConvert2AbsFullPath).exists()) {
            iWebview.setCssFile(strConvert2AbsFullPath, null);
            return;
        }
        java.lang.String strConvert2AbsFullPath2 = iApp.convert2AbsFullPath(null, "_www/__wap2app.css");
        if (new java.io.File(strConvert2AbsFullPath2).exists()) {
            iWebview.setCssFile(strConvert2AbsFullPath2, null);
        }
    }
}
