package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: JavaNullabilityAnnotationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaNullabilityAnnotationSettingsKt {
    private static final kotlin.reflect.jvm.internal.impl.name.FqName CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JSPECIFY_ANNOTATIONS_PACKAGE;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JSPECIFY_OLD_ANNOTATIONS_PACKAGE;
    private static final kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus JSR_305_DEFAULT_SETTINGS;
    private static final kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates<kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus> NULLABILITY_ANNOTATION_SETTINGS;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName[] RXJAVA3_ANNOTATIONS;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName RXJAVA3_ANNOTATIONS_PACKAGE;
    private static final java.lang.String RXJAVA3_ANNOTATIONS_PACKAGE_NAME;

    static {
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = new kotlin.reflect.jvm.internal.impl.name.FqName("org.jspecify.nullness");
        JSPECIFY_OLD_ANNOTATIONS_PACKAGE = fqName;
        kotlin.reflect.jvm.internal.impl.name.FqName fqName2 = new kotlin.reflect.jvm.internal.impl.name.FqName("org.jspecify.annotations");
        JSPECIFY_ANNOTATIONS_PACKAGE = fqName2;
        kotlin.reflect.jvm.internal.impl.name.FqName fqName3 = new kotlin.reflect.jvm.internal.impl.name.FqName("io.reactivex.rxjava3.annotations");
        RXJAVA3_ANNOTATIONS_PACKAGE = fqName3;
        kotlin.reflect.jvm.internal.impl.name.FqName fqName4 = new kotlin.reflect.jvm.internal.impl.name.FqName("org.checkerframework.checker.nullness.compatqual");
        CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE = fqName4;
        java.lang.String strAsString = fqName3.asString();
        RXJAVA3_ANNOTATIONS_PACKAGE_NAME = strAsString;
        RXJAVA3_ANNOTATIONS = new kotlin.reflect.jvm.internal.impl.name.FqName[]{new kotlin.reflect.jvm.internal.impl.name.FqName(strAsString + ".Nullable"), new kotlin.reflect.jvm.internal.impl.name.FqName(strAsString + ".NonNull")};
        NULLABILITY_ANNOTATION_SETTINGS = new kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStatesImpl(kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(new kotlin.reflect.jvm.internal.impl.name.FqName("org.jetbrains.annotations"), kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), kotlin.TuplesKt.to(new kotlin.reflect.jvm.internal.impl.name.FqName("androidx.annotation"), kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), kotlin.TuplesKt.to(new kotlin.reflect.jvm.internal.impl.name.FqName("android.support.annotation"), kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), kotlin.TuplesKt.to(new kotlin.reflect.jvm.internal.impl.name.FqName("android.annotation"), kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), kotlin.TuplesKt.to(new kotlin.reflect.jvm.internal.impl.name.FqName("com.android.annotations"), kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), kotlin.TuplesKt.to(new kotlin.reflect.jvm.internal.impl.name.FqName("org.eclipse.jdt.annotation"), kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), kotlin.TuplesKt.to(new kotlin.reflect.jvm.internal.impl.name.FqName("org.checkerframework.checker.nullness.qual"), kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), kotlin.TuplesKt.to(fqName4, kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), kotlin.TuplesKt.to(new kotlin.reflect.jvm.internal.impl.name.FqName("javax.annotation"), kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), kotlin.TuplesKt.to(new kotlin.reflect.jvm.internal.impl.name.FqName("edu.umd.cs.findbugs.annotations"), kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), kotlin.TuplesKt.to(new kotlin.reflect.jvm.internal.impl.name.FqName("io.reactivex.annotations"), kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), kotlin.TuplesKt.to(new kotlin.reflect.jvm.internal.impl.name.FqName("androidx.annotation.RecentlyNullable"), new kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus(kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.WARN, null, null, 4, null)), kotlin.TuplesKt.to(new kotlin.reflect.jvm.internal.impl.name.FqName("androidx.annotation.RecentlyNonNull"), new kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus(kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.WARN, null, null, 4, null)), kotlin.TuplesKt.to(new kotlin.reflect.jvm.internal.impl.name.FqName("lombok"), kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), kotlin.TuplesKt.to(fqName, new kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus(kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.WARN, new kotlin.KotlinVersion(2, 1), kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.STRICT)), kotlin.TuplesKt.to(fqName2, new kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus(kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.WARN, new kotlin.KotlinVersion(2, 1), kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.STRICT)), kotlin.TuplesKt.to(fqName3, new kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus(kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.WARN, new kotlin.KotlinVersion(1, 8), kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.STRICT)), kotlin.TuplesKt.to(new kotlin.reflect.jvm.internal.impl.name.FqName("jakarta.annotation"), new kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus(kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.WARN, new kotlin.KotlinVersion(2, 4), kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.STRICT))));
        JSR_305_DEFAULT_SETTINGS = new kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus(kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.WARN, null, null, 4, null);
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName getJSPECIFY_ANNOTATIONS_PACKAGE() {
        return JSPECIFY_ANNOTATIONS_PACKAGE;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName[] getRXJAVA3_ANNOTATIONS() {
        return RXJAVA3_ANNOTATIONS;
    }

    public static final kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings getDefaultJsr305Settings(kotlin.KotlinVersion configuredKotlinVersion) {
        kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevelBefore;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(configuredKotlinVersion, "configuredKotlinVersion");
        kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus javaNullabilityAnnotationsStatus = JSR_305_DEFAULT_SETTINGS;
        if (javaNullabilityAnnotationsStatus.getSinceVersion() != null && javaNullabilityAnnotationsStatus.getSinceVersion().compareTo(configuredKotlinVersion) <= 0) {
            reportLevelBefore = javaNullabilityAnnotationsStatus.getReportLevelAfter();
        } else {
            reportLevelBefore = javaNullabilityAnnotationsStatus.getReportLevelBefore();
        }
        kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevel = reportLevelBefore;
        return new kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings(reportLevel, getDefaultMigrationJsr305ReportLevelForGivenGlobal(reportLevel), null, 4, null);
    }

    public static final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel getDefaultMigrationJsr305ReportLevelForGivenGlobal(kotlin.reflect.jvm.internal.impl.load.java.ReportLevel globalReportLevel) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(globalReportLevel, "globalReportLevel");
        if (globalReportLevel == kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.WARN) {
            return null;
        }
        return globalReportLevel;
    }

    public static final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel getDefaultReportLevelForAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName annotationFqName, kotlin.KotlinVersion configuredKotlinVersion) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationFqName, "annotationFqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(configuredKotlinVersion, "configuredKotlinVersion");
        return getReportLevelForAnnotation(annotationFqName, kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates.Companion.getEMPTY(), configuredKotlinVersion);
    }

    public static final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel getReportLevelForAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName annotation, kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates<? extends kotlin.reflect.jvm.internal.impl.load.java.ReportLevel> configuredReportLevels, kotlin.KotlinVersion configuredKotlinVersion) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotation, "annotation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(configuredReportLevels, "configuredReportLevels");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(configuredKotlinVersion, "configuredKotlinVersion");
        kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevel = configuredReportLevels.get(annotation);
        if (reportLevel != null) {
            return reportLevel;
        }
        kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus javaNullabilityAnnotationsStatus = NULLABILITY_ANNOTATION_SETTINGS.get(annotation);
        if (javaNullabilityAnnotationsStatus == null) {
            return kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.IGNORE;
        }
        if (javaNullabilityAnnotationsStatus.getSinceVersion() != null && javaNullabilityAnnotationsStatus.getSinceVersion().compareTo(configuredKotlinVersion) <= 0) {
            return javaNullabilityAnnotationsStatus.getReportLevelAfter();
        }
        return javaNullabilityAnnotationsStatus.getReportLevelBefore();
    }
}
