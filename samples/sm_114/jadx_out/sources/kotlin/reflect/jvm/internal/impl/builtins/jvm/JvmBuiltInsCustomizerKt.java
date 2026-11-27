package kotlin.reflect.jvm.internal.impl.builtins.jvm;

/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmBuiltInsCustomizerKt {
    private static final kotlin.reflect.jvm.internal.impl.name.Name GET_FIRST_LIST_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.Name GET_LAST_LIST_NAME;

    static {
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier("getFirst");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        GET_FIRST_LIST_NAME = nameIdentifier;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier2 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("getLast");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier2, "identifier(...)");
        GET_LAST_LIST_NAME = nameIdentifier2;
    }
}
