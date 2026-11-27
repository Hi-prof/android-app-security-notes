package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class URIResultParser extends com.dcloud.zxing2.client.result.ResultParser {
    private static final java.util.regex.Pattern URL_WITH_PROTOCOL_PATTERN = java.util.regex.Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");
    private static final java.util.regex.Pattern URL_WITHOUT_PROTOCOL_PATTERN = java.util.regex.Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    static boolean isBasicallyValidURI(java.lang.String str) {
        if (str.contains(com.taobao.weex.el.parse.Operators.SPACE_STR)) {
            return false;
        }
        java.util.regex.Matcher matcher = URL_WITH_PROTOCOL_PATTERN.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        java.util.regex.Matcher matcher2 = URL_WITHOUT_PROTOCOL_PATTERN.matcher(str);
        return matcher2.find() && matcher2.start() == 0;
    }

    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.URIParsedResult parse(com.dcloud.zxing2.Result result) {
        java.lang.String massagedText = com.dcloud.zxing2.client.result.ResultParser.getMassagedText(result);
        if (massagedText.startsWith("URL:") || massagedText.startsWith("URI:")) {
            return new com.dcloud.zxing2.client.result.URIParsedResult(massagedText.substring(4).trim(), null);
        }
        java.lang.String strTrim = massagedText.trim();
        if (isBasicallyValidURI(strTrim)) {
            return new com.dcloud.zxing2.client.result.URIParsedResult(strTrim, null);
        }
        return null;
    }
}
