package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: JavaTypeEnhancementState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaTypeEnhancementState {
    public static final kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState.Companion Companion = new kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState.Companion(null);
    private final boolean disabledDefaultAnnotations;
    private final kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.load.java.ReportLevel> getReportLevelForAnnotation;
    private final kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings jsr305;

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeEnhancementState(kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings jsr305, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.FqName, ? extends kotlin.reflect.jvm.internal.impl.load.java.ReportLevel> getReportLevelForAnnotation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jsr305, "jsr305");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(getReportLevelForAnnotation, "getReportLevelForAnnotation");
        this.jsr305 = jsr305;
        this.getReportLevelForAnnotation = getReportLevelForAnnotation;
        this.disabledDefaultAnnotations = jsr305.isDisabled() || getReportLevelForAnnotation.invoke(kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) == kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.IGNORE;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings getJsr305() {
        return this.jsr305;
    }

    public final kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.load.java.ReportLevel> getGetReportLevelForAnnotation() {
        return this.getReportLevelForAnnotation;
    }

    public final boolean getDisabledDefaultAnnotations() {
        return this.disabledDefaultAnnotations;
    }

    /* JADX INFO: compiled from: JavaTypeEnhancementState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState getDefault(final kotlin.KotlinVersion kotlinVersion) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinVersion, "kotlinVersion");
            return new kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState(kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationSettingsKt.getDefaultJsr305Settings(kotlinVersion), new kotlin.jvm.functions.Function1(kotlinVersion) { // from class: kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState$Companion$$Lambda$0
                private final kotlin.KotlinVersion arg$0;

                {
                    this.arg$0 = kotlinVersion;
                }

                @Override // kotlin.jvm.functions.Function1
                public java.lang.Object invoke(java.lang.Object obj) {
                    return kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState.Companion.getDefault$lambda$0(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.FqName) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel getDefault$lambda$0(kotlin.KotlinVersion kotlinVersion, kotlin.reflect.jvm.internal.impl.name.FqName it) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
            return kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationSettingsKt.getDefaultReportLevelForAnnotation(it, kotlinVersion);
        }
    }

    public java.lang.String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.jsr305 + ", getReportLevelForAnnotation=" + this.getReportLevelForAnnotation + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }
}
