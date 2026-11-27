package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: flexibleTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FlexibleTypesKt {
    public static final boolean isFlexible(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.unwrap() instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.FlexibleType asFlexibleType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
        kotlin.jvm.internal.Intrinsics.checkNotNull(unwrappedTypeUnwrap, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (kotlin.reflect.jvm.internal.impl.types.FlexibleType) unwrappedTypeUnwrap;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType lowerIfFlexible(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
        if (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType) {
            return ((kotlin.reflect.jvm.internal.impl.types.FlexibleType) unwrappedTypeUnwrap).getLowerBound();
        }
        if (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
            return (kotlin.reflect.jvm.internal.impl.types.SimpleType) unwrappedTypeUnwrap;
        }
        throw new kotlin.NoWhenBranchMatchedException();
    }

    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType upperIfFlexible(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
        if (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType) {
            return ((kotlin.reflect.jvm.internal.impl.types.FlexibleType) unwrappedTypeUnwrap).getUpperBound();
        }
        if (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
            return (kotlin.reflect.jvm.internal.impl.types.SimpleType) unwrappedTypeUnwrap;
        }
        throw new kotlin.NoWhenBranchMatchedException();
    }
}
