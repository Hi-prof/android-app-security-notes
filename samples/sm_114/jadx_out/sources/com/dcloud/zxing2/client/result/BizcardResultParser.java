package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class BizcardResultParser extends com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser {
    private static java.lang.String buildName(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        return str + ' ' + str2;
    }

    private static java.lang.String[] buildPhoneNumbers(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.ArrayList arrayList = new java.util.ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[size]);
    }

    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.AddressBookParsedResult parse(com.dcloud.zxing2.Result result) {
        java.lang.String massagedText = com.dcloud.zxing2.client.result.ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("BIZCARD:")) {
            return null;
        }
        java.lang.String strBuildName = buildName(com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("N:", massagedText, true), com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("X:", massagedText, true));
        java.lang.String strMatchSingleDoCoMoPrefixedField = com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("T:", massagedText, true);
        java.lang.String strMatchSingleDoCoMoPrefixedField2 = com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("C:", massagedText, true);
        return new com.dcloud.zxing2.client.result.AddressBookParsedResult(com.dcloud.zxing2.client.result.ResultParser.maybeWrap(strBuildName), null, null, buildPhoneNumbers(com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("B:", massagedText, true), com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("M:", massagedText, true), com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("F:", massagedText, true)), null, com.dcloud.zxing2.client.result.ResultParser.maybeWrap(com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("E:", massagedText, true)), null, null, null, com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("A:", massagedText, true), null, strMatchSingleDoCoMoPrefixedField2, null, strMatchSingleDoCoMoPrefixedField, null, null);
    }
}
