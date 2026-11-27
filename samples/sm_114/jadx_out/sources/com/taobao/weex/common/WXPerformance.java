package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
@java.lang.Deprecated
public class WXPerformance {
    public static final java.lang.String CACHE_TYPE = "cacheType";
    public static final java.lang.String DEFAULT = "default";
    public long JSLibInitTime;
    public double JSLibSize;
    public double JSTemplateSize;
    public long actualNetworkTime;
    public long avgFPS;
    public long backImproveMemory;
    public long callBridgeTime;
    public long callCreateFinishTime;
    public long callCreateInstanceTime;
    public int cellExceedNum;

    @java.lang.Deprecated
    public long communicateTime;
    public long componentCount;
    public long componentCreateTime;
    public java.lang.String connectionType;
    public long cssLayoutTime;
    public java.lang.String errCode;

    @java.lang.Deprecated
    public java.lang.String errMsg;
    public long firstScreenJSFExecuteTime;
    public int fsCallEventTotalNum;
    public int fsCallJsTotalNum;
    public long fsCallJsTotalTime;
    public int fsCallNativeTotalNum;
    public long fsCallNativeTotalTime;
    public int fsComponentCount;
    public int fsComponentCreateTime;
    public long fsRenderTime;
    public int fsRequestNum;
    public long interactionRealUnixTime;
    public long interactionTime;
    public int interactionViewAddCount;
    public int interactionViewAddLimitCount;
    public int localInteractionViewAddCount;
    public double localReadTime;
    private java.lang.String mInstanceId;
    public int maxDeepVDomLayer;
    public int maxDeepViewLayer;
    public long networkTime;
    public long newFsRenderTime;
    public long packageSpendTime;
    public long parseJsonTime;
    public long pureNetworkTime;
    public java.lang.String renderFailedDetail;
    public long renderTimeOrigin;
    public long renderUnixTimeOrigin;
    public long screenRenderTime;
    public long syncTaskTime;
    public long templateLoadTime;

    @java.lang.Deprecated
    public java.lang.String templateUrl;
    public int timerInvokeCount;
    public double totalTime;
    public double wrongImgSizeCount;
    public java.lang.String zCacheInfo;
    public static final int VIEW_LIMIT_HEIGHT = com.taobao.weex.utils.WXViewUtils.getScreenHeight() / 2;
    public static final int VIEW_LIMIT_WIDTH = com.taobao.weex.utils.WXViewUtils.getScreenWidth() / 2;
    public static boolean TRACE_DATA = com.taobao.weex.WXEnvironment.isApkDebugable();

    @java.lang.Deprecated
    public java.lang.String bizType = "weex";
    public java.lang.String cacheType = "none";
    public double fluency = 100.0d;
    public java.lang.String pageName = "default";
    public int useScroller = 0;
    public java.lang.String JSLibVersion = com.taobao.weex.WXEnvironment.JS_LIB_SDK_VERSION;
    public java.lang.String WXSDKVersion = com.taobao.weex.WXEnvironment.WXSDK_VERSION;
    public java.lang.String args = "";
    public java.lang.String requestType = "other";

    @java.lang.Deprecated
    public java.lang.String[] wxDims = new java.lang.String[5];

    @java.lang.Deprecated
    public long[] measureTimes = new long[5];
    public int mActionAddElementCount = 0;
    public int mActionAddElementSumTime = 0;
    private java.lang.StringBuilder mErrMsgBuilder = new java.lang.StringBuilder();

    public enum Dimension {
        JSLibVersion,
        WXSDKVersion,
        pageName,
        spm,
        scheme,
        cacheType,
        requestType,
        networkType,
        connectionType,
        zcacheInfo,
        wxContainerName,
        wxInstanceType,
        wxParentPage,
        wxdim1,
        wxdim2,
        wxdim3,
        wxdim4,
        wxdim5,
        bizType,
        templateUrl,
        useScroller
    }

    public void afterInstanceDestroy(java.lang.String str) {
    }

