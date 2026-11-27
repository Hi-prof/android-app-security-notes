package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: MemberDeserializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberDeserializer {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer annotationDeserializer;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext c;

    private final int loadOldFlags(int i) {
        return (i & 63) + ((i >> 8) << 6);
    }

    public MemberDeserializer(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        this.c = c;
        this.annotationDeserializer = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer(c.getComponents().getModuleDescriptor(), c.getComponents().getNotFoundClasses());
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor loadProperty$default(kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer memberDeserializer, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return memberDeserializer.loadProperty(property, z);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor loadProperty(final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto, boolean z) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations empty;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl propertySetterDescriptorImplCreateDefaultSetter;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl propertyGetterDescriptorImplCreateDefaultGetter;
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeType;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        int flags = proto.hasFlags() ? proto.getFlags() : loadOldFlags(proto.getOldFlags());
        if (z) {
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion companion = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> list = annotationList;
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
            for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation : list) {
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer annotationDeserializer = this.annotationDeserializer;
                kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
                arrayList.add(annotationDeserializer.deserializeAnnotation(annotation, this.c.getNameResolver()));
            }
            annotations = companion.create(arrayList);
        } else {
            annotations = null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        if (annotations == null) {
            annotations = getAnnotations(proto, flags, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.Modality modality = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE.modality(kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY.get(flags));
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt.descriptorVisibility(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE, kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY.get(flags));
        java.lang.Boolean bool = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_VAR.get(flags);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        boolean zBooleanValue = bool.booleanValue();
        kotlin.reflect.jvm.internal.impl.name.Name name = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName());
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kindMemberKind = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt.memberKind(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE, kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MEMBER_KIND.get(flags));
        java.lang.Boolean bool2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_LATEINIT.get(flags);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
        boolean zBooleanValue2 = bool2.booleanValue();
        java.lang.Boolean bool3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_CONST.get(flags);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
        boolean zBooleanValue3 = bool3.booleanValue();
        java.lang.Boolean bool4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_PROPERTY.get(flags);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool4, "get(...)");
        boolean zBooleanValue4 = bool4.booleanValue();
        java.lang.Boolean bool5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_DELEGATED.get(flags);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool5, "get(...)");
        boolean zBooleanValue5 = bool5.booleanValue();
        java.lang.Boolean bool6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXPECT_PROPERTY.get(flags);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool6, "get(...)");
        int i = flags;
        final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor deserializedPropertyDescriptor = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor(containingDeclaration, null, annotations, modality, descriptorVisibility, zBooleanValue, name, kindMemberKind, zBooleanValue2, zBooleanValue3, zBooleanValue4, zBooleanValue5, bool6.booleanValue(), proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext deserializationContext = this.c;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext deserializationContextChildContext$default = kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext.childContext$default(deserializationContext, deserializedPropertyDescriptor2, typeParameterList, null, null, null, null, 60, null);
        java.lang.Boolean bool7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_GETTER.get(i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool7, "get(...)");
        boolean zBooleanValue6 = bool7.booleanValue();
        if (zBooleanValue6 && kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.hasReceiver(proto)) {
            empty = getReceiverParameterAnnotations(proto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_GETTER);
        } else {
            empty = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY();
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeType2 = deserializationContextChildContext$default.getTypeDeserializer().type(kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.returnType(proto, this.c.getTypeTable()));
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> ownTypeParameters = deserializationContextChildContext$default.getTypeDeserializer().getOwnTypeParameters();
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeReceiverType = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.receiverType(proto, this.c.getTypeTable());
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptorCreateExtensionReceiverParameterForCallable = (typeReceiverType == null || (kotlinTypeType = deserializationContextChildContext$default.getTypeDeserializer().type(typeReceiverType)) == null) ? null : kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedPropertyDescriptor, kotlinTypeType, empty);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> listContextReceiverTypes = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.contextReceiverTypes(proto, this.c.getTypeTable());
        java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listContextReceiverTypes, 10));
        int i2 = 0;
        for (java.lang.Object obj : listContextReceiverTypes) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            arrayList2.add(toContextReceiver((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) obj, deserializationContextChildContext$default, deserializedPropertyDescriptor, i2));
            i2 = i3;
        }
        deserializedPropertyDescriptor.setType(kotlinTypeType2, ownTypeParameters, dispatchReceiverParameter, receiverParameterDescriptorCreateExtensionReceiverParameterForCallable, arrayList2);
        java.lang.Boolean bool8 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS.get(i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool8, "get(...)");
        int accessorFlags = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.getAccessorFlags(bool8.booleanValue(), kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY.get(i), kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY.get(i), false, false, false);
        if (zBooleanValue6) {
            int getterFlags = proto.hasGetterFlags() ? proto.getGetterFlags() : accessorFlags;
            java.lang.Boolean bool9 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_NOT_DEFAULT.get(getterFlags);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool9, "get(...)");
            boolean zBooleanValue7 = bool9.booleanValue();
            java.lang.Boolean bool10 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool10, "get(...)");
            boolean zBooleanValue8 = bool10.booleanValue();
            java.lang.Boolean bool11 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_INLINE_ACCESSOR.get(getterFlags);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool11, "get(...)");
            boolean zBooleanValue9 = bool11.booleanValue();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations2 = getAnnotations(proto, getterFlags, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_GETTER);
            if (zBooleanValue7) {
                propertyGetterDescriptorImplCreateDefaultGetter = new kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl(deserializedPropertyDescriptor, annotations2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE.modality(kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY.get(getterFlags)), kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt.descriptorVisibility(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE, kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY.get(getterFlags)), !zBooleanValue7, zBooleanValue8, zBooleanValue9, deserializedPropertyDescriptor.getKind(), null, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE);
            } else {
                propertyGetterDescriptorImplCreateDefaultGetter = kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createDefaultGetter(deserializedPropertyDescriptor, annotations2);
                kotlin.jvm.internal.Intrinsics.checkNotNull(propertyGetterDescriptorImplCreateDefaultGetter);
            }
            propertyGetterDescriptorImpl = propertyGetterDescriptorImplCreateDefaultGetter;
            propertyGetterDescriptorImpl.initialize(deserializedPropertyDescriptor.getReturnType());
        } else {
            propertyGetterDescriptorImpl = null;
        }
        if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_SETTER.get(i).booleanValue()) {
            if (proto.hasSetterFlags()) {
                accessorFlags = proto.getSetterFlags();
            }
            java.lang.Boolean bool12 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_NOT_DEFAULT.get(accessorFlags);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool12, "get(...)");
            boolean zBooleanValue10 = bool12.booleanValue();
            java.lang.Boolean bool13 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_ACCESSOR.get(accessorFlags);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool13, "get(...)");
            boolean zBooleanValue11 = bool13.booleanValue();
            java.lang.Boolean bool14 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_INLINE_ACCESSOR.get(accessorFlags);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool14, "get(...)");
            boolean zBooleanValue12 = bool14.booleanValue();
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property = proto;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations3 = getAnnotations(property, accessorFlags, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_SETTER);
            if (zBooleanValue10) {
                propertySetterDescriptorImplCreateDefaultSetter = new kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl(deserializedPropertyDescriptor, annotations3, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE.modality(kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY.get(accessorFlags)), kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt.descriptorVisibility(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE, kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY.get(accessorFlags)), !zBooleanValue10, zBooleanValue11, zBooleanValue12, deserializedPropertyDescriptor.getKind(), null, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE);
                propertySetterDescriptorImplCreateDefaultSetter.initialize((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) kotlin.collections.CollectionsKt.single((java.util.List) kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext.childContext$default(deserializationContextChildContext$default, propertySetterDescriptorImplCreateDefaultSetter, kotlin.collections.CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer().valueParameters(kotlin.collections.CollectionsKt.listOf(proto.getSetterValueParameter()), property, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_SETTER)));
            } else {
                propertySetterDescriptorImplCreateDefaultSetter = kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createDefaultSetter(deserializedPropertyDescriptor, annotations3, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY());
                kotlin.jvm.internal.Intrinsics.checkNotNull(propertySetterDescriptorImplCreateDefaultSetter);
            }
        } else {
            propertySetterDescriptorImplCreateDefaultSetter = null;
        }
        if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_CONSTANT.get(i).booleanValue()) {
            deserializedPropertyDescriptor.setCompileTimeInitializerFactory(new kotlin.jvm.functions.Function0(this, proto, deserializedPropertyDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$0
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer arg$0;
                private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property arg$1;
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor arg$2;

                {
                    this.arg$0 = this;
                    this.arg$1 = proto;
                    this.arg$2 = deserializedPropertyDescriptor;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.loadProperty$lambda$4(this.arg$0, this.arg$1, this.arg$2);
                }
            });
        }
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration2 = this.c.getContainingDeclaration();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = containingDeclaration2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration2 : null;
        if ((classDescriptor != null ? classDescriptor.getKind() : null) == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS) {
            deserializedPropertyDescriptor.setCompileTimeInitializerFactory(new kotlin.jvm.functions.Function0(this, proto, deserializedPropertyDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$1
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer arg$0;
                private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property arg$1;
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor arg$2;

                {
                    this.arg$0 = this;
                    this.arg$1 = proto;
                    this.arg$2 = deserializedPropertyDescriptor;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.loadProperty$lambda$6(this.arg$0, this.arg$1, this.arg$2);
                }
            });
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor deserializedPropertyDescriptor3 = deserializedPropertyDescriptor;
        deserializedPropertyDescriptor.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImplCreateDefaultSetter, new kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl(getPropertyFieldAnnotations(proto, false), deserializedPropertyDescriptor3), new kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl(getPropertyFieldAnnotations(proto, true), deserializedPropertyDescriptor3));
        return deserializedPropertyDescriptor3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue loadProperty$lambda$4(final kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer memberDeserializer, final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property, final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        return memberDeserializer.c.getStorageManager().createNullableLazyValue(new kotlin.jvm.functions.Function0(memberDeserializer, property, deserializedPropertyDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$6
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer arg$0;
            private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property arg$1;
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor arg$2;

            {
                this.arg$0 = memberDeserializer;
                this.arg$1 = property;
                this.arg$2 = deserializedPropertyDescriptor;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.loadProperty$lambda$4$lambda$3(this.arg$0, this.arg$1, this.arg$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue loadProperty$lambda$4$lambda$3(kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer memberDeserializer, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer protoContainerAsProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.c.getContainingDeclaration());
        kotlin.jvm.internal.Intrinsics.checkNotNull(protoContainerAsProtoContainer);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> annotationAndConstantLoader = memberDeserializer.c.getComponents().getAnnotationAndConstantLoader();
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = deserializedPropertyDescriptor.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        return annotationAndConstantLoader.loadPropertyConstant(protoContainerAsProtoContainer, property, returnType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue loadProperty$lambda$6(final kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer memberDeserializer, final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property, final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        return memberDeserializer.c.getStorageManager().createNullableLazyValue(new kotlin.jvm.functions.Function0(memberDeserializer, property, deserializedPropertyDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$7
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer arg$0;
            private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property arg$1;
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor arg$2;

            {
                this.arg$0 = memberDeserializer;
                this.arg$1 = property;
                this.arg$2 = deserializedPropertyDescriptor;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.loadProperty$lambda$6$lambda$5(this.arg$0, this.arg$1, this.arg$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue loadProperty$lambda$6$lambda$5(kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer memberDeserializer, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer protoContainerAsProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.c.getContainingDeclaration());
        kotlin.jvm.internal.Intrinsics.checkNotNull(protoContainerAsProtoContainer);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> annotationAndConstantLoader = memberDeserializer.c.getComponents().getAnnotationAndConstantLoader();
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = deserializedPropertyDescriptor.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        return annotationAndConstantLoader.loadAnnotationDefaultValue(protoContainerAsProtoContainer, property, returnType);
    }

    private final void initializeWithCoroutinesExperimentalityStatus(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor2, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> list, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list2, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list3, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility, java.util.Map<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<?>, ?> map) {
        deserializedSimpleFunctionDescriptor.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, list3, kotlinType, modality, descriptorVisibility, map);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor loadFunction(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function proto) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations empty;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable versionRequirementTable;
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeType;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        int flags = proto.hasFlags() ? proto.getFlags() : loadOldFlags(proto.getOldFlags());
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function function = proto;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations = getAnnotations(function, flags, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.FUNCTION);
        if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.hasReceiver(proto)) {
            empty = getReceiverParameterAnnotations(function, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.FUNCTION);
        } else {
            empty = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY();
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(this.c.getContainingDeclaration()).child(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName())), kotlin.reflect.jvm.internal.impl.serialization.deserialization.SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            versionRequirementTable = kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion.getEMPTY();
        } else {
            versionRequirementTable = this.c.getVersionRequirementTable();
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations2 = empty;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor(this.c.getContainingDeclaration(), null, annotations, kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName()), kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt.memberKind(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE, kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MEMBER_KIND.get(flags)), proto, this.c.getNameResolver(), this.c.getTypeTable(), versionRequirementTable, this.c.getContainerSource(), null, 1024, null);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext deserializationContextChildContext$default = kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext.childContext$default(this.c, deserializedSimpleFunctionDescriptor, typeParameterList, null, null, null, null, 60, null);
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeReceiverType = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.receiverType(proto, this.c.getTypeTable());
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptorCreateExtensionReceiverParameterForCallable = (typeReceiverType == null || (kotlinTypeType = deserializationContextChildContext$default.getTypeDeserializer().type(typeReceiverType)) == null) ? null : kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedSimpleFunctionDescriptor, kotlinTypeType, annotations2);
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> listContextReceiverTypes = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.contextReceiverTypes(proto, this.c.getTypeTable());
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        for (java.lang.Object obj : listContextReceiverTypes) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor contextReceiver = toContextReceiver((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) obj, deserializationContextChildContext$default, deserializedSimpleFunctionDescriptor, i);
            if (contextReceiver != null) {
                arrayList.add(contextReceiver);
            }
            i = i2;
        }
        java.util.ArrayList arrayList2 = arrayList;
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> ownTypeParameters = deserializationContextChildContext$default.getTypeDeserializer().getOwnTypeParameters();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer memberDeserializer = deserializationContextChildContext$default.getMemberDeserializer();
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
        initializeWithCoroutinesExperimentalityStatus(deserializedSimpleFunctionDescriptor, receiverParameterDescriptorCreateExtensionReceiverParameterForCallable, dispatchReceiverParameter, arrayList2, ownTypeParameters, memberDeserializer.valueParameters(valueParameterList, function, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.FUNCTION), deserializationContextChildContext$default.getTypeDeserializer().type(kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.returnType(proto, this.c.getTypeTable())), kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE.modality(kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY.get(flags)), kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt.descriptorVisibility(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE, kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY.get(flags)), kotlin.collections.MapsKt.emptyMap());
        java.lang.Boolean bool = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_OPERATOR.get(flags);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        deserializedSimpleFunctionDescriptor.setOperator(bool.booleanValue());
        java.lang.Boolean bool2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_INFIX.get(flags);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
        deserializedSimpleFunctionDescriptor.setInfix(bool2.booleanValue());
        java.lang.Boolean bool3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_FUNCTION.get(flags);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
        deserializedSimpleFunctionDescriptor.setExternal(bool3.booleanValue());
        java.lang.Boolean bool4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_INLINE.get(flags);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool4, "get(...)");
        deserializedSimpleFunctionDescriptor.setInline(bool4.booleanValue());
        java.lang.Boolean bool5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_TAILREC.get(flags);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool5, "get(...)");
        deserializedSimpleFunctionDescriptor.setTailrec(bool5.booleanValue());
        java.lang.Boolean bool6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_SUSPEND.get(flags);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool6, "get(...)");
        deserializedSimpleFunctionDescriptor.setSuspend(bool6.booleanValue());
        java.lang.Boolean bool7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXPECT_FUNCTION.get(flags);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool7, "get(...)");
        deserializedSimpleFunctionDescriptor.setExpect(bool7.booleanValue());
        deserializedSimpleFunctionDescriptor.setHasStableParameterNames(!kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.get(flags).booleanValue());
        kotlin.Pair<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<?>, java.lang.Object> pairDeserializeContractFromFunction = this.c.getComponents().getContractDeserializer().deserializeContractFromFunction(proto, deserializedSimpleFunctionDescriptor, this.c.getTypeTable(), deserializationContextChildContext$default.getTypeDeserializer());
        if (pairDeserializeContractFromFunction != null) {
            deserializedSimpleFunctionDescriptor.putInUserDataMap(pairDeserializeContractFromFunction.getFirst(), pairDeserializeContractFromFunction.getSecond());
        }
        return deserializedSimpleFunctionDescriptor;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor loadTypeAlias(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias proto) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion companion = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> list = annotationList;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation : list) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer annotationDeserializer = this.annotationDeserializer;
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
            arrayList.add(annotationDeserializer.deserializeAnnotation(annotation, this.c.getNameResolver()));
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor(this.c.getStorageManager(), this.c.getContainingDeclaration(), companion.create(arrayList), kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName()), kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt.descriptorVisibility(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE, kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY.get(proto.getFlags())), proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext deserializationContextChildContext$default = kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext.childContext$default(this.c, deserializedTypeAliasDescriptor, typeParameterList, null, null, null, null, 60, null);
        deserializedTypeAliasDescriptor.initialize(deserializationContextChildContext$default.getTypeDeserializer().getOwnTypeParameters(), deserializationContextChildContext$default.getTypeDeserializer().simpleType(kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.underlyingType(proto, this.c.getTypeTable()), false), deserializationContextChildContext$default.getTypeDeserializer().simpleType(kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.expandedType(proto, this.c.getTypeTable()), false));
        return deserializedTypeAliasDescriptor;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor getDispatchReceiverParameter() {
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null) {
            return classDescriptor.getThisAsReceiverParameter();
        }
        return null;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor loadConstructor(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor proto, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor constructor = proto;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor(classDescriptor, null, getAnnotations(constructor, proto.getFlags(), kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.FUNCTION), z, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION, proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource(), null, 1024, null);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer memberDeserializer = kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext.childContext$default(this.c, deserializedClassConstructorDescriptor, kotlin.collections.CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer();
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
        deserializedClassConstructorDescriptor.initialize(memberDeserializer.valueParameters(valueParameterList, constructor, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.FUNCTION), kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt.descriptorVisibility(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE, kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY.get(proto.getFlags())));
        deserializedClassConstructorDescriptor.setReturnType(classDescriptor.getDefaultType());
        deserializedClassConstructorDescriptor.setExpect(classDescriptor.isExpect());
        deserializedClassConstructorDescriptor.setHasStableParameterNames(!kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.get(proto.getFlags()).booleanValue());
        return deserializedClassConstructorDescriptor;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getAnnotations(final kotlin.reflect.jvm.internal.impl.protobuf.MessageLite messageLite, int i, final kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind annotatedCallableKind) {
        if (!kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS.get(i).booleanValue()) {
            return kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY();
        }
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new kotlin.jvm.functions.Function0(this, messageLite, annotatedCallableKind) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer arg$0;
            private final kotlin.reflect.jvm.internal.impl.protobuf.MessageLite arg$1;
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind arg$2;

            {
                this.arg$0 = this;
                this.arg$1 = messageLite;
                this.arg$2 = annotatedCallableKind;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.getAnnotations$lambda$12(this.arg$0, this.arg$1, this.arg$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List getAnnotations$lambda$12(kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer memberDeserializer, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite messageLite, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind annotatedCallableKind) {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer protoContainerAsProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.c.getContainingDeclaration());
        java.util.List list = protoContainerAsProtoContainer != null ? kotlin.collections.CollectionsKt.toList(memberDeserializer.c.getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(protoContainerAsProtoContainer, messageLite, annotatedCallableKind)) : null;
        return list == null ? kotlin.collections.CollectionsKt.emptyList() : list;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getPropertyFieldAnnotations(final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property, final boolean z) {
        if (!kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS.get(property.getFlags()).booleanValue()) {
            return kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY();
        }
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new kotlin.jvm.functions.Function0(this, z, property) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$3
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer arg$0;
            private final boolean arg$1;
            private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property arg$2;

            {
                this.arg$0 = this;
                this.arg$1 = z;
                this.arg$2 = property;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.getPropertyFieldAnnotations$lambda$14(this.arg$0, this.arg$1, this.arg$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List getPropertyFieldAnnotations$lambda$14(kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer memberDeserializer, boolean z, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property) {
        java.util.List list;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer protoContainerAsProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.c.getContainingDeclaration());
        if (protoContainerAsProtoContainer == null) {
            list = null;
        } else if (z) {
            list = kotlin.collections.CollectionsKt.toList(memberDeserializer.c.getComponents().getAnnotationAndConstantLoader().loadPropertyDelegateFieldAnnotations(protoContainerAsProtoContainer, property));
        } else {
            list = kotlin.collections.CollectionsKt.toList(memberDeserializer.c.getComponents().getAnnotationAndConstantLoader().loadPropertyBackingFieldAnnotations(protoContainerAsProtoContainer, property));
        }
        return list == null ? kotlin.collections.CollectionsKt.emptyList() : list;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getReceiverParameterAnnotations(final kotlin.reflect.jvm.internal.impl.protobuf.MessageLite messageLite, final kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind annotatedCallableKind) {
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations(this.c.getStorageManager(), new kotlin.jvm.functions.Function0(this, messageLite, annotatedCallableKind) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$4
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer arg$0;
            private final kotlin.reflect.jvm.internal.impl.protobuf.MessageLite arg$1;
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind arg$2;

            {
                this.arg$0 = this;
                this.arg$1 = messageLite;
                this.arg$2 = annotatedCallableKind;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.getReceiverParameterAnnotations$lambda$16(this.arg$0, this.arg$1, this.arg$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List getReceiverParameterAnnotations$lambda$16(kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer memberDeserializer, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite messageLite, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind annotatedCallableKind) {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer protoContainerAsProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.c.getContainingDeclaration());
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> listLoadExtensionReceiverParameterAnnotations = protoContainerAsProtoContainer != null ? memberDeserializer.c.getComponents().getAnnotationAndConstantLoader().loadExtensionReceiverParameterAnnotations(protoContainerAsProtoContainer, messageLite, annotatedCallableKind) : null;
        return listLoadExtensionReceiverParameterAnnotations == null ? kotlin.collections.CollectionsKt.emptyList() : listLoadExtensionReceiverParameterAnnotations;
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters(java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> list, final kotlin.reflect.jvm.internal.impl.protobuf.MessageLite messageLite, final kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind annotatedCallableKind) {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations empty;
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) containingDeclaration;
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration2 = callableDescriptor.getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
        final kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer protoContainerAsProtoContainer = asProtoContainer(containingDeclaration2);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> list2 = list;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
        final int i = 0;
        for (java.lang.Object obj : list2) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter valueParameter = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) obj;
            int flags = valueParameter.hasFlags() ? valueParameter.getFlags() : 0;
            if (protoContainerAsProtoContainer != null && kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS.get(flags).booleanValue()) {
                empty = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new kotlin.jvm.functions.Function0(this, protoContainerAsProtoContainer, messageLite, annotatedCallableKind, i, valueParameter) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$5
                    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer arg$0;
                    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer arg$1;
                    private final kotlin.reflect.jvm.internal.impl.protobuf.MessageLite arg$2;
                    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind arg$3;
                    private final int arg$4;
                    private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter arg$5;

                    {
                        this.arg$0 = this;
                        this.arg$1 = protoContainerAsProtoContainer;
                        this.arg$2 = messageLite;
                        this.arg$3 = annotatedCallableKind;
                        this.arg$4 = i;
                        this.arg$5 = valueParameter;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public java.lang.Object invoke() {
                        return kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.valueParameters$lambda$19$lambda$17(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4, this.arg$5);
                    }
                });
            } else {
                empty = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY();
            }
            kotlin.reflect.jvm.internal.impl.name.Name name = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(this.c.getNameResolver(), valueParameter.getName());
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeType = this.c.getTypeDeserializer().type(kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.type(valueParameter, this.c.getTypeTable()));
            java.lang.Boolean bool = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.DECLARES_DEFAULT_VALUE.get(flags);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
            boolean zBooleanValue = bool.booleanValue();
            java.lang.Boolean bool2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_CROSSINLINE.get(flags);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
            boolean zBooleanValue2 = bool2.booleanValue();
            java.lang.Boolean bool3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_NOINLINE.get(flags);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
            boolean zBooleanValue3 = bool3.booleanValue();
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeVarargElementType = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.varargElementType(valueParameter, this.c.getTypeTable());
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeType2 = typeVarargElementType != null ? this.c.getTypeDeserializer().type(typeVarargElementType) : null;
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement NO_SOURCE = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2 = callableDescriptor;
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl(callableDescriptor2, null, i, empty, name, kotlinTypeType, zBooleanValue, zBooleanValue2, zBooleanValue3, kotlinTypeType2, NO_SOURCE));
            callableDescriptor = callableDescriptor2;
            i = i2;
        }
        return kotlin.collections.CollectionsKt.toList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List valueParameters$lambda$19$lambda$17(kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer memberDeserializer, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer protoContainer, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite messageLite, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind annotatedCallableKind, int i, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter valueParameter) {
        return kotlin.collections.CollectionsKt.toList(memberDeserializer.c.getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(protoContainer, messageLite, annotatedCallableKind, i, valueParameter));
    }

    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer asProtoContainer(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) {
            return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Package(((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) declarationDescriptor).getFqName(), this.c.getNameResolver(), this.c.getTypeTable(), this.c.getContainerSource());
        }
        if (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) {
            return ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) declarationDescriptor).getThisAsProtoContainer$deserialization();
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor toContextReceiver(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type type, kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext deserializationContext, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, int i) {
        return kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createContextReceiverParameterForCallable(callableDescriptor, deserializationContext.getTypeDeserializer().type(type), null, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), i);
    }
}
