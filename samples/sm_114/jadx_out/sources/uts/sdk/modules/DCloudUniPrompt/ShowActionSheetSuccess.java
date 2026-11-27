package uts.sdk.modules.DCloudUniPrompt;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetSuccess;", "Lio/dcloud/uts/UTSObject;", "tapIndex", "", "<init>", "(Ljava/lang/Number;)V", "getTapIndex", "()Ljava/lang/Number;", "setTapIndex", "uni-prompt_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ShowActionSheetSuccess extends io.dcloud.uts.UTSObject {

    @io.dcloud.uts.JsonNotNull
    private java.lang.Number tapIndex;

    public java.lang.Number getTapIndex() {
        return this.tapIndex;
    }

    public void setTapIndex(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.tapIndex = number;
    }

    public ShowActionSheetSuccess(java.lang.Number tapIndex) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tapIndex, "tapIndex");
        this.tapIndex = tapIndex;
    }
}
