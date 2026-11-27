package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class ReflectJavaClass$constructors$2 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function1<java.lang.reflect.Constructor<?>, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor> {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$constructors$2 INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$constructors$2();

    ReflectJavaClass$constructors$2() {
        super(1, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor.class, "<init>", "<init>(Ljava/lang/reflect/Constructor;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor invoke(java.lang.reflect.Constructor<?> p0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
        return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor(p0);
    }
}
