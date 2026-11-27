package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FilteredAnnotations implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations {
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations delegate;
    private final kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.name.FqName, java.lang.Boolean> fqNameFilter;
    private final boolean isDefinitelyNewInference;

    /* JADX WARN: Multi-variable type inference failed */
    public FilteredAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations delegate, boolean z, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.FqName, java.lang.Boolean> fqNameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegate, "delegate");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqNameFilter, "fqNameFilter");
        this.delegate = delegate;
        this.isDefinitelyNewInference = z;
        this.fqNameFilter = fqNameFilter;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilteredAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations delegate, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.FqName, java.lang.Boolean> fqNameFilter) {
        this(delegate, false, fqNameFilter);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegate, "delegate");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqNameFilter, "fqNameFilter");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.fqNameFilter.invoke(fqName).booleanValue()) {
            return this.delegate.hasAnnotation(fqName);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor mo1826findAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.fqNameFilter.invoke(fqName).booleanValue()) {
            return this.delegate.mo1826findAnnotation(fqName);
        }
        return null;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> iterator() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations = this.delegate;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptor : annotations) {
            if (shouldBeReturned(annotationDescriptor)) {
                arrayList.add(annotationDescriptor);
            }
        }
        return arrayList.iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        boolean z;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations = this.delegate;
        if (!(annotations instanceof java.util.Collection) || !((java.util.Collection) annotations).isEmpty()) {
            java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> it = annotations.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (shouldBeReturned(it.next())) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
            break;
        }
        if (this.isDefinitelyNewInference) {
            return !z;
        }
        return z;
    }

    private final boolean shouldBeReturned(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptor) {
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = annotationDescriptor.getFqName();
        return fqName != null && this.fqNameFilter.invoke(fqName).booleanValue();
    }
}
