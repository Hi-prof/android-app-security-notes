package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class ReflectJavaClass$constructors$1 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function1<java.lang.reflect.Member, java.lang.Boolean> {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$constructors$1 INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$constructors$1();

    ReflectJavaClass$constructors$1() {
        super(1, java.lang.reflect.Member.class, "isSynthetic", "isSynthetic()Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final java.lang.Boolean invoke(java.lang.reflect.Member p0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
        return java.lang.Boolean.valueOf(p0.isSynthetic());
    }
}
