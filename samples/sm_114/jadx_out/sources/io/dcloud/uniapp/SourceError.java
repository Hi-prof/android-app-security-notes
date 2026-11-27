package io.dcloud.uniapp;

/* JADX INFO: compiled from: UniError.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0002\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/dcloud/uniapp/SourceError;", "Lio/dcloud/uts/UTSError;", "<init>", "()V", "message", "", "(Ljava/lang/String;)V", "options", "Lio/dcloud/uts/UTSJSONObject;", "(Ljava/lang/String;Lio/dcloud/uts/UTSJSONObject;)V", "subject", "getSubject", "()Ljava/lang/String;", "setSubject", "code", "", "getCode", "()Ljava/lang/Number;", "setCode", "(Ljava/lang/Number;)V", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class SourceError extends io.dcloud.uts.UTSError {
    private java.lang.Number code;
    private java.lang.String subject;

    public SourceError() {
        this.code = (java.lang.Number) 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SourceError(java.lang.String message) {
        this();
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        setMessage(message);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SourceError(java.lang.String message, io.dcloud.uts.UTSJSONObject options) {
        this();
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        setMessage(message);
        java.lang.Object obj = options.get("cause");
        if (obj == null || !(obj instanceof io.dcloud.uts.UTSError)) {
            return;
        }
        setCause((io.dcloud.uts.UTSError) obj);
    }

    public final java.lang.String getSubject() {
        return this.subject;
    }

    public final void setSubject(java.lang.String str) {
        this.subject = str;
    }

    public final java.lang.Number getCode() {
        return this.code;
    }

    public final void setCode(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.code = number;
    }
}
