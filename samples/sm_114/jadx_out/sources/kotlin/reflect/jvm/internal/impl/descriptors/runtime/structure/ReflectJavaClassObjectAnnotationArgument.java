package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaClassObjectAnnotationArgument extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument implements kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument {
    private final java.lang.Class<?> klass;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaClassObjectAnnotationArgument(kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.Class<?> klass) {
        super(name, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(klass, "klass");
        this.klass = klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument
    public kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType getReferencedType() {
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory.create(this.klass);
    }
}
