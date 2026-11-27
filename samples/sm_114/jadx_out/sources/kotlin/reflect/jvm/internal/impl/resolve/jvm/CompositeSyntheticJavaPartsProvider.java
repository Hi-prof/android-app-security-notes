package kotlin.reflect.jvm.internal.impl.resolve.jvm;

/* JADX INFO: compiled from: SyntheticJavaPartsProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CompositeSyntheticJavaPartsProvider implements kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider {
    private final java.util.List<kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider> inner;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeSyntheticJavaPartsProvider(java.util.List<? extends kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider> inner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inner, "inner");
        this.inner = inner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> getMethodNames(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor thisDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        java.util.List<kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider> list = this.inner;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            kotlin.collections.CollectionsKt.addAll(arrayList, ((kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider) it.next()).getMethodNames(thisDescriptor, c));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateMethods(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor thisDescriptor, kotlin.reflect.jvm.internal.impl.name.Name name, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> result, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        java.util.Iterator<T> it = this.inner.iterator();
        while (it.hasNext()) {
            ((kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider) it.next()).generateMethods(thisDescriptor, name, result, c);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> getStaticFunctionNames(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor thisDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        java.util.List<kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider> list = this.inner;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            kotlin.collections.CollectionsKt.addAll(arrayList, ((kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider) it.next()).getStaticFunctionNames(thisDescriptor, c));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateStaticFunctions(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor thisDescriptor, kotlin.reflect.jvm.internal.impl.name.Name name, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> result, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        java.util.Iterator<T> it = this.inner.iterator();
        while (it.hasNext()) {
            ((kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider) it.next()).generateStaticFunctions(thisDescriptor, name, result, c);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateConstructors(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor thisDescriptor, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> result, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        java.util.Iterator<T> it = this.inner.iterator();
        while (it.hasNext()) {
            ((kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider) it.next()).generateConstructors(thisDescriptor, result, c);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> getNestedClassNames(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor thisDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        java.util.List<kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider> list = this.inner;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            kotlin.collections.CollectionsKt.addAll(arrayList, ((kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider) it.next()).getNestedClassNames(thisDescriptor, c));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateNestedClass(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor thisDescriptor, kotlin.reflect.jvm.internal.impl.name.Name name, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> result, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        java.util.Iterator<T> it = this.inner.iterator();
        while (it.hasNext()) {
            ((kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider) it.next()).generateNestedClass(thisDescriptor, name, result, c);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl modifyField(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor thisDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl propertyDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(thisDescriptor, "thisDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyDescriptor, "propertyDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        java.util.Iterator<T> it = this.inner.iterator();
        while (it.hasNext()) {
            propertyDescriptor = ((kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider) it.next()).modifyField(thisDescriptor, propertyDescriptor, c);
        }
        return propertyDescriptor;
    }
}
