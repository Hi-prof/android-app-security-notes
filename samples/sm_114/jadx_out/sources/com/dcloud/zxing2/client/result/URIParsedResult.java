package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class URIParsedResult extends com.dcloud.zxing2.client.result.ParsedResult {
    private static final java.util.regex.Pattern USER_IN_HOST = java.util.regex.Pattern.compile(":/*([^/@]+)@[^/]+");
    private final java.lang.String title;
    private final java.lang.String uri;

    public URIParsedResult(java.lang.String str, java.lang.String str2) {
        super(com.dcloud.zxing2.client.result.ParsedResultType.URI);
        this.uri = massageURI(str);
        this.title = str2;
    }

    private static boolean isColonFollowedByPortNumber(java.lang.String str, int i) {
        int i2 = i + 1;
        int iIndexOf = str.indexOf(47, i2);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
        }
        return com.dcloud.zxing2.client.result.ResultParser.isSubstringOfDigits(str, i2, iIndexOf - i2);
    }

    private static java.lang.String massageURI(java.lang.String str) {
        java.lang.String strTrim = str.trim();
        int iIndexOf = strTrim.indexOf(58);
        if (iIndexOf >= 0 && !isColonFollowedByPortNumber(strTrim, iIndexOf)) {
            return strTrim;
        }
        return io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL + strTrim;
    }

    @Override // com.dcloud.zxing2.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(30);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.title, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.uri, sb);
        return sb.toString();
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public java.lang.String getURI() {
        return this.uri;
    }

    public boolean isPossiblyMaliciousURI() {
        return USER_IN_HOST.matcher(this.uri).find();
    }
}
