package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MethodSignatureMappingKt {
    public static final java.lang.String computeJvmDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, boolean z, boolean z2) {
        java.lang.String strAsString;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functionDescriptor, "<this>");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (z2) {
            if (functionDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) {
                strAsString = "<init>";
            } else {
                strAsString = functionDescriptor.getName().asString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
            }
            sb.append(strAsString);
        }
        sb.append(com.taobao.weex.el.parse.Operators.BRACKET_START_STR);
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor extensionReceiverParameter = functionDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = extensionReceiverParameter.getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            appendErasedType(sb, type);
        }
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> it = functionDescriptor.getValueParameters().iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType type2 = it.next().getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
            appendErasedType(sb, type2);
        }
        sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        if (z) {
            if (kotlin.reflect.jvm.internal.impl.load.kotlin.DescriptorBasedTypeSignatureMappingKt.hasVoidReturnType(functionDescriptor)) {
                sb.append("V");
            } else {
                kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = functionDescriptor.getReturnType();
                kotlin.jvm.internal.Intrinsics.checkNotNull(returnType);
                appendErasedType(sb, returnType);
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ java.lang.String computeJvmDescriptor$default(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, boolean z, boolean z2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return computeJvmDescriptor(functionDescriptor, z, z2);
    }

    public static final boolean forceSingleValueParameterBoxing(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor f) {
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(f, "f");
        if (!(f instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) f;
        if (kotlin.jvm.internal.Intrinsics.areEqual(functionDescriptor.getName().asString(), io.dcloud.common.constant.AbsoluteConst.XML_REMOVE) && functionDescriptor.getValueParameters().size() == 1 && !kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.isFromJavaOrBuiltins((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) f)) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = functionDescriptor.getOriginal().getValueParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = ((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) kotlin.collections.CollectionsKt.single((java.util.List) valueParameters)).getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType jvmTypeMapToJvmType = mapToJvmType(type);
            kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive primitive = jvmTypeMapToJvmType instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive ? (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive) jvmTypeMapToJvmType : null;
            if ((primitive != null ? primitive.getJvmPrimitiveType() : null) != kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.INT || (overriddenBuiltinFunctionWithErasedValueParametersInJava = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(functionDescriptor)) == null) {
                return false;
            }
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters2 = overriddenBuiltinFunctionWithErasedValueParametersInJava.getOriginal().getValueParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
            kotlin.reflect.jvm.internal.impl.types.KotlinType type2 = ((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) kotlin.collections.CollectionsKt.single((java.util.List) valueParameters2)).getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
            kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType jvmTypeMapToJvmType2 = mapToJvmType(type2);
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = overriddenBuiltinFunctionWithErasedValueParametersInJava.getContainingDeclaration();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (kotlin.jvm.internal.Intrinsics.areEqual(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(containingDeclaration), kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.mutableCollection.toUnsafe()) && (jvmTypeMapToJvmType2 instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object) && kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object) jvmTypeMapToJvmType2).getInternalName(), "java/lang/Object")) {
                return true;
            }
        }
        return false;
    }

    public static final java.lang.String getInternalName(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.name.ClassId classIdMapKotlinToJava = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(classDescriptor).toUnsafe());
        if (classIdMapKotlinToJava != null) {
            java.lang.String strInternalNameByClassId = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.internalNameByClassId(classIdMapKotlinToJava);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strInternalNameByClassId, "internalNameByClassId(...)");
            return strInternalNameByClassId;
        }
        return kotlin.reflect.jvm.internal.impl.load.kotlin.DescriptorBasedTypeSignatureMappingKt.computeInternalName$default(classDescriptor, null, 2, null);
    }

    private static final void appendErasedType(java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        sb.append(mapToJvmType(kotlinType));
    }

    public static final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType mapToJvmType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType) kotlin.reflect.jvm.internal.impl.load.kotlin.DescriptorBasedTypeSignatureMappingKt.mapType$default(kotlinType, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactoryImpl.INSTANCE, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode.DEFAULT, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfigurationImpl.INSTANCE, null, null, 32, null);
    }

    public static final java.lang.String computeJvmSignature(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents signatureBuildingComponents = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE;
        if (kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isLocal(callableDescriptor)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null || classDescriptor.getName().isSpecial()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor original = callableDescriptor.getOriginal();
        kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor = original instanceof kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) original : null;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt.signature(signatureBuildingComponents, classDescriptor, computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null));
    }
}
