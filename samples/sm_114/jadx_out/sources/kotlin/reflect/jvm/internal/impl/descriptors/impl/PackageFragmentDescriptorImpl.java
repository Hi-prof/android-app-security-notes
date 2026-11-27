package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: compiled from: PackageFragmentDescriptorImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class PackageFragmentDescriptorImpl extends kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl implements kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor {
    private final java.lang.String debugString;
    private final kotlin.reflect.jvm.internal.impl.name.FqName fqName;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public final kotlin.reflect.jvm.internal.impl.name.FqName getFqName() {
        return this.fqName;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PackageFragmentDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module, kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        super(module, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), fqName.shortNameOrSpecial(), kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = fqName;
        this.debugString = "package " + fqName + " of " + module;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor<R, D> visitor, D d) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visitor, "visitor");
        return visitor.visitPackageFragmentDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor getContainingDeclaration() {
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = super.getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
        return (kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor) containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public kotlin.reflect.jvm.internal.impl.descriptors.SourceElement getSource() {
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement NO_SOURCE = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public java.lang.String toString() {
        return this.debugString;
    }
}
