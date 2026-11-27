package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmAnnotation {
    private final java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument> arguments;
    private final java.lang.String className;

    /* JADX WARN: Multi-variable type inference failed */
    public KmAnnotation(java.lang.String className, java.util.Map<java.lang.String, ? extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument> arguments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(className, "className");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.className = className;
        this.arguments = arguments;
    }

    public final java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument> getArguments() {
        return this.arguments;
    }

    public final java.lang.String getClassName() {
        return this.className;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotation)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.km.KmAnnotation kmAnnotation = (kotlin.reflect.jvm.internal.impl.km.KmAnnotation) obj;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.className, kmAnnotation.className) && kotlin.jvm.internal.Intrinsics.areEqual(this.arguments, kmAnnotation.arguments);
    }

    public int hashCode() {
        return (this.className.hashCode() * 31) + this.arguments.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.CharSequence toString$lambda$0(kotlin.Pair pair) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pair, "<destruct>");
        return ((java.lang.String) pair.component1()) + " = " + ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument) pair.component2());
    }

    public java.lang.String toString() {
        return "@" + this.className + com.taobao.weex.el.parse.Operators.BRACKET_START + kotlin.collections.CollectionsKt.joinToString$default(kotlin.collections.MapsKt.toList(this.arguments), null, null, null, 0, null, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.km.KmAnnotation$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.km.KmAnnotation.toString$lambda$0((kotlin.Pair) obj);
            }
        }, 31, null) + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }
}
