package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: AnnotationQualifierApplicabilityType.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum AnnotationQualifierApplicabilityType {
    METHOD_RETURN_TYPE("METHOD"),
    VALUE_PARAMETER("PARAMETER"),
    FIELD("FIELD"),
    TYPE_USE("TYPE_USE"),
    TYPE_PARAMETER_BOUNDS("TYPE_USE"),
    TYPE_PARAMETER("TYPE_PARAMETER");

    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    private final java.lang.String javaTarget;

    AnnotationQualifierApplicabilityType(java.lang.String str) {
        this.javaTarget = str;
    }

    public final java.lang.String getJavaTarget() {
        return this.javaTarget;
    }
}
