package kotlin.reflect.jvm.internal.impl.builtins.functions;

/* JADX INFO: compiled from: FunctionClassKind.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum FunctionClassKind {
    Function,
    SuspendFunction,
    KFunction,
    KSuspendFunction,
    UNKNOWN;

    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    public static final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.Companion Companion = new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.Companion(null);

    /* JADX INFO: compiled from: FunctionClassKind.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind getFunctionClassKind(kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind functionTypeKind) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functionTypeKind, "functionTypeKind");
            if (kotlin.jvm.internal.Intrinsics.areEqual(functionTypeKind, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.Function.INSTANCE)) {
                return kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.Function;
            }
            if (kotlin.jvm.internal.Intrinsics.areEqual(functionTypeKind, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.SuspendFunction.INSTANCE)) {
                return kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.SuspendFunction;
            }
            if (kotlin.jvm.internal.Intrinsics.areEqual(functionTypeKind, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KFunction.INSTANCE)) {
                return kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.KFunction;
            }
            return kotlin.jvm.internal.Intrinsics.areEqual(functionTypeKind, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KSuspendFunction.INSTANCE) ? kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.KSuspendFunction : kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.UNKNOWN;
        }
    }
}
