package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

/* JADX INFO: compiled from: JvmFlags.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmFlags {
    private static final kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_COMPILED_IN_COMPATIBILITY_MODE;
    private static final kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_COMPILED_IN_JVM_DEFAULT_MODE;
    public static final kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmFlags INSTANCE = new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmFlags();
    private static final kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField IS_MOVED_FROM_INTERFACE_COMPANION = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField.booleanFirst();

    private JvmFlags() {
    }

    static {
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField booleanFlagFieldBooleanFirst = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField.booleanFirst();
        IS_COMPILED_IN_JVM_DEFAULT_MODE = booleanFlagFieldBooleanFirst;
        IS_COMPILED_IN_COMPATIBILITY_MODE = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField.booleanAfter(booleanFlagFieldBooleanFirst);
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField getIS_MOVED_FROM_INTERFACE_COMPANION() {
        return IS_MOVED_FROM_INTERFACE_COMPANION;
    }
}
