package androidx.activity;

/* JADX INFO: compiled from: OnBackPressedDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0004)*+,B\u0013\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\fH\u0007J\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\fH\u0001¢\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\u0014H\u0007J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\n\u001a\u00020\u0007H\u0007J\b\u0010 \u001a\u00020\u0014H\u0003J\b\u0010!\u001a\u00020\u0014H\u0007J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0003J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0003J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000eH\u0007J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0007H\u0003J\b\u0010(\u001a\u00020\u0014H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher;", "", "fallbackOnBackPressed", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "onHasEnabledCallbacksChanged", "Landroidx/core/util/Consumer;", "", "(Ljava/lang/Runnable;Landroidx/core/util/Consumer;)V", "backInvokedCallbackRegistered", "hasEnabledCallbacks", "inProgressCallback", "Landroidx/activity/OnBackPressedCallback;", "invokedDispatcher", "Landroid/window/OnBackInvokedDispatcher;", "onBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackPressedCallbacks", "Lkotlin/collections/ArrayDeque;", "addCallback", "", "onBackPressedCallback", "owner", "Landroidx/lifecycle/LifecycleOwner;", "addCancellableCallback", "Landroidx/activity/Cancellable;", "addCancellableCallback$activity_release", "dispatchOnBackCancelled", "dispatchOnBackProgressed", "backEvent", "Landroidx/activity/BackEventCompat;", "dispatchOnBackStarted", "onBackCancelled", "onBackPressed", "onBackProgressed", "onBackStarted", "setOnBackInvokedDispatcher", "invoker", "updateBackInvokedCallbackState", "shouldBeRegistered", "updateEnabledCallbacks", "Api33Impl", "Api34Impl", "LifecycleOnBackPressedCancellable", "OnBackPressedCancellable", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OnBackPressedDispatcher {
    private boolean backInvokedCallbackRegistered;
    private final java.lang.Runnable fallbackOnBackPressed;
    private boolean hasEnabledCallbacks;
    private androidx.activity.OnBackPressedCallback inProgressCallback;
    private android.window.OnBackInvokedDispatcher invokedDispatcher;
    private android.window.OnBackInvokedCallback onBackInvokedCallback;
    private final kotlin.collections.ArrayDeque<androidx.activity.OnBackPressedCallback> onBackPressedCallbacks;
    private final androidx.core.util.Consumer<java.lang.Boolean> onHasEnabledCallbacksChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public OnBackPressedDispatcher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public OnBackPressedDispatcher(java.lang.Runnable runnable, androidx.core.util.Consumer<java.lang.Boolean> consumer) {
        android.window.OnBackInvokedCallback onBackInvokedCallbackCreateOnBackInvokedCallback;
        this.fallbackOnBackPressed = runnable;
        this.onHasEnabledCallbacksChanged = consumer;
        this.onBackPressedCallbacks = new kotlin.collections.ArrayDeque<>();
        if (android.os.Build.VERSION.SDK_INT >= 33) {
            if (android.os.Build.VERSION.SDK_INT >= 34) {
                onBackInvokedCallbackCreateOnBackInvokedCallback = androidx.activity.OnBackPressedDispatcher.Api34Impl.INSTANCE.createOnBackAnimationCallback(new kotlin.jvm.functions.Function1<androidx.activity.BackEventCompat, kotlin.Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.Unit invoke(androidx.activity.BackEventCompat backEventCompat) {
                        invoke2(backEventCompat);
                        return kotlin.Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(androidx.activity.BackEventCompat backEvent) {
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                        androidx.activity.OnBackPressedDispatcher.this.onBackStarted(backEvent);
                    }
                }, new kotlin.jvm.functions.Function1<androidx.activity.BackEventCompat, kotlin.Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.Unit invoke(androidx.activity.BackEventCompat backEventCompat) {
                        invoke2(backEventCompat);
                        return kotlin.Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(androidx.activity.BackEventCompat backEvent) {
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                        androidx.activity.OnBackPressedDispatcher.this.onBackProgressed(backEvent);
                    }
                }, new kotlin.jvm.functions.Function0<kotlin.Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ kotlin.Unit invoke() {
                        invoke2();
                        return kotlin.Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        androidx.activity.OnBackPressedDispatcher.this.onBackPressed();
                    }
                }, new kotlin.jvm.functions.Function0<kotlin.Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ kotlin.Unit invoke() {
                        invoke2();
                        return kotlin.Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        androidx.activity.OnBackPressedDispatcher.this.onBackCancelled();
                    }
                });
            } else {
                onBackInvokedCallbackCreateOnBackInvokedCallback = androidx.activity.OnBackPressedDispatcher.Api33Impl.INSTANCE.createOnBackInvokedCallback(new kotlin.jvm.functions.Function0<kotlin.Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ kotlin.Unit invoke() {
                        invoke2();
                        return kotlin.Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        androidx.activity.OnBackPressedDispatcher.this.onBackPressed();
                    }
                });
            }
            this.onBackInvokedCallback = onBackInvokedCallbackCreateOnBackInvokedCallback;
        }
    }

    public /* synthetic */ OnBackPressedDispatcher(java.lang.Runnable runnable, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : runnable);
    }

    public OnBackPressedDispatcher(java.lang.Runnable runnable) {
        this(runnable, null);
    }

    public final void setOnBackInvokedDispatcher(android.window.OnBackInvokedDispatcher invoker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(invoker, "invoker");
        this.invokedDispatcher = invoker;
        updateBackInvokedCallbackState(this.hasEnabledCallbacks);
    }

    private final void updateBackInvokedCallbackState(boolean shouldBeRegistered) {
        android.window.OnBackInvokedDispatcher onBackInvokedDispatcher = this.invokedDispatcher;
        android.window.OnBackInvokedCallback onBackInvokedCallback = this.onBackInvokedCallback;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (shouldBeRegistered && !this.backInvokedCallbackRegistered) {
            androidx.activity.OnBackPressedDispatcher.Api33Impl.INSTANCE.registerOnBackInvokedCallback(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.backInvokedCallbackRegistered = true;
        } else {
            if (shouldBeRegistered || !this.backInvokedCallbackRegistered) {
                return;
            }
            androidx.activity.OnBackPressedDispatcher.Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback);
            this.backInvokedCallbackRegistered = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEnabledCallbacks() {
        boolean z = this.hasEnabledCallbacks;
        kotlin.collections.ArrayDeque<androidx.activity.OnBackPressedCallback> arrayDeque = this.onBackPressedCallbacks;
        boolean z2 = false;
        if (!(arrayDeque instanceof java.util.Collection) || !arrayDeque.isEmpty()) {
            java.util.Iterator<androidx.activity.OnBackPressedCallback> it = arrayDeque.iterator();
            while (it.hasNext()) {
                if (it.next().getIsEnabled()) {
                    z2 = true;
                    break;
                }
            }
        }
        this.hasEnabledCallbacks = z2;
        if (z2 != z) {
            androidx.core.util.Consumer<java.lang.Boolean> consumer = this.onHasEnabledCallbacksChanged;
            if (consumer != null) {
                consumer.accept(java.lang.Boolean.valueOf(z2));
            }
            if (android.os.Build.VERSION.SDK_INT >= 33) {
                updateBackInvokedCallbackState(z2);
            }
        }
    }

    public final void addCallback(androidx.activity.OnBackPressedCallback onBackPressedCallback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        addCancellableCallback$activity_release(onBackPressedCallback);
    }

    public final androidx.activity.Cancellable addCancellableCallback$activity_release(androidx.activity.OnBackPressedCallback onBackPressedCallback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        this.onBackPressedCallbacks.add(onBackPressedCallback);
        androidx.activity.OnBackPressedDispatcher.OnBackPressedCancellable onBackPressedCancellable = new androidx.activity.OnBackPressedDispatcher.OnBackPressedCancellable(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(onBackPressedCancellable);
        updateEnabledCallbacks();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new androidx.activity.OnBackPressedDispatcher$addCancellableCallback$1(this));
        return onBackPressedCancellable;
    }

    public final void addCallback(androidx.lifecycle.LifecycleOwner owner, androidx.activity.OnBackPressedCallback onBackPressedCallback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(owner, "owner");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        androidx.lifecycle.Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.getState() == androidx.lifecycle.Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new androidx.activity.OnBackPressedDispatcher.LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
        updateEnabledCallbacks();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new androidx.activity.OnBackPressedDispatcher.C00841(this));
    }

    /* JADX INFO: renamed from: androidx.activity.OnBackPressedDispatcher$addCallback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OnBackPressedDispatcher.kt */
    @kotlin.Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class C00841 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function0<kotlin.Unit> {
        C00841(java.lang.Object obj) {
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

    /* JADX INFO: renamed from: hasEnabledCallbacks, reason: from getter */
    public final boolean getHasEnabledCallbacks() {
        return this.hasEnabledCallbacks;
    }

    public final void dispatchOnBackStarted(androidx.activity.BackEventCompat backEvent) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        onBackStarted(backEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBackStarted(androidx.activity.BackEventCompat backEvent) {
        androidx.activity.OnBackPressedCallback onBackPressedCallbackPrevious;
        kotlin.collections.ArrayDeque<androidx.activity.OnBackPressedCallback> arrayDeque = this.onBackPressedCallbacks;
        java.util.ListIterator<androidx.activity.OnBackPressedCallback> listIterator = arrayDeque.listIterator(arrayDeque.size());
        do {
            if (!listIterator.hasPrevious()) {
                onBackPressedCallbackPrevious = null;
                break;
            }
            onBackPressedCallbackPrevious = listIterator.previous();
        } while (!onBackPressedCallbackPrevious.getIsEnabled());
        androidx.activity.OnBackPressedCallback onBackPressedCallback = onBackPressedCallbackPrevious;
        if (this.inProgressCallback != null) {
            onBackCancelled();
        }
        this.inProgressCallback = onBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackStarted(backEvent);
        }
    }

    public final void dispatchOnBackProgressed(androidx.activity.BackEventCompat backEvent) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        onBackProgressed(backEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBackProgressed(androidx.activity.BackEventCompat backEvent) {
        androidx.activity.OnBackPressedCallback onBackPressedCallbackPrevious;
        androidx.activity.OnBackPressedCallback onBackPressedCallback = this.inProgressCallback;
        if (onBackPressedCallback == null) {
            kotlin.collections.ArrayDeque<androidx.activity.OnBackPressedCallback> arrayDeque = this.onBackPressedCallbacks;
            java.util.ListIterator<androidx.activity.OnBackPressedCallback> listIterator = arrayDeque.listIterator(arrayDeque.size());
            do {
                if (!listIterator.hasPrevious()) {
                    onBackPressedCallbackPrevious = null;
                    break;
                }
                onBackPressedCallbackPrevious = listIterator.previous();
            } while (!onBackPressedCallbackPrevious.getIsEnabled());
            onBackPressedCallback = onBackPressedCallbackPrevious;
        }
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackProgressed(backEvent);
        }
    }

    public final void onBackPressed() {
        androidx.activity.OnBackPressedCallback onBackPressedCallbackPrevious;
        androidx.activity.OnBackPressedCallback onBackPressedCallback = this.inProgressCallback;
        if (onBackPressedCallback == null) {
            kotlin.collections.ArrayDeque<androidx.activity.OnBackPressedCallback> arrayDeque = this.onBackPressedCallbacks;
            java.util.ListIterator<androidx.activity.OnBackPressedCallback> listIterator = arrayDeque.listIterator(arrayDeque.size());
            do {
                if (!listIterator.hasPrevious()) {
                    onBackPressedCallbackPrevious = null;
                    break;
                }
                onBackPressedCallbackPrevious = listIterator.previous();
            } while (!onBackPressedCallbackPrevious.getIsEnabled());
            onBackPressedCallback = onBackPressedCallbackPrevious;
        }
        this.inProgressCallback = null;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackPressed();
            return;
        }
        java.lang.Runnable runnable = this.fallbackOnBackPressed;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void dispatchOnBackCancelled() {
        onBackCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBackCancelled() {
        androidx.activity.OnBackPressedCallback onBackPressedCallbackPrevious;
        androidx.activity.OnBackPressedCallback onBackPressedCallback = this.inProgressCallback;
        if (onBackPressedCallback == null) {
            kotlin.collections.ArrayDeque<androidx.activity.OnBackPressedCallback> arrayDeque = this.onBackPressedCallbacks;
            java.util.ListIterator<androidx.activity.OnBackPressedCallback> listIterator = arrayDeque.listIterator(arrayDeque.size());
            do {
                if (!listIterator.hasPrevious()) {
                    onBackPressedCallbackPrevious = null;
                    break;
                }
                onBackPressedCallbackPrevious = listIterator.previous();
            } while (!onBackPressedCallbackPrevious.getIsEnabled());
            onBackPressedCallback = onBackPressedCallbackPrevious;
        }
        this.inProgressCallback = null;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackCancelled();
        }
    }

    /* JADX INFO: compiled from: OnBackPressedDispatcher.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$OnBackPressedCancellable;", "Landroidx/activity/Cancellable;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/activity/OnBackPressedCallback;)V", com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_CANCEL, "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class OnBackPressedCancellable implements androidx.activity.Cancellable {
        private final androidx.activity.OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ androidx.activity.OnBackPressedDispatcher this$0;

        public OnBackPressedCancellable(androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher, androidx.activity.OnBackPressedCallback onBackPressedCallback) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.onBackPressedCallback = onBackPressedCallback;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.this$0.onBackPressedCallbacks.remove(this.onBackPressedCallback);
            if (kotlin.jvm.internal.Intrinsics.areEqual(this.this$0.inProgressCallback, this.onBackPressedCallback)) {
                this.onBackPressedCallback.handleOnBackCancelled();
                this.this$0.inProgressCallback = null;
            }
            this.onBackPressedCallback.removeCancellable(this);
            kotlin.jvm.functions.Function0<kotlin.Unit> enabledChangedCallback$activity_release = this.onBackPressedCallback.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.onBackPressedCallback.setEnabledChangedCallback$activity_release(null);
        }
    }

    /* JADX INFO: compiled from: OnBackPressedDispatcher.kt */
    @kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/activity/Cancellable;", com.taobao.weex.ui.component.list.template.VirtualComponentLifecycle.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/lifecycle/Lifecycle;Landroidx/activity/OnBackPressedCallback;)V", "currentCancellable", com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_CANCEL, "", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class LifecycleOnBackPressedCancellable implements androidx.lifecycle.LifecycleEventObserver, androidx.activity.Cancellable {
        private androidx.activity.Cancellable currentCancellable;
        private final androidx.lifecycle.Lifecycle lifecycle;
        private final androidx.activity.OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ androidx.activity.OnBackPressedDispatcher this$0;

        public LifecycleOnBackPressedCancellable(androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher, androidx.lifecycle.Lifecycle lifecycle, androidx.activity.OnBackPressedCallback onBackPressedCallback) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.lifecycle = lifecycle;
            this.onBackPressedCallback = onBackPressedCallback;
            lifecycle.addObserver(this);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(androidx.lifecycle.LifecycleOwner source, androidx.lifecycle.Lifecycle.Event event) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
            if (event == androidx.lifecycle.Lifecycle.Event.ON_START) {
                this.currentCancellable = this.this$0.addCancellableCallback$activity_release(this.onBackPressedCallback);
                return;
            }
            if (event == androidx.lifecycle.Lifecycle.Event.ON_STOP) {
                androidx.activity.Cancellable cancellable = this.currentCancellable;
                if (cancellable != null) {
                    cancellable.cancel();
                    return;
                }
                return;
            }
            if (event == androidx.lifecycle.Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.lifecycle.removeObserver(this);
            this.onBackPressedCallback.removeCancellable(this);
            androidx.activity.Cancellable cancellable = this.currentCancellable;
            if (cancellable != null) {
                cancellable.cancel();
            }
            this.currentCancellable = null;
        }
    }

    /* JADX INFO: compiled from: OnBackPressedDispatcher.kt */
    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J \u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0007J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0007¨\u0006\u000e"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api33Impl;", "", "()V", "createOnBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackInvoked", "Lkotlin/Function0;", "", "registerOnBackInvokedCallback", "dispatcher", "priority", "", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "unregisterOnBackInvokedCallback", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api33Impl {
        public static final androidx.activity.OnBackPressedDispatcher.Api33Impl INSTANCE = new androidx.activity.OnBackPressedDispatcher.Api33Impl();

        private Api33Impl() {
        }

        public final void registerOnBackInvokedCallback(java.lang.Object dispatcher, int priority, java.lang.Object callback) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
            ((android.window.OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(priority, (android.window.OnBackInvokedCallback) callback);
        }

        public final void unregisterOnBackInvokedCallback(java.lang.Object dispatcher, java.lang.Object callback) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
            ((android.window.OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((android.window.OnBackInvokedCallback) callback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void createOnBackInvokedCallback$lambda$0(kotlin.jvm.functions.Function0 onBackInvoked) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onBackInvoked, "$onBackInvoked");
            onBackInvoked.invoke();
        }

        public final android.window.OnBackInvokedCallback createOnBackInvokedCallback(final kotlin.jvm.functions.Function0<kotlin.Unit> onBackInvoked) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onBackInvoked, "onBackInvoked");
            return new android.window.OnBackInvokedCallback() { // from class: androidx.activity.OnBackPressedDispatcher$Api33Impl$$ExternalSyntheticLambda0
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    androidx.activity.OnBackPressedDispatcher.Api33Impl.createOnBackInvokedCallback$lambda$0(onBackInvoked);
                }
            };
        }
    }

    /* JADX INFO: compiled from: OnBackPressedDispatcher.kt */
    @kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jj\u0010\u0003\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00062!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0007¨\u0006\u0010"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api34Impl;", "", "()V", "createOnBackAnimationCallback", "Landroid/window/OnBackInvokedCallback;", "onBackStarted", "Lkotlin/Function1;", "Landroidx/activity/BackEventCompat;", "Lkotlin/ParameterName;", "name", "backEvent", "", "onBackProgressed", "onBackInvoked", "Lkotlin/Function0;", "onBackCancelled", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Api34Impl {
        public static final androidx.activity.OnBackPressedDispatcher.Api34Impl INSTANCE = new androidx.activity.OnBackPressedDispatcher.Api34Impl();

        private Api34Impl() {
        }

        public final android.window.OnBackInvokedCallback createOnBackAnimationCallback(final kotlin.jvm.functions.Function1<? super androidx.activity.BackEventCompat, kotlin.Unit> onBackStarted, final kotlin.jvm.functions.Function1<? super androidx.activity.BackEventCompat, kotlin.Unit> onBackProgressed, final kotlin.jvm.functions.Function0<kotlin.Unit> onBackInvoked, final kotlin.jvm.functions.Function0<kotlin.Unit> onBackCancelled) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onBackStarted, "onBackStarted");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onBackProgressed, "onBackProgressed");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onBackInvoked, "onBackInvoked");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onBackCancelled, "onBackCancelled");
            return new android.window.OnBackAnimationCallback() { // from class: androidx.activity.OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1
                @Override // android.window.OnBackAnimationCallback
                public void onBackStarted(android.window.BackEvent backEvent) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    onBackStarted.invoke(new androidx.activity.BackEventCompat(backEvent));
                }

                @Override // android.window.OnBackAnimationCallback
                public void onBackProgressed(android.window.BackEvent backEvent) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    onBackProgressed.invoke(new androidx.activity.BackEventCompat(backEvent));
                }

                @Override // android.window.OnBackInvokedCallback
                public void onBackInvoked() {
                    onBackInvoked.invoke();
                }

                @Override // android.window.OnBackAnimationCallback
                public void onBackCancelled() {
                    onBackCancelled.invoke();
                }
            };
        }
    }
}
