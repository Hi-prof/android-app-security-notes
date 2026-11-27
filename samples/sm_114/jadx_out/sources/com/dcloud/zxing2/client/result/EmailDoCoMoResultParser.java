package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class EmailDoCoMoResultParser extends com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser {
    private static final java.util.regex.Pattern ATEXT_ALPHANUMERIC = java.util.regex.Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    static boolean isBasicallyValidEmailAddress(java.lang.String str) {
        return str != null && ATEXT_ALPHANUMERIC.matcher(str).matches() && str.indexOf(64) >= 0;
    }

    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.EmailAddressParsedResult parse(com.dcloud.zxing2.Result result) {
        java.lang.String[] strArrMatchDoCoMoPrefixedField;
        java.lang.String massagedText = com.dcloud.zxing2.client.result.ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("MATMSG:") || (strArrMatchDoCoMoPrefixedField = com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("TO:", massagedText, true)) == null) {
            return null;
        }
        for (java.lang.String str : strArrMatchDoCoMoPrefixedField) {
            if (!isBasicallyValidEmailAddress(str)) {
                return null;
            }
        }
        return new com.dcloud.zxing2.client.result.EmailAddressParsedResult(strArrMatchDoCoMoPrefixedField, null, null, com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("SUB:", massagedText, false), com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("BODY:", massagedText, false));
    }
}
