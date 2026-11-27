package io.dcloud.uniapp;

/* JADX INFO: compiled from: UniError.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB!\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u0010J\b\u0010 \u001a\u00020\u001bH\u0016J\b\u0010!\u001a\u00020\u0007H\u0016R\u001a\u0010\f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\bR\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lio/dcloud/uniapp/UniError;", "Lio/dcloud/uts/UTSError;", "Lio/dcloud/uts/json/IJsonStringify;", "Lio/dcloud/uniapp/IUniError;", "<init>", "()V", "message", "", "(Ljava/lang/String;)V", "options", "Lio/dcloud/uts/UTSJSONObject;", "(Ljava/lang/String;Lio/dcloud/uts/UTSJSONObject;)V", "errSubject", com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_CODE, "", com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, "(Ljava/lang/String;Ljava/lang/Number;Ljava/lang/String;)V", "getErrSubject", "()Ljava/lang/String;", "setErrSubject", "getErrCode", "()Ljava/lang/Number;", "setErrCode", "(Ljava/lang/Number;)V", "getErrMsg", "setErrMsg", "data", "", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "toJSON", "toString", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class UniError extends io.dcloud.uts.UTSError implements io.dcloud.uts.json.IJsonStringify, io.dcloud.uniapp.IUniError {
    private java.lang.Object data;
    private java.lang.Number errCode;
    private java.lang.String errMsg;
    private java.lang.String errSubject;

    public UniError() {
        this.errSubject = "";
        this.errCode = (java.lang.Number) 0;
        this.errMsg = "";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UniError(java.lang.String message) {
        this();
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        setMessage(message);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UniError(java.lang.String message, io.dcloud.uts.UTSJSONObject options) {
        this();
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        setMessage(message);
        java.lang.Object obj = options.get("cause");
        if (obj == null || !(obj instanceof io.dcloud.uts.UTSError)) {
            return;
        }
        setCause((io.dcloud.uts.UTSError) obj);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UniError(java.lang.String errSubject, java.lang.Number errCode, java.lang.String errMsg) {
        this();
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errSubject, "errSubject");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errCode, "errCode");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        setErrSubject(errSubject);
        setErrCode(errCode);
        setErrMsg(errMsg);
    }

    @Override // io.dcloud.uniapp.IUniError
    public java.lang.String getErrSubject() {
        return this.errSubject;
    }

    @Override // io.dcloud.uniapp.IUniError
    public void setErrSubject(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errSubject = str;
    }

    @Override // io.dcloud.uniapp.IUniError
    public java.lang.Number getErrCode() {
        return this.errCode;
    }

    @Override // io.dcloud.uniapp.IUniError
    public void setErrCode(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.errCode = number;
    }

    @Override // io.dcloud.uniapp.AsyncApiResult
    public java.lang.String getErrMsg() {
        return this.errMsg;
    }

    @Override // io.dcloud.uniapp.AsyncApiResult
    public void setErrMsg(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errMsg = str;
    }

    @Override // io.dcloud.uniapp.IUniError
    public java.lang.Object getData() {
        return this.data;
    }

    @Override // io.dcloud.uniapp.IUniError
    public void setData(java.lang.Object obj) {
        this.data = obj;
    }

    @Override // io.dcloud.uts.UTSError, io.dcloud.uts.json.IJsonStringify
    public java.lang.Object toJSON() {
        io.dcloud.uts.UTSJSONObject uTSJSONObject = new io.dcloud.uts.UTSJSONObject();
        uTSJSONObject.set(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_CODE, getErrCode());
        uTSJSONObject.set(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, getErrMsg());
        uTSJSONObject.set("errSubject", getErrSubject());
        if (getData() != null) {
            uTSJSONObject.set("data", getData());
        }
        if (getCause() != null) {
            if (getCause() instanceof io.dcloud.uts.json.IJsonStringify) {
                io.dcloud.uts.UTSError cause = getCause();
                kotlin.jvm.internal.Intrinsics.checkNotNull(cause, "null cannot be cast to non-null type io.dcloud.uts.json.IJsonStringify");
                uTSJSONObject.set("cause", cause.toJSON());
                return uTSJSONObject;
            }
            uTSJSONObject.set("cause", java.lang.String.valueOf(getCause()));
        }
        return uTSJSONObject;
    }

    @Override // io.dcloud.uts.UTSError, java.lang.Throwable
    public java.lang.String toString() {
        return "UniError(errSubject='" + getErrSubject() + "', errCode=" + getErrCode() + ", errMsg='" + getErrMsg() + "', data=" + getData() + ", cause=" + getCause() + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }
}
