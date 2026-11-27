package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KotlinTypeKt {
    public static final boolean isNullable(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(kotlinType);
    }

    public static final boolean isError(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
        if (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.error.ErrorType) {
            return true;
        }
        return (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType) && (((kotlin.reflect.jvm.internal.impl.types.FlexibleType) unwrappedTypeUnwrap).getDelegate() instanceof kotlin.reflect.jvm.internal.impl.types.error.ErrorType);
    }
}
