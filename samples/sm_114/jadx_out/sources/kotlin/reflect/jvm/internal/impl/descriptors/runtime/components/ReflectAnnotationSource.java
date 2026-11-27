package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

/* JADX INFO: compiled from: ReflectAnnotationSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectAnnotationSource implements kotlin.reflect.jvm.internal.impl.descriptors.SourceElement {
    private final java.lang.annotation.Annotation annotation;

    public ReflectAnnotationSource(java.lang.annotation.Annotation annotation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotation, "annotation");
        this.annotation = annotation;
    }

    public final java.lang.annotation.Annotation getAnnotation() {
        return this.annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public kotlin.reflect.jvm.internal.impl.descriptors.SourceFile getContainingFile() {
        kotlin.reflect.jvm.internal.impl.descriptors.SourceFile NO_SOURCE_FILE = kotlin.reflect.jvm.internal.impl.descriptors.SourceFile.NO_SOURCE_FILE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }
}
