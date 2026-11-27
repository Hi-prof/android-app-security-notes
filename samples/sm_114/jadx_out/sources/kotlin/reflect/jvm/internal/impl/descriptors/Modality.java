package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: Modality.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum Modality {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;

    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    public static final kotlin.reflect.jvm.internal.impl.descriptors.Modality.Companion Companion = new kotlin.reflect.jvm.internal.impl.descriptors.Modality.Companion(null);

    /* JADX INFO: compiled from: Modality.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.Modality convertFromFlags(boolean z, boolean z2, boolean z3) {
            if (z) {
                return kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED;
            }
            if (z2) {
                return kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT;
            }
            if (z3) {
                return kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN;
            }
            return kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL;
        }
    }
}
