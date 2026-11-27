package kotlin.reflect.jvm.internal.impl.types.error;

/* JADX INFO: compiled from: ErrorFunctionDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ErrorFunctionDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl {
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<V> key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> overriddenDescriptors) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(overriddenDescriptors, "overriddenDescriptors");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorFunctionDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor containingDeclaration) {
        super(containingDeclaration, null, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), kotlin.reflect.jvm.internal.impl.name.Name.special(kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity.ERROR_FUNCTION.getDebugText()), kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        initialize((kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor) null, (kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor) null, kotlin.collections.CollectionsKt.emptyList(), kotlin.collections.CollectionsKt.emptyList(), kotlin.collections.CollectionsKt.emptyList(), (kotlin.reflect.jvm.internal.impl.types.KotlinType) kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.RETURN_TYPE_FOR_FUNCTION, new java.lang.String[0]), kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl createSubstitutedCopy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor newOwner, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor copy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor newOwner, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(modality, "modality");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visibility, "visibility");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> newCopyBuilder() {
        return new kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.types.error.ErrorFunctionDescriptor.newCopyBuilder.1
            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setOwner(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor owner) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(owner, "owner");
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setModality(kotlin.reflect.jvm.internal.impl.descriptors.Modality modality) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(modality, "modality");
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setVisibility(kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visibility, "visibility");
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setKind(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setCopyOverrides(boolean z) {
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setName(kotlin.reflect.jvm.internal.impl.name.Name name) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setSubstitution(kotlin.reflect.jvm.internal.impl.types.TypeSubstitution substitution) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(substitution, "substitution");
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setValueParameters(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> parameters) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameters, "parameters");
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public <V> kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> putUserData(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<V> userDataKey, V v) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(userDataKey, "userDataKey");
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setTypeParameters(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameters, "parameters");
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setReturnType(kotlin.reflect.jvm.internal.impl.types.KotlinType type) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setExtensionReceiverParameter(kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor) {
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setDispatchReceiverParameter(kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor) {
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setOriginal(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setSignatureChange() {
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setPreserveSourceElement() {
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setDropOriginalInContainingParts() {
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setHiddenToOvercomeSignatureClash() {
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setHiddenForResolutionEverywhereBesideSupercalls() {
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> setAdditionalAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations additionalAnnotations) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(additionalAnnotations, "additionalAnnotations");
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
            public kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor build() {
                return kotlin.reflect.jvm.internal.impl.types.error.ErrorFunctionDescriptor.this;
            }
        };
    }
}
