package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: typeSignatureMapping.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeSignatureMappingKt {
    public static final <T> T boxTypeIfNeeded(kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory<T> jvmTypeFactory, T possiblyPrimitiveType, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jvmTypeFactory, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(possiblyPrimitiveType, "possiblyPrimitiveType");
        return z ? jvmTypeFactory.boxType(possiblyPrimitiveType) : possiblyPrimitiveType;
    }

    public static final <T> T mapBuiltInType(kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext typeSystemCommonBackendContext, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory<T> typeFactory, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode mode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeFactory, "typeFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mode, "mode");
        kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker typeConstructorMarkerTypeConstructor = typeSystemCommonBackendContext.typeConstructor(type);
        if (!typeSystemCommonBackendContext.isClassTypeConstructor(typeConstructorMarkerTypeConstructor)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType = typeSystemCommonBackendContext.getPrimitiveType(typeConstructorMarkerTypeConstructor);
        if (primitiveType != null) {
            return (T) boxTypeIfNeeded(typeFactory, typeFactory.createPrimitiveType(primitiveType), typeSystemCommonBackendContext.isNullableType(type) || kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt.hasEnhancedNullability(typeSystemCommonBackendContext, type));
        }
        kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveArrayType = typeSystemCommonBackendContext.getPrimitiveArrayType(typeConstructorMarkerTypeConstructor);
        if (primitiveArrayType != null) {
            return typeFactory.createFromString(com.taobao.weex.el.parse.Operators.ARRAY_START_STR + kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.get(primitiveArrayType).getDesc());
        }
        if (typeSystemCommonBackendContext.isUnderKotlinPackage(typeConstructorMarkerTypeConstructor)) {
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe classFqNameUnsafe = typeSystemCommonBackendContext.getClassFqNameUnsafe(typeConstructorMarkerTypeConstructor);
            kotlin.reflect.jvm.internal.impl.name.ClassId classIdMapKotlinToJava = classFqNameUnsafe != null ? kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(classFqNameUnsafe) : null;
            if (classIdMapKotlinToJava != null) {
                if (!mode.getKotlinCollectionsToJavaCollections()) {
                    java.util.List<kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping> mutabilityMappings = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
                    if (!(mutabilityMappings instanceof java.util.Collection) || !mutabilityMappings.isEmpty()) {
                        java.util.Iterator<T> it = mutabilityMappings.iterator();
                        while (it.hasNext()) {
                            if (kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping) it.next()).getJavaClass(), classIdMapKotlinToJava)) {
                                return null;
                            }
                        }
                    }
                }
                java.lang.String strInternalNameByClassId = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.internalNameByClassId(classIdMapKotlinToJava);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strInternalNameByClassId, "internalNameByClassId(...)");
                return typeFactory.createObjectType(strInternalNameByClassId);
            }
        }
        return null;
    }
}
