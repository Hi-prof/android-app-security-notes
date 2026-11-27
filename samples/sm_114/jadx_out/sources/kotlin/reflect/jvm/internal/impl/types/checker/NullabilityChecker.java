package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NullabilityChecker {
    public static final kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker INSTANCE = new kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker();

    private NullabilityChecker() {
    }

    public final boolean isSubtypeOfAny(kotlin.reflect.jvm.internal.impl.types.UnwrappedType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        return kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker.INSTANCE.hasNotNullSupertype(kotlin.reflect.jvm.internal.impl.types.model.TypeCheckerProviderContext$$Util.newTypeCheckerState$default(kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE, false, true, false, 4, null), kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.lowerIfFlexible(type), kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE);
    }
}
