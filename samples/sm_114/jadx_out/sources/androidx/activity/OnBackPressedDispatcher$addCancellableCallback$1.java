package androidx.activity;

/* JADX INFO: compiled from: OnBackPressedDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class OnBackPressedDispatcher$addCancellableCallback$1 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function0<kotlin.Unit> {
    OnBackPressedDispatcher$addCancellableCallback$1(java.lang.Object obj) {
        super(0, obj, androidx.activity.OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ kotlin.Unit invoke() {
        invoke2();
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((androidx.activity.OnBackPressedDispatcher) this.receiver).updateEnabledCallbacks();
    }
}
