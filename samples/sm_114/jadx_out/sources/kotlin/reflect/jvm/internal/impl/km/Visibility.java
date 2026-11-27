package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Modifiers.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum Visibility {
    INTERNAL(0),
    PRIVATE(1),
    PROTECTED(2),
    PUBLIC(3),
    PRIVATE_TO_THIS(4),
    LOCAL(5);

    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    private final kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl flag;

    public static kotlin.enums.EnumEntries<kotlin.reflect.jvm.internal.impl.km.Visibility> getEntries() {
        return $ENTRIES;
    }

    Visibility(int i) {
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility> VISIBILITY = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(VISIBILITY, "VISIBILITY");
        this.flag = new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(VISIBILITY, i);
    }

    public final kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl getFlag$kotlin_metadata() {
        return this.flag;
    }
}
