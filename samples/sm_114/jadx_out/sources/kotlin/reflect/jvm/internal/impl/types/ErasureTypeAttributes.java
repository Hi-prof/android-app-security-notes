package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: ErasureTypeAttributes.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ErasureTypeAttributes {
    private final kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType;
    private final kotlin.reflect.jvm.internal.impl.types.TypeUsage howThisTypeIsUsed;
    private final java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> visitedTypeParameters;

    /* JADX WARN: Multi-variable type inference failed */
    public ErasureTypeAttributes(kotlin.reflect.jvm.internal.impl.types.TypeUsage howThisTypeIsUsed, java.util.Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> set, kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(howThisTypeIsUsed, "howThisTypeIsUsed");
        this.howThisTypeIsUsed = howThisTypeIsUsed;
        this.visitedTypeParameters = set;
        this.defaultType = simpleType;
    }

    public kotlin.reflect.jvm.internal.impl.types.TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    public java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getDefaultType() {
        return this.defaultType;
    }

    public kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes withNewVisitedTypeParameter(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameter) {
        java.util.Set of;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        kotlin.reflect.jvm.internal.impl.types.TypeUsage howThisTypeIsUsed = getHowThisTypeIsUsed();
        java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> visitedTypeParameters = getVisitedTypeParameters();
        if (visitedTypeParameters == null || (of = kotlin.collections.SetsKt.plus(visitedTypeParameters, typeParameter)) == null) {
            of = kotlin.collections.SetsKt.setOf(typeParameter);
        }
        return new kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes(howThisTypeIsUsed, of, getDefaultType());
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes erasureTypeAttributes = (kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes) obj;
        return kotlin.jvm.internal.Intrinsics.areEqual(erasureTypeAttributes.getDefaultType(), getDefaultType()) && erasureTypeAttributes.getHowThisTypeIsUsed() == getHowThisTypeIsUsed();
    }

    public int hashCode() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = getDefaultType();
        int iHashCode = defaultType != null ? defaultType.hashCode() : 0;
        return iHashCode + (iHashCode * 31) + getHowThisTypeIsUsed().hashCode();
    }
}
