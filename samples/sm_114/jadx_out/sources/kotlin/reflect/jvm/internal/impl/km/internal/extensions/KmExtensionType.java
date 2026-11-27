package kotlin.reflect.jvm.internal.impl.km.internal.extensions;

/* JADX INFO: compiled from: ExtensionNodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmExtensionType {
    private final kotlin.reflect.KClass<? extends kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtension> klass;

    public KmExtensionType(kotlin.reflect.KClass<? extends kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtension> klass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(klass, "klass");
        this.klass = klass;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType) && kotlin.jvm.internal.Intrinsics.areEqual(this.klass, ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType) obj).klass);
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public java.lang.String toString() {
        java.lang.String name = kotlin.jvm.JvmClassMappingKt.getJavaClass((kotlin.reflect.KClass) this.klass).getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }
}
