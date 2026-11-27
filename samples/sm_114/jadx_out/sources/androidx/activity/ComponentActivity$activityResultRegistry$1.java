package androidx.activity;

/* JADX INFO: compiled from: ComponentActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t2\u0006\u0010\n\u001a\u0002H\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"androidx/activity/ComponentActivity$activityResultRegistry$1", "Landroidx/activity/result/ActivityResultRegistry;", "onLaunch", "", "I", "O", com.taobao.weex.common.WXModule.REQUEST_CODE, "", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "input", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(ILandroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComponentActivity$activityResultRegistry$1 extends androidx.activity.result.ActivityResultRegistry {
    final /* synthetic */ androidx.activity.ComponentActivity this$0;

    ComponentActivity$activityResultRegistry$1(androidx.activity.ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    @Override // androidx.activity.result.ActivityResultRegistry
    public <I, O> void onLaunch(final int requestCode, androidx.activity.result.contract.ActivityResultContract<I, O> contract, I input, androidx.core.app.ActivityOptionsCompat options) {
        android.os.Bundle bundle;
        final int i;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contract, "contract");
        androidx.activity.ComponentActivity componentActivity = this.this$0;
        androidx.activity.ComponentActivity componentActivity2 = componentActivity;
        final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<O> synchronousResult = contract.getSynchronousResult(componentActivity2, input);
        if (synchronousResult != null) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: androidx.activity.ComponentActivity$activityResultRegistry$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    androidx.activity.ComponentActivity$activityResultRegistry$1.onLaunch$lambda$0(this.f$0, requestCode, synchronousResult);
                }
            });
            return;
        }
        android.content.Intent intentCreateIntent = contract.createIntent(componentActivity2, input);
        if (intentCreateIntent.getExtras() != null) {
            android.os.Bundle extras = intentCreateIntent.getExtras();
            kotlin.jvm.internal.Intrinsics.checkNotNull(extras);
            if (extras.getClassLoader() == null) {
                intentCreateIntent.setExtrasClassLoader(componentActivity.getClassLoader());
            }
        }
        if (intentCreateIntent.hasExtra(androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE)) {
            bundle = intentCreateIntent.getBundleExtra(androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            intentCreateIntent.removeExtra(androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
        } else {
            bundle = options != null ? options.toBundle() : null;
        }
        android.os.Bundle bundle2 = bundle;
        if (kotlin.jvm.internal.Intrinsics.areEqual(androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS, intentCreateIntent.getAction())) {
            java.lang.String[] stringArrayExtra = intentCreateIntent.getStringArrayExtra(androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS);
            if (stringArrayExtra == null) {
                stringArrayExtra = new java.lang.String[0];
            }
            androidx.core.app.ActivityCompat.requestPermissions(componentActivity, stringArrayExtra, requestCode);
            return;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST, intentCreateIntent.getAction())) {
            androidx.activity.result.IntentSenderRequest intentSenderRequest = (androidx.activity.result.IntentSenderRequest) intentCreateIntent.getParcelableExtra(androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST);
            try {
                androidx.activity.ComponentActivity componentActivity3 = componentActivity;
                kotlin.jvm.internal.Intrinsics.checkNotNull(intentSenderRequest);
                i = requestCode;
                try {
                    androidx.core.app.ActivityCompat.startIntentSenderForResult(componentActivity3, intentSenderRequest.getIntentSender(), i, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle2);
                } catch (android.content.IntentSender.SendIntentException e) {
                    e = e;
                    final android.content.IntentSender.SendIntentException sendIntentException = e;
                    new android.os.Handler(android.os.Looper.getMainLooper()).post(new java.lang.Runnable() { // from class: androidx.activity.ComponentActivity$activityResultRegistry$1$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            androidx.activity.ComponentActivity$activityResultRegistry$1.onLaunch$lambda$1(this.f$0, i, sendIntentException);
                        }
                    });
                }
            } catch (android.content.IntentSender.SendIntentException e2) {
                e = e2;
                i = requestCode;
            }
        } else {
            androidx.core.app.ActivityCompat.startActivityForResult(componentActivity, intentCreateIntent, requestCode, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLaunch$lambda$0(androidx.activity.ComponentActivity$activityResultRegistry$1 this$0, int i, androidx.activity.result.contract.ActivityResultContract.SynchronousResult synchronousResult) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dispatchResult(i, synchronousResult.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLaunch$lambda$1(androidx.activity.ComponentActivity$activityResultRegistry$1 this$0, int i, android.content.IntentSender.SendIntentException e) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(e, "$e");
        this$0.dispatchResult(i, 0, new android.content.Intent().setAction(androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST).putExtra(androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.EXTRA_SEND_INTENT_EXCEPTION, e));
    }
}
