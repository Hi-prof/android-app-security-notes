package kotlin.reflect.jvm.internal.impl.load.java.lazy;

/* JADX INFO: compiled from: ModuleClassResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SingleModuleClassResolver implements kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver {
    public kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver resolver;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor resolveClass(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass javaClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        return getResolver().resolveClass(javaClass);
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver getResolver() {
        kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver javaDescriptorResolver = this.resolver;
        if (javaDescriptorResolver != null) {
            return javaDescriptorResolver;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("resolver");
        return null;
    }

    public final void setResolver(kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver javaDescriptorResolver) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaDescriptorResolver, "<set-?>");
        this.resolver = javaDescriptorResolver;
    }
}
