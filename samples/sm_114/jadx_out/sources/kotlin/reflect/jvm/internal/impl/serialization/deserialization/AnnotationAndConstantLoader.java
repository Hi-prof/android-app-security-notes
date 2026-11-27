package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: AnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface AnnotationAndConstantLoader<A, C> extends kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader<A> {
    C loadAnnotationDefaultValue(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer protoContainer, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType);

    C loadPropertyConstant(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer protoContainer, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType);
}
