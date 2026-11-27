package io.dcloud.common.util.net.http;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class Request {
    private java.io.InputStream input;
    private java.lang.String mData;
    private java.lang.String uri;

    public Request(java.io.InputStream inputStream) {
        this.input = inputStream;
    }

    private java.lang.String parseUri(java.lang.String str) {
        int i;
        int iIndexOf;
        int iIndexOf2 = str.indexOf(32);
        if (iIndexOf2 == -1 || (iIndexOf = str.indexOf(32, (i = iIndexOf2 + 1))) <= iIndexOf2) {
            return null;
        }
        return str.substring(i, iIndexOf);
    }

    public java.lang.String getData() {
        return this.mData;
    }

    public java.lang.String getUri() {
        return this.uri;
    }

    public void parse() {
        int i;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(2048);
        byte[] bArr = new byte[2048];
        try {
            i = this.input.read(bArr);
        } catch (java.io.IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append((char) bArr[i2]);
        }
        java.lang.String string = stringBuffer.toString();
        this.mData = string;
        java.lang.String uri = parseUri(string);
        this.uri = uri;
        this.uri = (uri == null || !uri.startsWith("/")) ? this.uri : this.uri.substring(1);
    }
}
