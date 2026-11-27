package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BuiltinMethodsWithDifferentJvmName extends kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures {
    public static final kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName INSTANCE = new kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName();

    private BuiltinMethodsWithDifferentJvmName() {
    }

    public final kotlin.reflect.jvm.internal.impl.name.Name getJvmName(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor functionDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.name.Name> signature_to_jvm_representation_name = kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.getSIGNATURE_TO_JVM_REPRESENTATION_NAME();
        java.lang.String strComputeJvmSignature = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmSignature(functionDescriptor);
        if (strComputeJvmSignature == null) {
            return null;
        }
        return signature_to_jvm_representation_name.get(strComputeJvmSignature);
    }

    public final boolean isBuiltinFunctionWithDifferentNameInJvm(final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor functionDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        return kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBuiltIn(functionDescriptor) && kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.firstOverridden$default(functionDescriptor, false, new kotlin.jvm.functions.Function1(functionDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor arg$0;

            {
                this.arg$0 = functionDescriptor;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName.isBuiltinFunctionWithDifferentNameInJvm$lambda$0(this.arg$0, (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) obj));
            }
        }, 1, null) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isBuiltinFunctionWithDifferentNameInJvm$lambda$0(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.getSIGNATURE_TO_JVM_REPRESENTATION_NAME().containsKey(kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmSignature(simpleFunctionDescriptor));
    }

    public final boolean isRemoveAtByIndex(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "<this>");
        return kotlin.jvm.internal.Intrinsics.areEqual(simpleFunctionDescriptor.getName().asString(), "removeAt") && kotlin.jvm.internal.Intrinsics.areEqual(kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmSignature(simpleFunctionDescriptor), kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.getREMOVE_AT_NAME_AND_SIGNATURE().getSignature());
    }
}
