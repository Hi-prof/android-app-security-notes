package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

/* JADX INFO: Add missing generic type declarations: [M] */
/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1<M> implements kotlin.jvm.functions.Function0<M> {
    final /* synthetic */ java.io.ByteArrayInputStream $inputStream;
    final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.Parser<M> $parser;
    final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope this$0;

    public DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(kotlin.reflect.jvm.internal.impl.protobuf.Parser<M> parser, java.io.ByteArrayInputStream byteArrayInputStream, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope deserializedMemberScope) {
        this.$parser = parser;
        this.$inputStream = byteArrayInputStream;
        this.this$0 = deserializedMemberScope;
    }

    /* JADX WARN: Incorrect return type in method signature: ()TM; */
    @Override // kotlin.jvm.functions.Function0
    public final kotlin.reflect.jvm.internal.impl.protobuf.MessageLite invoke() {
        return (kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) this.$parser.parseDelimitedFrom(this.$inputStream, this.this$0.getC().getComponents().getExtensionRegistryLite());
    }
}
