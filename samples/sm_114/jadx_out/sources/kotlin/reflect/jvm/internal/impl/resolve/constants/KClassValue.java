package kotlin.reflect.jvm.internal.impl.resolve.constants;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KClassValue extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value> {
    public static final kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Companion Companion = new kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Companion(null);

    /* JADX INFO: compiled from: constantValues.kt */
    public static abstract class Value {
        public /* synthetic */ Value(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: constantValues.kt */
        public static final class NormalClass extends kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value {
            private final kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue value;

            public boolean equals(java.lang.Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass) && kotlin.jvm.internal.Intrinsics.areEqual(this.value, ((kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass) obj).value);
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public java.lang.String toString() {
                return "NormalClass(value=" + this.value + com.taobao.weex.el.parse.Operators.BRACKET_END;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NormalClass(kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue value) {
                super(null);
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
            }

            public final kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue getValue() {
                return this.value;
            }

            public final kotlin.reflect.jvm.internal.impl.name.ClassId getClassId() {
                return this.value.getClassId();
            }

            public final int getArrayDimensions() {
                return this.value.getArrayNestedness();
            }
        }

        private Value() {
        }

        /* JADX INFO: compiled from: constantValues.kt */
        public static final class LocalClass extends kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value {
            private final kotlin.reflect.jvm.internal.impl.types.KotlinType type;

            public boolean equals(java.lang.Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.LocalClass) && kotlin.jvm.internal.Intrinsics.areEqual(this.type, ((kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.LocalClass) obj).type);
            }

            public int hashCode() {
                return this.type.hashCode();
            }

            public java.lang.String toString() {
                return "LocalClass(type=" + this.type + com.taobao.weex.el.parse.Operators.BRACKET_END;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LocalClass(kotlin.reflect.jvm.internal.impl.types.KotlinType type) {
                super(null);
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
                this.type = type;
            }

            public final kotlin.reflect.jvm.internal.impl.types.KotlinType getType() {
                return this.type;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassValue(kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value value) {
        super(value);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KClassValue(kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue value) {
        this(new kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass(value));
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KClassValue(kotlin.reflect.jvm.internal.impl.name.ClassId classId, int i) {
        this(new kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue(classId, i));
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getType(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.reflect.jvm.internal.impl.types.TypeAttributes empty = kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion.getEmpty();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor kClass = module.getBuiltIns().getKClass();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kClass, "getKClass(...)");
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleNotNullType(empty, kClass, kotlin.collections.CollectionsKt.listOf(new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(getArgumentType(module))));
    }

    public final kotlin.reflect.jvm.internal.impl.types.KotlinType getArgumentType(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value value = getValue();
        if (value instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.LocalClass) {
            return ((kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.LocalClass) getValue()).getType();
        }
        if (!(value instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass)) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue value2 = ((kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass) getValue()).getValue();
        kotlin.reflect.jvm.internal.impl.name.ClassId classIdComponent1 = value2.component1();
        int iComponent2 = value2.component2();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findClassAcrossModuleDependencies(module, classIdComponent1);
        if (classDescriptorFindClassAcrossModuleDependencies == null) {
            return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.UNRESOLVED_KCLASS_CONSTANT_VALUE, classIdComponent1.toString(), java.lang.String.valueOf(iComponent2));
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = classDescriptorFindClassAcrossModuleDependencies.getDefaultType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeReplaceArgumentsWithStarProjections = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType);
        for (int i = 0; i < iComponent2; i++) {
            kotlinTypeReplaceArgumentsWithStarProjections = module.getBuiltIns().getArrayType(kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT, kotlinTypeReplaceArgumentsWithStarProjections);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kotlinTypeReplaceArgumentsWithStarProjections, "getArrayType(...)");
        }
        return kotlinTypeReplaceArgumentsWithStarProjections;
    }

    /* JADX INFO: compiled from: constantValues.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> create(kotlin.reflect.jvm.internal.impl.types.KotlinType argumentType) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(argumentType, "argumentType");
            if (kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(argumentType)) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = argumentType;
            int i = 0;
            while (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArray(type)) {
                type = ((kotlin.reflect.jvm.internal.impl.types.TypeProjection) kotlin.collections.CollectionsKt.single((java.util.List) type.getArguments())).getType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                i++;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = type.getConstructor().mo1835getDeclarationDescriptor();
            if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
                kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getClassId(classifierDescriptorMo1835getDeclarationDescriptor);
                return classId == null ? new kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue(new kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.LocalClass(argumentType)) : new kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue(classId, i);
            }
            if (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) {
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.topLevel(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.any.toSafe()), 0);
            }
            return null;
        }
    }
}
