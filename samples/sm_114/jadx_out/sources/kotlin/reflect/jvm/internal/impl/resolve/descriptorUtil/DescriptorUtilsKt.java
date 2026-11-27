package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

/* JADX INFO: compiled from: DescriptorUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DescriptorUtilsKt {
    private static final kotlin.reflect.jvm.internal.impl.name.Name RETENTION_PARAMETER_NAME;

    static {
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier("value");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        RETENTION_PARAMETER_NAME = nameIdentifier;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe getFqNameUnsafe(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqName = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getFqName(declarationDescriptor);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(...)");
        return fqName;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName getFqNameSafe(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.name.FqName fqNameSafe = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getFqNameSafe(declarationDescriptor);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(fqNameSafe, "getFqNameSafe(...)");
        return fqNameSafe;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor getModule(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor containingModule = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getContainingModule(declarationDescriptor);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingModule, "getContainingModule(...)");
        return containingModule;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor resolveTopLevelClass(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, kotlin.reflect.jvm.internal.impl.name.FqName topLevelClassFqName, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(topLevelClassFqName, "topLevelClassFqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        topLevelClassFqName.isRoot();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor contributedClassifier = moduleDescriptor.getPackage(topLevelClassFqName.parent()).getMemberScope().mo1837getContributedClassifier(topLevelClassFqName.shortName(), location);
        if (contributedClassifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) contributedClassifier;
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.ClassId getClassId(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration;
        kotlin.reflect.jvm.internal.impl.name.ClassId classId;
        if (classifierDescriptor != null && (containingDeclaration = classifierDescriptor.getContainingDeclaration()) != null) {
            if (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) {
                kotlin.reflect.jvm.internal.impl.name.FqName fqName = ((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) containingDeclaration).getFqName();
                kotlin.reflect.jvm.internal.impl.name.Name name = classifierDescriptor.getName();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                return new kotlin.reflect.jvm.internal.impl.name.ClassId(fqName, name);
            }
            if ((containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters) && (classId = getClassId((kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) containingDeclaration)) != null) {
                kotlin.reflect.jvm.internal.impl.name.Name name2 = classifierDescriptor.getName();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                return classId.createNestedClassId(name2);
            }
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getSuperClassNotAny(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        for (kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType : classDescriptor.getDefaultType().getConstructor().mo1836getSupertypes()) {
            if (!kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isAnyOrNullableAny(kotlinType)) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
                if (kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isClassOrEnumClass(classifierDescriptorMo1835getDeclarationDescriptor)) {
                    kotlin.jvm.internal.Intrinsics.checkNotNull(classifierDescriptorMo1835getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor;
                }
            }
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns getBuiltIns(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return getModule(declarationDescriptor).getBuiltIns();
    }

    public static final boolean declaresOrInheritsDefaultValue(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(valueParameterDescriptor, "<this>");
        java.lang.Boolean boolIfAny = kotlin.reflect.jvm.internal.impl.utils.DFS.ifAny(kotlin.collections.CollectionsKt.listOf(valueParameterDescriptor), new kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$0
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public java.lang.Iterable getNeighbors(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue$lambda$5((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) obj);
            }
        }, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.AnonymousClass2.INSTANCE);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(boolIfAny, "ifAny(...)");
        return boolIfAny.booleanValue();
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$declaresOrInheritsDefaultValue$2, reason: invalid class name */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    static final /* synthetic */ class AnonymousClass2 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, java.lang.Boolean> {
        public static final kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.AnonymousClass2 INSTANCE = new kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.AnonymousClass2();

        AnonymousClass2() {
            super(1, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor.class, "declaresDefaultValue", "declaresDefaultValue()Z", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final java.lang.Boolean invoke2(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor p0) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
            return java.lang.Boolean.valueOf(p0.declaresDefaultValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Iterable declaresOrInheritsDefaultValue$lambda$5(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor) {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> overriddenDescriptors = valueParameterDescriptor.getOverriddenDescriptors();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(overriddenDescriptors, 10));
        java.util.Iterator<T> it = overriddenDescriptors.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) it.next()).getOriginal());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor _get_parentsWithSelf_$lambda$8(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it.getContainingDeclaration();
    }

    public static final kotlin.sequences.Sequence<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getParentsWithSelf(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return kotlin.sequences.SequencesKt.generateSequence(declarationDescriptor, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt._get_parentsWithSelf_$lambda$8((kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) obj);
            }
        });
    }

    public static final kotlin.sequences.Sequence<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getParents(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        return kotlin.sequences.SequencesKt.drop(getParentsWithSelf(declarationDescriptor), 1);
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor getPropertyIfAccessor(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        if (!(callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor)) {
            return callableMemberDescriptor;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor correspondingProperty = ((kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor) callableMemberDescriptor).getCorrespondingProperty();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(correspondingProperty, "getCorrespondingProperty(...)");
        return correspondingProperty;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName fqNameOrNull(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe = getFqNameUnsafe(declarationDescriptor);
        if (!fqNameUnsafe.isSafe()) {
            fqNameUnsafe = null;
        }
        if (fqNameUnsafe != null) {
            return fqNameUnsafe.toSafe();
        }
        return null;
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor firstOverridden$default(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, boolean z, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return firstOverridden(callableMemberDescriptor, z, function1);
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor firstOverridden(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, final boolean z, final kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        return (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) kotlin.reflect.jvm.internal.impl.utils.DFS.dfs(kotlin.collections.CollectionsKt.listOf(callableMemberDescriptor), new kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors(z) { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$2
            private final boolean arg$0;

            {
                this.arg$0 = z;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public java.lang.Iterable getNeighbors(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.firstOverridden$lambda$10(this.arg$0, (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) obj);
            }
        }, new kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.firstOverridden.2
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor current) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(current, "current");
                return objectRef.element == null;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public void afterChildren(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor current) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(current, "current");
                if (objectRef.element == null && predicate.invoke2(current).booleanValue()) {
                    objectRef.element = current;
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor result() {
                return objectRef.element;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Iterable firstOverridden$lambda$10(boolean z, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> overriddenDescriptors;
        if (z) {
            callableMemberDescriptor = callableMemberDescriptor != null ? callableMemberDescriptor.getOriginal() : null;
        }
        return (callableMemberDescriptor == null || (overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors()) == null) ? kotlin.collections.CollectionsKt.emptyList() : overriddenDescriptors;
    }

    public static final kotlin.sequences.Sequence<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> overriddenTreeAsSequence(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, final boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        if (z) {
            callableMemberDescriptor = callableMemberDescriptor.getOriginal();
        }
        kotlin.sequences.Sequence sequenceSequenceOf = kotlin.sequences.SequencesKt.sequenceOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor[]{callableMemberDescriptor});
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        return kotlin.sequences.SequencesKt.plus(sequenceSequenceOf, kotlin.sequences.SequencesKt.flatMap(kotlin.collections.CollectionsKt.asSequence(overriddenDescriptors), new kotlin.jvm.functions.Function1(z) { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$$Lambda$3
            private final boolean arg$0;

            {
                this.arg$0 = z;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.overriddenTreeAsSequence$lambda$12$lambda$11(this.arg$0, (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.sequences.Sequence overriddenTreeAsSequence$lambda$12$lambda$11(boolean z, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(callableMemberDescriptor);
        return overriddenTreeAsSequence(callableMemberDescriptor, z);
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getAnnotationClass(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = annotationDescriptor.getType().getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor;
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner getKotlinTypeRefiner(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.types.checker.Ref ref = (kotlin.reflect.jvm.internal.impl.types.checker.Ref) moduleDescriptor.getCapability(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport typeRefinementSupport = ref != null ? (kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport) ref.getValue() : null;
        return typeRefinementSupport instanceof kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport.Enabled ? ((kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport.Enabled) typeRefinementSupport).getTypeRefiner() : kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default.INSTANCE;
    }

    public static final boolean isTypeRefinementEnabled(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor) {
        kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport typeRefinementSupport;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.types.checker.Ref ref = (kotlin.reflect.jvm.internal.impl.types.checker.Ref) moduleDescriptor.getCapability(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        return (ref == null || (typeRefinementSupport = (kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport) ref.getValue()) == null || !typeRefinementSupport.isEnabled()) ? false : true;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> getInlineClassRepresentation(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> valueClassRepresentation = classDescriptor != null ? classDescriptor.getValueClassRepresentation() : null;
        if (valueClassRepresentation instanceof kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation) valueClassRepresentation;
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> getMultiFieldValueClassRepresentation(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> valueClassRepresentation = classDescriptor != null ? classDescriptor.getValueClassRepresentation() : null;
        if (valueClassRepresentation instanceof kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation) valueClassRepresentation;
        }
        return null;
    }
}
