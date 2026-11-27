package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FunctionDescriptorImpl extends kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl implements kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor {
    private java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> contextReceiverParameters;
    private kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor dispatchReceiverParameter;
    private kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor extensionReceiverParameter;
    private boolean hasStableParameterNames;
    private boolean hasSynthesizedParameterNames;
    private kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor initialSignatureDescriptor;
    private boolean isActual;
    private boolean isExpect;
    private boolean isExternal;
    private boolean isHiddenForResolutionEverywhereBesideSupercalls;
    private boolean isHiddenToOvercomeSignatureClash;
    private boolean isInfix;
    private boolean isInline;
    private boolean isOperator;
    private boolean isSuspend;
    private boolean isTailrec;
    private final kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind;
    private volatile kotlin.jvm.functions.Function0<java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor>> lazyOverriddenFunctionsTask;
    private kotlin.reflect.jvm.internal.impl.descriptors.Modality modality;
    private final kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor original;
    private java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> overriddenFunctions;
    private java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters;
    private kotlin.reflect.jvm.internal.impl.types.KotlinType unsubstitutedReturnType;
    private java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> unsubstitutedValueParameters;
    protected java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<?>, java.lang.Object> userDataMap;
    private kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.String str;
        int i2;
        switch (i) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                i2 = 2;
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                i2 = 3;
                break;
        }
        java.lang.Object[] objArr = new java.lang.Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "contextReceiverParameters";
                break;
            case 6:
                objArr[0] = "typeParameters";
                break;
            case 7:
            case 28:
            case 30:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 8:
            case 10:
                objArr[0] = com.taobao.weex.common.Constants.Name.VISIBILITY;
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 11:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 12:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 17:
                objArr[0] = "overriddenDescriptors";
                break;
            case 22:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
            case 29:
            case 31:
                objArr[0] = "substitutor";
                break;
            case 25:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 9:
                objArr[1] = "initialize";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 14:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 15:
                objArr[1] = "getModality";
                break;
            case 16:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getTypeParameters";
                break;
            case 19:
                objArr[1] = "getValueParameters";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getKind";
                break;
            case 23:
                objArr[1] = "newCopyBuilder";
                break;
            case 26:
                objArr[1] = "copy";
                break;
            case 27:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                break;
            case 10:
                objArr[2] = "setVisibility";
                break;
            case 11:
                objArr[2] = "setReturnType";
                break;
            case 12:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 17:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 22:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "newCopyBuilder";
                break;
            case 25:
                objArr[2] = "doSubstitute";
                break;
            case 28:
            case 29:
            case 30:
            case 31:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        java.lang.String str2 = java.lang.String.format(str, objArr);
        switch (i) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                throw new java.lang.IllegalStateException(str2);
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                throw new java.lang.IllegalArgumentException(str2);
        }
    }

    protected abstract kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl createSubstitutedCopy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected FunctionDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement) {
        super(declarationDescriptor, annotations, name, sourceElement);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (name == null) {
            $$$reportNull$$$0(2);
        }
        if (kind == null) {
            $$$reportNull$$$0(3);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(4);
        }
        this.visibility = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.UNKNOWN;
        this.isOperator = false;
        this.isInfix = false;
        this.isExternal = false;
        this.isInline = false;
        this.isTailrec = false;
        this.isExpect = false;
        this.isActual = false;
        this.isHiddenToOvercomeSignatureClash = false;
        this.isHiddenForResolutionEverywhereBesideSupercalls = false;
        this.isSuspend = false;
        this.hasStableParameterNames = true;
        this.hasSynthesizedParameterNames = false;
        this.overriddenFunctions = null;
        this.lazyOverriddenFunctionsTask = null;
        this.initialSignatureDescriptor = null;
        this.userDataMap = null;
        this.original = functionDescriptor == null ? this : functionDescriptor;
        this.kind = kind;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl initialize(kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor2, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> list, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list2, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list3, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility) {
        if (list == null) {
            $$$reportNull$$$0(5);
        }
        if (list2 == null) {
            $$$reportNull$$$0(6);
        }
        if (list3 == null) {
            $$$reportNull$$$0(7);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(8);
        }
        this.typeParameters = kotlin.collections.CollectionsKt.toList(list2);
        this.unsubstitutedValueParameters = kotlin.collections.CollectionsKt.toList(list3);
        this.unsubstitutedReturnType = kotlinType;
        this.modality = modality;
        this.visibility = descriptorVisibility;
        this.extensionReceiverParameter = receiverParameterDescriptor;
        this.dispatchReceiverParameter = receiverParameterDescriptor2;
        this.contextReceiverParameters = list;
        for (int i = 0; i < list2.size(); i++) {
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = list2.get(i);
            if (typeParameterDescriptor.getIndex() != i) {
                throw new java.lang.IllegalStateException(typeParameterDescriptor + " index is " + typeParameterDescriptor.getIndex() + " but position is " + i);
            }
        }
        for (int i2 = 0; i2 < list3.size(); i2++) {
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor = list3.get(i2);
            if (valueParameterDescriptor.getIndex() != i2) {
                throw new java.lang.IllegalStateException(valueParameterDescriptor + "index is " + valueParameterDescriptor.getIndex() + " but position is " + i2);
            }
        }
        return this;
    }

    public void setVisibility(kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility) {
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(10);
        }
        this.visibility = descriptorVisibility;
    }

    public void setOperator(boolean z) {
        this.isOperator = z;
    }

    public void setInfix(boolean z) {
        this.isInfix = z;
    }

    public void setExternal(boolean z) {
        this.isExternal = z;
    }

    public void setInline(boolean z) {
        this.isInline = z;
    }

    public void setTailrec(boolean z) {
        this.isTailrec = z;
    }

    public void setExpect(boolean z) {
        this.isExpect = z;
    }

    public void setActual(boolean z) {
        this.isActual = z;
    }

    private void setHiddenToOvercomeSignatureClash(boolean z) {
        this.isHiddenToOvercomeSignatureClash = z;
    }

    private void setHiddenForResolutionEverywhereBesideSupercalls(boolean z) {
        this.isHiddenForResolutionEverywhereBesideSupercalls = z;
    }

    public void setSuspend(boolean z) {
        this.isSuspend = z;
    }

    public void setReturnType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(11);
        }
        this.unsubstitutedReturnType = kotlinType;
    }

    public void setHasStableParameterNames(boolean z) {
        this.hasStableParameterNames = z;
    }

    public void setHasSynthesizedParameterNames(boolean z) {
        this.hasSynthesizedParameterNames = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> getContextReceiverParameters() {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> list = this.contextReceiverParameters;
        if (list == null) {
            $$$reportNull$$$0(13);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    public java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> getOverriddenDescriptors() {
        performOverriddenLazyCalculationIfNeeded();
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> collection = this.overriddenFunctions;
        if (collection == null) {
            collection = java.util.Collections.EMPTY_LIST;
        }
        if (collection == null) {
            $$$reportNull$$$0(14);
        }
        return collection;
    }

    private void performOverriddenLazyCalculationIfNeeded() {
        kotlin.jvm.functions.Function0<java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor>> function0 = this.lazyOverriddenFunctionsTask;
        if (function0 != null) {
            this.overriddenFunctions = function0.invoke();
            this.lazyOverriddenFunctionsTask = null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.Modality getModality() {
        kotlin.reflect.jvm.internal.impl.descriptors.Modality modality = this.modality;
        if (modality == null) {
            $$$reportNull$$$0(15);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility = this.visibility;
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(16);
        }
        return descriptorVisibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isOperator() {
        if (this.isOperator) {
            return true;
        }
        java.util.Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> it = getOriginal().getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            if (it.next().isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInfix() {
        if (this.isInfix) {
            return true;
        }
        java.util.Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> it = getOriginal().getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            if (it.next().isInfix()) {
                return true;
            }
        }
        return false;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    public boolean isInline() {
        return this.isInline;
    }

    public boolean isTailrec() {
        return this.isTailrec;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return this.isSuspend;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.isExpect;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.isActual;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<V> userDataKey) {
        java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<?>, java.lang.Object> map = this.userDataMap;
        if (map == null) {
            return null;
        }
        return (V) map.get(userDataKey);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenToOvercomeSignatureClash() {
        return this.isHiddenToOvercomeSignatureClash;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOverriddenDescriptors(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> collection) {
        if (collection == 0) {
            $$$reportNull$$$0(17);
        }
        this.overriddenFunctions = collection;
        java.util.Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) it.next()).isHiddenForResolutionEverywhereBesideSupercalls()) {
                this.isHiddenForResolutionEverywhereBesideSupercalls = true;
                return;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getTypeParameters() {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list = this.typeParameters;
        if (list != null) {
            if (list == null) {
                $$$reportNull$$$0(18);
            }
            return list;
        }
        throw new java.lang.IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> getValueParameters() {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list = this.unsubstitutedValueParameters;
        if (list == null) {
            $$$reportNull$$$0(19);
        }
        return list;
    }

    public boolean hasStableParameterNames() {
        return this.hasStableParameterNames;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.hasSynthesizedParameterNames;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getReturnType() {
        return this.unsubstitutedReturnType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor getOriginal() {
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor = this.original;
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor original = functionDescriptor == this ? this : functionDescriptor.getOriginal();
        if (original == null) {
            $$$reportNull$$$0(20);
        }
        return original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind getKind() {
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind = this.kind;
        if (kind == null) {
            $$$reportNull$$$0(21);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor substitute(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(22);
        }
        return typeSubstitutor.isEmpty() ? this : newCopyBuilder(typeSubstitutor).setOriginal((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) getOriginal()).setPreserveSourceElement().setJustForTypeSubstitution(true).build();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.isHiddenForResolutionEverywhereBesideSupercalls;
    }

    public class CopyConfiguration implements kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> {
        private kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations additionalAnnotations;
        protected boolean copyOverrides;
        protected kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor dispatchReceiverParameter;
        protected boolean dropOriginalInContainingParts;
        private boolean isHiddenForResolutionEverywhereBesideSupercalls;
        private boolean isHiddenToOvercomeSignatureClash;
        protected boolean justForTypeSubstitution;
        protected kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind;
        protected kotlin.reflect.jvm.internal.impl.name.Name name;
        protected java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> newContextReceiverParameters;
        protected kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor newExtensionReceiverParameter;
        private java.lang.Boolean newHasSynthesizedParameterNames;
        protected kotlin.reflect.jvm.internal.impl.descriptors.Modality newModality;
        protected kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor newOwner;
        protected kotlin.reflect.jvm.internal.impl.types.KotlinType newReturnType;
        private java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> newTypeParameters;
        protected java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> newValueParameterDescriptors;
        protected kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility newVisibility;
        protected kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor original;
        protected boolean preserveSourceElement;
        protected boolean signatureChange;
        protected kotlin.reflect.jvm.internal.impl.types.TypeSubstitution substitution;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl this$0;
        private java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<?>, java.lang.Object> userDataMap;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.String str;
            int i2;
            switch (i) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    i2 = 2;
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    i2 = 3;
                    break;
            }
            java.lang.Object[] objArr = new java.lang.Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 14:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newContextReceiverParameters";
                    break;
                case 7:
                    objArr[0] = "newReturnType";
                    break;
                case 8:
                    objArr[0] = "owner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[0] = "modality";
                    break;
                case 12:
                    objArr[0] = com.taobao.weex.common.Constants.Name.VISIBILITY;
                    break;
                case 17:
                    objArr[0] = "name";
                    break;
                case 19:
                case 21:
                    objArr[0] = "parameters";
                    break;
                case 23:
                    objArr[0] = "type";
                    break;
                case 25:
                    objArr[0] = "contextReceiverParameters";
                    break;
                case 35:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 37:
                default:
                    objArr[0] = "substitution";
                    break;
                case 39:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i) {
                case 9:
                    objArr[1] = "setOwner";
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 11:
                    objArr[1] = "setModality";
                    break;
                case 13:
                    objArr[1] = "setVisibility";
                    break;
                case 15:
                    objArr[1] = "setKind";
                    break;
                case 16:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 18:
                    objArr[1] = "setName";
                    break;
                case 20:
                    objArr[1] = "setValueParameters";
                    break;
                case 22:
                    objArr[1] = "setTypeParameters";
                    break;
                case 24:
                    objArr[1] = "setReturnType";
                    break;
                case 26:
                    objArr[1] = "setContextReceiverParameters";
                    break;
                case 27:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 28:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 29:
                    objArr[1] = "setOriginal";
                    break;
                case 30:
                    objArr[1] = "setSignatureChange";
                    break;
                case 31:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 32:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 33:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 34:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 36:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 38:
                    objArr[1] = "setSubstitution";
                    break;
                case 40:
                    objArr[1] = "putUserData";
                    break;
                case 41:
                    objArr[1] = "getSubstitution";
                    break;
                case 42:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i) {
                case 8:
                    objArr[2] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    break;
                case 10:
                    objArr[2] = "setModality";
                    break;
                case 12:
                    objArr[2] = "setVisibility";
                    break;
                case 14:
                    objArr[2] = "setKind";
                    break;
                case 17:
                    objArr[2] = "setName";
                    break;
                case 19:
                    objArr[2] = "setValueParameters";
                    break;
                case 21:
                    objArr[2] = "setTypeParameters";
                    break;
                case 23:
                    objArr[2] = "setReturnType";
                    break;
                case 25:
                    objArr[2] = "setContextReceiverParameters";
                    break;
                case 35:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 37:
                    objArr[2] = "setSubstitution";
                    break;
                case 39:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            java.lang.String str2 = java.lang.String.format(str, objArr);
            switch (i) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    throw new java.lang.IllegalStateException(str2);
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    throw new java.lang.IllegalArgumentException(str2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder setTypeParameters(java.util.List list) {
            return setTypeParameters((java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor>) list);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder setValueParameters(java.util.List list) {
            return setValueParameters((java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor>) list);
        }

        public CopyConfiguration(kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl functionDescriptorImpl, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution typeSubstitution, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> list2, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.name.Name name) {
            if (typeSubstitution == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            if (modality == null) {
                $$$reportNull$$$0(2);
            }
            if (descriptorVisibility == null) {
                $$$reportNull$$$0(3);
            }
            if (kind == null) {
                $$$reportNull$$$0(4);
            }
            if (list == null) {
                $$$reportNull$$$0(5);
            }
            if (list2 == null) {
                $$$reportNull$$$0(6);
            }
            if (kotlinType == null) {
                $$$reportNull$$$0(7);
            }
            this.this$0 = functionDescriptorImpl;
            this.original = null;
            this.dispatchReceiverParameter = functionDescriptorImpl.dispatchReceiverParameter;
            this.copyOverrides = true;
            this.signatureChange = false;
            this.preserveSourceElement = false;
            this.dropOriginalInContainingParts = false;
            this.isHiddenToOvercomeSignatureClash = functionDescriptorImpl.isHiddenToOvercomeSignatureClash();
            this.newTypeParameters = null;
            this.additionalAnnotations = null;
            this.isHiddenForResolutionEverywhereBesideSupercalls = functionDescriptorImpl.isHiddenForResolutionEverywhereBesideSupercalls();
            this.userDataMap = new java.util.LinkedHashMap();
            this.newHasSynthesizedParameterNames = null;
            this.justForTypeSubstitution = false;
            this.substitution = typeSubstitution;
            this.newOwner = declarationDescriptor;
            this.newModality = modality;
            this.newVisibility = descriptorVisibility;
            this.kind = kind;
            this.newValueParameterDescriptors = list;
            this.newContextReceiverParameters = list2;
            this.newExtensionReceiverParameter = receiverParameterDescriptor;
            this.newReturnType = kotlinType;
            this.name = name;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setOwner(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(8);
            }
            this.newOwner = declarationDescriptor;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setModality(kotlin.reflect.jvm.internal.impl.descriptors.Modality modality) {
            if (modality == null) {
                $$$reportNull$$$0(10);
            }
            this.newModality = modality;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setVisibility(kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility) {
            if (descriptorVisibility == null) {
                $$$reportNull$$$0(12);
            }
            this.newVisibility = descriptorVisibility;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setKind(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                $$$reportNull$$$0(14);
            }
            this.kind = kind;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setCopyOverrides(boolean z) {
            this.copyOverrides = z;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setName(kotlin.reflect.jvm.internal.impl.name.Name name) {
            if (name == null) {
                $$$reportNull$$$0(17);
            }
            this.name = name;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setValueParameters(java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list) {
            if (list == null) {
                $$$reportNull$$$0(19);
            }
            this.newValueParameterDescriptors = list;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setTypeParameters(java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list) {
            if (list == null) {
                $$$reportNull$$$0(21);
            }
            this.newTypeParameters = list;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setReturnType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
            if (kotlinType == null) {
                $$$reportNull$$$0(23);
            }
            this.newReturnType = kotlinType;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setExtensionReceiverParameter(kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.newExtensionReceiverParameter = receiverParameterDescriptor;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setDispatchReceiverParameter(kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.dispatchReceiverParameter = receiverParameterDescriptor;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setOriginal(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
            this.original = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) callableMemberDescriptor;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setSignatureChange() {
            this.signatureChange = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setPreserveSourceElement() {
            this.preserveSourceElement = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setDropOriginalInContainingParts() {
            this.dropOriginalInContainingParts = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setHiddenToOvercomeSignatureClash() {
            this.isHiddenToOvercomeSignatureClash = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setHiddenForResolutionEverywhereBesideSupercalls() {
            this.isHiddenForResolutionEverywhereBesideSupercalls = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setAdditionalAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations) {
            if (annotations == null) {
                $$$reportNull$$$0(35);
            }
            this.additionalAnnotations = annotations;
            return this;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setHasSynthesizedParameterNames(boolean z) {
            this.newHasSynthesizedParameterNames = java.lang.Boolean.valueOf(z);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setSubstitution(kotlin.reflect.jvm.internal.impl.types.TypeSubstitution typeSubstitution) {
            if (typeSubstitution == null) {
                $$$reportNull$$$0(37);
            }
            this.substitution = typeSubstitution;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public <V> kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> putUserData(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<V> userDataKey, V v) {
            if (userDataKey == null) {
                $$$reportNull$$$0(39);
            }
            this.userDataMap.put(userDataKey, v);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor build() {
            return this.this$0.doSubstitute(this);
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration setJustForTypeSubstitution(boolean z) {
            this.justForTypeSubstitution = z;
            return this;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> newCopyBuilder() {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration copyConfigurationNewCopyBuilder = newCopyBuilder(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.EMPTY);
        if (copyConfigurationNewCopyBuilder == null) {
            $$$reportNull$$$0(23);
        }
        return copyConfigurationNewCopyBuilder;
    }

    protected kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration newCopyBuilder(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(24);
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration(this, typeSubstitutor.getSubstitution(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), getContextReceiverParameters(), getExtensionReceiverParameter(), getReturnType(), null);
    }

    protected kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor doSubstitute(kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration copyConfiguration) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl;
        if (copyConfiguration == null) {
            $$$reportNull$$$0(25);
        }
        boolean[] zArr = new boolean[1];
        if (copyConfiguration.additionalAnnotations != null) {
            annotations = kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt.composeAnnotations(getAnnotations(), copyConfiguration.additionalAnnotations);
        } else {
            annotations = getAnnotations();
        }
        kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl functionDescriptorImplCreateSubstitutedCopy = createSubstitutedCopy(copyConfiguration.newOwner, copyConfiguration.original, copyConfiguration.kind, copyConfiguration.name, annotations, getSourceToUseForCopy(copyConfiguration.preserveSourceElement, copyConfiguration.original));
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters = copyConfiguration.newTypeParameters == null ? getTypeParameters() : copyConfiguration.newTypeParameters;
        zArr[0] = zArr[0] | (!typeParameters.isEmpty());
        java.util.ArrayList arrayList = new java.util.ArrayList(typeParameters.size());
        final kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutorSubstituteTypeParameters = kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor.substituteTypeParameters(typeParameters, copyConfiguration.substitution, functionDescriptorImplCreateSubstitutedCopy, arrayList, zArr);
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor = null;
        if (typeSubstitutorSubstituteTypeParameters == null) {
            return null;
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        if (!copyConfiguration.newContextReceiverParameters.isEmpty()) {
            int i = 0;
            for (kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor2 : copyConfiguration.newContextReceiverParameters) {
                kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSubstitute = typeSubstitutorSubstituteTypeParameters.substitute(receiverParameterDescriptor2.getType(), kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE);
                if (kotlinTypeSubstitute == null) {
                    return null;
                }
                int i2 = i + 1;
                arrayList2.add(kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createContextReceiverParameterForCallable(functionDescriptorImplCreateSubstitutedCopy, kotlinTypeSubstitute, ((kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver) receiverParameterDescriptor2.getValue()).getCustomLabelName(), receiverParameterDescriptor2.getAnnotations(), i));
                zArr[0] = zArr[0] | (kotlinTypeSubstitute != receiverParameterDescriptor2.getType());
                i = i2;
            }
        }
        if (copyConfiguration.newExtensionReceiverParameter != null) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSubstitute2 = typeSubstitutorSubstituteTypeParameters.substitute(copyConfiguration.newExtensionReceiverParameter.getType(), kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE);
            if (kotlinTypeSubstitute2 == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl2 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl(functionDescriptorImplCreateSubstitutedCopy, new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver(functionDescriptorImplCreateSubstitutedCopy, kotlinTypeSubstitute2, copyConfiguration.newExtensionReceiverParameter.getValue()), copyConfiguration.newExtensionReceiverParameter.getAnnotations());
            zArr[0] = (kotlinTypeSubstitute2 != copyConfiguration.newExtensionReceiverParameter.getType()) | zArr[0];
            receiverParameterDescriptorImpl = receiverParameterDescriptorImpl2;
        } else {
            receiverParameterDescriptorImpl = null;
        }
        if (copyConfiguration.dispatchReceiverParameter != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptorSubstitute = copyConfiguration.dispatchReceiverParameter.substitute(typeSubstitutorSubstituteTypeParameters);
            if (receiverParameterDescriptorSubstitute == null) {
                return null;
            }
            zArr[0] = zArr[0] | (receiverParameterDescriptorSubstitute != copyConfiguration.dispatchReceiverParameter);
            receiverParameterDescriptor = receiverParameterDescriptorSubstitute;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> substitutedValueParameters = getSubstitutedValueParameters(functionDescriptorImplCreateSubstitutedCopy, copyConfiguration.newValueParameterDescriptors, typeSubstitutorSubstituteTypeParameters, copyConfiguration.dropOriginalInContainingParts, copyConfiguration.preserveSourceElement, zArr);
        if (substitutedValueParameters == null) {
            return 0;
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSubstitute3 = typeSubstitutorSubstituteTypeParameters.substitute(copyConfiguration.newReturnType, kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE);
        if (kotlinTypeSubstitute3 == null) {
            return receiverParameterDescriptor;
        }
        boolean z = zArr[0] | (kotlinTypeSubstitute3 != copyConfiguration.newReturnType);
        zArr[0] = z;
        if (!z && copyConfiguration.justForTypeSubstitution) {
            return this;
        }
        functionDescriptorImplCreateSubstitutedCopy.initialize(receiverParameterDescriptorImpl, receiverParameterDescriptor, arrayList2, arrayList, substitutedValueParameters, kotlinTypeSubstitute3, copyConfiguration.newModality, copyConfiguration.newVisibility);
        functionDescriptorImplCreateSubstitutedCopy.setOperator(this.isOperator);
        functionDescriptorImplCreateSubstitutedCopy.setInfix(this.isInfix);
        functionDescriptorImplCreateSubstitutedCopy.setExternal(this.isExternal);
        functionDescriptorImplCreateSubstitutedCopy.setInline(this.isInline);
        functionDescriptorImplCreateSubstitutedCopy.setTailrec(this.isTailrec);
        functionDescriptorImplCreateSubstitutedCopy.setSuspend(this.isSuspend);
        functionDescriptorImplCreateSubstitutedCopy.setExpect(this.isExpect);
        functionDescriptorImplCreateSubstitutedCopy.setActual(this.isActual);
        functionDescriptorImplCreateSubstitutedCopy.setHasStableParameterNames(this.hasStableParameterNames);
        functionDescriptorImplCreateSubstitutedCopy.setHiddenToOvercomeSignatureClash(copyConfiguration.isHiddenToOvercomeSignatureClash);
        functionDescriptorImplCreateSubstitutedCopy.setHiddenForResolutionEverywhereBesideSupercalls(copyConfiguration.isHiddenForResolutionEverywhereBesideSupercalls);
        functionDescriptorImplCreateSubstitutedCopy.setHasSynthesizedParameterNames(copyConfiguration.newHasSynthesizedParameterNames != null ? copyConfiguration.newHasSynthesizedParameterNames.booleanValue() : this.hasSynthesizedParameterNames);
        if (!copyConfiguration.userDataMap.isEmpty() || this.userDataMap != null) {
            java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<?>, java.lang.Object> map = copyConfiguration.userDataMap;
            java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<?>, java.lang.Object> map2 = this.userDataMap;
            if (map2 != null) {
                for (java.util.Map.Entry<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<?>, java.lang.Object> entry : map2.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                functionDescriptorImplCreateSubstitutedCopy.userDataMap = java.util.Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                functionDescriptorImplCreateSubstitutedCopy.userDataMap = map;
            }
        }
        if (copyConfiguration.signatureChange || getInitialSignatureDescriptor() != null) {
            functionDescriptorImplCreateSubstitutedCopy.setInitialSignatureDescriptor((getInitialSignatureDescriptor() != null ? getInitialSignatureDescriptor() : this).substitute(typeSubstitutorSubstituteTypeParameters));
        }
        if (copyConfiguration.copyOverrides && !getOriginal().getOverriddenDescriptors().isEmpty()) {
            if (copyConfiguration.substitution.isEmpty()) {
                kotlin.jvm.functions.Function0<java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor>> function0 = this.lazyOverriddenFunctionsTask;
                if (function0 != null) {
                    functionDescriptorImplCreateSubstitutedCopy.lazyOverriddenFunctionsTask = function0;
                    return functionDescriptorImplCreateSubstitutedCopy;
                }
                functionDescriptorImplCreateSubstitutedCopy.setOverriddenDescriptors(getOverriddenDescriptors());
                return functionDescriptorImplCreateSubstitutedCopy;
            }
            functionDescriptorImplCreateSubstitutedCopy.lazyOverriddenFunctionsTask = new kotlin.jvm.functions.Function0<java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.1
                @Override // kotlin.jvm.functions.Function0
                public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> invoke() {
                    kotlin.reflect.jvm.internal.impl.utils.SmartList smartList = new kotlin.reflect.jvm.internal.impl.utils.SmartList();
                    java.util.Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> it = kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.this.getOverriddenDescriptors().iterator();
                    while (it.hasNext()) {
                        smartList.add(it.next().substitute(typeSubstitutorSubstituteTypeParameters));
                    }
                    return smartList;
                }
            };
        }
        return functionDescriptorImplCreateSubstitutedCopy;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor copy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, boolean z) {
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptorBuild = newCopyBuilder().setOwner(declarationDescriptor).setModality(modality).setVisibility(descriptorVisibility).setKind(kind).setCopyOverrides(z).build();
        if (functionDescriptorBuild == null) {
            $$$reportNull$$$0(26);
        }
        return functionDescriptorBuild;
    }

    private kotlin.reflect.jvm.internal.impl.descriptors.SourceElement getSourceToUseForCopy(boolean z, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source;
        if (z) {
            if (functionDescriptor == null) {
                functionDescriptor = getOriginal();
            }
            source = functionDescriptor.getSource();
        } else {
            source = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
        }
        if (source == null) {
            $$$reportNull$$$0(27);
        }
        return source;
    }

    public <R, D> R accept(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitFunctionDescriptor(this, d);
    }

    public static java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> getSubstitutedValueParameters(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list, kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutor) {
        if (list == null) {
            $$$reportNull$$$0(28);
        }
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(29);
        }
        return getSubstitutedValueParameters(functionDescriptor, list, typeSubstitutor, false, false, null);
    }

    public static java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> getSubstitutedValueParameters(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list, kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutor, boolean z, boolean z2, boolean[] zArr) {
        kotlin.jvm.functions.Function0<java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor>> function0;
        if (list == null) {
            $$$reportNull$$$0(30);
        }
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(31);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        for (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor : list) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSubstitute = typeSubstitutor.substitute(valueParameterDescriptor.getType(), kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE);
            kotlin.reflect.jvm.internal.impl.types.KotlinType varargElementType = valueParameterDescriptor.getVarargElementType();
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSubstitute2 = varargElementType == null ? null : typeSubstitutor.substitute(varargElementType, kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE);
            if (kotlinTypeSubstitute == null) {
                return null;
            }
            if ((kotlinTypeSubstitute != valueParameterDescriptor.getType() || varargElementType != kotlinTypeSubstitute2) && zArr != null) {
                zArr[0] = true;
            }
            if (valueParameterDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.WithDestructuringDeclaration) {
                final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor> destructuringVariables = ((kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.WithDestructuringDeclaration) valueParameterDescriptor).getDestructuringVariables();
                function0 = new kotlin.jvm.functions.Function0<java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.2
                    @Override // kotlin.jvm.functions.Function0
                    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor> invoke() {
                        return destructuringVariables;
                    }
                };
            } else {
                function0 = null;
            }
            arrayList.add(kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.createWithDestructuringDeclarations(functionDescriptor, z ? null : valueParameterDescriptor, valueParameterDescriptor.getIndex(), valueParameterDescriptor.getAnnotations(), valueParameterDescriptor.getName(), kotlinTypeSubstitute, valueParameterDescriptor.declaresDefaultValue(), valueParameterDescriptor.isCrossinline(), valueParameterDescriptor.isNoinline(), kotlinTypeSubstitute2, z2 ? valueParameterDescriptor.getSource() : kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE, function0));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor getInitialSignatureDescriptor() {
        return this.initialSignatureDescriptor;
    }

    private void setInitialSignatureDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor) {
        this.initialSignatureDescriptor = functionDescriptor;
    }

    public <V> void putInUserDataMap(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<V> userDataKey, java.lang.Object obj) {
        if (this.userDataMap == null) {
            this.userDataMap = new java.util.LinkedHashMap();
        }
        this.userDataMap.put(userDataKey, obj);
    }
}
