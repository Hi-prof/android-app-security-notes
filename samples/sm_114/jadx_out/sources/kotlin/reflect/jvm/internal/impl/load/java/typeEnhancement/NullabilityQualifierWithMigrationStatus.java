package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: NullabilityQualifierWithMigrationStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NullabilityQualifierWithMigrationStatus {
    private final boolean isForWarningOnly;
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier qualifier;

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus copy$default(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullabilityQualifier, boolean z, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifier = nullabilityQualifierWithMigrationStatus.qualifier;
        }
        if ((i & 2) != 0) {
            z = nullabilityQualifierWithMigrationStatus.isForWarningOnly;
        }
        return nullabilityQualifierWithMigrationStatus.copy(nullabilityQualifier, z);
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus copy(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier qualifier, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus(qualifier, z);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus) obj;
        return this.qualifier == nullabilityQualifierWithMigrationStatus.qualifier && this.isForWarningOnly == nullabilityQualifierWithMigrationStatus.isForWarningOnly;
    }

    public int hashCode() {
        return (this.qualifier.hashCode() * 31) + kotlin.UByte$$ExternalSyntheticBackport0.m(this.isForWarningOnly);
    }

    public java.lang.String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.qualifier + ", isForWarningOnly=" + this.isForWarningOnly + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    public NullabilityQualifierWithMigrationStatus(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier qualifier, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        this.qualifier = qualifier;
        this.isForWarningOnly = z;
    }

    public /* synthetic */ NullabilityQualifierWithMigrationStatus(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier nullabilityQualifier, boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifier, (i & 2) != 0 ? false : z);
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier getQualifier() {
        return this.qualifier;
    }

    public final boolean isForWarningOnly() {
        return this.isForWarningOnly;
    }
}
