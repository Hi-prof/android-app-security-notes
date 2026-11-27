package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModuleDescriptorImpl extends kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl implements kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor {
    private final kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns;
    private final java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<?>, java.lang.Object> capabilities;
    private kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies dependencies;
    private boolean isValid;
    private kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider packageFragmentProviderForModuleContent;
    private final kotlin.Lazy packageFragmentProviderForWholeModuleWithDependencies$delegate;
    private final kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory packageViewDescriptorFactory;
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor> packages;
    private final kotlin.reflect.jvm.internal.impl.platform.TargetPlatform platform;
    private final kotlin.reflect.jvm.internal.impl.name.Name stableName;
    private final kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl(kotlin.reflect.jvm.internal.impl.name.Name moduleName, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns, kotlin.reflect.jvm.internal.impl.platform.TargetPlatform targetPlatform) {
        this(moduleName, storageManager, builtIns, targetPlatform, null, null, 48, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builtIns, "builtIns");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return (R) kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor.DefaultImpls.accept(this, declarationDescriptorVisitor, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor getContainingDeclaration() {
        return kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns getBuiltIns() {
        return this.builtIns;
    }

    public /* synthetic */ ModuleDescriptorImpl(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns kotlinBuiltIns, kotlin.reflect.jvm.internal.impl.platform.TargetPlatform targetPlatform, java.util.Map map, kotlin.reflect.jvm.internal.impl.name.Name name2, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(name, storageManager, kotlinBuiltIns, (i & 8) != 0 ? null : targetPlatform, (i & 16) != 0 ? kotlin.collections.MapsKt.emptyMap() : map, (i & 32) != 0 ? null : name2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl(kotlin.reflect.jvm.internal.impl.name.Name moduleName, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns, kotlin.reflect.jvm.internal.impl.platform.TargetPlatform targetPlatform, java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<?>, ? extends java.lang.Object> capabilities, kotlin.reflect.jvm.internal.impl.name.Name name) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), moduleName);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        this.storageManager = storageManager;
        this.builtIns = builtIns;
        this.platform = targetPlatform;
        this.stableName = name;
        if (!moduleName.isSpecial()) {
            throw new java.lang.IllegalArgumentException("Module name must be special: " + moduleName);
        }
        this.capabilities = capabilities;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory.Default r2 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory) getCapability(kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory.Companion.getCAPABILITY());
        this.packageViewDescriptorFactory = r2 == null ? kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory.Default.INSTANCE : r2;
        this.isValid = true;
        this.packages = storageManager.createMemoizedFunction(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl.packages$lambda$0(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.FqName) obj);
            }
        });
        this.packageFragmentProviderForWholeModuleWithDependencies$delegate = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl.packageFragmentProviderForWholeModuleWithDependencies_delegate$lambda$10(this.arg$0);
            }
        });
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void assertValid() {
        if (isValid()) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleExceptionKt.moduleInvalidated(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor packages$lambda$0(kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl moduleDescriptorImpl, kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return moduleDescriptorImpl.packageViewDescriptorFactory.compute(moduleDescriptorImpl, fqName, moduleDescriptorImpl.storageManager);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor> getExpectedByModules() {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies moduleDependencies = this.dependencies;
        if (moduleDependencies != null) {
            return moduleDependencies.getDirectExpectedByDependencies();
        }
        throw new java.lang.AssertionError("Dependencies of module " + getId() + " were not set");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor getPackage(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        assertValid();
        return this.packages.invoke(fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.name.FqName> getSubPackagesOf(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(fqName, nameFilter);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider getPackageFragmentProviderForWholeModuleWithDependencies() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider) this.packageFragmentProviderForWholeModuleWithDependencies$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider packageFragmentProviderForWholeModuleWithDependencies_delegate$lambda$10(kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl moduleDescriptorImpl) {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies moduleDependencies = moduleDescriptorImpl.dependencies;
        if (moduleDependencies == null) {
            throw new java.lang.AssertionError("Dependencies of module " + moduleDescriptorImpl.getId() + " were not set before querying module content");
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> allDependencies = moduleDependencies.getAllDependencies();
        moduleDescriptorImpl.assertValid();
        allDependencies.contains(moduleDescriptorImpl);
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> list = allDependencies;
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl) it.next()).isInitialized();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider packageFragmentProvider = ((kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl) it2.next()).packageFragmentProviderForModuleContent;
            kotlin.jvm.internal.Intrinsics.checkNotNull(packageFragmentProvider);
            arrayList.add(packageFragmentProvider);
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider(arrayList, "CompositeProvider@ModuleDescriptor for " + moduleDescriptorImpl.getName());
    }

    private final boolean isInitialized() {
        return this.packageFragmentProviderForModuleContent != null;
    }

    public final void setDependencies(kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies dependencies) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dependencies, "dependencies");
        this.dependencies = dependencies;
    }

    public final void setDependencies(kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl... descriptors) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        setDependencies(kotlin.collections.ArraysKt.toList(descriptors));
    }

    public final void setDependencies(java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> descriptors) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        setDependencies(descriptors, kotlin.collections.SetsKt.emptySet());
    }

    public final void setDependencies(java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> descriptors, java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> friends) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(friends, "friends");
        setDependencies(new kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependenciesImpl(descriptors, friends, kotlin.collections.CollectionsKt.emptyList(), kotlin.collections.SetsKt.emptySet()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public boolean shouldSeeInternalsOf(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor targetModule) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(targetModule, "targetModule");
        if (kotlin.jvm.internal.Intrinsics.areEqual(this, targetModule)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies moduleDependencies = this.dependencies;
        kotlin.jvm.internal.Intrinsics.checkNotNull(moduleDependencies);
        return kotlin.collections.CollectionsKt.contains(moduleDependencies.getModulesWhoseInternalsAreVisible(), targetModule) || getExpectedByModules().contains(targetModule) || targetModule.getExpectedByModules().contains(this);
    }

    private final java.lang.String getId() {
        java.lang.String string = getName().toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void initialize(kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider providerForModuleContent) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(providerForModuleContent, "providerForModuleContent");
        isInitialized();
        this.packageFragmentProviderForModuleContent = providerForModuleContent;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider getPackageFragmentProvider() {
        assertValid();
        return getPackageFragmentProviderForWholeModuleWithDependencies();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public <T> T getCapability(kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<T> capability) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(capability, "capability");
        T t = (T) this.capabilities.get(capability);
        if (t == null) {
            return null;
        }
        return t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public java.lang.String toString() {
        java.lang.Class<?> cls;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(super.toString());
        if (!isValid()) {
            sb.append(" !isValid");
        }
        sb.append(" packageFragmentProvider: ");
        kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider packageFragmentProvider = this.packageFragmentProviderForModuleContent;
        sb.append((packageFragmentProvider == null || (cls = packageFragmentProvider.getClass()) == null) ? null : cls.getSimpleName());
        return sb.toString();
    }
}
