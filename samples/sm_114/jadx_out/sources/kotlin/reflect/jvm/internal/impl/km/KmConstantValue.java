package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Contracts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmConstantValue {
    private final java.lang.Object value;

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmConstantValue) && kotlin.jvm.internal.Intrinsics.areEqual(this.value, ((kotlin.reflect.jvm.internal.impl.km.KmConstantValue) obj).value);
    }

    public int hashCode() {
        java.lang.Object obj = this.value;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public java.lang.String toString() {
        return "KmConstantValue(value=" + this.value + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    public KmConstantValue(java.lang.Object obj) {
        this.value = obj;
    }
}
