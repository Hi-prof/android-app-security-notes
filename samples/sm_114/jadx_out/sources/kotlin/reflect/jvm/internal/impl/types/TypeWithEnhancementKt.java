package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeWithEnhancementKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType getEnhancement(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (kotlinType instanceof kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement) {
            return ((kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement) kotlinType).getEnhancement();
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.UnwrappedType inheritEnhancement(kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType origin, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.KotlinType, ? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(origin, "origin");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        kotlin.reflect.jvm.internal.impl.types.KotlinType enhancement = getEnhancement(origin);
        return wrapEnhancement(unwrappedType, enhancement != null ? transform.invoke2(enhancement) : null);
    }

    public static final kotlin.reflect.jvm.internal.impl.types.UnwrappedType inheritEnhancement(kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType origin) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(origin, "origin");
        return wrapEnhancement(unwrappedType, getEnhancement(origin));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final kotlin.reflect.jvm.internal.impl.types.UnwrappedType wrapEnhancement(kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
        if (unwrappedType instanceof kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement) {
            return wrapEnhancement(((kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement) unwrappedType).getOrigin(), kotlinType);
        }
        if (kotlinType == null || kotlin.jvm.internal.Intrinsics.areEqual(kotlinType, unwrappedType)) {
            return unwrappedType;
        }
        if (unwrappedType instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
            return new kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement((kotlin.reflect.jvm.internal.impl.types.SimpleType) unwrappedType, kotlinType);
        }
        if (unwrappedType instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType) {
            return new kotlin.reflect.jvm.internal.impl.types.FlexibleTypeWithEnhancement((kotlin.reflect.jvm.internal.impl.types.FlexibleType) unwrappedType, kotlinType);
        }
        throw new kotlin.NoWhenBranchMatchedException();
    }
}
