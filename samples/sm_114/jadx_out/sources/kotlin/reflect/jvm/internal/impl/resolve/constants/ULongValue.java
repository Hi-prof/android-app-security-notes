package kotlin.reflect.jvm.internal.impl.resolve.constants;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ULongValue extends kotlin.reflect.jvm.internal.impl.resolve.constants.UnsignedValueConstant<java.lang.Long> {
    public ULongValue(long j) {
        super(java.lang.Long.valueOf(j));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getType(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module) {
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findClassAcrossModuleDependencies(module, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.uLong);
        return (classDescriptorFindClassAcrossModuleDependencies == null || (defaultType = classDescriptorFindClassAcrossModuleDependencies.getDefaultType()) == null) ? kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.NOT_FOUND_UNSIGNED_TYPE, "ULong") : defaultType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public java.lang.String toString() {
        return getValue().longValue() + ".toULong()";
    }
}
