package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeserializedClassDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor implements kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDescriptor {
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext c;
    private final kotlin.reflect.jvm.internal.impl.name.ClassId classId;
    private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class classProto;
    private final kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> companionObjectDescriptor;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor>> constructors;
    private final kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntries;
    private final boolean hasEnumEntriesMetadataFlag;
    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassKind kind;
    private final kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass<kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope> memberScopeHolder;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion metadataVersion;
    private final kotlin.reflect.jvm.internal.impl.descriptors.Modality modality;
    private final kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> primaryConstructor;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor>> sealedSubclasses;
    private final kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement;
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl staticScope;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class thisAsProtoContainer;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassTypeConstructor typeConstructor;
    private final kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue<kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType>> valueClassRepresentation;
    private final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class getClassProto() {
        return this.classProto;
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext outerContext, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class classProto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion metadataVersion, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement) {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty staticScopeForKotlinEnum;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations nonEmptyDeserializedAnnotations;
        super(outerContext.getStorageManager(), kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getClassId(nameResolver, classProto.getFqName()).getShortClassName());
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outerContext, "outerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classProto, "classProto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceElement, "sourceElement");
        this.classProto = classProto;
        this.metadataVersion = metadataVersion;
        this.sourceElement = sourceElement;
        this.classId = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getClassId(nameResolver, classProto.getFqName());
        this.modality = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE.modality(kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY.get(classProto.getFlags()));
        this.visibility = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt.descriptorVisibility(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE, kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY.get(classProto.getFlags()));
        kotlin.reflect.jvm.internal.impl.descriptors.ClassKind classKind = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE.classKind(kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.CLASS_KIND.get(classProto.getFlags()));
        this.kind = classKind;
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameterList = classProto.getTypeParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable typeTable = classProto.getTypeTable();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable2 = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable(typeTable);
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion companion = kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable versionRequirementTable = classProto.getVersionRequirementTable();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "getVersionRequirementTable(...)");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext deserializationContextChildContext = outerContext.childContext(this, typeParameterList, nameResolver, typeTable2, companion.create(versionRequirementTable), metadataVersion);
        this.c = deserializationContextChildContext;
        java.lang.Boolean bool = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ENUM_ENTRIES.get(classProto.getFlags());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        boolean zBooleanValue = bool.booleanValue();
        this.hasEnumEntriesMetadataFlag = zBooleanValue;
        if (classKind == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_CLASS) {
            boolean z = true;
            if (!zBooleanValue && !kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) deserializationContextChildContext.getComponents().getEnumEntriesDeserializationSupport().canSynthesizeEnumEntries(), (java.lang.Object) true)) {
                z = false;
            }
            staticScopeForKotlinEnum = new kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum(deserializationContextChildContext.getStorageManager(), this, z);
        } else {
            staticScopeForKotlinEnum = kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty.INSTANCE;
        }
        this.staticScope = staticScopeForKotlinEnum;
        this.typeConstructor = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassTypeConstructor();
        this.memberScopeHolder = kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass.Companion.create(this, deserializationContextChildContext.getStorageManager(), deserializationContextChildContext.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$memberScopeHolder$1(this));
        this.enumEntries = classKind == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_CLASS ? new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.EnumEntryClassDescriptors() : null;
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = outerContext.getContainingDeclaration();
        this.containingDeclaration = containingDeclaration;
        this.primaryConstructor = deserializationContextChildContext.getStorageManager().createNullableLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return this.arg$0.computePrimaryConstructor();
            }
        });
        this.constructors = deserializationContextChildContext.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return this.arg$0.computeConstructors();
            }
        });
        this.companionObjectDescriptor = deserializationContextChildContext.getStorageManager().createNullableLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return this.arg$0.computeCompanionObjectDescriptor();
            }
        });
        this.sealedSubclasses = deserializationContextChildContext.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$$Lambda$3
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return this.arg$0.computeSubclassesForSealedClass();
            }
        });
        this.valueClassRepresentation = deserializationContextChildContext.getStorageManager().createNullableLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$$Lambda$4
            private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return this.arg$0.computeValueClassRepresentation();
            }
        });
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver2 = deserializationContextChildContext.getNameResolver();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable3 = deserializationContextChildContext.getTypeTable();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor = containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor ? (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) containingDeclaration : null;
        this.thisAsProtoContainer = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class(classProto, nameResolver2, typeTable3, sourceElement, deserializedClassDescriptor != null ? deserializedClassDescriptor.thisAsProtoContainer : null);
        if (!kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS.get(classProto.getFlags()).booleanValue()) {
            nonEmptyDeserializedAnnotations = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY();
        } else {
            nonEmptyDeserializedAnnotations = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations(deserializationContextChildContext.getStorageManager(), new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$$Lambda$5
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.annotations$lambda$5(this.arg$0);
                }
            });
        }
        this.annotations = nonEmptyDeserializedAnnotations;
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext getC() {
        return this.c;
    }

    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope getMemberScope() {
        return (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope) this.memberScopeHolder.getScope(this.c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner());
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class getThisAsProtoContainer$deserialization() {
        return this.thisAsProtoContainer;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getAnnotations() {
        return this.annotations;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List annotations$lambda$5(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor) {
        return kotlin.collections.CollectionsKt.toList(deserializedClassDescriptor.c.getComponents().getAnnotationAndConstantLoader().loadClassAnnotations(deserializedClassDescriptor.thisAsProtoContainer));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public kotlin.reflect.jvm.internal.impl.types.TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassKind getKind() {
        return this.kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.Modality getModality() {
        return this.modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility getVisibility() {
        return this.visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        java.lang.Boolean bool = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_INNER.get(this.classProto.getFlags());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        return bool.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        java.lang.Boolean bool = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_DATA.get(this.classProto.getFlags());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        return bool.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_VALUE_CLASS.get(this.classProto.getFlags()).booleanValue() && this.metadataVersion.isAtMost(1, 4, 1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        java.lang.Boolean bool = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXPECT_CLASS.get(this.classProto.getFlags());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        return bool.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        java.lang.Boolean bool = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_CLASS.get(this.classProto.getFlags());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        return bool.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        java.lang.Boolean bool = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_FUN_INTERFACE.get(this.classProto.getFlags());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        return bool.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_VALUE_CLASS.get(this.classProto.getFlags()).booleanValue() && this.metadataVersion.isAtLeast(1, 4, 2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    protected kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getUnsubstitutedMemberScope(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.memberScopeHolder.getScope(kotlinTypeRefiner);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl getStaticScope() {
        return this.staticScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.CLASS_KIND.get(this.classProto.getFlags()) == kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind.COMPANION_OBJECT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor computePrimaryConstructor() {
        java.lang.Object next;
        if (this.kind.isSingleton()) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl classConstructorDescriptorImplCreatePrimaryConstructorForObject = kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createPrimaryConstructorForObject(this, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE);
            classConstructorDescriptorImplCreatePrimaryConstructorForObject.setReturnType(getDefaultType());
            return classConstructorDescriptorImplCreatePrimaryConstructorForObject;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor> constructorList = this.classProto.getConstructorList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(constructorList, "getConstructorList(...)");
        java.util.Iterator<T> it = constructorList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_SECONDARY.get(((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) next).getFlags()).booleanValue());
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor constructor = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) next;
        if (constructor != null) {
            return this.c.getMemberDeserializer().loadConstructor(constructor, true);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor mo1825getUnsubstitutedPrimaryConstructor() {
        return this.primaryConstructor.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> computeConstructors() {
        return kotlin.collections.CollectionsKt.plus((java.util.Collection) kotlin.collections.CollectionsKt.plus((java.util.Collection) computeSecondaryConstructors(), (java.lang.Iterable) kotlin.collections.CollectionsKt.listOfNotNull(mo1825getUnsubstitutedPrimaryConstructor())), (java.lang.Iterable) this.c.getComponents().getAdditionalClassPartsProvider().getConstructors(this));
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> computeSecondaryConstructors() {
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor> constructorList = this.classProto.getConstructorList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(constructorList, "getConstructorList(...)");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : constructorList) {
            java.lang.Boolean bool = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_SECONDARY.get(((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) obj).getFlags());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
            if (bool.booleanValue()) {
                arrayList.add(obj);
            }
        }
        java.util.ArrayList<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor> arrayList2 = arrayList;
        java.util.ArrayList arrayList3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor constructor : arrayList2) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer memberDeserializer = this.c.getMemberDeserializer();
            kotlin.jvm.internal.Intrinsics.checkNotNull(constructor);
            arrayList3.add(memberDeserializer.loadConstructor(constructor, false));
        }
        return arrayList3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> getConstructors() {
        return this.constructors.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> getContextReceivers() {
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> listContextReceiverTypes = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.contextReceiverTypes(this.classProto, this.c.getTypeTable());
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listContextReceiverTypes, 10));
        java.util.Iterator<T> it = listContextReceiverTypes.iterator();
        while (it.hasNext()) {
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl(getThisAsReceiverParameter(), new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextClassReceiver(this, this.c.getTypeDeserializer().type((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) it.next()), null, null), kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor computeCompanionObjectDescriptor() {
        if (!this.classProto.hasCompanionObjectName()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1837getContributedClassifier = getMemberScope().mo1837getContributedClassifier(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(this.c.getNameResolver(), this.classProto.getCompanionObjectName()), kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION);
        if (classifierDescriptorMo1837getContributedClassifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1837getContributedClassifier;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getCompanionObjectDescriptor */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor mo1824getCompanionObjectDescriptor() {
        return this.companionObjectDescriptor.invoke();
    }

    public final boolean hasNestedClass$deserialization(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return getMemberScope().getClassNames$deserialization().contains(name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> computeSubclassesForSealedClass() {
        if (this.modality != kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.List<java.lang.Integer> sealedSubclassFqNameList = this.classProto.getSealedSubclassFqNameList();
        kotlin.jvm.internal.Intrinsics.checkNotNull(sealedSubclassFqNameList);
        if (sealedSubclassFqNameList.isEmpty()) {
            return kotlin.reflect.jvm.internal.impl.resolve.CliSealedClassInheritorsProvider.INSTANCE.computeSealedSubclasses(this, false);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Integer num : sealedSubclassFqNameList) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents components = this.c.getComponents();
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver = this.c.getNameResolver();
            kotlin.jvm.internal.Intrinsics.checkNotNull(num);
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorDeserializeClass = components.deserializeClass(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getClassId(nameResolver, num.intValue()));
            if (classDescriptorDeserializeClass != null) {
                arrayList.add(classDescriptorDeserializeClass);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> getValueClassRepresentation() {
        return this.valueClassRepresentation.invoke();
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$computeValueClassRepresentation$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    static final /* synthetic */ class AnonymousClass1 extends kotlin.jvm.internal.AdaptedFunctionReference implements kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type, kotlin.reflect.jvm.internal.impl.types.SimpleType> {
        AnonymousClass1(java.lang.Object obj) {
            super(1, obj, kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.class, "simpleType", "simpleType(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Type;Z)Lorg/jetbrains/kotlin/types/SimpleType;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final kotlin.reflect.jvm.internal.impl.types.SimpleType invoke2(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type p0) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
            return kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.simpleType$default((kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer) this.receiver, p0, false, 2, null);
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$computeValueClassRepresentation$2, reason: invalid class name */
    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    static final /* synthetic */ class AnonymousClass2 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.types.SimpleType> {
        AnonymousClass2(java.lang.Object obj) {
            super(1, obj, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.class, "getValueClassPropertyType", "getValueClassPropertyType(Lorg/jetbrains/kotlin/name/Name;)Lorg/jetbrains/kotlin/types/SimpleType;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final kotlin.reflect.jvm.internal.impl.types.SimpleType invoke2(kotlin.reflect.jvm.internal.impl.name.Name p0) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
            return ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) this.receiver).getValueClassPropertyType(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> computeValueClassRepresentation() {
        if (!isInline() && !isValue()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> valueClassRepresentationLoadValueClassRepresentation = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ValueClassUtilKt.loadValueClassRepresentation(this.classProto, this.c.getNameResolver(), this.c.getTypeTable(), new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.AnonymousClass1(this.c.getTypeDeserializer()), new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.AnonymousClass2(this));
        if (valueClassRepresentationLoadValueClassRepresentation != null) {
            return valueClassRepresentationLoadValueClassRepresentation;
        }
        if (this.metadataVersion.isAtLeast(1, 5, 1)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptorMo1825getUnsubstitutedPrimaryConstructor = mo1825getUnsubstitutedPrimaryConstructor();
        if (classConstructorDescriptorMo1825getUnsubstitutedPrimaryConstructor == null) {
            throw new java.lang.IllegalStateException(("Inline class has no primary constructor: " + this).toString());
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = classConstructorDescriptorMo1825getUnsubstitutedPrimaryConstructor.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        kotlin.reflect.jvm.internal.impl.name.Name name = ((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) kotlin.collections.CollectionsKt.first((java.util.List) valueParameters)).getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        kotlin.reflect.jvm.internal.impl.types.SimpleType valueClassPropertyType = getValueClassPropertyType(name);
        if (valueClassPropertyType == null) {
            throw new java.lang.IllegalStateException(("Value class has no underlying property: " + this).toString());
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation(name, valueClassPropertyType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.types.SimpleType getValueClassPropertyType(kotlin.reflect.jvm.internal.impl.name.Name name) {
        java.util.Iterator<T> it = getMemberScope().getContributedVariables(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION).iterator();
        boolean z = false;
        java.lang.Object obj = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z) {
                    break;
                }
                break;
            }
            java.lang.Object next = it.next();
            if (((kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) next).getExtensionReceiverParameter() == null) {
                if (!z) {
                    z = true;
                    obj = next;
                }
            }
            obj = null;
            break;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) obj;
        return (kotlin.reflect.jvm.internal.impl.types.SimpleType) (propertyDescriptor != null ? propertyDescriptor.getType() : null);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("deserialized ");
        sb.append(isExpect() ? "expect " : "");
        sb.append("class ");
        sb.append(getName());
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public kotlin.reflect.jvm.internal.impl.descriptors.SourceElement getSource() {
        return this.sourceElement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.c.getTypeDeserializer().getOwnTypeParameters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    final class DeserializedClassTypeConstructor extends kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor {
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor>> parameters;

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public DeserializedClassTypeConstructor() {
            super(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this.getC().getStorageManager());
            this.parameters = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this.getC().getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassTypeConstructor$$Lambda$0
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor arg$0;

                {
                    this.arg$0 = deserializedClassDescriptor;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassTypeConstructor.parameters$lambda$0(this.arg$0);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List parameters$lambda$0(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor) {
            return kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt.computeConstructorTypeParameters(deserializedClassDescriptor);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> computeSupertypes() {
            java.lang.String strAsString;
            kotlin.reflect.jvm.internal.impl.name.FqName fqNameAsSingleFqName;
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> listSupertypes = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.supertypes(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this.getClassProto(), kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this.getC().getTypeTable());
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this;
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listSupertypes, 10));
            java.util.Iterator<T> it = listSupertypes.iterator();
            while (it.hasNext()) {
                arrayList.add(deserializedClassDescriptor.getC().getTypeDeserializer().type((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) it.next()));
            }
            java.util.List listPlus = kotlin.collections.CollectionsKt.plus((java.util.Collection) arrayList, (java.lang.Iterable) kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this.getC().getComponents().getAdditionalClassPartsProvider().getSupertypes(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this));
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            java.util.Iterator it2 = listPlus.iterator();
            while (it2.hasNext()) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = ((kotlin.reflect.jvm.internal.impl.types.KotlinType) it2.next()).getConstructor().mo1835getDeclarationDescriptor();
                kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor mockClassDescriptor = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null;
                if (mockClassDescriptor != null) {
                    arrayList2.add(mockClassDescriptor);
                }
            }
            java.util.ArrayList arrayList3 = arrayList2;
            if (!arrayList3.isEmpty()) {
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter errorReporter = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this.getC().getComponents().getErrorReporter();
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this;
                java.util.ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor> arrayList4 = arrayList3;
                java.util.ArrayList arrayList5 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                for (kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor mockClassDescriptor2 : arrayList4) {
                    kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getClassId(mockClassDescriptor2);
                    if (classId == null || (fqNameAsSingleFqName = classId.asSingleFqName()) == null || (strAsString = fqNameAsSingleFqName.asString()) == null) {
                        strAsString = mockClassDescriptor2.getName().asString();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
                    }
                    arrayList5.add(strAsString);
                }
                errorReporter.reportIncompleteHierarchy(deserializedClassDescriptor2, arrayList5);
            }
            return kotlin.collections.CollectionsKt.toList(listPlus);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getParameters() {
            return this.parameters.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor mo1835getDeclarationDescriptor() {
            return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this;
        }

        public java.lang.String toString() {
            java.lang.String string = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this.getName().toString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker getSupertypeLoopChecker() {
            return kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    final class DeserializedClassMemberScope extends kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope {
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor>> allDescriptors;
        private final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner;
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType>> refinedSupertypes;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor this$0;

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List _init_$lambda$1$lambda$0(java.util.List list) {
            return list;
        }

        public DeserializedClassMemberScope(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.this$0 = deserializedClassDescriptor;
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext c = deserializedClassDescriptor.getC();
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> functionList = deserializedClassDescriptor.getClassProto().getFunctionList();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(functionList, "getFunctionList(...)");
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property> propertyList = deserializedClassDescriptor.getClassProto().getPropertyList();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyList, "getPropertyList(...)");
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias> typeAliasList = deserializedClassDescriptor.getClassProto().getTypeAliasList();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeAliasList, "getTypeAliasList(...)");
            java.util.List<java.lang.Integer> nestedClassNameList = deserializedClassDescriptor.getClassProto().getNestedClassNameList();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nestedClassNameList, "getNestedClassNameList(...)");
            java.util.List<java.lang.Integer> list = nestedClassNameList;
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver = deserializedClassDescriptor.getC().getNameResolver();
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
            java.util.Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(nameResolver, ((java.lang.Number) it.next()).intValue()));
            }
            final java.util.ArrayList arrayList2 = arrayList;
            super(c, functionList, propertyList, typeAliasList, new kotlin.jvm.functions.Function0(arrayList2) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$0
                private final java.util.List arg$0;

                {
                    this.arg$0 = arrayList2;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope._init_$lambda$1$lambda$0(this.arg$0);
                }
            });
            this.kotlinTypeRefiner = kotlinTypeRefiner;
            this.allDescriptors = getC().getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$1
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope.allDescriptors$lambda$2(this.arg$0);
                }
            });
            this.refinedSupertypes = getC().getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$$Lambda$2
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope.refinedSupertypes$lambda$3(this.arg$0);
                }
            });
        }

        private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor getClassDescriptor() {
            return this.this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Collection allDescriptors$lambda$2(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope deserializedClassMemberScope) {
            return deserializedClassMemberScope.computeDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.ALL, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Companion.getALL_NAME_FILTER(), kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Collection refinedSupertypes$lambda$3(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope deserializedClassMemberScope) {
            return deserializedClassMemberScope.kotlinTypeRefiner.refineSupertypes(deserializedClassMemberScope.getClassDescriptor());
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
            return this.allDescriptors.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
            mo1841recordLookup(name, location);
            return super.getContributedFunctions(name, location);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
            mo1841recordLookup(name, location);
            return super.getContributedVariables(name, location);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected boolean isDeclaredFunctionAvailable(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor function) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "function");
            return getC().getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable(this.this$0, function);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected void computeNonDeclaredFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> functions) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functions, "functions");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<kotlin.reflect.jvm.internal.impl.types.KotlinType> it = this.refinedSupertypes.invoke().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().getMemberScope().getContributedFunctions(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            functions.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctions(name, this.this$0));
            generateFakeOverrides(name, arrayList, functions);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected void computeNonDeclaredProperties(kotlin.reflect.jvm.internal.impl.name.Name name, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> descriptors) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptors, "descriptors");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<kotlin.reflect.jvm.internal.impl.types.KotlinType> it = this.refinedSupertypes.invoke().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().getMemberScope().getContributedVariables(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            generateFakeOverrides(name, arrayList, descriptors);
        }

        private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> void generateFakeOverrides(kotlin.reflect.jvm.internal.impl.name.Name name, java.util.Collection<? extends D> collection, final java.util.List<D> list) {
            getC().getComponents().getKotlinTypeChecker().getOverridingUtil().generateOverridesInFunctionGroup(name, collection, new java.util.ArrayList(list), getClassDescriptor(), new kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1
                /* JADX WARN: Type inference incomplete: some casts might be missing */
                @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
                public void addFakeOverride(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor fakeOverride) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fakeOverride, "fakeOverride");
                    kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.resolveUnknownVisibilityForMember(fakeOverride, null);
                    list.add((D) fakeOverride);
                }

                @Override // kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy
                protected void conflict(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor fromSuper, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor fromCurrent) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fromSuper, "fromSuper");
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fromCurrent, "fromCurrent");
                    if (fromCurrent instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl) {
                        ((kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl) fromCurrent).putInUserDataMap(kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDeclarationsFromSupertypeConflictDataKey.INSTANCE, fromSuper);
                    }
                }
            });
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getNonDeclaredFunctionNames() {
            java.util.List supertypes = getClassDescriptor().typeConstructor.mo1836getSupertypes();
            java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
            java.util.Iterator it = supertypes.iterator();
            while (it.hasNext()) {
                kotlin.collections.CollectionsKt.addAll(linkedHashSet, ((kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next()).getMemberScope().getFunctionNames());
            }
            linkedHashSet.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctionsNames(this.this$0));
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getNonDeclaredVariableNames() {
            java.util.List supertypes = getClassDescriptor().typeConstructor.mo1836getSupertypes();
            java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
            java.util.Iterator it = supertypes.iterator();
            while (it.hasNext()) {
                kotlin.collections.CollectionsKt.addAll(linkedHashSet, ((kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next()).getMemberScope().getVariableNames());
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getNonDeclaredClassifierNames() {
            java.util.List supertypes = getClassDescriptor().typeConstructor.mo1836getSupertypes();
            java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
            java.util.Iterator it = supertypes.iterator();
            while (it.hasNext()) {
                java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> classifierNames = ((kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next()).getMemberScope().getClassifierNames();
                if (classifierNames == null) {
                    linkedHashSet = null;
                    break;
                }
                kotlin.collections.CollectionsKt.addAll(linkedHashSet, classifierNames);
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        /* JADX INFO: renamed from: getContributedClassifier */
        public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1837getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorFindEnumEntry;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
            mo1841recordLookup(name, location);
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors = getClassDescriptor().enumEntries;
            return (enumEntryClassDescriptors == null || (classDescriptorFindEnumEntry = enumEntryClassDescriptors.findEnumEntry(name)) == null) ? super.mo1837getContributedClassifier(name, location) : classDescriptorFindEnumEntry;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected kotlin.reflect.jvm.internal.impl.name.ClassId createClassId(kotlin.reflect.jvm.internal.impl.name.Name name) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            return this.this$0.classId.createNestedClassId(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected void addEnumEntryDescriptors(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> result, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors = getClassDescriptor().enumEntries;
            java.util.List listAll = enumEntryClassDescriptors != null ? enumEntryClassDescriptors.all() : null;
            if (listAll == null) {
                listAll = kotlin.collections.CollectionsKt.emptyList();
            }
            result.addAll(listAll);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        /* JADX INFO: renamed from: recordLookup */
        public void mo1841recordLookup(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
            kotlin.reflect.jvm.internal.impl.incremental.UtilsKt.record(getC().getComponents().getLookupTracker(), location, getClassDescriptor(), name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    final class EnumEntryClassDescriptors {
        private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> enumEntryByName;
        private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry> enumEntryProtos;
        private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name>> enumMemberNames;

        public EnumEntryClassDescriptors() {
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry> enumEntryList = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this.getClassProto().getEnumEntryList();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(enumEntryList, "getEnumEntryList(...)");
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry> list = enumEntryList;
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(kotlin.ranges.RangesKt.coerceAtLeast(kotlin.collections.MapsKt.mapCapacity(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (java.lang.Object obj : list) {
                linkedHashMap.put(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this.getC().getNameResolver(), ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry) obj).getName()), obj);
            }
            this.enumEntryProtos = linkedHashMap;
            kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this.getC().getStorageManager();
            final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this;
            this.enumEntryByName = storageManager.createMemoizedFunctionWithNullableValues(new kotlin.jvm.functions.Function1(this, deserializedClassDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors$$Lambda$0
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.EnumEntryClassDescriptors arg$0;
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = deserializedClassDescriptor;
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj2) {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.EnumEntryClassDescriptors.enumEntryByName$lambda$3(this.arg$0, this.arg$1, (kotlin.reflect.jvm.internal.impl.name.Name) obj2);
                }
            });
            this.enumMemberNames = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this.getC().getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors$$Lambda$1
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.EnumEntryClassDescriptors arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return this.arg$0.computeEnumMemberNames();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor enumEntryByName$lambda$3(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors, final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor, kotlin.reflect.jvm.internal.impl.name.Name name) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry enumEntry = enumEntryClassDescriptors.enumEntryProtos.get(name);
            return enumEntry != null ? kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.create(deserializedClassDescriptor.getC().getStorageManager(), deserializedClassDescriptor, name, enumEntryClassDescriptors.enumMemberNames, new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations(deserializedClassDescriptor.getC().getStorageManager(), new kotlin.jvm.functions.Function0(deserializedClassDescriptor, enumEntry) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors$$Lambda$2
                private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor arg$0;
                private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry arg$1;

                {
                    this.arg$0 = deserializedClassDescriptor;
                    this.arg$1 = enumEntry;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.EnumEntryClassDescriptors.enumEntryByName$lambda$3$lambda$2$lambda$1(this.arg$0, this.arg$1);
                }
            }), kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE) : null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List enumEntryByName$lambda$3$lambda$2$lambda$1(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry enumEntry) {
            return kotlin.collections.CollectionsKt.toList(deserializedClassDescriptor.getC().getComponents().getAnnotationAndConstantLoader().loadEnumEntryAnnotations(deserializedClassDescriptor.getThisAsProtoContainer$deserialization(), enumEntry));
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor findEnumEntry(kotlin.reflect.jvm.internal.impl.name.Name name) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            return this.enumEntryByName.invoke2(name);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> computeEnumMemberNames() {
            java.util.HashSet hashSet = new java.util.HashSet();
            java.util.Iterator<kotlin.reflect.jvm.internal.impl.types.KotlinType> it = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this.getTypeConstructor().mo1836getSupertypes().iterator();
            while (it.hasNext()) {
                for (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor : kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls.getContributedDescriptors$default(it.next().getMemberScope(), null, null, 3, null)) {
                    if ((declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) || (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor)) {
                        hashSet.add(((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) declarationDescriptor).getName());
                    }
                }
            }
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> functionList = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this.getClassProto().getFunctionList();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(functionList, "getFunctionList(...)");
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this;
            java.util.Iterator<T> it2 = functionList.iterator();
            while (it2.hasNext()) {
                hashSet.add(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(deserializedClassDescriptor.getC().getNameResolver(), ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) it2.next()).getName()));
            }
            java.util.HashSet hashSet2 = hashSet;
            java.util.HashSet hashSet3 = hashSet2;
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property> propertyList = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this.getClassProto().getPropertyList();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyList, "getPropertyList(...)");
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.this;
            java.util.Iterator<T> it3 = propertyList.iterator();
            while (it3.hasNext()) {
                hashSet2.add(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(deserializedClassDescriptor2.getC().getNameResolver(), ((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) it3.next()).getName()));
            }
            return kotlin.collections.SetsKt.plus((java.util.Set) hashSet3, (java.lang.Iterable) hashSet2);
        }

        public final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> all() {
            java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> setKeySet = this.enumEntryProtos.keySet();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorFindEnumEntry = findEnumEntry((kotlin.reflect.jvm.internal.impl.name.Name) it.next());
                if (classDescriptorFindEnumEntry != null) {
                    arrayList.add(classDescriptorFindEnumEntry);
                }
            }
            return arrayList;
        }
    }
}
