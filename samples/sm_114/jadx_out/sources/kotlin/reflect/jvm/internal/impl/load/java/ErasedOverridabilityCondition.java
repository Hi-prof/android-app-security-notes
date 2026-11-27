package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ErasedOverridabilityCondition implements kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition {

    /* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result isOverridable(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor superDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor subDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(subDescriptor, "subDescriptor");
        if (subDescriptor instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor) {
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor javaMethodDescriptor = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor) subDescriptor;
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters = javaMethodDescriptor.getTypeParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            if (typeParameters.isEmpty()) {
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo basicOverridabilityProblem = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.getBasicOverridabilityProblem(superDescriptor, subDescriptor);
                if ((basicOverridabilityProblem != null ? basicOverridabilityProblem.getResult() : null) != null) {
                    return kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = javaMethodDescriptor.getValueParameters();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                kotlin.sequences.Sequence map = kotlin.sequences.SequencesKt.map(kotlin.collections.CollectionsKt.asSequence(valueParameters), new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.ErasedOverridabilityCondition$$Lambda$0
                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: invoke */
                    public java.lang.Object invoke2(java.lang.Object obj) {
                        return ((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) obj).getType();
                    }
                });
                kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = javaMethodDescriptor.getReturnType();
                kotlin.jvm.internal.Intrinsics.checkNotNull(returnType);
                kotlin.sequences.Sequence sequencePlus = kotlin.sequences.SequencesKt.plus((kotlin.sequences.Sequence<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType>) map, returnType);
                kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor extensionReceiverParameter = javaMethodDescriptor.getExtensionReceiverParameter();
                for (kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType : kotlin.sequences.SequencesKt.plus(sequencePlus, (java.lang.Iterable) kotlin.collections.CollectionsKt.listOfNotNull(extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null))) {
                    if (!kotlinType.getArguments().isEmpty() && !(kotlinType.unwrap() instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl)) {
                        return kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.UNKNOWN;
                    }
                }
                kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptorSubstitute = superDescriptor.substitute(new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution(null, 1, null).buildSubstitutor());
                if (functionDescriptorSubstitute == null) {
                    return kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                if (functionDescriptorSubstitute instanceof kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) {
                    kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) functionDescriptorSubstitute;
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters2 = simpleFunctionDescriptor.getTypeParameters();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters2, "getTypeParameters(...)");
                    if (!typeParameters2.isEmpty()) {
                        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptorBuild = simpleFunctionDescriptor.newCopyBuilder().setTypeParameters(kotlin.collections.CollectionsKt.emptyList()).build();
                        kotlin.jvm.internal.Intrinsics.checkNotNull(functionDescriptorBuild);
                        functionDescriptorSubstitute = functionDescriptorBuild;
                    }
                }
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result result = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(functionDescriptorSubstitute, subDescriptor, false).getResult();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                if (kotlin.reflect.jvm.internal.impl.load.java.ErasedOverridabilityCondition.WhenMappings.$EnumSwitchMapping$0[result.ordinal()] == 1) {
                    return kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.OVERRIDABLE;
                }
                return kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.UNKNOWN;
            }
        }
        return kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.UNKNOWN;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract getContract() {
        return kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract.SUCCESS_ONLY;
    }
}
