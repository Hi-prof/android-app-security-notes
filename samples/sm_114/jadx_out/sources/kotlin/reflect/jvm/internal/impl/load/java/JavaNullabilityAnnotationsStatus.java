package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: JavaNullabilityAnnotationsStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaNullabilityAnnotationsStatus {
    public static final kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus.Companion Companion = new kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus.Companion(null);
    private static final kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus DEFAULT = new kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus(kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.STRICT, null, null, 6, null);
    private final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevelAfter;
    private final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevelBefore;
    private final kotlin.KotlinVersion sinceVersion;

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus javaNullabilityAnnotationsStatus = (kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus) obj;
        return this.reportLevelBefore == javaNullabilityAnnotationsStatus.reportLevelBefore && kotlin.jvm.internal.Intrinsics.areEqual(this.sinceVersion, javaNullabilityAnnotationsStatus.sinceVersion) && this.reportLevelAfter == javaNullabilityAnnotationsStatus.reportLevelAfter;
    }

    public int hashCode() {
        int iHashCode = this.reportLevelBefore.hashCode() * 31;
        kotlin.KotlinVersion kotlinVersion = this.sinceVersion;
        return ((iHashCode + (kotlinVersion == null ? 0 : kotlinVersion.getVersion())) * 31) + this.reportLevelAfter.hashCode();
    }

    public java.lang.String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.reportLevelBefore + ", sinceVersion=" + this.sinceVersion + ", reportLevelAfter=" + this.reportLevelAfter + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    public JavaNullabilityAnnotationsStatus(kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevelBefore, kotlin.KotlinVersion kotlinVersion, kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevelAfter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reportLevelBefore, "reportLevelBefore");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reportLevelAfter, "reportLevelAfter");
        this.reportLevelBefore = reportLevelBefore;
        this.sinceVersion = kotlinVersion;
        this.reportLevelAfter = reportLevelAfter;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel getReportLevelBefore() {
        return this.reportLevelBefore;
    }

    public /* synthetic */ JavaNullabilityAnnotationsStatus(kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevel, kotlin.KotlinVersion kotlinVersion, kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevel2, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(reportLevel, (i & 2) != 0 ? new kotlin.KotlinVersion(1, 0) : kotlinVersion, (i & 4) != 0 ? reportLevel : reportLevel2);
    }

    public final kotlin.KotlinVersion getSinceVersion() {
        return this.sinceVersion;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel getReportLevelAfter() {
        return this.reportLevelAfter;
    }

    /* JADX INFO: compiled from: JavaNullabilityAnnotationsStatus.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus getDEFAULT() {
            return kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus.DEFAULT;
        }
    }
}
