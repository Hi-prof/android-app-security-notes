package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimpleClassicTypeSystemContext implements kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext {
    public static final kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext INSTANCE = new kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext();

    public java.util.List<kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker> default$fastCorrespondingSupertypes(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker constructor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rigidTypeMarker, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "constructor");
        return null;
    }

    private SimpleClassicTypeSystemContext() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean areEqualTypeConstructors(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker2) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.areEqualTypeConstructors(this, typeConstructorMarker, typeConstructorMarker2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int argumentsCount(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.argumentsCount(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker asArgumentList(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.asArgumentList(this, rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker asCapturedType(kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker simpleTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.asCapturedType(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker asCapturedTypeUnwrappingDnn(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        return default$asCapturedTypeUnwrappingDnn(rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker asDefinitelyNotNullType(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.asDefinitelyNotNullType(this, rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker asDynamicType(kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker flexibleTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.asDynamicType(this, flexibleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker asFlexibleType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.asFlexibleType(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker asRigidType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.asRigidType(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker asTypeArgument(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.asTypeArgument(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.SimpleType captureFromArguments(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus captureStatus) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.captureFromArguments(this, rigidTypeMarker, captureStatus);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus captureStatus(kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker capturedTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.captureStatus(this, capturedTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker createFlexibleType(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker2) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.createFlexibleType(this, rigidTypeMarker, rigidTypeMarker2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public java.util.List<kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker> fastCorrespondingSupertypes(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return default$fastCorrespondingSupertypes(rigidTypeMarker, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker get(kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker typeArgumentListMarker, int i) {
        return default$get(typeArgumentListMarker, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker getArgument(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, int i) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.getArgument(this, kotlinTypeMarker, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker getArgumentOrNull(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, int i) {
        return default$getArgumentOrNull(rigidTypeMarker, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public java.util.List<kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker> getArguments(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.getArguments(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe getClassFqNameUnsafe(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.getClassFqNameUnsafe(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker getParameter(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker, int i) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.getParameter(this, typeConstructorMarker, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public java.util.List<kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker> getParameters(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.getParameters(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType getPrimitiveArrayType(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.getPrimitiveArrayType(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType getPrimitiveType(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.getPrimitiveType(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker getRepresentativeUpperBound(kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.getRepresentativeUpperBound(this, typeParameterMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker getType(kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker typeArgumentMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.getType(this, typeArgumentMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker getTypeParameter(kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.getTypeParameter(this, typeVariableTypeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker getTypeParameterClassifier(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.getTypeParameterClassifier(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker getUnsubstitutedUnderlyingType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.getUnsubstitutedUnderlyingType(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public java.util.List<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> getUpperBounds(kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.getUpperBounds(this, typeParameterMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.TypeVariance getVariance(kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker typeArgumentMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.getVariance(this, typeArgumentMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.TypeVariance getVariance(kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.getVariance(this, typeParameterMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean hasAnnotation(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.hasAnnotation(this, kotlinTypeMarker, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean hasFlexibleNullability(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return default$hasFlexibleNullability(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean hasRecursiveBounds(kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker typeParameterMarker, kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.hasRecursiveBounds(this, typeParameterMarker, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemOptimizationContext
    public boolean identicalArguments(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker2) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.identicalArguments(this, rigidTypeMarker, rigidTypeMarker2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker intersectTypes(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> collection) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.intersectTypes(this, collection);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isAnyConstructor(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isAnyConstructor(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isCapturedType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return default$isCapturedType(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isClassType(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        return default$isClassType(rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isClassTypeConstructor(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isClassTypeConstructor(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isCommonFinalClassConstructor(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isCommonFinalClassConstructor(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDefinitelyNotNullType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return default$isDefinitelyNotNullType(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDefinitelyNotNullType(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        return default$isDefinitelyNotNullType(rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDenotable(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isDenotable(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDynamic(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return default$isDynamic(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isError(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isError(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isFlexible(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return default$isFlexible(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isFlexibleWithDifferentTypeConstructors(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return default$isFlexibleWithDifferentTypeConstructors(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean isInlineClass(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isInlineClass(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntegerLiteralType(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        return default$isIntegerLiteralType(rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntegerLiteralTypeConstructor(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralTypeConstructor(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntersection(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isIntersection(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext
    public boolean isK2() {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isK2(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isMarkedNullable(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isMarkedNullable(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNotNullTypeParameter(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isNotNullTypeParameter(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNothing(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return default$isNothing(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNothingConstructor(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isNothingConstructor(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNullableType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isNullableType(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isOldCapturedType(kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker capturedTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isOldCapturedType(this, capturedTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isPrimitiveType(kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker simpleTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isPrimitiveType(this, simpleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isProjectionNotNull(kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker capturedTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isProjectionNotNull(this, capturedTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isRawType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isRawType(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isSingleClassifierType(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isSingleClassifierType(this, rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStarProjection(kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker typeArgumentMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isStarProjection(this, typeArgumentMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStubType(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isStubType(this, rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStubTypeForBuilderInference(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isStubTypeForBuilderInference(this, rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isTypeVariableType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isTypeVariableType(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean isUnderKotlinPackage(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.isUnderKotlinPackage(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker lowerBound(kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker flexibleTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.lowerBound(this, flexibleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker lowerBoundIfFlexible(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return default$lowerBoundIfFlexible(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker lowerType(kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker capturedTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.lowerType(this, capturedTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker makeDefinitelyNotNullOrNotNull(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return default$makeDefinitelyNotNullOrNotNull(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker makeDefinitelyNotNullOrNotNull(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, boolean z) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.makeDefinitelyNotNullOrNotNull(this, kotlinTypeMarker, z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker makeNullable(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return default$makeNullable(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeCheckerProviderContext
    public kotlin.reflect.jvm.internal.impl.types.TypeCheckerState newTypeCheckerState(boolean z, boolean z2, boolean z3) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.newTypeCheckerState(this, z, z2, z3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker original(kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.original(this, definitelyNotNullTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker originalIfDefinitelyNotNullable(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        return default$originalIfDefinitelyNotNullable(rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int parametersCount(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.parametersCount(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> possibleIntegerTypes(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.possibleIntegerTypes(this, rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker projection(kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker capturedTypeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.projection(this, capturedTypeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int size(kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker typeArgumentListMarker) {
        return default$size(typeArgumentListMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.substitutionSupertypePolicy(this, rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker> supertypes(kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.supertypes(this, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker typeConstructor(kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker capturedTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.typeConstructor((kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext) this, capturedTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructor(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return default$typeConstructor(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructor(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, rigidTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker upperBound(kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker flexibleTypeMarker) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.upperBound(this, flexibleTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker upperBoundIfFlexible(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        return default$upperBoundIfFlexible(kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker withNullability(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, boolean z) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.withNullability(this, kotlinTypeMarker, z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker withNullability(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, boolean z) {
        return kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls.withNullability((kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext) this, rigidTypeMarker, z);
    }

    public kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker default$makeNullable(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerWithNullability;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
        return (rigidTypeMarkerAsRigidType == null || (rigidTypeMarkerWithNullability = withNullability(rigidTypeMarkerAsRigidType, true)) == null) ? kotlinTypeMarker : rigidTypeMarkerWithNullability;
    }

    public kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker default$asCapturedTypeUnwrappingDnn(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rigidTypeMarker, "<this>");
        return asCapturedType(originalIfDefinitelyNotNullable(rigidTypeMarker));
    }

    public boolean default$isCapturedType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
        return (rigidTypeMarkerAsRigidType != null ? asCapturedTypeUnwrappingDnn(rigidTypeMarkerAsRigidType) : null) != null;
    }

    public kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker default$originalIfDefinitelyNotNullable(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker simpleTypeMarkerOriginal;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rigidTypeMarker, "<this>");
        kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker definitelyNotNullTypeMarkerAsDefinitelyNotNullType = asDefinitelyNotNullType(rigidTypeMarker);
        return (definitelyNotNullTypeMarkerAsDefinitelyNotNullType == null || (simpleTypeMarkerOriginal = original(definitelyNotNullTypeMarkerAsDefinitelyNotNullType)) == null) ? (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) rigidTypeMarker : simpleTypeMarkerOriginal;
    }

    public kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker default$makeDefinitelyNotNullOrNotNull(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return makeDefinitelyNotNullOrNotNull(kotlinTypeMarker, false);
    }

    public kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker default$getArgumentOrNull(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rigidTypeMarker, "<this>");
        if (i < 0 || i >= argumentsCount(rigidTypeMarker)) {
            return null;
        }
        return getArgument(rigidTypeMarker, i);
    }

    public kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker default$lowerBoundIfFlexible(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerLowerBound;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType = asFlexibleType(kotlinTypeMarker);
        if (flexibleTypeMarkerAsFlexibleType != null && (rigidTypeMarkerLowerBound = lowerBound(flexibleTypeMarkerAsFlexibleType)) != null) {
            return rigidTypeMarkerLowerBound;
        }
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
        kotlin.jvm.internal.Intrinsics.checkNotNull(rigidTypeMarkerAsRigidType);
        return rigidTypeMarkerAsRigidType;
    }

    public kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker default$upperBoundIfFlexible(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerUpperBound;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType = asFlexibleType(kotlinTypeMarker);
        if (flexibleTypeMarkerAsFlexibleType != null && (rigidTypeMarkerUpperBound = upperBound(flexibleTypeMarkerAsFlexibleType)) != null) {
            return rigidTypeMarkerUpperBound;
        }
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
        kotlin.jvm.internal.Intrinsics.checkNotNull(rigidTypeMarkerAsRigidType);
        return rigidTypeMarkerAsRigidType;
    }

    public boolean default$isFlexibleWithDifferentTypeConstructors(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return !kotlin.jvm.internal.Intrinsics.areEqual(typeConstructor(lowerBoundIfFlexible(kotlinTypeMarker)), typeConstructor(upperBoundIfFlexible(kotlinTypeMarker)));
    }

    public boolean default$isFlexible(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return asFlexibleType(kotlinTypeMarker) != null;
    }

    public boolean default$isDynamic(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker flexibleTypeMarkerAsFlexibleType = asFlexibleType(kotlinTypeMarker);
        return (flexibleTypeMarkerAsFlexibleType != null ? asDynamicType(flexibleTypeMarkerAsFlexibleType) : null) != null;
    }

    public boolean default$isDefinitelyNotNullType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
        return (rigidTypeMarkerAsRigidType != null ? asDefinitelyNotNullType(rigidTypeMarkerAsRigidType) : null) != null;
    }

    public boolean default$isDefinitelyNotNullType(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rigidTypeMarker, "<this>");
        return asDefinitelyNotNullType(rigidTypeMarker) != null;
    }

    public boolean default$hasFlexibleNullability(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return isMarkedNullable(lowerBoundIfFlexible(kotlinTypeMarker)) != isMarkedNullable(upperBoundIfFlexible(kotlinTypeMarker));
    }

    public kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker default$typeConstructor(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarkerAsRigidType = asRigidType(kotlinTypeMarker);
        if (rigidTypeMarkerAsRigidType == null) {
            rigidTypeMarkerAsRigidType = lowerBoundIfFlexible(kotlinTypeMarker);
        }
        return typeConstructor(rigidTypeMarkerAsRigidType);
    }

    public boolean default$isNothing(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeMarker, "<this>");
        return isNothingConstructor(typeConstructor(kotlinTypeMarker)) && !isNullableType(kotlinTypeMarker);
    }

    public boolean default$isClassType(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rigidTypeMarker, "<this>");
        return isClassTypeConstructor(typeConstructor(rigidTypeMarker));
    }

    public boolean default$isIntegerLiteralType(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker rigidTypeMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rigidTypeMarker, "<this>");
        return isIntegerLiteralTypeConstructor(typeConstructor(rigidTypeMarker));
    }

    public kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker default$get(kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker typeArgumentListMarker, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeArgumentListMarker, "<this>");
        if (typeArgumentListMarker instanceof kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) {
            return getArgument((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) typeArgumentListMarker, i);
        }
        if (typeArgumentListMarker instanceof kotlin.reflect.jvm.internal.impl.types.model.ArgumentList) {
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker typeArgumentMarker = ((kotlin.reflect.jvm.internal.impl.types.model.ArgumentList) typeArgumentListMarker).get(i);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeArgumentMarker, "get(...)");
            return typeArgumentMarker;
        }
        throw new java.lang.IllegalStateException(("unknown type argument list type: " + typeArgumentListMarker + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(typeArgumentListMarker.getClass())).toString());
    }

    public int default$size(kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker typeArgumentListMarker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeArgumentListMarker, "<this>");
        if (typeArgumentListMarker instanceof kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker) {
            return argumentsCount((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) typeArgumentListMarker);
        }
        if (typeArgumentListMarker instanceof kotlin.reflect.jvm.internal.impl.types.model.ArgumentList) {
            return ((kotlin.reflect.jvm.internal.impl.types.model.ArgumentList) typeArgumentListMarker).size();
        }
        throw new java.lang.IllegalStateException(("unknown type argument list type: " + typeArgumentListMarker + ", " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(typeArgumentListMarker.getClass())).toString());
    }
}
