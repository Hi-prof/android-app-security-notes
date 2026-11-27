package uts.sdk.modules.DCloudUniStorage;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\u0096\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012+\b\u0002\u0010\u0004\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b\u0012+\b\u0002\u0010\f\u001a%\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000e\u0012+\b\u0002\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R=\u0010\u0004\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR=\u0010\f\u001a%\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR=\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001b¨\u0006 "}, d2 = {"Luts/sdk/modules/DCloudUniStorage/GetStorageOptions;", "Lio/dcloud/uts/UTSObject;", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniStorage/GetStorageSuccess;", "Lkotlin/ParameterName;", "name", com.facebook.common.util.UriUtil.LOCAL_RESOURCE_SCHEME, "", "Luts/sdk/modules/DCloudUniStorage/GetStorageSuccessCallback;", com.taobao.weex.common.Constants.Event.FAIL, "Lio/dcloud/uniapp/UniError;", "Luts/sdk/modules/DCloudUniStorage/GetStorageFailCallback;", "complete", "", "Luts/sdk/modules/DCloudUniStorage/GetStorageCompleteCallback;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getSuccess", "()Lkotlin/jvm/functions/Function1;", "setSuccess", "(Lkotlin/jvm/functions/Function1;)V", "getFail", "setFail", "getComplete", "setComplete", "uni-storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class GetStorageOptions extends io.dcloud.uts.UTSObject {
    private kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete;
    private kotlin.jvm.functions.Function1<? super io.dcloud.uniapp.UniError, kotlin.Unit> fail;

    @io.dcloud.uts.JsonNotNull
    private java.lang.String key;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniStorage.GetStorageSuccess, kotlin.Unit> success;

    public /* synthetic */ GetStorageOptions(java.lang.String str, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function2, kotlin.jvm.functions.Function1 function3, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : function1, (i & 4) != 0 ? null : function2, (i & 8) != 0 ? null : function3);
    }

    public java.lang.String getKey() {
        return this.key;
    }

    public void setKey(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.GetStorageSuccess, kotlin.Unit> getSuccess() {
        return this.success;
    }

    public void setSuccess(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniStorage.GetStorageSuccess, kotlin.Unit> function1) {
        this.success = function1;
    }

    public kotlin.jvm.functions.Function1<io.dcloud.uniapp.UniError, kotlin.Unit> getFail() {
        return this.fail;
    }

    public void setFail(kotlin.jvm.functions.Function1<? super io.dcloud.uniapp.UniError, kotlin.Unit> function1) {
        this.fail = function1;
    }

    public kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> getComplete() {
        return this.complete;
    }

    public void setComplete(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1) {
        this.complete = function1;
    }

    public GetStorageOptions(java.lang.String key, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniStorage.GetStorageSuccess, kotlin.Unit> function1, kotlin.jvm.functions.Function1<? super io.dcloud.uniapp.UniError, kotlin.Unit> function2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.success = function1;
        this.fail = function2;
        this.complete = function3;
    }
}
