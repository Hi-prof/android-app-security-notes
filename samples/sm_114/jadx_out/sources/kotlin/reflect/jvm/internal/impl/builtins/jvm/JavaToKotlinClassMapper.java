package kotlin.reflect.jvm.internal.impl.builtins.jvm;

/* JADX INFO: compiled from: JavaToKotlinClassMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaToKotlinClassMapper {
    public static final kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper INSTANCE = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper();

    private JavaToKotlinClassMapper() {
    }

    public final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> mapPlatformClass(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorMapJavaToKotlin$default = mapJavaToKotlin$default(this, fqName, builtIns, null, 4, null);
        if (classDescriptorMapJavaToKotlin$default == null) {
            return kotlin.collections.SetsKt.emptySet();
        }
        kotlin.reflect.jvm.internal.impl.name.FqName onlyToMutable = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(classDescriptorMapJavaToKotlin$default));
        return onlyToMutable == null ? kotlin.collections.SetsKt.setOf(classDescriptorMapJavaToKotlin$default) : kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor[]{classDescriptorMapJavaToKotlin$default, builtIns.getBuiltInClassByFqName(onlyToMutable)});
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor mapJavaToKotlin$default(kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper javaToKotlinClassMapper, kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns kotlinBuiltIns, java.lang.Integer num, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return javaToKotlinClassMapper.mapJavaToKotlin(fqName, kotlinBuiltIns, num);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor mapJavaToKotlin(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns, java.lang.Integer num) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        kotlin.reflect.jvm.internal.impl.name.ClassId classIdMapJavaToKotlin = (num == null || !kotlin.jvm.internal.Intrinsics.areEqual(fqName, kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME())) ? kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(fqName) : kotlin.reflect.jvm.internal.impl.builtins.StandardNames.getFunctionClassId(num.intValue());
        if (classIdMapJavaToKotlin != null) {
            return builtIns.getBuiltInClassByFqName(classIdMapJavaToKotlin.asSingleFqName());
        }
        return null;
    }

    public final boolean isMutable(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor mutable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mutable, "mutable");
        return kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.isMutable(kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getFqName(mutable));
    }

    public final boolean isReadOnly(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor readOnly) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(readOnly, "readOnly");
        return kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.isReadOnly(kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getFqName(readOnly));
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor convertMutableToReadOnly(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor mutable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mutable, "mutable");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = mutable;
        kotlin.reflect.jvm.internal.impl.name.FqName fqNameMutableToReadOnly = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.mutableToReadOnly(kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getFqName(classDescriptor));
        if (fqNameMutableToReadOnly == null) {
            throw new java.lang.IllegalArgumentException("Given class " + mutable + " is not a mutable collection");
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor builtInClassByFqName = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(classDescriptor).getBuiltInClassByFqName(fqNameMutableToReadOnly);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "getBuiltInClassByFqName(...)");
        return builtInClassByFqName;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor convertReadOnlyToMutable(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor readOnly) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(readOnly, "readOnly");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = readOnly;
        kotlin.reflect.jvm.internal.impl.name.FqName onlyToMutable = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getFqName(classDescriptor));
        if (onlyToMutable == null) {
            throw new java.lang.IllegalArgumentException("Given class " + readOnly + " is not a read-only collection");
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor builtInClassByFqName = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(classDescriptor).getBuiltInClassByFqName(onlyToMutable);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "getBuiltInClassByFqName(...)");
        return builtInClassByFqName;
    }
}
