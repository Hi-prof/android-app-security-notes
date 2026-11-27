package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractTypeAliasDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl implements kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor.class, "constructors", "getConstructors()Ljava/util/Collection;", 0))};
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue constructors$delegate;
    private java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> declaredTypeParametersImpl;
    private final kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager;
    private final kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$typeConstructor$1 typeConstructor;
    private final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibilityImpl;

    protected abstract java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getTypeConstructorTypeParameters();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    protected final kotlin.reflect.jvm.internal.impl.storage.StorageManager getStorageManager() {
        return this.storageManager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$typeConstructor$1] */
    public AbstractTypeAliasDescriptor(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibilityImpl) {
        super(containingDeclaration, annotations, name, sourceElement);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceElement, "sourceElement");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visibilityImpl, "visibilityImpl");
        this.storageManager = storageManager;
        this.visibilityImpl = visibilityImpl;
        this.constructors$delegate = storageManager.createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return this.arg$0.getTypeAliasConstructors();
            }
        });
        this.typeConstructor = new kotlin.reflect.jvm.internal.impl.types.TypeConstructor() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$typeConstructor$1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public boolean isDenotable() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            /* JADX INFO: renamed from: getDeclarationDescriptor */
            public kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor mo1835getDeclarationDescriptor() {
                return this.this$0;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getParameters() {
                return this.this$0.getTypeConstructorTypeParameters();
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            /* JADX INFO: renamed from: getSupertypes */
            public java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> mo1836getSupertypes() {
                java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = mo1835getDeclarationDescriptor().getUnderlyingType().getConstructor().mo1836getSupertypes();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionMo1836getSupertypes, "getSupertypes(...)");
                return collectionMo1836getSupertypes;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns getBuiltIns() {
                return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(mo1835getDeclarationDescriptor());
            }

            public java.lang.String toString() {
                return "[typealias " + mo1835getDeclarationDescriptor().getName().asString() + com.taobao.weex.el.parse.Operators.ARRAY_END;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public kotlin.reflect.jvm.internal.impl.types.TypeConstructor refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
                return this;
            }
        };
    }

    public final void initialize(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> declaredTypeParameters) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declaredTypeParameters, "declaredTypeParameters");
        this.declaredTypeParametersImpl = declaredTypeParameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor<R, D> visitor, D d) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visitor, "visitor");
        return visitor.visitTypeAliasDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return kotlin.reflect.jvm.internal.impl.types.TypeUtils.contains(getUnderlyingType(), new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor.isInner$lambda$2(this.arg$0, (kotlin.reflect.jvm.internal.impl.types.UnwrappedType) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:9:0x0026  */
    public static final java.lang.Boolean isInner$lambda$2(kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor abstractTypeAliasDescriptor, kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType) {
        boolean z;
        kotlin.jvm.internal.Intrinsics.checkNotNull(unwrappedType);
        if (kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(unwrappedType)) {
            z = false;
        } else {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = unwrappedType.getConstructor().mo1835getDeclarationDescriptor();
            if (!(classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) || kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) classifierDescriptorMo1835getDeclarationDescriptor).getContainingDeclaration(), abstractTypeAliasDescriptor)) {
                z = false;
            } else {
                z = true;
            }
        }
        return java.lang.Boolean.valueOf(z);
    }

    public final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor> getTypeAliasConstructors() {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = getClassDescriptor();
        if (classDescriptor == null) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> constructors = classDescriptor.getConstructors();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(constructors, "getConstructors(...)");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptor : constructors) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(classConstructorDescriptor);
            kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor typeAliasConstructorDescriptorCreateIfAvailable = kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl.Companion.createIfAvailable(this.storageManager, this, classConstructorDescriptor);
            if (typeAliasConstructorDescriptorCreateIfAvailable != null) {
                arrayList.add(typeAliasConstructorDescriptorCreateIfAvailable);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getDeclaredTypeParameters() {
        java.util.List list = this.declaredTypeParametersImpl;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("declaredTypeParametersImpl");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.Modality getModality() {
        return kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility getVisibility() {
        return this.visibilityImpl;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public kotlin.reflect.jvm.internal.impl.types.TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public java.lang.String toString() {
        return "typealias " + getName().asString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor getOriginal() {
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource original = super.getOriginal();
        kotlin.jvm.internal.Intrinsics.checkNotNull(original, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
        return (kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) original;
    }

    protected final kotlin.reflect.jvm.internal.impl.types.SimpleType computeDefaultType() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty unsubstitutedMemberScope;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor abstractTypeAliasDescriptor = this;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = getClassDescriptor();
        if (classDescriptor == null || (unsubstitutedMemberScope = classDescriptor.getUnsubstitutedMemberScope()) == null) {
            unsubstitutedMemberScope = kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty.INSTANCE;
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeMakeUnsubstitutedType = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeUnsubstitutedType(abstractTypeAliasDescriptor, unsubstitutedMemberScope, (kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.SimpleType>) new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor.computeDefaultType$lambda$4(this.arg$0, (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) obj);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(simpleTypeMakeUnsubstitutedType, "makeUnsubstitutedType(...)");
        return simpleTypeMakeUnsubstitutedType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType computeDefaultType$lambda$4(kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor abstractTypeAliasDescriptor, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorRefineDescriptor = kotlinTypeRefiner.refineDescriptor(abstractTypeAliasDescriptor);
        if (classifierDescriptorRefineDescriptor != null) {
            return classifierDescriptorRefineDescriptor.getDefaultType();
        }
        return null;
    }
}
