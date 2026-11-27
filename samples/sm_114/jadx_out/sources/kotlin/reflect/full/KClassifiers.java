package kotlin.reflect.full;

/* JADX INFO: compiled from: KClassifiers.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0007\u001a.\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\"\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"createType", "Lkotlin/reflect/KType;", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "nullable", "", "annotations", "", "createKotlinType", "Lkotlin/reflect/jvm/internal/impl/types/SimpleType;", "attributes", "Lkotlin/reflect/jvm/internal/impl/types/TypeAttributes;", "typeConstructor", "Lkotlin/reflect/jvm/internal/impl/types/TypeConstructor;", "starProjectedType", "getStarProjectedType$annotations", "(Lkotlin/reflect/KClassifier;)V", "getStarProjectedType", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KType;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KClassifiers {

    /* JADX INFO: compiled from: KClassifiers.kt */
    @kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.KVariance.values().length];
            try {
                iArr[kotlin.reflect.KVariance.INVARIANT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.KVariance.IN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.KVariance.OUT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getStarProjectedType$annotations(kotlin.reflect.KClassifier kClassifier) {
    }

    public static /* synthetic */ kotlin.reflect.KType createType$default(kotlin.reflect.KClassifier kClassifier, java.util.List list, boolean z, java.util.List list2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            list = kotlin.collections.CollectionsKt.emptyList();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            list2 = kotlin.collections.CollectionsKt.emptyList();
        }
        return createType(kClassifier, list, z, list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final kotlin.reflect.KType createType(kotlin.reflect.KClassifier kClassifier, java.util.List<kotlin.reflect.KTypeProjection> arguments, boolean z, java.util.List<? extends java.lang.annotation.Annotation> annotations) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor descriptor;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClassifier, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        kotlin.jvm.functions.Function0 function0 = null;
        java.lang.Object[] objArr = 0;
        kotlin.reflect.jvm.internal.KClassifierImpl kClassifierImpl = kClassifier instanceof kotlin.reflect.jvm.internal.KClassifierImpl ? (kotlin.reflect.jvm.internal.KClassifierImpl) kClassifier : null;
        if (kClassifierImpl == null || (descriptor = kClassifierImpl.getDescriptor()) == null) {
            throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + kClassifier + " (" + kClassifier.getClass() + com.taobao.weex.el.parse.Operators.BRACKET_END);
        }
        kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = descriptor.getTypeConstructor();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
        if (parameters.size() != arguments.size()) {
            throw new java.lang.IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + arguments.size() + " were provided.");
        }
        return new kotlin.reflect.jvm.internal.KTypeImpl(createKotlinType(annotations.isEmpty() ? kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion.getEmpty() : kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion.getEmpty(), typeConstructor, arguments, z), function0, 2, objArr == true ? 1 : 0);
    }

    private static final kotlin.reflect.jvm.internal.impl.types.SimpleType createKotlinType(kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, java.util.List<kotlin.reflect.KTypeProjection> list, boolean z) {
        kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase starProjectionImpl;
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
        java.util.List<kotlin.reflect.KTypeProjection> list2 = list;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i = 0;
        for (java.lang.Object obj : list2) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            kotlin.reflect.KTypeProjection kTypeProjection = (kotlin.reflect.KTypeProjection) obj;
            kotlin.reflect.jvm.internal.KTypeImpl kTypeImpl = (kotlin.reflect.jvm.internal.KTypeImpl) kTypeProjection.getType();
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = kTypeImpl != null ? kTypeImpl.getType() : null;
            kotlin.reflect.KVariance variance = kTypeProjection.getVariance();
            int i3 = variance == null ? -1 : kotlin.reflect.full.KClassifiers.WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
            if (i3 == -1) {
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor = parameters.get(i);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "get(...)");
                starProjectionImpl = new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl(typeParameterDescriptor);
            } else if (i3 == 1) {
                kotlin.reflect.jvm.internal.impl.types.Variance variance2 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT;
                kotlin.jvm.internal.Intrinsics.checkNotNull(type);
                starProjectionImpl = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(variance2, type);
            } else if (i3 == 2) {
                kotlin.reflect.jvm.internal.impl.types.Variance variance3 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE;
                kotlin.jvm.internal.Intrinsics.checkNotNull(type);
                starProjectionImpl = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(variance3, type);
            } else {
                if (i3 != 3) {
                    throw new kotlin.NoWhenBranchMatchedException();
                }
                kotlin.reflect.jvm.internal.impl.types.Variance variance4 = kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE;
                kotlin.jvm.internal.Intrinsics.checkNotNull(type);
                starProjectionImpl = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(variance4, type);
            }
            arrayList.add(starProjectionImpl);
            i = i2;
        }
        return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleType$default(typeAttributes, typeConstructor, arrayList, z, (kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner) null, 16, (java.lang.Object) null);
    }

    public static final kotlin.reflect.KType getStarProjectedType(kotlin.reflect.KClassifier kClassifier) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor descriptor;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClassifier, "<this>");
        kotlin.reflect.jvm.internal.KClassifierImpl kClassifierImpl = kClassifier instanceof kotlin.reflect.jvm.internal.KClassifierImpl ? (kotlin.reflect.jvm.internal.KClassifierImpl) kClassifier : null;
        if (kClassifierImpl == null || (descriptor = kClassifierImpl.getDescriptor()) == null) {
            return createType$default(kClassifier, null, false, null, 7, null);
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = descriptor.getTypeConstructor().getParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
        if (parameters.isEmpty()) {
            return createType$default(kClassifier, null, false, null, 7, null);
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list = parameters;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor : list) {
            arrayList.add(kotlin.reflect.KTypeProjection.INSTANCE.getSTAR());
        }
        return createType$default(kClassifier, arrayList, false, null, 6, null);
    }
}
