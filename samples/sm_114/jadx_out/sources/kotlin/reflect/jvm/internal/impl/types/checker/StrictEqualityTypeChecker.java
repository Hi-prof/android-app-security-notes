package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StrictEqualityTypeChecker {
    public static final kotlin.reflect.jvm.internal.impl.types.checker.StrictEqualityTypeChecker INSTANCE = new kotlin.reflect.jvm.internal.impl.types.checker.StrictEqualityTypeChecker();

    private StrictEqualityTypeChecker() {
    }

    public final boolean strictEqualTypes(kotlin.reflect.jvm.internal.impl.types.UnwrappedType a, kotlin.reflect.jvm.internal.impl.types.UnwrappedType b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(b, "b");
        return kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE, a, b);
    }
}
