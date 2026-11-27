package uts.sdk.modules.DCloudUniChooseMedia;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0016\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaErrorImpl;", "Lio/dcloud/uniapp/UniError;", "Luts/sdk/modules/DCloudUniChooseMedia/IChooseMediaError;", com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_CODE, "", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaErrorCode;", "uniErrorSubject", "", "<init>", "(Ljava/lang/Number;Ljava/lang/String;)V", "getErrCode", "()Ljava/lang/Number;", "setErrCode", "(Ljava/lang/Number;)V", "uni-chooseMedia_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ChooseMediaErrorImpl extends io.dcloud.uniapp.UniError implements uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError {
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

    public ChooseMediaErrorImpl(java.lang.Number errCode, java.lang.String uniErrorSubject) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errCode, "errCode");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uniErrorSubject, "uniErrorSubject");
        setErrSubject(uniErrorSubject);
        setErrCode(errCode);
        java.lang.String str = uts.sdk.modules.DCloudUniChooseMedia.IndexKt.getChooseMediaUniErrors().get(errCode);
        setErrMsg(str == null ? "" : str);
    }

    public /* synthetic */ ChooseMediaErrorImpl(java.lang.Number number, java.lang.String str, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(number, (i & 2) != 0 ? "uni-chooseMedia" : str);
    }
}
