package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

/* JADX INFO: compiled from: DeserializedAnnotations.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DeserializedAnnotations implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations.class, "annotations", "getAnnotations()Ljava/util/List;", 0))};
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue annotations$delegate;

    public DeserializedAnnotations(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.jvm.functions.Function0<? extends java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>> compute) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(compute, "compute");
        this.annotations$delegate = storageManager.createLazyValue(compute);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor mo1826findAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.DefaultImpls.findAnnotation(this, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.DefaultImpls.hasAnnotation(this, fqName);
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> getAnnotations() {
        return (java.util.List) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.annotations$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return getAnnotations().isEmpty();
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> iterator() {
        return getAnnotations().iterator();
    }
}
