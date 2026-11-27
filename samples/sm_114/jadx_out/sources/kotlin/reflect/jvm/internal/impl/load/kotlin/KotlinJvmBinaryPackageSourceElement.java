package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: KotlinJvmBinaryPackageSourceElement.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KotlinJvmBinaryPackageSourceElement implements kotlin.reflect.jvm.internal.impl.descriptors.SourceElement {
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment packageFragment;

    public KotlinJvmBinaryPackageSourceElement(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment packageFragment) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFragment, "packageFragment");
        this.packageFragment = packageFragment;
    }

    public java.lang.String toString() {
        return this.packageFragment + ": " + this.packageFragment.getBinaryClasses$descriptors_jvm().keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public kotlin.reflect.jvm.internal.impl.descriptors.SourceFile getContainingFile() {
        kotlin.reflect.jvm.internal.impl.descriptors.SourceFile NO_SOURCE_FILE = kotlin.reflect.jvm.internal.impl.descriptors.SourceFile.NO_SOURCE_FILE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }
}
