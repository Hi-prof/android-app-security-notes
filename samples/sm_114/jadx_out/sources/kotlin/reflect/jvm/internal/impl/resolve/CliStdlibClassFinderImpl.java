package kotlin.reflect.jvm.internal.impl.resolve;

/* JADX INFO: compiled from: StdlibClassFinder.kt */
/* JADX INFO: loaded from: classes2.dex */
final class CliStdlibClassFinderImpl implements kotlin.reflect.jvm.internal.impl.resolve.StdlibClassFinder {
    public static final kotlin.reflect.jvm.internal.impl.resolve.CliStdlibClassFinderImpl INSTANCE = new kotlin.reflect.jvm.internal.impl.resolve.CliStdlibClassFinderImpl();

    private CliStdlibClassFinderImpl() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.StdlibClassFinder
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor findEnumEntriesClass(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        return kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, kotlin.reflect.jvm.internal.impl.name.StandardClassIds.INSTANCE.getEnumEntries());
    }
}
