package kotlin.reflect.jvm.internal.impl.name;

/* JADX INFO: compiled from: CallableId.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CallableId {
    public static final kotlin.reflect.jvm.internal.impl.name.CallableId.Companion Companion = new kotlin.reflect.jvm.internal.impl.name.CallableId.Companion(null);
    private static final kotlin.reflect.jvm.internal.impl.name.Name LOCAL_NAME;
    private static final kotlin.reflect.jvm.internal.impl.name.FqName PACKAGE_FQ_NAME_FOR_LOCAL;
    private final kotlin.reflect.jvm.internal.impl.name.Name callableName;
    private final kotlin.reflect.jvm.internal.impl.name.ClassId classId;
    private final kotlin.reflect.jvm.internal.impl.name.FqName className;
    private final kotlin.reflect.jvm.internal.impl.name.FqName packageName;
    private final kotlin.reflect.jvm.internal.impl.name.FqName pathToLocal;

    private CallableId(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.name.FqName fqName2, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.name.FqName fqName3) {
        this.packageName = fqName;
        this.className = fqName2;
        this.callableName = name;
        this.classId = classId;
        this.pathToLocal = fqName3;
    }

    /* JADX INFO: compiled from: CallableId.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.Name name = kotlin.reflect.jvm.internal.impl.name.SpecialNames.LOCAL;
        LOCAL_NAME = name;
        PACKAGE_FQ_NAME_FOR_LOCAL = kotlin.reflect.jvm.internal.impl.name.FqName.Companion.topLevel(name);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CallableId(kotlin.reflect.jvm.internal.impl.name.FqName packageName, kotlin.reflect.jvm.internal.impl.name.Name callableName) {
        this(packageName, null, callableName, null, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageName, "packageName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableName, "callableName");
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.name.CallableId)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.name.CallableId callableId = (kotlin.reflect.jvm.internal.impl.name.CallableId) obj;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.packageName, callableId.packageName) && kotlin.jvm.internal.Intrinsics.areEqual(this.className, callableId.className) && kotlin.jvm.internal.Intrinsics.areEqual(this.callableName, callableId.callableName);
    }

    public int hashCode() {
        int iHashCode = (527 + this.packageName.hashCode()) * 31;
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = this.className;
        return ((iHashCode + (fqName != null ? fqName.hashCode() : 0)) * 31) + this.callableName.hashCode();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(kotlin.text.StringsKt.replace$default(this.packageName.asString(), com.taobao.weex.el.parse.Operators.DOT, '/', false, 4, (java.lang.Object) null));
        sb.append("/");
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = this.className;
        if (fqName != null) {
            sb.append(fqName);
            sb.append(com.taobao.weex.el.parse.Operators.DOT_STR);
        }
        sb.append(this.callableName);
        return sb.toString();
    }
}
