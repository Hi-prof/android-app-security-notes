package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: JvmAnnotationNames.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmAnnotationNamesKt {
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> BUILT_IN_TYPE_QUALIFIER_ANNOTATIONS;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> FORCE_FLEXIBILITY_ANNOTATIONS;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JAVAX_CHECK_FOR_NULL_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JAVAX_NONNULL_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JAVAX_NULLABLE_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JSPECIFY_NON_NULL_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JSPECIFY_NULLABLE_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JSPECIFY_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JSPECIFY_OLD_NULLABLE_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JSPECIFY_OLD_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> MUTABLE_ANNOTATIONS;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> NOT_NULL_ANNOTATIONS;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> NULLABILITY_ANNOTATIONS;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> NULLABLE_ANNOTATIONS;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> READ_ONLY_ANNOTATIONS;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName UNDER_MIGRATION_ANNOTATION_FQ_NAME;
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.name.FqName> javaToKotlinNameMap;

    static {
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = new kotlin.reflect.jvm.internal.impl.name.FqName("org.jspecify.nullness.Nullable");
        JSPECIFY_OLD_NULLABLE_ANNOTATION_FQ_NAME = fqName;
        kotlin.reflect.jvm.internal.impl.name.FqName fqName2 = new kotlin.reflect.jvm.internal.impl.name.FqName("org.jspecify.nullness.NullMarked");
        JSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME = fqName2;
        kotlin.reflect.jvm.internal.impl.name.FqName fqName3 = new kotlin.reflect.jvm.internal.impl.name.FqName("org.jspecify.nullness.NullnessUnspecified");
        JSPECIFY_OLD_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME = fqName3;
        kotlin.reflect.jvm.internal.impl.name.FqName fqName4 = new kotlin.reflect.jvm.internal.impl.name.FqName("org.jspecify.annotations.NonNull");
        JSPECIFY_NON_NULL_ANNOTATION_FQ_NAME = fqName4;
        kotlin.reflect.jvm.internal.impl.name.FqName fqName5 = new kotlin.reflect.jvm.internal.impl.name.FqName("org.jspecify.annotations.Nullable");
        JSPECIFY_NULLABLE_ANNOTATION_FQ_NAME = fqName5;
        kotlin.reflect.jvm.internal.impl.name.FqName fqName6 = new kotlin.reflect.jvm.internal.impl.name.FqName("org.jspecify.annotations.NullMarked");
        JSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME = fqName6;
        kotlin.reflect.jvm.internal.impl.name.FqName fqName7 = new kotlin.reflect.jvm.internal.impl.name.FqName("org.jspecify.annotations.NullnessUnspecified");
        JSPECIFY_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME = fqName7;
        kotlin.reflect.jvm.internal.impl.name.FqName fqName8 = new kotlin.reflect.jvm.internal.impl.name.FqName("org.jspecify.annotations.NullUnmarked");
        JSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME = fqName8;
        JAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME = new kotlin.reflect.jvm.internal.impl.name.FqName("javax.annotation.meta.TypeQualifier");
        JAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME = new kotlin.reflect.jvm.internal.impl.name.FqName("javax.annotation.meta.TypeQualifierNickname");
        JAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME = new kotlin.reflect.jvm.internal.impl.name.FqName("javax.annotation.meta.TypeQualifierDefault");
        kotlin.reflect.jvm.internal.impl.name.FqName fqName9 = new kotlin.reflect.jvm.internal.impl.name.FqName("javax.annotation.Nonnull");
        JAVAX_NONNULL_ANNOTATION_FQ_NAME = fqName9;
        kotlin.reflect.jvm.internal.impl.name.FqName fqName10 = new kotlin.reflect.jvm.internal.impl.name.FqName("javax.annotation.Nullable");
        JAVAX_NULLABLE_ANNOTATION_FQ_NAME = fqName10;
        kotlin.reflect.jvm.internal.impl.name.FqName fqName11 = new kotlin.reflect.jvm.internal.impl.name.FqName("javax.annotation.CheckForNull");
        JAVAX_CHECK_FOR_NULL_ANNOTATION_FQ_NAME = fqName11;
        JAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME = new kotlin.reflect.jvm.internal.impl.name.FqName("javax.annotation.ParametersAreNonnullByDefault");
        JAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME = new kotlin.reflect.jvm.internal.impl.name.FqName("javax.annotation.ParametersAreNullableByDefault");
        BUILT_IN_TYPE_QUALIFIER_ANNOTATIONS = kotlin.collections.SetsKt.setOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.name.FqName[]{fqName9, fqName11});
        java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> of = kotlin.collections.SetsKt.setOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.name.FqName[]{kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, fqName4, new kotlin.reflect.jvm.internal.impl.name.FqName("android.annotation.NonNull"), new kotlin.reflect.jvm.internal.impl.name.FqName("androidx.annotation.NonNull"), new kotlin.reflect.jvm.internal.impl.name.FqName("androidx.annotation.RecentlyNonNull"), new kotlin.reflect.jvm.internal.impl.name.FqName("androidx.annotation.NonNull"), new kotlin.reflect.jvm.internal.impl.name.FqName("com.android.annotations.NonNull"), new kotlin.reflect.jvm.internal.impl.name.FqName("org.checkerframework.checker.nullness.compatqual.NonNullDecl"), new kotlin.reflect.jvm.internal.impl.name.FqName("org.checkerframework.checker.nullness.qual.NonNull"), new kotlin.reflect.jvm.internal.impl.name.FqName("edu.umd.cs.findbugs.annotations.NonNull"), new kotlin.reflect.jvm.internal.impl.name.FqName("io.reactivex.annotations.NonNull"), new kotlin.reflect.jvm.internal.impl.name.FqName("io.reactivex.rxjava3.annotations.NonNull"), new kotlin.reflect.jvm.internal.impl.name.FqName("org.eclipse.jdt.annotation.NonNull"), new kotlin.reflect.jvm.internal.impl.name.FqName("lombok.NonNull"), new kotlin.reflect.jvm.internal.impl.name.FqName("jakarta.annotation.Nonnull")});
        NOT_NULL_ANNOTATIONS = of;
        java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> of2 = kotlin.collections.SetsKt.setOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.name.FqName[]{kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, fqName, fqName5, fqName10, fqName11, new kotlin.reflect.jvm.internal.impl.name.FqName("android.annotation.Nullable"), new kotlin.reflect.jvm.internal.impl.name.FqName("androidx.annotation.Nullable"), new kotlin.reflect.jvm.internal.impl.name.FqName("androidx.annotation.RecentlyNullable"), new kotlin.reflect.jvm.internal.impl.name.FqName("androidx.annotation.Nullable"), new kotlin.reflect.jvm.internal.impl.name.FqName("com.android.annotations.Nullable"), new kotlin.reflect.jvm.internal.impl.name.FqName("org.checkerframework.checker.nullness.compatqual.NullableDecl"), new kotlin.reflect.jvm.internal.impl.name.FqName("org.checkerframework.checker.nullness.qual.Nullable"), new kotlin.reflect.jvm.internal.impl.name.FqName("edu.umd.cs.findbugs.annotations.Nullable"), new kotlin.reflect.jvm.internal.impl.name.FqName("edu.umd.cs.findbugs.annotations.PossiblyNull"), new kotlin.reflect.jvm.internal.impl.name.FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new kotlin.reflect.jvm.internal.impl.name.FqName("io.reactivex.annotations.Nullable"), new kotlin.reflect.jvm.internal.impl.name.FqName("io.reactivex.rxjava3.annotations.Nullable"), new kotlin.reflect.jvm.internal.impl.name.FqName("org.eclipse.jdt.annotation.Nullable"), new kotlin.reflect.jvm.internal.impl.name.FqName("jakarta.annotation.Nullable")});
        NULLABLE_ANNOTATIONS = of2;
        FORCE_FLEXIBILITY_ANNOTATIONS = kotlin.collections.SetsKt.setOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.name.FqName[]{fqName3, fqName7});
        NULLABILITY_ANNOTATIONS = kotlin.collections.SetsKt.plus((java.util.Set<? extends kotlin.reflect.jvm.internal.impl.name.FqName>) kotlin.collections.SetsKt.plus((java.util.Set<? extends kotlin.reflect.jvm.internal.impl.name.FqName>) kotlin.collections.SetsKt.plus((java.util.Set<? extends kotlin.reflect.jvm.internal.impl.name.FqName>) kotlin.collections.SetsKt.plus((java.util.Set<? extends kotlin.reflect.jvm.internal.impl.name.FqName>) kotlin.collections.SetsKt.plus(kotlin.collections.SetsKt.plus((java.util.Set) new java.util.LinkedHashSet(), (java.lang.Iterable) of), (java.lang.Iterable) of2), fqName9), fqName2), fqName6), fqName8);
        READ_ONLY_ANNOTATIONS = kotlin.collections.SetsKt.setOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.name.FqName[]{kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.JETBRAINS_READONLY_ANNOTATION, kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.READONLY_ANNOTATION});
        MUTABLE_ANNOTATIONS = kotlin.collections.SetsKt.setOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.name.FqName[]{kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.JETBRAINS_MUTABLE_ANNOTATION, kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.MUTABLE_ANNOTATION});
        javaToKotlinNameMap = kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.TARGET_ANNOTATION, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.target), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.RETENTION_ANNOTATION, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.retention), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.DEPRECATED_ANNOTATION, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.deprecated), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.DOCUMENTED_ANNOTATION, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.mustBeDocumented));
        UNDER_MIGRATION_ANNOTATION_FQ_NAME = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.annotations.jvm.UnderMigration");
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName getJSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME() {
        return JSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName getJSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME() {
        return JSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName getJSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME() {
        return JSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName getJAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME() {
        return JAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName getJAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME() {
        return JAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName getJAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME() {
        return JAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName getJAVAX_NONNULL_ANNOTATION_FQ_NAME() {
        return JAVAX_NONNULL_ANNOTATION_FQ_NAME;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName getJAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME() {
        return JAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName getJAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME() {
        return JAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME;
    }

    public static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> getBUILT_IN_TYPE_QUALIFIER_ANNOTATIONS() {
        return BUILT_IN_TYPE_QUALIFIER_ANNOTATIONS;
    }

    public static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> getNOT_NULL_ANNOTATIONS() {
        return NOT_NULL_ANNOTATIONS;
    }

    public static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> getNULLABLE_ANNOTATIONS() {
        return NULLABLE_ANNOTATIONS;
    }

    public static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> getFORCE_FLEXIBILITY_ANNOTATIONS() {
        return FORCE_FLEXIBILITY_ANNOTATIONS;
    }

    public static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> getREAD_ONLY_ANNOTATIONS() {
        return READ_ONLY_ANNOTATIONS;
    }

    public static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> getMUTABLE_ANNOTATIONS() {
        return MUTABLE_ANNOTATIONS;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName getUNDER_MIGRATION_ANNOTATION_FQ_NAME() {
        return UNDER_MIGRATION_ANNOTATION_FQ_NAME;
    }
}
