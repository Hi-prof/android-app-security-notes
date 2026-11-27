package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: AnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnnotationAndConstantLoaderImpl extends kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractAnnotationLoader<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer deserializer;

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> loadAnnotationDefaultValue(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto, kotlin.reflect.jvm.internal.impl.types.KotlinType expectedType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationAndConstantLoaderImpl(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses, kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol protocol) {
        super(protocol);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(protocol, "protocol");
        this.deserializer = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer(module, notFoundClasses);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor loadAnnotation(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        return this.deserializer.deserializeAnnotation(proto, nameResolver);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> loadPropertyConstant(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto, kotlin.reflect.jvm.internal.impl.types.KotlinType expectedType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value value = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(proto, getProtocol().getCompileTimeValue());
        if (value == null) {
            return null;
        }
        return this.deserializer.resolveValue(expectedType, value, container.getNameResolver());
    }
}
