package kotlin.reflect.jvm.internal.impl.resolve;

/* JADX INFO: compiled from: inlineClassesUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InlineClassesUtilsKt {
    private static final kotlin.reflect.jvm.internal.impl.name.ClassId JVM_INLINE_ANNOTATION_CLASS_ID;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JVM_INLINE_ANNOTATION_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName JVM_NAME_ANNOTATION_FQ_NAME;

    static {
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.JvmInline");
        JVM_INLINE_ANNOTATION_FQ_NAME = fqName;
        JVM_INLINE_ANNOTATION_CLASS_ID = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(fqName);
        JVM_NAME_ANNOTATION_FQ_NAME = new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.JvmName");
    }

    public static final boolean isInlineClass(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) && (((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) declarationDescriptor).getValueClassRepresentation() instanceof kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation);
    }

    public static final boolean isMultiFieldValueClass(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) && (((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) declarationDescriptor).getValueClassRepresentation() instanceof kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation);
    }

    public static final boolean isValueClass(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return isInlineClass(declarationDescriptor) || isMultiFieldValueClass(declarationDescriptor);
    }

    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType unsubstitutedUnderlyingType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> inlineClassRepresentation;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType = null;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null;
        if (classDescriptor != null && (inlineClassRepresentation = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getInlineClassRepresentation(classDescriptor)) != null) {
            simpleType = (kotlin.reflect.jvm.internal.impl.types.SimpleType) inlineClassRepresentation.getUnderlyingType();
        }
        return simpleType;
    }

    public static final boolean isInlineClassType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor != null) {
            return isInlineClass(classifierDescriptorMo1835getDeclarationDescriptor);
        }
        return false;
    }

    public static final boolean isValueClassType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor != null) {
            return isValueClass(classifierDescriptorMo1835getDeclarationDescriptor);
        }
        return false;
    }

    public static final boolean needsMfvcFlattening(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        return (classifierDescriptorMo1835getDeclarationDescriptor == null || !isMultiFieldValueClass(classifierDescriptorMo1835getDeclarationDescriptor) || kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE.isNullableType(kotlinType)) ? false : true;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType substitutedUnderlyingType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeUnsubstitutedUnderlyingType = unsubstitutedUnderlyingType(kotlinType);
        if (kotlinTypeUnsubstitutedUnderlyingType != null) {
            return kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.create(kotlinType).substitute(kotlinTypeUnsubstitutedUnderlyingType, kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT);
        }
        return null;
    }

    public static final boolean isGetterOfUnderlyingPropertyOfValueClass(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableDescriptor, "<this>");
        if (!(callableDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor correspondingProperty = ((kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor) callableDescriptor).getCorrespondingProperty();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(correspondingProperty, "getCorrespondingProperty(...)");
        return isUnderlyingPropertyOfValueClass(correspondingProperty);
    }

    public static final boolean isUnderlyingPropertyOfInlineClass(kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor variableDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> inlineClassRepresentation;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(variableDescriptor, "<this>");
        if (variableDescriptor.getExtensionReceiverParameter() != null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = variableDescriptor.getContainingDeclaration();
        kotlin.reflect.jvm.internal.impl.name.Name underlyingPropertyName = null;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null && (inlineClassRepresentation = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getInlineClassRepresentation(classDescriptor)) != null) {
            underlyingPropertyName = inlineClassRepresentation.getUnderlyingPropertyName();
        }
        return kotlin.jvm.internal.Intrinsics.areEqual(underlyingPropertyName, variableDescriptor.getName());
    }

    public static final boolean isUnderlyingPropertyOfValueClass(kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor variableDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> valueClassRepresentation;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(variableDescriptor, "<this>");
        if (variableDescriptor.getExtensionReceiverParameter() != null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = variableDescriptor.getContainingDeclaration();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null || (valueClassRepresentation = classDescriptor.getValueClassRepresentation()) == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.name.Name name = variableDescriptor.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return valueClassRepresentation.containsPropertyWithName(name);
    }
}
