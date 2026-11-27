package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public class NativeInvokeHelper {
    private java.lang.String mInstanceId;

    public NativeInvokeHelper(java.lang.String str) {
        this.mInstanceId = str;
    }

    public java.lang.Object invoke(final java.lang.Object obj, final com.taobao.weex.bridge.Invoker invoker, com.alibaba.fastjson.JSONArray jSONArray) throws java.lang.Exception {
        final java.lang.Object[] objArrPrepareArguments = prepareArguments(invoker.getParameterTypes(), jSONArray);
        if (com.taobao.weex.performance.WXAnalyzerDataTransfer.isInteractionLogOpen() && (invoker instanceof com.taobao.weex.bridge.MethodInvoker)) {
            for (int i = 0; i < objArrPrepareArguments.length; i++) {
                java.lang.Object obj2 = objArrPrepareArguments[i];
                if (obj2 instanceof com.taobao.weex.bridge.SimpleJSCallback) {
                    final java.lang.String callbackId = ((com.taobao.weex.bridge.SimpleJSCallback) obj2).getCallbackId();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("[client][callNativeModuleStart],");
                    sb.append(this.mInstanceId);
                    sb.append(",");
                    com.taobao.weex.bridge.MethodInvoker methodInvoker = (com.taobao.weex.bridge.MethodInvoker) invoker;
                    sb.append(methodInvoker.mMethod.getDeclaringClass());
                    sb.append(",");
                    sb.append(methodInvoker.mMethod.getName());
                    sb.append(",");
                    sb.append(callbackId);
                    android.util.Log.d(com.taobao.weex.performance.WXAnalyzerDataTransfer.INTERACTION_TAG, sb.toString());
                    ((com.taobao.weex.bridge.SimpleJSCallback) objArrPrepareArguments[i]).setInvokerCallback(new com.taobao.weex.bridge.SimpleJSCallback.InvokerCallback() { // from class: com.taobao.weex.bridge.NativeInvokeHelper.1
                        @Override // com.taobao.weex.bridge.SimpleJSCallback.InvokerCallback
                        public void onInvokeSuccess() {
                            android.util.Log.d(com.taobao.weex.performance.WXAnalyzerDataTransfer.INTERACTION_TAG, "[client][callNativeModuleEnd]," + com.taobao.weex.bridge.NativeInvokeHelper.this.mInstanceId + "," + ((com.taobao.weex.bridge.MethodInvoker) invoker).mMethod.getDeclaringClass() + "," + ((com.taobao.weex.bridge.MethodInvoker) invoker).mMethod.getName() + "," + callbackId);
                        }
                    });
                    break;
                }
            }
        }
        if (invoker.isRunOnUIThread()) {
            com.taobao.weex.WXSDKManager.getInstance().postOnUiThread(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.NativeInvokeHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    if (invoker != null) {
                        try {
                            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(com.taobao.weex.bridge.NativeInvokeHelper.this.mInstanceId);
                            if (sDKInstance != null && !sDKInstance.isDestroy()) {
                                invoker.invoke(obj, objArrPrepareArguments);
                            }
                        } catch (java.lang.Exception e) {
                            com.taobao.weex.utils.WXLogUtils.e("NativeInvokeHelper", obj + " Invoker " + invoker.toString() + " exception:" + e);
                        }
                    }
                }
            }, 0L);
            return null;
        }
        return invoker.invoke(obj, objArrPrepareArguments);
    }

    protected java.lang.Object[] prepareArguments(java.lang.reflect.Type[] typeArr, com.alibaba.fastjson.JSONArray jSONArray) throws java.lang.Exception {
        java.lang.Object[] objArr = new java.lang.Object[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            java.lang.reflect.Type type = typeArr[i];
            if (i >= jSONArray.size()) {
                if (!type.getClass().isPrimitive()) {
                    objArr[i] = null;
                } else {
                    throw new java.lang.Exception("[prepareArguments] method argument list not match.");
                }
            } else {
                java.lang.Object obj = jSONArray.get(i);
                if (type == com.alibaba.fastjson.JSONObject.class) {
                    if ((obj instanceof com.alibaba.fastjson.JSONObject) || obj == null) {
                        objArr[i] = obj;
                    } else if (obj instanceof java.lang.String) {
                        objArr[i] = com.alibaba.fastjson.JSON.parseObject(obj.toString());
                    }
                } else if (com.taobao.weex.bridge.JSCallback.class == type || io.dcloud.feature.uniapp.bridge.UniJSCallback.class == type) {
                    if (obj instanceof java.lang.String) {
                        objArr[i] = new com.taobao.weex.bridge.SimpleJSCallback(this.mInstanceId, (java.lang.String) obj);
                    } else {
                        throw new java.lang.Exception("Parameter type not match.");
                    }
                } else {
                    objArr[i] = com.taobao.weex.utils.WXReflectionUtils.parseArgument(type, obj);
                }
            }
        }
        return objArr;
    }
}
