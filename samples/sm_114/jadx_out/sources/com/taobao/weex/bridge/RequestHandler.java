package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public class RequestHandler {
    native void nativeInvokeOnFailed(long j);

    native void nativeInvokeOnSuccess(long j, java.lang.String str, java.lang.String str2);

    public static com.taobao.weex.bridge.RequestHandler create() {
        return new com.taobao.weex.bridge.RequestHandler();
    }

    public void send(java.lang.String str, java.lang.String str2, long j) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || j == 0 || !com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().containsKey(str)) {
            return;
        }
        com.taobao.weex.WXSDKManager wXSDKManager = com.taobao.weex.WXSDKManager.getInstance();
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
        if (sDKInstance == null) {
            return;
        }
        com.taobao.weex.adapter.IWXHttpAdapter iWXHttpAdapter = com.taobao.weex.WXSDKManager.getInstance().getIWXHttpAdapter();
        com.taobao.weex.common.WXRequest wXRequest = new com.taobao.weex.common.WXRequest();
        wXRequest.url = wXSDKManager.getURIAdapter().rewrite(sDKInstance, io.dcloud.feature.uniapp.adapter.AbsURIAdapter.BUNDLE, android.net.Uri.parse(str2)).toString();
        if (wXRequest.paramMap == null) {
            wXRequest.paramMap = new java.util.HashMap();
        }
        wXRequest.paramMap.put(com.taobao.weex.http.WXHttpUtil.KEY_USER_AGENT, com.taobao.weex.http.WXHttpUtil.assembleUserAgent(sDKInstance.getContext(), com.taobao.weex.WXEnvironment.getConfig()));
        wXRequest.paramMap.put("isBundleRequest", io.dcloud.common.constant.AbsoluteConst.TRUE);
        com.taobao.weex.utils.WXLogUtils.i("Eagle", java.lang.String.format(java.util.Locale.ENGLISH, "Weex eagle is going to download script from %s", str2));
        iWXHttpAdapter.sendRequest(wXRequest, new com.taobao.weex.bridge.RequestHandler.OnHttpListenerInner(sDKInstance, j, str2));
    }

    public void getBundleType(java.lang.String str, final java.lang.String str2, final long j) {
        com.taobao.weex.bridge.WXBridgeManager.BundType bundleType = com.taobao.weex.bridge.WXBridgeManager.getInstance().getBundleType("", str2);
        final java.lang.String string = bundleType == null ? "Others" : bundleType.toString();
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
        if ("Others".equalsIgnoreCase(string) && sDKInstance != null) {
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_NO_BUNDLE_TYPE, "RequestHandler.onSuccess", "eagle ->" + com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_NO_BUNDLE_TYPE.getErrorMsg(), null);
        }
        com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.RequestHandler.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.taobao.weex.bridge.WXBridgeManager.getInstance().isJSFrameworkInit()) {
                    com.taobao.weex.bridge.RequestHandler.this.nativeInvokeOnSuccess(j, str2, string);
                } else {
                    com.taobao.weex.bridge.RequestHandler.this.nativeInvokeOnFailed(j);
                }
            }
        });
    }

    class OnHttpListenerInner extends com.taobao.weex.WXHttpListener {
        private long sNativeCallback;

        OnHttpListenerInner(com.taobao.weex.WXSDKInstance wXSDKInstance, long j, java.lang.String str) {
            super(wXSDKInstance, str);
            this.sNativeCallback = j;
        }

        @Override // com.taobao.weex.WXHttpListener
        public void onSuccess(com.taobao.weex.common.WXResponse wXResponse) {
            final java.lang.String str = new java.lang.String(wXResponse.originalData);
            com.taobao.weex.bridge.WXBridgeManager.BundType bundleType = com.taobao.weex.bridge.WXBridgeManager.getInstance().getBundleType("", str);
            final java.lang.String string = bundleType == null ? "Others" : bundleType.toString();
            if ("Others".equalsIgnoreCase(string) && getInstance() != null) {
                com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(getInstance().getInstanceId(), com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_NO_BUNDLE_TYPE, "RequestHandler.onSuccess", "eagle ->" + com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_NO_BUNDLE_TYPE.getErrorMsg(), null);
            }
            com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.RequestHandler.OnHttpListenerInner.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.taobao.weex.bridge.WXBridgeManager.getInstance().isJSFrameworkInit()) {
                        com.taobao.weex.bridge.RequestHandler.this.nativeInvokeOnSuccess(com.taobao.weex.bridge.RequestHandler.OnHttpListenerInner.this.sNativeCallback, str, string);
                    } else {
                        com.taobao.weex.bridge.RequestHandler.this.nativeInvokeOnFailed(com.taobao.weex.bridge.RequestHandler.OnHttpListenerInner.this.sNativeCallback);
                    }
                }
            });
        }

        @Override // com.taobao.weex.WXHttpListener
        public void onFail(com.taobao.weex.common.WXResponse wXResponse) {
            com.taobao.weex.bridge.RequestHandler.this.nativeInvokeOnFailed(this.sNativeCallback);
        }
    }
}
