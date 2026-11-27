package uts.sdk.modules.DCloudUniStorage;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Luts/sdk/modules/DCloudUniStorage/GetStorageInfoSuccess;", "Lio/dcloud/uts/UTSObject;", "keys", "Lio/dcloud/uts/UTSArray;", "", "currentSize", "", "limitSize", "<init>", "(Lio/dcloud/uts/UTSArray;Ljava/lang/Number;Ljava/lang/Number;)V", "getKeys", "()Lio/dcloud/uts/UTSArray;", "setKeys", "(Lio/dcloud/uts/UTSArray;)V", "getCurrentSize", "()Ljava/lang/Number;", "setCurrentSize", "(Ljava/lang/Number;)V", "getLimitSize", "setLimitSize", "uni-storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class GetStorageInfoSuccess extends io.dcloud.uts.UTSObject {

    @io.dcloud.uts.JsonNotNull
    private java.lang.Number currentSize;

    @io.dcloud.uts.JsonNotNull
    private io.dcloud.uts.UTSArray<java.lang.String> keys;

    @io.dcloud.uts.JsonNotNull
    private java.lang.Number limitSize;

    public io.dcloud.uts.UTSArray<java.lang.String> getKeys() {
        return this.keys;
    }

    public void setKeys(io.dcloud.uts.UTSArray<java.lang.String> uTSArray) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uTSArray, "<set-?>");
        this.keys = uTSArray;
    }

    public java.lang.Number getCurrentSize() {
        return this.currentSize;
    }

    public void setCurrentSize(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.currentSize = number;
    }

    public java.lang.Number getLimitSize() {
        return this.limitSize;
    }

    public void setLimitSize(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.limitSize = number;
    }

    public GetStorageInfoSuccess(io.dcloud.uts.UTSArray<java.lang.String> keys, java.lang.Number currentSize, java.lang.Number limitSize) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keys, "keys");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(currentSize, "currentSize");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(limitSize, "limitSize");
        this.keys = keys;
        this.currentSize = currentSize;
        this.limitSize = limitSize;
    }
}
