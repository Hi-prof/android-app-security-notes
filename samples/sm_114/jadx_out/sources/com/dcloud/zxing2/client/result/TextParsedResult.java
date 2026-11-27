package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class TextParsedResult extends com.dcloud.zxing2.client.result.ParsedResult {
    private final java.lang.String language;
    private final java.lang.String text;

    public TextParsedResult(java.lang.String str, java.lang.String str2) {
        super(com.dcloud.zxing2.client.result.ParsedResultType.TEXT);
        this.text = str;
        this.language = str2;
    }

    @Override // com.dcloud.zxing2.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        return this.text;
    }

    public java.lang.String getLanguage() {
        return this.language;
    }

    public java.lang.String getText() {
        return this.text;
    }
}
