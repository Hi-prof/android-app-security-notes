package uts.sdk.modules.DCloudUniGetAppBaseInfo;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Luts/sdk/modules/DCloudUniGetAppBaseInfo/GetAppBaseInfoOptions;", "Lio/dcloud/uts/UTSObject;", com.taobao.weex.common.Constants.Name.FILTER, "Lio/dcloud/uts/UTSArray;", "", "<init>", "(Lio/dcloud/uts/UTSArray;)V", "getFilter", "()Lio/dcloud/uts/UTSArray;", "setFilter", "uni-getAppBaseInfo_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class GetAppBaseInfoOptions extends io.dcloud.uts.UTSObject {

    @io.dcloud.uts.JsonNotNull
    private io.dcloud.uts.UTSArray<java.lang.String> filter;

    public io.dcloud.uts.UTSArray<java.lang.String> getFilter() {
        return this.filter;
    }

    public void setFilter(io.dcloud.uts.UTSArray<java.lang.String> uTSArray) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uTSArray, "<set-?>");
        this.filter = uTSArray;
    }

    public GetAppBaseInfoOptions(io.dcloud.uts.UTSArray<java.lang.String> filter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(filter, "filter");
        this.filter = filter;
    }
}
