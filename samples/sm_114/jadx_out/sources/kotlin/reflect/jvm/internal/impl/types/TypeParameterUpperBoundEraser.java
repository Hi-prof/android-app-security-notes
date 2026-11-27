package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeParameterUpperBoundEraser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeParameterUpperBoundEraser {
    public static final kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser.Companion Companion = new kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser.Companion(null);
    private final kotlin.Lazy erroneousErasedBound$delegate;
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser.DataToEraseUpperBound, kotlin.reflect.jvm.internal.impl.types.KotlinType> getErasedUpperBound;
    private final kotlin.reflect.jvm.internal.impl.types.TypeParameterErasureOptions options;
    private final kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer projectionComputer;
    private final kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager storage;

    public TypeParameterUpperBoundEraser(kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer projectionComputer, kotlin.reflect.jvm.internal.impl.types.TypeParameterErasureOptions options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(projectionComputer, "projectionComputer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        this.projectionComputer = projectionComputer;
        this.options = options;
        kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager lockBasedStorageManager = new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager("Type parameter upper bound erasure results");
        this.storage = lockBasedStorageManager;
        this.erroneousErasedBound$delegate = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser.erroneousErasedBound_delegate$lambda$0(this.arg$0);
            }
        });
        kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser.DataToEraseUpperBound, kotlin.reflect.jvm.internal.impl.types.KotlinType> memoizedFunctionToNotNullCreateMemoizedFunction = lockBasedStorageManager.createMemoizedFunction(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser.getErasedUpperBound$lambda$2(this.arg$0, (kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser.DataToEraseUpperBound) obj);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(memoizedFunctionToNotNullCreateMemoizedFunction, "createMemoizedFunction(...)");
        this.getErasedUpperBound = memoizedFunctionToNotNullCreateMemoizedFunction;
    }

    public /* synthetic */ TypeParameterUpperBoundEraser(kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer erasureProjectionComputer, kotlin.reflect.jvm.internal.impl.types.TypeParameterErasureOptions typeParameterErasureOptions, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(erasureProjectionComputer, (i & 2) != 0 ? new kotlin.reflect.jvm.internal.impl.types.TypeParameterErasureOptions(false, false) : typeParameterErasureOptions);
    }

    private final kotlin.reflect.jvm.internal.impl.types.error.ErrorType getErroneousErasedBound() {
        return (kotlin.reflect.jvm.internal.impl.types.error.ErrorType) this.erroneousErasedBound$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorType erroneousErasedBound_delegate$lambda$0(kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser typeParameterUpperBoundEraser) {
        return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.CANNOT_COMPUTE_ERASED_BOUND, typeParameterUpperBoundEraser.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TypeParameterUpperBoundEraser.kt */
    static final class DataToEraseUpperBound {
        private final kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes typeAttr;
        private final kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameter;

        public java.lang.String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.typeParameter + ", typeAttr=" + this.typeAttr + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }

        public DataToEraseUpperBound(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameter, kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes typeAttr) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
            this.typeParameter = typeParameter;
            this.typeAttr = typeAttr;
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor getTypeParameter() {
            return this.typeParameter;
        }

        public final kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes getTypeAttr() {
            return this.typeAttr;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser.DataToEraseUpperBound)) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser.DataToEraseUpperBound dataToEraseUpperBound = (kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser.DataToEraseUpperBound) obj;
            return kotlin.jvm.internal.Intrinsics.areEqual(dataToEraseUpperBound.typeParameter, this.typeParameter) && kotlin.jvm.internal.Intrinsics.areEqual(dataToEraseUpperBound.typeAttr, this.typeAttr);
        }

        public int hashCode() {
            int iHashCode = this.typeParameter.hashCode();
            return iHashCode + (iHashCode * 31) + this.typeAttr.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType getErasedUpperBound$lambda$2(kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser.DataToEraseUpperBound dataToEraseUpperBound) {
        return typeParameterUpperBoundEraser.getErasedUpperBoundInternal(dataToEraseUpperBound.getTypeParameter(), dataToEraseUpperBound.getTypeAttr());
    }

    public final kotlin.reflect.jvm.internal.impl.types.KotlinType getErasedUpperBound(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameter, kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes typeAttr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeInvoke = this.getErasedUpperBound.invoke2(new kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser.DataToEraseUpperBound(typeParameter, typeAttr));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kotlinTypeInvoke, "invoke(...)");
        return kotlinTypeInvoke;
    }

    private final kotlin.reflect.jvm.internal.impl.types.KotlinType getDefaultType(kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes erasureTypeAttributes) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeReplaceArgumentsWithStarProjections;
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = erasureTypeAttributes.getDefaultType();
        return (defaultType == null || (kotlinTypeReplaceArgumentsWithStarProjections = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType)) == null) ? getErroneousErasedBound() : kotlinTypeReplaceArgumentsWithStarProjections;
    }

    private final kotlin.reflect.jvm.internal.impl.types.KotlinType getErasedUpperBoundInternal(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor, kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes erasureTypeAttributes) {
        kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjectionComputeProjection;
        java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> visitedTypeParameters = erasureTypeAttributes.getVisitedTypeParameters();
        if (visitedTypeParameters != null && visitedTypeParameters.contains(typeParameterDescriptor.getOriginal())) {
            return getDefaultType(erasureTypeAttributes);
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = typeParameterDescriptor.getDefaultType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
        java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> setExtractTypeParametersFromUpperBounds = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.extractTypeParametersFromUpperBounds(defaultType, visitedTypeParameters);
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(kotlin.ranges.RangesKt.coerceAtLeast(kotlin.collections.MapsKt.mapCapacity(kotlin.collections.CollectionsKt.collectionSizeOrDefault(setExtractTypeParametersFromUpperBounds, 10)), 16));
        for (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor2 : setExtractTypeParametersFromUpperBounds) {
            if (visitedTypeParameters == null || !visitedTypeParameters.contains(typeParameterDescriptor2)) {
                typeProjectionComputeProjection = this.projectionComputer.computeProjection(typeParameterDescriptor2, erasureTypeAttributes, this, getErasedUpperBound(typeParameterDescriptor2, erasureTypeAttributes.withNewVisitedTypeParameter(typeParameterDescriptor)));
            } else {
                typeProjectionComputeProjection = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeStarProjection(typeParameterDescriptor2, erasureTypeAttributes);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeProjectionComputeProjection, "makeStarProjection(...)");
            }
            kotlin.Pair pair = kotlin.TuplesKt.to(typeParameterDescriptor2.getTypeConstructor(), typeProjectionComputeProjection);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutorCreate = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.create(kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion.createByConstructorsMap$default(kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion, linkedHashMap, false, 2, null));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeSubstitutorCreate, "create(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
        java.util.Set<kotlin.reflect.jvm.internal.impl.types.KotlinType> setSubstituteErasedUpperBounds = substituteErasedUpperBounds(typeSubstitutorCreate, upperBounds, erasureTypeAttributes);
        if (!setSubstituteErasedUpperBounds.isEmpty()) {
            if (!this.options.getIntersectUpperBounds()) {
                if (setSubstituteErasedUpperBounds.size() != 1) {
                    throw new java.lang.IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds".toString());
                }
                return (kotlin.reflect.jvm.internal.impl.types.KotlinType) kotlin.collections.CollectionsKt.single(setSubstituteErasedUpperBounds);
            }
            java.util.List list = kotlin.collections.CollectionsKt.toList(setSubstituteErasedUpperBounds);
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next()).unwrap());
            }
            return kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt.intersectTypes(arrayList);
        }
        return getDefaultType(erasureTypeAttributes);
    }

    private final java.util.Set<kotlin.reflect.jvm.internal.impl.types.KotlinType> substituteErasedUpperBounds(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutor, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> list, kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes erasureTypeAttributes) {
        java.util.Set setCreateSetBuilder = kotlin.collections.SetsKt.createSetBuilder();
        for (kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType : list) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
            if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
                setCreateSetBuilder.add(Companion.replaceArgumentsOfUpperBound(kotlinType, typeSubstitutor, erasureTypeAttributes.getVisitedTypeParameters(), this.options.getLeaveNonTypeParameterTypes()));
            } else if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) {
                java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> visitedTypeParameters = erasureTypeAttributes.getVisitedTypeParameters();
                if (visitedTypeParameters != null && visitedTypeParameters.contains(classifierDescriptorMo1835getDeclarationDescriptor)) {
                    setCreateSetBuilder.add(getDefaultType(erasureTypeAttributes));
                } else {
                    java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> upperBounds = ((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) classifierDescriptorMo1835getDeclarationDescriptor).getUpperBounds();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                    setCreateSetBuilder.addAll(substituteErasedUpperBounds(typeSubstitutor, upperBounds, erasureTypeAttributes));
                }
            }
            if (!this.options.getIntersectUpperBounds()) {
                break;
            }
        }
        return kotlin.collections.SetsKt.build(setCreateSetBuilder);
    }

    /* JADX INFO: compiled from: TypeParameterUpperBoundEraser.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:29:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:57:0x0142  */
        /* JADX WARN: Code duplicated, block: B:88:0x01e3  */
        public final kotlin.reflect.jvm.internal.impl.types.KotlinType replaceArgumentsOfUpperBound(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor substitutor, java.util.Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> set, boolean z) {
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeFlexibleType;
            kotlin.reflect.jvm.internal.impl.types.KotlinType type;
            kotlin.reflect.jvm.internal.impl.types.KotlinType type2;
            kotlin.reflect.jvm.internal.impl.types.KotlinType type3;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(substitutor, "substitutor");
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
            if (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType) {
                kotlin.reflect.jvm.internal.impl.types.FlexibleType flexibleType = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) unwrappedTypeUnwrap;
                kotlin.reflect.jvm.internal.impl.types.SimpleType lowerBound = flexibleType.getLowerBound();
                if (!lowerBound.getConstructor().getParameters().isEmpty() && lowerBound.getConstructor().mo1835getDeclarationDescriptor() != null) {
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = lowerBound.getConstructor().getParameters();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list = parameters;
                    java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor : list) {
                        kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl starProjectionImpl = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) kotlin.collections.CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor.getIndex());
                        if (!z || starProjectionImpl == null || (type3 = starProjectionImpl.getType()) == null || kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.containsTypeParameter(type3)) {
                            boolean z2 = set != null && set.contains(typeParameterDescriptor);
                            if (starProjectionImpl == null || z2) {
                                starProjectionImpl = new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl(typeParameterDescriptor);
                            } else {
                                kotlin.reflect.jvm.internal.impl.types.TypeSubstitution substitution = substitutor.getSubstitution();
                                kotlin.reflect.jvm.internal.impl.types.KotlinType type4 = starProjectionImpl.getType();
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type4, "getType(...)");
                                if (substitution.mo1840get(type4) == null) {
                                    starProjectionImpl = new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl(typeParameterDescriptor);
                                }
                            }
                        }
                        arrayList.add(starProjectionImpl);
                    }
                    lowerBound = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.replace$default(lowerBound, arrayList, null, 2, null);
                }
                kotlin.reflect.jvm.internal.impl.types.SimpleType upperBound = flexibleType.getUpperBound();
                if (!upperBound.getConstructor().getParameters().isEmpty() && upperBound.getConstructor().mo1835getDeclarationDescriptor() != null) {
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters2 = upperBound.getConstructor().getParameters();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters2, "getParameters(...)");
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list2 = parameters2;
                    java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor2 : list2) {
                        kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl starProjectionImpl2 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) kotlin.collections.CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor2.getIndex());
                        if (!z || starProjectionImpl2 == null || (type2 = starProjectionImpl2.getType()) == null || kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.containsTypeParameter(type2)) {
                            boolean z3 = set != null && set.contains(typeParameterDescriptor2);
                            if (starProjectionImpl2 == null || z3) {
                                starProjectionImpl2 = new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl(typeParameterDescriptor2);
                            } else {
                                kotlin.reflect.jvm.internal.impl.types.TypeSubstitution substitution2 = substitutor.getSubstitution();
                                kotlin.reflect.jvm.internal.impl.types.KotlinType type5 = starProjectionImpl2.getType();
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type5, "getType(...)");
                                if (substitution2.mo1840get(type5) == null) {
                                    starProjectionImpl2 = new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl(typeParameterDescriptor2);
                                }
                            }
                        }
                        arrayList2.add(starProjectionImpl2);
                    }
                    upperBound = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.replace$default(upperBound, arrayList2, null, 2, null);
                }
                simpleTypeFlexibleType = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(lowerBound, upperBound);
            } else {
                if (!(unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType)) {
                    throw new kotlin.NoWhenBranchMatchedException();
                }
                kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeReplace$default = (kotlin.reflect.jvm.internal.impl.types.SimpleType) unwrappedTypeUnwrap;
                if (!simpleTypeReplace$default.getConstructor().getParameters().isEmpty() && simpleTypeReplace$default.getConstructor().mo1835getDeclarationDescriptor() != null) {
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters3 = simpleTypeReplace$default.getConstructor().getParameters();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters3, "getParameters(...)");
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list3 = parameters3;
                    java.util.ArrayList arrayList3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list3, 10));
                    for (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor3 : list3) {
                        kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl starProjectionImpl3 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) kotlin.collections.CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor3.getIndex());
                        if (!z || starProjectionImpl3 == null || (type = starProjectionImpl3.getType()) == null || kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.containsTypeParameter(type)) {
                            boolean z4 = set != null && set.contains(typeParameterDescriptor3);
                            if (starProjectionImpl3 == null || z4) {
                                starProjectionImpl3 = new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl(typeParameterDescriptor3);
                            } else {
                                kotlin.reflect.jvm.internal.impl.types.TypeSubstitution substitution3 = substitutor.getSubstitution();
                                kotlin.reflect.jvm.internal.impl.types.KotlinType type6 = starProjectionImpl3.getType();
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type6, "getType(...)");
                                if (substitution3.mo1840get(type6) == null) {
                                    starProjectionImpl3 = new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl(typeParameterDescriptor3);
                                }
                            }
                        }
                        arrayList3.add(starProjectionImpl3);
                    }
                    simpleTypeReplace$default = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.replace$default(simpleTypeReplace$default, arrayList3, null, 2, null);
                }
                simpleTypeFlexibleType = simpleTypeReplace$default;
            }
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSafeSubstitute = substitutor.safeSubstitute(kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.inheritEnhancement(simpleTypeFlexibleType, unwrappedTypeUnwrap), kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kotlinTypeSafeSubstitute, "safeSubstitute(...)");
            return kotlinTypeSafeSubstitute;
        }
    }
}
