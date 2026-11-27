package kotlin.reflect.jvm.internal.impl.load.java.components;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaAnnotationMapper {
    private static final kotlin.reflect.jvm.internal.impl.name.Name DEPRECATED_ANNOTATION_MESSAGE;
    public static final kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper INSTANCE = new kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper();
    private static final kotlin.reflect.jvm.internal.impl.name.Name RETENTION_ANNOTATION_VALUE;
    private static final kotlin.reflect.jvm.internal.impl.name.Name TARGET_ANNOTATION_ALLOWED_TARGETS;
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.name.FqName> kotlinToJavaNameMap;

    private JavaAnnotationMapper() {
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier("message");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        DEPRECATED_ANNOTATION_MESSAGE = nameIdentifier;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier2 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("allowedTargets");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier2, "identifier(...)");
        TARGET_ANNOTATION_ALLOWED_TARGETS = nameIdentifier2;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier3 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("value");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier3, "identifier(...)");
        RETENTION_ANNOTATION_VALUE = nameIdentifier3;
        kotlinToJavaNameMap = kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.target, kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.TARGET_ANNOTATION), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.retention, kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.RETENTION_ANNOTATION), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.mustBeDocumented, kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.DOCUMENTED_ANNOTATION));
    }

    public final kotlin.reflect.jvm.internal.impl.name.Name getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm() {
        return DEPRECATED_ANNOTATION_MESSAGE;
    }

    public final kotlin.reflect.jvm.internal.impl.name.Name getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm() {
        return TARGET_ANNOTATION_ALLOWED_TARGETS;
    }

    public final kotlin.reflect.jvm.internal.impl.name.Name getRETENTION_ANNOTATION_VALUE$descriptors_jvm() {
        return RETENTION_ANNOTATION_VALUE;
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor mapOrResolveJavaAnnotation$default(kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper javaAnnotationMapper, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation javaAnnotation, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, boolean z, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return javaAnnotationMapper.mapOrResolveJavaAnnotation(javaAnnotation, lazyJavaResolverContext, z);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor mapOrResolveJavaAnnotation(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation annotation, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotation, "annotation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = annotation.getClassId();
        kotlin.reflect.jvm.internal.impl.name.ClassId.Companion companion = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion;
        kotlin.reflect.jvm.internal.impl.name.FqName TARGET_ANNOTATION = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.TARGET_ANNOTATION;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(TARGET_ANNOTATION, "TARGET_ANNOTATION");
        if (kotlin.jvm.internal.Intrinsics.areEqual(classId, companion.topLevel(TARGET_ANNOTATION))) {
            return new kotlin.reflect.jvm.internal.impl.load.java.components.JavaTargetAnnotationDescriptor(annotation, c);
        }
        kotlin.reflect.jvm.internal.impl.name.ClassId.Companion companion2 = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion;
        kotlin.reflect.jvm.internal.impl.name.FqName RETENTION_ANNOTATION = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.RETENTION_ANNOTATION;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(RETENTION_ANNOTATION, "RETENTION_ANNOTATION");
        if (kotlin.jvm.internal.Intrinsics.areEqual(classId, companion2.topLevel(RETENTION_ANNOTATION))) {
            return new kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor(annotation, c);
        }
        kotlin.reflect.jvm.internal.impl.name.ClassId.Companion companion3 = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion;
        kotlin.reflect.jvm.internal.impl.name.FqName DOCUMENTED_ANNOTATION = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.DOCUMENTED_ANNOTATION;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(DOCUMENTED_ANNOTATION, "DOCUMENTED_ANNOTATION");
        if (kotlin.jvm.internal.Intrinsics.areEqual(classId, companion3.topLevel(DOCUMENTED_ANNOTATION))) {
            return new kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor(c, annotation, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.mustBeDocumented);
        }
        kotlin.reflect.jvm.internal.impl.name.ClassId.Companion companion4 = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion;
        kotlin.reflect.jvm.internal.impl.name.FqName DEPRECATED_ANNOTATION = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.DEPRECATED_ANNOTATION;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(DEPRECATED_ANNOTATION, "DEPRECATED_ANNOTATION");
        if (kotlin.jvm.internal.Intrinsics.areEqual(classId, companion4.topLevel(DEPRECATED_ANNOTATION))) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor(c, annotation, z);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor findMappedJavaAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName kotlinName, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner annotationOwner, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c) {
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation javaAnnotationFindAnnotation;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinName, "kotlinName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationOwner, "annotationOwner");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        if (kotlin.jvm.internal.Intrinsics.areEqual(kotlinName, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.deprecated)) {
            kotlin.reflect.jvm.internal.impl.name.FqName DEPRECATED_ANNOTATION = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.DEPRECATED_ANNOTATION;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(DEPRECATED_ANNOTATION, "DEPRECATED_ANNOTATION");
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation javaAnnotationFindAnnotation2 = annotationOwner.findAnnotation(DEPRECATED_ANNOTATION);
            if (javaAnnotationFindAnnotation2 != null || annotationOwner.isDeprecatedInJavaDoc()) {
                return new kotlin.reflect.jvm.internal.impl.load.java.components.JavaDeprecatedAnnotationDescriptor(javaAnnotationFindAnnotation2, c);
            }
        }
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = kotlinToJavaNameMap.get(kotlinName);
        if (fqName == null || (javaAnnotationFindAnnotation = annotationOwner.findAnnotation(fqName)) == null) {
            return null;
        }
        return mapOrResolveJavaAnnotation$default(INSTANCE, javaAnnotationFindAnnotation, c, false, 4, null);
    }
}
