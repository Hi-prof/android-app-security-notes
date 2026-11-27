package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: SignatureBuildingComponents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SignatureBuildingComponents {
    public static final kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents INSTANCE = new kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents();

    private SignatureBuildingComponents() {
    }

    public final java.lang.String javaLang(java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return "java/lang/" + name;
    }

    public final java.lang.String javaUtil(java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return "java/util/" + name;
    }

    public final java.lang.String javaFunction(java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return "java/util/function/" + name;
    }

    public final java.lang.String javaUtilConcurrentAtomic(java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return "java/util/concurrent/atomic/" + name;
    }

    public final java.util.Set<java.lang.String> inJavaLang(java.lang.String name, java.lang.String... signatures) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signatures, "signatures");
        return inClass(javaLang(name), (java.lang.String[]) java.util.Arrays.copyOf(signatures, signatures.length));
    }

    public final java.util.Set<java.lang.String> inJavaUtil(java.lang.String name, java.lang.String... signatures) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signatures, "signatures");
        return inClass(javaUtil(name), (java.lang.String[]) java.util.Arrays.copyOf(signatures, signatures.length));
    }

    public final java.util.Set<java.lang.String> inClass(java.lang.String internalName, java.lang.String... signatures) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(internalName, "internalName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signatures, "signatures");
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        for (java.lang.String str : signatures) {
            linkedHashSet.add(internalName + com.taobao.weex.el.parse.Operators.DOT + str);
        }
        return linkedHashSet;
    }

    public final java.lang.String signature(java.lang.String internalName, java.lang.String jvmDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(internalName, "internalName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jvmDescriptor, "jvmDescriptor");
        return internalName + com.taobao.weex.el.parse.Operators.DOT + jvmDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.CharSequence jvmDescriptor$lambda$2(java.lang.String it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.escapeClassName(it);
    }

    public final java.lang.String jvmDescriptor(java.lang.String name, java.util.List<java.lang.String> parameters, java.lang.String ret) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameters, "parameters");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(ret, "ret");
        return name + com.taobao.weex.el.parse.Operators.BRACKET_START + kotlin.collections.CollectionsKt.joinToString$default(parameters, "", null, null, 0, null, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.jvmDescriptor$lambda$2((java.lang.String) obj);
            }
        }, 30, null) + com.taobao.weex.el.parse.Operators.BRACKET_END + escapeClassName(ret);
    }

    private final java.lang.String escapeClassName(java.lang.String str) {
        if (str.length() <= 1) {
            return str;
        }
        return "L" + str + ';';
    }

    public final java.lang.String[] constructors(java.lang.String... signatures) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signatures, "signatures");
        java.util.ArrayList arrayList = new java.util.ArrayList(signatures.length);
        for (java.lang.String str : signatures) {
            arrayList.add("<init>(" + str + ")V");
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[0]);
    }
}
