package kotlin.reflect.jvm.internal.impl.util;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes2.dex */
final class NoDefaultAndVarargsCheck implements kotlin.reflect.jvm.internal.impl.util.Check {
    public static final kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck INSTANCE = new kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck();
    private static final java.lang.String description = "should not have varargs or parameters with default values";

    private NoDefaultAndVarargsCheck() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public java.lang.String invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor) {
        return kotlin.reflect.jvm.internal.impl.util.Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public java.lang.String getDescription() {
        return description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list = valueParameters;
        if ((list instanceof java.util.Collection) && list.isEmpty()) {
            return true;
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor : list) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(valueParameterDescriptor);
            if (kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor) || valueParameterDescriptor.getVarargElementType() != null) {
                return false;
            }
        }
        return true;
    }
}
