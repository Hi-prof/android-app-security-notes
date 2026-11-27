package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class SMSParsedResult extends com.dcloud.zxing2.client.result.ParsedResult {
    private final java.lang.String body;
    private final java.lang.String[] numbers;
    private final java.lang.String subject;
    private final java.lang.String[] vias;

    public SMSParsedResult(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        super(com.dcloud.zxing2.client.result.ParsedResultType.SMS);
        this.numbers = new java.lang.String[]{str};
        this.vias = new java.lang.String[]{str2};
        this.subject = str3;
        this.body = str4;
    }

    public java.lang.String getBody() {
        return this.body;
    }

    @Override // com.dcloud.zxing2.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(100);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.numbers, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.subject, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.body, sb);
        return sb.toString();
    }

    public java.lang.String[] getNumbers() {
        return this.numbers;
    }

    public java.lang.String getSMSURI() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("sms:");
        boolean z = true;
        for (int i = 0; i < this.numbers.length; i++) {
            if (z) {
                z = false;
            } else {
                sb.append(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
            }
            sb.append(this.numbers[i]);
            java.lang.String[] strArr = this.vias;
            if (strArr != null && strArr[i] != null) {
                sb.append(";via=");
                sb.append(this.vias[i]);
            }
        }
        boolean z2 = this.body != null;
        boolean z3 = this.subject != null;
        if (z2 || z3) {
            sb.append(com.taobao.weex.el.parse.Operators.CONDITION_IF);
            if (z2) {
                sb.append("body=");
                sb.append(this.body);
            }
            if (z3) {
                if (z2) {
                    sb.append(kotlin.text.Typography.amp);
                }
                sb.append("subject=");
                sb.append(this.subject);
            }
        }
        return sb.toString();
    }

    public java.lang.String getSubject() {
        return this.subject;
    }

    public java.lang.String[] getVias() {
        return this.vias;
    }

    public SMSParsedResult(java.lang.String[] strArr, java.lang.String[] strArr2, java.lang.String str, java.lang.String str2) {
        super(com.dcloud.zxing2.client.result.ParsedResultType.SMS);
        this.numbers = strArr;
        this.vias = strArr2;
        this.subject = str;
        this.body = str2;
    }
}
