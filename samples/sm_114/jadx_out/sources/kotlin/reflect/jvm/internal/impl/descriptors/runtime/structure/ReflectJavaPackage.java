package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaPackage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaPackage extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage {
    private final kotlin.reflect.jvm.internal.impl.name.FqName fqName;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation findAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public ReflectJavaPackage(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    public kotlin.reflect.jvm.internal.impl.name.FqName getFqName() {
        return this.fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass> getClasses(kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage> getSubPackages() {
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation> getAnnotations() {
        return kotlin.collections.CollectionsKt.emptyList();
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaPackage) && kotlin.jvm.internal.Intrinsics.areEqual(getFqName(), ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaPackage) obj).getFqName());
    }

    public int hashCode() {
        return getFqName().hashCode();
    }

    public java.lang.String toString() {
        return getClass().getName() + ": " + getFqName();
    }
}
