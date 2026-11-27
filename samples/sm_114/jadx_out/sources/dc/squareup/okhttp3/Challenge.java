package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Challenge {
    private final java.util.Map<java.lang.String, java.lang.String> authParams;
    private final java.lang.String scheme;

    public Challenge(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (str == null) {
            throw new java.lang.NullPointerException("scheme == null");
        }
        if (map == null) {
            throw new java.lang.NullPointerException("authParams == null");
        }
        this.scheme = str;
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey() == null ? null : entry.getKey().toLowerCase(java.util.Locale.US), entry.getValue());
        }
        this.authParams = java.util.Collections.unmodifiableMap(linkedHashMap);
    }

    public java.util.Map<java.lang.String, java.lang.String> authParams() {
        return this.authParams;
    }

    public java.nio.charset.Charset charset() {
        java.lang.String str = this.authParams.get("charset");
        if (str != null) {
            try {
                return java.nio.charset.Charset.forName(str);
            } catch (java.lang.Exception unused) {
            }
        }
        return dc.squareup.okhttp3.internal.Util.ISO_8859_1;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof dc.squareup.okhttp3.Challenge)) {
            return false;
        }
        dc.squareup.okhttp3.Challenge challenge = (dc.squareup.okhttp3.Challenge) obj;
        return challenge.scheme.equals(this.scheme) && challenge.authParams.equals(this.authParams);
    }

    public int hashCode() {
        return ((this.scheme.hashCode() + 899) * 31) + this.authParams.hashCode();
    }

    public java.lang.String realm() {
        return this.authParams.get("realm");
    }

    public java.lang.String scheme() {
        return this.scheme;
    }

    public java.lang.String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    public dc.squareup.okhttp3.Challenge withCharset(java.nio.charset.Charset charset) {
        if (charset == null) {
            throw new java.lang.NullPointerException("charset == null");
        }
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(this.authParams);
        linkedHashMap.put("charset", charset.name());
        return new dc.squareup.okhttp3.Challenge(this.scheme, linkedHashMap);
    }

    public Challenge(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            throw new java.lang.NullPointerException("scheme == null");
        }
        if (str2 != null) {
            this.scheme = str;
            this.authParams = java.util.Collections.singletonMap("realm", str2);
            return;
        }
        throw new java.lang.NullPointerException("realm == null");
    }
}
