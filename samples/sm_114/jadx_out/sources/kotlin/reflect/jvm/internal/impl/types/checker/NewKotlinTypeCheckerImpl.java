package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NewKotlinTypeCheckerImpl implements kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker {
    private final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator kotlinTypePreparator;
    private final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner;
    private final kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil overridingUtil;

    public NewKotlinTypeCheckerImpl(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator kotlinTypePreparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypePreparator, "kotlinTypePreparator");
        this.kotlinTypeRefiner = kotlinTypeRefiner;
        this.kotlinTypePreparator = kotlinTypePreparator;
        kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil overridingUtilCreateWithTypeRefiner = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.createWithTypeRefiner(getKotlinTypeRefiner());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(overridingUtilCreateWithTypeRefiner, "createWithTypeRefiner(...)");
        this.overridingUtil = overridingUtilCreateWithTypeRefiner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner getKotlinTypeRefiner() {
        return this.kotlinTypeRefiner;
    }

    public /* synthetic */ NewKotlinTypeCheckerImpl(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator.Default r2, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(kotlinTypeRefiner, (i & 2) != 0 ? kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator.Default.INSTANCE : r2);
    }

    public kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator getKotlinTypePreparator() {
        return this.kotlinTypePreparator;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil getOverridingUtil() {
        return this.overridingUtil;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean isSubtypeOf(kotlin.reflect.jvm.internal.impl.types.KotlinType subtype, kotlin.reflect.jvm.internal.impl.types.KotlinType supertype) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(subtype, "subtype");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(supertype, "supertype");
        return isSubtypeOf(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(true, false, null, getKotlinTypePreparator(), getKotlinTypeRefiner(), 6, null), subtype.unwrap(), supertype.unwrap());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean equalTypes(kotlin.reflect.jvm.internal.impl.types.KotlinType a, kotlin.reflect.jvm.internal.impl.types.KotlinType b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(b, "b");
        return equalTypes(kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(false, false, null, getKotlinTypePreparator(), getKotlinTypeRefiner(), 6, null), a.unwrap(), b.unwrap());
    }

    public final boolean equalTypes(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.UnwrappedType a, kotlin.reflect.jvm.internal.impl.types.UnwrappedType b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeCheckerState, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(b, "b");
        return kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.INSTANCE.equalTypes(typeCheckerState, a, b);
    }

    public final boolean isSubtypeOf(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.UnwrappedType subType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType superType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeCheckerState, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(subType, "subType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(superType, "superType");
        return kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.isSubtypeOf$default(kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.INSTANCE, typeCheckerState, subType, superType, false, 8, null);
    }
}
