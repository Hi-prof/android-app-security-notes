package com.taobao.weex.appfram.websocket;

/* JADX INFO: loaded from: classes.dex */
public class WebSocketModule extends com.taobao.weex.WXSDKEngine.DestroyableModule {
    private static final java.lang.String KEY_CODE = "code";
    private static final java.lang.String KEY_DATA = "data";
    private static final java.lang.String KEY_REASON = "reason";
    private static final java.lang.String KEY_WAS_CLEAN = "wasClean";
    private static final java.lang.String TAG = "WebSocketModule";
    private com.taobao.weex.appfram.websocket.WebSocketModule.WebSocketEventListener eventListener;
    private com.taobao.weex.appfram.websocket.IWebSocketAdapter webSocketAdapter;

    public WebSocketModule() {
        com.taobao.weex.utils.WXLogUtils.e(TAG, "create new instance");
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void WebSocket(java.lang.String str, java.lang.String str2) {
        if (this.webSocketAdapter != null) {
            com.taobao.weex.utils.WXLogUtils.w(TAG, io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE);
            this.webSocketAdapter.close(com.taobao.weex.appfram.websocket.WebSocketCloseCodes.CLOSE_GOING_AWAY.getCode(), com.taobao.weex.appfram.websocket.WebSocketCloseCodes.CLOSE_GOING_AWAY.name());
        }
        this.webSocketAdapter = this.mWXSDKInstance.getWXWebSocketAdapter();
        if (reportErrorIfNoAdapter()) {
            return;
        }
        com.taobao.weex.appfram.websocket.WebSocketModule.WebSocketEventListener webSocketEventListener = new com.taobao.weex.appfram.websocket.WebSocketModule.WebSocketEventListener();
        this.eventListener = webSocketEventListener;
        this.webSocketAdapter.connect(str, str2, webSocketEventListener);
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void WebSocket(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (this.webSocketAdapter != null) {
            com.taobao.weex.utils.WXLogUtils.w(TAG, io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE);
            this.webSocketAdapter.close(com.taobao.weex.appfram.websocket.WebSocketCloseCodes.CLOSE_GOING_AWAY.getCode(), com.taobao.weex.appfram.websocket.WebSocketCloseCodes.CLOSE_GOING_AWAY.name());
        }
        this.webSocketAdapter = this.mWXSDKInstance.getWXWebSocketAdapter();
        if (reportErrorIfNoAdapter()) {
            return;
        }
        com.taobao.weex.appfram.websocket.WebSocketModule.WebSocketEventListener webSocketEventListener = new com.taobao.weex.appfram.websocket.WebSocketModule.WebSocketEventListener();
        this.eventListener = webSocketEventListener;
        this.webSocketAdapter.connect(str, str2, str3, webSocketEventListener);
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void send(java.lang.String str) {
        if (reportErrorIfNoAdapter()) {
            return;
        }
        this.webSocketAdapter.send(str);
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void close(java.lang.String str, java.lang.String str2) {
        if (reportErrorIfNoAdapter()) {
            return;
        }
        int code = com.taobao.weex.appfram.websocket.WebSocketCloseCodes.CLOSE_NORMAL.getCode();
        if (str != null) {
            try {
                code = java.lang.Integer.parseInt(str);
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        this.webSocketAdapter.close(code, str2);
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void onopen(com.taobao.weex.bridge.JSCallback jSCallback) {
        com.taobao.weex.appfram.websocket.WebSocketModule.WebSocketEventListener webSocketEventListener = this.eventListener;
        if (webSocketEventListener != null) {
            webSocketEventListener.onOpen = jSCallback;
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void onmessage(com.taobao.weex.bridge.JSCallback jSCallback) {
        com.taobao.weex.appfram.websocket.WebSocketModule.WebSocketEventListener webSocketEventListener = this.eventListener;
        if (webSocketEventListener != null) {
            webSocketEventListener.onMessage = jSCallback;
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void onclose(com.taobao.weex.bridge.JSCallback jSCallback) {
        com.taobao.weex.appfram.websocket.WebSocketModule.WebSocketEventListener webSocketEventListener = this.eventListener;
        if (webSocketEventListener != null) {
            webSocketEventListener.onClose = jSCallback;
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void onerror(com.taobao.weex.bridge.JSCallback jSCallback) {
        com.taobao.weex.appfram.websocket.WebSocketModule.WebSocketEventListener webSocketEventListener = this.eventListener;
        if (webSocketEventListener != null) {
            webSocketEventListener.onError = jSCallback;
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.taobao.weex.appfram.websocket.WebSocketModule.1
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.utils.WXLogUtils.w(com.taobao.weex.appfram.websocket.WebSocketModule.TAG, "close session with instance id " + com.taobao.weex.appfram.websocket.WebSocketModule.this.mWXSDKInstance.getInstanceId());
                if (com.taobao.weex.appfram.websocket.WebSocketModule.this.webSocketAdapter != null) {
                    com.taobao.weex.appfram.websocket.WebSocketModule.this.webSocketAdapter.destroy();
                }
                com.taobao.weex.appfram.websocket.WebSocketModule.this.webSocketAdapter = null;
                com.taobao.weex.appfram.websocket.WebSocketModule.this.eventListener = null;
            }
        };
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().post(runnable);
        } else {
            runnable.run();
        }
    }

    private boolean reportErrorIfNoAdapter() {
        if (this.webSocketAdapter != null) {
            return false;
        }
        com.taobao.weex.appfram.websocket.WebSocketModule.WebSocketEventListener webSocketEventListener = this.eventListener;
        if (webSocketEventListener != null) {
            webSocketEventListener.onError("No implementation found for IWebSocketAdapter");
        }
        com.taobao.weex.utils.WXLogUtils.e(TAG, "No implementation found for IWebSocketAdapter");
        return true;
    }

    private class WebSocketEventListener implements com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener {
        private com.taobao.weex.bridge.JSCallback onClose;
        private com.taobao.weex.bridge.JSCallback onError;
        private com.taobao.weex.bridge.JSCallback onMessage;
        private com.taobao.weex.bridge.JSCallback onOpen;

        private WebSocketEventListener() {
        }

        @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener
        public void onOpen() {
            com.taobao.weex.bridge.JSCallback jSCallback = this.onOpen;
            if (jSCallback != null) {
                jSCallback.invoke(new java.util.HashMap(0));
            }
        }

        @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener
        public void onMessage(java.lang.String str) {
            if (this.onMessage != null) {
                java.util.HashMap map = new java.util.HashMap(1);
                try {
                    map.put("data", com.alibaba.fastjson.JSON.parseObject(str));
                } catch (java.lang.Exception unused) {
                    map.put("data", str);
                }
                this.onMessage.invokeAndKeepAlive(map);
            }
        }

        @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener
        public void onClose(int i, java.lang.String str, boolean z) {
            if (this.onClose != null) {
                java.util.HashMap map = new java.util.HashMap(3);
                map.put("code", java.lang.Integer.valueOf(i));
                map.put(com.taobao.weex.appfram.websocket.WebSocketModule.KEY_REASON, str);
                map.put(com.taobao.weex.appfram.websocket.WebSocketModule.KEY_WAS_CLEAN, java.lang.Boolean.valueOf(z));
                this.onClose.invoke(map);
            }
        }

        @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener
        public void onError(java.lang.String str) {
            if (this.onError != null) {
                java.util.HashMap map = new java.util.HashMap(1);
                map.put("data", str);
                this.onError.invokeAndKeepAlive(map);
            }
        }
    }
}