    public enum Measure {
        JSLibSize(0.0d, Double.MAX_VALUE),
        JSLibInitTime(0.0d, 80000.0d),
        SDKInitTime(0.0d, 120000.0d),
        SDKInitInvokeTime(0.0d, 5000.0d),
        SDKInitExecuteTime(0.0d, 5000.0d),
        JSTemplateSize(0.0d, 5000.0d),
        pureNetworkTime(0.0d, 15000.0d),
        networkTime(0.0d, 15000.0d),
        fsCreateInstanceTime(0.0d, 3000.0d),
        fsCallJsTotalTime(0.0d, 5000.0d),
        fsCallJsTotalNum(0.0d, Double.MAX_VALUE),
        fsCallNativeTotalTime(0.0d, 5000.0d),
        fsCallNativeTotalNum(0.0d, Double.MAX_VALUE),
        fsCallEventTotalNum(0.0d, Double.MAX_VALUE),
        fsComponentCount(0.0d, 100000.0d),
        fsComponentCreateTime(0.0d, Double.MAX_VALUE),
        fsRenderTime(0.0d, 5000.0d),
        fsRequestNum(0.0d, 100.0d),
        callCreateFinishTime(0.0d, 10000.0d),
        cellExceedNum(0.0d, Double.MAX_VALUE),
        communicateTotalTime(0.0d, 5000.0d),
        maxDeepViewLayer(0.0d, Double.MAX_VALUE),
        maxDeepVDomLayer(0.0d, Double.MAX_VALUE),
        componentCount(0.0d, 1000000.0d),
        componentCreateTime(0.0d, Double.MAX_VALUE),
        avgFps(0.0d, 61.0d),
        timerCount(0.0d, Double.MAX_VALUE),
        MaxImproveMemory(0.0d, Double.MAX_VALUE),
        BackImproveMemory(0.0d, Double.MAX_VALUE),
        PushImproveMemory(0.0d, Double.MAX_VALUE),
        measureTime1(0.0d, Double.MAX_VALUE),
        measureTime2(0.0d, Double.MAX_VALUE),
        measureTime3(0.0d, Double.MAX_VALUE),
        measureTime4(0.0d, Double.MAX_VALUE),
        measureTime5(0.0d, Double.MAX_VALUE),
        callBridgeTime(0.0d, Double.MAX_VALUE),
        cssLayoutTime(0.0d, Double.MAX_VALUE),
        parseJsonTime(0.0d, Double.MAX_VALUE),
        communicateTime(0.0d, 5000.0d),
        screenRenderTime(0.0d, 5000.0d),
        totalTime(0.0d, 5000.0d),
        localReadTime(0.0d, 5000.0d),
        templateLoadTime(0.0d, 5000.0d),
        packageSpendTime(0.0d, 5000.0d),
        syncTaskTime(0.0d, 5000.0d),
        actualNetworkTime(0.0d, 5000.0d),
        firstScreenJSFExecuteTime(0.0d, 5000.0d),
        fluency(0.0d, 101.0d),
        imgSizeCount(0.0d, 2000.0d),
        interactionTime(0.0d, 10000.0d),
        interactionViewAddCount(0.0d, Double.MAX_VALUE),
        interactionViewAddLimitCount(0.0d, Double.MAX_VALUE),
        newFsRenderTime(0.0d, 10000.0d);

        private double mMaxRange;
        private double mMinRange;

        Measure(double d, double d2) {
            this.mMinRange = d;
            this.mMaxRange = d2;
        }

        public double getMinRange() {
            return this.mMinRange;
        }

        public double getMaxRange() {
            return this.mMaxRange;
        }
    }

    public WXPerformance(java.lang.String str) {
        this.mInstanceId = str;
    }

