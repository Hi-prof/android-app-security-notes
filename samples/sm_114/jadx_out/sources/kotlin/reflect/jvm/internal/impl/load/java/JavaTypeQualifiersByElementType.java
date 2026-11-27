package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: JavaTypeQualifiersByElementType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaTypeQualifiersByElementType {
    private final java.util.EnumMap<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> defaultQualifiers;

    public JavaTypeQualifiersByElementType(java.util.EnumMap<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> defaultQualifiers) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(defaultQualifiers, "defaultQualifiers");
        this.defaultQualifiers = defaultQualifiers;
    }

    public final java.util.EnumMap<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> getDefaultQualifiers() {
        return this.defaultQualifiers;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers get(kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return this.defaultQualifiers.get(annotationQualifierApplicabilityType);
    }
}
