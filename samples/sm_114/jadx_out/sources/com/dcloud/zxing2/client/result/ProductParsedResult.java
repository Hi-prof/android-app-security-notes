package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ProductParsedResult extends com.dcloud.zxing2.client.result.ParsedResult {
    private final java.lang.String normalizedProductID;
    private final java.lang.String productID;

    ProductParsedResult(java.lang.String str) {
        this(str, str);
    }

    @Override // com.dcloud.zxing2.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        return this.productID;
    }

    public java.lang.String getNormalizedProductID() {
        return this.normalizedProductID;
    }

    public java.lang.String getProductID() {
        return this.productID;
    }

    ProductParsedResult(java.lang.String str, java.lang.String str2) {
        super(com.dcloud.zxing2.client.result.ParsedResultType.PRODUCT);
        this.productID = str;
        this.normalizedProductID = str2;
    }
}
