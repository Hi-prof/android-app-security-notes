package kotlin.reflect.jvm.internal.impl.load.java.lazy;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyJavaResolverContext {
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents components;
    private final kotlin.Lazy<kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType> delegateForDefaultTypeQualifiers;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver typeParameterResolver;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver typeResolver;

    public LazyJavaResolverContext(kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents components, kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver typeParameterResolver, kotlin.Lazy<kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType> delegateForDefaultTypeQualifiers) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(components, "components");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameterResolver, "typeParameterResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegateForDefaultTypeQualifiers, "delegateForDefaultTypeQualifiers");
        this.components = components;
        this.typeParameterResolver = typeParameterResolver;
        this.delegateForDefaultTypeQualifiers = delegateForDefaultTypeQualifiers;
        this.typeResolver = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver(this, typeParameterResolver);
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents getComponents() {
        return this.components;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver getTypeParameterResolver() {
        return this.typeParameterResolver;
    }

    public final kotlin.Lazy<kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType> getDelegateForDefaultTypeQualifiers$descriptors_jvm() {
        return this.delegateForDefaultTypeQualifiers;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType getDefaultTypeQualifiers() {
        return this.delegateForDefaultTypeQualifiers.getValue();
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver getTypeResolver() {
        return this.typeResolver;
    }

    public final kotlin.reflect.jvm.internal.impl.storage.StorageManager getStorageManager() {
        return this.components.getStorageManager();
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor getModule() {
        return this.components.getModule();
    }
}
