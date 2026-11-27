package io.dcloud.feature.gg.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AolFeatureImpl {
    private static volatile boolean isRequestSuccess = false;
    private static boolean isSplashClose = false;
    private static android.os.Handler mHandler = new io.dcloud.feature.gg.dcloud.AolFeatureImpl.MyHandler(null);
    private static int retryCount = 0;
    private static io.dcloud.p.v splashAd;

    /* JADX INFO: renamed from: io.dcloud.feature.gg.dcloud.AolFeatureImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class AnonymousClass1 implements io.dcloud.sdk.core.v3.sp.DCSplashAOLLoadListener {
        final /* synthetic */ android.content.Context val$context;

        AnonymousClass1(android.content.Context context) {
            this.val$context = context;
        }

        static /* synthetic */ void lambda$onSplashAOLLoad$0(android.content.Context context) {
            if (context instanceof io.dcloud.WebAppActivity) {
                io.dcloud.WebAppActivity webAppActivity = (io.dcloud.WebAppActivity) context;
                webAppActivity.onCreateAdSplash(context);
                webAppActivity.initBackToFrontSplashAd();
            }
        }

        @Override // io.dcloud.sdk.core.v3.base.DCBaseAOLLoadListener
        public void onError(int i, java.lang.String str, org.json.JSONArray jSONArray) {
            io.dcloud.common.adapter.util.Logger.e("doForFeature", "AolFeatureImpl load fail" + i + ":" + str);
            if (i == -5000 || i == -5001) {
                return;
            }
            io.dcloud.feature.gg.dcloud.AolFeatureImpl.setRequest(this.val$context, "-8003", str, jSONArray);
        }

        @Override // io.dcloud.sdk.core.v3.sp.DCSplashAOLLoadListener
        public void onSplashAOLLoad() {
            io.dcloud.common.adapter.util.Logger.e("doForFeature", "AolFeatureImpl load success");
            if (io.dcloud.feature.gg.dcloud.AolFeatureImpl.isRequestSuccess) {
                android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
                final android.content.Context context = this.val$context;
                handler.post(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.AolFeatureImpl$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        io.dcloud.feature.gg.dcloud.AolFeatureImpl.AnonymousClass1.lambda$onSplashAOLLoad$0(context);
                    }
                });
            }
        }

        @Override // io.dcloud.sdk.core.v3.sp.DCSplashAOLLoadListener
        public void redBag(android.view.View view, android.widget.FrameLayout.LayoutParams layoutParams) {
            ((android.view.ViewGroup) ((android.app.Activity) this.val$context).getWindow().getDecorView().findViewById(android.R.id.content)).addView(view, layoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    protected static class AdReceiver implements io.dcloud.feature.gg.dcloud.IAolReceiver {
        private java.lang.Object[] _args;
        private java.lang.String appid;
        private android.content.Context context;

        public AdReceiver(android.content.Context context, java.lang.Object[] objArr, java.lang.String str) {
            this.context = context;
            this._args = objArr;
            this.appid = str;
        }

        public java.util.List<java.lang.String> getActivities() {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            try {
                android.content.pm.ActivityInfo[] activityInfoArr = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 1).activities;
                if (activityInfoArr != null) {
                    for (android.content.pm.ActivityInfo activityInfo : activityInfoArr) {
                        arrayList.add(activityInfo.name);
                    }
                }
                android.content.pm.ServiceInfo[] serviceInfoArr = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 4).services;
                if (serviceInfoArr != null) {
                    for (android.content.pm.ServiceInfo serviceInfo : serviceInfoArr) {
                        arrayList.add(serviceInfo.name);
                    }
                }
                android.content.pm.ProviderInfo[] providerInfoArr = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 8).providers;
                if (providerInfoArr != null) {
                    for (android.content.pm.ProviderInfo providerInfo : providerInfoArr) {
                        arrayList.add(providerInfo.name);
                    }
                }
                android.content.pm.ActivityInfo[] activityInfoArr2 = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 2).receivers;
                if (activityInfoArr2 != null) {
                    for (android.content.pm.ActivityInfo activityInfo2 : activityInfoArr2) {
                        arrayList.add(activityInfo2.name);
                    }
                }
            } catch (java.lang.Exception unused) {
            }
            return arrayList;
        }

        /* JADX INFO: renamed from: lambda$onReceiver$0$io-dcloud-feature-gg-dcloud-AolFeatureImpl$AdReceiver, reason: not valid java name */
        /* synthetic */ void m431x644f7ad6() {
            android.content.Context context = this.context;
            if (context instanceof io.dcloud.WebAppActivity) {
                ((io.dcloud.WebAppActivity) context).onCreateAdSplash(context);
                ((io.dcloud.WebAppActivity) this.context).initBackToFrontSplashAd();
            }
        }

        @Override // io.dcloud.feature.gg.dcloud.IAolReceiver
        public void onError(java.lang.String str, java.lang.String str2) {
            int i;
            boolean unused = io.dcloud.feature.gg.dcloud.AolFeatureImpl.isRequestSuccess = false;
            io.dcloud.common.adapter.util.SP.setsBundleData(io.dcloud.feature.gg.dcloud.ADHandler.AdTag, "uniad", "");
            io.dcloud.common.adapter.util.Logger.p("request Fail", "type:" + str + ";message:" + str2);
            if (io.dcloud.feature.gg.dcloud.AolFeatureImpl.retryCount < 3) {
                io.dcloud.feature.gg.dcloud.AolFeatureImpl.access$508();
                android.os.Message message = new android.os.Message();
                message.what = 1;
                message.obj = new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.AolFeatureImpl.AdReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        io.dcloud.p.l.a(io.dcloud.feature.gg.dcloud.AolFeatureImpl.AdReceiver.this.context, io.dcloud.feature.gg.dcloud.AolFeatureImpl.AdReceiver.this.appid, "pull", "RETRY");
                    }
                };
                io.dcloud.feature.gg.dcloud.AolFeatureImpl.mHandler.sendMessageDelayed(message, io.dcloud.feature.gg.dcloud.AolFeatureImpl.retryCount * com.taobao.weex.common.WXRequest.DEFAULT_TIMEOUT_MS);
            }
            if (this._args[2] == null) {
                try {
                    i = java.lang.Integer.parseInt(str2);
                } catch (java.lang.Exception unused2) {
                    i = -1;
                }
                android.content.Context context = this.context;
                if (i != -1) {
                    str2 = "http:" + str2;
                }
                io.dcloud.feature.gg.dcloud.AolFeatureImpl.setRequest(context, "-8001", str2, null);
            }
        }

        @Override // io.dcloud.feature.gg.dcloud.IAolReceiver
        public void onReceiver(org.json.JSONObject jSONObject) {
            char c;
            char c2;
            org.json.JSONObject jSONObject2;
            io.dcloud.common.adapter.util.Logger.p("doForFeature", "success when request");
            if (io.dcloud.feature.gg.dcloud.AolFeatureImpl.isSplashClose && this._args[2] == null && io.dcloud.feature.gg.dcloud.ADHandler.SplashAdIsEnable(this.context).booleanValue()) {
                io.dcloud.feature.gg.dcloud.AolFeatureImpl.setRequest(this.context, "-8002", "广告关闭时未请求成功", null);
            }
            boolean unused = io.dcloud.feature.gg.dcloud.AolFeatureImpl.isRequestSuccess = true;
            try {
                org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                java.util.HashMap map = new java.util.HashMap();
                org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                io.dcloud.p.h4 h4Var = io.dcloud.common.adapter.util.SP.getsOrCreateBundle(this.context, io.dcloud.feature.gg.dcloud.ADHandler.AdTag);
                if (jSONObjectOptJSONObject != null) {
                    java.lang.String strOptString = jSONObjectOptJSONObject.has("uniad") ? jSONObjectOptJSONObject.optString("uniad") : "";
                    if (jSONObjectOptJSONObject.has("al")) {
                        h4Var.b("al", jSONObjectOptJSONObject.optString("al"));
                    }
                    if (jSONObjectOptJSONObject.has("cad")) {
                        org.json.JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("cad");
                        if (jSONObjectOptJSONObject2 != null) {
                            java.util.List<java.lang.String> activities = getActivities();
                            java.util.Iterator<java.lang.String> itKeys = jSONObjectOptJSONObject2.keys();
                            while (itKeys.hasNext()) {
                                java.lang.String next = itKeys.next();
                                org.json.JSONObject jSONObject4 = jSONObjectOptJSONObject2.getJSONObject(next);
                                org.json.JSONArray jSONArrayOptJSONArray = jSONObject4.optJSONArray("mf-a");
                                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                                    jSONObject2 = jSONObjectOptJSONObject2;
                                    org.json.JSONArray jSONArray = jSONObject4.getJSONArray("cls-a");
                                    for (int i = 0; i < jSONArray.length(); i++) {
                                        try {
                                            java.lang.Class.forName(jSONArray.getString(i));
                                            org.json.JSONObject jSONObject5 = new org.json.JSONObject();
                                            jSONObject5.put("r", "1");
                                            jSONObject3.put(next, jSONObject5);
                                            break;
                                        } catch (java.lang.Exception unused2) {
                                        }
                                    }
                                } else {
                                    jSONObject2 = jSONObjectOptJSONObject2;
                                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                        if (activities.contains(jSONArrayOptJSONArray.getString(i2))) {
                                            org.json.JSONObject jSONObject6 = new org.json.JSONObject();
                                            jSONObject6.put("r", "1");
                                            jSONObject3.put(next, jSONObject6);
                                            break;
                                        }
                                    }
                                }
                                jSONObjectOptJSONObject2 = jSONObject2;
                            }
                            c = 0;
                            c2 = 1;
                            map.put("cad", jSONObject3.length() > 0 ? jSONObject3.toString() : "");
                        } else {
                            c = 0;
                            c2 = 1;
                        }
                    } else {
                        c = 0;
                        c2 = 1;
                        map.put("cad", "");
                    }
                    h4Var.b("uniad", strOptString);
                    h4Var.b("cgk", strOptString);
                } else {
                    c = 0;
                    c2 = 1;
                    h4Var.b("uniad", "");
                    map.put("cad", "");
                }
                io.dcloud.feature.gg.AolSplashUtil.saveOperate(map);
                if (jSONObject3.length() > 0) {
                    java.util.HashMap map2 = new java.util.HashMap();
                    map2.put("rad", jSONObject3.toString());
                    android.content.Context context = this.context;
                    io.dcloud.feature.gg.dcloud.ADHandler.ADReceiver aDReceiver = new io.dcloud.feature.gg.dcloud.ADHandler.ADReceiver(context);
                    io.dcloud.feature.gg.dcloud.ADResult.CADReceiver cADReceiver = new io.dcloud.feature.gg.dcloud.ADResult.CADReceiver(this.context);
                    io.dcloud.feature.gg.dcloud.IAolReceiver[] iAolReceiverArr = new io.dcloud.feature.gg.dcloud.IAolReceiver[2];
                    iAolReceiverArr[c] = aDReceiver;
                    iAolReceiverArr[c2] = cADReceiver;
                    io.dcloud.feature.gg.dcloud.ADHandler.pullRad(context, map2, iAolReceiverArr);
                }
                if (io.dcloud.feature.gg.dcloud.AolFeatureImpl.splashAd != null) {
                    new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.AolFeatureImpl$AdReceiver$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m431x644f7ad6();
                        }
                    });
                    io.dcloud.feature.gg.dcloud.AolFeatureImpl.splashAd.v();
                }
            } catch (java.lang.Exception unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class MyHandler extends android.os.Handler {
        private MyHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                ((java.lang.Runnable) message.obj).run();
            }
        }

        /* synthetic */ MyHandler(io.dcloud.feature.gg.dcloud.AolFeatureImpl.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static /* synthetic */ int access$508() {
        int i = retryCount;
        retryCount = i + 1;
        return i;
    }

    public static java.lang.Object doForFeature(java.lang.String str, java.lang.Object obj) {
        io.dcloud.p.v vVar;
        if ("onAppCreate".equals(str)) {
            android.content.Context context = (android.content.Context) obj;
            io.dcloud.common.adapter.util.Logger.p("doForFeature", "AolFeatureImpl onAppCreate");
            java.lang.String str2 = io.dcloud.feature.gg.dcloud.ADHandler.get("uniad");
            if (!android.text.TextUtils.isEmpty(str2)) {
                io.dcloud.common.adapter.util.SP.setsBundleData(context, io.dcloud.feature.gg.dcloud.ADHandler.AdTag, "uniad", str2);
                io.dcloud.common.adapter.util.SP.setsBundleData(context, io.dcloud.feature.gg.dcloud.ADHandler.AdTag, "cgk", str2);
                io.dcloud.common.adapter.util.SP.removeBundleData(context, io.dcloud.feature.gg.dcloud.ADHandler.AdTag, "uniad");
                io.dcloud.common.adapter.util.SP.removeBundleData(context, io.dcloud.feature.gg.dcloud.ADHandler.AdTag, "cgk");
            }
        } else if ("pull".equals(str) || "ba_pull".equals(str)) {
            java.lang.Object[] objArr = (java.lang.Object[]) obj;
            android.content.Context context2 = (android.content.Context) objArr[0];
            java.lang.String str3 = (java.lang.String) objArr[1];
            if (str.equals("ba_pull") && io.dcloud.p.c4.b() && !io.dcloud.p.t.d(context2, str3)) {
                return null;
            }
            io.dcloud.p.h4.a(context2, io.dcloud.feature.gg.dcloud.ADHandler.AdTag);
            io.dcloud.feature.gg.dcloud.ADHandler.pull(context2, str3, false, (java.util.List<io.dcloud.common.util.hostpicker.HostPicker.Host>) null, new io.dcloud.feature.gg.dcloud.ADHandler.ADReceiver(context2), new io.dcloud.feature.gg.dcloud.ADResult.CADReceiver(context2), new io.dcloud.feature.gg.dcloud.AolFeatureImpl.AdReceiver(context2, objArr, str3));
            if ((io.dcloud.common.util.PdrUtil.isEmpty(objArr[2]) || !"RETRY".equals(objArr[2])) && !io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(context2)) {
                splashAd = null;
                isSplashClose = false;
                isRequestSuccess = false;
                mHandler.removeMessages(1);
                retryCount = 0;
                io.dcloud.sdk.core.entry.SplashAOLConfig splashAOLConfigBuild = new io.dcloud.sdk.core.entry.SplashAOLConfig.Builder().width(0).height(0).build();
                io.dcloud.p.v vVar2 = new io.dcloud.p.v((android.app.Activity) context2);
                splashAd = vVar2;
                vVar2.a(splashAOLConfigBuild, (io.dcloud.sdk.core.v3.sp.DCSplashAOLLoadListener) new io.dcloud.feature.gg.dcloud.AolFeatureImpl.AnonymousClass1(context2), false);
            }
            io.dcloud.feature.gg.AolSplashUtil.setShowInterstitialAd(false);
        } else if ("save".equals(str)) {
            java.lang.Object[] objArr2 = (java.lang.Object[]) obj;
            android.content.Context context3 = (android.content.Context) objArr2[0];
            java.lang.String str4 = (java.lang.String) objArr2[1];
            java.util.HashMap map = (java.util.HashMap) objArr2[2];
            io.dcloud.common.adapter.util.Logger.p("doForFeature", "AolFeatureImpl save");
            io.dcloud.feature.gg.AolSplashUtil.saveOperate(context3, str4, map);
        } else {
            if ("formatUrl_wanka".equals(str)) {
                java.lang.Object[] objArr3 = (java.lang.Object[]) ((java.lang.Object[]) obj)[2];
                return io.dcloud.feature.gg.dcloud.ADHandler.formatUrl((java.lang.String) objArr3[0], (org.json.JSONObject) objArr3[1]);
            }
            if ("handleArgs_wanka".equals(str)) {
                return io.dcloud.feature.gg.dcloud.ADHandler.getArgsJsonData((org.json.JSONObject) ((java.lang.Object[]) obj)[2]);
            }
            if ("onWillCloseSplash".equals(str)) {
                isSplashClose = true;
                isRequestSuccess = false;
                java.lang.Object[] objArr4 = (java.lang.Object[]) obj;
                android.content.Context context4 = (android.content.Context) objArr4[0];
                if (context4 instanceof android.app.Activity) {
                    android.app.Activity activity = (android.app.Activity) context4;
                    if (!activity.isDestroyed() && !activity.isFinishing() && (vVar = splashAd) != null) {
                        vVar.a((android.view.View) objArr4[2]);
                    }
                }
                return null;
            }
            if ("onCloseSplashNoAd".equals(str)) {
                isSplashClose = true;
                android.content.Context context5 = (android.content.Context) ((java.lang.Object[]) obj)[0];
                if (context5 instanceof android.app.Activity) {
                    android.app.Activity activity2 = (android.app.Activity) context5;
                    if (!activity2.isDestroyed() && !activity2.isFinishing()) {
                        io.dcloud.common.adapter.util.Logger.p("doForFeature", "AolFeatureImpl onCloseSplashNoAd");
                        io.dcloud.feature.gg.dcloud.ADHandler.SplashAdIsEnable(context5).booleanValue();
                    }
                }
                return null;
            }
            if ("onCreateAdSplash".equals(str)) {
                if (!isRequestSuccess || splashAd == null || isSplashClose) {
                    return null;
                }
                java.lang.Object[] objArr5 = (java.lang.Object[]) obj;
                android.content.Context context6 = (android.content.Context) objArr5[0];
                if (context6 instanceof android.app.Activity) {
                    android.app.Activity activity3 = (android.app.Activity) context6;
                    if (activity3.isDestroyed() || activity3.isFinishing() || !io.dcloud.feature.gg.dcloud.ADHandler.SplashAdIsEnable(context6).booleanValue()) {
                        return null;
                    }
                    io.dcloud.common.DHInterface.ICallBack iCallBack = (io.dcloud.common.DHInterface.ICallBack) objArr5[1];
                    io.dcloud.common.adapter.util.Logger.p("doForFeature", "AolFeatureImpl onCreateAdSplash");
                    io.dcloud.p.v vVar3 = splashAd;
                    if (vVar3 != null && vVar3.l()) {
                        return splashAd.a(activity3, "", iCallBack);
                    }
                }
                return null;
            }
            if ("onAppAttachBaseContext".equals(str)) {
                io.dcloud.common.adapter.util.Logger.p("doForFeature", "AolFeatureImpl onAppAttachBaseContext");
            } else if ("onSplashclosed".equals(str)) {
                io.dcloud.p.v vVar4 = splashAd;
                if (vVar4 != null) {
                    vVar4.w();
                }
                splashAd = null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setRequest(android.content.Context context, java.lang.String str, java.lang.String str2, org.json.JSONArray jSONArray) {
        if (context.getPackageName().equals("io.dcloud.HBuilder")) {
            return;
        }
        io.dcloud.feature.gg.dcloud.ADHandler.postSplashError(context, str, str2, jSONArray);
    }
}
