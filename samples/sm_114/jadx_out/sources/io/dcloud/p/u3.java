package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class u3 extends io.dcloud.p.w {
    io.dcloud.p.t1.a[] a;
    android.content.Context b;
    boolean c = false;
    org.json.JSONObject d = new org.json.JSONObject();

    public u3() {
        if (io.dcloud.common.adapter.io.DHFile.hasFile()) {
            io.dcloud.p.w0.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(android.content.Context context) {
        io.dcloud.feature.gg.dcloud.ADHandler.pull(context, io.dcloud.p.r0.d().b().getAppId());
    }

    @Override // io.dcloud.p.h3, io.dcloud.p.t1
    public void a(final android.content.Context context, int i, io.dcloud.p.t1.a... aVarArr) {
        this.c = true;
        if (i != 1) {
            io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.u3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    io.dcloud.p.u3.c(context);
                }
            });
        } else {
            this.a = aVarArr;
            this.b = context;
        }
    }

    public java.util.HashMap b(android.content.Context context) {
        return io.dcloud.p.x3.a(context);
    }

    public void a(org.json.JSONObject jSONObject) {
        java.lang.String[] strArr;
        android.content.Context context;
        org.json.JSONArray jSONArrayNames = jSONObject.names();
        io.dcloud.p.p0 p0Var = null;
        if (jSONArrayNames != null) {
            strArr = new java.lang.String[jSONArrayNames.length()];
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                strArr[i] = jSONArrayNames.optString(i);
            }
        } else {
            strArr = null;
        }
        if (strArr != null) {
            try {
                p0Var = new io.dcloud.p.p0(jSONObject, strArr);
            } catch (org.json.JSONException unused) {
            }
        }
        if (p0Var != null && p0Var.has("7C61656D") && (context = this.b) != null) {
            a(p0Var, context);
        }
        io.dcloud.p.t1.a[] aVarArr = this.a;
        if (aVarArr != null) {
            for (io.dcloud.p.t1.a aVar : aVarArr) {
                if (p0Var == null) {
                    aVar.a(-5007, "数据解析异常");
                } else {
                    aVar.a(p0Var);
                }
            }
        }
    }

    public void a(int i, java.lang.String str) {
        io.dcloud.p.t1.a[] aVarArr = this.a;
        if (aVarArr != null) {
            for (io.dcloud.p.t1.a aVar : aVarArr) {
                aVar.a(i, str);
            }
        }
    }
}
