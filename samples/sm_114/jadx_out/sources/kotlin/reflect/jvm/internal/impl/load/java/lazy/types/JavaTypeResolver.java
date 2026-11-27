package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaTypeResolver {
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawProjectionComputer projectionComputer;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver typeParameterResolver;
    private final kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeResolver(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c, kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver typeParameterResolver) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameterResolver, "typeParameterResolver");
        this.c = c;
        this.typeParameterResolver = typeParameterResolver;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawProjectionComputer rawProjectionComputer = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawProjectionComputer();
        this.projectionComputer = rawProjectionComputer;
        this.typeParameterUpperBoundEraser = new kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser(rawProjectionComputer, null, 2, 0 == true ? 1 : 0);
    }

    public final kotlin.reflect.jvm.internal.impl.types.KotlinType transformJavaType(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType javaType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes attr) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeTransformJavaType;
        kotlin.reflect.jvm.internal.impl.types.SimpleType unitType;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attr, "attr");
        if (javaType instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType) {
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType type = ((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType) javaType).getType();
            if (type != null) {
                unitType = this.c.getModule().getBuiltIns().getPrimitiveKotlinType(type);
            } else {
                unitType = this.c.getModule().getBuiltIns().getUnitType();
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(unitType);
            return unitType;
        }
        if (javaType instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType) {
            return transformJavaClassifierType((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType) javaType, attr);
        }
        if (javaType instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType) {
            return transformArrayType$default(this, (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType) javaType, attr, false, 4, null);
        }
        if (javaType instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType) {
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType bound = ((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType) javaType).getBound();
            if (bound != null && (kotlinTypeTransformJavaType = transformJavaType(bound, attr)) != null) {
                return kotlinTypeTransformJavaType;
            }
            kotlin.reflect.jvm.internal.impl.types.SimpleType defaultBound = this.c.getModule().getBuiltIns().getDefaultBound();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultBound, "getDefaultBound(...)");
            return defaultBound;
        }
        if (javaType == null) {
            kotlin.reflect.jvm.internal.impl.types.SimpleType defaultBound2 = this.c.getModule().getBuiltIns().getDefaultBound();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultBound2, "getDefaultBound(...)");
            return defaultBound2;
        }
        throw new java.lang.UnsupportedOperationException("Unsupported type: " + javaType);
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.KotlinType transformArrayType$default(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver javaTypeResolver, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType javaArrayType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes, boolean z, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return javaTypeResolver.transformArrayType(javaArrayType, javaTypeAttributes, z);
    }

    public final kotlin.reflect.jvm.internal.impl.types.KotlinType transformArrayType(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType arrayType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes attr, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arrayType, "arrayType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attr, "attr");
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType componentType = arrayType.getComponentType();
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType javaPrimitiveType = componentType instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType ? (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType) componentType : null;
        kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType type = javaPrimitiveType != null ? javaPrimitiveType.getType() : null;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations lazyJavaAnnotations = new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations(this.c, arrayType, true);
        if (type != null) {
            kotlin.reflect.jvm.internal.impl.types.SimpleType primitiveArrayKotlinType = this.c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(type);
            kotlin.jvm.internal.Intrinsics.checkNotNull(primitiveArrayKotlinType);
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeReplaceAnnotations = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceAnnotations(primitiveArrayKotlinType, new kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations(primitiveArrayKotlinType.getAnnotations(), lazyJavaAnnotations));
            kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinTypeReplaceAnnotations, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType = (kotlin.reflect.jvm.internal.impl.types.SimpleType) kotlinTypeReplaceAnnotations;
            if (attr.isForAnnotationParameter()) {
                return simpleType;
            }
            return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(simpleType, simpleType.makeNullableAsSpecified(true));
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeTransformJavaType = transformJavaType(componentType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON, attr.isForAnnotationParameter(), false, null, 6, null));
        if (attr.isForAnnotationParameter()) {
            kotlin.reflect.jvm.internal.impl.types.SimpleType arrayType2 = this.c.getModule().getBuiltIns().getArrayType(z ? kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE : kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT, kotlinTypeTransformJavaType, lazyJavaAnnotations);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(arrayType2, "getArrayType(...)");
            return arrayType2;
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations lazyJavaAnnotations2 = lazyJavaAnnotations;
        kotlin.reflect.jvm.internal.impl.types.SimpleType arrayType3 = this.c.getModule().getBuiltIns().getArrayType(kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT, kotlinTypeTransformJavaType, lazyJavaAnnotations2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(arrayType3, "getArrayType(...)");
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(arrayType3, this.c.getModule().getBuiltIns().getArrayType(kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE, kotlinTypeTransformJavaType, lazyJavaAnnotations2).makeNullableAsSpecified(true));
    }

    private static final kotlin.reflect.jvm.internal.impl.types.error.ErrorType transformJavaClassifierType$errorType(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType javaClassifierType) {
        return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.UNRESOLVED_JAVA_CLASS, javaClassifierType.getPresentableText());
    }

    private final kotlin.reflect.jvm.internal.impl.types.KotlinType transformJavaClassifierType(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType javaClassifierType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes) {
        boolean z = (javaTypeAttributes.isForAnnotationParameter() || javaTypeAttributes.getHowThisTypeIsUsed() == kotlin.reflect.jvm.internal.impl.types.TypeUsage.SUPERTYPE) ? false : true;
        boolean zIsRaw = javaClassifierType.isRaw();
        if (!zIsRaw && !z) {
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeComputeSimpleJavaClassifierType = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes, null);
            return simpleTypeComputeSimpleJavaClassifierType != null ? simpleTypeComputeSimpleJavaClassifierType : transformJavaClassifierType$errorType(javaClassifierType);
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeComputeSimpleJavaClassifierType2 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (simpleTypeComputeSimpleJavaClassifierType2 == null) {
            return transformJavaClassifierType$errorType(javaClassifierType);
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeComputeSimpleJavaClassifierType3 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), simpleTypeComputeSimpleJavaClassifierType2);
        if (simpleTypeComputeSimpleJavaClassifierType3 == null) {
            return transformJavaClassifierType$errorType(javaClassifierType);
        }
        if (zIsRaw) {
            return new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl(simpleTypeComputeSimpleJavaClassifierType2, simpleTypeComputeSimpleJavaClassifierType3);
        }
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(simpleTypeComputeSimpleJavaClassifierType2, simpleTypeComputeSimpleJavaClassifierType3);
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType computeSimpleJavaClassifierType(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType javaClassifierType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes, kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType) {
        kotlin.reflect.jvm.internal.impl.types.TypeAttributes defaultAttributes;
        if (simpleType == null || (defaultAttributes = simpleType.getAttributes()) == null) {
            defaultAttributes = kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt.toDefaultAttributes(new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations(this.c, javaClassifierType, false, 4, null));
        }
        kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes = defaultAttributes;
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructorComputeTypeConstructor = computeTypeConstructor(javaClassifierType, javaTypeAttributes);
        if (typeConstructorComputeTypeConstructor == null) {
            return null;
        }
        boolean zIsNullable = isNullable(javaTypeAttributes);
        if (kotlin.jvm.internal.Intrinsics.areEqual(simpleType != null ? simpleType.getConstructor() : null, typeConstructorComputeTypeConstructor) && !javaClassifierType.isRaw() && zIsNullable) {
            return simpleType.makeNullableAsSpecified(true);
        }
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(typeAttributes, typeConstructorComputeTypeConstructor, computeArguments(javaClassifierType, javaTypeAttributes, typeConstructorComputeTypeConstructor), zIsNullable, (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) null, 16, (java.lang.Object) null);
    }

    private final kotlin.reflect.jvm.internal.impl.types.TypeConstructor computeTypeConstructor(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType javaClassifierType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes) {
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor;
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier classifier = javaClassifierType.getClassifier();
        if (classifier == null) {
            return createNotFoundClass(javaClassifierType);
        }
        if (classifier instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass) {
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass javaClass = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass) classifier;
            kotlin.reflect.jvm.internal.impl.name.FqName fqName = javaClass.getFqName();
            if (fqName == null) {
                throw new java.lang.AssertionError("Class type should have a FQ name: " + classifier);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorMapKotlinClass = mapKotlinClass(javaClassifierType, javaTypeAttributes, fqName);
            if (classDescriptorMapKotlinClass == null) {
                classDescriptorMapKotlinClass = this.c.getComponents().getModuleClassResolver().resolveClass(javaClass);
            }
            return (classDescriptorMapKotlinClass == null || (typeConstructor = classDescriptorMapKotlinClass.getTypeConstructor()) == null) ? createNotFoundClass(javaClassifierType) : typeConstructor;
        }
        if (classifier instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter) {
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = this.typeParameterResolver.resolveTypeParameter((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter) classifier);
            if (typeParameterDescriptorResolveTypeParameter != null) {
                return typeParameterDescriptorResolveTypeParameter.getTypeConstructor();
            }
            return null;
        }
        throw new java.lang.IllegalStateException("Unknown classifier kind: " + classifier);
    }

    private final kotlin.reflect.jvm.internal.impl.types.TypeConstructor createNotFoundClass(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType javaClassifierType) {
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName(javaClassifierType.getClassifierQualifiedName())), kotlin.collections.CollectionsKt.listOf(0)).getTypeConstructor();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return typeConstructor;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor mapKotlinClass(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType javaClassifierType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes, kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        if (javaTypeAttributes.isForAnnotationParameter() && kotlin.jvm.internal.Intrinsics.areEqual(fqName, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.JAVA_LANG_CLASS_FQ_NAME)) {
            return this.c.getComponents().getReflectionTypes().getKClass();
        }
        kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper javaToKotlinClassMapper = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper.INSTANCE;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorMapJavaToKotlin$default = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper.mapJavaToKotlin$default(javaToKotlinClassMapper, fqName, this.c.getModule().getBuiltIns(), null, 4, null);
        if (classDescriptorMapJavaToKotlin$default == null) {
            return null;
        }
        return (javaToKotlinClassMapper.isReadOnly(classDescriptorMapJavaToKotlin$default) && (javaTypeAttributes.getFlexibility() == kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.getHowThisTypeIsUsed() == kotlin.reflect.jvm.internal.impl.types.TypeUsage.SUPERTYPE || argumentsMakeSenseOnlyForMutableContainer(javaClassifierType, classDescriptorMapJavaToKotlin$default))) ? javaToKotlinClassMapper.convertReadOnlyToMutable(classDescriptorMapJavaToKotlin$default) : classDescriptorMapJavaToKotlin$default;
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType javaClassifierType, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.reflect.jvm.internal.impl.types.Variance variance;
        if (!kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypesKt.isSuperWildcard((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType) kotlin.collections.CollectionsKt.lastOrNull((java.util.List) javaClassifierType.getTypeArguments()))) {
            return false;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper.INSTANCE.convertReadOnlyToMutable(classDescriptor).getTypeConstructor().getParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) kotlin.collections.CollectionsKt.lastOrNull((java.util.List) parameters);
        return (typeParameterDescriptor == null || (variance = typeParameterDescriptor.getVariance()) == null || variance == kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE) ? false : true;
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> computeRawTypeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType javaClassifierType, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes) {
        final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType javaClassifierType2;
        final kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor2;
        final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes2;
        kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjectionComputeProjection;
        java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list2 = list;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (final kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor : list2) {
            if (kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.hasTypeParameterRecursiveBounds(typeParameterDescriptor, null, javaTypeAttributes.getVisitedTypeParameters())) {
                typeProjectionComputeProjection = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
                javaClassifierType2 = javaClassifierType;
                typeConstructor2 = typeConstructor;
                javaTypeAttributes2 = javaTypeAttributes;
            } else {
                javaClassifierType2 = javaClassifierType;
                typeConstructor2 = typeConstructor;
                javaTypeAttributes2 = javaTypeAttributes;
                typeProjectionComputeProjection = this.projectionComputer.computeProjection(typeParameterDescriptor, javaTypeAttributes2.markIsRaw(javaClassifierType2.isRaw()), this.typeParameterUpperBoundEraser, new kotlin.reflect.jvm.internal.impl.types.LazyWrappedType(this.c.getStorageManager(), new kotlin.jvm.functions.Function0(this, typeParameterDescriptor, javaTypeAttributes2, typeConstructor2, javaClassifierType2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$$Lambda$0
                    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver arg$0;
                    private final kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor arg$1;
                    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes arg$2;
                    private final kotlin.reflect.jvm.internal.impl.types.TypeConstructor arg$3;
                    private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType arg$4;

                    {
                        this.arg$0 = this;
                        this.arg$1 = typeParameterDescriptor;
                        this.arg$2 = javaTypeAttributes2;
                        this.arg$3 = typeConstructor2;
                        this.arg$4 = javaClassifierType2;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public java.lang.Object invoke() {
                        return kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.computeRawTypeArguments$lambda$4$lambda$3(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4);
                    }
                }));
            }
            arrayList.add(typeProjectionComputeProjection);
            javaTypeAttributes = javaTypeAttributes2;
            typeConstructor = typeConstructor2;
            javaClassifierType = javaClassifierType2;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType computeRawTypeArguments$lambda$4$lambda$3(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver javaTypeResolver, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType javaClassifierType) {
        kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser typeParameterUpperBoundEraser = javaTypeResolver.typeParameterUpperBoundEraser;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = typeConstructor.mo1835getDeclarationDescriptor();
        return typeParameterUpperBoundEraser.getErasedUpperBound(typeParameterDescriptor, javaTypeAttributes.withDefaultType(classifierDescriptorMo1835getDeclarationDescriptor != null ? classifierDescriptorMo1835getDeclarationDescriptor.getDefaultType() : null).markIsRaw(javaClassifierType.isRaw()));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> computeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType javaClassifierType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor) {
        boolean z;
        if (!javaClassifierType.isRaw()) {
            if (javaClassifierType.getTypeArguments().isEmpty()) {
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = typeConstructor.getParameters();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
                z = parameters.isEmpty() ? false : true;
            }
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters2, "getParameters(...)");
        if (z) {
            return computeRawTypeArguments(javaClassifierType, parameters2, typeConstructor, javaTypeAttributes);
        }
        if (parameters2.size() != javaClassifierType.getTypeArguments().size()) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list = parameters2;
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
            java.util.Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER, ((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) it.next()).getName().asString())));
            }
            return kotlin.collections.CollectionsKt.toList(arrayList);
        }
        java.lang.Iterable<kotlin.collections.IndexedValue> iterableWithIndex = kotlin.collections.CollectionsKt.withIndex(javaClassifierType.getTypeArguments());
        java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iterableWithIndex, 10));
        for (kotlin.collections.IndexedValue indexedValue : iterableWithIndex) {
            int index = indexedValue.getIndex();
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType javaType = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType) indexedValue.component2();
            parameters2.size();
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = parameters2.get(index);
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes attributes$default = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON, false, false, null, 7, null);
            kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameterDescriptor);
            arrayList2.add(transformToTypeProjection(javaType, attributes$default, typeParameterDescriptor));
        }
        return kotlin.collections.CollectionsKt.toList(arrayList2);
    }

    private final kotlin.reflect.jvm.internal.impl.types.TypeProjection transformToTypeProjection(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType javaType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor) {
        if (javaType instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType) {
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType javaWildcardType = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType) javaType;
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType bound = javaWildcardType.getBound();
            kotlin.reflect.jvm.internal.impl.types.Variance variance = javaWildcardType.isExtends() ? kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE : kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE;
            if (bound == null || isConflictingArgumentFor(variance, typeParameterDescriptor)) {
                kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjectionMakeStarProjection = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeProjectionMakeStarProjection, "makeStarProjection(...)");
                return typeProjectionMakeStarProjection;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptorExtractNullabilityAnnotationOnBoundedWildcard = kotlin.reflect.jvm.internal.impl.load.java.UtilsKt.extractNullabilityAnnotationOnBoundedWildcard(this.c, javaWildcardType);
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeTransformJavaType = transformJavaType(bound, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON, false, false, null, 7, null));
            if (annotationDescriptorExtractNullabilityAnnotationOnBoundedWildcard != null) {
                kotlinTypeTransformJavaType = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceAnnotations(kotlinTypeTransformJavaType, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.create(kotlin.collections.CollectionsKt.plus(kotlinTypeTransformJavaType.getAnnotations(), annotationDescriptorExtractNullabilityAnnotationOnBoundedWildcard)));
            }
            return kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.createProjection(kotlinTypeTransformJavaType, variance, typeParameterDescriptor);
        }
        return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT, transformJavaType(javaType, javaTypeAttributes));
    }

    private final boolean isConflictingArgumentFor(kotlin.reflect.jvm.internal.impl.types.Variance variance, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor) {
        return (typeParameterDescriptor.getVariance() == kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT || variance == typeParameterDescriptor.getVariance()) ? false : true;
    }

    private final boolean isNullable(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes) {
        return (javaTypeAttributes.getFlexibility() == kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.isForAnnotationParameter() || javaTypeAttributes.getHowThisTypeIsUsed() == kotlin.reflect.jvm.internal.impl.types.TypeUsage.SUPERTYPE) ? false : true;
    }
}
