package com.taobao.weex.appfram.websocket;

/* JADX INFO: loaded from: classes.dex */
public interface IWebSocketAdapter {
    public static final java.lang.String HEADER_SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol";

    public interface EventListener {
        void onClose(int i, java.lang.String str, boolean z);

        void onError(java.lang.String str);

        void onMessage(java.lang.String str);

        void onOpen();
    }

    void close(int i, java.lang.String str);

    void connect(java.lang.String str, java.lang.String str2, com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener eventListener);

    void connect(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.appfram.websocket.IWebSocketAdapter.EventListener eventListener);

    void destroy();

    void send(java.lang.String str);
}
