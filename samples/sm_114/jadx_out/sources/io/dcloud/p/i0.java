package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class i0 implements io.dcloud.common.DHInterface.IConfusionMgr {
    private static java.lang.String e;
    private static java.lang.String f;
    private static java.lang.String g;
    private static java.lang.String h;
    private static java.lang.String i;
    private static java.lang.String j;
    private static io.dcloud.common.DHInterface.IConfusionMgr k;
    private io.dcloud.common.DHInterface.DCI b;
    private int a = 3;
    final java.lang.String c = "##";
    private boolean d = false;

    private i0() {
        java.lang.Object objInvokeMethod = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(decodeString(b(), true, this.a), "getInstance", null);
        if (objInvokeMethod == null || !(objInvokeMethod instanceof io.dcloud.common.DHInterface.DCI)) {
            return;
        }
        this.b = (io.dcloud.common.DHInterface.DCI) objInvokeMethod;
    }

    private java.lang.String a(java.lang.String str) throws java.io.UnsupportedEncodingException {
        byte[] bytes = str.getBytes("GBK");
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bytes[i2] = (byte) (bytes[i2] ^ 8);
        }
        return new java.lang.String(bytes, "GBK");
    }

    private java.lang.String b() {
        return "amwtZ2BvbHZnLWBsbm5sbS1gcC1HTyo2YTNkODhmYS00YmEwLTQ3OWYtOTQyMi1lNWFhYmUxNTg5N2I2Nw==";
    }

    public static io.dcloud.common.DHInterface.IConfusionMgr c() {
        if (k == null) {
            k = new io.dcloud.p.i0();
        }
        return k;
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.lang.String decodeString(java.lang.String str) {
        try {
            return a(new java.lang.String(android.util.Base64.decode(str, 2)));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.lang.String decryptStr(java.lang.String str) {
        try {
            return a(str);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.lang.String encodeString(java.lang.String str, boolean z, int i2) {
        if (!z) {
            return str;
        }
        try {
            if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
                return str;
            }
            byte[] bytes = str.getBytes("utf-8");
            for (int i3 = 0; i3 < bytes.length; i3++) {
                bytes[i3] = (byte) (bytes[i3] ^ i2);
            }
            return "##" + android.util.Base64.encodeToString((android.util.Base64.encodeToString(bytes, 2) + "*6a3d88fa-4ba0-479f-9422-e5aabe15897b" + (i2 + 64)).getBytes(), 2);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.lang.String getCSJClassName() {
        if (android.text.TextUtils.isEmpty(i)) {
            try {
                i = a("kge&jq|mlifkm&{lc&gxmfil{lc&\\\\Il[lc");
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return i;
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.util.Map getData(java.lang.String str) {
        java.lang.Object objInvokeMethod = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(decodeString(a(), true, this.a), "getData", null, new java.lang.Class[]{java.lang.String.class}, new java.lang.Object[]{str});
        if (objInvokeMethod == null || !(objInvokeMethod instanceof java.util.Map)) {
            return null;
        }
        return (java.util.Map) objInvokeMethod;
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.io.InputStream getEncryptionInputStream(java.lang.String str, io.dcloud.common.DHInterface.IApp iApp) {
        byte[] bArrLf;
        java.lang.Object objInvokeMethod;
        java.io.File file = null;
        if (android.text.TextUtils.isEmpty(str) || iApp == null || android.webkit.URLUtil.isNetworkUrl(str)) {
            return null;
        }
        java.io.InputStream fileInputStream = (java.lang.Boolean.parseBoolean(iApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_USE_V3_ENCRYPTION)) || (objInvokeMethod = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(decodeString(a(), true, this.a), decodeString("b218TWZrenF4fGFnZkFmeH18W3x6bWll"), null, new java.lang.Class[]{java.lang.String.class, io.dcloud.common.DHInterface.IApp.class}, new java.lang.Object[]{str, iApp})) == null || !(objInvokeMethod instanceof java.io.InputStream)) ? null : (java.io.InputStream) objInvokeMethod;
        if (fileInputStream != null) {
            return fileInputStream;
        }
        boolean z = iApp.obtainRunningAppMode() == 1;
        if (str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
            try {
                android.net.Uri uri = android.net.Uri.parse(str);
                if (uri != null) {
                    file = new java.io.File(uri.getPath());
                }
            } catch (java.lang.Exception unused) {
            }
        } else {
            file = new java.io.File(str);
        }
        if (file == null && !z) {
            return fileInputStream;
        }
        try {
            if (z) {
                fileInputStream = io.dcloud.common.adapter.util.PlatformUtil.getInputStream(str, 0);
            } else if (file != null && file.exists()) {
                fileInputStream = io.dcloud.common.util.FileUtil.getFileInputStream(iApp.getActivity(), file);
            }
            return (fileInputStream == null || !isV3Encryption() || !this.b.cf(iApp.obtainAppId(), str) || (bArrLf = this.b.lf(iApp.obtainAppId(), str, io.dcloud.common.util.IOUtil.getBytes(fileInputStream))) == null) ? fileInputStream : io.dcloud.common.util.IOUtil.byte2InputStream(bArrLf);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return fileInputStream;
        }
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.lang.String getGDTClassName() {
        if (android.text.TextUtils.isEmpty(h)) {
            try {
                h = a("kge&yy&m&il{&{xdi{`&[xdi{`IL");
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return h;
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.lang.String getKSClassName() {
        if (android.text.TextUtils.isEmpty(j)) {
            try {
                j = a("kge&c\u007fil&{lc&ixa&C{Il[LC");
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return j;
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.lang.String getODS() {
        return "##V2hOMGMzNUZaM0pYU25kQ1p4Ri9VMTRUZFdkZlFsaGRGR1ZVV0d4d1UwSjhmM1ZCUUVwallYUllVV0p6ZFhaQmR4aGdVWGgyZjF0SGZHc1JVV2hBVXc9PSo2YTNkODhmYS00YmEwLTQ3OWYtOTQyMi1lNWFhYmUxNTg5N2IxMTQ=";
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.lang.String getS5DS() {
        return "UWV/BnpHVVhMahB0EU1XA15hAEFOAWlGVHBkcgluSF0HFhlQZx15Yhhjb3xCHgRfWxV+cQhPS1ICFxRzdkUfeyo2YTNkODhmYS00YmEwLTQ3OWYtOTQyMi1lNWFhYmUxNTg5N2IxMjQ=";
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.lang.String getSIV() {
        if (android.text.TextUtils.isEmpty(f)) {
            try {
                f = a("@\\ED=XD][Z]F\\AEM");
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return f;
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.lang.String getSK() {
        if (android.text.TextUtils.isEmpty(e)) {
            try {
                e = a("LKdg}l.:\"8V9+>88");
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return e;
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.lang.String getSPK() {
        return "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw4a5Rcq2ZWsKUogf5rc6Q+RqEZiFS6hq6FmNd5q6ZVwIRedk7HV5B6c7WCvLcEYhEe+dnF4XqhCiZe31nvp4FpmEvIDJrzh20qEwHAGcEUijF+0iXOWOskLpDqtXuk/anskpyJ/KstPbreHKVSE4DHqxgGf0ZUn7Z4BZynIGfAK/zizsIcRQwFccBHIsgi0AT+HBdXnxGWBK9LbeSnCzotqLTPEBrV9LhZsUGcY4B+HB1qTOS1PF2sv+/UDvmgWtM9PX3FrzuB8uy8gR+vf0XYJadaL6x0NlRRcIpE5R84oWuaarSfoNr3prFbh+EkYctODHmoiVIvqdfUspqRdZaQIDAQAB";
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.lang.String getSQK() {
        if (android.text.TextUtils.isEmpty(g)) {
            try {
                g = a("Y.:]\"8MV9[+>88\\?");
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return g;
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.lang.String handleEncryption(android.content.Context context, byte[] bArr) {
        java.lang.Object objInvokeMethod = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(decodeString(a(), true, this.a), decodeString("YGlmbGRtTWZrenF4fGFnZg=="), null, new java.lang.Class[]{android.content.Context.class, byte[].class}, new java.lang.Object[]{context, bArr});
        if (objInvokeMethod != null) {
            return java.lang.String.valueOf(objInvokeMethod);
        }
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public boolean isV3Encryption() {
        return this.d;
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public void recordEncryptionResources(java.lang.String str, org.json.JSONObject jSONObject) {
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(decodeString(a(), true, this.a), decodeString("em1rZ3psTWZrenF4fGFnZlpte2d9emttew=="), null, new java.lang.Class[]{java.lang.String.class, org.json.JSONObject.class}, new java.lang.Object[]{str, jSONObject});
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public boolean recordEncryptionV3Resources(java.lang.String str, java.lang.String str2) {
        if (this.b != null && !io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
            this.d = this.b.dt(str, str2.getBytes());
        }
        return this.d;
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public void removeData(java.lang.String str) {
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(decodeString(a(), true, this.a), "removeData", null, new java.lang.Class[]{java.lang.String.class}, new java.lang.Object[]{str});
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.lang.String decryptStr(java.lang.String str, byte b) {
        try {
            return a(str, b);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private java.lang.String a(java.lang.String str, byte b) throws java.io.UnsupportedEncodingException {
        byte[] bytes = str.getBytes("GBK");
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bytes[i2] = (byte) (bytes[i2] ^ b);
        }
        return new java.lang.String(bytes, "GBK");
    }

    @Override // io.dcloud.common.DHInterface.IConfusionMgr
    public java.lang.String decodeString(java.lang.String str, boolean z, int i2) {
        boolean z2;
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return str;
        }
        if (str.startsWith("##")) {
            str = str.substring(2);
            z2 = true;
        } else {
            z2 = false;
        }
        byte[] bArrDecode = android.util.Base64.decode(str, 2);
        if (z) {
            try {
                java.lang.String str2 = new java.lang.String(bArrDecode);
                if (str2.contains("*6a3d88fa-4ba0-479f-9422-e5aabe15897b")) {
                    int iIndexOf = str2.indexOf("*6a3d88fa-4ba0-479f-9422-e5aabe15897b");
                    java.lang.String strSubstring = str2.substring(0, iIndexOf);
                    if (java.lang.Integer.valueOf(str2.substring(iIndexOf + 37)).intValue() - 64 == i2) {
                        if (z2) {
                            bArrDecode = android.util.Base64.decode(strSubstring, 2);
                        } else {
                            bArrDecode = strSubstring.getBytes("utf-8");
                        }
                        for (int i3 = 0; i3 < bArrDecode.length; i3++) {
                            bArrDecode[i3] = (byte) (bArrDecode[i3] ^ i2);
                        }
                    }
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return new java.lang.String(bArrDecode, "utf-8");
    }

    private java.lang.String a() {
        return "amwtZ2BvbHZnLWVmYnd2cWYtYGUtYEVmYnd2cWZKbnNvKjZhM2Q4OGZhLTRiYTAtNDc5Zi05NDIyLWU1YWFiZTE1ODk3YjY3";
    }
}
