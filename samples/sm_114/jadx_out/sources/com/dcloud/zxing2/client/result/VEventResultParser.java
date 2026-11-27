package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class VEventResultParser extends com.dcloud.zxing2.client.result.ResultParser {
    private static java.lang.String matchSingleVCardPrefixedField(java.lang.CharSequence charSequence, java.lang.String str, boolean z) {
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField = com.dcloud.zxing2.client.result.VCardResultParser.matchSingleVCardPrefixedField(charSequence, str, z, false);
        if (listMatchSingleVCardPrefixedField == null || listMatchSingleVCardPrefixedField.isEmpty()) {
            return null;
        }
        return listMatchSingleVCardPrefixedField.get(0);
    }

    private static java.lang.String[] matchVCardPrefixedField(java.lang.CharSequence charSequence, java.lang.String str, boolean z) {
        java.util.List<java.util.List<java.lang.String>> listMatchVCardPrefixedField = com.dcloud.zxing2.client.result.VCardResultParser.matchVCardPrefixedField(charSequence, str, z, false);
        if (listMatchVCardPrefixedField == null || listMatchVCardPrefixedField.isEmpty()) {
            return null;
        }
        int size = listMatchVCardPrefixedField.size();
        java.lang.String[] strArr = new java.lang.String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = listMatchVCardPrefixedField.get(i).get(0);
        }
        return strArr;
    }

    private static java.lang.String stripMailto(java.lang.String str) {
        if (str != null) {
            return (str.startsWith(androidx.core.net.MailTo.MAILTO_SCHEME) || str.startsWith("MAILTO:")) ? str.substring(7) : str;
        }
        return str;
    }

    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.CalendarParsedResult parse(com.dcloud.zxing2.Result result) {
        double d;
        double d2;
        java.lang.String massagedText = com.dcloud.zxing2.client.result.ResultParser.getMassagedText(result);
        if (massagedText.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        java.lang.String strMatchSingleVCardPrefixedField = matchSingleVCardPrefixedField("SUMMARY", massagedText, true);
        java.lang.String strMatchSingleVCardPrefixedField2 = matchSingleVCardPrefixedField("DTSTART", massagedText, true);
        if (strMatchSingleVCardPrefixedField2 == null) {
            return null;
        }
        java.lang.String strMatchSingleVCardPrefixedField3 = matchSingleVCardPrefixedField("DTEND", massagedText, true);
        java.lang.String strMatchSingleVCardPrefixedField4 = matchSingleVCardPrefixedField("DURATION", massagedText, true);
        java.lang.String strMatchSingleVCardPrefixedField5 = matchSingleVCardPrefixedField(io.dcloud.common.adapter.util.PermissionUtil.PMS_LOCATION, massagedText, true);
        java.lang.String strStripMailto = stripMailto(matchSingleVCardPrefixedField("ORGANIZER", massagedText, true));
        java.lang.String[] strArrMatchVCardPrefixedField = matchVCardPrefixedField("ATTENDEE", massagedText, true);
        if (strArrMatchVCardPrefixedField != null) {
            for (int i = 0; i < strArrMatchVCardPrefixedField.length; i++) {
                strArrMatchVCardPrefixedField[i] = stripMailto(strArrMatchVCardPrefixedField[i]);
            }
        }
        java.lang.String strMatchSingleVCardPrefixedField6 = matchSingleVCardPrefixedField("DESCRIPTION", massagedText, true);
        java.lang.String strMatchSingleVCardPrefixedField7 = matchSingleVCardPrefixedField("GEO", massagedText, true);
        if (strMatchSingleVCardPrefixedField7 == null) {
            d = Double.NaN;
            d2 = Double.NaN;
        } else {
            int iIndexOf = strMatchSingleVCardPrefixedField7.indexOf(59);
            if (iIndexOf < 0) {
                return null;
            }
            try {
                d = java.lang.Double.parseDouble(strMatchSingleVCardPrefixedField7.substring(0, iIndexOf));
                d2 = java.lang.Double.parseDouble(strMatchSingleVCardPrefixedField7.substring(iIndexOf + 1));
            } catch (java.lang.NumberFormatException | java.lang.IllegalArgumentException unused) {
                return null;
            }
        }
        return new com.dcloud.zxing2.client.result.CalendarParsedResult(strMatchSingleVCardPrefixedField, strMatchSingleVCardPrefixedField2, strMatchSingleVCardPrefixedField3, strMatchSingleVCardPrefixedField4, strMatchSingleVCardPrefixedField5, strStripMailto, strArrMatchVCardPrefixedField, strMatchSingleVCardPrefixedField6, d, d2);
    }
}
