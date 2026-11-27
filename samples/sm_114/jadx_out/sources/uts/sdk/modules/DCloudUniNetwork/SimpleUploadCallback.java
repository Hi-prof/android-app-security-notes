package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/SimpleUploadCallback;", "Lokhttp3/Callback;", "listener", "Luts/sdk/modules/DCloudUniNetwork/NetworkUploadFileListener;", "<init>", "(Luts/sdk/modules/DCloudUniNetwork/NetworkUploadFileListener;)V", "onFailure", "", androidx.core.app.NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "exception", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class SimpleUploadCallback implements okhttp3.Callback {
    private uts.sdk.modules.DCloudUniNetwork.NetworkUploadFileListener listener;

    public SimpleUploadCallback(uts.sdk.modules.DCloudUniNetwork.NetworkUploadFileListener listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // okhttp3.Callback
    public void onFailure(okhttp3.Call call, java.io.IOException exception) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(call, "call");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(exception, "exception");
        io.dcloud.uts.UTSJSONObject uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
        uTSJSONObject_uO.set("statusCode", "-1");
        uTSJSONObject_uO.set("errorCode", "-1");
        uTSJSONObject_uO.set("errorMsg", exception.getMessage());
        uTSJSONObject_uO.set("cause", new io.dcloud.uniapp.SourceError(io.dcloud.uts.NumberKt.toString_number_nullable$default(exception.getCause(), (java.lang.Number) null, 1, (java.lang.Object) null)));
        uts.sdk.modules.DCloudUniNetwork.NetworkUploadFileListener networkUploadFileListener = this.listener;
        if (networkUploadFileListener != null) {
            networkUploadFileListener.onComplete(uTSJSONObject_uO);
        }
    }

    @Override // okhttp3.Callback
    public void onResponse(okhttp3.Call call, okhttp3.Response response) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(call, "call");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(response, "response");
        io.dcloud.uts.UTSJSONObject uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
        uTSJSONObject_uO.set("statusCode", io.dcloud.uts.NumberKt.plus(java.lang.Integer.valueOf(response.code()), ""));
        okhttp3.ResponseBody responseBodyBody = response.body();
        uTSJSONObject_uO.set("data", responseBodyBody != null ? responseBodyBody.string() : null);
        uts.sdk.modules.DCloudUniNetwork.NetworkUploadFileListener networkUploadFileListener = this.listener;
        if (networkUploadFileListener != null) {
            networkUploadFileListener.onComplete(uTSJSONObject_uO);
        }
    }
}
