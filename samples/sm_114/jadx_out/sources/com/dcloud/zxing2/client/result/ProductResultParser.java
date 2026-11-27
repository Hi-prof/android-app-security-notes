package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ProductResultParser extends com.dcloud.zxing2.client.result.ResultParser {
    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.ProductParsedResult parse(com.dcloud.zxing2.Result result) {
        com.dcloud.zxing2.BarcodeFormat barcodeFormat = result.getBarcodeFormat();
        if (barcodeFormat != com.dcloud.zxing2.BarcodeFormat.UPC_A && barcodeFormat != com.dcloud.zxing2.BarcodeFormat.UPC_E && barcodeFormat != com.dcloud.zxing2.BarcodeFormat.EAN_8 && barcodeFormat != com.dcloud.zxing2.BarcodeFormat.EAN_13) {
            return null;
        }
        java.lang.String massagedText = com.dcloud.zxing2.client.result.ResultParser.getMassagedText(result);
        if (com.dcloud.zxing2.client.result.ResultParser.isStringOfDigits(massagedText, massagedText.length())) {
            return new com.dcloud.zxing2.client.result.ProductParsedResult(massagedText, (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.UPC_E && massagedText.length() == 8) ? com.dcloud.zxing2.oned.UPCEReader.convertUPCEtoUPCA(massagedText) : massagedText);
        }
        return null;
    }
}
