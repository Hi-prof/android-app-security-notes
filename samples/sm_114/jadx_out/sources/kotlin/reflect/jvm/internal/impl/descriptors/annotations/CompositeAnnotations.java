package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CompositeAnnotations implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations {
    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations> delegates;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeAnnotations(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations> delegates) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegates, "delegates");
        this.delegates = delegates;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompositeAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations... delegates) {
        this((java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations>) kotlin.collections.ArraysKt.toList(delegates));
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegates, "delegates");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations> list = this.delegates;
        if ((list instanceof java.util.Collection) && list.isEmpty()) {
            return true;
        }
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        java.util.Iterator it = kotlin.collections.CollectionsKt.asSequence(this.delegates).iterator();
        while (it.hasNext()) {
            if (((kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) it.next()).hasAnnotation(fqName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor findAnnotation$lambda$2(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it.mo1826findAnnotation(fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor mo1826findAnnotation(final kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return (kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor) kotlin.sequences.SequencesKt.firstOrNull(kotlin.sequences.SequencesKt.mapNotNull(kotlin.collections.CollectionsKt.asSequence(this.delegates), new kotlin.jvm.functions.Function1(fqName) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.name.FqName arg$0;

            {
                this.arg$0 = fqName;
            }

            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations.findAnnotation$lambda$2(this.arg$0, (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.sequences.Sequence iterator$lambda$4(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return kotlin.collections.CollectionsKt.asSequence(it);
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> iterator() {
        return kotlin.sequences.SequencesKt.flatMap(kotlin.collections.CollectionsKt.asSequence(this.delegates), new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations.iterator$lambda$4((kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) obj);
            }
        }).iterator();
    }
}
