package kotlin.reflect.jvm.internal.impl.km.internal;

/* JADX INFO: compiled from: FlagDelegatesImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BooleanFlagDelegate<Node> {
    private final kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl flag;
    private final kotlin.reflect.KMutableProperty1<Node, java.lang.Integer> flags;
    private final int mask;

    public BooleanFlagDelegate(kotlin.reflect.KMutableProperty1<Node, java.lang.Integer> flags, kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl flag) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(flags, "flags");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(flag, "flag");
        this.flags = flags;
        this.flag = flag;
        if (flag.getBitWidth$kotlin_metadata() != 1 || flag.getValue$kotlin_metadata() != 1) {
            throw new java.lang.IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + flag + " was passed").toString());
        }
        this.mask = 1 << flag.getOffset$kotlin_metadata();
    }

    public final boolean getValue(Node node, kotlin.reflect.KProperty<?> property) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        return this.flag.invoke(this.flags.get(node).intValue());
    }

    public final void setValue(Node node, kotlin.reflect.KProperty<?> property, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        int iIntValue = this.flags.get(node).intValue();
        this.flags.set(node, java.lang.Integer.valueOf(z ? iIntValue | this.mask : iIntValue & (~this.mask)));
    }
}
