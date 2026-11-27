package io.dcloud.uts;

/* JADX INFO: compiled from: UTSPromise.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0001X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lio/dcloud/uts/UTSPromiseAggregateError;", "", "errors", "message", "", "<init>", "(Ljava/lang/Object;Ljava/lang/String;)V", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getErrors", "()Ljava/lang/Object;", "setErrors", "(Ljava/lang/Object;)V", "getMessage", "setMessage", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class UTSPromiseAggregateError {
    private java.lang.Object errors;
    private java.lang.String message;
    private java.lang.String name;

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public java.lang.Object getErrors() {
        return this.errors;
    }

    public void setErrors(java.lang.Object obj) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.errors = obj;
    }

    public java.lang.String getMessage() {
        return this.message;
    }

    public void setMessage(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public UTSPromiseAggregateError(java.lang.Object errors, java.lang.String message) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errors, "errors");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        this.name = "AggregateError";
        this.errors = "";
        this.message = "";
        setErrors(errors);
        setMessage(message);
    }

    public /* synthetic */ UTSPromiseAggregateError(java.lang.Object obj, java.lang.String str, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? "" : str);
    }
}
