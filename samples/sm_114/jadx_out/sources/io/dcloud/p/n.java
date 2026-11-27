package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class n {
    private static java.lang.Boolean a;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class a {
        public boolean a = true;
        public int b;
        public int c;
        public java.util.List d;
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class b {
        private double a;
        private double b;
        private java.lang.String c;

        public java.lang.String a() {
            return this.c;
        }

        public void a(double d, double d2, java.lang.String str) {
            this.a = d;
            this.b = d2;
            this.c = str;
        }

        public boolean a(double d) {
            return d >= this.a && d < this.b;
        }
    }

    private static void a(android.content.Context context, java.lang.Boolean bool) {
        try {
            io.dcloud.p.v0.a((bool.booleanValue() ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT).getBytes(), 0, e(context).replaceAll("/ad/", "/") + "AdEnable.dat");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        a(context, java.lang.Boolean.valueOf(java.lang.Integer.parseInt(str) == 1));
    }

    public static void c(android.content.Context context, java.lang.String str) {
        a = java.lang.Boolean.valueOf("1".equals(str));
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        io.dcloud.p.e4.a(context, io.dcloud.feature.gg.AolSplashUtil.showCountADReward, "_is_gm_channel", str);
    }

    public static boolean d(android.content.Context context) {
        try {
            java.lang.String strG = g(context);
            return strG == null ? b(context).booleanValue() : "1".equals(strG.replaceAll("\n", ""));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private static java.lang.String e(android.content.Context context) {
        java.io.File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            return "/sdcard/Android/data/" + context.getPackageName() + "/cache/ad/";
        }
        return externalCacheDir.getAbsolutePath() + "/ad/";
    }

    public static boolean f(android.content.Context context) {
        if (a == null) {
            a = java.lang.Boolean.valueOf("1".equals(io.dcloud.p.e4.a(context, io.dcloud.feature.gg.AolSplashUtil.showCountADReward, "_is_gm_channel")));
        }
        return a.booleanValue();
    }

    public static java.lang.String g(android.content.Context context) {
        java.lang.String str = e(context).replaceAll("/ad/", "/") + "AdEnable.dat";
        try {
            if (io.dcloud.p.v0.a(str)) {
                return new java.lang.String(io.dcloud.p.v0.e(str));
            }
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static java.lang.Boolean b(android.content.Context context) {
        try {
            return java.lang.Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("DCLOUD_AD_SPLASH", false));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return java.lang.Boolean.FALSE;
        }
    }

    public static java.lang.String c(android.content.Context context) {
        return io.dcloud.p.e4.a(context, io.dcloud.feature.gg.AolSplashUtil.showCountADReward, "servertime");
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObject;
        java.lang.String strA = io.dcloud.p.e4.a(context, io.dcloud.feature.gg.AolSplashUtil.showCountADReward, str);
        try {
            if (android.text.TextUtils.isEmpty(strA)) {
                jSONObject = new org.json.JSONObject();
            } else {
                jSONObject = new org.json.JSONObject(strA);
            }
            if (jSONObject.has(str2)) {
                jSONObject.put(str2, jSONObject.optInt(str2) + 1);
            } else {
                jSONObject.put(str2, 1);
            }
            io.dcloud.p.e4.a(context, io.dcloud.feature.gg.AolSplashUtil.showCountADReward, str, jSONObject.toString());
        } catch (org.json.JSONException unused) {
        }
    }

    public static java.lang.String b(io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL) {
        io.dcloud.sdk.core.adapter.IAdAdapter iAdAdapterB;
        if (!dCBaseAOL.isCustom() || (iAdAdapterB = io.dcloud.p.e.b().b(dCBaseAOL.getType())) == null) {
            return null;
        }
        return iAdAdapterB.getSDKVersion();
    }

    public static void a(android.content.Context context) {
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(io.dcloud.feature.gg.AolSplashUtil.showCountADReward, 0).edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    public static void a(android.content.Context context, java.lang.String str) {
        io.dcloud.p.e4.a(context, io.dcloud.feature.gg.AolSplashUtil.showCountADReward, "servertime", str);
    }

    public static boolean a(long j, long j2) {
        java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar();
        gregorianCalendar.setTimeInMillis(j);
        java.util.GregorianCalendar gregorianCalendar2 = new java.util.GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j2);
        return gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(2) == gregorianCalendar2.get(2) && gregorianCalendar.get(5) == gregorianCalendar2.get(5);
    }

    public static java.util.List a(android.content.Context context, java.util.List list, java.lang.String str, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        org.json.JSONObject jSONObject3;
        java.lang.String strOptString;
        int iOptInt;
        io.dcloud.p.c3.a(java.lang.String.valueOf(str) + "---STA---" + list.toString());
        if (jSONObject != null && jSONObject.length() > 0 && list.size() > 1) {
            java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                java.lang.String next = itKeys.next();
                if (!list.contains(next)) {
                    itKeys.remove();
                } else if (jSONObject.optInt(next) <= 0) {
                    itKeys.remove();
                }
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(a(jSONObject));
            if (list.size() != arrayList.size()) {
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    java.lang.String str2 = (java.lang.String) it.next();
                    if (!arrayList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
            list = arrayList;
        }
        io.dcloud.p.c3.a(java.lang.String.valueOf(str) + "---PRE---" + list.toString());
        if (jSONObject2 != null && jSONObject2.length() > 0 && list.size() > 1) {
            try {
                jSONObject3 = new org.json.JSONObject(io.dcloud.p.e4.a(context, io.dcloud.feature.gg.AolSplashUtil.showCountADReward, str));
            } catch (java.lang.Exception unused) {
                jSONObject3 = null;
            }
            boolean z = true;
            int i = 0;
            while (jSONObject3 != null && z && i < list.size()) {
                i++;
                org.json.JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray((java.lang.String) list.get(0));
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 1) {
                    strOptString = jSONArrayOptJSONArray.optString(0);
                    iOptInt = jSONArrayOptJSONArray.optInt(1);
                } else {
                    strOptString = "";
                    iOptInt = 0;
                }
                if (iOptInt > jSONObject3.optInt(strOptString) || iOptInt == 0) {
                    z = false;
                } else {
                    list.add((java.lang.String) list.remove(0));
                }
            }
        }
        io.dcloud.p.c3.a(java.lang.String.valueOf(str) + "---AFT---" + list.toString());
        return list;
    }

    private static java.util.List a(org.json.JSONObject jSONObject) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONObject != null && jSONObject.length() != 0) {
            if (jSONObject.length() == 1) {
                arrayList.add(jSONObject.keys().next());
                return arrayList;
            }
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            for (int i = 0; i < jSONObject.length(); i++) {
                arrayList2.add(new io.dcloud.p.n.b());
            }
            while (arrayList2.size() > 1) {
                io.dcloud.p.n.b bVarA = a(arrayList2, a(jSONObject, arrayList2));
                if (bVarA != null) {
                    jSONObject.remove(bVarA.a());
                    arrayList2.remove(bVarA);
                    arrayList.add(bVarA.a());
                }
            }
            arrayList.add(((io.dcloud.p.n.b) arrayList2.get(0)).a());
        }
        return arrayList;
    }

    private static int a(org.json.JSONObject jSONObject, java.util.ArrayList arrayList) {
        java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
        int iOptInt = 0;
        int i = 0;
        while (itKeys.hasNext()) {
            java.lang.String next = itKeys.next();
            double d = iOptInt;
            iOptInt += jSONObject.optInt(next);
            ((io.dcloud.p.n.b) arrayList.get(i)).a(d, iOptInt, next);
            i++;
        }
        return iOptInt;
    }

    private static io.dcloud.p.n.b a(java.util.ArrayList arrayList, int i) {
        double dRandom = java.lang.Math.random() * ((double) i);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            java.lang.Object obj = arrayList.get(i2);
            i2++;
            io.dcloud.p.n.b bVar = (io.dcloud.p.n.b) obj;
            if (bVar.a(dRandom)) {
                return bVar;
            }
        }
        return null;
    }

    public static void a(java.util.List list) {
        if (list.size() > 1) {
            for (int i = 0; i < list.size() - 1; i++) {
                int i2 = 0;
                while (i2 < (list.size() - i) - 1) {
                    int i3 = i2 + 1;
                    if (((io.dcloud.sdk.core.module.DCBaseAOL) list.get(i3)).getBiddingECPM() > ((io.dcloud.sdk.core.module.DCBaseAOL) list.get(i2)).getBiddingECPM()) {
                        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = (io.dcloud.sdk.core.module.DCBaseAOL) list.get(i2);
                        list.set(i2, (io.dcloud.sdk.core.module.DCBaseAOL) list.get(i3));
                        list.set(i3, dCBaseAOL);
                    }
                    i2 = i3;
                }
            }
        }
    }

    public static io.dcloud.p.n.a a(int i, java.util.List... listArr) {
        int biddingECPM;
        int biddingECPM2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        boolean z = false;
        for (java.util.List list : listArr) {
            arrayList.addAll(list);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        a(arrayList);
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        if (arrayList.size() > i) {
            arrayList2.addAll(arrayList.subList(0, i));
            java.util.List<io.dcloud.sdk.core.module.DCBaseAOL> listSubList = arrayList.subList(i, arrayList.size());
            biddingECPM = ((io.dcloud.sdk.core.module.DCBaseAOL) arrayList2.get(0)).getBiddingECPM();
            biddingECPM2 = ((io.dcloud.sdk.core.module.DCBaseAOL) listSubList.get(0)).getBiddingECPM();
            for (io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL : listSubList) {
                if (dCBaseAOL.isSlotSupportBidding()) {
                    dCBaseAOL.biddingFail(biddingECPM, biddingECPM2, 2);
                }
            }
        } else {
            arrayList2.addAll(arrayList);
            biddingECPM = ((io.dcloud.sdk.core.module.DCBaseAOL) arrayList2.get(0)).getBiddingECPM();
            biddingECPM2 = 0;
        }
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            java.lang.Object obj = arrayList2.get(i2);
            i2++;
            if (!((io.dcloud.sdk.core.module.DCBaseAOL) obj).isSlotSupportBidding()) {
                io.dcloud.p.n.a aVar = new io.dcloud.p.n.a();
                aVar.a = z;
                aVar.b = biddingECPM;
                aVar.c = biddingECPM2;
                aVar.d = arrayList2;
                return aVar;
            }
        }
        z = true;
        io.dcloud.p.n.a aVar2 = new io.dcloud.p.n.a();
        aVar2.a = z;
        aVar2.b = biddingECPM;
        aVar2.c = biddingECPM2;
        aVar2.d = arrayList2;
        return aVar2;
    }

    public static java.lang.String a(io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL) {
        io.dcloud.sdk.core.adapter.IAdAdapter iAdAdapterB;
        if (!dCBaseAOL.isCustom() || (iAdAdapterB = io.dcloud.p.e.b().b(dCBaseAOL.getType())) == null) {
            return null;
        }
        return iAdAdapterB.getAdapterSDKVersion();
    }
}
