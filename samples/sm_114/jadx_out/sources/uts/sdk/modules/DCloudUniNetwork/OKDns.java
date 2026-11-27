package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/OKDns;", "Lokhttp3/Dns;", "<init>", "()V", "lookup", "", "Ljava/net/InetAddress;", "hostName", "", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class OKDns implements okhttp3.Dns {
    @Override // okhttp3.Dns
    public java.util.List<java.net.InetAddress> lookup(java.lang.String hostName) throws java.net.UnknownHostException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(hostName, "hostName");
        try {
            io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
            java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator((java.lang.Object[]) io.dcloud.uts.UTSIteratorKt.resolveUTSKeyIterator(java.net.InetAddress.getAllByName(hostName)));
            while (it.hasNext()) {
                java.net.InetAddress inetAddress = (java.net.InetAddress) it.next();
                if (inetAddress instanceof java.net.Inet4Address) {
                    uTSArray.unshift(inetAddress);
                } else {
                    kotlin.jvm.internal.Intrinsics.checkNotNull(inetAddress);
                    uTSArray.push(inetAddress);
                }
            }
            return uTSArray;
        } catch (java.lang.Exception e) {
            java.net.UnknownHostException unknownHostException = new java.net.UnknownHostException("error");
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
