package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class x2 implements io.dcloud.common.DHInterface.IEventCallback {
    static java.util.HashMap b = new java.util.HashMap(2);
    static io.dcloud.p.x2 c = null;
    java.util.ArrayList a = new java.util.ArrayList();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends io.dcloud.common.adapter.util.PermissionUtil.Request {
        final /* synthetic */ org.json.JSONArray a;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview b;
        final /* synthetic */ java.lang.String[] c;
        final /* synthetic */ org.json.JSONArray d;
        final /* synthetic */ org.json.JSONArray e;
        final /* synthetic */ org.json.JSONArray f;

        a(org.json.JSONArray jSONArray, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String[] strArr, org.json.JSONArray jSONArray2, org.json.JSONArray jSONArray3, org.json.JSONArray jSONArray4) {
            this.a = jSONArray;
            this.b = iWebview;
            this.c = strArr;
            this.d = jSONArray2;
            this.e = jSONArray3;
            this.f = jSONArray4;
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onDenied(java.lang.String str) {
            java.lang.String strConvertNativePermission = io.dcloud.common.adapter.util.PermissionUtil.convertNativePermission(str);
            try {
                if (androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale(this.b.getActivity(), strConvertNativePermission)) {
                    this.e.put(strConvertNativePermission);
                } else {
                    this.f.put(strConvertNativePermission);
                }
            } catch (java.lang.RuntimeException unused) {
            }
            io.dcloud.p.x2.this.a(this.b, this.c, this.d, this.a, this.e, this.f);
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onGranted(java.lang.String str) {
            this.a.put(io.dcloud.common.adapter.util.PermissionUtil.convertNativePermission(str));
            io.dcloud.p.x2.this.a(this.b, this.c, this.d, this.a, this.e, this.f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements io.dcloud.common.DHInterface.ISysEventListener {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;

        b(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.DHInterface.ISysEventListener
        public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
            if (sysEventType != io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult) {
                return false;
            }
            java.lang.Object[] objArr = (java.lang.Object[]) obj;
            int iIntValue = ((java.lang.Integer) objArr[0]).intValue();
            int iIntValue2 = ((java.lang.Integer) objArr[1]).intValue();
            android.content.Intent intent = (android.content.Intent) objArr[2];
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
            stringBuffer.append(iIntValue);
            stringBuffer.append(",").append(iIntValue2);
            if (intent != null) {
                stringBuffer.append(",").append(io.dcloud.p.x2.a(this.a, intent));
            }
            stringBuffer.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, stringBuffer.toString(), io.dcloud.common.util.JSUtil.OK, true, true);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements io.dcloud.common.DHInterface.IEventCallback {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ io.dcloud.common.DHInterface.ISysEventListener b;

        c(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.common.DHInterface.ISysEventListener iSysEventListener) {
            this.a = iWebview;
            this.b = iSysEventListener;
        }

        @Override // io.dcloud.common.DHInterface.IEventCallback
        public java.lang.Object onCallBack(java.lang.String str, java.lang.Object obj) {
            if (!io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_WINDOW_CLOSE) && !io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE)) {
                return null;
            }
            this.a.obtainApp().unregisterSysEventListener(this.b, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.values().length];
            a = iArr;
            try {
                iArr[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
        }
    }

    public x2(io.dcloud.common.DHInterface.AbsMgr absMgr) {
        c = this;
    }

    static void b(java.lang.Class cls, org.json.JSONStringer jSONStringer, java.util.ArrayList arrayList) throws org.json.JSONException {
        for (java.lang.Class superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            java.lang.String name = superclass.getName();
            if (!arrayList.contains(name)) {
                jSONStringer.value(name);
                arrayList.add(name);
                a(superclass, jSONStringer, arrayList);
            }
            if (superclass == java.lang.Object.class) {
                return;
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.IEventCallback
    public java.lang.Object onCallBack(java.lang.String str, java.lang.Object obj) {
        if (!io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE) || !(obj instanceof io.dcloud.common.DHInterface.IWebview)) {
            return null;
        }
        try {
            ((io.dcloud.common.adapter.ui.AdaFrameView) ((io.dcloud.common.DHInterface.IWebview) obj).obtainFrameView()).removeFrameViewListener(this);
            this.a.remove(java.lang.Integer.valueOf(((io.dcloud.common.DHInterface.IWebview) obj).hashCode()));
            java.util.HashMap map = (java.util.HashMap) b.remove(java.lang.Integer.valueOf(((io.dcloud.common.DHInterface.IWebview) obj).hashCode()));
            if (map == null) {
                return null;
            }
            for (java.util.Map.Entry entry : map.entrySet()) {
                b.remove(entry.getKey());
                ((io.dcloud.p.j3) entry.getValue()).a();
            }
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public java.lang.String a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        io.dcloud.p.j3 j3Var;
        org.json.JSONArray jSONArray;
        java.lang.Class cls;
        java.lang.String str2;
        java.lang.Object objA;
        org.json.JSONArray jSONArray2;
        io.dcloud.p.x2 x2Var = this;
        java.lang.String[] strArr2 = strArr;
        if (!x2Var.a.contains(java.lang.Integer.valueOf(iWebview.hashCode()))) {
            x2Var.a.add(java.lang.Integer.valueOf(iWebview.hashCode()));
            ((io.dcloud.common.adapter.ui.AdaFrameView) iWebview.obtainFrameView()).addFrameViewListener(x2Var);
        }
        boolean zOptBoolean = true;
        int i = 0;
        if ("__Instance".equals(str)) {
            java.lang.String str3 = strArr2[0];
            java.lang.String str4 = strArr2[1];
            if (strArr2.length <= 2 || io.dcloud.common.util.PdrUtil.isEmpty(strArr2[2])) {
                jSONArray2 = null;
            } else {
                org.json.JSONArray jSONArrayCreateJSONArray = io.dcloud.common.util.JSONUtil.createJSONArray(strArr2[2]);
                org.json.JSONObject jSONObject = io.dcloud.common.util.JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 0);
                zOptBoolean = jSONObject != null ? "boolean".equals(jSONObject.optString("type")) ? jSONObject.optBoolean("value") : true ^ io.dcloud.common.util.PdrUtil.isEquals("__super__constructor__", io.dcloud.common.util.JSONUtil.getString(jSONObject, "value")) : true;
                jSONArray2 = jSONArrayCreateJSONArray;
            }
            if (zOptBoolean) {
                try {
                    try {
                        a(iWebview, str3, new io.dcloud.p.j3(iWebview, x2Var, io.dcloud.p.k3.a(str4), str3, jSONArray2));
                        return null;
                    } catch (java.lang.Exception e) {
                        e = e;
                        java.lang.String strA = a(e, "new " + str4);
                        android.util.Log.e("InvProxy", "NativeObject.execMethod __Instance " + str4 + " method ; params=" + jSONArray2 + e);
                        return strA;
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                }
            }
        } else {
            io.dcloud.common.DHInterface.IWebview iWebview2 = iWebview;
            if ("release".equals(str) || "__autoCollection".equals(str)) {
                java.lang.String str5 = strArr[0];
                java.util.HashMap mapA = a(iWebview);
                if (mapA != null && (j3Var = (io.dcloud.p.j3) mapA.remove(str5)) != null) {
                    j3Var.a();
                }
            } else {
                if ("getWebviewById".equals(str)) {
                    return b(iWebview2, io.dcloud.feature.internal.sdk.SDK.obtainWebview(iWebview2.obtainFrameView().obtainApp().obtainAppId(), strArr2[0]).obtainWebview());
                }
                if ("currentWebview".equals(str)) {
                    return iWebview2 instanceof io.dcloud.common.adapter.ui.AdaUniWebView ? "" : b(iWebview2, iWebview2.obtainWebview());
                }
                if ("getContext".equals(str)) {
                    java.lang.String str6 = strArr2[0];
                    java.lang.String strB = b(iWebview2, iWebview2.getActivity());
                    x2Var.a(iWebview2, "onActivityResult", str6);
                    return strB;
                }
                if ("importFields".equals(str)) {
                    io.dcloud.p.j3 j3VarA = x2Var.a(iWebview2, strArr2[0]);
                    if (j3VarA != null) {
                        return io.dcloud.common.util.JSUtil.wrapJsVar(j3VarA.a(iWebview2, j3VarA.a));
                    }
                } else {
                    if ("import".equals(str)) {
                        return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(io.dcloud.p.k3.a(iWebview2, x2Var, strArr2[0]), false);
                    }
                    if ("__plusGetAttribute".equals(str)) {
                        java.lang.String str7 = strArr2[0];
                        java.lang.String str8 = strArr2[1];
                        io.dcloud.p.j3 j3VarA2 = x2Var.a(iWebview2, str7);
                        if (j3VarA2 != null && (objA = io.dcloud.p.j3.a(j3VarA2.b, j3VarA2.c, str8)) != null) {
                            return b(iWebview2, objA);
                        }
                    } else if ("__plusSetAttribute".equals(str)) {
                        java.lang.String str9 = strArr2[0];
                        java.lang.String str10 = strArr2[1];
                        org.json.JSONArray jSONArrayCreateJSONArray2 = io.dcloud.common.util.JSONUtil.createJSONArray(strArr2[2]);
                        io.dcloud.p.j3 j3VarA3 = x2Var.a(iWebview2, str9);
                        if (j3VarA3 != null) {
                            io.dcloud.p.j3.b(iWebview, x2Var, j3VarA3.b, j3VarA3.c, str10, jSONArrayCreateJSONArray2);
                            return null;
                        }
                    } else {
                        if ("implements".equals(str)) {
                            java.lang.String str11 = strArr2[0];
                            io.dcloud.p.y2 y2Var = new io.dcloud.p.y2(iWebview2, strArr2[1], io.dcloud.common.util.JSONUtil.createJSONArray(strArr2[2]), strArr2[3]);
                            y2Var.a = str11;
                            return b(iWebview2, y2Var.a(null));
                        }
                        if (!"__loadDylib".equals(str) && !"__release".equals(str)) {
                            if ("__inheritList".equals(str)) {
                                java.lang.String str12 = strArr2[0];
                                try {
                                    java.lang.String str13 = strArr2[1];
                                    if (android.text.TextUtils.isEmpty(str13)) {
                                        return io.dcloud.p.k3.b(str12);
                                    }
                                    io.dcloud.p.j3 j3VarA4 = x2Var.a(iWebview2, str13);
                                    return j3VarA4 != null ? io.dcloud.p.k3.c(j3VarA4.b) : io.dcloud.p.k3.b(str12);
                                } catch (java.lang.Exception e3) {
                                    return a(e3, "importClass " + str12);
                                }
                            }
                            if (!"__execCFunction".equals(str)) {
                                if ("__newObject".equals(str)) {
                                    java.lang.String str14 = strArr2[0];
                                    org.json.JSONArray jSONArrayCreateJSONArray3 = io.dcloud.common.util.JSONUtil.createJSONArray(strArr2[1]);
                                    try {
                                        return b(iWebview2, io.dcloud.p.j3.a(iWebview2, x2Var, io.dcloud.p.k3.a(str14), jSONArrayCreateJSONArray3));
                                    } catch (java.lang.Exception e4) {
                                        java.lang.String strA2 = a(e4, "newObject " + str14);
                                        android.util.Log.e("InvProxy", "NativeObject.execMethod __newObject " + str14 + " method ; params=" + jSONArrayCreateJSONArray3 + e4);
                                        return strA2;
                                    }
                                }
                                if ("__execStatic".equals(str)) {
                                    java.lang.String str15 = strArr2[0];
                                    java.lang.String str16 = strArr2[1];
                                    if (!x2Var.a(str15, str16, iWebview2)) {
                                        org.json.JSONArray jSONArrayCreateJSONArray4 = (strArr2.length <= 2 || io.dcloud.common.util.PdrUtil.isEmpty(strArr2[2])) ? null : io.dcloud.common.util.JSONUtil.createJSONArray(strArr2[2]);
                                        java.lang.Class clsA = io.dcloud.p.k3.a(str15);
                                        if (clsA == null) {
                                            str2 = str15;
                                            cls = java.lang.String.class;
                                        } else {
                                            cls = clsA;
                                            str2 = null;
                                        }
                                        try {
                                            java.lang.Object objA2 = io.dcloud.p.j3.a(iWebview2, x2Var, cls, str2, str16, jSONArrayCreateJSONArray4);
                                            if (objA2 != null) {
                                                try {
                                                    return b(iWebview2, objA2);
                                                } catch (java.lang.Exception e5) {
                                                    e = e5;
                                                    java.lang.String strA3 = a(e, "static " + cls.getName() + com.taobao.weex.el.parse.Operators.DOT_STR + str16);
                                                    android.util.Log.e("InvProxy", "NativeObject.execMethod " + str16 + " method ; params=" + cls + e);
                                                    return strA3;
                                                }
                                            }
                                        } catch (java.lang.Exception e6) {
                                            e = e6;
                                        }
                                    }
                                } else if ("__exec".equals(str)) {
                                    java.lang.String str17 = strArr2[0];
                                    java.lang.String str18 = strArr2[1];
                                    if (!x2Var.a("", str18, iWebview2)) {
                                        org.json.JSONArray jSONArrayCreateJSONArray5 = io.dcloud.common.util.JSONUtil.createJSONArray(strArr2[2]);
                                        io.dcloud.p.j3 j3VarA5 = x2Var.a(iWebview2, str17);
                                        if (j3VarA5 != null) {
                                            try {
                                                java.lang.Object objA3 = j3VarA5.a(iWebview2, str18, jSONArrayCreateJSONArray5);
                                                if (objA3 != null) {
                                                    return b(iWebview2, objA3);
                                                }
                                            } catch (java.lang.Exception e7) {
                                                java.lang.String strA4 = a(e7, j3VarA5.b.getName() + com.taobao.weex.el.parse.Operators.DOT_STR + str18);
                                                android.util.Log.e("InvProxy", "NativeObject.execMethod " + str18 + " method ; params=" + jSONArrayCreateJSONArray5 + e7);
                                                return strA4;
                                            }
                                        }
                                    }
                                } else {
                                    if ("__saveContent".equals(str)) {
                                        io.dcloud.common.adapter.io.DHFile.writeFile(strArr2[1].toString().getBytes(), 0, iWebview2.obtainFrameView().obtainApp().convert2AbsFullPath(iWebview2.obtainFullUrl(), strArr2[0]));
                                        return null;
                                    }
                                    if ("requestPermissions".equals(str)) {
                                        org.json.JSONArray jSONArrayCreateJSONArray6 = io.dcloud.common.util.JSONUtil.createJSONArray(strArr2[1]);
                                        java.util.ArrayList arrayList = new java.util.ArrayList();
                                        org.json.JSONArray jSONArray3 = new org.json.JSONArray();
                                        org.json.JSONArray jSONArray4 = new org.json.JSONArray();
                                        org.json.JSONArray jSONArray5 = new org.json.JSONArray();
                                        java.util.ArrayList arrayList2 = new java.util.ArrayList();
                                        int i2 = 0;
                                        while (i2 < jSONArrayCreateJSONArray6.length()) {
                                            java.lang.String strOptString = jSONArrayCreateJSONArray6.optString(i2);
                                            int iCheckSelfPermission = androidx.core.content.PermissionChecker.checkSelfPermission(iWebview2.getActivity(), strOptString);
                                            arrayList2.add(strOptString);
                                            if (iCheckSelfPermission != 0) {
                                                if (iWebview2.getActivity().getApplicationInfo().targetSdkVersion < 23 || android.os.Build.VERSION.SDK_INT < 23) {
                                                    jSONArray5.put(strOptString);
                                                    x2Var.a(iWebview2, strArr2, jSONArrayCreateJSONArray6, jSONArray3, jSONArray4, jSONArray4);
                                                } else {
                                                    arrayList.add(strOptString);
                                                }
                                                jSONArray = jSONArray5;
                                            } else {
                                                jSONArray3.put(strOptString);
                                                jSONArray = jSONArray5;
                                                a(iWebview, strArr, jSONArrayCreateJSONArray6, jSONArray3, jSONArray4, jSONArray);
                                            }
                                            i2++;
                                            x2Var = this;
                                            iWebview2 = iWebview;
                                            strArr2 = strArr;
                                            jSONArray5 = jSONArray;
                                        }
                                        org.json.JSONArray jSONArray6 = jSONArray5;
                                        io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_REQUEST, (java.lang.String[]) arrayList2.toArray(new java.lang.String[0]));
                                        if (arrayList.size() == 0) {
                                            io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE, (java.lang.String[]) arrayList2.toArray(new java.lang.String[0]));
                                            return null;
                                        }
                                        if (jSONArray3.length() > 0 || jSONArray6.length() > 0) {
                                            java.util.ArrayList arrayList3 = new java.util.ArrayList();
                                            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                                                arrayList3.add(jSONArray3.optString(i3));
                                            }
                                            for (int i4 = 0; i4 < jSONArray6.length(); i4++) {
                                                arrayList3.add(jSONArray6.optString(i4));
                                            }
                                            io.dcloud.common.core.permission.PermissionControler.invokeUTSAndroidPermissionRequest(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE, (java.lang.String[]) arrayList3.toArray(new java.lang.String[0]));
                                        }
                                        java.lang.String[] strArr3 = (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
                                        io.dcloud.p.x2.a aVar = new io.dcloud.p.x2.a(jSONArray3, iWebview, strArr, jSONArrayCreateJSONArray6, jSONArray4, jSONArray6);
                                        aVar.setTriggerRequestEvent(true);
                                        io.dcloud.common.adapter.util.PermissionUtil.requestSystemPermissions(iWebview.getActivity(), strArr3, io.dcloud.common.adapter.util.PermissionUtil.getRequestCode(), aVar, false);
                                        return null;
                                    }
                                    if ("checkPermission".equals(str)) {
                                        java.lang.String str19 = strArr[0];
                                        int iCheckSelfPermission2 = androidx.core.content.PermissionChecker.checkSelfPermission(iWebview.getActivity(), strArr[1]);
                                        if (iCheckSelfPermission2 == -2) {
                                            i = -2;
                                        } else if (iCheckSelfPermission2 == -1) {
                                            i = -1;
                                        } else if (iCheckSelfPermission2 != 0) {
                                            i = iCheckSelfPermission2;
                                        }
                                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str19, "{checkResult:+" + i + com.taobao.weex.el.parse.Operators.BLOCK_END_STR, io.dcloud.common.util.JSUtil.OK, true, false);
                                        return null;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    static java.lang.String b(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.Object obj) {
        java.lang.String str;
        java.lang.Class<?> cls = obj.getClass();
        java.lang.String strB = io.dcloud.p.k3.b(cls);
        if (!io.dcloud.p.k3.a((java.lang.Class) cls) && cls != java.lang.String.class && cls != java.lang.CharSequence.class && !cls.isArray()) {
            str = "object";
        } else {
            str = "basic";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        a(iWebview, obj, cls, stringBuffer);
        return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(io.dcloud.common.util.StringUtil.format("{\"type\":\"%s\", \"value\":%s, \"className\":\"%s\",\"superClassNames\":%s}", str, stringBuffer.toString(), strB, a((java.lang.Class) cls)), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String[] strArr, org.json.JSONArray jSONArray, org.json.JSONArray jSONArray2, org.json.JSONArray jSONArray3, org.json.JSONArray jSONArray4) {
        if (jSONArray.length() == jSONArray2.length() + jSONArray3.length() + jSONArray4.length()) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("granted", jSONArray2);
                jSONObject.put("deniedPresent", jSONArray3);
                jSONObject.put("deniedAlways", jSONArray4);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strArr[0], jSONObject.toString(), io.dcloud.common.util.JSUtil.OK, true, false);
        }
    }

    private static java.lang.String a(java.lang.Exception exc, java.lang.String str) {
        java.lang.Exception message;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (exc.getCause() != null) {
            message = exc.getCause();
        } else if (!android.text.TextUtils.isEmpty(exc.getMessage())) {
            message = exc;
            message = exc.getMessage();
        }
        message = exc;
        sb.append(message);
        sb.append(";at ");
        sb.append(str);
        return io.dcloud.common.util.StringUtil.format("throw '%s';", sb.toString());
    }

    private void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        if (io.dcloud.p.x2.d.a[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.valueOf(str).ordinal()] != 1) {
            return;
        }
        io.dcloud.p.x2.b bVar = new io.dcloud.p.x2.b(iWebview, str2);
        iWebview.obtainApp().registerSysEventListener(bVar, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult);
        iWebview.obtainFrameView().addFrameViewListener(new io.dcloud.p.x2.c(iWebview, bVar));
    }

    static java.lang.String a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.Object obj) {
        java.lang.String strValueOf;
        java.lang.Class<?> cls = obj.getClass();
        java.lang.String strB = io.dcloud.p.k3.b(cls);
        if (cls != java.lang.String.class && cls != java.lang.CharSequence.class) {
            if (io.dcloud.p.k3.a((java.lang.Class) cls)) {
                strValueOf = java.lang.String.valueOf(obj);
            } else {
                java.lang.String strA = a(obj);
                a(iWebview, strA, obj);
                return io.dcloud.common.util.StringUtil.format("plus.ios.__Tool.New(%s, true)", io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(io.dcloud.common.util.StringUtil.format("{\"type\":\"%s\", \"value\":%s, \"className\":\"%s\",\"superClassNames\":%s}", "object", io.dcloud.common.util.JSUtil.QUOTE + strA + io.dcloud.common.util.JSUtil.QUOTE, strB, a((java.lang.Class) cls)), false));
            }
        } else {
            strValueOf = io.dcloud.common.util.JSUtil.QUOTE + java.lang.String.valueOf(obj) + io.dcloud.common.util.JSUtil.QUOTE;
        }
        return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(io.dcloud.common.util.StringUtil.format("{\"type\":\"%s\", \"value\":%s, \"className\":\"%s\",\"superClassNames\":%s}", "basic", strValueOf, strB, a((java.lang.Class) cls)), false);
    }

    static java.lang.String a(java.lang.Class cls) {
        org.json.JSONStringer jSONStringer = new org.json.JSONStringer();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            jSONStringer.array();
            b(cls, jSONStringer, arrayList);
            jSONStringer.endArray();
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        java.lang.String string = jSONStringer.toString();
        return string == null ? "[]" : string;
    }

    static void a(java.lang.Class cls, org.json.JSONStringer jSONStringer, java.util.ArrayList arrayList) throws org.json.JSONException {
        java.lang.Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces != null) {
            for (java.lang.Class<?> cls2 : interfaces) {
                java.lang.String name = cls2.getName();
                if (!arrayList.contains(name)) {
                    jSONStringer.value(name);
                    arrayList.add(name);
                    a(cls2, jSONStringer, arrayList);
                }
            }
        }
    }

    static void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.Object obj, java.lang.Class cls, java.lang.StringBuffer stringBuffer) {
        if (cls != java.lang.String.class && cls != java.lang.CharSequence.class) {
            if (io.dcloud.p.k3.a(cls)) {
                stringBuffer.append(java.lang.String.valueOf(obj));
                return;
            }
            if (cls.isArray()) {
                int length = java.lang.reflect.Array.getLength(obj);
                stringBuffer.append(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
                for (int i = 0; i < length; i++) {
                    stringBuffer.append(b(iWebview, io.dcloud.p.k3.a(java.lang.reflect.Array.get(obj, i), cls)));
                    if (i != length - 1) {
                        stringBuffer.append(",");
                    }
                }
                stringBuffer.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
                return;
            }
            java.lang.String strA = a(obj);
            a(iWebview, strA, obj);
            stringBuffer.append(io.dcloud.common.util.JSUtil.QUOTE).append(strA).append(io.dcloud.common.util.JSUtil.QUOTE);
            return;
        }
        stringBuffer.append(org.json.JSONObject.quote(java.lang.String.valueOf(obj)));
    }

    private static java.util.HashMap a(io.dcloud.common.DHInterface.IWebview iWebview) {
        java.util.HashMap map = (java.util.HashMap) b.get(java.lang.Integer.valueOf(iWebview.hashCode()));
        if (map != null) {
            return map;
        }
        java.util.HashMap map2 = new java.util.HashMap(2);
        b.put(java.lang.Integer.valueOf(iWebview.hashCode()), map2);
        return map2;
    }

    io.dcloud.p.j3 a(java.util.HashMap map, java.lang.String str) {
        return (io.dcloud.p.j3) map.get(str);
    }

    io.dcloud.p.j3 a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        return a(a(iWebview), str);
    }

    private static void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, io.dcloud.p.j3 j3Var) {
        a(iWebview).put(str, j3Var);
    }

    private static io.dcloud.p.j3 a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.Object obj) {
        io.dcloud.p.j3 j3Var = new io.dcloud.p.j3(c, obj.getClass(), str, obj);
        a(iWebview, str, j3Var);
        return j3Var;
    }

    static java.lang.String a(java.lang.Object obj) {
        return io.dcloud.common.DHInterface.IFeature.F_INVOCATION + obj.hashCode();
    }

    private boolean a(java.lang.String str, java.lang.String str2, io.dcloud.common.DHInterface.IWebview iWebview) {
        return iWebview != null && !android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2) && java.lang.Boolean.parseBoolean(iWebview.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_USE_ENCRYPTION)) && "setWebContentsDebuggingEnabled".equalsIgnoreCase(str2) && (android.text.TextUtils.isEmpty(str) || "WebView".equalsIgnoreCase(str) || "android.webkit.WebView".equalsIgnoreCase(str));
    }

    public void a(java.lang.String str) {
        android.text.TextUtils.isEmpty(str);
    }
}
