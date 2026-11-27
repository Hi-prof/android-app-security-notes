package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

/* JADX INFO: compiled from: JvmMemberSignature.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class JvmMemberSignature {
    public /* synthetic */ JvmMemberSignature(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract java.lang.String asString();

    private JvmMemberSignature() {
    }

    /* JADX INFO: compiled from: JvmMemberSignature.kt */
    public static final class Method extends kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature {
        private final java.lang.String desc;
        private final java.lang.String name;

        public static /* synthetic */ kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method copy$default(kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method method, java.lang.String str, java.lang.String str2, int i, java.lang.Object obj) {
            if ((i & 1) != 0) {
                str = method.name;
            }
            if ((i & 2) != 0) {
                str2 = method.desc;
            }
            return method.copy(str, str2);
        }

        public final kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method copy(java.lang.String name, java.lang.String desc) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(desc, "desc");
            return new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method(name, desc);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method)) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method method = (kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method) obj;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.name, method.name) && kotlin.jvm.internal.Intrinsics.areEqual(this.desc, method.desc);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.desc.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Method(java.lang.String name, java.lang.String desc) {
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(desc, "desc");
            this.name = name;
            this.desc = desc;
        }

        public java.lang.String getDesc() {
            return this.desc;
        }

        public java.lang.String getName() {
            return this.name;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public java.lang.String asString() {
            return getName() + getDesc();
        }
    }

    /* JADX INFO: compiled from: JvmMemberSignature.kt */
    public static final class Field extends kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature {
        private final java.lang.String desc;
        private final java.lang.String name;

        public final java.lang.String component1() {
            return this.name;
        }

        public final java.lang.String component2() {
            return this.desc;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field)) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field field = (kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field) obj;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.name, field.name) && kotlin.jvm.internal.Intrinsics.areEqual(this.desc, field.desc);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.desc.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Field(java.lang.String name, java.lang.String desc) {
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(desc, "desc");
            this.name = name;
            this.desc = desc;
        }

        public java.lang.String getDesc() {
            return this.desc;
        }

        public java.lang.String getName() {
            return this.name;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public java.lang.String asString() {
            return getName() + com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE + getDesc();
        }
    }

    public final java.lang.String toString() {
        return asString();
    }
}
