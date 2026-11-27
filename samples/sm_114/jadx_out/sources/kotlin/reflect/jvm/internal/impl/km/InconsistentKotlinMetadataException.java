package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: InconsistentKotlinMetadataException.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InconsistentKotlinMetadataException extends java.lang.IllegalArgumentException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InconsistentKotlinMetadataException(java.lang.String message, java.lang.Throwable th) {
        super(message, th);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
    }

    public /* synthetic */ InconsistentKotlinMetadataException(java.lang.String str, java.lang.Throwable th, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }
}
