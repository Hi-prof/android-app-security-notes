package kotlin.reflect.jvm.internal.impl.builtins.functions;

/* JADX INFO: compiled from: FunctionTypeKindExtractor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FunctionTypeKindExtractor {
    public static final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor.Companion Companion = new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor.Companion(null);
    private static final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor Default = new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor(kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind[]{kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.Function.INSTANCE, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.SuspendFunction.INSTANCE, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KFunction.INSTANCE, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KSuspendFunction.INSTANCE}));
    private final java.util.List<kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind> kinds;
    private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, java.util.List<kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind>> knownKindsByPackageFqName;

    /* JADX INFO: compiled from: FunctionTypeKindExtractor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor getDefault() {
            return kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor.Default;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FunctionTypeKindExtractor(java.util.List<? extends kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind> kinds) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kinds, "kinds");
        this.kinds = kinds;
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.lang.Object obj : kinds) {
            kotlin.reflect.jvm.internal.impl.name.FqName packageFqName = ((kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind) obj).getPackageFqName();
            java.lang.Object obj2 = linkedHashMap.get(packageFqName);
            if (obj2 == null) {
                obj2 = (java.util.List) new java.util.ArrayList();
                linkedHashMap.put(packageFqName, obj2);
            }
            ((java.util.List) obj2).add(obj);
        }
        this.knownKindsByPackageFqName = linkedHashMap;
    }

    public final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind getFunctionalClassKind(kotlin.reflect.jvm.internal.impl.name.FqName packageFqName, java.lang.String className) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(className, "className");
        kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor.KindWithArity functionalClassKindWithArity = getFunctionalClassKindWithArity(packageFqName, className);
        if (functionalClassKindWithArity != null) {
            return functionalClassKindWithArity.getKind();
        }
        return null;
    }

    public final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor.KindWithArity getFunctionalClassKindWithArity(kotlin.reflect.jvm.internal.impl.name.FqName packageFqName, java.lang.String className) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(className, "className");
        java.util.List<kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind> list = this.knownKindsByPackageFqName.get(packageFqName);
        if (list == null) {
            return null;
        }
        for (kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind functionTypeKind : list) {
            if (kotlin.text.StringsKt.startsWith$default(className, functionTypeKind.getClassNamePrefix(), false, 2, (java.lang.Object) null)) {
                java.lang.String strSubstring = className.substring(functionTypeKind.getClassNamePrefix().length());
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                java.lang.Integer num = toInt(strSubstring);
                if (num != null) {
                    return new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor.KindWithArity(functionTypeKind, num.intValue());
                }
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: FunctionTypeKindExtractor.kt */
    public static final class KindWithArity {
        private final int arity;
        private final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind kind;

        public final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind component1() {
            return this.kind;
        }

        public final int component2() {
            return this.arity;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor.KindWithArity)) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor.KindWithArity kindWithArity = (kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor.KindWithArity) obj;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.kind, kindWithArity.kind) && this.arity == kindWithArity.arity;
        }

        public int hashCode() {
            return (this.kind.hashCode() * 31) + this.arity;
        }

        public java.lang.String toString() {
            return "KindWithArity(kind=" + this.kind + ", arity=" + this.arity + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }

        public KindWithArity(kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind kind, int i) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
            this.kind = kind;
            this.arity = i;
        }

        public final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind getKind() {
            return this.kind;
        }
    }

    private final java.lang.Integer toInt(java.lang.String str) {
        if (str.length() == 0) {
            return null;
        }
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int iCharAt = str.charAt(i2) - '0';
            if (iCharAt < 0 || iCharAt >= 10) {
                return null;
            }
            i = (i * 10) + iCharAt;
        }
        return java.lang.Integer.valueOf(i);
    }
}
