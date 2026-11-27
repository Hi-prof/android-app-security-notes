package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotNullTypeParameterImpl extends kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType implements kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter {
    private final kotlin.reflect.jvm.internal.impl.types.SimpleType delegate;

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public boolean isTypeParameter() {
        return true;
    }

    public NotNullTypeParameterImpl(kotlin.reflect.jvm.internal.impl.types.SimpleType delegate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    protected kotlin.reflect.jvm.internal.impl.types.SimpleType getDelegate() {
        return this.delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public kotlin.reflect.jvm.internal.impl.types.KotlinType substitutionResult(kotlin.reflect.jvm.internal.impl.types.KotlinType replacement) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacement, "replacement");
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = replacement.unwrap();
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType = unwrappedTypeUnwrap;
        if (!kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isTypeParameter(unwrappedType) && !kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(unwrappedType)) {
            return unwrappedType;
        }
        if (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType) {
            return prepareReplacement((kotlin.reflect.jvm.internal.impl.types.SimpleType) unwrappedTypeUnwrap);
        }
        if (!(unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType)) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        kotlin.reflect.jvm.internal.impl.types.FlexibleType flexibleType = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) unwrappedTypeUnwrap;
        return kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(prepareReplacement(flexibleType.getLowerBound()), prepareReplacement(flexibleType.getUpperBound())), kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.getEnhancement(unwrappedType));
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType prepareReplacement(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType) {
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeMakeNullableAsSpecified = simpleType.makeNullableAsSpecified(false);
        return !kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isTypeParameter(simpleType) ? simpleTypeMakeNullableAsSpecified : new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameterImpl(simpleTypeMakeNullableAsSpecified);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameterImpl replaceAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttributes newAttributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameterImpl(getDelegate().replaceAttributes(newAttributes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType makeNullableAsSpecified(boolean z) {
        return z ? getDelegate().makeNullableAsSpecified(true) : this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameterImpl replaceDelegate(kotlin.reflect.jvm.internal.impl.types.SimpleType delegate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameterImpl(delegate);
    }
}
