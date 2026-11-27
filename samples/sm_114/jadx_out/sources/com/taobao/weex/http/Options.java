package com.taobao.weex.http;

/* JADX INFO: loaded from: classes.dex */
class Options {
    private java.lang.String body;
    private java.util.Map<java.lang.String, java.lang.String> headers;
    private java.lang.String inputType;
    private boolean isFirstIpv4;
    private java.lang.String method;
    private boolean sslVerify;
    private int timeout;
    private com.alibaba.fastjson.JSONObject tlsConfig;
    private com.taobao.weex.http.Options.Type type;
    private java.lang.String url;

    public enum Type {
        json,
        text,
        jsonp,
        base64
    }

    private Options(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str3, com.taobao.weex.http.Options.Type type, int i) {
        com.taobao.weex.http.Options.Type type2 = com.taobao.weex.http.Options.Type.text;
        this.timeout = com.taobao.weex.common.WXRequest.DEFAULT_TIMEOUT_MS;
        this.sslVerify = false;
        this.isFirstIpv4 = false;
        this.method = str;
        this.url = str2;
        this.headers = map;
        this.body = str3;
        this.type = type;
        this.timeout = i == 0 ? com.taobao.weex.common.WXRequest.DEFAULT_TIMEOUT_MS : i;
    }

    private Options(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str3, com.taobao.weex.http.Options.Type type, int i, boolean z, boolean z2) {
        com.taobao.weex.http.Options.Type type2 = com.taobao.weex.http.Options.Type.text;
        this.timeout = com.taobao.weex.common.WXRequest.DEFAULT_TIMEOUT_MS;
        this.sslVerify = false;
        this.isFirstIpv4 = false;
        this.method = str;
        this.url = str2;
        this.headers = map;
        this.body = str3;
        this.type = type;
        this.timeout = i == 0 ? com.taobao.weex.common.WXRequest.DEFAULT_TIMEOUT_MS : i;
        this.sslVerify = z;
        this.isFirstIpv4 = z2;
    }

    public java.lang.String getMethod() {
        return this.method;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
        return this.headers;
    }

    public java.lang.String getBody() {
        return this.body;
    }

    public com.taobao.weex.http.Options.Type getType() {
        return this.type;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public boolean getSslVerify() {
        return this.sslVerify;
    }

    public boolean isFirstIpv4() {
        return this.isFirstIpv4;
    }

    public com.alibaba.fastjson.JSONObject getTlsConfig() {
        return this.tlsConfig;
    }

    public void setTlsConfig(com.alibaba.fastjson.JSONObject jSONObject) {
        this.tlsConfig = jSONObject;
    }

    public java.lang.String getInputType() {
        return this.inputType;
    }

    public void setInputType(java.lang.String str) {
        this.inputType = str;
    }

    public static class Builder {
        private com.alibaba.fastjson.JSONObject androidTLSConfig;
        private java.lang.String body;
        private java.util.Map<java.lang.String, java.lang.String> headers = new java.util.HashMap();
        private java.lang.String inputType;
        private boolean isFirstIpv4;
        private java.lang.String method;
        private boolean sslVerify;
        private int timeout;
        private com.taobao.weex.http.Options.Type type;
        private java.lang.String url;

        public com.taobao.weex.http.Options.Builder setAndroidTlsConfig(com.alibaba.fastjson.JSONObject jSONObject) {
            this.androidTLSConfig = jSONObject;
            return this;
        }

        public com.taobao.weex.http.Options.Builder setMethod(java.lang.String str) {
            this.method = str;
            return this;
        }

        public com.taobao.weex.http.Options.Builder setUrl(java.lang.String str) {
            this.url = str;
            return this;
        }

        public com.taobao.weex.http.Options.Builder putHeader(java.lang.String str, java.lang.String str2) {
            this.headers.put(str, str2);
            return this;
        }

        public com.taobao.weex.http.Options.Builder setBody(java.lang.String str) {
            this.body = str;
            return this;
        }

        public com.taobao.weex.http.Options.Builder setSslVerify(boolean z) {
            this.sslVerify = z;
            return this;
        }

        public com.taobao.weex.http.Options.Builder setFirstIpv4(boolean z) {
            this.isFirstIpv4 = z;
            return this;
        }

        public com.taobao.weex.http.Options.Builder setType(java.lang.String str) {
            if (com.taobao.weex.http.Options.Type.json.name().equals(str)) {
                this.type = com.taobao.weex.http.Options.Type.json;
                return this;
            }
            if (com.taobao.weex.http.Options.Type.jsonp.name().equals(str)) {
                this.type = com.taobao.weex.http.Options.Type.jsonp;
                return this;
            }
            if (com.taobao.weex.http.Options.Type.base64.name().equals(str)) {
                this.type = com.taobao.weex.http.Options.Type.base64;
                return this;
            }
            this.type = com.taobao.weex.http.Options.Type.text;
            return this;
        }

        public com.taobao.weex.http.Options.Builder setType(com.taobao.weex.http.Options.Type type) {
            this.type = type;
            return this;
        }

        public com.taobao.weex.http.Options.Builder setInputTypes(java.lang.String str) {
            this.inputType = str;
            return this;
        }

        public com.taobao.weex.http.Options.Builder setTimeout(int i) {
            this.timeout = i;
            return this;
        }

        public com.taobao.weex.http.Options createOptions() {
            com.taobao.weex.http.Options options = new com.taobao.weex.http.Options(this.method, this.url, this.headers, this.body, this.type, this.timeout, this.sslVerify, this.isFirstIpv4);
            options.setInputType(this.inputType);
            options.setTlsConfig(this.androidTLSConfig);
            return options;
        }
    }
}
