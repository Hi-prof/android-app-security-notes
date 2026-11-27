package io.dcloud.feature.weex.extend.result;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Result {
    public io.dcloud.feature.weex.extend.result.Result.IError cause;
    public com.alibaba.fastjson.JSONObject data;
    public int errCode;
    public java.lang.String errMsg;
    public java.lang.String errSubject;

    public interface IError {
        com.alibaba.fastjson.JSONObject toJsonObject();
    }

    public static class SourceError implements io.dcloud.feature.weex.extend.result.Result.IError {
        public static final int EMPTY_CODE = -999999;
        public io.dcloud.feature.weex.extend.result.Result.SourceError cause;
        public int code;
        public java.lang.String message;
        public java.lang.String subject;

        public SourceError(java.lang.String str, int i, java.lang.String str2, io.dcloud.feature.weex.extend.result.Result.SourceError sourceError) {
            this.subject = str;
            this.code = i;
            this.message = str2;
            this.cause = sourceError;
        }

        @Override // io.dcloud.feature.weex.extend.result.Result.IError
        public com.alibaba.fastjson.JSONObject toJsonObject() {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            java.lang.String str = this.subject;
            if (str != null) {
                jSONObject.put("subject", (java.lang.Object) str);
            }
            int i = this.code;
            if (i != -999999) {
                jSONObject.put("code", (java.lang.Object) java.lang.Integer.valueOf(i));
            }
            java.lang.String str2 = this.message;
            if (str2 != null) {
                jSONObject.put("message", (java.lang.Object) str2);
            }
            io.dcloud.feature.weex.extend.result.Result.SourceError sourceError = this.cause;
            if (sourceError != null) {
                jSONObject.put("cause", (java.lang.Object) sourceError.toJsonObject());
            }
            return jSONObject;
        }
    }

    public static class AggregateError implements io.dcloud.feature.weex.extend.result.Result.IError {
        public java.lang.String[] errors;
        public java.lang.String message;
        public java.lang.String name;

        public AggregateError(java.lang.String str, java.lang.String[] strArr, java.lang.String str2) {
            this.name = str;
            this.errors = strArr;
            this.message = str2;
        }

        @Override // io.dcloud.feature.weex.extend.result.Result.IError
        public com.alibaba.fastjson.JSONObject toJsonObject() {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("name", (java.lang.Object) this.name);
            if (this.errors != null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
                for (java.lang.String str : this.errors) {
                    sb.append(str);
                }
                sb.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
                jSONObject.put("errors", (java.lang.Object) sb);
            }
            java.lang.String str2 = this.message;
            if (str2 != null) {
                jSONObject.put("message", (java.lang.Object) str2);
            }
            return jSONObject;
        }
    }

    public Result(java.lang.String str, int i, java.lang.String str2) {
        this.errSubject = str;
        this.errCode = i;
        this.errMsg = str2;
    }

    @java.lang.SafeVarargs
    public static com.alibaba.fastjson.JSONObject boxCallBackResult(boolean z, android.util.Pair<java.lang.String, java.lang.Object>... pairArr) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        if (z) {
            jSONObject.put("type", (java.lang.Object) com.taobao.weex.ui.component.WXImage.SUCCEED);
        } else {
            jSONObject.put("type", (java.lang.Object) com.taobao.weex.common.Constants.Event.FAIL);
        }
        for (android.util.Pair<java.lang.String, java.lang.Object> pair : pairArr) {
            if (pair != null) {
                jSONObject.put((java.lang.String) pair.first, pair.second);
            }
        }
        return jSONObject;
    }

    public static com.alibaba.fastjson.JSONObject boxSuccessResult(java.lang.Object obj) {
        return boxCallBackResult(true, new android.util.Pair("data", obj));
    }

    public static com.alibaba.fastjson.JSONObject boxFailResult(io.dcloud.feature.weex.extend.result.Result result) {
        return boxCallBackResult(false, new android.util.Pair("errSubject", result.errSubject), new android.util.Pair(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_CODE, java.lang.Integer.valueOf(result.errCode)), new android.util.Pair(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, result.errMsg), result.cause != null ? new android.util.Pair("cause", result.cause.toJsonObject()) : null, result.data != null ? new android.util.Pair("data", result.data) : null);
    }
}
