package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeCapabilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeCapabilitiesKt {
    public static final boolean isCustomTypeParameter(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        java.lang.Object objUnwrap = kotlinType.unwrap();
        kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter customTypeParameter = objUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter ? (kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter) objUnwrap : null;
        if (customTypeParameter != null) {
            return customTypeParameter.isTypeParameter();
        }
        return false;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter getCustomTypeParameter(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        java.lang.Object objUnwrap = kotlinType.unwrap();
        kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter customTypeParameter = objUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter ? (kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter) objUnwrap : null;
        if (customTypeParameter == null || !customTypeParameter.isTypeParameter()) {
            return null;
        }
        return customTypeParameter;
    }
}
