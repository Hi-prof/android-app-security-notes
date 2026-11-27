package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: AbstractDeserializedPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractDeserializedPackageFragmentProvider implements kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized {
    protected kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents components;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder finder;
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> fragments;
    private final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor;
    private final kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager;

    protected abstract kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment findPackage(kotlin.reflect.jvm.internal.impl.name.FqName fqName);

    public AbstractDeserializedPackageFragmentProvider(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder finder, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(finder, "finder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        this.storageManager = storageManager;
        this.finder = finder;
        this.moduleDescriptor = moduleDescriptor;
        this.fragments = storageManager.createMemoizedFunctionWithNullableValues(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider.fragments$lambda$1(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.FqName) obj);
            }
        });
    }

    protected final kotlin.reflect.jvm.internal.impl.storage.StorageManager getStorageManager() {
        return this.storageManager;
    }

    protected final kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder getFinder() {
        return this.finder;
    }

    protected final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    protected final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents getComponents() {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents != null) {
            return deserializationComponents;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    protected final void setComponents(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents deserializationComponents) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor fragments$lambda$1(kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider abstractDeserializedPackageFragmentProvider, kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment deserializedPackageFragmentFindPackage = abstractDeserializedPackageFragmentProvider.findPackage(fqName);
        if (deserializedPackageFragmentFindPackage != null) {
            deserializedPackageFragmentFindPackage.initialize(abstractDeserializedPackageFragmentProvider.getComponents());
        } else {
            deserializedPackageFragmentFindPackage = null;
        }
        return deserializedPackageFragmentFindPackage;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(kotlin.reflect.jvm.internal.impl.name.FqName fqName, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> packageFragments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFragments, "packageFragments");
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(packageFragments, this.fragments.invoke2(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor packageFragmentDescriptorFindPackage;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.fragments.isComputed(fqName)) {
            packageFragmentDescriptorFindPackage = this.fragments.invoke2(fqName);
        } else {
            packageFragmentDescriptorFindPackage = findPackage(fqName);
        }
        return packageFragmentDescriptorFindPackage == null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @kotlin.Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> getPackageFragments(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return kotlin.collections.CollectionsKt.listOfNotNull(this.fragments.invoke2(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.name.FqName> getSubPackagesOf(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return kotlin.collections.SetsKt.emptySet();
    }
}
