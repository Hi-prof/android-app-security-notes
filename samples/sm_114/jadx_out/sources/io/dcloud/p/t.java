package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class t {
    private static boolean a(android.content.Context context, java.lang.String str) {
        if (io.dcloud.p.c4.b() && !io.dcloud.common.util.PdrUtil.isEmpty(io.dcloud.p.c4.a())) {
            try {
                org.json.JSONArray jSONArray = new org.json.JSONObject(new java.lang.String(a(io.dcloud.common.util.Base64.decode2bytes(io.dcloud.p.c4.a()), a(io.dcloud.p.e1.d())))).getJSONArray("appkeys");
                java.lang.String strB = b(context, str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    java.lang.String string = jSONArray.getString(i);
                    if (!io.dcloud.common.util.PdrUtil.isEmpty(string) && io.dcloud.common.util.PdrUtil.isEquals(string, strB)) {
                        return true;
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private static java.lang.String b(android.content.Context context, java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            str = a();
        }
        return io.dcloud.common.util.Md5Utils.md5((str + a(context)) + b(context) + io.dcloud.p.e1.a(io.dcloud.p.e1.a(), true, 60));
    }

    public static boolean c(android.content.Context context) {
        return (io.dcloud.p.c4.b() && a(context, (java.lang.String) null)) ? false : true;
    }

    public static boolean d(android.content.Context context, java.lang.String str) {
        return (io.dcloud.p.c4.b() && a(context, str)) ? false : true;
    }

    public static boolean c(android.content.Context context, java.lang.String str) {
        return a(context, str);
    }

    private static java.lang.String b(android.content.Context context) {
        return io.dcloud.common.util.LoadAppUtils.getAppSignatureSHA1(context);
    }

    private static java.lang.String a(android.content.Context context) {
        return context.getPackageName().toLowerCase(java.util.Locale.ENGLISH);
    }

    private static java.lang.String a() {
        return io.dcloud.common.util.BaseInfo.sDefaultBootApp;
    }

    private static java.security.Key a(java.lang.String str) {
        try {
            return java.security.KeyFactory.getInstance(io.dcloud.p.e1.a("WltJ")).generatePublic(new java.security.spec.X509EncodedKeySpec(io.dcloud.common.util.Base64.decode2bytes(str)));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static byte[] a(byte[] bArr, java.security.Key key) {
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(io.dcloud.p.e1.a("WltJJ01LSidYQ0tbOVhpbGxhZm8="));
            cipher.init(2, key);
            int blockSize = cipher.getBlockSize();
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(bArr.length);
            int i = 0;
            while (true) {
                int i2 = i * blockSize;
                if (bArr.length - i2 > 0) {
                    byteArrayOutputStream.write(cipher.doFinal(bArr, i2, blockSize));
                    i++;
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
