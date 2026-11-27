package androidx.webkit.internal;

/* JADX INFO: loaded from: classes.dex */
public class ScriptHandlerImpl extends androidx.webkit.ScriptHandler {
    private org.chromium.support_lib_boundary.ScriptHandlerBoundaryInterface mBoundaryInterface;

    private ScriptHandlerImpl(org.chromium.support_lib_boundary.ScriptHandlerBoundaryInterface scriptHandlerBoundaryInterface) {
        this.mBoundaryInterface = scriptHandlerBoundaryInterface;
    }

    public static androidx.webkit.internal.ScriptHandlerImpl toScriptHandler(java.lang.reflect.InvocationHandler invocationHandler) {
        return new androidx.webkit.internal.ScriptHandlerImpl((org.chromium.support_lib_boundary.ScriptHandlerBoundaryInterface) org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil.castToSuppLibClass(org.chromium.support_lib_boundary.ScriptHandlerBoundaryInterface.class, invocationHandler));
    }

    @Override // androidx.webkit.ScriptHandler
    public void remove() {
        this.mBoundaryInterface.remove();
    }
}
