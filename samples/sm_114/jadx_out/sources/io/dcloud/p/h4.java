package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class h4 {
    private static io.dcloud.p.h4 d;
    android.content.Context a;
    private io.dcloud.p.p.c b;
    java.lang.String c;

    private h4(android.content.Context context, java.lang.String str) {
        this.a = context;
        this.c = str;
        if (this.b == null) {
            try {
                java.lang.String strA = a(context);
                android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(context, str);
                java.lang.String string = orCreateBundle.getString(strA, null);
                if (string != null) {
                    this.b = io.dcloud.p.p.a(string);
                } else {
                    this.b = io.dcloud.p.p.c();
                    orCreateBundle.edit().putString(strA, this.b.toString()).commit();
                }
            } catch (java.security.GeneralSecurityException unused) {
            }
        }
    }

    public static io.dcloud.p.h4 a(android.content.Context context, java.lang.String str) {
        if (d == null) {
            synchronized (io.dcloud.p.h4.class) {
                if (d == null) {
                    d = new io.dcloud.p.h4(context, str);
                }
            }
        }
        return d;
    }

    private java.lang.String c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return io.dcloud.p.p.a(str, this.b).toString();
        } catch (java.io.UnsupportedEncodingException | java.security.GeneralSecurityException unused) {
            return null;
        }
    }

    public static java.lang.String d(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-256");
            byte[] bytes = str.getBytes(java.nio.charset.StandardCharsets.UTF_8);
            messageDigest.update(bytes, 0, bytes.length);
            return android.util.Base64.encodeToString(messageDigest.digest(), 2);
        } catch (java.security.NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public void b(java.lang.String str, java.lang.String str2) {
        try {
            java.io.File dir = this.a.getDir(io.dcloud.common.util.Md5Utils.md5(this.c), 0);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            java.io.File file = new java.io.File(dir, io.dcloud.common.util.Md5Utils.md5(str));
            if (!file.exists()) {
                try {
                    dir.createNewFile();
                } catch (java.io.IOException unused) {
                }
            }
            try {
                java.io.FileWriter fileWriter = new java.io.FileWriter(file);
                java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(fileWriter);
                bufferedWriter.write(c(str2));
                bufferedWriter.flush();
                bufferedWriter.close();
                fileWriter.flush();
                fileWriter.close();
            } catch (java.io.IOException unused2) {
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private java.lang.String a(android.content.Context context) {
        return d(io.dcloud.p.p.a(context.getPackageName(), context.getPackageName().getBytes(), 1000).toString());
    }

    public boolean a(java.lang.String str) {
        return new java.io.File(this.a.getDir(io.dcloud.common.util.Md5Utils.md5(this.c), 0), io.dcloud.common.util.Md5Utils.md5(str)).exists();
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.io.File file = new java.io.File(this.a.getDir(io.dcloud.common.util.Md5Utils.md5(this.c), 0).getAbsolutePath() + "/" + io.dcloud.common.util.Md5Utils.md5(str));
        if (file.exists()) {
            try {
                return b(new java.lang.String(io.dcloud.common.adapter.io.DHFile.readAll(file)));
            } catch (java.lang.Exception unused) {
            }
        }
        return str2;
    }

    private java.lang.String b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return io.dcloud.p.p.b(new io.dcloud.p.p.a(str), this.b);
        } catch (java.io.UnsupportedEncodingException | java.security.GeneralSecurityException unused) {
            return null;
        }
    }
}
