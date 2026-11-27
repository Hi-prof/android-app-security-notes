package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DelegatingSimpleTypeImpl extends kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType {
    private final kotlin.reflect.jvm.internal.impl.types.SimpleType delegate;

    public DelegatingSimpleTypeImpl(kotlin.reflect.jvm.internal.impl.types.SimpleType delegate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    protected kotlin.reflect.jvm.internal.impl.types.SimpleType getDelegate() {
        return this.delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType replaceAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttributes newAttributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        if (newAttributes != getAttributes()) {
            return new kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithAttributes(this, newAttributes);
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType makeNullableAsSpecified(boolean z) {
        return z == isMarkedNullable() ? this : getDelegate().makeNullableAsSpecified(z).replaceAttributes(getAttributes());
    }
}
