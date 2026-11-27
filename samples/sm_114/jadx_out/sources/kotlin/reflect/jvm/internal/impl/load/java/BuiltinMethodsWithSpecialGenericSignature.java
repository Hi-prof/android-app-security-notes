package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BuiltinMethodsWithSpecialGenericSignature extends kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures {
    public static final kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature INSTANCE = new kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature();

    private BuiltinMethodsWithSpecialGenericSignature() {
    }

    private final boolean getHasErasedValueParametersInJava(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        return kotlin.collections.CollectionsKt.contains(kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SIGNATURES(), kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmSignature(callableMemberDescriptor));
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor getOverriddenBuiltinFunctionWithErasedValueParametersInJava(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = INSTANCE;
        kotlin.reflect.jvm.internal.impl.name.Name name = functionDescriptor.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.firstOverridden$default(functionDescriptor, false, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj) {
                    return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava$lambda$0((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) obj));
                }
            }, 1, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getOverriddenBuiltinFunctionWithErasedValueParametersInJava$lambda$0(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.getHasErasedValueParametersInJava(it);
    }

    public final boolean getSameAsBuiltinMethodWithErasedValueParameters(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "<this>");
        return kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(name);
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.SpecialSignatureInfo getSpecialSignatureInfo(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptorFirstOverridden$default;
        java.lang.String strComputeJvmSignature;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        if (!kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(callableMemberDescriptor.getName()) || (callableMemberDescriptorFirstOverridden$default = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.firstOverridden$default(callableMemberDescriptor, false, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.getSpecialSignatureInfo$lambda$3((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) obj));
            }
        }, 1, null)) == null || (strComputeJvmSignature = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmSignature(callableMemberDescriptorFirstOverridden$default)) == null) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.getSpecialSignatureInfo(strComputeJvmSignature);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getSpecialSignatureInfo$lambda$3(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return (it instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) && INSTANCE.getHasErasedValueParametersInJava(it);
    }
}
