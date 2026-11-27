package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StarProjectionForAbsentTypeParameter extends kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase {
    private final kotlin.reflect.jvm.internal.impl.types.KotlinType nullableAnyType;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return true;
    }

    public StarProjectionForAbsentTypeParameter(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns kotlinBuiltIns) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinBuiltIns, "kotlinBuiltIns");
        kotlin.reflect.jvm.internal.impl.types.SimpleType nullableAnyType = kotlinBuiltIns.getNullableAnyType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nullableAnyType, "getNullableAnyType(...)");
        this.nullableAnyType = nullableAnyType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public kotlin.reflect.jvm.internal.impl.types.Variance getProjectionKind() {
        return kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getType() {
        return this.nullableAnyType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public kotlin.reflect.jvm.internal.impl.types.TypeProjection refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
