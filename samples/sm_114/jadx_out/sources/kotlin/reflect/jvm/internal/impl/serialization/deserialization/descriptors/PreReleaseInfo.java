package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

/* JADX INFO: compiled from: DeserializedContainerSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PreReleaseInfo {
    public static final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo.Companion Companion = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo.Companion(null);
    private static final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo DEFAULT_VISIBLE = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo(false, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
    private final boolean isInvisible;
    private final java.util.List<java.lang.String> poisoningFeatures;

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo preReleaseInfo = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.PreReleaseInfo) obj;
        return this.isInvisible == preReleaseInfo.isInvisible && kotlin.jvm.internal.Intrinsics.areEqual(this.poisoningFeatures, preReleaseInfo.poisoningFeatures);
    }

    public int hashCode() {
        return (kotlin.UByte$$ExternalSyntheticBackport0.m(this.isInvisible) * 31) + this.poisoningFeatures.hashCode();
    }

    public java.lang.String toString() {
        return "PreReleaseInfo(isInvisible=" + this.isInvisible + ", poisoningFeatures=" + this.poisoningFeatures + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    /* JADX INFO: compiled from: DeserializedContainerSource.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PreReleaseInfo(boolean z, java.util.List<java.lang.String> poisoningFeatures) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(poisoningFeatures, "poisoningFeatures");
        this.isInvisible = z;
        this.poisoningFeatures = poisoningFeatures;
    }

    public /* synthetic */ PreReleaseInfo(boolean z, java.util.List list, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? kotlin.collections.CollectionsKt.emptyList() : list);
    }
}
