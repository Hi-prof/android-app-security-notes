package kotlin.reflect.jvm.internal.impl.km.internal;

/* JADX INFO: compiled from: FlagDelegatesImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumFlagDelegate<Node, E extends java.lang.Enum<E>> {
    private final kotlin.enums.EnumEntries<E> entries;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl> flagValues;
    private final kotlin.reflect.KMutableProperty1<Node, java.lang.Integer> flags;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<? extends kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite> protoSet;

    public EnumFlagDelegate(kotlin.reflect.KMutableProperty1<Node, java.lang.Integer> flags, kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<? extends kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite> protoSet, kotlin.enums.EnumEntries<E> entries, java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl> flagValues) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(flags, "flags");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(protoSet, "protoSet");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(entries, "entries");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(flagValues, "flagValues");
        this.flags = flags;
        this.protoSet = protoSet;
        this.entries = entries;
        this.flagValues = flagValues;
    }

    public final E getValue(Node node, kotlin.reflect.KProperty<?> property) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        return this.entries.get(this.protoSet.get(this.flags.get(node).intValue()).getNumber());
    }
}
