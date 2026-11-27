package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class VCardResultParser extends com.dcloud.zxing2.client.result.ResultParser {
    private static final java.util.regex.Pattern BEGIN_VCARD = java.util.regex.Pattern.compile("BEGIN:VCARD", 2);
    private static final java.util.regex.Pattern VCARD_LIKE_DATE = java.util.regex.Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
    private static final java.util.regex.Pattern CR_LF_SPACE_TAB = java.util.regex.Pattern.compile("\r\n[ \t]");
    private static final java.util.regex.Pattern NEWLINE_ESCAPE = java.util.regex.Pattern.compile("\\\\[nN]");
    private static final java.util.regex.Pattern VCARD_ESCAPES = java.util.regex.Pattern.compile("\\\\([,;\\\\])");
    private static final java.util.regex.Pattern EQUALS = java.util.regex.Pattern.compile("=");
    private static final java.util.regex.Pattern SEMICOLON = java.util.regex.Pattern.compile(";");
    private static final java.util.regex.Pattern UNESCAPED_SEMICOLONS = java.util.regex.Pattern.compile("(?<!\\\\);+");
    private static final java.util.regex.Pattern COMMA = java.util.regex.Pattern.compile(",");
    private static final java.util.regex.Pattern SEMICOLON_OR_COMMA = java.util.regex.Pattern.compile("[;,]");

    private static java.lang.String decodeQuotedPrintable(java.lang.CharSequence charSequence, java.lang.String str) {
        char cCharAt;
        int length = charSequence.length();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length);
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        int i = 0;
        while (i < length) {
            char cCharAt2 = charSequence.charAt(i);
            if (cCharAt2 != '\n' && cCharAt2 != '\r') {
                if (cCharAt2 != '=') {
                    maybeAppendFragment(byteArrayOutputStream, str, sb);
                    sb.append(cCharAt2);
                } else if (i < length - 2 && (cCharAt = charSequence.charAt(i + 1)) != '\r' && cCharAt != '\n') {
                    i += 2;
                    char cCharAt3 = charSequence.charAt(i);
                    int hexDigit = com.dcloud.zxing2.client.result.ResultParser.parseHexDigit(cCharAt);
                    int hexDigit2 = com.dcloud.zxing2.client.result.ResultParser.parseHexDigit(cCharAt3);
                    if (hexDigit >= 0 && hexDigit2 >= 0) {
                        byteArrayOutputStream.write((hexDigit << 4) + hexDigit2);
                    }
                }
            }
            i++;
        }
        maybeAppendFragment(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static void formatNames(java.lang.Iterable<java.util.List<java.lang.String>> iterable) {
        int iIndexOf;
        if (iterable != null) {
            for (java.util.List<java.lang.String> list : iterable) {
                java.lang.String str = list.get(0);
                java.lang.String[] strArr = new java.lang.String[5];
                int i = 0;
                int i2 = 0;
                while (i < 4 && (iIndexOf = str.indexOf(59, i2)) >= 0) {
                    strArr[i] = str.substring(i2, iIndexOf);
                    i++;
                    i2 = iIndexOf + 1;
                }
                strArr[i] = str.substring(i2);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(100);
                maybeAppendComponent(strArr, 3, sb);
                maybeAppendComponent(strArr, 1, sb);
                maybeAppendComponent(strArr, 2, sb);
                maybeAppendComponent(strArr, 0, sb);
                maybeAppendComponent(strArr, 4, sb);
                list.set(0, sb.toString().trim());
            }
        }
    }

    private static boolean isLikeVCardDate(java.lang.CharSequence charSequence) {
        return charSequence == null || VCARD_LIKE_DATE.matcher(charSequence).matches();
    }

    static java.util.List<java.lang.String> matchSingleVCardPrefixedField(java.lang.CharSequence charSequence, java.lang.String str, boolean z, boolean z2) {
        java.util.List<java.util.List<java.lang.String>> listMatchVCardPrefixedField = matchVCardPrefixedField(charSequence, str, z, z2);
        if (listMatchVCardPrefixedField == null || listMatchVCardPrefixedField.isEmpty()) {
            return null;
        }
        return listMatchVCardPrefixedField.get(0);
    }

    static java.util.List<java.util.List<java.lang.String>> matchVCardPrefixedField(java.lang.CharSequence charSequence, java.lang.String str, boolean z, boolean z2) {
        java.util.ArrayList arrayList;
        boolean z3;
        java.lang.String str2;
        int iIndexOf;
        java.lang.String strReplaceAll;
        int length = str.length();
        int i = 0;
        int i2 = 0;
        java.util.ArrayList arrayList2 = null;
        while (i2 < length) {
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("(?:^|\n)" + ((java.lang.Object) charSequence) + "(?:;([^:]*))?:", 2).matcher(str);
            if (i2 > 0) {
                i2--;
            }
            if (!matcher.find(i2)) {
                break;
            }
            int iEnd = matcher.end(i);
            java.lang.String strGroup = matcher.group(1);
            if (strGroup != null) {
                java.lang.String[] strArrSplit = SEMICOLON.split(strGroup);
                int length2 = strArrSplit.length;
                int i3 = 0;
                arrayList = null;
                z3 = false;
                str2 = null;
                while (i3 < length2) {
                    java.lang.String str3 = strArrSplit[i3];
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList(1);
                    }
                    arrayList.add(str3);
                    java.lang.String[] strArrSplit2 = EQUALS.split(str3, 2);
                    if (strArrSplit2.length > 1) {
                        java.lang.String str4 = strArrSplit2[i];
                        java.lang.String str5 = strArrSplit2[1];
                        if ("ENCODING".equalsIgnoreCase(str4) && "QUOTED-PRINTABLE".equalsIgnoreCase(str5)) {
                            z3 = true;
                        } else if ("CHARSET".equalsIgnoreCase(str4)) {
                            str2 = str5;
                        }
                    }
                    i3++;
                    i = 0;
                }
            } else {
                arrayList = null;
                z3 = false;
                str2 = null;
            }
            int i4 = iEnd;
            while (true) {
                iIndexOf = str.indexOf(10, i4);
                if (iIndexOf < 0) {
                    break;
                }
                if (iIndexOf < str.length() - 1) {
                    int i5 = iIndexOf + 1;
                    if (str.charAt(i5) == ' ' || str.charAt(i5) == '\t') {
                        i4 = iIndexOf + 2;
                    }
                }
                if (!z3 || ((iIndexOf < 1 || str.charAt(iIndexOf - 1) != '=') && (iIndexOf < 2 || str.charAt(iIndexOf - 2) != '='))) {
                    break;
                }
                i4 = iIndexOf + 1;
            }
            if (iIndexOf < 0) {
                i2 = length;
            } else {
                if (iIndexOf > iEnd) {
                    if (arrayList2 == null) {
                        arrayList2 = new java.util.ArrayList(1);
                    }
                    if (iIndexOf >= 1 && str.charAt(iIndexOf - 1) == '\r') {
                        iIndexOf--;
                    }
                    java.lang.String strSubstring = str.substring(iEnd, iIndexOf);
                    if (z) {
                        strSubstring = strSubstring.trim();
                    }
                    if (z3) {
                        strReplaceAll = decodeQuotedPrintable(strSubstring, str2);
                        if (z2) {
                            strReplaceAll = UNESCAPED_SEMICOLONS.matcher(strReplaceAll).replaceAll("\n").trim();
                        }
                    } else {
                        if (z2) {
                            strSubstring = UNESCAPED_SEMICOLONS.matcher(strSubstring).replaceAll("\n").trim();
                        }
                        strReplaceAll = VCARD_ESCAPES.matcher(NEWLINE_ESCAPE.matcher(CR_LF_SPACE_TAB.matcher(strSubstring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                    }
                    if (arrayList == null) {
                        java.util.ArrayList arrayList3 = new java.util.ArrayList(1);
                        arrayList3.add(strReplaceAll);
                        arrayList2.add(arrayList3);
                    } else {
                        arrayList.add(0, strReplaceAll);
                        arrayList2.add(arrayList);
                    }
                }
                i2 = iIndexOf + 1;
            }
            i = 0;
        }
        return arrayList2;
    }

    private static void maybeAppendComponent(java.lang.String[] strArr, int i, java.lang.StringBuilder sb) {
        java.lang.String str = strArr[i];
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(strArr[i]);
    }

    private static void maybeAppendFragment(java.io.ByteArrayOutputStream byteArrayOutputStream, java.lang.String str, java.lang.StringBuilder sb) {
        java.lang.String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new java.lang.String(byteArray, java.nio.charset.Charset.forName("UTF-8"));
            } else {
                try {
                    str2 = new java.lang.String(byteArray, str);
                } catch (java.io.UnsupportedEncodingException unused) {
                    str2 = new java.lang.String(byteArray, java.nio.charset.Charset.forName("UTF-8"));
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    private static java.lang.String toPrimaryValue(java.util.List<java.lang.String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static java.lang.String[] toPrimaryValues(java.util.Collection<java.util.List<java.lang.String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        java.util.Iterator<java.util.List<java.lang.String>> it = collection.iterator();
        while (it.hasNext()) {
            java.lang.String str = it.next().get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[collection.size()]);
    }

    private static java.lang.String[] toTypes(java.util.Collection<java.util.List<java.lang.String>> collection) {
        java.lang.String strSubstring;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        for (java.util.List<java.lang.String> list : collection) {
            int i = 1;
            while (true) {
                if (i >= list.size()) {
                    strSubstring = null;
                    break;
                }
                strSubstring = list.get(i);
                int iIndexOf = strSubstring.indexOf(61);
                if (iIndexOf < 0) {
                    break;
                }
                if (io.dcloud.feature.barcode2.decoding.Intents.WifiConnect.TYPE.equalsIgnoreCase(strSubstring.substring(0, iIndexOf))) {
                    strSubstring = strSubstring.substring(iIndexOf + 1);
                    break;
                }
                i++;
            }
            arrayList.add(strSubstring);
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[collection.size()]);
    }

    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.AddressBookParsedResult parse(com.dcloud.zxing2.Result result) {
        java.lang.String massagedText = com.dcloud.zxing2.client.result.ResultParser.getMassagedText(result);
        java.util.regex.Matcher matcher = BEGIN_VCARD.matcher(massagedText);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        java.util.List<java.util.List<java.lang.String>> listMatchVCardPrefixedField = matchVCardPrefixedField("FN", massagedText, true, false);
        if (listMatchVCardPrefixedField == null) {
            listMatchVCardPrefixedField = matchVCardPrefixedField("N", massagedText, true, false);
            formatNames(listMatchVCardPrefixedField);
        }
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField = matchSingleVCardPrefixedField("NICKNAME", massagedText, true, false);
        java.lang.String[] strArrSplit = listMatchSingleVCardPrefixedField == null ? null : COMMA.split(listMatchSingleVCardPrefixedField.get(0));
        java.util.List<java.util.List<java.lang.String>> listMatchVCardPrefixedField2 = matchVCardPrefixedField("TEL", massagedText, true, false);
        java.util.List<java.util.List<java.lang.String>> listMatchVCardPrefixedField3 = matchVCardPrefixedField("EMAIL", massagedText, true, false);
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField2 = matchSingleVCardPrefixedField("NOTE", massagedText, false, false);
        java.util.List<java.util.List<java.lang.String>> listMatchVCardPrefixedField4 = matchVCardPrefixedField("ADR", massagedText, true, true);
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField3 = matchSingleVCardPrefixedField("ORG", massagedText, true, true);
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField4 = matchSingleVCardPrefixedField("BDAY", massagedText, true, false);
        if (listMatchSingleVCardPrefixedField4 != null && !isLikeVCardDate(listMatchSingleVCardPrefixedField4.get(0))) {
            listMatchSingleVCardPrefixedField4 = null;
        }
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField5 = matchSingleVCardPrefixedField("TITLE", massagedText, true, false);
        java.util.List<java.util.List<java.lang.String>> listMatchVCardPrefixedField5 = matchVCardPrefixedField("URL", massagedText, true, false);
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField6 = matchSingleVCardPrefixedField("IMPP", massagedText, true, false);
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField7 = matchSingleVCardPrefixedField("GEO", massagedText, true, false);
        java.lang.String[] strArrSplit2 = listMatchSingleVCardPrefixedField7 == null ? null : SEMICOLON_OR_COMMA.split(listMatchSingleVCardPrefixedField7.get(0));
        return new com.dcloud.zxing2.client.result.AddressBookParsedResult(toPrimaryValues(listMatchVCardPrefixedField), strArrSplit, null, toPrimaryValues(listMatchVCardPrefixedField2), toTypes(listMatchVCardPrefixedField2), toPrimaryValues(listMatchVCardPrefixedField3), toTypes(listMatchVCardPrefixedField3), toPrimaryValue(listMatchSingleVCardPrefixedField6), toPrimaryValue(listMatchSingleVCardPrefixedField2), toPrimaryValues(listMatchVCardPrefixedField4), toTypes(listMatchVCardPrefixedField4), toPrimaryValue(listMatchSingleVCardPrefixedField3), toPrimaryValue(listMatchSingleVCardPrefixedField4), toPrimaryValue(listMatchSingleVCardPrefixedField5), toPrimaryValues(listMatchVCardPrefixedField5), (strArrSplit2 == null || strArrSplit2.length == 2) ? strArrSplit2 : null);
    }
}
