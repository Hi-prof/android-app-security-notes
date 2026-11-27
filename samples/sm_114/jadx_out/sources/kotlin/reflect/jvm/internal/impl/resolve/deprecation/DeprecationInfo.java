package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

/* JADX INFO: compiled from: DeprecationInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DeprecationInfo implements java.lang.Comparable<kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationInfo> {
    public abstract kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationLevelValue getDeprecationLevel();

    public abstract boolean getPropagatesToOverrides();

    @Override // java.lang.Comparable
    public int compareTo(kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationInfo other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        int iCompareTo = getDeprecationLevel().compareTo(other.getDeprecationLevel());
        if (iCompareTo == 0 && !getPropagatesToOverrides() && other.getPropagatesToOverrides()) {
            return 1;
        }
        return iCompareTo;
    }
}
