package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class SMSMMSResultParser extends com.dcloud.zxing2.client.result.ResultParser {
    private static void addNumberVia(java.util.Collection<java.lang.String> collection, java.util.Collection<java.lang.String> collection2, java.lang.String str) {
        int iIndexOf = str.indexOf(59);
        if (iIndexOf < 0) {
            collection.add(str);
            collection2.add(null);
        } else {
            collection.add(str.substring(0, iIndexOf));
            java.lang.String strSubstring = str.substring(iIndexOf + 1);
            collection2.add(strSubstring.startsWith("via=") ? strSubstring.substring(4) : null);
        }
    }

    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.SMSParsedResult parse(com.dcloud.zxing2.Result result) {
        boolean z;
        java.lang.String str;
        java.lang.String massagedText = com.dcloud.zxing2.client.result.ResultParser.getMassagedText(result);
        java.lang.String str2 = null;
        if (!massagedText.startsWith("sms:") && !massagedText.startsWith("SMS:") && !massagedText.startsWith("mms:") && !massagedText.startsWith("MMS:")) {
            return null;
        }
        java.util.Map<java.lang.String, java.lang.String> nameValuePairs = com.dcloud.zxing2.client.result.ResultParser.parseNameValuePairs(massagedText);
        if (nameValuePairs == null || nameValuePairs.isEmpty()) {
            z = false;
            str = null;
        } else {
            str2 = nameValuePairs.get("subject");
            str = nameValuePairs.get("body");
            z = true;
        }
        int iIndexOf = massagedText.indexOf(63, 4);
        java.lang.String strSubstring = (iIndexOf < 0 || !z) ? massagedText.substring(4) : massagedText.substring(4, iIndexOf);
        java.util.ArrayList arrayList = new java.util.ArrayList(1);
        java.util.ArrayList arrayList2 = new java.util.ArrayList(1);
        int i = -1;
        while (true) {
            int i2 = i + 1;
            int iIndexOf2 = strSubstring.indexOf(44, i2);
            if (iIndexOf2 <= i) {
                addNumberVia(arrayList, arrayList2, strSubstring.substring(i2));
                return new com.dcloud.zxing2.client.result.SMSParsedResult((java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]), (java.lang.String[]) arrayList2.toArray(new java.lang.String[arrayList2.size()]), str2, str);
            }
            addNumberVia(arrayList, arrayList2, strSubstring.substring(i2, iIndexOf2));
            i = iIndexOf2;
        }
    }
}
