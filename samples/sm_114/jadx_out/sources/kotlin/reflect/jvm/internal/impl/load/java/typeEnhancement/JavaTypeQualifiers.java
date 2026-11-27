package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: typeQualifiers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaTypeQualifiers {
    public static final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers.Companion Companion = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers.Companion(null);
    private static final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers NONE = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers(null, null, false, false, 8, null);
    private final boolean definitelyNotNull;
    private final boolean isNullabilityQualifierForWarning;
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier mutability;
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullability;

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers copy$default(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullabilityQualifier, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier mutabilityQualifier, boolean z, boolean z2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifier = javaTypeQualifiers.nullability;
        }
        if ((i & 2) != 0) {
            mutabilityQualifier = javaTypeQualifiers.mutability;
        }
        if ((i & 4) != 0) {
            z = javaTypeQualifiers.definitelyNotNull;
        }
        if ((i & 8) != 0) {
            z2 = javaTypeQualifiers.isNullabilityQualifierForWarning;
        }
        return javaTypeQualifiers.copy(nullabilityQualifier, mutabilityQualifier, z, z2);
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers copy(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullabilityQualifier, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, z, z2);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers javaTypeQualifiers = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) obj;
        return this.nullability == javaTypeQualifiers.nullability && this.mutability == javaTypeQualifiers.mutability && this.definitelyNotNull == javaTypeQualifiers.definitelyNotNull && this.isNullabilityQualifierForWarning == javaTypeQualifiers.isNullabilityQualifierForWarning;
    }

    public int hashCode() {
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullabilityQualifier = this.nullability;
        int iHashCode = (nullabilityQualifier == null ? 0 : nullabilityQualifier.hashCode()) * 31;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier mutabilityQualifier = this.mutability;
        return ((((iHashCode + (mutabilityQualifier != null ? mutabilityQualifier.hashCode() : 0)) * 31) + kotlin.UByte$$ExternalSyntheticBackport0.m(this.definitelyNotNull)) * 31) + kotlin.UByte$$ExternalSyntheticBackport0.m(this.isNullabilityQualifierForWarning);
    }

    public java.lang.String toString() {
        return "JavaTypeQualifiers(nullability=" + this.nullability + ", mutability=" + this.mutability + ", definitelyNotNull=" + this.definitelyNotNull + ", isNullabilityQualifierForWarning=" + this.isNullabilityQualifierForWarning + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    public JavaTypeQualifiers(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullabilityQualifier, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        this.nullability = nullabilityQualifier;
        this.mutability = mutabilityQualifier;
        this.definitelyNotNull = z;
        this.isNullabilityQualifierForWarning = z2;
    }

    public /* synthetic */ JavaTypeQualifiers(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullabilityQualifier, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier mutabilityQualifier, boolean z, boolean z2, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifier, mutabilityQualifier, z, (i & 8) != 0 ? false : z2);
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier getNullability() {
        return this.nullability;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier getMutability() {
        return this.mutability;
    }

    public final boolean getDefinitelyNotNull() {
        return this.definitelyNotNull;
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.isNullabilityQualifierForWarning;
    }

    /* JADX INFO: compiled from: typeQualifiers.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers getNONE() {
            return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers.NONE;
        }
    }
}
