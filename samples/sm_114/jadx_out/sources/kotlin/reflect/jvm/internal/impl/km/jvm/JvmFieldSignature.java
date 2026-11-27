package kotlin.reflect.jvm.internal.impl.km.jvm;

/* JADX INFO: compiled from: JvmMemberSignature.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmFieldSignature extends kotlin.reflect.jvm.internal.impl.km.jvm.JvmMemberSignature {
    private final java.lang.String descriptor;
    private final java.lang.String name;

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature jvmFieldSignature = (kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature) obj;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.name, jvmFieldSignature.name) && kotlin.jvm.internal.Intrinsics.areEqual(this.descriptor, jvmFieldSignature.descriptor);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.descriptor.hashCode();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmFieldSignature(java.lang.String name, java.lang.String descriptor) {
        super(null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.name = name;
        this.descriptor = descriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.jvm.JvmMemberSignature
    public java.lang.String getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.jvm.JvmMemberSignature
    public java.lang.String getName() {
        return this.name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.jvm.JvmMemberSignature
    public java.lang.String toString() {
        return getName() + com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE + getDescriptor();
    }
}
