package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TypeProjectionBase implements kotlin.reflect.jvm.internal.impl.types.TypeProjection {
    public java.lang.String toString() {
        if (isStarProjection()) {
            return "*";
        }
        if (getProjectionKind() == kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT) {
            return getType().toString();
        }
        return getProjectionKind() + com.taobao.weex.el.parse.Operators.SPACE_STR + getType();
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.types.TypeProjection)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) obj;
        return isStarProjection() == typeProjection.isStarProjection() && getProjectionKind() == typeProjection.getProjectionKind() && getType().equals(typeProjection.getType());
    }

    public int hashCode() {
        int iHashCode = getProjectionKind().hashCode();
        if (kotlin.reflect.jvm.internal.impl.types.TypeUtils.noExpectedType(getType())) {
            return (iHashCode * 31) + 19;
        }
        return (iHashCode * 31) + (isStarProjection() ? 17 : getType().hashCode());
    }
}
