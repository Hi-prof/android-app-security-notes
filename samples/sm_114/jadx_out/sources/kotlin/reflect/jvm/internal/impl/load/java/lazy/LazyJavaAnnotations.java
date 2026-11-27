package kotlin.reflect.jvm.internal.impl.load.java.lazy;

/* JADX INFO: compiled from: LazyJavaAnnotations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyJavaAnnotations implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations {
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> annotationDescriptors;
    private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner annotationOwner;
    private final boolean areAnnotationsFreshlySupported;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c;

    public LazyJavaAnnotations(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner annotationOwner, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationOwner, "annotationOwner");
        this.c = c;
        this.annotationOwner = annotationOwner;
        this.areAnnotationsFreshlySupported = z;
        this.annotationDescriptors = c.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations.annotationDescriptors$lambda$0(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation) obj);
            }
        });
    }

    public /* synthetic */ LazyJavaAnnotations(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner javaAnnotationOwner, boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, javaAnnotationOwner, (i & 4) != 0 ? false : z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.DefaultImpls.hasAnnotation(this, fqName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptors$lambda$0(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations lazyJavaAnnotations, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation annotation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotation, "annotation");
        return kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper.INSTANCE.mapOrResolveJavaAnnotation(annotation, lazyJavaAnnotations.c, lazyJavaAnnotations.areAnnotationsFreshlySupported);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor mo1826findAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptorInvoke;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation javaAnnotationFindAnnotation = this.annotationOwner.findAnnotation(fqName);
        return (javaAnnotationFindAnnotation == null || (annotationDescriptorInvoke = this.annotationDescriptors.invoke(javaAnnotationFindAnnotation)) == null) ? kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(fqName, this.annotationOwner, this.c) : annotationDescriptorInvoke;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> iterator() {
        return kotlin.sequences.SequencesKt.filterNotNull(kotlin.sequences.SequencesKt.plus((kotlin.sequences.Sequence<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>) kotlin.sequences.SequencesKt.map(kotlin.collections.CollectionsKt.asSequence(this.annotationOwner.getAnnotations()), this.annotationDescriptors), kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.deprecated, this.annotationOwner, this.c))).iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return this.annotationOwner.getAnnotations().isEmpty() && !this.annotationOwner.isDeprecatedInJavaDoc();
    }
}
