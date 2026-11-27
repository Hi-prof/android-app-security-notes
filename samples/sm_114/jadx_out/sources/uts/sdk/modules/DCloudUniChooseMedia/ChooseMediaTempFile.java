package uts.sdk.modules.DCloudUniChooseMedia;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u001c\b\u0016\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0003j\u0002`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u00060\u0003j\u0002`\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012¨\u0006#"}, d2 = {"Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaTempFile;", "Lio/dcloud/uts/UTSObject;", "tempFilePath", "", "fileType", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaFileType;", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "", "byteSize", "duration", "height", "width", "thumbTempFilePath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/String;)V", "getTempFilePath", "()Ljava/lang/String;", "setTempFilePath", "(Ljava/lang/String;)V", "getFileType", "setFileType", "getSize", "()Ljava/lang/Number;", "setSize", "(Ljava/lang/Number;)V", "getByteSize", "setByteSize", "getDuration", "setDuration", "getHeight", "setHeight", "getWidth", "setWidth", "getThumbTempFilePath", "setThumbTempFilePath", "uni-chooseMedia_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ChooseMediaTempFile extends io.dcloud.uts.UTSObject {
    private java.lang.Number byteSize;
    private java.lang.Number duration;

    @io.dcloud.uts.JsonNotNull
    private java.lang.String fileType;
    private java.lang.Number height;

    @io.dcloud.uts.JsonNotNull
    private java.lang.Number size;

    @io.dcloud.uts.JsonNotNull
    private java.lang.String tempFilePath;
    private java.lang.String thumbTempFilePath;
    private java.lang.Number width;

    public /* synthetic */ ChooseMediaTempFile(java.lang.String str, java.lang.String str2, java.lang.Number number, java.lang.Number number2, java.lang.Number number3, java.lang.Number number4, java.lang.Number number5, java.lang.String str3, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, number, (i & 8) != 0 ? null : number2, (i & 16) != 0 ? null : number3, (i & 32) != 0 ? null : number4, (i & 64) != 0 ? null : number5, (i & 128) != 0 ? null : str3);
    }

    public java.lang.String getTempFilePath() {
        return this.tempFilePath;
    }

    public void setTempFilePath(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tempFilePath = str;
    }

    public java.lang.String getFileType() {
        return this.fileType;
    }

    public void setFileType(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fileType = str;
    }

    public java.lang.Number getSize() {
        return this.size;
    }

    public void setSize(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.size = number;
    }

    public java.lang.Number getByteSize() {
        return this.byteSize;
    }

    public void setByteSize(java.lang.Number number) {
        this.byteSize = number;
    }

    public java.lang.Number getDuration() {
        return this.duration;
    }

    public void setDuration(java.lang.Number number) {
        this.duration = number;
    }

    public java.lang.Number getHeight() {
        return this.height;
    }

    public void setHeight(java.lang.Number number) {
        this.height = number;
    }

    public java.lang.Number getWidth() {
        return this.width;
    }

    public void setWidth(java.lang.Number number) {
        this.width = number;
    }

    public java.lang.String getThumbTempFilePath() {
        return this.thumbTempFilePath;
    }

    public void setThumbTempFilePath(java.lang.String str) {
        this.thumbTempFilePath = str;
    }

    public ChooseMediaTempFile(java.lang.String tempFilePath, java.lang.String fileType, java.lang.Number size, java.lang.Number number, java.lang.Number number2, java.lang.Number number3, java.lang.Number number4, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tempFilePath, "tempFilePath");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fileType, "fileType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(size, "size");
        this.tempFilePath = tempFilePath;
        this.fileType = fileType;
        this.size = size;
        this.byteSize = number;
        this.duration = number2;
        this.height = number3;
        this.width = number4;
        this.thumbTempFilePath = str;
    }
}
