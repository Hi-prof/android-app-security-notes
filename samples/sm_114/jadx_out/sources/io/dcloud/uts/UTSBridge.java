package io.dcloud.uts;

/* JADX INFO: compiled from: UTSBridge.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\u0007"}, d2 = {"Lio/dcloud/uts/UTSBridge;", "", "<init>", "()V", "registerJavaScriptClassInstance", "", "nativeInstance", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UTSBridge {
    public static final io.dcloud.uts.UTSBridge INSTANCE = new io.dcloud.uts.UTSBridge();

    private UTSBridge() {
    }

    public final int registerJavaScriptClassInstance(java.lang.Object nativeInstance) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nativeInstance, "nativeInstance");
        io.dcloud.feature.utsplugin.ProxyModule.INSTANCE.setInstanceDynamicId(io.dcloud.feature.utsplugin.ProxyModule.INSTANCE.getInstanceDynamicId() + 1);
        io.dcloud.feature.utsplugin.ProxyModule.INSTANCE.getUtsInstances().put(java.lang.Integer.valueOf(io.dcloud.feature.utsplugin.ProxyModule.INSTANCE.getInstanceDynamicId()), nativeInstance);
        return io.dcloud.feature.utsplugin.ProxyModule.INSTANCE.getInstanceDynamicId();
    }
}
