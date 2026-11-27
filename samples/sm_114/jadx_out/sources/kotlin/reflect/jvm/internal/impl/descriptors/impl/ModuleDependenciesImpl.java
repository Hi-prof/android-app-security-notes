package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModuleDependenciesImpl implements kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies {
    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> allDependencies;
    private final java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> allExpectedByDependencies;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> directExpectedByDependencies;
    private final java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> modulesWhoseInternalsAreVisible;

    public ModuleDependenciesImpl(java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> allDependencies, java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> modulesWhoseInternalsAreVisible, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> directExpectedByDependencies, java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> allExpectedByDependencies) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(allDependencies, "allDependencies");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(modulesWhoseInternalsAreVisible, "modulesWhoseInternalsAreVisible");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(directExpectedByDependencies, "directExpectedByDependencies");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(allExpectedByDependencies, "allExpectedByDependencies");
        this.allDependencies = allDependencies;
        this.modulesWhoseInternalsAreVisible = modulesWhoseInternalsAreVisible;
        this.directExpectedByDependencies = directExpectedByDependencies;
        this.allExpectedByDependencies = allExpectedByDependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> getAllDependencies() {
        return this.allDependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    public java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> getModulesWhoseInternalsAreVisible() {
        return this.modulesWhoseInternalsAreVisible;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> getDirectExpectedByDependencies() {
        return this.directExpectedByDependencies;
    }
}
