package dc.squareup.okhttp3.internal.http;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class HttpHeaders {
    private static final dc.squareup.okio.ByteString QUOTED_STRING_DELIMITERS = dc.squareup.okio.ByteString.encodeUtf8("\"\\");
    private static final dc.squareup.okio.ByteString TOKEN_DELIMITERS = dc.squareup.okio.ByteString.encodeUtf8("\t ,=");

    private HttpHeaders() {
    }

    public static long contentLength(dc.squareup.okhttp3.Response response) {
        return contentLength(response.headers());
    }

    public static boolean hasBody(dc.squareup.okhttp3.Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int iCode = response.code();
        return (((iCode >= 100 && iCode < 200) || iCode == 204 || iCode == 304) && contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) ? false : true;
    }

    public static boolean hasVaryAll(dc.squareup.okhttp3.Response response) {
        return hasVaryAll(response.headers());
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0088  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:61:0x007d A[EDGE_INSN: B:61:0x007d->B:28:0x007d BREAK  A[LOOP:2: B:22:0x006a->B:51:0x00c5], SYNTHETIC] */
    private static void parseChallengeHeader(java.util.List<dc.squareup.okhttp3.Challenge> list, dc.squareup.okio.Buffer buffer) {
        java.lang.String token;
        while (true) {
            java.lang.String token2 = null;
            while (true) {
                if (token2 == null) {
                    skipWhitespaceAndCommas(buffer);
                    token2 = readToken(buffer);
                    if (token2 == null) {
                        return;
                    }
                }
                boolean zSkipWhitespaceAndCommas = skipWhitespaceAndCommas(buffer);
                java.lang.String token3 = readToken(buffer);
                if (token3 == null) {
                    if (buffer.exhausted()) {
                        list.add(new dc.squareup.okhttp3.Challenge(token2, (java.util.Map<java.lang.String, java.lang.String>) java.util.Collections.EMPTY_MAP));
                        return;
                    }
                    return;
                }
                int iSkipAll = skipAll(buffer, kotlin.io.encoding.Base64.padSymbol);
                boolean zSkipWhitespaceAndCommas2 = skipWhitespaceAndCommas(buffer);
                if (zSkipWhitespaceAndCommas || !(zSkipWhitespaceAndCommas2 || buffer.exhausted())) {
                    java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
                    int iSkipAll2 = iSkipAll + skipAll(buffer, kotlin.io.encoding.Base64.padSymbol);
                    while (true) {
                        if (token3 == null) {
                            token3 = readToken(buffer);
                            if (skipWhitespaceAndCommas(buffer)) {
                                break;
                            }
                            iSkipAll2 = skipAll(buffer, kotlin.io.encoding.Base64.padSymbol);
                            if (iSkipAll2 == 0) {
                                break;
                            }
                            if (iSkipAll2 <= 1 || skipWhitespaceAndCommas(buffer)) {
                                return;
                            }
                            if (buffer.exhausted() && buffer.getByte(0L) == 34) {
                                token = readQuotedString(buffer);
                            } else {
                                token = readToken(buffer);
                            }
                            if (token != null || ((java.lang.String) linkedHashMap.put(token3, token)) != null) {
                                return;
                            }
                            if (skipWhitespaceAndCommas(buffer) && !buffer.exhausted()) {
                                return;
                            } else {
                                token3 = null;
                            }
                        } else {
                            if (iSkipAll2 == 0) {
                                break;
                                break;
                            }
                            if (iSkipAll2 <= 1) {
                                return;
                            }
                            if (buffer.exhausted()) {
                                token = readToken(buffer);
                            } else {
                                token = readToken(buffer);
                            }
                            if (token != null) {
                                return;
                            }
                            if (skipWhitespaceAndCommas(buffer)) {
                            }
                            token3 = null;
                        }
                    }
                    list.add(new dc.squareup.okhttp3.Challenge(token2, linkedHashMap));
                    token2 = token3;
                } else {
                    list.add(new dc.squareup.okhttp3.Challenge(token2, (java.util.Map<java.lang.String, java.lang.String>) java.util.Collections.singletonMap(null, token3 + repeat('=', iSkipAll))));
                }
            }
        }
    }

    public static java.util.List<dc.squareup.okhttp3.Challenge> parseChallenges(dc.squareup.okhttp3.Headers headers, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < headers.size(); i++) {
            if (str.equalsIgnoreCase(headers.name(i))) {
                parseChallengeHeader(arrayList, new dc.squareup.okio.Buffer().writeUtf8(headers.value(i)));
            }
        }
        return arrayList;
    }

    public static int parseSeconds(java.lang.String str, int i) {
        try {
            long j = java.lang.Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (java.lang.NumberFormatException unused) {
            return i;
        }
    }

    private static java.lang.String readQuotedString(dc.squareup.okio.Buffer buffer) {
        if (buffer.readByte() != 34) {
            throw new java.lang.IllegalArgumentException();
        }
        dc.squareup.okio.Buffer buffer2 = new dc.squareup.okio.Buffer();
        while (true) {
            long jIndexOfElement = buffer.indexOfElement(QUOTED_STRING_DELIMITERS);
            if (jIndexOfElement == -1) {
                return null;
            }
            if (buffer.getByte(jIndexOfElement) == 34) {
                buffer2.write(buffer, jIndexOfElement);
                buffer.readByte();
                return buffer2.readUtf8();
            }
            if (buffer.size() == jIndexOfElement + 1) {
                return null;
            }
            buffer2.write(buffer, jIndexOfElement);
            buffer.readByte();
            buffer2.write(buffer, 1L);
        }
    }

    private static java.lang.String readToken(dc.squareup.okio.Buffer buffer) {
        try {
            long jIndexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
            if (jIndexOfElement == -1) {
                jIndexOfElement = buffer.size();
            }
            if (jIndexOfElement != 0) {
                return buffer.readUtf8(jIndexOfElement);
            }
            return null;
        } catch (java.io.EOFException unused) {
            throw new java.lang.AssertionError();
        }
    }

    public static void receiveHeaders(dc.squareup.okhttp3.CookieJar cookieJar, dc.squareup.okhttp3.HttpUrl httpUrl, dc.squareup.okhttp3.Headers headers) {
        if (cookieJar == dc.squareup.okhttp3.CookieJar.NO_COOKIES) {
            return;
        }
        java.util.List<dc.squareup.okhttp3.Cookie> all = dc.squareup.okhttp3.Cookie.parseAll(httpUrl, headers);
        if (all.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, all);
    }

    private static java.lang.String repeat(char c, int i) {
        char[] cArr = new char[i];
        java.util.Arrays.fill(cArr, c);
        return new java.lang.String(cArr);
    }

    private static int skipAll(dc.squareup.okio.Buffer buffer, byte b) {
        int i = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b) {
            i++;
            buffer.readByte();
        }
        return i;
    }

    public static int skipUntil(java.lang.String str, int i, java.lang.String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int skipWhitespace(java.lang.String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }

    private static boolean skipWhitespaceAndCommas(dc.squareup.okio.Buffer buffer) {
        boolean z = false;
        while (!buffer.exhausted()) {
            byte b = buffer.getByte(0L);
            if (b != 44) {
                if (b != 32 && b != 9) {
                    break;
                }
                buffer.readByte();
            } else {
                buffer.readByte();
                z = true;
            }
        }
        return z;
    }

    private static long stringToLong(java.lang.String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return java.lang.Long.parseLong(str);
        } catch (java.lang.NumberFormatException unused) {
            return -1L;
        }
    }

    private static java.util.Set<java.lang.String> varyFields(dc.squareup.okhttp3.Response response) {
        return varyFields(response.headers());
    }

    public static dc.squareup.okhttp3.Headers varyHeaders(dc.squareup.okhttp3.Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static boolean varyMatches(dc.squareup.okhttp3.Response response, dc.squareup.okhttp3.Headers headers, dc.squareup.okhttp3.Request request) {
        for (java.lang.String str : varyFields(response)) {
            if (!dc.squareup.okhttp3.internal.Util.equal(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }

    public static long contentLength(dc.squareup.okhttp3.Headers headers) {
        return stringToLong(headers.get("Content-Length"));
    }

    public static boolean hasVaryAll(dc.squareup.okhttp3.Headers headers) {
        return varyFields(headers).contains("*");
    }

    public static java.util.Set<java.lang.String> varyFields(dc.squareup.okhttp3.Headers headers) {
        java.util.Set<java.lang.String> treeSet = java.util.Collections.EMPTY_SET;
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if ("Vary".equalsIgnoreCase(headers.name(i))) {
                java.lang.String strValue = headers.value(i);
                if (treeSet.isEmpty()) {
                    treeSet = new java.util.TreeSet<>((java.util.Comparator<? super java.lang.String>) java.lang.String.CASE_INSENSITIVE_ORDER);
                }
                for (java.lang.String str : strValue.split(",")) {
                    treeSet.add(str.trim());
                }
            }
        }
        return treeSet;
    }

    public static dc.squareup.okhttp3.Headers varyHeaders(dc.squareup.okhttp3.Headers headers, dc.squareup.okhttp3.Headers headers2) {
        java.util.Set<java.lang.String> setVaryFields = varyFields(headers2);
        if (setVaryFields.isEmpty()) {
            return new dc.squareup.okhttp3.Headers.Builder().build();
        }
        dc.squareup.okhttp3.Headers.Builder builder = new dc.squareup.okhttp3.Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            java.lang.String strName = headers.name(i);
            if (setVaryFields.contains(strName)) {
                builder.add(strName, headers.value(i));
            }
        }
        return builder.build();
    }
}
