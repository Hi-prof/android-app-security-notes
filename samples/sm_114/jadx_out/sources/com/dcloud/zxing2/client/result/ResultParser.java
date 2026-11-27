package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResultParser {
    private static final java.lang.String BYTE_ORDER_MARK = "\ufeff";
    private static final com.dcloud.zxing2.client.result.ResultParser[] PARSERS = {new com.dcloud.zxing2.client.result.BookmarkDoCoMoResultParser(), new com.dcloud.zxing2.client.result.AddressBookDoCoMoResultParser(), new com.dcloud.zxing2.client.result.EmailDoCoMoResultParser(), new com.dcloud.zxing2.client.result.AddressBookAUResultParser(), new com.dcloud.zxing2.client.result.VCardResultParser(), new com.dcloud.zxing2.client.result.BizcardResultParser(), new com.dcloud.zxing2.client.result.VEventResultParser(), new com.dcloud.zxing2.client.result.EmailAddressResultParser(), new com.dcloud.zxing2.client.result.SMTPResultParser(), new com.dcloud.zxing2.client.result.TelResultParser(), new com.dcloud.zxing2.client.result.SMSMMSResultParser(), new com.dcloud.zxing2.client.result.SMSTOMMSTOResultParser(), new com.dcloud.zxing2.client.result.GeoResultParser(), new com.dcloud.zxing2.client.result.WifiResultParser(), new com.dcloud.zxing2.client.result.URLTOResultParser(), new com.dcloud.zxing2.client.result.URIResultParser(), new com.dcloud.zxing2.client.result.ISBNResultParser(), new com.dcloud.zxing2.client.result.ProductResultParser(), new com.dcloud.zxing2.client.result.ExpandedProductResultParser(), new com.dcloud.zxing2.client.result.VINResultParser()};
    private static final java.util.regex.Pattern DIGITS = java.util.regex.Pattern.compile("\\d+");
    private static final java.util.regex.Pattern AMPERSAND = java.util.regex.Pattern.compile("&");
    private static final java.util.regex.Pattern EQUALS = java.util.regex.Pattern.compile("=");

    private static void appendKeyValue(java.lang.CharSequence charSequence, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String[] strArrSplit = EQUALS.split(charSequence, 2);
        if (strArrSplit.length == 2) {
            try {
                map.put(strArrSplit[0], urlDecode(strArrSplit[1]));
            } catch (java.lang.IllegalArgumentException unused) {
            }
        }
    }

    private static int countPrecedingBackslashes(java.lang.CharSequence charSequence, int i) {
        int i2 = 0;
        for (int i3 = i - 1; i3 >= 0 && charSequence.charAt(i3) == '\\'; i3--) {
            i2++;
        }
        return i2;
    }

    protected static java.lang.String getMassagedText(com.dcloud.zxing2.Result result) {
        java.lang.String text = result.getText();
        return text.startsWith(BYTE_ORDER_MARK) ? text.substring(1) : text;
    }

    protected static boolean isStringOfDigits(java.lang.CharSequence charSequence, int i) {
        return charSequence != null && i > 0 && i == charSequence.length() && DIGITS.matcher(charSequence).matches();
    }

    protected static boolean isSubstringOfDigits(java.lang.CharSequence charSequence, int i, int i2) {
        int i3;
        return charSequence != null && i2 > 0 && charSequence.length() >= (i3 = i2 + i) && DIGITS.matcher(charSequence.subSequence(i, i3)).matches();
    }

    static java.lang.String[] matchPrefixedField(java.lang.String str, java.lang.String str2, char c, boolean z) {
        int length = str2.length();
        java.util.ArrayList arrayList = null;
        int i = 0;
        while (i < length) {
            int iIndexOf = str2.indexOf(str, i);
            if (iIndexOf < 0) {
                break;
            }
            int length2 = iIndexOf + str.length();
            java.util.ArrayList arrayList2 = arrayList;
            boolean z2 = true;
            int length3 = length2;
            while (z2) {
                int iIndexOf2 = str2.indexOf(c, length3);
                if (iIndexOf2 < 0) {
                    length3 = str2.length();
                } else if (countPrecedingBackslashes(str2, iIndexOf2) % 2 != 0) {
                    length3 = iIndexOf2 + 1;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new java.util.ArrayList(3);
                    }
                    java.lang.String strUnescapeBackslash = unescapeBackslash(str2.substring(length2, iIndexOf2));
                    if (z) {
                        strUnescapeBackslash = strUnescapeBackslash.trim();
                    }
                    if (!strUnescapeBackslash.isEmpty()) {
                        arrayList2.add(strUnescapeBackslash);
                    }
                    length3 = iIndexOf2 + 1;
                }
                z2 = false;
            }
            i = length3;
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    static java.lang.String matchSinglePrefixedField(java.lang.String str, java.lang.String str2, char c, boolean z) {
        java.lang.String[] strArrMatchPrefixedField = matchPrefixedField(str, str2, c, z);
        if (strArrMatchPrefixedField == null) {
            return null;
        }
        return strArrMatchPrefixedField[0];
    }

    protected static void maybeAppend(java.lang.String str, java.lang.StringBuilder sb) {
        if (str != null) {
            sb.append('\n');
            sb.append(str);
        }
    }

    protected static java.lang.String[] maybeWrap(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return new java.lang.String[]{str};
    }

    protected static int parseHexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return c - '7';
    }

    static java.util.Map<java.lang.String, java.lang.String> parseNameValuePairs(java.lang.String str) {
        int iIndexOf = str.indexOf(63);
        if (iIndexOf < 0) {
            return null;
        }
        java.util.HashMap map = new java.util.HashMap(3);
        for (java.lang.String str2 : AMPERSAND.split(str.substring(iIndexOf + 1))) {
            appendKeyValue(str2, map);
        }
        return map;
    }

    public static com.dcloud.zxing2.client.result.ParsedResult parseResult(com.dcloud.zxing2.Result result) {
        for (com.dcloud.zxing2.client.result.ResultParser resultParser : PARSERS) {
            com.dcloud.zxing2.client.result.ParsedResult parsedResult = resultParser.parse(result);
            if (parsedResult != null) {
                return parsedResult;
            }
        }
        return new com.dcloud.zxing2.client.result.TextParsedResult(result.getText(), null);
    }

    protected static java.lang.String unescapeBackslash(java.lang.String str) {
        int iIndexOf = str.indexOf(92);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str.length();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, iIndexOf);
        boolean z = false;
        while (iIndexOf < length) {
            char cCharAt = str.charAt(iIndexOf);
            if (z || cCharAt != '\\') {
                sb.append(cCharAt);
                z = false;
            } else {
                z = true;
            }
            iIndexOf++;
        }
        return sb.toString();
    }

    static java.lang.String urlDecode(java.lang.String str) {
        try {
            return java.net.URLDecoder.decode(str, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.IllegalStateException(e);
        }
    }

    public abstract com.dcloud.zxing2.client.result.ParsedResult parse(com.dcloud.zxing2.Result result);

    protected static void maybeAppend(java.lang.String[] strArr, java.lang.StringBuilder sb) {
        if (strArr != null) {
            for (java.lang.String str : strArr) {
                sb.append('\n');
                sb.append(str);
            }
        }
    }
}
