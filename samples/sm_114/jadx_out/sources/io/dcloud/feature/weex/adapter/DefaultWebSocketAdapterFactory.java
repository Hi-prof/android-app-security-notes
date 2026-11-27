package io.dcloud.feature.weex.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultWebSocketAdapterFactory implements com.taobao.weex.appfram.websocket.IWebSocketAdapterFactory {
    @Override // com.taobao.weex.appfram.websocket.IWebSocketAdapterFactory
    public com.taobao.weex.appfram.websocket.IWebSocketAdapter createWebSocketAdapter() {
        return new io.dcloud.feature.weex.adapter.DefaultWebSocketAdapter();
    }
}
