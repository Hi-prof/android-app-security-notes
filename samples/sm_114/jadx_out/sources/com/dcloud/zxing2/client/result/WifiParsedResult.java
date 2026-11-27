package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class WifiParsedResult extends com.dcloud.zxing2.client.result.ParsedResult {
    private final boolean hidden;
    private final java.lang.String networkEncryption;
    private final java.lang.String password;
    private final java.lang.String ssid;

    public WifiParsedResult(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this(str, str2, str3, false);
    }

    @Override // com.dcloud.zxing2.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(80);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.ssid, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.networkEncryption, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(this.password, sb);
        com.dcloud.zxing2.client.result.ParsedResult.maybeAppend(java.lang.Boolean.toString(this.hidden), sb);
        return sb.toString();
    }

    public java.lang.String getNetworkEncryption() {
        return this.networkEncryption;
    }

    public java.lang.String getPassword() {
        return this.password;
    }

    public java.lang.String getSsid() {
        return this.ssid;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public WifiParsedResult(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        super(com.dcloud.zxing2.client.result.ParsedResultType.WIFI);
        this.ssid = str2;
        this.networkEncryption = str;
        this.password = str3;
        this.hidden = z;
    }
}
