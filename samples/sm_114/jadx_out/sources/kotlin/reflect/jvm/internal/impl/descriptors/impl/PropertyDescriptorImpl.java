package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: loaded from: classes2.dex */
public class PropertyDescriptorImpl extends kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorWithInitializerImpl implements kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor {
    private kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor backingField;
    private java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> contextReceiverParameters;
    private kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor delegateField;
    private kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor dispatchReceiverParameter;
    private kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor extensionReceiverParameter;
    private kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl getter;
    private final boolean isActual;
    private final boolean isConst;
    private final boolean isDelegated;
    private final boolean isExpect;
    private final boolean isExternal;
    private final kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind;
    private final boolean lateInit;
    private final kotlin.reflect.jvm.internal.impl.descriptors.Modality modality;
    private final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor original;
    private java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> overriddenProperties;
    private kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor setter;
    private boolean setterProjectedOut;
    private java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters;
    private kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility;

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    /* JADX WARN: Code duplicated, block: B:19:0x002c  */
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.String str;
        int i2;
        if (i != 28 && i != 38 && i != 39 && i != 41 && i != 42) {
            switch (i) {
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 28 && i != 38 && i != 39 && i != 41 && i != 42) {
            switch (i) {
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
        } else {
            i2 = 2;
        }
        java.lang.Object[] objArr = new java.lang.Object[i2];
        switch (i) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
            case 20:
                objArr[0] = com.taobao.weex.common.Constants.Name.VISIBILITY;
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 35:
                objArr[0] = "kind";
                break;
            case 6:
            case 13:
            case 37:
                objArr[0] = "source";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 14:
                objArr[0] = "inType";
                break;
            case 15:
            case 17:
                objArr[0] = "outType";
                break;
            case 16:
            case 18:
                objArr[0] = "typeParameters";
                break;
            case 19:
                objArr[0] = "contextReceiverParameters";
                break;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 28:
            case 38:
            case 39:
            case 41:
            case 42:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                break;
            case 27:
                objArr[0] = "originalSubstitutor";
                break;
            case 29:
                objArr[0] = "copyConfiguration";
                break;
            case 30:
                objArr[0] = "substitutor";
                break;
            case 31:
                objArr[0] = "accessorDescriptor";
                break;
            case 32:
                objArr[0] = "newOwner";
                break;
            case 33:
                objArr[0] = "newModality";
                break;
            case 34:
                objArr[0] = "newVisibility";
                break;
            case 36:
                objArr[0] = "newName";
                break;
            case 40:
                objArr[0] = "overriddenDescriptors";
                break;
        }
        if (i == 28) {
            objArr[1] = "getSourceToUseForCopy";
        } else if (i == 38) {
            objArr[1] = "getOriginal";
        } else if (i == 39) {
            objArr[1] = "getKind";
        } else if (i == 41) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i != 42) {
            switch (i) {
                case 21:
                    objArr[1] = "getTypeParameters";
                    break;
                case 22:
                    objArr[1] = "getContextReceiverParameters";
                    break;
                case 23:
                    objArr[1] = "getReturnType";
                    break;
                case 24:
                    objArr[1] = "getModality";
                    break;
                case 25:
                    objArr[1] = "getVisibility";
                    break;
                case 26:
                    objArr[1] = "getAccessors";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                    break;
            }
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[2] = "create";
                break;
            case 14:
                objArr[2] = "setInType";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "setType";
                break;
            case 20:
                objArr[2] = "setVisibility";
                break;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 28:
            case 38:
            case 39:
            case 41:
            case 42:
                break;
            case 27:
                objArr[2] = "substitute";
                break;
            case 29:
                objArr[2] = "doSubstitute";
                break;
            case 30:
            case 31:
                objArr[2] = "getSubstitutedInitialSignatureDescriptor";
                break;
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 40:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        java.lang.String str2 = java.lang.String.format(str, objArr);
        if (i != 28 && i != 38 && i != 39 && i != 41 && i != 42) {
            switch (i) {
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    break;
                default:
                    throw new java.lang.IllegalArgumentException(str2);
            }
        }
        throw new java.lang.IllegalStateException(str2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<V> userDataKey) {
        return null;
    }

    public void setInType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(14);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected PropertyDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility, boolean z, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        super(declarationDescriptor, annotations, name, null, z, sourceElement);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (modality == null) {
            $$$reportNull$$$0(2);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(3);
        }
        if (name == null) {
            $$$reportNull$$$0(4);
        }
        if (kind == null) {
            $$$reportNull$$$0(5);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(6);
        }
        this.overriddenProperties = null;
        this.contextReceiverParameters = java.util.Collections.EMPTY_LIST;
        this.modality = modality;
        this.visibility = descriptorVisibility;
        this.original = propertyDescriptor == null ? this : propertyDescriptor;
        this.kind = kind;
        this.lateInit = z2;
        this.isConst = z3;
        this.isExpect = z4;
        this.isActual = z5;
        this.isExternal = z6;
        this.isDelegated = z7;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl create(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility, boolean z, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(7);
        }
        if (annotations == null) {
            $$$reportNull$$$0(8);
        }
        if (modality == null) {
            $$$reportNull$$$0(9);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(10);
        }
        if (name == null) {
            $$$reportNull$$$0(11);
        }
        if (kind == null) {
            $$$reportNull$$$0(12);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(13);
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl(declarationDescriptor, null, annotations, modality, descriptorVisibility, z, name, kind, sourceElement, z2, z3, z4, z5, z6, z7);
    }

    public void setType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor2, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> list2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(17);
        }
        if (list == null) {
            $$$reportNull$$$0(18);
        }
        if (list2 == null) {
            $$$reportNull$$$0(19);
        }
        setOutType(kotlinType);
        this.typeParameters = new java.util.ArrayList(list);
        this.extensionReceiverParameter = receiverParameterDescriptor2;
        this.dispatchReceiverParameter = receiverParameterDescriptor;
        this.contextReceiverParameters = list2;
    }

    public void initialize(kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor propertySetterDescriptor) {
        initialize(propertyGetterDescriptorImpl, propertySetterDescriptor, null, null);
    }

    public void initialize(kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor propertySetterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor fieldDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor fieldDescriptor2) {
        this.getter = propertyGetterDescriptorImpl;
        this.setter = propertySetterDescriptor;
        this.backingField = fieldDescriptor;
        this.delegateField = fieldDescriptor2;
    }

    public void setSetterProjectedOut(boolean z) {
        this.setterProjectedOut = z;
    }

    public void setVisibility(kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility) {
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(20);
        }
        this.visibility = descriptorVisibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getTypeParameters() {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list = this.typeParameters;
        if (list != null) {
            if (list == null) {
                $$$reportNull$$$0(21);
            }
            return list;
        }
        throw new java.lang.IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> getContextReceiverParameters() {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> list = this.contextReceiverParameters;
        if (list == null) {
            $$$reportNull$$$0(22);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getReturnType() {
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = getType();
        if (type == null) {
            $$$reportNull$$$0(23);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.Modality getModality() {
        kotlin.reflect.jvm.internal.impl.descriptors.Modality modality = this.modality;
        if (modality == null) {
            $$$reportNull$$$0(24);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility = this.visibility;
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(25);
        }
        return descriptorVisibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl getGetter() {
        return this.getter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor getSetter() {
        return this.setter;
    }

    public boolean isSetterProjectedOut() {
        return this.setterProjectedOut;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return this.lateInit;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        return this.isConst;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.isExternal;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors
    public boolean isDelegated() {
        return this.isDelegated;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor> getAccessors() {
        java.util.ArrayList arrayList = new java.util.ArrayList(2);
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = this.getter;
        if (propertyGetterDescriptorImpl != null) {
            arrayList.add(propertyGetterDescriptorImpl);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor propertySetterDescriptor = this.setter;
        if (propertySetterDescriptor != null) {
            arrayList.add(propertySetterDescriptor);
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor substitute(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(27);
        }
        return typeSubstitutor.isEmpty() ? this : newCopyBuilder().setSubstitution(typeSubstitutor.getSubstitution()).setOriginal(getOriginal()).build();
    }

    public class CopyConfiguration {
        private kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor dispatchReceiverParameter;
        private kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind;
        private kotlin.reflect.jvm.internal.impl.descriptors.Modality modality;
        private kotlin.reflect.jvm.internal.impl.name.Name name;
        private kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor owner;
        private kotlin.reflect.jvm.internal.impl.types.KotlinType returnType;
        private kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility;
        private kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor original = null;
        private boolean preserveSourceElement = false;
        private kotlin.reflect.jvm.internal.impl.types.TypeSubstitution substitution = kotlin.reflect.jvm.internal.impl.types.TypeSubstitution.EMPTY;
        private boolean copyOverrides = true;
        private java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> newTypeParameters = null;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.String str = (i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            java.lang.Object[] objArr = new java.lang.Object[(i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = com.taobao.weex.common.Constants.Name.VISIBILITY;
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i == 1) {
                objArr[1] = "setOwner";
            } else if (i == 2) {
                objArr[1] = "setOriginal";
            } else if (i == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i == 5) {
                objArr[1] = "setReturnType";
            } else if (i == 7) {
                objArr[1] = "setModality";
            } else if (i == 9) {
                objArr[1] = "setVisibility";
            } else if (i == 11) {
                objArr[1] = "setKind";
            } else if (i == 19) {
                objArr[1] = "setName";
            } else if (i == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i == 16) {
                objArr[1] = "setSubstitution";
            } else if (i != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            java.lang.String str2 = java.lang.String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 5 && i != 7 && i != 9 && i != 11 && i != 19 && i != 13 && i != 14 && i != 16 && i != 17) {
                throw new java.lang.IllegalArgumentException(str2);
            }
            throw new java.lang.IllegalStateException(str2);
        }

        public CopyConfiguration() {
            this.owner = kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.this.getContainingDeclaration();
            this.modality = kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.this.getModality();
            this.visibility = kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.this.getVisibility();
            this.kind = kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.this.getKind();
            this.dispatchReceiverParameter = kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.this.dispatchReceiverParameter;
            this.name = kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.this.getName();
            this.returnType = kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.this.getType();
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.CopyConfiguration setOwner(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(0);
            }
            this.owner = declarationDescriptor;
            return this;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.CopyConfiguration setOriginal(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
            this.original = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) callableMemberDescriptor;
            return this;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.CopyConfiguration setModality(kotlin.reflect.jvm.internal.impl.descriptors.Modality modality) {
            if (modality == null) {
                $$$reportNull$$$0(6);
            }
            this.modality = modality;
            return this;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.CopyConfiguration setVisibility(kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility) {
            if (descriptorVisibility == null) {
                $$$reportNull$$$0(8);
            }
            this.visibility = descriptorVisibility;
            return this;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.CopyConfiguration setKind(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                $$$reportNull$$$0(10);
            }
            this.kind = kind;
            return this;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.CopyConfiguration setSubstitution(kotlin.reflect.jvm.internal.impl.types.TypeSubstitution typeSubstitution) {
            if (typeSubstitution == null) {
                $$$reportNull$$$0(15);
            }
            this.substitution = typeSubstitution;
            return this;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.CopyConfiguration setCopyOverrides(boolean z) {
            this.copyOverrides = z;
            return this;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor build() {
            return kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.this.doSubstitute(this);
        }

        kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor getOriginalGetter() {
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor = this.original;
            if (propertyDescriptor == null) {
                return null;
            }
            return propertyDescriptor.getGetter();
        }

        kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor getOriginalSetter() {
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor = this.original;
            if (propertyDescriptor == null) {
                return null;
            }
            return propertyDescriptor.getSetter();
        }
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.CopyConfiguration newCopyBuilder() {
        return new kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.CopyConfiguration();
    }

    private kotlin.reflect.jvm.internal.impl.descriptors.SourceElement getSourceToUseForCopy(boolean z, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source;
        if (z) {
            if (propertyDescriptor == null) {
                propertyDescriptor = getOriginal();
            }
            source = propertyDescriptor.getSource();
        } else {
            source = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
        }
        if (source == null) {
            $$$reportNull$$$0(28);
        }
        return source;
    }

    protected kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor doSubstitute(kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.CopyConfiguration copyConfiguration) {
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor;
        if (copyConfiguration == null) {
            $$$reportNull$$$0(29);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl propertyDescriptorImplCreateSubstitutedCopy = createSubstitutedCopy(copyConfiguration.owner, copyConfiguration.modality, copyConfiguration.visibility, copyConfiguration.original, copyConfiguration.kind, copyConfiguration.name, getSourceToUseForCopy(copyConfiguration.preserveSourceElement, copyConfiguration.original));
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters = copyConfiguration.newTypeParameters == null ? getTypeParameters() : copyConfiguration.newTypeParameters;
        java.util.ArrayList arrayList = new java.util.ArrayList(typeParameters.size());
        kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutorSubstituteTypeParameters = kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor.substituteTypeParameters(typeParameters, copyConfiguration.substitution, propertyDescriptorImplCreateSubstitutedCopy, arrayList);
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType = copyConfiguration.returnType;
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSubstitute = typeSubstitutorSubstituteTypeParameters.substitute(kotlinType, kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE);
        if (kotlinTypeSubstitute == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSubstitute2 = typeSubstitutorSubstituteTypeParameters.substitute(kotlinType, kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE);
        if (kotlinTypeSubstitute2 != null) {
            propertyDescriptorImplCreateSubstitutedCopy.setInType(kotlinTypeSubstitute2);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor2 = copyConfiguration.dispatchReceiverParameter;
        if (receiverParameterDescriptor2 != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptorSubstitute = receiverParameterDescriptor2.substitute(typeSubstitutorSubstituteTypeParameters);
            if (receiverParameterDescriptorSubstitute == null) {
                return null;
            }
            receiverParameterDescriptor = receiverParameterDescriptorSubstitute;
        } else {
            receiverParameterDescriptor = null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor3 = this.extensionReceiverParameter;
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptorSubstituteParameterDescriptor = receiverParameterDescriptor3 != null ? substituteParameterDescriptor(typeSubstitutorSubstituteTypeParameters, propertyDescriptorImplCreateSubstitutedCopy, receiverParameterDescriptor3) : null;
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> it = this.contextReceiverParameters.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptorSubstituteContextParameterDescriptor = substituteContextParameterDescriptor(typeSubstitutorSubstituteTypeParameters, propertyDescriptorImplCreateSubstitutedCopy, it.next());
            if (receiverParameterDescriptorSubstituteContextParameterDescriptor != null) {
                arrayList2.add(receiverParameterDescriptorSubstituteContextParameterDescriptor);
            }
        }
        propertyDescriptorImplCreateSubstitutedCopy.setType(kotlinTypeSubstitute, arrayList, receiverParameterDescriptor, receiverParameterDescriptorSubstituteParameterDescriptor, arrayList2);
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = this.getter == null ? null : new kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl(propertyDescriptorImplCreateSubstitutedCopy, this.getter.getAnnotations(), copyConfiguration.modality, normalizeVisibility(this.getter.getVisibility(), copyConfiguration.kind), this.getter.isDefault(), this.getter.isExternal(), this.getter.isInline(), copyConfiguration.kind, copyConfiguration.getOriginalGetter(), kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE);
        if (propertyGetterDescriptorImpl != null) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = this.getter.getReturnType();
            propertyGetterDescriptorImpl.setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(typeSubstitutorSubstituteTypeParameters, this.getter));
            propertyGetterDescriptorImpl.initialize(returnType != null ? typeSubstitutorSubstituteTypeParameters.substitute(returnType, kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE) : null);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl propertySetterDescriptorImpl = this.setter == null ? null : new kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl(propertyDescriptorImplCreateSubstitutedCopy, this.setter.getAnnotations(), copyConfiguration.modality, normalizeVisibility(this.setter.getVisibility(), copyConfiguration.kind), this.setter.isDefault(), this.setter.isExternal(), this.setter.isInline(), copyConfiguration.kind, copyConfiguration.getOriginalSetter(), kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE);
        if (propertySetterDescriptorImpl != null) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> substitutedValueParameters = kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.getSubstitutedValueParameters(propertySetterDescriptorImpl, this.setter.getValueParameters(), typeSubstitutorSubstituteTypeParameters, false, false, null);
            if (substitutedValueParameters == null) {
                propertyDescriptorImplCreateSubstitutedCopy.setSetterProjectedOut(true);
                substitutedValueParameters = java.util.Collections.singletonList(kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl.createSetterParameter(propertySetterDescriptorImpl, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(copyConfiguration.owner).getNothingType(), this.setter.getValueParameters().get(0).getAnnotations()));
            }
            if (substitutedValueParameters.size() != 1) {
                throw new java.lang.IllegalStateException();
            }
            propertySetterDescriptorImpl.setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(typeSubstitutorSubstituteTypeParameters, this.setter));
            propertySetterDescriptorImpl.initialize(substitutedValueParameters.get(0));
        }
        propertyDescriptorImplCreateSubstitutedCopy.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, this.backingField == null ? null : new kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl(this.backingField.getAnnotations(), propertyDescriptorImplCreateSubstitutedCopy), this.delegateField == null ? null : new kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl(this.delegateField.getAnnotations(), propertyDescriptorImplCreateSubstitutedCopy));
        if (copyConfiguration.copyOverrides) {
            kotlin.reflect.jvm.internal.impl.utils.SmartSet smartSetCreate = kotlin.reflect.jvm.internal.impl.utils.SmartSet.create();
            java.util.Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> it2 = getOverriddenDescriptors().iterator();
            while (it2.hasNext()) {
                smartSetCreate.add(it2.next().substitute(typeSubstitutorSubstituteTypeParameters));
            }
            propertyDescriptorImplCreateSubstitutedCopy.setOverriddenDescriptors(smartSetCreate);
        }
        if (isConst() && this.compileTimeInitializerFactory != null) {
            propertyDescriptorImplCreateSubstitutedCopy.setCompileTimeInitializer(this.compileTimeInitializer, this.compileTimeInitializerFactory);
        }
        return propertyDescriptorImplCreateSubstitutedCopy;
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility normalizeVisibility(kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind) {
        return (kind == kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE && kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.isPrivate(descriptorVisibility.normalize())) ? kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INVISIBLE_FAKE : descriptorVisibility;
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor substituteParameterDescriptor(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutor, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSubstitute = typeSubstitutor.substitute(receiverParameterDescriptor.getType(), kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE);
        if (kotlinTypeSubstitute == null) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl(propertyDescriptor, new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver(propertyDescriptor, kotlinTypeSubstitute, receiverParameterDescriptor.getValue()), receiverParameterDescriptor.getAnnotations());
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor substituteContextParameterDescriptor(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutor, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSubstitute = typeSubstitutor.substitute(receiverParameterDescriptor.getType(), kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE);
        if (kotlinTypeSubstitute == null) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl(propertyDescriptor, new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextReceiver(propertyDescriptor, kotlinTypeSubstitute, ((kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver) receiverParameterDescriptor.getValue()).getCustomLabelName(), receiverParameterDescriptor.getValue()), receiverParameterDescriptor.getAnnotations());
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor getSubstitutedInitialSignatureDescriptor(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutor, kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor propertyAccessorDescriptor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(30);
        }
        if (propertyAccessorDescriptor == null) {
            $$$reportNull$$$0(31);
        }
        if (propertyAccessorDescriptor.getInitialSignatureDescriptor() != null) {
            return propertyAccessorDescriptor.getInitialSignatureDescriptor().substitute(typeSubstitutor);
        }
        return null;
    }

    protected kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl createSubstitutedCopy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(32);
        }
        if (modality == null) {
            $$$reportNull$$$0(33);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(34);
        }
        if (kind == null) {
            $$$reportNull$$$0(35);
        }
        if (name == null) {
            $$$reportNull$$$0(36);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(37);
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl(declarationDescriptor, propertyDescriptor, getAnnotations(), modality, descriptorVisibility, isVar(), name, kind, sourceElement, isLateInit(), isConst(), isExpect(), isActual(), isExternal(), isDelegated());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitPropertyDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor getOriginal() {
        kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor = this.original;
        kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor original = propertyDescriptor == this ? this : propertyDescriptor.getOriginal();
        if (original == null) {
            $$$reportNull$$$0(38);
        }
        return original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind getKind() {
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind = this.kind;
        if (kind == null) {
            $$$reportNull$$$0(39);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.isExpect;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.isActual;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor getBackingField() {
        return this.backingField;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor getDelegateField() {
        return this.delegateField;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> collection) {
        if (collection == 0) {
            $$$reportNull$$$0(40);
        }
        this.overriddenProperties = collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getOverriddenDescriptors() {
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> collection = this.overriddenProperties;
        if (collection == null) {
            collection = java.util.Collections.EMPTY_LIST;
        }
        if (collection == null) {
            $$$reportNull$$$0(41);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor copy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, boolean z) {
        kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptorBuild = newCopyBuilder().setOwner(declarationDescriptor).setOriginal(null).setModality(modality).setVisibility(descriptorVisibility).setKind(kind).setCopyOverrides(z).build();
        if (propertyDescriptorBuild == null) {
            $$$reportNull$$$0(42);
        }
        return propertyDescriptorBuild;
    }
}
