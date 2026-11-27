package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractLazyTypeParameterDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor {
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.Object[] objArr = new java.lang.Object[3];
        switch (i) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractLazyTypeParameterDescriptor(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.types.Variance variance, boolean z, int i, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement, kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker supertypeLoopChecker) {
        super(storageManager, declarationDescriptor, annotations, name, variance, z, i, sourceElement, supertypeLoopChecker);
        if (storageManager == null) {
            $$$reportNull$$$0(0);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(1);
        }
        if (annotations == null) {
            $$$reportNull$$$0(2);
        }
        if (name == null) {
            $$$reportNull$$$0(3);
        }
        if (variance == null) {
            $$$reportNull$$$0(4);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(5);
        }
        if (supertypeLoopChecker == null) {
            $$$reportNull$$$0(6);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public java.lang.String toString() {
        java.lang.String str = "";
        java.lang.String str2 = isReified() ? "reified " : "";
        if (getVariance() != kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT) {
            str = getVariance() + com.taobao.weex.el.parse.Operators.SPACE_STR;
        }
        return java.lang.String.format("%s%s%s", str2, str, getName());
    }
}
