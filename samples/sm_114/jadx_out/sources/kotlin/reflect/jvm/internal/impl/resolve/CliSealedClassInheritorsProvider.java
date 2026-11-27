package kotlin.reflect.jvm.internal.impl.resolve;

/* JADX INFO: compiled from: SealedClassInheritorsProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CliSealedClassInheritorsProvider extends kotlin.reflect.jvm.internal.impl.resolve.SealedClassInheritorsProvider {
    public static final kotlin.reflect.jvm.internal.impl.resolve.CliSealedClassInheritorsProvider INSTANCE = new kotlin.reflect.jvm.internal.impl.resolve.CliSealedClassInheritorsProvider();

    private CliSealedClassInheritorsProvider() {
    }

    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> computeSealedSubclasses(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor sealedClass, boolean z) {
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor next;
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sealedClass, "sealedClass");
        if (sealedClass.getModality() != kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        if (!z) {
            containingDeclaration = sealedClass.getContainingDeclaration();
        } else {
            java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> it = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getParents(sealedClass).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(next instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor));
            containingDeclaration = next;
        }
        if (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) {
            computeSealedSubclasses$collectSubclasses(sealedClass, linkedHashSet, ((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) containingDeclaration).getMemberScope(), z);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope unsubstitutedInnerClassesScope = sealedClass.getUnsubstitutedInnerClassesScope();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "getUnsubstitutedInnerClassesScope(...)");
        computeSealedSubclasses$collectSubclasses(sealedClass, linkedHashSet, unsubstitutedInnerClassesScope, true);
        return kotlin.collections.CollectionsKt.sortedWith(linkedHashSet, new java.util.Comparator() { // from class: kotlin.reflect.jvm.internal.impl.resolve.CliSealedClassInheritorsProvider$computeSealedSubclasses$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return kotlin.comparisons.ComparisonsKt.compareValues(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) t).asString(), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) t2).asString());
            }
        });
    }

    private static final void computeSealedSubclasses$collectSubclasses(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, java.util.LinkedHashSet<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> linkedHashSet, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope, boolean z) {
        for (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor : kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls.getContributedDescriptors$default(memberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.CLASSIFIERS, null, 2, null)) {
            if (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) declarationDescriptor;
                if (classDescriptor2.isExpect()) {
                    kotlin.reflect.jvm.internal.impl.name.Name name = classDescriptor2.getName();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor contributedClassifier = memberScope.mo1837getContributedClassifier(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
                    if (contributedClassifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
                        classDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) contributedClassifier;
                    } else {
                        classDescriptor2 = contributedClassifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor ? ((kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) contributedClassifier).getClassDescriptor() : null;
                    }
                }
                if (classDescriptor2 != null) {
                    if (kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isDirectSubclass(classDescriptor2, classDescriptor)) {
                        linkedHashSet.add(classDescriptor2);
                    }
                    if (z) {
                        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope unsubstitutedInnerClassesScope = classDescriptor2.getUnsubstitutedInnerClassesScope();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "getUnsubstitutedInnerClassesScope(...)");
                        computeSealedSubclasses$collectSubclasses(classDescriptor, linkedHashSet, unsubstitutedInnerClassesScope, z);
                    }
                }
            }
        }
    }
}
