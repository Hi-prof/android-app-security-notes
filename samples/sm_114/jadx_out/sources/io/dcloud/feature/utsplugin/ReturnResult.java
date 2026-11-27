package io.dcloud.feature.utsplugin;

/* JADX INFO: compiled from: ReturnResult.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lio/dcloud/feature/utsplugin/ReturnResult;", "", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "params", "getParams", "()Ljava/lang/Object;", "setParams", "(Ljava/lang/Object;)V", com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, "getErrMsg", "setErrMsg", "(Ljava/lang/String;)V", "updateJSON", "", "newParam", "updateError", "newErrMsg", "toJSON", "Lcom/alibaba/fastjson/JSONObject;", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReturnResult {
    private final java.lang.String type = com.taobao.weex.common.Constants.Event.RETURN;
    private java.lang.Object params = "";
    private java.lang.String errMsg = "";

    public java.lang.String getType() {
        return this.type;
    }

    public java.lang.Object getParams() {
        return this.params;
    }

    public void setParams(java.lang.Object obj) {
        this.params = obj;
    }

    public java.lang.String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errMsg = str;
    }

    public final void updateJSON(java.lang.Object newParam) {
        setParams(newParam);
        setErrMsg("");
    }

    public final void updateError(java.lang.String newErrMsg) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newErrMsg, "newErrMsg");
        setParams("");
        setErrMsg(newErrMsg);
    }

    public final com.alibaba.fastjson.JSONObject toJSON() {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        com.alibaba.fastjson.JSONObject jSONObject2 = jSONObject;
        jSONObject2.put("type", getType());
        if (android.text.TextUtils.isEmpty(getErrMsg())) {
            if ((getParams() instanceof java.lang.String) || (getParams() instanceof java.lang.Number) || (getParams() instanceof java.lang.Boolean) || (getParams() instanceof com.alibaba.fastjson.JSONObject) || (getParams() instanceof org.json.JSONArray) || (getParams() instanceof io.dcloud.uts.UTSArray) || getParams() == null) {
                jSONObject2.put("params", getParams());
                return jSONObject;
            }
            jSONObject2.put("params", com.alibaba.fastjson.JSON.parseObject(io.dcloud.uts.JSON.stringify(getParams())));
            return jSONObject;
        }
        jSONObject2.put(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, getErrMsg());
        return jSONObject;
    }
}
