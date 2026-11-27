package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

/* JADX INFO: compiled from: ReflectJavaClassFinder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaClassFinderKt {
    public static final java.lang.Class<?> tryLoadClass(java.lang.ClassLoader classLoader, java.lang.String fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classLoader, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        try {
            return java.lang.Class.forName(fqName, false, classLoader);
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
    }
}
