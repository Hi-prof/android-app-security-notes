package kotlin.reflect.jvm.internal.impl.util;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OperatorChecks extends kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks {
    public static final kotlin.reflect.jvm.internal.impl.util.OperatorChecks INSTANCE = new kotlin.reflect.jvm.internal.impl.util.OperatorChecks();
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.util.Checks> checks = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.util.Checks[]{new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.GET, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, new kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.AtLeast(1)}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.SET, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, new kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.AtLeast(2)}, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$$Lambda$0
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public java.lang.Object invoke2(java.lang.Object obj) {
            return kotlin.reflect.jvm.internal.impl.util.OperatorChecks.checks$lambda$2((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) obj);
        }
    }), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.GET_VALUE, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck.INSTANCE, new kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.AtLeast(2), kotlin.reflect.jvm.internal.impl.util.IsKPropertyCheck.INSTANCE}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.SET_VALUE, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck.INSTANCE, new kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.AtLeast(3), kotlin.reflect.jvm.internal.impl.util.IsKPropertyCheck.INSTANCE}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.PROVIDE_DELEGATE, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck.INSTANCE, new kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.Equals(2), kotlin.reflect.jvm.internal.impl.util.IsKPropertyCheck.INSTANCE}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.INVOKE, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.CONTAINS, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.SingleValueParameter.INSTANCE, kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck.INSTANCE, kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsBoolean.INSTANCE}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.ITERATOR, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.NoValueParameters.INSTANCE}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.NEXT, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.NoValueParameters.INSTANCE}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.HAS_NEXT, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.NoValueParameters.INSTANCE, kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsBoolean.INSTANCE}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.RANGE_TO, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.SingleValueParameter.INSTANCE, kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck.INSTANCE}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.RANGE_UNTIL, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.SingleValueParameter.INSTANCE, kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck.INSTANCE}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.EQUALS, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.Member.INSTANCE}, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$$Lambda$1
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public java.lang.Object invoke2(java.lang.Object obj) {
            return kotlin.reflect.jvm.internal.impl.util.OperatorChecks.checks$lambda$6((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) obj);
        }
    }), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.COMPARE_TO, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsInt.INSTANCE, kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.SingleValueParameter.INSTANCE, kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck.INSTANCE}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.BINARY_OPERATION_NAMES, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.SingleValueParameter.INSTANCE, kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck.INSTANCE}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.SIMPLE_UNARY_OPERATION_NAMES, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.NoValueParameters.INSTANCE}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.name.Name[]{kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.INC, kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.DEC}), new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE}, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$$Lambda$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public java.lang.Object invoke2(java.lang.Object obj) {
            return kotlin.reflect.jvm.internal.impl.util.OperatorChecks.checks$lambda$8((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) obj);
        }
    }), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.ASSIGNMENT_OPERATIONS, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsUnit.INSTANCE, kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.SingleValueParameter.INSTANCE, kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck.INSTANCE}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null), new kotlin.reflect.jvm.internal.impl.util.Checks(kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.COMPONENT_REGEX, new kotlin.reflect.jvm.internal.impl.util.Check[]{kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension.INSTANCE, kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.NoValueParameters.INSTANCE}, (kotlin.jvm.functions.Function1) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null)});

    private OperatorChecks() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks
    public java.util.List<kotlin.reflect.jvm.internal.impl.util.Checks> getChecks$descriptors() {
        return checks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String checks$lambda$2(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor Checks) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(Checks, "$this$Checks");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = Checks.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) kotlin.collections.CollectionsKt.lastOrNull((java.util.List) valueParameters);
        boolean z = false;
        if (valueParameterDescriptor != null && !kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor) && valueParameterDescriptor.getVarargElementType() == null) {
            z = true;
        }
        kotlin.reflect.jvm.internal.impl.util.OperatorChecks operatorChecks = INSTANCE;
        if (z) {
            return null;
        }
        return "last parameter should not have a default value or be a vararg";
    }

    private static final boolean checks$lambda$6$isAny(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        return (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) && kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isAny((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) declarationDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x0052  */
    /* JADX WARN: Code duplicated, block: B:17:0x0054  */
    public static final java.lang.String checks$lambda$6(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor Checks) {
        boolean z;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(Checks, "$this$Checks");
        kotlin.reflect.jvm.internal.impl.util.OperatorChecks operatorChecks = INSTANCE;
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = Checks.getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
        if (checks$lambda$6$isAny(containingDeclaration)) {
            z = true;
        } else {
            java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> overriddenDescriptors = Checks.getOverriddenDescriptors();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
            java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> collection = overriddenDescriptors;
            if (!collection.isEmpty()) {
                java.util.Iterator<T> it = collection.iterator();
                while (true) {
                    if (it.hasNext()) {
                        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration2 = ((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) it.next()).getContainingDeclaration();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
                        if (checks$lambda$6$isAny(containingDeclaration2)) {
                        }
                    } else if (kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt.isTypedEqualsInValueClass(Checks)) {
                        z = false;
                    }
                    z = true;
                }
            } else if (kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt.isTypedEqualsInValueClass(Checks)) {
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("must override ''equals()'' in Any");
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration3 = Checks.getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration3, "getContainingDeclaration(...)");
        if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClass(containingDeclaration3)) {
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer descriptorRenderer = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.SHORT_NAMES_IN_TYPES;
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration4 = Checks.getContainingDeclaration();
            kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration4, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = ((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration4).getDefaultType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
            sb.append(" or define ''equals(other: " + descriptorRenderer.renderType(kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType)) + "): Boolean''");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String checks$lambda$8(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor Checks) {
        boolean zIsSubtypeOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(Checks, "$this$Checks");
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor dispatchReceiverParameter = Checks.getDispatchReceiverParameter();
        if (dispatchReceiverParameter == null) {
            dispatchReceiverParameter = Checks.getExtensionReceiverParameter();
        }
        kotlin.reflect.jvm.internal.impl.util.OperatorChecks operatorChecks = INSTANCE;
        boolean z = false;
        if (dispatchReceiverParameter != null) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = Checks.getReturnType();
            if (returnType != null) {
                kotlin.reflect.jvm.internal.impl.types.KotlinType type = dispatchReceiverParameter.getType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                zIsSubtypeOf = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isSubtypeOf(returnType, type);
            } else {
                zIsSubtypeOf = false;
            }
            if (zIsSubtypeOf || operatorChecks.incDecCheckForExpectClass(Checks, dispatchReceiverParameter)) {
                z = true;
            }
        }
        if (z) {
            return null;
        }
        return "receiver must be a supertype of the return type";
    }

    private final boolean incDecCheckForExpectClass(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor) {
        kotlin.reflect.jvm.internal.impl.name.ClassId classId;
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue value = receiverParameterDescriptor.getValue();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        if (!(value instanceof kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = ((kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver) value).getClassDescriptor();
        if (!classDescriptor.isExpect() || (classId = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getClassId(classDescriptor)) == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorFindClassifierAcrossModuleDependencies = kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findClassifierAcrossModuleDependencies(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getModule(classDescriptor), classId);
        kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor = classifierDescriptorFindClassifierAcrossModuleDependencies instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) classifierDescriptorFindClassifierAcrossModuleDependencies : null;
        if (typeAliasDescriptor == null || (returnType = functionDescriptor.getReturnType()) == null) {
            return false;
        }
        return kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isSubtypeOf(returnType, typeAliasDescriptor.getExpandedType());
    }
}
