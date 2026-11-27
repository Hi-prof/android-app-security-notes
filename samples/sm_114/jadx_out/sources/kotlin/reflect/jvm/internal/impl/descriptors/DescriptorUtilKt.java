package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: descriptorUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DescriptorUtilKt {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor resolveClassByFqName(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation lookupLocation) {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope unsubstitutedInnerClassesScope;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lookupLocation, "lookupLocation");
        if (fqName.isRoot()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor contributedClassifier = moduleDescriptor.getPackage(fqName.parent()).getMemberScope().mo1837getContributedClassifier(fqName.shortName(), lookupLocation);
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = contributedClassifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) contributedClassifier : null;
        if (classDescriptor != null) {
            return classDescriptor;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorResolveClassByFqName = resolveClassByFqName(moduleDescriptor, fqName.parent(), lookupLocation);
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor contributedClassifier2 = (classDescriptorResolveClassByFqName == null || (unsubstitutedInnerClassesScope = classDescriptorResolveClassByFqName.getUnsubstitutedInnerClassesScope()) == null) ? null : unsubstitutedInnerClassesScope.mo1837getContributedClassifier(fqName.shortName(), lookupLocation);
        if (contributedClassifier2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) contributedClassifier2;
        }
        return null;
    }

    public static final boolean isTopLevelInPackage(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return declarationDescriptor.getContainingDeclaration() instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor getTopLevelContainingClassifier(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        if (containingDeclaration != null && !(declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor)) {
            if (!isTopLevelInPackage(containingDeclaration)) {
                return getTopLevelContainingClassifier(containingDeclaration);
            }
            if (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) {
                return (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) containingDeclaration;
            }
        }
        return null;
    }

    public static final boolean isTypedEqualsInValueClass(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor) {
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType;
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeReplaceArgumentsWithStarProjections;
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functionDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor2 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClass(classDescriptor) ? classDescriptor : null;
            if (classDescriptor2 != null && (defaultType = classDescriptor2.getDefaultType()) != null && (kotlinTypeReplaceArgumentsWithStarProjections = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType)) != null && (returnType = functionDescriptor.getReturnType()) != null && kotlin.jvm.internal.Intrinsics.areEqual(functionDescriptor.getName(), kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.EQUALS) && ((kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isBoolean(returnType) || kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isNothing(returnType)) && functionDescriptor.getValueParameters().size() == 1)) {
                kotlin.reflect.jvm.internal.impl.types.KotlinType type = functionDescriptor.getValueParameters().get(0).getType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                if (kotlin.jvm.internal.Intrinsics.areEqual(kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(type), kotlinTypeReplaceArgumentsWithStarProjections) && functionDescriptor.getContextReceiverParameters().isEmpty() && functionDescriptor.getExtensionReceiverParameter() == null) {
                    return true;
                }
            }
        }
        return false;
    }
}
