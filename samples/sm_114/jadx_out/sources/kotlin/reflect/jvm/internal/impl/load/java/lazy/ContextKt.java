package kotlin.reflect.jvm.internal.impl.load.java.lazy;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContextKt {
    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext child(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver typeParameterResolver) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameterResolver, "typeParameterResolver");
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext(lazyJavaResolverContext.getComponents(), typeParameterResolver, lazyJavaResolverContext.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static final kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType computeNewDefaultTypeQualifiers(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations additionalAnnotations) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(additionalAnnotations, "additionalAnnotations");
        return lazyJavaResolverContext.getComponents().getAnnotationTypeQualifierResolver().extractAndMergeDefaultQualifiers(lazyJavaResolverContext.getDefaultTypeQualifiers(), additionalAnnotations);
    }

    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext replaceComponents(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents components) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(components, "components");
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext(components, lazyJavaResolverContext.getTypeParameterResolver(), lazyJavaResolverContext.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    private static final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext child(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner javaTypeParameterListOwner, int i, kotlin.Lazy<kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType> lazy) {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver typeParameterResolver;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents components = lazyJavaResolverContext.getComponents();
        if (javaTypeParameterListOwner != null) {
            typeParameterResolver = new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver(lazyJavaResolverContext, declarationDescriptor, javaTypeParameterListOwner, i);
        } else {
            typeParameterResolver = lazyJavaResolverContext.getTypeParameterResolver();
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext(components, typeParameterResolver, lazy);
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext childForMethod$default(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner javaTypeParameterListOwner, int i, int i2, java.lang.Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return childForMethod(lazyJavaResolverContext, declarationDescriptor, javaTypeParameterListOwner, i);
    }

    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext childForMethod(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner typeParameterOwner, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameterOwner, "typeParameterOwner");
        return child(lazyJavaResolverContext, containingDeclaration, typeParameterOwner, i, lazyJavaResolverContext.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext childForClassOrPackage$default(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner javaTypeParameterListOwner, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            javaTypeParameterListOwner = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return childForClassOrPackage(lazyJavaResolverContext, classOrPackageFragmentDescriptor, javaTypeParameterListOwner, i);
    }

    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext childForClassOrPackage(final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, final kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor containingDeclaration, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner javaTypeParameterListOwner, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        return child(lazyJavaResolverContext, containingDeclaration, javaTypeParameterListOwner, i, kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.NONE, new kotlin.jvm.functions.Function0(lazyJavaResolverContext, containingDeclaration) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext arg$0;
            private final kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor arg$1;

            {
                this.arg$0 = lazyJavaResolverContext;
                this.arg$1 = containingDeclaration;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.childForClassOrPackage$lambda$1(this.arg$0, this.arg$1);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType childForClassOrPackage$lambda$1(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor) {
        return computeNewDefaultTypeQualifiers(lazyJavaResolverContext, classOrPackageFragmentDescriptor.getAnnotations());
    }

    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext copyWithNewDefaultTypeQualifiers(final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations additionalAnnotations) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(additionalAnnotations, "additionalAnnotations");
        return additionalAnnotations.isEmpty() ? lazyJavaResolverContext : new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext(lazyJavaResolverContext.getComponents(), lazyJavaResolverContext.getTypeParameterResolver(), kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.NONE, new kotlin.jvm.functions.Function0(lazyJavaResolverContext, additionalAnnotations) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext arg$0;
            private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations arg$1;

            {
                this.arg$0 = lazyJavaResolverContext;
                this.arg$1 = additionalAnnotations;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.computeNewDefaultTypeQualifiers(this.arg$0, this.arg$1);
            }
        }));
    }
}
