package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/SSLFactoryManager;", "", "<init>", "()V", "cacheSSLFactory", "Lio/dcloud/uts/Map;", "Luts/sdk/modules/DCloudUniNetwork/SSLConfig;", "Ljavax/net/ssl/SSLSocketFactory;", "getSSLSocketFactory", "sslConfig", "Companion", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class SSLFactoryManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final uts.sdk.modules.DCloudUniNetwork.SSLFactoryManager.Companion INSTANCE = new uts.sdk.modules.DCloudUniNetwork.SSLFactoryManager.Companion(null);
    private static uts.sdk.modules.DCloudUniNetwork.SSLFactoryManager instance;
    private io.dcloud.uts.Map<uts.sdk.modules.DCloudUniNetwork.SSLConfig, javax.net.ssl.SSLSocketFactory> cacheSSLFactory = new io.dcloud.uts.Map<>();

    public javax.net.ssl.SSLSocketFactory getSSLSocketFactory(uts.sdk.modules.DCloudUniNetwork.SSLConfig sslConfig) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sslConfig, "sslConfig");
        if (this.cacheSSLFactory.has(sslConfig)) {
            return this.cacheSSLFactory.get(sslConfig);
        }
        try {
            javax.net.ssl.SSLContext.getInstance("TLS");
            java.security.KeyStore.getInstance("PKCS12");
            javax.net.ssl.KeyManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());
            if (!android.text.TextUtils.isEmpty(sslConfig.getKeystore())) {
                android.text.TextUtils.isEmpty(sslConfig.getStorePass());
            }
            java.security.cert.CertificateFactory.getInstance("X.509");
            java.security.KeyStore.getInstance("PKCS12");
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    /* JADX INFO: compiled from: index.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/SSLFactoryManager$Companion;", "", "<init>", "()V", "instance", "Luts/sdk/modules/DCloudUniNetwork/SSLFactoryManager;", "getInstance", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final uts.sdk.modules.DCloudUniNetwork.SSLFactoryManager getInstance() {
            if (uts.sdk.modules.DCloudUniNetwork.SSLFactoryManager.instance == null) {
                uts.sdk.modules.DCloudUniNetwork.SSLFactoryManager.instance = new uts.sdk.modules.DCloudUniNetwork.SSLFactoryManager();
            }
            uts.sdk.modules.DCloudUniNetwork.SSLFactoryManager sSLFactoryManager = uts.sdk.modules.DCloudUniNetwork.SSLFactoryManager.instance;
            kotlin.jvm.internal.Intrinsics.checkNotNull(sSLFactoryManager);
            return sSLFactoryManager;
        }
    }
}
