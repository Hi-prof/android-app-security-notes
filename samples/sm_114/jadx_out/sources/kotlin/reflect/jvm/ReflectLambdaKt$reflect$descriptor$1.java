package kotlin.reflect.jvm;

/* JADX INFO: compiled from: reflectLambda.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ReflectLambdaKt$reflect$descriptor$1 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function2<kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> {
    public static final kotlin.reflect.jvm.ReflectLambdaKt$reflect$descriptor$1 INSTANCE = new kotlin.reflect.jvm.ReflectLambdaKt$reflect$descriptor$1();

    ReflectLambdaKt$reflect$descriptor$1() {
        super(2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.class, "loadFunction", "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor invoke(kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer p0, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function p1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p1, "p1");
        return p0.loadFunction(p1);
    }
}
