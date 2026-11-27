package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractDoCoMoResultParser extends com.dcloud.zxing2.client.result.ResultParser {
    AbstractDoCoMoResultParser() {
    }

    static java.lang.String[] matchDoCoMoPrefixedField(java.lang.String str, java.lang.String str2, boolean z) {
        return com.dcloud.zxing2.client.result.ResultParser.matchPrefixedField(str, str2, ';', z);
    }

    static java.lang.String matchSingleDoCoMoPrefixedField(java.lang.String str, java.lang.String str2, boolean z) {
        return com.dcloud.zxing2.client.result.ResultParser.matchSinglePrefixedField(str, str2, ';', z);
    }
}
