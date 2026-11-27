package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeAliasConstructorDescriptorImpl extends kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl implements kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl.class, "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;", 0))};
    public static final kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl.Companion Companion = new kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl.Companion(null);
    private final kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager;
    private final kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor;
    private kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor underlyingConstructorDescriptor;
    private final kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue withDispatchReceiver$delegate;

    public /* synthetic */ TypeAliasConstructorDescriptorImpl(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, typeAliasDescriptor, classConstructorDescriptor, typeAliasConstructorDescriptor, annotations, kind, sourceElement);
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor getTypeAliasDescriptor() {
        return this.typeAliasDescriptor;
    }

    private TypeAliasConstructorDescriptorImpl(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor, final kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement) {
        super(typeAliasDescriptor, typeAliasConstructorDescriptor, annotations, kotlin.reflect.jvm.internal.impl.name.SpecialNames.INIT, kind, sourceElement);
        this.storageManager = storageManager;
        this.typeAliasDescriptor = typeAliasDescriptor;
        setActual(getTypeAliasDescriptor().isActual());
        this.withDispatchReceiver$delegate = storageManager.createNullableLazyValue(new kotlin.jvm.functions.Function0(this, classConstructorDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl arg$0;
            private final kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = classConstructorDescriptor;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl.withDispatchReceiver_delegate$lambda$2(this.arg$0, this.arg$1);
            }
        });
        this.underlyingConstructorDescriptor = classConstructorDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl withDispatchReceiver_delegate$lambda$2(kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations = classConstructorDescriptor.getAnnotations();
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind = classConstructorDescriptor.getKind();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kind, "getKind(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source = typeAliasConstructorDescriptorImpl.getTypeAliasDescriptor().getSource();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(source, "getSource(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl2 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl(typeAliasConstructorDescriptorImpl.storageManager, typeAliasConstructorDescriptorImpl.getTypeAliasDescriptor(), classConstructorDescriptor, typeAliasConstructorDescriptorImpl, annotations, kind, source);
        kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutorForUnderlyingClass = Companion.getTypeSubstitutorForUnderlyingClass(typeAliasConstructorDescriptorImpl.getTypeAliasDescriptor());
        if (typeSubstitutorForUnderlyingClass == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor dispatchReceiverParameter = classConstructorDescriptor.getDispatchReceiverParameter();
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptorSubstitute = dispatchReceiverParameter != null ? dispatchReceiverParameter.substitute(typeSubstitutorForUnderlyingClass) : null;
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> contextReceiverParameters = classConstructorDescriptor.getContextReceiverParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "getContextReceiverParameters(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> list = contextReceiverParameters;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor) it.next()).substitute(typeSubstitutorForUnderlyingClass));
        }
        typeAliasConstructorDescriptorImpl2.initialize(null, receiverParameterDescriptorSubstitute, arrayList, typeAliasConstructorDescriptorImpl.getTypeAliasDescriptor().getDeclaredTypeParameters(), typeAliasConstructorDescriptorImpl.getValueParameters(), typeAliasConstructorDescriptorImpl.getReturnType(), kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL, typeAliasConstructorDescriptorImpl.getTypeAliasDescriptor().getVisibility());
        return typeAliasConstructorDescriptorImpl2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor getUnderlyingConstructorDescriptor() {
        return this.underlyingConstructorDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public boolean isPrimary() {
        return getUnderlyingConstructorDescriptor().isPrimary();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor getContainingDeclaration() {
        return getTypeAliasDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getConstructedClass() {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor constructedClass = getUnderlyingConstructorDescriptor().getConstructedClass();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(constructedClass, "getConstructedClass(...)");
        return constructedClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getReturnType() {
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = super.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(returnType);
        return returnType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor getOriginal() {
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor original = super.getOriginal();
        kotlin.jvm.internal.Intrinsics.checkNotNull(original, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor) original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor substitute(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor substitutor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(substitutor, "substitutor");
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptorSubstitute = super.substitute(substitutor);
        kotlin.jvm.internal.Intrinsics.checkNotNull(functionDescriptorSubstitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = (kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl) functionDescriptorSubstitute;
        kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutorCreate = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.create(typeAliasConstructorDescriptorImpl.getReturnType());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeSubstitutorCreate, "create(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptorSubstitute = getUnderlyingConstructorDescriptor().getOriginal().substitute(typeSubstitutorCreate);
        if (classConstructorDescriptorSubstitute == null) {
            return null;
        }
        typeAliasConstructorDescriptorImpl.underlyingConstructorDescriptor = classConstructorDescriptorSubstitute;
        return typeAliasConstructorDescriptorImpl;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor copy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor newOwner, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(modality, "modality");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visibility, "visibility");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptorBuild = newCopyBuilder().setOwner(newOwner).setModality(modality).setVisibility(visibility).setKind(kind).setCopyOverrides(z).build();
        kotlin.jvm.internal.Intrinsics.checkNotNull(functionDescriptorBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor) functionDescriptorBuild;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl createSubstitutedCopy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor newOwner, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        if (kind != kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION) {
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind2 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.SYNTHESIZED;
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl(this.storageManager, getTypeAliasDescriptor(), getUnderlyingConstructorDescriptor(), this, annotations, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION, source);
    }

    /* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor getTypeSubstitutorForUnderlyingClass(kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor) {
            if (typeAliasDescriptor.getClassDescriptor() == null) {
                return null;
            }
            return kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.create(typeAliasDescriptor.getExpandedType());
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor createIfAvailable(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor constructor) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptorSubstitute;
            java.util.ArrayList arrayListEmptyList;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAliasDescriptor, "typeAliasDescriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "constructor");
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutorForUnderlyingClass = getTypeSubstitutorForUnderlyingClass(typeAliasDescriptor);
            if (typeSubstitutorForUnderlyingClass == null || (classConstructorDescriptorSubstitute = constructor.substitute(typeSubstitutorForUnderlyingClass)) == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations = constructor.getAnnotations();
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind = constructor.getKind();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kind, "getKind(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source = typeAliasDescriptor.getSource();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(source, "getSource(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = new kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl(storageManager, typeAliasDescriptor, classConstructorDescriptorSubstitute, null, annotations, kind, source, null);
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> substitutedValueParameters = kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.getSubstitutedValueParameters(typeAliasConstructorDescriptorImpl, constructor.getValueParameters(), typeSubstitutorForUnderlyingClass);
            if (substitutedValueParameters == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeLowerIfFlexible = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.lowerIfFlexible(classConstructorDescriptorSubstitute.getReturnType().unwrap());
            kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = typeAliasDescriptor.getDefaultType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeWithAbbreviation = kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.withAbbreviation(simpleTypeLowerIfFlexible, defaultType);
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor dispatchReceiverParameter = constructor.getDispatchReceiverParameter();
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptorCreateExtensionReceiverParameterForCallable = dispatchReceiverParameter != null ? kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createExtensionReceiverParameterForCallable(typeAliasConstructorDescriptorImpl, typeSubstitutorForUnderlyingClass.safeSubstitute(dispatchReceiverParameter.getType(), kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT), kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY()) : null;
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = typeAliasDescriptor.getClassDescriptor();
            if (classDescriptor != null) {
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> contextReceiverParameters = constructor.getContextReceiverParameters();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "getContextReceiverParameters(...)");
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> list = contextReceiverParameters;
                java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
                int i = 0;
                for (java.lang.Object obj : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        kotlin.collections.CollectionsKt.throwIndexOverflow();
                    }
                    kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor) obj;
                    kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSafeSubstitute = typeSubstitutorForUnderlyingClass.safeSubstitute(receiverParameterDescriptor.getType(), kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT);
                    kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue value = receiverParameterDescriptor.getValue();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(value, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.receivers.ImplicitContextReceiver");
                    arrayList.add(kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createContextReceiverParameterForClass(classDescriptor, kotlinTypeSafeSubstitute, ((kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver) value).getCustomLabelName(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), i));
                    i = i2;
                }
                arrayListEmptyList = arrayList;
            } else {
                arrayListEmptyList = kotlin.collections.CollectionsKt.emptyList();
            }
            typeAliasConstructorDescriptorImpl.initialize(receiverParameterDescriptorCreateExtensionReceiverParameterForCallable, null, arrayListEmptyList, typeAliasDescriptor.getDeclaredTypeParameters(), substitutedValueParameters, simpleTypeWithAbbreviation, kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL, typeAliasDescriptor.getVisibility());
            return typeAliasConstructorDescriptorImpl;
        }
    }
}
