package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class HttpUrl {
    static final java.lang.String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final java.lang.String FRAGMENT_ENCODE_SET = "";
    static final java.lang.String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static final java.lang.String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final java.lang.String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final java.lang.String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    static final java.lang.String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    static final java.lang.String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    static final java.lang.String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    static final java.lang.String QUERY_ENCODE_SET = " \"'<>#";
    static final java.lang.String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final java.lang.String fragment;
    final java.lang.String host;
    private final java.lang.String password;
    private final java.util.List<java.lang.String> pathSegments;
    final int port;
    private final java.util.List<java.lang.String> queryNamesAndValues;
    final java.lang.String scheme;
    private final java.lang.String url;
    private final java.lang.String username;

    HttpUrl(dc.squareup.okhttp3.HttpUrl.Builder builder) {
        this.scheme = builder.scheme;
        this.username = percentDecode(builder.encodedUsername, false);
        this.password = percentDecode(builder.encodedPassword, false);
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.pathSegments = percentDecode(builder.encodedPathSegments, false);
        java.util.List<java.lang.String> list = builder.encodedQueryNamesAndValues;
        this.queryNamesAndValues = list != null ? percentDecode(list, true) : null;
        java.lang.String str = builder.encodedFragment;
        this.fragment = str != null ? percentDecode(str, false) : null;
        this.url = builder.toString();
    }

    static java.lang.String canonicalize(java.lang.String str, int i, int i2, java.lang.String str2, boolean z, boolean z2, boolean z3, boolean z4, java.nio.charset.Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && (!z || (z2 && !percentEncoded(str, iCharCount, i2)))) || (iCodePointAt == 43 && z3)))) {
                dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
                buffer.writeUtf8(str, i, iCharCount);
                canonicalize(buffer, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                return buffer.readUtf8();
            }
            iCharCount += java.lang.Character.charCount(iCodePointAt);
        }
        return str.substring(i, i2);
    }

    public static int defaultPort(java.lang.String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static dc.squareup.okhttp3.HttpUrl get(java.lang.String str) {
        return new dc.squareup.okhttp3.HttpUrl.Builder().parse(null, str).build();
    }

    static void namesAndValuesToQueryString(java.lang.StringBuilder sb, java.util.List<java.lang.String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            java.lang.String str = list.get(i);
            java.lang.String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(kotlin.text.Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static dc.squareup.okhttp3.HttpUrl parse(java.lang.String str) {
        try {
            return get(str);
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    static void pathSegmentsToString(java.lang.StringBuilder sb, java.util.List<java.lang.String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    static java.lang.String percentDecode(java.lang.String str, boolean z) {
        return percentDecode(str, 0, str.length(), z);
    }

    static boolean percentEncoded(java.lang.String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && dc.squareup.okhttp3.internal.Util.decodeHexDigit(str.charAt(i + 1)) != -1 && dc.squareup.okhttp3.internal.Util.decodeHexDigit(str.charAt(i3)) != -1;
    }

    static java.util.List<java.lang.String> queryStringToNamesAndValues(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    public java.lang.String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(this.url.indexOf(35) + 1);
    }

    public java.lang.String encodedPassword() {
        if (this.password.isEmpty()) {
            return "";
        }
        return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, this.url.indexOf(64));
    }

    public java.lang.String encodedPath() {
        int iIndexOf = this.url.indexOf(47, this.scheme.length() + 3);
        java.lang.String str = this.url;
        return this.url.substring(iIndexOf, dc.squareup.okhttp3.internal.Util.delimiterOffset(str, iIndexOf, str.length(), "?#"));
    }

    public java.util.List<java.lang.String> encodedPathSegments() {
        int iIndexOf = this.url.indexOf(47, this.scheme.length() + 3);
        java.lang.String str = this.url;
        int iDelimiterOffset = dc.squareup.okhttp3.internal.Util.delimiterOffset(str, iIndexOf, str.length(), "?#");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (iIndexOf < iDelimiterOffset) {
            int i = iIndexOf + 1;
            int iDelimiterOffset2 = dc.squareup.okhttp3.internal.Util.delimiterOffset(this.url, i, iDelimiterOffset, '/');
            arrayList.add(this.url.substring(i, iDelimiterOffset2));
            iIndexOf = iDelimiterOffset2;
        }
        return arrayList;
    }

    public java.lang.String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int iIndexOf = this.url.indexOf(63) + 1;
        java.lang.String str = this.url;
        return this.url.substring(iIndexOf, dc.squareup.okhttp3.internal.Util.delimiterOffset(str, iIndexOf, str.length(), '#'));
    }

    public java.lang.String encodedUsername() {
        if (this.username.isEmpty()) {
            return "";
        }
        int length = this.scheme.length() + 3;
        java.lang.String str = this.url;
        return this.url.substring(length, dc.squareup.okhttp3.internal.Util.delimiterOffset(str, length, str.length(), ":@"));
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof dc.squareup.okhttp3.HttpUrl) && ((dc.squareup.okhttp3.HttpUrl) obj).url.equals(this.url);
    }

    public java.lang.String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public java.lang.String host() {
        return this.host;
    }

    public boolean isHttps() {
        return this.scheme.equals("https");
    }

    public dc.squareup.okhttp3.HttpUrl.Builder newBuilder() {
        dc.squareup.okhttp3.HttpUrl.Builder builder = new dc.squareup.okhttp3.HttpUrl.Builder();
        builder.scheme = this.scheme;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        builder.port = this.port != defaultPort(this.scheme) ? this.port : -1;
        builder.encodedPathSegments.clear();
        builder.encodedPathSegments.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.encodedFragment = encodedFragment();
        return builder;
    }

    public java.lang.String password() {
        return this.password;
    }

    public java.util.List<java.lang.String> pathSegments() {
        return this.pathSegments;
    }

    public int pathSize() {
        return this.pathSegments.size();
    }

    public int port() {
        return this.port;
    }

    public java.lang.String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        namesAndValuesToQueryString(sb, this.queryNamesAndValues);
        return sb.toString();
    }

    public java.lang.String queryParameter(java.lang.String str) {
        java.util.List<java.lang.String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.queryNamesAndValues.get(i))) {
                return this.queryNamesAndValues.get(i + 1);
            }
        }
        return null;
    }

    public java.lang.String queryParameterName(int i) {
        java.util.List<java.lang.String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get(i * 2);
        }
        throw new java.lang.IndexOutOfBoundsException();
    }

    public java.util.Set<java.lang.String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return java.util.Collections.EMPTY_SET;
        }
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        int size = this.queryNamesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            linkedHashSet.add(this.queryNamesAndValues.get(i));
        }
        return java.util.Collections.unmodifiableSet(linkedHashSet);
    }

    public java.lang.String queryParameterValue(int i) {
        java.util.List<java.lang.String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i * 2) + 1);
        }
        throw new java.lang.IndexOutOfBoundsException();
    }

    public java.util.List<java.lang.String> queryParameterValues(java.lang.String str) {
        if (this.queryNamesAndValues == null) {
            return java.util.Collections.EMPTY_LIST;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int size = this.queryNamesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.queryNamesAndValues.get(i))) {
                arrayList.add(this.queryNamesAndValues.get(i + 1));
            }
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public int querySize() {
        java.util.List<java.lang.String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public java.lang.String redact() {
        return newBuilder("/...").username("").password("").build().toString();
    }

    public dc.squareup.okhttp3.HttpUrl resolve(java.lang.String str) {
        dc.squareup.okhttp3.HttpUrl.Builder builderNewBuilder = newBuilder(str);
        if (builderNewBuilder != null) {
            return builderNewBuilder.build();
        }
        return null;
    }

    public java.lang.String scheme() {
        return this.scheme;
    }

    public java.lang.String toString() {
        return this.url;
    }

    public java.lang.String topPrivateDomain() {
        if (dc.squareup.okhttp3.internal.Util.verifyAsIpAddress(this.host)) {
            return null;
        }
        return dc.squareup.okhttp3.internal.publicsuffix.PublicSuffixDatabase.get().getEffectiveTldPlusOne(this.host);
    }

    public java.net.URI uri() {
        java.lang.String string = newBuilder().reencodeForUri().toString();
        try {
            return new java.net.URI(string);
        } catch (java.net.URISyntaxException e) {
            try {
                return java.net.URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (java.lang.Exception unused) {
                throw new java.lang.RuntimeException(e);
            }
        }
    }

    public java.net.URL url() {
        try {
            return new java.net.URL(this.url);
        } catch (java.net.MalformedURLException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public java.lang.String username() {
        return this.username;
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static final class Builder {
        static final java.lang.String INVALID_HOST = "Invalid URL host";
        java.lang.String encodedFragment;
        final java.util.List<java.lang.String> encodedPathSegments;
        java.util.List<java.lang.String> encodedQueryNamesAndValues;
        java.lang.String host;
        java.lang.String scheme;
        java.lang.String encodedUsername = "";
        java.lang.String encodedPassword = "";
        int port = -1;

        public Builder() {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private static java.lang.String canonicalizeHost(java.lang.String str, int i, int i2) {
            return dc.squareup.okhttp3.internal.Util.canonicalizeHost(dc.squareup.okhttp3.HttpUrl.percentDecode(str, i, i2, false));
        }

        private boolean isDot(java.lang.String str) {
            return str.equals(com.taobao.weex.el.parse.Operators.DOT_STR) || str.equalsIgnoreCase("%2e");
        }

        private boolean isDotDot(java.lang.String str) {
            return str.equals(io.dcloud.common.util.PdrUtil.FILE_PATH_ENTRY_BACK) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int parsePort(java.lang.String str, int i, int i2) {
            try {
                int i3 = java.lang.Integer.parseInt(dc.squareup.okhttp3.HttpUrl.canonicalize(str, i, i2, "", false, false, false, true, null));
                if (i3 <= 0 || i3 > 65535) {
                    return -1;
                }
                return i3;
            } catch (java.lang.NumberFormatException unused) {
            }
        }

        private void pop() {
            java.util.List<java.lang.String> list = this.encodedPathSegments;
            if (!list.remove(list.size() - 1).isEmpty() || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            } else {
                java.util.List<java.lang.String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
            }
        }

        private static int portColonOffset(java.lang.String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == ':') {
                    return i;
                }
                if (cCharAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private void push(java.lang.String str, int i, int i2, boolean z, boolean z2) {
            java.lang.String strCanonicalize = dc.squareup.okhttp3.HttpUrl.canonicalize(str, i, i2, dc.squareup.okhttp3.HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, true, null);
            if (isDot(strCanonicalize)) {
                return;
            }
            if (isDotDot(strCanonicalize)) {
                pop();
                return;
            }
            java.util.List<java.lang.String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).isEmpty()) {
                java.util.List<java.lang.String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, strCanonicalize);
            } else {
                this.encodedPathSegments.add(strCanonicalize);
            }
            if (z) {
                this.encodedPathSegments.add("");
            }
        }

        private void removeAllCanonicalQueryParameters(java.lang.String str) {
            for (int size = this.encodedQueryNamesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.encodedQueryNamesAndValues.get(size))) {
                    this.encodedQueryNamesAndValues.remove(size + 1);
                    this.encodedQueryNamesAndValues.remove(size);
                    if (this.encodedQueryNamesAndValues.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
            }
        }

        private void resolvePath(java.lang.String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i++;
            } else {
                java.util.List<java.lang.String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            int i3 = i;
            while (i3 < i2) {
                int iDelimiterOffset = dc.squareup.okhttp3.internal.Util.delimiterOffset(str, i3, i2, "/\\");
                boolean z = iDelimiterOffset < i2;
                str = str;
                push(str, i3, iDelimiterOffset, z, true);
                i3 = z ? iDelimiterOffset + 1 : iDelimiterOffset;
            }
        }

        private static int schemeDelimiterOffset(java.lang.String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int slashCount(java.lang.String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder addEncodedPathSegment(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedPathSegment == null");
            }
            push(str, 0, str.length(), false, true);
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder addEncodedPathSegments(java.lang.String str) {
            if (str != null) {
                return addPathSegments(str, true);
            }
            throw new java.lang.NullPointerException("encodedPathSegments == null");
        }

        public dc.squareup.okhttp3.HttpUrl.Builder addEncodedQueryParameter(java.lang.String str, java.lang.String str2) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedName == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new java.util.ArrayList();
            }
            this.encodedQueryNamesAndValues.add(dc.squareup.okhttp3.HttpUrl.canonicalize(str, dc.squareup.okhttp3.HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
            this.encodedQueryNamesAndValues.add(str2 != null ? dc.squareup.okhttp3.HttpUrl.canonicalize(str2, dc.squareup.okhttp3.HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true) : null);
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder addPathSegment(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("pathSegment == null");
            }
            push(str, 0, str.length(), false, false);
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder addPathSegments(java.lang.String str) {
            if (str != null) {
                return addPathSegments(str, false);
            }
            throw new java.lang.NullPointerException("pathSegments == null");
        }

        public dc.squareup.okhttp3.HttpUrl.Builder addQueryParameter(java.lang.String str, java.lang.String str2) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new java.util.ArrayList();
            }
            this.encodedQueryNamesAndValues.add(dc.squareup.okhttp3.HttpUrl.canonicalize(str, dc.squareup.okhttp3.HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
            this.encodedQueryNamesAndValues.add(str2 != null ? dc.squareup.okhttp3.HttpUrl.canonicalize(str2, dc.squareup.okhttp3.HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true) : null);
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl build() {
            if (this.scheme == null) {
                throw new java.lang.IllegalStateException("scheme == null");
            }
            if (this.host != null) {
                return new dc.squareup.okhttp3.HttpUrl(this);
            }
            throw new java.lang.IllegalStateException("host == null");
        }

        int effectivePort() {
            int i = this.port;
            return i != -1 ? i : dc.squareup.okhttp3.HttpUrl.defaultPort(this.scheme);
        }

        public dc.squareup.okhttp3.HttpUrl.Builder encodedFragment(java.lang.String str) {
            this.encodedFragment = str != null ? dc.squareup.okhttp3.HttpUrl.canonicalize(str, "", true, false, false, false) : null;
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder encodedPassword(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedPassword == null");
            }
            this.encodedPassword = dc.squareup.okhttp3.HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder encodedPath(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedPath == null");
            }
            if (str.startsWith("/")) {
                resolvePath(str, 0, str.length());
                return this;
            }
            throw new java.lang.IllegalArgumentException("unexpected encodedPath: " + str);
        }

        public dc.squareup.okhttp3.HttpUrl.Builder encodedQuery(java.lang.String str) {
            this.encodedQueryNamesAndValues = str != null ? dc.squareup.okhttp3.HttpUrl.queryStringToNamesAndValues(dc.squareup.okhttp3.HttpUrl.canonicalize(str, dc.squareup.okhttp3.HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder encodedUsername(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedUsername == null");
            }
            this.encodedUsername = dc.squareup.okhttp3.HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder fragment(java.lang.String str) {
            this.encodedFragment = str != null ? dc.squareup.okhttp3.HttpUrl.canonicalize(str, "", false, false, false, false) : null;
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder host(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("host == null");
            }
            java.lang.String strCanonicalizeHost = canonicalizeHost(str, 0, str.length());
            if (strCanonicalizeHost != null) {
                this.host = strCanonicalizeHost;
                return this;
            }
            throw new java.lang.IllegalArgumentException("unexpected host: " + str);
        }

        dc.squareup.okhttp3.HttpUrl.Builder parse(dc.squareup.okhttp3.HttpUrl httpUrl, java.lang.String str) {
            int iDelimiterOffset;
            java.lang.String str2;
            int i;
            java.lang.String str3;
            java.lang.String str4 = str;
            int iSkipLeadingAsciiWhitespace = dc.squareup.okhttp3.internal.Util.skipLeadingAsciiWhitespace(str4, 0, str4.length());
            int iSkipTrailingAsciiWhitespace = dc.squareup.okhttp3.internal.Util.skipTrailingAsciiWhitespace(str4, iSkipLeadingAsciiWhitespace, str4.length());
            int iSchemeDelimiterOffset = schemeDelimiterOffset(str4, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace);
            if (iSchemeDelimiterOffset != -1) {
                if (str4.regionMatches(true, iSkipLeadingAsciiWhitespace, "https:", 0, 6)) {
                    this.scheme = "https";
                    iSkipLeadingAsciiWhitespace += 6;
                    str4 = str;
                } else {
                    str4 = str;
                    if (!str4.regionMatches(true, iSkipLeadingAsciiWhitespace, "http:", 0, 5)) {
                        throw new java.lang.IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str4.substring(0, iSchemeDelimiterOffset) + "'");
                    }
                    this.scheme = "http";
                    iSkipLeadingAsciiWhitespace += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new java.lang.IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.scheme = httpUrl.scheme;
            }
            int iSlashCount = slashCount(str4, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace);
            char c = '#';
            if (iSlashCount >= 2 || httpUrl == null || !httpUrl.scheme.equals(this.scheme)) {
                int i2 = iSkipLeadingAsciiWhitespace + iSlashCount;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    iDelimiterOffset = dc.squareup.okhttp3.internal.Util.delimiterOffset(str4, i2, iSkipTrailingAsciiWhitespace, "@/\\?#");
                    byte bCharAt = iDelimiterOffset != iSkipTrailingAsciiWhitespace ? str4.charAt(iDelimiterOffset) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c || bCharAt == 47 || bCharAt == 92 || bCharAt == 63) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z) {
                            i = iDelimiterOffset;
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append(this.encodedPassword);
                            sb.append("%40");
                            str3 = str;
                            sb.append(dc.squareup.okhttp3.HttpUrl.canonicalize(str3, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
                            this.encodedPassword = sb.toString();
                        } else {
                            int iDelimiterOffset2 = dc.squareup.okhttp3.internal.Util.delimiterOffset(str4, i2, iDelimiterOffset, com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE);
                            java.lang.String strCanonicalize = dc.squareup.okhttp3.HttpUrl.canonicalize(str, i2, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strCanonicalize = this.encodedUsername + "%40" + strCanonicalize;
                            }
                            this.encodedUsername = strCanonicalize;
                            if (iDelimiterOffset2 != iDelimiterOffset) {
                                i = iDelimiterOffset;
                                this.encodedPassword = dc.squareup.okhttp3.HttpUrl.canonicalize(str, iDelimiterOffset2 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            } else {
                                i = iDelimiterOffset;
                            }
                            str3 = str;
                            z2 = true;
                        }
                        i2 = i + 1;
                        str4 = str3;
                        c = '#';
                    }
                }
                str2 = str4;
                int i3 = i2;
                int iPortColonOffset = portColonOffset(str2, i3, iDelimiterOffset);
                int i4 = iPortColonOffset + 1;
                if (i4 < iDelimiterOffset) {
                    this.host = canonicalizeHost(str2, i3, iPortColonOffset);
                    int port = parsePort(str2, i4, iDelimiterOffset);
                    this.port = port;
                    if (port == -1) {
                        throw new java.lang.IllegalArgumentException("Invalid URL port: \"" + str2.substring(i4, iDelimiterOffset) + '\"');
                    }
                } else {
                    this.host = canonicalizeHost(str2, i3, iPortColonOffset);
                    this.port = dc.squareup.okhttp3.HttpUrl.defaultPort(this.scheme);
                }
                if (this.host == null) {
                    throw new java.lang.IllegalArgumentException("Invalid URL host: \"" + str2.substring(i3, iPortColonOffset) + '\"');
                }
                iSkipLeadingAsciiWhitespace = iDelimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host;
                this.port = httpUrl.port;
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (iSkipLeadingAsciiWhitespace == iSkipTrailingAsciiWhitespace || str4.charAt(iSkipLeadingAsciiWhitespace) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                str2 = str4;
            }
            int iDelimiterOffset3 = dc.squareup.okhttp3.internal.Util.delimiterOffset(str2, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace, "?#");
            resolvePath(str2, iSkipLeadingAsciiWhitespace, iDelimiterOffset3);
            if (iDelimiterOffset3 < iSkipTrailingAsciiWhitespace && str2.charAt(iDelimiterOffset3) == '?') {
                int iDelimiterOffset4 = dc.squareup.okhttp3.internal.Util.delimiterOffset(str2, iDelimiterOffset3, iSkipTrailingAsciiWhitespace, '#');
                this.encodedQueryNamesAndValues = dc.squareup.okhttp3.HttpUrl.queryStringToNamesAndValues(dc.squareup.okhttp3.HttpUrl.canonicalize(str2, iDelimiterOffset3 + 1, iDelimiterOffset4, dc.squareup.okhttp3.HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                iDelimiterOffset3 = iDelimiterOffset4;
            }
            if (iDelimiterOffset3 < iSkipTrailingAsciiWhitespace && str2.charAt(iDelimiterOffset3) == '#') {
                this.encodedFragment = dc.squareup.okhttp3.HttpUrl.canonicalize(str2, iDelimiterOffset3 + 1, iSkipTrailingAsciiWhitespace, "", true, false, false, false, null);
            }
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder password(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("password == null");
            }
            this.encodedPassword = dc.squareup.okhttp3.HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder port(int i) {
            if (i > 0 && i <= 65535) {
                this.port = i;
                return this;
            }
            throw new java.lang.IllegalArgumentException("unexpected port: " + i);
        }

        public dc.squareup.okhttp3.HttpUrl.Builder query(java.lang.String str) {
            this.encodedQueryNamesAndValues = str != null ? dc.squareup.okhttp3.HttpUrl.queryStringToNamesAndValues(dc.squareup.okhttp3.HttpUrl.canonicalize(str, dc.squareup.okhttp3.HttpUrl.QUERY_ENCODE_SET, false, false, true, true)) : null;
            return this;
        }

        dc.squareup.okhttp3.HttpUrl.Builder reencodeForUri() {
            int size = this.encodedPathSegments.size();
            for (int i = 0; i < size; i++) {
                this.encodedPathSegments.set(i, dc.squareup.okhttp3.HttpUrl.canonicalize(this.encodedPathSegments.get(i), dc.squareup.okhttp3.HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
            }
            java.util.List<java.lang.String> list = this.encodedQueryNamesAndValues;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    java.lang.String str = this.encodedQueryNamesAndValues.get(i2);
                    if (str != null) {
                        this.encodedQueryNamesAndValues.set(i2, dc.squareup.okhttp3.HttpUrl.canonicalize(str, dc.squareup.okhttp3.HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
                    }
                }
            }
            java.lang.String str2 = this.encodedFragment;
            if (str2 != null) {
                this.encodedFragment = dc.squareup.okhttp3.HttpUrl.canonicalize(str2, dc.squareup.okhttp3.HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
            }
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder removeAllEncodedQueryParameters(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedName == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(dc.squareup.okhttp3.HttpUrl.canonicalize(str, dc.squareup.okhttp3.HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder removeAllQueryParameters(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(dc.squareup.okhttp3.HttpUrl.canonicalize(str, dc.squareup.okhttp3.HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder removePathSegment(int i) {
            this.encodedPathSegments.remove(i);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder scheme(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.scheme = "http";
                return this;
            }
            if (str.equalsIgnoreCase("https")) {
                this.scheme = "https";
                return this;
            }
            throw new java.lang.IllegalArgumentException("unexpected scheme: " + str);
        }

        public dc.squareup.okhttp3.HttpUrl.Builder setEncodedPathSegment(int i, java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("encodedPathSegment == null");
            }
            java.lang.String strCanonicalize = dc.squareup.okhttp3.HttpUrl.canonicalize(str, 0, str.length(), dc.squareup.okhttp3.HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, true, null);
            this.encodedPathSegments.set(i, strCanonicalize);
            if (!isDot(strCanonicalize) && !isDotDot(strCanonicalize)) {
                return this;
            }
            throw new java.lang.IllegalArgumentException("unexpected path segment: " + str);
        }

        public dc.squareup.okhttp3.HttpUrl.Builder setEncodedQueryParameter(java.lang.String str, java.lang.String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public dc.squareup.okhttp3.HttpUrl.Builder setPathSegment(int i, java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("pathSegment == null");
            }
            java.lang.String strCanonicalize = dc.squareup.okhttp3.HttpUrl.canonicalize(str, 0, str.length(), dc.squareup.okhttp3.HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, true, null);
            if (!isDot(strCanonicalize) && !isDotDot(strCanonicalize)) {
                this.encodedPathSegments.set(i, strCanonicalize);
                return this;
            }
            throw new java.lang.IllegalArgumentException("unexpected path segment: " + str);
        }

        public dc.squareup.okhttp3.HttpUrl.Builder setQueryParameter(java.lang.String str, java.lang.String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.encodedUsername.isEmpty() || !this.encodedPassword.isEmpty()) {
                sb.append(this.encodedUsername);
                if (!this.encodedPassword.isEmpty()) {
                    sb.append(com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE);
                    sb.append(this.encodedPassword);
                }
                sb.append(com.taobao.weex.ui.component.list.template.TemplateDom.SEPARATOR);
            }
            java.lang.String str2 = this.host;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append(com.taobao.weex.el.parse.Operators.ARRAY_START);
                    sb.append(this.host);
                    sb.append(com.taobao.weex.el.parse.Operators.ARRAY_END);
                } else {
                    sb.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int iEffectivePort = effectivePort();
                java.lang.String str3 = this.scheme;
                if (str3 == null || iEffectivePort != dc.squareup.okhttp3.HttpUrl.defaultPort(str3)) {
                    sb.append(com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE);
                    sb.append(iEffectivePort);
                }
            }
            dc.squareup.okhttp3.HttpUrl.pathSegmentsToString(sb, this.encodedPathSegments);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append(com.taobao.weex.el.parse.Operators.CONDITION_IF);
                dc.squareup.okhttp3.HttpUrl.namesAndValuesToQueryString(sb, this.encodedQueryNamesAndValues);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }

        public dc.squareup.okhttp3.HttpUrl.Builder username(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("username == null");
            }
            this.encodedUsername = dc.squareup.okhttp3.HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        private dc.squareup.okhttp3.HttpUrl.Builder addPathSegments(java.lang.String str, boolean z) {
            int i = 0;
            while (true) {
                int iDelimiterOffset = dc.squareup.okhttp3.internal.Util.delimiterOffset(str, i, str.length(), "/\\");
                java.lang.String str2 = str;
                boolean z2 = z;
                push(str2, i, iDelimiterOffset, iDelimiterOffset < str.length(), z2);
                i = iDelimiterOffset + 1;
                if (i > str2.length()) {
                    return this;
                }
                str = str2;
                z = z2;
            }
        }
    }

    public static dc.squareup.okhttp3.HttpUrl get(java.net.URL url) {
        return parse(url.toString());
    }

    private java.util.List<java.lang.String> percentDecode(java.util.List<java.lang.String> list, boolean z) {
        int size = list.size();
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        for (int i = 0; i < size; i++) {
            java.lang.String str = list.get(i);
            arrayList.add(str != null ? percentDecode(str, z) : null);
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public static dc.squareup.okhttp3.HttpUrl get(java.net.URI uri) {
        return parse(uri.toString());
    }

    static java.lang.String percentDecode(java.lang.String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
                buffer.writeUtf8(str, i, i3);
                percentDecode(buffer, str, i3, i2, z);
                return buffer.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    public dc.squareup.okhttp3.HttpUrl.Builder newBuilder(java.lang.String str) {
        try {
            return new dc.squareup.okhttp3.HttpUrl.Builder().parse(this, str);
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    static void percentDecode(dc.squareup.okio.Buffer buffer, java.lang.String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                int iDecodeHexDigit = dc.squareup.okhttp3.internal.Util.decodeHexDigit(str.charAt(i + 1));
                int iDecodeHexDigit2 = dc.squareup.okhttp3.internal.Util.decodeHexDigit(str.charAt(i3));
                if (iDecodeHexDigit != -1 && iDecodeHexDigit2 != -1) {
                    buffer.writeByte((iDecodeHexDigit << 4) + iDecodeHexDigit2);
                    i = i3;
                } else {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                }
            } else if (iCodePointAt == 43 && z) {
                buffer.writeByte(32);
            } else {
                buffer.writeUtf8CodePoint(iCodePointAt);
            }
            i += java.lang.Character.charCount(iCodePointAt);
        }
    }

    static void canonicalize(dc.squareup.okio.Buffer buffer, java.lang.String str, int i, int i2, java.lang.String str2, boolean z, boolean z2, boolean z3, boolean z4, java.nio.charset.Charset charset) {
        dc.squareup.okio.Buffer buffer2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    buffer.writeUtf8(z ? com.taobao.weex.el.parse.Operators.PLUS : "%2B");
                } else if (iCodePointAt >= 32 && iCodePointAt != 127 && ((iCodePointAt < 128 || !z4) && str2.indexOf(iCodePointAt) == -1 && (iCodePointAt != 37 || (z && (!z2 || percentEncoded(str, i, i2)))))) {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new dc.squareup.okio.Buffer();
                    }
                    if (charset != null && !charset.equals(dc.squareup.okhttp3.internal.Util.UTF_8)) {
                        buffer2.writeString(str, i, java.lang.Character.charCount(iCodePointAt) + i, charset);
                    } else {
                        buffer2.writeUtf8CodePoint(iCodePointAt);
                    }
                    while (!buffer2.exhausted()) {
                        byte b = buffer2.readByte();
                        buffer.writeByte(37);
                        char[] cArr = HEX_DIGITS;
                        buffer.writeByte((int) cArr[((b & 255) >> 4) & 15]);
                        buffer.writeByte((int) cArr[b & 15]);
                    }
                }
            }
            i += java.lang.Character.charCount(iCodePointAt);
        }
    }

    static java.lang.String canonicalize(java.lang.String str, java.lang.String str2, boolean z, boolean z2, boolean z3, boolean z4, java.nio.charset.Charset charset) {
        return canonicalize(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    static java.lang.String canonicalize(java.lang.String str, java.lang.String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return canonicalize(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
