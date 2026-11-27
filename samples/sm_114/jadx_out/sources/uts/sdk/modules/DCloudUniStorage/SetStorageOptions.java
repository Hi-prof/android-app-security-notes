package uts.sdk.modules.DCloudUniStorage;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B\u009e\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012+\b\u0002\u0010\u0006\u001a%\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\r\u0012+\b\u0002\u0010\u000e\u001a%\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0010\u0012+\b\u0002\u0010\u0011\u001a%\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR=\u0010\u0006\u001a%\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R=\u0010\u000e\u001a%\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R=\u0010\u0011\u001a%\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 ¨\u0006%"}, d2 = {"Luts/sdk/modules/DCloudUniStorage/SetStorageOptions;", "Lio/dcloud/uts/UTSObject;", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "", "data", "", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniStorage/SetStorageSuccess;", "Lkotlin/ParameterName;", "name", com.facebook.common.util.UriUtil.LOCAL_RESOURCE_SCHEME, "", "Luts/sdk/modules/DCloudUniStorage/SetStorageSuccessCallback;", com.taobao.weex.common.Constants.Event.FAIL, "Lio/dcloud/uniapp/UniError;", "Luts/sdk/modules/DCloudUniStorage/SetStorageFailCallback;", "complete", "Luts/sdk/modules/DCloudUniStorage/SetStorageCompleteCallback;", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "getSuccess", "()Lkotlin/jvm/functions/Function1;", "setSuccess", "(Lkotlin/jvm/functions/Function1;)V", "getFail", "setFail", "getComplete", "setComplete", "uni-storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class SetStorageOptions extends io.dcloud.uts.UTSObject {
    private kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete;

    @io.dcloud.uts.JsonNotNull
    private java.lang.Object data;
    private kotlin.jvm.functions.Function1<? super io.dcloud.uniapp.UniError, kotlin.Unit> fail;

    @io.dcloud.uts.JsonNotNull
    private java.lang.String key;
    private kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniStorage.SetStorageSuccess, kotlin.Unit> success;

    public /* synthetic */ SetStorageOptions(java.lang.String str, java.lang.Object obj, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function2, kotlin.jvm.functions.Function1 function3, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, obj, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : function2, (i & 16) != 0 ? null : function3);
    }

    public java.lang.String getKey() {
        return this.key;
    }

    public void setKey(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    public java.lang.Object getData() {
        return this.data;
    }

    public void setData(java.lang.Object obj) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.data = obj;
    }

    public kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.SetStorageSuccess, kotlin.Unit> getSuccess() {
        return this.success;
    }

    public void setSuccess(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniStorage.SetStorageSuccess, kotlin.Unit> function1) {
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

    public SetStorageOptions(java.lang.String key, java.lang.Object data, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniStorage.SetStorageSuccess, kotlin.Unit> function1, kotlin.jvm.functions.Function1<? super io.dcloud.uniapp.UniError, kotlin.Unit> function2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        this.key = key;
        this.data = data;
        this.success = function1;
        this.fail = function2;
        this.complete = function3;
    }
}
