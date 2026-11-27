package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

/* JADX INFO: compiled from: BuiltInsPackageFragmentImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BuiltInsPackageFragmentImpl extends kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl implements kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment {
    public static final kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl.Companion Companion = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl.Companion(null);
    private final boolean isFallback;

    public /* synthetic */ BuiltInsPackageFragmentImpl(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment packageFragment, kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion builtInsBinaryVersion, boolean z, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(fqName, storageManager, moduleDescriptor, packageFragment, builtInsBinaryVersion, z);
    }

    private BuiltInsPackageFragmentImpl(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment packageFragment, kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion builtInsBinaryVersion, boolean z) {
        super(fqName, storageManager, moduleDescriptor, packageFragment, builtInsBinaryVersion, null);
        this.isFallback = z;
    }

    /* JADX INFO: compiled from: BuiltInsPackageFragmentImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl create(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module, java.io.InputStream inputStream, boolean z) throws java.io.IOException {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            kotlin.Pair<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment, kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion> builtinsPackageFragment = kotlin.reflect.jvm.internal.impl.metadata.builtins.ReadPackageFragmentKt.readBuiltinsPackageFragment(inputStream);
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment packageFragmentComponent1 = builtinsPackageFragment.component1();
            kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion builtInsBinaryVersionComponent2 = builtinsPackageFragment.component2();
            if (packageFragmentComponent1 != null) {
                return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl(fqName, storageManager, module, packageFragmentComponent1, builtInsBinaryVersionComponent2, z, null);
            }
            throw new java.lang.UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion.INSTANCE + ", actual " + builtInsBinaryVersionComponent2 + ". Please update Kotlin");
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public java.lang.String toString() {
        return "builtins package fragment for " + getFqName() + " from " + kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getModule(this);
    }
}
