package com.taobao.weex;

/* JADX INFO: loaded from: classes.dex */
public class WXHttpListener implements com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener {
    private com.taobao.weex.common.WXRenderStrategy flag;
    private com.taobao.weex.WXSDKInstance instance;
    private boolean isInstanceReady;
    public boolean isPreDownLoadMode;
    private boolean isResponseHasWait;
    private java.lang.String jsonInitData;
    private com.taobao.weex.performance.WXInstanceApm mApmForInstance;
    private java.lang.String mBundleUrl;
    private com.taobao.weex.utils.tools.LogDetail mLogDetail;
    private com.taobao.weex.common.WXResponse mResponse;
    private com.taobao.weex.adapter.IWXUserTrackAdapter mUserTrackAdapter;
    private com.taobao.weex.common.WXPerformance mWXPerformance;
    private java.util.Map<java.lang.String, java.lang.Object> options;
    private java.lang.String pageName;
    private long startRequestTime;
    private int traceId;

    public void onFail(com.taobao.weex.common.WXResponse wXResponse) {
    }

    @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
    public void onHttpUploadProgress(int i) {
    }

    public WXHttpListener(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        this.isPreDownLoadMode = false;
        this.isInstanceReady = false;
        this.isResponseHasWait = false;
        if (wXSDKInstance != null) {
            this.mLogDetail = wXSDKInstance.mTimeCalculator.createLogDetail("downloadBundleJS");
        }
        this.instance = wXSDKInstance;
        this.traceId = com.taobao.weex.tracing.WXTracing.nextId();
        this.mWXPerformance = wXSDKInstance.getWXPerformance();
        this.mApmForInstance = wXSDKInstance.getApmForInstance();
        this.mUserTrackAdapter = com.taobao.weex.WXSDKManager.getInstance().getIWXUserTrackAdapter();
        if (com.taobao.weex.tracing.WXTracing.isAvailable()) {
            com.taobao.weex.tracing.WXTracing.TraceEvent traceEventNewEvent = com.taobao.weex.tracing.WXTracing.newEvent("downloadBundleJS", wXSDKInstance.getInstanceId(), -1);
            traceEventNewEvent.iid = wXSDKInstance.getInstanceId();
            traceEventNewEvent.tname = "Network";
            traceEventNewEvent.ph = "B";
            traceEventNewEvent.traceId = this.traceId;
            traceEventNewEvent.submit();
        }
    }

    public WXHttpListener(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str) {
        this(wXSDKInstance);
        this.startRequestTime = java.lang.System.currentTimeMillis();
        this.mBundleUrl = str;
    }

    public WXHttpListener(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str2, com.taobao.weex.common.WXRenderStrategy wXRenderStrategy, long j) {
        this(wXSDKInstance);
        this.pageName = str;
        this.options = map;
        this.jsonInitData = str2;
        this.flag = wXRenderStrategy;
        this.startRequestTime = j;
        this.mBundleUrl = wXSDKInstance.getBundleUrl();
    }

    public void setSDKInstance(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        this.instance = wXSDKInstance;
    }

    protected com.taobao.weex.WXSDKInstance getInstance() {
        return this.instance;
    }

    @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
    public void onHttpStart() {
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.instance;
        if (wXSDKInstance == null || wXSDKInstance.getWXStatisticsListener() == null) {
            return;
        }
        this.instance.getWXStatisticsListener().onHttpStart();
        com.taobao.weex.utils.tools.LogDetail logDetail = this.mLogDetail;
        if (logDetail != null) {
            logDetail.taskStart();
        }
    }

    @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
    public void onHeadersReceived(int i, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.instance;
        if (wXSDKInstance != null && wXSDKInstance.getWXStatisticsListener() != null) {
            this.instance.getWXStatisticsListener().onHeadersReceived();
            this.instance.onHttpStart();
        }
        com.taobao.weex.WXSDKInstance wXSDKInstance2 = this.instance;
        if (wXSDKInstance2 == null || wXSDKInstance2.responseHeaders == null || map == null) {
            return;
        }
        this.instance.responseHeaders.putAll(map);
    }

    @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
    public void onHttpResponseProgress(int i) {
        this.instance.getApmForInstance().extInfo.put(com.taobao.weex.performance.WXInstanceApm.VALUE_BUNDLE_LOAD_LENGTH, java.lang.Integer.valueOf(i));
    }

