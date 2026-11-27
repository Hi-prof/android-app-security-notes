package kotlin.reflect.jvm.internal.impl.types.error;

/* JADX INFO: compiled from: ErrorModuleDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ErrorModuleDescriptor implements kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor {
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorModuleDescriptor INSTANCE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorModuleDescriptor();
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor> allDependencyModules;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor> allExpectedByModules;
    private static final kotlin.Lazy builtIns$delegate;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor> expectedByModules;
    private static final kotlin.reflect.jvm.internal.impl.name.Name stableName;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor<R, D> visitor, D d) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visitor, "visitor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public <T> T getCapability(kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<T> capability) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(capability, "capability");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor getContainingDeclaration() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public boolean shouldSeeInternalsOf(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor targetModule) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(targetModule, "targetModule");
        return false;
    }

    private ErrorModuleDescriptor() {
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial = kotlin.reflect.jvm.internal.impl.name.Name.special(kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity.ERROR_MODULE.getDebugText());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial, "special(...)");
        stableName = nameSpecial;
        allDependencyModules = kotlin.collections.CollectionsKt.emptyList();
        expectedByModules = kotlin.collections.CollectionsKt.emptyList();
        allExpectedByModules = kotlin.collections.SetsKt.emptySet();
        builtIns$delegate = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: kotlin.reflect.jvm.internal.impl.types.error.ErrorModuleDescriptor$$Lambda$0
            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.types.error.ErrorModuleDescriptor.builtIns_delegate$lambda$0();
            }
        });
    }

    public kotlin.reflect.jvm.internal.impl.name.Name getStableName() {
        return stableName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor> getExpectedByModules() {
        return expectedByModules;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getAnnotations() {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns builtIns_delegate$lambda$0() {
        return kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns.Companion.getInstance();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns getBuiltIns() {
        return (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns) builtIns$delegate.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.name.FqName> getSubPackagesOf(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public kotlin.reflect.jvm.internal.impl.name.Name getName() {
        return getStableName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor getPackage(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        throw new java.lang.IllegalStateException("Should not be called!");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor getOriginal() {
        return this;
    }
}
