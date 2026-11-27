package uts.sdk.modules.DCloudUniStorage;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Luts/sdk/modules/DCloudUniStorage/GetStorageSuccess;", "Lio/dcloud/uts/UTSObject;", "data", "", "<init>", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "setData", "uni-storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class GetStorageSuccess extends io.dcloud.uts.UTSObject {
    private java.lang.Object data;

    /* JADX WARN: Illegal instructions before constructor call */
    public GetStorageSuccess() {
        kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker = null;
        this(defaultConstructorMarker, 1, defaultConstructorMarker);
    }

    public /* synthetic */ GetStorageSuccess(java.lang.Object obj, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj);
    }

    public java.lang.Object getData() {
        return this.data;
    }

    public void setData(java.lang.Object obj) {
        this.data = obj;
    }

    public GetStorageSuccess(java.lang.Object obj) {
        this.data = obj;
    }
}
