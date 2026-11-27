package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ReflectJavaAnnotationOwner extends kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner {
    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation findAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName fqName);

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation> getAnnotations();

    java.lang.reflect.AnnotatedElement getElement();
}
