package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class c0 implements io.dcloud.p.t1.a {
    private static volatile io.dcloud.p.c0 l;
    private org.json.JSONObject d;
    private android.content.Context g;
    private final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);
    private final java.util.Queue b = new java.util.concurrent.ConcurrentLinkedQueue();
    private final java.util.Map c = new java.util.HashMap();
    private final java.util.Map e = new java.util.HashMap();
    private java.lang.String f = "";
    private final java.lang.String h = "uniad_config";
    private final java.lang.String i = "S_C";
    private final java.lang.String j = "pap";
    private final java.lang.String k = "dpap";

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends java.util.HashMap {
        a() {
            put("r", java.lang.Boolean.FALSE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b extends java.util.HashMap {
        b() {
            put(com.taobao.weex.ui.component.WXComponent.PROP_FS_MATCH_PARENT, java.lang.Boolean.FALSE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static abstract class c {
        java.lang.String a;

        public c(java.lang.String str) {
            this.a = str;
        }

        public abstract void a(int i, java.lang.String str);

        public abstract void a(org.json.JSONObject jSONObject);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static abstract class d extends io.dcloud.p.c0.c {
        private boolean b;

        public d(java.lang.String str) {
            super(str);
            this.b = false;
        }

        public abstract void a(org.json.JSONArray jSONArray);

        public abstract void a(org.json.JSONArray jSONArray, boolean z);

        @Override // io.dcloud.p.c0.c
        public void a(org.json.JSONObject jSONObject) {
            this.b = true;
        }

        @Override // io.dcloud.p.c0.c
        public void a(int i, java.lang.String str) {
            this.b = true;
        }

        public boolean a() {
            return this.b;
        }
    }

    private c0() {
    }

    public static io.dcloud.p.c0 a() {
        if (l == null) {
            synchronized (io.dcloud.p.c0.class) {
                if (l == null) {
                    l = new io.dcloud.p.c0();
                    return l;
                }
            }
        }
        return l;
    }

    private org.json.JSONObject b(android.content.Context context) {
        try {
            android.os.Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            java.util.Set<java.lang.String> setKeySet = bundle.keySet();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            for (java.lang.String str : setKeySet) {
                if (str.startsWith("UNIAD")) {
                    if (str.endsWith("APPID")) {
                        a(bundle, str, jSONObject);
                    } else if (str.endsWith("SPLASH")) {
                        a(bundle, str, jSONObject3);
                    } else if (str.endsWith("APPKEY")) {
                        a(bundle, str, jSONObject2);
                    } else if (str.endsWith("ADPID")) {
                        a(bundle, str, jSONObject3);
                    }
                }
            }
            if (bundle.containsKey("com.google.android.gms.ads.APPLICATION_ID")) {
                jSONObject.put(io.dcloud.sdk.core.util.Const.TYPE_GG, bundle.getString("com.google.android.gms.ads.APPLICATION_ID"));
            }
            if (d(context)) {
                jSONObject3 = new org.json.JSONObject();
            }
            if (jSONObject3.length() > 0) {
                java.util.Iterator<java.lang.String> itKeys = jSONObject3.keys();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(itKeys.next());
                while (itKeys.hasNext()) {
                    sb.append(",");
                    sb.append(itKeys.next());
                }
                jSONObject3.put("_psp_", sb.toString());
                jSONObject3.put("_adpid_", jSONObject3.optString("adpid"));
                jSONObject3.put("_fs_", bundle.getString("UNIAD_FULL_SPLASH", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT));
            }
            io.dcloud.p.p0 p0Var = new io.dcloud.p.p0();
            p0Var.put("697878616C", jSONObject);
            p0Var.put("697878436D71", jSONObject2);
            p0Var.put("7B7864697B60", jSONObject3);
            return b(p0Var);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private boolean d(android.content.Context context) {
        java.lang.String str = io.dcloud.p.r0.d().b().getAppId() + "/www/androidPrivacy.json";
        if (a(context, "apps/" + str)) {
            return true;
        }
        context.getFilesDir();
        java.lang.String str2 = android.os.Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + context.getPackageName() + java.io.File.separatorChar;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str2);
        sb.append(str);
        return new java.io.File(sb.toString()).exists() || new java.io.File(context.getFilesDir(), str).exists() || new java.io.File(context.getFilesDir().getParentFile(), str).exists();
    }

    public void c(android.content.Context context) {
        io.dcloud.sdk.core.adapter.IAdAdapter iAdAdapterB;
        for (java.util.Map.Entry entry : this.e.entrySet()) {
            io.dcloud.p.b0 b0Var = (io.dcloud.p.b0) entry.getValue();
            java.lang.String str = (java.lang.String) entry.getKey();
            if (b0Var.h()) {
                try {
                    java.lang.Object objNewInstance = java.lang.Class.forName(b0Var.d()).newInstance();
                    if (objNewInstance instanceof io.dcloud.api.custom.UniAdCustomAdapter) {
                        io.dcloud.p.e.b().a(str, (io.dcloud.api.custom.UniAdCustomAdapter) objNewInstance);
                        iAdAdapterB = (io.dcloud.api.custom.UniAdCustomAdapter) objNewInstance;
                    } else {
                        iAdAdapterB = null;
                    }
                } catch (java.lang.Exception unused) {
                }
            } else {
                iAdAdapterB = io.dcloud.p.e.b().b(str);
            }
            if (iAdAdapterB != null) {
                try {
                    iAdAdapterB.init(context, b0Var.e());
                } catch (java.lang.Exception unused2) {
                }
            }
        }
    }

    public void a(android.content.Context context, int i, io.dcloud.p.c0.c cVar) {
        org.json.JSONObject jSONObject;
        io.dcloud.p.p0 p0Var;
        if (android.text.TextUtils.isEmpty(cVar.a) && i != 1 && i != 3) {
            cVar.a(-5001, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5001));
            return;
        }
        if (i == 3) {
            org.json.JSONObject jSONObject2 = this.d;
            if (jSONObject2 != null && jSONObject2.has("frsplash")) {
                cVar.a(this.d.optJSONObject("frsplash"));
                return;
            } else {
                cVar.a(-5015, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5015));
                return;
            }
        }
        if (i == 1) {
            org.json.JSONObject jSONObject3 = this.d;
            if (jSONObject3 != null) {
                if (!jSONObject3.has("splash")) {
                    cVar.a(-5019, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5019));
                    return;
                } else if (io.dcloud.p.n.d(context)) {
                    cVar.a(this.d.optJSONObject("splash"));
                    this.b.add(cVar);
                    return;
                } else {
                    cVar.a(this.d.optJSONObject("splash"));
                    this.b.add(cVar);
                    return;
                }
            }
            java.lang.String strA = io.dcloud.p.e4.a(context, "uniad_config", "S_C");
            if (android.text.TextUtils.isEmpty(strA)) {
                org.json.JSONObject jSONObjectB = b(context);
                if (jSONObjectB == null) {
                    cVar.a(-5000, "");
                } else {
                    cVar.a(jSONObjectB);
                }
            } else {
                try {
                    p0Var = new io.dcloud.p.p0(io.dcloud.p.s4.c(strA));
                } catch (org.json.JSONException unused) {
                    p0Var = null;
                }
                if (p0Var != null && p0Var.length() > 0) {
                    if (!p0Var.has("7B78") && !p0Var.has("697878436D71")) {
                        a(p0Var.b("697878616C"));
                        if (io.dcloud.p.n.d(context)) {
                            org.json.JSONObject jSONObjectB2 = p0Var.b("7B7864697B60");
                            if (jSONObjectB2 != null) {
                                cVar.a(jSONObjectB2);
                            }
                        } else {
                            org.json.JSONObject jSONObjectB3 = p0Var.b("7B7864697B60");
                            if (jSONObjectB3 != null) {
                                cVar.a(jSONObjectB3);
                            }
                        }
                    } else {
                        org.json.JSONObject jSONObjectB4 = b(p0Var);
                        if (jSONObjectB4 != null) {
                            cVar.a(jSONObjectB4);
                        }
                    }
                }
            }
            this.b.add(cVar);
            if (this.a.get()) {
                return;
            }
            a(context, i);
            return;
        }
        if (this.e.size() > 0 && (jSONObject = this.d) != null && jSONObject.length() > 0) {
            if (!android.text.TextUtils.isEmpty(cVar.a)) {
                if (this.d.has(cVar.a)) {
                    cVar.a(this.d.optJSONObject(cVar.a));
                    return;
                }
                cVar.a(-5002, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5002) + cVar.a);
                return;
            }
            cVar.a(-5001, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5001));
            return;
        }
        this.b.add(cVar);
        if (this.a.get()) {
            return;
        }
        a(context, i);
    }

    private org.json.JSONObject b(io.dcloud.p.p0 p0Var) {
        io.dcloud.p.b0 b0Var;
        org.json.JSONObject jSONObjectA = p0Var.a("appid");
        org.json.JSONObject jSONObjectA2 = p0Var.a("appKey");
        org.json.JSONObject jSONObjectA3 = p0Var.a("splash");
        org.json.JSONObject jSONObjectA4 = p0Var.a("sp");
        java.util.HashMap map = new java.util.HashMap();
        if (jSONObjectA != null) {
            java.util.Iterator<java.lang.String> itKeys = jSONObjectA.keys();
            while (itKeys.hasNext()) {
                java.lang.String next = itKeys.next();
                io.dcloud.p.b0 b0Var2 = new io.dcloud.p.b0();
                b0Var2.c(next);
                b0Var2.a(jSONObjectA.optString(next));
                if (jSONObjectA2 != null && jSONObjectA2.has(next)) {
                    b0Var2.b(jSONObjectA.optString(next));
                }
                map.put(next, b0Var2);
            }
        }
        if (jSONObjectA4 != null) {
            java.util.Iterator<java.lang.String> itKeys2 = jSONObjectA4.keys();
            while (itKeys2.hasNext()) {
                java.lang.String next2 = itKeys2.next();
                org.json.JSONObject jSONObjectOptJSONObject = jSONObjectA4.optJSONObject(next2);
                if (jSONObjectOptJSONObject != null) {
                    if (map.containsKey(next2)) {
                        b0Var = (io.dcloud.p.b0) map.get(next2);
                    } else {
                        b0Var = new io.dcloud.p.b0();
                        b0Var.c(next2);
                    }
                    io.dcloud.sdk.poly.api.Platform platform = new io.dcloud.sdk.poly.api.Platform();
                    platform.setType(next2);
                    platform.setPlatJson(jSONObjectOptJSONObject);
                    b0Var.a(platform);
                    map.put(next2, b0Var);
                }
            }
        }
        this.e.putAll(map);
        org.json.JSONObject jSONObject = null;
        if (jSONObjectA3 != null) {
            java.lang.String strOptString = jSONObjectA3.optString("_psp_");
            if (android.text.TextUtils.isEmpty(strOptString)) {
                return null;
            }
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                jSONObject2.put("adpid", jSONObjectA3.optString("_adpid_"));
                jSONObject2.put("type", 1);
                jSONObject2.put("cpadpid", jSONObjectA3.optString("cp_adp_id"));
                jSONObject2.put("fs", jSONObjectA3.optString("_fs_"));
                jSONObject2.put("fwt", jSONObjectA3.optString("_fwt_"));
                jSONObject2.put("ord", jSONObjectA3.optString("_ord_"));
                jSONObject2.put("sr", jSONObjectA3.optString("_sr_"));
                org.json.JSONObject jSONObjectOptJSONObject2 = jSONObjectA3.optJSONObject("_w_");
                if (jSONObjectOptJSONObject2 == null) {
                    jSONObjectOptJSONObject2 = new org.json.JSONObject();
                }
                org.json.JSONObject jSONObjectOptJSONObject3 = jSONObjectA3.optJSONObject("_m_");
                if (jSONObjectOptJSONObject3 == null) {
                    jSONObjectOptJSONObject3 = new org.json.JSONObject();
                }
                java.lang.String[] strArrSplit = android.text.TextUtils.split(strOptString, ",");
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                for (java.lang.String str : strArrSplit) {
                    org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                    jSONObject3.put(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT, str);
                    jSONObject3.put("sid", jSONObjectA3.optString(str));
                    if (jSONObjectOptJSONObject2.has(str)) {
                        jSONObject3.put(com.taobao.weex.ui.component.WXComponent.PROP_FS_WRAP_CONTENT, jSONObjectOptJSONObject2.optString(str));
                    }
                    if (jSONObjectOptJSONObject3.has(str)) {
                        jSONObject3.put(com.taobao.weex.ui.component.WXComponent.PROP_FS_MATCH_PARENT, jSONObjectOptJSONObject3.optString(str));
                    }
                    jSONArray.put(jSONObject3);
                }
                jSONObject2.put("cfgs", jSONArray);
                return jSONObject2;
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                jSONObject = jSONObject2;
            }
        }
        return jSONObject;
    }

    private void a(android.content.Context context, int i) {
        this.g = context.getApplicationContext();
        this.a.set(true);
        io.dcloud.p.r0.d().a().a(context, i, this);
    }

    @Override // io.dcloud.p.t1.a
    public void a(io.dcloud.p.p0 p0Var) {
        int i = 0;
        this.a.set(false);
        if (p0Var.has("786978")) {
            io.dcloud.p.n.b(this.g, p0Var.optString("786978", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT));
        }
        if (p0Var.has("6F65")) {
            io.dcloud.p.n.c(this.g, p0Var.optString("6F65", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT));
        }
        if (p0Var.has("6C786978")) {
            java.lang.String strOptString = p0Var.optString("6C786978", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            this.f = strOptString;
            io.dcloud.p.e4.a(this.g, "uniad_config", "dpap", strOptString);
        }
        io.dcloud.p.p0 p0VarOptJSONObject = p0Var.optJSONObject("6C697C69");
        if (p0VarOptJSONObject != null && p0VarOptJSONObject.has("7D6661696C")) {
            io.dcloud.p.p0 p0VarOptJSONObject2 = p0VarOptJSONObject.optJSONObject("7D6661696C");
            if (p0VarOptJSONObject2 != null && p0VarOptJSONObject2.length() > 0) {
                org.json.JSONObject jSONObjectB = p0VarOptJSONObject2.has("6B606966666D64") ? p0VarOptJSONObject2.b("6B606966666D64") : new org.json.JSONObject();
                this.e.clear();
                a(jSONObjectB);
                org.json.JSONArray jSONArrayOptJSONArray = p0VarOptJSONObject2.has("787A") ? p0VarOptJSONObject2.optJSONArray("787A") : null;
                org.json.JSONObject jSONObjectB2 = p0VarOptJSONObject2.b("696C78616C7B");
                this.d = jSONObjectB2;
                org.json.JSONObject jSONObjectOptJSONObject = jSONObjectB2 != null ? jSONObjectB2.optJSONObject("splash") : null;
                io.dcloud.p.p0 p0Var2 = new io.dcloud.p.p0();
                try {
                    p0Var2.put("697878616C", jSONObjectB);
                    p0Var2.put("7B7864697B60", jSONObjectOptJSONObject);
                } catch (org.json.JSONException unused) {
                }
                a(p0Var2.toString(), this.g);
                org.json.JSONArray jSONArrayOptJSONArray2 = p0Var.optJSONArray("787B697B");
                java.util.ArrayList arrayList = new java.util.ArrayList();
                org.json.JSONObject jSONObject = this.d;
                if (jSONObject != null && jSONObject.length() > 0) {
                    java.util.Iterator it = this.b.iterator();
                    while (it.hasNext()) {
                        io.dcloud.p.c0.c cVar = (io.dcloud.p.c0.c) it.next();
                        if (cVar instanceof io.dcloud.p.c0.d) {
                            arrayList.add((io.dcloud.p.c0.d) cVar);
                        } else if (this.d.has(cVar.a)) {
                            cVar.a(this.d.optJSONObject(cVar.a));
                        } else {
                            cVar.a(-5002, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5002) + cVar.a);
                        }
                        it.remove();
                    }
                } else {
                    java.util.Iterator it2 = this.b.iterator();
                    while (it2.hasNext()) {
                        io.dcloud.p.c0.c cVar2 = (io.dcloud.p.c0.c) it2.next();
                        if (cVar2 instanceof io.dcloud.p.c0.d) {
                            arrayList.add((io.dcloud.p.c0.d) cVar2);
                        } else {
                            cVar2.a(-5007, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5007));
                        }
                        it2.remove();
                    }
                }
                int size = arrayList.size();
                while (i < size) {
                    java.lang.Object obj = arrayList.get(i);
                    i++;
                    io.dcloud.p.c0.d dVar = (io.dcloud.p.c0.d) obj;
                    if (!dVar.b) {
                        if (io.dcloud.p.n.d(this.g)) {
                            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                                dVar.a(jSONObjectOptJSONObject);
                            } else {
                                dVar.a(-5007, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5007));
                            }
                        } else {
                            dVar.a(jSONObjectOptJSONObject);
                        }
                    }
                    dVar.a(jSONArrayOptJSONArray2, true);
                    dVar.a(jSONArrayOptJSONArray);
                }
                return;
            }
            java.util.Iterator it3 = this.b.iterator();
            while (it3.hasNext()) {
                io.dcloud.p.c0.c cVar3 = (io.dcloud.p.c0.c) it3.next();
                if (cVar3 instanceof io.dcloud.p.c0.d) {
                    io.dcloud.p.c0.d dVar2 = (io.dcloud.p.c0.d) cVar3;
                    if (!dVar2.a()) {
                        cVar3.a(-5007, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5007));
                    }
                    dVar2.a((org.json.JSONArray) null, false);
                } else {
                    cVar3.a(-5007, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5007));
                }
                it3.remove();
            }
            return;
        }
        java.util.Iterator it4 = this.b.iterator();
        while (it4.hasNext()) {
            io.dcloud.p.c0.c cVar4 = (io.dcloud.p.c0.c) it4.next();
            if (cVar4 instanceof io.dcloud.p.c0.d) {
                io.dcloud.p.c0.d dVar3 = (io.dcloud.p.c0.d) cVar4;
                if (!dVar3.a()) {
                    cVar4.a(-5007, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5007));
                }
                dVar3.a((org.json.JSONArray) null, false);
            } else {
                cVar4.a(-5007, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5007));
            }
            it4.remove();
        }
    }

    private void a(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            java.lang.String next = itKeys.next();
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            io.dcloud.p.b0 b0Var = new io.dcloud.p.b0();
            b0Var.c(next);
            if (b0Var.a(jSONObjectOptJSONObject)) {
                this.e.put(next, b0Var);
            } else {
                this.e.remove(next);
            }
        }
    }

    @Override // io.dcloud.p.t1.a
    public void a(int i, java.lang.String str) {
        int i2;
        java.lang.String str2;
        java.lang.String str3;
        this.d = new org.json.JSONObject();
        io.dcloud.p.e4.a(this.g, "uniad_config", "S_C", "");
        this.a.set(false);
        try {
            i2 = java.lang.Integer.parseInt(str);
        } catch (java.lang.Exception unused) {
            i2 = -1;
        }
        java.util.Iterator it = this.b.iterator();
        while (it.hasNext()) {
            io.dcloud.p.c0.c cVar = (io.dcloud.p.c0.c) it.next();
            if (cVar instanceof io.dcloud.p.c0.d) {
                io.dcloud.p.c0.d dVar = (io.dcloud.p.c0.d) cVar;
                if (!dVar.a()) {
                    if (i2 != -1) {
                        str3 = "http:" + str;
                    } else {
                        str3 = str;
                    }
                    cVar.a(-5007, str3);
                }
                dVar.a((org.json.JSONArray) null, false);
            } else {
                if (i2 != -1) {
                    str2 = "http:" + str;
                } else {
                    str2 = str;
                }
                cVar.a(-5007, str2);
            }
            it.remove();
        }
    }

    private void a(java.lang.String str, android.content.Context context) {
        if (context != null) {
            io.dcloud.p.e4.a(context, "uniad_config", "S_C", io.dcloud.p.s4.e(str));
        }
    }

    private boolean a(android.content.Context context, java.lang.String str) {
        try {
            context.getAssets().open(str);
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private void a(android.os.Bundle bundle, java.lang.String str, org.json.JSONObject jSONObject) {
        java.lang.String string = bundle.getString(str);
        if (android.text.TextUtils.isEmpty(string)) {
            return;
        }
        java.lang.String[] strArrSplit = string.split("_");
        if (strArrSplit.length <= 1 || android.text.TextUtils.isEmpty(strArrSplit[0]) || android.text.TextUtils.isEmpty(strArrSplit[1])) {
            return;
        }
        try {
            jSONObject.put(strArrSplit[0], strArrSplit[1]);
        } catch (org.json.JSONException unused) {
        }
    }

    public io.dcloud.p.b0 a(java.lang.String str) {
        if (io.dcloud.sdk.core.util.Const.TYPE_GM.equalsIgnoreCase(str) && !this.e.containsKey(str)) {
            str = io.dcloud.sdk.core.util.Const.TYPE_CSJ;
        }
        if (this.e.size() == 0 || android.text.TextUtils.isEmpty(str) || !this.e.containsKey(str)) {
            return null;
        }
        return (io.dcloud.p.b0) this.e.get(str);
    }

    public boolean a(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(this.f)) {
            this.f = io.dcloud.p.e4.a(context, "uniad_config", "dpap");
        }
        return "1".equals(this.f);
    }

    public java.util.Map a(java.util.Map map) {
        io.dcloud.p.b0 b0Var;
        if (this.e.isEmpty()) {
            return new io.dcloud.p.c0.a();
        }
        java.lang.String str = (java.lang.String) map.get(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT);
        if (!this.e.containsKey(str)) {
            return new io.dcloud.p.c0.b();
        }
        java.util.HashMap map2 = new java.util.HashMap();
        java.lang.String str2 = (java.lang.String) map.get("a");
        if (android.text.TextUtils.isEmpty(str2)) {
            map2.put(com.taobao.weex.ui.component.WXComponent.PROP_FS_MATCH_PARENT, java.lang.Boolean.FALSE);
            return map2;
        }
        io.dcloud.p.b0 b0Var2 = (io.dcloud.p.b0) this.e.get(str);
        boolean zD = b0Var2.d(str2);
        if (str != null && str.equalsIgnoreCase(io.dcloud.sdk.core.util.Const.TYPE_CSJ) && !zD && (b0Var = (io.dcloud.p.b0) this.e.get(io.dcloud.sdk.core.util.Const.TYPE_GM)) != null) {
            zD = b0Var.d(str2);
        }
        map2.put(com.taobao.weex.ui.component.WXComponent.PROP_FS_MATCH_PARENT, java.lang.Boolean.valueOf(zD));
        map2.put("s", b0Var2.a());
        map2.put("sh", b0Var2.f());
        return map2;
    }
}
