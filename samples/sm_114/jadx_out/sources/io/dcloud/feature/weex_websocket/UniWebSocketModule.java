package io.dcloud.feature.weex_websocket;

/* JADX INFO: loaded from: classes2.dex */
public class UniWebSocketModule extends com.taobao.weex.WXSDKEngine.DestroyableModule {
    private static final java.lang.String KEY_CODE = "code";
    private static final java.lang.String KEY_DATA = "data";
    private static final java.lang.String KEY_ID = "id";
    private static final java.lang.String KEY_REASON = "reason";
    private static final java.lang.String KEY_WAS_CLEAN = "wasClean";
    private static final java.lang.String TAG = "WebSocketModule";
    private com.taobao.weex.bridge.JSCallback callback_onclose;
    private com.taobao.weex.bridge.JSCallback callback_onerror;
    private com.taobao.weex.bridge.JSCallback callback_onmessage;
    private com.taobao.weex.bridge.JSCallback callback_onopen;
    private java.lang.String currentId;
    private java.util.Map<java.lang.String, com.taobao.weex.appfram.websocket.IWebSocketAdapter> webSocketAdapterMap;
    private java.util.Map<java.lang.String, io.dcloud.feature.weex_websocket.UniWebSocketModule.WebSocketEventListener> webSocketEventListenerMap;

