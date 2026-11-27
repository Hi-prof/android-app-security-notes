package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmTypeProjection {
    public static final kotlin.reflect.jvm.internal.impl.km.KmTypeProjection.Companion Companion = new kotlin.reflect.jvm.internal.impl.km.KmTypeProjection.Companion(null);
    public static final kotlin.reflect.jvm.internal.impl.km.KmTypeProjection STAR = new kotlin.reflect.jvm.internal.impl.km.KmTypeProjection(null, null);
    private kotlin.reflect.jvm.internal.impl.km.KmType type;
    private kotlin.reflect.jvm.internal.impl.km.KmVariance variance;

    public final kotlin.reflect.jvm.internal.impl.km.KmVariance component1() {
        return this.variance;
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmType component2() {
        return this.type;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.km.KmTypeProjection)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.km.KmTypeProjection kmTypeProjection = (kotlin.reflect.jvm.internal.impl.km.KmTypeProjection) obj;
        return this.variance == kmTypeProjection.variance && kotlin.jvm.internal.Intrinsics.areEqual(this.type, kmTypeProjection.type);
    }

    public int hashCode() {
        kotlin.reflect.jvm.internal.impl.km.KmVariance kmVariance = this.variance;
        int iHashCode = (kmVariance == null ? 0 : kmVariance.hashCode()) * 31;
        kotlin.reflect.jvm.internal.impl.km.KmType kmType = this.type;
        return iHashCode + (kmType != null ? kmType.hashCode() : 0);
    }

    public java.lang.String toString() {
        return "KmTypeProjection(variance=" + this.variance + ", type=" + this.type + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    public KmTypeProjection(kotlin.reflect.jvm.internal.impl.km.KmVariance kmVariance, kotlin.reflect.jvm.internal.impl.km.KmType kmType) {
        this.variance = kmVariance;
        this.type = kmType;
    }

    /* JADX INFO: compiled from: Nodes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
