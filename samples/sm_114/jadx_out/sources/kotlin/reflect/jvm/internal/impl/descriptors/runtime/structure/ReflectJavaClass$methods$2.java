package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class ReflectJavaClass$methods$2 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function1<java.lang.reflect.Method, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod> {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$methods$2 INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$methods$2();

    ReflectJavaClass$methods$2() {
        super(1, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod.class, "<init>", "<init>(Ljava/lang/reflect/Method;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod invoke(java.lang.reflect.Method p0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
        return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod(p0);
    }
}
