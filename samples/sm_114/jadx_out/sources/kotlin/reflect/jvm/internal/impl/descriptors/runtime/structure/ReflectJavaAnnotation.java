package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaAnnotation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaAnnotation extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation {
    private final java.lang.annotation.Annotation annotation;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public boolean isFreshlySupportedTypeUseAnnotation() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public boolean isIdeExternalAnnotation() {
        return false;
    }

    public ReflectJavaAnnotation(java.lang.annotation.Annotation annotation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotation, "annotation");
        this.annotation = annotation;
    }

    public final java.lang.annotation.Annotation getAnnotation() {
        return this.annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument> getArguments() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Method[] declaredMethods = kotlin.jvm.JvmClassMappingKt.getJavaClass(kotlin.jvm.JvmClassMappingKt.getAnnotationClass(this.annotation)).getDeclaredMethods();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        java.lang.reflect.Method[] methodArr = declaredMethods;
        java.util.ArrayList arrayList = new java.util.ArrayList(methodArr.length);
        for (java.lang.reflect.Method method : methodArr) {
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument.Factory factory = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument.Factory;
            java.lang.Object objInvoke = method.invoke(this.annotation, null);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objInvoke, "invoke(...)");
            arrayList.add(factory.create(objInvoke, kotlin.reflect.jvm.internal.impl.name.Name.identifier(method.getName())));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public kotlin.reflect.jvm.internal.impl.name.ClassId getClassId() {
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getClassId(kotlin.jvm.JvmClassMappingKt.getJavaClass(kotlin.jvm.JvmClassMappingKt.getAnnotationClass(this.annotation)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation
    public kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass resolve() {
        return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass(kotlin.jvm.JvmClassMappingKt.getJavaClass(kotlin.jvm.JvmClassMappingKt.getAnnotationClass(this.annotation)));
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation) && this.annotation == ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation) obj).annotation;
    }

    public int hashCode() {
        return java.lang.System.identityHashCode(this.annotation);
    }

    public java.lang.String toString() {
        return getClass().getName() + ": " + this.annotation;
    }
}
