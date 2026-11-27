package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

/* JADX INFO: compiled from: RuntimeModuleData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RuntimeModuleData {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData.Companion Companion = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData.Companion(null);
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents deserialization;
    private final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.PackagePartScopeCache packagePartScopeCache;

    public /* synthetic */ RuntimeModuleData(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents deserializationComponents, kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.PackagePartScopeCache packagePartScopeCache, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(deserializationComponents, packagePartScopeCache);
    }

    private RuntimeModuleData(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents deserializationComponents, kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.PackagePartScopeCache packagePartScopeCache) {
        this.deserialization = deserializationComponents;
        this.packagePartScopeCache = packagePartScopeCache;
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents getDeserialization() {
        return this.deserialization;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.PackagePartScopeCache getPackagePartScopeCache() {
        return this.packagePartScopeCache;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor getModule() {
        return this.deserialization.getModuleDescriptor();
    }

    /* JADX INFO: compiled from: RuntimeModuleData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData create(java.lang.ClassLoader classLoader) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classLoader, "classLoader");
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClassFinder reflectKotlinClassFinder = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClassFinder(classLoader);
            java.lang.ClassLoader classLoader2 = kotlin.Unit.class.getClassLoader();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(classLoader2, "getClassLoader(...)");
            kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava.Companion.ModuleData moduleDataCreateModuleData = kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava.Companion.createModuleData(reflectKotlinClassFinder, new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClassFinder(classLoader2), new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinder(classLoader), "runtime module for " + classLoader, kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeErrorReporter.INSTANCE, kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory.INSTANCE);
            return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData(moduleDataCreateModuleData.getDeserializationComponentsForJava().getComponents(), new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.PackagePartScopeCache(moduleDataCreateModuleData.getDeserializedDescriptorResolver(), reflectKotlinClassFinder), null);
        }
    }
}