    @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
    public void onHttpFinish(com.taobao.weex.common.WXResponse wXResponse) {
        com.taobao.weex.utils.tools.LogDetail logDetail = this.mLogDetail;
        if (logDetail != null) {
            logDetail.taskEnd();
        }
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.instance;
        if (wXSDKInstance != null && wXSDKInstance.getWXStatisticsListener() != null) {
            this.instance.getWXStatisticsListener().onHttpFinish();
        }
        if (com.taobao.weex.tracing.WXTracing.isAvailable()) {
            com.taobao.weex.tracing.WXTracing.TraceEvent traceEventNewEvent = com.taobao.weex.tracing.WXTracing.newEvent("downloadBundleJS", this.instance.getInstanceId(), -1);
            traceEventNewEvent.traceId = this.traceId;
            traceEventNewEvent.tname = "Network";
            traceEventNewEvent.ph = "E";
            traceEventNewEvent.extParams = new java.util.HashMap();
            if (wXResponse != null && wXResponse.originalData != null) {
                traceEventNewEvent.extParams.put("BundleSize", java.lang.Integer.valueOf(wXResponse.originalData.length));
            }
            traceEventNewEvent.submit();
        }
        this.mWXPerformance.networkTime = java.lang.System.currentTimeMillis() - this.startRequestTime;
        if (wXResponse != null && wXResponse.extendParams != null) {
            this.mApmForInstance.updateRecordInfo(wXResponse.extendParams);
            java.lang.Object obj = wXResponse.extendParams.get("actualNetworkTime");
            this.mWXPerformance.actualNetworkTime = obj instanceof java.lang.Long ? ((java.lang.Long) obj).longValue() : 0L;
            java.lang.Object obj2 = wXResponse.extendParams.get("pureNetworkTime");
            this.mWXPerformance.pureNetworkTime = obj2 instanceof java.lang.Long ? ((java.lang.Long) obj2).longValue() : 0L;
            java.lang.Object obj3 = wXResponse.extendParams.get("connectionType");
            this.mWXPerformance.connectionType = obj3 instanceof java.lang.String ? (java.lang.String) obj3 : "";
            java.lang.Object obj4 = wXResponse.extendParams.get("packageSpendTime");
            this.mWXPerformance.packageSpendTime = obj4 instanceof java.lang.Long ? ((java.lang.Long) obj4).longValue() : 0L;
            java.lang.Object obj5 = wXResponse.extendParams.get("syncTaskTime");
            this.mWXPerformance.syncTaskTime = obj5 instanceof java.lang.Long ? ((java.lang.Long) obj5).longValue() : 0L;
            java.lang.Object obj6 = wXResponse.extendParams.get("requestType");
            this.mWXPerformance.requestType = obj6 instanceof java.lang.String ? (java.lang.String) obj6 : "none";
            java.lang.Object obj7 = wXResponse.extendParams.get(com.taobao.weex.common.WXPerformance.Dimension.cacheType.toString());
            if (obj7 instanceof java.lang.String) {
                this.mWXPerformance.cacheType = (java.lang.String) obj7;
            }
            java.lang.Object obj8 = wXResponse.extendParams.get("zCacheInfo");
            this.mWXPerformance.zCacheInfo = obj8 instanceof java.lang.String ? (java.lang.String) obj8 : "";
            if (isNet(this.mWXPerformance.requestType) && this.mUserTrackAdapter != null) {
                com.taobao.weex.common.WXPerformance wXPerformance = new com.taobao.weex.common.WXPerformance(this.instance.getInstanceId());
                if (!android.text.TextUtils.isEmpty(this.mBundleUrl)) {
                    try {
                        wXPerformance.args = android.net.Uri.parse(this.mBundleUrl).buildUpon().clearQuery().toString();
                    } catch (java.lang.Exception unused) {
                        wXPerformance.args = this.pageName;
                    }
                }
                if (!"200".equals(wXResponse.statusCode)) {
                    wXPerformance.errCode = com.taobao.weex.common.WXErrorCode.WX_ERR_JSBUNDLE_DOWNLOAD.getErrorCode();
                    wXPerformance.appendErrMsg(wXResponse.errorCode);
                    wXPerformance.appendErrMsg("|");
                    wXPerformance.appendErrMsg(wXResponse.errorMsg);
                } else if ("200".equals(wXResponse.statusCode) && (wXResponse.originalData == null || wXResponse.originalData.length <= 0)) {
                    wXPerformance.errCode = com.taobao.weex.common.WXErrorCode.WX_ERR_JSBUNDLE_DOWNLOAD.getErrorCode();
                    wXPerformance.appendErrMsg(wXResponse.statusCode);
                    wXPerformance.appendErrMsg("|template is null!");
                } else {
                    wXPerformance.errCode = com.taobao.weex.common.WXErrorCode.WX_SUCCESS.getErrorCode();
                }
                com.taobao.weex.adapter.IWXUserTrackAdapter iWXUserTrackAdapter = this.mUserTrackAdapter;
                if (iWXUserTrackAdapter != null) {
                    iWXUserTrackAdapter.commit(this.instance.getContext(), null, com.taobao.weex.adapter.IWXUserTrackAdapter.JS_DOWNLOAD, wXPerformance, null);
                }
            }
        }
        if (this.isPreDownLoadMode) {
            if (this.isInstanceReady) {
                com.taobao.weex.utils.WXLogUtils.e("test->", "DownLoad didHttpFinish on http");
                didHttpFinish(wXResponse);
                return;
            } else {
                com.taobao.weex.utils.WXLogUtils.e("test->", "DownLoad end before activity created");
                this.mResponse = wXResponse;
                this.isResponseHasWait = true;
                return;
            }
        }
        didHttpFinish(wXResponse);
    }

