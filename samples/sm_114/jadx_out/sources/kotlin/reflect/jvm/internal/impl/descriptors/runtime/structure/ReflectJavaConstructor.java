package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaConstructor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaConstructor extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor {
    private final java.lang.reflect.Constructor<?> member;

    public ReflectJavaConstructor(java.lang.reflect.Constructor<?> member) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(member, "member");
        this.member = member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public java.lang.reflect.Constructor<?> getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor
    public java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter> getValueParameters() {
        java.lang.reflect.Type[] genericParameterTypes = getMember().getGenericParameterTypes();
        kotlin.jvm.internal.Intrinsics.checkNotNull(genericParameterTypes);
        if (genericParameterTypes.length == 0) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        java.lang.Class<?> declaringClass = getMember().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !java.lang.reflect.Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (java.lang.reflect.Type[]) kotlin.collections.ArraysKt.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
        }
        java.lang.annotation.Annotation[][] parameterAnnotations = getMember().getParameterAnnotations();
        java.lang.annotation.Annotation[][] annotationArr = parameterAnnotations;
        if (annotationArr.length < genericParameterTypes.length) {
            throw new java.lang.IllegalStateException("Illegal generic signature: " + getMember());
        }
        if (annotationArr.length > genericParameterTypes.length) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(parameterAnnotations);
            parameterAnnotations = (java.lang.annotation.Annotation[][]) kotlin.collections.ArraysKt.copyOfRange(annotationArr, annotationArr.length - genericParameterTypes.length, annotationArr.length);
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(genericParameterTypes);
        kotlin.jvm.internal.Intrinsics.checkNotNull(parameterAnnotations);
        return getValueParameters(genericParameterTypes, parameterAnnotations, getMember().isVarArgs());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaTypeParameter> getTypeParameters() {
        java.lang.reflect.TypeVariable<java.lang.reflect.Constructor<?>>[] typeParameters = getMember().getTypeParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
        java.lang.reflect.TypeVariable<java.lang.reflect.Constructor<?>>[] typeVariableArr = typeParameters;
        java.util.ArrayList arrayList = new java.util.ArrayList(typeVariableArr.length);
        for (java.lang.reflect.TypeVariable<java.lang.reflect.Constructor<?>> typeVariable : typeVariableArr) {
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaTypeParameter(typeVariable));
        }
        return arrayList;
    }
}
