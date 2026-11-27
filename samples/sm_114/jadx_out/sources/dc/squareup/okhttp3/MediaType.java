package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class MediaType {
    private static final java.lang.String QUOTED = "\"([^\"]*)\"";
    private static final java.lang.String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final java.lang.String charset;
    private final java.lang.String mediaType;
    private final java.lang.String subtype;
    private final java.lang.String type;
    private static final java.util.regex.Pattern TYPE_SUBTYPE = java.util.regex.Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final java.util.regex.Pattern PARAMETER = java.util.regex.Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    private MediaType(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.charset = str4;
    }

    public static dc.squareup.okhttp3.MediaType get(java.lang.String str) {
        java.util.regex.Matcher matcher = TYPE_SUBTYPE.matcher(str);
        if (!matcher.lookingAt()) {
            throw new java.lang.IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        java.lang.String strGroup = matcher.group(1);
        java.util.Locale locale = java.util.Locale.US;
        java.lang.String lowerCase = strGroup.toLowerCase(locale);
        java.lang.String lowerCase2 = matcher.group(2).toLowerCase(locale);
        java.util.regex.Matcher matcher2 = PARAMETER.matcher(str);
        java.lang.String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                throw new java.lang.IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(iEnd) + "\" for: \"" + str + '\"');
            }
            java.lang.String strGroup2 = matcher2.group(1);
            if (strGroup2 != null && strGroup2.equalsIgnoreCase("charset")) {
                java.lang.String strGroup3 = matcher2.group(2);
                if (strGroup3 == null) {
                    strGroup3 = matcher2.group(3);
                } else if (strGroup3.startsWith("'") && strGroup3.endsWith("'") && strGroup3.length() > 2) {
                    strGroup3 = strGroup3.substring(1, strGroup3.length() - 1);
                }
                if (str2 != null && !strGroup3.equalsIgnoreCase(str2)) {
                    throw new java.lang.IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + strGroup3 + "\" for: \"" + str + '\"');
                }
                str2 = strGroup3;
            }
        }
        return new dc.squareup.okhttp3.MediaType(str, lowerCase, lowerCase2, str2);
    }

    public static dc.squareup.okhttp3.MediaType parse(java.lang.String str) {
        try {
            return get(str);
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    public java.nio.charset.Charset charset() {
        return charset(null);
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof dc.squareup.okhttp3.MediaType) && ((dc.squareup.okhttp3.MediaType) obj).mediaType.equals(this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public java.lang.String subtype() {
        return this.subtype;
    }

    public java.lang.String toString() {
        return this.mediaType;
    }

    public java.lang.String type() {
        return this.type;
    }

    public java.nio.charset.Charset charset(java.nio.charset.Charset charset) {
        try {
            java.lang.String str = this.charset;
            return str != null ? java.nio.charset.Charset.forName(str) : charset;
        } catch (java.lang.IllegalArgumentException unused) {
            return charset;
        }
    }
}
