package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractClassTypeConstructor extends kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor {
    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.String str = (i == 1 || i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        java.lang.Object[] objArr = new java.lang.Object[(i == 1 || i == 3 || i == 4) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        } else if (i == 2) {
            objArr[0] = "classifier";
        } else if (i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 1) {
            objArr[1] = "getBuiltIns";
        } else if (i == 3 || i == 4) {
            objArr[1] = "getAdditionalNeighboursInSupertypeGraph";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        }
        if (i != 1) {
            if (i == 2) {
                objArr[2] = "isSameClassifier";
            } else if (i != 3 && i != 4) {
                objArr[2] = "<init>";
            }
        }
        java.lang.String str2 = java.lang.String.format(str, objArr);
        if (i != 1 && i != 3 && i != 4) {
            throw new java.lang.IllegalArgumentException(str2);
        }
        throw new java.lang.IllegalStateException(str2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor mo1835getDeclarationDescriptor();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractClassTypeConstructor(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager) {
        super(storageManager);
        if (storageManager == null) {
            $$$reportNull$$$0(0);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns getBuiltIns() {
        kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(mo1835getDeclarationDescriptor());
        if (builtIns == null) {
            $$$reportNull$$$0(1);
        }
        return builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor
    protected boolean isSameClassifier(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptor) {
        if (classifierDescriptor == null) {
            $$$reportNull$$$0(2);
        }
        return (classifierDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) && areFqNamesEqual(mo1835getDeclarationDescriptor(), classifierDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    protected java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean z) {
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = mo1835getDeclarationDescriptor().getContainingDeclaration();
        if (!(containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor)) {
            java.util.List list = java.util.Collections.EMPTY_LIST;
            if (list == null) {
                $$$reportNull$$$0(3);
            }
            return list;
        }
        kotlin.reflect.jvm.internal.impl.utils.SmartList smartList = new kotlin.reflect.jvm.internal.impl.utils.SmartList();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration;
        smartList.add(classDescriptor.getDefaultType());
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorMo1824getCompanionObjectDescriptor = classDescriptor.mo1824getCompanionObjectDescriptor();
        if (z && classDescriptorMo1824getCompanionObjectDescriptor != null) {
            smartList.add(classDescriptorMo1824getCompanionObjectDescriptor.getDefaultType());
        }
        return smartList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    protected kotlin.reflect.jvm.internal.impl.types.KotlinType defaultSupertypeIfEmpty() {
        if (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isSpecialClassWithNoSupertypes(mo1835getDeclarationDescriptor())) {
            return null;
        }
        return getBuiltIns().getAnyType();
    }
}
