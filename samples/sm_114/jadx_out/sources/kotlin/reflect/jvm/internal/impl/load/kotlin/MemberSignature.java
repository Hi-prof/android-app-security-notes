package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: MemberSignature.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberSignature {
    public static final kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion Companion = new kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion(null);
    private final java.lang.String signature;

    public /* synthetic */ MemberSignature(java.lang.String str, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature) && kotlin.jvm.internal.Intrinsics.areEqual(this.signature, ((kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature) obj).signature);
    }

    public int hashCode() {
        return this.signature.hashCode();
    }

    public java.lang.String toString() {
        return "MemberSignature(signature=" + this.signature + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    /* JADX INFO: compiled from: MemberSignature.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature fromMethod(kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature signature) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signature, "signature");
            return fromMethodNameAndDesc(nameResolver.getString(signature.getName()), nameResolver.getString(signature.getDesc()));
        }

        @kotlin.jvm.JvmStatic
        public final kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature fromMethodNameAndDesc(java.lang.String name, java.lang.String desc) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(desc, "desc");
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature(name + desc, null);
        }

        @kotlin.jvm.JvmStatic
        public final kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature fromFieldNameAndDesc(java.lang.String name, java.lang.String desc) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(desc, "desc");
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature(name + '#' + desc, null);
        }

        @kotlin.jvm.JvmStatic
        public final kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature fromJvmMemberSignature(kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature signature) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signature, "signature");
            if (signature instanceof kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method) {
                kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method method = (kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method) signature;
                return fromMethodNameAndDesc(method.getName(), method.getDesc());
            }
            if (!(signature instanceof kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field)) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field field = (kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field) signature;
            return fromFieldNameAndDesc(field.getName(), field.getDesc());
        }

        @kotlin.jvm.JvmStatic
        public final kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature fromMethodSignatureAndParameterIndex(kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature signature, int i) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signature, "signature");
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature(signature.getSignature() + com.taobao.weex.ui.component.list.template.TemplateDom.SEPARATOR + i, null);
        }
    }

    private MemberSignature(java.lang.String str) {
        this.signature = str;
    }

    public final java.lang.String getSignature() {
        return this.signature;
    }
}
