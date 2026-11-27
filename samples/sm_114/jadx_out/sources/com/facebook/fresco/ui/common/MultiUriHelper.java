package com.facebook.fresco.ui.common;

/* JADX INFO: compiled from: MultiUriHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JQ\u0010\u0004\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u0001H\u00062\b\u0010\b\u001a\u0004\u0018\u0001H\u00062\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0006\u0018\u00010\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00050\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/facebook/fresco/ui/common/MultiUriHelper;", "", "<init>", "()V", "getMainUri", "Landroid/net/Uri;", "T", "mainRequest", "lowResRequest", "firstAvailableRequest", "", "requestToUri", "Lcom/facebook/common/internal/Fn;", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;Lcom/facebook/common/internal/Fn;)Landroid/net/Uri;", "ui-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MultiUriHelper {
    public static final com.facebook.fresco.ui.common.MultiUriHelper INSTANCE = new com.facebook.fresco.ui.common.MultiUriHelper();

    private MultiUriHelper() {
    }

    @kotlin.jvm.JvmStatic
    public static final <T> android.net.Uri getMainUri(T mainRequest, T lowResRequest, T[] firstAvailableRequest, com.facebook.common.internal.Fn<T, android.net.Uri> requestToUri) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestToUri, "requestToUri");
        android.net.Uri uriApply = mainRequest != null ? requestToUri.apply(mainRequest) : null;
        if (uriApply != null) {
            return uriApply;
        }
        if (firstAvailableRequest != null && firstAvailableRequest.length != 0) {
            T t = firstAvailableRequest[0];
            android.net.Uri uriApply2 = t != null ? requestToUri.apply(t) : null;
            if (uriApply2 != null) {
                return uriApply2;
            }
        }
        if (lowResRequest != null) {
            return requestToUri.apply(lowResRequest);
        }
        return null;
    }
}
