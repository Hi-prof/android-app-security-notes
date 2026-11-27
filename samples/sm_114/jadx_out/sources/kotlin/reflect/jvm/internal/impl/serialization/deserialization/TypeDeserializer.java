package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: TypeDeserializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeDeserializer {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext c;
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor> classifierDescriptors;
    private final java.lang.String containerPresentableName;
    private final java.lang.String debugName;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer parent;
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor> typeAliasDescriptors;
    private final java.util.Map<java.lang.Integer, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameterDescriptors;

    public TypeDeserializer(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext c, kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer typeDeserializer, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameterProtos, java.lang.String debugName, java.lang.String containerPresentableName) {
        java.util.LinkedHashMap linkedHashMapEmptyMap;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameterProtos, "typeParameterProtos");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(debugName, "debugName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containerPresentableName, "containerPresentableName");
        this.c = c;
        this.parent = typeDeserializer;
        this.debugName = debugName;
        this.containerPresentableName = containerPresentableName;
        this.classifierDescriptors = c.getStorageManager().createMemoizedFunctionWithNullableValues(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return this.arg$0.computeClassifierDescriptor(((java.lang.Number) obj).intValue());
            }
        });
        this.typeAliasDescriptors = c.getStorageManager().createMemoizedFunctionWithNullableValues(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return this.arg$0.computeTypeAliasDescriptor(((java.lang.Number) obj).intValue());
            }
        });
        if (typeParameterProtos.isEmpty()) {
            linkedHashMapEmptyMap = kotlin.collections.MapsKt.emptyMap();
        } else {
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
            int i = 0;
            for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter typeParameter : typeParameterProtos) {
                linkedHashMap.put(java.lang.Integer.valueOf(typeParameter.getId()), new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor(this.c, typeParameter, i));
                i++;
            }
            linkedHashMapEmptyMap = linkedHashMap;
        }
        this.typeParameterDescriptors = linkedHashMapEmptyMap;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getOwnTypeParameters() {
        return kotlin.collections.CollectionsKt.toList(this.typeParameterDescriptors.values());
    }

    public final kotlin.reflect.jvm.internal.impl.types.KotlinType type(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type proto) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        if (proto.hasFlexibleTypeCapabilitiesId()) {
            java.lang.String string = this.c.getNameResolver().getString(proto.getFlexibleTypeCapabilitiesId());
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeSimpleType$default = simpleType$default(this, proto, false, 2, null);
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeFlexibleUpperBound = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.flexibleUpperBound(proto, this.c.getTypeTable());
            kotlin.jvm.internal.Intrinsics.checkNotNull(typeFlexibleUpperBound);
            return this.c.getComponents().getFlexibleTypeDeserializer().create(proto, string, simpleTypeSimpleType$default, simpleType$default(this, typeFlexibleUpperBound, false, 2, null));
        }
        return simpleType(proto, true);
    }

    private final kotlin.reflect.jvm.internal.impl.types.TypeAttributes toAttributes(java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator> list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator> list2 = list;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
        java.util.Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator) it.next()).toAttributes(annotations, typeConstructor, declarationDescriptor));
        }
        return kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion.create(kotlin.collections.CollectionsKt.flatten(arrayList));
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType$default(kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer typeDeserializer, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type type, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return typeDeserializer.simpleType(type, z);
    }

    public final kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType(final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type proto, boolean z) {
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeComputeLocalClassifierReplacementType;
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeSimpleType$default;
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeWithAbbreviation;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        if (proto.hasClassName()) {
            simpleTypeComputeLocalClassifierReplacementType = computeLocalClassifierReplacementType(proto.getClassName());
        } else {
            simpleTypeComputeLocalClassifierReplacementType = proto.hasTypeAliasName() ? computeLocalClassifierReplacementType(proto.getTypeAliasName()) : null;
        }
        if (simpleTypeComputeLocalClassifierReplacementType != null) {
            return simpleTypeComputeLocalClassifierReplacementType;
        }
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = typeConstructor(proto);
        if (kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.isError(typeConstructor.mo1835getDeclarationDescriptor())) {
            return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.TYPE_FOR_ERROR_TYPE_CONSTRUCTOR, typeConstructor, typeConstructor.toString());
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations deserializedAnnotations = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations(this.c.getStorageManager(), new kotlin.jvm.functions.Function0(this, proto) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer arg$0;
            private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = proto;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.simpleType$lambda$3(this.arg$0, this.arg$1);
            }
        });
        kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes = toAttributes(this.c.getComponents().getTypeAttributeTranslators(), deserializedAnnotations, typeConstructor, this.c.getContainingDeclaration());
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument> listSimpleType$collectAllArguments = simpleType$collectAllArguments(proto, this);
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listSimpleType$collectAllArguments, 10));
        int i = 0;
        for (java.lang.Object obj : listSimpleType$collectAllArguments) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            arrayList.add(typeArgument((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) kotlin.collections.CollectionsKt.getOrNull(parameters, i), (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument) obj));
            i = i2;
        }
        java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> list = kotlin.collections.CollectionsKt.toList(arrayList);
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = typeConstructor.mo1835getDeclarationDescriptor();
        if (z && (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor)) {
            kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory kotlinTypeFactory = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE;
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeComputeExpandedType = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.computeExpandedType((kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) classifierDescriptorMo1835getDeclarationDescriptor, list);
            simpleTypeSimpleType$default = simpleTypeComputeExpandedType.makeNullableAsSpecified(kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isNullable(simpleTypeComputeExpandedType) || proto.getNullable()).replaceAttributes(toAttributes(this.c.getComponents().getTypeAttributeTranslators(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.create(kotlin.collections.CollectionsKt.plus((java.lang.Iterable) deserializedAnnotations, (java.lang.Iterable) simpleTypeComputeExpandedType.getAnnotations())), typeConstructor, this.c.getContainingDeclaration()));
        } else if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.SUSPEND_TYPE.get(proto.getFlags()).booleanValue()) {
            simpleTypeSimpleType$default = createSuspendFunctionType(attributes, typeConstructor, list, proto.getNullable());
        } else {
            simpleTypeSimpleType$default = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(attributes, typeConstructor, list, proto.getNullable(), (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) null, 16, (java.lang.Object) null);
            if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.DEFINITELY_NOT_NULL_TYPE.get(proto.getFlags()).booleanValue()) {
                kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType definitelyNotNullTypeMakeDefinitelyNotNull$default = kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType.Companion, simpleTypeSimpleType$default, true, false, 4, null);
                if (definitelyNotNullTypeMakeDefinitelyNotNull$default == null) {
                    throw new java.lang.IllegalStateException(("null DefinitelyNotNullType for '" + simpleTypeSimpleType$default + com.taobao.weex.el.parse.Operators.SINGLE_QUOTE).toString());
                }
                simpleTypeSimpleType$default = definitelyNotNullTypeMakeDefinitelyNotNull$default;
            }
        }
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeAbbreviatedType = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.abbreviatedType(proto, this.c.getTypeTable());
        return (typeAbbreviatedType == null || (simpleTypeWithAbbreviation = kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.withAbbreviation(simpleTypeSimpleType$default, simpleType(typeAbbreviatedType, false))) == null) ? simpleTypeSimpleType$default : simpleTypeWithAbbreviation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List simpleType$lambda$3(kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer typeDeserializer, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type type) {
        return typeDeserializer.c.getComponents().getAnnotationAndConstantLoader().loadTypeAnnotations(type, typeDeserializer.c.getNameResolver());
    }

    private static final java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument> simpleType$collectAllArguments(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type type, kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer typeDeserializer) {
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument> argumentList = type.getArgumentList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(argumentList, "getArgumentList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument> list = argumentList;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeOuterType = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.outerType(type, typeDeserializer.c.getTypeTable());
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument> listSimpleType$collectAllArguments = typeOuterType != null ? simpleType$collectAllArguments(typeOuterType, typeDeserializer) : null;
        if (listSimpleType$collectAllArguments == null) {
            listSimpleType$collectAllArguments = kotlin.collections.CollectionsKt.emptyList();
        }
        return kotlin.collections.CollectionsKt.plus((java.util.Collection) list, (java.lang.Iterable) listSimpleType$collectAllArguments);
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor typeConstructor$notFoundClass(final kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer typeDeserializer, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type type, int i) {
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getClassId(typeDeserializer.c.getNameResolver(), i);
        java.util.List<java.lang.Integer> mutableList = kotlin.sequences.SequencesKt.toMutableList(kotlin.sequences.SequencesKt.map(kotlin.sequences.SequencesKt.generateSequence(type, (kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type, ? extends kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type>) new kotlin.jvm.functions.Function1(typeDeserializer) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$3
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer arg$0;

            {
                this.arg$0 = typeDeserializer;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.typeConstructor$notFoundClass$lambda$8(this.arg$0, (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) obj);
            }
        }), new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$$Lambda$4
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Integer.valueOf(kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.typeConstructor$notFoundClass$lambda$9((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) obj));
            }
        }));
        int iCount = kotlin.sequences.SequencesKt.count(kotlin.sequences.SequencesKt.generateSequence(classId, new kotlin.jvm.internal.PropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeConstructor$notFoundClass$classNestingLevel$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return ((kotlin.reflect.jvm.internal.impl.name.ClassId) obj).getOuterClassId();
            }
        }));
        while (mutableList.size() < iCount) {
            mutableList.add(0);
        }
        return typeDeserializer.c.getComponents().getNotFoundClasses().getClass(classId, mutableList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeConstructor$notFoundClass$lambda$8(kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer typeDeserializer, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.outerType(it, typeDeserializer.c.getTypeTable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int typeConstructor$notFoundClass$lambda$9(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it.getArgumentCount();
    }

    private final kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type type) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorInvoke2;
        java.lang.Object next;
        if (type.hasClassName()) {
            classDescriptorInvoke2 = this.classifierDescriptors.invoke2(java.lang.Integer.valueOf(type.getClassName()));
            if (classDescriptorInvoke2 == null) {
                classDescriptorInvoke2 = typeConstructor$notFoundClass(this, type, type.getClassName());
            }
        } else if (type.hasTypeParameter()) {
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptorLoadTypeParameter = loadTypeParameter(type.getTypeParameter());
            if (typeParameterDescriptorLoadTypeParameter == null) {
                return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE.createErrorTypeConstructor(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER, java.lang.String.valueOf(type.getTypeParameter()), this.containerPresentableName);
            }
            classDescriptorInvoke2 = typeParameterDescriptorLoadTypeParameter;
        } else if (type.hasTypeParameterName()) {
            java.lang.String string = this.c.getNameResolver().getString(type.getTypeParameterName());
            java.util.Iterator<T> it = getOwnTypeParameters().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) next).getName().asString(), string));
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) next;
            if (typeParameterDescriptor == null) {
                return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE.createErrorTypeConstructor(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME, string, this.c.getContainingDeclaration().toString());
            }
            classDescriptorInvoke2 = typeParameterDescriptor;
        } else if (type.hasTypeAliasName()) {
            classDescriptorInvoke2 = this.typeAliasDescriptors.invoke2(java.lang.Integer.valueOf(type.getTypeAliasName()));
            if (classDescriptorInvoke2 == null) {
                classDescriptorInvoke2 = typeConstructor$notFoundClass(this, type, type.getTypeAliasName());
            }
        } else {
            return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE.createErrorTypeConstructor(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.UNKNOWN_TYPE, new java.lang.String[0]);
        }
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = classDescriptorInvoke2.getTypeConstructor();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return typeConstructor;
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType createSuspendFunctionType(kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> list, boolean z) {
        java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> list2;
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeCreateSuspendFunctionTypeForBasicCase;
        int size;
        int size2 = typeConstructor.getParameters().size() - list.size();
        if (size2 != 0) {
            simpleTypeCreateSuspendFunctionTypeForBasicCase = null;
            if (size2 == 1 && (size = list.size() - 1) >= 0) {
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor2 = typeConstructor.getBuiltIns().getSuspendFunction(size).getTypeConstructor();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
                list2 = list;
                simpleTypeCreateSuspendFunctionTypeForBasicCase = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(typeAttributes, typeConstructor2, list2, z, (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) null, 16, (java.lang.Object) null);
            } else {
                list2 = list;
            }
        } else {
            list2 = list;
            simpleTypeCreateSuspendFunctionTypeForBasicCase = createSuspendFunctionTypeForBasicCase(typeAttributes, typeConstructor, list2, z);
        }
        return simpleTypeCreateSuspendFunctionTypeForBasicCase == null ? kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE.createErrorTypeWithArguments(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.INCONSISTENT_SUSPEND_FUNCTION, list2, typeConstructor, new java.lang.String[0]) : simpleTypeCreateSuspendFunctionTypeForBasicCase;
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType createSuspendFunctionTypeForBasicCase(kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> list, boolean z) {
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeSimpleType$default = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(typeAttributes, typeConstructor, list, z, (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) null, 16, (java.lang.Object) null);
        if (kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isFunctionType(simpleTypeSimpleType$default)) {
            return transformRuntimeFunctionTypeToSuspendFunction(simpleTypeSimpleType$default);
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType transformRuntimeFunctionTypeToSuspendFunction(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType type;
        kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) kotlin.collections.CollectionsKt.lastOrNull((java.util.List) kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType));
        if (typeProjection == null || (type = typeProjection.getType()) == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = type.getConstructor().mo1835getDeclarationDescriptor();
        kotlin.reflect.jvm.internal.impl.name.FqName fqNameSafe = classifierDescriptorMo1835getDeclarationDescriptor != null ? kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(classifierDescriptorMo1835getDeclarationDescriptor) : null;
        if (type.getArguments().size() != 1 || (!kotlin.jvm.internal.Intrinsics.areEqual(fqNameSafe, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.CONTINUATION_INTERFACE_FQ_NAME) && !kotlin.jvm.internal.Intrinsics.areEqual(fqNameSafe, kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializerKt.EXPERIMENTAL_CONTINUATION_FQ_NAME))) {
            return (kotlin.reflect.jvm.internal.impl.types.SimpleType) kotlinType;
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType type2 = ((kotlin.reflect.jvm.internal.impl.types.TypeProjection) kotlin.collections.CollectionsKt.single((java.util.List) type.getArguments())).getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor = containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) containingDeclaration : null;
        if (kotlin.jvm.internal.Intrinsics.areEqual(callableDescriptor != null ? kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.fqNameOrNull(callableDescriptor) : null, kotlin.reflect.jvm.internal.impl.serialization.deserialization.SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            return createSimpleSuspendFunctionType(kotlinType, type2);
        }
        return createSimpleSuspendFunctionType(kotlinType, type2);
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType createSimpleSuspendFunctionType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2) {
        kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getBuiltIns(kotlinType);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations = kotlinType.getAnnotations();
        kotlin.reflect.jvm.internal.impl.types.KotlinType receiverTypeFromFunctionType = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> contextReceiverTypesFromFunctionType = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.getContextReceiverTypesFromFunctionType(kotlinType);
        java.util.List listDropLast = kotlin.collections.CollectionsKt.dropLast(kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType), 1);
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listDropLast, 10));
        java.util.Iterator it = listDropLast.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.types.TypeProjection) it.next()).getType());
        }
        return kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, contextReceiverTypesFromFunctionType, arrayList, null, kotlinType2, true).makeNullableAsSpecified(kotlinType.isMarkedNullable());
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor loadTypeParameter(int i) {
        kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = this.typeParameterDescriptors.get(java.lang.Integer.valueOf(i));
        if (typeParameterDescriptor != null) {
            return typeParameterDescriptor;
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer typeDeserializer = this.parent;
        if (typeDeserializer != null) {
            return typeDeserializer.loadTypeParameter(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor computeClassifierDescriptor(int i) {
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getClassId(this.c.getNameResolver(), i);
        if (classId.isLocal()) {
            return this.c.getComponents().deserializeClass(classId);
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findClassifierAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), classId);
    }

    private final kotlin.reflect.jvm.internal.impl.types.SimpleType computeLocalClassifierReplacementType(int i) {
        if (kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getClassId(this.c.getNameResolver(), i).isLocal()) {
            return this.c.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor computeTypeAliasDescriptor(int i) {
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getClassId(this.c.getNameResolver(), i);
        if (classId.isLocal()) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), classId);
    }

    private final kotlin.reflect.jvm.internal.impl.types.TypeProjection typeArgument(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument argument) {
        if (argument.getProjection() == kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.STAR) {
            if (typeParameterDescriptor == null) {
                return new kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter(this.c.getComponents().getModuleDescriptor().getBuiltIns());
            }
            return new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl(typeParameterDescriptor);
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags protoEnumFlags = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection projection = argument.getProjection();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(projection, "getProjection(...)");
        kotlin.reflect.jvm.internal.impl.types.Variance variance = protoEnumFlags.variance(projection);
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type type = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.type(argument, this.c.getTypeTable());
        if (type == null) {
            return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.NO_RECORDED_TYPE, argument.toString()));
        }
        return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(variance, type(type));
    }

    public java.lang.String toString() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.debugName);
        if (this.parent == null) {
            str = "";
        } else {
            str = ". Child of " + this.parent.debugName;
        }
        sb.append(str);
        return sb.toString();
    }
}
