package kotlin.reflect.jvm.internal.impl.load.java.lazy;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaResolverComponents {
    private final kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver annotationTypeQualifierResolver;
    private final kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver deserializedDescriptorResolver;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter errorReporter;
    private final kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder finder;
    private final kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker javaClassesTracker;
    private final kotlin.reflect.jvm.internal.impl.load.java.JavaModuleAnnotationsProvider javaModuleResolver;
    private final kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator;
    private final kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache javaResolverCache;
    private final kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState javaTypeEnhancementState;
    private final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder kotlinClassFinder;
    private final kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker kotlinTypeChecker;
    private final kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker lookupTracker;
    private final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver moduleClassResolver;
    private final kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider packagePartProvider;
    private final kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes reflectionTypes;
    private final kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver samConversionResolver;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings settings;
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement signatureEnhancement;
    private final kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator signaturePropagator;
    private final kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory sourceElementFactory;
    private final kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager;
    private final kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker supertypeLoopChecker;
    private final kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider syntheticPartsProvider;

    public JavaResolverComponents(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder finder, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder kotlinClassFinder, kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver deserializedDescriptorResolver, kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator signaturePropagator, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter errorReporter, kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache javaResolverCache, kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator, kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver samConversionResolver, kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory sourceElementFactory, kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver moduleClassResolver, kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider packagePartProvider, kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker supertypeLoopChecker, kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker lookupTracker, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module, kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes reflectionTypes, kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver annotationTypeQualifierResolver, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement signatureEnhancement, kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker javaClassesTracker, kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings settings, kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker kotlinTypeChecker, kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState javaTypeEnhancementState, kotlin.reflect.jvm.internal.impl.load.java.JavaModuleAnnotationsProvider javaModuleResolver, kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider syntheticPartsProvider) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(finder, "finder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signaturePropagator, "signaturePropagator");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaPropertyInitializerEvaluator, "javaPropertyInitializerEvaluator");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(samConversionResolver, "samConversionResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceElementFactory, "sourceElementFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleClassResolver, "moduleClassResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packagePartProvider, "packagePartProvider");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(supertypeLoopChecker, "supertypeLoopChecker");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lookupTracker, "lookupTracker");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reflectionTypes, "reflectionTypes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signatureEnhancement, "signatureEnhancement");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaClassesTracker, "javaClassesTracker");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(settings, "settings");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaModuleResolver, "javaModuleResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(syntheticPartsProvider, "syntheticPartsProvider");
        this.storageManager = storageManager;
        this.finder = finder;
        this.kotlinClassFinder = kotlinClassFinder;
        this.deserializedDescriptorResolver = deserializedDescriptorResolver;
        this.signaturePropagator = signaturePropagator;
        this.errorReporter = errorReporter;
        this.javaResolverCache = javaResolverCache;
        this.javaPropertyInitializerEvaluator = javaPropertyInitializerEvaluator;
        this.samConversionResolver = samConversionResolver;
        this.sourceElementFactory = sourceElementFactory;
        this.moduleClassResolver = moduleClassResolver;
        this.packagePartProvider = packagePartProvider;
        this.supertypeLoopChecker = supertypeLoopChecker;
        this.lookupTracker = lookupTracker;
        this.module = module;
        this.reflectionTypes = reflectionTypes;
        this.annotationTypeQualifierResolver = annotationTypeQualifierResolver;
        this.signatureEnhancement = signatureEnhancement;
        this.javaClassesTracker = javaClassesTracker;
        this.settings = settings;
        this.kotlinTypeChecker = kotlinTypeChecker;
        this.javaTypeEnhancementState = javaTypeEnhancementState;
        this.javaModuleResolver = javaModuleResolver;
        this.syntheticPartsProvider = syntheticPartsProvider;
    }

    public final kotlin.reflect.jvm.internal.impl.storage.StorageManager getStorageManager() {
        return this.storageManager;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder getFinder() {
        return this.finder;
    }

    public final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder getKotlinClassFinder() {
        return this.kotlinClassFinder;
    }

    public final kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
        return this.deserializedDescriptorResolver;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator getSignaturePropagator() {
        return this.signaturePropagator;
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter getErrorReporter() {
        return this.errorReporter;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache getJavaResolverCache() {
        return this.javaResolverCache;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator getJavaPropertyInitializerEvaluator() {
        return this.javaPropertyInitializerEvaluator;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory getSourceElementFactory() {
        return this.sourceElementFactory;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver getModuleClassResolver() {
        return this.moduleClassResolver;
    }

    public final kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider getPackagePartProvider() {
        return this.packagePartProvider;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker getSupertypeLoopChecker() {
        return this.supertypeLoopChecker;
    }

    public final kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker getLookupTracker() {
        return this.lookupTracker;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor getModule() {
        return this.module;
    }

    public final kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes getReflectionTypes() {
        return this.reflectionTypes;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver getAnnotationTypeQualifierResolver() {
        return this.annotationTypeQualifierResolver;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement getSignatureEnhancement() {
        return this.signatureEnhancement;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker getJavaClassesTracker() {
        return this.javaClassesTracker;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings getSettings() {
        return this.settings;
    }

    public final kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.kotlinTypeChecker;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState getJavaTypeEnhancementState() {
        return this.javaTypeEnhancementState;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.JavaModuleAnnotationsProvider getJavaModuleResolver() {
        return this.javaModuleResolver;
    }

    public /* synthetic */ JavaResolverComponents(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder javaClassFinder, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder kotlinClassFinder, kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver deserializedDescriptorResolver, kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator signaturePropagator, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter errorReporter, kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache javaResolverCache, kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator, kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver samConversionResolver, kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory javaSourceElementFactory, kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver moduleClassResolver, kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider packagePartProvider, kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker supertypeLoopChecker, kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker lookupTracker, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes reflectionTypes, kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver annotationTypeQualifierResolver, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement signatureEnhancement, kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker javaClassesTracker, kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings javaResolverSettings, kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker newKotlinTypeChecker, kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState javaTypeEnhancementState, kotlin.reflect.jvm.internal.impl.load.java.JavaModuleAnnotationsProvider javaModuleAnnotationsProvider, kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider syntheticJavaPartsProvider, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, javaClassFinder, kotlinClassFinder, deserializedDescriptorResolver, signaturePropagator, errorReporter, javaResolverCache, javaPropertyInitializerEvaluator, samConversionResolver, javaSourceElementFactory, moduleClassResolver, packagePartProvider, supertypeLoopChecker, lookupTracker, moduleDescriptor, reflectionTypes, annotationTypeQualifierResolver, signatureEnhancement, javaClassesTracker, javaResolverSettings, newKotlinTypeChecker, javaTypeEnhancementState, javaModuleAnnotationsProvider, (i & 8388608) != 0 ? kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider.Companion.getEMPTY() : syntheticJavaPartsProvider);
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider getSyntheticPartsProvider() {
        return this.syntheticPartsProvider;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents replace(kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache javaResolverCache) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents(this.storageManager, this.finder, this.kotlinClassFinder, this.deserializedDescriptorResolver, this.signaturePropagator, this.errorReporter, javaResolverCache, this.javaPropertyInitializerEvaluator, this.samConversionResolver, this.sourceElementFactory, this.moduleClassResolver, this.packagePartProvider, this.supertypeLoopChecker, this.lookupTracker, this.module, this.reflectionTypes, this.annotationTypeQualifierResolver, this.signatureEnhancement, this.javaClassesTracker, this.settings, this.kotlinTypeChecker, this.javaTypeEnhancementState, this.javaModuleResolver, null, 8388608, null);
    }
}
