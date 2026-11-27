package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

/* JADX INFO: compiled from: RuntimeSourceElementFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RuntimeSourceElementFactory implements kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory();

    /* JADX INFO: compiled from: RuntimeSourceElementFactory.kt */
    public static final class RuntimeSourceElement implements kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement {
        private final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement javaElement;

        public RuntimeSourceElement(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement javaElement) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaElement, "javaElement");
            this.javaElement = javaElement;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
        public kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement getJavaElement() {
            return this.javaElement;
        }

        public java.lang.String toString() {
            return getClass().getName() + ": " + getJavaElement();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
        public kotlin.reflect.jvm.internal.impl.descriptors.SourceFile getContainingFile() {
            kotlin.reflect.jvm.internal.impl.descriptors.SourceFile NO_SOURCE_FILE = kotlin.reflect.jvm.internal.impl.descriptors.SourceFile.NO_SOURCE_FILE;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE_FILE, "NO_SOURCE_FILE");
            return NO_SOURCE_FILE;
        }
    }

    private RuntimeSourceElementFactory() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory
    public kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement source(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement javaElement) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaElement, "javaElement");
        return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory.RuntimeSourceElement((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement) javaElement);
    }
}
