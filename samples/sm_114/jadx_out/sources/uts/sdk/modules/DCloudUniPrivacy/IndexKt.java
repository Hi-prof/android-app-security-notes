package uts.sdk.modules.DCloudUniPrivacy;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u00105\u001a\u00020\t2\u0006\u0010\u000f\u001a\u000206\u001a\u0006\u00107\u001a\u00020\t\u001a\u000e\u00108\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u000209\u001a\u000e\u0010:\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006\u001a\u0006\u0010;\u001a\u00020\t\"0\u0010\u0019\u001a!\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u001b\u0010\u001d\u001a\f\u0012\u0004\u0012\u00020\t0\u0017j\u0002`\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \"<\u0010!\u001a-\u0012\u0004\u0012\u00020\u0006\u0012#\u0012!\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$\"\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\"\u001d\u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001c\"^\u0010,\u001aO\u0012A\u0012?\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001j\u0011`\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001c\"0\u0010/\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\t0\u0001j\u0002`0¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001c\"\u001b\u00102\u001a\f\u0012\u0004\u0012\u00020\t0\u0017j\u0002`3¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 *n\u0010\u0000\"\u001d\u0012\u0013\u0012\u0011`\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012K\u0012A\u0012?\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001j\u0011`\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010\n\"\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\t0\u00012\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\t0\u0001*@\u0010\f\"\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00012\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001*@\u0010\r\"\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\t0\u00012\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\t0\u0001*@\u0010\u0010\"\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u00012\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u0001*@\u0010\u0013\"\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u00012\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u0001*@\u0010\u0015\"\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u00012\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u0001*\u0016\u0010\u0016\"\b\u0012\u0004\u0012\u00020\t0\u00172\b\u0012\u0004\u0012\u00020\t0\u0017*\u0016\u0010\u0018\"\b\u0012\u0004\u0012\u00020\t0\u00172\b\u0012\u0004\u0012\u00020\t0\u0017¨\u0006<"}, d2 = {"OnPrivacyAuthorizationChange", "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniPrivacy/OnPrivacyAuthorizationChangeCallback;", "Lkotlin/ParameterName;", "name", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "", "Luts/sdk/modules/DCloudUniPrivacy/PrivacyChangeResult;", com.facebook.common.util.UriUtil.LOCAL_RESOURCE_SCHEME, "", "OffPrivacyAuthorizationChange", "id", "OnPrivacyAuthorizationChangeCallback", "GetPrivacySetting", "Luts/sdk/modules/DCloudUniPrivacy/GetPrivacySettingOptions;", "options", "GetPrivacySettingSuccessCallback", "Luts/sdk/modules/DCloudUniPrivacy/GetPrivacySettingSuccessResult;", "result", "GetPrivacySettingFailCallback", "", "GetPrivacySettingCompleteCallback", "ResetPrivacyAuthorization", "Lkotlin/Function0;", "AgreePrivacyAuthorization", "getPrivacySetting", "Luts/sdk/modules/DCloudUniPrivacy/GetPrivacySetting;", "getGetPrivacySetting", "()Lkotlin/jvm/functions/Function1;", "resetPrivacyAuthorization", "Luts/sdk/modules/DCloudUniPrivacy/ResetPrivacyAuthorization;", "getResetPrivacyAuthorization", "()Lkotlin/jvm/functions/Function0;", "privacyCallbacks", "Ljava/util/HashMap;", "getPrivacyCallbacks", "()Ljava/util/HashMap;", "getId", "()Ljava/lang/Number;", "setId", "(Ljava/lang/Number;)V", "privacyAuthorizationChangeFunction", "Lio/dcloud/uts/PrivacyOption;", "getPrivacyAuthorizationChangeFunction", "onPrivacyAuthorizationChange", "Luts/sdk/modules/DCloudUniPrivacy/OnPrivacyAuthorizationChange;", "getOnPrivacyAuthorizationChange", "offPrivacyAuthorizationChange", "Luts/sdk/modules/DCloudUniPrivacy/OffPrivacyAuthorizationChange;", "getOffPrivacyAuthorizationChange", "agreePrivacyAuthorization", "Luts/sdk/modules/DCloudUniPrivacy/AgreePrivacyAuthorization;", "getAgreePrivacyAuthorization", "getPrivacySettingByJs", "Luts/sdk/modules/DCloudUniPrivacy/GetPrivacySettingOptionsJSONObject;", "resetPrivacyAuthorizationByJs", "onPrivacyAuthorizationChangeByJs", "Lio/dcloud/uts/UTSCallback;", "offPrivacyAuthorizationChangeByJs", "agreePrivacyAuthorizationByJs", "uni-privacy_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IndexKt {
    private static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrivacy.GetPrivacySettingOptions, kotlin.Unit> getPrivacySetting = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrivacy.IndexKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function1
        public final java.lang.Object invoke(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniPrivacy.IndexKt.getPrivacySetting$lambda$0((uts.sdk.modules.DCloudUniPrivacy.GetPrivacySettingOptions) obj);
        }
    };
    private static final kotlin.jvm.functions.Function0<kotlin.Unit> resetPrivacyAuthorization = new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniPrivacy.IndexKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final java.lang.Object invoke() {
            return uts.sdk.modules.DCloudUniPrivacy.IndexKt.resetPrivacyAuthorization$lambda$1();
        }
    };
    private static final java.util.HashMap<java.lang.Number, kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrivacy.PrivacyChangeResult, kotlin.Unit>> privacyCallbacks = new java.util.HashMap<>();
    private static java.lang.Number id = (java.lang.Number) 0;
    private static final kotlin.jvm.functions.Function1<io.dcloud.uts.PrivacyOption, kotlin.Unit> privacyAuthorizationChangeFunction = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrivacy.IndexKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function1
        public final java.lang.Object invoke(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniPrivacy.IndexKt.privacyAuthorizationChangeFunction$lambda$3((io.dcloud.uts.PrivacyOption) obj);
        }
    };
    private static final kotlin.jvm.functions.Function1<kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrivacy.PrivacyChangeResult, kotlin.Unit>, java.lang.Number> onPrivacyAuthorizationChange = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrivacy.IndexKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function1
        public final java.lang.Object invoke(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniPrivacy.IndexKt.onPrivacyAuthorizationChange$lambda$4((kotlin.jvm.functions.Function1) obj);
        }
    };
    private static final kotlin.jvm.functions.Function1<java.lang.Number, kotlin.Unit> offPrivacyAuthorizationChange = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrivacy.IndexKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function1
        public final java.lang.Object invoke(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniPrivacy.IndexKt.offPrivacyAuthorizationChange$lambda$5((java.lang.Number) obj);
        }
    };
    private static final kotlin.jvm.functions.Function0<kotlin.Unit> agreePrivacyAuthorization = new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniPrivacy.IndexKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function0
        public final java.lang.Object invoke() {
            return uts.sdk.modules.DCloudUniPrivacy.IndexKt.agreePrivacyAuthorization$lambda$6();
        }
    };

    public static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrivacy.GetPrivacySettingOptions, kotlin.Unit> getGetPrivacySetting() {
        return getPrivacySetting;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit getPrivacySetting$lambda$0(uts.sdk.modules.DCloudUniPrivacy.GetPrivacySettingOptions getPrivacySettingOptions) {
        uts.sdk.modules.DCloudUniPrivacy.GetPrivacySettingSuccessResult getPrivacySettingSuccessResult = new uts.sdk.modules.DCloudUniPrivacy.GetPrivacySettingSuccessResult(!io.dcloud.uts.UTSAndroid.INSTANCE.isPrivacyAgree());
        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrivacy.GetPrivacySettingSuccessResult, kotlin.Unit> success = getPrivacySettingOptions.getSuccess();
        if (success != null) {
            success.invoke(getPrivacySettingSuccessResult);
        }
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = getPrivacySettingOptions.getComplete();
        if (complete != null) {
            complete.invoke(getPrivacySettingSuccessResult);
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function0<kotlin.Unit> getResetPrivacyAuthorization() {
        return resetPrivacyAuthorization;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit resetPrivacyAuthorization$lambda$1() {
        io.dcloud.uts.UTSAndroid.INSTANCE.resetPrivacyAgree();
        return kotlin.Unit.INSTANCE;
    }

    public static final java.util.HashMap<java.lang.Number, kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrivacy.PrivacyChangeResult, kotlin.Unit>> getPrivacyCallbacks() {
        return privacyCallbacks;
    }

    public static final java.lang.Number getId() {
        return id;
    }

    public static final void setId(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        id = number;
    }

    public static final kotlin.jvm.functions.Function1<io.dcloud.uts.PrivacyOption, kotlin.Unit> getPrivacyAuthorizationChangeFunction() {
        return privacyAuthorizationChangeFunction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit privacyAuthorizationChangeFunction$lambda$3(io.dcloud.uts.PrivacyOption privacyOption) {
        java.util.Collection<kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrivacy.PrivacyChangeResult, kotlin.Unit>> collectionValues = privacyCallbacks.values();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        java.util.Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((kotlin.jvm.functions.Function1) it.next()).invoke(new uts.sdk.modules.DCloudUniPrivacy.PrivacyChangeResult(!privacyOption.getIsAgree()));
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function1<kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrivacy.PrivacyChangeResult, kotlin.Unit>, java.lang.Number> getOnPrivacyAuthorizationChange() {
        return onPrivacyAuthorizationChange;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Number onPrivacyAuthorizationChange$lambda$4(kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrivacy.PrivacyChangeResult, kotlin.Unit> function1) {
        java.util.HashMap<java.lang.Number, kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrivacy.PrivacyChangeResult, kotlin.Unit>> map = privacyCallbacks;
        if (map.isEmpty()) {
            io.dcloud.uts.UTSAndroid.INSTANCE.onPrivacyAgreeChange(privacyAuthorizationChangeFunction);
        }
        java.lang.Number numberPlus = io.dcloud.uts.NumberKt.plus(id, (java.lang.Number) 1);
        id = numberPlus;
        map.put(numberPlus, function1);
        return id;
    }

    public static final kotlin.jvm.functions.Function1<java.lang.Number, kotlin.Unit> getOffPrivacyAuthorizationChange() {
        return offPrivacyAuthorizationChange;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit offPrivacyAuthorizationChange$lambda$5(java.lang.Number number) {
        java.util.HashMap<java.lang.Number, kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrivacy.PrivacyChangeResult, kotlin.Unit>> map = privacyCallbacks;
        map.remove(number);
        if (map.isEmpty()) {
            io.dcloud.uts.UTSAndroid.INSTANCE.offPrivacyAgreeChange(privacyAuthorizationChangeFunction);
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function0<kotlin.Unit> getAgreePrivacyAuthorization() {
        return agreePrivacyAuthorization;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit agreePrivacyAuthorization$lambda$6() {
        io.dcloud.uts.UTSAndroid.INSTANCE.setPrivacyAgree(true);
        return kotlin.Unit.INSTANCE;
    }

    public static final void getPrivacySettingByJs(final uts.sdk.modules.DCloudUniPrivacy.GetPrivacySettingOptionsJSONObject options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        getPrivacySetting.invoke(new uts.sdk.modules.DCloudUniPrivacy.GetPrivacySettingOptions(new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrivacy.IndexKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final java.lang.Object invoke(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrivacy.IndexKt.getPrivacySettingByJs$lambda$7(options, (uts.sdk.modules.DCloudUniPrivacy.GetPrivacySettingSuccessResult) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrivacy.IndexKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final java.lang.Object invoke(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrivacy.IndexKt.getPrivacySettingByJs$lambda$8(options, obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrivacy.IndexKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final java.lang.Object invoke(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrivacy.IndexKt.getPrivacySettingByJs$lambda$9(options, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit getPrivacySettingByJs$lambda$7(uts.sdk.modules.DCloudUniPrivacy.GetPrivacySettingOptionsJSONObject getPrivacySettingOptionsJSONObject, uts.sdk.modules.DCloudUniPrivacy.GetPrivacySettingSuccessResult getPrivacySettingSuccessResult) {
        io.dcloud.uts.UTSCallback success = getPrivacySettingOptionsJSONObject.getSuccess();
        if (success != null) {
            success.invoke(getPrivacySettingSuccessResult);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit getPrivacySettingByJs$lambda$8(uts.sdk.modules.DCloudUniPrivacy.GetPrivacySettingOptionsJSONObject getPrivacySettingOptionsJSONObject, java.lang.Object obj) {
        io.dcloud.uts.UTSCallback fail = getPrivacySettingOptionsJSONObject.getFail();
        if (fail != null) {
            fail.invoke(obj);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit getPrivacySettingByJs$lambda$9(uts.sdk.modules.DCloudUniPrivacy.GetPrivacySettingOptionsJSONObject getPrivacySettingOptionsJSONObject, java.lang.Object obj) {
        io.dcloud.uts.UTSCallback complete = getPrivacySettingOptionsJSONObject.getComplete();
        if (complete != null) {
            complete.invoke(obj);
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final void resetPrivacyAuthorizationByJs() {
        resetPrivacyAuthorization.invoke();
    }

    public static final java.lang.Number onPrivacyAuthorizationChangeByJs(final io.dcloud.uts.UTSCallback callback) {
        java.lang.Object fnJS;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        kotlin.jvm.functions.Function1<kotlin.jvm.functions.Function1<? super uts.sdk.modules.DCloudUniPrivacy.PrivacyChangeResult, kotlin.Unit>, java.lang.Number> function1 = onPrivacyAuthorizationChange;
        if (callback.getFnJS() != null) {
            fnJS = callback.getFnJS();
        } else {
            callback.setFnJS(new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrivacy.IndexKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final java.lang.Object invoke(java.lang.Object obj) {
                    return uts.sdk.modules.DCloudUniPrivacy.IndexKt.onPrivacyAuthorizationChangeByJs$lambda$10(callback, (uts.sdk.modules.DCloudUniPrivacy.PrivacyChangeResult) obj);
                }
            });
            fnJS = callback.getFnJS();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(fnJS, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"res\")] uts.sdk.modules.DCloudUniPrivacy.PrivacyChangeResult, kotlin.Unit>");
        return function1.invoke((kotlin.jvm.functions.Function1) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(fnJS, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit onPrivacyAuthorizationChangeByJs$lambda$10(io.dcloud.uts.UTSCallback uTSCallback, uts.sdk.modules.DCloudUniPrivacy.PrivacyChangeResult privacyChangeResult) {
        uTSCallback.invoke(privacyChangeResult);
        return kotlin.Unit.INSTANCE;
    }

    public static final void offPrivacyAuthorizationChangeByJs(java.lang.Number id2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(id2, "id");
        offPrivacyAuthorizationChange.invoke(id2);
    }

    public static final void agreePrivacyAuthorizationByJs() {
        agreePrivacyAuthorization.invoke();
    }
}
