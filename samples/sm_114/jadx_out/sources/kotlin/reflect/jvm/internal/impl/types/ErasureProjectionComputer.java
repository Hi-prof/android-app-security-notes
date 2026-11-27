package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: ErasureProjectionComputer.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ErasureProjectionComputer {
    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.types.TypeProjection computeProjection$default(kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer erasureProjectionComputer, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor, kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes erasureTypeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: computeProjection");
        }
        if ((i & 8) != 0) {
            kotlinType = typeParameterUpperBoundEraser.getErasedUpperBound(typeParameterDescriptor, erasureTypeAttributes);
        }
        return erasureProjectionComputer.computeProjection(typeParameterDescriptor, erasureTypeAttributes, typeParameterUpperBoundEraser, kotlinType);
    }

    public kotlin.reflect.jvm.internal.impl.types.TypeProjection computeProjection(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor parameter, kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes typeAttr, kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, kotlin.reflect.jvm.internal.impl.types.KotlinType erasedUpperBound) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameter, "parameter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAttr, "typeAttr");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameterUpperBoundEraser, "typeParameterUpperBoundEraser");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(erasedUpperBound, "erasedUpperBound");
        return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE, erasedUpperBound);
    }
}
