package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H&R=\u0010\u0002\u001a'\u0012#\u0012!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\n0\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014À\u0006\u0003"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/NetworkUploadFileListener;", "", "progressListeners", "Ljava/util/ArrayList;", "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniNetwork/OnProgressUpdateResult;", "Lkotlin/ParameterName;", "name", "result", "", "Luts/sdk/modules/DCloudUniNetwork/UploadFileProgressUpdateCallback;", "getProgressListeners", "()Ljava/util/ArrayList;", "setProgressListeners", "(Ljava/util/ArrayList;)V", "onProgress", "progressUpdate", "onComplete", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_OPTION, "Lio/dcloud/uts/UTSJSONObject;", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NetworkUploadFileListener {
    java.util.ArrayList<kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.OnProgressUpdateResult, kotlin.Unit>> getProgressListeners();

    void onComplete(io.dcloud.uts.UTSJSONObject option);

    void onProgress(uts.sdk.modules.DCloudUniNetwork.OnProgressUpdateResult progressUpdate);

    void setProgressListeners(java.util.ArrayList<kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.OnProgressUpdateResult, kotlin.Unit>> arrayList);
}
