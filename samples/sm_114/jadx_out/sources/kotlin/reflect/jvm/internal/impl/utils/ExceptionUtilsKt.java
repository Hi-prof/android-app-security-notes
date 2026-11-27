package kotlin.reflect.jvm.internal.impl.utils;

/* JADX INFO: compiled from: exceptionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExceptionUtilsKt {
    public static final java.lang.RuntimeException rethrow(java.lang.Throwable e) throws java.lang.Throwable {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(e, "e");
        throw e;
    }

    public static final boolean isProcessCanceledException(java.lang.Throwable th) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(th, "<this>");
        java.lang.Class<?> superclass = th.getClass();
        while (!kotlin.jvm.internal.Intrinsics.areEqual(superclass.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return false;
            }
        }
        return true;
    }
}
