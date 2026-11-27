package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

/* JADX INFO: compiled from: ReflectJavaClassFinder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaClassFinder implements kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder {
    private final java.lang.ClassLoader classLoader;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public java.util.Set<java.lang.String> knownClassNamesInPackage(kotlin.reflect.jvm.internal.impl.name.FqName packageFqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        return null;
    }

    public ReflectJavaClassFinder(java.lang.ClassLoader classLoader) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.classLoader = classLoader;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass findClass(kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder.Request request) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(request, "request");
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = request.getClassId();
        kotlin.reflect.jvm.internal.impl.name.FqName packageFqName = classId.getPackageFqName();
        java.lang.String strReplace$default = kotlin.text.StringsKt.replace$default(classId.getRelativeClassName().asString(), com.taobao.weex.el.parse.Operators.DOT, '$', false, 4, (java.lang.Object) null);
        if (!packageFqName.isRoot()) {
            strReplace$default = packageFqName.asString() + com.taobao.weex.el.parse.Operators.DOT + strReplace$default;
        }
        java.lang.Class<?> clsTryLoadClass = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, strReplace$default);
        if (clsTryLoadClass != null) {
            return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass(clsTryLoadClass);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage findPackage(kotlin.reflect.jvm.internal.impl.name.FqName fqName, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaPackage(fqName);
    }
}
