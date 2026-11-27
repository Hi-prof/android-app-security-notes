package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UtilsKt {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility toDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.Visibility visibility) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visibility, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility = kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities.toDescriptorVisibility(visibility);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(...)");
        return descriptorVisibility;
    }

    public static final boolean isJspecifyEnabledInStrictMode(kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState javaTypeEnhancementState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        return javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke2(kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) == kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.STRICT;
    }

    public static final boolean hasErasedValueParameters(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor memberDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(memberDescriptor, "memberDescriptor");
        return (memberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) && kotlin.jvm.internal.Intrinsics.areEqual(memberDescriptor.getUserData(kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS), (java.lang.Object) true);
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor extractNullabilityAnnotationOnBoundedWildcard(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType wildcardType) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor next;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(wildcardType, "wildcardType");
        if (wildcardType.getBound() == null) {
            throw new java.lang.IllegalArgumentException("Nullability annotations on unbounded wildcards aren't supported".toString());
        }
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> it = new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations(c, wildcardType, false, 4, null).iterator();
        while (it.hasNext()) {
            next = it.next();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptor = next;
            for (kotlin.reflect.jvm.internal.impl.name.FqName fqName : kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationSettingsKt.getRXJAVA3_ANNOTATIONS()) {
                if (kotlin.jvm.internal.Intrinsics.areEqual(annotationDescriptor.getFqName(), fqName)) {
                    return next;
                }
            }
        }
        next = null;
        return next;
    }
}
