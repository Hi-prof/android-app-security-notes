package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001b\u001a\u00020\u0010H\u0016J/\u0010\u001c\u001a\u00020\u00072%\u0010\u001d\u001a!\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bj\u0002`\u0011H\u0016J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J/\u0010!\u001a\u00020\u00072%\u0010\u001d\u001a!\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bj\u0002`\u0018H\u0016J\u0012\u0010\"\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000RE\u0010\t\u001a-\u0012\u0004\u0012\u00020\u0007\u0012#\u0012!\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bj\u0002`\u00110\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015RE\u0010\u0016\u001a-\u0012\u0004\u0012\u00020\u0007\u0012#\u0012!\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bj\u0002`\u00180\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015¨\u0006#"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/NetworkRequestTaskImpl;", "Luts/sdk/modules/DCloudUniNetwork/RequestTask;", androidx.core.app.NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "<init>", "(Lokhttp3/Call;)V", "headersReceivedListenerId", "", "chunkReceivedListenerId", "headersReceivedListeners", "Lio/dcloud/uts/Map;", "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniNetwork/RequestTaskOnHeadersReceivedListenerResult;", "Lkotlin/ParameterName;", "name", "result", "", "Luts/sdk/modules/DCloudUniNetwork/RequestTaskOnHeadersReceivedCallback;", "getHeadersReceivedListeners", "()Lio/dcloud/uts/Map;", "setHeadersReceivedListeners", "(Lio/dcloud/uts/Map;)V", "chunkReceivedListeners", "Luts/sdk/modules/DCloudUniNetwork/RequestTaskOnChunkReceivedListenerResult;", "Luts/sdk/modules/DCloudUniNetwork/RequestTaskOnChunkReceivedCallback;", "getChunkReceivedListeners", "setChunkReceivedListeners", "abort", "onHeadersReceived", "listener", "offHeadersReceived", "id", "", "onChunkReceived", "offChunkReceived", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class NetworkRequestTaskImpl implements uts.sdk.modules.DCloudUniNetwork.RequestTask {
    private okhttp3.Call call;
    private java.lang.Number headersReceivedListenerId = (java.lang.Number) 0;
    private java.lang.Number chunkReceivedListenerId = (java.lang.Number) 0;
    private io.dcloud.uts.Map<java.lang.Number, kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.RequestTaskOnHeadersReceivedListenerResult, kotlin.Unit>> headersReceivedListeners = new io.dcloud.uts.Map<>();
    private io.dcloud.uts.Map<java.lang.Number, kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.RequestTaskOnChunkReceivedListenerResult, kotlin.Unit>> chunkReceivedListeners = new io.dcloud.uts.Map<>();

    public io.dcloud.uts.Map<java.lang.Number, kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.RequestTaskOnHeadersReceivedListenerResult, kotlin.Unit>> getHeadersReceivedListeners() {
        return this.headersReceivedListeners;
    }

    public void setHeadersReceivedListeners(io.dcloud.uts.Map<java.lang.Number, kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.RequestTaskOnHeadersReceivedListenerResult, kotlin.Unit>> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.headersReceivedListeners = map;
    }

    public io.dcloud.uts.Map<java.lang.Number, kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.RequestTaskOnChunkReceivedListenerResult, kotlin.Unit>> getChunkReceivedListeners() {
        return this.chunkReceivedListeners;
    }

    public void setChunkReceivedListeners(io.dcloud.uts.Map<java.lang.Number, kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.RequestTaskOnChunkReceivedListenerResult, kotlin.Unit>> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.chunkReceivedListeners = map;
    }

    public NetworkRequestTaskImpl(okhttp3.Call call) {
        this.call = call;
    }

    @Override // uts.sdk.modules.DCloudUniNetwork.RequestTask
    public void abort() {
        okhttp3.Call call = this.call;
        if (call != null && call != null) {
            call.cancel();
        }
        io.dcloud.uts.UTSAndroid.INSTANCE.destroyInstance(this);
    }

    @Override // uts.sdk.modules.DCloudUniNetwork.RequestTask
    public java.lang.Number onHeadersReceived(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.RequestTaskOnHeadersReceivedListenerResult, kotlin.Unit> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.headersReceivedListenerId = io.dcloud.uts.NumberKt.inc(this.headersReceivedListenerId);
        getHeadersReceivedListeners().put(this.headersReceivedListenerId, listener);
        return this.headersReceivedListenerId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Integer] */
    @Override // uts.sdk.modules.DCloudUniNetwork.RequestTask
    public void offHeadersReceived(final java.lang.Object id) {
        if (id != null) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSAndroid.INSTANCE.typeof(id), "function")) {
                final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
                objectRef.element = -1;
                getHeadersReceivedListeners().forEach(new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                        return uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl.offHeadersReceived$lambda$0(id, objectRef, (kotlin.jvm.functions.Function1) obj, (java.lang.Number) obj2);
                    }
                });
                if (io.dcloud.uts.NumberKt.numberEquals(objectRef.element, -1)) {
                    return;
                }
                getHeadersReceivedListeners().delete(objectRef.element);
                return;
            }
            getHeadersReceivedListeners().delete((java.lang.Number) id);
            return;
        }
        setHeadersReceivedListeners(new io.dcloud.uts.Map<>());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final kotlin.Unit offHeadersReceived$lambda$0(java.lang.Object obj, kotlin.jvm.internal.Ref.ObjectRef<java.lang.Number> objectRef, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.RequestTaskOnHeadersReceivedListenerResult, kotlin.Unit> function1, java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"result\")] uts.sdk.modules.DCloudUniNetwork.RequestTaskOnHeadersReceivedListenerResult, kotlin.Unit>");
        if (kotlin.jvm.internal.Intrinsics.areEqual((kotlin.jvm.functions.Function1) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1), function1)) {
            objectRef.element = number;
        }
        return kotlin.Unit.INSTANCE;
    }

    @Override // uts.sdk.modules.DCloudUniNetwork.RequestTask
    public java.lang.Number onChunkReceived(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.RequestTaskOnChunkReceivedListenerResult, kotlin.Unit> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.chunkReceivedListenerId = io.dcloud.uts.NumberKt.inc(this.chunkReceivedListenerId);
        getChunkReceivedListeners().put(this.chunkReceivedListenerId, listener);
        return this.chunkReceivedListenerId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Integer] */
    @Override // uts.sdk.modules.DCloudUniNetwork.RequestTask
    public void offChunkReceived(final java.lang.Object id) {
        if (id != null) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSAndroid.INSTANCE.typeof(id), "function")) {
                final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
                objectRef.element = -1;
                getChunkReceivedListeners().forEach(new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                        return uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl.offChunkReceived$lambda$1(id, objectRef, (kotlin.jvm.functions.Function1) obj, (java.lang.Number) obj2);
                    }
                });
                getChunkReceivedListeners().delete(objectRef.element);
                return;
            }
            getChunkReceivedListeners().delete((java.lang.Number) id);
            return;
        }
        setChunkReceivedListeners(new io.dcloud.uts.Map<>());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final kotlin.Unit offChunkReceived$lambda$1(java.lang.Object obj, kotlin.jvm.internal.Ref.ObjectRef<java.lang.Number> objectRef, kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniNetwork.RequestTaskOnChunkReceivedListenerResult, kotlin.Unit> function1, java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"result\")] uts.sdk.modules.DCloudUniNetwork.RequestTaskOnChunkReceivedListenerResult, kotlin.Unit>");
        if (kotlin.jvm.internal.Intrinsics.areEqual((kotlin.jvm.functions.Function1) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1), function1)) {
            objectRef.element = number;
        }
        return kotlin.Unit.INSTANCE;
    }
}
