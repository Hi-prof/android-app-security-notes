package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: compiled from: CompositePackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CompositePackageFragmentProvider implements kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized {
    private final java.lang.String debugName;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider> providers;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositePackageFragmentProvider(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider> providers, java.lang.String debugName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(providers, "providers");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(debugName, "debugName");
        this.providers = providers;
        this.debugName = debugName;
        providers.size();
        kotlin.collections.CollectionsKt.toSet(providers).size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @kotlin.Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> getPackageFragments(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider> it = this.providers.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(it.next(), fqName, arrayList);
        }
        return kotlin.collections.CollectionsKt.toList(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(kotlin.reflect.jvm.internal.impl.name.FqName fqName, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> packageFragments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFragments, "packageFragments");
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider> it = this.providers.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(it.next(), fqName, packageFragments);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider> list = this.providers;
        if ((list instanceof java.util.Collection) && list.isEmpty()) {
            return true;
        }
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt.isEmpty((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider) it.next(), fqName)) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.name.FqName> getSubPackagesOf(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider> it = this.providers.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().getSubPackagesOf(fqName, nameFilter));
        }
        return hashSet;
    }

    public java.lang.String toString() {
        return this.debugName;
    }
}
