package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaArrayType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaArrayType extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType {
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation> annotations;
    private final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType componentType;
    private final boolean isDeprecatedInJavaDoc;
    private final java.lang.reflect.Type reflectType;

    public ReflectJavaArrayType(java.lang.reflect.Type reflectType) {
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType reflectJavaTypeCreate;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reflectType, "reflectType");
        this.reflectType = reflectType;
        java.lang.reflect.Type reflectType2 = getReflectType();
        if (!(reflectType2 instanceof java.lang.reflect.GenericArrayType)) {
            if (reflectType2 instanceof java.lang.Class) {
                java.lang.Class cls = (java.lang.Class) reflectType2;
                if (cls.isArray()) {
                    kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory factory = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory;
                    java.lang.Class<?> componentType = cls.getComponentType();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(componentType, "getComponentType(...)");
                    reflectJavaTypeCreate = factory.create(componentType);
                }
            }
            throw new java.lang.IllegalArgumentException("Not an array type (" + getReflectType().getClass() + "): " + getReflectType());
        }
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory factory2 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory;
        java.lang.reflect.Type genericComponentType = ((java.lang.reflect.GenericArrayType) reflectType2).getGenericComponentType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(genericComponentType, "getGenericComponentType(...)");
        reflectJavaTypeCreate = factory2.create(genericComponentType);
        this.componentType = reflectJavaTypeCreate;
        this.annotations = kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    protected java.lang.reflect.Type getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    public kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType getComponentType() {
        return this.componentType;
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
