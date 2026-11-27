package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: ClassifierBasedTypeConstructor.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ClassifierBasedTypeConstructor implements kotlin.reflect.jvm.internal.impl.types.TypeConstructor {
    private int hashCode;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1835getDeclarationDescriptor();

    protected abstract boolean isSameClassifier(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptor);

    public int hashCode() {
        int iIdentityHashCode;
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = mo1835getDeclarationDescriptor();
        if (hasMeaningfulFqName(classifierDescriptorMo1835getDeclarationDescriptor)) {
            iIdentityHashCode = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getFqName(classifierDescriptorMo1835getDeclarationDescriptor).hashCode();
        } else {
            iIdentityHashCode = java.lang.System.identityHashCode(this);
        }
        this.hashCode = iIdentityHashCode;
        return iIdentityHashCode;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.types.TypeConstructor) || obj.hashCode() != hashCode()) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = (kotlin.reflect.jvm.internal.impl.types.TypeConstructor) obj;
        if (typeConstructor.getParameters().size() != getParameters().size()) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = mo1835getDeclarationDescriptor();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor2 = typeConstructor.mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor2 != null && hasMeaningfulFqName(classifierDescriptorMo1835getDeclarationDescriptor) && hasMeaningfulFqName(classifierDescriptorMo1835getDeclarationDescriptor2)) {
            return isSameClassifier(classifierDescriptorMo1835getDeclarationDescriptor2);
        }
        return false;
    }

    protected final boolean areFqNamesEqual(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor first, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor second) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(first, "first");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(second, "second");
        if (!kotlin.jvm.internal.Intrinsics.areEqual(first.getName(), second.getName())) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = first.getContainingDeclaration();
        for (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration2 = second.getContainingDeclaration(); containingDeclaration != null && containingDeclaration2 != null; containingDeclaration2 = containingDeclaration2.getContainingDeclaration()) {
            if (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor) {
                return containingDeclaration2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
            }
            if (containingDeclaration2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor) {
                return false;
            }
            if (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) {
                return (containingDeclaration2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) && kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) containingDeclaration).getFqName(), ((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) containingDeclaration2).getFqName());
            }
            if ((containingDeclaration2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) || !kotlin.jvm.internal.Intrinsics.areEqual(containingDeclaration.getName(), containingDeclaration2.getName())) {
                return false;
            }
            containingDeclaration = containingDeclaration.getContainingDeclaration();
        }
        return true;
    }

    private final boolean hasMeaningfulFqName(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptor2 = classifierDescriptor;
        return (kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.isError(classifierDescriptor2) || kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isLocal(classifierDescriptor2)) ? false : true;
    }
}
