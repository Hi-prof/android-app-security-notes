package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaAnnotationAsAnnotationArgument extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument {
    private final java.lang.annotation.Annotation annotation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaAnnotationAsAnnotationArgument(kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.annotation.Annotation annotation) {
        super(name, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotation, "annotation");
        this.annotation = annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument
    public kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation getAnnotation() {
        return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation(this.annotation);
    }
}
