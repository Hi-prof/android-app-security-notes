package kotlin.reflect.jvm.internal.impl.resolve.constants;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FloatValue extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<java.lang.Float> {
    public FloatValue(float f) {
        super(java.lang.Float.valueOf(f));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public kotlin.reflect.jvm.internal.impl.types.SimpleType getType(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.reflect.jvm.internal.impl.types.SimpleType floatType = module.getBuiltIns().getFloatType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(floatType, "getFloatType(...)");
        return floatType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public java.lang.String toString() {
        return getValue().floatValue() + ".toFloat()";
    }
}
