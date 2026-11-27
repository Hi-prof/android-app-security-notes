package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/OnProgressDownloadResult;", "Lio/dcloud/uts/UTSObject;", "progress", "", "totalBytesWritten", "totalBytesExpectedToWrite", "<init>", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)V", "getProgress", "()Ljava/lang/Number;", "setProgress", "(Ljava/lang/Number;)V", "getTotalBytesWritten", "setTotalBytesWritten", "getTotalBytesExpectedToWrite", "setTotalBytesExpectedToWrite", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class OnProgressDownloadResult extends io.dcloud.uts.UTSObject {

    @io.dcloud.uts.JsonNotNull
    private java.lang.Number progress;

    @io.dcloud.uts.JsonNotNull
    private java.lang.Number totalBytesExpectedToWrite;

    @io.dcloud.uts.JsonNotNull
    private java.lang.Number totalBytesWritten;

    public java.lang.Number getProgress() {
        return this.progress;
    }

    public void setProgress(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.progress = number;
    }

    public java.lang.Number getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    public void setTotalBytesWritten(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.totalBytesWritten = number;
    }

    public java.lang.Number getTotalBytesExpectedToWrite() {
        return this.totalBytesExpectedToWrite;
    }

    public void setTotalBytesExpectedToWrite(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.totalBytesExpectedToWrite = number;
    }

    public OnProgressDownloadResult(java.lang.Number progress, java.lang.Number totalBytesWritten, java.lang.Number totalBytesExpectedToWrite) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(progress, "progress");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(totalBytesWritten, "totalBytesWritten");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(totalBytesExpectedToWrite, "totalBytesExpectedToWrite");
        this.progress = progress;
        this.totalBytesWritten = totalBytesWritten;
        this.totalBytesExpectedToWrite = totalBytesExpectedToWrite;
    }
}
