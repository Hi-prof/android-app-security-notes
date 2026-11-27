package kotlin.reflect.jvm.internal.impl.util;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ReturnsCheck implements kotlin.reflect.jvm.internal.impl.util.Check {
    private final java.lang.String description;
    private final java.lang.String name;
    private final kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns, kotlin.reflect.jvm.internal.impl.types.KotlinType> type;

    public /* synthetic */ ReturnsCheck(java.lang.String str, kotlin.jvm.functions.Function1 function1, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ReturnsCheck(java.lang.String str, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns, ? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> function1) {
        this.name = str;
        this.type = function1;
        this.description = "must return " + str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public java.lang.String invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor) {
        return kotlin.reflect.jvm.internal.impl.util.Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public java.lang.String getDescription() {
        return this.description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        return kotlin.jvm.internal.Intrinsics.areEqual(functionDescriptor.getReturnType(), this.type.invoke2(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(functionDescriptor)));
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class ReturnsBoolean extends kotlin.reflect.jvm.internal.impl.util.ReturnsCheck {
        public static final kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsBoolean INSTANCE = new kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsBoolean();

        private ReturnsBoolean() {
            super("Boolean", new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsBoolean$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj) {
                    return kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsBoolean._init_$lambda$0((kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns) obj);
                }
            }, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.types.KotlinType _init_$lambda$0(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns kotlinBuiltIns) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
            kotlin.reflect.jvm.internal.impl.types.SimpleType booleanType = kotlinBuiltIns.getBooleanType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(booleanType, "getBooleanType(...)");
            return booleanType;
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class ReturnsInt extends kotlin.reflect.jvm.internal.impl.util.ReturnsCheck {
        public static final kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsInt INSTANCE = new kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsInt();

        private ReturnsInt() {
            super("Int", new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsInt$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj) {
                    return kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsInt._init_$lambda$0((kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns) obj);
                }
            }, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.types.KotlinType _init_$lambda$0(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns kotlinBuiltIns) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
            kotlin.reflect.jvm.internal.impl.types.SimpleType intType = kotlinBuiltIns.getIntType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(intType, "getIntType(...)");
            return intType;
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class ReturnsUnit extends kotlin.reflect.jvm.internal.impl.util.ReturnsCheck {
        public static final kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsUnit INSTANCE = new kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsUnit();

        private ReturnsUnit() {
            super("Unit", new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsUnit$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj) {
                    return kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsUnit._init_$lambda$0((kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns) obj);
                }
            }, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.types.KotlinType _init_$lambda$0(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns kotlinBuiltIns) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
            kotlin.reflect.jvm.internal.impl.types.SimpleType unitType = kotlinBuiltIns.getUnitType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(unitType, "getUnitType(...)");
            return unitType;
        }
    }
}
