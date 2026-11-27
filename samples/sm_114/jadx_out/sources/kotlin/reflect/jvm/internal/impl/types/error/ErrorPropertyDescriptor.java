package kotlin.reflect.jvm.internal.impl.types.error;

/* JADX INFO: compiled from: ErrorPropertyDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ErrorPropertyDescriptor implements kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor {
    private final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl $$delegate_0;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return (R) this.$$delegate_0.accept(declarationDescriptorVisitor, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor copy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, boolean z) {
        kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptorCopy = this.$$delegate_0.copy(declarationDescriptor, modality, descriptorVisibility, kind, z);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyDescriptorCopy, "copy(...)");
        return propertyDescriptorCopy;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor> getAccessors() {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor> accessors = this.$$delegate_0.getAccessors();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(accessors, "getAccessors(...)");
        return accessors;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations = this.$$delegate_0.getAnnotations();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotations, "<get-annotations>(...)");
        return annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor getBackingField() {
        return this.$$delegate_0.getBackingField();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    /* JADX INFO: renamed from: getCompileTimeInitializer */
    public kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> mo1827getCompileTimeInitializer() {
        return this.$$delegate_0.mo1827getCompileTimeInitializer();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor getContainingDeclaration() {
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = this.$$delegate_0.getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
        return containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> getContextReceiverParameters() {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> contextReceiverParameters = this.$$delegate_0.getContextReceiverParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "getContextReceiverParameters(...)");
        return contextReceiverParameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor getDelegateField() {
        return this.$$delegate_0.getDelegateField();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.$$delegate_0.getDispatchReceiverParameter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.$$delegate_0.getExtensionReceiverParameter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor getGetter() {
        return this.$$delegate_0.getGetter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind getKind() {
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind = this.$$delegate_0.getKind();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kind, "getKind(...)");
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.Modality getModality() {
        kotlin.reflect.jvm.internal.impl.descriptors.Modality modality = this.$$delegate_0.getModality();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(modality, "getModality(...)");
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public kotlin.reflect.jvm.internal.impl.name.Name getName() {
        kotlin.reflect.jvm.internal.impl.name.Name name = this.$$delegate_0.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor getOriginal() {
        kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor original = this.$$delegate_0.getOriginal();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(original, "getOriginal(...)");
        return original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getOverriddenDescriptors() {
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> overriddenDescriptors = this.$$delegate_0.getOverriddenDescriptors();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        return overriddenDescriptors;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getReturnType() {
        return this.$$delegate_0.getReturnType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor getSetter() {
        return this.$$delegate_0.getSetter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public kotlin.reflect.jvm.internal.impl.descriptors.SourceElement getSource() {
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source = this.$$delegate_0.getSource();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(source, "getSource(...)");
        return source;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueDescriptor
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getType() {
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = this.$$delegate_0.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getTypeParameters() {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters = this.$$delegate_0.getTypeParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
        return typeParameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<V> userDataKey) {
        return (V) this.$$delegate_0.getUserData(userDataKey);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> getValueParameters() {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = this.$$delegate_0.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        return valueParameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility = this.$$delegate_0.getVisibility();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
        return visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.$$delegate_0.hasSynthesizedParameterNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.$$delegate_0.isActual();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        return this.$$delegate_0.isConst();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors
    public boolean isDelegated() {
        return this.$$delegate_0.isDelegated();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.$$delegate_0.isExpect();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.$$delegate_0.isExternal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return this.$$delegate_0.isLateInit();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isVar() {
        return this.$$delegate_0.isVar();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> overriddenDescriptors) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(overriddenDescriptors, "overriddenDescriptors");
        this.$$delegate_0.setOverriddenDescriptors(overriddenDescriptors);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor substitute(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor substitutor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(substitutor, "substitutor");
        return this.$$delegate_0.substitute(substitutor);
    }

    public ErrorPropertyDescriptor() {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl propertyDescriptorImplCreate = kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.create(kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE.getErrorClass(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC, true, kotlin.reflect.jvm.internal.impl.name.Name.special(kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity.ERROR_PROPERTY.getDebugText()), kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE, false, false, false, false, false, false);
        propertyDescriptorImplCreate.setType(kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE.getErrorPropertyType(), kotlin.collections.CollectionsKt.emptyList(), null, null, kotlin.collections.CollectionsKt.emptyList());
        this.$$delegate_0 = propertyDescriptorImplCreate;
    }
}
