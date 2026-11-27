package io.dcloud.uts;

/* JADX INFO: compiled from: UniCallbackWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0015\b\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u0004\u0010\u0007J$\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001f\"\u00020\u0001H\u0086\u0002¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0017J\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0017J\u0006\u0010%\u001a\u00020\"J\u0006\u0010&\u001a\u00020'R \u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0005R \u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0007R \u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006("}, d2 = {"Lio/dcloud/uts/UniCallbackWrapper;", "", "callFunc", "Lkotlin/reflect/KFunction;", "<init>", "(Lkotlin/reflect/KFunction;)V", "Lkotlin/Function;", "(Lkotlin/Function;)V", "holderFunc", "getHolderFunc", "()Lkotlin/reflect/KFunction;", "setHolderFunc", "holderFun", "getHolderFun", "()Lkotlin/Function;", "setHolderFun", "hostClass", "Ljava/lang/Class;", "getHostClass", "()Ljava/lang/Class;", "setHostClass", "(Ljava/lang/Class;)V", "holderArgs", "", "", "getHolderArgs", "()Ljava/util/Map;", "setHolderArgs", "(Ljava/util/Map;)V", "invoke", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "setArgs", "", "param", "getArgs", kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF, "isValid", "", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UniCallbackWrapper {
    private java.util.Map<java.lang.String, ? extends java.lang.Object> holderArgs;
    private kotlin.Function<?> holderFun;
    private kotlin.reflect.KFunction<?> holderFunc;
    private java.lang.Class<?> hostClass;

    public final kotlin.reflect.KFunction<?> getHolderFunc() {
        return this.holderFunc;
    }

    public final void setHolderFunc(kotlin.reflect.KFunction<?> kFunction) {
        this.holderFunc = kFunction;
    }

    public final kotlin.Function<?> getHolderFun() {
        return this.holderFun;
    }

    public final void setHolderFun(kotlin.Function<?> function) {
        this.holderFun = function;
    }

    public final java.lang.Class<?> getHostClass() {
        return this.hostClass;
    }

    public final void setHostClass(java.lang.Class<?> cls) {
        this.hostClass = cls;
    }

    public final java.util.Map<java.lang.String, java.lang.Object> getHolderArgs() {
        return this.holderArgs;
    }

    public final void setHolderArgs(java.util.Map<java.lang.String, ? extends java.lang.Object> map) {
        this.holderArgs = map;
    }

    public UniCallbackWrapper(kotlin.reflect.KFunction<?> callFunc) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callFunc, "callFunc");
        this.holderFunc = callFunc;
    }

    public UniCallbackWrapper(kotlin.Function<?> callFunc) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callFunc, "callFunc");
        this.holderFun = callFunc;
        this.hostClass = callFunc.getClass();
    }

    public final java.lang.Object invoke(java.lang.Object... args) {
        java.lang.reflect.Method method;
        java.lang.reflect.Method method2;
        java.lang.reflect.Method[] declaredMethods;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(args, "args");
        if (this.holderFun != null) {
            java.lang.Class<?> cls = this.hostClass;
            if (cls == null || (declaredMethods = cls.getDeclaredMethods()) == null) {
                method = null;
                method2 = null;
            } else {
                method = null;
                method2 = null;
                for (java.lang.reflect.Method method3 : declaredMethods) {
                    if (kotlin.jvm.internal.Intrinsics.areEqual("invoke", method3.getName())) {
                        if (method3.isBridge()) {
                            method2 = method3;
                        } else {
                            method = method3;
                        }
                    }
                }
            }
            if (method == null && method2 != null) {
                method = method2;
            }
            if (method != null) {
                int length = method.getParameterTypes().length;
                if (length == 1 && kotlin.jvm.internal.Intrinsics.areEqual("[Ljava.lang.Object;", method.getParameterTypes()[0].getName())) {
                    return method.invoke(this.holderFun, args);
                }
                return (args.length >= length && args.length <= length) ? method.invoke(this.holderFun, java.util.Arrays.copyOf(args, args.length)) : "";
            }
        }
        kotlin.reflect.KFunction<?> kFunction = this.holderFunc;
        if (kFunction != null) {
            return kFunction.call(java.util.Arrays.copyOf(args, args.length));
        }
        return null;
    }

    public final void setArgs(java.util.Map<java.lang.String, ? extends java.lang.Object> param) {
        this.holderArgs = param;
    }

    public final java.util.Map<java.lang.String, java.lang.Object> getArgs() {
        return this.holderArgs;
    }

    public final void off() {
        this.holderFunc = null;
        this.holderFun = null;
        this.holderArgs = null;
    }

    public final boolean isValid() {
        return (this.holderFunc == null && this.holderFun == null && this.holderArgs == null) ? false : true;
    }
}
