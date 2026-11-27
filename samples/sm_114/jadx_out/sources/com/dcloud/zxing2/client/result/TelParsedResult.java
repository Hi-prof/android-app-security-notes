package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class TelParsedResult extends com.dcloud.zxing2.client.result.ParsedResult {
    private final java.lang.String number;
    private final java.lang.String telURI;
    private final java.lang.String title;

    public TelParsedResult(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(com.dcloud.zxing2.client.result.ParsedResultType.TEL);
        this.number = str;
        this.telURI = str2;
        this.title = str3;
    }

    @Override // com.dcloud.zxing2.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(20);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.number, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.title, sb);
        return sb.toString();
    }

    public java.lang.String getNumber() {
        return this.number;
    }

    public java.lang.String getTelURI() {
        return this.telURI;
    }

    public java.lang.String getTitle() {
        return this.title;
    }
}
