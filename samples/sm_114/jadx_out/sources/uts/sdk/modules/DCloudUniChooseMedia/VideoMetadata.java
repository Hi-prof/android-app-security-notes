package uts.sdk.modules.DCloudUniChooseMedia;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b \b\u0016\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0005\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\t\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001e\u0010\n\u001a\u00020\b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013¨\u0006("}, d2 = {"Luts/sdk/modules/DCloudUniChooseMedia/VideoMetadata;", "Lio/dcloud/uts/UTSObject;", "duration", "", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "height", "width", "filePath", "", "byteSize", "orientation", "type", tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, "fps", "<init>", "(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;)V", "getDuration", "()Ljava/lang/Number;", "setDuration", "(Ljava/lang/Number;)V", "getSize", "setSize", "getHeight", "setHeight", "getWidth", "setWidth", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "getByteSize", "setByteSize", "getOrientation", "setOrientation", "getType", "setType", "getBitrate", "setBitrate", "getFps", "setFps", "uni-chooseMedia_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class VideoMetadata extends io.dcloud.uts.UTSObject {
    private java.lang.Number bitrate;

    @io.dcloud.uts.JsonNotNull
    private java.lang.Number byteSize;

    @io.dcloud.uts.JsonNotNull
    private java.lang.Number duration;

    @io.dcloud.uts.JsonNotNull
    private java.lang.String filePath;
    private java.lang.Number fps;

    @io.dcloud.uts.JsonNotNull
    private java.lang.Number height;

    @io.dcloud.uts.JsonNotNull
    private java.lang.String orientation;

    @io.dcloud.uts.JsonNotNull
    private java.lang.Number size;
    private java.lang.String type;

    @io.dcloud.uts.JsonNotNull
    private java.lang.Number width;

    public /* synthetic */ VideoMetadata(java.lang.Number number, java.lang.Number number2, java.lang.Number number3, java.lang.Number number4, java.lang.String str, java.lang.Number number5, java.lang.String str2, java.lang.String str3, java.lang.Number number6, java.lang.Number number7, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(number, number2, number3, number4, str, number5, str2, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : number6, (i & 512) != 0 ? null : number7);
    }

    public java.lang.Number getDuration() {
        return this.duration;
    }

    public void setDuration(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.duration = number;
    }

    public java.lang.Number getSize() {
        return this.size;
    }

    public void setSize(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.size = number;
    }

    public java.lang.Number getHeight() {
        return this.height;
    }

    public void setHeight(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.height = number;
    }

    public java.lang.Number getWidth() {
        return this.width;
    }

    public void setWidth(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.width = number;
    }

    public java.lang.String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.filePath = str;
    }

    public java.lang.Number getByteSize() {
        return this.byteSize;
    }

    public void setByteSize(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.byteSize = number;
    }

    public java.lang.String getOrientation() {
        return this.orientation;
    }

    public void setOrientation(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orientation = str;
    }

    public java.lang.String getType() {
        return this.type;
    }

    public void setType(java.lang.String str) {
        this.type = str;
    }

    public java.lang.Number getBitrate() {
        return this.bitrate;
    }

    public void setBitrate(java.lang.Number number) {
        this.bitrate = number;
    }

    public java.lang.Number getFps() {
        return this.fps;
    }

    public void setFps(java.lang.Number number) {
        this.fps = number;
    }

    public VideoMetadata(java.lang.Number duration, java.lang.Number size, java.lang.Number height, java.lang.Number width, java.lang.String filePath, java.lang.Number byteSize, java.lang.String orientation, java.lang.String str, java.lang.Number number, java.lang.Number number2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(duration, "duration");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(size, "size");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(height, "height");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(width, "width");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(filePath, "filePath");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(byteSize, "byteSize");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.duration = duration;
        this.size = size;
        this.height = height;
        this.width = width;
        this.filePath = filePath;
        this.byteSize = byteSize;
        this.orientation = orientation;
        this.type = str;
        this.bitrate = number;
        this.fps = number2;
    }
}