    public java.util.Map<java.lang.String, java.lang.Double> getMeasureMap() {
        double d;
        long j = this.fsRenderTime;
        java.lang.Double dValueOf = java.lang.Double.valueOf(0.0d);
        if (j != 0) {
            d = j - this.renderTimeOrigin;
        } else {
            d = this.totalTime;
            if (d == 0.0d) {
                d = -1.0d;
            }
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.taobao.weex.common.WXPerformance.Measure.JSLibSize.toString(), java.lang.Double.valueOf(this.JSLibSize));
        map.put(com.taobao.weex.common.WXPerformance.Measure.JSLibInitTime.toString(), java.lang.Double.valueOf(this.JSLibInitTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.SDKInitTime.toString(), java.lang.Double.valueOf(com.taobao.weex.WXEnvironment.sSDKInitTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.SDKInitInvokeTime.toString(), java.lang.Double.valueOf(com.taobao.weex.WXEnvironment.sSDKInitInvokeTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.SDKInitExecuteTime.toString(), java.lang.Double.valueOf(com.taobao.weex.WXEnvironment.sSDKInitExecuteTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.JSTemplateSize.toString(), java.lang.Double.valueOf(this.JSTemplateSize));
        map.put(com.taobao.weex.common.WXPerformance.Measure.pureNetworkTime.toString(), java.lang.Double.valueOf(this.pureNetworkTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.networkTime.toString(), java.lang.Double.valueOf(this.networkTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.fsCreateInstanceTime.toString(), java.lang.Double.valueOf(this.callCreateInstanceTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.fsCallJsTotalTime.toString(), java.lang.Double.valueOf(this.fsCallJsTotalTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.fsCallJsTotalNum.toString(), java.lang.Double.valueOf(this.fsCallJsTotalNum));
        map.put(com.taobao.weex.common.WXPerformance.Measure.fsCallNativeTotalTime.toString(), java.lang.Double.valueOf(this.fsCallNativeTotalTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.fsCallNativeTotalNum.toString(), java.lang.Double.valueOf(this.fsCallNativeTotalNum));
        map.put(com.taobao.weex.common.WXPerformance.Measure.fsComponentCount.toString(), java.lang.Double.valueOf(this.fsComponentCount));
        map.put(com.taobao.weex.common.WXPerformance.Measure.fsComponentCreateTime.toString(), java.lang.Double.valueOf(this.fsComponentCreateTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.fsRenderTime.toString(), java.lang.Double.valueOf(d));
        map.put(com.taobao.weex.common.WXPerformance.Measure.fsRequestNum.toString(), java.lang.Double.valueOf(this.fsRequestNum));
        map.put(com.taobao.weex.common.WXPerformance.Measure.communicateTotalTime.toString(), java.lang.Double.valueOf(this.totalTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.maxDeepViewLayer.toString(), java.lang.Double.valueOf(this.maxDeepViewLayer));
        map.put(com.taobao.weex.common.WXPerformance.Measure.maxDeepVDomLayer.toString(), java.lang.Double.valueOf(this.maxDeepVDomLayer));
        map.put(com.taobao.weex.common.WXPerformance.Measure.componentCount.toString(), java.lang.Double.valueOf(this.componentCount));
        map.put(com.taobao.weex.common.WXPerformance.Measure.componentCreateTime.toString(), java.lang.Double.valueOf(this.componentCreateTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.cellExceedNum.toString(), java.lang.Double.valueOf(this.cellExceedNum));
        map.put(com.taobao.weex.common.WXPerformance.Measure.timerCount.toString(), java.lang.Double.valueOf(this.timerInvokeCount));
        map.put(com.taobao.weex.common.WXPerformance.Measure.avgFps.toString(), java.lang.Double.valueOf(this.avgFPS));
        map.put(com.taobao.weex.common.WXPerformance.Measure.fluency.toString(), java.lang.Double.valueOf(this.fluency));
        map.put(com.taobao.weex.common.WXPerformance.Measure.MaxImproveMemory.toString(), dValueOf);
        map.put(com.taobao.weex.common.WXPerformance.Measure.BackImproveMemory.toString(), java.lang.Double.valueOf(this.backImproveMemory));
        map.put(com.taobao.weex.common.WXPerformance.Measure.PushImproveMemory.toString(), dValueOf);
        map.put(com.taobao.weex.common.WXPerformance.Measure.fsCallEventTotalNum.toString(), java.lang.Double.valueOf(this.fsCallEventTotalNum));
        map.put(com.taobao.weex.common.WXPerformance.Measure.callCreateFinishTime.toString(), java.lang.Double.valueOf(this.callCreateFinishTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.imgSizeCount.toString(), java.lang.Double.valueOf(this.wrongImgSizeCount));
        map.put(com.taobao.weex.common.WXPerformance.Measure.interactionTime.toString(), java.lang.Double.valueOf(this.interactionTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.interactionViewAddCount.toString(), java.lang.Double.valueOf(this.interactionViewAddCount));
        map.put(com.taobao.weex.common.WXPerformance.Measure.interactionViewAddLimitCount.toString(), java.lang.Double.valueOf(this.interactionViewAddLimitCount));
        map.put(com.taobao.weex.common.WXPerformance.Measure.newFsRenderTime.toString(), java.lang.Double.valueOf(this.newFsRenderTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.callBridgeTime.toString(), java.lang.Double.valueOf(this.callBridgeTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.cssLayoutTime.toString(), java.lang.Double.valueOf(this.cssLayoutTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.parseJsonTime.toString(), java.lang.Double.valueOf(this.parseJsonTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.screenRenderTime.toString(), java.lang.Double.valueOf(this.screenRenderTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.communicateTime.toString(), java.lang.Double.valueOf(this.communicateTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.localReadTime.toString(), java.lang.Double.valueOf(this.localReadTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.templateLoadTime.toString(), java.lang.Double.valueOf(this.templateLoadTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.firstScreenJSFExecuteTime.toString(), java.lang.Double.valueOf(this.firstScreenJSFExecuteTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.actualNetworkTime.toString(), java.lang.Double.valueOf(this.actualNetworkTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.syncTaskTime.toString(), java.lang.Double.valueOf(this.syncTaskTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.packageSpendTime.toString(), java.lang.Double.valueOf(this.packageSpendTime));
        map.put(com.taobao.weex.common.WXPerformance.Measure.measureTime1.toString(), java.lang.Double.valueOf(this.measureTimes[0]));
        map.put(com.taobao.weex.common.WXPerformance.Measure.measureTime2.toString(), java.lang.Double.valueOf(this.measureTimes[1]));
        map.put(com.taobao.weex.common.WXPerformance.Measure.measureTime3.toString(), java.lang.Double.valueOf(this.measureTimes[2]));
        map.put(com.taobao.weex.common.WXPerformance.Measure.measureTime4.toString(), java.lang.Double.valueOf(this.measureTimes[3]));
        map.put(com.taobao.weex.common.WXPerformance.Measure.measureTime5.toString(), java.lang.Double.valueOf(this.measureTimes[4]));
        return map;
    }

    public java.util.Map<java.lang.String, java.lang.String> getDimensionMap() {
        java.lang.String str;
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.taobao.weex.common.WXPerformance.Dimension.JSLibVersion.toString(), this.JSLibVersion);
        map.put(com.taobao.weex.common.WXPerformance.Dimension.WXSDKVersion.toString(), this.WXSDKVersion);
        map.put(com.taobao.weex.common.WXPerformance.Dimension.pageName.toString(), this.pageName);
        map.put(com.taobao.weex.common.WXPerformance.Dimension.requestType.toString(), this.requestType);
        map.put(com.taobao.weex.common.WXPerformance.Dimension.networkType.toString(), "unknown");
        map.put(com.taobao.weex.common.WXPerformance.Dimension.connectionType.toString(), this.connectionType);
        map.put(com.taobao.weex.common.WXPerformance.Dimension.zcacheInfo.toString(), this.zCacheInfo);
        map.put(com.taobao.weex.common.WXPerformance.Dimension.cacheType.toString(), this.cacheType);
        map.put(com.taobao.weex.common.WXPerformance.Dimension.useScroller.toString(), java.lang.String.valueOf(this.useScroller));
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(this.mInstanceId);
        java.lang.String str2 = "unKnow";
        map.put(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_PROPERTIES_CONTAINER_NAME, sDKInstance == null ? "unKnow" : sDKInstance.getContainerInfo().get(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_PROPERTIES_CONTAINER_NAME));
        if (sDKInstance == null) {
            str = "unKnow";
        } else {
            str = sDKInstance.getContainerInfo().get(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_PROPERTIES_INSTANCE_TYPE);
        }
        map.put(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_PROPERTIES_INSTANCE_TYPE, str);
        if (sDKInstance != null) {
            str2 = sDKInstance.getContainerInfo().get(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_PROPERTIES_PARENT_PAGE);
        }
        map.put(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_PROPERTIES_PARENT_PAGE, str2);
        map.put(com.taobao.weex.common.WXPerformance.Dimension.wxdim1.toString(), this.wxDims[0]);
        map.put(com.taobao.weex.common.WXPerformance.Dimension.wxdim2.toString(), this.wxDims[1]);
        map.put(com.taobao.weex.common.WXPerformance.Dimension.wxdim3.toString(), this.wxDims[2]);
        map.put(com.taobao.weex.common.WXPerformance.Dimension.wxdim4.toString(), this.wxDims[3]);
        map.put(com.taobao.weex.common.WXPerformance.Dimension.wxdim5.toString(), this.wxDims[4]);
        map.put(com.taobao.weex.common.WXPerformance.Dimension.bizType.toString(), this.bizType);
        map.put(com.taobao.weex.common.WXPerformance.Dimension.templateUrl.toString(), this.templateUrl);
        return map;
    }

    public static java.lang.String[] getDimensions() {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        for (com.taobao.weex.common.WXPerformance.Dimension dimension : com.taobao.weex.common.WXPerformance.Dimension.values()) {
            linkedList.add(dimension.toString());
        }
        return (java.lang.String[]) linkedList.toArray(new java.lang.String[linkedList.size()]);
    }

    public static java.lang.String[] getMeasures() {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        for (com.taobao.weex.common.WXPerformance.Measure measure : com.taobao.weex.common.WXPerformance.Measure.values()) {
            linkedList.add(measure.toString());
        }
        return (java.lang.String[]) linkedList.toArray(new java.lang.String[linkedList.size()]);
    }

    public java.lang.String toString() {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            return "bizType:" + this.bizType + ",pageName:" + this.pageName + ",templateLoadTime" + this.templateLoadTime + ",localReadTime:" + this.localReadTime + ",JSLibInitTime:" + this.JSLibInitTime + ",JSLibSize:" + this.JSLibSize + ",templateUrl" + this.templateUrl + ",JSTemplateSize:" + this.JSTemplateSize + ",communicateTime:" + this.communicateTime + ",screenRenderTime:" + this.screenRenderTime + ",firstScreenJSFExecuteTime:" + this.firstScreenJSFExecuteTime + ",componentCount:" + this.componentCount + ",syncTaskTime:" + this.syncTaskTime + ",pureNetworkTime:" + this.pureNetworkTime + ",networkTime:" + this.networkTime + ",actualNetworkTime:" + this.actualNetworkTime + ",packageSpendTime:" + this.packageSpendTime + ",connectionType:" + this.connectionType + ",requestType:" + this.requestType + ",initInvokeTime:" + com.taobao.weex.WXEnvironment.sSDKInitInvokeTime + ",initExecuteTime:" + com.taobao.weex.WXEnvironment.sSDKInitExecuteTime + ",SDKInitTime:" + com.taobao.weex.WXEnvironment.sSDKInitTime + ",totalTime:" + this.totalTime + ",JSLibVersion:" + this.JSLibVersion + ",WXSDKVersion:" + this.WXSDKVersion + ",errCode:" + this.errCode + ",renderFailedDetail:" + this.renderFailedDetail + ",arg:" + this.args + ",errMsg:" + getErrMsg();
        }
        return super.toString();
    }

    public java.lang.String getPerfData() {
        return "networkTime:" + this.networkTime + " actualNetworkTime:" + this.actualNetworkTime + " connectionType:" + this.connectionType + " requestType:" + this.requestType + " firstScreenRenderTime:" + this.screenRenderTime + " firstScreenJSFExecuteTime:" + this.firstScreenJSFExecuteTime + " componentCount:" + this.componentCount + " JSTemplateSize:" + this.JSTemplateSize + " SDKInitTime:" + com.taobao.weex.WXEnvironment.sSDKInitTime + " totalTime:" + this.totalTime + " JSLibVersion:" + this.JSLibVersion + " WXSDKVersion:" + this.WXSDKVersion + " pageName:" + this.pageName + " useScroller:" + this.useScroller;
    }

    public java.lang.String getErrMsg() {
        return this.mErrMsgBuilder.toString();
    }

    public void appendErrMsg(java.lang.CharSequence charSequence) {
        this.mErrMsgBuilder.append(charSequence);
    }

    public void beforeInstanceRender(java.lang.String str) {
        this.renderTimeOrigin = java.lang.System.currentTimeMillis();
        this.renderUnixTimeOrigin = com.taobao.weex.utils.WXUtils.getFixUnixTime();
    }
}
