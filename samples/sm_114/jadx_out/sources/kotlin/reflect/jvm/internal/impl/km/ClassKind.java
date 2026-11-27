package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Modifiers.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum ClassKind {
    CLASS(0),
    INTERFACE(1),
    ENUM_CLASS(2),
    ENUM_ENTRY(3),
    ANNOTATION_CLASS(4),
    OBJECT(5),
    COMPANION_OBJECT(6);

    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    private final kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl flag;

    public static kotlin.enums.EnumEntries<kotlin.reflect.jvm.internal.impl.km.ClassKind> getEntries() {
        return $ENTRIES;
    }

    ClassKind(int i) {
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind> CLASS_KIND = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.CLASS_KIND;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(CLASS_KIND, "CLASS_KIND");
        this.flag = new kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl(CLASS_KIND, i);
    }

    public final kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl getFlag$kotlin_metadata() {
        return this.flag;
    }
}
