package io.dcloud.sdk.base.entry;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private long a;
    private java.lang.String b;
    private io.dcloud.sdk.base.entry.AdData c;

    public a(java.lang.String str) {
        this.b = str;
    }

    public void a(java.lang.String str) {
        try {
            java.util.Date date = new java.text.SimpleDateFormat("yy-MM-dd HH:mm:ss", java.util.Locale.ENGLISH).parse(new org.json.JSONObject(str).optString("expires"));
            if (date != null) {
                this.a = date.getTime();
            }
        } catch (java.text.ParseException | org.json.JSONException unused) {
        }
    }

    public boolean b() {
        return java.lang.System.currentTimeMillis() > this.a;
    }

    public void a(android.content.Context context, io.dcloud.sdk.base.entry.AdData adData) {
        if (adData != null) {
            adData.c(context);
            java.lang.String strA = io.dcloud.p.l4.a().a(context, this.b);
            if (strA != null) {
                try {
                    adData.a(new org.json.JSONObject(strA), null, false);
                } catch (org.json.JSONException unused) {
                }
            }
        }
    }

    public void a(io.dcloud.sdk.base.entry.AdData adData) {
        this.c = adData;
    }

    public java.lang.String a() {
        return this.b;
    }
}
