package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

/* JADX INFO: compiled from: RawProjectionComputer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RawProjectionComputer extends kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer {

    /* JADX INFO: compiled from: RawProjectionComputer.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer
    public kotlin.reflect.jvm.internal.impl.types.TypeProjection computeProjection(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor parameter, kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes typeAttr, kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, kotlin.reflect.jvm.internal.impl.types.KotlinType erasedUpperBound) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameter, "parameter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameterUpperBoundEraser, "typeParameterUpperBoundEraser");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(erasedUpperBound, "erasedUpperBound");
        if (!(typeAttr instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes)) {
            return super.computeProjection(parameter, typeAttr, typeParameterUpperBoundEraser, erasedUpperBound);
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributesWithFlexibility = (kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes) typeAttr;
        if (!javaTypeAttributesWithFlexibility.isRaw()) {
            javaTypeAttributesWithFlexibility = javaTypeAttributesWithFlexibility.withFlexibility(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.INFLEXIBLE);
        }
        int i = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawProjectionComputer.WhenMappings.$EnumSwitchMapping$0[javaTypeAttributesWithFlexibility.getFlexibility().ordinal()];
        if (i == 1) {
            return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT, erasedUpperBound);
        }
        if (i != 2 && i != 3) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        if (!parameter.getVariance().getAllowsOutPosition()) {
            return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(parameter).getNothingType());
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = erasedUpperBound.getConstructor().getParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
        if (!parameters.isEmpty()) {
            return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE, erasedUpperBound);
        }
        kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjectionMakeStarProjection = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeStarProjection(parameter, javaTypeAttributesWithFlexibility);
        kotlin.jvm.internal.Intrinsics.checkNotNull(typeProjectionMakeStarProjection);
        return typeProjectionMakeStarProjection;
    }
}
