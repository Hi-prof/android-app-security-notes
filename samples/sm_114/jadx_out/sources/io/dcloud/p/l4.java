package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class l4 {
    private static int a = 1;
    private static io.dcloud.p.x0 b;
    private static android.content.SharedPreferences c;
    private static io.dcloud.p.l4 d;
    private static java.util.Map e = new java.util.concurrent.ConcurrentHashMap();

    l4() {
    }

    private io.dcloud.p.x0 a(android.content.Context context) {
        if (b == null) {
            synchronized (io.dcloud.p.l4.class) {
                if (b == null) {
                    try {
                        b = io.dcloud.p.x0.a(new java.io.File(context.getFilesDir(), "dcloudcache"), a, 1, 10240L);
                    } catch (java.io.IOException unused) {
                    }
                }
            }
        }
        return b;
    }

    private static void c(android.content.Context context) {
        if (c == null) {
            synchronized (io.dcloud.p.l4.class) {
                if (c == null) {
                    c = context.getSharedPreferences("dcloudcache", 0);
                }
            }
        }
    }

    public java.util.Map b(android.content.Context context) {
        c(context);
        java.util.Map<java.lang.String, ?> all = c.getAll();
        if (all != null) {
            for (java.lang.String str : all.keySet()) {
                if (!android.text.TextUtils.isEmpty(str) && !e.containsKey(str)) {
                    io.dcloud.sdk.base.entry.a aVar = new io.dcloud.sdk.base.entry.a(str);
                    aVar.a((java.lang.String) all.get(str));
                    e.put(str, aVar);
                }
            }
        }
        return e;
    }

    public static io.dcloud.p.l4 a() {
        if (d == null) {
            synchronized (io.dcloud.p.l4.class) {
                if (d == null) {
                    d = new io.dcloud.p.l4();
                    e.clear();
                }
            }
        }
        return d;
    }

    public void b(android.content.Context context, java.lang.String str) {
        e.remove(str);
        c(context);
        android.content.SharedPreferences.Editor editorEdit = c.edit();
        editorEdit.remove(str);
        editorEdit.apply();
        try {
            a(context).d(str);
        } catch (java.io.IOException unused) {
        }
    }

    private void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        c(context);
        android.content.SharedPreferences.Editor editorEdit = c.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public void a(android.content.Context context, io.dcloud.sdk.base.entry.AdData adData, java.lang.String str) {
        io.dcloud.sdk.base.entry.a aVar = new io.dcloud.sdk.base.entry.a(adData.k());
        aVar.a(adData.h());
        aVar.a(adData);
        e.put(adData.k(), aVar);
        try {
            a(context, adData.k(), adData.h());
            io.dcloud.p.x0.c cVarA = a(context).a(adData.k());
            java.io.OutputStream outputStreamA = cVarA.a(0);
            outputStreamA.write(str.getBytes());
            outputStreamA.close();
            cVarA.b();
            a(context).flush();
        } catch (java.lang.Exception unused) {
        }
    }

    public java.lang.String a(android.content.Context context, java.lang.String str) {
        try {
            return a(context).b(str).getString(0);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
