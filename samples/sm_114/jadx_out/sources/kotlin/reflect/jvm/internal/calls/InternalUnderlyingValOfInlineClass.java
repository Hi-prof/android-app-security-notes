package kotlin.reflect.jvm.internal.calls;

/* JADX INFO: compiled from: InternalUnderlyingValOfInlineClass.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u0017\u0018B\u001f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0004¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0002\u0019\u001a¨\u0006\u001b"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Method;", "unboxMethod", "parameterTypes", "", "Ljava/lang/reflect/Type;", "<init>", "(Ljava/lang/reflect/Method;Ljava/util/List;)V", "getParameterTypes", "()Ljava/util/List;", "member", "getMember", "()Ljava/lang/reflect/Method;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "callMethod", "", "instance", "args", "", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "Unbound", "Bound", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class InternalUnderlyingValOfInlineClass implements kotlin.reflect.jvm.internal.calls.Caller<java.lang.reflect.Method> {
    private final java.util.List<java.lang.reflect.Type> parameterTypes;
    private final java.lang.reflect.Type returnType;
    private final java.lang.reflect.Method unboxMethod;

    public /* synthetic */ InternalUnderlyingValOfInlineClass(java.lang.reflect.Method method, java.util.List list, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(method, list);
    }

    public boolean default$isBoundInstanceCallWithValueClasses() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* JADX INFO: renamed from: getMember */
    public final java.lang.reflect.Method mo1823getMember() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private InternalUnderlyingValOfInlineClass(java.lang.reflect.Method method, java.util.List<? extends java.lang.reflect.Type> list) {
        this.unboxMethod = method;
        this.parameterTypes = list;
        java.lang.Class<?> returnType = method.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        this.returnType = returnType;
    }

    public void checkArguments(java.lang.Object[] objArr) {
        default$checkArguments(objArr);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public boolean isBoundInstanceCallWithValueClasses() {
        return default$isBoundInstanceCallWithValueClasses();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final java.util.List<java.lang.reflect.Type> getParameterTypes() {
        return this.parameterTypes;
    }

    public void default$checkArguments(java.lang.Object[] args) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(args, "args");
        if (kotlin.reflect.jvm.internal.calls.CallerKt.getArity(this) == args.length) {
            return;
        }
        throw new java.lang.IllegalArgumentException("Callable expects " + kotlin.reflect.jvm.internal.calls.CallerKt.getArity(this) + " arguments, but " + args.length + " were provided.");
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final java.lang.reflect.Type getReturnType() {
        return this.returnType;
    }

    protected final java.lang.Object callMethod(java.lang.Object instance, java.lang.Object[] args) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(args, "args");
        return this.unboxMethod.invoke(instance, java.util.Arrays.copyOf(args, args.length));
    }

    /* JADX INFO: compiled from: InternalUnderlyingValOfInlineClass.kt */
    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "unboxMethod", "Ljava/lang/reflect/Method;", "<init>", "(Ljava/lang/reflect/Method;)V", androidx.core.app.NotificationCompat.CATEGORY_CALL, "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Unbound extends kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unbound(java.lang.reflect.Method unboxMethod) {
            super(unboxMethod, kotlin.collections.CollectionsKt.listOf(unboxMethod.getDeclaringClass()), null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unboxMethod, "unboxMethod");
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public java.lang.Object call(java.lang.Object[] args) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(args, "args");
            checkArguments(args);
            java.lang.Object obj = args[0];
            kotlin.reflect.jvm.internal.calls.CallerImpl.Companion companion = kotlin.reflect.jvm.internal.calls.CallerImpl.INSTANCE;
            return callMethod(obj, args.length <= 1 ? new java.lang.Object[0] : kotlin.collections.ArraysKt.copyOfRange(args, 1, args.length));
        }
    }

    /* JADX INFO: compiled from: InternalUnderlyingValOfInlineClass.kt */
    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u0004\u0018\u00010\u00062\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0002\u0010\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "unboxMethod", "Ljava/lang/reflect/Method;", "boundReceiver", "", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", androidx.core.app.NotificationCompat.CATEGORY_CALL, "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Bound extends kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass implements kotlin.reflect.jvm.internal.calls.BoundCaller {
        private final java.lang.Object boundReceiver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Bound(java.lang.reflect.Method unboxMethod, java.lang.Object obj) {
            super(unboxMethod, kotlin.collections.CollectionsKt.emptyList(), null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unboxMethod, "unboxMethod");
            this.boundReceiver = obj;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public java.lang.Object call(java.lang.Object[] args) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(args, "args");
            checkArguments(args);
            return callMethod(this.boundReceiver, args);
        }
    }
}
