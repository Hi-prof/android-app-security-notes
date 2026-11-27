package kotlin.reflect.jvm.internal.impl.load.java.lazy;

/* JADX INFO: compiled from: LazyJavaPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyJavaPackageFragmentProvider implements kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized {
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c;
    private final kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment> packageFragments;

    public LazyJavaPackageFragmentProvider(kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents components) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(components, "components");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext = new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext(components, kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver.EMPTY.INSTANCE, kotlin.LazyKt.lazyOf(null));
        this.c = lazyJavaResolverContext;
        this.packageFragments = lazyJavaResolverContext.getStorageManager().createCacheWithNotNullValues();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public /* bridge */ /* synthetic */ java.util.Collection getSubPackagesOf(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.jvm.functions.Function1 function1) {
        return getSubPackagesOf(fqName, (kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean>) function1);
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment getPackageFragment(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage javaPackageFindPackage$default = kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder$$Util.findPackage$default(this.c.getComponents().getFinder(), fqName, false, 2, null);
        if (javaPackageFindPackage$default == null) {
            return null;
        }
        return this.packageFragments.computeIfAbsent(fqName, new kotlin.jvm.functions.Function0(this, javaPackageFindPackage$default) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider arg$0;
            private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = javaPackageFindPackage$default;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider.getPackageFragment$lambda$0(this.arg$0, this.arg$1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment getPackageFragment$lambda$0(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage javaPackage) {
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment(lazyJavaPackageFragmentProvider.c, javaPackage);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @kotlin.Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public java.util.List<kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment> getPackageFragments(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return kotlin.collections.CollectionsKt.listOfNotNull(getPackageFragment(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(kotlin.reflect.jvm.internal.impl.name.FqName fqName, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> packageFragments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFragments, "packageFragments");
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(packageFragments, getPackageFragment(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder$$Util.findPackage$default(this.c.getComponents().getFinder(), fqName, false, 2, null) == null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public java.util.List<kotlin.reflect.jvm.internal.impl.name.FqName> getSubPackagesOf(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment packageFragment = getPackageFragment(fqName);
        java.util.List<kotlin.reflect.jvm.internal.impl.name.FqName> subPackageFqNames$descriptors_jvm = packageFragment != null ? packageFragment.getSubPackageFqNames$descriptors_jvm() : null;
        return subPackageFqNames$descriptors_jvm == null ? kotlin.collections.CollectionsKt.emptyList() : subPackageFqNames$descriptors_jvm;
    }

    public java.lang.String toString() {
        return "LazyJavaPackageFragmentProvider of module " + this.c.getComponents().getModule();
    }
}
