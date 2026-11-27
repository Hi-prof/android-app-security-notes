package kotlin.reflect.jvm.internal.impl.types.error;

/* JADX INFO: compiled from: ErrorEntity.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum ErrorEntity {
    ERROR_CLASS("<Error class: %s>"),
    ERROR_FUNCTION("<Error function>"),
    ERROR_SCOPE("<Error scope>"),
    ERROR_MODULE("<Error module>"),
    ERROR_PROPERTY("<Error property>"),
    ERROR_TYPE("[Error type: %s]"),
    PARENT_OF_ERROR_SCOPE("<Fake parent for error lexical scope>");

    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    private final java.lang.String debugText;

    ErrorEntity(java.lang.String str) {
        this.debugText = str;
    }

    public final java.lang.String getDebugText() {
        return this.debugText;
    }
}
