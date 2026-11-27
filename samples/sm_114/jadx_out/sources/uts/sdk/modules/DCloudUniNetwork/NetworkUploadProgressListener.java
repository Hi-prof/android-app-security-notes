package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/NetworkUploadProgressListener;", "Luts/sdk/modules/DCloudUniNetwork/UploadProgressListener;", "listener", "Luts/sdk/modules/DCloudUniNetwork/NetworkUploadFileListener;", "<init>", "(Luts/sdk/modules/DCloudUniNetwork/NetworkUploadFileListener;)V", "onProgress", "", "bytesWritten", "", "contentLength", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class NetworkUploadProgressListener implements uts.sdk.modules.DCloudUniNetwork.UploadProgressListener {
    private uts.sdk.modules.DCloudUniNetwork.NetworkUploadFileListener listener;

    public NetworkUploadProgressListener(uts.sdk.modules.DCloudUniNetwork.NetworkUploadFileListener listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // uts.sdk.modules.DCloudUniNetwork.UploadProgressListener
    public void onProgress(java.lang.Number bytesWritten, java.lang.Number contentLength) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bytesWritten, "bytesWritten");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contentLength, "contentLength");
        uts.sdk.modules.DCloudUniNetwork.OnProgressUpdateResult onProgressUpdateResult = new uts.sdk.modules.DCloudUniNetwork.OnProgressUpdateResult(java.lang.Integer.valueOf(io.dcloud.uts.NumberKt.times(io.dcloud.uts.NumberKt.div(java.lang.Float.valueOf(bytesWritten.floatValue()), contentLength), (java.lang.Number) 100).intValue()), bytesWritten, contentLength);
        uts.sdk.modules.DCloudUniNetwork.NetworkUploadFileListener networkUploadFileListener = this.listener;
        if (networkUploadFileListener != null) {
            networkUploadFileListener.onProgress(onProgressUpdateResult);
        }
    }
}
