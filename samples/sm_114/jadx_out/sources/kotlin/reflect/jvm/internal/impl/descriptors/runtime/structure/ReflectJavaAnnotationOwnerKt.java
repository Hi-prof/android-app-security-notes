package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaAnnotationOwnerKt {
    public static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation> getAnnotations(java.lang.annotation.Annotation[] annotationArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationArr, "<this>");
        java.util.ArrayList arrayList = new java.util.ArrayList(annotationArr.length);
        for (java.lang.annotation.Annotation annotation : annotationArr) {
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation(annotation));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002e  */
    /* JADX WARN: Code duplicated, block: B:13:0x0034 A[RETURN] */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation findAnnotation(java.lang.annotation.Annotation[] annotationArr, kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationArr, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        for (java.lang.annotation.Annotation annotation : annotationArr) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getClassId(kotlin.jvm.JvmClassMappingKt.getJavaClass(kotlin.jvm.JvmClassMappingKt.getAnnotationClass(annotation))).asSingleFqName(), fqName)) {
                if (annotation != null) {
                    return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation(annotation);
                }
                return null;
            }
        }
        annotation = null;
        if (annotation != null) {
            return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation(annotation);
        }
        return null;
    }
}
