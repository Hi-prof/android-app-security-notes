package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ExpandedProductResultParser extends com.dcloud.zxing2.client.result.ResultParser {
    private static java.lang.String findAIvalue(int i, java.lang.String str) {
        if (str.charAt(i) != '(') {
            return null;
        }
        java.lang.String strSubstring = str.substring(i + 1);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i2 = 0; i2 < strSubstring.length(); i2++) {
            char cCharAt = strSubstring.charAt(i2);
            if (cCharAt == ')') {
                return sb.toString();
            }
            if (cCharAt < '0' || cCharAt > '9') {
                return null;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    private static java.lang.String findValue(int i, java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String strSubstring = str.substring(i);
        for (int i2 = 0; i2 < strSubstring.length(); i2++) {
            char cCharAt = strSubstring.charAt(i2);
            if (cCharAt != '(') {
                sb.append(cCharAt);
            } else {
                if (findAIvalue(i2, strSubstring) != null) {
                    break;
                }
                sb.append(com.taobao.weex.el.parse.Operators.BRACKET_START);
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0054  */
    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.ExpandedProductParsedResult parse(com.dcloud.zxing2.Result result) {
        if (result.getBarcodeFormat() != com.dcloud.zxing2.BarcodeFormat.RSS_EXPANDED) {
            return null;
        }
        java.lang.String massagedText = com.dcloud.zxing2.client.result.ResultParser.getMassagedText(result);
        java.util.HashMap map = new java.util.HashMap();
        java.lang.String str = null;
        java.lang.String str2 = null;
        java.lang.String str3 = null;
        java.lang.String str4 = null;
        java.lang.String str5 = null;
        java.lang.String str6 = null;
        java.lang.String str7 = null;
        java.lang.String str8 = null;
        java.lang.String str9 = null;
        java.lang.String strSubstring = null;
        java.lang.String strSubstring2 = null;
        java.lang.String strSubstring3 = null;
        java.lang.String strSubstring4 = null;
        int i = 0;
        while (i < massagedText.length()) {
            java.lang.String strFindAIvalue = findAIvalue(i, massagedText);
            if (strFindAIvalue == null) {
                return null;
            }
            byte b = 2;
            int length = i + strFindAIvalue.length() + 2;
            java.lang.String strFindValue = findValue(length, massagedText);
            int length2 = length + strFindValue.length();
            strFindAIvalue.hashCode();
            switch (strFindAIvalue.hashCode()) {
                case 1536:
                    if (!strFindAIvalue.equals("00")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 1537:
                    if (!strFindAIvalue.equals("01")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 1567:
                    if (!strFindAIvalue.equals("10")) {
                        b = -1;
                    }
                    break;
                case 1568:
                    if (!strFindAIvalue.equals("11")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 1570:
                    if (!strFindAIvalue.equals("13")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 1572:
                    if (!strFindAIvalue.equals("15")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 1574:
                    if (!strFindAIvalue.equals("17")) {
                        b = -1;
                    } else {
                        b = 6;
                    }
                    break;
                case 1567966:
                    if (!strFindAIvalue.equals("3100")) {
                        b = -1;
                    } else {
                        b = 7;
                    }
                    break;
                case 1567967:
                    if (!strFindAIvalue.equals("3101")) {
                        b = -1;
                    } else {
                        b = 8;
                    }
                    break;
                case 1567968:
                    if (!strFindAIvalue.equals("3102")) {
                        b = -1;
                    } else {
                        b = 9;
                    }
                    break;
                case 1567969:
                    if (!strFindAIvalue.equals("3103")) {
                        b = -1;
                    } else {
                        b = 10;
                    }
                    break;
                case 1567970:
                    if (!strFindAIvalue.equals("3104")) {
                        b = -1;
                    } else {
                        b = 11;
                    }
                    break;
                case 1567971:
                    if (!strFindAIvalue.equals("3105")) {
                        b = -1;
                    } else {
                        b = 12;
                    }
                    break;
                case 1567972:
                    if (!strFindAIvalue.equals("3106")) {
                        b = -1;
                    } else {
                        b = 13;
                    }
                    break;
                case 1567973:
                    if (!strFindAIvalue.equals("3107")) {
                        b = -1;
                    } else {
                        b = 14;
                    }
                    break;
                case 1567974:
                    if (!strFindAIvalue.equals("3108")) {
                        b = -1;
                    } else {
                        b = 15;
                    }
                    break;
                case 1567975:
                    if (!strFindAIvalue.equals("3109")) {
                        b = -1;
                    } else {
                        b = 16;
                    }
                    break;
                case 1568927:
                    if (!strFindAIvalue.equals("3200")) {
                        b = -1;
                    } else {
                        b = 17;
                    }
                    break;
                case 1568928:
                    if (!strFindAIvalue.equals("3201")) {
                        b = -1;
                    } else {
                        b = 18;
                    }
                    break;
                case 1568929:
                    if (!strFindAIvalue.equals("3202")) {
                        b = -1;
                    } else {
                        b = 19;
                    }
                    break;
                case 1568930:
                    if (!strFindAIvalue.equals("3203")) {
                        b = -1;
                    } else {
                        b = 20;
                    }
                    break;
                case 1568931:
                    if (!strFindAIvalue.equals("3204")) {
                        b = -1;
                    } else {
                        b = 21;
                    }
                    break;
                case 1568932:
                    if (!strFindAIvalue.equals("3205")) {
                        b = -1;
                    } else {
                        b = 22;
                    }
                    break;
                case 1568933:
                    if (!strFindAIvalue.equals("3206")) {
                        b = -1;
                    } else {
                        b = 23;
                    }
                    break;
                case 1568934:
                    if (!strFindAIvalue.equals("3207")) {
                        b = -1;
                    } else {
                        b = 24;
                    }
                    break;
                case 1568935:
                    if (!strFindAIvalue.equals("3208")) {
                        b = -1;
                    } else {
                        b = 25;
                    }
                    break;
                case 1568936:
                    if (!strFindAIvalue.equals("3209")) {
                        b = -1;
                    } else {
                        b = 26;
                    }
                    break;
                case 1575716:
                    if (!strFindAIvalue.equals("3920")) {
                        b = -1;
                    } else {
                        b = 27;
                    }
                    break;
                case 1575717:
                    if (!strFindAIvalue.equals("3921")) {
                        b = -1;
                    } else {
                        b = 28;
                    }
                    break;
                case 1575718:
                    if (!strFindAIvalue.equals("3922")) {
                        b = -1;
                    } else {
                        b = 29;
                    }
                    break;
                case 1575719:
                    if (!strFindAIvalue.equals("3923")) {
                        b = -1;
                    } else {
                        b = 30;
                    }
                    break;
                case 1575747:
                    if (!strFindAIvalue.equals("3930")) {
                        b = -1;
                    } else {
                        b = 31;
                    }
                    break;
                case 1575748:
                    if (!strFindAIvalue.equals("3931")) {
                        b = -1;
                    } else {
                        b = org.mozilla.universalchardet.prober.HebrewProber.SPACE;
                    }
                    break;
                case 1575749:
                    if (!strFindAIvalue.equals("3932")) {
                        b = -1;
                    } else {
                        b = 33;
                    }
                    break;
                case 1575750:
                    if (!strFindAIvalue.equals("3933")) {
                        b = -1;
                    } else {
                        b = 34;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    map = map;
                    str2 = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 1:
                    map = map;
                    str = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 2:
                    map = map;
                    str3 = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 3:
                    map = map;
                    str4 = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 4:
                    map = map;
                    str5 = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 5:
                    map = map;
                    str6 = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 6:
                    map = map;
                    str7 = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                    strSubstring = strFindAIvalue.substring(3);
                    str9 = com.dcloud.zxing2.client.result.ExpandedProductParsedResult.KILOGRAM;
                    break;
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    strSubstring = strFindAIvalue.substring(3);
                    str9 = com.dcloud.zxing2.client.result.ExpandedProductParsedResult.POUND;
                    break;
                case 27:
                case 28:
                case 29:
                case 30:
                    map = map;
                    strSubstring3 = strFindAIvalue.substring(3);
                    strSubstring2 = strFindValue;
                    continue;
                    map = map;
                    i = length2;
                    break;
                case 31:
                case 32:
                case 33:
                case 34:
                    if (strFindValue.length() < 4) {
                        return null;
                    }
                    strSubstring2 = strFindValue.substring(3);
                    map = map;
                    strSubstring4 = strFindValue.substring(0, 3);
                    strSubstring3 = strFindAIvalue.substring(3);
                    continue;
                    map = map;
                    i = length2;
                    break;
                default:
                    map.put(strFindAIvalue, strFindValue);
                    map = map;
                    continue;
                    map = map;
                    i = length2;
                    break;
            }
            str8 = strFindValue;
            map = map;
            i = length2;
        }
        return new com.dcloud.zxing2.client.result.ExpandedProductParsedResult(massagedText, str, str2, str3, str4, str5, str6, str7, str8, str9, strSubstring, strSubstring2, strSubstring3, strSubstring4, map);
    }
}
