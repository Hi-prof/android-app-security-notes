package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: typeOfImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0007H\u0002\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¨\u0006\t"}, d2 = {"createPlatformKType", "Lkotlin/reflect/KType;", "lowerBound", "upperBound", "createMutableCollectionKType", "type", "readOnlyToMutable", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "createNothingType", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TypeOfImplKt {
    public static final kotlin.reflect.KType createPlatformKType(kotlin.reflect.KType lowerBound, kotlin.reflect.KType upperBound) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(upperBound, "upperBound");
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = ((kotlin.reflect.jvm.internal.KTypeImpl) lowerBound).getType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(type, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        kotlin.reflect.jvm.internal.impl.types.KotlinType type2 = ((kotlin.reflect.jvm.internal.KTypeImpl) upperBound).getType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(type2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new kotlin.reflect.jvm.internal.KTypeImpl(kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType((kotlin.reflect.jvm.internal.impl.types.SimpleType) type, (kotlin.reflect.jvm.internal.impl.types.SimpleType) type2), null, 2, null);
    }

    public static final kotlin.reflect.KType createMutableCollectionKType(kotlin.reflect.KType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.reflect.jvm.internal.impl.types.KotlinType type2 = ((kotlin.reflect.jvm.internal.KTypeImpl) type).getType();
        if (!(type2 instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType)) {
            throw new java.lang.IllegalArgumentException(("Non-simple type cannot be a mutable collection type: " + type).toString());
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = type2.getConstructor().mo1835getDeclarationDescriptor();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null;
        if (classDescriptor == null) {
            throw new java.lang.IllegalArgumentException("Non-class type cannot be a mutable collection type: " + type);
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType = (kotlin.reflect.jvm.internal.impl.types.SimpleType) type2;
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = readOnlyToMutable(classDescriptor).getTypeConstructor();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return new kotlin.reflect.jvm.internal.KTypeImpl(kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(simpleType, (kotlin.reflect.jvm.internal.impl.types.TypeAttributes) null, typeConstructor, (java.util.List) null, false, 26, (java.lang.Object) null), null, 2, null);
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor readOnlyToMutable(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor2 = classDescriptor;
        kotlin.reflect.jvm.internal.impl.name.FqName onlyToMutable = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameUnsafe(classDescriptor2));
        if (onlyToMutable == null) {
            throw new java.lang.IllegalArgumentException("Not a readonly collection: " + classDescriptor);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor builtInClassByFqName = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(classDescriptor2).getBuiltInClassByFqName(onlyToMutable);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "getBuiltInClassByFqName(...)");
        return builtInClassByFqName;
    }

    public static final kotlin.reflect.KType createNothingType(kotlin.reflect.KType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.reflect.jvm.internal.impl.types.KotlinType type2 = ((kotlin.reflect.jvm.internal.KTypeImpl) type).getType();
        if (!(type2 instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType)) {
            throw new java.lang.IllegalArgumentException(("Non-simple type cannot be a Nothing type: " + type).toString());
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType = (kotlin.reflect.jvm.internal.impl.types.SimpleType) type2;
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getBuiltIns(type2).getNothing().getTypeConstructor();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return new kotlin.reflect.jvm.internal.KTypeImpl(kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(simpleType, (kotlin.reflect.jvm.internal.impl.types.TypeAttributes) null, typeConstructor, (java.util.List) null, false, 26, (java.lang.Object) null), null, 2, null);
    }
}
