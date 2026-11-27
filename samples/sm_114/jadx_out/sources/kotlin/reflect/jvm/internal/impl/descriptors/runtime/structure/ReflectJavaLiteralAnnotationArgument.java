package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaLiteralAnnotationArgument extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument {
    private final java.lang.Object value;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument
    public java.lang.Object getValue() {
        return this.value;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaLiteralAnnotationArgument(kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.Object value) {
        super(name, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }
}
