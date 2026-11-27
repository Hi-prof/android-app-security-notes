package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmFlexibleTypeUpperBound {
    public static final kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound.Companion Companion = new kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound.Companion(null);
    private kotlin.reflect.jvm.internal.impl.km.KmType type;
    private java.lang.String typeFlexibilityId;

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound = (kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound) obj;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.type, kmFlexibleTypeUpperBound.type) && kotlin.jvm.internal.Intrinsics.areEqual(this.typeFlexibilityId, kmFlexibleTypeUpperBound.typeFlexibilityId);
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        java.lang.String str = this.typeFlexibilityId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public java.lang.String toString() {
        return "KmFlexibleTypeUpperBound(type=" + this.type + ", typeFlexibilityId=" + this.typeFlexibilityId + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    public KmFlexibleTypeUpperBound(kotlin.reflect.jvm.internal.impl.km.KmType type, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.typeFlexibilityId = str;
    }

    public final kotlin.reflect.jvm.internal.impl.km.KmType getType() {
        return this.type;
    }

    public final java.lang.String getTypeFlexibilityId() {
        return this.typeFlexibilityId;
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
