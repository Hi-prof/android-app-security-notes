package com.taobao.weex.performance;

/* JADX INFO: loaded from: classes.dex */
public class WXInstanceApm {
    public static final java.lang.String KEY_PAGE_ANIM_BACK_NUM = "wxAnimationInBackCount";
    public static final java.lang.String KEY_PAGE_PROPERTIES_BIZ_ID = "wxBizID";
    public static final java.lang.String KEY_PAGE_PROPERTIES_BUBDLE_URL = "wxBundleUrl";
    public static final java.lang.String KEY_PAGE_PROPERTIES_BUNDLE_TYPE = "wxBundleType";
    public static final java.lang.String KEY_PAGE_PROPERTIES_CACHE_INFO = "wxZCacheInfo";
    public static final java.lang.String KEY_PAGE_PROPERTIES_CACHE_TYPE = "wxCacheType";
    public static final java.lang.String KEY_PAGE_PROPERTIES_CONTAINER_NAME = "wxContainerName";
    public static final java.lang.String KEY_PAGE_PROPERTIES_INSTANCE_TYPE = "wxInstanceType";
    public static final java.lang.String KEY_PAGE_PROPERTIES_JSLIB_VERSION = "wxJSLibVersion";
    public static final java.lang.String KEY_PAGE_PROPERTIES_JS_FM_INI = "wxJsFrameworkInit";
    public static final java.lang.String KEY_PAGE_PROPERTIES_PARENT_PAGE = "wxParentPage";
    public static final java.lang.String KEY_PAGE_PROPERTIES_RENDER_TYPE = "wxRenderType";
    public static final java.lang.String KEY_PAGE_PROPERTIES_REQUEST_TYPE = "wxRequestType";
    public static final java.lang.String KEY_PAGE_PROPERTIES_UIKIT_TYPE = "wxUIKitType";
    public static final java.lang.String KEY_PAGE_PROPERTIES_WEEX_VERSION = "wxSDKVersion";
    public static final java.lang.String KEY_PAGE_STAGES_CONTAINER_READY = "wxContainerReady";
    public static final java.lang.String KEY_PAGE_STAGES_CREATE_FINISH = "wxJSBundleCreateFinish";
    public static final java.lang.String KEY_PAGE_STAGES_CUSTOM_PREPROCESS_END = "wxCustomPreprocessEnd";
    public static final java.lang.String KEY_PAGE_STAGES_CUSTOM_PREPROCESS_START = "wxCustomPreprocessStart";
    public static final java.lang.String KEY_PAGE_STAGES_DESTROY = "wxDestroy";
    public static final java.lang.String KEY_PAGE_STAGES_DOWN_BUNDLE_END = "wxEndDownLoadBundle";
    public static final java.lang.String KEY_PAGE_STAGES_DOWN_BUNDLE_START = "wxStartDownLoadBundle";
    public static final java.lang.String KEY_PAGE_STAGES_END_EXCUTE_BUNDLE = "wxEndExecuteBundle";
    public static final java.lang.String KEY_PAGE_STAGES_FIRST_INTERACTION_VIEW = "wxFirstInteractionView";
    public static final java.lang.String KEY_PAGE_STAGES_FSRENDER = "wxFsRender";
    public static final java.lang.String KEY_PAGE_STAGES_INTERACTION = "wxInteraction";
    public static final java.lang.String KEY_PAGE_STAGES_LOAD_BUNDLE_END = "wxEndLoadBundle";
    public static final java.lang.String KEY_PAGE_STAGES_LOAD_BUNDLE_START = "wxStartLoadBundle";
    public static final java.lang.String KEY_PAGE_STAGES_NEW_FSRENDER = "wxNewFsRender";
    public static final java.lang.String KEY_PAGE_STAGES_RENDER_ORGIGIN = "wxRenderTimeOrigin";
    public static final java.lang.String KEY_PAGE_STATS_ACTUAL_DOWNLOAD_TIME = "wxActualNetworkTime";
    public static final java.lang.String KEY_PAGE_STATS_BODY_RATIO = "wxBodyRatio";
    public static final java.lang.String KEY_PAGE_STATS_BUNDLE_SIZE = "wxBundleSize";
    public static final java.lang.String KEY_PAGE_STATS_CELL_DATA_UN_RECYCLE_NUM = "wxCellDataUnRecycleCount";
    public static final java.lang.String KEY_PAGE_STATS_CELL_EXCEED_NUM = "wxCellExceedNum";
    public static final java.lang.String KEY_PAGE_STATS_CELL_UN_RE_USE_NUM = "wxCellUnReUseCount";
    public static final java.lang.String KEY_PAGE_STATS_COMPONENT_CREATE_COST = "wxComponentCost";
    public static final java.lang.String KEY_PAGE_STATS_EMBED_COUNT = "wxEmbedCount";
    public static final java.lang.String KEY_PAGE_STATS_EXECUTE_JS_CALLBACK_COST = "wxExecJsCallBack";
    public static final java.lang.String KEY_PAGE_STATS_FS_CALL_EVENT_NUM = "wxFSCallEventTotalNum";
    public static final java.lang.String KEY_PAGE_STATS_FS_CALL_JS_NUM = "wxFSCallJsTotalNum";
    public static final java.lang.String KEY_PAGE_STATS_FS_CALL_JS_TIME = "wxFSCallJsTotalTime";
    public static final java.lang.String KEY_PAGE_STATS_FS_CALL_NATIVE_NUM = "wxFSCallNativeTotalNum";
    public static final java.lang.String KEY_PAGE_STATS_FS_CALL_NATIVE_TIME = "wxFSCallNativeTotalTime";
    public static final java.lang.String KEY_PAGE_STATS_FS_REQUEST_NUM = "wxFSRequestNum";
    public static final java.lang.String KEY_PAGE_STATS_FS_TIMER_NUM = "wxFSTimerCount";
    public static final java.lang.String KEY_PAGE_STATS_IMG_LOAD_FAIL_NUM = "wxImgLoadFailCount";
    public static final java.lang.String KEY_PAGE_STATS_IMG_LOAD_NUM = "wxImgLoadCount";
    public static final java.lang.String KEY_PAGE_STATS_IMG_LOAD_SUCCESS_NUM = "wxImgLoadSuccessCount";
    public static final java.lang.String KEY_PAGE_STATS_IMG_UN_RECYCLE_NUM = "wxImgUnRecycleCount";
    public static final java.lang.String KEY_PAGE_STATS_I_ALL_VIEW_COUNT = "wxInteractionAllViewCount";
    public static final java.lang.String KEY_PAGE_STATS_I_COMPONENT_CREATE_COUNT = "wxInteractionComponentCreateCount";
    public static final java.lang.String KEY_PAGE_STATS_I_SCREEN_VIEW_COUNT = "wxInteractionScreenViewCount";
    public static final java.lang.String KEY_PAGE_STATS_JSLIB_INIT_TIME = "wxJSLibInitTime";
    public static final java.lang.String KEY_PAGE_STATS_LARGE_IMG_COUNT = "wxLargeImgMaxCount";
    public static final java.lang.String KEY_PAGE_STATS_LAYOUT_TIME = "wxLayoutTime";
    public static final java.lang.String KEY_PAGE_STATS_MAX_COMPONENT_NUM = "wxMaxComponentCount";
    public static final java.lang.String KEY_PAGE_STATS_MAX_DEEP_DOM = "wxMaxDeepVDomLayer";
    public static final java.lang.String KEY_PAGE_STATS_MAX_DEEP_VIEW = "wxMaxDeepViewLayer";
    public static final java.lang.String KEY_PAGE_STATS_NET_FAIL_NUM = "wxNetworkRequestFailCount";
    public static final java.lang.String KEY_PAGE_STATS_NET_NUM = "wxNetworkRequestCount";
    public static final java.lang.String KEY_PAGE_STATS_NET_SUCCESS_NUM = "wxNetworkRequestSuccessCount";
    public static final java.lang.String KEY_PAGE_STATS_SCROLLER_NUM = "wxScrollerCount";
    public static final java.lang.String KEY_PAGE_STATS_VIEW_CREATE_COST = "wxViewCost";
    public static final java.lang.String KEY_PAGE_STATS_WRONG_IMG_SIZE_COUNT = "wxWrongImgSizeCount";
    public static final java.lang.String KEY_PAGE_TIMER_BACK_NUM = "wxTimerInBackCount";
    public static final java.lang.String KEY_PROPERTIES_ERROR_CODE = "wxErrorCode";
    public static final java.lang.String VALUE_BUNDLE_LOAD_LENGTH = "wxLoadedLength";
    public static final java.lang.String VALUE_ERROR_CODE_DEFAULT = "0";
    public static final java.lang.String WEEX_PAGE_TOPIC = "weex_page";
    private com.taobao.weex.performance.IWXApmMonitorAdapter apmInstance;
    public long componentCreateTime;
    public boolean hasAddView;
    public android.graphics.Rect instanceRect;
    private long interactionComponentCreateTime;
    private long interactionJsCallBackTime;
    private double interactionLayoutTime;
    private long interactionViewCreateTime;
    private boolean isFSEnd;
    private java.lang.String mInstanceId;
    public java.lang.String reportPageName;
    public long viewCreateTime;
    private long wxExecJsCallBackTime;
    private boolean mHasInit = false;
    private boolean mEnd = false;
    private boolean hasRecordFistInteractionView = false;
    public boolean forceStopRecordInteraction = false;
    public boolean hasReportLayerOverDraw = false;
    public java.util.Set<java.lang.String> exceptionRecord = new java.util.concurrent.CopyOnWriteArraySet();
    private boolean mHasRecordDetailData = false;
    private boolean hasSendInteractionToJS = false;
    public volatile boolean isReady = true;
    private java.lang.Runnable jsPerformanceCallBack = new java.lang.Runnable() { // from class: com.taobao.weex.performance.WXInstanceApm.1
        @Override // java.lang.Runnable
        public void run() {
            com.taobao.weex.performance.WXInstanceApm.this.sendPerformanceToJS();
        }
    };
    private java.lang.Runnable delayCollectDataTask = new java.lang.Runnable() { // from class: com.taobao.weex.performance.WXInstanceApm.2
        @Override // java.lang.Runnable
        public void run() {
            com.taobao.weex.performance.WXInstanceApm.this.recordPerformanceDetailData();
        }
    };
    private long preUpdateTime = 0;
    public final java.util.Map<java.lang.String, java.lang.Object> extInfo = new java.util.concurrent.ConcurrentHashMap();
    public final java.util.Map<java.lang.String, java.lang.Long> stageMap = new java.util.concurrent.ConcurrentHashMap();
    private android.os.Handler mUIHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private java.util.Map<java.lang.String, java.lang.Double> recordStatsMap = new java.util.concurrent.ConcurrentHashMap();
    private java.util.Map<java.lang.String, java.lang.Object> mPropertiesMap = new java.util.concurrent.ConcurrentHashMap();

