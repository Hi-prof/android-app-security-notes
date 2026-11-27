package io.dcloud.uts;

/* JADX INFO: compiled from: UTSCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\u000bJ(\u0010!\u001a\u0004\u0018\u00010\u00012\u0016\u0010\"\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010#\"\u0004\u0018\u00010\u0001H\u0086\u0002¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010(\u001a\u00020\u0005H\u0016R\u001a\u0010\f\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0007X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u000bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u000b¨\u0006)"}, d2 = {"Lio/dcloud/uts/UTSCallback;", "", "jsCallback", "Lcom/taobao/weex/bridge/JSCallback;", io.dcloud.feature.internal.sdk.SDK.UNIMP_EVENT_CALLBACKID, "", "name", "", "<init>", "(Lcom/taobao/weex/bridge/JSCallback;ILjava/lang/String;)V", "fn", "(Ljava/lang/Object;)V", "mCallbackId", "getMCallbackId", "()I", "setMCallbackId", "(I)V", "hostCallback", "getHostCallback", "()Lcom/taobao/weex/bridge/JSCallback;", "setHostCallback", "(Lcom/taobao/weex/bridge/JSCallback;)V", "callbackName", "getCallbackName", "()Ljava/lang/String;", "setCallbackName", "(Ljava/lang/String;)V", "getFn", "()Ljava/lang/Object;", "setFn", "fnJS", "getFnJS", "setFnJS", "invoke", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UTSCallback {
    public java.lang.String callbackName;
    private java.lang.Object fn;
    private java.lang.Object fnJS;
    private com.taobao.weex.bridge.JSCallback hostCallback;
    private int mCallbackId;

    public int getMCallbackId() {
        return this.mCallbackId;
    }

    public void setMCallbackId(int i) {
        this.mCallbackId = i;
    }

    public com.taobao.weex.bridge.JSCallback getHostCallback() {
        return this.hostCallback;
    }

    public void setHostCallback(com.taobao.weex.bridge.JSCallback jSCallback) {
        this.hostCallback = jSCallback;
    }

    public java.lang.String getCallbackName() {
        java.lang.String str = this.callbackName;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("callbackName");
        return null;
    }

    public void setCallbackName(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.callbackName = str;
    }

    public UTSCallback(com.taobao.weex.bridge.JSCallback jSCallback, int i, java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        this.mCallbackId = -1;
        setMCallbackId(i);
        setHostCallback(jSCallback);
        setCallbackName(name);
    }

    public final java.lang.Object getFn() {
        return this.fn;
    }

    public final void setFn(java.lang.Object obj) {
        this.fn = obj;
    }

    public final java.lang.Object getFnJS() {
        return this.fnJS;
    }

    public final void setFnJS(java.lang.Object obj) {
        this.fnJS = obj;
    }

    public UTSCallback(java.lang.Object fn) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fn, "fn");
        this.mCallbackId = -1;
        this.fn = fn;
    }

    public final java.lang.Object invoke(java.lang.Object... args) {
        java.lang.reflect.Method method;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(args, "args");
        java.lang.Object obj = this.fn;
        int i = 0;
        if (obj != null) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
            java.lang.reflect.Method[] methods = obj.getClass().getMethods();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(methods, "getMethods(...)");
            java.lang.reflect.Method[] methodArr = methods;
            int length = methodArr.length;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = methodArr[i];
                if (kotlin.jvm.internal.Intrinsics.areEqual(method.getName(), "invoke")) {
                    break;
                }
                i++;
            }
            java.lang.reflect.Method method2 = method;
            if (method2 != null) {
                return method2.invoke(this.fn, java.util.Arrays.copyOf(args, args.length));
            }
            return null;
        }
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        for (java.lang.Object obj2 : args) {
            if (obj2 instanceof io.dcloud.uts.UTSJSONObject) {
                jSONArray.add(((io.dcloud.uts.UTSJSONObject) obj2).toJSONObject());
            } else if (obj2 != null && !(obj2 instanceof java.lang.String) && !(obj2 instanceof java.lang.Number) && !(obj2 instanceof java.lang.Boolean) && !obj2.getClass().isPrimitive()) {
                jSONArray.add(com.alibaba.fastjson.JSON.parse(new io.dcloud.uts.gson.GsonBuilder().serializeSpecialFloatingPointValues().setExclusionStrategies(new io.dcloud.uts.DynamicMapStrategy()).registerTypeAdapter(io.dcloud.uts.UTSJSONObject.class, new io.dcloud.uts.UTSJSONJsonSerializer()).create().toJson(obj2)));
            } else {
                jSONArray.add(obj2);
            }
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        com.alibaba.fastjson.JSONObject jSONObject2 = jSONObject;
        jSONObject2.put("type", "params");
        jSONObject2.put("params", jSONArray);
        jSONObject2.put("name", getCallbackName());
        jSONObject2.put("keepAlive", true);
        jSONObject2.put("id", java.lang.Integer.valueOf(getMCallbackId()));
        if (getHostCallback() != null) {
            com.taobao.weex.bridge.JSCallback hostCallback = getHostCallback();
            kotlin.jvm.internal.Intrinsics.checkNotNull(hostCallback);
            hostCallback.invokeAndKeepAlive(jSONObject);
        }
        return null;
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!kotlin.jvm.internal.Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(other, "null cannot be cast to non-null type io.dcloud.uts.UTSCallback");
        return getMCallbackId() == ((io.dcloud.uts.UTSCallback) other).getMCallbackId();
    }

    public int hashCode() {
        return getMCallbackId();
    }
}
