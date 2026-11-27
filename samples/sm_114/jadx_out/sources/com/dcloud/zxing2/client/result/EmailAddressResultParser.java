package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class EmailAddressResultParser extends com.dcloud.zxing2.client.result.ResultParser {
    private static final java.util.regex.Pattern COMMA = java.util.regex.Pattern.compile(",");

    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.EmailAddressParsedResult parse(com.dcloud.zxing2.Result result) {
        java.lang.String[] strArr;
        java.lang.String[] strArr2;
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String massagedText = com.dcloud.zxing2.client.result.ResultParser.getMassagedText(result);
        if (!massagedText.startsWith(androidx.core.net.MailTo.MAILTO_SCHEME) && !massagedText.startsWith("MAILTO:")) {
            if (com.dcloud.zxing2.client.result.EmailDoCoMoResultParser.isBasicallyValidEmailAddress(massagedText)) {
                return new com.dcloud.zxing2.client.result.EmailAddressParsedResult(massagedText);
            }
            return null;
        }
        java.lang.String strSubstring = massagedText.substring(7);
        int iIndexOf = strSubstring.indexOf(63);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf);
        }
        try {
            java.lang.String strUrlDecode = com.dcloud.zxing2.client.result.ResultParser.urlDecode(strSubstring);
            java.lang.String[] strArrSplit = !strUrlDecode.isEmpty() ? COMMA.split(strUrlDecode) : null;
            java.util.Map<java.lang.String, java.lang.String> nameValuePairs = com.dcloud.zxing2.client.result.ResultParser.parseNameValuePairs(massagedText);
            if (nameValuePairs != null) {
                if (strArrSplit == null && (str3 = nameValuePairs.get("to")) != null) {
                    strArrSplit = COMMA.split(str3);
                }
                java.lang.String str4 = nameValuePairs.get("cc");
                java.lang.String[] strArrSplit2 = str4 != null ? COMMA.split(str4) : null;
                java.lang.String str5 = nameValuePairs.get("bcc");
                java.lang.String[] strArrSplit3 = str5 != null ? COMMA.split(str5) : null;
                java.lang.String str6 = nameValuePairs.get("subject");
                str2 = nameValuePairs.get("body");
                strArr2 = strArrSplit3;
                strArr = strArrSplit2;
                str = str6;
            } else {
                strArr = null;
                strArr2 = null;
                str = null;
                str2 = null;
            }
            return new com.dcloud.zxing2.client.result.EmailAddressParsedResult(strArrSplit, strArr, strArr2, str, str2);
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }
}
