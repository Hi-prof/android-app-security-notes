package kotlin.reflect.jvm.internal.impl.resolve;

/* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DescriptorEquivalenceForOverrides {
    public static final kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides INSTANCE = new kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides();

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean areCallableDescriptorsEquivalent$lambda$1(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor2) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean areTypeParametersEquivalent$lambda$0(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor2) {
        return false;
    }

    public final boolean areTypeParametersEquivalent(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor a, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor b, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(b, "b");
        return areTypeParametersEquivalent$default(this, a, b, z, null, 8, null);
    }

    private DescriptorEquivalenceForOverrides() {
    }

    public static /* synthetic */ boolean areEquivalent$default(kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor2, boolean z, boolean z2, int i, java.lang.Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        return descriptorEquivalenceForOverrides.areEquivalent(declarationDescriptor, declarationDescriptor2, z, z2);
    }

    public final boolean areEquivalent(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor2, boolean z, boolean z2) {
        if ((declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) && (declarationDescriptor2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor)) {
            return areClassesEquivalent((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) declarationDescriptor, (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) declarationDescriptor2);
        }
        if ((declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) && (declarationDescriptor2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor)) {
            return areTypeParametersEquivalent$default(this, (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) declarationDescriptor, (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) declarationDescriptor2, z, null, 8, null);
        }
        if ((declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) && (declarationDescriptor2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor)) {
            return areCallableDescriptorsEquivalent$default(this, (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) declarationDescriptor, (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) declarationDescriptor2, z, z2, false, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default.INSTANCE, 16, null);
        }
        return ((declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) && (declarationDescriptor2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor)) ? kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) declarationDescriptor).getFqName(), ((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) declarationDescriptor2).getFqName()) : kotlin.jvm.internal.Intrinsics.areEqual(declarationDescriptor, declarationDescriptor2);
    }

    private final boolean areClassesEquivalent(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor2) {
        return kotlin.jvm.internal.Intrinsics.areEqual(classDescriptor.getTypeConstructor(), classDescriptor2.getTypeConstructor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean areTypeParametersEquivalent$default(kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor2, boolean z, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
        if ((i & 8) != 0) {
            function2 = new kotlin.jvm.functions.Function2() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$0
                @Override // kotlin.jvm.functions.Function2
                public java.lang.Object invoke(java.lang.Object obj2, java.lang.Object obj3) {
                    return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides.areTypeParametersEquivalent$lambda$0((kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) obj2, (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) obj3));
                }
            };
        }
        return descriptorEquivalenceForOverrides.areTypeParametersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, z, function2);
    }

    public final boolean areTypeParametersEquivalent(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor a, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor b, boolean z, kotlin.jvm.functions.Function2<? super kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, ? super kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, java.lang.Boolean> equivalentCallables) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(b, "b");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(equivalentCallables, "equivalentCallables");
        if (kotlin.jvm.internal.Intrinsics.areEqual(a, b)) {
            return true;
        }
        return !kotlin.jvm.internal.Intrinsics.areEqual(a.getContainingDeclaration(), b.getContainingDeclaration()) && ownersEquivalent(a, b, equivalentCallables, z) && a.getIndex() == b.getIndex();
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.SourceElement singleSource(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor) {
        while (callableDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) {
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) callableDescriptor;
            if (callableMemberDescriptor.getKind() != kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                break;
            }
            java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) kotlin.collections.CollectionsKt.singleOrNull(overriddenDescriptors);
            if (callableMemberDescriptor2 == null) {
                return null;
            }
            callableDescriptor = callableMemberDescriptor2;
        }
        return callableDescriptor.getSource();
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2, boolean z, boolean z2, boolean z3, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner, int i, java.lang.Object obj) {
        return descriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent(callableDescriptor, callableDescriptor2, z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? false : z3, kotlinTypeRefiner);
    }

    public final boolean areCallableDescriptorsEquivalent(final kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor a, final kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor b, final boolean z, boolean z2, boolean z3, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(b, "b");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (kotlin.jvm.internal.Intrinsics.areEqual(a, b)) {
            return true;
        }
        if (!kotlin.jvm.internal.Intrinsics.areEqual(a.getName(), b.getName())) {
            return false;
        }
        if (z2 && (a instanceof kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor) && (b instanceof kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor) && ((kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor) a).isExpect() != ((kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor) b).isExpect()) {
            return false;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(a.getContainingDeclaration(), b.getContainingDeclaration()) && (!z || !kotlin.jvm.internal.Intrinsics.areEqual(singleSource(a), singleSource(b)))) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor = a;
        if (!kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isLocal(callableDescriptor)) {
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2 = b;
            if (kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isLocal(callableDescriptor2) || !ownersEquivalent(callableDescriptor, callableDescriptor2, new kotlin.jvm.functions.Function2() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$1
                @Override // kotlin.jvm.functions.Function2
                public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                    return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent$lambda$1((kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) obj, (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) obj2));
                }
            }, z)) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil overridingUtilCreate = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.create(kotlinTypeRefiner, new kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality(z, a, b) { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$2
                private final boolean arg$0;
                private final kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor arg$1;
                private final kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor arg$2;

                {
                    this.arg$0 = z;
                    this.arg$1 = a;
                    this.arg$2 = b;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
                public boolean equals(kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor2) {
                    return kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent$lambda$3(this.arg$0, this.arg$1, this.arg$2, typeConstructor, typeConstructor2);
                }
            });
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(overridingUtilCreate, "create(...)");
            if (overridingUtilCreate.isOverridableBy(a, b, null, !z3).getResult() == kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && overridingUtilCreate.isOverridableBy(b, a, null, !z3).getResult() == kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean areCallableDescriptorsEquivalent$lambda$3(boolean z, final kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, final kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2, kotlin.reflect.jvm.internal.impl.types.TypeConstructor c1, kotlin.reflect.jvm.internal.impl.types.TypeConstructor c2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c1, "c1");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c2, "c2");
        if (kotlin.jvm.internal.Intrinsics.areEqual(c1, c2)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = c1.mo1835getDeclarationDescriptor();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor2 = c2.mo1835getDeclarationDescriptor();
        if ((classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) && (classifierDescriptorMo1835getDeclarationDescriptor2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor)) {
            return INSTANCE.areTypeParametersEquivalent((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) classifierDescriptorMo1835getDeclarationDescriptor, (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) classifierDescriptorMo1835getDeclarationDescriptor2, z, new kotlin.jvm.functions.Function2(callableDescriptor, callableDescriptor2) { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$$Lambda$3
                private final kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor arg$0;
                private final kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor arg$1;

                {
                    this.arg$0 = callableDescriptor;
                    this.arg$1 = callableDescriptor2;
                }

                @Override // kotlin.jvm.functions.Function2
                public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                    return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent$lambda$3$lambda$2(this.arg$0, this.arg$1, (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) obj, (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) obj2));
                }
            });
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean areCallableDescriptorsEquivalent$lambda$3$lambda$2(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor2) {
        return kotlin.jvm.internal.Intrinsics.areEqual(declarationDescriptor, callableDescriptor) && kotlin.jvm.internal.Intrinsics.areEqual(declarationDescriptor2, callableDescriptor2);
    }

    private final boolean ownersEquivalent(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor2, kotlin.jvm.functions.Function2<? super kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, ? super kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, java.lang.Boolean> function2, boolean z) {
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration2 = declarationDescriptor2.getContainingDeclaration();
        if ((containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) || (containingDeclaration2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor)) {
            return function2.invoke(containingDeclaration, containingDeclaration2).booleanValue();
        }
        return areEquivalent$default(this, containingDeclaration, containingDeclaration2, z, false, 8, null);
    }
}
