package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractBinaryClassAnnotationLoader<A, S extends kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.AnnotationsContainer<? extends A>> implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader<A> {
    public static final kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.Companion Companion = new kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.Companion(null);
    private final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder kotlinClassFinder;

    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
    public static abstract class AnnotationsContainer<A> {
        public abstract java.util.Map<kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, java.util.List<A>> getMemberAnnotations();
    }

    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
    private enum PropertyRelatedElement {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD;

        private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    }

    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    protected abstract S getAnnotationsContainer(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass kotlinJvmBinaryClass);

    protected byte[] getCachedFileContent(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass kotlinClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        return null;
    }

    public abstract kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion getMetadataVersion();

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public abstract A loadAnnotation(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver);

    protected abstract kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement, java.util.List<A> list);

    public AbstractBinaryClassAnnotationLoader(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder kotlinClassFinder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.kotlinClassFinder = kotlinClassFinder;
    }

    protected final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder getKotlinClassFinder() {
        return this.kotlinClassFinder;
    }

    protected final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial(kotlin.reflect.jvm.internal.impl.name.ClassId annotationClassId, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source, java.util.List<A> result) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationClassId, "annotationClassId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        if (kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS().contains(annotationClassId)) {
            return null;
        }
        return loadAnnotation(annotationClassId, source, result);
    }

    private final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass toBinaryClass(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class r3) {
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source = r3.getSource();
        kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement = source instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement ? (kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement) source : null;
        if (kotlinJvmBinarySourceElement != null) {
            return kotlinJvmBinarySourceElement.getBinaryClass();
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadClassAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class container) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass binaryClass = toBinaryClass(container);
        if (binaryClass == null) {
            throw new java.lang.IllegalStateException(("Class for loading annotations is not found: " + container.debugFqName()).toString());
        }
        final java.util.ArrayList arrayList = new java.util.ArrayList(1);
        binaryClass.loadClassAnnotations(new kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor(this) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.loadClassAnnotations.1
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader<A, S> this$0;

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
            public void visitEnd() {
            }

            {
                this.this$0 = this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
            public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
                return this.this$0.loadAnnotationIfNotSpecial(classId, source, arrayList);
            }
        }, getCachedFileContent(binaryClass));
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadCallableAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite proto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind kind) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        if (kind == kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY) {
            return loadPropertyAnnotations(container, (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) proto, kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.PropertyRelatedElement.PROPERTY);
        }
        kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature callableSignature$default = getCallableSignature$default(this, proto, container.getNameResolver(), container.getTypeTable(), kind, false, 16, null);
        return callableSignature$default == null ? kotlin.collections.CollectionsKt.emptyList() : findClassAndLoadMemberAnnotations$default(this, container, callableSignature$default, false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadPropertyBackingFieldAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        return loadPropertyAnnotations(container, proto, kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.PropertyRelatedElement.BACKING_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadPropertyDelegateFieldAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        return loadPropertyAnnotations(container, proto, kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.PropertyRelatedElement.DELEGATE_FIELD);
    }

    private final java.util.List<A> loadPropertyAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer protoContainer, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.PropertyRelatedElement propertyRelatedElement) {
        java.lang.Boolean bool = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_CONST.get(property.getFlags());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        bool.booleanValue();
        boolean zIsMovedFromInterfaceCompanion = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.isMovedFromInterfaceCompanion(property);
        if (propertyRelatedElement == kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.PropertyRelatedElement.PROPERTY) {
            kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature propertySignature$default = kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), false, true, false, 40, null);
            return propertySignature$default == null ? kotlin.collections.CollectionsKt.emptyList() : findClassAndLoadMemberAnnotations$default(this, protoContainer, propertySignature$default, true, false, bool, zIsMovedFromInterfaceCompanion, 8, null);
        }
        kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature propertySignature$default2 = kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), true, false, false, 48, null);
        if (propertySignature$default2 == null) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        return kotlin.text.StringsKt.contains$default((java.lang.CharSequence) propertySignature$default2.getSignature(), (java.lang.CharSequence) "$delegate", false, 2, (java.lang.Object) null) != (propertyRelatedElement == kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.PropertyRelatedElement.DELEGATE_FIELD) ? kotlin.collections.CollectionsKt.emptyList() : findClassAndLoadMemberAnnotations(protoContainer, propertySignature$default2, true, true, bool, zIsMovedFromInterfaceCompanion);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadEnumEntryAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry proto) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        return findClassAndLoadMemberAnnotations$default(this, container, kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion.fromFieldNameAndDesc(container.getNameResolver().getString(proto.getName()), kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite.mapClass(((kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class) container).getClassId().asString())), false, false, null, false, 60, null);
    }

    static /* synthetic */ java.util.List findClassAndLoadMemberAnnotations$default(kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer protoContainer, kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature memberSignature, boolean z, boolean z2, java.lang.Boolean bool, boolean z3, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        if ((i & 16) != 0) {
            bool = null;
        }
        if ((i & 32) != 0) {
            z3 = false;
        }
        return abstractBinaryClassAnnotationLoader.findClassAndLoadMemberAnnotations(protoContainer, memberSignature, z, z2, bool, z3);
    }

    private final java.util.List<A> findClassAndLoadMemberAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer protoContainer, kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature memberSignature, boolean z, boolean z2, java.lang.Boolean bool, boolean z3) {
        kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass kotlinJvmBinaryClassFindClassWithAnnotationsAndInitializers = findClassWithAnnotationsAndInitializers(protoContainer, Companion.getSpecialCaseContainerClass(protoContainer, z, z2, bool, z3, this.kotlinClassFinder, getMetadataVersion()));
        if (kotlinJvmBinaryClassFindClassWithAnnotationsAndInitializers == null) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.List<A> list = getAnnotationsContainer(kotlinJvmBinaryClassFindClassWithAnnotationsAndInitializers).getMemberAnnotations().get(memberSignature);
        return list == null ? kotlin.collections.CollectionsKt.emptyList() : list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadValueParameterAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite callableProto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind kind, int i, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter proto) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableProto, "callableProto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature callableSignature$default = getCallableSignature$default(this, callableProto, container.getNameResolver(), container.getTypeTable(), kind, false, 16, null);
        if (callableSignature$default != null) {
            return findClassAndLoadMemberAnnotations$default(this, container, kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion.fromMethodSignatureAndParameterIndex(callableSignature$default, i + computeJvmParameterIndexShift(container, callableProto)), false, false, null, false, 60, null);
        }
        return kotlin.collections.CollectionsKt.emptyList();
    }

    private final int computeJvmParameterIndexShift(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer protoContainer, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite messageLite) {
        if (messageLite instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) {
            return kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.hasReceiver((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) messageLite) ? 1 : 0;
        }
        if (messageLite instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) {
            return kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.hasReceiver((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) messageLite) ? 1 : 0;
        }
        if (messageLite instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(protoContainer, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class r4 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class) protoContainer;
            if (r4.getKind() == kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.ENUM_CLASS) {
                return 2;
            }
            return r4.isInner() ? 1 : 0;
        }
        throw new java.lang.UnsupportedOperationException("Unsupported message: " + messageLite.getClass());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadExtensionReceiverParameterAnnotations(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite proto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind kind) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature callableSignature$default = getCallableSignature$default(this, proto, container.getNameResolver(), container.getTypeTable(), kind, false, 16, null);
        if (callableSignature$default != null) {
            return findClassAndLoadMemberAnnotations$default(this, container, kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion.fromMethodSignatureAndParameterIndex(callableSignature$default, 0), false, false, null, false, 60, null);
        }
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadTypeAnnotations(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        java.lang.Object extension = proto.getExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.typeAnnotation);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(extension, "getExtension(...)");
        java.lang.Iterable<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> iterable = (java.lang.Iterable) extension;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation : iterable) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
            arrayList.add(loadAnnotation(annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public java.util.List<A> loadTypeParameterAnnotations(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        java.lang.Object extension = proto.getExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.typeParameterAnnotation);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(extension, "getExtension(...)");
        java.lang.Iterable<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> iterable = (java.lang.Iterable) extension;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation : iterable) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
            arrayList.add(loadAnnotation(annotation, nameResolver));
        }
        return arrayList;
    }

    protected final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        if (kotlinJvmBinaryClass != null) {
            return kotlinJvmBinaryClass;
        }
        if (container instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class) {
            return toBinaryClass((kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class) container);
        }
        return null;
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature getCallableSignature$default(kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader abstractBinaryClassAnnotationLoader, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite messageLite, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind annotatedCallableKind, boolean z, int i, java.lang.Object obj) {
        if (obj == null) {
            return abstractBinaryClassAnnotationLoader.getCallableSignature(messageLite, nameResolver, typeTable, annotatedCallableKind, (i & 16) != 0 ? false : z);
        }
        throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    protected final kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature getCallableSignature(kotlin.reflect.jvm.internal.impl.protobuf.MessageLite proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind kind, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        if (proto instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) {
            kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion companion = kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion;
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method jvmConstructorSignature = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) proto, nameResolver, typeTable);
            if (jvmConstructorSignature == null) {
                return null;
            }
            return companion.fromJvmMemberSignature(jvmConstructorSignature);
        }
        if (proto instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) {
            kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion companion2 = kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion;
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method jvmMethodSignature = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) proto, nameResolver, typeTable);
            if (jvmMethodSignature == null) {
                return null;
            }
            return companion2.fromJvmMemberSignature(jvmMethodSignature);
        }
        if (proto instanceof kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) {
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature> propertySignature = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.propertySignature;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertySignature, "propertySignature");
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage) proto, propertySignature);
            if (jvmPropertySignature == null) {
                return null;
            }
            int i = kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoaderKt.getPropertySignature((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) proto, nameResolver, typeTable, true, true, z);
                }
                if (!jvmPropertySignature.hasSetter()) {
                    return null;
                }
                kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion companion3 = kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion;
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature setter = jvmPropertySignature.getSetter();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(setter, "getSetter(...)");
                return companion3.fromMethod(nameResolver, setter);
            }
            if (jvmPropertySignature.hasGetter()) {
                kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion companion4 = kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion;
                kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature getter = jvmPropertySignature.getGetter();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(getter, "getGetter(...)");
                return companion4.fromMethod(nameResolver, getter);
            }
        }
        return null;
    }

    protected final boolean isImplicitRepeatableContainer(kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
        kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass kotlinJvmBinaryClassFindKotlinClass;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
        return classId.getOuterClassId() != null && kotlin.jvm.internal.Intrinsics.areEqual(classId.getShortClassName().asString(), "Container") && (kotlinJvmBinaryClassFindKotlinClass = kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, classId, getMetadataVersion())) != null && kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations.INSTANCE.isAnnotatedWithContainerMetaAnnotation(kotlinJvmBinaryClassFindKotlinClass);
    }

    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass getSpecialCaseContainerClass(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, boolean z, boolean z2, java.lang.Boolean bool, boolean z3, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder kotlinClassFinder, kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class outerClass;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
            if (z) {
                if (bool == null) {
                    throw new java.lang.IllegalStateException(("isConst should not be null for property (container=" + container + com.taobao.weex.el.parse.Operators.BRACKET_END).toString());
                }
                if (container instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class) {
                    kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class r8 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class) container;
                    if (r8.getKind() == kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.INTERFACE) {
                        kotlin.reflect.jvm.internal.impl.name.ClassId classId = r8.getClassId();
                        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier("DefaultImpls");
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
                        return kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt.findKotlinClass(kotlinClassFinder, classId.createNestedClassId(nameIdentifier), metadataVersion);
                    }
                }
                if (bool.booleanValue() && (container instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Package)) {
                    kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source = container.getSource();
                    kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource jvmPackagePartSource = source instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource ? (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource) source : null;
                    kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName facadeClassName = jvmPackagePartSource != null ? jvmPackagePartSource.getFacadeClassName() : null;
                    if (facadeClassName != null) {
                        kotlin.reflect.jvm.internal.impl.name.ClassId.Companion companion = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion;
                        java.lang.String internalName = facadeClassName.getInternalName();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(internalName, "getInternalName(...)");
                        return kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt.findKotlinClass(kotlinClassFinder, companion.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName(kotlin.text.StringsKt.replace$default(internalName, '/', com.taobao.weex.el.parse.Operators.DOT, false, 4, (java.lang.Object) null))), metadataVersion);
                    }
                }
            }
            if (z2 && (container instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class)) {
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class r9 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class) container;
                if (r9.getKind() == kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.COMPANION_OBJECT && (outerClass = r9.getOuterClass()) != null && (outerClass.getKind() == kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.CLASS || outerClass.getKind() == kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.ENUM_CLASS || (z3 && (outerClass.getKind() == kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.INTERFACE || outerClass.getKind() == kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.ANNOTATION_CLASS)))) {
                    kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source2 = outerClass.getSource();
                    kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement = source2 instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement ? (kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement) source2 : null;
                    if (kotlinJvmBinarySourceElement != null) {
                        return kotlinJvmBinarySourceElement.getBinaryClass();
                    }
                    return null;
                }
            }
            if (!(container instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Package) || !(container.getSource() instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource)) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source3 = container.getSource();
            kotlin.jvm.internal.Intrinsics.checkNotNull(source3, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
            kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource jvmPackagePartSource2 = (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource) source3;
            kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource2.getKnownJvmBinaryClass();
            return knownJvmBinaryClass == null ? kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt.findKotlinClass(kotlinClassFinder, jvmPackagePartSource2.getClassId(), metadataVersion) : knownJvmBinaryClass;
        }
    }
}
