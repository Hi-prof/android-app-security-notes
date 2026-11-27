package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: JavaDefaultQualifiers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaDefaultQualifiersKt {
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> APPLICABILITY_OF_JAVAX_DEFAULTS;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> APPLICABILITY_OF_JSPECIFY_DEFAULTS;
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS;
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> JAVAX_DEFAULT_ANNOTATIONS;
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> JSPECIFY_DEFAULT_ANNOTATIONS;

    static {
        java.util.List<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> listListOf = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType[]{kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.FIELD, kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.VALUE_PARAMETER, kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_USE});
        APPLICABILITY_OF_JSPECIFY_DEFAULTS = listListOf;
        java.util.List<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> listListOf2 = kotlin.collections.CollectionsKt.listOf(kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.VALUE_PARAMETER);
        APPLICABILITY_OF_JAVAX_DEFAULTS = listListOf2;
        java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> mapMapOf = kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getJSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME(), new kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL, false, 2, null), listListOf, false)), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getJSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME(), new kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL, false, 2, null), listListOf, false)), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getJSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME(), new kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null), listListOf, false, 4, null)));
        JSPECIFY_DEFAULT_ANNOTATIONS = mapMapOf;
        java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> mapMapOf2 = kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getJAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME(), new kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL, false, 2, null), listListOf2, false, 4, null)), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getJAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME(), new kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE, false, 2, null), listListOf2, false, 4, null)));
        JAVAX_DEFAULT_ANNOTATIONS = mapMapOf2;
        BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS = kotlin.collections.MapsKt.plus(mapMapOf, mapMapOf2);
    }

    public static final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> getJSPECIFY_DEFAULT_ANNOTATIONS() {
        return JSPECIFY_DEFAULT_ANNOTATIONS;
    }

    public static final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS() {
        return BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS;
    }
}
