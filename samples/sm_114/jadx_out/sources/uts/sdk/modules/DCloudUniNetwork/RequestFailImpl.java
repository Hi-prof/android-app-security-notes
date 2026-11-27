package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\b\u0016\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/RequestFailImpl;", "Lio/dcloud/uniapp/UniError;", "Luts/sdk/modules/DCloudUniNetwork/RequestFail;", com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_CODE, "", "Luts/sdk/modules/DCloudUniNetwork/RequestErrorCode;", "<init>", "(Ljava/lang/Number;)V", "getErrCode", "()Ljava/lang/Number;", "setErrCode", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class RequestFailImpl extends io.dcloud.uniapp.UniError implements uts.sdk.modules.DCloudUniNetwork.RequestFail {
    public java.lang.Number errCode;

    @Override // io.dcloud.uniapp.UniError, io.dcloud.uniapp.IUniError
    public java.lang.Number getErrCode() {
        java.lang.Number number = this.errCode;
        if (number != null) {
            return number;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_CODE);
        return null;
    }

    @Override // io.dcloud.uniapp.UniError, io.dcloud.uniapp.IUniError
    public void setErrCode(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.errCode = number;
    }

    public RequestFailImpl(java.lang.Number errCode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errCode, "errCode");
        setErrSubject(uts.sdk.modules.DCloudUniNetwork.IndexKt.getUniNetWorkErrorSubject());
        setErrCode(errCode);
        java.lang.String str = uts.sdk.modules.DCloudUniNetwork.IndexKt.getNetWorkUniErrors().get(errCode);
        setErrMsg(str == null ? "" : str);
    }
}
