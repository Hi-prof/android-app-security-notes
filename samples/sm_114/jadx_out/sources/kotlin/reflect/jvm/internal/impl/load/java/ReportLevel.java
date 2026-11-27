package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: ReportLevel.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum ReportLevel {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");

    private final java.lang.String description;
    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    public static final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.Companion Companion = new kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.Companion(null);

    ReportLevel(java.lang.String str) {
        this.description = str;
    }

    public final java.lang.String getDescription() {
        return this.description;
    }

    /* JADX INFO: compiled from: ReportLevel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean isWarning() {
        return this == WARN;
    }

    public final boolean isIgnore() {
        return this == IGNORE;
    }
}
