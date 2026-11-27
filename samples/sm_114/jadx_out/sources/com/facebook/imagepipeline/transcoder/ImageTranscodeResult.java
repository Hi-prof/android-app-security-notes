package com.facebook.imagepipeline.transcoder;

/* JADX INFO: compiled from: ImageTranscodeResult.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/facebook/imagepipeline/transcoder/ImageTranscodeResult;", "", "transcodeStatus", "", "<init>", "(I)V", "getTranscodeStatus", "()I", "toString", "", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImageTranscodeResult {
    private final int transcodeStatus;

    public ImageTranscodeResult(int i) {
        this.transcodeStatus = i;
    }

    public final int getTranscodeStatus() {
        return this.transcodeStatus;
    }

    public java.lang.String toString() {
        kotlin.jvm.internal.StringCompanionObject stringCompanionObject = kotlin.jvm.internal.StringCompanionObject.INSTANCE;
        java.lang.String str = java.lang.String.format(null, "Status: %d", java.util.Arrays.copyOf(new java.lang.Object[]{java.lang.Integer.valueOf(this.transcodeStatus)}, 1));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
