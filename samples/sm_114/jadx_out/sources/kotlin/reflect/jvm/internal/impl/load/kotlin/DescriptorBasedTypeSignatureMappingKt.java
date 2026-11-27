package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: descriptorBasedTypeSignatureMapping.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DescriptorBasedTypeSignatureMappingKt {
    public static /* synthetic */ java.lang.Object mapType$default(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory jvmTypeFactory, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode typeMappingMode, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration typeMappingConfiguration, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter jvmDescriptorTypeWriter, kotlin.jvm.functions.Function3 function3, int i, java.lang.Object obj) {
        if ((i & 32) != 0) {
            function3 = kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.getDO_NOTHING_3();
        }
        return mapType(kotlinType, jvmTypeFactory, typeMappingMode, typeMappingConfiguration, jvmDescriptorTypeWriter, function3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v31, types: [T, java.lang.Object] */
    public static final <T> T mapType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory<T> factory, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode mode, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration<? extends T> typeMappingConfiguration, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter<T> jvmDescriptorTypeWriter, kotlin.jvm.functions.Function3<? super kotlin.reflect.jvm.internal.impl.types.KotlinType, ? super T, ? super kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, kotlin.Unit> writeGenericType) {
        T t;
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2;
        java.lang.Object objMapType;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "kotlinType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(factory, "factory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mode, "mode");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeMappingConfiguration, "typeMappingConfiguration");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(writeGenericType, "writeGenericType");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypePreprocessType = typeMappingConfiguration.preprocessType(kotlinType);
        if (kotlinTypePreprocessType != null) {
            return (T) mapType(kotlinTypePreprocessType, factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
        }
        if (kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isSuspendFunctionType(kotlinType)) {
            return (T) mapType(kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(kotlinType), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType3 = kotlinType;
        java.lang.Object objMapBuiltInType = kotlin.reflect.jvm.internal.impl.load.kotlin.TypeSignatureMappingKt.mapBuiltInType(kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE, kotlinType3, factory, mode);
        if (objMapBuiltInType != null) {
            ?? r8 = (java.lang.Object) kotlin.reflect.jvm.internal.impl.load.kotlin.TypeSignatureMappingKt.boxTypeIfNeeded(factory, objMapBuiltInType, mode.getNeedPrimitiveBoxing());
            writeGenericType.invoke(kotlinType, r8, mode);
            return r8;
        }
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) {
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor intersectionTypeConstructor = (kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) constructor;
            kotlin.reflect.jvm.internal.impl.types.KotlinType alternativeType = intersectionTypeConstructor.getAlternativeType();
            if (alternativeType == null) {
                alternativeType = typeMappingConfiguration.commonSupertype(intersectionTypeConstructor.mo1836getSupertypes());
            }
            return (T) mapType(kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(alternativeType), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = constructor.mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor == null) {
            throw new java.lang.UnsupportedOperationException("no descriptor for type constructor of " + kotlinType);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptor = classifierDescriptorMo1835getDeclarationDescriptor;
        if (kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.isError(classifierDescriptor)) {
            T t2 = (T) factory.createObjectType("error/NonExistentClass");
            typeMappingConfiguration.processErrorType(kotlinType, (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor);
            if (jvmDescriptorTypeWriter != 0) {
                jvmDescriptorTypeWriter.writeClass(t2);
            }
            return t2;
        }
        boolean z = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
        if (z && kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArray(kotlinType)) {
            if (kotlinType.getArguments().size() != 1) {
                throw new java.lang.UnsupportedOperationException("arrays must have one type argument");
            }
            kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection = kotlinType.getArguments().get(0);
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = typeProjection.getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            if (typeProjection.getProjectionKind() == kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE) {
                objMapType = factory.createObjectType("java/lang/Object");
                if (jvmDescriptorTypeWriter != 0) {
                    jvmDescriptorTypeWriter.writeArrayType();
                    jvmDescriptorTypeWriter.writeClass(objMapType);
                    jvmDescriptorTypeWriter.writeArrayEnd();
                }
            } else {
                if (jvmDescriptorTypeWriter != 0) {
                    jvmDescriptorTypeWriter.writeArrayType();
                }
                kotlin.reflect.jvm.internal.impl.types.Variance projectionKind = typeProjection.getProjectionKind();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(projectionKind, "getProjectionKind(...)");
                objMapType = mapType(type, factory, mode.toGenericArgumentMode(projectionKind, true), typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
                if (jvmDescriptorTypeWriter != 0) {
                    jvmDescriptorTypeWriter.writeArrayEnd();
                }
            }
            return (T) factory.createFromString(com.taobao.weex.el.parse.Operators.ARRAY_START_STR + factory.toString(objMapType));
        }
        if (z) {
            if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(classifierDescriptor) && !mode.getNeedInlineClassWrapping() && (kotlinType2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) kotlin.reflect.jvm.internal.impl.types.ExpandedTypeUtilsKt.computeExpandedTypeForInlineClass(kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE, kotlinType3)) != null) {
                return (T) mapType(kotlinType2, factory, mode.wrapInlineClassesMode(), typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
            }
            if (mode.isForAnnotationParameter() && kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isKClass((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor)) {
                t = (java.lang.Object) factory.getJavaLangClassType();
            } else {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor;
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor original = classDescriptor.getOriginal();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(original, "getOriginal(...)");
                T predefinedTypeForClass = typeMappingConfiguration.getPredefinedTypeForClass(original);
                if (predefinedTypeForClass == null) {
                    if (classDescriptor.getKind() == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_ENTRY) {
                        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
                        kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        classDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration;
                    }
                    kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor original2 = classDescriptor.getOriginal();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(original2, "getOriginal(...)");
                    t = (java.lang.Object) factory.createObjectType(computeInternalName(original2, typeMappingConfiguration));
                } else {
                    t = (java.lang.Object) predefinedTypeForClass;
                }
            }
            writeGenericType.invoke(kotlinType, t, mode);
            return t;
        }
        if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType representativeUpperBound = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getRepresentativeUpperBound((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) classifierDescriptorMo1835getDeclarationDescriptor);
            if (kotlinType.isMarkedNullable()) {
                representativeUpperBound = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(representativeUpperBound);
            }
            T t3 = (T) mapType(representativeUpperBound, factory, mode, typeMappingConfiguration, null, kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.getDO_NOTHING_3());
            if (jvmDescriptorTypeWriter != 0) {
                kotlin.reflect.jvm.internal.impl.name.Name name = classifierDescriptorMo1835getDeclarationDescriptor.getName();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                jvmDescriptorTypeWriter.writeTypeVariable(name, t3);
            }
            return t3;
        }
        if ((classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) && mode.getMapTypeAliases()) {
            return (T) mapType(((kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) classifierDescriptorMo1835getDeclarationDescriptor).getExpandedType(), factory, mode, typeMappingConfiguration, jvmDescriptorTypeWriter, writeGenericType);
        }
        throw new java.lang.UnsupportedOperationException("Unknown type " + kotlinType);
    }

    public static final boolean hasVoidReturnType(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor descriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = descriptor.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(returnType);
        if (!kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isUnit(returnType)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType2 = descriptor.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(returnType2);
        return (kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(returnType2) || (descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor)) ? false : true;
    }

    public static /* synthetic */ java.lang.String computeInternalName$default(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration typeMappingConfiguration, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            typeMappingConfiguration = kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfigurationImpl.INSTANCE;
        }
        return computeInternalName(classDescriptor, typeMappingConfiguration);
    }

    public static final java.lang.String computeInternalName(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor klass, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration<?> typeMappingConfiguration) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(klass, "klass");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeMappingConfiguration, "typeMappingConfiguration");
        java.lang.String predefinedFullInternalNameForClass = typeMappingConfiguration.getPredefinedFullInternalNameForClass(klass);
        if (predefinedFullInternalNameForClass != null) {
            return predefinedFullInternalNameForClass;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = klass.getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
        java.lang.String identifier = kotlin.reflect.jvm.internal.impl.name.SpecialNames.safeIdentifier(klass.getName()).getIdentifier();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(identifier, "getIdentifier(...)");
        if (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) {
            kotlin.reflect.jvm.internal.impl.name.FqName fqName = ((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) containingDeclaration).getFqName();
            if (fqName.isRoot()) {
                return identifier;
            }
            return kotlin.text.StringsKt.replace$default(fqName.asString(), com.taobao.weex.el.parse.Operators.DOT, '/', false, 4, (java.lang.Object) null) + '/' + identifier;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null) {
            throw new java.lang.IllegalArgumentException("Unexpected container: " + containingDeclaration + " for " + klass);
        }
        java.lang.String predefinedInternalNameForClass = typeMappingConfiguration.getPredefinedInternalNameForClass(classDescriptor);
        if (predefinedInternalNameForClass == null) {
            predefinedInternalNameForClass = computeInternalName(classDescriptor, typeMappingConfiguration);
        }
        return predefinedInternalNameForClass + '$' + identifier;
    }
}
