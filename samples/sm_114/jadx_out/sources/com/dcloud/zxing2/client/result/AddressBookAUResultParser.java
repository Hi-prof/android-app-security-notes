package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class AddressBookAUResultParser extends com.dcloud.zxing2.client.result.ResultParser {
    private static java.lang.String[] matchMultipleValuePrefix(java.lang.String str, int i, java.lang.String str2, boolean z) {
        java.util.ArrayList arrayList = null;
        for (int i2 = 1; i2 <= i; i2++) {
            java.lang.String strMatchSinglePrefixedField = com.dcloud.zxing2.client.result.ResultParser.matchSinglePrefixedField(str + i2 + com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE, str2, '\r', z);
            if (strMatchSinglePrefixedField == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new java.util.ArrayList(i);
            }
            arrayList.add(strMatchSinglePrefixedField);
        }
        if (arrayList == null) {
            return null;
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.AddressBookParsedResult parse(com.dcloud.zxing2.Result result) {
        java.lang.String massagedText = com.dcloud.zxing2.client.result.ResultParser.getMassagedText(result);
        if (!massagedText.contains("MEMORY") || !massagedText.contains("\r\n")) {
            return null;
        }
        java.lang.String strMatchSinglePrefixedField = com.dcloud.zxing2.client.result.ResultParser.matchSinglePrefixedField("NAME1:", massagedText, '\r', true);
        java.lang.String strMatchSinglePrefixedField2 = com.dcloud.zxing2.client.result.ResultParser.matchSinglePrefixedField("NAME2:", massagedText, '\r', true);
        java.lang.String[] strArrMatchMultipleValuePrefix = matchMultipleValuePrefix("TEL", 3, massagedText, true);
        java.lang.String[] strArrMatchMultipleValuePrefix2 = matchMultipleValuePrefix("MAIL", 3, massagedText, true);
        java.lang.String strMatchSinglePrefixedField3 = com.dcloud.zxing2.client.result.ResultParser.matchSinglePrefixedField("MEMORY:", massagedText, '\r', false);
        java.lang.String strMatchSinglePrefixedField4 = com.dcloud.zxing2.client.result.ResultParser.matchSinglePrefixedField("ADD:", massagedText, '\r', true);
        return new com.dcloud.zxing2.client.result.AddressBookParsedResult(com.dcloud.zxing2.client.result.ResultParser.maybeWrap(strMatchSinglePrefixedField), null, strMatchSinglePrefixedField2, strArrMatchMultipleValuePrefix, null, strArrMatchMultipleValuePrefix2, null, null, strMatchSinglePrefixedField3, strMatchSinglePrefixedField4 != null ? new java.lang.String[]{strMatchSinglePrefixedField4} : null, null, null, null, null, null, null);
    }
}
