package androidx.activity;

/* JADX INFO: compiled from: ComponentActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/activity/OnBackPressedDispatcher;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class ComponentActivity$onBackPressedDispatcher$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<androidx.activity.OnBackPressedDispatcher> {
    final /* synthetic */ androidx.activity.ComponentActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComponentActivity$onBackPressedDispatcher$2(androidx.activity.ComponentActivity componentActivity) {
        super(0);
        this.this$0 = componentActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final androidx.activity.OnBackPressedDispatcher invoke() {
        final androidx.activity.ComponentActivity componentActivity = this.this$0;
        final androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = new androidx.activity.OnBackPressedDispatcher(new java.lang.Runnable() { // from class: androidx.activity.ComponentActivity$onBackPressedDispatcher$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                androidx.activity.ComponentActivity$onBackPressedDispatcher$2.invoke$lambda$0(componentActivity);
            }
        });
        final androidx.activity.ComponentActivity componentActivity2 = this.this$0;
        if (android.os.Build.VERSION.SDK_INT >= 33) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(android.os.Looper.myLooper(), android.os.Looper.getMainLooper())) {
                componentActivity2.addObserverForBackInvoker(onBackPressedDispatcher);
            } else {
                new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: androidx.activity.ComponentActivity$onBackPressedDispatcher$2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        androidx.activity.ComponentActivity$onBackPressedDispatcher$2.invoke$lambda$2$lambda$1(componentActivity2, onBackPressedDispatcher);
                    }
                });
                return onBackPressedDispatcher;
            }
        }
        return onBackPressedDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(androidx.activity.ComponentActivity this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            super/*androidx.core.app.ComponentActivity*/.onBackPressed();
        } catch (java.lang.IllegalStateException e) {
            if (!kotlin.jvm.internal.Intrinsics.areEqual(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e;
            }
        } catch (java.lang.NullPointerException e2) {
            if (!kotlin.jvm.internal.Intrinsics.areEqual(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$1(androidx.activity.ComponentActivity this$0, androidx.activity.OnBackPressedDispatcher dispatcher) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dispatcher, "$dispatcher");
        this$0.addObserverForBackInvoker(dispatcher);
    }
}
