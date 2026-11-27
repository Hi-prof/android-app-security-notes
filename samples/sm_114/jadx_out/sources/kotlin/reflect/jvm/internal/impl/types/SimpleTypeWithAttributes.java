package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
final class SimpleTypeWithAttributes extends kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleTypeImpl {
    private final kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes;

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.TypeAttributes getAttributes() {
        return this.attributes;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleTypeWithAttributes(kotlin.reflect.jvm.internal.impl.types.SimpleType delegate, kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes) {
        super(delegate);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegate, "delegate");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.attributes = attributes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithAttributes replaceDelegate(kotlin.reflect.jvm.internal.impl.types.SimpleType delegate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithAttributes(delegate, getAttributes());
    }
}
