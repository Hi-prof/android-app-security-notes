package uts.sdk.modules.DCloudUniPrompt;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0082\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020\u0013\u001a\u0006\u0010B\u001a\u00020\n\u001a\u000e\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u001e\u001a\u0006\u0010E\u001a\u00020\n\u001a\u0010\u0010F\u001a\u00020\n2\b\u0010G\u001a\u0004\u0018\u00010\u0010\u001a\u001e\u0010H\u001a\u00020\n2\u0006\u0010A\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u0010\u001a\u001e\u0010Q\u001a\u00020\n2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u0010\u001a\u000e\u0010X\u001a\u00020\n2\u0006\u0010A\u001a\u00020'\u001a\u000e\u0010_\u001a\u00020\n2\u0006\u0010A\u001a\u00020/\u001a\u0010\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010\u0010\u001a\u000e\u0010w\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020x\u001a\u0006\u0010y\u001a\u00020\n\u001a\u000e\u0010z\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020{\u001a\u0006\u0010|\u001a\u00020\n\u001a\u000e\u0010}\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020~\u001a\u000f\u0010\u007f\u001a\u00020\n2\u0007\u0010\u0014\u001a\u00030\u0080\u0001\"\u001c\u00100\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104\"\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\"\u001c\u0010;\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?\"\"\u0010J\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P\"\u001c\u0010R\u001a\u0004\u0018\u00010SX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W\"\u001c\u0010Y\u001a\u0004\u0018\u00010ZX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^\"0\u0010c\u001a!\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0005j\u0002`d¢\u0006\b\n\u0000\u001a\u0004\be\u0010f\"\u001b\u0010g\u001a\f\u0012\u0004\u0012\u00020\n0\u0016j\u0002`h¢\u0006\b\n\u0000\u001a\u0004\bi\u0010j\"0\u0010k\u001a!\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0005j\u0002`l¢\u0006\b\n\u0000\u001a\u0004\bm\u0010f\"\u001b\u0010n\u001a\f\u0012\u0004\u0012\u00020\n0\u0016j\u0002`o¢\u0006\b\n\u0000\u001a\u0004\bp\u0010j\"0\u0010q\u001a!\u0012\u0013\u0012\u00110'¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0005j\u0002`r¢\u0006\b\n\u0000\u001a\u0004\bs\u0010f\"0\u0010t\u001a!\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0005j\u0002`u¢\u0006\b\n\u0000\u001a\u0004\bv\u0010f*\n\u0010\u0000\"\u00020\u00012\u00020\u0001*\n\u0010\u0002\"\u00020\u00032\u00020\u0003*@\u0010\u0004\"\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005*S\u0010\u000b\"\u001d\u0012\u0013\u0012\u0011`\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u000520\u0012&\u0012$0\u0003j\u0011`\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005*@\u0010\r\"\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005*\n\u0010\u000f\"\u00020\u00102\u00020\u0010*\n\u0010\u0011\"\u00020\u00102\u00020\u0010*@\u0010\u0012\"\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u00052\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0005*\u0016\u0010\u0015\"\b\u0012\u0004\u0012\u00020\n0\u00162\b\u0012\u0004\u0012\u00020\n0\u0016*\n\u0010\u0017\"\u00020\u00032\u00020\u0003*@\u0010\u0018\"\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005*S\u0010\u001a\"\u001d\u0012\u0013\u0012\u0011`\u001b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u000520\u0012&\u0012$0\u0003j\u0011`\u001b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005*@\u0010\u001c\"\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005*@\u0010\u001d\"\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u00052\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0005*\u0016\u0010\u001f\"\b\u0012\u0004\u0012\u00020\n0\u00162\b\u0012\u0004\u0012\u00020\n0\u0016*\n\u0010 \"\u00020\u00032\u00020\u0003*@\u0010!\"\u001d\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052\u001d\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005*S\u0010#\"\u001d\u0012\u0013\u0012\u0011`$¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u000520\u0012&\u0012$0\u0003j\u0011`$¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005*@\u0010%\"\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005*@\u0010&\"\u001d\u0012\u0013\u0012\u00110'¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u00052\u001d\u0012\u0013\u0012\u00110'¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0005*\n\u0010(\"\u00020\u00032\u00020\u0003*@\u0010)\"\u001d\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052\u001d\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005*S\u0010+\"\u001d\u0012\u0013\u0012\u0011`,¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u000520\u0012&\u0012$0\u0003j\u0011`,¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005*@\u0010-\"\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005*@\u0010.\"\u001d\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u00052\u001d\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0005¨\u0006\u0081\u0001"}, d2 = {"PromptErrorCode", "", "ShowToastFail", "Luts/sdk/modules/DCloudUniPrompt/IPromptError;", "ShowToastSuccessCallback", "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniPrompt/ShowToastSuccess;", "Lkotlin/ParameterName;", "name", com.facebook.common.util.UriUtil.LOCAL_RESOURCE_SCHEME, "", "ShowToastFailCallback", "Luts/sdk/modules/DCloudUniPrompt/ShowToastFail;", "ShowToastCompleteCallback", "", "Icon", "", "ShowToastPosition", "ShowToast", "Luts/sdk/modules/DCloudUniPrompt/ShowToastOptions;", "options", "HideToast", "Lkotlin/Function0;", "ShowLoadingFail", "ShowLoadingSuccessCallback", "Luts/sdk/modules/DCloudUniPrompt/ShowLoadingSuccess;", "ShowLoadingFailCallback", "Luts/sdk/modules/DCloudUniPrompt/ShowLoadingFail;", "ShowLoadingCompleteCallback", "ShowLoading", "Luts/sdk/modules/DCloudUniPrompt/ShowLoadingOptions;", "HideLoading", "ShowModalFail", "ShowModalSuccessCallback", "Luts/sdk/modules/DCloudUniPrompt/ShowModalSuccess;", "ShowModalFailCallback", "Luts/sdk/modules/DCloudUniPrompt/ShowModalFail;", "ShowModalCompleteCallback", "ShowModal", "Luts/sdk/modules/DCloudUniPrompt/ShowModalOptions;", "ShowActionSheetFail", "ShowActionSheetSuccessCallback", "Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetSuccess;", "ShowActionSheetFailCallback", "Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetFail;", "ShowActionSheetCompleteCallback", "ShowActionSheet", "Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptions;", "timeout", "getTimeout", "()Ljava/lang/Number;", "setTimeout", "(Ljava/lang/Number;)V", "toast", "Luts/sdk/modules/DCloudUniPrompt/WaitingView;", "getToast", "()Luts/sdk/modules/DCloudUniPrompt/WaitingView;", "setToast", "(Luts/sdk/modules/DCloudUniPrompt/WaitingView;)V", "toastType", "getToastType", "()Ljava/lang/String;", "setToastType", "(Ljava/lang/String;)V", "showToastImpl", "style", "hideToastImpl", "showLoadingImpl", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_OPTION, "hideLoadingImpl", "closeToast", "type", "makeLoading", com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, "androidToastCache", "Ljava/lang/ref/WeakReference;", "Landroid/widget/Toast;", "getAndroidToastCache", "()Ljava/lang/ref/WeakReference;", "setAndroidToastCache", "(Ljava/lang/ref/WeakReference;)V", "makeToast", "utsDialog", "Luts/sdk/modules/DCloudUniPrompt/UTSDialog;", "getUtsDialog", "()Luts/sdk/modules/DCloudUniPrompt/UTSDialog;", "setUtsDialog", "(Luts/sdk/modules/DCloudUniPrompt/UTSDialog;)V", "showModalImpl", "uniActionSheet", "Luts/sdk/modules/DCloudUniPrompt/UniActionSheet;", "getUniActionSheet", "()Luts/sdk/modules/DCloudUniPrompt/UniActionSheet;", "setUniActionSheet", "(Luts/sdk/modules/DCloudUniPrompt/UniActionSheet;)V", "actionSheetImpl", "isValidColor", "", "colorStr", "showToast", "Luts/sdk/modules/DCloudUniPrompt/ShowToast;", "getShowToast", "()Lkotlin/jvm/functions/Function1;", "hideToast", "Luts/sdk/modules/DCloudUniPrompt/HideToast;", "getHideToast", "()Lkotlin/jvm/functions/Function0;", "showLoading", "Luts/sdk/modules/DCloudUniPrompt/ShowLoading;", "getShowLoading", "hideLoading", "Luts/sdk/modules/DCloudUniPrompt/HideLoading;", "getHideLoading", "showModal", "Luts/sdk/modules/DCloudUniPrompt/ShowModal;", "getShowModal", "showActionSheet", "Luts/sdk/modules/DCloudUniPrompt/ShowActionSheet;", "getShowActionSheet", "showToastByJs", "Luts/sdk/modules/DCloudUniPrompt/ShowToastOptionsJSONObject;", "hideToastByJs", "showLoadingByJs", "Luts/sdk/modules/DCloudUniPrompt/ShowLoadingOptionsJSONObject;", "hideLoadingByJs", "showModalByJs", "Luts/sdk/modules/DCloudUniPrompt/ShowModalOptionsJSONObject;", "showActionSheetByJs", "Luts/sdk/modules/DCloudUniPrompt/ShowActionSheetOptionsJSONObject;", "uni-prompt_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IndexKt {
    private static java.lang.ref.WeakReference<android.widget.Toast> androidToastCache;
    private static java.lang.Number timeout;
    private static uts.sdk.modules.DCloudUniPrompt.WaitingView toast;
    private static java.lang.String toastType;
    private static uts.sdk.modules.DCloudUniPrompt.UniActionSheet uniActionSheet;
    private static uts.sdk.modules.DCloudUniPrompt.UTSDialog utsDialog;
    private static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowToastOptions, kotlin.Unit> showToast = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda23
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public final java.lang.Object invoke2(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniPrompt.IndexKt.showToast$lambda$6((uts.sdk.modules.DCloudUniPrompt.ShowToastOptions) obj);
        }
    };
    private static final kotlin.jvm.functions.Function0<kotlin.Unit> hideToast = new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda24
        @Override // kotlin.jvm.functions.Function0
        public final java.lang.Object invoke() {
            return uts.sdk.modules.DCloudUniPrompt.IndexKt.hideToast$lambda$8();
        }
    };
    private static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowLoadingOptions, kotlin.Unit> showLoading = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda25
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public final java.lang.Object invoke2(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniPrompt.IndexKt.showLoading$lambda$10((uts.sdk.modules.DCloudUniPrompt.ShowLoadingOptions) obj);
        }
    };
    private static final kotlin.jvm.functions.Function0<kotlin.Unit> hideLoading = new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda26
        @Override // kotlin.jvm.functions.Function0
        public final java.lang.Object invoke() {
            return uts.sdk.modules.DCloudUniPrompt.IndexKt.hideLoading$lambda$12();
        }
    };
    private static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowModalOptions, kotlin.Unit> showModal = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda27
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public final java.lang.Object invoke2(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniPrompt.IndexKt.showModal$lambda$14((uts.sdk.modules.DCloudUniPrompt.ShowModalOptions) obj);
        }
    };
    private static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions, kotlin.Unit> showActionSheet = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda28
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public final java.lang.Object invoke2(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniPrompt.IndexKt.showActionSheet$lambda$16((uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions) obj);
        }
    };

    public static final java.lang.Number getTimeout() {
        return timeout;
    }

    public static final void setTimeout(java.lang.Number number) {
        timeout = number;
    }

    public static final uts.sdk.modules.DCloudUniPrompt.WaitingView getToast() {
        return toast;
    }

    public static final void setToast(uts.sdk.modules.DCloudUniPrompt.WaitingView waitingView) {
        toast = waitingView;
    }

    public static final java.lang.String getToastType() {
        return toastType;
    }

    public static final void setToastType(java.lang.String str) {
        toastType = str;
    }

    public static final void showToastImpl(uts.sdk.modules.DCloudUniPrompt.ShowToastOptions style) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(style, "style");
        makeToast(style, "toast", "showToast");
    }

    public static final void hideToastImpl() {
        closeToast("toast");
    }

    public static final void showLoadingImpl(uts.sdk.modules.DCloudUniPrompt.ShowLoadingOptions option) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(option, "option");
        makeLoading(option, "loading", "showLoading");
    }

    public static final void hideLoadingImpl() {
        closeToast("loading");
    }

    public static final void closeToast(java.lang.String str) {
        if (str == null || str == toastType) {
            java.lang.Number number = timeout;
            if (number != null) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(number, "null cannot be cast to non-null type kotlin.Number");
                if (io.dcloud.uts.NumberKt.compareTo(number, (java.lang.Number) 0) > 0) {
                    java.lang.Number number2 = timeout;
                    kotlin.jvm.internal.Intrinsics.checkNotNull(number2, "null cannot be cast to non-null type kotlin.Number");
                    io.dcloud.uts.UTSTimerKt.clearTimeout(number2);
                    timeout = null;
                }
            }
            uts.sdk.modules.DCloudUniPrompt.WaitingView waitingView = toast;
            if (waitingView != null) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(waitingView, "null cannot be cast to non-null type uts.sdk.modules.DCloudUniPrompt.WaitingView");
                waitingView.close();
                toast = null;
            }
            uts.sdk.modules.DCloudUniPrompt.WaitingView waitingView2 = toast;
            if (waitingView2 != null) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(waitingView2, "null cannot be cast to non-null type uts.sdk.modules.DCloudUniPrompt.WaitingView");
                waitingView2.close();
                toast = null;
            }
            java.lang.ref.WeakReference<android.widget.Toast> weakReference = androidToastCache;
            if ((weakReference != null ? weakReference.get() : null) != null) {
                java.lang.ref.WeakReference<android.widget.Toast> weakReference2 = androidToastCache;
                kotlin.jvm.internal.Intrinsics.checkNotNull(weakReference2);
                android.widget.Toast toast2 = weakReference2.get();
                kotlin.jvm.internal.Intrinsics.checkNotNull(toast2);
                toast2.cancel();
            }
            toastType = null;
        }
    }

    public static final void makeLoading(uts.sdk.modules.DCloudUniPrompt.ShowLoadingOptions style, java.lang.String type, java.lang.String errMsg) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(style, "style");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        closeToast(null);
        if (style.getTitle() == null) {
            uts.sdk.modules.DCloudUniPrompt.PromptErrorImpl promptErrorImpl = new uts.sdk.modules.DCloudUniPrompt.PromptErrorImpl((java.lang.Number) 1001, "showLoading:title is null");
            kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> fail = style.getFail();
            if (fail != null) {
                fail.invoke2(promptErrorImpl);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = style.getComplete();
            if (complete != null) {
                complete.invoke2(promptErrorImpl);
                return;
            }
            return;
        }
        toastType = type;
        io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
        io.dcloud.uts.UTSJSONObject uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(kotlin.TuplesKt.to("name", style.getTitle()), kotlin.TuplesKt.to(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_MODAL, style.getMask()), kotlin.TuplesKt.to("back", "transmit"), kotlin.TuplesKt.to("padding", "10"), kotlin.TuplesKt.to(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "16"));
        uTSJSONObject_uO.set("width", "140");
        uTSJSONObject_uO.set("height", "112");
        uts.sdk.modules.DCloudUniPrompt.WaitingView waitingView = new uts.sdk.modules.DCloudUniPrompt.WaitingView(io.dcloud.uts.UTSAndroid.INSTANCE.getTopPageActivity(), uTSJSONObject_uO, io.dcloud.uts.UTSAndroid.INSTANCE.getTopPageView());
        toast = waitingView;
        waitingView.showWaiting();
        io.dcloud.uts.UTSAndroid.INSTANCE.onAppActivityDestroy(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.makeLoading$lambda$0();
            }
        });
        uts.sdk.modules.DCloudUniPrompt.ShowLoadingSuccess showLoadingSuccess = new uts.sdk.modules.DCloudUniPrompt.ShowLoadingSuccess();
        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowLoadingSuccess, kotlin.Unit> success = style.getSuccess();
        if (success != null) {
            success.invoke2(showLoadingSuccess);
        }
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete2 = style.getComplete();
        if (complete2 != null) {
            complete2.invoke2(showLoadingSuccess);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit makeLoading$lambda$0() {
        uts.sdk.modules.DCloudUniPrompt.WaitingView waitingView = toast;
        if (waitingView != null) {
            waitingView.close();
        }
        toast = null;
        return kotlin.Unit.INSTANCE;
    }

    public static final java.lang.ref.WeakReference<android.widget.Toast> getAndroidToastCache() {
        return androidToastCache;
    }

    public static final void setAndroidToastCache(java.lang.ref.WeakReference<android.widget.Toast> weakReference) {
        androidToastCache = weakReference;
    }

    public static final void makeToast(uts.sdk.modules.DCloudUniPrompt.ShowToastOptions style, java.lang.String type, java.lang.String errMsg) {
        java.lang.String str;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(style, "style");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        closeToast(null);
        if (style.getTitle() == null || style.getTitle().length() == 0) {
            uts.sdk.modules.DCloudUniPrompt.PromptErrorImpl promptErrorImpl = new uts.sdk.modules.DCloudUniPrompt.PromptErrorImpl((java.lang.Number) 1001, "showLoading:title is null");
            kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> fail = style.getFail();
            if (fail != null) {
                fail.invoke2(promptErrorImpl);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = style.getComplete();
            if (complete != null) {
                complete.invoke2(promptErrorImpl);
                return;
            }
            return;
        }
        toastType = type;
        if (kotlin.collections.CollectionsKt.indexOf((java.util.List<? extends java.lang.String>) io.dcloud.uts.UTSArrayKt._uA("top", "center", "bottom"), style.getPosition()) >= 0) {
            android.widget.Toast toastMakeText = android.widget.Toast.makeText(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext(), style.getTitle(), 0);
            java.lang.String position = style.getPosition();
            if (position != null) {
                int iHashCode = position.hashCode();
                if (iHashCode != -1383228885) {
                    if (iHashCode != -1364013995) {
                        if (iHashCode == 115029 && position.equals("top")) {
                            kotlin.jvm.internal.Intrinsics.checkNotNull(toastMakeText);
                            toastMakeText.setGravity(48, toastMakeText.getXOffset(), toastMakeText.getYOffset());
                        }
                    } else if (position.equals("center")) {
                        kotlin.jvm.internal.Intrinsics.checkNotNull(toastMakeText);
                        toastMakeText.setGravity(17, 0, 0);
                    }
                } else if (position.equals("bottom")) {
                    kotlin.jvm.internal.Intrinsics.checkNotNull(toastMakeText);
                    toastMakeText.setGravity(80, toastMakeText.getXOffset(), toastMakeText.getYOffset());
                }
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(toastMakeText);
            toastMakeText.show();
            androidToastCache = new java.lang.ref.WeakReference<>(toastMakeText);
            uts.sdk.modules.DCloudUniPrompt.ShowToastSuccess showToastSuccess = new uts.sdk.modules.DCloudUniPrompt.ShowToastSuccess();
            kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowToastSuccess, kotlin.Unit> success = style.getSuccess();
            if (success != null) {
                success.invoke2(showToastSuccess);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete2 = style.getComplete();
            if (complete2 != null) {
                complete2.invoke2(showToastSuccess);
                return;
            }
            return;
        }
        io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
        java.lang.String icon = style.getIcon();
        if (icon == null || io.dcloud.uts.UTSArrayKt._uA(com.taobao.weex.ui.component.WXImage.SUCCEED, "loading", "error", "none").indexOf(icon) < 0) {
            icon = com.taobao.weex.ui.component.WXImage.SUCCEED;
        }
        io.dcloud.uts.UTSJSONObject uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(kotlin.TuplesKt.to("name", style.getTitle()), kotlin.TuplesKt.to(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_MODAL, style.getMask()), kotlin.TuplesKt.to("back", "transmit"), kotlin.TuplesKt.to("padding", "10"), kotlin.TuplesKt.to(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "16"));
        if ((style.getImage() == null || kotlin.jvm.internal.Intrinsics.areEqual(style.getImage(), "")) && kotlin.jvm.internal.Intrinsics.areEqual(icon, "none")) {
            uTSJSONObject_uO.set("loading", io.dcloud.uts.UTSJSONObjectKt._uO(kotlin.TuplesKt.to("display", "none")));
        } else {
            uTSJSONObject_uO.set("width", "140");
            uTSJSONObject_uO.set("height", "112");
        }
        if (style.getImage() != null && !kotlin.jvm.internal.Intrinsics.areEqual(style.getImage(), "")) {
            java.lang.String image = style.getImage();
            kotlin.jvm.internal.Intrinsics.checkNotNull(image);
            uTSJSONObject_uO.set("loading", io.dcloud.uts.UTSJSONObjectKt._uO(kotlin.TuplesKt.to("display", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_BLOCK), kotlin.TuplesKt.to("height", "55"), kotlin.TuplesKt.to(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON, image)));
        } else if (io.dcloud.uts.UTSArrayKt._uA(com.taobao.weex.ui.component.WXImage.SUCCEED, "error").indexOf(icon) >= 0) {
            kotlin.Pair[] pairArr = new kotlin.Pair[3];
            pairArr[0] = kotlin.TuplesKt.to("display", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_BLOCK);
            pairArr[1] = kotlin.TuplesKt.to("height", "36");
            if (kotlin.jvm.internal.Intrinsics.areEqual(icon, com.taobao.weex.ui.component.WXImage.SUCCEED)) {
                str = "successIcon";
            } else {
                str = "errorIcon";
            }
            pairArr[2] = kotlin.TuplesKt.to(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON, str);
            uTSJSONObject_uO.set("loading", io.dcloud.uts.UTSJSONObjectKt._uO(pairArr));
        }
        android.app.Activity topPageActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getTopPageActivity();
        if (topPageActivity != null) {
            uts.sdk.modules.DCloudUniPrompt.WaitingView waitingView = new uts.sdk.modules.DCloudUniPrompt.WaitingView(topPageActivity, uTSJSONObject_uO, io.dcloud.uts.UTSAndroid.INSTANCE.getTopPageView());
            toast = waitingView;
            waitingView.showWaiting();
            io.dcloud.uts.UTSAndroid.INSTANCE.onAppActivityDestroy(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return uts.sdk.modules.DCloudUniPrompt.IndexKt.makeToast$lambda$1();
                }
            });
        }
        java.lang.Number duration = style.getDuration();
        if (duration == null || io.dcloud.uts.NumberKt.compareTo(duration, (java.lang.Number) 0) <= 0) {
            duration = (java.lang.Number) 1500;
        }
        if (type != "loading") {
            timeout = io.dcloud.uts.UTSTimerKt.setTimeout(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return uts.sdk.modules.DCloudUniPrompt.IndexKt.makeToast$lambda$2();
                }
            }, duration);
        }
        uts.sdk.modules.DCloudUniPrompt.ShowToastSuccess showToastSuccess2 = new uts.sdk.modules.DCloudUniPrompt.ShowToastSuccess();
        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowToastSuccess, kotlin.Unit> success2 = style.getSuccess();
        if (success2 != null) {
            success2.invoke2(showToastSuccess2);
        }
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete3 = style.getComplete();
        if (complete3 != null) {
            complete3.invoke2(showToastSuccess2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit makeToast$lambda$1() {
        uts.sdk.modules.DCloudUniPrompt.WaitingView waitingView = toast;
        if (waitingView != null) {
            waitingView.close();
        }
        toast = null;
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit makeToast$lambda$2() {
        uts.sdk.modules.DCloudUniPrompt.WaitingView waitingView = toast;
        if (waitingView != null) {
            waitingView.close();
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final uts.sdk.modules.DCloudUniPrompt.UTSDialog getUtsDialog() {
        return utsDialog;
    }

    public static final void setUtsDialog(uts.sdk.modules.DCloudUniPrompt.UTSDialog uTSDialog) {
        utsDialog = uTSDialog;
    }

    public static final void showModalImpl(uts.sdk.modules.DCloudUniPrompt.ShowModalOptions style) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(style, "style");
        uts.sdk.modules.DCloudUniPrompt.UTSDialog uTSDialog = utsDialog;
        if (uTSDialog != null) {
            if (uTSDialog != null) {
                uTSDialog.dismiss();
            }
            utsDialog = null;
        }
        if (io.dcloud.uts.UTSAndroid.INSTANCE.getTopPageActivity() == null) {
            return;
        }
        android.app.Activity topPageActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getTopPageActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNull(topPageActivity);
        if (topPageActivity.isFinishing()) {
            return;
        }
        android.app.Activity topPageActivity2 = io.dcloud.uts.UTSAndroid.INSTANCE.getTopPageActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNull(topPageActivity2);
        uts.sdk.modules.DCloudUniPrompt.UTSDialog uTSDialog2 = new uts.sdk.modules.DCloudUniPrompt.UTSDialog(topPageActivity2);
        utsDialog = uTSDialog2;
        uTSDialog2.initStyle(style);
        uts.sdk.modules.DCloudUniPrompt.UTSDialog uTSDialog3 = utsDialog;
        if (uTSDialog3 != null) {
            uTSDialog3.show();
        }
        io.dcloud.uts.UTSAndroid.INSTANCE.onAppActivityDestroy(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showModalImpl$lambda$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showModalImpl$lambda$3() {
        uts.sdk.modules.DCloudUniPrompt.UTSDialog uTSDialog = utsDialog;
        if (uTSDialog != null) {
            uTSDialog.dismiss();
        }
        utsDialog = null;
        return kotlin.Unit.INSTANCE;
    }

    public static final uts.sdk.modules.DCloudUniPrompt.UniActionSheet getUniActionSheet() {
        return uniActionSheet;
    }

    public static final void setUniActionSheet(uts.sdk.modules.DCloudUniPrompt.UniActionSheet uniActionSheet2) {
        uniActionSheet = uniActionSheet2;
    }

    public static final void actionSheetImpl(uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions style) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(style, "style");
        if (style.getItemList() == null || io.dcloud.uts.NumberKt.compareTo(style.getItemList().getLength(), (java.lang.Number) 1) < 0) {
            uts.sdk.modules.DCloudUniPrompt.PromptErrorImpl promptErrorImpl = new uts.sdk.modules.DCloudUniPrompt.PromptErrorImpl((java.lang.Number) 1001, "showActionSheet:fail parameter error: parameter.itemList should have at least 1 item");
            kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> fail = style.getFail();
            if (fail != null) {
                fail.invoke2(promptErrorImpl);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = style.getComplete();
            if (complete != null) {
                complete.invoke2(promptErrorImpl);
                return;
            }
            return;
        }
        if (style.getItemList().size() > 6) {
            uts.sdk.modules.DCloudUniPrompt.PromptErrorImpl promptErrorImpl2 = new uts.sdk.modules.DCloudUniPrompt.PromptErrorImpl((java.lang.Number) 1001, "showActionSheet:fail parameter error: itemList should not be large than 6");
            kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.IPromptError, kotlin.Unit> fail2 = style.getFail();
            if (fail2 != null) {
                fail2.invoke2(promptErrorImpl2);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete2 = style.getComplete();
            if (complete2 != null) {
                complete2.invoke2(promptErrorImpl2);
                return;
            }
            return;
        }
        uts.sdk.modules.DCloudUniPrompt.UniActionSheet uniActionSheet2 = uniActionSheet;
        if (uniActionSheet2 != null) {
            if (uniActionSheet2 != null) {
                uniActionSheet2.dismiss();
            }
            uniActionSheet = null;
        }
        if (io.dcloud.uts.UTSAndroid.INSTANCE.getTopPageActivity() == null) {
            return;
        }
        android.app.Activity topPageActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getTopPageActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNull(topPageActivity);
        if (topPageActivity.isFinishing()) {
            return;
        }
        android.app.Activity topPageActivity2 = io.dcloud.uts.UTSAndroid.INSTANCE.getTopPageActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNull(topPageActivity2);
        uts.sdk.modules.DCloudUniPrompt.UniActionSheet uniActionSheet3 = new uts.sdk.modules.DCloudUniPrompt.UniActionSheet(topPageActivity2, style);
        uniActionSheet = uniActionSheet3;
        uniActionSheet3.show();
        io.dcloud.uts.UTSAndroid.INSTANCE.onAppActivityDestroy(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.actionSheetImpl$lambda$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit actionSheetImpl$lambda$4() {
        uts.sdk.modules.DCloudUniPrompt.UniActionSheet uniActionSheet2 = uniActionSheet;
        if (uniActionSheet2 != null) {
            uniActionSheet2.dismiss();
        }
        uniActionSheet = null;
        return kotlin.Unit.INSTANCE;
    }

    public static final boolean isValidColor(java.lang.String str) {
        return str != null && str.length() == 7 && kotlin.text.StringsKt.startsWith$default(str, "#", false, 2, (java.lang.Object) null);
    }

    public static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowToastOptions, kotlin.Unit> getShowToast() {
        return showToast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showToast$lambda$6(final uts.sdk.modules.DCloudUniPrompt.ShowToastOptions showToastOptions) {
        io.dcloud.uts.UTSAndroid.INSTANCE.dispatchAsync("main", new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showToast$lambda$6$lambda$5(showToastOptions, obj);
            }
        }, null);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showToast$lambda$6$lambda$5(uts.sdk.modules.DCloudUniPrompt.ShowToastOptions showToastOptions, java.lang.Object obj) {
        showToastImpl(showToastOptions);
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function0<kotlin.Unit> getHideToast() {
        return hideToast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit hideToast$lambda$8() {
        io.dcloud.uts.UTSAndroid.INSTANCE.dispatchAsync("main", new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.hideToast$lambda$8$lambda$7(obj);
            }
        }, null);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit hideToast$lambda$8$lambda$7(java.lang.Object obj) {
        hideToastImpl();
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowLoadingOptions, kotlin.Unit> getShowLoading() {
        return showLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showLoading$lambda$10(final uts.sdk.modules.DCloudUniPrompt.ShowLoadingOptions showLoadingOptions) {
        io.dcloud.uts.UTSAndroid.INSTANCE.dispatchAsync("main", new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showLoading$lambda$10$lambda$9(showLoadingOptions, obj);
            }
        }, null);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showLoading$lambda$10$lambda$9(uts.sdk.modules.DCloudUniPrompt.ShowLoadingOptions showLoadingOptions, java.lang.Object obj) {
        showLoadingImpl(showLoadingOptions);
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function0<kotlin.Unit> getHideLoading() {
        return hideLoading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit hideLoading$lambda$12() {
        io.dcloud.uts.UTSAndroid.INSTANCE.dispatchAsync("main", new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.hideLoading$lambda$12$lambda$11(obj);
            }
        }, null);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit hideLoading$lambda$12$lambda$11(java.lang.Object obj) {
        hideLoadingImpl();
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowModalOptions, kotlin.Unit> getShowModal() {
        return showModal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showModal$lambda$14(final uts.sdk.modules.DCloudUniPrompt.ShowModalOptions showModalOptions) {
        io.dcloud.uts.UTSAndroid.INSTANCE.dispatchAsync("main", new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showModal$lambda$14$lambda$13(showModalOptions, obj);
            }
        }, null);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showModal$lambda$14$lambda$13(uts.sdk.modules.DCloudUniPrompt.ShowModalOptions showModalOptions, java.lang.Object obj) {
        showModalImpl(showModalOptions);
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions, kotlin.Unit> getShowActionSheet() {
        return showActionSheet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showActionSheet$lambda$16(final uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions showActionSheetOptions) {
        io.dcloud.uts.UTSAndroid.INSTANCE.dispatchAsync("main", new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showActionSheet$lambda$16$lambda$15(showActionSheetOptions, obj);
            }
        }, null);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showActionSheet$lambda$16$lambda$15(uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions showActionSheetOptions, java.lang.Object obj) {
        actionSheetImpl(showActionSheetOptions);
        return kotlin.Unit.INSTANCE;
    }

    public static final void showToastByJs(final uts.sdk.modules.DCloudUniPrompt.ShowToastOptionsJSONObject options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        showToast.invoke2(new uts.sdk.modules.DCloudUniPrompt.ShowToastOptions(options.getTitle(), options.getIcon(), options.getImage(), options.getMask(), options.getDuration(), options.getPosition(), new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showToastByJs$lambda$17(options, (uts.sdk.modules.DCloudUniPrompt.ShowToastSuccess) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showToastByJs$lambda$18(options, (uts.sdk.modules.DCloudUniPrompt.IPromptError) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showToastByJs$lambda$19(options, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showToastByJs$lambda$17(uts.sdk.modules.DCloudUniPrompt.ShowToastOptionsJSONObject showToastOptionsJSONObject, uts.sdk.modules.DCloudUniPrompt.ShowToastSuccess showToastSuccess) {
        io.dcloud.uts.UTSCallback success = showToastOptionsJSONObject.getSuccess();
        if (success != null) {
            success.invoke(showToastSuccess);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showToastByJs$lambda$18(uts.sdk.modules.DCloudUniPrompt.ShowToastOptionsJSONObject showToastOptionsJSONObject, uts.sdk.modules.DCloudUniPrompt.IPromptError iPromptError) {
        io.dcloud.uts.UTSCallback fail = showToastOptionsJSONObject.getFail();
        if (fail != null) {
            fail.invoke(iPromptError);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showToastByJs$lambda$19(uts.sdk.modules.DCloudUniPrompt.ShowToastOptionsJSONObject showToastOptionsJSONObject, java.lang.Object obj) {
        io.dcloud.uts.UTSCallback complete = showToastOptionsJSONObject.getComplete();
        if (complete != null) {
            complete.invoke(obj);
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final void hideToastByJs() {
        hideToast.invoke();
    }

    public static final void showLoadingByJs(final uts.sdk.modules.DCloudUniPrompt.ShowLoadingOptionsJSONObject options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        showLoading.invoke2(new uts.sdk.modules.DCloudUniPrompt.ShowLoadingOptions(options.getTitle(), options.getMask(), new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showLoadingByJs$lambda$20(options, (uts.sdk.modules.DCloudUniPrompt.ShowLoadingSuccess) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showLoadingByJs$lambda$21(options, (uts.sdk.modules.DCloudUniPrompt.IPromptError) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showLoadingByJs$lambda$22(options, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showLoadingByJs$lambda$20(uts.sdk.modules.DCloudUniPrompt.ShowLoadingOptionsJSONObject showLoadingOptionsJSONObject, uts.sdk.modules.DCloudUniPrompt.ShowLoadingSuccess showLoadingSuccess) {
        io.dcloud.uts.UTSCallback success = showLoadingOptionsJSONObject.getSuccess();
        if (success != null) {
            success.invoke(showLoadingSuccess);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showLoadingByJs$lambda$21(uts.sdk.modules.DCloudUniPrompt.ShowLoadingOptionsJSONObject showLoadingOptionsJSONObject, uts.sdk.modules.DCloudUniPrompt.IPromptError iPromptError) {
        io.dcloud.uts.UTSCallback fail = showLoadingOptionsJSONObject.getFail();
        if (fail != null) {
            fail.invoke(iPromptError);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showLoadingByJs$lambda$22(uts.sdk.modules.DCloudUniPrompt.ShowLoadingOptionsJSONObject showLoadingOptionsJSONObject, java.lang.Object obj) {
        io.dcloud.uts.UTSCallback complete = showLoadingOptionsJSONObject.getComplete();
        if (complete != null) {
            complete.invoke(obj);
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final void hideLoadingByJs() {
        hideLoading.invoke();
    }

    public static final void showModalByJs(final uts.sdk.modules.DCloudUniPrompt.ShowModalOptionsJSONObject options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        showModal.invoke2(new uts.sdk.modules.DCloudUniPrompt.ShowModalOptions(options.getTitle(), options.getContent(), options.getShowCancel(), options.getCancelText(), options.getCancelColor(), options.getConfirmText(), options.getConfirmColor(), options.getEditable(), options.getPlaceholderText(), new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showModalByJs$lambda$23(options, (uts.sdk.modules.DCloudUniPrompt.ShowModalSuccess) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showModalByJs$lambda$24(options, (uts.sdk.modules.DCloudUniPrompt.IPromptError) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showModalByJs$lambda$25(options, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showModalByJs$lambda$23(uts.sdk.modules.DCloudUniPrompt.ShowModalOptionsJSONObject showModalOptionsJSONObject, uts.sdk.modules.DCloudUniPrompt.ShowModalSuccess showModalSuccess) {
        io.dcloud.uts.UTSCallback success = showModalOptionsJSONObject.getSuccess();
        if (success != null) {
            success.invoke(showModalSuccess);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showModalByJs$lambda$24(uts.sdk.modules.DCloudUniPrompt.ShowModalOptionsJSONObject showModalOptionsJSONObject, uts.sdk.modules.DCloudUniPrompt.IPromptError iPromptError) {
        io.dcloud.uts.UTSCallback fail = showModalOptionsJSONObject.getFail();
        if (fail != null) {
            fail.invoke(iPromptError);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showModalByJs$lambda$25(uts.sdk.modules.DCloudUniPrompt.ShowModalOptionsJSONObject showModalOptionsJSONObject, java.lang.Object obj) {
        io.dcloud.uts.UTSCallback complete = showModalOptionsJSONObject.getComplete();
        if (complete != null) {
            complete.invoke(obj);
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final void showActionSheetByJs(final uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptionsJSONObject options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        showActionSheet.invoke2(new uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions(options.getTitle(), options.getAlertText(), options.getItemList(), options.getItemColor(), options.getPopover(), new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showActionSheetByJs$lambda$26(options, (uts.sdk.modules.DCloudUniPrompt.ShowActionSheetSuccess) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showActionSheetByJs$lambda$27(options, (uts.sdk.modules.DCloudUniPrompt.IPromptError) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniPrompt.IndexKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniPrompt.IndexKt.showActionSheetByJs$lambda$28(options, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showActionSheetByJs$lambda$26(uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptionsJSONObject showActionSheetOptionsJSONObject, uts.sdk.modules.DCloudUniPrompt.ShowActionSheetSuccess showActionSheetSuccess) {
        io.dcloud.uts.UTSCallback success = showActionSheetOptionsJSONObject.getSuccess();
        if (success != null) {
            success.invoke(showActionSheetSuccess);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showActionSheetByJs$lambda$27(uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptionsJSONObject showActionSheetOptionsJSONObject, uts.sdk.modules.DCloudUniPrompt.IPromptError iPromptError) {
        io.dcloud.uts.UTSCallback fail = showActionSheetOptionsJSONObject.getFail();
        if (fail != null) {
            fail.invoke(iPromptError);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit showActionSheetByJs$lambda$28(uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptionsJSONObject showActionSheetOptionsJSONObject, java.lang.Object obj) {
        io.dcloud.uts.UTSCallback complete = showActionSheetOptionsJSONObject.getComplete();
        if (complete != null) {
            complete.invoke(obj);
        }
        return kotlin.Unit.INSTANCE;
    }
}