    public void onInstanceReady() {
        if (this.isPreDownLoadMode) {
            this.isInstanceReady = true;
            if (this.isResponseHasWait) {
                com.taobao.weex.utils.WXLogUtils.e("test->", "preDownLoad didHttpFinish on ready");
                didHttpFinish(this.mResponse);
            }
        }
    }

    private void didHttpFinish(com.taobao.weex.common.WXResponse wXResponse) {
        java.lang.String errorCode;
        if (wXResponse != null && wXResponse.originalData != null && android.text.TextUtils.equals("200", wXResponse.statusCode)) {
            this.mApmForInstance.onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_END);
            onSuccess(wXResponse);
            errorCode = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
        } else if (android.text.TextUtils.equals(com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR.getErrorCode(), wXResponse.statusCode)) {
            com.taobao.weex.utils.WXLogUtils.e("user intercept: WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR");
            errorCode = com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR.getErrorCode();
            this.instance.onRenderError(errorCode, "|response.errorMsg==" + wXResponse.errorMsg + "|instance bundleUrl = \n" + this.instance.getBundleUrl() + "|instance requestUrl = \n" + android.net.Uri.decode(com.taobao.weex.WXSDKInstance.requestUrl));
            onFail(wXResponse);
        } else if (wXResponse != null && wXResponse.originalData != null && android.text.TextUtils.equals("-206", wXResponse.statusCode)) {
            com.taobao.weex.utils.WXLogUtils.e("user intercept: WX_DEGRAD_ERR_NETWORK_CHECK_CONTENT_LENGTH_FAILED");
            errorCode = com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_NETWORK_CHECK_CONTENT_LENGTH_FAILED.getErrorCode();
            this.instance.onRenderError(errorCode, com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_NETWORK_CHECK_CONTENT_LENGTH_FAILED.getErrorCode() + "|response.errorMsg==" + wXResponse.errorMsg);
            onFail(wXResponse);
        } else {
            errorCode = com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_NETWORK_BUNDLE_DOWNLOAD_FAILED.getErrorCode();
            this.instance.onRenderError(errorCode, wXResponse.errorMsg);
            onFail(wXResponse);
        }
        if (com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT.equals(errorCode)) {
            return;
        }
        this.mApmForInstance.addProperty(com.taobao.weex.performance.WXInstanceApm.KEY_PROPERTIES_ERROR_CODE, errorCode);
    }

    private boolean isNet(java.lang.String str) {
        return "network".equals(str) || "2g".equals(str) || "3g".equals(str) || "4g".equals(str) || "wifi".equals(str) || "other".equals(str) || "unknown".equals(str);
    }

    public void onSuccess(com.taobao.weex.common.WXResponse wXResponse) {
        if (this.flag == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY) {
            this.instance.render(this.pageName, wXResponse.originalData, this.options, this.jsonInitData);
        } else {
            this.instance.render(this.pageName, new java.lang.String(wXResponse.originalData), this.options, this.jsonInitData, this.flag);
        }
    }
}
