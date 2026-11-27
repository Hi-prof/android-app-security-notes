package com.taobao.weex.http;

/* JADX INFO: loaded from: classes.dex */
public class WXStreamModule extends com.taobao.weex.common.WXModule {
    public static final java.lang.String STATUS = "status";
    public static final java.lang.String STATUS_TEXT = "statusText";
    final com.taobao.weex.adapter.IWXHttpAdapter mAdapter;
    static final java.util.regex.Pattern CHARSET_PATTERN = java.util.regex.Pattern.compile("charset=([a-z0-9-]+)");
    public static java.util.HashMap<java.lang.String, com.taobao.weex.http.CertDTO> certMap = new java.util.HashMap<>();

    private interface ResponseCallback {
        void onResponse(com.taobao.weex.common.WXResponse wXResponse, java.util.Map<java.lang.String, java.lang.String> map);
    }

    public WXStreamModule() {
        this(null);
    }

    public WXStreamModule(com.taobao.weex.adapter.IWXHttpAdapter iWXHttpAdapter) {
        this.mAdapter = iWXHttpAdapter;
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    @java.lang.Deprecated
    public void sendHttp(com.alibaba.fastjson.JSONObject jSONObject, final java.lang.String str) {
        java.lang.String string = jSONObject.getString("method");
        java.lang.String string2 = jSONObject.getString("url");
        com.alibaba.fastjson.JSONObject jSONObject2 = jSONObject.getJSONObject(com.taobao.weex.ui.component.WXBasicComponentType.HEADER);
        java.lang.String string3 = jSONObject.getString("body");
        int intValue = jSONObject.getIntValue("timeout");
        boolean booleanValue = jSONObject.getBooleanValue("sslVerify");
        boolean booleanValue2 = jSONObject.getBooleanValue("firstIpv4");
        com.alibaba.fastjson.JSONObject jSONObject3 = jSONObject.getJSONObject("tls");
        if (string != null) {
            string = string.toUpperCase();
        }
        com.taobao.weex.http.Options.Builder builder = new com.taobao.weex.http.Options.Builder();
        if (!"GET".equals(string) && !"POST".equals(string) && !"PUT".equals(string) && !"DELETE".equals(string) && !"HEAD".equals(string) && !"PATCH".equals(string)) {
            string = "GET";
        }
        com.taobao.weex.http.Options.Builder firstIpv4 = builder.setMethod(string).setUrl(string2).setBody(string3).setTimeout(intValue).setSslVerify(booleanValue).setAndroidTlsConfig(jSONObject3).setFirstIpv4(booleanValue2);
        extractHeaders(jSONObject2, firstIpv4);
        final com.taobao.weex.http.Options optionsCreateOptions = firstIpv4.createOptions();
        sendRequest(firstIpv4.createOptions(), new com.taobao.weex.http.WXStreamModule.ResponseCallback() { // from class: com.taobao.weex.http.WXStreamModule.1
            @Override // com.taobao.weex.http.WXStreamModule.ResponseCallback
            public void onResponse(com.taobao.weex.common.WXResponse wXResponse, java.util.Map<java.lang.String, java.lang.String> map) {
                java.lang.String asString;
                if (str == null || com.taobao.weex.http.WXStreamModule.this.mWXSDKInstance == null) {
                    return;
                }
                com.taobao.weex.bridge.WXBridgeManager wXBridgeManager = com.taobao.weex.bridge.WXBridgeManager.getInstance();
                java.lang.String instanceId = com.taobao.weex.http.WXStreamModule.this.mWXSDKInstance.getInstanceId();
                java.lang.String str2 = str;
                if (wXResponse == null || wXResponse.originalData == null) {
                    asString = "{}";
                } else {
                    asString = com.taobao.weex.http.WXStreamModule.readAsString(wXResponse.originalData, map != null ? com.taobao.weex.http.WXStreamModule.getHeader(map, io.dcloud.common.util.net.NetWork.CONTENT_TYPE) : "", optionsCreateOptions.getType());
                }
                wXBridgeManager.callback(instanceId, str2, asString);
            }
        }, null, this.mWXSDKInstance.getInstanceId(), this.mWXSDKInstance.getBundleUrl());
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void fetch(com.alibaba.fastjson.JSONObject jSONObject, com.taobao.weex.bridge.JSCallback jSCallback, com.taobao.weex.bridge.JSCallback jSCallback2) {
        fetch(jSONObject, jSCallback, jSCallback2, this.mWXSDKInstance.getInstanceId(), this.mWXSDKInstance.getBundleUrl());
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void fetchWithArrayBuffer(com.alibaba.fastjson.JSONObject jSONObject, com.alibaba.fastjson.JSONObject jSONObject2, com.taobao.weex.bridge.JSCallback jSCallback, com.taobao.weex.bridge.JSCallback jSCallback2) {
        if (jSONObject == null) {
            if (jSCallback != null) {
                java.util.HashMap map = new java.util.HashMap();
                map.put("ok", false);
                map.put(STATUS_TEXT, com.taobao.weex.http.Status.ERR_INVALID_REQUEST);
                jSCallback.invoke(map);
                return;
            }
            return;
        }
        java.lang.String string = jSONObject.getString("@type");
        if (android.text.TextUtils.isEmpty(string) || !"binary".equalsIgnoreCase(string)) {
            if (jSCallback != null) {
                java.util.HashMap map2 = new java.util.HashMap();
                map2.put("ok", false);
                map2.put(STATUS_TEXT, com.taobao.weex.http.Status.ERR_INVALID_REQUEST);
                jSCallback.invoke(map2);
                return;
            }
            return;
        }
        java.lang.String string2 = jSONObject.getString("base64");
        if (!android.text.TextUtils.isEmpty(string2)) {
            jSONObject2.put("inputType", "base64");
            jSONObject2.put("body", (java.lang.Object) string2);
            fetch(jSONObject2, jSCallback, jSCallback2, this.mWXSDKInstance.getInstanceId(), this.mWXSDKInstance.getBundleUrl());
        } else if (jSCallback != null) {
            java.util.HashMap map3 = new java.util.HashMap();
            map3.put("ok", false);
            map3.put(STATUS_TEXT, com.taobao.weex.http.Status.ERR_INVALID_REQUEST);
            jSCallback.invoke(map3);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void configMTLS(com.alibaba.fastjson.JSONArray jSONArray, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (jSCallback == null) {
            return;
        }
        if (jSONArray == null || jSONArray.isEmpty()) {
            jSCallback.invoke(com.taobao.weex.http.CertJSResponse.obtainFail(-1, io.dcloud.common.constant.DOMException.MSG_PARAMETER_ERROR));
            return;
        }
        certMap.clear();
        for (int i = 0; i < jSONArray.size(); i++) {
            com.alibaba.fastjson.JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.containsKey("host")) {
                com.taobao.weex.http.CertDTO certDTO = new com.taobao.weex.http.CertDTO();
                java.lang.String string = jSONObject.getString("host");
                certDTO.host = string;
                certDTO.client = jSONObject.getString("client");
                certDTO.clientPassword = jSONObject.getString("clientPassword");
                certDTO.server = (java.lang.String[]) jSONObject.getJSONArray("server").toArray(new java.lang.String[0]);
                certMap.put(string, certDTO);
            }
        }
        jSCallback.invoke(com.taobao.weex.http.CertJSResponse.obtainSuccess());
    }

    public void fetch(com.alibaba.fastjson.JSONObject jSONObject, final com.taobao.weex.bridge.JSCallback jSCallback, com.taobao.weex.bridge.JSCallback jSCallback2, java.lang.String str, java.lang.String str2) {
        if (jSONObject == null || jSONObject.getString("url") == null) {
            if (jSCallback != null) {
                java.util.HashMap map = new java.util.HashMap();
                map.put("ok", false);
                map.put(STATUS_TEXT, com.taobao.weex.http.Status.ERR_INVALID_REQUEST);
                jSCallback.invoke(map);
                return;
            }
            return;
        }
        java.lang.String string = jSONObject.getString("method");
        java.lang.String string2 = jSONObject.getString("url");
        com.alibaba.fastjson.JSONObject jSONObject2 = jSONObject.getJSONObject("headers");
        java.lang.String string3 = jSONObject.getString("body");
        java.lang.String string4 = jSONObject.getString("type");
        java.lang.String string5 = jSONObject.getString("inputType");
        int intValue = jSONObject.getIntValue("timeout");
        com.alibaba.fastjson.JSONObject jSONObject3 = jSONObject.getJSONObject("tls");
        boolean booleanValue = jSONObject.getBooleanValue("sslVerify");
        boolean booleanValue2 = jSONObject.getBooleanValue("firstIpv4");
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
        if (sDKInstance != null && sDKInstance.getStreamNetworkHandler() != null) {
            java.lang.String strFetchLocal = sDKInstance.getStreamNetworkHandler().fetchLocal(string2);
            if (!android.text.TextUtils.isEmpty(strFetchLocal)) {
                string2 = strFetchLocal;
            }
        }
        if (string != null) {
            string = string.toUpperCase();
        }
        com.taobao.weex.http.Options.Builder builder = new com.taobao.weex.http.Options.Builder();
        if (!"GET".equals(string) && !"POST".equals(string) && !"PUT".equals(string) && !"DELETE".equals(string) && !"HEAD".equals(string) && !"PATCH".equals(string)) {
            string = "GET";
        }
        com.taobao.weex.http.Options.Builder firstIpv4 = builder.setMethod(string).setUrl(string2).setBody(string3).setType(string4).setInputTypes(string5).setTimeout(intValue).setSslVerify(booleanValue).setAndroidTlsConfig(jSONObject3).setFirstIpv4(booleanValue2);
        extractHeaders(jSONObject2, firstIpv4);
        final com.taobao.weex.http.Options optionsCreateOptions = firstIpv4.createOptions();
        sendRequest(optionsCreateOptions, new com.taobao.weex.http.WXStreamModule.ResponseCallback() { // from class: com.taobao.weex.http.WXStreamModule.2
            @Override // com.taobao.weex.http.WXStreamModule.ResponseCallback
            public void onResponse(com.taobao.weex.common.WXResponse wXResponse, java.util.Map<java.lang.String, java.lang.String> map2) {
                if (jSCallback != null) {
                    java.util.HashMap map3 = new java.util.HashMap();
                    if (wXResponse == null || "-1".equals(wXResponse.statusCode)) {
                        map3.put("status", -1);
                        map3.put(com.taobao.weex.http.WXStreamModule.STATUS_TEXT, com.taobao.weex.http.Status.ERR_CONNECT_FAILED);
                        if (wXResponse != null) {
                            map3.put("errorMsg", wXResponse.errorMsg);
                        } else {
                            map3.put("errorMsg", "response 为空");
                        }
                    } else {
                        int i = java.lang.Integer.parseInt(wXResponse.statusCode);
                        map3.put("status", java.lang.Integer.valueOf(i));
                        map3.put("ok", java.lang.Boolean.valueOf(i >= 200 && i <= 299));
                        if (wXResponse.originalData == null) {
                            map3.put("data", wXResponse.errorMsg);
                        } else {
                            try {
                                map3.put("data", com.taobao.weex.http.WXStreamModule.this.parseData(com.taobao.weex.http.WXStreamModule.readAsString(wXResponse.originalData, map2 != null ? com.taobao.weex.http.WXStreamModule.getHeader(map2, io.dcloud.common.util.net.NetWork.CONTENT_TYPE) : "", optionsCreateOptions.getType()), optionsCreateOptions.getType()));
                            } catch (com.alibaba.fastjson.JSONException e) {
                                com.taobao.weex.utils.WXLogUtils.e("", e);
                                map3.put("ok", false);
                                map3.put("data", "{'err':'Data parse failed!'}");
                            }
                        }
                        map3.put(com.taobao.weex.http.WXStreamModule.STATUS_TEXT, com.taobao.weex.http.Status.getStatusText(wXResponse.statusCode));
                    }
                    map3.put("headers", map2);
                    jSCallback.invoke(map3);
                }
            }
        }, jSCallback2, str, str2);
    }

    java.lang.Object parseData(java.lang.String str, com.taobao.weex.http.Options.Type type) throws com.alibaba.fastjson.JSONException {
        if (type == com.taobao.weex.http.Options.Type.json) {
            return com.alibaba.fastjson.JSONObject.parse(str);
        }
        if (type != com.taobao.weex.http.Options.Type.jsonp) {
            return str;
        }
        if (str == null || str.isEmpty()) {
            return new com.alibaba.fastjson.JSONObject();
        }
        int iIndexOf = str.indexOf(com.taobao.weex.el.parse.Operators.BRACKET_START_STR) + 1;
        int iLastIndexOf = str.lastIndexOf(com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        if (iIndexOf == 0 || iIndexOf >= iLastIndexOf || iLastIndexOf <= 0) {
            return new com.alibaba.fastjson.JSONObject();
        }
        return com.alibaba.fastjson.JSONObject.parse(str.substring(iIndexOf, iLastIndexOf));
    }

    static java.lang.String getHeader(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) {
        if (map == null || str == null) {
            return null;
        }
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return map.get(str.toLowerCase(java.util.Locale.ENGLISH));
    }

    /* JADX WARN: Code duplicated, block: B:6:0x001a  */
    static java.lang.String readAsString(byte[] bArr, java.lang.String str, com.taobao.weex.http.Options.Type type) {
        java.lang.String strGroup;
        if (str != null) {
            java.util.regex.Matcher matcher = CHARSET_PATTERN.matcher(str.toLowerCase(java.util.Locale.ENGLISH));
            if (matcher.find()) {
                strGroup = matcher.group(1);
            } else {
                strGroup = "utf-8";
            }
        } else {
            strGroup = "utf-8";
        }
        try {
            if (type == com.taobao.weex.http.Options.Type.base64) {
                return android.util.Base64.encodeToString(bArr, 2);
            }
            return new java.lang.String(bArr, strGroup);
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("", e);
            return new java.lang.String(bArr);
        }
    }

    private void extractHeaders(com.alibaba.fastjson.JSONObject jSONObject, com.taobao.weex.http.Options.Builder builder) {
        java.lang.String strAssembleUserAgent = com.taobao.weex.http.WXHttpUtil.assembleUserAgent(com.taobao.weex.WXEnvironment.getApplication(), com.taobao.weex.WXEnvironment.getConfig());
        if (jSONObject != null) {
            for (java.lang.String str : jSONObject.keySet()) {
                if (str.equals(com.taobao.weex.http.WXHttpUtil.KEY_USER_AGENT)) {
                    strAssembleUserAgent = jSONObject.getString(str);
                } else {
                    builder.putHeader(str, jSONObject.getString(str));
                }
            }
        }
        builder.putHeader(com.taobao.weex.http.WXHttpUtil.KEY_USER_AGENT, strAssembleUserAgent);
    }

    private void sendRequest(com.taobao.weex.http.Options options, com.taobao.weex.http.WXStreamModule.ResponseCallback responseCallback, com.taobao.weex.bridge.JSCallback jSCallback, java.lang.String str, java.lang.String str2) {
        com.taobao.weex.common.WXRequest wXRequest = new com.taobao.weex.common.WXRequest();
        wXRequest.method = options.getMethod();
        wXRequest.url = com.taobao.weex.WXSDKManager.getInstance().getURIAdapter().rewrite(str2, io.dcloud.feature.uniapp.adapter.AbsURIAdapter.REQUEST, android.net.Uri.parse(options.getUrl())).toString();
        wXRequest.body = options.getBody();
        wXRequest.timeoutMs = options.getTimeout();
        wXRequest.instanceId = str;
        wXRequest.sslVerify = options.getSslVerify();
        wXRequest.isFirstIpv4 = options.isFirstIpv4();
        wXRequest.tls = options.getTlsConfig();
        if ("BASE64".equalsIgnoreCase(options.getInputType())) {
            wXRequest.inputType = "BASE64";
        } else {
            wXRequest.inputType = "";
        }
        if (options.getHeaders() != null) {
            if (wXRequest.paramMap == null) {
                wXRequest.paramMap = options.getHeaders();
            } else {
                wXRequest.paramMap.putAll(options.getHeaders());
            }
        }
        com.taobao.weex.adapter.IWXHttpAdapter iWXHttpAdapter = this.mAdapter;
        if (iWXHttpAdapter == null) {
            iWXHttpAdapter = com.taobao.weex.WXSDKManager.getInstance().getIWXHttpAdapter();
        }
        if (iWXHttpAdapter != null) {
            iWXHttpAdapter.sendRequest(wXRequest, new com.taobao.weex.http.WXStreamModule.StreamHttpListener(responseCallback, jSCallback));
        } else {
            com.taobao.weex.utils.WXLogUtils.e("WXStreamModule", "No HttpAdapter found,request failed.");
        }
    }

    private static class StreamHttpListener implements com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener {
        private com.taobao.weex.http.WXStreamModule.ResponseCallback mCallback;
        private com.taobao.weex.bridge.JSCallback mProgressCallback;
        private java.util.Map<java.lang.String, java.lang.String> mRespHeaders;
        private java.util.Map<java.lang.String, java.lang.Object> mResponse;

        @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
        public void onHttpUploadProgress(int i) {
        }

        private StreamHttpListener(com.taobao.weex.http.WXStreamModule.ResponseCallback responseCallback, com.taobao.weex.bridge.JSCallback jSCallback) {
            this.mResponse = new java.util.HashMap();
            this.mCallback = responseCallback;
            this.mProgressCallback = jSCallback;
        }

        @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
        public void onHttpStart() {
            if (this.mProgressCallback != null) {
                this.mResponse.put("readyState", 1);
                this.mResponse.put("length", 0);
                this.mProgressCallback.invokeAndKeepAlive(new java.util.HashMap(this.mResponse));
            }
        }

        @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
        public void onHeadersReceived(int i, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
            this.mResponse.put("readyState", 2);
            this.mResponse.put("status", java.lang.Integer.valueOf(i));
            java.util.HashMap map2 = new java.util.HashMap();
            if (map != null) {
                for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : map.entrySet()) {
                    if (entry.getValue().size() != 0) {
                        if (entry.getValue().size() == 1) {
                            map2.put(entry.getKey() != null ? entry.getKey() : "_", entry.getValue().get(0));
                        } else {
                            map2.put(entry.getKey() != null ? entry.getKey() : "_", entry.getValue().toString());
                        }
                    }
                }
            }
            this.mResponse.put("headers", map2);
            this.mRespHeaders = map2;
            com.taobao.weex.bridge.JSCallback jSCallback = this.mProgressCallback;
            if (jSCallback != null) {
                jSCallback.invokeAndKeepAlive(new java.util.HashMap(this.mResponse));
            }
        }

        @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
        public void onHttpResponseProgress(int i) {
            this.mResponse.put("length", java.lang.Integer.valueOf(i));
            com.taobao.weex.bridge.JSCallback jSCallback = this.mProgressCallback;
            if (jSCallback != null) {
                jSCallback.invokeAndKeepAlive(new java.util.HashMap(this.mResponse));
            }
        }

        @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
        public void onHttpFinish(com.taobao.weex.common.WXResponse wXResponse) {
            com.taobao.weex.http.WXStreamModule.ResponseCallback responseCallback = this.mCallback;
            if (responseCallback != null) {
                responseCallback.onResponse(wXResponse, this.mRespHeaders);
            }
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("WXStreamModule", (wXResponse == null || wXResponse.originalData == null) ? "response data is NUll!" : new java.lang.String(wXResponse.originalData));
            }
        }
    }
}