    public WXInstanceApm(java.lang.String str) {
        this.mInstanceId = str;
        com.taobao.weex.performance.IApmGenerator apmGenerater = com.taobao.weex.WXSDKManager.getInstance().getApmGenerater();
        if (apmGenerater != null) {
            this.apmInstance = apmGenerater.generateApmInstance(WEEX_PAGE_TOPIC);
        }
    }

    public void onInstanceReady(boolean z) {
        this.isReady = true;
        if (z) {
            onStage(KEY_PAGE_STAGES_DOWN_BUNDLE_START);
        }
        doInit();
        for (java.util.Map.Entry<java.lang.String, java.lang.Long> entry : this.stageMap.entrySet()) {
            sendStageInfo(entry.getKey(), entry.getValue().longValue());
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.Double> entry2 : this.recordStatsMap.entrySet()) {
            sendStats(entry2.getKey(), entry2.getValue().doubleValue());
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry3 : this.mPropertiesMap.entrySet()) {
            sendProperty(entry3.getKey(), entry3.getValue());
        }
    }

    public void onEvent(java.lang.String str, java.lang.Object obj) {
        com.taobao.weex.performance.IWXApmMonitorAdapter iWXApmMonitorAdapter = this.apmInstance;
        if (iWXApmMonitorAdapter == null) {
            return;
        }
        iWXApmMonitorAdapter.onEvent(str, obj);
    }

