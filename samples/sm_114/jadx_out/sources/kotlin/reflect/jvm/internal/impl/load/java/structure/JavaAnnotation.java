package kotlin.reflect.jvm.internal.impl.load.java.structure;

/* JADX INFO: compiled from: javaElements.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface JavaAnnotation extends kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement {
    java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument> getArguments();

    kotlin.reflect.jvm.internal.impl.name.ClassId getClassId();

    boolean isFreshlySupportedTypeUseAnnotation();

    boolean isIdeExternalAnnotation();

    kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass resolve();
}
