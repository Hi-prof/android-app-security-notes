package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Modifiers.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum MemberKind {
    DECLARATION(0),
    FAKE_OVERRIDE(1),
    DELEGATION(2),
    SYNTHESIZED(3);

    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    private final kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl flag;

    public static kotlin.enums.EnumEntries<kotlin.reflect.jvm.internal.impl.km.MemberKind> getEntries() {
        return $ENTRIES;
    }

    MemberKind(int i) {
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind> MEMBER_KIND = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MEMBER_KIND;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(MEMBER_KIND, "MEMBER_KIND");
        this.flag = new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(MEMBER_KIND, i);
    }

    public final kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl getFlag$kotlin_metadata() {
        return this.flag;
    }
}
