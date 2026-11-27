package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public class WXBridge implements com.taobao.weex.common.IWXBridge {
    public static final boolean MULTIPROCESS = true;
    public static final java.lang.String TAG = "WXBridge";

    private native void nativeBindMeasurementToRenderObject(long j);

    private native java.lang.String nativeDecrypt(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    private native java.lang.String nativeEncrypt(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    private native int nativeExecJS(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr);

    private native int nativeExecJSService(java.lang.String str);

    private native void nativeForceLayout(java.lang.String str);

    private native int nativeInitFramework(java.lang.String str, com.taobao.weex.bridge.WXParams wXParams);

    private native int nativeInitFrameworkEnv(java.lang.String str, com.taobao.weex.bridge.WXParams wXParams, java.lang.String str2, boolean z);

    private native void nativeMarkDirty(java.lang.String str, java.lang.String str2, boolean z);

    private native boolean nativeNotifyLayout(java.lang.String str);

    private native void nativeOnInstanceClose(java.lang.String str);

    private native java.lang.String nativePreGetClientKey(java.lang.String str, java.lang.String str2, java.lang.String str3);

    private native void nativeRefreshInstance(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr);

    private native void nativeRegisterCoreEnv(java.lang.String str, java.lang.String str2);

    private native void nativeReloadPageLayout(java.lang.String str);

    private native void nativeRemoveInstanceRenderType(java.lang.String str);

    private native void nativeResetWXBridge(java.lang.Object obj, java.lang.String str);

    private native void nativeSetDefaultHeightAndWidthIntoRootDom(java.lang.String str, float f, float f2, boolean z, boolean z2);

    private native void nativeSetDeviceDisplay(java.lang.String str, float f, float f2, float f3);

    private native void nativeSetDeviceDisplayOfPage(java.lang.String str, float f, float f2);

    private native void nativeSetFlexDirectionDef(java.lang.String str);

    private native void nativeSetInstanceRenderType(java.lang.String str, java.lang.String str2);

    private native void nativeSetLogType(float f, float f2);

    private native void nativeSetMargin(java.lang.String str, java.lang.String str2, int i, float f);

    private native void nativeSetPadding(java.lang.String str, java.lang.String str2, int i, float f);

    private native void nativeSetPageArgument(java.lang.String str, java.lang.String str2, java.lang.String str3);

    private native void nativeSetPosition(java.lang.String str, java.lang.String str2, int i, float f);

    private native void nativeSetRenderContainerWrapContent(boolean z, java.lang.String str);

    private native void nativeSetStyleHeight(java.lang.String str, java.lang.String str2, float f, boolean z);

    private native void nativeSetStyleWidth(java.lang.String str, java.lang.String str2, float f, boolean z);

    private native void nativeSetViewPortWidth(java.lang.String str, float f);

    private native void nativeTakeHeapSnapshot(java.lang.String str);

    private native void nativeUpdateInitFrameworkParams(java.lang.String str, java.lang.String str2, java.lang.String str3);

    private native boolean nativeVerifyClientKeyPayload(java.lang.String str, java.lang.String str2, java.lang.String str3);

    public native int nativeCreateInstanceContext(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr);

    public native int nativeDestoryInstance(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr);

    public native java.lang.String nativeDumpIpcPageQueueInfo();

    public native java.lang.String nativeExecJSOnInstance(java.lang.String str, java.lang.String str2, int i);

    public native void nativeExecJSWithCallback(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr, long j);

    public native byte[] nativeExecJSWithResult(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr);

    public native void nativeFireEventOnDataRenderNode(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5);

    public native long[] nativeGetFirstScreenRenderTime(java.lang.String str);

    public native long[] nativeGetRenderFinishTime(java.lang.String str);

    public native void nativeInvokeCallbackOnDataRender(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z);

    public native void nativeOnInteractionTimeUpdate(java.lang.String str);

    public native void nativeRegisterComponentOnDataRenderNode(java.lang.String str);

    public native void nativeRegisterModuleOnDataRenderNode(java.lang.String str);

    public native void nativeUpdateGlobalConfig(java.lang.String str);

    @Override // com.taobao.weex.common.IWXBridge
    public void updateInitFrameworkParams(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.taobao.weex.performance.WXStateRecord.getInstance().recordAction("", "updateInitFrameworkParams:");
        nativeUpdateInitFrameworkParams(str, str2, str3);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setLogType(float f, boolean z) {
        android.util.Log.e("WeexCore", "setLog" + com.taobao.weex.WXEnvironment.sLogLevel.getValue() + "isPerf : " + z);
        nativeSetLogType(f, z ? 1.0f : 0.0f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int initFramework(java.lang.String str, com.taobao.weex.bridge.WXParams wXParams) {
        return nativeInitFramework(str, wXParams);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int initFrameworkEnv(java.lang.String str, com.taobao.weex.bridge.WXParams wXParams, java.lang.String str2, boolean z) {
        com.taobao.weex.performance.WXStateRecord.getInstance().recordAction("", "nativeInitFrameworkEnv:");
        return nativeInitFrameworkEnv(str, wXParams, str2, z);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void refreshInstance(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr) {
        com.taobao.weex.performance.WXStateRecord.getInstance().recordAction(str, "refreshInstance:" + str2 + "," + str3);
        nativeRefreshInstance(str, str2, str3, wXJSObjectArr);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int execJS(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr) {
        com.taobao.weex.performance.WXStateRecord.getInstance().recordAction(str, "execJS:" + str2 + "," + str3);
        return nativeExecJS(str, str2, str3, wXJSObjectArr);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void execJSWithCallback(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr, com.taobao.weex.bridge.ResultCallback resultCallback) {
        com.taobao.weex.performance.WXStateRecord.getInstance().recordAction(str, "execJSWithCallback:" + str2 + "," + str3);
        if (resultCallback == null) {
            execJS(str, str2, str3, wXJSObjectArr);
        }
        nativeExecJSWithCallback(str, str2, str3, wXJSObjectArr, com.taobao.weex.bridge.ResultCallbackManager.generateCallbackId(resultCallback));
    }

    public void onNativePerformanceDataUpdate(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        com.taobao.weex.WXSDKInstance wXSDKInstance;
        if (android.text.TextUtils.isEmpty(str) || map == null || map.size() < 1 || (wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().get(str)) == null || wXSDKInstance.getApmForInstance() == null) {
            return;
        }
        wXSDKInstance.getApmForInstance().updateNativePerformanceData(map);
    }

    public void onReceivedResult(long j, byte[] bArr) {
        com.taobao.weex.performance.WXStateRecord.getInstance().recordAction("onReceivedResult", io.dcloud.feature.internal.sdk.SDK.UNIMP_EVENT_CALLBACKID + j);
        com.taobao.weex.bridge.ResultCallback resultCallbackRemoveCallbackById = com.taobao.weex.bridge.ResultCallbackManager.removeCallbackById(j);
        if (resultCallbackRemoveCallbackById != null) {
            resultCallbackRemoveCallbackById.onReceiveResult(bArr);
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int execJSService(java.lang.String str) {
        com.taobao.weex.performance.WXStateRecord.getInstance().recordAction("execJSService", "execJSService:");
        return nativeExecJSService(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void takeHeapSnapshot(java.lang.String str) {
        nativeTakeHeapSnapshot(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int createInstanceContext(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr) {
        android.util.Log.e(com.taobao.weex.utils.tools.TimeCalculator.TIMELINE_TAG, "createInstance :" + java.lang.System.currentTimeMillis());
        com.taobao.weex.performance.WXStateRecord.getInstance().recordAction(str, "createInstanceContext:");
        return nativeCreateInstanceContext(str, str2, str3, wXJSObjectArr);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int destoryInstance(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr) {
        com.taobao.weex.performance.WXStateRecord.getInstance().recordAction(str, "destoryInstance:");
        return nativeDestoryInstance(str, str2, str3, wXJSObjectArr);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public java.lang.String execJSOnInstance(java.lang.String str, java.lang.String str2, int i) {
        com.taobao.weex.performance.WXStateRecord.getInstance().recordAction(str, "execJSOnInstance:" + i);
        return nativeExecJSOnInstance(str, str2, i);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callNative(java.lang.String str, byte[] bArr, java.lang.String str2) {
        if ("HeartBeat".equals(str2)) {
            android.util.Log.e("HeartBeat instanceId", str);
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance == null) {
                return 1;
            }
            sDKInstance.createInstanceFuncHeartBeat();
            return 1;
        }
        return callNative(str, com.alibaba.fastjson.JSON.parseArray(new java.lang.String(bArr)), str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callNative(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            return callNative(str, com.alibaba.fastjson.JSONArray.parseArray(str2), str3);
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callNative throw exception: " + com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
            return 1;
        }
    }

    private int callNative(java.lang.String str, com.alibaba.fastjson.JSONArray jSONArray, java.lang.String str2) {
        int iCallNative;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
        if (sDKInstance != null) {
            sDKInstance.firstScreenCreateInstanceTime(jCurrentTimeMillis);
        }
        try {
            iCallNative = com.taobao.weex.bridge.WXBridgeManager.getInstance().callNative(str, jSONArray, str2);
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callNative throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            iCallNative = 1;
        }
        if (com.taobao.weex.WXEnvironment.isApkDebugable() && iCallNative == -1) {
            com.taobao.weex.utils.WXLogUtils.w("destroyInstance :" + str + " JSF must stop callNative");
        }
        return iCallNative;
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void reportJSException(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().reportJSException(str, str2, str3);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public java.lang.Object callVueExecSync(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
        if (sDKInstance != null) {
            if (sDKInstance != null && sDKInstance.isDestroy()) {
                return new com.taobao.weex.bridge.WXJSObject(null);
            }
            java.lang.String strExecSync = com.taobao.weex.WXSDKManager.getInstance().getVueBridgeAdapter().execSync(sDKInstance, str2, str3);
            if (strExecSync == null) {
                return new com.taobao.weex.bridge.WXJSObject(null);
            }
            return new com.taobao.weex.bridge.WXJSObject(3, com.taobao.weex.utils.WXJsonUtils.fromObjectToJSONString(strExecSync));
        }
        return new com.taobao.weex.bridge.WXJSObject(null);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void callVueExec(java.lang.String str, final java.lang.String str2, final java.lang.String str3) {
        final com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
        if (sDKInstance != null) {
            if (sDKInstance == null || !sDKInstance.isDestroy()) {
                com.taobao.weex.WXSDKManager.getInstance().postOnUiThread(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridge.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.taobao.weex.WXSDKManager.getInstance().getVueBridgeAdapter().exec(sDKInstance, str2, str3);
                    }
                }, 0L);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00bb A[Catch: Exception -> 0x0111, TryCatch #2 {Exception -> 0x0111, blocks: (B:3:0x0007, B:6:0x0032, B:8:0x003a, B:17:0x0064, B:36:0x00ae, B:38:0x00bb, B:40:0x00d9, B:42:0x00e1, B:53:0x0107, B:55:0x010c, B:20:0x006e, B:22:0x0078, B:24:0x0082, B:25:0x0087, B:27:0x008d, B:29:0x0095, B:31:0x009e, B:32:0x00a5, B:34:0x00a9, B:12:0x0050, B:13:0x0058, B:10:0x0042, B:45:0x00eb, B:47:0x00f1, B:49:0x00f9, B:51:0x00fc), top: B:63:0x0007, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00d9 A[Catch: Exception -> 0x0111, TryCatch #2 {Exception -> 0x0111, blocks: (B:3:0x0007, B:6:0x0032, B:8:0x003a, B:17:0x0064, B:36:0x00ae, B:38:0x00bb, B:40:0x00d9, B:42:0x00e1, B:53:0x0107, B:55:0x010c, B:20:0x006e, B:22:0x0078, B:24:0x0082, B:25:0x0087, B:27:0x008d, B:29:0x0095, B:31:0x009e, B:32:0x00a5, B:34:0x00a9, B:12:0x0050, B:13:0x0058, B:10:0x0042, B:45:0x00eb, B:47:0x00f1, B:49:0x00f9, B:51:0x00fc), top: B:63:0x0007, inners: #0, #1 }] */
    @Override // com.taobao.weex.common.IWXBridge
    public java.lang.Object callNativeModule(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, byte[] bArr2) {
        com.alibaba.fastjson.JSONArray jSONArray;
        com.alibaba.fastjson.JSONObject jSONObject;
        com.taobao.weex.WXSDKInstance sDKInstance;
        com.alibaba.fastjson.JSONObject jSONObject2;
        java.lang.Object objCallNativeModule;
        com.alibaba.fastjson.JSONArray jSONArray2;
        try {
            com.taobao.weex.performance.WXStateRecord.getInstance().recordAction(str, "callNativeModule:" + str2 + com.taobao.weex.el.parse.Operators.DOT_STR + str3);
            long fixUnixTime = com.taobao.weex.utils.WXUtils.getFixUnixTime();
            com.taobao.weex.WXSDKInstance sDKInstance2 = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (bArr != null) {
                if (sDKInstance2 == null || !(sDKInstance2.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER || sDKInstance2.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY)) {
                    jSONArray2 = (com.alibaba.fastjson.JSONArray) com.taobao.weex.utils.WXWsonJSONSwitch.parseWsonOrJSON(bArr);
                } else {
                    try {
                        jSONArray2 = (com.alibaba.fastjson.JSONArray) com.alibaba.fastjson.JSON.parse(new java.lang.String(bArr, "UTF-8"));
                    } catch (java.lang.Exception unused) {
                        jSONArray2 = (com.alibaba.fastjson.JSONArray) com.taobao.weex.utils.WXWsonJSONSwitch.parseWsonOrJSON(bArr);
                    }
                }
                jSONArray = jSONArray2;
            } else {
                jSONArray = null;
            }
            if (bArr2 == null) {
                if (jSONArray != null && (sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str)) != null && com.taobao.weex.bridge.WXBridgeManager.BundType.Rax.equals(sDKInstance.bundleType)) {
                    java.lang.Object obj = null;
                    for (java.lang.Object obj2 : jSONArray) {
                        if ((obj2 instanceof com.alibaba.fastjson.JSONObject) && ((com.alibaba.fastjson.JSONObject) obj2).containsKey("__weex_options__")) {
                            obj = ((com.alibaba.fastjson.JSONObject) obj2).get("__weex_options__");
                        }
                    }
                    if (obj instanceof com.alibaba.fastjson.JSONObject) {
                        jSONObject2 = (com.alibaba.fastjson.JSONObject) obj;
                    }
                    objCallNativeModule = com.taobao.weex.bridge.WXBridgeManager.getInstance().callNativeModule(str, str2, str3, jSONArray, jSONObject);
                    if (sDKInstance2 != null) {
                        sDKInstance2.getApmForInstance().updateFSDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_FS_CALL_NATIVE_NUM, 1.0d);
                        sDKInstance2.getApmForInstance().updateFSDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_FS_CALL_NATIVE_TIME, com.taobao.weex.utils.WXUtils.getFixUnixTime() - fixUnixTime);
                    }
                    if (sDKInstance2 != null || (sDKInstance2.getRenderStrategy() != com.taobao.weex.common.WXRenderStrategy.DATA_RENDER && sDKInstance2.getRenderStrategy() != com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY)) {
                        return com.taobao.weex.utils.WXWsonJSONSwitch.toWsonOrJsonWXJSObject(objCallNativeModule);
                    }
                    try {
                        if (objCallNativeModule == null) {
                            return new com.taobao.weex.bridge.WXJSObject(null);
                        }
                        return objCallNativeModule.getClass() == com.taobao.weex.bridge.WXJSObject.class ? (com.taobao.weex.bridge.WXJSObject) objCallNativeModule : new com.taobao.weex.bridge.WXJSObject(3, com.taobao.weex.utils.WXJsonUtils.fromObjectToJSONString(objCallNativeModule));
                    } catch (java.lang.Exception unused2) {
                        return com.taobao.weex.utils.WXWsonJSONSwitch.toWsonOrJsonWXJSObject(objCallNativeModule);
                    }
                }
                jSONObject = null;
                objCallNativeModule = com.taobao.weex.bridge.WXBridgeManager.getInstance().callNativeModule(str, str2, str3, jSONArray, jSONObject);
                if (sDKInstance2 != null) {
                    sDKInstance2.getApmForInstance().updateFSDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_FS_CALL_NATIVE_NUM, 1.0d);
                    sDKInstance2.getApmForInstance().updateFSDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_FS_CALL_NATIVE_TIME, com.taobao.weex.utils.WXUtils.getFixUnixTime() - fixUnixTime);
                }
                if (sDKInstance2 != null) {
                }
                return com.taobao.weex.utils.WXWsonJSONSwitch.toWsonOrJsonWXJSObject(objCallNativeModule);
            }
            jSONObject2 = (com.alibaba.fastjson.JSONObject) com.taobao.weex.utils.WXWsonJSONSwitch.parseWsonOrJSON(bArr2);
            jSONObject = jSONObject2;
            objCallNativeModule = com.taobao.weex.bridge.WXBridgeManager.getInstance().callNativeModule(str, str2, str3, jSONArray, jSONObject);
            if (sDKInstance2 != null) {
                sDKInstance2.getApmForInstance().updateFSDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_FS_CALL_NATIVE_NUM, 1.0d);
                sDKInstance2.getApmForInstance().updateFSDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_FS_CALL_NATIVE_TIME, com.taobao.weex.utils.WXUtils.getFixUnixTime() - fixUnixTime);
            }
            if (sDKInstance2 != null) {
            }
            return com.taobao.weex.utils.WXWsonJSONSwitch.toWsonOrJsonWXJSObject(objCallNativeModule);
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, e);
            return new com.taobao.weex.bridge.WXJSObject(null);
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void callNativeComponent(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, byte[] bArr2) {
        com.alibaba.fastjson.JSONArray jSONArray;
        com.taobao.weex.performance.WXStateRecord.getInstance().recordAction(str, "callNativeComponent:" + str3);
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (bArr == null) {
                jSONArray = null;
            } else if (sDKInstance != null && (sDKInstance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER || sDKInstance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY)) {
                try {
                    jSONArray = (com.alibaba.fastjson.JSONArray) com.alibaba.fastjson.JSON.parse(new java.lang.String(bArr, "UTF-8"));
                } catch (java.lang.Exception unused) {
                    jSONArray = (com.alibaba.fastjson.JSONArray) com.taobao.weex.utils.WXWsonJSONSwitch.parseWsonOrJSON(bArr);
                }
            } else {
                jSONArray = (com.alibaba.fastjson.JSONArray) com.taobao.weex.utils.WXWsonJSONSwitch.parseWsonOrJSON(bArr);
            }
            com.taobao.weex.bridge.WXBridgeManager.getInstance().callNativeComponent(str, str2, str3, jSONArray, com.taobao.weex.utils.WXWsonJSONSwitch.parseWsonOrJSON(bArr2));
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, e);
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setTimeoutNative(java.lang.String str, java.lang.String str2) {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().setTimeout(str, str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setJSFrmVersion(java.lang.String str) {
        if (str != null) {
            com.taobao.weex.WXEnvironment.JS_LIB_SDK_VERSION = str;
        }
        com.taobao.weex.performance.WXStateRecord.getInstance().onJSFMInit();
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void resetWXBridge(boolean z) {
        nativeResetWXBridge(this, getClass().getName().replace(com.taobao.weex.el.parse.Operators.DOT, '/'));
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callUpdateFinish(java.lang.String str, byte[] bArr, java.lang.String str2) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callUpdateFinish(str, str2);
        } catch (java.lang.Throwable th) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 1;
            }
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callCreateBody throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callRefreshFinish(java.lang.String str, byte[] bArr, java.lang.String str2) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callRefreshFinish(str, str2);
        } catch (java.lang.Throwable th) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 1;
            }
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callCreateFinish throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void reportServerCrash(java.lang.String str, java.lang.String str2) {
        com.taobao.weex.utils.WXLogUtils.e(TAG, "reportServerCrash instanceId:" + str + " crashFile: " + str2);
        try {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().callReportCrashReloadPage(str, str2);
        } catch (java.lang.Throwable th) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.e(TAG, "reloadPageNative throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            }
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callCreateBody(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.HashMap<java.lang.String, java.lang.String> map, java.util.HashMap<java.lang.String, java.lang.String> map2, java.util.HashSet<java.lang.String> hashSet, float[] fArr, float[] fArr2, float[] fArr3) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callCreateBody(str, str2, str3, map, map2, hashSet, fArr, fArr2, fArr3);
        } catch (java.lang.Throwable th) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 1;
            }
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callCreateBody throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callAddElement(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4, java.util.HashMap<java.lang.String, java.lang.String> map, java.util.HashMap<java.lang.String, java.lang.String> map2, java.util.HashSet<java.lang.String> hashSet, float[] fArr, float[] fArr2, float[] fArr3, boolean z) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callAddElement(str, str2, str3, i, str4, map, map2, hashSet, fArr, fArr2, fArr3, z);
        } catch (java.lang.Throwable th) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 1;
            }
            th.printStackTrace();
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callAddElement throw error:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callRemoveElement(java.lang.String str, java.lang.String str2) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callRemoveElement(str, str2);
        } catch (java.lang.Throwable th) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 1;
            }
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callRemoveElement throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callMoveElement(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callMoveElement(str, str2, str3, i);
        } catch (java.lang.Throwable th) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 1;
            }
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callMoveElement throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callAddEvent(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callAddEvent(str, str2, str3);
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callAddEvent throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void callBacthStart(java.lang.String str) {
        try {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().callBacthStart(str);
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "cal\n    return errorCode;\n  }lAddEvent throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void callBacthEnd(java.lang.String str) {
        try {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().callBacthEnd(str);
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "cal\n    return errorCode;\n  }lAddEvent throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callRemoveEvent(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callRemoveEvent(str, str2, str3);
        } catch (java.lang.Throwable th) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 1;
            }
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callRemoveEvent throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callUpdateStyle(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.Object> map, java.util.HashMap<java.lang.String, java.lang.String> map2, java.util.HashMap<java.lang.String, java.lang.String> map3, java.util.HashMap<java.lang.String, java.lang.String> map4) {
        if (map != null) {
            try {
                if (map.isEmpty() && map2 != null && map2.isEmpty() && map3 != null && map3.isEmpty() && map4 != null && map4.isEmpty()) {
                    return 1;
                }
            } catch (java.lang.Throwable th) {
                if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    return 1;
                }
                com.taobao.weex.utils.WXLogUtils.e(TAG, "callUpdateStyle throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
                return 1;
            }
        }
        return com.taobao.weex.bridge.WXBridgeManager.getInstance().callUpdateStyle(str, str2, map, map2, map3, map4);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callUpdateAttrs(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callUpdateAttrs(str, str2, map);
        } catch (java.lang.Throwable th) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 1;
            }
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callUpdateAttr throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callAddChildToRichtext(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.util.HashMap<java.lang.String, java.lang.String> map, java.util.HashMap<java.lang.String, java.lang.String> map2) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callAddChildToRichtext(str, str2, str3, str4, str5, map, map2);
        } catch (java.lang.Throwable th) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 1;
            }
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callAddChildToRichtext throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callRemoveChildFromRichtext(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callRemoveChildFromRichtext(str, str2, str3, str4);
        } catch (java.lang.Throwable th) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 1;
            }
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callRemoveChildFromRichtext throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callUpdateRichtextStyle(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map, java.lang.String str3, java.lang.String str4) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callUpdateRichtextStyle(str, str2, map, str3, str4);
        } catch (java.lang.Throwable th) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 1;
            }
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callUpdateRichtextStyle throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callUpdateRichtextChildAttr(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map, java.lang.String str3, java.lang.String str4) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callUpdateRichtextChildAttr(str, str2, map, str3, str4);
        } catch (java.lang.Throwable th) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 1;
            }
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callUpdateRichtextChildAttr throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callLayout(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callLayout(str, str2, i, i2, i3, i4, i5, i6, z, i7);
        } catch (java.lang.Throwable th) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 1;
            }
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callLayout throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callCreateFinish(java.lang.String str) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callCreateFinish(str);
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callCreateFinish throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callRenderSuccess(java.lang.String str) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callRenderSuccess(str);
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callCreateFinish throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callAppendTreeCreateFinish(java.lang.String str, java.lang.String str2) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callAppendTreeCreateFinish(str, str2);
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callAppendTreeCreateFinish throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public int callHasTransitionPros(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().callHasTransitionPros(str, str2, map);
        } catch (java.lang.Throwable th) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return 1;
            }
            com.taobao.weex.utils.WXLogUtils.e(TAG, "callHasTransitionPros throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return 1;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public com.taobao.weex.layout.ContentBoxMeasurement getMeasurementFunc(java.lang.String str, long j) {
        try {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().getMeasurementFunc(str, j);
        } catch (java.lang.Throwable th) {
            if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                return null;
            }
            com.taobao.weex.utils.WXLogUtils.e(TAG, "getMeasurementFunc throw exception:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return null;
        }
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void bindMeasurementToRenderObject(long j) {
        nativeBindMeasurementToRenderObject(j);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setRenderContainerWrapContent(boolean z, java.lang.String str) {
        nativeSetRenderContainerWrapContent(z, str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public long[] getFirstScreenRenderTime(java.lang.String str) {
        return nativeGetFirstScreenRenderTime(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public long[] getRenderFinishTime(java.lang.String str) {
        return nativeGetRenderFinishTime(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setDefaultHeightAndWidthIntoRootDom(java.lang.String str, float f, float f2, boolean z, boolean z2) {
        nativeSetDefaultHeightAndWidthIntoRootDom(str, f, f2, z, z2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void onInstanceClose(java.lang.String str) {
        nativeOnInstanceClose(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void forceLayout(java.lang.String str) {
        nativeForceLayout(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public boolean notifyLayout(java.lang.String str) {
        return nativeNotifyLayout(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setStyleWidth(java.lang.String str, java.lang.String str2, float f, boolean z) {
        nativeSetStyleWidth(str, str2, f, z);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setMargin(java.lang.String str, java.lang.String str2, com.taobao.weex.dom.CSSShorthand.EDGE edge, float f) {
        nativeSetMargin(str, str2, edge.ordinal(), f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setPadding(java.lang.String str, java.lang.String str2, com.taobao.weex.dom.CSSShorthand.EDGE edge, float f) {
        nativeSetPadding(str, str2, edge.ordinal(), f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setPosition(java.lang.String str, java.lang.String str2, com.taobao.weex.dom.CSSShorthand.EDGE edge, float f) {
        nativeSetPosition(str, str2, edge.ordinal(), f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void markDirty(java.lang.String str, java.lang.String str2, boolean z) {
        nativeMarkDirty(str, str2, z);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setDeviceDisplay(java.lang.String str, float f, float f2, float f3) {
        nativeSetDeviceDisplay(str, f, f2, f3);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setStyleHeight(java.lang.String str, java.lang.String str2, float f, boolean z) {
        nativeSetStyleHeight(str, str2, f, z);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setStyleWidth(java.lang.String str, java.lang.String str2, float f) {
        nativeSetStyleWidth(str, str2, f, false);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setStyleHeight(java.lang.String str, java.lang.String str2, float f) {
        nativeSetStyleHeight(str, str2, f, false);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setInstanceRenderType(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        nativeSetInstanceRenderType(str, str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setViewPortWidth(java.lang.String str, float f) {
        nativeSetViewPortWidth(str, f);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setFlexDirectionDef(java.lang.String str) {
        nativeSetFlexDirectionDef(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void removeInstanceRenderType(java.lang.String str) {
        nativeRemoveInstanceRenderType(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setPageArgument(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        nativeSetPageArgument(str, str2, str3);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void registerCoreEnv(java.lang.String str, java.lang.String str2) {
        nativeRegisterCoreEnv(str, str2);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void reportNativeInitStatus(java.lang.String str, java.lang.String str2) {
        if (com.taobao.weex.common.WXErrorCode.WX_JS_FRAMEWORK_INIT_SINGLE_PROCESS_SUCCESS.getErrorCode().equals(str) || com.taobao.weex.common.WXErrorCode.WX_JS_FRAMEWORK_INIT_FAILED.getErrorCode().equals(str)) {
            com.taobao.weex.adapter.IWXUserTrackAdapter iWXUserTrackAdapter = com.taobao.weex.WXSDKManager.getInstance().getIWXUserTrackAdapter();
            if (iWXUserTrackAdapter != null) {
                java.util.HashMap map = new java.util.HashMap(3);
                map.put(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_CODE, str);
                map.put(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ARG, "InitFrameworkNativeError");
                map.put(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, str2);
                com.taobao.weex.utils.WXLogUtils.e("reportNativeInitStatus is running and errorCode is " + str + " And errorMsg is " + str2);
                iWXUserTrackAdapter.commit(null, null, com.taobao.weex.adapter.IWXUserTrackAdapter.INIT_FRAMEWORK, null, map);
                return;
            }
            return;
        }
        if (com.taobao.weex.common.WXErrorCode.WX_JS_FRAMEWORK_INIT_FAILED_PARAMS_NULL.getErrorCode().equals(str)) {
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(null, com.taobao.weex.common.WXErrorCode.WX_JS_FRAMEWORK_INIT_FAILED_PARAMS_NULL, "WeexProxy::initFromParam()", com.taobao.weex.common.WXErrorCode.WX_JS_FRAMEWORK_INIT_FAILED_PARAMS_NULL.getErrorMsg() + ": " + str2, null);
            return;
        }
        for (com.taobao.weex.common.WXErrorCode wXErrorCode : com.taobao.weex.common.WXErrorCode.values()) {
            if (wXErrorCode.getErrorType().equals(com.taobao.weex.common.WXErrorCode.ErrorType.NATIVE_ERROR) && wXErrorCode.getErrorCode().equals(str)) {
                com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(null, wXErrorCode, com.taobao.weex.adapter.IWXUserTrackAdapter.INIT_FRAMEWORK, str2, null);
                return;
            }
        }
    }

    public void fireEventOnDataRenderNode(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        nativeFireEventOnDataRenderNode(str, str2, str3, str4, str5);
    }

    public void invokeCallbackOnDataRender(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        nativeInvokeCallbackOnDataRender(str, str2, str3, z);
    }

    public void registerModuleOnDataRenderNode(java.lang.String str) {
        nativeRegisterModuleOnDataRenderNode(str);
    }

    public void registerComponentOnDataRenderNode(java.lang.String str) {
        nativeRegisterComponentOnDataRenderNode(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void reloadPageLayout(java.lang.String str) {
        nativeReloadPageLayout(str);
    }

    @Override // com.taobao.weex.common.IWXBridge
    public void setDeviceDisplayOfPage(java.lang.String str, float f, float f2) {
        nativeSetDeviceDisplayOfPage(str, f, f2);
    }

    public java.lang.String encryptGetClientKeyPayload(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return nativePreGetClientKey(str, str2, str3);
    }

    public java.lang.String encrypt(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        return nativeEncrypt(str, str2, str3, str4);
    }

    public java.lang.String decrypt(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        return nativeDecrypt(str, str2, str3, str4);
    }

    public boolean verifyClientKeyPayload(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return nativeVerifyClientKeyPayload(str, str2, str3);
    }
}
