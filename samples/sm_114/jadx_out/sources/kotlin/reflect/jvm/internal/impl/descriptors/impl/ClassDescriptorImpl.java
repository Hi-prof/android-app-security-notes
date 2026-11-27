package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: loaded from: classes2.dex */
public class ClassDescriptorImpl extends kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> constructors;
    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassKind kind;
    private final kotlin.reflect.jvm.internal.impl.descriptors.Modality modality;
    private kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor primaryConstructor;
    private final kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor;
    private kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope unsubstitutedMemberScope;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.String str;
        int i2;
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                i2 = 2;
                break;
            case 12:
            default:
                i2 = 3;
                break;
        }
        java.lang.Object[] objArr = new java.lang.Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        java.lang.String str2 = java.lang.String.format(str, objArr);
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                throw new java.lang.IllegalStateException(str2);
            case 12:
            default:
                throw new java.lang.IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getCompanionObjectDescriptor */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor mo1824getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> getValueClassRepresentation() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.ClassKind classKind, java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collection, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement, boolean z, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager) {
        super(storageManager, declarationDescriptor, name, sourceElement, z);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (name == null) {
            $$$reportNull$$$0(1);
        }
        if (modality == null) {
            $$$reportNull$$$0(2);
        }
        if (classKind == null) {
            $$$reportNull$$$0(3);
        }
        if (collection == null) {
            $$$reportNull$$$0(4);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(5);
        }
        if (storageManager == null) {
            $$$reportNull$$$0(6);
        }
        this.modality = modality;
        this.kind = classKind;
        this.typeConstructor = new kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl(this, java.util.Collections.EMPTY_LIST, collection, storageManager);
    }

    public final void initialize(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope, java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> set, kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptor) {
        if (memberScope == null) {
            $$$reportNull$$$0(7);
        }
        if (set == null) {
            $$$reportNull$$$0(8);
        }
        this.unsubstitutedMemberScope = memberScope;
        this.constructors = set;
        this.primaryConstructor = classConstructorDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations empty = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY();
        if (empty == null) {
            $$$reportNull$$$0(9);
        }
        return empty;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public kotlin.reflect.jvm.internal.impl.types.TypeConstructor getTypeConstructor() {
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = this.typeConstructor;
        if (typeConstructor == null) {
            $$$reportNull$$$0(10);
        }
        return typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> getConstructors() {
        java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> set = this.constructors;
        if (set == null) {
            $$$reportNull$$$0(11);
        }
        return set;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getUnsubstitutedMemberScope(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(12);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope = this.unsubstitutedMemberScope;
        if (memberScope == null) {
            $$$reportNull$$$0(13);
        }
        return memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getStaticScope() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty empty = kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty.INSTANCE;
        if (empty == null) {
            $$$reportNull$$$0(14);
        }
        return empty;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassKind getKind() {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassKind classKind = this.kind;
        if (classKind == null) {
            $$$reportNull$$$0(15);
        }
        return classKind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor mo1825getUnsubstitutedPrimaryConstructor() {
        return this.primaryConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.Modality getModality() {
        kotlin.reflect.jvm.internal.impl.descriptors.Modality modality = this.modality;
        if (modality == null) {
            $$$reportNull$$$0(16);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC;
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(17);
        }
        return descriptorVisibility;
    }

    public java.lang.String toString() {
        return "class " + getName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getDeclaredTypeParameters() {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list = java.util.Collections.EMPTY_LIST;
        if (list == null) {
            $$$reportNull$$$0(18);
        }
        return list;
    }
}
