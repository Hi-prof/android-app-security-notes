package kotlin.reflect.jvm.internal.impl.resolve.jvm;

/* JADX INFO: compiled from: SyntheticJavaPartsProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface SyntheticJavaPartsProvider {
    public static final kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider.Companion Companion = kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider.Companion.$$INSTANCE;

    void generateConstructors(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> list, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext);

    void generateMethods(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.name.Name name, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collection, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext);

    void generateNestedClass(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.name.Name name, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> list, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext);

    void generateStaticFunctions(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.name.Name name, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> collection, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext);

    java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> getMethodNames(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext);

    java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> getNestedClassNames(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext);

    java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> getStaticFunctionNames(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext);

    kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl modifyField(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl propertyDescriptorImpl, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext);

    /* JADX INFO: compiled from: SyntheticJavaPartsProvider.kt */
    public static final class Companion {
        static final /* synthetic */ kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider.Companion $$INSTANCE = new kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider.Companion();
        private static final kotlin.reflect.jvm.internal.impl.resolve.jvm.CompositeSyntheticJavaPartsProvider EMPTY = new kotlin.reflect.jvm.internal.impl.resolve.jvm.CompositeSyntheticJavaPartsProvider(kotlin.collections.CollectionsKt.emptyList());

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.resolve.jvm.CompositeSyntheticJavaPartsProvider getEMPTY() {
            return EMPTY;
        }
    }
}
