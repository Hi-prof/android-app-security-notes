package kotlin.reflect.jvm.internal.impl;

/* JADX INFO: compiled from: SpecialJvmAnnotations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpecialJvmAnnotations {
    public static final kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations INSTANCE = new kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations();
    private static final kotlin.reflect.jvm.internal.impl.name.ClassId JAVA_LANG_ANNOTATION_REPEATABLE;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.ClassId> SPECIAL_ANNOTATIONS;

    private SpecialJvmAnnotations() {
    }

    public final java.util.Set<kotlin.reflect.jvm.internal.impl.name.ClassId> getSPECIAL_ANNOTATIONS() {
        return SPECIAL_ANNOTATIONS;
    }

    static {
        java.util.List listListOf = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.name.FqName[]{kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.METADATA_FQ_NAME, kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.TARGET_ANNOTATION, kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.RETENTION_ANNOTATION, kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.DOCUMENTED_ANNOTATION});
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        kotlin.reflect.jvm.internal.impl.name.ClassId.Companion companion = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion;
        java.util.Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(companion.topLevel((kotlin.reflect.jvm.internal.impl.name.FqName) it.next()));
        }
        SPECIAL_ANNOTATIONS = linkedHashSet;
        kotlin.reflect.jvm.internal.impl.name.ClassId.Companion companion2 = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion;
        kotlin.reflect.jvm.internal.impl.name.FqName REPEATABLE_ANNOTATION = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.REPEATABLE_ANNOTATION;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(REPEATABLE_ANNOTATION, "REPEATABLE_ANNOTATION");
        JAVA_LANG_ANNOTATION_REPEATABLE = companion2.topLevel(REPEATABLE_ANNOTATION);
    }

    public final kotlin.reflect.jvm.internal.impl.name.ClassId getJAVA_LANG_ANNOTATION_REPEATABLE() {
        return JAVA_LANG_ANNOTATION_REPEATABLE;
    }

    public final boolean isAnnotatedWithContainerMetaAnnotation(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass klass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(klass, "klass");
        final kotlin.jvm.internal.Ref.BooleanRef booleanRef = new kotlin.jvm.internal.Ref.BooleanRef();
        klass.loadClassAnnotations(new kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor() { // from class: kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations.isAnnotatedWithContainerMetaAnnotation.1
            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
            public void visitEnd() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
            public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
                if (!kotlin.jvm.internal.Intrinsics.areEqual(classId, kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.INSTANCE.getREPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION())) {
                    return null;
                }
                booleanRef.element = true;
                return null;
            }
        }, null);
        return booleanRef.element;
    }
}
