package io.dcloud.feature.weex.config;

/* JADX INFO: loaded from: classes2.dex */
public class UserCustomTrustManager {
    private static java.util.HashMap<io.dcloud.feature.weex.config.AndroidTlsConfig, javax.net.ssl.SSLSocketFactory> cacheSSLFactory = new java.util.HashMap<>();
    private static java.util.HashMap<com.taobao.weex.http.CertDTO, javax.net.ssl.SSLSocketFactory> cacheCertSSLFactory = new java.util.HashMap<>();

    public static javax.net.ssl.SSLSocketFactory getSSLSocketFactory(io.dcloud.feature.weex.config.AndroidTlsConfig androidTlsConfig, com.taobao.weex.WXSDKInstance wXSDKInstance) {
        javax.net.ssl.SSLSocketFactory sSLSocketFactory;
        if (androidTlsConfig == null) {
            return null;
        }
        if (cacheSSLFactory.containsKey(androidTlsConfig) && (sSLSocketFactory = cacheSSLFactory.get(androidTlsConfig)) != null) {
            return sSLSocketFactory;
        }
        if (wXSDKInstance == null) {
            return null;
        }
        try {
            javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("PKCS12");
            javax.net.ssl.KeyManagerFactory keyManagerFactory = javax.net.ssl.KeyManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());
            if ((!android.text.TextUtils.isEmpty(androidTlsConfig.getKeystore())) && (!android.text.TextUtils.isEmpty(androidTlsConfig.getStorePass()))) {
                io.dcloud.feature.weex.config.MimeInfoParser.MimeInfo mimeInfoObtainMimeInfo = io.dcloud.feature.weex.config.MimeInfoParser.getInstance().obtainMimeInfo(androidTlsConfig.getKeystore());
                if (mimeInfoObtainMimeInfo == null) {
                    return null;
                }
                keyStore.load(mimeInfoObtainMimeInfo.getDataBytes(wXSDKInstance), androidTlsConfig.getStorePass().toCharArray());
                keyManagerFactory.init(keyStore, androidTlsConfig.getStorePass().toCharArray());
            } else {
                keyManagerFactory = null;
            }
            java.security.cert.CertificateFactory certificateFactory = java.security.cert.CertificateFactory.getInstance("X.509");
            java.security.KeyStore keyStore2 = java.security.KeyStore.getInstance("PKCS12");
            for (int i = 0; i < androidTlsConfig.getCa().length; i++) {
                io.dcloud.feature.weex.config.MimeInfoParser.MimeInfo mimeInfoObtainMimeInfo2 = io.dcloud.feature.weex.config.MimeInfoParser.getInstance().obtainMimeInfo(androidTlsConfig.getCa()[i]);
                if (mimeInfoObtainMimeInfo2 != null) {
                    java.io.InputStream dataBytes = mimeInfoObtainMimeInfo2.getDataBytes(wXSDKInstance);
                    keyStore2.load(null);
                    keyStore2.setCertificateEntry(java.lang.Integer.toString(i), certificateFactory.generateCertificate(dataBytes));
                }
            }
            javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore2);
            if (keyManagerFactory == null) {
                sSLContext.init(null, trustManagerFactory.getTrustManagers(), new java.security.SecureRandom());
            } else {
                sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new java.security.SecureRandom());
            }
            javax.net.ssl.SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            if (cacheSSLFactory.size() > 3) {
                cacheSSLFactory.clear();
            }
            cacheSSLFactory.put(androidTlsConfig, socketFactory);
            return socketFactory;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        } catch (java.security.KeyManagementException e2) {
            e2.printStackTrace();
            return null;
        } catch (java.security.KeyStoreException e3) {
            e3.printStackTrace();
            return null;
        } catch (java.security.NoSuchAlgorithmException e4) {
            e4.printStackTrace();
            return null;
        } catch (java.security.UnrecoverableKeyException e5) {
            e5.printStackTrace();
            return null;
        } catch (java.security.cert.CertificateException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static javax.net.ssl.SSLSocketFactory getSSLSocketFactory(com.taobao.weex.http.CertDTO certDTO, com.taobao.weex.WXSDKInstance wXSDKInstance) {
        java.io.InputStream filePathStream;
        java.io.InputStream filePathStream2;
        javax.net.ssl.SSLSocketFactory sSLSocketFactory;
        if (certDTO == null) {
            return null;
        }
        if (cacheCertSSLFactory.containsKey(certDTO) && (sSLSocketFactory = cacheCertSSLFactory.get(certDTO)) != null) {
            return sSLSocketFactory;
        }
        if (wXSDKInstance == null) {
            return null;
        }
        try {
            javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
            java.security.KeyStore keyStore = java.security.KeyStore.getInstance("PKCS12");
            javax.net.ssl.KeyManagerFactory keyManagerFactory = javax.net.ssl.KeyManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());
            if ((!android.text.TextUtils.isEmpty(certDTO.client)) && (!android.text.TextUtils.isEmpty(certDTO.clientPassword))) {
                io.dcloud.feature.weex.config.MimeInfoParser.MimeInfo mimeInfoObtainMimeInfo = io.dcloud.feature.weex.config.MimeInfoParser.getInstance().obtainMimeInfo(certDTO.client);
                if (mimeInfoObtainMimeInfo != null) {
                    filePathStream2 = mimeInfoObtainMimeInfo.getDataBytes(wXSDKInstance);
                } else {
                    filePathStream2 = io.dcloud.feature.weex.config.MimeInfoParser.getFilePathStream(wXSDKInstance, certDTO.client);
                }
                if (filePathStream2 != null) {
                    keyStore.load(filePathStream2, certDTO.getClientPassword().toCharArray());
                    keyManagerFactory.init(keyStore, certDTO.getClientPassword().toCharArray());
                }
            } else {
                keyManagerFactory = null;
            }
            java.security.cert.CertificateFactory certificateFactory = java.security.cert.CertificateFactory.getInstance("X.509");
            java.security.KeyStore keyStore2 = java.security.KeyStore.getInstance("PKCS12");
            for (int i = 0; i < certDTO.getServer().length; i++) {
                io.dcloud.feature.weex.config.MimeInfoParser.MimeInfo mimeInfoObtainMimeInfo2 = io.dcloud.feature.weex.config.MimeInfoParser.getInstance().obtainMimeInfo(certDTO.getServer()[i]);
                if (mimeInfoObtainMimeInfo2 != null) {
                    filePathStream = mimeInfoObtainMimeInfo2.getDataBytes(wXSDKInstance);
                } else {
                    filePathStream = io.dcloud.feature.weex.config.MimeInfoParser.getFilePathStream(wXSDKInstance, certDTO.getServer()[i]);
                }
                if (filePathStream != null) {
                    keyStore2.load(null);
                    keyStore2.setCertificateEntry(java.lang.Integer.toString(i), certificateFactory.generateCertificate(filePathStream));
                }
            }
            javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore2);
            if (keyManagerFactory == null) {
                sSLContext.init(null, trustManagerFactory.getTrustManagers(), new java.security.SecureRandom());
            } else {
                sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new java.security.SecureRandom());
            }
            javax.net.ssl.SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            if (cacheCertSSLFactory.size() > 3) {
                cacheCertSSLFactory.clear();
            }
            cacheCertSSLFactory.put(certDTO, socketFactory);
            return socketFactory;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        } catch (java.security.KeyManagementException e2) {
            e2.printStackTrace();
            return null;
        } catch (java.security.KeyStoreException e3) {
            e3.printStackTrace();
            return null;
        } catch (java.security.NoSuchAlgorithmException e4) {
            e4.printStackTrace();
            return null;
        } catch (java.security.UnrecoverableKeyException e5) {
            e5.printStackTrace();
            return null;
        } catch (java.security.cert.CertificateException e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
