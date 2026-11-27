package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeserializationComponentsForJava {
    public static final kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava.Companion Companion = new kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava.Companion(null);
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents components;

    public DeserializationComponentsForJava(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration configuration, kotlin.reflect.jvm.internal.impl.load.kotlin.JavaClassDataFinder classDataFinder, kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl annotationAndConstantLoader, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider packageFragmentProvider, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter errorReporter, kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker lookupTracker, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer contractDeserializer, kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker kotlinTypeChecker, kotlin.reflect.jvm.internal.impl.types.extensions.TypeAttributeTranslators typeAttributeTranslators) {
        kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter customizer;
        kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider customizer2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(configuration, "configuration");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDataFinder, "classDataFinder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationAndConstantLoader, "annotationAndConstantLoader");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFragmentProvider, "packageFragmentProvider");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lookupTracker, "lookupTracker");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contractDeserializer, "contractDeserializer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAttributeTranslators, "typeAttributeTranslators");
        kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns = moduleDescriptor.getBuiltIns();
        kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns jvmBuiltIns = builtIns instanceof kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns ? (kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns) builtIns : null;
        this.components = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents(storageManager, moduleDescriptor, configuration, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings.Default.INSTANCE, errorReporter, lookupTracker, kotlin.reflect.jvm.internal.impl.load.kotlin.JavaFlexibleTypeDeserializer.INSTANCE, kotlin.collections.CollectionsKt.emptyList(), notFoundClasses, contractDeserializer, (jvmBuiltIns == null || (customizer2 = jvmBuiltIns.getCustomizer()) == null) ? kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider.None.INSTANCE : customizer2, (jvmBuiltIns == null || (customizer = jvmBuiltIns.getCustomizer()) == null) ? kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE : customizer, kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE.getEXTENSION_REGISTRY(), kotlinTypeChecker, new kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl(storageManager, kotlin.collections.CollectionsKt.emptyList()), typeAttributeTranslators.getTranslators(), kotlin.reflect.jvm.internal.impl.serialization.deserialization.JvmEnumEntriesDeserializationSupport.INSTANCE);
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents getComponents() {
        return this.components;
    }

    /* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
        public static final class ModuleData {
            private final kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava deserializationComponentsForJava;
            private final kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver deserializedDescriptorResolver;

            public ModuleData(kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava deserializationComponentsForJava, kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver deserializedDescriptorResolver) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(deserializationComponentsForJava, "deserializationComponentsForJava");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
                this.deserializationComponentsForJava = deserializationComponentsForJava;
                this.deserializedDescriptorResolver = deserializedDescriptorResolver;
            }

            public final kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava getDeserializationComponentsForJava() {
                return this.deserializationComponentsForJava;
            }

            public final kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
                return this.deserializedDescriptorResolver;
            }
        }

        public final kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava.Companion.ModuleData createModuleData(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder kotlinClassFinder, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder jvmBuiltInsKotlinClassFinder, kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder javaClassFinder, java.lang.String moduleName, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter errorReporter, kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory javaSourceElementFactory) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jvmBuiltInsKotlinClassFinder, "jvmBuiltInsKotlinClassFinder");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaClassFinder, "javaClassFinder");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleName, "moduleName");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaSourceElementFactory, "javaSourceElementFactory");
            kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager lockBasedStorageManager = new kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager("DeserializationComponentsForJava.ModuleData");
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns jvmBuiltIns = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns(lockBasedStorageManager, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            kotlin.reflect.jvm.internal.impl.name.Name nameSpecial = kotlin.reflect.jvm.internal.impl.name.Name.special(com.taobao.weex.el.parse.Operators.L + moduleName + kotlin.text.Typography.greater);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial, "special(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl moduleDescriptorImpl = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl(nameSpecial, lockBasedStorageManager, jvmBuiltIns, null, null, null, 56, null);
            jvmBuiltIns.setBuiltInsModule(moduleDescriptorImpl);
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl moduleDescriptorImpl2 = moduleDescriptorImpl;
            jvmBuiltIns.initialize(moduleDescriptorImpl2, true);
            kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver deserializedDescriptorResolver = new kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver();
            kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver singleModuleClassResolver = new kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver();
            kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses = new kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses(lockBasedStorageManager, moduleDescriptorImpl2);
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProviderMakeLazyJavaPackageFragmentProvider = kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJavaKt.makeLazyJavaPackageFragmentProvider(javaClassFinder, moduleDescriptorImpl2, lockBasedStorageManager, notFoundClasses, kotlinClassFinder, deserializedDescriptorResolver, errorReporter, javaSourceElementFactory, singleModuleClassResolver, (512 & 512) != 0 ? kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider.Empty.INSTANCE : null);
            kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava deserializationComponentsForJavaMakeDeserializationComponentsForJava = kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJavaKt.makeDeserializationComponentsForJava(moduleDescriptorImpl2, lockBasedStorageManager, notFoundClasses, lazyJavaPackageFragmentProviderMakeLazyJavaPackageFragmentProvider, kotlinClassFinder, deserializedDescriptorResolver, errorReporter, kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion.INSTANCE);
            deserializedDescriptorResolver.setComponents(deserializationComponentsForJavaMakeDeserializationComponentsForJava);
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache EMPTY = kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache.EMPTY;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver javaDescriptorResolver = new kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver(lazyJavaPackageFragmentProviderMakeLazyJavaPackageFragmentProvider, EMPTY);
            singleModuleClassResolver.setResolver(javaDescriptorResolver);
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider jvmBuiltInsPackageFragmentProvider = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider(lockBasedStorageManager, jvmBuiltInsKotlinClassFinder, moduleDescriptorImpl2, notFoundClasses, jvmBuiltIns.getCustomizer(), jvmBuiltIns.getCustomizer(), kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration.Default.INSTANCE, kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion.getDefault(), new kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl(lockBasedStorageManager, kotlin.collections.CollectionsKt.emptyList()));
            moduleDescriptorImpl.setDependencies(moduleDescriptorImpl);
            moduleDescriptorImpl.initialize(new kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider(kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized[]{javaDescriptorResolver.getPackageFragmentProvider(), jvmBuiltInsPackageFragmentProvider}), "CompositeProvider@RuntimeModuleData for " + moduleDescriptorImpl));
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava.Companion.ModuleData(deserializationComponentsForJavaMakeDeserializationComponentsForJava, deserializedDescriptorResolver);
        }
    }
}