    public void onStage(java.lang.String str) {
        onStageWithTime(str, com.taobao.weex.utils.WXUtils.getFixUnixTime());
    }

    public void onStageWithTime(java.lang.String str, long j) {
        if (this.mEnd || str == null) {
            return;
        }
        this.stageMap.put(str, java.lang.Long.valueOf(j));
        if (this.isReady) {
            sendStageInfo(str, j);
        }
    }

    private void sendStageInfo(java.lang.String str, long j) {
        if (com.taobao.weex.performance.WXAnalyzerDataTransfer.isOpenPerformance) {
            com.taobao.weex.performance.WXAnalyzerDataTransfer.transferPerformance(this.mInstanceId, "stage", str, java.lang.Long.valueOf(j));
        }
        if (KEY_PAGE_STAGES_RENDER_ORGIGIN.equalsIgnoreCase(str)) {
            this.mUIHandler.postDelayed(this.jsPerformanceCallBack, 8000L);
        }
        com.taobao.weex.performance.IWXApmMonitorAdapter iWXApmMonitorAdapter = this.apmInstance;
        if (iWXApmMonitorAdapter == null) {
            return;
        }
        iWXApmMonitorAdapter.onStage(str, j);
    }

    public void addProperty(java.lang.String str, java.lang.Object obj) {
        if (this.mEnd || str == null || obj == null) {
            return;
        }
        this.mPropertiesMap.put(str, obj);
        if (this.isReady) {
            sendProperty(str, obj);
        }
    }

