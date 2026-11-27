package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: compiled from: SubpackagesScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public class SubpackagesScope extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl {
    private final kotlin.reflect.jvm.internal.impl.name.FqName fqName;
    private final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor;

    public SubpackagesScope(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.moduleDescriptor = moduleDescriptor;
        this.fqName = fqName;
    }

    protected final kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor getPackage(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        if (name.isSpecial()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor packageViewDescriptor = this.moduleDescriptor.getPackage(this.fqName.child(name));
        if (packageViewDescriptor.isEmpty()) {
            return null;
        }
        return packageViewDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        if (!kindFilter.acceptsKinds(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion.getPACKAGES_MASK())) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        if (this.fqName.isRoot() && kindFilter.getExcludes().contains(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude.TopLevelPackages.INSTANCE)) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.name.FqName> subPackagesOf = this.moduleDescriptor.getSubPackagesOf(this.fqName, nameFilter);
        java.util.ArrayList arrayList = new java.util.ArrayList(subPackagesOf.size());
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.name.FqName> it = subPackagesOf.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.name.Name nameShortName = it.next().shortName();
            if (nameFilter.invoke2(nameShortName).booleanValue()) {
                kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList, getPackage(nameShortName));
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getClassifierNames() {
        return kotlin.collections.SetsKt.emptySet();
    }

    public java.lang.String toString() {
        return "subpackages of " + this.fqName + " from " + this.moduleDescriptor;
    }
}
