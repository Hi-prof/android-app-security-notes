package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NetTool {
    private static final int DEFAULT_TIME_OUT_TIMES = 5000;
    private static java.lang.String TAG = "NetTool";
    static javax.net.ssl.HostnameVerifier sCustomeHostnameVerifier;

    public static java.net.HttpURLConnection createConnection(java.net.URL url, java.lang.String str, int i, boolean z, boolean z2) {
        try {
            if (io.dcloud.common.util.BaseInfo.isUniStatistics) {
                z2 = false;
            }
            java.net.HttpURLConnection httpURLConnection = (!z2 || io.dcloud.common.adapter.io.DHFile.hasFile()) ? (java.net.HttpURLConnection) url.openConnection() : (java.net.HttpURLConnection) url.openConnection(java.net.Proxy.NO_PROXY);
            if ((httpURLConnection instanceof javax.net.ssl.HttpsURLConnection) && z) {
                try {
                    javax.net.ssl.SSLSocketFactory sSLSocketFactory = io.dcloud.common.adapter.util.DCloudTrustManager.getSSLSocketFactory();
                    if (sSLSocketFactory != null) {
                        ((javax.net.ssl.HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                    }
                    ((javax.net.ssl.HttpsURLConnection) httpURLConnection).setHostnameVerifier(getDefaultHostnameVerifier());
                } catch (java.lang.Exception e) {
                    throw new java.lang.RuntimeException(e);
                }
            }
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i);
            httpURLConnection.setRequestMethod(str);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static javax.net.ssl.HostnameVerifier getDefaultHostnameVerifier() {
        javax.net.ssl.HostnameVerifier hostnameVerifier = sCustomeHostnameVerifier;
        return hostnameVerifier != null ? hostnameVerifier : io.dcloud.common.adapter.util.DCloudTrustManager.getHostnameVerifier(true);
    }

    public static byte[] httpGet(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map) throws java.lang.Exception {
        return request(str, null, map, "GET", 5000, true);
    }

    public static byte[] httpGetThrows(java.lang.String str) throws java.lang.Exception {
        return httpGet(str, (java.util.HashMap<java.lang.String, java.lang.String>) null);
    }

    public static byte[] httpPost(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map) {
        return request(str, str2, map, "POST", 5000, true);
    }

    public static boolean isNetworkAvailable(android.content.Context context) {
        android.net.NetworkInfo[] allNetworkInfo;
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
            for (int i = 0; i < allNetworkInfo.length; i++) {
                if (allNetworkInfo[i].getState() == android.net.NetworkInfo.State.CONNECTED || allNetworkInfo[i].getState() == android.net.NetworkInfo.State.CONNECTING) {
                    return true;
                }
            }
        }
        return false;
    }

    private static byte[] read(java.io.InputStream inputStream) {
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

    private static byte[] request(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map, java.lang.String str3, int i, boolean z) {
        return request(str, str2, map, str3, i, z, false, null);
    }

    private static void write(java.io.OutputStream outputStream, java.lang.String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    outputStream.write(str.getBytes("UTF-8"));
                }
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static byte[] httpGet(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map, boolean z) throws java.lang.Exception {
        return request(str, null, map, "GET", 5000, z);
    }

    public static byte[] httpGetThrows(java.lang.String str, boolean z) throws java.lang.Exception {
        return httpGet(str, (java.util.HashMap<java.lang.String, java.lang.String>) null, z);
    }

    public static byte[] httpPost(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map, boolean z) {
        return request(str, str2, map, "POST", 5000, z);
    }

    private static byte[] request(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map, java.lang.String str3, int i, boolean z, boolean z2) {
        return request(str, str2, map, str3, i, z, z2, null);
    }

    public static byte[] httpGet(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map, int i) throws java.lang.Exception {
        return request(str, null, map, "GET", i, true);
    }

    public static byte[] httpPost(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map, boolean z, boolean z2) {
        return request(str, str2, map, "POST", 5000, z, z2);
    }

    private static byte[] request(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map, java.lang.String str3, int i, boolean z, boolean z2, java.lang.String[] strArr) {
        if (str != null && str.length() != 0) {
            try {
                java.net.HttpURLConnection httpURLConnectionCreateConnection = createConnection(new java.net.URL(str), str3, i, z, z2);
                if (map != null && !map.isEmpty()) {
                    for (java.lang.String str4 : map.keySet()) {
                        httpURLConnectionCreateConnection.setRequestProperty(str4, map.get(str4));
                    }
                }
                if (!android.text.TextUtils.isEmpty(str3) && android.text.TextUtils.equals(str3.toLowerCase(java.util.Locale.ENGLISH), "post")) {
                    write(httpURLConnectionCreateConnection.getOutputStream(), str2);
                }
                int responseCode = httpURLConnectionCreateConnection.getResponseCode();
                if (responseCode != 200) {
                    io.dcloud.common.adapter.util.Logger.p(TAG, "httpGet fail, status code = " + responseCode);
                    if (strArr != null) {
                        strArr[0] = java.lang.String.valueOf(responseCode);
                    }
                    return null;
                }
                return read(httpURLConnectionCreateConnection.getInputStream());
            } catch (java.lang.Exception e) {
                io.dcloud.common.adapter.util.Logger.p(TAG, "httpPost exception, e = " + e.getMessage());
                if (strArr != null) {
                    strArr[0] = e.getMessage();
                }
                return null;
            }
        }
        io.dcloud.common.adapter.util.Logger.p(TAG, "httpPost, url is null");
        return null;
    }

    public static byte[] httpGet(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map, int i, boolean z) throws java.lang.Exception {
        return request(str, null, map, "GET", i, z);
    }

    public static byte[] httpPost(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map, boolean z, java.lang.String[] strArr) {
        return request(str, str2, map, "POST", 5000, z, false, strArr);
    }

    public static byte[] httpGet(java.lang.String str) {
        return httpGet(str, true);
    }

    public static byte[] httpPost(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map, boolean z, boolean z2, java.lang.String[] strArr) {
        return request(str, str2, map, "POST", 5000, z, z2, strArr);
    }

    public static byte[] httpGet(java.lang.String str, boolean z) {
        try {
            return httpGet(str, (java.util.HashMap<java.lang.String, java.lang.String>) null, z);
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.p(TAG, "httpGet exception, e = " + e.getMessage());
            return null;
        }
    }

    public static byte[] httpPost(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map, int i) {
        return request(str, str2, map, "POST", i, true);
    }

    public static byte[] httpPost(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map, int i, boolean z) {
        return request(str, str2, map, "POST", i, z);
    }

    public static byte[] httpGet(java.lang.String str, int i) {
        return httpGet(str, i, true);
    }

    public static byte[] httpGet(java.lang.String str, int i, boolean z) {
        try {
            return httpGet(str, null, i, z);
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.p(TAG, "httpGet exception, e = " + e.getMessage());
            return null;
        }
    }
}