    private void sendProperty(java.lang.String str, java.lang.Object obj) {
        if (com.taobao.weex.performance.WXAnalyzerDataTransfer.isOpenPerformance) {
            com.taobao.weex.performance.WXAnalyzerDataTransfer.transferPerformance(this.mInstanceId, "properties", str, obj);
        }
        com.taobao.weex.performance.IWXApmMonitorAdapter iWXApmMonitorAdapter = this.apmInstance;
        if (iWXApmMonitorAdapter == null) {
            return;
        }
        iWXApmMonitorAdapter.addProperty(str, obj);
    }

    public void addStats(java.lang.String str, double d) {
        if (this.mEnd || str == null) {
            return;
        }
        this.recordStatsMap.put(str, java.lang.Double.valueOf(d));
        if (this.isReady) {
            sendStats(str, d);
        }
    }

    private void sendStats(java.lang.String str, double d) {
        if (com.taobao.weex.performance.WXAnalyzerDataTransfer.isOpenPerformance) {
            com.taobao.weex.performance.WXAnalyzerDataTransfer.transferPerformance(this.mInstanceId, "stats", str, java.lang.Double.valueOf(d));
        }
        com.taobao.weex.performance.IWXApmMonitorAdapter iWXApmMonitorAdapter = this.apmInstance;
        if (iWXApmMonitorAdapter == null) {
            return;
        }
        iWXApmMonitorAdapter.addStats(str, d);
    }

    public boolean hasInit() {
        return this.mHasInit;
    }

