package kotlin.reflect.jvm.internal.impl.load.java.lazy;

/* JADX INFO: compiled from: resolvers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyJavaTypeParameterResolver implements kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver {
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c;
    private final kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration;
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor> resolve;
    private final java.util.Map<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter, java.lang.Integer> typeParameters;
    private final int typeParametersIndexOffset;

    public LazyJavaTypeParameterResolver(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner typeParameterOwner, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameterOwner, "typeParameterOwner");
        this.c = c;
        this.containingDeclaration = containingDeclaration;
        this.typeParametersIndexOffset = i;
        this.typeParameters = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.mapToIndex(typeParameterOwner.getTypeParameters());
        this.resolve = c.getStorageManager().createMemoizedFunctionWithNullableValues(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver.resolve$lambda$1(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor resolve$lambda$1(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter typeParameter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        java.lang.Integer num = lazyJavaTypeParameterResolver.typeParameters.get(typeParameter);
        if (num == null) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor(kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.copyWithNewDefaultTypeQualifiers(kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.child(lazyJavaTypeParameterResolver.c, lazyJavaTypeParameterResolver), lazyJavaTypeParameterResolver.containingDeclaration.getAnnotations()), typeParameter, lazyJavaTypeParameterResolver.typeParametersIndexOffset + num.intValue(), lazyJavaTypeParameterResolver.containingDeclaration);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
    public kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor resolveTypeParameter(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter javaTypeParameter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaTypeParameter, "javaTypeParameter");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor lazyJavaTypeParameterDescriptorInvoke = this.resolve.invoke2(javaTypeParameter);
        return lazyJavaTypeParameterDescriptorInvoke != null ? lazyJavaTypeParameterDescriptorInvoke : this.c.getTypeParameterResolver().resolveTypeParameter(javaTypeParameter);
    }
}
