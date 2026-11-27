package io.dcloud.feature.weex.extend;

/* JADX INFO: loaded from: classes2.dex */
public class RandomBytesModule extends com.taobao.weex.common.WXModule {
    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public java.lang.String getRandomValues(int i) {
        return getRandomBytes(i);
    }

    private java.lang.String getRandomBytes(int i) {
        byte[] bArr = new byte[i];
        new java.security.SecureRandom().nextBytes(bArr);
        return android.util.Base64.encodeToString(bArr, 2);
    }
}
