package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: loaded from: classes2.dex */
public class ReceiverParameterDescriptorImpl extends kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractReceiverParameterDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration;
    private kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue value;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.String str = (i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        java.lang.Object[] objArr = new java.lang.Object[(i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
            case 4:
                objArr[0] = "value";
                break;
            case 2:
            case 5:
                objArr[0] = "annotations";
                break;
            case 3:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 6:
                objArr[0] = "name";
                break;
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 9:
                objArr[0] = "newOwner";
                break;
            case 10:
                objArr[0] = "outType";
                break;
        }
        if (i == 7) {
            objArr[1] = "getValue";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        switch (i) {
            case 7:
            case 8:
                break;
            case 9:
                objArr[2] = "copy";
                break;
            case 10:
                objArr[2] = "setOutType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        java.lang.String str2 = java.lang.String.format(str, objArr);
        if (i != 7 && i != 8) {
            throw new java.lang.IllegalArgumentException(str2);
        }
        throw new java.lang.IllegalStateException(str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReceiverParameterDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue receiverValue, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations) {
        this(declarationDescriptor, receiverValue, annotations, kotlin.reflect.jvm.internal.impl.name.SpecialNames.THIS);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (receiverValue == null) {
            $$$reportNull$$$0(1);
        }
        if (annotations == null) {
            $$$reportNull$$$0(2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceiverParameterDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue receiverValue, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.name.Name name) {
        super(annotations, name);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(3);
        }
        if (receiverValue == null) {
            $$$reportNull$$$0(4);
        }
        if (annotations == null) {
            $$$reportNull$$$0(5);
        }
        if (name == null) {
            $$$reportNull$$$0(6);
        }
        this.containingDeclaration = declarationDescriptor;
        this.value = receiverValue;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue getValue() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue receiverValue = this.value;
        if (receiverValue == null) {
            $$$reportNull$$$0(7);
        }
        return receiverValue;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor getContainingDeclaration() {
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor = this.containingDeclaration;
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(8);
        }
        return declarationDescriptor;
    }
}
