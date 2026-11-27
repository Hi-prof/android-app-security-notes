package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class WifiResultParser extends com.dcloud.zxing2.client.result.ResultParser {
    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.WifiParsedResult parse(com.dcloud.zxing2.Result result) {
        java.lang.String strMatchSinglePrefixedField;
        java.lang.String massagedText = com.dcloud.zxing2.client.result.ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("WIFI:") || (strMatchSinglePrefixedField = com.dcloud.zxing2.client.result.ResultParser.matchSinglePrefixedField("S:", massagedText, ';', false)) == null || strMatchSinglePrefixedField.isEmpty()) {
            return null;
        }
        java.lang.String strMatchSinglePrefixedField2 = com.dcloud.zxing2.client.result.ResultParser.matchSinglePrefixedField("P:", massagedText, ';', false);
        java.lang.String strMatchSinglePrefixedField3 = com.dcloud.zxing2.client.result.ResultParser.matchSinglePrefixedField("T:", massagedText, ';', false);
        if (strMatchSinglePrefixedField3 == null) {
            strMatchSinglePrefixedField3 = "nopass";
        }
        return new com.dcloud.zxing2.client.result.WifiParsedResult(strMatchSinglePrefixedField3, strMatchSinglePrefixedField, strMatchSinglePrefixedField2, java.lang.Boolean.parseBoolean(com.dcloud.zxing2.client.result.ResultParser.matchSinglePrefixedField("H:", massagedText, ';', false)));
    }
}
