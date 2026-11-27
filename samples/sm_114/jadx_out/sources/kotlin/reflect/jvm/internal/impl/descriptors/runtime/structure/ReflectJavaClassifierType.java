package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaClassifierType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaClassifierType extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType {
    private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier classifier;
    private final java.lang.reflect.Type reflectType;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation findAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public ReflectJavaClassifierType(java.lang.reflect.Type reflectType) {
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass reflectJavaClass;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reflectType, "reflectType");
        this.reflectType = reflectType;
        java.lang.reflect.Type reflectType2 = getReflectType();
        if (reflectType2 instanceof java.lang.Class) {
            reflectJavaClass = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass((java.lang.Class) reflectType2);
        } else if (reflectType2 instanceof java.lang.reflect.TypeVariable) {
            reflectJavaClass = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaTypeParameter((java.lang.reflect.TypeVariable) reflectType2);
        } else {
            if (!(reflectType2 instanceof java.lang.reflect.ParameterizedType)) {
                throw new java.lang.IllegalStateException("Not a classifier type (" + reflectType2.getClass() + "): " + reflectType2);
            }
            java.lang.reflect.Type rawType = ((java.lang.reflect.ParameterizedType) reflectType2).getRawType();
            kotlin.jvm.internal.Intrinsics.checkNotNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            reflectJavaClass = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass((java.lang.Class) rawType);
        }
        this.classifier = reflectJavaClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public java.lang.reflect.Type getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public java.lang.String getClassifierQualifiedName() {
        throw new java.lang.UnsupportedOperationException("Type not found: " + getReflectType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public java.lang.String getPresentableText() {
        return getReflectType().toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public boolean isRaw() {
        java.lang.reflect.Type reflectType = getReflectType();
        if (reflectType instanceof java.lang.Class) {
            java.lang.reflect.TypeVariable[] typeParameters = ((java.lang.Class) reflectType).getTypeParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            if (!(typeParameters.length == 0)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType> getTypeArguments() {
        java.util.List<java.lang.reflect.Type> parameterizedTypeArguments = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getParameterizedTypeArguments(getReflectType());
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory factory = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(parameterizedTypeArguments, 10));
        java.util.Iterator<T> it = parameterizedTypeArguments.iterator();
        while (it.hasNext()) {
            arrayList.add(factory.create((java.lang.reflect.Type) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation> getAnnotations() {
        return kotlin.collections.CollectionsKt.emptyList();
    }
}
