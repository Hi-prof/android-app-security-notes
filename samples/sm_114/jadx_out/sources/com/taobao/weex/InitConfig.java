package com.taobao.weex;

/* JADX INFO: loaded from: classes.dex */
public class InitConfig {
    private com.taobao.weex.performance.IApmGenerator apmGenerater;
    private com.taobao.weex.adapter.ClassLoaderAdapter classLoaderAdapter;
    private com.taobao.weex.adapter.IDrawableLoader drawableLoader;
    private java.lang.String framework;
    private com.taobao.weex.adapter.IWXHttpAdapter httpAdapter;
    private com.taobao.weex.adapter.IWXImgLoaderAdapter imgAdapter;
    private com.taobao.weex.adapter.IWXJsFileLoaderAdapter jsFileLoaderAdapter;
    private com.taobao.weex.adapter.IWXJscProcessManager jscProcessManager;
    private com.taobao.weex.adapter.IWXJSExceptionAdapter mJSExceptionAdapter;
    private com.taobao.weex.adapter.URIAdapter mURIAdapter;
    private com.taobao.weex.bridge.IDCVueBridgeAdapter mVueBridgeAdaper;
    private java.util.List<java.lang.String> nativeLibraryList;
    private com.taobao.weex.adapter.IWXSoLoaderAdapter soLoader;
    private com.taobao.weex.appfram.storage.IWXStorageAdapter storageAdapter;
    private com.taobao.weex.adapter.IWXUserTrackAdapter utAdapter;
    private com.taobao.weex.appfram.websocket.IWebSocketAdapterFactory webSocketAdapterFactory;

    public com.taobao.weex.adapter.IWXHttpAdapter getHttpAdapter() {
        return this.httpAdapter;
    }

    public com.taobao.weex.adapter.IWXImgLoaderAdapter getImgAdapter() {
        return this.imgAdapter;
    }

    public com.taobao.weex.adapter.IDrawableLoader getDrawableLoader() {
        return this.drawableLoader;
    }

    public com.taobao.weex.adapter.IWXUserTrackAdapter getUtAdapter() {
        return this.utAdapter;
    }

    public com.taobao.weex.adapter.IWXSoLoaderAdapter getIWXSoLoaderAdapter() {
        return this.soLoader;
    }

    public java.lang.String getFramework() {
        return this.framework;
    }

    public com.taobao.weex.appfram.storage.IWXStorageAdapter getStorageAdapter() {
        return this.storageAdapter;
    }

    public com.taobao.weex.adapter.URIAdapter getURIAdapter() {
        return this.mURIAdapter;
    }

    public com.taobao.weex.bridge.IDCVueBridgeAdapter getVueBridgeAdaper() {
        return this.mVueBridgeAdaper;
    }

    public com.taobao.weex.appfram.websocket.IWebSocketAdapterFactory getWebSocketAdapterFactory() {
        return this.webSocketAdapterFactory;
    }

    public com.taobao.weex.adapter.ClassLoaderAdapter getClassLoaderAdapter() {
        return this.classLoaderAdapter;
    }

    public com.taobao.weex.performance.IApmGenerator getApmGenerater() {
        return this.apmGenerater;
    }

    public com.taobao.weex.adapter.IWXJsFileLoaderAdapter getJsFileLoaderAdapter() {
        return this.jsFileLoaderAdapter;
    }

    public com.taobao.weex.InitConfig setClassLoaderAdapter(com.taobao.weex.adapter.ClassLoaderAdapter classLoaderAdapter) {
        this.classLoaderAdapter = classLoaderAdapter;
        return this;
    }

    public com.taobao.weex.adapter.IWXJSExceptionAdapter getJSExceptionAdapter() {
        return this.mJSExceptionAdapter;
    }

    public com.taobao.weex.adapter.IWXJscProcessManager getJscProcessManager() {
        return this.jscProcessManager;
    }

    java.lang.Iterable<java.lang.String> getNativeLibraryList() {
        if (this.nativeLibraryList == null) {
            this.nativeLibraryList = new java.util.LinkedList();
        }
        return this.nativeLibraryList;
    }

    private InitConfig() {
    }

    public static class Builder {
        com.taobao.weex.performance.IApmGenerator apmGenerater;
        com.taobao.weex.adapter.ClassLoaderAdapter classLoaderAdapter;
        com.taobao.weex.adapter.IDrawableLoader drawableLoader;
        java.lang.String framework;
        com.taobao.weex.adapter.IWXHttpAdapter httpAdapter;
        com.taobao.weex.adapter.IWXImgLoaderAdapter imgAdapter;
        private com.taobao.weex.adapter.IWXJsFileLoaderAdapter jsFileLoaderAdapter;
        com.taobao.weex.adapter.IWXJscProcessManager jscProcessManager;
        com.taobao.weex.adapter.IWXJSExceptionAdapter mJSExceptionAdapter;
        com.taobao.weex.adapter.URIAdapter mURIAdapter;
        com.taobao.weex.bridge.IDCVueBridgeAdapter mVueBridgeAdapter;
        private java.util.List<java.lang.String> nativeLibraryList = new java.util.LinkedList();
        com.taobao.weex.adapter.IWXSoLoaderAdapter soLoader;
        com.taobao.weex.appfram.storage.IWXStorageAdapter storageAdapter;
        com.taobao.weex.adapter.IWXUserTrackAdapter utAdapter;
        com.taobao.weex.appfram.websocket.IWebSocketAdapterFactory webSocketAdapterFactory;

