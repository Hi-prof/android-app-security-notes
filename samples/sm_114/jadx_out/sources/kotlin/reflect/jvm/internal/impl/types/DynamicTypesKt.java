package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: dynamicTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DynamicTypesKt {
    public static final boolean isDynamic(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.unwrap() instanceof kotlin.reflect.jvm.internal.impl.types.DynamicType;
    }
}