    public void doInit() {
        if (this.isReady && !this.mHasInit) {
            this.mHasInit = true;
            com.taobao.weex.performance.IWXApmMonitorAdapter iWXApmMonitorAdapter = this.apmInstance;
            if (iWXApmMonitorAdapter == null) {
                return;
            }
            iWXApmMonitorAdapter.onStart(this.mInstanceId);
            com.taobao.weex.WXSDKInstance wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().get(this.mInstanceId);
            addProperty(KEY_PAGE_PROPERTIES_BUBDLE_URL, wXSDKInstance == null ? "unKnowUrl" : wXSDKInstance.getBundleUrl());
            addProperty(KEY_PROPERTIES_ERROR_CODE, VALUE_ERROR_CODE_DEFAULT);
            addProperty(KEY_PAGE_PROPERTIES_JSLIB_VERSION, com.taobao.weex.WXEnvironment.JS_LIB_SDK_VERSION);
            addProperty(KEY_PAGE_PROPERTIES_WEEX_VERSION, com.taobao.weex.WXEnvironment.WXSDK_VERSION);
            addProperty(KEY_PAGE_PROPERTIES_WEEX_VERSION, com.taobao.weex.WXEnvironment.WXSDK_VERSION);
            addStats("wxReInitCount", com.taobao.weex.bridge.WXBridgeManager.reInitCount);
            if (wXSDKInstance != null) {
                addProperty(KEY_PAGE_PROPERTIES_UIKIT_TYPE, wXSDKInstance.getRenderType());
            }
            addProperty("wxUseRuntimeApi", java.lang.Boolean.valueOf(com.taobao.weex.WXEnvironment.sUseRunTimeApi));
            if (wXSDKInstance != null && (wXSDKInstance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER || wXSDKInstance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY)) {
                addProperty(KEY_PAGE_PROPERTIES_RENDER_TYPE, com.taobao.weex.WXEnvironment.EAGLE);
            }
            if (wXSDKInstance != null) {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : wXSDKInstance.getContainerInfo().entrySet()) {
                    addProperty(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public void setPageName(java.lang.String str) {
        com.taobao.weex.WXSDKInstance wXSDKInstance;
        if (android.text.TextUtils.isEmpty(str) && (wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().get(this.mInstanceId)) != null) {
            str = wXSDKInstance.getContainerInfo().get(KEY_PAGE_PROPERTIES_CONTAINER_NAME);
        }
        com.taobao.weex.performance.IWXApmMonitorAdapter iWXApmMonitorAdapter = this.apmInstance;
        if (iWXApmMonitorAdapter != null) {
            str = iWXApmMonitorAdapter.parseReportUrl(str);
        }
        this.reportPageName = str;
        java.lang.String str2 = android.text.TextUtils.isEmpty(str) ? "emptyPageName" : this.reportPageName;
        this.reportPageName = str2;
        addProperty(KEY_PAGE_PROPERTIES_BIZ_ID, str2);
    }

    public void onAppear() {
        com.taobao.weex.performance.IWXApmMonitorAdapter iWXApmMonitorAdapter = this.apmInstance;
        if (iWXApmMonitorAdapter == null) {
            return;
        }
        iWXApmMonitorAdapter.onAppear();
    }

    public void onDisAppear() {
        com.taobao.weex.performance.IWXApmMonitorAdapter iWXApmMonitorAdapter = this.apmInstance;
        if (iWXApmMonitorAdapter == null) {
            return;
        }
        iWXApmMonitorAdapter.onDisappear();
    }

    public void onEnd() {
        if (this.apmInstance == null || this.mEnd) {
            return;
        }
        new android.os.Handler(android.os.Looper.getMainLooper()).removeCallbacks(this.delayCollectDataTask);
        recordPerformanceDetailData();
        this.exceptionRecord.clear();
        this.mUIHandler.removeCallbacks(this.jsPerformanceCallBack);
        onStage(KEY_PAGE_STAGES_DESTROY);
        if (!this.mHasInit) {
            this.apmInstance.onEnd();
        }
        this.mEnd = true;
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            printLog();
        }
    }

    public void doDelayCollectData() {
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(this.delayCollectDataTask, 8000L);
    }

    private void printLog() {
        java.lang.Long l = this.stageMap.get(KEY_PAGE_STAGES_DOWN_BUNDLE_START);
        java.lang.Long l2 = this.stageMap.get(KEY_PAGE_STAGES_DOWN_BUNDLE_END);
        java.lang.Long l3 = this.stageMap.get(KEY_PAGE_STAGES_INTERACTION);
        java.lang.Long l4 = this.stageMap.get(KEY_PAGE_STAGES_CONTAINER_READY);
        if (l2 != null && l != null) {
            com.taobao.weex.utils.WXLogUtils.d("test->", "downLoadTime: " + (l2.longValue() - l.longValue()));
        }
        if (l2 != null && l3 != null) {
            com.taobao.weex.utils.WXLogUtils.d("test->", "renderTime: " + (l3.longValue() - l2.longValue()));
        }
        if (l4 == null || l3 == null) {
            return;
        }
        com.taobao.weex.utils.WXLogUtils.d("test->", "showTime: " + (l3.longValue() - l4.longValue()));
    }

    public void arriveNewFsRenderTime() {
        if (this.apmInstance == null) {
            return;
        }
        onStage(KEY_PAGE_STAGES_NEW_FSRENDER);
    }

    public void arriveFSRenderTime() {
        if (this.apmInstance == null) {
            return;
        }
        this.isFSEnd = true;
        onStage(KEY_PAGE_STAGES_FSRENDER);
    }

    public void arriveInteraction(com.taobao.weex.ui.component.WXComponent wXComponent) {
        com.taobao.weex.common.WXPerformance wXPerformance;
        if (this.apmInstance == null || wXComponent == null || wXComponent.getInstance() == null) {
            return;
        }
        if (com.taobao.weex.performance.WXAnalyzerDataTransfer.isOpenPerformance) {
            com.taobao.weex.performance.WXAnalyzerDataTransfer.transferInteractionInfo(wXComponent);
        }
        if (this.apmInstance == null || (wXPerformance = wXComponent.getInstance().getWXPerformance()) == null) {
            return;
        }
        long fixUnixTime = com.taobao.weex.utils.WXUtils.getFixUnixTime();
        if (com.taobao.weex.performance.WXAnalyzerDataTransfer.isInteractionLogOpen()) {
            android.util.Log.d(com.taobao.weex.performance.WXAnalyzerDataTransfer.INTERACTION_TAG, "[client][wxinteraction]" + wXComponent.getInstance().getInstanceId() + "," + wXComponent.getComponentType() + "," + wXComponent.getRef() + "," + wXComponent.getStyles() + "," + wXComponent.getAttrs());
        }
        if (!this.hasRecordFistInteractionView) {
            onStage(KEY_PAGE_STAGES_FIRST_INTERACTION_VIEW);
            this.hasRecordFistInteractionView = true;
        }
        if (this.forceStopRecordInteraction) {
            return;
        }
        long fixUnixTime2 = com.taobao.weex.utils.WXUtils.getFixUnixTime();
        if (fixUnixTime2 - this.preUpdateTime > 50) {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().onInteractionTimeUpdate(this.mInstanceId);
            this.preUpdateTime = fixUnixTime2;
        }
        this.interactionComponentCreateTime = this.componentCreateTime;
        this.interactionViewCreateTime = this.viewCreateTime;
        java.lang.Double d = this.recordStatsMap.get(KEY_PAGE_STATS_LAYOUT_TIME);
        this.interactionLayoutTime = d == null ? 0.0d : d.doubleValue();
        wXPerformance.interactionTime = fixUnixTime - wXPerformance.renderUnixTimeOrigin;
        wXPerformance.interactionRealUnixTime = java.lang.System.currentTimeMillis();
        onStageWithTime(KEY_PAGE_STAGES_INTERACTION, fixUnixTime);
        updateDiffStats(KEY_PAGE_STATS_I_SCREEN_VIEW_COUNT, 1.0d);
        updateMaxStats(KEY_PAGE_STATS_I_ALL_VIEW_COUNT, wXPerformance.localInteractionViewAddCount);
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(this.mInstanceId);
        if (sDKInstance != null) {
            updateMaxStats(KEY_PAGE_STATS_I_COMPONENT_CREATE_COUNT, sDKInstance.getWXPerformance().componentCount);
        }
    }

    public void updateFSDiffStats(java.lang.String str, double d) {
        if (this.apmInstance == null || this.isFSEnd) {
            return;
        }
        updateDiffStats(str, d);
    }

    public void recordPerformanceDetailData() {
        if (this.mHasRecordDetailData) {
            return;
        }
        this.mHasRecordDetailData = true;
        addStats(KEY_PAGE_STATS_VIEW_CREATE_COST, this.interactionViewCreateTime);
        addStats(KEY_PAGE_STATS_COMPONENT_CREATE_COST, this.interactionComponentCreateTime);
        addStats(KEY_PAGE_STATS_EXECUTE_JS_CALLBACK_COST, this.interactionJsCallBackTime);
        addStats(KEY_PAGE_STATS_LAYOUT_TIME, this.interactionLayoutTime);
    }

    public void updateDiffStats(java.lang.String str, double d) {
        if (this.apmInstance == null) {
            return;
        }
        double dDoubleValue = this.recordStatsMap.containsKey(str) ? this.recordStatsMap.get(str).doubleValue() : 0.0d;
        java.lang.Double dValueOf = java.lang.Double.valueOf(dDoubleValue);
        if (dValueOf == null) {
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT("", com.taobao.weex.common.WXErrorCode.WX_ERR_HASH_MAP_TMP, "updateDiffStats", "key : " + str, null);
            return;
        }
        dValueOf.getClass();
        addStats(str, dDoubleValue + d);
    }

    public void updateMaxStats(java.lang.String str, double d) {
        if (this.apmInstance == null) {
            return;
        }
        double dDoubleValue = this.recordStatsMap.containsKey(str) ? this.recordStatsMap.get(str).doubleValue() : 0.0d;
        java.lang.Double dValueOf = java.lang.Double.valueOf(dDoubleValue);
        if (dValueOf == null) {
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT("", com.taobao.weex.common.WXErrorCode.WX_ERR_HASH_MAP_TMP, "updateMaxStats", "key : " + str, null);
            return;
        }
        dValueOf.getClass();
        if (dDoubleValue < d) {
            java.lang.Double.valueOf(d).getClass();
            addStats(str, d);
        }
    }

    public void updateRecordInfo(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (this.apmInstance == null || map == null) {
            return;
        }
        addPropeyFromExtParms(KEY_PAGE_PROPERTIES_REQUEST_TYPE, KEY_PAGE_PROPERTIES_REQUEST_TYPE, map);
        addPropeyFromExtParms(com.taobao.weex.common.WXPerformance.CACHE_TYPE, KEY_PAGE_PROPERTIES_CACHE_TYPE, map);
        addPropeyFromExtParms("zCacheInfo", KEY_PAGE_PROPERTIES_CACHE_INFO, map);
        addStats(KEY_PAGE_STATS_JSLIB_INIT_TIME, com.taobao.weex.WXEnvironment.sJSLibInitTime);
        addProperty(KEY_PAGE_PROPERTIES_JS_FM_INI, java.lang.Boolean.valueOf(com.taobao.weex.WXEnvironment.JsFrameworkInit));
        java.lang.Object obj = map.get("actualNetworkTime");
        if (obj instanceof java.lang.Long) {
            updateDiffStats(KEY_PAGE_STATS_ACTUAL_DOWNLOAD_TIME, ((java.lang.Long) obj).doubleValue());
        }
    }

    private void addPropeyFromExtParms(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj = map.get(str);
        if (obj instanceof java.lang.String) {
            addProperty(str2, obj);
        }
    }

    public void actionNetRequest() {
        if (!this.isFSEnd) {
            updateFSDiffStats(KEY_PAGE_STATS_FS_REQUEST_NUM, 1.0d);
        }
        updateDiffStats(KEY_PAGE_STATS_NET_NUM, 1.0d);
    }

    public void actionNetResult(boolean z, java.lang.String str) {
        if (z) {
            updateDiffStats(KEY_PAGE_STATS_NET_SUCCESS_NUM, 1.0d);
        } else {
            updateDiffStats(KEY_PAGE_STATS_NET_FAIL_NUM, 1.0d);
        }
    }

    public void actionLoadImg() {
        updateDiffStats(KEY_PAGE_STATS_IMG_LOAD_NUM, 1.0d);
    }

    public void actionLoadImgResult(boolean z, java.lang.String str) {
        if (z) {
            updateDiffStats(KEY_PAGE_STATS_IMG_LOAD_SUCCESS_NUM, 1.0d);
        } else {
            updateDiffStats(KEY_PAGE_STATS_IMG_LOAD_FAIL_NUM, 1.0d);
        }
    }

    public void sendPerformanceToJS() {
        if (this.hasSendInteractionToJS) {
            return;
        }
        this.hasSendInteractionToJS = true;
        com.taobao.weex.WXSDKInstance wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().get(this.mInstanceId);
        if (wXSDKInstance == null) {
            return;
        }
        java.util.HashMap map = new java.util.HashMap(2);
        map.put(KEY_PAGE_PROPERTIES_BIZ_ID, this.reportPageName);
        map.put(KEY_PAGE_PROPERTIES_BUBDLE_URL, wXSDKInstance.getBundleUrl());
        java.util.HashMap map2 = new java.util.HashMap(1);
        map2.put(KEY_PAGE_STAGES_INTERACTION, java.lang.Long.valueOf(wXSDKInstance.getWXPerformance().interactionRealUnixTime));
        java.util.HashMap map3 = new java.util.HashMap(2);
        map3.put("stage", map2);
        map3.put("properties", map);
        wXSDKInstance.fireGlobalEventCallback("wx_apm", map3);
    }

    public java.lang.String toPerfString() {
        java.lang.Long l = this.stageMap.get(KEY_PAGE_STAGES_RENDER_ORGIGIN);
        java.lang.Long l2 = this.stageMap.get(KEY_PAGE_STAGES_INTERACTION);
        java.lang.Long l3 = this.stageMap.get(KEY_PAGE_STAGES_NEW_FSRENDER);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (l != null && l2 != null) {
            sb.append("interactiveTime " + (l2.longValue() - l.longValue()) + "ms");
        }
        if (l3 != null) {
            sb.append(" wxNewFsRender " + l3 + "ms");
        }
        return sb.toString();
    }

    public void updateNativePerformanceData(java.util.Map<java.lang.String, java.lang.String> map) {
        double dDoubleValue;
        if (map == null) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            try {
                dDoubleValue = java.lang.Double.valueOf(entry.getValue()).doubleValue();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                dDoubleValue = -1.0d;
            }
            if (dDoubleValue != -1.0d) {
                this.recordStatsMap.put(entry.getKey(), java.lang.Double.valueOf(dDoubleValue));
            }
        }
    }
}
