package io.dcloud.feature.utsplugin;

/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ProxyModule$invokeSync$3$invokeSuspend$$inlined$CoroutineExceptionHandler$1 extends kotlin.coroutines.AbstractCoroutineContextElement implements kotlinx.coroutines.CoroutineExceptionHandler {
    final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef $errRet$inlined;
    final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef $executeRet$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProxyModule$invokeSync$3$invokeSuspend$$inlined$CoroutineExceptionHandler$1(kotlinx.coroutines.CoroutineExceptionHandler.Companion companion, kotlin.jvm.internal.Ref.ObjectRef objectRef, kotlin.jvm.internal.Ref.ObjectRef objectRef2) {
        super(companion);
        this.$executeRet$inlined = objectRef;
        this.$errRet$inlined = objectRef2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(kotlin.coroutines.CoroutineContext context, java.lang.Throwable exception) {
        this.$executeRet$inlined.element = null;
        if (exception.getCause() != null) {
            ((io.dcloud.feature.utsplugin.ReturnResult) this.$errRet$inlined.element).updateError("uts method error::" + exception.getCause());
            return;
        }
        ((io.dcloud.feature.utsplugin.ReturnResult) this.$errRet$inlined.element).updateError("uts method error::" + exception);
    }
}
