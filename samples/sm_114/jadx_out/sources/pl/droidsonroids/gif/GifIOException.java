package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
public class GifIOException extends java.io.IOException {
    private static final long serialVersionUID = 13038402904505L;
    private final java.lang.String mErrnoMessage;
    public final pl.droidsonroids.gif.GifError reason;

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        if (this.mErrnoMessage == null) {
            return this.reason.getFormattedDescription();
        }
        return this.reason.getFormattedDescription() + ": " + this.mErrnoMessage;
    }

    GifIOException(int i, java.lang.String str) {
        this.reason = pl.droidsonroids.gif.GifError.fromCode(i);
        this.mErrnoMessage = str;
    }

    static pl.droidsonroids.gif.GifIOException fromCode(int i) {
        if (i == pl.droidsonroids.gif.GifError.NO_ERROR.errorCode) {
            return null;
        }
        return new pl.droidsonroids.gif.GifIOException(i, null);
    }
}