        public com.taobao.weex.adapter.IWXJscProcessManager getJscProcessManager() {
            return this.jscProcessManager;
        }

        public com.taobao.weex.InitConfig.Builder setJscProcessManager(com.taobao.weex.adapter.IWXJscProcessManager iWXJscProcessManager) {
            this.jscProcessManager = iWXJscProcessManager;
            return this;
        }

        public com.taobao.weex.InitConfig.Builder setHttpAdapter(com.taobao.weex.adapter.IWXHttpAdapter iWXHttpAdapter) {
            this.httpAdapter = iWXHttpAdapter;
            return this;
        }

        public com.taobao.weex.InitConfig.Builder setImgAdapter(com.taobao.weex.adapter.IWXImgLoaderAdapter iWXImgLoaderAdapter) {
            this.imgAdapter = iWXImgLoaderAdapter;
            return this;
        }

        public com.taobao.weex.InitConfig.Builder setDrawableLoader(com.taobao.weex.adapter.IDrawableLoader iDrawableLoader) {
            this.drawableLoader = iDrawableLoader;
            return this;
        }

        public com.taobao.weex.InitConfig.Builder setUtAdapter(com.taobao.weex.adapter.IWXUserTrackAdapter iWXUserTrackAdapter) {
            this.utAdapter = iWXUserTrackAdapter;
            return this;
        }

        public com.taobao.weex.InitConfig.Builder setStorageAdapter(com.taobao.weex.appfram.storage.IWXStorageAdapter iWXStorageAdapter) {
            this.storageAdapter = iWXStorageAdapter;
            return this;
        }

        public com.taobao.weex.InitConfig.Builder setURIAdapter(com.taobao.weex.adapter.URIAdapter uRIAdapter) {
            this.mURIAdapter = uRIAdapter;
            return this;
        }

        public com.taobao.weex.InitConfig.Builder setDCVueBridgeAdapter(com.taobao.weex.bridge.IDCVueBridgeAdapter iDCVueBridgeAdapter) {
            this.mVueBridgeAdapter = iDCVueBridgeAdapter;
            return this;
        }

        public com.taobao.weex.InitConfig.Builder setJSExceptionAdapter(com.taobao.weex.adapter.IWXJSExceptionAdapter iWXJSExceptionAdapter) {
            this.mJSExceptionAdapter = iWXJSExceptionAdapter;
            return this;
        }

        public com.taobao.weex.InitConfig.Builder setSoLoader(com.taobao.weex.adapter.IWXSoLoaderAdapter iWXSoLoaderAdapter) {
            this.soLoader = iWXSoLoaderAdapter;
            return this;
        }

        public com.taobao.weex.InitConfig.Builder setFramework(java.lang.String str) {
            this.framework = str;
            return this;
        }

        public com.taobao.weex.InitConfig.Builder setWebSocketAdapterFactory(com.taobao.weex.appfram.websocket.IWebSocketAdapterFactory iWebSocketAdapterFactory) {
            this.webSocketAdapterFactory = iWebSocketAdapterFactory;
            return this;
        }

        public com.taobao.weex.InitConfig.Builder setClassLoaderAdapter(com.taobao.weex.adapter.ClassLoaderAdapter classLoaderAdapter) {
            this.classLoaderAdapter = classLoaderAdapter;
            return this;
        }

        public com.taobao.weex.InitConfig.Builder setApmGenerater(com.taobao.weex.performance.IApmGenerator iApmGenerator) {
            this.apmGenerater = iApmGenerator;
            return this;
        }

        public com.taobao.weex.InitConfig.Builder setJsFileLoaderAdapter(com.taobao.weex.adapter.IWXJsFileLoaderAdapter iWXJsFileLoaderAdapter) {
            this.jsFileLoaderAdapter = iWXJsFileLoaderAdapter;
            return this;
        }

        public com.taobao.weex.InitConfig.Builder addNativeLibrary(java.lang.String str) {
            this.nativeLibraryList.add(str);
            return this;
        }

        public com.taobao.weex.InitConfig build() {
            com.taobao.weex.InitConfig initConfig = new com.taobao.weex.InitConfig();
            initConfig.httpAdapter = this.httpAdapter;
            initConfig.imgAdapter = this.imgAdapter;
            initConfig.drawableLoader = this.drawableLoader;
            initConfig.utAdapter = this.utAdapter;
            initConfig.storageAdapter = this.storageAdapter;
            initConfig.soLoader = this.soLoader;
            initConfig.framework = this.framework;
            initConfig.mURIAdapter = this.mURIAdapter;
            initConfig.mVueBridgeAdaper = this.mVueBridgeAdapter;
            initConfig.webSocketAdapterFactory = this.webSocketAdapterFactory;
            initConfig.mJSExceptionAdapter = this.mJSExceptionAdapter;
            initConfig.classLoaderAdapter = this.classLoaderAdapter;
            initConfig.apmGenerater = this.apmGenerater;
            initConfig.jsFileLoaderAdapter = this.jsFileLoaderAdapter;
            initConfig.jscProcessManager = this.jscProcessManager;
            initConfig.nativeLibraryList = this.nativeLibraryList;
            return initConfig;
        }
    }
}
