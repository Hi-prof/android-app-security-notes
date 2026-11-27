package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

/* JADX INFO: compiled from: DeserializedTypeParameterDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeserializedTypeParameterDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations annotations;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext c;
    private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter proto;

    /* JADX WARN: Illegal instructions before constructor call */
    public DeserializedTypeParameterDescriptor(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext c, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter proto, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager = c.getStorageManager();
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = c.getContainingDeclaration();
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations empty = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY();
        kotlin.reflect.jvm.internal.impl.name.Name name = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(c.getNameResolver(), proto.getName());
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags protoEnumFlags = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance variance = proto.getVariance();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(variance, "getVariance(...)");
        super(storageManager, containingDeclaration, empty, name, protoEnumFlags.variance(variance), proto.getReified(), i, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE, kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY.INSTANCE);
        this.c = c;
        this.proto = proto;
        this.annotations = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations(c.getStorageManager(), new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor.annotations$lambda$0(this.arg$0);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations getAnnotations() {
        return this.annotations;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List annotations$lambda$0(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor deserializedTypeParameterDescriptor) {
        return kotlin.collections.CollectionsKt.toList(deserializedTypeParameterDescriptor.c.getComponents().getAnnotationAndConstantLoader().loadTypeParameterAnnotations(deserializedTypeParameterDescriptor.proto, deserializedTypeParameterDescriptor.c.getNameResolver()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> resolveUpperBounds() {
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> listUpperBounds = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.upperBounds(this.proto, this.c.getTypeTable());
        if (listUpperBounds.isEmpty()) {
            return kotlin.collections.CollectionsKt.listOf(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(this).getDefaultBound());
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> list = listUpperBounds;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer typeDeserializer = this.c.getTypeDeserializer();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(typeDeserializer.type((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* JADX INFO: renamed from: reportSupertypeLoopError, reason: merged with bridge method [inline-methods] */
    public java.lang.Void mo1838reportSupertypeLoopError(kotlin.reflect.jvm.internal.impl.types.KotlinType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        throw new java.lang.IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }
}
