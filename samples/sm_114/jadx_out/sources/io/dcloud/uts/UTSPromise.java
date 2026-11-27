package io.dcloud.uts;

/* JADX INFO: compiled from: UTSPromise.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 =*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001=BG\b\u0016\u0012<\u0010\u0003\u001a8\u0012.\u0012,\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0004\b\n\u0010\u000bBy\b\u0016\u0012n\u0010\u0003\u001aj\u0012.\u0012,\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u00120\u0012.\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0004\b\n\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\b2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0016J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0019\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0001\u0010+H\u0017¢\u0006\u0002\b,J2\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0\u0000\"\u0004\b\u0001\u0010+2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H+0.2\u000e\b\u0002\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0016J=\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0\u0000\"\u0004\b\u0001\u0010+2\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H+0\u00000.2\u000e\b\u0002\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0017¢\u0006\u0002\b0JG\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0\u0000\"\u0004\b\u0001\u0010+2!\u0010-\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(1\u0012\u0004\u0012\u0002H+0\u00042\u000e\b\u0002\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0016JR\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0\u0000\"\u0004\b\u0001\u0010+2'\u0010-\u001a#\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(1\u0012\n\u0012\b\u0012\u0004\u0012\u0002H+0\u00000\u00042\u000e\b\u0002\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0017¢\u0006\u0002\b2J4\u00103\u001a\b\u0012\u0004\u0012\u0002H+0\u0000\"\u0004\b\u0001\u0010+2\u000e\b\u0002\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u000e\b\u0002\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0016J4\u00104\u001a\b\u0012\u0004\u0012\u0002H+0\u0000\"\u0004\b\u0001\u0010+2\u000e\b\u0002\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u000e\b\u0002\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0002J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0019\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0001\u0010+H\u0017¢\u0006\u0002\b6J\"\u00105\u001a\b\u0012\u0004\u0012\u0002H+0\u0000\"\u0004\b\u0001\u0010+2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H+0.H\u0016J-\u00105\u001a\b\u0012\u0004\u0012\u0002H+0\u0000\"\u0004\b\u0001\u0010+2\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H+0\u00000.H\u0017¢\u0006\u0002\b7J9\u00105\u001a\b\u0012\u0004\u0012\u0002H+0\u0000\"\u0004\b\u0001\u0010+2#\u0010/\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(1\u0012\u0004\u0012\u0002H+0\u0004H\u0016JD\u00105\u001a\b\u0012\u0004\u0012\u0002H+0\u0000\"\u0004\b\u0001\u0010+2)\u0010/\u001a%\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(1\u0012\n\u0012\b\u0012\u0004\u0012\u0002H+0\u00000\u0004H\u0017¢\u0006\u0002\b8J$\u00109\u001a\b\u0012\u0004\u0012\u0002H+0\u0000\"\u0004\b\u0001\u0010+2\u000e\b\u0002\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0016J\"\u0010:\u001a\b\u0012\u0004\u0012\u0002H+0\u0000\"\u0004\b\u0001\u0010+2\f\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0002J\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0016R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006>"}, d2 = {"Lio/dcloud/uts/UTSPromise;", "T", "", "fn", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "resolve", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "reason", "reject", "(Lkotlin/jvm/functions/Function2;)V", "constructor_origin", "Lkotlin/Function;", "_state", "", "get_state", "()Ljava/lang/Number;", "set_state", "(Ljava/lang/Number;)V", "_handled", "", "get_handled", "()Z", "set_handled", "(Z)V", "_value", "get_value", "()Ljava/lang/Object;", "set_value", "(Ljava/lang/Object;)V", "_deferreds", "Lio/dcloud/uts/UTSArray;", "Lio/dcloud/uts/UTSPromiseHandler;", "get_deferreds", "()Lio/dcloud/uts/UTSArray;", "set_deferreds", "(Lio/dcloud/uts/UTSArray;)V", "then", "R", "then0", "onFulfilled", "Lkotlin/Function0;", "onRejected", "then1", com.facebook.common.util.UriUtil.LOCAL_RESOURCE_SCHEME, "then2", "then_origin", "_then", "catch", "catch0", "catch1", "catch2", "catch_origin", "_catch", "finally", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "Companion", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UTSPromise<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final io.dcloud.uts.UTSPromise.Companion INSTANCE = new io.dcloud.uts.UTSPromise.Companion(null);
    private io.dcloud.uts.UTSArray<io.dcloud.uts.UTSPromiseHandler> _deferreds;
    private boolean _handled;
    private java.lang.Number _state;
    private java.lang.Object _value;

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object finally$lambda$2$lambda$1(java.lang.Object obj) {
        return obj;
    }

    public UTSPromise(kotlin.jvm.functions.Function1<? super kotlin.jvm.functions.Function1<? super T, kotlin.Unit>, kotlin.Unit> fn) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fn, "fn");
        this._state = (java.lang.Number) 0;
        this._deferreds = new io.dcloud.uts.UTSArray<>();
        constructor_origin(fn);
    }

    public UTSPromise(kotlin.jvm.functions.Function2<? super kotlin.jvm.functions.Function1<? super T, kotlin.Unit>, ? super kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>, kotlin.Unit> fn) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fn, "fn");
        this._state = (java.lang.Number) 0;
        this._deferreds = new io.dcloud.uts.UTSArray<>();
        constructor_origin(fn);
    }

    public void constructor_origin(kotlin.Function<?> fn) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fn, "fn");
        kotlin.jvm.internal.Intrinsics.checkNotNull(this, "null cannot be cast to non-null type io.dcloud.uts.UTSPromise<*>");
        io.dcloud.uts.UTSPromiseKt.doResolveUTSPromise(fn, this);
    }

    public java.lang.Number get_state() {
        return this._state;
    }

    public void set_state(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this._state = number;
    }

    public boolean get_handled() {
        return this._handled;
    }

    public void set_handled(boolean z) {
        this._handled = z;
    }

    public java.lang.Object get_value() {
        return this._value;
    }

    public void set_value(java.lang.Object obj) {
        this._value = obj;
    }

    public io.dcloud.uts.UTSArray<io.dcloud.uts.UTSPromiseHandler> get_deferreds() {
        return this._deferreds;
    }

    public void set_deferreds(io.dcloud.uts.UTSArray<io.dcloud.uts.UTSPromiseHandler> uTSArray) {
        this._deferreds = uTSArray;
    }

    public io.dcloud.uts.UTSPromise<T> then() {
        return (io.dcloud.uts.UTSPromise<T>) then_origin(null, null);
    }

    public <R> io.dcloud.uts.UTSPromise<T> then0() {
        return then_origin(null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ io.dcloud.uts.UTSPromise then$default(io.dcloud.uts.UTSPromise uTSPromise, kotlin.jvm.functions.Function0 function0, kotlin.Function function, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            function = null;
        }
        return uTSPromise.then(function0, (kotlin.Function<?>) function);
    }

    public <R> io.dcloud.uts.UTSPromise<R> then(kotlin.jvm.functions.Function0<? extends R> onFulfilled, kotlin.Function<?> onRejected) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onFulfilled, "onFulfilled");
        return then_origin(onFulfilled, onRejected);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ io.dcloud.uts.UTSPromise then1$default(io.dcloud.uts.UTSPromise uTSPromise, kotlin.jvm.functions.Function0 function0, kotlin.Function function, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            function = null;
        }
        return uTSPromise.then1(function0, function);
    }

    public <R> io.dcloud.uts.UTSPromise<R> then1(kotlin.jvm.functions.Function0<io.dcloud.uts.UTSPromise<R>> onFulfilled, kotlin.Function<?> onRejected) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onFulfilled, "onFulfilled");
        return then_origin(onFulfilled, onRejected);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ io.dcloud.uts.UTSPromise then$default(io.dcloud.uts.UTSPromise uTSPromise, kotlin.jvm.functions.Function1 function1, kotlin.Function function, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            function = null;
        }
        return uTSPromise.then(function1, (kotlin.Function<?>) function);
    }

    public <R> io.dcloud.uts.UTSPromise<R> then(kotlin.jvm.functions.Function1<? super T, ? extends R> onFulfilled, kotlin.Function<?> onRejected) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onFulfilled, "onFulfilled");
        return then_origin(onFulfilled, onRejected);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ io.dcloud.uts.UTSPromise then2$default(io.dcloud.uts.UTSPromise uTSPromise, kotlin.jvm.functions.Function1 function1, kotlin.Function function, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            function = null;
        }
        return uTSPromise.then2(function1, function);
    }

    public <R> io.dcloud.uts.UTSPromise<R> then2(kotlin.jvm.functions.Function1<? super T, io.dcloud.uts.UTSPromise<R>> onFulfilled, kotlin.Function<?> onRejected) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onFulfilled, "onFulfilled");
        return then_origin(onFulfilled, onRejected);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ io.dcloud.uts.UTSPromise then_origin$default(io.dcloud.uts.UTSPromise uTSPromise, kotlin.Function function, kotlin.Function function2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function = null;
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        return uTSPromise.then_origin(function, function2);
    }

    public <R> io.dcloud.uts.UTSPromise<R> then_origin(kotlin.Function<?> onFulfilled, kotlin.Function<?> onRejected) {
        return _then(onFulfilled, onRejected);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ io.dcloud.uts.UTSPromise _then$default(io.dcloud.uts.UTSPromise uTSPromise, kotlin.Function function, kotlin.Function function2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function = null;
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        return uTSPromise._then(function, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> io.dcloud.uts.UTSPromise<R> _then(kotlin.Function<?> onFulfilled, kotlin.Function<?> onRejected) {
        io.dcloud.uts.UTSPromise<R> uTSPromise = new io.dcloud.uts.UTSPromise<>((kotlin.jvm.functions.Function2<? super kotlin.jvm.functions.Function1<? super R, kotlin.Unit>, ? super kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>, kotlin.Unit>) new kotlin.jvm.functions.Function2() { // from class: io.dcloud.uts.UTSPromise$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                return io.dcloud.uts.UTSPromise._then$lambda$0((kotlin.jvm.functions.Function1) obj, (kotlin.jvm.functions.Function1) obj2);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNull(this, "null cannot be cast to non-null type io.dcloud.uts.UTSPromise<*>");
        io.dcloud.uts.UTSPromiseKt.handleUTSPromise(this, new io.dcloud.uts.UTSPromiseHandler(onFulfilled, onRejected, uTSPromise));
        return uTSPromise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R> kotlin.Unit _then$lambda$0(kotlin.jvm.functions.Function1<? super R, kotlin.Unit> function1, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function2) {
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: catch, reason: not valid java name */
    public io.dcloud.uts.UTSPromise<T> m521catch() {
        return catch_origin$default(this, null, 1, null);
    }

    public <R> io.dcloud.uts.UTSPromise<T> catch0() {
        return catch_origin$default(this, null, 1, null);
    }

    /* JADX INFO: renamed from: catch, reason: not valid java name */
    public <R> io.dcloud.uts.UTSPromise<R> m522catch(kotlin.jvm.functions.Function0<? extends R> onRejected) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onRejected, "onRejected");
        return catch_origin(onRejected);
    }

    public <R> io.dcloud.uts.UTSPromise<R> catch1(kotlin.jvm.functions.Function0<io.dcloud.uts.UTSPromise<R>> onRejected) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onRejected, "onRejected");
        return catch_origin(onRejected);
    }

    /* JADX INFO: renamed from: catch, reason: not valid java name */
    public <R> io.dcloud.uts.UTSPromise<R> m523catch(kotlin.jvm.functions.Function1<java.lang.Object, ? extends R> onRejected) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onRejected, "onRejected");
        return catch_origin(onRejected);
    }

    public <R> io.dcloud.uts.UTSPromise<R> catch2(kotlin.jvm.functions.Function1<java.lang.Object, io.dcloud.uts.UTSPromise<R>> onRejected) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onRejected, "onRejected");
        return catch_origin(onRejected);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ io.dcloud.uts.UTSPromise catch_origin$default(io.dcloud.uts.UTSPromise uTSPromise, kotlin.Function function, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function = null;
        }
        return uTSPromise.catch_origin(function);
    }

    public <R> io.dcloud.uts.UTSPromise<R> catch_origin(kotlin.Function<?> onRejected) {
        return _catch(onRejected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> io.dcloud.uts.UTSPromise<R> _catch(kotlin.Function<?> onRejected) {
        return _then(null, onRejected);
    }

    /* JADX INFO: renamed from: finally, reason: not valid java name */
    public io.dcloud.uts.UTSPromise<T> m524finally(final kotlin.Function<?> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        return (io.dcloud.uts.UTSPromise<T>) _then(new kotlin.jvm.functions.Function1() { // from class: io.dcloud.uts.UTSPromise$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final java.lang.Object invoke(java.lang.Object obj) {
                return io.dcloud.uts.UTSPromise.finally$lambda$2(callback, obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: io.dcloud.uts.UTSPromise$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final java.lang.Object invoke(java.lang.Object obj) {
                return io.dcloud.uts.UTSPromise.finally$lambda$4(callback, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> java.lang.Object finally$lambda$2(kotlin.Function<?> function, final java.lang.Object obj) {
        return _then$default(INSTANCE._resolve(io.dcloud.uts.UTSPromiseKt.callFunction(function, new io.dcloud.uts.UTSArray())), new kotlin.jvm.functions.Function0() { // from class: io.dcloud.uts.UTSPromise$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return io.dcloud.uts.UTSPromise.finally$lambda$2$lambda$1(obj);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> java.lang.Object finally$lambda$4(kotlin.Function<?> function, final java.lang.Object obj) {
        return _then$default(INSTANCE._resolve(io.dcloud.uts.UTSPromiseKt.callFunction(function, new io.dcloud.uts.UTSArray())), new kotlin.jvm.functions.Function0() { // from class: io.dcloud.uts.UTSPromise$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return io.dcloud.uts.UTSPromise.finally$lambda$4$lambda$3(obj);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object finally$lambda$4$lambda$3(java.lang.Object obj) {
        return INSTANCE.reject(obj);
    }

    /* JADX INFO: compiled from: UTSPromise.kt */
    @kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0001\u0010\u00072\u0006\u0010\b\u001a\u0002H\u0007¢\u0006\u0002\u0010\tJ \u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0001\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0001\u0010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0001\u0010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001J,\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u000e0\u0005\"\u0004\b\u0001\u0010\u00072\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00050\u000eJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0001\u0010\u00072\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eJ&\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0001\u0010\u00072\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00050\u000eJ\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0001\u0010\u00072\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eJ&\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0001\u0010\u00072\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00050\u000eJ\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0001\u0010\u00072\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eJ2\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00160\u000e0\u0005\"\u0004\b\u0001\u0010\u00072\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00050\u000eJ*\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00160\u000e0\u0005\"\u0004\b\u0001\u0010\u00072\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eJ\u0012\u0010\u0018\u001a\u00020\u00062\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aJ\u0010\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001¨\u0006\u001d"}, d2 = {"Lio/dcloud/uts/UTSPromise$Companion;", "", "<init>", "()V", "resolve", "Lio/dcloud/uts/UTSPromise;", "", "T", "value", "(Ljava/lang/Object;)Lio/dcloud/uts/UTSPromise;", "resolve_origin", "_resolve", "reject", "all", "Lio/dcloud/uts/UTSArray;", "arr", "all_origin", "race", "race_origin", "any", "any_origin", "allSettled", "Lio/dcloud/uts/UTSPromiseSettledResult;", "allSettled_origin", "_immediateFn", "fn", "Lkotlin/Function;", "_unhandledRejectionFn", androidx.core.app.NotificationCompat.CATEGORY_ERROR, "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final io.dcloud.uts.UTSPromise<kotlin.Unit> resolve() {
            return resolve_origin$default(io.dcloud.uts.UTSPromise.INSTANCE, null, 1, null);
        }

        public final <T> io.dcloud.uts.UTSPromise<T> resolve(T value) {
            return io.dcloud.uts.UTSPromise.INSTANCE.resolve_origin(value);
        }

        public final <T> io.dcloud.uts.UTSPromise<T> resolve(io.dcloud.uts.UTSPromise<T> value) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
            return io.dcloud.uts.UTSPromise.INSTANCE.resolve_origin(value);
        }

        public static /* synthetic */ io.dcloud.uts.UTSPromise resolve_origin$default(io.dcloud.uts.UTSPromise.Companion companion, java.lang.Object obj, int i, java.lang.Object obj2) {
            if ((i & 1) != 0) {
                obj = null;
            }
            return companion.resolve_origin(obj);
        }

        public final <T> io.dcloud.uts.UTSPromise<T> resolve_origin(java.lang.Object value) {
            return io.dcloud.uts.UTSPromise.INSTANCE._resolve(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> io.dcloud.uts.UTSPromise<T> _resolve(final java.lang.Object value) {
            if (value != null && (value instanceof io.dcloud.uts.UTSPromise)) {
                return (io.dcloud.uts.UTSPromise) value;
            }
            return new io.dcloud.uts.UTSPromise<>(new kotlin.jvm.functions.Function2() { // from class: io.dcloud.uts.UTSPromise$Companion$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                    return io.dcloud.uts.UTSPromise.Companion._resolve$lambda$0(value, (kotlin.jvm.functions.Function1) obj, (kotlin.jvm.functions.Function1) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final <T> kotlin.Unit _resolve$lambda$0(java.lang.Object obj, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> function1, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function2) {
            io.dcloud.uts.UTSPromiseKt.callFunction(function1, io.dcloud.uts.UTSArrayKt.utsArrayOf(obj));
            return kotlin.Unit.INSTANCE;
        }

        public static /* synthetic */ io.dcloud.uts.UTSPromise reject$default(io.dcloud.uts.UTSPromise.Companion companion, java.lang.Object obj, int i, java.lang.Object obj2) {
            if ((i & 1) != 0) {
                obj = null;
            }
            return companion.reject(obj);
        }

        public final io.dcloud.uts.UTSPromise<kotlin.Unit> reject(final java.lang.Object value) {
            return new io.dcloud.uts.UTSPromise<>(new kotlin.jvm.functions.Function2() { // from class: io.dcloud.uts.UTSPromise$Companion$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                    return io.dcloud.uts.UTSPromise.Companion.reject$lambda$1(value, (kotlin.jvm.functions.Function1) obj, (kotlin.jvm.functions.Function1) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit reject$lambda$1(java.lang.Object obj, kotlin.jvm.functions.Function1<? super kotlin.Unit, kotlin.Unit> function1, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function2) {
            io.dcloud.uts.UTSPromiseKt.callFunction(function2, io.dcloud.uts.UTSArrayKt.utsArrayOf(obj));
            return kotlin.Unit.INSTANCE;
        }

        public final <T> io.dcloud.uts.UTSPromise<io.dcloud.uts.UTSArray<T>> all(io.dcloud.uts.UTSArray<io.dcloud.uts.UTSPromise<T>> arr) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arr, "arr");
            return io.dcloud.uts.UTSPromise.INSTANCE.all_origin(arr);
        }

        public final <T> io.dcloud.uts.UTSPromise<T> all_origin(final io.dcloud.uts.UTSArray<?> arr) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arr, "arr");
            return new io.dcloud.uts.UTSPromise<>(new kotlin.jvm.functions.Function2() { // from class: io.dcloud.uts.UTSPromise$Companion$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                    return io.dcloud.uts.UTSPromise.Companion.all_origin$lambda$5(arr, (kotlin.jvm.functions.Function1) obj, (kotlin.jvm.functions.Function1) obj2);
                }
            });
        }

        private static final <T> void all_origin$lambda$5$res(final kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1, final io.dcloud.uts.UTSArray<java.lang.Object> uTSArray, final kotlin.jvm.internal.Ref.ObjectRef<java.lang.Number> objectRef, final kotlin.jvm.functions.Function1<? super T, kotlin.Unit> function2, final java.lang.Number number, java.lang.Object obj) {
            try {
                if (obj != null) {
                    try {
                        if (obj instanceof io.dcloud.uts.UTSPromise) {
                            ((io.dcloud.uts.UTSPromise) obj)._then(new kotlin.jvm.functions.Function1() { // from class: io.dcloud.uts.UTSPromise$Companion$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final java.lang.Object invoke(java.lang.Object obj2) {
                                    return io.dcloud.uts.UTSPromise.Companion.all_origin$lambda$5$res$lambda$3(number, function1, uTSArray, objectRef, function2, obj2);
                                }
                            }, function1);
                            return;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        io.dcloud.uts.UTSPromiseKt.callFunction(function1, io.dcloud.uts.UTSArrayKt.utsArrayOf(th));
                        return;
                    }
                }
                kotlin.jvm.internal.Intrinsics.checkNotNull(number, "null cannot be cast to non-null type kotlin.Int");
                uTSArray.set(((java.lang.Integer) number).intValue(), obj);
                objectRef.element = (T) io.dcloud.uts.NumberKt.dec(objectRef.element);
                if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) objectRef.element, (java.lang.Object) 0)) {
                    io.dcloud.uts.UTSPromiseKt.callFunction(function2, io.dcloud.uts.UTSArrayKt.utsArrayOf(uTSArray));
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final <T> kotlin.Unit all_origin$lambda$5$res$lambda$3(java.lang.Number number, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1, io.dcloud.uts.UTSArray<java.lang.Object> uTSArray, kotlin.jvm.internal.Ref.ObjectRef<java.lang.Number> objectRef, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> function2, java.lang.Object obj) {
            all_origin$lambda$5$res(function1, uTSArray, objectRef, function2, number, obj);
            return kotlin.Unit.INSTANCE;
        }

        public final <T> io.dcloud.uts.UTSPromise<T> race(io.dcloud.uts.UTSArray<io.dcloud.uts.UTSPromise<T>> arr) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arr, "arr");
            return io.dcloud.uts.UTSPromise.INSTANCE.race_origin(arr);
        }

        public final <T> io.dcloud.uts.UTSPromise<T> race_origin(final io.dcloud.uts.UTSArray<?> arr) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arr, "arr");
            return new io.dcloud.uts.UTSPromise<>(new kotlin.jvm.functions.Function2() { // from class: io.dcloud.uts.UTSPromise$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                    return io.dcloud.uts.UTSPromise.Companion.race_origin$lambda$7(arr, (kotlin.jvm.functions.Function1) obj, (kotlin.jvm.functions.Function1) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final <T> kotlin.Unit race_origin$lambda$7(io.dcloud.uts.UTSArray<?> uTSArray, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> function1, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function2) {
            io.dcloud.uts.UTSPromise.Companion companion = io.dcloud.uts.UTSPromise.INSTANCE;
            java.lang.Number length = uTSArray.getLength();
            for (java.lang.Integer numValueOf = (java.lang.Number) 0; io.dcloud.uts.NumberKt.compareTo(numValueOf, length) < 0; numValueOf = java.lang.Integer.valueOf(numValueOf.intValue() + 1)) {
                io.dcloud.uts.UTSPromise.INSTANCE._resolve(uTSArray.get(numValueOf.intValue()))._then(function1, function2);
            }
            return kotlin.Unit.INSTANCE;
        }

        public final <T> io.dcloud.uts.UTSPromise<T> any(io.dcloud.uts.UTSArray<io.dcloud.uts.UTSPromise<T>> arr) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arr, "arr");
            return io.dcloud.uts.UTSPromise.INSTANCE.any_origin(arr);
        }

        public final <T> io.dcloud.uts.UTSPromise<T> any_origin(final io.dcloud.uts.UTSArray<?> arr) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arr, "arr");
            return new io.dcloud.uts.UTSPromise<>(new kotlin.jvm.functions.Function2() { // from class: io.dcloud.uts.UTSPromise$Companion$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                    return io.dcloud.uts.UTSPromise.Companion.any_origin$lambda$11(arr, (kotlin.jvm.functions.Function1) obj, (kotlin.jvm.functions.Function1) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final <T> kotlin.Unit any_origin$lambda$11(io.dcloud.uts.UTSArray<?> uTSArray, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> function1, final kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function2) {
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) uTSArray.getLength(), (java.lang.Object) 0)) {
                io.dcloud.uts.UTSPromiseKt.callFunction(function2, new io.dcloud.uts.UTSArray());
                return kotlin.Unit.INSTANCE;
            }
            final io.dcloud.uts.UTSArray uTSArray2 = new io.dcloud.uts.UTSArray();
            java.util.Iterator<?> it = uTSArray.iterator();
            while (it.hasNext()) {
                uTSArray2.push(it.next());
            }
            final io.dcloud.uts.UTSArray uTSArray3 = new io.dcloud.uts.UTSArray();
            io.dcloud.uts.UTSPromise.Companion companion = io.dcloud.uts.UTSPromise.INSTANCE;
            for (java.lang.Number numberInc = (java.lang.Number) 0; io.dcloud.uts.NumberKt.compareTo(numberInc, uTSArray2.getLength()) < 0; numberInc = io.dcloud.uts.NumberKt.inc(numberInc)) {
                try {
                    io.dcloud.uts.UTSPromise.Companion companion2 = io.dcloud.uts.UTSPromise.INSTANCE;
                    kotlin.jvm.internal.Intrinsics.checkNotNull(numberInc, "null cannot be cast to non-null type kotlin.Int");
                    io.dcloud.uts.UTSPromise._then$default(companion2._resolve(uTSArray2.get(((java.lang.Integer) numberInc).intValue())), function1, null, 2, null)._catch(new kotlin.jvm.functions.Function1() { // from class: io.dcloud.uts.UTSPromise$Companion$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final java.lang.Object invoke(java.lang.Object obj) {
                            return io.dcloud.uts.UTSPromise.Companion.any_origin$lambda$11$lambda$10$lambda$9(uTSArray3, uTSArray2, function2, obj);
                        }
                    });
                } catch (java.lang.Throwable th) {
                    io.dcloud.uts.UTSPromiseKt.callFunction(function2, io.dcloud.uts.UTSArrayKt.utsArrayOf(th));
                }
            }
            return kotlin.Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit any_origin$lambda$11$lambda$10$lambda$9(io.dcloud.uts.UTSArray<java.lang.Object> uTSArray, io.dcloud.uts.UTSArray<java.lang.Object> uTSArray2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1, java.lang.Object obj) {
            uTSArray.push(obj);
            if (kotlin.jvm.internal.Intrinsics.areEqual(uTSArray.getLength(), uTSArray2.getLength())) {
                io.dcloud.uts.UTSPromiseKt.callFunction(function1, io.dcloud.uts.UTSArrayKt.utsArrayOf(new io.dcloud.uts.UTSPromiseAggregateError(uTSArray, "All promises were rejected")));
            }
            return kotlin.Unit.INSTANCE;
        }

        public final <T> io.dcloud.uts.UTSPromise<io.dcloud.uts.UTSArray<io.dcloud.uts.UTSPromiseSettledResult<T>>> allSettled(io.dcloud.uts.UTSArray<io.dcloud.uts.UTSPromise<T>> arr) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arr, "arr");
            return io.dcloud.uts.UTSPromise.INSTANCE.allSettled_origin(arr);
        }

        public final <T> io.dcloud.uts.UTSPromise<io.dcloud.uts.UTSArray<io.dcloud.uts.UTSPromiseSettledResult<T>>> allSettled_origin(final io.dcloud.uts.UTSArray<?> arr) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arr, "arr");
            return new io.dcloud.uts.UTSPromise<>(new kotlin.jvm.functions.Function2() { // from class: io.dcloud.uts.UTSPromise$Companion$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                    return io.dcloud.uts.UTSPromise.Companion.allSettled_origin$lambda$17(arr, (kotlin.Function) obj, (kotlin.Function) obj2);
                }
            });
        }

        private static final <T> void allSettled_origin$lambda$17$res$15(final io.dcloud.uts.UTSArray<java.lang.Object> uTSArray, final kotlin.jvm.internal.Ref.ObjectRef<java.lang.Number> objectRef, final kotlin.Function<?> function, final java.lang.Number number, java.lang.Object obj) {
            if (obj != null && (obj instanceof io.dcloud.uts.UTSPromise)) {
                ((io.dcloud.uts.UTSPromise) obj)._then(new kotlin.jvm.functions.Function1() { // from class: io.dcloud.uts.UTSPromise$Companion$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final java.lang.Object invoke(java.lang.Object obj2) {
                        return io.dcloud.uts.UTSPromise.Companion.allSettled_origin$lambda$17$res$15$lambda$13(number, uTSArray, objectRef, function, obj2);
                    }
                }, new kotlin.jvm.functions.Function1() { // from class: io.dcloud.uts.UTSPromise$Companion$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final java.lang.Object invoke(java.lang.Object obj2) {
                        return io.dcloud.uts.UTSPromise.Companion.allSettled_origin$lambda$17$res$15$lambda$14(uTSArray, number, objectRef, function, obj2);
                    }
                });
                return;
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(number, "null cannot be cast to non-null type kotlin.Int");
            uTSArray.set(((java.lang.Integer) number).intValue(), new io.dcloud.uts.UTSPromiseFulfilledResultImpl(obj));
            objectRef.element = (T) io.dcloud.uts.NumberKt.dec(objectRef.element);
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) objectRef.element, (java.lang.Object) 0)) {
                io.dcloud.uts.UTSPromiseKt.callFunction(function, io.dcloud.uts.UTSArrayKt.utsArrayOf(uTSArray));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final <T> kotlin.Unit allSettled_origin$lambda$17$res$15$lambda$13(java.lang.Number number, io.dcloud.uts.UTSArray<java.lang.Object> uTSArray, kotlin.jvm.internal.Ref.ObjectRef<java.lang.Number> objectRef, kotlin.Function<?> function, java.lang.Object obj) {
            allSettled_origin$lambda$17$res$15(uTSArray, objectRef, function, number, obj);
            return kotlin.Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit allSettled_origin$lambda$17$res$15$lambda$14(io.dcloud.uts.UTSArray<java.lang.Object> uTSArray, java.lang.Number number, kotlin.jvm.internal.Ref.ObjectRef<java.lang.Number> objectRef, kotlin.Function<?> function, java.lang.Object obj) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(number, "null cannot be cast to non-null type kotlin.Int");
            uTSArray.set(((java.lang.Integer) number).intValue(), new io.dcloud.uts.UTSPromiseRejectedResultImpl(obj));
            objectRef.element = (T) io.dcloud.uts.NumberKt.dec(objectRef.element);
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) objectRef.element, (java.lang.Object) 0)) {
                io.dcloud.uts.UTSPromiseKt.callFunction(function, io.dcloud.uts.UTSArrayKt.utsArrayOf(uTSArray));
            }
            return kotlin.Unit.INSTANCE;
        }

        public final void _immediateFn(final kotlin.Function<?> fn) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fn, "fn");
            io.dcloud.uts.UTSTimerKt.setTimeout(new kotlin.jvm.functions.Function0() { // from class: io.dcloud.uts.UTSPromise$Companion$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return io.dcloud.uts.UTSPromise.Companion._immediateFn$lambda$18(fn);
                }
            }, (java.lang.Number) 0);
        }

        public final void _unhandledRejectionFn(java.lang.Object err) {
            io.dcloud.uts.console.warn("Possible Unhandled Promise Rejection:", err);
            if (err instanceof java.lang.Throwable) {
                io.dcloud.uts.console.INSTANCE.errorV1WithStack(err);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final <T> kotlin.Unit all_origin$lambda$5(io.dcloud.uts.UTSArray<?> uTSArray, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> function1, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function2) {
            io.dcloud.uts.UTSArray uTSArray2 = new io.dcloud.uts.UTSArray();
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) uTSArray.getLength(), (java.lang.Object) 0)) {
                io.dcloud.uts.UTSPromiseKt.callFunction(function1, io.dcloud.uts.UTSArrayKt.utsArrayOf(uTSArray2));
                return kotlin.Unit.INSTANCE;
            }
            java.util.Iterator<?> it = uTSArray.iterator();
            while (it.hasNext()) {
                uTSArray2.push(it.next());
            }
            kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
            objectRef.element = (T) uTSArray2.getLength();
            io.dcloud.uts.UTSPromise.Companion companion = io.dcloud.uts.UTSPromise.INSTANCE;
            for (java.lang.Integer numValueOf = (java.lang.Number) 0; io.dcloud.uts.NumberKt.compareTo(numValueOf, uTSArray2.getLength()) < 0; numValueOf = java.lang.Integer.valueOf(numValueOf.intValue() + 1)) {
                all_origin$lambda$5$res(function2, uTSArray2, objectRef, function1, numValueOf, uTSArray2.get(numValueOf.intValue()));
            }
            return kotlin.Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final <T> kotlin.Unit allSettled_origin$lambda$17(io.dcloud.uts.UTSArray<?> uTSArray, kotlin.Function<?> function, kotlin.Function<?> function2) {
            io.dcloud.uts.UTSArray uTSArray2 = new io.dcloud.uts.UTSArray();
            java.lang.Integer numValueOf = 0;
            if (kotlin.jvm.internal.Intrinsics.areEqual(uTSArray.getLength(), numValueOf)) {
                io.dcloud.uts.UTSPromiseKt.callFunction(function, io.dcloud.uts.UTSArrayKt.utsArrayOf(uTSArray2));
                return kotlin.Unit.INSTANCE;
            }
            java.util.Iterator<?> it = uTSArray.iterator();
            while (it.hasNext()) {
                uTSArray2.push(it.next());
            }
            kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
            objectRef.element = (T) uTSArray2.getLength();
            io.dcloud.uts.UTSPromise.Companion companion = io.dcloud.uts.UTSPromise.INSTANCE;
            while (true) {
                java.lang.Integer num = numValueOf;
                if (io.dcloud.uts.NumberKt.compareTo(num, uTSArray2.getLength()) < 0) {
                    allSettled_origin$lambda$17$res$15(uTSArray2, objectRef, function, num, uTSArray2.get(num.intValue()));
                    numValueOf = java.lang.Integer.valueOf(num.intValue() + 1);
                } else {
                    return kotlin.Unit.INSTANCE;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit _immediateFn$lambda$18(kotlin.Function<?> function) {
            io.dcloud.uts.UTSPromiseKt.callFunction(function, new io.dcloud.uts.UTSArray());
            return kotlin.Unit.INSTANCE;
        }
    }
}
