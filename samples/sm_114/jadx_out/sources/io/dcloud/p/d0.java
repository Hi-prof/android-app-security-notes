package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d0 {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends java.util.ArrayList {
        a() {
            addAll(io.dcloud.p.r1.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements io.dcloud.p.q1.b {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.util.HashMap b;
        final /* synthetic */ java.lang.String[] c;

        b(java.lang.String str, java.util.HashMap map, java.lang.String[] strArr) {
            this.a = str;
            this.b = map;
            this.c = strArr;
        }

        @Override // io.dcloud.p.q1.b
        public void a(io.dcloud.p.q1.a aVar) {
        }

        @Override // io.dcloud.p.q1.b
        public boolean b(io.dcloud.p.q1.a aVar) {
            byte[] bArrA = io.dcloud.p.l3.a(aVar.a(), this.a, this.b, this.c);
            if (bArrA == null) {
                return false;
            }
            java.lang.String str = new java.lang.String(bArrA, java.nio.charset.StandardCharsets.UTF_8);
            if (android.text.TextUtils.isEmpty(str)) {
                return true;
            }
            io.dcloud.p.c3.c("uniAD-Commit_A", str);
            return true;
        }

        @Override // io.dcloud.p.q1.b
        public void onNoOnePicked() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c extends java.util.ArrayList {
        c() {
            addAll(io.dcloud.p.r1.f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements io.dcloud.p.q1.b {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.util.HashMap b;

        d(java.lang.String str, java.util.HashMap map) {
            this.a = str;
            this.b = map;
        }

        @Override // io.dcloud.p.q1.b
        public void a(io.dcloud.p.q1.a aVar) {
        }

        @Override // io.dcloud.p.q1.b
        public boolean b(io.dcloud.p.q1.a aVar) {
            byte[] bArrA = io.dcloud.p.l3.a(aVar.a(), this.a, this.b);
            if (bArrA == null) {
                return false;
            }
            java.lang.String str = new java.lang.String(bArrA, java.nio.charset.StandardCharsets.UTF_8);
            if (android.text.TextUtils.isEmpty(str)) {
                return true;
            }
            io.dcloud.p.c3.c("uniAD-Commit_F", str);
            return true;
        }

        @Override // io.dcloud.p.q1.b
        public void onNoOnePicked() {
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4) {
        a(context, null, null, str2, str, str3, i, str4, null, null, null);
    }

    private static java.util.Map b(android.content.Context context, java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.util.HashMap map) {
        java.lang.String strEncode;
        java.lang.String str4;
        try {
            strEncode = java.net.URLEncoder.encode(android.os.Build.MODEL, "utf-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            strEncode = "";
        }
        try {
            str4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (java.lang.Exception unused2) {
            str4 = "";
        }
        java.lang.String strA = io.dcloud.p.u4.a(context, true, true);
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT, "a");
        map2.put("appid", str);
        map2.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, str4);
        map2.put("at", java.lang.Integer.valueOf(i));
        map2.put("psdk", java.lang.Integer.valueOf(io.dcloud.p.l0.c()));
        map2.put(com.taobao.weex.common.WXConfig.os, java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT));
        map2.put("adpid", str3);
        if (strA.endsWith("&ie=1")) {
            strA = strA.replace("&ie=1", "");
            map2.put("ie", 1);
        } else if (strA.endsWith("&ie=0")) {
            strA = strA.replace("&ie=0", "");
            map2.put("ie", 0);
        }
        map2.put("imei", strA);
        map2.put("md", strEncode);
        map2.put("vd", android.os.Build.MANUFACTURER);
        map2.put("net", io.dcloud.p.n4.d(context));
        map2.put("vb", io.dcloud.p.l0.a());
        map2.put("t", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        map2.put("mc", io.dcloud.p.l0.a(context));
        map2.put("paid", str2);
        map2.put("oaid", io.dcloud.p.m3.a().c(context));
        if (map != null) {
            map2.putAll(map);
        }
        return map2;
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i, java.lang.String str6, java.util.HashMap map, java.lang.String str7, java.lang.String str8) {
        a(context, str4, str3, str5, i, null, null, null, str, str2, str6, null, map, str7, str8, null, null);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i, java.lang.String str6, java.util.HashMap map, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10) {
        a(context, str4, str3, str5, i, null, null, null, str, str2, str6, null, map, str7, str8, str9, str10);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4, java.lang.String str5, org.json.JSONObject jSONObject, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.util.HashMap map, java.lang.String str10, java.lang.String str11, java.lang.String str12, java.lang.String str13) {
        java.lang.String strEncode;
        org.json.JSONObject jSONObjectOptJSONObject;
        java.util.Map mapB = b(context, str, str3, i, str8, map);
        if (str10 != null) {
            mapB.put("rid", str10);
        }
        if (str11 != null) {
            mapB.put("cpm", str11);
        }
        if (str6 != null) {
            mapB.put("mediaId", str6);
        }
        if (str12 != null) {
            mapB.put("csv", str12);
        }
        if (str13 != null) {
            mapB.put("cav", str13);
        }
        if (str7 != null) {
            mapB.put("slotId", str7);
        }
        if (i == 32) {
            mapB.put("dec", str4);
            mapB.put("dem", str5);
        }
        if (i == 41 && jSONObject != null && str6 == null) {
            if (jSONObject.has(com.taobao.weex.ui.component.WXBasicComponentType.IMG)) {
                mapB.put(com.taobao.weex.ui.component.WXBasicComponentType.IMG, io.dcloud.p.d3.a(jSONObject.optString(com.taobao.weex.ui.component.WXBasicComponentType.IMG)).toLowerCase(java.util.Locale.ENGLISH));
            }
            if (jSONObject.has("dw")) {
                mapB.put("dw", jSONObject.optString("dw"));
            }
            if (jSONObject.has("dh")) {
                mapB.put("dh", jSONObject.optString("dh"));
            }
            if (jSONObject.has("click_coord") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("click_coord")) != null) {
                mapB.put("click_coord", jSONObjectOptJSONObject.toString());
            }
        }
        mapB.put("tid", str2);
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put(io.dcloud.common.util.net.NetWork.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        try {
            strEncode = java.net.URLEncoder.encode(android.util.Base64.encodeToString(io.dcloud.p.d.b(io.dcloud.p.g5.a(new org.json.JSONObject(mapB).toString()), io.dcloud.p.f1.b(), io.dcloud.p.f1.a()), 2), "utf-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            strEncode = null;
        }
        io.dcloud.p.q1.a().a(context, new io.dcloud.p.d0.a(), "CAA_" + i, new io.dcloud.p.d0.b("edata=" + strEncode, map2, new java.lang.String[1]));
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.util.HashMap map) {
        java.lang.String strEncode;
        try {
            strEncode = java.net.URLEncoder.encode(android.util.Base64.encodeToString(io.dcloud.p.d.b(io.dcloud.p.g5.a(new org.json.JSONObject(b(context, str, str2, i, str3, map)).toString()), io.dcloud.p.f1.b(), io.dcloud.p.f1.a()), 2), "utf-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            strEncode = null;
        }
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put(io.dcloud.common.util.net.NetWork.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        io.dcloud.p.q1.a().a(context, new io.dcloud.p.d0.c(), "RSP", new io.dcloud.p.d0.d("edata=" + strEncode, map2));
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, int i, java.lang.String str8) {
        java.lang.String strEncode;
        java.lang.String strEncode2;
        java.lang.String str9 = "";
        try {
            strEncode = java.net.URLEncoder.encode(android.os.Build.MODEL, "utf-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            strEncode = "";
        }
        try {
            str9 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (java.lang.Exception unused2) {
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT, "a");
        map.put("appid", str);
        map.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, str9);
        map.put("psdk", java.lang.Integer.valueOf(io.dcloud.p.l0.c()));
        map.put(com.taobao.weex.common.WXConfig.os, java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT));
        map.put("adpid", str2);
        map.put("md", strEncode);
        map.put("vd", android.os.Build.MANUFACTURER);
        map.put("vb", io.dcloud.p.l0.a());
        map.put("t", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        map.put("mc", io.dcloud.p.l0.a(context));
        map.put("paid", str3);
        if (str4 != null) {
            map.put("mediaId", str4);
        }
        if (str5 != null) {
            map.put("slotId", str5);
        }
        if (str8 != null) {
            map.put("rid", str8);
            io.dcloud.p.c3.b("uniad", str8);
        }
        map.put("gcpm", str6);
        map.put("currency", str7);
        map.put("pt", java.lang.Integer.valueOf(i));
        try {
            strEncode2 = java.net.URLEncoder.encode(android.util.Base64.encodeToString(io.dcloud.p.d.b(io.dcloud.p.g5.a(new org.json.JSONObject(map).toString()), io.dcloud.p.f1.b(), io.dcloud.p.f1.a()), 2), "utf-8");
        } catch (java.io.UnsupportedEncodingException unused3) {
            strEncode2 = null;
        }
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put(io.dcloud.common.util.net.NetWork.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        byte[] bArrA = io.dcloud.p.l3.a(io.dcloud.p.r1.g.a(), "edata=" + strEncode2, map2);
        if (bArrA != null) {
            java.lang.String str10 = new java.lang.String(bArrA, java.nio.charset.StandardCharsets.UTF_8);
            if (android.text.TextUtils.isEmpty(str10)) {
                return;
            }
            io.dcloud.p.c3.c("uniAD-Commit_P", str10);
        }
    }
}
