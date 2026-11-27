package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class GeoParsedResult extends com.dcloud.zxing2.client.result.ParsedResult {
    private final double altitude;
    private final double latitude;
    private final double longitude;
    private final java.lang.String query;

    GeoParsedResult(double d, double d2, double d3, java.lang.String str) {
        super(com.dcloud.zxing2.client.result.ParsedResultType.GEO);
        this.latitude = d;
        this.longitude = d2;
        this.altitude = d3;
        this.query = str;
    }

    public double getAltitude() {
        return this.altitude;
    }

    @Override // com.dcloud.zxing2.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(20);
        sb.append(this.latitude);
        sb.append(", ");
        sb.append(this.longitude);
        if (this.altitude > 0.0d) {
            sb.append(", ");
            sb.append(this.altitude);
            sb.append('m');
        }
        if (this.query != null) {
            sb.append(" (");
            sb.append(this.query);
            sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END);
        }
        return sb.toString();
    }

    public java.lang.String getGeoURI() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("geo:");
        sb.append(this.latitude);
        sb.append(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
        sb.append(this.longitude);
        if (this.altitude > 0.0d) {
            sb.append(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
            sb.append(this.altitude);
        }
        if (this.query != null) {
            sb.append(com.taobao.weex.el.parse.Operators.CONDITION_IF);
            sb.append(this.query);
        }
        return sb.toString();
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public java.lang.String getQuery() {
        return this.query;
    }
}
