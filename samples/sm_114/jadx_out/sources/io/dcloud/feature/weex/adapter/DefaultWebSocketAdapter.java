package io.dcloud.feature.weex.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultWebSocketAdapter implements com.taobao.weex.appfram.websocket.IWebSocketAdapter {
    private static dc.squareup.okhttp3.ConnectionPool mConnectPool;
    private com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener eventListener;
    private io.dcloud.common.util.ThrottleUtil throttleUtil = null;
    private dc.squareup.okhttp3.WebSocket ws;

    @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter
    public void connect(java.lang.String str, java.lang.String str2, com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener eventListener) {
        this.eventListener = eventListener;
        dc.squareup.okhttp3.OkHttpClient.Builder builder = new dc.squareup.okhttp3.OkHttpClient.Builder();
        try {
            javax.net.ssl.SSLSocketFactory sSLSocketFactory = io.dcloud.common.adapter.util.DCloudTrustManager.getSSLSocketFactory();
            if (sSLSocketFactory != null) {
                builder.sslSocketFactory(sSLSocketFactory);
            }
        } catch (java.security.KeyManagementException e) {
            e.printStackTrace();
        } catch (java.security.NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        builder.readTimeout(24L, java.util.concurrent.TimeUnit.HOURS);
        builder.writeTimeout(24L, java.util.concurrent.TimeUnit.HOURS);
        builder.hostnameVerifier(io.dcloud.common.adapter.util.DCloudTrustManager.getHostnameVerifier(false));
        dc.squareup.okhttp3.Request.Builder builder2 = new dc.squareup.okhttp3.Request.Builder();
        if (!android.text.TextUtils.isEmpty(str2)) {
            builder2.addHeader(com.taobao.weex.appfram.websocket.IWebSocketAdapter.HEADER_SEC_WEBSOCKET_PROTOCOL, str2);
        }
        builder2.addHeader("Origin", "http://localhost");
        builder2.url(str);
        builder.build().newWebSocket(builder2.build(), new dc.squareup.okhttp3.WebSocketListener() { // from class: io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.1
            @Override // dc.squareup.okhttp3.WebSocketListener
            public void onOpen(dc.squareup.okhttp3.WebSocket webSocket, dc.squareup.okhttp3.Response response) {
                super.onOpen(webSocket, response);
                io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.ws = webSocket;
                io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.eventListener.onOpen();
                dc.squareup.okhttp3.Headers headers = response.headers();
                java.util.HashMap map = new java.util.HashMap();
                for (java.lang.String str3 : headers.names()) {
                    map.put(str3, headers.values(str3).toString());
                }
            }

            @Override // dc.squareup.okhttp3.WebSocketListener
            public void onMessage(dc.squareup.okhttp3.WebSocket webSocket, java.lang.String str3) {
                super.onMessage(webSocket, str3);
                io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.eventListener.onMessage(str3);
            }

            @Override // dc.squareup.okhttp3.WebSocketListener
            public void onMessage(dc.squareup.okhttp3.WebSocket webSocket, dc.squareup.okio.ByteString byteString) {
                super.onMessage(webSocket, byteString);
                java.lang.String strEncodeToString = android.util.Base64.encodeToString(byteString.toByteArray(), 2);
                com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                jSONObject.put("@type", (java.lang.Object) "binary");
                jSONObject.put("base64", (java.lang.Object) strEncodeToString);
                io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.eventListener.onMessage(jSONObject.toJSONString());
            }

            @Override // dc.squareup.okhttp3.WebSocketListener
            public void onClosing(dc.squareup.okhttp3.WebSocket webSocket, final int i, final java.lang.String str3) {
                super.onClosing(webSocket, i, str3);
                if (io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.throttleUtil == null) {
                    io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.throttleUtil = new io.dcloud.common.util.ThrottleUtil();
                }
                io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.throttleUtil.throttlePost(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.eventListener.onClose(i, str3, true);
                    }
                }, 10L);
            }

            @Override // dc.squareup.okhttp3.WebSocketListener
            public void onClosed(dc.squareup.okhttp3.WebSocket webSocket, final int i, final java.lang.String str3) {
                super.onClosed(webSocket, i, str3);
                if (io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.throttleUtil == null) {
                    io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.throttleUtil = new io.dcloud.common.util.ThrottleUtil();
                }
                io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.throttleUtil.throttlePost(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.eventListener.onClose(i, str3, true);
                    }
                }, 10L);
            }

            @Override // dc.squareup.okhttp3.WebSocketListener
            public void onFailure(dc.squareup.okhttp3.WebSocket webSocket, java.lang.Throwable th, dc.squareup.okhttp3.Response response) {
                super.onFailure(webSocket, th, response);
                if (th instanceof java.io.EOFException) {
                    io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.eventListener.onClose(com.taobao.weex.appfram.websocket.WebSocketCloseCodes.CLOSE_NORMAL.getCode(), com.taobao.weex.appfram.websocket.WebSocketCloseCodes.CLOSE_NORMAL.name(), true);
                } else {
                    io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.eventListener.onError(th.getMessage());
                }
            }
        });
    }

    @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter
    public void connect(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener eventListener) {
        java.util.Map map;
        this.eventListener = eventListener;
        dc.squareup.okhttp3.OkHttpClient.Builder builder = new dc.squareup.okhttp3.OkHttpClient.Builder();
        try {
            javax.net.ssl.SSLSocketFactory sSLSocketFactory = io.dcloud.common.adapter.util.DCloudTrustManager.getSSLSocketFactory();
            if (sSLSocketFactory != null) {
                builder.sslSocketFactory(sSLSocketFactory);
            }
        } catch (java.security.KeyManagementException e) {
            e.printStackTrace();
        } catch (java.security.NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        builder.readTimeout(24L, java.util.concurrent.TimeUnit.HOURS);
        builder.writeTimeout(24L, java.util.concurrent.TimeUnit.HOURS);
        if (mConnectPool == null) {
            mConnectPool = new dc.squareup.okhttp3.ConnectionPool();
        }
        builder.connectionPool(mConnectPool);
        boolean z = false;
        builder.hostnameVerifier(io.dcloud.common.adapter.util.DCloudTrustManager.getHostnameVerifier(false));
        dc.squareup.okhttp3.Request.Builder builder2 = new dc.squareup.okhttp3.Request.Builder();
        if (!android.text.TextUtils.isEmpty(str2)) {
            builder2.addHeader(com.taobao.weex.appfram.websocket.IWebSocketAdapter.HEADER_SEC_WEBSOCKET_PROTOCOL, str2);
        }
        try {
            if (!android.text.TextUtils.isEmpty(str3) && (map = (java.util.Map) com.alibaba.fastjson.JSON.parse(str3)) != null) {
                for (java.util.Map.Entry entry : map.entrySet()) {
                    java.lang.String str4 = (java.lang.String) entry.getKey();
                    java.lang.String str5 = (java.lang.String) entry.getValue();
                    if ("Origin".equals(str4)) {
                        z = true;
                    }
                    if (!android.text.TextUtils.isEmpty(str4)) {
                        builder2.addHeader(str4, str5);
                    }
                }
            }
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        if (!z) {
            builder2.addHeader("Origin", "http://localhost");
        }
        builder2.url(str);
        builder.build().newWebSocket(builder2.build(), new dc.squareup.okhttp3.WebSocketListener() { // from class: io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.2
            @Override // dc.squareup.okhttp3.WebSocketListener
            public void onOpen(dc.squareup.okhttp3.WebSocket webSocket, dc.squareup.okhttp3.Response response) {
                super.onOpen(webSocket, response);
                io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.ws = webSocket;
                io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.eventListener.onOpen();
                dc.squareup.okhttp3.Headers headers = response.headers();
                java.util.HashMap map2 = new java.util.HashMap();
                for (java.lang.String str6 : headers.names()) {
                    map2.put(str6, headers.values(str6).toString());
                }
            }

            @Override // dc.squareup.okhttp3.WebSocketListener
            public void onMessage(dc.squareup.okhttp3.WebSocket webSocket, java.lang.String str6) {
                super.onMessage(webSocket, str6);
                io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.eventListener.onMessage(str6);
            }

            @Override // dc.squareup.okhttp3.WebSocketListener
            public void onMessage(dc.squareup.okhttp3.WebSocket webSocket, dc.squareup.okio.ByteString byteString) {
                super.onMessage(webSocket, byteString);
                java.lang.String strEncodeToString = android.util.Base64.encodeToString(byteString.toByteArray(), 2);
                com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                jSONObject.put("@type", (java.lang.Object) "binary");
                jSONObject.put("base64", (java.lang.Object) strEncodeToString);
                io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.eventListener.onMessage(jSONObject.toJSONString());
            }

            @Override // dc.squareup.okhttp3.WebSocketListener
            public void onClosing(dc.squareup.okhttp3.WebSocket webSocket, final int i, final java.lang.String str6) {
                super.onClosing(webSocket, i, str6);
                if (io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.throttleUtil == null) {
                    io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.throttleUtil = new io.dcloud.common.util.ThrottleUtil();
                }
                io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.throttleUtil.throttlePost(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.eventListener.onClose(i, str6, true);
                    }
                }, 10L);
            }

            @Override // dc.squareup.okhttp3.WebSocketListener
            public void onClosed(dc.squareup.okhttp3.WebSocket webSocket, final int i, final java.lang.String str6) {
                super.onClosed(webSocket, i, str6);
                if (io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.throttleUtil == null) {
                    io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.throttleUtil = new io.dcloud.common.util.ThrottleUtil();
                }
                io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.throttleUtil.throttlePost(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.eventListener.onClose(i, str6, true);
                    }
                }, 10L);
            }

            @Override // dc.squareup.okhttp3.WebSocketListener
            public void onFailure(dc.squareup.okhttp3.WebSocket webSocket, java.lang.Throwable th, dc.squareup.okhttp3.Response response) {
                super.onFailure(webSocket, th, response);
                if (th instanceof java.io.EOFException) {
                    io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.eventListener.onClose(com.taobao.weex.appfram.websocket.WebSocketCloseCodes.CLOSE_NORMAL.getCode(), com.taobao.weex.appfram.websocket.WebSocketCloseCodes.CLOSE_NORMAL.name(), true);
                } else {
                    io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter.this.eventListener.onError(th.getMessage());
                }
            }
        });
    }

    @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter
    public void send(java.lang.String str) {
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
            java.lang.String string = object.getString("@type");
            if (string != null && string.equals("binary") && object.containsKey("base64")) {
                send(object);
                return;
            }
        } catch (java.lang.Exception unused) {
        }
        dc.squareup.okhttp3.WebSocket webSocket = this.ws;
        if (webSocket != null) {
            try {
                webSocket.send(str);
                return;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                reportError(e.getMessage());
                return;
            }
        }
        reportError("WebSocket is not ready");
    }

    public void send(com.alibaba.fastjson.JSONObject jSONObject) {
        if (this.ws != null) {
            try {
                java.lang.String string = jSONObject.getString("@type");
                if (string != null && string.equals("binary") && jSONObject.containsKey("base64")) {
                    byte[] bArrDecode = android.util.Base64.decode(jSONObject.getString("base64"), 0);
                    if (bArrDecode != null) {
                        this.ws.send(dc.squareup.okio.ByteString.of(bArrDecode));
                        return;
                    } else {
                        reportError("some error occur");
                        return;
                    }
                }
                reportError("some error occur");
                return;
            } catch (java.lang.Exception e) {
                reportError(e.getMessage());
                return;
            }
        }
        reportError("WebSocket is not ready");
    }

    @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter
    public void close(int i, java.lang.String str) {
        dc.squareup.okhttp3.WebSocket webSocket = this.ws;
        if (webSocket != null) {
            try {
                webSocket.close(i, str);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                reportError(e.getMessage());
            }
        }
    }

    @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter
    public void destroy() {
        dc.squareup.okhttp3.WebSocket webSocket = this.ws;
        if (webSocket != null) {
            try {
                webSocket.close(com.taobao.weex.appfram.websocket.WebSocketCloseCodes.CLOSE_GOING_AWAY.getCode(), com.taobao.weex.appfram.websocket.WebSocketCloseCodes.CLOSE_GOING_AWAY.name());
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void reportError(java.lang.String str) {
        com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener eventListener = this.eventListener;
        if (eventListener != null) {
            eventListener.onError(str);
        }
    }
}
