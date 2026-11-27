package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaIncompatibilityRulesOverridabilityCondition implements kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition {
    public static final kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition.Companion Companion = new kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition.Companion(null);

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result isOverridable(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor superDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor subDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(subDescriptor, "subDescriptor");
        if (isIncompatibleInAccordanceWithBuiltInOverridabilityRules(superDescriptor, subDescriptor, classDescriptor)) {
            return kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        if (Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(superDescriptor, subDescriptor)) {
            return kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        return kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.UNKNOWN;
    }

    private final boolean isIncompatibleInAccordanceWithBuiltInOverridabilityRules(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        if ((callableDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) && (callableDescriptor2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) && !kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBuiltIn(callableDescriptor2)) {
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) callableDescriptor2;
            kotlin.reflect.jvm.internal.impl.name.Name name = functionDescriptor.getName();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
                kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion companion = kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion;
                kotlin.reflect.jvm.internal.impl.name.Name name2 = functionDescriptor.getName();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                if (!companion.getSameAsRenamedInJvmBuiltin(name2)) {
                    return false;
                }
            }
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor overriddenSpecialBuiltin = kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.getOverriddenSpecialBuiltin((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) callableDescriptor);
            boolean z = callableDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor2 = z ? (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) callableDescriptor : null;
            if (!(functionDescriptor2 != null && functionDescriptor.isHiddenToOvercomeSignatureClash() == functionDescriptor2.isHiddenToOvercomeSignatureClash()) && (overriddenSpecialBuiltin == null || !functionDescriptor.isHiddenToOvercomeSignatureClash())) {
                return true;
            }
            if ((classDescriptor instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor) && functionDescriptor.getInitialSignatureDescriptor() == null && overriddenSpecialBuiltin != null && !kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(classDescriptor, overriddenSpecialBuiltin)) {
                if ((overriddenSpecialBuiltin instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) && z && kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) overriddenSpecialBuiltin) != null) {
                    java.lang.String strComputeJvmDescriptor$default = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 2, null);
                    kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor original = ((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) callableDescriptor).getOriginal();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(original, "getOriginal(...)");
                    if (kotlin.jvm.internal.Intrinsics.areEqual(strComputeJvmDescriptor$default, kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(original, false, false, 2, null))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract getContract() {
        return kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    /* JADX INFO: compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor superDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor subDescriptor) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(superDescriptor, "superDescriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(subDescriptor, "subDescriptor");
            if ((subDescriptor instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor) && (superDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor)) {
                kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor javaMethodDescriptor = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor) subDescriptor;
                javaMethodDescriptor.getValueParameters().size();
                kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) superDescriptor;
                functionDescriptor.getValueParameters().size();
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = javaMethodDescriptor.getOriginal().getValueParameters();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters2 = functionDescriptor.getOriginal().getValueParameters();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
                for (kotlin.Pair pair : kotlin.collections.CollectionsKt.zip(valueParameters, valueParameters2)) {
                    kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) pair.component1();
                    kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) pair.component2();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(valueParameterDescriptor);
                    boolean z = mapValueParameterType((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) subDescriptor, valueParameterDescriptor) instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive;
                    kotlin.jvm.internal.Intrinsics.checkNotNull(valueParameterDescriptor2);
                    if (z != (mapValueParameterType(functionDescriptor, valueParameterDescriptor2) instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType mapValueParameterType(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor) {
            if (kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.forceSingleValueParameterBoxing(functionDescriptor) || isPrimitiveCompareTo(functionDescriptor)) {
                kotlin.reflect.jvm.internal.impl.types.KotlinType type = valueParameterDescriptor.getType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                return kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.mapToJvmType(kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(type));
            }
            kotlin.reflect.jvm.internal.impl.types.KotlinType type2 = valueParameterDescriptor.getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
            return kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.mapToJvmType(type2);
        }

        private final boolean isPrimitiveCompareTo(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor) {
            if (functionDescriptor.getValueParameters().size() != 1) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration : null;
            if (classDescriptor == null) {
                return false;
            }
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = ((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) kotlin.collections.CollectionsKt.single((java.util.List) valueParameters)).getType().getConstructor().mo1835getDeclarationDescriptor();
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor2 = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null;
            return classDescriptor2 != null && kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isPrimitiveClass(classDescriptor) && kotlin.jvm.internal.Intrinsics.areEqual(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(classDescriptor), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(classDescriptor2));
        }
    }
}
