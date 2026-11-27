package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CapturedTypeApproximationKt {

    /* JADX INFO: compiled from: CapturedTypeApproximation.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.types.Variance.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final kotlin.reflect.jvm.internal.impl.types.TypeProjection toTypeProjection(kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument typeArgument) {
        typeArgument.isConsistent();
        if (kotlin.jvm.internal.Intrinsics.areEqual(typeArgument.getInProjection(), typeArgument.getOutProjection()) || typeArgument.getTypeParameter().getVariance() == kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE) {
            return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(typeArgument.getInProjection());
        }
        if (!kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isNothing(typeArgument.getInProjection()) || typeArgument.getTypeParameter().getVariance() == kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE) {
            return kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isNullableAny(typeArgument.getOutProjection()) ? new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(typeArgument, kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE), typeArgument.getInProjection()) : new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(typeArgument, kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE), typeArgument.getOutProjection());
        }
        return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(typeArgument, kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE), typeArgument.getOutProjection());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit toTypeProjection$lambda$1$lambda$0(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions withOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setClassifierNamePolicy(kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.FULLY_QUALIFIED.INSTANCE);
        return kotlin.Unit.INSTANCE;
    }

    private static final kotlin.reflect.jvm.internal.impl.types.Variance toTypeProjection$removeProjectionIfRedundant(kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument typeArgument, kotlin.reflect.jvm.internal.impl.types.Variance variance) {
        return variance == typeArgument.getTypeParameter().getVariance() ? kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT : variance;
    }

    private static final kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument toTypeArgument(kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor) {
        int i = kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt.WhenMappings.$EnumSwitchMapping$0[kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.combine(typeParameterDescriptor.getVariance(), typeProjection).ordinal()];
        if (i == 1) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = typeProjection.getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            kotlin.reflect.jvm.internal.impl.types.KotlinType type2 = typeProjection.getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
            return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument(typeParameterDescriptor, type, type2);
        }
        if (i == 2) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType type3 = typeProjection.getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type3, "getType(...)");
            kotlin.reflect.jvm.internal.impl.types.SimpleType nullableAnyType = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNullableAnyType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nullableAnyType, "getNullableAnyType(...)");
            return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument(typeParameterDescriptor, type3, nullableAnyType);
        }
        if (i != 3) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType nothingType = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNothingType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nothingType, "getNothingType(...)");
        kotlin.reflect.jvm.internal.impl.types.KotlinType type4 = typeProjection.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type4, "getType(...)");
        return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument(typeParameterDescriptor, nothingType, type4);
    }

    public static final kotlin.reflect.jvm.internal.impl.types.TypeProjection approximateCapturedTypesIfNecessary(kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection, boolean z) {
        if (typeProjection == null) {
            return null;
        }
        if (!typeProjection.isStarProjection()) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = typeProjection.getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            if (kotlin.reflect.jvm.internal.impl.types.TypeUtils.contains(type, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$$Lambda$1
                @Override // kotlin.jvm.functions.Function1
                public java.lang.Object invoke(java.lang.Object obj) {
                    return kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary$lambda$2((kotlin.reflect.jvm.internal.impl.types.UnwrappedType) obj);
                }
            })) {
                kotlin.reflect.jvm.internal.impl.types.Variance projectionKind = typeProjection.getProjectionKind();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(projectionKind, "getProjectionKind(...)");
                if (projectionKind == kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE) {
                    return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getUpper());
                }
                if (z) {
                    return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getLower());
                }
                return substituteCapturedTypesWithProjections(typeProjection);
            }
        }
        return typeProjection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Boolean approximateCapturedTypesIfNecessary$lambda$2(kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(unwrappedType);
        return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt.isCaptured(unwrappedType));
    }

    private static final kotlin.reflect.jvm.internal.impl.types.TypeProjection substituteCapturedTypesWithProjections(kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection) {
        kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutorCreate = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.create(new kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
            public kotlin.reflect.jvm.internal.impl.types.TypeProjection get(kotlin.reflect.jvm.internal.impl.types.TypeConstructor key) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
                kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor capturedTypeConstructor = key instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor ? (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor) key : null;
                if (capturedTypeConstructor == null) {
                    return null;
                }
                if (capturedTypeConstructor.getProjection().isStarProjection()) {
                    return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE, capturedTypeConstructor.getProjection().getType());
                }
                return capturedTypeConstructor.getProjection();
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeSubstitutorCreate, "create(...)");
        return typeSubstitutorCreate.substituteWithoutApproximation(typeProjection);
    }

    public static final kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds<kotlin.reflect.jvm.internal.impl.types.KotlinType> approximateCapturedTypes(kotlin.reflect.jvm.internal.impl.types.KotlinType type) {
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeReplaceTypeArguments;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        if (kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.isFlexible(type)) {
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds<kotlin.reflect.jvm.internal.impl.types.KotlinType> approximationBoundsApproximateCapturedTypes = approximateCapturedTypes(kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.lowerIfFlexible(type));
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds<kotlin.reflect.jvm.internal.impl.types.KotlinType> approximationBoundsApproximateCapturedTypes2 = approximateCapturedTypes(kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.upperIfFlexible(type));
            return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds<>(kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.inheritEnhancement(kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.lowerIfFlexible(approximationBoundsApproximateCapturedTypes.getLower()), kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.upperIfFlexible(approximationBoundsApproximateCapturedTypes2.getLower())), type), kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.inheritEnhancement(kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.lowerIfFlexible(approximationBoundsApproximateCapturedTypes.getUpper()), kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.upperIfFlexible(approximationBoundsApproximateCapturedTypes2.getUpper())), type));
        }
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor = type.getConstructor();
        if (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt.isCaptured(type)) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
            kotlin.reflect.jvm.internal.impl.types.TypeProjection projection = ((kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor) constructor).getProjection();
            kotlin.reflect.jvm.internal.impl.types.KotlinType type2 = projection.getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeApproximateCapturedTypes$makeNullableIfNeeded = approximateCapturedTypes$makeNullableIfNeeded(type2, type);
            int i = kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt.WhenMappings.$EnumSwitchMapping$0[projection.getProjectionKind().ordinal()];
            if (i == 2) {
                return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds<>(kotlinTypeApproximateCapturedTypes$makeNullableIfNeeded, kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getBuiltIns(type).getNullableAnyType());
            }
            if (i == 3) {
                kotlin.reflect.jvm.internal.impl.types.SimpleType nothingType = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getBuiltIns(type).getNothingType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nothingType, "getNothingType(...)");
                return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds<>(approximateCapturedTypes$makeNullableIfNeeded(nothingType, type), kotlinTypeApproximateCapturedTypes$makeNullableIfNeeded);
            }
            throw new java.lang.AssertionError("Only nontrivial projections should have been captured, not: " + projection);
        }
        if (type.getArguments().isEmpty() || type.getArguments().size() != constructor.getParameters().size()) {
            return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds<>(type, type);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments = type.getArguments();
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = constructor.getParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
        for (kotlin.Pair pair : kotlin.collections.CollectionsKt.zip(arguments, parameters)) {
            kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) pair.component1();
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) pair.component2();
            kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameterDescriptor);
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument typeArgument = toTypeArgument(typeProjection, typeParameterDescriptor);
            if (typeProjection.isStarProjection()) {
                arrayList.add(typeArgument);
                arrayList2.add(typeArgument);
            } else {
                kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds<kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument> approximationBoundsApproximateProjection = approximateProjection(typeArgument);
                kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument typeArgumentComponent1 = approximationBoundsApproximateProjection.component1();
                kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument typeArgumentComponent2 = approximationBoundsApproximateProjection.component2();
                arrayList.add(typeArgumentComponent1);
                arrayList2.add(typeArgumentComponent2);
            }
        }
        java.util.ArrayList arrayList3 = arrayList;
        boolean z = false;
        if (!(arrayList3 instanceof java.util.Collection) || !arrayList3.isEmpty()) {
            java.util.Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                if (!((kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument) it.next()).isConsistent()) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            kotlin.reflect.jvm.internal.impl.types.SimpleType nothingType2 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getBuiltIns(type).getNothingType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nothingType2, "getNothingType(...)");
            simpleTypeReplaceTypeArguments = nothingType2;
        } else {
            simpleTypeReplaceTypeArguments = replaceTypeArguments(type, arrayList);
        }
        return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds<>(simpleTypeReplaceTypeArguments, replaceTypeArguments(type, arrayList2));
    }

    private static final kotlin.reflect.jvm.internal.impl.types.KotlinType approximateCapturedTypes$makeNullableIfNeeded(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeMakeNullableIfNeeded = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullableIfNeeded(kotlinType, kotlinType2.isMarkedNullable());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kotlinTypeMakeNullableIfNeeded, "makeNullableIfNeeded(...)");
        return kotlinTypeMakeNullableIfNeeded;
    }

    private static final kotlin.reflect.jvm.internal.impl.types.KotlinType replaceTypeArguments(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, java.util.List<kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument> list) {
        kotlinType.getArguments().size();
        list.size();
        java.util.List<kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument> list2 = list;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
        java.util.Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toTypeProjection((kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument) it.next()));
        }
        return kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.replace$default(kotlinType, arrayList, null, null, 6, null);
    }

    private static final kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds<kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument> approximateProjection(kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument typeArgument) {
        kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds<kotlin.reflect.jvm.internal.impl.types.KotlinType> approximationBoundsApproximateCapturedTypes = approximateCapturedTypes(typeArgument.getInProjection());
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeComponent1 = approximationBoundsApproximateCapturedTypes.component1();
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeComponent2 = approximationBoundsApproximateCapturedTypes.component2();
        kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds<kotlin.reflect.jvm.internal.impl.types.KotlinType> approximationBoundsApproximateCapturedTypes2 = approximateCapturedTypes(typeArgument.getOutProjection());
        return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds<>(new kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument(typeArgument.getTypeParameter(), kotlinTypeComponent2, approximationBoundsApproximateCapturedTypes2.component1()), new kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument(typeArgument.getTypeParameter(), kotlinTypeComponent1, approximationBoundsApproximateCapturedTypes2.component2()));
    }
}
