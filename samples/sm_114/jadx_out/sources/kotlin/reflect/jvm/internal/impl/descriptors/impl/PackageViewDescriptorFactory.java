package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: compiled from: PackageViewDescriptorFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface PackageViewDescriptorFactory {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory.Companion Companion = kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory.Companion.$$INSTANCE;

    kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor compute(kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl moduleDescriptorImpl, kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager);

    /* JADX INFO: compiled from: PackageViewDescriptorFactory.kt */
    public static final class Default implements kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory {
        public static final kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory.Default INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory.Default();

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory
        public kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor compute(kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl module, kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            return new kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl(module, fqName, storageManager);
        }
    }

    /* JADX INFO: compiled from: PackageViewDescriptorFactory.kt */
    public static final class Companion {
        static final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory.Companion $$INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory.Companion();
        private static final kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory> CAPABILITY = new kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<>("PackageViewDescriptorFactory");

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory> getCAPABILITY() {
            return CAPABILITY;
        }
    }
}
