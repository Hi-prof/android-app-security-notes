package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

/* JADX INFO: compiled from: BuiltInsLoaderImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BuiltInsLoaderImpl implements kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader resourceLoader = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader();

    @Override // kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader
    public kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider createPackageFragmentProvider(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor builtInsModule, java.lang.Iterable<? extends kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory> classDescriptorFactories, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter platformDependentDeclarationFilter, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider additionalClassPartsProvider, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builtInsModule, "builtInsModule");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptorFactories, "classDescriptorFactories");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(additionalClassPartsProvider, "additionalClassPartsProvider");
        return createBuiltInPackageFragmentProvider(storageManager, builtInsModule, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_FQ_NAMES, classDescriptorFactories, platformDependentDeclarationFilter, additionalClassPartsProvider, z, new kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsLoaderImpl.AnonymousClass1(this.resourceLoader));
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsLoaderImpl$createPackageFragmentProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: BuiltInsLoaderImpl.kt */
    static final /* synthetic */ class AnonymousClass1 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function1<java.lang.String, java.io.InputStream> {
        AnonymousClass1(java.lang.Object obj) {
            super(1, obj, kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader.class, "loadResource", "loadResource(Ljava/lang/String;)Ljava/io/InputStream;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final java.io.InputStream invoke2(java.lang.String p0) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
            return ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader) this.receiver).loadResource(p0);
        }
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider createBuiltInPackageFragmentProvider(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> packageFqNames, java.lang.Iterable<? extends kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory> classDescriptorFactories, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter platformDependentDeclarationFilter, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider additionalClassPartsProvider, boolean z, kotlin.jvm.functions.Function1<? super java.lang.String, ? extends java.io.InputStream> loadResource) throws java.io.IOException {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl builtInsPackageFragmentImplCreate;
        kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager2 = storageManager;
        kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module = moduleDescriptor;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFqNames, "packageFqNames");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptorFactories, "classDescriptorFactories");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(additionalClassPartsProvider, "additionalClassPartsProvider");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(loadResource, "loadResource");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (kotlin.reflect.jvm.internal.impl.name.FqName fqName : packageFqNames) {
            java.io.InputStream inputStreamInvoke2 = loadResource.invoke2(kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(fqName));
            if (inputStreamInvoke2 != null) {
                kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor2 = module;
                builtInsPackageFragmentImplCreate = kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl.Companion.create(fqName, storageManager, moduleDescriptor2, inputStreamInvoke2, z);
                storageManager2 = storageManager;
                module = moduleDescriptor2;
            } else {
                builtInsPackageFragmentImplCreate = null;
            }
            if (builtInsPackageFragmentImplCreate != null) {
                arrayList.add(builtInsPackageFragmentImplCreate);
            }
        }
        java.util.ArrayList arrayList2 = arrayList;
        kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl packageFragmentProviderImpl = new kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl(arrayList2);
        kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses = new kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses(storageManager2, module);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration.Default r4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration.Default.INSTANCE;
        kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl packageFragmentProviderImpl2 = packageFragmentProviderImpl;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder deserializedClassDataFinder = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder(packageFragmentProviderImpl2);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl annotationAndConstantLoaderImpl = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl(module, notFoundClasses, kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol.INSTANCE);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings.Default r7 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings.Default.INSTANCE;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter DO_NOTHING = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter.DO_NOTHING;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(DO_NOTHING, "DO_NOTHING");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents deserializationComponents = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents(storageManager2, moduleDescriptor, r4, deserializedClassDataFinder, annotationAndConstantLoaderImpl, packageFragmentProviderImpl2, r7, DO_NOTHING, kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.DO_NOTHING.INSTANCE, kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer.ThrowException.INSTANCE, classDescriptorFactories, notFoundClasses, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer.Companion.getDEFAULT(), additionalClassPartsProvider, platformDependentDeclarationFilter, kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol.INSTANCE.getExtensionRegistry(), null, new kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl(storageManager2, kotlin.collections.CollectionsKt.emptyList()), null, null, 851968, null);
        java.util.Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl) it.next()).initialize(deserializationComponents);
        }
        return packageFragmentProviderImpl2;
    }
}