    public UniWebSocketModule() {
        com.taobao.weex.utils.WXLogUtils.e(TAG, "create new instance");
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void WebSocket(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(new java.lang.String(str.getBytes(), "utf-8"));
            java.lang.String string = object.getString("id");
            java.lang.String string2 = object.getString("url");
            java.lang.String string3 = object.getString("protocol");
            java.lang.String string4 = object.getString(com.taobao.weex.ui.component.WXBasicComponentType.HEADER);
            if (this.webSocketAdapterMap == null) {
                this.webSocketAdapterMap = new java.util.HashMap();
                this.webSocketEventListenerMap = new java.util.HashMap();
            }
            if (this.webSocketAdapterMap.get(string) == null || this.webSocketEventListenerMap.get(string) == null) {
                if (this.webSocketAdapterMap.get(string) != null && this.webSocketEventListenerMap.get(string) == null) {
                    this.webSocketAdapterMap.remove(string);
                }
                com.taobao.weex.appfram.websocket.IWebSocketAdapter wXWebSocketAdapter = this.mWXSDKInstance.getWXWebSocketAdapter();
                io.dcloud.feature.weex_websocket.UniWebSocketModule.WebSocketEventListener webSocketEventListener = new io.dcloud.feature.weex_websocket.UniWebSocketModule.WebSocketEventListener(string);
                webSocketEventListener.onOpen = this.callback_onopen;
                webSocketEventListener.onMessage = this.callback_onmessage;
                webSocketEventListener.onClose = this.callback_onclose;
                webSocketEventListener.onError = this.callback_onerror;
                wXWebSocketAdapter.connect(string2, string3, string4, webSocketEventListener);
                this.webSocketEventListenerMap.put(string, webSocketEventListener);
                this.currentId = string;
                this.webSocketAdapterMap.put(string, wXWebSocketAdapter);
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[UniWebSocketModule] alert param parse error ", e);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void send(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(new java.lang.String(str.getBytes(), "utf-8"));
            java.lang.String string = object.getString("id");
            this.webSocketAdapterMap.get(string).send(object.getString("data"));
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[UniWebSocketModule] alert param parse error ", e);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void close(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(new java.lang.String(str.getBytes(), "utf-8"));
            java.lang.String string = object.getString("id");
            java.lang.String string2 = object.getString("code");
            java.lang.String string3 = object.getString(KEY_REASON);
            int code = com.taobao.weex.appfram.websocket.WebSocketCloseCodes.CLOSE_NORMAL.getCode();
            if (string2 != null) {
                try {
                    code = java.lang.Integer.parseInt(string2);
                } catch (java.lang.NumberFormatException unused) {
                }
            }
            this.webSocketAdapterMap.get(string).close(code, string3);
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[UniWebSocketModule] alert param parse error ", e);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void onopen(com.taobao.weex.bridge.JSCallback jSCallback) {
        this.callback_onopen = jSCallback;
        java.util.Map<java.lang.String, io.dcloud.feature.weex_websocket.UniWebSocketModule.WebSocketEventListener> map = this.webSocketEventListenerMap;
        if (map != null) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, io.dcloud.feature.weex_websocket.UniWebSocketModule.WebSocketEventListener>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().onOpen = this.callback_onopen;
            }
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void onmessage(com.taobao.weex.bridge.JSCallback jSCallback) {
        this.callback_onmessage = jSCallback;
        java.util.Map<java.lang.String, io.dcloud.feature.weex_websocket.UniWebSocketModule.WebSocketEventListener> map = this.webSocketEventListenerMap;
        if (map != null) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, io.dcloud.feature.weex_websocket.UniWebSocketModule.WebSocketEventListener>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().onMessage = this.callback_onmessage;
            }
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void onclose(com.taobao.weex.bridge.JSCallback jSCallback) {
        this.callback_onclose = jSCallback;
        java.util.Map<java.lang.String, io.dcloud.feature.weex_websocket.UniWebSocketModule.WebSocketEventListener> map = this.webSocketEventListenerMap;
        if (map != null) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, io.dcloud.feature.weex_websocket.UniWebSocketModule.WebSocketEventListener>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().onClose = this.callback_onclose;
            }
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void onerror(com.taobao.weex.bridge.JSCallback jSCallback) {
        this.callback_onerror = jSCallback;
        java.util.Map<java.lang.String, io.dcloud.feature.weex_websocket.UniWebSocketModule.WebSocketEventListener> map = this.webSocketEventListenerMap;
        if (map != null) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, io.dcloud.feature.weex_websocket.UniWebSocketModule.WebSocketEventListener>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().onError = this.callback_onerror;
            }
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        java.lang.Runnable runnable = new java.lang.Runnable() { // from class: io.dcloud.feature.weex_websocket.UniWebSocketModule.1
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.utils.WXLogUtils.w(io.dcloud.feature.weex_websocket.UniWebSocketModule.TAG, "close session with instance id " + io.dcloud.feature.weex_websocket.UniWebSocketModule.this.mWXSDKInstance.getInstanceId());
                if (io.dcloud.feature.weex_websocket.UniWebSocketModule.this.webSocketAdapterMap != null) {
                    java.util.Iterator it = io.dcloud.feature.weex_websocket.UniWebSocketModule.this.webSocketAdapterMap.entrySet().iterator();
                    while (it.hasNext()) {
                        ((com.taobao.weex.appfram.websocket.IWebSocketAdapter) ((java.util.Map.Entry) it.next()).getValue()).destroy();
                    }
                    io.dcloud.feature.weex_websocket.UniWebSocketModule.this.webSocketAdapterMap.clear();
                    io.dcloud.feature.weex_websocket.UniWebSocketModule.this.webSocketAdapterMap = null;
                }
                if (io.dcloud.feature.weex_websocket.UniWebSocketModule.this.webSocketEventListenerMap != null) {
                    io.dcloud.feature.weex_websocket.UniWebSocketModule.this.webSocketEventListenerMap.clear();
                }
                io.dcloud.feature.weex_websocket.UniWebSocketModule.this.webSocketEventListenerMap = null;
            }
        };
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().post(runnable);
        } else {
            runnable.run();
        }
    }

    private class WebSocketEventListener implements com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener {
        private java.lang.String id;
        private com.taobao.weex.bridge.JSCallback onClose;
        private com.taobao.weex.bridge.JSCallback onError;
        private com.taobao.weex.bridge.JSCallback onMessage;
        private com.taobao.weex.bridge.JSCallback onOpen;

        public WebSocketEventListener(java.lang.String str) {
            this.id = str;
        }

        @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener
        public void onOpen() {
            if (this.onOpen != null) {
                java.util.HashMap map = new java.util.HashMap();
                map.put("id", this.id);
                this.onOpen.invokeAndKeepAlive(map);
            }
        }

        @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener
        public void onMessage(java.lang.String str) {
            if (this.onMessage != null) {
                java.util.HashMap map = new java.util.HashMap(2);
                map.put("id", this.id);
                try {
                    com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
                    if (object.containsKey("@type") && object.containsKey("base64")) {
                        map.put("data", object);
                    } else {
                        map.put("data", str);
                    }
                } catch (java.lang.Exception unused) {
                    map.put("data", str);
                }
                this.onMessage.invokeAndKeepAlive(map);
            }
        }

        @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener
        public void onClose(int i, java.lang.String str, boolean z) {
            if (this.onClose != null) {
                java.util.HashMap map = new java.util.HashMap(4);
                map.put("id", this.id);
                map.put("code", java.lang.Integer.valueOf(i));
                map.put(io.dcloud.feature.weex_websocket.UniWebSocketModule.KEY_REASON, str);
                map.put(io.dcloud.feature.weex_websocket.UniWebSocketModule.KEY_WAS_CLEAN, java.lang.Boolean.valueOf(z));
                this.onClose.invokeAndKeepAlive(map);
                if (io.dcloud.feature.weex_websocket.UniWebSocketModule.this.webSocketEventListenerMap != null) {
                    io.dcloud.feature.weex_websocket.UniWebSocketModule.this.webSocketEventListenerMap.remove(this.id);
                }
            }
        }

        @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener
        public void onError(java.lang.String str) {
            if (this.onError != null) {
                java.util.HashMap map = new java.util.HashMap(2);
                map.put("id", this.id);
                map.put("data", str);
                this.onError.invokeAndKeepAlive(map);
                if (io.dcloud.feature.weex_websocket.UniWebSocketModule.this.webSocketEventListenerMap != null) {
                    io.dcloud.feature.weex_websocket.UniWebSocketModule.this.webSocketEventListenerMap.remove(this.id);
                }
            }
        }
    }
}
