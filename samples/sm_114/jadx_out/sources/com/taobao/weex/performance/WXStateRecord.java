package com.taobao.weex.performance;

/* JADX INFO: loaded from: classes.dex */
public class WXStateRecord {
    private long jsThreadTime;
    private java.lang.Runnable jsThreadWatchTask;
    private com.taobao.weex.performance.WXStateRecord.RecordList<com.taobao.weex.performance.WXStateRecord.Info> mActionHistory;
    private com.taobao.weex.performance.WXStateRecord.RecordList<com.taobao.weex.performance.WXStateRecord.Info> mExceptionHistory;
    private com.taobao.weex.performance.WXStateRecord.RecordList<com.taobao.weex.performance.WXStateRecord.Info> mIPCExceptionHistory;
    private com.taobao.weex.performance.WXStateRecord.RecordList<com.taobao.weex.performance.WXStateRecord.Info> mJsThradWatchHistory;
    private com.taobao.weex.performance.WXStateRecord.RecordList<com.taobao.weex.performance.WXStateRecord.Info> mJscCrashHistory;
    private com.taobao.weex.performance.WXStateRecord.RecordList<com.taobao.weex.performance.WXStateRecord.Info> mJscReloadHistory;
    private com.taobao.weex.performance.WXStateRecord.RecordList<com.taobao.weex.performance.WXStateRecord.Info> mJsfmInitHistory;

    private static class SingleTonHolder {
        private static final com.taobao.weex.performance.WXStateRecord S_INSTANCE = new com.taobao.weex.performance.WXStateRecord();

        private SingleTonHolder() {
        }
    }

    public static com.taobao.weex.performance.WXStateRecord getInstance() {
        return com.taobao.weex.performance.WXStateRecord.SingleTonHolder.S_INSTANCE;
    }

