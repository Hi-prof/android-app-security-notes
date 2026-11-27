package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ISBNResultParser extends com.dcloud.zxing2.client.result.ResultParser {
    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.ISBNParsedResult parse(com.dcloud.zxing2.Result result) {
        if (result.getBarcodeFormat() != com.dcloud.zxing2.BarcodeFormat.EAN_13) {
            return null;
        }
        java.lang.String massagedText = com.dcloud.zxing2.client.result.ResultParser.getMassagedText(result);
        if (massagedText.length() != 13) {
            return null;
        }
        if (massagedText.startsWith("978") || massagedText.startsWith("979")) {
            return new com.dcloud.zxing2.client.result.ISBNParsedResult(massagedText);
        }
        return null;
    }
}
