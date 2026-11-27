package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
public enum GifError {
    NO_ERROR(0, "No error"),
    OPEN_FAILED(101, "Failed to open given input"),
    READ_FAILED(102, "Failed to read from given input"),
    NOT_GIF_FILE(103, "Data is not in GIF format"),
    NO_SCRN_DSCR(androidx.core.location.LocationRequestCompat.QUALITY_LOW_POWER, "No screen descriptor detected"),
    NO_IMAG_DSCR(105, "No image descriptor detected"),
    NO_COLOR_MAP(106, "Neither global nor local color map found"),
    WRONG_RECORD(107, "Wrong record type detected"),
    DATA_TOO_BIG(androidx.appcompat.app.AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, "Number of pixels bigger than width * height"),
    NOT_ENOUGH_MEM(androidx.appcompat.app.AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, "Failed to allocate required memory"),
    CLOSE_FAILED(tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_10, "Failed to close given input"),
    NOT_READABLE(111, "Given file was not opened for read"),
    IMAGE_DEFECT(112, "Image is defective, decoding aborted"),
    EOF_TOO_SOON(113, "Image EOF detected before image complete"),
    NO_FRAMES(1000, "No frames found, at least one frame required"),
    INVALID_SCR_DIMS(1001, "Invalid screen size, dimensions must be positive"),
    INVALID_IMG_DIMS(1002, "Invalid image size, dimensions must be positive"),
    IMG_NOT_CONFINED(1003, "Image size exceeds screen size"),
    REWIND_FAILED(1004, "Input source rewind failed, animation stopped"),
    INVALID_BYTE_BUFFER(io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.CODE_DECODE_portrait, "Invalid and/or indirect byte buffer specified"),
    UNKNOWN(-1, "Unknown error");

    public final java.lang.String description;
    int errorCode;

    GifError(int i, java.lang.String str) {
        this.errorCode = i;
        this.description = str;
    }

    static pl.droidsonroids.gif.GifError fromCode(int i) {
        for (pl.droidsonroids.gif.GifError gifError : values()) {
            if (gifError.errorCode == i) {
                return gifError;
            }
        }
        pl.droidsonroids.gif.GifError gifError2 = UNKNOWN;
        gifError2.errorCode = i;
        return gifError2;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    java.lang.String getFormattedDescription() {
        return java.lang.String.format(java.util.Locale.ENGLISH, "GifError %d: %s", java.lang.Integer.valueOf(this.errorCode), this.description);
    }
}
