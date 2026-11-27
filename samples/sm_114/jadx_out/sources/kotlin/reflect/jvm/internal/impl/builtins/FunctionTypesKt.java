package kotlin.reflect.jvm.internal.impl.builtins;

/* JADX INFO: compiled from: functionTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FunctionTypesKt {
    public static final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind getFunctionTypeKind(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor != null) {
            return getFunctionTypeKind(classifierDescriptorMo1835getDeclarationDescriptor);
        }
        return null;
    }

    public static final boolean isFunctionType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlin.jvm.internal.Intrinsics.areEqual(getFunctionTypeKind(kotlinType), kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.Function.INSTANCE);
    }

    public static final boolean isSuspendFunctionType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlin.jvm.internal.Intrinsics.areEqual(getFunctionTypeKind(kotlinType), kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.SuspendFunction.INSTANCE);
    }

    public static final boolean isBuiltinFunctionalType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        return classifierDescriptorMo1835getDeclarationDescriptor != null && isBuiltinFunctionalClassDescriptor(classifierDescriptorMo1835getDeclarationDescriptor);
    }

    public static final boolean isBuiltinFunctionalClassDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind functionTypeKind = getFunctionTypeKind(declarationDescriptor);
        return kotlin.jvm.internal.Intrinsics.areEqual(functionTypeKind, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.Function.INSTANCE) || kotlin.jvm.internal.Intrinsics.areEqual(functionTypeKind, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.SuspendFunction.INSTANCE);
    }

    public static final boolean isBuiltinExtensionFunctionalType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return isBuiltinFunctionalType(kotlinType) && isTypeAnnotatedWithExtensionFunctionType(kotlinType);
    }

    private static final boolean isTypeAnnotatedWithExtensionFunctionType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        return kotlinType.getAnnotations().mo1826findAnnotation(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.extensionFunctionType) != null;
    }

    public static final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind getFunctionTypeKind(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        if ((declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) && kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor)) {
            return getFunctionTypeKind(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(declarationDescriptor));
        }
        return null;
    }

    private static final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind getFunctionTypeKind(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe) {
        if (!fqNameUnsafe.isSafe() || fqNameUnsafe.isRoot()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor functionTypeKindExtractor = kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor.Companion.getDefault();
        kotlin.reflect.jvm.internal.impl.name.FqName fqNameParent = fqNameUnsafe.toSafe().parent();
        java.lang.String strAsString = fqNameUnsafe.shortName().asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return functionTypeKindExtractor.getFunctionalClassKind(fqNameParent, strAsString);
    }

    public static final int contextFunctionTypeParamsCount(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptorMo1826findAnnotation = kotlinType.getAnnotations().mo1826findAnnotation(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.contextFunctionTypeParams);
        if (annotationDescriptorMo1826findAnnotation == null) {
            return 0;
        }
        kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue constantValue = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) kotlin.collections.MapsKt.getValue(annotationDescriptorMo1826findAnnotation.getAllValueArguments(), kotlin.reflect.jvm.internal.impl.builtins.StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME);
        kotlin.jvm.internal.Intrinsics.checkNotNull(constantValue, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue) constantValue).getValue().intValue();
    }

    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType getReceiverTypeFromFunctionType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        if (!isTypeAnnotatedWithExtensionFunctionType(kotlinType)) {
            return null;
        }
        return kotlinType.getArguments().get(contextFunctionTypeParamsCount(kotlinType)).getType();
    }

    public static final java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> getContextReceiverTypesFromFunctionType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        int iContextFunctionTypeParamsCount = contextFunctionTypeParamsCount(kotlinType);
        if (iContextFunctionTypeParamsCount == 0) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> listSubList = kotlinType.getArguments().subList(0, iContextFunctionTypeParamsCount);
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listSubList, 10));
        java.util.Iterator<T> it = listSubList.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.types.TypeProjection) it.next()).getType());
        }
        return arrayList;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType getReturnTypeFromFunctionType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = ((kotlin.reflect.jvm.internal.impl.types.TypeProjection) kotlin.collections.CollectionsKt.last((java.util.List) kotlinType.getArguments())).getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    public static final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> getValueParameterTypesFromFunctionType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments = kotlinType.getArguments();
        return arguments.subList(contextFunctionTypeParamsCount(kotlinType) + (isBuiltinExtensionFunctionalType(kotlinType) ? 1 : 0), arguments.size() - 1);
    }

    public static final kotlin.reflect.jvm.internal.impl.name.Name extractParameterNameFromFunctionTypeArgument(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        java.lang.String value;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptorMo1826findAnnotation = kotlinType.getAnnotations().mo1826findAnnotation(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.parameterName);
        if (annotationDescriptorMo1826findAnnotation == null) {
            return null;
        }
        java.lang.Object objSingleOrNull = kotlin.collections.CollectionsKt.singleOrNull(annotationDescriptorMo1826findAnnotation.getAllValueArguments().values());
        kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue stringValue = objSingleOrNull instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue ? (kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue) objSingleOrNull : null;
        if (stringValue != null && (value = stringValue.getValue()) != null) {
            if (!kotlin.reflect.jvm.internal.impl.name.Name.isValidIdentifier(value)) {
                value = null;
            }
            if (value != null) {
                return kotlin.reflect.jvm.internal.impl.name.Name.identifier(value);
            }
        }
        return null;
    }

    public static final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> getFunctionTypeArgumentProjections(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> contextReceiverTypes, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> parameterTypes, java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> list, kotlin.reflect.jvm.internal.impl.types.KotlinType returnType, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns kotlinBuiltIns) {
        kotlin.reflect.jvm.internal.impl.name.Name name;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contextReceiverTypes, "contextReceiverTypes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(returnType, "returnType");
        kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns = kotlinBuiltIns;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        int i = 0;
        java.util.ArrayList arrayList = new java.util.ArrayList(parameterTypes.size() + contextReceiverTypes.size() + (kotlinType != null ? 1 : 0) + 1);
        java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> list2 = contextReceiverTypes;
        java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
        java.util.Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.asTypeProjection((kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next()));
        }
        arrayList.addAll(arrayList2);
        java.util.ArrayList arrayList3 = arrayList;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList3, kotlinType != null ? kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.asTypeProjection(kotlinType) : null);
        for (java.lang.Object obj : parameterTypes) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeReplaceAnnotations = (kotlin.reflect.jvm.internal.impl.types.KotlinType) obj;
            if (list == null || (name = list.get(i)) == null || name.isSpecial()) {
                name = null;
            }
            if (name != null) {
                kotlin.reflect.jvm.internal.impl.name.FqName fqName = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.parameterName;
                kotlin.reflect.jvm.internal.impl.name.Name name2 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.NAME;
                java.lang.String strAsString = name.asString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
                kotlinTypeReplaceAnnotations = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceAnnotations(kotlinTypeReplaceAnnotations, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.create(kotlin.collections.CollectionsKt.plus(kotlinTypeReplaceAnnotations.getAnnotations(), new kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor(builtIns, fqName, kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(name2, new kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue(strAsString))), false, 8, null))));
            }
            arrayList3.add(kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.asTypeProjection(kotlinTypeReplaceAnnotations));
            builtIns = kotlinBuiltIns;
            i = i2;
        }
        arrayList.add(kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.asTypeProjection(returnType));
        return arrayList;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType createFunctionType(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> contextReceiverTypes, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> parameterTypes, java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> list, kotlin.reflect.jvm.internal.impl.types.KotlinType returnType, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contextReceiverTypes, "contextReceiverTypes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(returnType, "returnType");
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> functionTypeArgumentProjections = getFunctionTypeArgumentProjections(kotlinType, contextReceiverTypes, parameterTypes, list, returnType, builtIns);
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor functionDescriptor = getFunctionDescriptor(builtIns, parameterTypes.size() + contextReceiverTypes.size() + (kotlinType == null ? 0 : 1), z);
        if (kotlinType != null) {
            annotations = withExtensionFunctionAnnotation(annotations, builtIns);
        }
        if (!contextReceiverTypes.isEmpty()) {
            annotations = withContextReceiversFunctionAnnotation(annotations, builtIns, contextReceiverTypes.size());
        }
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleNotNullType(kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt.toDefaultAttributes(annotations), functionDescriptor, functionTypeArgumentProjections);
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations withExtensionFunctionAnnotation(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        if (annotations.hasAnnotation(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.extensionFunctionType)) {
            return annotations;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.create(kotlin.collections.CollectionsKt.plus(annotations, new kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor(builtIns, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.extensionFunctionType, kotlin.collections.MapsKt.emptyMap(), false, 8, null)));
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations withContextReceiversFunctionAnnotation(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        if (annotations.hasAnnotation(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.contextFunctionTypeParams)) {
            return annotations;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.create(kotlin.collections.CollectionsKt.plus(annotations, new kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor(builtIns, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.contextFunctionTypeParams, kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME, new kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue(i))), false, 8, null)));
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getFunctionDescriptor(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns, int i, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor suspendFunction = z ? builtIns.getSuspendFunction(i) : builtIns.getFunction(i);
        kotlin.jvm.internal.Intrinsics.checkNotNull(suspendFunction);
        return suspendFunction;
    }
}
