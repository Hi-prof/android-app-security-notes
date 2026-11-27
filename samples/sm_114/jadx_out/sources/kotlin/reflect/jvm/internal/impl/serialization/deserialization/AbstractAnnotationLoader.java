package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: AbstractAnnotationLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractAnnotationLoader<A> implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader<A> {
    private final kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol protocol;

    /* JADX INFO: compiled from: AbstractAnnotationLoader.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AbstractAnnotationLoader(kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol protocol) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(protocol, "protocol");
        this.protocol = protocol;
    }

    protected final kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol getProtocol() {
        return this.protocol;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadClassAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class container) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        java.util.List listEmptyList = (java.util.List) container.getClassProto().getExtension(this.protocol.getClassAnnotation());
        if (listEmptyList == null) {
            listEmptyList = kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.List list = listEmptyList;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(loadAnnotation((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation) it.next(), container.getNameResolver()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadCallableAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite proto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind kind) {
        java.util.List listEmptyList;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        if (proto instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) {
            listEmptyList = (java.util.List) ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) proto).getExtension(this.protocol.getConstructorAnnotation());
        } else if (proto instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) {
            listEmptyList = (java.util.List) ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) proto).getExtension(this.protocol.getFunctionAnnotation());
        } else {
            if (!(proto instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property)) {
                throw new java.lang.IllegalStateException(("Unknown message: " + proto).toString());
            }
            int i = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractAnnotationLoader.WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
            if (i == 1) {
                listEmptyList = (java.util.List) ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) proto).getExtension(this.protocol.getPropertyAnnotation());
            } else if (i == 2) {
                listEmptyList = (java.util.List) ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) proto).getExtension(this.protocol.getPropertyGetterAnnotation());
            } else if (i == 3) {
                listEmptyList = (java.util.List) ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) proto).getExtension(this.protocol.getPropertySetterAnnotation());
            } else {
                throw new java.lang.IllegalStateException("Unsupported callable kind with property proto".toString());
            }
        }
        if (listEmptyList == null) {
            listEmptyList = kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.List list = listEmptyList;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(loadAnnotation((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation) it.next(), container.getNameResolver()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadPropertyBackingFieldAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> propertyBackingFieldAnnotation = this.protocol.getPropertyBackingFieldAnnotation();
        java.util.List listEmptyList = propertyBackingFieldAnnotation != null ? (java.util.List) proto.getExtension(propertyBackingFieldAnnotation) : null;
        if (listEmptyList == null) {
            listEmptyList = kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.List list = listEmptyList;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(loadAnnotation((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation) it.next(), container.getNameResolver()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadPropertyDelegateFieldAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> propertyDelegatedFieldAnnotation = this.protocol.getPropertyDelegatedFieldAnnotation();
        java.util.List listEmptyList = propertyDelegatedFieldAnnotation != null ? (java.util.List) proto.getExtension(propertyDelegatedFieldAnnotation) : null;
        if (listEmptyList == null) {
            listEmptyList = kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.List list = listEmptyList;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(loadAnnotation((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation) it.next(), container.getNameResolver()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadEnumEntryAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry proto) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        java.util.List listEmptyList = (java.util.List) proto.getExtension(this.protocol.getEnumEntryAnnotation());
        if (listEmptyList == null) {
            listEmptyList = kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.List list = listEmptyList;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(loadAnnotation((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation) it.next(), container.getNameResolver()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadValueParameterAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite callableProto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind kind, int i, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter proto) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableProto, "callableProto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        java.util.List listEmptyList = (java.util.List) proto.getExtension(this.protocol.getParameterAnnotation());
        if (listEmptyList == null) {
            listEmptyList = kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.List list = listEmptyList;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(loadAnnotation((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation) it.next(), container.getNameResolver()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadExtensionReceiverParameterAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite proto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind kind) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        java.util.List listEmptyList = null;
        if (proto instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) {
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> functionExtensionReceiverAnnotation = this.protocol.getFunctionExtensionReceiverAnnotation();
            if (functionExtensionReceiverAnnotation != null) {
                listEmptyList = (java.util.List) ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) proto).getExtension(functionExtensionReceiverAnnotation);
            }
        } else {
            if (!(proto instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property)) {
                throw new java.lang.IllegalStateException(("Unknown message: " + proto).toString());
            }
            int i = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractAnnotationLoader.WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation>> propertyExtensionReceiverAnnotation = this.protocol.getPropertyExtensionReceiverAnnotation();
                if (propertyExtensionReceiverAnnotation != null) {
                    listEmptyList = (java.util.List) ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) proto).getExtension(propertyExtensionReceiverAnnotation);
                }
            } else {
                throw new java.lang.IllegalStateException(("Unsupported callable kind with property proto for receiver annotations: " + kind).toString());
            }
        }
        if (listEmptyList == null) {
            listEmptyList = kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.List list = listEmptyList;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(loadAnnotation((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation) it.next(), container.getNameResolver()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadTypeAnnotations(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        java.util.List listEmptyList = (java.util.List) proto.getExtension(this.protocol.getTypeAnnotation());
        if (listEmptyList == null) {
            listEmptyList = kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.List list = listEmptyList;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(loadAnnotation((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadTypeParameterAnnotations(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        java.util.List listEmptyList = (java.util.List) proto.getExtension(this.protocol.getTypeParameterAnnotation());
        if (listEmptyList == null) {
            listEmptyList = kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.List list = listEmptyList;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(loadAnnotation((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation) it.next(), nameResolver));
        }
        return arrayList;
    }
}
