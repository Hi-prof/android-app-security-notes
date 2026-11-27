package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
final class NullableSimpleType extends kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleTypeImpl {
    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NullableSimpleType(kotlin.reflect.jvm.internal.impl.types.SimpleType delegate) {
        super(delegate);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public kotlin.reflect.jvm.internal.impl.types.NullableSimpleType replaceDelegate(kotlin.reflect.jvm.internal.impl.types.SimpleType delegate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new kotlin.reflect.jvm.internal.impl.types.NullableSimpleType(delegate);
    }
}
