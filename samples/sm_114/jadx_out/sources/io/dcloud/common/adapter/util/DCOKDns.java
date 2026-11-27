package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DCOKDns implements dc.squareup.okhttp3.Dns {
    @Override // dc.squareup.okhttp3.Dns
    public java.util.List<java.net.InetAddress> lookup(java.lang.String str) throws java.net.UnknownHostException {
        if (str == null) {
            throw new java.net.UnknownHostException("hostname == null");
        }
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.net.InetAddress inetAddress : java.net.InetAddress.getAllByName(str)) {
                if (inetAddress instanceof java.net.Inet4Address) {
                    arrayList.add(0, inetAddress);
                } else {
                    arrayList.add(inetAddress);
                }
            }
            return arrayList;
        } catch (java.lang.Exception e) {
            java.net.UnknownHostException unknownHostException = new java.net.UnknownHostException("error");
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
