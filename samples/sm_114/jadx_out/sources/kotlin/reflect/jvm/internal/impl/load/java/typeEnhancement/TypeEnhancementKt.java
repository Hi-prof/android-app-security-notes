package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeEnhancementKt {
    private static final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancedTypeAnnotations ENHANCED_MUTABILITY_ANNOTATIONS;
    private static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations ENHANCED_NULLABILITY_ANNOTATIONS;

    /* JADX INFO: compiled from: typeEnhancement.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean hasEnhancedNullability(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt.hasEnhancedNullability(kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext.INSTANCE, kotlinType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations compositeAnnotationsOrSingle(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations> list) {
        int size = list.size();
        if (size == 0) {
            throw new java.lang.IllegalStateException("At least one Annotations object expected".toString());
        }
        if (size == 1) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) kotlin.collections.CollectionsKt.single((java.util.List) list);
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations((java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations>) kotlin.collections.CollectionsKt.toList(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor enhanceMutability(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptor, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition typeComponentPosition) {
        kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper javaToKotlinClassMapper = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper.INSTANCE;
        if (!kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPositionKt.shouldEnhance(typeComponentPosition) || !(classifierDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor)) {
            return null;
        }
        if (javaTypeQualifiers.getMutability() == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY && typeComponentPosition == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_LOWER) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptor;
            if (javaToKotlinClassMapper.isMutable(classDescriptor)) {
                return javaToKotlinClassMapper.convertMutableToReadOnly(classDescriptor);
            }
        }
        if (javaTypeQualifiers.getMutability() == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE && typeComponentPosition == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_UPPER) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptor;
            if (javaToKotlinClassMapper.isReadOnly(classDescriptor2)) {
                return javaToKotlinClassMapper.convertReadOnlyToMutable(classDescriptor2);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Boolean getEnhancedNullability(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition typeComponentPosition) {
        if (!kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPositionKt.shouldEnhance(typeComponentPosition)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullability = javaTypeQualifiers.getNullability();
        int i = nullability == null ? -1 : kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.WhenMappings.$EnumSwitchMapping$0[nullability.ordinal()];
        if (i != 1) {
            return i != 2 ? null : false;
        }
        return true;
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.FqName ENHANCED_NULLABILITY_ANNOTATION = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        ENHANCED_NULLABILITY_ANNOTATIONS = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancedTypeAnnotations(ENHANCED_NULLABILITY_ANNOTATION);
        kotlin.reflect.jvm.internal.impl.name.FqName ENHANCED_MUTABILITY_ANNOTATION = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ENHANCED_MUTABILITY_ANNOTATION, "ENHANCED_MUTABILITY_ANNOTATION");
        ENHANCED_MUTABILITY_ANNOTATIONS = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancedTypeAnnotations(ENHANCED_MUTABILITY_ANNOTATION);
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getENHANCED_NULLABILITY_ANNOTATIONS() {
        return ENHANCED_NULLABILITY_ANNOTATIONS;
    }
}
