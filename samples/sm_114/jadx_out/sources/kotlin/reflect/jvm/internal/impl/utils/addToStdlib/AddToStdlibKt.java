package kotlin.reflect.jvm.internal.impl.utils.addToStdlib;

/* JADX INFO: compiled from: addToStdlib.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddToStdlibKt {
    private static final java.util.concurrent.ConcurrentHashMap<kotlin.jvm.functions.Function0<?>, java.lang.Object> constantMap = new java.util.concurrent.ConcurrentHashMap<>();

    public static /* synthetic */ java.lang.Void shouldNotBeCalled$default(java.lang.String str, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = "should not be called";
        }
        return shouldNotBeCalled(str);
    }

    public static final java.lang.Void shouldNotBeCalled(java.lang.String message) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        throw new java.lang.IllegalStateException(message.toString());
    }
}
