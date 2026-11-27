package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class EmailAddressParsedResult extends com.dcloud.zxing2.client.result.ParsedResult {
    private final java.lang.String[] bccs;
    private final java.lang.String body;
    private final java.lang.String[] ccs;
    private final java.lang.String subject;
    private final java.lang.String[] tos;

    EmailAddressParsedResult(java.lang.String str) {
        this(new java.lang.String[]{str}, null, null, null, null);
    }

    public java.lang.String[] getBCCs() {
        return this.bccs;
    }

    public java.lang.String getBody() {
        return this.body;
    }

    public java.lang.String[] getCCs() {
        return this.ccs;
    }

    @Override // com.dcloud.zxing2.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(30);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.tos, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.ccs, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.bccs, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.subject, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.body, sb);
        return sb.toString();
    }

    @java.lang.Deprecated
    public java.lang.String getEmailAddress() {
        java.lang.String[] strArr = this.tos;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return strArr[0];
    }

    @java.lang.Deprecated
    public java.lang.String getMailtoURI() {
        return androidx.core.net.MailTo.MAILTO_SCHEME;
    }

    public java.lang.String getSubject() {
        return this.subject;
    }

    public java.lang.String[] getTos() {
        return this.tos;
    }

    EmailAddressParsedResult(java.lang.String[] strArr, java.lang.String[] strArr2, java.lang.String[] strArr3, java.lang.String str, java.lang.String str2) {
        super(com.dcloud.zxing2.client.result.ParsedResultType.EMAIL_ADDRESS);
        this.tos = strArr;
        this.ccs = strArr2;
        this.bccs = strArr3;
        this.subject = str;
        this.body = str2;
    }
}
