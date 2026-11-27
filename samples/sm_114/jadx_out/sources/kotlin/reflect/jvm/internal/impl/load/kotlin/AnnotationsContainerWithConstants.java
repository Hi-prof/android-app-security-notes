package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnnotationsContainerWithConstants<A, C> extends kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.AnnotationsContainer<A> {
    private final java.util.Map<kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, C> annotationParametersDefaultValues;
    private final java.util.Map<kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, java.util.List<A>> memberAnnotations;
    private final java.util.Map<kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, C> propertyConstants;

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.AnnotationsContainer
    public java.util.Map<kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, java.util.List<A>> getMemberAnnotations() {
        return this.memberAnnotations;
    }

    public final java.util.Map<kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, C> getPropertyConstants() {
        return this.propertyConstants;
    }

    public final java.util.Map<kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, C> getAnnotationParametersDefaultValues() {
        return this.annotationParametersDefaultValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotationsContainerWithConstants(java.util.Map<kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, ? extends java.util.List<? extends A>> memberAnnotations, java.util.Map<kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, ? extends C> propertyConstants, java.util.Map<kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, ? extends C> annotationParametersDefaultValues) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(memberAnnotations, "memberAnnotations");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyConstants, "propertyConstants");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationParametersDefaultValues, "annotationParametersDefaultValues");
        this.memberAnnotations = memberAnnotations;
        this.propertyConstants = propertyConstants;
        this.annotationParametersDefaultValues = annotationParametersDefaultValues;
    }
}
