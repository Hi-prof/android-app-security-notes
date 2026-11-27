package kotlin.reflect.jvm.internal.impl.builtins.functions;

/* JADX INFO: compiled from: FunctionTypeKind.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class FunctionTypeKind {
    private final kotlin.reflect.jvm.internal.impl.name.ClassId annotationOnInvokeClassId;
    private final java.lang.String classNamePrefix;
    private final boolean isInlineable;
    private final boolean isReflectType;
    private final kotlin.reflect.jvm.internal.impl.name.FqName packageFqName;

    public FunctionTypeKind(kotlin.reflect.jvm.internal.impl.name.FqName packageFqName, java.lang.String classNamePrefix, boolean z, kotlin.reflect.jvm.internal.impl.name.ClassId classId, boolean z2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classNamePrefix, "classNamePrefix");
        this.packageFqName = packageFqName;
        this.classNamePrefix = classNamePrefix;
        this.isReflectType = z;
        this.annotationOnInvokeClassId = classId;
        this.isInlineable = z2;
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final java.lang.String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    public final kotlin.reflect.jvm.internal.impl.name.Name numberedClassName(int i) {
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(this.classNamePrefix + i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return nameIdentifier;
    }

    public java.lang.String toString() {
        return this.packageFqName + com.taobao.weex.el.parse.Operators.DOT + this.classNamePrefix + 'N';
    }

    /* JADX INFO: compiled from: FunctionTypeKind.kt */
    public static final class Function extends kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind {
        public static final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.Function INSTANCE = new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.Function();

        private Function() {
            super(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_FQ_NAME, "Function", false, null, true);
        }
    }

    /* JADX INFO: compiled from: FunctionTypeKind.kt */
    public static final class SuspendFunction extends kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind {
        public static final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.SuspendFunction INSTANCE = new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.SuspendFunction();

        private SuspendFunction() {
            super(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.COROUTINES_PACKAGE_FQ_NAME, "SuspendFunction", false, null, true);
        }
    }

    /* JADX INFO: compiled from: FunctionTypeKind.kt */
    public static final class KFunction extends kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind {
        public static final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KFunction INSTANCE = new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KFunction();

        private KFunction() {
            super(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.KOTLIN_REFLECT_FQ_NAME, "KFunction", true, null, false);
        }
    }

    /* JADX INFO: compiled from: FunctionTypeKind.kt */
    public static final class KSuspendFunction extends kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind {
        public static final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KSuspendFunction INSTANCE = new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KSuspendFunction();

        private KSuspendFunction() {
            super(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.KOTLIN_REFLECT_FQ_NAME, "KSuspendFunction", true, null, false);
        }
    }
}
