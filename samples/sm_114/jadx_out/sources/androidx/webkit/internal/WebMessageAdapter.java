package androidx.webkit.internal;

/* JADX INFO: loaded from: classes.dex */
public class WebMessageAdapter implements org.chromium.support_lib_boundary.WebMessageBoundaryInterface {
    private androidx.webkit.WebMessageCompat mWebMessageCompat;

    public WebMessageAdapter(androidx.webkit.WebMessageCompat webMessageCompat) {
        this.mWebMessageCompat = webMessageCompat;
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public java.lang.String getData() {
        return this.mWebMessageCompat.getData();
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public java.lang.reflect.InvocationHandler getMessagePayload() {
        throw new java.lang.UnsupportedOperationException("This method is not yet supported");
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public java.lang.reflect.InvocationHandler[] getPorts() {
        androidx.webkit.WebMessagePortCompat[] ports = this.mWebMessageCompat.getPorts();
        if (ports == null) {
            return null;
        }
        java.lang.reflect.InvocationHandler[] invocationHandlerArr = new java.lang.reflect.InvocationHandler[ports.length];
        for (int i = 0; i < ports.length; i++) {
            invocationHandlerArr[i] = ports[i].getInvocationHandler();
        }
        return invocationHandlerArr;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public java.lang.String[] getSupportedFeatures() {
        return new java.lang.String[0];
    }

    public static androidx.webkit.WebMessageCompat webMessageCompatFromBoundaryInterface(org.chromium.support_lib_boundary.WebMessageBoundaryInterface webMessageBoundaryInterface) {
        return new androidx.webkit.WebMessageCompat(webMessageBoundaryInterface.getData(), toWebMessagePortCompats(webMessageBoundaryInterface.getPorts()));
    }

    private static androidx.webkit.WebMessagePortCompat[] toWebMessagePortCompats(java.lang.reflect.InvocationHandler[] invocationHandlerArr) {
        androidx.webkit.WebMessagePortCompat[] webMessagePortCompatArr = new androidx.webkit.WebMessagePortCompat[invocationHandlerArr.length];
        for (int i = 0; i < invocationHandlerArr.length; i++) {
            webMessagePortCompatArr[i] = new androidx.webkit.internal.WebMessagePortImpl(invocationHandlerArr[i]);
        }
        return webMessagePortCompatArr;
    }
}
