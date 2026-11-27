package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class BookmarkDoCoMoResultParser extends com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser {
    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.URIParsedResult parse(com.dcloud.zxing2.Result result) {
        java.lang.String text = result.getText();
        if (!text.startsWith("MEBKM:")) {
            return null;
        }
        java.lang.String strMatchSingleDoCoMoPrefixedField = com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("TITLE:", text, true);
        java.lang.String[] strArrMatchDoCoMoPrefixedField = com.dcloud.zxing2.client.result.AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("URL:", text, true);
        if (strArrMatchDoCoMoPrefixedField == null) {
            return null;
        }
        java.lang.String str = strArrMatchDoCoMoPrefixedField[0];
        if (com.dcloud.zxing2.client.result.URIResultParser.isBasicallyValidURI(str)) {
            return new com.dcloud.zxing2.client.result.URIParsedResult(str, strMatchSingleDoCoMoPrefixedField);
        }
        return null;
    }
}
