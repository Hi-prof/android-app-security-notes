package kotlin.reflect.jvm.internal.impl.resolve.constants;

/* JADX INFO: compiled from: ClassLiteralValue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ClassLiteralValue {
    private final int arrayNestedness;
    private final kotlin.reflect.jvm.internal.impl.name.ClassId classId;

    public final kotlin.reflect.jvm.internal.impl.name.ClassId component1() {
        return this.classId;
    }

    public final int component2() {
        return this.arrayNestedness;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue classLiteralValue = (kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue) obj;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.classId, classLiteralValue.classId) && this.arrayNestedness == classLiteralValue.arrayNestedness;
    }

    public int hashCode() {
        return (this.classId.hashCode() * 31) + this.arrayNestedness;
    }

    public ClassLiteralValue(kotlin.reflect.jvm.internal.impl.name.ClassId classId, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
        this.classId = classId;
        this.arrayNestedness = i;
    }

    public final int getArrayNestedness() {
        return this.arrayNestedness;
    }

    public final kotlin.reflect.jvm.internal.impl.name.ClassId getClassId() {
        return this.classId;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = this.arrayNestedness;
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("kotlin/Array<");
        }
        sb.append(this.classId);
        int i3 = this.arrayNestedness;
        for (int i4 = 0; i4 < i3; i4++) {
            sb.append(com.taobao.weex.el.parse.Operators.G);
        }
        return sb.toString();
    }
}
