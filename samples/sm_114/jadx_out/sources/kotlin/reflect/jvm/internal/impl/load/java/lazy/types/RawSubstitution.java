package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

/* JADX INFO: compiled from: RawSubstitution.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RawSubstitution extends kotlin.reflect.jvm.internal.impl.types.TypeSubstitution {
    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution.Companion Companion = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution.Companion(null);
    private static final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes lowerTypeAttr = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON, false, true, null, 5, null).withFlexibility(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
    private static final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes upperTypeAttr = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt.toAttributes$default(kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON, false, true, null, 5, null).withFlexibility(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawProjectionComputer projectionComputer;
    private final kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    /* JADX WARN: Multi-variable type inference failed */
    public RawSubstitution() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    public RawSubstitution(kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser typeParameterUpperBoundEraser) {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawProjectionComputer rawProjectionComputer = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawProjectionComputer();
        this.projectionComputer = rawProjectionComputer;
        this.typeParameterUpperBoundEraser = typeParameterUpperBoundEraser == null ? new kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser(rawProjectionComputer, null, 2, null) : typeParameterUpperBoundEraser;
    }

    public /* synthetic */ RawSubstitution(kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : typeParameterUpperBoundEraser);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl mo1840get(kotlin.reflect.jvm.internal.impl.types.KotlinType key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(eraseType$default(this, key, null, 2, null));
    }

    static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.KotlinType eraseType$default(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution rawSubstitution, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            javaTypeAttributes = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes(kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON, null, false, false, null, null, 62, null);
        }
        return rawSubstitution.eraseType(kotlinType, javaTypeAttributes);
    }

    private final kotlin.reflect.jvm.internal.impl.types.KotlinType eraseType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes) {
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl rawTypeImpl;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) {
            return eraseType(this.typeParameterUpperBoundEraser.getErasedUpperBound((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) classifierDescriptorMo1835getDeclarationDescriptor, javaTypeAttributes.markIsRaw(true)), javaTypeAttributes);
        }
        if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor2 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.upperIfFlexible(kotlinType).getConstructor().mo1835getDeclarationDescriptor();
            if (!(classifierDescriptorMo1835getDeclarationDescriptor2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor)) {
                throw new java.lang.IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + classifierDescriptorMo1835getDeclarationDescriptor2 + "\" while for lower it's \"" + classifierDescriptorMo1835getDeclarationDescriptor + '\"').toString());
            }
            kotlin.Pair<kotlin.reflect.jvm.internal.impl.types.SimpleType, java.lang.Boolean> pairEraseInflexibleBasedOnClassDescriptor = eraseInflexibleBasedOnClassDescriptor(kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.lowerIfFlexible(kotlinType), (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor, lowerTypeAttr);
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeComponent1 = pairEraseInflexibleBasedOnClassDescriptor.component1();
            boolean zBooleanValue = pairEraseInflexibleBasedOnClassDescriptor.component2().booleanValue();
            kotlin.Pair<kotlin.reflect.jvm.internal.impl.types.SimpleType, java.lang.Boolean> pairEraseInflexibleBasedOnClassDescriptor2 = eraseInflexibleBasedOnClassDescriptor(kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.upperIfFlexible(kotlinType), (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor2, upperTypeAttr);
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeComponent2 = pairEraseInflexibleBasedOnClassDescriptor2.component1();
            boolean zBooleanValue2 = pairEraseInflexibleBasedOnClassDescriptor2.component2().booleanValue();
            if (zBooleanValue || zBooleanValue2) {
                rawTypeImpl = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl(simpleTypeComponent1, simpleTypeComponent2);
            } else {
                rawTypeImpl = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(simpleTypeComponent1, simpleTypeComponent2);
            }
            return rawTypeImpl;
        }
        throw new java.lang.IllegalStateException(("Unexpected declaration kind: " + classifierDescriptorMo1835getDeclarationDescriptor).toString());
    }

    private final kotlin.Pair<kotlin.reflect.jvm.internal.impl.types.SimpleType, java.lang.Boolean> eraseInflexibleBasedOnClassDescriptor(final kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes) {
        if (simpleType.getConstructor().getParameters().isEmpty()) {
            return kotlin.TuplesKt.to(simpleType, false);
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType2 = simpleType;
        if (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArray(simpleType2)) {
            kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection = simpleType.getArguments().get(0);
            kotlin.reflect.jvm.internal.impl.types.Variance projectionKind = typeProjection.getProjectionKind();
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = typeProjection.getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            return kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(simpleType.getAttributes(), simpleType.getConstructor(), kotlin.collections.CollectionsKt.listOf(new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(projectionKind, eraseType(type, javaTypeAttributes))), simpleType.isMarkedNullable(), (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) null, 16, (java.lang.Object) null), false);
        }
        if (kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(simpleType2)) {
            return kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.ERROR_RAW_TYPE, simpleType.getConstructor().toString()), false);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope = classDescriptor.getMemberScope(this);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(memberScope, "getMemberScope(...)");
        kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes = simpleType.getAttributes();
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = classDescriptor.getTypeConstructor().getParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list = parameters;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor : list) {
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawProjectionComputer rawProjectionComputer = this.projectionComputer;
            kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameterDescriptor);
            arrayList.add(kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer.computeProjection$default(rawProjectionComputer, typeParameterDescriptor, javaTypeAttributes, this.typeParameterUpperBoundEraser, null, 8, null));
        }
        return kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(attributes, typeConstructor, arrayList, simpleType.isMarkedNullable(), memberScope, new kotlin.jvm.functions.Function1(classDescriptor, this, simpleType, javaTypeAttributes) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor arg$0;
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution arg$1;
            private final kotlin.reflect.jvm.internal.impl.types.SimpleType arg$2;
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes arg$3;

            {
                this.arg$0 = classDescriptor;
                this.arg$1 = this;
                this.arg$2 = simpleType;
                this.arg$3 = javaTypeAttributes;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution.eraseInflexibleBasedOnClassDescriptor$lambda$2(this.arg$0, this.arg$1, this.arg$2, this.arg$3, (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) obj);
            }
        }), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.SimpleType eraseInflexibleBasedOnClassDescriptor$lambda$2(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution rawSubstitution, kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorFindClassAcrossModuleDependencies;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getClassId(classDescriptor);
        if (classId == null || (classDescriptorFindClassAcrossModuleDependencies = kotlinTypeRefiner.findClassAcrossModuleDependencies(classId)) == null || kotlin.jvm.internal.Intrinsics.areEqual(classDescriptorFindClassAcrossModuleDependencies, classDescriptor)) {
            return null;
        }
        return rawSubstitution.eraseInflexibleBasedOnClassDescriptor(simpleType, classDescriptorFindClassAcrossModuleDependencies, javaTypeAttributes).getFirst();
    }

    /* JADX INFO: compiled from: RawSubstitution.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
