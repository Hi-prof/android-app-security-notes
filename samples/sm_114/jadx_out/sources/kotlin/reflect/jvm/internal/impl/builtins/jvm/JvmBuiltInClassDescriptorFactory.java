package kotlin.reflect.jvm.internal.impl.builtins.jvm;

/* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmBuiltInClassDescriptorFactory implements kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory {
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue cloneable$delegate;
    private final kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> computeContainingDeclaration;
    private final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor;
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory.class, "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;", 0))};
    public static final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory.Companion Companion = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory.Companion(null);
    private static final kotlin.reflect.jvm.internal.impl.name.FqName KOTLIN_FQ_NAME = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_FQ_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.Name CLONEABLE_NAME = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.cloneable.shortName();
    private static final kotlin.reflect.jvm.internal.impl.name.ClassId CLONEABLE_CLASS_ID = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.cloneable.toSafe());

    /* JADX WARN: Multi-variable type inference failed */
    public JvmBuiltInClassDescriptorFactory(final kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, ? extends kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> computeContainingDeclaration) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(computeContainingDeclaration, "computeContainingDeclaration");
        this.moduleDescriptor = moduleDescriptor;
        this.computeContainingDeclaration = computeContainingDeclaration;
        this.cloneable$delegate = storageManager.createLazyValue(new kotlin.jvm.functions.Function0(this, storageManager) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory arg$0;
            private final kotlin.reflect.jvm.internal.impl.storage.StorageManager arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = storageManager;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory.cloneable_delegate$lambda$2(this.arg$0, this.arg$1);
            }
        });
    }

    public /* synthetic */ JvmBuiltInClassDescriptorFactory(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, kotlin.jvm.functions.Function1 function1, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, moduleDescriptor, (i & 4) != 0 ? new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory._init_$lambda$0((kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor) obj);
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment _init_$lambda$0(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> fragments = module.getPackage(KOTLIN_FQ_NAME).getFragments();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : fragments) {
            if (obj instanceof kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment) {
                arrayList.add(obj);
            }
        }
        return (kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment) kotlin.collections.CollectionsKt.first((java.util.List) arrayList);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl getCloneable() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.cloneable$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl cloneable_delegate$lambda$2(kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory jvmBuiltInClassDescriptorFactory, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager) {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl classDescriptorImpl = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl(jvmBuiltInClassDescriptorFactory.computeContainingDeclaration.invoke2(jvmBuiltInClassDescriptorFactory.moduleDescriptor), CLONEABLE_NAME, kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT, kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE, kotlin.collections.CollectionsKt.listOf(jvmBuiltInClassDescriptorFactory.moduleDescriptor.getBuiltIns().getAnyType()), kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE, false, storageManager);
        classDescriptorImpl.initialize(new kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope(storageManager, classDescriptorImpl), kotlin.collections.SetsKt.emptySet(), null);
        return classDescriptorImpl;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(kotlin.reflect.jvm.internal.impl.name.FqName packageFqName, kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return kotlin.jvm.internal.Intrinsics.areEqual(name, CLONEABLE_NAME) && kotlin.jvm.internal.Intrinsics.areEqual(packageFqName, KOTLIN_FQ_NAME);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor createClass(kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
        if (kotlin.jvm.internal.Intrinsics.areEqual(classId, CLONEABLE_CLASS_ID)) {
            return getCloneable();
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> getAllContributedClassesIfPossible(kotlin.reflect.jvm.internal.impl.name.FqName packageFqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        return kotlin.jvm.internal.Intrinsics.areEqual(packageFqName, KOTLIN_FQ_NAME) ? kotlin.collections.SetsKt.setOf(getCloneable()) : kotlin.collections.SetsKt.emptySet();
    }

    /* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.name.ClassId getCLONEABLE_CLASS_ID() {
            return kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory.CLONEABLE_CLASS_ID;
        }
    }
}
