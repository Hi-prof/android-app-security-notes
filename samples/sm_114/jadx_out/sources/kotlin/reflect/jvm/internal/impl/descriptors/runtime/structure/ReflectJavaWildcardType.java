package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaWildcardType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaWildcardType extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType {
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation> annotations;
    private final boolean isDeprecatedInJavaDoc;
    private final java.lang.reflect.WildcardType reflectType;

    public ReflectJavaWildcardType(java.lang.reflect.WildcardType reflectType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reflectType, "reflectType");
        this.reflectType = reflectType;
        this.annotations = kotlin.collections.CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public java.lang.reflect.WildcardType getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType getBound() {
        java.lang.reflect.Type[] upperBounds = getReflectType().getUpperBounds();
        java.lang.reflect.Type[] lowerBounds = getReflectType().getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new java.lang.UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + getReflectType());
        }
        if (lowerBounds.length == 1) {
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory factory = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory;
            kotlin.jvm.internal.Intrinsics.checkNotNull(lowerBounds);
            java.lang.Object objSingle = kotlin.collections.ArraysKt.single(lowerBounds);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objSingle, "single(...)");
            return factory.create((java.lang.reflect.Type) objSingle);
        }
        if (upperBounds.length == 1) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(upperBounds);
            java.lang.reflect.Type type = (java.lang.reflect.Type) kotlin.collections.ArraysKt.single(upperBounds);
            if (!kotlin.jvm.internal.Intrinsics.areEqual(type, java.lang.Object.class)) {
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory factory2 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory;
                kotlin.jvm.internal.Intrinsics.checkNotNull(type);
                return factory2.create(type);
            }
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public boolean isExtends() {
        java.lang.reflect.Type[] upperBounds = getReflectType().getUpperBounds();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
        return !kotlin.jvm.internal.Intrinsics.areEqual(kotlin.collections.ArraysKt.firstOrNull(upperBounds), java.lang.Object.class);
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
