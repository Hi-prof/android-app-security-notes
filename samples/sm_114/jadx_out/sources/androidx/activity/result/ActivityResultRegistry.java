package androidx.activity.result;

/* JADX INFO: compiled from: ActivityResultRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 72\u00020\u0001:\u0003678B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J#\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u0002H\u0017H\u0007¢\u0006\u0002\u0010\u001aJ\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J8\u0010\u001e\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\u0006H\u0002J\b\u0010 \u001a\u00020\nH\u0002JG\u0010!\u001a\u00020\u0012\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H\u00170$2\u0006\u0010%\u001a\u0002H\"2\b\u0010&\u001a\u0004\u0018\u00010'H'¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u000fJB\u0010-\u001a\b\u0012\u0004\u0012\u0002H\"0.\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u00172\u0006\u0010\u0014\u001a\u00020\u00052\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H\u00170$2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H\u001700JJ\u0010-\u001a\b\u0012\u0004\u0012\u0002H\"0.\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u00172\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u00101\u001a\u0002022\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u0002H\u00170$2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H\u001700J\u0010\u00103\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0015\u00104\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0005H\u0001¢\u0006\u0002\b5R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Landroidx/activity/result/ActivityResultRegistry;", "", "()V", "keyToCallback", "", "", "Landroidx/activity/result/ActivityResultRegistry$CallbackAndContract;", "keyToLifecycleContainers", "Landroidx/activity/result/ActivityResultRegistry$LifecycleContainer;", "keyToRc", "", "launchedKeys", "", "parsedPendingResults", "pendingResults", "Landroid/os/Bundle;", "rcToKey", "bindRcKey", "", "rc", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "dispatchResult", "", "O", com.taobao.weex.common.WXModule.REQUEST_CODE, "result", "(ILjava/lang/Object;)Z", com.taobao.weex.common.WXModule.RESULT_CODE, "data", "Landroid/content/Intent;", "doDispatch", "callbackAndContract", "generateRandomNumber", "onLaunch", "I", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "input", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(ILandroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", "onRestoreInstanceState", "savedInstanceState", "onSaveInstanceState", "outState", "register", "Landroidx/activity/result/ActivityResultLauncher;", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "Landroidx/activity/result/ActivityResultCallback;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "registerKey", "unregister", "unregister$activity_release", "CallbackAndContract", "Companion", "LifecycleContainer", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ActivityResultRegistry {
    private static final androidx.activity.result.ActivityResultRegistry.Companion Companion = new androidx.activity.result.ActivityResultRegistry.Companion(null);
    private static final int INITIAL_REQUEST_CODE_VALUE = 65536;
    private static final java.lang.String KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";
    private static final java.lang.String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
    private static final java.lang.String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
    private static final java.lang.String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
    private static final java.lang.String LOG_TAG = "ActivityResultRegistry";
    private final java.util.Map<java.lang.Integer, java.lang.String> rcToKey = new java.util.LinkedHashMap();
    private final java.util.Map<java.lang.String, java.lang.Integer> keyToRc = new java.util.LinkedHashMap();
    private final java.util.Map<java.lang.String, androidx.activity.result.ActivityResultRegistry.LifecycleContainer> keyToLifecycleContainers = new java.util.LinkedHashMap();
    private final java.util.List<java.lang.String> launchedKeys = new java.util.ArrayList();
    private final transient java.util.Map<java.lang.String, androidx.activity.result.ActivityResultRegistry.CallbackAndContract<?>> keyToCallback = new java.util.LinkedHashMap();
    private final java.util.Map<java.lang.String, java.lang.Object> parsedPendingResults = new java.util.LinkedHashMap();
    private final android.os.Bundle pendingResults = new android.os.Bundle();

    public abstract <I, O> void onLaunch(int requestCode, androidx.activity.result.contract.ActivityResultContract<I, O> contract, I input, androidx.core.app.ActivityOptionsCompat options);

    public final <I, O> androidx.activity.result.ActivityResultLauncher<I> register(final java.lang.String key, androidx.lifecycle.LifecycleOwner lifecycleOwner, final androidx.activity.result.contract.ActivityResultContract<I, O> contract, final androidx.activity.result.ActivityResultCallback<O> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contract, "contract");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        androidx.lifecycle.Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getState().isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED)) {
            throw new java.lang.IllegalStateException(("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.getState() + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        registerKey(key);
        androidx.activity.result.ActivityResultRegistry.LifecycleContainer lifecycleContainer = this.keyToLifecycleContainers.get(key);
        if (lifecycleContainer == null) {
            lifecycleContainer = new androidx.activity.result.ActivityResultRegistry.LifecycleContainer(lifecycle);
        }
        lifecycleContainer.addObserver(new androidx.lifecycle.LifecycleEventObserver() { // from class: androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(androidx.lifecycle.LifecycleOwner lifecycleOwner2, androidx.lifecycle.Lifecycle.Event event) {
                androidx.activity.result.ActivityResultRegistry.register$lambda$1(this.f$0, key, callback, contract, lifecycleOwner2, event);
            }
        });
        this.keyToLifecycleContainers.put(key, lifecycleContainer);
        return new androidx.activity.result.ActivityResultLauncher<I>() { // from class: androidx.activity.result.ActivityResultRegistry.register.2
            @Override // androidx.activity.result.ActivityResultLauncher
            public void launch(I input, androidx.core.app.ActivityOptionsCompat options) throws java.lang.Exception {
                java.lang.Object obj = androidx.activity.result.ActivityResultRegistry.this.keyToRc.get(key);
                java.lang.Object obj2 = contract;
                if (obj != null) {
                    int iIntValue = ((java.lang.Number) obj).intValue();
                    androidx.activity.result.ActivityResultRegistry.this.launchedKeys.add(key);
                    try {
                        androidx.activity.result.ActivityResultRegistry.this.onLaunch(iIntValue, contract, input, options);
                        return;
                    } catch (java.lang.Exception e) {
                        androidx.activity.result.ActivityResultRegistry.this.launchedKeys.remove(key);
                        throw e;
                    }
                }
                throw new java.lang.IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + obj2 + " and input " + input + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void unregister() {
                androidx.activity.result.ActivityResultRegistry.this.unregister$activity_release(key);
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public androidx.activity.result.contract.ActivityResultContract<I, ?> getContract() {
                return (androidx.activity.result.contract.ActivityResultContract<I, ?>) contract;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void register$lambda$1(androidx.activity.result.ActivityResultRegistry this$0, java.lang.String key, androidx.activity.result.ActivityResultCallback callback, androidx.activity.result.contract.ActivityResultContract contract, androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "$key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "$callback");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contract, "$contract");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        if (androidx.lifecycle.Lifecycle.Event.ON_START == event) {
            this$0.keyToCallback.put(key, new androidx.activity.result.ActivityResultRegistry.CallbackAndContract<>(callback, contract));
            if (this$0.parsedPendingResults.containsKey(key)) {
                java.lang.Object obj = this$0.parsedPendingResults.get(key);
                this$0.parsedPendingResults.remove(key);
                callback.onActivityResult(obj);
            }
            androidx.activity.result.ActivityResult activityResult = (androidx.activity.result.ActivityResult) androidx.core.os.BundleCompat.getParcelable(this$0.pendingResults, key, androidx.activity.result.ActivityResult.class);
            if (activityResult != null) {
                this$0.pendingResults.remove(key);
                callback.onActivityResult(contract.parseResult(activityResult.getResultCode(), activityResult.getData()));
                return;
            }
            return;
        }
        if (androidx.lifecycle.Lifecycle.Event.ON_STOP == event) {
            this$0.keyToCallback.remove(key);
        } else if (androidx.lifecycle.Lifecycle.Event.ON_DESTROY == event) {
            this$0.unregister$activity_release(key);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> androidx.activity.result.ActivityResultLauncher<I> register(final java.lang.String key, final androidx.activity.result.contract.ActivityResultContract<I, O> contract, androidx.activity.result.ActivityResultCallback<O> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contract, "contract");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        registerKey(key);
        this.keyToCallback.put(key, new androidx.activity.result.ActivityResultRegistry.CallbackAndContract<>(callback, contract));
        if (this.parsedPendingResults.containsKey(key)) {
            java.lang.Object obj = this.parsedPendingResults.get(key);
            this.parsedPendingResults.remove(key);
            callback.onActivityResult(obj);
        }
        androidx.activity.result.ActivityResult activityResult = (androidx.activity.result.ActivityResult) androidx.core.os.BundleCompat.getParcelable(this.pendingResults, key, androidx.activity.result.ActivityResult.class);
        if (activityResult != null) {
            this.pendingResults.remove(key);
            callback.onActivityResult(contract.parseResult(activityResult.getResultCode(), activityResult.getData()));
        }
        return new androidx.activity.result.ActivityResultLauncher<I>() { // from class: androidx.activity.result.ActivityResultRegistry.register.3
            @Override // androidx.activity.result.ActivityResultLauncher
            public void launch(I input, androidx.core.app.ActivityOptionsCompat options) throws java.lang.Exception {
                java.lang.Object obj2 = androidx.activity.result.ActivityResultRegistry.this.keyToRc.get(key);
                java.lang.Object obj3 = contract;
                if (obj2 != null) {
                    int iIntValue = ((java.lang.Number) obj2).intValue();
                    androidx.activity.result.ActivityResultRegistry.this.launchedKeys.add(key);
                    try {
                        androidx.activity.result.ActivityResultRegistry.this.onLaunch(iIntValue, contract, input, options);
                        return;
                    } catch (java.lang.Exception e) {
                        androidx.activity.result.ActivityResultRegistry.this.launchedKeys.remove(key);
                        throw e;
                    }
                }
                throw new java.lang.IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + obj3 + " and input " + input + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void unregister() {
                androidx.activity.result.ActivityResultRegistry.this.unregister$activity_release(key);
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public androidx.activity.result.contract.ActivityResultContract<I, ?> getContract() {
                return (androidx.activity.result.contract.ActivityResultContract<I, ?>) contract;
            }
        };
    }

    public final void unregister$activity_release(java.lang.String key) {
        java.lang.Integer numRemove;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        if (!this.launchedKeys.contains(key) && (numRemove = this.keyToRc.remove(key)) != null) {
            this.rcToKey.remove(numRemove);
        }
        this.keyToCallback.remove(key);
        if (this.parsedPendingResults.containsKey(key)) {
            android.util.Log.w(LOG_TAG, "Dropping pending result for request " + key + ": " + this.parsedPendingResults.get(key));
            this.parsedPendingResults.remove(key);
        }
        if (this.pendingResults.containsKey(key)) {
            android.util.Log.w(LOG_TAG, "Dropping pending result for request " + key + ": " + ((androidx.activity.result.ActivityResult) androidx.core.os.BundleCompat.getParcelable(this.pendingResults, key, androidx.activity.result.ActivityResult.class)));
            this.pendingResults.remove(key);
        }
        androidx.activity.result.ActivityResultRegistry.LifecycleContainer lifecycleContainer = this.keyToLifecycleContainers.get(key);
        if (lifecycleContainer != null) {
            lifecycleContainer.clearObservers();
            this.keyToLifecycleContainers.remove(key);
        }
    }

    public final void onSaveInstanceState(android.os.Bundle outState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS, new java.util.ArrayList<>(this.keyToRc.values()));
        outState.putStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS, new java.util.ArrayList<>(this.keyToRc.keySet()));
        outState.putStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS, new java.util.ArrayList<>(this.launchedKeys));
        outState.putBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS, new android.os.Bundle(this.pendingResults));
    }

    public final void onRestoreInstanceState(android.os.Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return;
        }
        java.util.ArrayList<java.lang.Integer> integerArrayList = savedInstanceState.getIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS);
        java.util.ArrayList<java.lang.String> stringArrayList = savedInstanceState.getStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS);
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        java.util.ArrayList<java.lang.String> stringArrayList2 = savedInstanceState.getStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS);
        if (stringArrayList2 != null) {
            this.launchedKeys.addAll(stringArrayList2);
        }
        android.os.Bundle bundle = savedInstanceState.getBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS);
        if (bundle != null) {
            this.pendingResults.putAll(bundle);
        }
        int size = stringArrayList.size();
        for (int i = 0; i < size; i++) {
            java.lang.String str = stringArrayList.get(i);
            if (this.keyToRc.containsKey(str)) {
                java.lang.Integer numRemove = this.keyToRc.remove(str);
                if (!this.pendingResults.containsKey(str)) {
                    kotlin.jvm.internal.TypeIntrinsics.asMutableMap(this.rcToKey).remove(numRemove);
                }
            }
            java.lang.Integer num = integerArrayList.get(i);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(num, "rcs[i]");
            int iIntValue = num.intValue();
            java.lang.String str2 = stringArrayList.get(i);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str2, "keys[i]");
            bindRcKey(iIntValue, str2);
        }
    }

    public final boolean dispatchResult(int requestCode, int resultCode, android.content.Intent data) {
        java.lang.String str = this.rcToKey.get(java.lang.Integer.valueOf(requestCode));
        if (str == null) {
            return false;
        }
        doDispatch(str, resultCode, data, this.keyToCallback.get(str));
        return true;
    }

    public final <O> boolean dispatchResult(int requestCode, O result) {
        java.lang.String str = this.rcToKey.get(java.lang.Integer.valueOf(requestCode));
        if (str == null) {
            return false;
        }
        androidx.activity.result.ActivityResultRegistry.CallbackAndContract<?> callbackAndContract = this.keyToCallback.get(str);
        if ((callbackAndContract != null ? callbackAndContract.getCallback() : null) == null) {
            this.pendingResults.remove(str);
            this.parsedPendingResults.put(str, result);
            return true;
        }
        androidx.activity.result.ActivityResultCallback<?> callback = callbackAndContract.getCallback();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
        if (!this.launchedKeys.remove(str)) {
            return true;
        }
        callback.onActivityResult(result);
        return true;
    }

    private final <O> void doDispatch(java.lang.String key, int resultCode, android.content.Intent data, androidx.activity.result.ActivityResultRegistry.CallbackAndContract<O> callbackAndContract) {
        if ((callbackAndContract != null ? callbackAndContract.getCallback() : null) != null && this.launchedKeys.contains(key)) {
            callbackAndContract.getCallback().onActivityResult(callbackAndContract.getContract().parseResult(resultCode, data));
            this.launchedKeys.remove(key);
        } else {
            this.parsedPendingResults.remove(key);
            this.pendingResults.putParcelable(key, new androidx.activity.result.ActivityResult(resultCode, data));
        }
    }

    private final void registerKey(java.lang.String key) {
        if (this.keyToRc.get(key) != null) {
            return;
        }
        bindRcKey(generateRandomNumber(), key);
    }

    private final int generateRandomNumber() {
        for (java.lang.Number number : kotlin.sequences.SequencesKt.generateSequence(new kotlin.jvm.functions.Function0<java.lang.Integer>() { // from class: androidx.activity.result.ActivityResultRegistry.generateRandomNumber.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Integer invoke() {
                return java.lang.Integer.valueOf(kotlin.random.Random.INSTANCE.nextInt(2147418112) + 65536);
            }
        })) {
            if (!this.rcToKey.containsKey(java.lang.Integer.valueOf(number.intValue()))) {
                return number.intValue();
            }
        }
        throw new java.util.NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    private final void bindRcKey(int rc, java.lang.String key) {
        this.rcToKey.put(java.lang.Integer.valueOf(rc), key);
        this.keyToRc.put(key, java.lang.Integer.valueOf(rc));
    }

    /* JADX INFO: compiled from: ActivityResultRegistry.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0010\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/activity/result/ActivityResultRegistry$CallbackAndContract;", "O", "", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "Landroidx/activity/result/ActivityResultCallback;", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "(Landroidx/activity/result/ActivityResultCallback;Landroidx/activity/result/contract/ActivityResultContract;)V", "getCallback", "()Landroidx/activity/result/ActivityResultCallback;", "getContract", "()Landroidx/activity/result/contract/ActivityResultContract;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class CallbackAndContract<O> {
        private final androidx.activity.result.ActivityResultCallback<O> callback;
        private final androidx.activity.result.contract.ActivityResultContract<?, O> contract;

        public CallbackAndContract(androidx.activity.result.ActivityResultCallback<O> callback, androidx.activity.result.contract.ActivityResultContract<?, O> contract) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contract, "contract");
            this.callback = callback;
            this.contract = contract;
        }

        public final androidx.activity.result.ActivityResultCallback<O> getCallback() {
            return this.callback;
        }

        public final androidx.activity.result.contract.ActivityResultContract<?, O> getContract() {
            return this.contract;
        }
    }

    /* JADX INFO: compiled from: ActivityResultRegistry.kt */
    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/activity/result/ActivityResultRegistry$LifecycleContainer;", "", com.taobao.weex.ui.component.list.template.VirtualComponentLifecycle.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;)V", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "observers", "", "Landroidx/lifecycle/LifecycleEventObserver;", "addObserver", "", "observer", "clearObservers", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class LifecycleContainer {
        private final androidx.lifecycle.Lifecycle lifecycle;
        private final java.util.List<androidx.lifecycle.LifecycleEventObserver> observers;

        public LifecycleContainer(androidx.lifecycle.Lifecycle lifecycle) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            this.lifecycle = lifecycle;
            this.observers = new java.util.ArrayList();
        }

        public final androidx.lifecycle.Lifecycle getLifecycle() {
            return this.lifecycle;
        }

        public final void addObserver(androidx.lifecycle.LifecycleEventObserver observer) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(observer, "observer");
            this.lifecycle.addObserver(observer);
            this.observers.add(observer);
        }

        public final void clearObservers() {
            java.util.Iterator<T> it = this.observers.iterator();
            while (it.hasNext()) {
                this.lifecycle.removeObserver((androidx.lifecycle.LifecycleEventObserver) it.next());
            }
            this.observers.clear();
        }
    }

    /* JADX INFO: compiled from: ActivityResultRegistry.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/activity/result/ActivityResultRegistry$Companion;", "", "()V", "INITIAL_REQUEST_CODE_VALUE", "", androidx.activity.result.ActivityResultRegistry.KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS, "", "KEY_COMPONENT_ACTIVITY_PENDING_RESULTS", androidx.activity.result.ActivityResultRegistry.KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS, androidx.activity.result.ActivityResultRegistry.KEY_COMPONENT_ACTIVITY_REGISTERED_RCS, "LOG_TAG", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
