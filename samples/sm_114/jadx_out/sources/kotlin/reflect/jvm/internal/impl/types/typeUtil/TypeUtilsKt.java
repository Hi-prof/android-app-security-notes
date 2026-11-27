package kotlin.reflect.jvm.internal.impl.types.typeUtil;

/* JADX INFO: compiled from: TypeUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeUtilsKt {
    public static final boolean hasTypeParameterRecursiveBounds(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        return hasTypeParameterRecursiveBounds$default(typeParameter, null, null, 6, null);
    }

    public static final kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns getBuiltIns(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns = kotlinType.getConstructor().getBuiltIns();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(builtIns, "getBuiltIns(...)");
        return builtIns;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType makeNullable(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeMakeNullable = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullable(kotlinType);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kotlinTypeMakeNullable, "makeNullable(...)");
        return kotlinTypeMakeNullable;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType makeNotNullable(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeMakeNotNullable = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNotNullable(kotlinType);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kotlinTypeMakeNotNullable, "makeNotNullable(...)");
        return kotlinTypeMakeNotNullable;
    }

    public static final boolean isNothing(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isNothing(kotlinType);
    }

    public static final boolean isBoolean(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBoolean(kotlinType);
    }

    public static final boolean isTypeParameter(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlin.reflect.jvm.internal.impl.types.TypeUtils.isTypeParameter(kotlinType);
    }

    public static final boolean containsTypeParameter(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlin.reflect.jvm.internal.impl.types.TypeUtils.contains(kotlinType, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.containsTypeParameter$lambda$0((kotlin.reflect.jvm.internal.impl.types.UnwrappedType) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Boolean containsTypeParameter$lambda$0(kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType) {
        return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.types.TypeUtils.isTypeParameter(unwrappedType));
    }

    public static final boolean isSubtypeOf(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType superType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(superType, "superType");
        return kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT.isSubtypeOf(kotlinType, superType);
    }

    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType replaceAnnotations(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations newAnnotations) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        return (kotlinType.getAnnotations().isEmpty() && newAnnotations.isEmpty()) ? kotlinType : kotlinType.unwrap().replaceAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt.replaceAnnotations(kotlinType.getAttributes(), newAnnotations));
    }

    public static final kotlin.reflect.jvm.internal.impl.types.TypeProjection createProjection(kotlin.reflect.jvm.internal.impl.types.KotlinType type, kotlin.reflect.jvm.internal.impl.types.Variance projectionKind, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(projectionKind, "projectionKind");
        if ((typeParameterDescriptor != null ? typeParameterDescriptor.getVariance() : null) == projectionKind) {
            projectionKind = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT;
        }
        return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(projectionKind, type);
    }

    public static final kotlin.reflect.jvm.internal.impl.types.TypeProjection asTypeProjection(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(kotlinType);
    }

    public static final boolean contains(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.UnwrappedType, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        return kotlin.reflect.jvm.internal.impl.types.TypeUtils.contains(kotlinType, predicate);
    }

    public static final java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> extractTypeParametersFromUpperBounds(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, java.util.Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> set) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        extractTypeParametersFromUpperBounds(kotlinType, kotlinType, linkedHashSet, set);
        return linkedHashSet;
    }

    private static final void extractTypeParametersFromUpperBounds(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2, java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> set, java.util.Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> set2) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) {
            if (!kotlin.jvm.internal.Intrinsics.areEqual(kotlinType.getConstructor(), kotlinType2.getConstructor())) {
                set.add(classifierDescriptorMo1835getDeclarationDescriptor);
                return;
            }
            for (kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType3 : ((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) classifierDescriptorMo1835getDeclarationDescriptor).getUpperBounds()) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinType3);
                extractTypeParametersFromUpperBounds(kotlinType3, kotlinType2, set, set2);
            }
            return;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor2 = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = classifierDescriptorMo1835getDeclarationDescriptor2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters) classifierDescriptorMo1835getDeclarationDescriptor2 : null;
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters != null ? classifierDescriptorWithTypeParameters.getDeclaredTypeParameters() : null;
        int i = 0;
        for (kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection : kotlinType.getArguments()) {
            int i2 = i + 1;
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = declaredTypeParameters != null ? (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) kotlin.collections.CollectionsKt.getOrNull(declaredTypeParameters, i) : null;
            if ((typeParameterDescriptor == null || set2 == null || !set2.contains(typeParameterDescriptor)) && !typeProjection.isStarProjection() && !kotlin.collections.CollectionsKt.contains(set, typeProjection.getType().getConstructor().mo1835getDeclarationDescriptor()) && !kotlin.jvm.internal.Intrinsics.areEqual(typeProjection.getType().getConstructor(), kotlinType2.getConstructor())) {
                kotlin.reflect.jvm.internal.impl.types.KotlinType type = typeProjection.getType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                extractTypeParametersFromUpperBounds(type, kotlinType2, set, set2);
            }
            i = i2;
        }
    }

    public static /* synthetic */ boolean hasTypeParameterRecursiveBounds$default(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, java.util.Set set, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            typeConstructor = null;
        }
        if ((i & 4) != 0) {
            set = null;
        }
        return hasTypeParameterRecursiveBounds(typeParameterDescriptor, typeConstructor, set);
    }

    public static final boolean hasTypeParameterRecursiveBounds(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameter, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, java.util.Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> set) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> upperBounds = typeParameter.getUpperBounds();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> list = upperBounds;
        if ((list instanceof java.util.Collection) && list.isEmpty()) {
            return false;
        }
        for (kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType : list) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinType);
            if (containsSelfTypeParameter(kotlinType, typeParameter.getDefaultType().getConstructor(), set) && (typeConstructor == null || kotlin.jvm.internal.Intrinsics.areEqual(kotlinType.getConstructor(), typeConstructor))) {
                return true;
            }
        }
        return false;
    }

    private static final boolean containsSelfTypeParameter(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, java.util.Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> set) {
        boolean zContainsSelfTypeParameter;
        if (kotlin.jvm.internal.Intrinsics.areEqual(kotlinType.getConstructor(), typeConstructor)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters) classifierDescriptorMo1835getDeclarationDescriptor : null;
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters != null ? classifierDescriptorWithTypeParameters.getDeclaredTypeParameters() : null;
        java.lang.Iterable<kotlin.collections.IndexedValue> iterableWithIndex = kotlin.collections.CollectionsKt.withIndex(kotlinType.getArguments());
        if ((iterableWithIndex instanceof java.util.Collection) && ((java.util.Collection) iterableWithIndex).isEmpty()) {
            return false;
        }
        for (kotlin.collections.IndexedValue indexedValue : iterableWithIndex) {
            int index = indexedValue.getIndex();
            kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) indexedValue.component2();
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = declaredTypeParameters != null ? (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) kotlin.collections.CollectionsKt.getOrNull(declaredTypeParameters, index) : null;
            if ((typeParameterDescriptor == null || set == null || !set.contains(typeParameterDescriptor)) && !typeProjection.isStarProjection()) {
                kotlin.reflect.jvm.internal.impl.types.KotlinType type = typeProjection.getType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                zContainsSelfTypeParameter = containsSelfTypeParameter(type, typeConstructor, set);
            } else {
                zContainsSelfTypeParameter = false;
            }
            if (zContainsSelfTypeParameter) {
                return true;
            }
        }
        return false;
    }

    public static final boolean containsTypeAliasParameters(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return contains(kotlinType, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.containsTypeAliasParameters$lambda$13((kotlin.reflect.jvm.internal.impl.types.UnwrappedType) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean containsTypeAliasParameters$lambda$13(kotlin.reflect.jvm.internal.impl.types.UnwrappedType it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = it.getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor != null) {
            return isTypeAliasParameter(classifierDescriptorMo1835getDeclarationDescriptor);
        }
        return false;
    }

    public static final boolean isTypeAliasParameter(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classifierDescriptor, "<this>");
        return (classifierDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) && (((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) classifierDescriptor).getContainingDeclaration() instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor);
    }

    public static final boolean requiresTypeAliasExpansion(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return contains(kotlinType, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$$Lambda$4
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.requiresTypeAliasExpansion$lambda$16((kotlin.reflect.jvm.internal.impl.types.UnwrappedType) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean requiresTypeAliasExpansion$lambda$16(kotlin.reflect.jvm.internal.impl.types.UnwrappedType it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = it.getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor != null) {
            return (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) || (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor);
        }
        return false;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType getRepresentativeUpperBound(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor) {
        java.lang.Object obj;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameterDescriptor, "<this>");
        java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
        upperBounds.isEmpty();
        java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> upperBounds2 = typeParameterDescriptor.getUpperBounds();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperBounds2, "getUpperBounds(...)");
        java.util.Iterator<T> it = upperBounds2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            java.lang.Object next = it.next();
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = ((kotlin.reflect.jvm.internal.impl.types.KotlinType) next).getConstructor().mo1835getDeclarationDescriptor();
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null;
            if (classDescriptor != null && classDescriptor.getKind() != kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE && classDescriptor.getKind() != kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS) {
                obj = next;
                break;
            }
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType = (kotlin.reflect.jvm.internal.impl.types.KotlinType) obj;
        if (kotlinType != null) {
            return kotlinType;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> upperBounds3 = typeParameterDescriptor.getUpperBounds();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperBounds3, "getUpperBounds(...)");
        java.lang.Object objFirst = kotlin.collections.CollectionsKt.first((java.util.List<? extends java.lang.Object>) upperBounds3);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objFirst, "first(...)");
        return (kotlin.reflect.jvm.internal.impl.types.KotlinType) objFirst;
    }

    public static final boolean shouldBeUpdated(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        return kotlinType == null || contains(kotlinType, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$$Lambda$5
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.shouldBeUpdated$lambda$23((kotlin.reflect.jvm.internal.impl.types.UnwrappedType) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldBeUpdated$lambda$23(kotlin.reflect.jvm.internal.impl.types.UnwrappedType it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return (it instanceof kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference) || (it.getConstructor() instanceof kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker) || kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(it);
    }

    public static final boolean isStubType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (kotlinType instanceof kotlin.reflect.jvm.internal.impl.types.AbstractStubType) {
            return true;
        }
        return (kotlinType instanceof kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType) && (((kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType) kotlinType).getOriginal() instanceof kotlin.reflect.jvm.internal.impl.types.AbstractStubType);
    }

    public static final boolean isStubTypeForBuilderInference(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (kotlinType instanceof kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference) {
            return true;
        }
        return (kotlinType instanceof kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType) && (((kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType) kotlinType).getOriginal() instanceof kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference);
    }

    public static final boolean isUnresolvedType(kotlin.reflect.jvm.internal.impl.types.KotlinType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        return (type instanceof kotlin.reflect.jvm.internal.impl.types.error.ErrorType) && ((kotlin.reflect.jvm.internal.impl.types.error.ErrorType) type).getKind().isUnresolved();
    }

    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType replaceArgumentsWithStarProjections(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeFlexibleType;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
        if (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType) {
            kotlin.reflect.jvm.internal.impl.types.FlexibleType flexibleType = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) unwrappedTypeUnwrap;
            kotlin.reflect.jvm.internal.impl.types.SimpleType lowerBound = flexibleType.getLowerBound();
            if (!lowerBound.getConstructor().getParameters().isEmpty() && lowerBound.getConstructor().mo1835getDeclarationDescriptor() != null) {
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = lowerBound.getConstructor().getParameters();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list = parameters;
                java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
                java.util.Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) it.next()));
                }
                lowerBound = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.replace$default(lowerBound, arrayList, null, 2, null);
            }
            kotlin.reflect.jvm.internal.impl.types.SimpleType upperBound = flexibleType.getUpperBound();
            if (!upperBound.getConstructor().getParameters().isEmpty() && upperBound.getConstructor().mo1835getDeclarationDescriptor() != null) {
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters2 = upperBound.getConstructor().getParameters();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters2, "getParameters(...)");
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list2 = parameters2;
                java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
                java.util.Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) it2.next()));
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
                java.util.Iterator<T> it3 = list3.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) it3.next()));
                }
                simpleTypeReplace$default = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.replace$default(simpleTypeReplace$default, arrayList3, null, 2, null);
            }
            simpleTypeFlexibleType = simpleTypeReplace$default;
        }
        return kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.inheritEnhancement(simpleTypeFlexibleType, unwrappedTypeUnwrap);
    }
}
