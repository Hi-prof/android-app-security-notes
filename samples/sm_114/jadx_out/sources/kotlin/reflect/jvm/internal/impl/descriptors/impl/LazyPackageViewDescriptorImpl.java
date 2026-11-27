package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: compiled from: LazyPackageViewDescriptorImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public class LazyPackageViewDescriptorImpl extends kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl implements kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl.class, "fragments", "getFragments()Ljava/util/List;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl.class, "empty", "getEmpty()Z", 0))};
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue empty$delegate;
    private final kotlin.reflect.jvm.internal.impl.name.FqName fqName;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue fragments$delegate;
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope;
    private final kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl module;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl getModule() {
        return this.module;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public kotlin.reflect.jvm.internal.impl.name.FqName getFqName() {
        return this.fqName;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl module, kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), fqName.shortNameOrSpecial());
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.module = module;
        this.fqName = fqName;
        this.fragments$delegate = storageManager.createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl.fragments_delegate$lambda$0(this.arg$0);
            }
        });
        this.empty$delegate = storageManager.createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl.empty_delegate$lambda$1(this.arg$0));
            }
        });
        this.memberScope = new kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter(storageManager, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl.memberScope$lambda$3(this.arg$0);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> getFragments() {
        return (java.util.List) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.fragments$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List fragments_delegate$lambda$0(kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        return kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt.packageFragments(lazyPackageViewDescriptorImpl.getModule().getPackageFragmentProvider(), lazyPackageViewDescriptorImpl.getFqName());
    }

    protected final boolean getEmpty() {
        return ((java.lang.Boolean) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.empty$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[1])).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean empty_delegate$lambda$1(kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        return kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt.isEmpty(lazyPackageViewDescriptorImpl.getModule().getPackageFragmentProvider(), lazyPackageViewDescriptorImpl.getFqName());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public boolean isEmpty() {
        return getEmpty();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getMemberScope() {
        return this.memberScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope$lambda$3(kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        if (lazyPackageViewDescriptorImpl.isEmpty()) {
            return kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty.INSTANCE;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> fragments = lazyPackageViewDescriptorImpl.getFragments();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(fragments, 10));
        java.util.Iterator<T> it = fragments.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) it.next()).getMemberScope());
        }
        java.util.List listPlus = kotlin.collections.CollectionsKt.plus((java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.impl.SubpackagesScope>) arrayList, new kotlin.reflect.jvm.internal.impl.descriptors.impl.SubpackagesScope(lazyPackageViewDescriptorImpl.getModule(), lazyPackageViewDescriptorImpl.getFqName()));
        return kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope.Companion.create("package view scope for " + lazyPackageViewDescriptorImpl.getFqName() + " in " + lazyPackageViewDescriptorImpl.getModule().getName(), listPlus);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor getContainingDeclaration() {
        if (getFqName().isRoot()) {
            return null;
        }
        return getModule().getPackage(getFqName().parent());
    }

    public boolean equals(java.lang.Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor packageViewDescriptor = obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor) obj : null;
        return packageViewDescriptor != null && kotlin.jvm.internal.Intrinsics.areEqual(getFqName(), packageViewDescriptor.getFqName()) && kotlin.jvm.internal.Intrinsics.areEqual(getModule(), packageViewDescriptor.getModule());
    }

    public int hashCode() {
        return (getModule().hashCode() * 31) + getFqName().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor<R, D> visitor, D d) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visitor, "visitor");
        return visitor.visitPackageViewDescriptor(this, d);
    }
}
