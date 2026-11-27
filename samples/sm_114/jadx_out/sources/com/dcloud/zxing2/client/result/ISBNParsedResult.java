package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ISBNParsedResult extends com.dcloud.zxing2.client.result.ParsedResult {
    private final java.lang.String isbn;

    ISBNParsedResult(java.lang.String str) {
        super(com.dcloud.zxing2.client.result.ParsedResultType.ISBN);
        this.isbn = str;
    }

    @Override // com.dcloud.zxing2.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        return this.isbn;
    }

    public java.lang.String getISBN() {
        return this.isbn;
    }
}
