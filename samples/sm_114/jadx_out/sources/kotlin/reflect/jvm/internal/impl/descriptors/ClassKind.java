package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: ClassKind.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum ClassKind {
    CLASS("class"),
    INTERFACE("interface"),
    ENUM_CLASS("enum class"),
    ENUM_ENTRY(null),
    ANNOTATION_CLASS("annotation class"),
    OBJECT("object");

    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    private final java.lang.String codeRepresentation;

    ClassKind(java.lang.String str) {
        this.codeRepresentation = str;
    }

    public final boolean isSingleton() {
        return this == OBJECT || this == ENUM_ENTRY;
    }
}
