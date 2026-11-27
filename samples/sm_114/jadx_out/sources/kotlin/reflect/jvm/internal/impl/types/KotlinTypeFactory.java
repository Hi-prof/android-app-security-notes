package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KotlinTypeFactory {
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory INSTANCE = new kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory();
    private static final kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.SimpleType> EMPTY_REFINED_TYPE_FACTORY = new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final java.lang.Void invoke2(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "<unused var>");
            return null;
        }
    };

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType(kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attributes, "attributes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "constructor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        return simpleType$default(attributes, constructor, arguments, z, (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) null, 16, (java.lang.Object) null);
    }

    private KotlinTypeFactory() {
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope computeMemberScope(kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> list, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = typeConstructor.mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) {
            return ((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) classifierDescriptorMo1835getDeclarationDescriptor).getDefaultType().getMemberScope();
        }
        if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
            if (kotlinTypeRefiner == null) {
                kotlinTypeRefiner = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getKotlinTypeRefiner(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getModule(classifierDescriptorMo1835getDeclarationDescriptor));
            }
            if (list.isEmpty()) {
                return kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptorKt.getRefinedUnsubstitutedMemberScopeIfPossible((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor, kotlinTypeRefiner);
            }
            return kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptorKt.getRefinedMemberScopeIfPossible((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor, kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion.create(typeConstructor, list), kotlinTypeRefiner);
        }
        if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) {
            return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorScope(kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind.SCOPE_FOR_ABBREVIATION_TYPE, true, ((kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) classifierDescriptorMo1835getDeclarationDescriptor).getName().toString());
        }
        if (typeConstructor instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) {
            return ((kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) typeConstructor).createScopeForKotlinType();
        }
        throw new java.lang.IllegalStateException("Unsupported classifier: " + classifierDescriptorMo1835getDeclarationDescriptor + " for constructor: " + typeConstructor);
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType$default(kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, java.util.List list, boolean z, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner, int i, java.lang.Object obj) {
        if ((i & 16) != 0) {
            kotlinTypeRefiner = null;
        }
        return simpleType(typeAttributes, typeConstructor, (java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection>) list, z, kotlinTypeRefiner);
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType(final kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes, final kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor, final java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments, final boolean z, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attributes, "attributes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "constructor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (attributes.isEmpty() && arguments.isEmpty() && !z && constructor.mo1835getDeclarationDescriptor() != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = constructor.mo1835getDeclarationDescriptor();
            kotlin.jvm.internal.Intrinsics.checkNotNull(classifierDescriptorMo1835getDeclarationDescriptor);
            kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = classifierDescriptorMo1835getDeclarationDescriptor.getDefaultType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
            return defaultType;
        }
        return simpleTypeWithNonTrivialMemberScope(attributes, constructor, arguments, z, INSTANCE.computeMemberScope(constructor, arguments, kotlinTypeRefiner), new kotlin.jvm.functions.Function1(constructor, arguments, attributes, z) { // from class: kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.types.TypeConstructor arg$0;
            private final java.util.List arg$1;
            private final kotlin.reflect.jvm.internal.impl.types.TypeAttributes arg$2;
            private final boolean arg$3;

            {
                this.arg$0 = constructor;
                this.arg$1 = arguments;
                this.arg$2 = attributes;
                this.arg$3 = z;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$lambda$1(this.arg$0, this.arg$1, this.arg$2, this.arg$3, (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType$lambda$1(kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, java.util.List list, kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes, boolean z, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner refiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(refiner, "refiner");
        kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.ExpandedTypeOrRefinedConstructor expandedTypeOrRefinedConstructorRefineConstructor = INSTANCE.refineConstructor(typeConstructor, refiner, list);
        if (expandedTypeOrRefinedConstructorRefineConstructor == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType expandedType = expandedTypeOrRefinedConstructorRefineConstructor.getExpandedType();
        if (expandedType != null) {
            return expandedType;
        }
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor refinedConstructor = expandedTypeOrRefinedConstructorRefineConstructor.getRefinedConstructor();
        kotlin.jvm.internal.Intrinsics.checkNotNull(refinedConstructor);
        return simpleType(typeAttributes, refinedConstructor, (java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection>) list, z, refiner);
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType computeExpandedType(kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAliasDescriptor, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        return new kotlin.reflect.jvm.internal.impl.types.TypeAliasExpander(kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false).expand(kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion.Companion.create(null, typeAliasDescriptor, arguments), kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion.getEmpty());
    }

    private final kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.ExpandedTypeOrRefinedConstructor refineConstructor(kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> list) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorRefineDescriptor;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = typeConstructor.mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor == null || (classifierDescriptorRefineDescriptor = kotlinTypeRefiner.refineDescriptor(classifierDescriptorMo1835getDeclarationDescriptor)) == null) {
            return null;
        }
        if (classifierDescriptorRefineDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) {
            return new kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.ExpandedTypeOrRefinedConstructor(computeExpandedType((kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) classifierDescriptorRefineDescriptor, list), null);
        }
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructorRefine = classifierDescriptorRefineDescriptor.getTypeConstructor().refine(kotlinTypeRefiner);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructorRefine, "refine(...)");
        return new kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.ExpandedTypeOrRefinedConstructor(null, typeConstructorRefine);
    }

    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    private static final class ExpandedTypeOrRefinedConstructor {
        private final kotlin.reflect.jvm.internal.impl.types.SimpleType expandedType;
        private final kotlin.reflect.jvm.internal.impl.types.TypeConstructor refinedConstructor;

        public ExpandedTypeOrRefinedConstructor(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor) {
            this.expandedType = simpleType;
            this.refinedConstructor = typeConstructor;
        }

        public final kotlin.reflect.jvm.internal.impl.types.SimpleType getExpandedType() {
            return this.expandedType;
        }

        public final kotlin.reflect.jvm.internal.impl.types.TypeConstructor getRefinedConstructor() {
            return this.refinedConstructor;
        }
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeWithNonTrivialMemberScope(final kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes, final kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor, final java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments, final boolean z, final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attributes, "attributes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "constructor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        kotlin.reflect.jvm.internal.impl.types.SimpleTypeImpl simpleTypeImpl = new kotlin.reflect.jvm.internal.impl.types.SimpleTypeImpl(constructor, arguments, z, memberScope, new kotlin.jvm.functions.Function1(constructor, arguments, attributes, z, memberScope) { // from class: kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.types.TypeConstructor arg$0;
            private final java.util.List arg$1;
            private final kotlin.reflect.jvm.internal.impl.types.TypeAttributes arg$2;
            private final boolean arg$3;
            private final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope arg$4;

            {
                this.arg$0 = constructor;
                this.arg$1 = arguments;
                this.arg$2 = attributes;
                this.arg$3 = z;
                this.arg$4 = memberScope;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope$lambda$4(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4, (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) obj);
            }
        });
        if (attributes.isEmpty()) {
            return simpleTypeImpl;
        }
        return new kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithAttributes(simpleTypeImpl, attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeWithNonTrivialMemberScope$lambda$4(kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, java.util.List list, kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes, boolean z, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.ExpandedTypeOrRefinedConstructor expandedTypeOrRefinedConstructorRefineConstructor = INSTANCE.refineConstructor(typeConstructor, kotlinTypeRefiner, list);
        if (expandedTypeOrRefinedConstructorRefineConstructor == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType expandedType = expandedTypeOrRefinedConstructorRefineConstructor.getExpandedType();
        if (expandedType != null) {
            return expandedType;
        }
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor refinedConstructor = expandedTypeOrRefinedConstructorRefineConstructor.getRefinedConstructor();
        kotlin.jvm.internal.Intrinsics.checkNotNull(refinedConstructor);
        return simpleTypeWithNonTrivialMemberScope(typeAttributes, refinedConstructor, list, z, memberScope);
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeWithNonTrivialMemberScope(kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments, boolean z, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, ? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> refinedTypeFactory) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attributes, "attributes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "constructor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(refinedTypeFactory, "refinedTypeFactory");
        kotlin.reflect.jvm.internal.impl.types.SimpleTypeImpl simpleTypeImpl = new kotlin.reflect.jvm.internal.impl.types.SimpleTypeImpl(constructor, arguments, z, memberScope, refinedTypeFactory);
        if (attributes.isEmpty()) {
            return simpleTypeImpl;
        }
        return new kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithAttributes(simpleTypeImpl, attributes);
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType simpleNotNullType(kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor descriptor, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attributes, "attributes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = descriptor.getTypeConstructor();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return simpleType$default(attributes, typeConstructor, (java.util.List) arguments, false, (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) null, 16, (java.lang.Object) null);
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType$default(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, java.util.List list, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            typeAttributes = simpleType.getAttributes();
        }
        if ((i & 4) != 0) {
            typeConstructor = simpleType.getConstructor();
        }
        if ((i & 8) != 0) {
            list = simpleType.getArguments();
        }
        if ((i & 16) != 0) {
            z = simpleType.isMarkedNullable();
        }
        return simpleType(simpleType, typeAttributes, typeConstructor, (java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection>) list, z);
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType(kotlin.reflect.jvm.internal.impl.types.SimpleType baseType, kotlin.reflect.jvm.internal.impl.types.TypeAttributes annotations, kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(baseType, "baseType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "constructor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        return simpleType$default(annotations, constructor, arguments, z, (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) null, 16, (java.lang.Object) null);
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.types.UnwrappedType flexibleType(kotlin.reflect.jvm.internal.impl.types.SimpleType lowerBound, kotlin.reflect.jvm.internal.impl.types.SimpleType upperBound) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(upperBound, "upperBound");
        return kotlin.jvm.internal.Intrinsics.areEqual(lowerBound, upperBound) ? lowerBound : new kotlin.reflect.jvm.internal.impl.types.FlexibleTypeImpl(lowerBound, upperBound);
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType integerLiteralType(kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes, kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor constructor, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attributes, "attributes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "constructor");
        return simpleTypeWithNonTrivialMemberScope(attributes, constructor, kotlin.collections.CollectionsKt.emptyList(), z, kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorScope(kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind.INTEGER_LITERAL_TYPE_SCOPE, true, "unknown integer literal type"));
    }
}
