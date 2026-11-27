package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class ReflectJavaClass$fields$2 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function1<java.lang.reflect.Field, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField> {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$fields$2 INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$fields$2();

    ReflectJavaClass$fields$2() {
        super(1, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField.class, "<init>", "<init>(Ljava/lang/reflect/Field;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField invoke(java.lang.reflect.Field p0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
        return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField(p0);
    }
}
