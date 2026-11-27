package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class URLTOResultParser extends com.dcloud.zxing2.client.result.ResultParser {
    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.URIParsedResult parse(com.dcloud.zxing2.Result result) {
        int iIndexOf;
        java.lang.String massagedText = com.dcloud.zxing2.client.result.ResultParser.getMassagedText(result);
        if ((massagedText.startsWith("urlto:") || massagedText.startsWith("URLTO:")) && (iIndexOf = massagedText.indexOf(58, 6)) >= 0) {
            return new com.dcloud.zxing2.client.result.URIParsedResult(massagedText.substring(iIndexOf + 1), iIndexOf > 6 ? massagedText.substring(6, iIndexOf) : null);
        }
        return null;
    }
}