    private WXStateRecord() {
        this.jsThreadTime = -1L;
        this.jsThreadWatchTask = new java.lang.Runnable() { // from class: com.taobao.weex.performance.WXStateRecord.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.taobao.weex.performance.WXStateRecord.this.jsThreadTime == -1) {
                    com.taobao.weex.performance.WXStateRecord.this.jsThreadTime = com.taobao.weex.utils.WXUtils.getFixUnixTime();
                }
                long fixUnixTime = com.taobao.weex.utils.WXUtils.getFixUnixTime() - com.taobao.weex.performance.WXStateRecord.this.jsThreadTime;
                com.taobao.weex.performance.WXStateRecord.this.recordJsThreadWatch("diff:" + fixUnixTime);
                com.taobao.weex.performance.WXStateRecord.this.jsThreadTime = com.taobao.weex.utils.WXUtils.getFixUnixTime();
                com.taobao.weex.bridge.WXBridgeManager.getInstance().postDelay(com.taobao.weex.performance.WXStateRecord.this.jsThreadWatchTask, 500L);
            }
        };
        this.mExceptionHistory = new com.taobao.weex.performance.WXStateRecord.RecordList<>(10);
        this.mActionHistory = new com.taobao.weex.performance.WXStateRecord.RecordList<>(20);
        this.mJsfmInitHistory = new com.taobao.weex.performance.WXStateRecord.RecordList<>(10);
        this.mJscCrashHistory = new com.taobao.weex.performance.WXStateRecord.RecordList<>(10);
        this.mJscReloadHistory = new com.taobao.weex.performance.WXStateRecord.RecordList<>(10);
        this.mJsThradWatchHistory = new com.taobao.weex.performance.WXStateRecord.RecordList<>(20);
        this.mIPCExceptionHistory = new com.taobao.weex.performance.WXStateRecord.RecordList<>(20);
    }

    public void recordException(java.lang.String str, java.lang.String str2) {
        if (str2.length() > 200) {
            str2 = str2.substring(0, 200);
        }
        recordCommon(this.mExceptionHistory, new com.taobao.weex.performance.WXStateRecord.Info(com.taobao.weex.utils.WXUtils.getFixUnixTime(), str, str2));
    }

    public void recordAction(java.lang.String str, java.lang.String str2) {
        recordCommon(this.mActionHistory, new com.taobao.weex.performance.WXStateRecord.Info(com.taobao.weex.utils.WXUtils.getFixUnixTime(), str, str2));
    }

    public void recordIPCException(java.lang.String str, java.lang.String str2) {
        if (str2.length() > 200) {
            str2 = str2.substring(0, 200);
        }
        recordCommon(this.mIPCExceptionHistory, new com.taobao.weex.performance.WXStateRecord.Info(com.taobao.weex.utils.WXUtils.getFixUnixTime(), str, str2));
    }

    public void onJSFMInit() {
        recoreJsfmInitHistory("setJsfmVersion");
    }

    public void recoreJsfmInitHistory(java.lang.String str) {
        recordCommon(this.mJsfmInitHistory, new com.taobao.weex.performance.WXStateRecord.Info(com.taobao.weex.utils.WXUtils.getFixUnixTime(), "JSFM", str));
    }

    public void recordJsThreadWatch(java.lang.String str) {
        recordCommon(this.mJsThradWatchHistory, new com.taobao.weex.performance.WXStateRecord.Info(com.taobao.weex.utils.WXUtils.getFixUnixTime(), "jsWatch", str));
    }

    public void onJSEngineReload(java.lang.String str) {
        recordCommon(this.mJscReloadHistory, new com.taobao.weex.performance.WXStateRecord.Info(com.taobao.weex.utils.WXUtils.getFixUnixTime(), str, "onJSEngineReload"));
    }

    public void onJSCCrash(java.lang.String str) {
        recordCommon(this.mJscCrashHistory, new com.taobao.weex.performance.WXStateRecord.Info(com.taobao.weex.utils.WXUtils.getFixUnixTime(), str, "onJSCCrash"));
    }

    private void recordCommon(com.taobao.weex.performance.WXStateRecord.RecordList<com.taobao.weex.performance.WXStateRecord.Info> recordList, com.taobao.weex.performance.WXStateRecord.Info info) {
        if (recordList == null || info == null) {
            return;
        }
        try {
            recordList.add(info);
            if (recordList.isEmpty() || recordList.size() <= ((com.taobao.weex.performance.WXStateRecord.RecordList) recordList).maxSize) {
                return;
            }
            recordList.poll();
        } catch (java.lang.Throwable th) {
            th.getStackTrace();
        }
    }

    public java.util.Map<java.lang.String, java.lang.String> getStateInfo() {
        java.util.HashMap map = new java.util.HashMap(5);
        map.put("reInitCount", java.lang.String.valueOf(com.taobao.weex.bridge.WXBridgeManager.reInitCount));
        java.util.ArrayList arrayList = new java.util.ArrayList(this.mExceptionHistory.size() + this.mActionHistory.size() + this.mJsfmInitHistory.size() + this.mJscCrashHistory.size() + this.mJscReloadHistory.size() + this.mJsThradWatchHistory.size());
        arrayList.addAll(this.mExceptionHistory);
        arrayList.addAll(this.mActionHistory);
        arrayList.addAll(this.mJsfmInitHistory);
        arrayList.addAll(this.mJscCrashHistory);
        arrayList.addAll(this.mJscReloadHistory);
        arrayList.addAll(this.mJsThradWatchHistory);
        arrayList.addAll(this.mIPCExceptionHistory);
        java.util.Collections.sort(arrayList);
        map.put("stateInfoList", arrayList.toString());
        com.taobao.weex.adapter.IWXConfigAdapter wxConfigAdapter = com.taobao.weex.WXSDKManager.getInstance().getWxConfigAdapter();
        if (wxConfigAdapter != null && io.dcloud.common.constant.AbsoluteConst.TRUE.equalsIgnoreCase(wxConfigAdapter.getConfig("wxapm", "dumpIpcPageInfo", io.dcloud.common.constant.AbsoluteConst.TRUE))) {
            map.put("pageQueueInfo", com.taobao.weex.bridge.WXBridgeManager.getInstance().dumpIpcPageInfo());
        }
        return map;
    }

    private static class RecordList<E> extends java.util.concurrent.ConcurrentLinkedQueue<E> {
        private int maxSize;

        public RecordList(int i) {
            this.maxSize = i;
        }
    }

    private static class Info implements java.lang.Comparable<com.taobao.weex.performance.WXStateRecord.Info> {
        private java.lang.String instanceId;
        private java.lang.String msg;
        private long time;

        public Info(long j, java.lang.String str, java.lang.String str2) {
            this.time = j;
            this.instanceId = str;
            this.msg = str2;
        }

        public java.lang.String toString() {
            return com.taobao.weex.el.parse.Operators.ARRAY_START_STR + this.instanceId + com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR + this.time + com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR + this.msg + "]->";
        }

        @Override // java.lang.Comparable
        public int compareTo(com.taobao.weex.performance.WXStateRecord.Info info) {
            long j = this.time;
            long j2 = info.time;
            if (j == j2) {
                return 0;
            }
            return j > j2 ? 1 : -1;
        }
    }

    public void startJSThreadWatchDog() {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().post(this.jsThreadWatchTask);
    }
}
