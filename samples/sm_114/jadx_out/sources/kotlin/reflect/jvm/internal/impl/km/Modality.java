package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Modifiers.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum Modality {
    FINAL(0),
    OPEN(1),
    ABSTRACT(2),
    SEALED(3);

    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    private final kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl flag;

    public static kotlin.enums.EnumEntries<kotlin.reflect.jvm.internal.impl.km.Modality> getEntries() {
        return $ENTRIES;
    }

    Modality(int i) {
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality> MODALITY = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(MODALITY, "MODALITY");
        this.flag = new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(MODALITY, i);
    }

    public final kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl getFlag$kotlin_metadata() {
        return this.flag;
    }
}
