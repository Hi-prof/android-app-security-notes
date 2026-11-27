package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DCloudTrustManager {
    private DCloudTrustManager() {
    }

    public static java.security.SecureRandom createSecureRandom() {
        return new java.security.SecureRandom();
    }

    public static org.apache.http.conn.ssl.X509HostnameVerifier getHostnameVerifier(boolean z) {
        return (z || !(io.dcloud.common.util.PdrUtil.isEquals(io.dcloud.common.util.BaseInfo.untrustedca, "refuse") || io.dcloud.common.util.PdrUtil.isEquals(io.dcloud.common.util.BaseInfo.untrustedca, "warning"))) ? org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER : org.apache.http.conn.ssl.SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
    }

    private static javax.net.ssl.SSLContext getSSLSocketContext(java.lang.String str) {
        if (!io.dcloud.common.util.PdrUtil.isEquals(str, "TLSv1") || io.dcloud.common.adapter.util.AndroidResources.sAppTargetSdkVersion < 36) {
            try {
                return javax.net.ssl.SSLContext.getInstance(str);
            } catch (java.security.NoSuchAlgorithmException unused) {
            }
        }
        try {
            try {
                return javax.net.ssl.SSLContext.getInstance("TLSv1.2");
            } catch (java.security.NoSuchAlgorithmException e) {
                throw new java.lang.IllegalStateException("No TLS provider", e);
            }
        } catch (java.security.NoSuchAlgorithmException unused2) {
            return javax.net.ssl.SSLContext.getInstance("TLS");
        }
    }

    public static javax.net.ssl.SSLSocketFactory getSSLSocketFactory() throws java.security.NoSuchAlgorithmException, java.security.KeyManagementException {
        return getSSLSocketFactory(getSSLVersion());
    }

    private static java.lang.String getSSLVersion() {
        return io.dcloud.common.adapter.util.AndroidResources.sAppTargetSdkVersion >= 36 ? "TLSv1.2" : "TLSv1";
    }

    public static javax.net.ssl.SSLSocketFactory getSSLSocketFactory(java.lang.String str) throws java.security.NoSuchAlgorithmException, java.security.KeyManagementException {
        java.lang.Object objNewInstance;
        if (io.dcloud.application.DCLoudApplicationImpl.self().getContext() != null) {
            java.lang.String str2 = io.dcloud.application.DCLoudApplicationImpl.self().getContext().getPackageName() + ".CustomTrustMgr";
            if (io.dcloud.common.adapter.util.PlatformUtil.checkClass(str2) && (objNewInstance = io.dcloud.common.adapter.util.PlatformUtil.newInstance(str2, null, null)) != null) {
                if (android.text.TextUtils.isEmpty(str)) {
                    str = getSSLVersion();
                }
                javax.net.ssl.SSLContext sSLSocketContext = getSSLSocketContext(str);
                sSLSocketContext.init(null, new javax.net.ssl.TrustManager[]{(javax.net.ssl.TrustManager) objNewInstance}, createSecureRandom());
                return sSLSocketContext.getSocketFactory();
            }
        }
        return null;
    }
}
