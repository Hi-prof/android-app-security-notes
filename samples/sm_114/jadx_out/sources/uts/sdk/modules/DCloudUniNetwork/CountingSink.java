package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0016\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/CountingSink;", "Lokio/ForwardingSink;", "sink", "Lokio/Sink;", "total", "", "listener", "Luts/sdk/modules/DCloudUniNetwork/UploadProgressListener;", "<init>", "(Lokio/Sink;Ljava/lang/Number;Luts/sdk/modules/DCloudUniNetwork/UploadProgressListener;)V", "bytesWritten", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class CountingSink extends okio.ForwardingSink {
    private java.lang.Number bytesWritten;
    private uts.sdk.modules.DCloudUniNetwork.UploadProgressListener listener;
    private java.lang.Number total;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountingSink(okio.Sink sink, java.lang.Number total, uts.sdk.modules.DCloudUniNetwork.UploadProgressListener listener) {
        super(sink);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sink, "sink");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(total, "total");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.bytesWritten = (java.lang.Number) 0;
        this.listener = listener;
        this.total = total;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(okio.Buffer source, long byteCount) throws java.io.IOException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        super.write(source, byteCount);
        java.lang.Number numberPlus = io.dcloud.uts.NumberKt.plus(this.bytesWritten, java.lang.Long.valueOf(byteCount));
        this.bytesWritten = numberPlus;
        uts.sdk.modules.DCloudUniNetwork.UploadProgressListener uploadProgressListener = this.listener;
        if (uploadProgressListener != null) {
            uploadProgressListener.onProgress(numberPlus, this.total);
        }
    }
}
