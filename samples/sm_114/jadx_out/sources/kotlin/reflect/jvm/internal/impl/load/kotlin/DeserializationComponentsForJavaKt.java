package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeserializationComponentsForJavaKt {
    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentProvider(kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder javaClassFinder, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder reflectKotlinClassFinder, kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver deserializedDescriptorResolver, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter errorReporter, kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory javaSourceElementFactory, kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver singleModuleClassResolver, kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider packagePartProvider) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaClassFinder, "javaClassFinder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reflectKotlinClassFinder, "reflectKotlinClassFinder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaSourceElementFactory, "javaSourceElementFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(singleModuleClassResolver, "singleModuleClassResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packagePartProvider, "packagePartProvider");
        kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState javaTypeEnhancementState = kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState.Companion.getDefault(new kotlin.KotlinVersion(1, 9));
        kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator DO_NOTHING = kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator.DO_NOTHING;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(DO_NOTHING, "DO_NOTHING");
        kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache EMPTY = kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache.EMPTY;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider(new kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents(storageManager, javaClassFinder, reflectKotlinClassFinder, deserializedDescriptorResolver, DO_NOTHING, errorReporter, EMPTY, kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator.DoNothing.INSTANCE, new kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl(storageManager, kotlin.collections.CollectionsKt.emptyList()), javaSourceElementFactory, singleModuleClassResolver, packagePartProvider, kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY.INSTANCE, kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.DO_NOTHING.INSTANCE, module, new kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes(module, notFoundClasses), new kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver(javaTypeEnhancementState), new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement(kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings.Default.INSTANCE)), kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker.Default.INSTANCE, kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings.Default.INSTANCE, kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion.getDefault(), javaTypeEnhancementState, new kotlin.reflect.jvm.internal.impl.load.java.JavaModuleAnnotationsProvider() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJavaKt$makeLazyJavaPackageFragmentProvider$javaResolverComponents$1
            @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaModuleAnnotationsProvider
            public java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation> getAnnotationsForModuleOwnerOfClass(kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
                return null;
            }
        }, null, 8388608, null));
    }

    public static final kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava makeDeserializationComponentsForJava(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder reflectKotlinClassFinder, kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver deserializedDescriptorResolver, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter errorReporter, kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lazyJavaPackageFragmentProvider, "lazyJavaPackageFragmentProvider");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reflectKotlinClassFinder, "reflectKotlinClassFinder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        return new kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava(storageManager, module, kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration.Default.INSTANCE, new kotlin.reflect.jvm.internal.impl.load.kotlin.JavaClassDataFinder(reflectKotlinClassFinder, deserializedDescriptorResolver), kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImplKt.createBinaryClassAnnotationAndConstantLoader(module, notFoundClasses, storageManager, reflectKotlinClassFinder, metadataVersion), lazyJavaPackageFragmentProvider, notFoundClasses, errorReporter, kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.DO_NOTHING.INSTANCE, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer.Companion.getDEFAULT(), kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion.getDefault(), new kotlin.reflect.jvm.internal.impl.types.extensions.TypeAttributeTranslators(kotlin.collections.CollectionsKt.listOf(kotlin.reflect.jvm.internal.impl.types.DefaultTypeAttributeTranslator.INSTANCE)));
    }
}
