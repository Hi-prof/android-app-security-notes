package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

/* JADX INFO: compiled from: JavaTypeAttributes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaTypeAttributes extends kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes {
    private final kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility flexibility;
    private final kotlin.reflect.jvm.internal.impl.types.TypeUsage howThisTypeIsUsed;
    private final boolean isForAnnotationParameter;
    private final boolean isRaw;
    private final java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> visitedTypeParameters;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes copy$default(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeUsage typeUsage, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility javaTypeFlexibility, boolean z, boolean z2, java.util.Set set, kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            typeUsage = javaTypeAttributes.howThisTypeIsUsed;
        }
        if ((i & 2) != 0) {
            javaTypeFlexibility = javaTypeAttributes.flexibility;
        }
        if ((i & 4) != 0) {
            z = javaTypeAttributes.isRaw;
        }
        if ((i & 8) != 0) {
            z2 = javaTypeAttributes.isForAnnotationParameter;
        }
        if ((i & 16) != 0) {
            set = javaTypeAttributes.visitedTypeParameters;
        }
        if ((i & 32) != 0) {
            simpleType = javaTypeAttributes.defaultType;
        }
        java.util.Set set2 = set;
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType2 = simpleType;
        return javaTypeAttributes.copy(typeUsage, javaTypeFlexibility, z, z2, set2, simpleType2);
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes copy(kotlin.reflect.jvm.internal.impl.types.TypeUsage howThisTypeIsUsed, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility flexibility, boolean z, boolean z2, java.util.Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> set, kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(howThisTypeIsUsed, "howThisTypeIsUsed");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(flexibility, "flexibility");
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes(howThisTypeIsUsed, flexibility, z, z2, set, simpleType);
    }

    public java.lang.String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.howThisTypeIsUsed + ", flexibility=" + this.flexibility + ", isRaw=" + this.isRaw + ", isForAnnotationParameter=" + this.isForAnnotationParameter + ", visitedTypeParameters=" + this.visitedTypeParameters + ", defaultType=" + this.defaultType + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public kotlin.reflect.jvm.internal.impl.types.TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    public /* synthetic */ JavaTypeAttributes(kotlin.reflect.jvm.internal.impl.types.TypeUsage typeUsage, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility javaTypeFlexibility, boolean z, boolean z2, java.util.Set set, kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(typeUsage, (i & 2) != 0 ? kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : set, (i & 32) != 0 ? null : simpleType);
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility getFlexibility() {
        return this.flexibility;
    }

    public final boolean isRaw() {
        return this.isRaw;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public kotlin.reflect.jvm.internal.impl.types.SimpleType getDefaultType() {
        return this.defaultType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeAttributes(kotlin.reflect.jvm.internal.impl.types.TypeUsage howThisTypeIsUsed, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility flexibility, boolean z, boolean z2, java.util.Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> set, kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType) {
        super(howThisTypeIsUsed, set, simpleType);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(howThisTypeIsUsed, "howThisTypeIsUsed");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(flexibility, "flexibility");
        this.howThisTypeIsUsed = howThisTypeIsUsed;
        this.flexibility = flexibility;
        this.isRaw = z;
        this.isForAnnotationParameter = z2;
        this.visitedTypeParameters = set;
        this.defaultType = simpleType;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes withFlexibility(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility flexibility) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(flexibility, "flexibility");
        return copy$default(this, null, flexibility, false, false, null, null, 61, null);
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes markIsRaw(boolean z) {
        return copy$default(this, null, null, z, false, null, null, 59, null);
    }

    public kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes withDefaultType(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType) {
        return copy$default(this, null, null, false, false, null, simpleType, 31, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes withNewVisitedTypeParameter(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        return copy$default(this, null, null, false, false, getVisitedTypeParameters() != null ? kotlin.collections.SetsKt.plus(getVisitedTypeParameters(), typeParameter) : kotlin.collections.SetsKt.setOf(typeParameter), null, 47, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes javaTypeAttributes = (kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes) obj;
        return kotlin.jvm.internal.Intrinsics.areEqual(javaTypeAttributes.getDefaultType(), getDefaultType()) && javaTypeAttributes.getHowThisTypeIsUsed() == getHowThisTypeIsUsed() && javaTypeAttributes.flexibility == this.flexibility && javaTypeAttributes.isRaw == this.isRaw && javaTypeAttributes.isForAnnotationParameter == this.isForAnnotationParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErasureTypeAttributes
    public int hashCode() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = getDefaultType();
        int iHashCode = defaultType != null ? defaultType.hashCode() : 0;
        int iHashCode2 = iHashCode + (iHashCode * 31) + getHowThisTypeIsUsed().hashCode();
        int iHashCode3 = iHashCode2 + (iHashCode2 * 31) + this.flexibility.hashCode();
        int i = iHashCode3 + (iHashCode3 * 31) + (this.isRaw ? 1 : 0);
        return i + (i * 31) + (this.isForAnnotationParameter ? 1 : 0);
    }
}
