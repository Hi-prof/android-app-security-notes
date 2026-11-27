package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

/* JADX INFO: loaded from: classes2.dex */
public class JavaPropertyDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl implements kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor {
    private kotlin.reflect.jvm.internal.impl.types.KotlinType inType;
    private final boolean isStaticFinal;
    private final kotlin.Pair<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<?>, ?> singleUserData;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.String str = i != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        java.lang.Object[] objArr = new java.lang.Object[i != 21 ? 3 : 2];
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
                objArr[0] = com.taobao.weex.common.Constants.Name.VISIBILITY;
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            case 22:
                objArr[0] = "inType";
                break;
        }
        if (i != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            case 22:
                objArr[2] = "setInType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        java.lang.String str2 = java.lang.String.format(str, objArr);
        if (i == 21) {
            throw new java.lang.IllegalStateException(str2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected JavaPropertyDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility, boolean z, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, boolean z2, kotlin.Pair<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<?>, ?> pair) {
        super(declarationDescriptor, propertyDescriptor, annotations, modality, descriptorVisibility, z, name, kind, sourceElement, false, false, false, false, false, false);
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
        if (sourceElement == null) {
            $$$reportNull$$$0(5);
        }
        if (kind == null) {
            $$$reportNull$$$0(6);
        }
        this.inType = null;
        this.isStaticFinal = z2;
        this.singleUserData = pair;
    }

    public static kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor create(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility, boolean z, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement, boolean z2) {
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
        if (sourceElement == null) {
            $$$reportNull$$$0(12);
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor(declarationDescriptor, annotations, modality, descriptorVisibility, z, name, sourceElement, null, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION, z2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl
    protected kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl createSubstitutedCopy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(13);
        }
        if (modality == null) {
            $$$reportNull$$$0(14);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(15);
        }
        if (kind == null) {
            $$$reportNull$$$0(16);
        }
        if (name == null) {
            $$$reportNull$$$0(17);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(18);
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor(declarationDescriptor, getAnnotations(), modality, descriptorVisibility, isVar(), name, sourceElement, propertyDescriptor, kind, this.isStaticFinal, this.singleUserData);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor enhance(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> list, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2, kotlin.Pair<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<?>, ?> pair) {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        if (list == null) {
            $$$reportNull$$$0(19);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(20);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor original = getOriginal() == this ? null : getOriginal();
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor javaPropertyDescriptor = new kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor(getContainingDeclaration(), getAnnotations(), getModality(), getVisibility(), isVar(), getName(), getSource(), original, getKind(), this.isStaticFinal, pair);
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl getter = getGetter();
        if (getter != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl(javaPropertyDescriptor, getter.getAnnotations(), getter.getModality(), getter.getVisibility(), getter.isDefault(), getter.isExternal(), getter.isInline(), getKind(), original == null ? null : original.getGetter(), getter.getSource());
            propertyGetterDescriptorImpl2.setInitialSignatureDescriptor(getter.getInitialSignatureDescriptor());
            propertyGetterDescriptorImpl2.initialize(kotlinType2);
            propertyGetterDescriptorImpl = propertyGetterDescriptorImpl2;
        } else {
            propertyGetterDescriptorImpl = null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor setter = getSetter();
        if (setter != null) {
            propertySetterDescriptorImpl = new kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl(javaPropertyDescriptor, setter.getAnnotations(), setter.getModality(), setter.getVisibility(), setter.isDefault(), setter.isExternal(), setter.isInline(), getKind(), original == null ? null : original.getSetter(), setter.getSource());
            propertySetterDescriptorImpl.setInitialSignatureDescriptor(propertySetterDescriptorImpl.getInitialSignatureDescriptor());
            propertySetterDescriptorImpl.initialize(setter.getValueParameters().get(0));
        } else {
            propertySetterDescriptorImpl = null;
        }
        javaPropertyDescriptor.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, getBackingField(), getDelegateField());
        javaPropertyDescriptor.setSetterProjectedOut(isSetterProjectedOut());
        if (this.compileTimeInitializerFactory != null) {
            javaPropertyDescriptor.setCompileTimeInitializer(this.compileTimeInitializer, this.compileTimeInitializerFactory);
        }
        javaPropertyDescriptor.setOverriddenDescriptors(getOverriddenDescriptors());
        javaPropertyDescriptor.setType(kotlinType2, getTypeParameters(), getDispatchReceiverParameter(), kotlinType != null ? kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createExtensionReceiverParameterForCallable(this, kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY()) : null, kotlin.collections.CollectionsKt.emptyList());
        return javaPropertyDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = getType();
        if (this.isStaticFinal && kotlin.reflect.jvm.internal.impl.descriptors.ConstUtil.canBeUsedForConstVal(type)) {
            return !kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.hasEnhancedNullability(type) || kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(type);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl
    public void setInType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(22);
        }
        this.inType = kotlinType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<V> userDataKey) {
        kotlin.Pair<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<?>, ?> pair = this.singleUserData;
        if (pair == null || !pair.getFirst().equals(userDataKey)) {
            return null;
        }
        return (V) this.singleUserData.getSecond();
    }
}
