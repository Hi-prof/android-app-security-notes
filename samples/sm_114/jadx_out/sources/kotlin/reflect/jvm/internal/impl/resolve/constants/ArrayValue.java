package kotlin.reflect.jvm.internal.impl.resolve.constants;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ArrayValue extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<java.util.List<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>>> {
    private final kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, kotlin.reflect.jvm.internal.impl.types.KotlinType> computeType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ArrayValue(java.util.List<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> value, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, ? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> computeType) {
        super(value);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(computeType, "computeType");
        this.computeType = computeType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getType(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeInvoke = this.computeType.invoke(module);
        if (!kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArray(kotlinTypeInvoke) && !kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isPrimitiveArray(kotlinTypeInvoke)) {
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isUnsignedArrayType(kotlinTypeInvoke);
        }
        return kotlinTypeInvoke;
    }
}
