package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class GeoResultParser extends com.dcloud.zxing2.client.result.ResultParser {
    private static final java.util.regex.Pattern GEO_URL_PATTERN = java.util.regex.Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.GeoParsedResult parse(com.dcloud.zxing2.Result result) {
        java.util.regex.Matcher matcher = GEO_URL_PATTERN.matcher(com.dcloud.zxing2.client.result.ResultParser.getMassagedText(result));
        if (!matcher.matches()) {
            return null;
        }
        java.lang.String strGroup = matcher.group(4);
        try {
            double d = java.lang.Double.parseDouble(matcher.group(1));
            if (d <= 90.0d && d >= -90.0d) {
                double d2 = java.lang.Double.parseDouble(matcher.group(2));
                if (d2 <= 180.0d && d2 >= -180.0d) {
                    double d3 = 0.0d;
                    if (matcher.group(3) != null) {
                        double d4 = java.lang.Double.parseDouble(matcher.group(3));
                        if (d4 < 0.0d) {
                            return null;
                        }
                        d3 = d4;
                    }
                    return new com.dcloud.zxing2.client.result.GeoParsedResult(d, d2, d3, strGroup);
                }
            }
        } catch (java.lang.NumberFormatException unused) {
        }
        return null;
    }
}
