package kotlin.reflect.jvm.internal.impl.resolve.constants;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShortValue extends kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueConstant<java.lang.Short> {
    public ShortValue(short s) {
        super(java.lang.Short.valueOf(s));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public kotlin.reflect.jvm.internal.impl.types.SimpleType getType(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.reflect.jvm.internal.impl.types.SimpleType shortType = module.getBuiltIns().getShortType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(shortType, "getShortType(...)");
        return shortType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public java.lang.String toString() {
        return getValue().intValue() + ".toShort()";
    }
}
