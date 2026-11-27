package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l3 {
    public static byte[] a(java.lang.String str, java.util.HashMap map, boolean z) {
        return a(str, null, map, "GET", com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT, z);
    }

    public static byte[] a(java.lang.String str, java.util.HashMap map, boolean z, java.lang.String[] strArr) {
        return a(str, null, map, "GET", com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT, z, false, strArr);
    }

    private static byte[] a(java.lang.String str, java.lang.String str2, java.util.HashMap map, java.lang.String str3, int i, boolean z) {
        return a(str, str2, map, str3, i, z, false, null);
    }

    private static byte[] a(java.lang.String str, java.lang.String str2, java.util.HashMap map, java.lang.String str3, int i, boolean z, boolean z2, java.lang.String[] strArr) {
        if (str != null && str.length() != 0) {
            if (map == null) {
                try {
                    map = new java.util.HashMap();
                } catch (java.lang.Exception e) {
                    if (strArr != null) {
                        strArr[0] = e.getMessage();
                    }
                }
            }
            java.net.HttpURLConnection httpURLConnectionA = a(new java.net.URL(str), str3, i, z, z2);
            if (!map.isEmpty()) {
                for (java.lang.String str4 : map.keySet()) {
                    httpURLConnectionA.setRequestProperty(str4, (java.lang.String) map.get(str4));
                }
            }
            if (!android.text.TextUtils.isEmpty(str3) && android.text.TextUtils.equals(str3.toLowerCase(java.util.Locale.ENGLISH), "post")) {
                a(httpURLConnectionA.getOutputStream(), str2);
            }
            int responseCode = httpURLConnectionA.getResponseCode();
            if (responseCode == 200) {
                return a(httpURLConnectionA.getInputStream());
            }
            if (strArr != null) {
                strArr[0] = java.lang.String.valueOf(responseCode);
            }
            return null;
        }
        return null;
    }

    public static java.io.InputStream a(java.lang.String str, int i, boolean z, java.lang.String[] strArr) {
        return a(str, null, "GET", i, z, false, strArr);
    }

    private static java.io.InputStream a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, boolean z, boolean z2, java.lang.String[] strArr) {
        if (str != null && str.length() != 0) {
            try {
                java.util.HashMap map = new java.util.HashMap();
                java.net.HttpURLConnection httpURLConnectionA = a(new java.net.URL(str), str3, i, z, z2);
                if (!map.isEmpty()) {
                    for (java.lang.String str4 : map.keySet()) {
                        httpURLConnectionA.setRequestProperty(str4, (java.lang.String) map.get(str4));
                    }
                }
                if (!android.text.TextUtils.isEmpty(str3) && android.text.TextUtils.equals(str3.toLowerCase(java.util.Locale.ENGLISH), "post")) {
                    a(httpURLConnectionA.getOutputStream(), str2);
                }
                int responseCode = httpURLConnectionA.getResponseCode();
                if (responseCode == 200) {
                    return httpURLConnectionA.getInputStream();
                }
                if (strArr != null) {
                    strArr[0] = java.lang.String.valueOf(responseCode);
                }
                return null;
            } catch (java.lang.Exception e) {
                if (strArr != null) {
                    strArr[0] = e.getMessage();
                }
            }
        }
        return null;
    }

    private static void a(java.io.OutputStream outputStream, java.lang.String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    outputStream.write(str.getBytes("UTF-8"));
                }
            } catch (java.io.IOException unused) {
            }
        }
    }

    private static byte[] a(java.io.InputStream inputStream) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            int i = 10240;
            int iMin = java.lang.Math.min(10240, inputStream.available());
            if (iMin > 0) {
                i = iMin;
            }
            byte[] bArr = new byte[i];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
            inputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static java.net.HttpURLConnection a(java.net.URL url, java.lang.String str, int i, boolean z, boolean z2) {
        java.net.HttpURLConnection httpURLConnection;
        try {
            if (io.dcloud.p.w0.a) {
                httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
            } else {
                httpURLConnection = (java.net.HttpURLConnection) url.openConnection(java.net.Proxy.NO_PROXY);
            }
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i);
            httpURLConnection.setRequestMethod(str);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(java.lang.String str, java.lang.String str2, java.util.HashMap map) {
        return a(str, str2, map, "POST", com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT, true);
    }

    public static byte[] a(java.lang.String str, java.lang.String str2, java.util.HashMap map, java.lang.String[] strArr) {
        return a(str, str2, map, "POST", com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT, true, false, strArr);
    }
}
