package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaPrimitiveType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaPrimitiveType extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType {
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation> annotations;
    private final boolean isDeprecatedInJavaDoc;
    private final java.lang.Class<?> reflectType;

    public ReflectJavaPrimitiveType(java.lang.Class<?> reflectType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reflectType, "reflectType");
        this.reflectType = reflectType;
        this.annotations = kotlin.collections.CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public java.lang.Class<?> getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType
    public kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType getType() {
        if (kotlin.jvm.internal.Intrinsics.areEqual(getReflectType(), java.lang.Void.TYPE)) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.get(getReflectType().getName()).getPrimitiveType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }
}
