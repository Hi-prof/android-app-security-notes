package kotlin.reflect.jvm.internal.impl.resolve.jvm;

/* JADX INFO: compiled from: inlineClassManglingRules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InlineClassManglingRulesKt {
    public static final boolean shouldHideConstructorDueToValueClassTypeValueParameters(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor descriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptor = descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) descriptor : null;
        if (classConstructorDescriptor == null || kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.isPrivate(classConstructorDescriptor.getVisibility())) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor constructedClass = classConstructorDescriptor.getConstructedClass();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(constructedClass, "getConstructedClass(...)");
        if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClass(constructedClass) || kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isSealedClass(classConstructorDescriptor.getConstructedClass())) {
            return false;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list = valueParameters;
        if ((list instanceof java.util.Collection) && list.isEmpty()) {
            return false;
        }
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = ((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) it.next()).getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            if (requiresFunctionNameManglingInParameterTypes(type)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isValueClassThatRequiresMangling(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClass(declarationDescriptor) && !isDontMangleClass((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) declarationDescriptor);
    }

    public static final boolean isValueClassThatRequiresMangling(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptor = classifierDescriptorMo1835getDeclarationDescriptor;
            if ((kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(classifierDescriptor) && isValueClassThatRequiresMangling(classifierDescriptor)) || kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.needsMfvcFlattening(kotlinType)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean requiresFunctionNameManglingInParameterTypes(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        return isValueClassThatRequiresMangling(kotlinType) || isTypeParameterWithUpperBoundThatRequiresMangling(kotlinType, true);
    }

    private static final boolean isDontMangleClass(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        return kotlin.jvm.internal.Intrinsics.areEqual(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(classDescriptor), kotlin.reflect.jvm.internal.impl.builtins.StandardNames.RESULT_FQ_NAME);
    }

    private static final boolean isTypeParameterWithUpperBoundThatRequiresMangling(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, boolean z) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null;
        if (typeParameterDescriptor == null) {
            return false;
        }
        return (z || !kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isMultiFieldValueClass(typeParameterDescriptor)) && requiresFunctionNameManglingInParameterTypes(kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getRepresentativeUpperBound(typeParameterDescriptor));
    }
}
