package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class AddressBookDoCoMoResultParser extends com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser {
    private static java.lang.String parseName(java.lang.String str) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf < 0) {
            return str;
        }
        return str.substring(iIndexOf + 1) + ' ' + str.substring(0, iIndexOf);
    }

    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.AddressBookParsedResult parse(com.dcloud.zxing2.Result result) {
        java.lang.String[] strArrMatchDoCoMoPrefixedField;
        java.lang.String massagedText = com.dcloud.zxing2.client.result.ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("MECARD:") || (strArrMatchDoCoMoPrefixedField = com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("N:", massagedText, true)) == null) {
            return null;
        }
        java.lang.String name = parseName(strArrMatchDoCoMoPrefixedField[0]);
        java.lang.String strMatchSingleDoCoMoPrefixedField = com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("SOUND:", massagedText, true);
        java.lang.String[] strArrMatchDoCoMoPrefixedField2 = com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("TEL:", massagedText, true);
        java.lang.String[] strArrMatchDoCoMoPrefixedField3 = com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("EMAIL:", massagedText, true);
        java.lang.String strMatchSingleDoCoMoPrefixedField2 = com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("NOTE:", massagedText, false);
        java.lang.String[] strArrMatchDoCoMoPrefixedField4 = com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("ADR:", massagedText, true);
        java.lang.String strMatchSingleDoCoMoPrefixedField3 = com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("BDAY:", massagedText, true);
        return new com.dcloud.zxing2.client.result.AddressBookParsedResult(com.dcloud.zxing2.client.result.ResultParser.maybeWrap(name), null, strMatchSingleDoCoMoPrefixedField, strArrMatchDoCoMoPrefixedField2, null, strArrMatchDoCoMoPrefixedField3, null, null, strMatchSingleDoCoMoPrefixedField2, strArrMatchDoCoMoPrefixedField4, null, com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("ORG:", massagedText, true), !com.dcloud.zxing2.client.result.ResultParser.isStringOfDigits(strMatchSingleDoCoMoPrefixedField3, 8) ? null : strMatchSingleDoCoMoPrefixedField3, null, com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("URL:", massagedText, true), null);
    }
}
