package io.dcloud.feature.gg.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ADHandler {
    public static final java.lang.String AdTag = "_adio.dcloud.feature.ad.dcloud.ADHandler";
    private static final java.lang.String File_Data = "data.json";
    private static final java.lang.String File_Gif = "img.gif";
    private static final java.lang.String File_Img = "img.png";
    private static final java.lang.String File_S = "s.txt";
    private static final java.lang.String File_Tid = "tid.txt";
    private static java.util.LinkedList<java.io.File> expiresFileList = null;
    private static io.dcloud.p.u3 handler = null;
    static boolean isPullFor360 = false;
    static boolean sNeedShowSkipView = false;
    static long sPullBeginTime;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class ADReceiver implements io.dcloud.feature.gg.dcloud.IAolReceiver {
        android.content.Context mContext;
        long mStartTime = java.lang.System.currentTimeMillis();

        public ADReceiver(android.content.Context context) {
            this.mContext = null;
            this.mContext = context;
        }

        private void broadcastADReceive() {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("ad_receive");
            intent.putExtra("begin", this.mStartTime);
            intent.putExtra("end", java.lang.System.currentTimeMillis());
            this.mContext.sendBroadcast(intent);
            io.dcloud.feature.gg.dcloud.ADHandler.log("ADReceive", "broadcastADReceive");
        }

        private void pap(org.json.JSONObject jSONObject) {
            if (jSONObject == null || !jSONObject.has("pap")) {
                return;
            }
            io.dcloud.feature.gg.dcloud.ADHandler.handleSplashAdEnable(this.mContext, java.lang.Boolean.valueOf(jSONObject.optInt("pap") == 1));
        }

        @Override // io.dcloud.feature.gg.dcloud.IAolReceiver
        public void onError(java.lang.String str, java.lang.String str2) {
            broadcastADReceive();
        }

        @Override // io.dcloud.feature.gg.dcloud.IAolReceiver
        public void onReceiver(org.json.JSONObject jSONObject) {
            org.json.JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("psas");
            boolean z = jSONObject.optInt("pap", 0) == 1;
            io.dcloud.common.adapter.util.SP.setBundleData(this.mContext, io.dcloud.feature.gg.dcloud.ADHandler.AdTag, "dpap", jSONObject.optString("dpap", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT));
            if (jSONArrayOptJSONArray == null || !z) {
                io.dcloud.feature.gg.dcloud.ADHandler.log("ADReceiver", "onReceiver no data = " + jSONObject);
            } else {
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                int length = jSONArrayOptJSONArray.length();
                io.dcloud.feature.gg.dcloud.ADHandler.log("ADReceiver", "onReceiver psas.length = " + length + "; data=" + jSONObject);
                for (int i = 0; i < length; i++) {
                    io.dcloud.feature.gg.dcloud.ADHandler.handleAdData(this.mContext, jSONArrayOptJSONArray.optJSONObject(i), jCurrentTimeMillis);
                }
            }
            if (io.dcloud.feature.gg.dcloud.ADHandler.isPullFor360) {
                return;
            }
            broadcastADReceive();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class AdData {
        public java.lang.Object mImgData;
        java.lang.String mImgPath;
        java.lang.String mImgSrc;
        org.json.JSONObject mJsonData;
        android.view.MotionEvent mMotionEvent_down;
        android.view.MotionEvent mMotionEvent_up;
        java.lang.String mOriginalAppid;
        java.lang.String mProvider;
        int mEShow = 0;
        int mEClick = 0;

        boolean check() {
            return (this.mJsonData == null || this.mImgData == null) ? false : true;
        }

        org.json.JSONObject data() {
            return this.mJsonData.optJSONObject("data");
        }

        org.json.JSONObject full() {
            return this.mJsonData;
        }

        boolean isEClick() {
            return this.mEClick == 1;
        }

        boolean isEShow() {
            return this.mEShow == 1;
        }

        void listenADReceive(android.content.Context context, final io.dcloud.feature.gg.dcloud.IAolReceiver iAolReceiver) {
            if (iAolReceiver != null) {
                android.content.BroadcastReceiver broadcastReceiver = new android.content.BroadcastReceiver() { // from class: io.dcloud.feature.gg.dcloud.ADHandler.AdData.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(android.content.Context context2, android.content.Intent intent) {
                        try {
                            long longExtra = intent.getLongExtra("end", 0L) - intent.getLongExtra("begin", 0L);
                            io.dcloud.feature.gg.dcloud.ADHandler.log("ADReceive", "useTime=" + longExtra);
                            if (longExtra <= 3000) {
                                iAolReceiver.onReceiver(null);
                            }
                            io.dcloud.feature.gg.dcloud.ADHandler.log("ADReceive", "unregisterReceiver");
                            context2.unregisterReceiver(this);
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                try {
                    android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                    intentFilter.addAction("ad_receive");
                    androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, intentFilter);
                    io.dcloud.feature.gg.dcloud.ADHandler.log("ADReceive", "registerReceiver");
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }

        org.json.JSONObject report() {
            return this.mJsonData.optJSONObject("report");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface AdDataWatcher<E> {
        boolean find();

        void operate(E e);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface ThreadTask {
        void execute();
    }

    public static java.lang.Boolean SplashAdIsEnable(android.content.Context context) {
        if (io.dcloud.p.c4.b()) {
            return java.lang.Boolean.FALSE;
        }
        if (handler == null) {
            handler = (io.dcloud.p.u3) io.dcloud.p.r0.d().a();
        }
        return java.lang.Boolean.valueOf(handler.a(context));
    }

    private static void addThreadTask(final io.dcloud.feature.gg.dcloud.ADHandler.ThreadTask threadTask) {
        if (threadTask != null) {
            if (java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
                io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.ADHandler.3
                    @Override // java.lang.Runnable
                    public void run() {
                        threadTask.execute();
                    }
                });
            } else {
                threadTask.execute();
            }
        }
    }

    public static boolean allReady(android.content.Context context) {
        return !android.text.TextUtils.isEmpty(get(context, "appid"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void analysisPullData(byte[] bArr, java.lang.String str, io.dcloud.feature.gg.dcloud.IAolReceiver... iAolReceiverArr) throws org.json.JSONException {
        io.dcloud.p.u3 u3Var;
        if (bArr == null) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(bArr));
        int iOptInt = jSONObject.optInt("ret", -1);
        int i = 0;
        if (iOptInt != 0) {
            int length = iAolReceiverArr.length;
            while (i < length) {
                iAolReceiverArr[i].onError(java.lang.String.valueOf(iOptInt), jSONObject.optString("desc"));
                i++;
            }
            io.dcloud.p.u3 u3Var2 = handler;
            if (u3Var2 != null) {
                u3Var2.a(-5007, jSONObject.optString("desc"));
                return;
            }
            return;
        }
        if (jSONObject.has("data")) {
            java.lang.String strDecrypt = io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.c(), io.dcloud.p.e1.b(), android.util.Base64.decode(jSONObject.optString("data"), 2));
            if (strDecrypt != null) {
                try {
                    try {
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject(strDecrypt);
                        io.dcloud.feature.gg.AolSplashUtil.decodeChannel(jSONObject2);
                        jSONObject.put("data", jSONObject2);
                    } catch (java.lang.Exception unused) {
                    }
                } catch (java.lang.Exception unused2) {
                    jSONObject.put("data", new org.json.JSONArray(strDecrypt));
                }
            }
        }
        int length2 = iAolReceiverArr.length;
        while (i < length2) {
            iAolReceiverArr[i].onReceiver(jSONObject);
            i++;
        }
        if ((str.equals("ThirdConfig") || str.equals("Splash")) && (u3Var = handler) != null) {
            u3Var.a(jSONObject);
        }
    }

    static java.lang.String appid(android.content.Context context) {
        return get(context, "appid");
    }

    static int bg(android.content.Context context) {
        int iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(get(context, "bg"));
        if (iStringToColor != -1) {
            return iStringToColor;
        }
        return -1;
    }

    static void click(final android.content.Context context, final io.dcloud.feature.gg.dcloud.ADHandler.AdData adData, final java.lang.String str) {
        final java.lang.String strOptString = adData.data().optString("tid");
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.ADHandler.9
            @Override // java.lang.Runnable
            public void run() {
                org.json.JSONObject clickData;
                int i;
                if (adData.isEClick()) {
                    clickData = null;
                    i = 46;
                } else {
                    clickData = io.dcloud.feature.gg.dcloud.ADHandler.getClickData(adData);
                    i = 41;
                }
                org.json.JSONObject jSONObject = clickData;
                org.json.JSONObject jSONObjectFull = adData.full();
                io.dcloud.p.e0.a(context, adData.mOriginalAppid, strOptString, str, i, null, null, jSONObject, null, null, io.dcloud.feature.gg.AolSplashUtil.getSplashAdpId("_adpid_", "UNIAD_SPLASH_ADPID"), (jSONObjectFull == null || !jSONObjectFull.has("ua")) ? "" : jSONObjectFull.optString("ua"), null);
            }
        });
        if ("wanka".equals(adData.mProvider)) {
            io.dcloud.feature.gg.dcloud.ADHandler_wanka.click_wanka(context, adData, str);
            return;
        }
        if ("youdao".equals(adData.mProvider)) {
            io.dcloud.feature.gg.dcloud.ADHandler_youdao.click_youdao(context, adData, str);
        } else if ("common".equals(adData.mProvider)) {
            io.dcloud.feature.gg.dcloud.Aolhandler_common.click_common(context, adData, str);
        } else {
            click_base(context, adData, str);
        }
    }

    static void click_base(final android.content.Context context, final io.dcloud.feature.gg.dcloud.ADHandler.AdData adData, final java.lang.String str) {
        org.json.JSONObject jSONObjectData = adData.data();
        final java.lang.String strOptString = adData.data().optString("tid");
        if (jSONObjectData.has("dplk") && io.dcloud.common.util.ADUtils.openDeepLink(context, jSONObjectData.optString("dplk"))) {
            if (adData.isEClick()) {
                return;
            }
            io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.ADHandler.8
                @Override // java.lang.Runnable
                public void run() {
                    org.json.JSONObject jSONObjectFull = adData.full();
                    io.dcloud.common.util.TestUtil.PointTime.commitTid(context, adData.mOriginalAppid, strOptString, str, 50, io.dcloud.feature.gg.AolSplashUtil.getSplashAdpId("_adpid_", "UNIAD_SPLASH_ADPID"), false, (jSONObjectFull == null || !jSONObjectFull.has("ua")) ? "" : jSONObjectFull.optString("ua"));
                }
            });
            if ("wanka".equals(adData.mProvider)) {
                io.dcloud.feature.gg.dcloud.ADHandler_wanka.dplk_wanka(context, adData, str);
                return;
            } else if ("youdao".equals(adData.mProvider)) {
                io.dcloud.feature.gg.dcloud.ADHandler_youdao.dplk_youdao(context, adData, str);
                return;
            } else {
                if ("common".equals(adData.mProvider)) {
                    io.dcloud.feature.gg.dcloud.Aolhandler_common.handletask_common(context, adData, str, "dptracker");
                    return;
                }
                return;
            }
        }
        java.lang.String strOptString2 = jSONObjectData.optString("action");
        if (android.text.TextUtils.equals("url", strOptString2)) {
            if (adData.isEClick()) {
                io.dcloud.feature.gg.dcloud.ADSim.openUrl(context, jSONObjectData.optString("url"));
                return;
            } else {
                io.dcloud.common.util.ADUtils.openUrl(context, jSONObjectData.optString("url"));
                return;
            }
        }
        if (android.text.TextUtils.equals(io.dcloud.common.constant.AbsoluteConst.SPNAME_DOWNLOAD, strOptString2)) {
            if (jSONObjectData.has("expires")) {
                try {
                    new java.text.SimpleDateFormat("yy-MM-dd HH:mm:ss", java.util.Locale.ENGLISH).parse(jSONObjectData.optString("expires")).getTime();
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                }
            }
            java.lang.String strOptString3 = adData.full() != null ? adData.full().optString("ua") : "";
            if (adData.isEClick()) {
                io.dcloud.feature.gg.dcloud.ADSim.dwApp(context, adData.mOriginalAppid, strOptString, str, jSONObjectData.optString("url"), jSONObjectData.optString(io.dcloud.feature.uniapp.adapter.AbsURIAdapter.BUNDLE), null, strOptString3);
                return;
            }
            return;
        }
        if (android.text.TextUtils.equals(io.dcloud.common.constant.AbsoluteConst.XML_STREAMAPP, strOptString2) && jSONObjectData.has("appid")) {
            if (adData.isEClick()) {
                return;
            }
            io.dcloud.common.util.ADUtils.openStreamApp(context, jSONObjectData.optString("appid"), jSONObjectData.optJSONObject("parameters"), -1, jSONObjectData.optString("streamapps"));
        } else {
            if (!android.text.TextUtils.equals("browser", strOptString2) || adData.isEClick()) {
                return;
            }
            io.dcloud.common.util.ADUtils.openBrowser(context, jSONObjectData.optString("url"));
        }
    }

    private static java.lang.Boolean defAdConfig(android.content.Context context) {
        try {
            return java.lang.Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("DCLOUD_AD_SPLASH", false));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return java.lang.Boolean.FALSE;
        }
    }

    private static void exec5Plus(final java.util.List<io.dcloud.common.util.hostpicker.HostPicker.Host> list, java.lang.String str, final io.dcloud.feature.gg.dcloud.IAolReceiver[] iAolReceiverArr) {
        java.lang.String strEncode;
        try {
            strEncode = java.net.URLEncoder.encode(android.util.Base64.encodeToString(io.dcloud.common.util.AESUtil.encrypt(io.dcloud.p.e1.c(), io.dcloud.p.e1.b(), io.dcloud.common.util.ZipUtils.zipString(str)), 2), "utf-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            strEncode = null;
        }
        final java.lang.String str2 = "edata=" + strEncode;
        final boolean z = !hasOtherAd();
        addThreadTask(new io.dcloud.feature.gg.dcloud.ADHandler.ThreadTask() { // from class: io.dcloud.feature.gg.dcloud.ADHandler.2
            @Override // io.dcloud.feature.gg.dcloud.ADHandler.ThreadTask
            public void execute() {
                java.util.List list2 = list;
                if (list2 != null) {
                    io.dcloud.feature.gg.dcloud.ADHandler.pull((java.util.List<io.dcloud.common.util.hostpicker.HostPicker.Host>) list2, "ThirdConfig", str2, z, iAolReceiverArr);
                    return;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (java.lang.String str3 : io.dcloud.p.r1.b.keySet()) {
                    io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum priorityEnum = io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.BACKUP;
                    int iIntValue = ((java.lang.Integer) io.dcloud.p.r1.b.get(str3)).intValue();
                    if (iIntValue != -1) {
                        if (iIntValue == 0) {
                            priorityEnum = io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.NORMAL;
                        } else if (iIntValue == 1) {
                            priorityEnum = io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.FIRST;
                        }
                    }
                    arrayList.add(new io.dcloud.common.util.hostpicker.HostPicker.Host(str3, priorityEnum));
                }
                io.dcloud.feature.gg.dcloud.ADHandler.pull(arrayList, "Splash", str2, z, iAolReceiverArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fileAdData(android.content.Context context, java.io.File file, io.dcloud.feature.gg.dcloud.ADHandler.AdData adData) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(io.dcloud.common.adapter.io.DHFile.readAll(file.getAbsolutePath() + "/data.json")));
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                return;
            }
            adData.mProvider = jSONObject.optString("provider");
            adData.mJsonData = jSONObject;
            adData.mEShow = jSONObject.optInt("es", 0);
            adData.mEClick = jSONObject.optInt("ec", 0);
            java.lang.String strOptString = jSONObjectOptJSONObject.optString("src");
            adData.mImgSrc = strOptString;
            boolean zEndsWith = strOptString.toLowerCase(java.util.Locale.ENGLISH).endsWith(".gif");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(file.getAbsolutePath());
            sb.append("/");
            sb.append(zEndsWith ? File_Gif : File_Img);
            java.lang.String string = sb.toString();
            java.lang.String str = file.getAbsolutePath() + "/s.txt";
            if (!new java.io.File(string).exists() || new java.io.File(str).exists()) {
                return;
            }
            if (zEndsWith) {
                adData.mImgData = io.dcloud.common.adapter.util.PlatformUtil.newInstance("pl.droidsonroids.gif.GifDrawable", new java.lang.Class[]{java.lang.String.class}, new java.lang.Object[]{jSONObject.optString("srcPath")});
            } else {
                android.graphics.Bitmap bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(string);
                if (bitmapDecodeFile != null) {
                    adData.mImgData = bitmapDecodeFile;
                }
            }
            adData.mImgPath = string;
            new java.io.File(str).createNewFile();
            io.dcloud.common.adapter.io.DHFile.delete(file.getAbsolutePath());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    static java.lang.String formatUrl(java.lang.String str, org.json.JSONObject jSONObject) {
        try {
            return str.replace("${User-Agent}", java.net.URLEncoder.encode(jSONObject.optString("u-a"), "utf-8")).replace("${click_id}", jSONObject.optString("click_id")).replace("${down_x}", java.lang.String.valueOf(jSONObject.optInt("down_x", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME))).replace("${down_y}", java.lang.String.valueOf(jSONObject.optInt("down_y", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME))).replace("${up_x}", java.lang.String.valueOf(jSONObject.optInt("up_x", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME))).replace("${up_y}", java.lang.String.valueOf(jSONObject.optInt("up_y", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME))).replace("${relative_down_x}", java.lang.String.valueOf(jSONObject.optInt("relative_down_x", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME))).replace("${relative_down_y}", java.lang.String.valueOf(jSONObject.optInt("relative_down_y", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME))).replace("${relative_up_x}", java.lang.String.valueOf(jSONObject.optInt("relative_up_x", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME))).replace("${relative_up_y}", java.lang.String.valueOf(jSONObject.optInt("relative_up_y", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME)));
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    private static void get(java.lang.StringBuilder sb, java.lang.String str, java.lang.String str2) {
        try {
            java.lang.Class.forName(io.dcloud.p.e1.b(str));
            sb.append(",");
            sb.append(str2);
        } catch (java.lang.Exception unused) {
        }
    }

    static org.json.JSONObject getArgsJsonData(org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            jSONObject2.put("ua", jSONObject.optString("ua"));
            jSONObject2.put("down_x", jSONObject.optInt("down_x"));
            jSONObject2.put("down_y", jSONObject.optInt("down_y"));
            jSONObject2.put("up_x", jSONObject.optInt("up_x"));
            jSONObject2.put("up_y", jSONObject.optInt("up_y"));
            jSONObject2.put("relative_down_x", jSONObject.optInt("relative_down_x"));
            jSONObject2.put("relative_down_y", jSONObject.optInt("relative_down_y"));
            jSONObject2.put("relative_up_x", jSONObject.optInt("relative_up_x"));
            jSONObject2.put("relative_up_y", jSONObject.optInt("relative_up_y"));
            return jSONObject2;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return jSONObject2;
        }
    }

    private static java.lang.String getBId() {
        try {
            java.io.File file = new java.io.File("/proc/sys/kernel/random/boot_id");
            if (!file.exists()) {
                return "";
            }
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            byte[] bArr = new byte[37];
            fileInputStream.read(bArr);
            java.lang.String str = new java.lang.String(bArr);
            try {
                fileInputStream.close();
                return str;
            } catch (java.lang.Exception unused) {
                return str;
            }
        } catch (java.lang.Exception unused2) {
            return "";
        }
    }

    public static io.dcloud.feature.gg.dcloud.ADHandler.AdData getBestAdData(android.content.Context context, java.lang.String str) {
        return getBestAdData(context, str, new io.dcloud.feature.gg.dcloud.ADHandler.AdData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static org.json.JSONObject getClickData(io.dcloud.feature.gg.dcloud.ADHandler.AdData adData) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.taobao.weex.ui.component.WXBasicComponentType.IMG, adData.mImgSrc);
            org.json.JSONObject jSONObjectFull = adData.full();
            jSONObject.put("dw", jSONObjectFull.optInt("dw"));
            jSONObject.put("dh", jSONObjectFull.optInt("dh"));
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("dx", jSONObjectFull.optInt("down_x"));
            jSONObject2.put(com.taobao.weex.common.Constants.Name.DISTANCE_Y, jSONObjectFull.optInt("down_y"));
            jSONObject2.put("ux", jSONObjectFull.optInt("up_x"));
            jSONObject2.put("uy", jSONObjectFull.optInt("up_y"));
            jSONObject2.put("rdx", jSONObjectFull.optInt("relative_down_x"));
            jSONObject2.put("rdy", jSONObjectFull.optInt("relative_down_y"));
            jSONObject2.put("rux", jSONObjectFull.optInt("relative_up_x"));
            jSONObject2.put("ruy", jSONObjectFull.optInt("relative_up_y"));
            jSONObject.put("click_coord", jSONObject2);
            return jSONObject;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private static java.lang.String getRootPath(android.content.Context context) {
        java.io.File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            return "/sdcard/Android/data/" + context.getPackageName() + "/cache/ad/";
        }
        return externalCacheDir.getAbsolutePath() + "/ad/";
    }

    private static java.lang.String getUT() {
        try {
            java.lang.Process processExec = java.lang.Runtime.getRuntime().exec("stat -c \"%x\" /data/data");
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(processExec.getInputStream()));
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            char[] cArr = new char[256];
            while (true) {
                int i = bufferedReader.read(cArr);
                if (i <= 0) {
                    break;
                }
                stringBuffer.append(cArr, 0, i);
            }
            bufferedReader.close();
            processExec.waitFor();
            java.lang.String[] strArrSplit = stringBuffer.toString().replace(io.dcloud.common.util.JSUtil.QUOTE, "").split("\\.");
            long time = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strArrSplit[0]).getTime();
            java.lang.String strSubstring = strArrSplit[1];
            if (strSubstring.contains(com.taobao.weex.el.parse.Operators.PLUS)) {
                strSubstring = strSubstring.substring(0, strSubstring.indexOf(com.taobao.weex.el.parse.Operators.PLUS));
            }
            return (time / 1000) + com.taobao.weex.el.parse.Operators.DOT_STR + java.lang.Long.parseLong(strSubstring.trim());
        } catch (java.lang.Exception unused) {
            return com.taobao.weex.el.parse.Operators.DOT_STR;
        }
    }

    private static void handleAdBaseData(final android.content.Context context, final org.json.JSONObject jSONObject, java.lang.String str, final java.lang.String str2, java.lang.String str3) throws java.lang.Exception {
        if (jSONObject != null && jSONObject.has("es") && jSONObject.getInt("es") == 1) {
            new io.dcloud.feature.gg.dcloud.ADSim(context, jSONObject).start();
            return;
        }
        java.lang.System.currentTimeMillis();
        io.dcloud.common.adapter.io.DHFile.writeFile(str.getBytes(), 0, str3 + File_Tid);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str3);
        sb.append(str2.endsWith(".gif") ? File_Gif : File_Img);
        final java.lang.String string = sb.toString();
        jSONObject.put("srcPath", string);
        io.dcloud.common.adapter.io.DHFile.writeFile(jSONObject.toString().getBytes(), 0, str3 + File_Data);
        addThreadTask(new io.dcloud.feature.gg.dcloud.ADHandler.ThreadTask() { // from class: io.dcloud.feature.gg.dcloud.ADHandler.12
            @Override // io.dcloud.feature.gg.dcloud.ADHandler.ThreadTask
            public void execute() {
                java.util.HashMap map;
                byte[] bArrHttpGet = null;
                if (jSONObject.has("ua") && jSONObject.optString("ua").equalsIgnoreCase("webview")) {
                    map = new java.util.HashMap();
                    map.put(io.dcloud.common.DHInterface.IWebview.USER_AGENT, io.dcloud.feature.gg.dcloud.ADHandler.get("ua-webview"));
                } else {
                    map = null;
                }
                try {
                    bArrHttpGet = io.dcloud.common.util.NetTool.httpGet(str2, (java.util.HashMap<java.lang.String, java.lang.String>) map, true);
                } catch (java.lang.Exception unused) {
                }
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("download file is nulll");
                sb2.append(bArrHttpGet == null);
                sb2.append("src=");
                sb2.append(str2);
                io.dcloud.feature.gg.dcloud.ADHandler.log("adh", sb2.toString());
                if (bArrHttpGet != null) {
                    io.dcloud.common.adapter.io.DHFile.writeFile(bArrHttpGet, 0, string);
                }
                if (io.dcloud.feature.gg.dcloud.ADHandler.isPullFor360) {
                    return;
                }
                android.content.Intent intent = new android.content.Intent();
                intent.setAction("ad_img_downlaod_receive");
                intent.putExtra("downloadImage", bArrHttpGet != null);
                intent.putExtra("src", str2);
                androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                io.dcloud.feature.gg.dcloud.ADHandler.log("adh", "handleAdBaseData--downloadC");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleAdData(android.content.Context context, org.json.JSONObject jSONObject, long j) {
        try {
            java.lang.String strOptString = jSONObject.optString("provider");
            if ("dcloud".equals(strOptString)) {
                handleAdData_dcloud(context, jSONObject, j);
                return;
            }
            if ("wanka".equals(strOptString)) {
                io.dcloud.feature.gg.dcloud.ADHandler_wanka.handleAdData_wanka(context, jSONObject, j);
            } else if ("youdao".equals(strOptString)) {
                io.dcloud.feature.gg.dcloud.ADHandler_youdao.handleAdData_youdao(context, jSONObject, j);
            } else if ("common".equals(strOptString)) {
                io.dcloud.feature.gg.dcloud.Aolhandler_common.handleAdData_common(context, jSONObject, j);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    static void handleAdData_dcloud(android.content.Context context, org.json.JSONObject jSONObject, long j) throws java.lang.Exception {
        java.lang.String rootPath = getRootPath(context);
        org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        java.util.Date date = new java.text.SimpleDateFormat("yy-MM-dd HH:mm:ss", java.util.Locale.ENGLISH).parse(jSONObjectOptJSONObject.optString("expires"));
        if (date.getTime() > java.lang.System.currentTimeMillis()) {
            java.lang.String strOptString = jSONObjectOptJSONObject.optString("src");
            handleAdBaseData(context, jSONObject, jSONObjectOptJSONObject.optString("tid"), strOptString, rootPath + j + "/" + date.getTime() + "/" + java.net.URLEncoder.encode(strOptString, "utf-8").hashCode() + "/");
        }
    }

    public static void handleSplashAdEnable(android.content.Context context, java.lang.Boolean bool) {
        io.dcloud.p.u3 u3Var = handler;
        if (u3Var != null) {
            u3Var.a(context, bool.booleanValue() ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    private static boolean hasOtherAd() {
        java.lang.String bundleData = io.dcloud.common.adapter.util.SP.getBundleData(AdTag, "pspType");
        if (android.text.TextUtils.isEmpty(bundleData)) {
            return false;
        }
        return bundleData.contains("360") || bundleData.contains(io.dcloud.sdk.core.util.Const.TYPE_GDT) || bundleData.contains(io.dcloud.sdk.core.util.Const.TYPE_CSJ);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d  */
    static android.graphics.drawable.Drawable img(android.content.Context context) {
        android.graphics.Bitmap bitmapDecodeStream;
        java.lang.String str = get(context, com.taobao.weex.ui.component.WXBasicComponentType.IMG);
        if (android.text.TextUtils.isEmpty(str)) {
            bitmapDecodeStream = null;
        } else if (!io.dcloud.common.util.PdrUtil.isDeviceRootDir(str)) {
            bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(io.dcloud.common.adapter.util.PlatformUtil.getInputStream(str, 0));
        } else if (new java.io.File(str).exists()) {
            bitmapDecodeStream = android.graphics.BitmapFactory.decodeFile(str);
        } else {
            bitmapDecodeStream = null;
        }
        if (bitmapDecodeStream != null) {
            return new android.graphics.drawable.BitmapDrawable(bitmapDecodeStream);
        }
        return null;
    }

    private static void listExpiresAdData(android.content.Context context, io.dcloud.feature.gg.dcloud.ADHandler.AdDataWatcher<java.io.File> adDataWatcher) {
        java.io.File file = new java.io.File(getRootPath(context));
        if (!file.exists()) {
            file.mkdirs();
        }
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        sortDesc(fileArrListFiles);
        for (java.io.File file2 : fileArrListFiles) {
            if (adDataWatcher.find()) {
                io.dcloud.common.adapter.io.DHFile.delete(file2);
            } else {
                for (java.io.File file3 : file2.listFiles()) {
                    if (java.lang.Long.parseLong(file3.getName()) <= java.lang.System.currentTimeMillis()) {
                        io.dcloud.common.adapter.io.DHFile.delete(file3);
                    } else if (!adDataWatcher.find()) {
                        for (java.io.File file4 : file3.listFiles()) {
                            adDataWatcher.operate(file4);
                            if (adDataWatcher.find()) {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    static void log(java.lang.String str, java.lang.String str2) {
    }

    static java.lang.String mc(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(io.dcloud.common.util.BaseInfo.sChannel) || android.text.TextUtils.equals("default", io.dcloud.common.util.BaseInfo.sChannel)) {
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("DCLOUD_STREAMAPP_CHANNEL", io.dcloud.common.util.BaseInfo.sChannel);
            } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return io.dcloud.common.util.BaseInfo.sChannel;
    }

    static java.lang.String name(android.content.Context context) {
        return get(context, "name");
    }

    public static java.lang.String papEnable(android.content.Context context) {
        java.lang.String str = getRootPath(context).replaceAll("/ad/", "/") + "AdEnable.dat";
        try {
            if (io.dcloud.common.adapter.io.DHFile.isExist(str)) {
                return new java.lang.String(io.dcloud.common.adapter.io.DHFile.readAll(str));
            }
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static void postSplashError(android.content.Context context, java.lang.String str, java.lang.String str2, org.json.JSONArray jSONArray) {
        java.lang.String str3;
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT, "a");
        map.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, get(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME));
        map.put("appid", get("appid"));
        map.put("name", get(context, "name"));
        map.put("pn", context.getPackageName());
        try {
            str3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).versionName;
        } catch (java.lang.Exception unused) {
            str3 = null;
        }
        map.put("pv", str3);
        map.put(com.facebook.common.callercontext.ContextChain.TAG_INFRA, android.util.Base64.encodeToString(io.dcloud.common.util.AESUtil.encrypt(io.dcloud.p.e1.c(), io.dcloud.p.e1.b(), io.dcloud.common.util.ZipUtils.zipString(io.dcloud.common.util.TelephonyUtil.getIMEI(context, true, true))), 2));
        map.put("md", android.os.Build.MODEL);
        map.put("vd", android.os.Build.MANUFACTURER);
        map.put(com.taobao.weex.common.WXConfig.os, java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT));
        map.put("vb", io.dcloud.common.util.PdrUtil.isEmpty("1.9.9.82680") ? "" : "1.9.9.82680");
        map.put("net", java.lang.Integer.valueOf(io.dcloud.common.util.NetworkTypeUtil.getNetworkType(context)));
        map.put("mc", mc(context));
        map.put("paid", get(context, "adid"));
        map.put("dw", java.lang.Integer.valueOf(io.dcloud.feature.gg.AolSplashUtil.dw(context)));
        map.put("dh", java.lang.Integer.valueOf(io.dcloud.feature.gg.AolSplashUtil.dh(context)));
        map.put("c", str);
        map.put(com.taobao.weex.ui.component.WXComponent.PROP_FS_MATCH_PARENT, str2);
        if (jSONArray != null) {
            map.put("d", jSONArray);
        }
        final java.lang.String string = new org.json.JSONObject(map).toString();
        addThreadTask(new io.dcloud.feature.gg.dcloud.ADHandler.ThreadTask() { // from class: io.dcloud.feature.gg.dcloud.ADHandler.6
            @Override // io.dcloud.feature.gg.dcloud.ADHandler.ThreadTask
            public void execute() {
                io.dcloud.common.util.NetTool.httpPost(io.dcloud.common.util.PdrUtil.checkIntl() ? "https://er.dcloud.io/sc" : "https://er.dcloud.net.cn/sc", string, new java.util.HashMap());
            }
        });
    }

    public static void pr(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.String str;
        map.put("name", get(context, "name"));
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).versionName;
        } catch (java.lang.Exception unused) {
            str = null;
        }
        map.put("pv", str);
        map.put(com.taobao.weex.common.WXConfig.os, java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT));
        map.put("vb", io.dcloud.common.util.PdrUtil.isEmpty("1.9.9.82680") ? "" : "1.9.9.82680");
        pullRad(context, map, new io.dcloud.feature.gg.dcloud.ADHandler.ADReceiver(context), new io.dcloud.feature.gg.dcloud.ADResult.CADReceiver(context));
    }

    private static java.lang.String psas(android.content.Context context) {
        final java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        listExpiresAdData(context, new io.dcloud.feature.gg.dcloud.ADHandler.AdDataWatcher<java.io.File>() { // from class: io.dcloud.feature.gg.dcloud.ADHandler.10
            @Override // io.dcloud.feature.gg.dcloud.ADHandler.AdDataWatcher
            public boolean find() {
                return false;
            }

            @Override // io.dcloud.feature.gg.dcloud.ADHandler.AdDataWatcher
            public void operate(java.io.File file) throws java.lang.Throwable {
                byte[] all = io.dcloud.common.adapter.io.DHFile.readAll(file.getAbsolutePath() + "/tid.txt");
                if (all != null) {
                    stringBuffer.append(new java.lang.String(all)).append(",");
                }
            }
        });
        return stringBuffer.length() > 0 ? stringBuffer.substring(0, stringBuffer.length() - 1) : stringBuffer.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void pull(final android.content.Context context, java.lang.String str, boolean z, java.util.List<io.dcloud.common.util.hostpicker.HostPicker.Host> list, io.dcloud.feature.gg.dcloud.IAolReceiver... iAolReceiverArr) {
        if (android.text.TextUtils.isEmpty(io.dcloud.common.util.BaseInfo.sDefaultBootApp)) {
            io.dcloud.common.util.BaseInfo.parseControl();
        }
        boolean z2 = false;
        boolean zStartsWith = !android.text.TextUtils.isEmpty(io.dcloud.common.util.BaseInfo.sDefaultBootApp) ? io.dcloud.common.util.BaseInfo.sDefaultBootApp.startsWith("__UNI__") : false;
        java.lang.String[] strArrSplit = mc(context).split("\\|");
        java.lang.String str2 = (strArrSplit == null || strArrSplit.length <= 2) ? "" : strArrSplit[2];
        io.dcloud.sdk.core.DCloudAOLManager.InitConfig initConfig = new io.dcloud.sdk.core.DCloudAOLManager.InitConfig();
        initConfig.setAdId(str2).setAppId(io.dcloud.common.util.BaseInfo.sDefaultBootApp);
        io.dcloud.p.t3.a(context, initConfig, new io.dcloud.p.u3());
        io.dcloud.sdk.core.DCloudAOLManager.setPrivacyConfig(new io.dcloud.sdk.poly.base.utils.PrivacyManager.a() { // from class: io.dcloud.feature.gg.dcloud.ADHandler.1
            @Override // io.dcloud.sdk.poly.base.utils.PrivacyManager.a
            public java.lang.String getAndroidId() {
                return io.dcloud.common.util.TelephonyUtil.getAId(context);
            }

            @Override // io.dcloud.sdk.poly.base.utils.PrivacyManager.a
            public java.lang.String[] getImeis() {
                return io.dcloud.common.util.TelephonyUtil.getMultiIMEI(context);
            }

            @Override // io.dcloud.sdk.poly.base.utils.PrivacyManager.a
            public java.lang.String getImsi() {
                return io.dcloud.common.util.TelephonyUtil.getIMSI(context);
            }

            @Override // io.dcloud.sdk.poly.base.utils.PrivacyManager.a
            public boolean isAllowPrivacy() {
                return !io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(context);
            }
        });
        io.dcloud.p.u3 u3Var = (io.dcloud.p.u3) io.dcloud.p.r0.d().a();
        handler = u3Var;
        java.util.HashMap mapB = u3Var.b(context);
        mapB.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, get(context, io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME));
        mapB.put("name", get(context, "name"));
        mapB.put("psas", psas(context));
        mapB.put("ps", java.lang.Integer.valueOf(io.dcloud.common.util.BaseInfo.existsStreamEnv() ? 1 : 0));
        mapB.put("psd", java.lang.Integer.valueOf(io.dcloud.common.util.BaseInfo.ISDEBUG ? 1 : 0));
        java.lang.Boolean boolSplashAdIsEnable = SplashAdIsEnable(context);
        java.lang.Boolean boolDefAdConfig = defAdConfig(context);
        mapB.put("pap", boolSplashAdIsEnable.booleanValue() ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        mapB.put("papi", boolDefAdConfig.booleanValue() ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        mapB.put("psaf", allReady(context) ? com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT : "1");
        java.lang.String str3 = get("cad");
        if (!android.text.TextUtils.isEmpty(str3)) {
            mapB.put("rad", str3);
        }
        java.lang.String strA = io.dcloud.common.adapter.util.SP.getsOrCreateBundle(context, io.dcloud.p.e1.b("IlKgfnao")).a(io.dcloud.p.e1.b("[xdi{`IlMfijdm"), io.dcloud.common.constant.AbsoluteConst.TRUE);
        mapB.put("mpap", strA != null && strA.equalsIgnoreCase(io.dcloud.common.constant.AbsoluteConst.FALSE) ? com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT : "1");
        java.lang.String string = new org.json.JSONObject(mapB).toString();
        if (!zStartsWith) {
            try {
                java.lang.Class.forName("io.dcloud.common.cs.DA");
                zStartsWith = true;
            } catch (java.lang.ClassNotFoundException unused) {
            }
        }
        if (zStartsWith) {
            try {
                java.lang.Object objInvokeMethod = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.common.cs.DA", "getInstance", null);
                if (objInvokeMethod != null && (objInvokeMethod instanceof io.dcloud.common.DHInterface.DAI)) {
                    if (list != null) {
                        ((io.dcloud.common.DHInterface.DAI) objInvokeMethod).act(string, new io.dcloud.feature.gg.dcloud.ADResult(iAolReceiverArr));
                    } else {
                        ((io.dcloud.common.DHInterface.DAI) objInvokeMethod).ar(string, new io.dcloud.feature.gg.dcloud.ADResult(iAolReceiverArr));
                    }
                    z2 = true;
                }
            } catch (java.lang.Exception e) {
                io.dcloud.common.adapter.util.Logger.e("ADHANDLER", e.toString());
            }
        }
        if (z2) {
            return;
        }
        exec5Plus(list, string, iAolReceiverArr);
    }

    static void pullRad(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, final io.dcloud.feature.gg.dcloud.IAolReceiver... iAolReceiverArr) {
        java.lang.String strEncode;
        if (android.text.TextUtils.isEmpty(io.dcloud.common.util.BaseInfo.sDefaultBootApp)) {
            io.dcloud.common.util.BaseInfo.parseControl();
        }
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT, "a");
        map2.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, get(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME));
        map2.put("appid", io.dcloud.common.util.BaseInfo.sDefaultBootApp);
        map2.put("vb", io.dcloud.common.util.PdrUtil.isEmpty("1.9.9.82680") ? "" : "1.9.9.82680");
        map2.put("imei", io.dcloud.common.util.TelephonyUtil.getIMEI(context, true, true));
        if (map == null || !map.containsKey("rad") || io.dcloud.common.util.PdrUtil.isEmpty(map.get("rad"))) {
            return;
        }
        map2.put("pn", context.getPackageName());
        map2.put("mc", mc(context));
        map2.put("paid", get(context, "adid"));
        map2.put("psdk", 0);
        map2.putAll(map);
        try {
            strEncode = java.net.URLEncoder.encode(android.util.Base64.encodeToString(io.dcloud.common.util.AESUtil.encrypt(io.dcloud.p.e1.c(), io.dcloud.p.e1.b(), io.dcloud.common.util.ZipUtils.zipString(new org.json.JSONObject(map2).toString())), 2), "utf-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            strEncode = null;
        }
        final java.lang.String str = "edata=" + strEncode;
        final boolean z = !hasOtherAd();
        addThreadTask(new io.dcloud.feature.gg.dcloud.ADHandler.ThreadTask() { // from class: io.dcloud.feature.gg.dcloud.ADHandler.5
            @Override // io.dcloud.feature.gg.dcloud.ADHandler.ThreadTask
            public void execute() {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                if (io.dcloud.common.util.PdrUtil.checkIntl()) {
                    arrayList.add(new io.dcloud.common.util.hostpicker.HostPicker.Host("YHx8eHsyJydvazkmbGtkZ31sJmFnJ2tnZGRta3wneGR9e2l4eCdraWw=", io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.FIRST));
                } else if (android.text.TextUtils.isEmpty(io.dcloud.p.l0.b()) || "CN".equalsIgnoreCase(io.dcloud.p.l0.b())) {
                    arrayList.add(new io.dcloud.common.util.hostpicker.HostPicker.Host("YHx8eHsyJydrOSZsa2RnfWwmZm18JmtmJ2tnZGRta3wneGR9e2l4eCdraWw=", io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.FIRST));
                } else {
                    arrayList.add(new io.dcloud.common.util.hostpicker.HostPicker.Host("YHx8eHsyJydvazkmbGtkZ31sJmZtfCZrZidrZ2RkbWt8J3hkfXtpeHgna2ls", io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.FIRST));
                }
                io.dcloud.feature.gg.dcloud.ADHandler.pull(arrayList, "CAD", str, z, iAolReceiverArr);
            }
        });
    }

    public static void setSplashAd(android.content.Context context, boolean z, io.dcloud.feature.gg.dcloud.IAolReceiver... iAolReceiverArr) {
        java.lang.String str;
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT, "a");
        map.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, get(context, io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME));
        map.put("appid", io.dcloud.common.util.BaseInfo.sDefaultBootApp);
        map.put("name", get(context, "name"));
        try {
            map.put("pname", context.getApplicationInfo().loadLabel(context.getPackageManager()));
        } catch (java.lang.Exception unused) {
        }
        map.put("pn", context.getPackageName());
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).versionName;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            str = null;
        }
        map.put("pv", str);
        map.put(com.taobao.weex.common.WXConfig.os, java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT));
        map.put("vb", io.dcloud.common.util.PdrUtil.isEmpty("1.9.9.82680") ? "" : "1.9.9.82680");
        map.put("mc", mc(context));
        map.put("psdk", 0);
        map.put("mpap", z ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        map.put("smpap", "1");
        exec5Plus(null, new org.json.JSONObject(map).toString(), iAolReceiverArr);
    }

    private static void sortDesc(java.io.File[] fileArr) {
        if (fileArr == null) {
            return;
        }
        for (int i = 0; i < fileArr.length - 1; i++) {
            int i2 = 0;
            while (i2 < (fileArr.length - 1) - i) {
                int i3 = i2 + 1;
                if (java.lang.Long.parseLong(fileArr[i2].getName()) < java.lang.Long.parseLong(fileArr[i3].getName())) {
                    java.io.File file = fileArr[i2];
                    fileArr[i2] = fileArr[i3];
                    fileArr[i3] = file;
                }
                i2 = i3;
            }
        }
    }

    static void view(final android.content.Context context, final io.dcloud.feature.gg.dcloud.ADHandler.AdData adData, final java.lang.String str) {
        final java.lang.String strOptString = adData.data().optString("tid");
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.ADHandler.7
            @Override // java.lang.Runnable
            public void run() {
                int i = adData.isEShow() ? 45 : 40;
                org.json.JSONObject jSONObjectFull = adData.full();
                io.dcloud.common.util.TestUtil.PointTime.commitTid(context, adData.mOriginalAppid, strOptString, str, i, io.dcloud.feature.gg.AolSplashUtil.getSplashAdpId("_adpid_", "UNIAD_SPLASH_ADPID"), false, (jSONObjectFull == null || !jSONObjectFull.has("ua")) ? "" : jSONObjectFull.optString("ua"));
            }
        });
        if ("wanka".equals(adData.mProvider)) {
            io.dcloud.feature.gg.dcloud.ADHandler_wanka.view_wanka(context, adData, str);
        } else if ("youdao".equals(adData.mProvider)) {
            io.dcloud.feature.gg.dcloud.ADHandler_youdao.view_youdao(context, adData, str);
        } else if ("common".equals(adData.mProvider)) {
            io.dcloud.feature.gg.dcloud.Aolhandler_common.handletask_common(context, adData, str, "imptracker");
        }
    }

    static java.lang.String get(android.content.Context context, java.lang.String str) {
        return io.dcloud.common.adapter.util.SP.getBundleData(context, AdTag, str);
    }

    static io.dcloud.feature.gg.dcloud.ADHandler.AdData getBestAdData(final android.content.Context context, java.lang.String str, final io.dcloud.feature.gg.dcloud.ADHandler.AdData adData) {
        adData.mOriginalAppid = str;
        expiresFileList = new java.util.LinkedList<>();
        listExpiresAdData(context, new io.dcloud.feature.gg.dcloud.ADHandler.AdDataWatcher<java.io.File>() { // from class: io.dcloud.feature.gg.dcloud.ADHandler.11
            @Override // io.dcloud.feature.gg.dcloud.ADHandler.AdDataWatcher
            public boolean find() {
                return adData.check();
            }

            @Override // io.dcloud.feature.gg.dcloud.ADHandler.AdDataWatcher
            public void operate(java.io.File file) {
                io.dcloud.feature.gg.dcloud.ADHandler.expiresFileList.add(file);
                io.dcloud.feature.gg.dcloud.ADHandler.fileAdData(context, file, adData);
            }
        });
        if (!adData.check() && expiresFileList.size() != 0) {
            for (int i = 0; i < expiresFileList.size(); i++) {
                new java.io.File(expiresFileList.get(i).getAbsolutePath() + "/s.txt").delete();
                if (i == 0) {
                    fileAdData(context, expiresFileList.get(i), adData);
                }
            }
        }
        return adData;
    }

    public static java.lang.String get(java.lang.String str) {
        return io.dcloud.common.adapter.util.SP.getBundleData(AdTag, str);
    }

    public static void pull(android.content.Context context, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str2 : io.dcloud.p.r1.c.keySet()) {
            io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum priorityEnum = io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.BACKUP;
            int iIntValue = ((java.lang.Integer) io.dcloud.p.r1.c.get(str2)).intValue();
            if (iIntValue != -1) {
                if (iIntValue == 0) {
                    priorityEnum = io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.NORMAL;
                } else if (iIntValue == 1) {
                    priorityEnum = io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.FIRST;
                }
            }
            arrayList.add(new io.dcloud.common.util.hostpicker.HostPicker.Host(str2, priorityEnum));
        }
        pull(context, str, false, (java.util.List<io.dcloud.common.util.hostpicker.HostPicker.Host>) arrayList, new io.dcloud.feature.gg.dcloud.ADHandler.ADReceiver(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pull(java.util.List<io.dcloud.common.util.hostpicker.HostPicker.Host> list, final java.lang.String str, final java.lang.String str2, final boolean z, final io.dcloud.feature.gg.dcloud.IAolReceiver... iAolReceiverArr) {
        io.dcloud.common.util.hostpicker.HostPicker.getInstance().pickSuitHost(io.dcloud.application.DCLoudApplicationImpl.self().getContext(), list, str, new io.dcloud.common.util.hostpicker.HostPicker.HostPickCallback() { // from class: io.dcloud.feature.gg.dcloud.ADHandler.4
            java.lang.String[] message = new java.lang.String[1];

            @Override // io.dcloud.common.util.hostpicker.HostPicker.HostPickCallback
            public boolean doRequest(io.dcloud.common.util.hostpicker.HostPicker.Host host) {
                byte[] bArrHttpPost = io.dcloud.common.util.NetTool.httpPost(host.getRealHost(), str2, new java.util.HashMap(), false, z, this.message);
                if (bArrHttpPost == null) {
                    return false;
                }
                try {
                    io.dcloud.feature.gg.dcloud.ADHandler.analysisPullData(bArrHttpPost, str, iAolReceiverArr);
                    return true;
                } catch (java.lang.Exception e) {
                    for (io.dcloud.feature.gg.dcloud.IAolReceiver iAolReceiver : iAolReceiverArr) {
                        iAolReceiver.onError("Exception", e.getMessage());
                    }
                    if (io.dcloud.feature.gg.dcloud.ADHandler.handler == null) {
                        return true;
                    }
                    io.dcloud.feature.gg.dcloud.ADHandler.handler.a(-5007, e.getMessage());
                    return true;
                }
            }

            @Override // io.dcloud.common.util.hostpicker.HostPicker.HostPickCallback
            public void onNoOnePicked() {
                io.dcloud.feature.gg.dcloud.IAolReceiver[] iAolReceiverArr2 = iAolReceiverArr;
                int length = iAolReceiverArr2.length;
                int i = 0;
                while (true) {
                    java.lang.String str3 = "data invalid";
                    if (i >= length) {
                        break;
                    }
                    io.dcloud.feature.gg.dcloud.IAolReceiver iAolReceiver = iAolReceiverArr2[i];
                    java.lang.String str4 = this.message[0];
                    if (str4 != null) {
                        str3 = str4;
                    }
                    iAolReceiver.onError("NotFountDataError", str3);
                    i++;
                }
                if (io.dcloud.feature.gg.dcloud.ADHandler.handler != null) {
                    io.dcloud.p.u3 u3Var = io.dcloud.feature.gg.dcloud.ADHandler.handler;
                    java.lang.String str5 = this.message[0];
                    u3Var.a(-5007, str5 != null ? str5 : "data invalid");
                }
            }

            @Override // io.dcloud.common.util.hostpicker.HostPicker.HostPickCallback
            public void onOneSelected(io.dcloud.common.util.hostpicker.HostPicker.Host host) {
            }
        });
    }
}
