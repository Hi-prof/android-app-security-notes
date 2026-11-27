package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static io.dcloud.p.b j;
    private volatile android.content.Context a;
    private boolean b = false;
    private org.json.JSONObject c = new org.json.JSONObject();
    private org.json.JSONObject d = new org.json.JSONObject();
    private org.json.JSONObject e = new org.json.JSONObject();
    private org.json.JSONObject f = new org.json.JSONObject();
    private org.json.JSONObject g = new org.json.JSONObject();
    private org.json.JSONObject h = new org.json.JSONObject();
    private android.os.Handler i = new io.dcloud.p.b.a();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends android.os.Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            try {
                io.dcloud.p.b.this.a();
            } catch (java.lang.Exception unused) {
            }
            sendEmptyMessageDelayed(1, java.lang.Double.valueOf((java.lang.Math.random() + 1.0d) * 1000.0d * 60.0d).longValue());
        }
    }

    /* JADX INFO: renamed from: io.dcloud.p.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class HandlerC0069b extends android.os.Handler {
        HandlerC0069b() {
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            try {
                io.dcloud.p.b.this.a();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            sendEmptyMessageDelayed(1, java.lang.Double.valueOf((java.lang.Math.random() + 1.0d) * 1000.0d * 60.0d).longValue());
        }
    }

    private b() {
        if (j != null) {
            throw new java.lang.IllegalStateException();
        }
    }

    private java.lang.String b(java.lang.String str) {
        android.os.Bundle bundle;
        try {
            android.content.pm.ApplicationInfo applicationInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 128).applicationInfo;
            return (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? "" : bundle.getString(str);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private void c() {
        if (this.d.length() > 0) {
            return;
        }
        try {
            this.d.put("r", "1");
            this.d.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, (java.lang.String) java.lang.Class.forName(io.dcloud.p.e1.b("kge&jmara&n}{agf&JmaRa{")).getMethod(io.dcloud.p.e1.b("om|[lc^mz{agf"), null).invoke(null, null));
        } catch (java.lang.Exception unused) {
        }
        try {
            try {
                java.lang.Class.forName(io.dcloud.p.e1.b("ag&lkdg}l&{lc&xgdq&ilix|mz&k}{|ge&jr&K}{|geJRIlix|mz"));
                this.d.put("ada", "1");
            } catch (java.lang.Exception unused2) {
            }
        } catch (java.lang.Exception unused3) {
            this.d.put("ada", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0079 A[Catch: Exception -> 0x007e, TRY_LEAVE, TryCatch #1 {Exception -> 0x007e, blocks: (B:3:0x000d, B:5:0x0018, B:7:0x001c, B:9:0x002a, B:13:0x0033, B:16:0x005e, B:18:0x0079), top: B:22:0x000d }] */
    private java.util.Map d() {
        java.util.HashMap map = new java.util.HashMap();
        map.put("app_id", "");
        try {
            byte[] bArrDecode2bytes = io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(1));
            if (bArrDecode2bytes == null) {
                a(4);
                return map;
            }
            java.lang.String strDecrypt = io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), bArrDecode2bytes);
            if (strDecrypt == null) {
                a(4);
                return map;
            }
            java.lang.Class<?> cls = null;
            try {
                try {
                    java.lang.Class<?> cls2 = java.lang.Class.forName(strDecrypt);
                    return (java.util.Map) cls2.getMethod("NM_getCustomInfo", null).invoke(cls2.newInstance(), null);
                } catch (java.lang.Exception unused) {
                    java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(8))));
                    if (cls == null) {
                        map.put("app_id", "unknow");
                    }
                    return map;
                }
            } catch (java.lang.Exception unused2) {
                cls = java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(9))));
                java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(8))));
                if (cls == null) {
                    map.put("app_id", "unknow");
                }
                return map;
            }
        } catch (java.lang.Exception unused3) {
        }
    }

    private java.lang.String e() {
        byte[] bArrDecode2bytes = io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(12));
        if (bArrDecode2bytes == null) {
            a(4);
            return "";
        }
        java.lang.String strDecrypt = io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), bArrDecode2bytes);
        if (strDecrypt == null) {
            a(4);
            return "";
        }
        try {
            java.lang.reflect.Field declaredField = java.lang.Class.forName(strDecrypt).getDeclaredField("appId");
            declaredField.setAccessible(true);
            return (java.lang.String) declaredField.get(null);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private java.lang.String f() {
        byte[] bArrDecode2bytes = io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(2));
        if (bArrDecode2bytes == null) {
            a(4);
            return "";
        }
        java.lang.String strDecrypt = io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), bArrDecode2bytes);
        if (strDecrypt == null) {
            a(4);
            return "";
        }
        for (java.util.List list : io.dcloud.p.r4.b()) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName(io.dcloud.p.e1.b((java.lang.String) list.get(0)));
                return (java.lang.String) cls.getMethod(io.dcloud.p.e1.b((java.lang.String) list.get(2)), null).invoke(cls.getDeclaredMethod(io.dcloud.p.e1.b((java.lang.String) list.get(1)), null).invoke(null, null), null);
            } catch (java.lang.Exception unused) {
            }
        }
        try {
            java.lang.Class<?> cls2 = java.lang.Class.forName(strDecrypt);
            java.lang.Object objInvoke = cls2.getMethod("getAppStatus", null).invoke(cls2.getMethod("getInstance", null).invoke(null, null), null);
            if (objInvoke != null) {
                return (java.lang.String) objInvoke.getClass().getMethod("getAPPID", null).invoke(objInvoke, null);
            }
        } catch (java.lang.Exception unused2) {
        }
        return "";
    }

    private void g() {
        if (this.f.length() > 0) {
            return;
        }
        try {
            this.f.put("r", "1");
            this.f.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, (java.lang.String) java.lang.Class.forName(io.dcloud.p.e1.b("kge&iddaifkm&{{x&il&ixa&[IIddaifkmIl[lc")).getMethod(io.dcloud.p.e1.b("om|Qg}\\}aILF[LC^mz{agf"), null).invoke(null, null));
        } catch (java.lang.Exception unused) {
        }
        try {
            try {
                java.lang.Class.forName(io.dcloud.p.e1.b("ag&lkdg}l&{lc&xgdq&ilix|mz&k}{|ge&q|&K}{|geQ\\Ilix|mz"));
                this.f.put("ada", "1");
            } catch (java.lang.Exception unused2) {
            }
        } catch (java.lang.Exception unused3) {
            this.f.put("ada", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    private void h() {
        if (this.e.length() > 0) {
            return;
        }
        try {
            this.e.put("r", "1");
            this.e.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, (java.lang.String) java.lang.Class.forName(io.dcloud.p.e1.b("kge&baiil{&il~a{|i&{lc&Il~a{|i[lc")).getMethod(io.dcloud.p.e1.b("om^mz{agf"), null).invoke(null, null));
        } catch (java.lang.Exception unused) {
        }
        try {
            try {
                java.lang.Class.forName(io.dcloud.p.e1.b("kge&baiil{&}fail&Il~a{|iK}{|geIlix|mz"));
                this.e.put("ada", "1");
            } catch (java.lang.Exception unused2) {
            }
        } catch (java.lang.Exception unused3) {
            this.e.put("ada", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    private java.lang.String i() {
        byte[] bArrDecode2bytes = io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(10));
        if (bArrDecode2bytes == null) {
            a(4);
            return "";
        }
        java.lang.String strDecrypt = io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), bArrDecode2bytes);
        if (strDecrypt == null) {
            a(4);
            return "";
        }
        try {
            return (java.lang.String) java.lang.Class.forName(strDecrypt).getMethod("getAppId", null).invoke(null, null);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private java.lang.String j() {
        try {
            for (java.util.List list : io.dcloud.p.r4.c()) {
                try {
                    java.lang.Class<?> cls = java.lang.Class.forName(io.dcloud.p.e1.b((java.lang.String) list.get(0)));
                    java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod(io.dcloud.p.e1.b((java.lang.String) list.get(1)), null);
                    declaredMethod.setAccessible(true);
                    return (java.lang.String) cls.getMethod(io.dcloud.p.e1.b((java.lang.String) list.get(2)), null).invoke(declaredMethod.invoke(null, null), null);
                } catch (java.lang.Exception unused) {
                }
            }
            return "";
        } catch (java.lang.Exception unused2) {
            return "";
        }
    }

    private java.lang.String k() {
        byte[] bArrDecode2bytes = io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(11));
        if (bArrDecode2bytes == null) {
            a(4);
            return "";
        }
        java.lang.String strDecrypt = io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), bArrDecode2bytes);
        if (strDecrypt == null) {
            a(4);
            return "";
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(strDecrypt);
            java.lang.Object objInvoke = cls.getMethod("sharedAds", null).invoke(null, null);
            java.lang.reflect.Method method = cls.getMethod("getAppId", null);
            method.setAccessible(true);
            return (java.lang.String) method.invoke(objInvoke, null);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private void l() {
        if (this.h.length() > 0) {
            return;
        }
        try {
            this.h.put("r", "1");
            this.h.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, (java.lang.String) java.lang.Class.forName(io.dcloud.p.e1.b("kge&\u007fifoeia&ixx{lclmp&_EIl[lc")).getMethod(io.dcloud.p.e1.b("om|[lc^mz{agf"), null).invoke(null, null));
        } catch (java.lang.Exception unused) {
        }
        try {
            try {
                java.lang.Class.forName(io.dcloud.p.e1.b("kge&\u007fe&\u007feilix|mz}fail&_E[lcAfa|"));
                this.h.put("ada", "1");
            } catch (java.lang.Exception unused2) {
            }
        } catch (java.lang.Exception unused3) {
            this.h.put("ada", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    private void m() {
        if (this.g.length() > 0) {
            return;
        }
        try {
            this.g.put("r", "1");
            this.g.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, (java.lang.String) java.lang.Class.forName(io.dcloud.p.e1.b("kge&gk|gx}{&il&Gk|gx}{")).getMethod(io.dcloud.p.e1.b("om|[lc^mz{agf"), null).invoke(null, null));
        } catch (java.lang.Exception unused) {
        }
        try {
            try {
                java.lang.Class.forName(io.dcloud.p.e1.b("ag&lkdg}l&{lc&xgdq&ilix|mz&rq&RQILIlix|mz"));
                this.g.put("ada", "1");
            } catch (java.lang.Exception unused2) {
            }
        } catch (java.lang.Exception unused3) {
            this.g.put("ada", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    public static io.dcloud.p.b o() {
        if (j == null) {
            synchronized (io.dcloud.p.b.class) {
                if (j == null) {
                    j = new io.dcloud.p.b();
                }
            }
        }
        return j;
    }

    public java.util.List n() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            android.content.pm.ActivityInfo[] activityInfoArr = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 1).activities;
            if (activityInfoArr != null) {
                for (android.content.pm.ActivityInfo activityInfo : activityInfoArr) {
                    arrayList.add(activityInfo.name);
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return arrayList;
    }

    public void p() {
        android.os.Handler handler = this.i;
        if (handler != null) {
            this.b = false;
            handler.removeMessages(1);
            this.i = null;
        }
    }

    public void a(android.content.Context context) {
        android.os.Handler handler;
        if (!io.dcloud.common.util.PdrUtil.checkIntl() || io.dcloud.common.util.language.LanguageUtil.getDeviceDefCountry().equalsIgnoreCase(io.dcloud.p.e1.b("KF"))) {
            this.a = context;
            try {
                if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
                    return;
                }
                if (java.lang.Math.abs(java.lang.Math.random() * 5.0d) == 5.0d && (handler = this.i) != null) {
                    handler.removeMessages(1);
                    this.i = null;
                }
                if (this.i == null) {
                    this.i = new io.dcloud.p.b.HandlerC0069b();
                }
                if (this.i.hasMessages(1)) {
                    return;
                }
                this.i.sendEmptyMessage(1);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void b() {
        if (this.c.length() > 0) {
            return;
        }
        try {
            this.c.put("r", "1");
            this.c.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, (java.lang.String) java.lang.Class.forName(io.dcloud.p.e1.b("kge&jial}&egjil{&{lc&ixa&Il[m||afo{")).getMethod(io.dcloud.p.e1.b("om|[LC^mz{agf"), null).invoke(null, null));
        } catch (java.lang.Exception unused) {
        }
        try {
            try {
                java.lang.Class.forName(io.dcloud.p.e1.b("ag&lkdg}l&{lc&xgdq&ilix|mz&jl&JLIlIlix|mz"));
                this.c.put("ada", "1");
            } catch (java.lang.Exception unused2) {
            }
        } catch (java.lang.Exception unused3) {
            this.c.put("ada", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:101:0x026f A[Catch: Exception -> 0x02ac, TRY_LEAVE, TryCatch #5 {Exception -> 0x02ac, blocks: (B:99:0x0269, B:101:0x026f), top: B:268:0x0269 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:120:0x02b9 A[Catch: Exception -> 0x02ee, TRY_LEAVE, TryCatch #2 {Exception -> 0x02ee, blocks: (B:118:0x02b3, B:120:0x02b9), top: B:262:0x02b3 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:125:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:129:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:130:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:134:0x02fb A[Catch: Exception -> 0x0330, TRY_LEAVE, TryCatch #0 {Exception -> 0x0330, blocks: (B:132:0x02f5, B:134:0x02fb), top: B:258:0x02f5 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0330  */
    /* JADX WARN: Code duplicated, block: B:148:0x033b A[Catch: Exception -> 0x036f, TRY_LEAVE, TryCatch #1 {Exception -> 0x036f, blocks: (B:146:0x0335, B:148:0x033b), top: B:260:0x0335 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0369  */
    /* JADX WARN: Code duplicated, block: B:166:0x03a4 A[Catch: Exception -> 0x03c6, TRY_LEAVE, TryCatch #20 {Exception -> 0x03c6, blocks: (B:164:0x0396, B:166:0x03a4), top: B:298:0x0396 }] */
    /* JADX WARN: Code duplicated, block: B:173:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:176:0x03cd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:200:0x0435 A[Catch: Exception -> 0x050d, TryCatch #3 {Exception -> 0x050d, blocks: (B:198:0x0415, B:200:0x0435, B:205:0x0448, B:240:0x04f1, B:203:0x0444), top: B:264:0x0415 }] */
    /* JADX WARN: Code duplicated, block: B:203:0x0444 A[Catch: Exception -> 0x050d, LOOP:0: B:199:0x0433->B:203:0x0444, LOOP_END, TryCatch #3 {Exception -> 0x050d, blocks: (B:198:0x0415, B:200:0x0435, B:205:0x0448, B:240:0x04f1, B:203:0x0444), top: B:264:0x0415 }] */
    /* JADX WARN: Code duplicated, block: B:208:0x0465 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:209:0x0467 A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:211:0x046c A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:213:0x0473 A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:215:0x0478 A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:218:0x0483 A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:221:0x0490 A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:224:0x049f A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:227:0x04ae A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:230:0x04bd A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:233:0x04cc A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:236:0x04db A[Catch: Exception -> 0x04f1, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:239:0x04ea A[Catch: Exception -> 0x04f1, TRY_LEAVE, TryCatch #17 {Exception -> 0x04f1, blocks: (B:207:0x045d, B:209:0x0467, B:211:0x046c, B:213:0x0473, B:215:0x0478, B:216:0x047d, B:218:0x0483, B:219:0x048a, B:221:0x0490, B:222:0x0497, B:224:0x049f, B:225:0x04a6, B:227:0x04ae, B:228:0x04b5, B:230:0x04bd, B:231:0x04c4, B:233:0x04cc, B:234:0x04d3, B:236:0x04db, B:237:0x04e2, B:239:0x04ea), top: B:292:0x045d }] */
    /* JADX WARN: Code duplicated, block: B:274:0x019d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:276:0x0182 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:292:0x045d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:300:0x038b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:302:0x03b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:304:0x0447 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:305:0x0443 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0110  */
    /* JADX WARN: Code duplicated, block: B:38:0x0124  */
    /* JADX WARN: Code duplicated, block: B:39:0x0127  */
    /* JADX WARN: Code duplicated, block: B:49:0x0158 A[PHI: r24 r28
  0x0158: PHI (r24v9 java.lang.String) = (r24v2 java.lang.String), (r24v2 java.lang.String), (r24v10 java.lang.String) binds: [B:41:0x0135, B:43:0x013b, B:38:0x0124] A[DONT_GENERATE, DONT_INLINE]
  0x0158: PHI (r28v2 java.util.Map) = (r28v0 java.util.Map), (r28v0 java.util.Map), (r28v3 java.util.Map) binds: [B:41:0x0135, B:43:0x013b, B:38:0x0124] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:52:0x0162  */
    /* JADX WARN: Code duplicated, block: B:54:0x0174  */
    /* JADX WARN: Code duplicated, block: B:56:0x0180 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x018b  */
    /* JADX WARN: Code duplicated, block: B:62:0x0191  */
    /* JADX WARN: Code duplicated, block: B:67:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:70:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:72:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:75:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:77:0x01df  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:82:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:85:0x0203  */
    /* JADX WARN: Code duplicated, block: B:87:0x0215  */
    /* JADX WARN: Code duplicated, block: B:90:0x021e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0230  */
    /* JADX WARN: Code duplicated, block: B:95:0x0239  */
    /* JADX WARN: Code duplicated, block: B:97:0x024b  */
    public void a() {
        java.util.Map mapD;
        java.lang.String str;
        boolean zEquals;
        java.lang.String strA;
        java.lang.String strF;
        java.lang.String strA2;
        java.lang.String strI;
        java.lang.String strA3;
        int i;
        java.lang.String strA4;
        java.lang.String str2;
        boolean z;
        java.lang.String strB;
        java.lang.String str3;
        java.lang.String strB2;
        java.lang.String strB3;
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String strK;
        java.util.Map map;
        java.lang.String str7;
        java.lang.String strE;
        java.lang.String strA5;
        org.json.JSONObject jSONObject3;
        org.json.JSONArray jSONArrayA;
        org.json.JSONObject jSONObject4;
        org.json.JSONObject jSONObject5;
        org.json.JSONObject jSONObject6;
        org.json.JSONObject jSONObject7;
        java.util.HashMap map2;
        org.json.JSONObject jSONObject8;
        java.lang.String str8;
        java.lang.String str9;
        boolean z2;
        boolean z3;
        java.lang.String str10;
        java.lang.String str11;
        boolean z4;
        boolean z5;
        java.lang.String str12;
        boolean z6;
        boolean z7;
        java.lang.String str13;
        boolean z8;
        boolean z9;
        java.lang.String strB4;
        java.lang.String str14;
        java.lang.String strA6;
        org.json.JSONArray jSONArrayA2;
        boolean z10;
        java.lang.reflect.Method[] declaredMethods;
        int length;
        int i2;
        java.lang.reflect.Method method;
        org.json.JSONObject jSONObject9;
        java.lang.String str15;
        org.json.JSONArray jSONArrayA3;
        java.util.List listN = n();
        java.util.List listA = io.dcloud.p.r4.a();
        if (listN.size() == 0 || listN.contains(io.dcloud.p.e1.b((java.lang.String) listA.get(1))) || listN.contains(io.dcloud.p.e1.b((java.lang.String) listA.get(4)))) {
            mapD = d();
            str = (java.lang.String) mapD.remove("app_id");
            zEquals = "unknow".equals(str);
            strA = a("UNIAD_CSJ_APPID", io.dcloud.sdk.core.util.Const.TYPE_CSJ);
        } else {
            mapD = null;
            str = null;
            zEquals = true;
            strA = null;
        }
        if (listN.size() == 0 || listN.contains(io.dcloud.p.e1.b((java.lang.String) listA.get(0)))) {
            strF = f();
            strA2 = a("UNIAD_GDT_APPID", io.dcloud.sdk.core.util.Const.TYPE_GDT);
        } else {
            strF = null;
            strA2 = null;
        }
        if (listN.size() == 0 || listN.contains(io.dcloud.p.e1.b((java.lang.String) listA.get(2)))) {
            strI = i();
            strA3 = a("UNIAD_KS_APPID", io.dcloud.sdk.core.util.Const.TYPE_KS);
        } else {
            strA3 = null;
            strI = null;
        }
        try {
            try {
                try {
                    try {
                        try {
                            if (listN.size() != 0) {
                                i = 1;
                                if (!listN.contains(io.dcloud.p.e1.b((java.lang.String) listA.get(5)))) {
                                    z = zEquals;
                                    str2 = null;
                                    strA4 = null;
                                }
                                strB = io.dcloud.p.e1.b("kWixxal");
                                str3 = str2;
                                strB2 = io.dcloud.p.e1.b("{Wixxal");
                                java.lang.String str16 = strA4;
                                strB3 = io.dcloud.p.e1.b("{WixxalW`");
                                jSONObject = new org.json.JSONObject();
                                java.lang.String str17 = strA3;
                                jSONObject2 = new org.json.JSONObject();
                                str4 = strI;
                                str5 = strF;
                                if (listN.size() != 0) {
                                    str6 = strA2;
                                    if (listN.contains(io.dcloud.p.e1.b((java.lang.String) listA.get(3)))) {
                                        map = mapD;
                                    }
                                    str7 = io.dcloud.sdk.core.util.Const.TYPE_CSJ;
                                    if (listN.size() != 0 || listN.contains(io.dcloud.p.e1.b((java.lang.String) listA.get(8)))) {
                                        strE = e();
                                        strA5 = a("", "10028");
                                        if (strE == null) {
                                            jSONObject3 = jSONObject;
                                        } else {
                                            if (strA5 == null) {
                                                try {
                                                    jSONObject2.put("r", "1");
                                                    jSONObject2.put(strB, strE);
                                                } catch (java.lang.Exception unused) {
                                                }
                                            } else if (!strE.equals(strA5)) {
                                                jSONObject3 = jSONObject;
                                                jSONArrayA = a("10028");
                                                if (!a(strE, jSONArrayA)) {
                                                    try {
                                                        jSONObject2.put("r", "1");
                                                        jSONObject2.put(strB, strE);
                                                        jSONObject2.put(strB2, strA5);
                                                        jSONObject2.put(strB3, jSONArrayA);
                                                    } catch (java.lang.Exception unused2) {
                                                    }
                                                }
                                            }
                                            jSONObject3 = jSONObject;
                                        }
                                    } else {
                                        jSONObject3 = jSONObject;
                                    }
                                    if (listN.size() != 0 || listN.contains(io.dcloud.p.e1.b((java.lang.String) listA.get(6)))) {
                                        c();
                                    }
                                    if (listN.size() != 0 || listN.contains(io.dcloud.p.e1.b((java.lang.String) listA.get(7)))) {
                                        h();
                                    }
                                    if (listN.size() != 0 || listN.contains(io.dcloud.p.e1.b((java.lang.String) listA.get(9)))) {
                                        g();
                                    }
                                    if (listN.size() != 0 || listN.contains(io.dcloud.p.e1.b((java.lang.String) listA.get(10)))) {
                                        m();
                                    }
                                    if (listN.size() != 0 || listN.contains(io.dcloud.p.e1.b((java.lang.String) listA.get(11)))) {
                                        b();
                                    }
                                    if (listN.size() != 0 || listN.contains(io.dcloud.p.e1.b((java.lang.String) listA.get(12)))) {
                                        l();
                                    }
                                    jSONObject4 = new org.json.JSONObject();
                                    jSONObject5 = new org.json.JSONObject();
                                    jSONObject6 = new org.json.JSONObject();
                                    jSONObject7 = new org.json.JSONObject();
                                    map2 = new java.util.HashMap();
                                    if (!android.text.TextUtils.isEmpty(str) || str.equals(strA)) {
                                        jSONObject8 = jSONObject2;
                                        str8 = str7;
                                        str9 = "10028";
                                    } else {
                                        java.lang.String str18 = strA;
                                        str8 = str7;
                                        str9 = "10028";
                                        try {
                                            org.json.JSONArray jSONArrayA4 = a(str8);
                                            if (!a(str, jSONArrayA4)) {
                                                if (z) {
                                                    jSONObject8 = jSONObject2;
                                                    try {
                                                        a(6);
                                                    } catch (java.lang.Exception unused3) {
                                                        z2 = true;
                                                    }
                                                } else {
                                                    jSONObject8 = jSONObject2;
                                                }
                                                try {
                                                    map2.put("r", "1");
                                                    map2.put(strB, str);
                                                    map2.put(strB2, java.lang.String.valueOf(str18));
                                                    map2.put(strB3, jSONArrayA4);
                                                    if (map != null) {
                                                        map2.putAll(map);
                                                    }
                                                    while (true) {
                                                        if (i2 < length) {
                                                            method = null;
                                                            break;
                                                        }
                                                        method = declaredMethods[i2];
                                                        if (method.getName().equals("pr")) {
                                                            break;
                                                        } else {
                                                            i2++;
                                                        }
                                                    }
                                                } catch (java.lang.Exception unused4) {
                                                }
                                                z2 = false;
                                                if (android.text.TextUtils.isEmpty(str5)) {
                                                    z3 = z2;
                                                    str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                                    str11 = io.dcloud.sdk.core.util.Const.TYPE_GDT;
                                                    z4 = true;
                                                } else {
                                                    str15 = str6;
                                                    if (str5.equals(str15)) {
                                                        z3 = z2;
                                                        str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                                        str11 = io.dcloud.sdk.core.util.Const.TYPE_GDT;
                                                    } else {
                                                        z3 = z2;
                                                        str11 = io.dcloud.sdk.core.util.Const.TYPE_GDT;
                                                        try {
                                                            jSONArrayA3 = a(str11);
                                                            if (a(str5, jSONArrayA3)) {
                                                                str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                                            } else {
                                                                str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                                                try {
                                                                    a(6);
                                                                    try {
                                                                        jSONObject4.put("r", "1");
                                                                        jSONObject4.put(strB, str5);
                                                                        jSONObject4.put(strB2, java.lang.String.valueOf(str15));
                                                                        jSONObject4.put(strB3, jSONArrayA3);
                                                                    } catch (java.lang.Exception unused5) {
                                                                    }
                                                                    z4 = false;
                                                                } catch (java.lang.Exception unused6) {
                                                                    z4 = true;
                                                                }
                                                            }
                                                        } catch (java.lang.Exception unused7) {
                                                        }
                                                    }
                                                    z4 = true;
                                                }
                                                if (!android.text.TextUtils.isEmpty(str4) || str4.equals(str17)) {
                                                    z5 = z4;
                                                    str12 = io.dcloud.sdk.core.util.Const.TYPE_KS;
                                                } else {
                                                    z5 = z4;
                                                    try {
                                                        org.json.JSONArray jSONArrayA5 = a(io.dcloud.sdk.core.util.Const.TYPE_KS);
                                                        if (!a(str4, jSONArrayA5)) {
                                                            str12 = io.dcloud.sdk.core.util.Const.TYPE_KS;
                                                            try {
                                                                a(6);
                                                                try {
                                                                    jSONObject5.put("r", "1");
                                                                    jSONObject5.put(strB, str4);
                                                                    jSONObject5.put(strB2, java.lang.String.valueOf(str17));
                                                                    jSONObject5.put(strB3, jSONArrayA5);
                                                                    while (true) {
                                                                        if (i2 < length) {
                                                                            method = null;
                                                                            break;
                                                                        }
                                                                        method = declaredMethods[i2];
                                                                        if (method.getName().equals("pr")) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        i2++;
                                                                    }
                                                                } catch (java.lang.Exception unused8) {
                                                                }
                                                                z6 = false;
                                                            } catch (java.lang.Exception unused9) {
                                                                z6 = true;
                                                            }
                                                            if (android.text.TextUtils.isEmpty(str3) && !str3.equals(str16)) {
                                                                z7 = z6;
                                                                str13 = io.dcloud.sdk.core.util.Const.TYPE_PG;
                                                                try {
                                                                    org.json.JSONArray jSONArrayA6 = a(str13);
                                                                    if (!a(str3, jSONArrayA6)) {
                                                                        try {
                                                                            jSONObject7.put("r", "1");
                                                                            jSONObject7.put(strB, str3);
                                                                            jSONObject7.put(strB2, java.lang.String.valueOf(str16));
                                                                            jSONObject7.put(strB3, jSONArrayA6);
                                                                        } catch (java.lang.Exception unused10) {
                                                                        }
                                                                        z8 = false;
                                                                    }
                                                                    while (true) {
                                                                        if (i2 < length) {
                                                                            method = null;
                                                                            break;
                                                                        }
                                                                        method = declaredMethods[i2];
                                                                        if (method.getName().equals("pr")) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        i2++;
                                                                    }
                                                                } catch (java.lang.Exception unused11) {
                                                                }
                                                                z9 = z8;
                                                                strB4 = b(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"));
                                                                if (!android.text.TextUtils.isEmpty(strB4)) {
                                                                    try {
                                                                        java.lang.Class.forName(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&EgjadmIl{"));
                                                                        str14 = str13;
                                                                        try {
                                                                            strA6 = a(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"), io.dcloud.sdk.core.util.Const.TYPE_GG);
                                                                            if (!strB4.equals(strA6)) {
                                                                                jSONArrayA2 = a(io.dcloud.sdk.core.util.Const.TYPE_GG);
                                                                                if (!a(strB4, jSONArrayA2)) {
                                                                                    try {
                                                                                        jSONObject6.put("r", "1");
                                                                                        jSONObject6.put(strB, strB4);
                                                                                        jSONObject6.put(strB2, java.lang.String.valueOf(strA6));
                                                                                        jSONObject6.put(strB3, jSONArrayA2);
                                                                                    } catch (java.lang.Exception unused12) {
                                                                                    }
                                                                                    z10 = false;
                                                                                }
                                                                            }
                                                                        } catch (java.lang.Exception unused13) {
                                                                        }
                                                                    } catch (java.lang.Exception unused14) {
                                                                        str14 = str13;
                                                                    }
                                                                    if ((z3 || !z5 || !z7 || !z10 || !z9 || jSONObject3.length() > 0 || jSONObject8.length() > 0 || this.c.length() > 0 || this.g.length() > 0 || this.e.length() > 0 || this.d.length() > 0 || this.f.length() > 0 || this.h.length() > 0) && !this.b) {
                                                                        declaredMethods = java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(7)))).getDeclaredMethods();
                                                                        length = declaredMethods.length;
                                                                        i2 = 0;
                                                                        while (true) {
                                                                            if (i2 < length) {
                                                                                method = null;
                                                                                break;
                                                                            }
                                                                            method = declaredMethods[i2];
                                                                            if (method.getName().equals("pr")) {
                                                                                break;
                                                                                break;
                                                                            }
                                                                            i2++;
                                                                        }
                                                                        java.util.HashMap map3 = new java.util.HashMap();
                                                                        map3.put("t", java.lang.Integer.valueOf(i));
                                                                        jSONObject9 = new org.json.JSONObject();
                                                                        if (!z3) {
                                                                            try {
                                                                                jSONObject9.put(str8, new org.json.JSONObject(map2));
                                                                                if (!z5) {
                                                                                    jSONObject9.put(str11, jSONObject4);
                                                                                }
                                                                                if (!z7) {
                                                                                    jSONObject9.put(str12, jSONObject5);
                                                                                }
                                                                                if (!z10) {
                                                                                    jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                                                                }
                                                                                if (!z9) {
                                                                                    jSONObject9.put(str14, jSONObject7);
                                                                                }
                                                                                if (jSONObject3.length() > 0) {
                                                                                    jSONObject9.put(str10, jSONObject3);
                                                                                }
                                                                                if (jSONObject8.length() > 0) {
                                                                                    jSONObject9.put(str9, jSONObject8);
                                                                                }
                                                                                if (this.c.length() > 0) {
                                                                                    jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                                                                }
                                                                                if (this.d.length() > 0) {
                                                                                    jSONObject9.put("10025", this.d);
                                                                                }
                                                                                if (this.e.length() > 0) {
                                                                                    jSONObject9.put("10033", this.e);
                                                                                }
                                                                                if (this.f.length() > 0) {
                                                                                    jSONObject9.put("10031", this.f);
                                                                                }
                                                                                if (this.g.length() > 0) {
                                                                                    jSONObject9.put("10026", this.g);
                                                                                }
                                                                                if (this.h.length() > 0) {
                                                                                    jSONObject9.put("10034", this.h);
                                                                                }
                                                                            } catch (java.lang.Exception unused15) {
                                                                            }
                                                                        } else {
                                                                            if (!z5) {
                                                                                jSONObject9.put(str11, jSONObject4);
                                                                            }
                                                                            if (!z7) {
                                                                                jSONObject9.put(str12, jSONObject5);
                                                                            }
                                                                            if (!z10) {
                                                                                jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                                                            }
                                                                            if (!z9) {
                                                                                jSONObject9.put(str14, jSONObject7);
                                                                            }
                                                                            if (jSONObject3.length() > 0) {
                                                                                jSONObject9.put(str10, jSONObject3);
                                                                            }
                                                                            if (jSONObject8.length() > 0) {
                                                                                jSONObject9.put(str9, jSONObject8);
                                                                            }
                                                                            if (this.c.length() > 0) {
                                                                                jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                                                            }
                                                                            if (this.d.length() > 0) {
                                                                                jSONObject9.put("10025", this.d);
                                                                            }
                                                                            if (this.e.length() > 0) {
                                                                                jSONObject9.put("10033", this.e);
                                                                            }
                                                                            if (this.f.length() > 0) {
                                                                                jSONObject9.put("10031", this.f);
                                                                            }
                                                                            if (this.g.length() > 0) {
                                                                                jSONObject9.put("10026", this.g);
                                                                            }
                                                                            if (this.h.length() > 0) {
                                                                                jSONObject9.put("10034", this.h);
                                                                            }
                                                                        }
                                                                        map3.put("rad", jSONObject9.toString());
                                                                        method.setAccessible(true);
                                                                        method.invoke(null, this.a, map3);
                                                                        this.b = true;
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                str14 = str13;
                                                                z10 = true;
                                                                if (z3) {
                                                                }
                                                                declaredMethods = java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(7)))).getDeclaredMethods();
                                                                length = declaredMethods.length;
                                                                i2 = 0;
                                                                java.util.HashMap map4 = new java.util.HashMap();
                                                                map4.put("t", java.lang.Integer.valueOf(i));
                                                                jSONObject9 = new org.json.JSONObject();
                                                                if (!z3) {
                                                                    jSONObject9.put(str8, new org.json.JSONObject(map2));
                                                                    if (!z5) {
                                                                        jSONObject9.put(str11, jSONObject4);
                                                                    }
                                                                    if (!z7) {
                                                                        jSONObject9.put(str12, jSONObject5);
                                                                    }
                                                                    if (!z10) {
                                                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                                                    }
                                                                    if (!z9) {
                                                                        jSONObject9.put(str14, jSONObject7);
                                                                    }
                                                                    if (jSONObject3.length() > 0) {
                                                                        jSONObject9.put(str10, jSONObject3);
                                                                    }
                                                                    if (jSONObject8.length() > 0) {
                                                                        jSONObject9.put(str9, jSONObject8);
                                                                    }
                                                                    if (this.c.length() > 0) {
                                                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                                                    }
                                                                    if (this.d.length() > 0) {
                                                                        jSONObject9.put("10025", this.d);
                                                                    }
                                                                    if (this.e.length() > 0) {
                                                                        jSONObject9.put("10033", this.e);
                                                                    }
                                                                    if (this.f.length() > 0) {
                                                                        jSONObject9.put("10031", this.f);
                                                                    }
                                                                    if (this.g.length() > 0) {
                                                                        jSONObject9.put("10026", this.g);
                                                                    }
                                                                    if (this.h.length() > 0) {
                                                                        jSONObject9.put("10034", this.h);
                                                                    }
                                                                } else {
                                                                    if (!z5) {
                                                                        jSONObject9.put(str11, jSONObject4);
                                                                    }
                                                                    if (!z7) {
                                                                        jSONObject9.put(str12, jSONObject5);
                                                                    }
                                                                    if (!z10) {
                                                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                                                    }
                                                                    if (!z9) {
                                                                        jSONObject9.put(str14, jSONObject7);
                                                                    }
                                                                    if (jSONObject3.length() > 0) {
                                                                        jSONObject9.put(str10, jSONObject3);
                                                                    }
                                                                    if (jSONObject8.length() > 0) {
                                                                        jSONObject9.put(str9, jSONObject8);
                                                                    }
                                                                    if (this.c.length() > 0) {
                                                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                                                    }
                                                                    if (this.d.length() > 0) {
                                                                        jSONObject9.put("10025", this.d);
                                                                    }
                                                                    if (this.e.length() > 0) {
                                                                        jSONObject9.put("10033", this.e);
                                                                    }
                                                                    if (this.f.length() > 0) {
                                                                        jSONObject9.put("10031", this.f);
                                                                    }
                                                                    if (this.g.length() > 0) {
                                                                        jSONObject9.put("10026", this.g);
                                                                    }
                                                                    if (this.h.length() > 0) {
                                                                        jSONObject9.put("10034", this.h);
                                                                    }
                                                                }
                                                                map4.put("rad", jSONObject9.toString());
                                                                method.setAccessible(true);
                                                                method.invoke(null, this.a, map4);
                                                                this.b = true;
                                                                return;
                                                            }
                                                            z7 = z6;
                                                            str13 = io.dcloud.sdk.core.util.Const.TYPE_PG;
                                                            z8 = true;
                                                            z9 = z8;
                                                            strB4 = b(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"));
                                                            if (!android.text.TextUtils.isEmpty(strB4)) {
                                                                java.lang.Class.forName(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&EgjadmIl{"));
                                                                str14 = str13;
                                                                strA6 = a(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"), io.dcloud.sdk.core.util.Const.TYPE_GG);
                                                                if (!strB4.equals(strA6)) {
                                                                    jSONArrayA2 = a(io.dcloud.sdk.core.util.Const.TYPE_GG);
                                                                    if (!a(strB4, jSONArrayA2)) {
                                                                        jSONObject6.put("r", "1");
                                                                        jSONObject6.put(strB, strB4);
                                                                        jSONObject6.put(strB2, java.lang.String.valueOf(strA6));
                                                                        jSONObject6.put(strB3, jSONArrayA2);
                                                                        z10 = false;
                                                                    }
                                                                }
                                                                if (z3) {
                                                                }
                                                                declaredMethods = java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(7)))).getDeclaredMethods();
                                                                length = declaredMethods.length;
                                                                i2 = 0;
                                                                while (true) {
                                                                    if (i2 < length) {
                                                                        method = null;
                                                                        break;
                                                                    }
                                                                    method = declaredMethods[i2];
                                                                    if (method.getName().equals("pr")) {
                                                                        break;
                                                                        break;
                                                                    }
                                                                    i2++;
                                                                }
                                                                java.util.HashMap map5 = new java.util.HashMap();
                                                                map5.put("t", java.lang.Integer.valueOf(i));
                                                                jSONObject9 = new org.json.JSONObject();
                                                                if (!z3) {
                                                                    jSONObject9.put(str8, new org.json.JSONObject(map2));
                                                                    if (!z5) {
                                                                        jSONObject9.put(str11, jSONObject4);
                                                                    }
                                                                    if (!z7) {
                                                                        jSONObject9.put(str12, jSONObject5);
                                                                    }
                                                                    if (!z10) {
                                                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                                                    }
                                                                    if (!z9) {
                                                                        jSONObject9.put(str14, jSONObject7);
                                                                    }
                                                                    if (jSONObject3.length() > 0) {
                                                                        jSONObject9.put(str10, jSONObject3);
                                                                    }
                                                                    if (jSONObject8.length() > 0) {
                                                                        jSONObject9.put(str9, jSONObject8);
                                                                    }
                                                                    if (this.c.length() > 0) {
                                                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                                                    }
                                                                    if (this.d.length() > 0) {
                                                                        jSONObject9.put("10025", this.d);
                                                                    }
                                                                    if (this.e.length() > 0) {
                                                                        jSONObject9.put("10033", this.e);
                                                                    }
                                                                    if (this.f.length() > 0) {
                                                                        jSONObject9.put("10031", this.f);
                                                                    }
                                                                    if (this.g.length() > 0) {
                                                                        jSONObject9.put("10026", this.g);
                                                                    }
                                                                    if (this.h.length() > 0) {
                                                                        jSONObject9.put("10034", this.h);
                                                                    }
                                                                } else {
                                                                    if (!z5) {
                                                                        jSONObject9.put(str11, jSONObject4);
                                                                    }
                                                                    if (!z7) {
                                                                        jSONObject9.put(str12, jSONObject5);
                                                                    }
                                                                    if (!z10) {
                                                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                                                    }
                                                                    if (!z9) {
                                                                        jSONObject9.put(str14, jSONObject7);
                                                                    }
                                                                    if (jSONObject3.length() > 0) {
                                                                        jSONObject9.put(str10, jSONObject3);
                                                                    }
                                                                    if (jSONObject8.length() > 0) {
                                                                        jSONObject9.put(str9, jSONObject8);
                                                                    }
                                                                    if (this.c.length() > 0) {
                                                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                                                    }
                                                                    if (this.d.length() > 0) {
                                                                        jSONObject9.put("10025", this.d);
                                                                    }
                                                                    if (this.e.length() > 0) {
                                                                        jSONObject9.put("10033", this.e);
                                                                    }
                                                                    if (this.f.length() > 0) {
                                                                        jSONObject9.put("10031", this.f);
                                                                    }
                                                                    if (this.g.length() > 0) {
                                                                        jSONObject9.put("10026", this.g);
                                                                    }
                                                                    if (this.h.length() > 0) {
                                                                        jSONObject9.put("10034", this.h);
                                                                    }
                                                                }
                                                                map5.put("rad", jSONObject9.toString());
                                                                method.setAccessible(true);
                                                                method.invoke(null, this.a, map5);
                                                                this.b = true;
                                                                return;
                                                            }
                                                            str14 = str13;
                                                            z10 = true;
                                                            if (z3) {
                                                            }
                                                            declaredMethods = java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(7)))).getDeclaredMethods();
                                                            length = declaredMethods.length;
                                                            i2 = 0;
                                                            java.util.HashMap map6 = new java.util.HashMap();
                                                            map6.put("t", java.lang.Integer.valueOf(i));
                                                            jSONObject9 = new org.json.JSONObject();
                                                            if (!z3) {
                                                                jSONObject9.put(str8, new org.json.JSONObject(map2));
                                                                if (!z5) {
                                                                    jSONObject9.put(str11, jSONObject4);
                                                                }
                                                                if (!z7) {
                                                                    jSONObject9.put(str12, jSONObject5);
                                                                }
                                                                if (!z10) {
                                                                    jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                                                }
                                                                if (!z9) {
                                                                    jSONObject9.put(str14, jSONObject7);
                                                                }
                                                                if (jSONObject3.length() > 0) {
                                                                    jSONObject9.put(str10, jSONObject3);
                                                                }
                                                                if (jSONObject8.length() > 0) {
                                                                    jSONObject9.put(str9, jSONObject8);
                                                                }
                                                                if (this.c.length() > 0) {
                                                                    jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                                                }
                                                                if (this.d.length() > 0) {
                                                                    jSONObject9.put("10025", this.d);
                                                                }
                                                                if (this.e.length() > 0) {
                                                                    jSONObject9.put("10033", this.e);
                                                                }
                                                                if (this.f.length() > 0) {
                                                                    jSONObject9.put("10031", this.f);
                                                                }
                                                                if (this.g.length() > 0) {
                                                                    jSONObject9.put("10026", this.g);
                                                                }
                                                                if (this.h.length() > 0) {
                                                                    jSONObject9.put("10034", this.h);
                                                                }
                                                            } else {
                                                                if (!z5) {
                                                                    jSONObject9.put(str11, jSONObject4);
                                                                }
                                                                if (!z7) {
                                                                    jSONObject9.put(str12, jSONObject5);
                                                                }
                                                                if (!z10) {
                                                                    jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                                                }
                                                                if (!z9) {
                                                                    jSONObject9.put(str14, jSONObject7);
                                                                }
                                                                if (jSONObject3.length() > 0) {
                                                                    jSONObject9.put(str10, jSONObject3);
                                                                }
                                                                if (jSONObject8.length() > 0) {
                                                                    jSONObject9.put(str9, jSONObject8);
                                                                }
                                                                if (this.c.length() > 0) {
                                                                    jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                                                }
                                                                if (this.d.length() > 0) {
                                                                    jSONObject9.put("10025", this.d);
                                                                }
                                                                if (this.e.length() > 0) {
                                                                    jSONObject9.put("10033", this.e);
                                                                }
                                                                if (this.f.length() > 0) {
                                                                    jSONObject9.put("10031", this.f);
                                                                }
                                                                if (this.g.length() > 0) {
                                                                    jSONObject9.put("10026", this.g);
                                                                }
                                                                if (this.h.length() > 0) {
                                                                    jSONObject9.put("10034", this.h);
                                                                }
                                                            }
                                                            map6.put("rad", jSONObject9.toString());
                                                            method.setAccessible(true);
                                                            method.invoke(null, this.a, map6);
                                                            this.b = true;
                                                            return;
                                                        }
                                                        str12 = io.dcloud.sdk.core.util.Const.TYPE_KS;
                                                    } catch (java.lang.Exception unused16) {
                                                    }
                                                }
                                                z6 = true;
                                                if (android.text.TextUtils.isEmpty(str3)) {
                                                    z7 = z6;
                                                    str13 = io.dcloud.sdk.core.util.Const.TYPE_PG;
                                                    z8 = true;
                                                } else {
                                                    z7 = z6;
                                                    str13 = io.dcloud.sdk.core.util.Const.TYPE_PG;
                                                    z8 = true;
                                                }
                                                z9 = z8;
                                                strB4 = b(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"));
                                                if (!android.text.TextUtils.isEmpty(strB4)) {
                                                    java.lang.Class.forName(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&EgjadmIl{"));
                                                    str14 = str13;
                                                    strA6 = a(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"), io.dcloud.sdk.core.util.Const.TYPE_GG);
                                                    if (!strB4.equals(strA6)) {
                                                        jSONArrayA2 = a(io.dcloud.sdk.core.util.Const.TYPE_GG);
                                                        if (!a(strB4, jSONArrayA2)) {
                                                            jSONObject6.put("r", "1");
                                                            jSONObject6.put(strB, strB4);
                                                            jSONObject6.put(strB2, java.lang.String.valueOf(strA6));
                                                            jSONObject6.put(strB3, jSONArrayA2);
                                                            z10 = false;
                                                        }
                                                    }
                                                    if (z3) {
                                                    }
                                                    declaredMethods = java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(7)))).getDeclaredMethods();
                                                    length = declaredMethods.length;
                                                    i2 = 0;
                                                    while (true) {
                                                        if (i2 < length) {
                                                            method = null;
                                                            break;
                                                        }
                                                        method = declaredMethods[i2];
                                                        if (method.getName().equals("pr")) {
                                                            break;
                                                            break;
                                                        }
                                                        i2++;
                                                    }
                                                    java.util.HashMap map7 = new java.util.HashMap();
                                                    map7.put("t", java.lang.Integer.valueOf(i));
                                                    jSONObject9 = new org.json.JSONObject();
                                                    if (!z3) {
                                                        jSONObject9.put(str8, new org.json.JSONObject(map2));
                                                        if (!z5) {
                                                            jSONObject9.put(str11, jSONObject4);
                                                        }
                                                        if (!z7) {
                                                            jSONObject9.put(str12, jSONObject5);
                                                        }
                                                        if (!z10) {
                                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                                        }
                                                        if (!z9) {
                                                            jSONObject9.put(str14, jSONObject7);
                                                        }
                                                        if (jSONObject3.length() > 0) {
                                                            jSONObject9.put(str10, jSONObject3);
                                                        }
                                                        if (jSONObject8.length() > 0) {
                                                            jSONObject9.put(str9, jSONObject8);
                                                        }
                                                        if (this.c.length() > 0) {
                                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                                        }
                                                        if (this.d.length() > 0) {
                                                            jSONObject9.put("10025", this.d);
                                                        }
                                                        if (this.e.length() > 0) {
                                                            jSONObject9.put("10033", this.e);
                                                        }
                                                        if (this.f.length() > 0) {
                                                            jSONObject9.put("10031", this.f);
                                                        }
                                                        if (this.g.length() > 0) {
                                                            jSONObject9.put("10026", this.g);
                                                        }
                                                        if (this.h.length() > 0) {
                                                            jSONObject9.put("10034", this.h);
                                                        }
                                                    } else {
                                                        if (!z5) {
                                                            jSONObject9.put(str11, jSONObject4);
                                                        }
                                                        if (!z7) {
                                                            jSONObject9.put(str12, jSONObject5);
                                                        }
                                                        if (!z10) {
                                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                                        }
                                                        if (!z9) {
                                                            jSONObject9.put(str14, jSONObject7);
                                                        }
                                                        if (jSONObject3.length() > 0) {
                                                            jSONObject9.put(str10, jSONObject3);
                                                        }
                                                        if (jSONObject8.length() > 0) {
                                                            jSONObject9.put(str9, jSONObject8);
                                                        }
                                                        if (this.c.length() > 0) {
                                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                                        }
                                                        if (this.d.length() > 0) {
                                                            jSONObject9.put("10025", this.d);
                                                        }
                                                        if (this.e.length() > 0) {
                                                            jSONObject9.put("10033", this.e);
                                                        }
                                                        if (this.f.length() > 0) {
                                                            jSONObject9.put("10031", this.f);
                                                        }
                                                        if (this.g.length() > 0) {
                                                            jSONObject9.put("10026", this.g);
                                                        }
                                                        if (this.h.length() > 0) {
                                                            jSONObject9.put("10034", this.h);
                                                        }
                                                    }
                                                    map7.put("rad", jSONObject9.toString());
                                                    method.setAccessible(true);
                                                    method.invoke(null, this.a, map7);
                                                    this.b = true;
                                                    return;
                                                }
                                                str14 = str13;
                                                z10 = true;
                                                if (z3) {
                                                }
                                                declaredMethods = java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(7)))).getDeclaredMethods();
                                                length = declaredMethods.length;
                                                i2 = 0;
                                                java.util.HashMap map8 = new java.util.HashMap();
                                                map8.put("t", java.lang.Integer.valueOf(i));
                                                jSONObject9 = new org.json.JSONObject();
                                                if (!z3) {
                                                    jSONObject9.put(str8, new org.json.JSONObject(map2));
                                                    if (!z5) {
                                                        jSONObject9.put(str11, jSONObject4);
                                                    }
                                                    if (!z7) {
                                                        jSONObject9.put(str12, jSONObject5);
                                                    }
                                                    if (!z10) {
                                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                                    }
                                                    if (!z9) {
                                                        jSONObject9.put(str14, jSONObject7);
                                                    }
                                                    if (jSONObject3.length() > 0) {
                                                        jSONObject9.put(str10, jSONObject3);
                                                    }
                                                    if (jSONObject8.length() > 0) {
                                                        jSONObject9.put(str9, jSONObject8);
                                                    }
                                                    if (this.c.length() > 0) {
                                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                                    }
                                                    if (this.d.length() > 0) {
                                                        jSONObject9.put("10025", this.d);
                                                    }
                                                    if (this.e.length() > 0) {
                                                        jSONObject9.put("10033", this.e);
                                                    }
                                                    if (this.f.length() > 0) {
                                                        jSONObject9.put("10031", this.f);
                                                    }
                                                    if (this.g.length() > 0) {
                                                        jSONObject9.put("10026", this.g);
                                                    }
                                                    if (this.h.length() > 0) {
                                                        jSONObject9.put("10034", this.h);
                                                    }
                                                } else {
                                                    if (!z5) {
                                                        jSONObject9.put(str11, jSONObject4);
                                                    }
                                                    if (!z7) {
                                                        jSONObject9.put(str12, jSONObject5);
                                                    }
                                                    if (!z10) {
                                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                                    }
                                                    if (!z9) {
                                                        jSONObject9.put(str14, jSONObject7);
                                                    }
                                                    if (jSONObject3.length() > 0) {
                                                        jSONObject9.put(str10, jSONObject3);
                                                    }
                                                    if (jSONObject8.length() > 0) {
                                                        jSONObject9.put(str9, jSONObject8);
                                                    }
                                                    if (this.c.length() > 0) {
                                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                                    }
                                                    if (this.d.length() > 0) {
                                                        jSONObject9.put("10025", this.d);
                                                    }
                                                    if (this.e.length() > 0) {
                                                        jSONObject9.put("10033", this.e);
                                                    }
                                                    if (this.f.length() > 0) {
                                                        jSONObject9.put("10031", this.f);
                                                    }
                                                    if (this.g.length() > 0) {
                                                        jSONObject9.put("10026", this.g);
                                                    }
                                                    if (this.h.length() > 0) {
                                                        jSONObject9.put("10034", this.h);
                                                    }
                                                }
                                                map8.put("rad", jSONObject9.toString());
                                                method.setAccessible(true);
                                                method.invoke(null, this.a, map8);
                                                this.b = true;
                                                return;
                                            }
                                            jSONObject8 = jSONObject2;
                                        } catch (java.lang.Exception unused17) {
                                        }
                                    }
                                    z2 = true;
                                    if (android.text.TextUtils.isEmpty(str5)) {
                                        str15 = str6;
                                        if (str5.equals(str15)) {
                                            z3 = z2;
                                            str11 = io.dcloud.sdk.core.util.Const.TYPE_GDT;
                                            jSONArrayA3 = a(str11);
                                            if (a(str5, jSONArrayA3)) {
                                                str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                                a(6);
                                                jSONObject4.put("r", "1");
                                                jSONObject4.put(strB, str5);
                                                jSONObject4.put(strB2, java.lang.String.valueOf(str15));
                                                jSONObject4.put(strB3, jSONArrayA3);
                                                z4 = false;
                                            } else {
                                                str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                            }
                                        } else {
                                            z3 = z2;
                                            str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                            str11 = io.dcloud.sdk.core.util.Const.TYPE_GDT;
                                        }
                                        z4 = true;
                                    } else {
                                        z3 = z2;
                                        str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                        str11 = io.dcloud.sdk.core.util.Const.TYPE_GDT;
                                        z4 = true;
                                    }
                                    if (android.text.TextUtils.isEmpty(str4)) {
                                        z5 = z4;
                                        str12 = io.dcloud.sdk.core.util.Const.TYPE_KS;
                                        z6 = true;
                                    } else {
                                        z5 = z4;
                                        str12 = io.dcloud.sdk.core.util.Const.TYPE_KS;
                                        z6 = true;
                                    }
                                    if (android.text.TextUtils.isEmpty(str3)) {
                                        z7 = z6;
                                        str13 = io.dcloud.sdk.core.util.Const.TYPE_PG;
                                        z8 = true;
                                    } else {
                                        z7 = z6;
                                        str13 = io.dcloud.sdk.core.util.Const.TYPE_PG;
                                        z8 = true;
                                    }
                                    z9 = z8;
                                    strB4 = b(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"));
                                    if (!android.text.TextUtils.isEmpty(strB4)) {
                                        java.lang.Class.forName(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&EgjadmIl{"));
                                        str14 = str13;
                                        strA6 = a(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"), io.dcloud.sdk.core.util.Const.TYPE_GG);
                                        if (!strB4.equals(strA6)) {
                                            jSONArrayA2 = a(io.dcloud.sdk.core.util.Const.TYPE_GG);
                                            if (!a(strB4, jSONArrayA2)) {
                                                jSONObject6.put("r", "1");
                                                jSONObject6.put(strB, strB4);
                                                jSONObject6.put(strB2, java.lang.String.valueOf(strA6));
                                                jSONObject6.put(strB3, jSONArrayA2);
                                                z10 = false;
                                            }
                                        }
                                        if (z3) {
                                        }
                                        declaredMethods = java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(7)))).getDeclaredMethods();
                                        length = declaredMethods.length;
                                        i2 = 0;
                                        while (true) {
                                            if (i2 < length) {
                                                method = null;
                                                break;
                                            }
                                            method = declaredMethods[i2];
                                            if (method.getName().equals("pr")) {
                                                break;
                                                break;
                                            }
                                            i2++;
                                        }
                                        java.util.HashMap map9 = new java.util.HashMap();
                                        map9.put("t", java.lang.Integer.valueOf(i));
                                        jSONObject9 = new org.json.JSONObject();
                                        if (!z3) {
                                            jSONObject9.put(str8, new org.json.JSONObject(map2));
                                            if (!z5) {
                                                jSONObject9.put(str11, jSONObject4);
                                            }
                                            if (!z7) {
                                                jSONObject9.put(str12, jSONObject5);
                                            }
                                            if (!z10) {
                                                jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                            }
                                            if (!z9) {
                                                jSONObject9.put(str14, jSONObject7);
                                            }
                                            if (jSONObject3.length() > 0) {
                                                jSONObject9.put(str10, jSONObject3);
                                            }
                                            if (jSONObject8.length() > 0) {
                                                jSONObject9.put(str9, jSONObject8);
                                            }
                                            if (this.c.length() > 0) {
                                                jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                            }
                                            if (this.d.length() > 0) {
                                                jSONObject9.put("10025", this.d);
                                            }
                                            if (this.e.length() > 0) {
                                                jSONObject9.put("10033", this.e);
                                            }
                                            if (this.f.length() > 0) {
                                                jSONObject9.put("10031", this.f);
                                            }
                                            if (this.g.length() > 0) {
                                                jSONObject9.put("10026", this.g);
                                            }
                                            if (this.h.length() > 0) {
                                                jSONObject9.put("10034", this.h);
                                            }
                                        } else {
                                            if (!z5) {
                                                jSONObject9.put(str11, jSONObject4);
                                            }
                                            if (!z7) {
                                                jSONObject9.put(str12, jSONObject5);
                                            }
                                            if (!z10) {
                                                jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                            }
                                            if (!z9) {
                                                jSONObject9.put(str14, jSONObject7);
                                            }
                                            if (jSONObject3.length() > 0) {
                                                jSONObject9.put(str10, jSONObject3);
                                            }
                                            if (jSONObject8.length() > 0) {
                                                jSONObject9.put(str9, jSONObject8);
                                            }
                                            if (this.c.length() > 0) {
                                                jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                            }
                                            if (this.d.length() > 0) {
                                                jSONObject9.put("10025", this.d);
                                            }
                                            if (this.e.length() > 0) {
                                                jSONObject9.put("10033", this.e);
                                            }
                                            if (this.f.length() > 0) {
                                                jSONObject9.put("10031", this.f);
                                            }
                                            if (this.g.length() > 0) {
                                                jSONObject9.put("10026", this.g);
                                            }
                                            if (this.h.length() > 0) {
                                                jSONObject9.put("10034", this.h);
                                            }
                                        }
                                        map9.put("rad", jSONObject9.toString());
                                        method.setAccessible(true);
                                        method.invoke(null, this.a, map9);
                                        this.b = true;
                                        return;
                                    }
                                    str14 = str13;
                                    z10 = true;
                                    if (z3) {
                                    }
                                    declaredMethods = java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(7)))).getDeclaredMethods();
                                    length = declaredMethods.length;
                                    i2 = 0;
                                    while (true) {
                                        if (i2 < length) {
                                            method = null;
                                            break;
                                        }
                                        method = declaredMethods[i2];
                                        if (method.getName().equals("pr")) {
                                            break;
                                            break;
                                        }
                                        i2++;
                                    }
                                    java.util.HashMap map10 = new java.util.HashMap();
                                    map10.put("t", java.lang.Integer.valueOf(i));
                                    jSONObject9 = new org.json.JSONObject();
                                    if (!z3) {
                                        jSONObject9.put(str8, new org.json.JSONObject(map2));
                                        if (!z5) {
                                            jSONObject9.put(str11, jSONObject4);
                                        }
                                        if (!z7) {
                                            jSONObject9.put(str12, jSONObject5);
                                        }
                                        if (!z10) {
                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                        }
                                        if (!z9) {
                                            jSONObject9.put(str14, jSONObject7);
                                        }
                                        if (jSONObject3.length() > 0) {
                                            jSONObject9.put(str10, jSONObject3);
                                        }
                                        if (jSONObject8.length() > 0) {
                                            jSONObject9.put(str9, jSONObject8);
                                        }
                                        if (this.c.length() > 0) {
                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                        }
                                        if (this.d.length() > 0) {
                                            jSONObject9.put("10025", this.d);
                                        }
                                        if (this.e.length() > 0) {
                                            jSONObject9.put("10033", this.e);
                                        }
                                        if (this.f.length() > 0) {
                                            jSONObject9.put("10031", this.f);
                                        }
                                        if (this.g.length() > 0) {
                                            jSONObject9.put("10026", this.g);
                                        }
                                        if (this.h.length() > 0) {
                                            jSONObject9.put("10034", this.h);
                                        }
                                    } else {
                                        if (!z5) {
                                            jSONObject9.put(str11, jSONObject4);
                                        }
                                        if (!z7) {
                                            jSONObject9.put(str12, jSONObject5);
                                        }
                                        if (!z10) {
                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                        }
                                        if (!z9) {
                                            jSONObject9.put(str14, jSONObject7);
                                        }
                                        if (jSONObject3.length() > 0) {
                                            jSONObject9.put(str10, jSONObject3);
                                        }
                                        if (jSONObject8.length() > 0) {
                                            jSONObject9.put(str9, jSONObject8);
                                        }
                                        if (this.c.length() > 0) {
                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                        }
                                        if (this.d.length() > 0) {
                                            jSONObject9.put("10025", this.d);
                                        }
                                        if (this.e.length() > 0) {
                                            jSONObject9.put("10033", this.e);
                                        }
                                        if (this.f.length() > 0) {
                                            jSONObject9.put("10031", this.f);
                                        }
                                        if (this.g.length() > 0) {
                                            jSONObject9.put("10026", this.g);
                                        }
                                        if (this.h.length() > 0) {
                                            jSONObject9.put("10034", this.h);
                                        }
                                    }
                                    map10.put("rad", jSONObject9.toString());
                                    method.setAccessible(true);
                                    method.invoke(null, this.a, map10);
                                    this.b = true;
                                    return;
                                }
                                str6 = strA2;
                                strK = k();
                                map = mapD;
                                java.lang.String strA7 = a("UNIAD_SGM_APPID", io.dcloud.sdk.core.util.Const.TYPE_SGM);
                                if (strK != null || strK.equals(strA7)) {
                                    str7 = io.dcloud.sdk.core.util.Const.TYPE_CSJ;
                                } else {
                                    str7 = io.dcloud.sdk.core.util.Const.TYPE_CSJ;
                                    org.json.JSONArray jSONArrayA7 = a(io.dcloud.sdk.core.util.Const.TYPE_SGM);
                                    if (!a(strK, jSONArrayA7)) {
                                        try {
                                            jSONObject.put("r", "1");
                                            jSONObject.put(strB, strK);
                                            jSONObject.put(strB2, strA7);
                                            jSONObject.put(strB3, jSONArrayA7);
                                        } catch (java.lang.Exception unused18) {
                                        }
                                    }
                                }
                                if (listN.size() != 0) {
                                    strE = e();
                                    strA5 = a("", "10028");
                                    if (strE == null) {
                                        jSONObject3 = jSONObject;
                                    } else {
                                        if (strA5 == null) {
                                            jSONObject2.put("r", "1");
                                            jSONObject2.put(strB, strE);
                                        } else if (!strE.equals(strA5)) {
                                            jSONObject3 = jSONObject;
                                            jSONArrayA = a("10028");
                                            if (!a(strE, jSONArrayA)) {
                                                jSONObject2.put("r", "1");
                                                jSONObject2.put(strB, strE);
                                                jSONObject2.put(strB2, strA5);
                                                jSONObject2.put(strB3, jSONArrayA);
                                            }
                                        }
                                        jSONObject3 = jSONObject;
                                    }
                                } else {
                                    strE = e();
                                    strA5 = a("", "10028");
                                    if (strE == null) {
                                        jSONObject3 = jSONObject;
                                    } else {
                                        if (strA5 == null) {
                                            jSONObject2.put("r", "1");
                                            jSONObject2.put(strB, strE);
                                        } else if (!strE.equals(strA5)) {
                                            jSONObject3 = jSONObject;
                                            jSONArrayA = a("10028");
                                            if (!a(strE, jSONArrayA)) {
                                                jSONObject2.put("r", "1");
                                                jSONObject2.put(strB, strE);
                                                jSONObject2.put(strB2, strA5);
                                                jSONObject2.put(strB3, jSONArrayA);
                                            }
                                        }
                                        jSONObject3 = jSONObject;
                                    }
                                }
                                if (listN.size() != 0) {
                                    c();
                                } else {
                                    c();
                                }
                                if (listN.size() != 0) {
                                    h();
                                } else {
                                    h();
                                }
                                if (listN.size() != 0) {
                                    g();
                                } else {
                                    g();
                                }
                                if (listN.size() != 0) {
                                    m();
                                } else {
                                    m();
                                }
                                if (listN.size() != 0) {
                                    b();
                                } else {
                                    b();
                                }
                                if (listN.size() != 0) {
                                    l();
                                } else {
                                    l();
                                }
                                jSONObject4 = new org.json.JSONObject();
                                jSONObject5 = new org.json.JSONObject();
                                jSONObject6 = new org.json.JSONObject();
                                jSONObject7 = new org.json.JSONObject();
                                map2 = new java.util.HashMap();
                                if (android.text.TextUtils.isEmpty(str)) {
                                    jSONObject8 = jSONObject2;
                                    str8 = str7;
                                    str9 = "10028";
                                    z2 = true;
                                } else {
                                    jSONObject8 = jSONObject2;
                                    str8 = str7;
                                    str9 = "10028";
                                    z2 = true;
                                }
                                if (android.text.TextUtils.isEmpty(str5)) {
                                    str15 = str6;
                                    if (str5.equals(str15)) {
                                        z3 = z2;
                                        str11 = io.dcloud.sdk.core.util.Const.TYPE_GDT;
                                        jSONArrayA3 = a(str11);
                                        if (a(str5, jSONArrayA3)) {
                                            str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                            a(6);
                                            jSONObject4.put("r", "1");
                                            jSONObject4.put(strB, str5);
                                            jSONObject4.put(strB2, java.lang.String.valueOf(str15));
                                            jSONObject4.put(strB3, jSONArrayA3);
                                            z4 = false;
                                        } else {
                                            str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                        }
                                    } else {
                                        z3 = z2;
                                        str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                        str11 = io.dcloud.sdk.core.util.Const.TYPE_GDT;
                                    }
                                    z4 = true;
                                } else {
                                    z3 = z2;
                                    str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                    str11 = io.dcloud.sdk.core.util.Const.TYPE_GDT;
                                    z4 = true;
                                }
                                if (android.text.TextUtils.isEmpty(str4)) {
                                    z5 = z4;
                                    str12 = io.dcloud.sdk.core.util.Const.TYPE_KS;
                                    z6 = true;
                                } else {
                                    z5 = z4;
                                    str12 = io.dcloud.sdk.core.util.Const.TYPE_KS;
                                    z6 = true;
                                }
                                if (android.text.TextUtils.isEmpty(str3)) {
                                    z7 = z6;
                                    str13 = io.dcloud.sdk.core.util.Const.TYPE_PG;
                                    z8 = true;
                                } else {
                                    z7 = z6;
                                    str13 = io.dcloud.sdk.core.util.Const.TYPE_PG;
                                    z8 = true;
                                }
                                z9 = z8;
                                strB4 = b(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"));
                                if (!android.text.TextUtils.isEmpty(strB4)) {
                                    java.lang.Class.forName(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&EgjadmIl{"));
                                    str14 = str13;
                                    strA6 = a(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"), io.dcloud.sdk.core.util.Const.TYPE_GG);
                                    if (!strB4.equals(strA6)) {
                                        jSONArrayA2 = a(io.dcloud.sdk.core.util.Const.TYPE_GG);
                                        if (!a(strB4, jSONArrayA2)) {
                                            jSONObject6.put("r", "1");
                                            jSONObject6.put(strB, strB4);
                                            jSONObject6.put(strB2, java.lang.String.valueOf(strA6));
                                            jSONObject6.put(strB3, jSONArrayA2);
                                            z10 = false;
                                        }
                                    }
                                    if (z3) {
                                    }
                                    declaredMethods = java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(7)))).getDeclaredMethods();
                                    length = declaredMethods.length;
                                    i2 = 0;
                                    while (true) {
                                        if (i2 < length) {
                                            method = null;
                                            break;
                                        }
                                        method = declaredMethods[i2];
                                        if (method.getName().equals("pr")) {
                                            break;
                                            break;
                                        }
                                        i2++;
                                    }
                                    java.util.HashMap map11 = new java.util.HashMap();
                                    map11.put("t", java.lang.Integer.valueOf(i));
                                    jSONObject9 = new org.json.JSONObject();
                                    if (!z3) {
                                        jSONObject9.put(str8, new org.json.JSONObject(map2));
                                        if (!z5) {
                                            jSONObject9.put(str11, jSONObject4);
                                        }
                                        if (!z7) {
                                            jSONObject9.put(str12, jSONObject5);
                                        }
                                        if (!z10) {
                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                        }
                                        if (!z9) {
                                            jSONObject9.put(str14, jSONObject7);
                                        }
                                        if (jSONObject3.length() > 0) {
                                            jSONObject9.put(str10, jSONObject3);
                                        }
                                        if (jSONObject8.length() > 0) {
                                            jSONObject9.put(str9, jSONObject8);
                                        }
                                        if (this.c.length() > 0) {
                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                        }
                                        if (this.d.length() > 0) {
                                            jSONObject9.put("10025", this.d);
                                        }
                                        if (this.e.length() > 0) {
                                            jSONObject9.put("10033", this.e);
                                        }
                                        if (this.f.length() > 0) {
                                            jSONObject9.put("10031", this.f);
                                        }
                                        if (this.g.length() > 0) {
                                            jSONObject9.put("10026", this.g);
                                        }
                                        if (this.h.length() > 0) {
                                            jSONObject9.put("10034", this.h);
                                        }
                                    } else {
                                        if (!z5) {
                                            jSONObject9.put(str11, jSONObject4);
                                        }
                                        if (!z7) {
                                            jSONObject9.put(str12, jSONObject5);
                                        }
                                        if (!z10) {
                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                        }
                                        if (!z9) {
                                            jSONObject9.put(str14, jSONObject7);
                                        }
                                        if (jSONObject3.length() > 0) {
                                            jSONObject9.put(str10, jSONObject3);
                                        }
                                        if (jSONObject8.length() > 0) {
                                            jSONObject9.put(str9, jSONObject8);
                                        }
                                        if (this.c.length() > 0) {
                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                        }
                                        if (this.d.length() > 0) {
                                            jSONObject9.put("10025", this.d);
                                        }
                                        if (this.e.length() > 0) {
                                            jSONObject9.put("10033", this.e);
                                        }
                                        if (this.f.length() > 0) {
                                            jSONObject9.put("10031", this.f);
                                        }
                                        if (this.g.length() > 0) {
                                            jSONObject9.put("10026", this.g);
                                        }
                                        if (this.h.length() > 0) {
                                            jSONObject9.put("10034", this.h);
                                        }
                                    }
                                    map11.put("rad", jSONObject9.toString());
                                    method.setAccessible(true);
                                    method.invoke(null, this.a, map11);
                                    this.b = true;
                                    return;
                                }
                                str14 = str13;
                                z10 = true;
                                if (z3) {
                                }
                                declaredMethods = java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(7)))).getDeclaredMethods();
                                length = declaredMethods.length;
                                i2 = 0;
                                while (true) {
                                    if (i2 < length) {
                                        method = null;
                                        break;
                                    }
                                    method = declaredMethods[i2];
                                    if (method.getName().equals("pr")) {
                                        break;
                                        break;
                                    }
                                    i2++;
                                }
                                java.util.HashMap map12 = new java.util.HashMap();
                                map12.put("t", java.lang.Integer.valueOf(i));
                                jSONObject9 = new org.json.JSONObject();
                                if (!z3) {
                                    jSONObject9.put(str8, new org.json.JSONObject(map2));
                                    if (!z5) {
                                        jSONObject9.put(str11, jSONObject4);
                                    }
                                    if (!z7) {
                                        jSONObject9.put(str12, jSONObject5);
                                    }
                                    if (!z10) {
                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                    }
                                    if (!z9) {
                                        jSONObject9.put(str14, jSONObject7);
                                    }
                                    if (jSONObject3.length() > 0) {
                                        jSONObject9.put(str10, jSONObject3);
                                    }
                                    if (jSONObject8.length() > 0) {
                                        jSONObject9.put(str9, jSONObject8);
                                    }
                                    if (this.c.length() > 0) {
                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                    }
                                    if (this.d.length() > 0) {
                                        jSONObject9.put("10025", this.d);
                                    }
                                    if (this.e.length() > 0) {
                                        jSONObject9.put("10033", this.e);
                                    }
                                    if (this.f.length() > 0) {
                                        jSONObject9.put("10031", this.f);
                                    }
                                    if (this.g.length() > 0) {
                                        jSONObject9.put("10026", this.g);
                                    }
                                    if (this.h.length() > 0) {
                                        jSONObject9.put("10034", this.h);
                                    }
                                } else {
                                    if (!z5) {
                                        jSONObject9.put(str11, jSONObject4);
                                    }
                                    if (!z7) {
                                        jSONObject9.put(str12, jSONObject5);
                                    }
                                    if (!z10) {
                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                    }
                                    if (!z9) {
                                        jSONObject9.put(str14, jSONObject7);
                                    }
                                    if (jSONObject3.length() > 0) {
                                        jSONObject9.put(str10, jSONObject3);
                                    }
                                    if (jSONObject8.length() > 0) {
                                        jSONObject9.put(str9, jSONObject8);
                                    }
                                    if (this.c.length() > 0) {
                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                    }
                                    if (this.d.length() > 0) {
                                        jSONObject9.put("10025", this.d);
                                    }
                                    if (this.e.length() > 0) {
                                        jSONObject9.put("10033", this.e);
                                    }
                                    if (this.f.length() > 0) {
                                        jSONObject9.put("10031", this.f);
                                    }
                                    if (this.g.length() > 0) {
                                        jSONObject9.put("10026", this.g);
                                    }
                                    if (this.h.length() > 0) {
                                        jSONObject9.put("10034", this.h);
                                    }
                                }
                                map12.put("rad", jSONObject9.toString());
                                method.setAccessible(true);
                                method.invoke(null, this.a, map12);
                                this.b = true;
                                return;
                            }
                            i = 1;
                            if (listN.size() != 0) {
                                str6 = strA2;
                                if (listN.contains(io.dcloud.p.e1.b((java.lang.String) listA.get(3)))) {
                                    map = mapD;
                                }
                                str7 = io.dcloud.sdk.core.util.Const.TYPE_CSJ;
                                if (listN.size() != 0) {
                                    strE = e();
                                    strA5 = a("", "10028");
                                    if (strE == null) {
                                        jSONObject3 = jSONObject;
                                    } else {
                                        if (strA5 == null) {
                                            jSONObject2.put("r", "1");
                                            jSONObject2.put(strB, strE);
                                        } else if (!strE.equals(strA5)) {
                                            jSONObject3 = jSONObject;
                                            jSONArrayA = a("10028");
                                            if (!a(strE, jSONArrayA)) {
                                                jSONObject2.put("r", "1");
                                                jSONObject2.put(strB, strE);
                                                jSONObject2.put(strB2, strA5);
                                                jSONObject2.put(strB3, jSONArrayA);
                                            }
                                        }
                                        jSONObject3 = jSONObject;
                                    }
                                } else {
                                    strE = e();
                                    strA5 = a("", "10028");
                                    if (strE == null) {
                                        jSONObject3 = jSONObject;
                                    } else {
                                        if (strA5 == null) {
                                            jSONObject2.put("r", "1");
                                            jSONObject2.put(strB, strE);
                                        } else if (!strE.equals(strA5)) {
                                            jSONObject3 = jSONObject;
                                            jSONArrayA = a("10028");
                                            if (!a(strE, jSONArrayA)) {
                                                jSONObject2.put("r", "1");
                                                jSONObject2.put(strB, strE);
                                                jSONObject2.put(strB2, strA5);
                                                jSONObject2.put(strB3, jSONArrayA);
                                            }
                                        }
                                        jSONObject3 = jSONObject;
                                    }
                                }
                                if (listN.size() != 0) {
                                    c();
                                } else {
                                    c();
                                }
                                if (listN.size() != 0) {
                                    h();
                                } else {
                                    h();
                                }
                                if (listN.size() != 0) {
                                    g();
                                } else {
                                    g();
                                }
                                if (listN.size() != 0) {
                                    m();
                                } else {
                                    m();
                                }
                                if (listN.size() != 0) {
                                    b();
                                } else {
                                    b();
                                }
                                if (listN.size() != 0) {
                                    l();
                                } else {
                                    l();
                                }
                                jSONObject4 = new org.json.JSONObject();
                                jSONObject5 = new org.json.JSONObject();
                                jSONObject6 = new org.json.JSONObject();
                                jSONObject7 = new org.json.JSONObject();
                                map2 = new java.util.HashMap();
                                if (android.text.TextUtils.isEmpty(str)) {
                                    jSONObject8 = jSONObject2;
                                    str8 = str7;
                                    str9 = "10028";
                                    z2 = true;
                                } else {
                                    jSONObject8 = jSONObject2;
                                    str8 = str7;
                                    str9 = "10028";
                                    z2 = true;
                                }
                                if (android.text.TextUtils.isEmpty(str5)) {
                                    str15 = str6;
                                    if (str5.equals(str15)) {
                                        z3 = z2;
                                        str11 = io.dcloud.sdk.core.util.Const.TYPE_GDT;
                                        jSONArrayA3 = a(str11);
                                        if (a(str5, jSONArrayA3)) {
                                            str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                            a(6);
                                            jSONObject4.put("r", "1");
                                            jSONObject4.put(strB, str5);
                                            jSONObject4.put(strB2, java.lang.String.valueOf(str15));
                                            jSONObject4.put(strB3, jSONArrayA3);
                                            z4 = false;
                                        } else {
                                            str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                        }
                                    } else {
                                        z3 = z2;
                                        str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                        str11 = io.dcloud.sdk.core.util.Const.TYPE_GDT;
                                    }
                                    z4 = true;
                                } else {
                                    z3 = z2;
                                    str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                    str11 = io.dcloud.sdk.core.util.Const.TYPE_GDT;
                                    z4 = true;
                                }
                                if (android.text.TextUtils.isEmpty(str4)) {
                                    z5 = z4;
                                    str12 = io.dcloud.sdk.core.util.Const.TYPE_KS;
                                    z6 = true;
                                } else {
                                    z5 = z4;
                                    str12 = io.dcloud.sdk.core.util.Const.TYPE_KS;
                                    z6 = true;
                                }
                                if (android.text.TextUtils.isEmpty(str3)) {
                                    z7 = z6;
                                    str13 = io.dcloud.sdk.core.util.Const.TYPE_PG;
                                    z8 = true;
                                } else {
                                    z7 = z6;
                                    str13 = io.dcloud.sdk.core.util.Const.TYPE_PG;
                                    z8 = true;
                                }
                                z9 = z8;
                                strB4 = b(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"));
                                if (!android.text.TextUtils.isEmpty(strB4)) {
                                    java.lang.Class.forName(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&EgjadmIl{"));
                                    str14 = str13;
                                    strA6 = a(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"), io.dcloud.sdk.core.util.Const.TYPE_GG);
                                    if (!strB4.equals(strA6)) {
                                        jSONArrayA2 = a(io.dcloud.sdk.core.util.Const.TYPE_GG);
                                        if (!a(strB4, jSONArrayA2)) {
                                            jSONObject6.put("r", "1");
                                            jSONObject6.put(strB, strB4);
                                            jSONObject6.put(strB2, java.lang.String.valueOf(strA6));
                                            jSONObject6.put(strB3, jSONArrayA2);
                                            z10 = false;
                                        }
                                    }
                                    if (z3) {
                                    }
                                    declaredMethods = java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(7)))).getDeclaredMethods();
                                    length = declaredMethods.length;
                                    i2 = 0;
                                    while (true) {
                                        if (i2 < length) {
                                            method = null;
                                            break;
                                        }
                                        method = declaredMethods[i2];
                                        if (method.getName().equals("pr")) {
                                            break;
                                            break;
                                        }
                                        i2++;
                                    }
                                    java.util.HashMap map13 = new java.util.HashMap();
                                    map13.put("t", java.lang.Integer.valueOf(i));
                                    jSONObject9 = new org.json.JSONObject();
                                    if (!z3) {
                                        jSONObject9.put(str8, new org.json.JSONObject(map2));
                                        if (!z5) {
                                            jSONObject9.put(str11, jSONObject4);
                                        }
                                        if (!z7) {
                                            jSONObject9.put(str12, jSONObject5);
                                        }
                                        if (!z10) {
                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                        }
                                        if (!z9) {
                                            jSONObject9.put(str14, jSONObject7);
                                        }
                                        if (jSONObject3.length() > 0) {
                                            jSONObject9.put(str10, jSONObject3);
                                        }
                                        if (jSONObject8.length() > 0) {
                                            jSONObject9.put(str9, jSONObject8);
                                        }
                                        if (this.c.length() > 0) {
                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                        }
                                        if (this.d.length() > 0) {
                                            jSONObject9.put("10025", this.d);
                                        }
                                        if (this.e.length() > 0) {
                                            jSONObject9.put("10033", this.e);
                                        }
                                        if (this.f.length() > 0) {
                                            jSONObject9.put("10031", this.f);
                                        }
                                        if (this.g.length() > 0) {
                                            jSONObject9.put("10026", this.g);
                                        }
                                        if (this.h.length() > 0) {
                                            jSONObject9.put("10034", this.h);
                                        }
                                    } else {
                                        if (!z5) {
                                            jSONObject9.put(str11, jSONObject4);
                                        }
                                        if (!z7) {
                                            jSONObject9.put(str12, jSONObject5);
                                        }
                                        if (!z10) {
                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                        }
                                        if (!z9) {
                                            jSONObject9.put(str14, jSONObject7);
                                        }
                                        if (jSONObject3.length() > 0) {
                                            jSONObject9.put(str10, jSONObject3);
                                        }
                                        if (jSONObject8.length() > 0) {
                                            jSONObject9.put(str9, jSONObject8);
                                        }
                                        if (this.c.length() > 0) {
                                            jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                        }
                                        if (this.d.length() > 0) {
                                            jSONObject9.put("10025", this.d);
                                        }
                                        if (this.e.length() > 0) {
                                            jSONObject9.put("10033", this.e);
                                        }
                                        if (this.f.length() > 0) {
                                            jSONObject9.put("10031", this.f);
                                        }
                                        if (this.g.length() > 0) {
                                            jSONObject9.put("10026", this.g);
                                        }
                                        if (this.h.length() > 0) {
                                            jSONObject9.put("10034", this.h);
                                        }
                                    }
                                    map13.put("rad", jSONObject9.toString());
                                    method.setAccessible(true);
                                    method.invoke(null, this.a, map13);
                                    this.b = true;
                                    return;
                                }
                                str14 = str13;
                                z10 = true;
                                if (z3) {
                                }
                                declaredMethods = java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(7)))).getDeclaredMethods();
                                length = declaredMethods.length;
                                i2 = 0;
                                while (true) {
                                    if (i2 < length) {
                                        method = null;
                                        break;
                                    }
                                    method = declaredMethods[i2];
                                    if (method.getName().equals("pr")) {
                                        break;
                                        break;
                                    }
                                    i2++;
                                }
                                java.util.HashMap map14 = new java.util.HashMap();
                                map14.put("t", java.lang.Integer.valueOf(i));
                                jSONObject9 = new org.json.JSONObject();
                                if (!z3) {
                                    jSONObject9.put(str8, new org.json.JSONObject(map2));
                                    if (!z5) {
                                        jSONObject9.put(str11, jSONObject4);
                                    }
                                    if (!z7) {
                                        jSONObject9.put(str12, jSONObject5);
                                    }
                                    if (!z10) {
                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                    }
                                    if (!z9) {
                                        jSONObject9.put(str14, jSONObject7);
                                    }
                                    if (jSONObject3.length() > 0) {
                                        jSONObject9.put(str10, jSONObject3);
                                    }
                                    if (jSONObject8.length() > 0) {
                                        jSONObject9.put(str9, jSONObject8);
                                    }
                                    if (this.c.length() > 0) {
                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                    }
                                    if (this.d.length() > 0) {
                                        jSONObject9.put("10025", this.d);
                                    }
                                    if (this.e.length() > 0) {
                                        jSONObject9.put("10033", this.e);
                                    }
                                    if (this.f.length() > 0) {
                                        jSONObject9.put("10031", this.f);
                                    }
                                    if (this.g.length() > 0) {
                                        jSONObject9.put("10026", this.g);
                                    }
                                    if (this.h.length() > 0) {
                                        jSONObject9.put("10034", this.h);
                                    }
                                } else {
                                    if (!z5) {
                                        jSONObject9.put(str11, jSONObject4);
                                    }
                                    if (!z7) {
                                        jSONObject9.put(str12, jSONObject5);
                                    }
                                    if (!z10) {
                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                    }
                                    if (!z9) {
                                        jSONObject9.put(str14, jSONObject7);
                                    }
                                    if (jSONObject3.length() > 0) {
                                        jSONObject9.put(str10, jSONObject3);
                                    }
                                    if (jSONObject8.length() > 0) {
                                        jSONObject9.put(str9, jSONObject8);
                                    }
                                    if (this.c.length() > 0) {
                                        jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                    }
                                    if (this.d.length() > 0) {
                                        jSONObject9.put("10025", this.d);
                                    }
                                    if (this.e.length() > 0) {
                                        jSONObject9.put("10033", this.e);
                                    }
                                    if (this.f.length() > 0) {
                                        jSONObject9.put("10031", this.f);
                                    }
                                    if (this.g.length() > 0) {
                                        jSONObject9.put("10026", this.g);
                                    }
                                    if (this.h.length() > 0) {
                                        jSONObject9.put("10034", this.h);
                                    }
                                }
                                map14.put("rad", jSONObject9.toString());
                                method.setAccessible(true);
                                method.invoke(null, this.a, map14);
                                this.b = true;
                                return;
                            }
                            str6 = strA2;
                            if (android.text.TextUtils.isEmpty(str)) {
                                jSONObject8 = jSONObject2;
                                str8 = str7;
                                str9 = "10028";
                                z2 = true;
                            } else {
                                jSONObject8 = jSONObject2;
                                str8 = str7;
                                str9 = "10028";
                                z2 = true;
                            }
                            while (true) {
                                if (i2 < length) {
                                    method = null;
                                    break;
                                }
                                method = declaredMethods[i2];
                                if (method.getName().equals("pr")) {
                                    break;
                                    break;
                                }
                                i2++;
                            }
                        } catch (java.lang.Exception unused19) {
                        }
                        if (!android.text.TextUtils.isEmpty(strB4)) {
                            java.lang.Class.forName(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&EgjadmIl{"));
                            str14 = str13;
                            strA6 = a(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"), io.dcloud.sdk.core.util.Const.TYPE_GG);
                            if (!strB4.equals(strA6)) {
                                jSONArrayA2 = a(io.dcloud.sdk.core.util.Const.TYPE_GG);
                                if (!a(strB4, jSONArrayA2)) {
                                    jSONObject6.put("r", "1");
                                    jSONObject6.put(strB, strB4);
                                    jSONObject6.put(strB2, java.lang.String.valueOf(strA6));
                                    jSONObject6.put(strB3, jSONArrayA2);
                                    z10 = false;
                                }
                            }
                            if (z3) {
                            }
                            declaredMethods = java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(7)))).getDeclaredMethods();
                            length = declaredMethods.length;
                            i2 = 0;
                            while (true) {
                                if (i2 < length) {
                                    method = null;
                                    break;
                                }
                                method = declaredMethods[i2];
                                if (method.getName().equals("pr")) {
                                    break;
                                    break;
                                }
                                i2++;
                            }
                            java.util.HashMap map15 = new java.util.HashMap();
                            map15.put("t", java.lang.Integer.valueOf(i));
                            jSONObject9 = new org.json.JSONObject();
                            if (!z3) {
                                jSONObject9.put(str8, new org.json.JSONObject(map2));
                                if (!z5) {
                                    jSONObject9.put(str11, jSONObject4);
                                }
                                if (!z7) {
                                    jSONObject9.put(str12, jSONObject5);
                                }
                                if (!z10) {
                                    jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                }
                                if (!z9) {
                                    jSONObject9.put(str14, jSONObject7);
                                }
                                if (jSONObject3.length() > 0) {
                                    jSONObject9.put(str10, jSONObject3);
                                }
                                if (jSONObject8.length() > 0) {
                                    jSONObject9.put(str9, jSONObject8);
                                }
                                if (this.c.length() > 0) {
                                    jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                }
                                if (this.d.length() > 0) {
                                    jSONObject9.put("10025", this.d);
                                }
                                if (this.e.length() > 0) {
                                    jSONObject9.put("10033", this.e);
                                }
                                if (this.f.length() > 0) {
                                    jSONObject9.put("10031", this.f);
                                }
                                if (this.g.length() > 0) {
                                    jSONObject9.put("10026", this.g);
                                }
                                if (this.h.length() > 0) {
                                    jSONObject9.put("10034", this.h);
                                }
                            } else {
                                if (!z5) {
                                    jSONObject9.put(str11, jSONObject4);
                                }
                                if (!z7) {
                                    jSONObject9.put(str12, jSONObject5);
                                }
                                if (!z10) {
                                    jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                                }
                                if (!z9) {
                                    jSONObject9.put(str14, jSONObject7);
                                }
                                if (jSONObject3.length() > 0) {
                                    jSONObject9.put(str10, jSONObject3);
                                }
                                if (jSONObject8.length() > 0) {
                                    jSONObject9.put(str9, jSONObject8);
                                }
                                if (this.c.length() > 0) {
                                    jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                                }
                                if (this.d.length() > 0) {
                                    jSONObject9.put("10025", this.d);
                                }
                                if (this.e.length() > 0) {
                                    jSONObject9.put("10033", this.e);
                                }
                                if (this.f.length() > 0) {
                                    jSONObject9.put("10031", this.f);
                                }
                                if (this.g.length() > 0) {
                                    jSONObject9.put("10026", this.g);
                                }
                                if (this.h.length() > 0) {
                                    jSONObject9.put("10034", this.h);
                                }
                            }
                            map15.put("rad", jSONObject9.toString());
                            method.setAccessible(true);
                            method.invoke(null, this.a, map15);
                            this.b = true;
                            return;
                        }
                        str14 = str13;
                        declaredMethods = java.lang.Class.forName(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(7)))).getDeclaredMethods();
                        length = declaredMethods.length;
                        i2 = 0;
                        java.util.HashMap map16 = new java.util.HashMap();
                        map16.put("t", java.lang.Integer.valueOf(i));
                        jSONObject9 = new org.json.JSONObject();
                        if (!z3) {
                            jSONObject9.put(str8, new org.json.JSONObject(map2));
                            if (!z5) {
                                jSONObject9.put(str11, jSONObject4);
                            }
                            if (!z7) {
                                jSONObject9.put(str12, jSONObject5);
                            }
                            if (!z10) {
                                jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                            }
                            if (!z9) {
                                jSONObject9.put(str14, jSONObject7);
                            }
                            if (jSONObject3.length() > 0) {
                                jSONObject9.put(str10, jSONObject3);
                            }
                            if (jSONObject8.length() > 0) {
                                jSONObject9.put(str9, jSONObject8);
                            }
                            if (this.c.length() > 0) {
                                jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                            }
                            if (this.d.length() > 0) {
                                jSONObject9.put("10025", this.d);
                            }
                            if (this.e.length() > 0) {
                                jSONObject9.put("10033", this.e);
                            }
                            if (this.f.length() > 0) {
                                jSONObject9.put("10031", this.f);
                            }
                            if (this.g.length() > 0) {
                                jSONObject9.put("10026", this.g);
                            }
                            if (this.h.length() > 0) {
                                jSONObject9.put("10034", this.h);
                            }
                        } else {
                            if (!z5) {
                                jSONObject9.put(str11, jSONObject4);
                            }
                            if (!z7) {
                                jSONObject9.put(str12, jSONObject5);
                            }
                            if (!z10) {
                                jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_GG, jSONObject6);
                            }
                            if (!z9) {
                                jSONObject9.put(str14, jSONObject7);
                            }
                            if (jSONObject3.length() > 0) {
                                jSONObject9.put(str10, jSONObject3);
                            }
                            if (jSONObject8.length() > 0) {
                                jSONObject9.put(str9, jSONObject8);
                            }
                            if (this.c.length() > 0) {
                                jSONObject9.put(io.dcloud.sdk.core.util.Const.TYPE_BD, this.c);
                            }
                            if (this.d.length() > 0) {
                                jSONObject9.put("10025", this.d);
                            }
                            if (this.e.length() > 0) {
                                jSONObject9.put("10033", this.e);
                            }
                            if (this.f.length() > 0) {
                                jSONObject9.put("10031", this.f);
                            }
                            if (this.g.length() > 0) {
                                jSONObject9.put("10026", this.g);
                            }
                            if (this.h.length() > 0) {
                                jSONObject9.put("10034", this.h);
                            }
                        }
                        map16.put("rad", jSONObject9.toString());
                        method.setAccessible(true);
                        method.invoke(null, this.a, map16);
                        this.b = true;
                        return;
                    } catch (java.lang.Exception unused20) {
                        return;
                    }
                    if (android.text.TextUtils.isEmpty(str5)) {
                        str15 = str6;
                        if (str5.equals(str15)) {
                            z3 = z2;
                            str11 = io.dcloud.sdk.core.util.Const.TYPE_GDT;
                            jSONArrayA3 = a(str11);
                            if (a(str5, jSONArrayA3)) {
                                str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                                a(6);
                                jSONObject4.put("r", "1");
                                jSONObject4.put(strB, str5);
                                jSONObject4.put(strB2, java.lang.String.valueOf(str15));
                                jSONObject4.put(strB3, jSONArrayA3);
                                z4 = false;
                            } else {
                                str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                            }
                        } else {
                            z3 = z2;
                            str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                            str11 = io.dcloud.sdk.core.util.Const.TYPE_GDT;
                        }
                        z4 = true;
                    } else {
                        z3 = z2;
                        str10 = io.dcloud.sdk.core.util.Const.TYPE_SGM;
                        str11 = io.dcloud.sdk.core.util.Const.TYPE_GDT;
                        z4 = true;
                    }
                } catch (java.lang.Exception unused21) {
                }
                if (android.text.TextUtils.isEmpty(str3)) {
                    z7 = z6;
                    str13 = io.dcloud.sdk.core.util.Const.TYPE_PG;
                    z8 = true;
                } else {
                    z7 = z6;
                    str13 = io.dcloud.sdk.core.util.Const.TYPE_PG;
                    z8 = true;
                }
            } catch (java.lang.Exception unused22) {
                z7 = z6;
                str13 = io.dcloud.sdk.core.util.Const.TYPE_PG;
            }
            if (android.text.TextUtils.isEmpty(str4)) {
                z5 = z4;
                str12 = io.dcloud.sdk.core.util.Const.TYPE_KS;
                z6 = true;
            } else {
                z5 = z4;
                str12 = io.dcloud.sdk.core.util.Const.TYPE_KS;
                z6 = true;
            }
        } catch (java.lang.Exception unused23) {
        }
        java.lang.String strJ = j();
        boolean z11 = zEquals;
        strA4 = a("UNIAD_PG_APPID", io.dcloud.sdk.core.util.Const.TYPE_PG);
        str2 = strJ;
        z = z11;
        strB = io.dcloud.p.e1.b("kWixxal");
        str3 = str2;
        strB2 = io.dcloud.p.e1.b("{Wixxal");
        java.lang.String str19 = strA4;
        strB3 = io.dcloud.p.e1.b("{WixxalW`");
        jSONObject = new org.json.JSONObject();
        java.lang.String str110 = strA3;
        jSONObject2 = new org.json.JSONObject();
        str4 = strI;
        str5 = strF;
        strK = k();
        map = mapD;
        java.lang.String strA8 = a("UNIAD_SGM_APPID", io.dcloud.sdk.core.util.Const.TYPE_SGM);
        if (strK != null) {
            str7 = io.dcloud.sdk.core.util.Const.TYPE_CSJ;
        } else {
            str7 = io.dcloud.sdk.core.util.Const.TYPE_CSJ;
        }
        if (listN.size() != 0) {
            strE = e();
            strA5 = a("", "10028");
            if (strE == null) {
                jSONObject3 = jSONObject;
            } else {
                if (strA5 == null) {
                    jSONObject2.put("r", "1");
                    jSONObject2.put(strB, strE);
                } else if (!strE.equals(strA5)) {
                    jSONObject3 = jSONObject;
                    jSONArrayA = a("10028");
                    if (!a(strE, jSONArrayA)) {
                        jSONObject2.put("r", "1");
                        jSONObject2.put(strB, strE);
                        jSONObject2.put(strB2, strA5);
                        jSONObject2.put(strB3, jSONArrayA);
                    }
                }
                jSONObject3 = jSONObject;
            }
        } else {
            strE = e();
            strA5 = a("", "10028");
            if (strE == null) {
                jSONObject3 = jSONObject;
            } else {
                if (strA5 == null) {
                    jSONObject2.put("r", "1");
                    jSONObject2.put(strB, strE);
                } else if (!strE.equals(strA5)) {
                    jSONObject3 = jSONObject;
                    jSONArrayA = a("10028");
                    if (!a(strE, jSONArrayA)) {
                        jSONObject2.put("r", "1");
                        jSONObject2.put(strB, strE);
                        jSONObject2.put(strB2, strA5);
                        jSONObject2.put(strB3, jSONArrayA);
                    }
                }
                jSONObject3 = jSONObject;
            }
        }
        if (listN.size() != 0) {
            c();
        } else {
            c();
        }
        if (listN.size() != 0) {
            h();
        } else {
            h();
        }
        if (listN.size() != 0) {
            g();
        } else {
            g();
        }
        if (listN.size() != 0) {
            m();
        } else {
            m();
        }
        if (listN.size() != 0) {
            b();
        } else {
            b();
        }
        if (listN.size() != 0) {
            l();
        } else {
            l();
        }
        jSONObject4 = new org.json.JSONObject();
        jSONObject5 = new org.json.JSONObject();
        jSONObject6 = new org.json.JSONObject();
        jSONObject7 = new org.json.JSONObject();
        map2 = new java.util.HashMap();
        z9 = z8;
        strB4 = b(io.dcloud.p.e1.b("kge&oggodm&iflzgal&oe{&il{&IXXDAKI\\AGFWAL"));
        z10 = true;
        if (z3) {
        }
    }

    private boolean a(java.lang.String str, org.json.JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                if (str.equals(jSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    private java.lang.String a(java.lang.String str, java.lang.String str2) {
        byte[] bArrDecode2bytes = io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(3));
        if (bArrDecode2bytes == null) {
            a(4);
            return "";
        }
        java.lang.String strDecrypt = io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), bArrDecode2bytes);
        if (strDecrypt == null) {
            a(4);
            return "";
        }
        try {
            return (java.lang.String) java.lang.Class.forName(strDecrypt).getMethod("da", java.lang.String.class, java.lang.String.class).invoke(null, str, str2);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private org.json.JSONArray a(java.lang.String str) {
        byte[] bArrDecode2bytes = io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(3));
        if (bArrDecode2bytes == null) {
            a(4);
            return null;
        }
        java.lang.String strDecrypt = io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), bArrDecode2bytes);
        if (strDecrypt == null) {
            a(4);
            return null;
        }
        try {
            return (org.json.JSONArray) java.lang.Class.forName(strDecrypt).getMethod("dah", java.lang.String.class).invoke(null, str);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private void a(int i) {
        if (this.a == null) {
            return;
        }
        io.dcloud.p.g0 g0Var = new io.dcloud.p.g0((android.app.Activity) this.a, "");
        android.widget.TextView textView = new android.widget.TextView(this.a);
        textView.setAutoLinkMask(1);
        textView.setClickable(true);
        textView.setText(io.dcloud.p.a4.a(this.a).a(io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.e(), io.dcloud.p.e1.b(), io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.r4.a(i)))));
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(this.a);
        linearLayout.addView(textView);
        g0Var.a(linearLayout, textView);
        g0Var.setDuration(1);
        g0Var.setGravity(80, g0Var.getXOffset(), g0Var.getYOffset());
        int iDip2px = io.dcloud.common.adapter.util.CanvasHelper.dip2px(this.a, 10.0f);
        int iDip2px2 = io.dcloud.common.adapter.util.CanvasHelper.dip2px(this.a, 8.0f);
        linearLayout.setPadding(iDip2px, iDip2px2, iDip2px, iDip2px2);
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setCornerRadius(iDip2px2);
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1308622848);
        linearLayout.setBackground(gradientDrawable);
        textView.setGravity(17);
        textView.setTextColor(android.graphics.Color.parseColor("#ffffffff"));
        g0Var.show();
    }
}
