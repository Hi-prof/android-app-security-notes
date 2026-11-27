package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpecialBuiltinMembers {
    public static final <T extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> T getOverriddenBuiltinWithDifferentJvmName(T t) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(t, "<this>");
        if (!kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.getORIGINAL_SHORT_NAMES().contains(t.getName()) && !kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES().contains(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getPropertyIfAccessor(t).getName())) {
            return null;
        }
        if ((t instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) || (t instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor)) {
            return (T) kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.firstOverridden$default(t, false, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj) {
                    return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName$lambda$0((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) obj));
                }
            }, 1, null);
        }
        if (t instanceof kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) {
            return (T) kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.firstOverridden$default(t, false, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$$Lambda$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj) {
                    return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName$lambda$1((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) obj));
                }
            }, 1, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getOverriddenBuiltinWithDifferentJvmName$lambda$0(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties.INSTANCE.hasBuiltinSpecialPropertyFqName(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getPropertyIfAccessor(it));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getOverriddenBuiltinWithDifferentJvmName$lambda$1(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName.INSTANCE.isBuiltinFunctionWithDifferentNameInJvm((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) it);
    }

    public static final boolean doesOverrideBuiltinWithDifferentJvmName(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        return getOverriddenBuiltinWithDifferentJvmName(callableMemberDescriptor) != null;
    }

    public static final <T extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> T getOverriddenSpecialBuiltin(T t) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(t, "<this>");
        T t2 = (T) getOverriddenBuiltinWithDifferentJvmName(t);
        if (t2 != null) {
            return t2;
        }
        kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        kotlin.reflect.jvm.internal.impl.name.Name name = t.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return (T) kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.firstOverridden$default(t, false, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$$Lambda$2
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj) {
                    return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.getOverriddenSpecialBuiltin$lambda$3((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) obj));
                }
            }, 1, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getOverriddenSpecialBuiltin$lambda$3(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBuiltIn(it) && kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.getSpecialSignatureInfo(it) != null;
    }

    public static final java.lang.String getJvmMethodNameIfSpecial(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor propertyIfAccessor;
        kotlin.reflect.jvm.internal.impl.name.Name jvmName;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableMemberDescriptor, "callableMemberDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor overriddenBuiltinThatAffectsJvmName = getOverriddenBuiltinThatAffectsJvmName(callableMemberDescriptor);
        if (overriddenBuiltinThatAffectsJvmName != null && (propertyIfAccessor = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getPropertyIfAccessor(overriddenBuiltinThatAffectsJvmName)) != null) {
            if (propertyIfAccessor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) {
                return kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(propertyIfAccessor);
            }
            if ((propertyIfAccessor instanceof kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) && (jvmName = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName.INSTANCE.getJvmName((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) propertyIfAccessor)) != null) {
                return jvmName.asString();
            }
        }
        return null;
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor getOverriddenBuiltinThatAffectsJvmName(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        if (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBuiltIn(callableMemberDescriptor)) {
            return getOverriddenBuiltinWithDifferentJvmName(callableMemberDescriptor);
        }
        return null;
    }

    public static final boolean hasRealKotlinSuperClassWithOverrideOf(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor specialCallableDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(specialCallableDescriptor, "specialCallableDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = specialCallableDescriptor.getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = ((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration).getDefaultType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
        for (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor superClassDescriptor = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getSuperClassDescriptor(classDescriptor); superClassDescriptor != null; superClassDescriptor = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getSuperClassDescriptor(superClassDescriptor)) {
            if (!(superClassDescriptor instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor) && kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure.findCorrespondingSupertype(superClassDescriptor.getDefaultType(), defaultType) != null) {
                return !kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBuiltIn(superClassDescriptor);
            }
        }
        return false;
    }

    public static final boolean isFromJava(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor).getContainingDeclaration() instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
    }

    public static final boolean isFromJavaOrBuiltins(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        return isFromJava(callableMemberDescriptor) || kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBuiltIn(callableMemberDescriptor);
    }
}
