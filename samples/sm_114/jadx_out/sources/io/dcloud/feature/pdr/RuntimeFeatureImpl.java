package io.dcloud.feature.pdr;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class RuntimeFeatureImpl implements io.dcloud.common.DHInterface.IFeature, io.dcloud.common.adapter.util.MessageHandler.IMessages {
    final java.lang.String a = io.dcloud.PandoraEntry.class.getName();
    io.dcloud.common.DHInterface.AbsMgr b = null;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends java.lang.Thread {
        final /* synthetic */ java.lang.String[] a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview c;

        a(java.lang.String[] strArr, java.lang.String str, io.dcloud.common.DHInterface.IWebview iWebview) {
            this.a = strArr;
            this.b = str;
            this.c = iWebview;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            java.lang.String[] strArr = this.a;
            java.lang.String str = strArr[1];
            java.lang.Object[] objArr = (java.lang.Object[]) io.dcloud.feature.pdr.RuntimeFeatureImpl.this.b.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 4, new java.lang.Object[]{this.b, !io.dcloud.common.util.PdrUtil.isEmpty(strArr[2]) ? io.dcloud.common.util.JSONUtil.createJSONObject(this.a[2]) : null, this.c});
            boolean zBooleanValue = java.lang.Boolean.valueOf(java.lang.String.valueOf(objArr[0])).booleanValue();
            java.lang.String strValueOf = java.lang.String.valueOf(objArr[1]);
            if (zBooleanValue) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, str, strValueOf, io.dcloud.common.util.JSUtil.ERROR, true, false);
            } else {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, str, strValueOf, io.dcloud.common.util.JSUtil.OK, true, false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements io.dcloud.common.ui.PrivacyManager.b {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ io.dcloud.WebAppActivity c;

        b(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, io.dcloud.WebAppActivity webAppActivity) {
            this.a = iWebview;
            this.b = str;
            this.c = webAppActivity;
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void a(java.lang.String str) {
            io.dcloud.common.util.JSUtil.execCallback(this.a, this.b, new org.json.JSONObject(), io.dcloud.common.util.JSUtil.ERROR, false);
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void b(io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("code", 2);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            io.dcloud.common.util.JSUtil.execCallback(this.a, this.b, jSONObject, io.dcloud.common.util.JSUtil.OK, false);
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a implements io.dcloud.common.ui.PrivacyManager.b {
            a() {
            }

            @Override // io.dcloud.common.ui.PrivacyManager.b
            public void a(java.lang.String str) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                io.dcloud.feature.pdr.RuntimeFeatureImpl.b bVar = io.dcloud.feature.pdr.RuntimeFeatureImpl.b.this;
                io.dcloud.common.util.JSUtil.execCallback(bVar.a, bVar.b, jSONObject, io.dcloud.common.util.JSUtil.ERROR, false);
            }

            @Override // io.dcloud.common.ui.PrivacyManager.b
            public void b(io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("code", 2);
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
                io.dcloud.feature.pdr.RuntimeFeatureImpl.b bVar = io.dcloud.feature.pdr.RuntimeFeatureImpl.b.this;
                io.dcloud.common.util.JSUtil.execCallback(bVar.a, bVar.b, jSONObject, io.dcloud.common.util.JSUtil.OK, false);
            }

            @Override // io.dcloud.common.ui.PrivacyManager.b
            public void a() {
                io.dcloud.feature.pdr.RuntimeFeatureImpl.b.this.c.onPrivacySureAction();
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("code", 1);
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
                io.dcloud.feature.pdr.RuntimeFeatureImpl.b bVar = io.dcloud.feature.pdr.RuntimeFeatureImpl.b.this;
                io.dcloud.common.util.JSUtil.execCallback(bVar.a, bVar.b, jSONObject, io.dcloud.common.util.JSUtil.OK, false);
            }

            @Override // io.dcloud.common.ui.PrivacyManager.b
            public void a(io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("code", -1);
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
                io.dcloud.feature.pdr.RuntimeFeatureImpl.b bVar = io.dcloud.feature.pdr.RuntimeFeatureImpl.b.this;
                io.dcloud.common.util.JSUtil.execCallback(bVar.a, bVar.b, jSONObject, io.dcloud.common.util.JSUtil.OK, false);
            }
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void a() {
            this.c.onPrivacySureAction();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("code", 1);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            io.dcloud.common.util.JSUtil.execCallback(this.a, this.b, jSONObject, io.dcloud.common.util.JSUtil.OK, false);
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void a(io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse) {
            if (android.text.TextUtils.isEmpty(androidPrivacyResponse.second.message)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("code", -1);
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
                io.dcloud.common.util.JSUtil.execCallback(this.a, this.b, jSONObject, io.dcloud.common.util.JSUtil.OK, false);
                return;
            }
            io.dcloud.common.ui.PrivacyManager.getInstance().showPrivacyDialog(this.c, new io.dcloud.feature.pdr.RuntimeFeatureImpl.b.a(), true, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements io.dcloud.common.DHInterface.ICallBack {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;

        c(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            if (i == 1) {
                return null;
            }
            io.dcloud.common.util.Deprecated_JSUtil.excCallbackError(this.a, this.b, java.lang.String.valueOf(obj), true);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements io.dcloud.common.DHInterface.ICallBack {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;

        d(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            if (i == 1) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, "{}", io.dcloud.common.util.JSUtil.OK, true, false);
                return null;
            }
            io.dcloud.common.util.Deprecated_JSUtil.excCallbackError(this.a, this.b, java.lang.String.valueOf(obj), true);
            return null;
        }
    }

    private void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.lang.String strValueOf = (android.text.TextUtils.isEmpty(str) || str.equals(com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT)) ? "" : java.lang.String.valueOf(java.lang.Math.max(0, java.lang.Integer.valueOf(str).intValue()));
        try {
            java.lang.String str3 = android.os.Build.MANUFACTURER;
            if (str3.equalsIgnoreCase("Xiaomi")) {
                b(iWebview, strValueOf, str2);
                return;
            }
            if (str3.equalsIgnoreCase("samsung")) {
                c(iWebview, strValueOf);
                return;
            }
            java.util.Locale locale = java.util.Locale.ENGLISH;
            if (str3.toLowerCase(locale).contains("sony")) {
                d(iWebview, strValueOf);
                return;
            }
            if (str3.toLowerCase(locale).contains("huawei")) {
                e(iWebview, strValueOf);
                return;
            }
            if (str3.toLowerCase(locale).contains("vivo")) {
                g(iWebview, strValueOf);
            } else if (str3.toLowerCase(locale).contains("oppo")) {
                f(iWebview, strValueOf);
            } else if (str3.toLowerCase(locale).contains("honor")) {
                b(iWebview, strValueOf);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void b(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        org.json.JSONObject jSONObject;
        android.app.Notification.Builder builder;
        try {
            jSONObject = new org.json.JSONObject(str2);
        } catch (org.json.JSONException unused) {
            jSONObject = new org.json.JSONObject();
        }
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) iWebview.getContext().getSystemService("notification");
        boolean z = false;
        android.app.Notification notificationBuild = null;
        try {
            try {
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    a(iWebview.getContext());
                    io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m485m$2();
                    builder = io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m(iWebview.getContext(), "LOCAL_BADGE_NUM");
                } else {
                    builder = new android.app.Notification.Builder(iWebview.getContext());
                }
                builder.setContentText(io.dcloud.common.util.PdrUtil.isEmpty(jSONObject.optString(com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME)) ? io.dcloud.common.util.StringUtil.format(iWebview.getContext().getString(io.dcloud.base.R.string.dcloud_common_msg_unread_prompt), str) : jSONObject.optString(com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME));
                builder.setAutoCancel(true);
                int i = io.dcloud.PdrR.getInt(iWebview.getContext(), "drawable", "push");
                if (i <= 0) {
                    builder.setSmallIcon(iWebview.getContext().getApplicationInfo().icon);
                } else {
                    builder.setSmallIcon(i);
                }
                builder.setDefaults(4);
                java.lang.String packageName = iWebview.getActivity().getPackageName();
                android.content.pm.PackageManager packageManager = iWebview.getActivity().getPackageManager();
                android.content.Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
                builder.setContentTitle(io.dcloud.common.util.PdrUtil.isEmpty(jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE)) ? io.dcloud.common.adapter.util.AndroidResources.mApplicationInfo.applicationInfo.loadLabel(packageManager) : jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE));
                builder.setContentIntent(android.app.PendingIntent.getActivity(iWebview.getActivity(), 10019, launchIntentForPackage, 1073741824));
                builder.setAutoCancel(true);
                notificationBuild = builder.build();
                notificationBuild.flags = 16;
                java.lang.Object obj = notificationBuild.getClass().getDeclaredField("extraNotification").get(notificationBuild);
                obj.getClass().getDeclaredMethod("setMessageCount", java.lang.Integer.TYPE).invoke(obj, java.lang.Integer.valueOf(java.lang.Integer.parseInt(str)));
                notificationManager.notify(101010, notificationBuild);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                try {
                    android.content.Intent intent = new android.content.Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
                    intent.putExtra("android.intent.extra.update_application_component_name", this.a);
                    intent.putExtra("android.intent.extra.update_application_message_text", str);
                    iWebview.getContext().sendBroadcast(intent);
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (notificationBuild != null) {
                        notificationManager.notify(101010, notificationBuild);
                    }
                    throw th;
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            z = true;
            if (notificationBuild != null && z) {
                notificationManager.notify(101010, notificationBuild);
            }
            throw th;
        }
    }

    private void c(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", java.lang.Integer.parseInt(str));
        intent.putExtra("badge_count_package_name", iWebview.getContext().getPackageName());
        intent.putExtra("badge_count_class_name", this.a);
        iWebview.getContext().sendBroadcast(intent);
    }

    private void d(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        if (iWebview.getContext().getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) == null) {
            android.content.Intent intent = new android.content.Intent("android.intent.action.BADGE_COUNT_UPDATE");
            intent.putExtra("badge_count", str);
            intent.putExtra("badge_count_package_name", iWebview.getContext().getPackageName());
            intent.putExtra("badge_count_class_name", this.a);
            iWebview.getActivity().sendBroadcast(intent);
            return;
        }
        boolean z = java.lang.Integer.parseInt(str) != 0;
        android.content.Intent intent2 = new android.content.Intent();
        intent2.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
        intent2.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", z);
        intent2.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", this.a);
        intent2.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", str);
        intent2.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", iWebview.getContext().getPackageName());
        iWebview.getContext().sendBroadcast(intent2);
    }

    private void e(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        int i = !str.equals("") ? java.lang.Integer.parseInt(str) : 0;
        int i2 = i >= 0 ? i : 0;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("package", iWebview.getContext().getPackageName());
        bundle.putString("class", iWebview.getContext().getPackageManager().getLaunchIntentForPackage(iWebview.getContext().getPackageName()).getComponent().getClassName());
        bundle.putInt("badgenumber", i2);
        iWebview.getContext().getContentResolver().call(android.net.Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (java.lang.String) null, bundle);
        io.dcloud.common.DHInterface.message.ActionBus.getInstance().sendToBus(io.dcloud.common.DHInterface.message.action.BadgeSyncAction.obtain(io.dcloud.common.DHInterface.message.action.BadgeSyncAction.ENUM_ACTION_TYPE.SYNC_NUM).setSyncNum(i2));
    }

    private void f(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        int i = java.lang.Integer.parseInt(str);
        if (i == 0) {
            i = -1;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("app_badge_count", i);
        iWebview.getContext().getContentResolver().call(android.net.Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (java.lang.String) null, bundle);
    }

    private void g(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        try {
            android.content.Intent intent = new android.content.Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra("packageName", iWebview.getContext().getPackageName());
            intent.putExtra("className", iWebview.getContext().getPackageManager().getLaunchIntentForPackage(iWebview.getContext().getPackageName()).getComponent().getClassName());
            intent.putExtra("notificationNum", java.lang.Integer.parseInt(str));
            iWebview.getContext().sendBroadcast(intent);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0016  */
    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        java.lang.String strSubstring;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.Object objValueOf;
        str.getClass();
        str.hashCode();
        boolean z = false;
        switch (str) {
            case "getDCloudId":
                java.lang.String bundleData = io.dcloud.common.adapter.util.SP.getBundleData(iWebview.getContext(), "pdr", io.dcloud.common.adapter.util.SP.STARTUP_DEVICE_ID);
                return !io.dcloud.common.util.PdrUtil.isEmpty(bundleData) ? io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(bundleData, true) : io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(io.dcloud.common.util.TelephonyUtil.getIMEI(iWebview.getContext(), true, true), true);
            case "isApplicationExist":
                java.lang.String str4 = strArr[0];
                if (!android.text.TextUtils.isEmpty(str4)) {
                    try {
                        org.json.JSONObject jSONObject = new org.json.JSONObject(str4);
                        if (jSONObject.has("pname")) {
                            java.lang.String string = jSONObject.getString("pname");
                            return (!android.text.TextUtils.isEmpty(string) && io.dcloud.common.util.LoadAppUtils.isAppLoad(iWebview.getContext(), string)) ? io.dcloud.common.constant.AbsoluteConst.TRUE : io.dcloud.common.constant.AbsoluteConst.FALSE;
                        }
                    } catch (org.json.JSONException e) {
                        e.printStackTrace();
                        return io.dcloud.common.constant.AbsoluteConst.FALSE;
                    }
                }
                return io.dcloud.common.constant.AbsoluteConst.FALSE;
            case "isCustomLaunchPath":
                return iWebview.obtainFrameView().obtainApp().checkIsCustomPath() ? io.dcloud.common.constant.AbsoluteConst.TRUE : io.dcloud.common.constant.AbsoluteConst.FALSE;
            case "processDirectPage":
                java.lang.String directPage = iWebview.obtainApp().getDirectPage();
                iWebview.obtainApp().setDirectPage(null);
                if (android.text.TextUtils.isEmpty(directPage)) {
                    directPage = "";
                }
                return io.dcloud.common.util.JSUtil.wrapJsVar(directPage);
            case "isStreamValid":
                return (io.dcloud.common.util.BaseInfo.existsStreamEnv() && io.dcloud.common.util.BaseInfo.existsLibso()) ? io.dcloud.common.constant.AbsoluteConst.TRUE : io.dcloud.common.constant.AbsoluteConst.FALSE;
            case "isAgreePrivacy":
                java.lang.String bundleData2 = io.dcloud.common.adapter.util.SP.getBundleData(iWebview.getContext(), "pdr", "scok");
                java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_PRIVACY_PROMPT");
                if (io.dcloud.common.util.PdrUtil.isEmpty(metaValue) ? io.dcloud.common.util.PdrUtil.isEmpty(bundleData2) || bundleData2.equals("1") : !metaValue.equalsIgnoreCase("template") ? !metaValue.equalsIgnoreCase("custom") ? io.dcloud.common.util.PdrUtil.isEmpty(bundleData2) || bundleData2.equals("1") : !io.dcloud.common.util.PdrUtil.isEmpty(bundleData2) && bundleData2.equals("1") : !io.dcloud.common.util.PdrUtil.isEmpty(bundleData2) && bundleData2.equals("1")) {
                    z = true;
                }
                return io.dcloud.common.util.JSUtil.wrapJsVar(z);
            case "downloadBlob":
                try {
                    strSubstring = strArr[0];
                    try {
                        str2 = strArr[2];
                        try {
                            str3 = str2;
                            objValueOf = strArr[1];
                        } catch (java.lang.Exception unused) {
                            str3 = str2;
                            objValueOf = null;
                        }
                    } catch (java.lang.Exception unused2) {
                        str2 = null;
                    }
                } catch (java.lang.Exception unused3) {
                    strSubstring = null;
                    str2 = null;
                }
                if (io.dcloud.common.util.PdrUtil.isEmpty(strSubstring)) {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str3, io.dcloud.common.constant.DOMException.toJSON(-1, "blob error"), io.dcloud.common.util.JSUtil.ERROR, true, false);
                } else {
                    try {
                        strSubstring = strSubstring.substring(strSubstring.indexOf(",") + 1);
                        break;
                    } catch (java.lang.Exception unused4) {
                    }
                    java.lang.String str5 = io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir + "/Download/";
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(str5);
                    if (io.dcloud.common.util.PdrUtil.isEmpty(objValueOf)) {
                        objValueOf = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
                    }
                    sb.append(objValueOf);
                    java.io.File file = new java.io.File(sb.toString());
                    byte[] bArrDecode = android.util.Base64.decode(strSubstring, 0);
                    try {
                        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file, false);
                        fileOutputStream.write(bArrDecode);
                        fileOutputStream.flush();
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str3, "{'code':0,'message':'" + file.getPath() + "'}", io.dcloud.common.util.JSUtil.ERROR, true, false);
                    } catch (java.lang.Exception e2) {
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                        try {
                            jSONObject2.put("code", -1);
                            jSONObject2.put("message", e2.toString());
                            break;
                        } catch (org.json.JSONException unused5) {
                        }
                        io.dcloud.common.util.JSUtil.execCallback(iWebview, str3, jSONObject2, io.dcloud.common.util.JSUtil.ERROR, false);
                        return null;
                    }
                }
                return null;
            case "disagreePrivacy":
                io.dcloud.common.adapter.util.SP.setBundleData(iWebview.getContext(), "pdr", "scok", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
                return null;
            case "agreePrivacy":
                io.dcloud.common.adapter.util.SP.setBundleData(iWebview.getContext(), "pdr", "scok", "1");
                return null;
            default:
                io.dcloud.common.adapter.util.MessageHandler.sendMessage(this, new java.lang.Object[]{iWebview, str, strArr});
                return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.b = absMgr;
    }

    private void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            android.content.Intent intent = new android.content.Intent();
            intent.setClass(iWebview.getActivity(), io.dcloud.WebviewActivity.class);
            intent.putExtra("url", str);
            intent.setData(android.net.Uri.parse(str));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            iWebview.getContext().startActivity(intent);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void a(java.lang.String str, io.dcloud.common.DHInterface.IApp iApp) {
        if (android.text.TextUtils.isEmpty(str) || !io.dcloud.common.util.BaseInfo.ISAMU) {
            return;
        }
        int length = str.length();
        java.lang.String str2 = io.dcloud.common.constant.StringConst.POINT_APP_EN;
        if ((length - str.indexOf(str2)) - str2.length() == 0 || (length - str.indexOf(".wgt")) - 4 == 0 || (length - str.indexOf(".wgtu")) - 5 == 0) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("type", "install");
                jSONObject.put("file", str);
                jSONObject.put("appid", iApp.obtainOriginalAppId());
                jSONObject.put("version", iApp.obtainAppVersionName());
                android.util.Log.i(io.dcloud.common.constant.AbsoluteConst.HBUILDER_TAG, jSONObject.toString());
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void a(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT < 26 || !android.os.Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            return;
        }
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService("notification");
        notificationManager.createNotificationChannelGroup(dc.squareup.okio.Okio$$ExternalSyntheticApiModelOutline0.m("LOCAL_BADGE_SETTING", "badge"));
        io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m482m$1();
        android.app.NotificationChannel notificationChannelM = dc.squareup.okio.Okio$$ExternalSyntheticApiModelOutline0.m("LOCAL_BADGE_NUM", context.getString(io.dcloud.base.R.string.dcloud_nf_desktop_icon_corner), 3);
        notificationChannelM.enableLights(true);
        notificationChannelM.setShowBadge(true);
        notificationManager.createNotificationChannel(notificationChannelM);
    }

    private void b(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        int i = !str.equals("") ? java.lang.Integer.parseInt(str) : 0;
        int i2 = i >= 0 ? i : 0;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("package", iWebview.getContext().getPackageName());
        bundle.putString("class", iWebview.getContext().getPackageManager().getLaunchIntentForPackage(iWebview.getContext().getPackageName()).getComponent().getClassName());
        bundle.putInt("badgenumber", i2);
        iWebview.getContext().getContentResolver().call(android.net.Uri.parse("content://com.hihonor.android.launcher.settings/badge/"), "change_badge", (java.lang.String) null, bundle);
        io.dcloud.common.DHInterface.message.ActionBus.getInstance().sendToBus(io.dcloud.common.DHInterface.message.action.BadgeSyncAction.obtain(io.dcloud.common.DHInterface.message.action.BadgeSyncAction.ENUM_ACTION_TYPE.SYNC_NUM).setSyncNum(i2));
    }

    private void b(java.lang.String str, io.dcloud.common.DHInterface.IApp iApp) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("type", "openurl");
            jSONObject.put("url", str);
            jSONObject.put("appid", iApp.obtainOriginalAppId());
            jSONObject.put("version", iApp.obtainAppVersionName());
            android.util.Log.i(io.dcloud.common.constant.AbsoluteConst.HBUILDER_TAG, jSONObject.toString());
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
    public void execute(java.lang.Object obj) throws java.lang.Throwable {
        char c2;
        java.lang.String strOptString;
        java.lang.String str;
        java.lang.String strOptString2;
        org.json.JSONObject jSONObject;
        java.lang.Object[] objArr = (java.lang.Object[]) obj;
        io.dcloud.common.DHInterface.IWebview iWebview = (io.dcloud.common.DHInterface.IWebview) objArr[0];
        java.lang.String strValueOf = java.lang.String.valueOf(objArr[1]);
        java.lang.String[] strArr = (java.lang.String[]) objArr[2];
        io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
        strValueOf.hashCode();
        byte b2 = -1;
        switch (strValueOf.hashCode()) {
            case -1263204667:
                if (strValueOf.equals("openURL")) {
                    b2 = 0;
                }
                break;
            case -1263202134:
                if (strValueOf.equals("openWeb")) {
                    b2 = 1;
                }
                break;
            case -1150858339:
                if (strValueOf.equals("launchApplication")) {
                    b2 = 2;
                }
                break;
            case -944934523:
                if (strValueOf.equals("openDocument")) {
                    b2 = 3;
                }
                break;
            case -505062682:
                if (strValueOf.equals("openFile")) {
                    b2 = 4;
                }
                break;
            case 3482191:
                if (strValueOf.equals("quit")) {
                    b2 = 5;
                }
                break;
            case 545494794:
                if (strValueOf.equals("setBadgeNumber")) {
                    b2 = 6;
                }
                break;
            case 1084758859:
                if (strValueOf.equals("getProperty")) {
                    b2 = 7;
                }
                break;
            case 1097506319:
                if (strValueOf.equals("restart")) {
                    b2 = 8;
                }
                break;
            case 1247092467:
                if (strValueOf.equals("showPrivacyDialog")) {
                    b2 = 9;
                }
                break;
            case 1957569947:
                if (strValueOf.equals("install")) {
                    b2 = 10;
                }
                break;
        }
        java.lang.String string = null;
        switch (b2) {
            case 0:
                try {
                    java.lang.String str2 = strArr[0];
                    if (io.dcloud.common.util.PdrUtil.isDeviceRootDir(str2) || io.dcloud.common.util.PdrUtil.isNetPath(str2) || str2.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL) || iAppObtainApp.checkSchemeWhite(str2)) {
                        b(strArr[0], iAppObtainApp);
                        io.dcloud.common.adapter.util.PlatformUtil.openURL(iWebview.getActivity(), strArr[0], java.lang.String.valueOf(io.dcloud.common.util.PdrUtil.getObject(strArr, 2)));
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    io.dcloud.common.util.Deprecated_JSUtil.excCallbackError(iWebview, strArr[1], e.getMessage());
                    return;
                }
                break;
            case 1:
                a(iWebview, strArr[0]);
                break;
            case 2:
                try {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject(strArr[0]);
                    org.json.JSONArray jSONArrayNames = jSONObject2.names();
                    java.util.HashMap map = new java.util.HashMap();
                    java.lang.String string2 = null;
                    boolean z = true;
                    for (int i = 0; i < jSONArrayNames.length(); i++) {
                        java.lang.String string3 = jSONArrayNames.getString(i);
                        try {
                            if (string3.equals("pname")) {
                                string = jSONObject2.getString(string3);
                            } else if (string3.equals("action")) {
                                string2 = jSONObject2.getString(string3);
                            } else {
                                if (string3.equals("extra")) {
                                    org.json.JSONObject jSONObject3 = jSONObject2.getJSONObject(string3);
                                    java.util.Iterator<java.lang.String> itKeys = jSONObject3.keys();
                                    while (itKeys.hasNext()) {
                                        java.lang.String next = itKeys.next();
                                        map.put(next, jSONObject3.get(next));
                                    }
                                } else {
                                    c2 = 1;
                                    if (string3.equals("newTask")) {
                                        z = jSONObject2.getBoolean("newTask");
                                    }
                                }
                            }
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strArr[c2], io.dcloud.common.constant.DOMException.toJSON(-99, e.getMessage()), io.dcloud.common.util.JSUtil.OK, true, false);
                            return;
                        }
                        c2 = 1;
                        break;
                    }
                    c2 = 1;
                    io.dcloud.common.adapter.util.PlatformUtil.launchApplication(iWebview.getActivity(), string, string2, map, z);
                } catch (java.lang.Exception e3) {
                    e = e3;
                    c2 = 1;
                }
                break;
            case 3:
                java.lang.String strCheckPrivateDirAndCopy2Temp = iAppObtainApp.checkPrivateDirAndCopy2Temp(strArr[0]);
                java.lang.String str3 = strArr[2];
                try {
                    org.json.JSONObject jSONObject4 = new org.json.JSONObject(strArr[1]);
                    strOptString = jSONObject4.optString("pname");
                    try {
                        java.lang.String lowerCase = jSONObject4.optString("fileType").toLowerCase(java.util.Locale.ENGLISH);
                        switch (lowerCase.hashCode()) {
                            case 99640:
                                if (lowerCase.equals(io.dcloud.common.util.CustomPath.CUSTOM_PATH_DOC)) {
                                    str = "application/msword";
                                    string = str;
                                }
                                break;
                            case 110834:
                                if (lowerCase.equals("pdf")) {
                                    str = "application/pdf";
                                    string = str;
                                }
                                break;
                            case 111220:
                                if (lowerCase.equals("ppt")) {
                                    str = "application/vnd.ms-powerpoint";
                                    string = str;
                                }
                                break;
                            case 118783:
                                if (lowerCase.equals("xls")) {
                                    str = "application/vnd.ms-excel";
                                    string = str;
                                }
                                break;
                            case 3088960:
                                if (lowerCase.equals("docx")) {
                                    str = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
                                    string = str;
                                }
                                break;
                            case 3447940:
                                if (lowerCase.equals("pptx")) {
                                    str = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
                                    string = str;
                                }
                                break;
                            case 3682393:
                                if (lowerCase.equals("xlsx")) {
                                    str = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
                                    string = str;
                                }
                                break;
                        }
                        break;
                    } catch (java.lang.Exception unused) {
                    }
                } catch (java.lang.Exception unused2) {
                    strOptString = null;
                }
                java.lang.String strConvert2AbsFullPath = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strCheckPrivateDirAndCopy2Temp);
                if (!new java.io.File(strConvert2AbsFullPath).isFile()) {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str3, io.dcloud.common.constant.DOMException.toJSON(-4, io.dcloud.common.constant.DOMException.MSG_FILE_NOT_EXIST), io.dcloud.common.util.JSUtil.ERROR, true, false);
                } else {
                    io.dcloud.common.adapter.util.PlatformUtil.openFileBySystem(iAppObtainApp.getActivity(), strConvert2AbsFullPath, strOptString, string, new io.dcloud.feature.pdr.RuntimeFeatureImpl.d(iWebview, str3));
                }
                break;
            case 4:
                java.lang.String strCheckPrivateDirAndCopy2Temp2 = iAppObtainApp.checkPrivateDirAndCopy2Temp(strArr[0]);
                java.lang.String str4 = strArr[2];
                try {
                    strOptString2 = new org.json.JSONObject(strArr[1]).optString("pname");
                } catch (java.lang.Exception e4) {
                    e4.printStackTrace();
                    strOptString2 = null;
                }
                java.lang.String strConvert2AbsFullPath2 = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strCheckPrivateDirAndCopy2Temp2);
                if (!new java.io.File(strConvert2AbsFullPath2).isFile()) {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str4, io.dcloud.common.constant.DOMException.toJSON(-4, io.dcloud.common.constant.DOMException.MSG_FILE_NOT_EXIST), io.dcloud.common.util.JSUtil.ERROR, true, false);
                } else {
                    io.dcloud.common.adapter.util.PlatformUtil.openFileBySystem(iAppObtainApp.getActivity(), strConvert2AbsFullPath2, strOptString2, null, new io.dcloud.feature.pdr.RuntimeFeatureImpl.c(iWebview, str4));
                }
                break;
            case 5:
                this.b.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 20, iAppObtainApp);
                break;
            case 6:
                a(iWebview, strArr[0], (strArr.length <= 1 || io.dcloud.common.util.PdrUtil.isEmpty(strArr[1])) ? "{}" : strArr[1]);
                break;
            case 7:
                java.lang.String strObtainAppId = strArr[0];
                if (io.dcloud.common.util.PdrUtil.isEmpty(strObtainAppId)) {
                    strObtainAppId = iWebview.obtainFrameView().obtainApp().obtainAppId();
                }
                java.lang.String str5 = strArr[1];
                java.lang.String strValueOf2 = java.lang.String.valueOf(this.b.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 5, strObtainAppId));
                if (io.dcloud.common.util.PdrUtil.isEmpty(strValueOf2)) {
                    io.dcloud.common.util.Deprecated_JSUtil.excCallbackError(iWebview, str5, null);
                } else {
                    io.dcloud.common.util.Deprecated_JSUtil.excCallbackSuccess(iWebview, str5, strValueOf2, true);
                }
                break;
            case 8:
                java.lang.String strObtainAppId2 = iAppObtainApp.obtainAppId();
                iAppObtainApp.clearRuntimeArgs();
                this.b.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 3, strObtainAppId2);
                break;
            case 9:
                java.lang.String str6 = strArr[0];
                try {
                    jSONObject = new org.json.JSONObject(strArr[1]);
                } catch (org.json.JSONException e5) {
                    e5.printStackTrace();
                    jSONObject = null;
                }
                io.dcloud.common.ui.PrivacyManager.getInstance().resetPrivacyLocalConfig(iWebview.getContext());
                if (jSONObject == null || jSONObject.optJSONObject(com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_CONFIG) == null) {
                    io.dcloud.common.ui.PrivacyManager.getInstance().reInit(iWebview.getContext(), null);
                } else {
                    io.dcloud.common.ui.PrivacyManager.getInstance().reInit(iWebview.getContext(), com.alibaba.fastjson.JSON.parseObject(jSONObject.toString()));
                }
                io.dcloud.WebAppActivity webAppActivity = (io.dcloud.WebAppActivity) iWebview.getContext();
                io.dcloud.common.ui.PrivacyManager.getInstance().showPrivacyDialog(webAppActivity, new io.dcloud.feature.pdr.RuntimeFeatureImpl.b(iWebview, str6, webAppActivity), false, true);
                break;
            case 10:
                io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Runtime-install");
                java.lang.String strConvert2AbsFullPath3 = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strArr[0]);
                a(strConvert2AbsFullPath3, iAppObtainApp);
                new io.dcloud.feature.pdr.RuntimeFeatureImpl.a(strArr, strConvert2AbsFullPath3, iWebview).start();
                break;
        }
    }
}
