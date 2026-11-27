package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DefinitelyNotNullType extends kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType implements kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter, kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker {
    public static final kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType.Companion Companion = new kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType.Companion(null);
    private final kotlin.reflect.jvm.internal.impl.types.SimpleType original;
    private final boolean useCorrectedNullabilityForTypeParameters;

    public /* synthetic */ DefinitelyNotNullType(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, boolean z, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(simpleType, z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    public final kotlin.reflect.jvm.internal.impl.types.SimpleType getOriginal() {
        return this.original;
    }

    private DefinitelyNotNullType(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, boolean z) {
        this.original = simpleType;
        this.useCorrectedNullabilityForTypeParameters = z;
    }

    /* JADX INFO: compiled from: SpecialTypes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType makeDefinitelyNotNull$default(kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType.Companion companion, kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType, boolean z, boolean z2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            return companion.makeDefinitelyNotNull(unwrappedType, z, z2);
        }

        public final kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType makeDefinitelyNotNull(kotlin.reflect.jvm.internal.impl.types.UnwrappedType type, boolean z, boolean z2) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
            if (type instanceof kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType) {
                return (kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType) type;
            }
            kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker = null;
            if (!z2 && !makesSenseToBeDefinitelyNotNull(type, z)) {
                return null;
            }
            if (type instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType) {
                kotlin.reflect.jvm.internal.impl.types.FlexibleType flexibleType = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) type;
                kotlin.jvm.internal.Intrinsics.areEqual(flexibleType.getLowerBound().getConstructor(), flexibleType.getUpperBound().getConstructor());
            }
            return new kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType(kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.lowerIfFlexible(type).makeNullableAsSpecified(false), z, defaultConstructorMarker);
        }

        private final boolean makesSenseToBeDefinitelyNotNull(kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType, boolean z) {
            if (!canHaveUndefinedNullability(unwrappedType)) {
                return false;
            }
            if (unwrappedType instanceof kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference) {
                return kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(unwrappedType);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = unwrappedType.getConstructor().mo1835getDeclarationDescriptor();
            kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl typeParameterDescriptorImpl = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl ? (kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl) classifierDescriptorMo1835getDeclarationDescriptor : null;
            if (typeParameterDescriptorImpl != null && !typeParameterDescriptorImpl.isInitialized()) {
                return true;
            }
            if (z && (unwrappedType.getConstructor().mo1835getDeclarationDescriptor() instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor)) {
                return kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(unwrappedType);
            }
            return !kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker.INSTANCE.isSubtypeOfAny(unwrappedType);
        }

        private final boolean canHaveUndefinedNullability(kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType) {
            return (unwrappedType.getConstructor() instanceof kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor) || (unwrappedType.getConstructor().mo1835getDeclarationDescriptor() instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) || (unwrappedType instanceof kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType) || (unwrappedType instanceof kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    protected kotlin.reflect.jvm.internal.impl.types.SimpleType getDelegate() {
        return this.original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public boolean isTypeParameter() {
        return (getDelegate().getConstructor() instanceof kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor) || (getDelegate().getConstructor().mo1835getDeclarationDescriptor() instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeParameter
    public kotlin.reflect.jvm.internal.impl.types.KotlinType substitutionResult(kotlin.reflect.jvm.internal.impl.types.KotlinType replacement) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacement, "replacement");
        return kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.makeDefinitelyNotNullOrNotNull(replacement.unwrap(), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType replaceAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttributes newAttributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType(getDelegate().replaceAttributes(newAttributes), this.useCorrectedNullabilityForTypeParameters);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType makeNullableAsSpecified(boolean z) {
        return z ? getDelegate().makeNullableAsSpecified(z) : this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public java.lang.String toString() {
        return getDelegate() + " & Any";
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType replaceDelegate(kotlin.reflect.jvm.internal.impl.types.SimpleType delegate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType(delegate, this.useCorrectedNullabilityForTypeParameters);
    }
}
