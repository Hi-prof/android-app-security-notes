package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: JavaDefaultQualifiers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaDefaultQualifiers {
    private final boolean definitelyNotNull;
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifier;
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers copy$default(kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers javaDefaultQualifiers, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, java.util.Collection collection, boolean z, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifierWithMigrationStatus = javaDefaultQualifiers.nullabilityQualifier;
        }
        if ((i & 2) != 0) {
            collection = javaDefaultQualifiers.qualifierApplicabilityTypes;
        }
        if ((i & 4) != 0) {
            z = javaDefaultQualifiers.definitelyNotNull;
        }
        return javaDefaultQualifiers.copy(nullabilityQualifierWithMigrationStatus, collection, z);
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers copy(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifier, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nullabilityQualifier, "nullabilityQualifier");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        return new kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers(nullabilityQualifier, qualifierApplicabilityTypes, z);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers javaDefaultQualifiers = (kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers) obj;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.nullabilityQualifier, javaDefaultQualifiers.nullabilityQualifier) && kotlin.jvm.internal.Intrinsics.areEqual(this.qualifierApplicabilityTypes, javaDefaultQualifiers.qualifierApplicabilityTypes) && this.definitelyNotNull == javaDefaultQualifiers.definitelyNotNull;
    }

    public int hashCode() {
        return (((this.nullabilityQualifier.hashCode() * 31) + this.qualifierApplicabilityTypes.hashCode()) * 31) + kotlin.UByte$$ExternalSyntheticBackport0.m(this.definitelyNotNull);
    }

    public java.lang.String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.nullabilityQualifier + ", qualifierApplicabilityTypes=" + this.qualifierApplicabilityTypes + ", definitelyNotNull=" + this.definitelyNotNull + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaDefaultQualifiers(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifier, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nullabilityQualifier, "nullabilityQualifier");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(qualifierApplicabilityTypes, "qualifierApplicabilityTypes");
        this.nullabilityQualifier = nullabilityQualifier;
        this.qualifierApplicabilityTypes = qualifierApplicabilityTypes;
        this.definitelyNotNull = z;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus getNullabilityQualifier() {
        return this.nullabilityQualifier;
    }

    public final java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> getQualifierApplicabilityTypes() {
        return this.qualifierApplicabilityTypes;
    }

    public /* synthetic */ JavaDefaultQualifiers(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, java.util.Collection collection, boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifierWithMigrationStatus, collection, (i & 4) != 0 ? nullabilityQualifierWithMigrationStatus.getQualifier() == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL : z);
    }

    public final boolean getDefinitelyNotNull() {
        return this.definitelyNotNull;
    }
}
