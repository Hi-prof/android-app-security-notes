package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeAliasExpander.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeAliasExpander {
    public static final kotlin.reflect.jvm.internal.impl.types.TypeAliasExpander.Companion Companion = new kotlin.reflect.jvm.internal.impl.types.TypeAliasExpander.Companion(null);
    private static final kotlin.reflect.jvm.internal.impl.types.TypeAliasExpander NON_REPORTING = new kotlin.reflect.jvm.internal.impl.types.TypeAliasExpander(kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false);
    private final kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy reportStrategy;
    private final boolean shouldCheckBounds;

    public TypeAliasExpander(kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy reportStrategy, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reportStrategy, "reportStrategy");
        this.reportStrategy = reportStrategy;
        this.shouldCheckBounds = z;
    }

    public final kotlin.reflect.jvm.internal.impl.types.SimpleType expand(kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion typeAliasExpansion, kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAliasExpansion, "typeAliasExpansion");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attributes, "attributes");
        return expandRecursively(typeAliasExpansion, attributes, false, 0, true);
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType expandRecursively(kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion typeAliasExpansion, kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes, boolean z, int i, boolean z2) {
        kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjectionExpandTypeProjection = expandTypeProjection(new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT, typeAliasExpansion.getDescriptor().getUnderlyingType()), typeAliasExpansion, null, i);
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = typeProjectionExpandTypeProjection.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeAsSimpleType = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.asSimpleType(type);
        if (kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(simpleTypeAsSimpleType)) {
            return simpleTypeAsSimpleType;
        }
        typeProjectionExpandTypeProjection.getProjectionKind();
        kotlin.reflect.jvm.internal.impl.types.Variance variance = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT;
        checkRepeatedAnnotations(simpleTypeAsSimpleType.getAnnotations(), kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttributeKt.getAnnotations(typeAttributes));
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeMakeNullableIfNeeded = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullableIfNeeded(combineAttributes(simpleTypeAsSimpleType, typeAttributes), z);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(simpleTypeMakeNullableIfNeeded, "let(...)");
        return z2 ? kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.withAbbreviation(simpleTypeMakeNullableIfNeeded, createAbbreviation(typeAliasExpansion, typeAttributes, z)) : simpleTypeMakeNullableIfNeeded;
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType createAbbreviation(kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion typeAliasExpansion, kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes, boolean z) {
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = typeAliasExpansion.getDescriptor().getTypeConstructor();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(typeAttributes, typeConstructor, typeAliasExpansion.getArguments(), z, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty.INSTANCE);
    }

    private final kotlin.reflect.jvm.internal.impl.types.TypeProjection expandTypeProjection(kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection, kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion typeAliasExpansion, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor, int i) {
        kotlin.reflect.jvm.internal.impl.types.Variance variance;
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeCombineNullabilityAndAnnotations;
        Companion.assertRecursionDepth(i, typeAliasExpansion.getDescriptor());
        if (typeProjection.isStarProjection()) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameterDescriptor);
            kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjectionMakeStarProjection = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeStarProjection(typeParameterDescriptor);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeProjectionMakeStarProjection, "makeStarProjection(...)");
            return typeProjectionMakeStarProjection;
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = typeProjection.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        kotlin.reflect.jvm.internal.impl.types.TypeProjection replacement = typeAliasExpansion.getReplacement(type.getConstructor());
        if (replacement == null) {
            return expandNonArgumentTypeProjection(typeProjection, typeAliasExpansion, i);
        }
        if (replacement.isStarProjection()) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameterDescriptor);
            kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjectionMakeStarProjection2 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeStarProjection(typeParameterDescriptor);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeProjectionMakeStarProjection2, "makeStarProjection(...)");
            return typeProjectionMakeStarProjection2;
        }
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = replacement.getType().unwrap();
        kotlin.reflect.jvm.internal.impl.types.Variance projectionKind = replacement.getProjectionKind();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(projectionKind, "getProjectionKind(...)");
        kotlin.reflect.jvm.internal.impl.types.Variance projectionKind2 = typeProjection.getProjectionKind();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(projectionKind2, "getProjectionKind(...)");
        if (projectionKind2 != projectionKind && projectionKind2 != kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT) {
            if (projectionKind == kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT) {
                projectionKind = projectionKind2;
            } else {
                this.reportStrategy.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, unwrappedTypeUnwrap);
            }
        }
        if (typeParameterDescriptor == null || (variance = typeParameterDescriptor.getVariance()) == null) {
            variance = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT;
        }
        if (variance != projectionKind && variance != kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT) {
            if (projectionKind == kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT) {
                projectionKind = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT;
            } else {
                this.reportStrategy.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, unwrappedTypeUnwrap);
            }
        }
        checkRepeatedAnnotations(type.getAnnotations(), unwrappedTypeUnwrap.getAnnotations());
        if (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.DynamicType) {
            simpleTypeCombineNullabilityAndAnnotations = combineAttributes((kotlin.reflect.jvm.internal.impl.types.DynamicType) unwrappedTypeUnwrap, type.getAttributes());
        } else {
            simpleTypeCombineNullabilityAndAnnotations = combineNullabilityAndAnnotations(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.asSimpleType(unwrappedTypeUnwrap), type);
        }
        return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(projectionKind, simpleTypeCombineNullabilityAndAnnotations);
    }

    private final kotlin.reflect.jvm.internal.impl.types.DynamicType combineAttributes(kotlin.reflect.jvm.internal.impl.types.DynamicType dynamicType, kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes) {
        return dynamicType.replaceAttributes(createdCombinedAttributes(dynamicType, typeAttributes));
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType combineAttributes(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes) {
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType2 = simpleType;
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(simpleType2) ? simpleType : kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.replace$default(simpleType, null, createdCombinedAttributes(simpleType2, typeAttributes), 1, null);
    }

    private final kotlin.reflect.jvm.internal.impl.types.TypeAttributes createdCombinedAttributes(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes) {
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(kotlinType) ? kotlinType.getAttributes() : typeAttributes.add(kotlinType.getAttributes());
    }

    private final void checkRepeatedAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations2) {
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> it = annotations.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getFqName());
        }
        java.util.HashSet hashSet2 = hashSet;
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptor : annotations2) {
            if (hashSet2.contains(annotationDescriptor.getFqName())) {
                this.reportStrategy.repeatedAnnotation(annotationDescriptor);
            }
        }
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType combineNullability(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeMakeNullableIfNeeded = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullableIfNeeded(simpleType, kotlinType.isMarkedNullable());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(simpleTypeMakeNullableIfNeeded, "makeNullableIfNeeded(...)");
        return simpleTypeMakeNullableIfNeeded;
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType combineNullabilityAndAnnotations(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        return combineAttributes(combineNullability(simpleType, kotlinType), kotlinType.getAttributes());
    }

    private final kotlin.reflect.jvm.internal.impl.types.TypeProjection expandNonArgumentTypeProjection(kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection, kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion typeAliasExpansion, int i) {
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = typeProjection.getType().unwrap();
        if (!kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt.isDynamic(unwrappedTypeUnwrap)) {
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeAsSimpleType = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.asSimpleType(unwrappedTypeUnwrap);
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType = simpleTypeAsSimpleType;
            if (!kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(simpleType) && kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.requiresTypeAliasExpansion(simpleType)) {
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor = simpleTypeAsSimpleType.getConstructor();
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = constructor.mo1835getDeclarationDescriptor();
                constructor.getParameters().size();
                simpleTypeAsSimpleType.getArguments().size();
                if (!(classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor)) {
                    if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) {
                        kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) classifierDescriptorMo1835getDeclarationDescriptor;
                        if (typeAliasExpansion.isRecursion(typeAliasDescriptor)) {
                            this.reportStrategy.recursiveTypeAlias(typeAliasDescriptor);
                            return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT, kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.RECURSIVE_TYPE_ALIAS, typeAliasDescriptor.getName().toString()));
                        }
                        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments = simpleTypeAsSimpleType.getArguments();
                        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arguments, 10));
                        int i2 = 0;
                        for (java.lang.Object obj : arguments) {
                            int i3 = i2 + 1;
                            if (i2 < 0) {
                                kotlin.collections.CollectionsKt.throwIndexOverflow();
                            }
                            arrayList.add(expandTypeProjection((kotlin.reflect.jvm.internal.impl.types.TypeProjection) obj, typeAliasExpansion, constructor.getParameters().get(i2), i + 1));
                            i2 = i3;
                        }
                        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeExpandRecursively = expandRecursively(kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion.Companion.create(typeAliasExpansion, typeAliasDescriptor, arrayList), simpleTypeAsSimpleType.getAttributes(), simpleTypeAsSimpleType.isMarkedNullable(), i + 1, false);
                        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeSubstituteArguments = substituteArguments(simpleTypeAsSimpleType, typeAliasExpansion, i);
                        if (!kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt.isDynamic(simpleTypeExpandRecursively)) {
                            simpleTypeExpandRecursively = kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.withAbbreviation(simpleTypeExpandRecursively, simpleTypeSubstituteArguments);
                        }
                        return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(typeProjection.getProjectionKind(), simpleTypeExpandRecursively);
                    }
                    kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeSubstituteArguments2 = substituteArguments(simpleTypeAsSimpleType, typeAliasExpansion, i);
                    checkTypeArgumentsSubstitution(simpleType, simpleTypeSubstituteArguments2);
                    return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(typeProjection.getProjectionKind(), simpleTypeSubstituteArguments2);
                }
            }
        }
        return typeProjection;
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType substituteArguments(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion typeAliasExpansion, int i) {
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor = simpleType.getConstructor();
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments = simpleType.getArguments();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arguments, 10));
        int i2 = 0;
        for (java.lang.Object obj : arguments) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) obj;
            kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl typeProjectionImplExpandTypeProjection = expandTypeProjection(typeProjection, typeAliasExpansion, constructor.getParameters().get(i2), i + 1);
            if (!typeProjectionImplExpandTypeProjection.isStarProjection()) {
                typeProjectionImplExpandTypeProjection = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(typeProjectionImplExpandTypeProjection.getProjectionKind(), kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullableIfNeeded(typeProjectionImplExpandTypeProjection.getType(), typeProjection.getType().isMarkedNullable()));
            }
            arrayList.add(typeProjectionImplExpandTypeProjection);
            i2 = i3;
        }
        return kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.replace$default(simpleType, arrayList, null, 2, null);
    }

    private final void checkTypeArgumentsSubstitution(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2) {
        kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutorCreate = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.create(kotlinType2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeSubstitutorCreate, "create(...)");
        int i = 0;
        for (java.lang.Object obj : kotlinType2.getArguments()) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) obj;
            if (!typeProjection.isStarProjection()) {
                kotlin.reflect.jvm.internal.impl.types.KotlinType type = typeProjection.getType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                if (!kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.containsTypeAliasParameters(type)) {
                    kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection2 = kotlinType.getArguments().get(i);
                    kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = kotlinType.getConstructor().getParameters().get(i);
                    if (this.shouldCheckBounds) {
                        kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy = this.reportStrategy;
                        kotlin.reflect.jvm.internal.impl.types.KotlinType type2 = typeProjection2.getType();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                        kotlin.reflect.jvm.internal.impl.types.KotlinType type3 = typeProjection.getType();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type3, "getType(...)");
                        kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameterDescriptor);
                        typeAliasExpansionReportStrategy.boundsViolationInSubstitution(typeSubstitutorCreate, type2, type3, typeParameterDescriptor);
                    }
                }
            }
            i = i2;
        }
    }

    /* JADX INFO: compiled from: TypeAliasExpander.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void assertRecursionDepth(int i, kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor) {
            if (i <= 100) {
                return;
            }
            throw new java.lang.AssertionError("Too deep recursion while expanding type alias " + typeAliasDescriptor.getName());
        }
    }
}
