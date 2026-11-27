package androidx.activity;

/* JADX INFO: compiled from: ComponentActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 ¼\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u0011:\n»\u0001¼\u0001½\u0001¾\u0001¿\u0001B\u0011\b\u0017\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014B\u0005¢\u0006\u0002\u0010\u0015J\u001c\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010^2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010a\u001a\u00020\\2\u0006\u0010b\u001a\u00020cH\u0016J\u0018\u0010a\u001a\u00020\\2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0003H\u0016J \u0010a\u001a\u00020\\2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u00032\u0006\u0010e\u001a\u00020fH\u0017J\u0010\u0010g\u001a\u00020\\2\u0006\u0010h\u001a\u00020=H\u0003J\u0014\u0010i\u001a\u00020\\2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020E0DJ\u000e\u0010k\u001a\u00020\\2\u0006\u0010j\u001a\u00020lJ\u0014\u0010m\u001a\u00020\\2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020G0DJ\u0014\u0010n\u001a\u00020\\2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020I0DJ\u0014\u0010o\u001a\u00020\\2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020K0DJ\u0014\u0010p\u001a\u00020\\2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00130DJ\u000e\u0010q\u001a\u00020\\2\u0006\u0010j\u001a\u00020NJ\b\u0010r\u001a\u00020PH\u0002J\b\u0010s\u001a\u00020\\H\u0002J\b\u0010t\u001a\u00020\\H\u0017J\b\u0010u\u001a\u00020\\H\u0016J\"\u0010v\u001a\u00020\\2\u0006\u0010w\u001a\u00020\u00132\u0006\u0010x\u001a\u00020\u00132\b\u0010y\u001a\u0004\u0018\u00010IH\u0015J\b\u0010z\u001a\u00020\\H\u0017J\u0010\u0010{\u001a\u00020\\2\u0006\u0010|\u001a\u00020EH\u0017J\u0012\u0010}\u001a\u00020\\2\b\u0010~\u001a\u0004\u0018\u00010\u007fH\u0014J\u001c\u0010\u0080\u0001\u001a\u00020)2\u0007\u0010\u0081\u0001\u001a\u00020\u00132\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J\u001c\u0010\u0084\u0001\u001a\u00020)2\u0007\u0010\u0081\u0001\u001a\u00020\u00132\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016J\u0012\u0010\u0087\u0001\u001a\u00020\\2\u0007\u0010\u0088\u0001\u001a\u00020)H\u0017J\u001a\u0010\u0087\u0001\u001a\u00020\\2\u0007\u0010\u0088\u0001\u001a\u00020)2\u0006\u0010|\u001a\u00020EH\u0017J\u0012\u0010\u0089\u0001\u001a\u00020\\2\u0007\u0010\u008a\u0001\u001a\u00020IH\u0015J\u001c\u0010\u008b\u0001\u001a\u00020\\2\u0007\u0010\u0081\u0001\u001a\u00020\u00132\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J\u0012\u0010\u008c\u0001\u001a\u00020\\2\u0007\u0010\u008d\u0001\u001a\u00020)H\u0017J\u001a\u0010\u008c\u0001\u001a\u00020\\2\u0007\u0010\u008d\u0001\u001a\u00020)2\u0006\u0010|\u001a\u00020EH\u0017J&\u0010\u008e\u0001\u001a\u00020)2\u0007\u0010\u0081\u0001\u001a\u00020\u00132\b\u0010]\u001a\u0004\u0018\u00010^2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J2\u0010\u008f\u0001\u001a\u00020\\2\u0006\u0010w\u001a\u00020\u00132\u000f\u0010\u0090\u0001\u001a\n\u0012\u0005\u0012\u00030\u0092\u00010\u0091\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0017¢\u0006\u0003\u0010\u0095\u0001J\u000b\u0010\u0096\u0001\u001a\u0004\u0018\u000101H\u0017J\t\u0010\u0097\u0001\u001a\u0004\u0018\u000101J\u0012\u0010\u0098\u0001\u001a\u00020\\2\u0007\u0010\u0099\u0001\u001a\u00020\u007fH\u0015J\u0012\u0010\u009a\u0001\u001a\u00020\\2\u0007\u0010\u009b\u0001\u001a\u00020\u0013H\u0017J\t\u0010\u009c\u0001\u001a\u00020\\H\u0015J\f\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0016JF\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u0003H¡\u00010 \u0001\"\u0005\b\u0000\u0010¡\u0001\"\u0005\b\u0001\u0010¢\u00012\u0016\u0010£\u0001\u001a\u0011\u0012\u0005\u0012\u0003H¡\u0001\u0012\u0005\u0012\u0003H¢\u00010¤\u00012\u000f\u0010¥\u0001\u001a\n\u0012\u0005\u0012\u0003H¢\u00010¦\u0001JO\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u0003H¡\u00010 \u0001\"\u0005\b\u0000\u0010¡\u0001\"\u0005\b\u0001\u0010¢\u00012\u0016\u0010£\u0001\u001a\u0011\u0012\u0005\u0012\u0003H¡\u0001\u0012\u0005\u0012\u0003H¢\u00010¤\u00012\u0007\u0010§\u0001\u001a\u00020\u00192\u000f\u0010¥\u0001\u001a\n\u0012\u0005\u0012\u0003H¢\u00010¦\u0001J\u0011\u0010¨\u0001\u001a\u00020\\2\u0006\u0010b\u001a\u00020cH\u0016J\u0015\u0010©\u0001\u001a\u00020\\2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020E0DJ\u000f\u0010ª\u0001\u001a\u00020\\2\u0006\u0010j\u001a\u00020lJ\u0015\u0010«\u0001\u001a\u00020\\2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020G0DJ\u0015\u0010¬\u0001\u001a\u00020\\2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020I0DJ\u0015\u0010\u00ad\u0001\u001a\u00020\\2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020K0DJ\u0015\u0010®\u0001\u001a\u00020\\2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00130DJ\u000f\u0010¯\u0001\u001a\u00020\\2\u0006\u0010j\u001a\u00020NJ\t\u0010°\u0001\u001a\u00020\\H\u0016J\u0013\u0010±\u0001\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u001d\u0010±\u0001\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010^2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0014\u0010±\u0001\u001a\u00020\\2\t\b\u0001\u0010²\u0001\u001a\u00020\u0013H\u0016J\u001a\u0010³\u0001\u001a\u00020\\2\u0007\u0010\u008a\u0001\u001a\u00020I2\u0006\u0010w\u001a\u00020\u0013H\u0017J%\u0010³\u0001\u001a\u00020\\2\u0007\u0010\u008a\u0001\u001a\u00020I2\u0006\u0010w\u001a\u00020\u00132\t\u0010´\u0001\u001a\u0004\u0018\u00010\u007fH\u0017JA\u0010µ\u0001\u001a\u00020\\2\b\u0010\u008a\u0001\u001a\u00030¶\u00012\u0006\u0010w\u001a\u00020\u00132\t\u0010·\u0001\u001a\u0004\u0018\u00010I2\u0007\u0010¸\u0001\u001a\u00020\u00132\u0007\u0010¹\u0001\u001a\u00020\u00132\u0007\u0010º\u0001\u001a\u00020\u0013H\u0017JL\u0010µ\u0001\u001a\u00020\\2\b\u0010\u008a\u0001\u001a\u00030¶\u00012\u0006\u0010w\u001a\u00020\u00132\t\u0010·\u0001\u001a\u0004\u0018\u00010I2\u0007\u0010¸\u0001\u001a\u00020\u00132\u0007\u0010¹\u0001\u001a\u00020\u00132\u0007\u0010º\u0001\u001a\u00020\u00132\t\u0010´\u0001\u001a\u0004\u0018\u00010\u007fH\u0017R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u0012\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001f8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001b\u0010\"\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010'\u001a\u0004\b-\u0010.R\u0016\u00100\u001a\u0004\u0018\u0001018WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u0002058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010<\u001a\u00020=8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\bA\u0010'\u0012\u0004\b>\u0010\u0015\u001a\u0004\b?\u0010@R\u001a\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0D0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0D0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0D0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0D0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130D0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020N0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010Q\u001a\u00020R8F¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\bW\u0010\u0015R\u0014\u0010X\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010Z¨\u0006À\u0001"}, d2 = {"Landroidx/activity/ComponentActivity;", "Landroidx/core/app/ComponentActivity;", "Landroidx/activity/contextaware/ContextAware;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/HasDefaultViewModelProviderFactory;", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "Landroidx/activity/result/ActivityResultRegistryOwner;", "Landroidx/activity/result/ActivityResultCaller;", "Landroidx/core/content/OnConfigurationChangedProvider;", "Landroidx/core/content/OnTrimMemoryProvider;", "Landroidx/core/app/OnNewIntentProvider;", "Landroidx/core/app/OnMultiWindowModeChangedProvider;", "Landroidx/core/app/OnPictureInPictureModeChangedProvider;", "Landroidx/core/app/OnUserLeaveHintProvider;", "Landroidx/core/view/MenuHost;", "Landroidx/activity/FullyDrawnReporterOwner;", "contentLayoutId", "", "(I)V", "()V", "_viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "activityResultRegistry", "Landroidx/activity/result/ActivityResultRegistry;", "getActivityResultRegistry", "()Landroidx/activity/result/ActivityResultRegistry;", "contextAwareHelper", "Landroidx/activity/contextaware/ContextAwareHelper;", "defaultViewModelCreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "getDefaultViewModelCreationExtras", "()Landroidx/lifecycle/viewmodel/CreationExtras;", "defaultViewModelProviderFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getDefaultViewModelProviderFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "defaultViewModelProviderFactory$delegate", "Lkotlin/Lazy;", "dispatchingOnMultiWindowModeChanged", "", "dispatchingOnPictureInPictureModeChanged", "fullyDrawnReporter", "Landroidx/activity/FullyDrawnReporter;", "getFullyDrawnReporter", "()Landroidx/activity/FullyDrawnReporter;", "fullyDrawnReporter$delegate", "lastCustomNonConfigurationInstance", "", "getLastCustomNonConfigurationInstance", "()Ljava/lang/Object;", com.taobao.weex.ui.component.list.template.VirtualComponentLifecycle.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "menuHostHelper", "Landroidx/core/view/MenuHostHelper;", "nextLocalRequestCode", "Ljava/util/concurrent/atomic/AtomicInteger;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "getOnBackPressedDispatcher$annotations", "getOnBackPressedDispatcher", "()Landroidx/activity/OnBackPressedDispatcher;", "onBackPressedDispatcher$delegate", "onConfigurationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/core/util/Consumer;", "Landroid/content/res/Configuration;", "onMultiWindowModeChangedListeners", "Landroidx/core/app/MultiWindowModeChangedInfo;", "onNewIntentListeners", "Landroid/content/Intent;", "onPictureInPictureModeChangedListeners", "Landroidx/core/app/PictureInPictureModeChangedInfo;", "onTrimMemoryListeners", "onUserLeaveHintListeners", "Ljava/lang/Runnable;", "reportFullyDrawnExecutor", "Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutor;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistryController", "Landroidx/savedstate/SavedStateRegistryController;", "getSavedStateRegistryController$annotations", "viewModelStore", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "addContentView", "", com.taobao.weex.ui.component.WXBasicComponentType.VIEW, "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "addMenuProvider", "provider", "Landroidx/core/view/MenuProvider;", "owner", "state", "Landroidx/lifecycle/Lifecycle$State;", "addObserverForBackInvoker", "dispatcher", "addOnConfigurationChangedListener", "listener", "addOnContextAvailableListener", "Landroidx/activity/contextaware/OnContextAvailableListener;", "addOnMultiWindowModeChangedListener", "addOnNewIntentListener", "addOnPictureInPictureModeChangedListener", "addOnTrimMemoryListener", "addOnUserLeaveHintListener", "createFullyDrawnExecutor", "ensureViewModelStore", "initializeViewTreeOwners", "invalidateMenu", "onActivityResult", com.taobao.weex.common.WXModule.REQUEST_CODE, com.taobao.weex.common.WXModule.RESULT_CODE, "data", "onBackPressed", "onConfigurationChanged", "newConfig", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePanelMenu", "featureId", io.dcloud.common.constant.AbsoluteConst.EVENTS_MENU, "Landroid/view/Menu;", "onMenuItemSelected", io.dcloud.common.constant.AbsoluteConst.XML_ITEM, "Landroid/view/MenuItem;", "onMultiWindowModeChanged", "isInMultiWindowMode", "onNewIntent", "intent", "onPanelClosed", "onPictureInPictureModeChanged", "isInPictureInPictureMode", "onPreparePanel", "onRequestPermissionsResult", "permissions", "", "", com.taobao.weex.common.WXModule.GRANT_RESULTS, "", "(I[Ljava/lang/String;[I)V", "onRetainCustomNonConfigurationInstance", "onRetainNonConfigurationInstance", "onSaveInstanceState", "outState", "onTrimMemory", androidtranscoder.format.MediaFormatExtraConstants.KEY_LEVEL, "onUserLeaveHint", "peekAvailableContext", "Landroid/content/Context;", "registerForActivityResult", "Landroidx/activity/result/ActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "Landroidx/activity/result/ActivityResultCallback;", "registry", "removeMenuProvider", "removeOnConfigurationChangedListener", "removeOnContextAvailableListener", "removeOnMultiWindowModeChangedListener", "removeOnNewIntentListener", "removeOnPictureInPictureModeChangedListener", "removeOnTrimMemoryListener", "removeOnUserLeaveHintListener", "reportFullyDrawn", "setContentView", "layoutResID", "startActivityForResult", "options", "startIntentSenderForResult", "Landroid/content/IntentSender;", "fillInIntent", "flagsMask", "flagsValues", "extraFlags", "Api33Impl", "Companion", "NonConfigurationInstances", "ReportFullyDrawnExecutor", "ReportFullyDrawnExecutorImpl", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ComponentActivity extends androidx.core.app.ComponentActivity implements androidx.activity.contextaware.ContextAware, androidx.lifecycle.LifecycleOwner, androidx.lifecycle.ViewModelStoreOwner, androidx.lifecycle.HasDefaultViewModelProviderFactory, androidx.savedstate.SavedStateRegistryOwner, androidx.activity.OnBackPressedDispatcherOwner, androidx.activity.result.ActivityResultRegistryOwner, androidx.activity.result.ActivityResultCaller, androidx.core.content.OnConfigurationChangedProvider, androidx.core.content.OnTrimMemoryProvider, androidx.core.app.OnNewIntentProvider, androidx.core.app.OnMultiWindowModeChangedProvider, androidx.core.app.OnPictureInPictureModeChangedProvider, androidx.core.app.OnUserLeaveHintProvider, androidx.core.view.MenuHost, androidx.activity.FullyDrawnReporterOwner {
    private static final java.lang.String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private static final androidx.activity.ComponentActivity.Companion Companion = new androidx.activity.ComponentActivity.Companion(null);
    private androidx.lifecycle.ViewModelStore _viewModelStore;
    private final androidx.activity.result.ActivityResultRegistry activityResultRegistry;
    private int contentLayoutId;
    private final androidx.activity.contextaware.ContextAwareHelper contextAwareHelper;

    /* JADX INFO: renamed from: defaultViewModelProviderFactory$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy defaultViewModelProviderFactory;
    private boolean dispatchingOnMultiWindowModeChanged;
    private boolean dispatchingOnPictureInPictureModeChanged;

    /* JADX INFO: renamed from: fullyDrawnReporter$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy fullyDrawnReporter;
    private final androidx.core.view.MenuHostHelper menuHostHelper;
    private final java.util.concurrent.atomic.AtomicInteger nextLocalRequestCode;

    /* JADX INFO: renamed from: onBackPressedDispatcher$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy onBackPressedDispatcher;
    private final java.util.concurrent.CopyOnWriteArrayList<androidx.core.util.Consumer<android.content.res.Configuration>> onConfigurationChangedListeners;
    private final java.util.concurrent.CopyOnWriteArrayList<androidx.core.util.Consumer<androidx.core.app.MultiWindowModeChangedInfo>> onMultiWindowModeChangedListeners;
    private final java.util.concurrent.CopyOnWriteArrayList<androidx.core.util.Consumer<android.content.Intent>> onNewIntentListeners;
    private final java.util.concurrent.CopyOnWriteArrayList<androidx.core.util.Consumer<androidx.core.app.PictureInPictureModeChangedInfo>> onPictureInPictureModeChangedListeners;
    private final java.util.concurrent.CopyOnWriteArrayList<androidx.core.util.Consumer<java.lang.Integer>> onTrimMemoryListeners;
    private final java.util.concurrent.CopyOnWriteArrayList<java.lang.Runnable> onUserLeaveHintListeners;
    private final androidx.activity.ComponentActivity.ReportFullyDrawnExecutor reportFullyDrawnExecutor;
    private final androidx.savedstate.SavedStateRegistryController savedStateRegistryController;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ComponentActivity.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutor;", "Ljava/util/concurrent/Executor;", "activityDestroyed", "", "viewCreated", com.taobao.weex.ui.component.WXBasicComponentType.VIEW, "Landroid/view/View;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    interface ReportFullyDrawnExecutor extends java.util.concurrent.Executor {
        void activityDestroyed();

        void viewCreated(android.view.View view);
    }

    public static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    private static /* synthetic */ void getSavedStateRegistryController$annotations() {
    }

    @kotlin.Deprecated(message = "Use a {@link androidx.lifecycle.ViewModel} to store non config state.")
    public java.lang.Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public ComponentActivity() {
        this.contextAwareHelper = new androidx.activity.contextaware.ContextAwareHelper();
        this.menuHostHelper = new androidx.core.view.MenuHostHelper(new java.lang.Runnable() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                androidx.activity.ComponentActivity.menuHostHelper$lambda$0(this.f$0);
            }
        });
        androidx.activity.ComponentActivity componentActivity = this;
        androidx.savedstate.SavedStateRegistryController savedStateRegistryControllerCreate = androidx.savedstate.SavedStateRegistryController.INSTANCE.create(componentActivity);
        this.savedStateRegistryController = savedStateRegistryControllerCreate;
        this.reportFullyDrawnExecutor = createFullyDrawnExecutor();
        this.fullyDrawnReporter = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0<androidx.activity.FullyDrawnReporter>() { // from class: androidx.activity.ComponentActivity$fullyDrawnReporter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final androidx.activity.FullyDrawnReporter invoke() {
                androidx.activity.ComponentActivity.ReportFullyDrawnExecutor reportFullyDrawnExecutor = this.this$0.reportFullyDrawnExecutor;
                final androidx.activity.ComponentActivity componentActivity2 = this.this$0;
                return new androidx.activity.FullyDrawnReporter(reportFullyDrawnExecutor, new kotlin.jvm.functions.Function0<kotlin.Unit>() { // from class: androidx.activity.ComponentActivity$fullyDrawnReporter$2.1
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
                        componentActivity2.reportFullyDrawn();
                    }
                });
            }
        });
        this.nextLocalRequestCode = new java.util.concurrent.atomic.AtomicInteger();
        this.activityResultRegistry = new androidx.activity.ComponentActivity$activityResultRegistry$1(this);
        this.onConfigurationChangedListeners = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.onTrimMemoryListeners = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.onNewIntentListeners = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.onMultiWindowModeChangedListeners = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.onPictureInPictureModeChangedListeners = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.onUserLeaveHintListeners = new java.util.concurrent.CopyOnWriteArrayList<>();
        if (getLifecycle() == null) {
            throw new java.lang.IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.".toString());
        }
        getLifecycle().addObserver(new androidx.lifecycle.LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
                androidx.activity.ComponentActivity._init_$lambda$2(this.f$0, lifecycleOwner, event);
            }
        });
        getLifecycle().addObserver(new androidx.lifecycle.LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
                androidx.activity.ComponentActivity._init_$lambda$3(this.f$0, lifecycleOwner, event);
            }
        });
        getLifecycle().addObserver(new androidx.lifecycle.LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(androidx.lifecycle.LifecycleOwner source, androidx.lifecycle.Lifecycle.Event event) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
                androidx.activity.ComponentActivity.this.ensureViewModelStore();
                androidx.activity.ComponentActivity.this.getLifecycle().removeObserver(this);
            }
        });
        savedStateRegistryControllerCreate.performAttach();
        androidx.lifecycle.SavedStateHandleSupport.enableSavedStateHandles(componentActivity);
        if (android.os.Build.VERSION.SDK_INT <= 23) {
            getLifecycle().addObserver(new androidx.activity.ImmLeaksCleaner(this));
        }
        getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, new androidx.savedstate.SavedStateRegistry.SavedStateProvider() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda3
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final android.os.Bundle saveState() {
                return androidx.activity.ComponentActivity._init_$lambda$4(this.f$0);
            }
        });
        addOnContextAvailableListener(new androidx.activity.contextaware.OnContextAvailableListener() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda4
            @Override // androidx.activity.contextaware.OnContextAvailableListener
            public final void onContextAvailable(android.content.Context context) {
                androidx.activity.ComponentActivity._init_$lambda$5(this.f$0, context);
            }
        });
        this.defaultViewModelProviderFactory = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0<androidx.lifecycle.SavedStateViewModelFactory>() { // from class: androidx.activity.ComponentActivity$defaultViewModelProviderFactory$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final androidx.lifecycle.SavedStateViewModelFactory invoke() {
                android.app.Application application = this.this$0.getApplication();
                androidx.activity.ComponentActivity componentActivity2 = this.this$0;
                return new androidx.lifecycle.SavedStateViewModelFactory(application, componentActivity2, componentActivity2.getIntent() != null ? this.this$0.getIntent().getExtras() : null);
            }
        });
        this.onBackPressedDispatcher = kotlin.LazyKt.lazy(new androidx.activity.ComponentActivity$onBackPressedDispatcher$2(this));
    }

    /* JADX INFO: compiled from: ComponentActivity.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/activity/ComponentActivity$NonConfigurationInstances;", "", "()V", "custom", "getCustom", "()Ljava/lang/Object;", "setCustom", "(Ljava/lang/Object;)V", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "setViewModelStore", "(Landroidx/lifecycle/ViewModelStore;)V", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NonConfigurationInstances {
        private java.lang.Object custom;
        private androidx.lifecycle.ViewModelStore viewModelStore;

        public final java.lang.Object getCustom() {
            return this.custom;
        }

        public final void setCustom(java.lang.Object obj) {
            this.custom = obj;
        }

        public final androidx.lifecycle.ViewModelStore getViewModelStore() {
            return this.viewModelStore;
        }

        public final void setViewModelStore(androidx.lifecycle.ViewModelStore viewModelStore) {
            this.viewModelStore = viewModelStore;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void menuHostHelper$lambda$0(androidx.activity.ComponentActivity this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.invalidateMenu();
    }

    @Override // androidx.activity.FullyDrawnReporterOwner
    public androidx.activity.FullyDrawnReporter getFullyDrawnReporter() {
        return (androidx.activity.FullyDrawnReporter) this.fullyDrawnReporter.getValue();
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    public final androidx.activity.result.ActivityResultRegistry getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(androidx.activity.ComponentActivity this$0, androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
        android.view.Window window;
        android.view.View viewPeekDecorView;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        if (event != androidx.lifecycle.Lifecycle.Event.ON_STOP || (window = this$0.getWindow()) == null || (viewPeekDecorView = window.peekDecorView()) == null) {
            return;
        }
        viewPeekDecorView.cancelPendingInputEvents();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(androidx.activity.ComponentActivity this$0, androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        if (event == androidx.lifecycle.Lifecycle.Event.ON_DESTROY) {
            this$0.contextAwareHelper.clearAvailableContext();
            if (!this$0.isChangingConfigurations()) {
                this$0.getViewModelStore().clear();
            }
            this$0.reportFullyDrawnExecutor.activityDestroyed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final android.os.Bundle _init_$lambda$4(androidx.activity.ComponentActivity this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        android.os.Bundle bundle = new android.os.Bundle();
        this$0.activityResultRegistry.onSaveInstanceState(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(androidx.activity.ComponentActivity this$0, android.content.Context it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        android.os.Bundle bundleConsumeRestoredStateForKey = this$0.getSavedStateRegistry().consumeRestoredStateForKey(ACTIVITY_RESULT_TAG);
        if (bundleConsumeRestoredStateForKey != null) {
            this$0.activityResultRegistry.onRestoreInstanceState(bundleConsumeRestoredStateForKey);
        }
    }

    public ComponentActivity(int i) {
        this();
        this.contentLayoutId = i;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(android.os.Bundle savedInstanceState) {
        this.savedStateRegistryController.performRestore(savedInstanceState);
        this.contextAwareHelper.dispatchOnContextAvailable(this);
        super.onCreate(savedInstanceState);
        androidx.lifecycle.ReportFragment.INSTANCE.injectIfNeededIn(this);
        int i = this.contentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(android.os.Bundle outState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outState, "outState");
        if (getLifecycle() instanceof androidx.lifecycle.LifecycleRegistry) {
            androidx.lifecycle.Lifecycle lifecycle = getLifecycle();
            kotlin.jvm.internal.Intrinsics.checkNotNull(lifecycle, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            ((androidx.lifecycle.LifecycleRegistry) lifecycle).setCurrentState(androidx.lifecycle.Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(outState);
        this.savedStateRegistryController.performSave(outState);
    }

    @Override // android.app.Activity
    public final java.lang.Object onRetainNonConfigurationInstance() {
        androidx.activity.ComponentActivity.NonConfigurationInstances nonConfigurationInstances;
        java.lang.Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        androidx.lifecycle.ViewModelStore viewModelStore = this._viewModelStore;
        if (viewModelStore == null && (nonConfigurationInstances = (androidx.activity.ComponentActivity.NonConfigurationInstances) getLastNonConfigurationInstance()) != null) {
            viewModelStore = nonConfigurationInstances.getViewModelStore();
        }
        if (viewModelStore == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        androidx.activity.ComponentActivity.NonConfigurationInstances nonConfigurationInstances2 = new androidx.activity.ComponentActivity.NonConfigurationInstances();
        nonConfigurationInstances2.setCustom(objOnRetainCustomNonConfigurationInstance);
        nonConfigurationInstances2.setViewModelStore(viewModelStore);
        return nonConfigurationInstances2;
    }

    @kotlin.Deprecated(message = "Use a {@link androidx.lifecycle.ViewModel} to store non config state.")
    public java.lang.Object getLastCustomNonConfigurationInstance() {
        androidx.activity.ComponentActivity.NonConfigurationInstances nonConfigurationInstances = (androidx.activity.ComponentActivity.NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.getCustom();
        }
        return null;
    }

    @Override // android.app.Activity
    public void setContentView(int layoutResID) {
        initializeViewTreeOwners();
        androidx.activity.ComponentActivity.ReportFullyDrawnExecutor reportFullyDrawnExecutor = this.reportFullyDrawnExecutor;
        android.view.View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        reportFullyDrawnExecutor.viewCreated(decorView);
        super.setContentView(layoutResID);
    }

    @Override // android.app.Activity
    public void setContentView(android.view.View view) {
        initializeViewTreeOwners();
        androidx.activity.ComponentActivity.ReportFullyDrawnExecutor reportFullyDrawnExecutor = this.reportFullyDrawnExecutor;
        android.view.View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        reportFullyDrawnExecutor.viewCreated(decorView);
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams params) {
        initializeViewTreeOwners();
        androidx.activity.ComponentActivity.ReportFullyDrawnExecutor reportFullyDrawnExecutor = this.reportFullyDrawnExecutor;
        android.view.View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        reportFullyDrawnExecutor.viewCreated(decorView);
        super.setContentView(view, params);
    }

    @Override // android.app.Activity
    public void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams params) {
        initializeViewTreeOwners();
        androidx.activity.ComponentActivity.ReportFullyDrawnExecutor reportFullyDrawnExecutor = this.reportFullyDrawnExecutor;
        android.view.View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        reportFullyDrawnExecutor.viewCreated(decorView);
        super.addContentView(view, params);
    }

    public void initializeViewTreeOwners() {
        android.view.View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        androidx.lifecycle.ViewTreeLifecycleOwner.set(decorView, this);
        android.view.View decorView2 = getWindow().getDecorView();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(decorView2, "window.decorView");
        androidx.lifecycle.ViewTreeViewModelStoreOwner.set(decorView2, this);
        android.view.View decorView3 = getWindow().getDecorView();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(decorView3, "window.decorView");
        androidx.savedstate.ViewTreeSavedStateRegistryOwner.set(decorView3, this);
        android.view.View decorView4 = getWindow().getDecorView();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(decorView4, "window.decorView");
        androidx.activity.ViewTreeOnBackPressedDispatcherOwner.set(decorView4, this);
        android.view.View decorView5 = getWindow().getDecorView();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(decorView5, "window.decorView");
        androidx.activity.ViewTreeFullyDrawnReporterOwner.set(decorView5, this);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public android.content.Context peekAvailableContext() {
        return this.contextAwareHelper.getContext();
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void addOnContextAvailableListener(androidx.activity.contextaware.OnContextAvailableListener listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.contextAwareHelper.addOnContextAvailableListener(listener);
    }

    @Override // androidx.activity.contextaware.ContextAware
    public final void removeOnContextAvailableListener(androidx.activity.contextaware.OnContextAvailableListener listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.contextAwareHelper.removeOnContextAvailableListener(listener);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int featureId, android.view.View view, android.view.Menu menu) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(menu, "menu");
        if (featureId != 0) {
            return true;
        }
        super.onPreparePanel(featureId, view, menu);
        this.menuHostHelper.onPrepareMenu(menu);
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int featureId, android.view.Menu menu) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(menu, "menu");
        if (featureId != 0) {
            return true;
        }
        super.onCreatePanelMenu(featureId, menu);
        this.menuHostHelper.onCreateMenu(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int featureId, android.view.MenuItem item) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(item, "item");
        if (super.onMenuItemSelected(featureId, item)) {
            return true;
        }
        if (featureId == 0) {
            return this.menuHostHelper.onMenuItemSelected(item);
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int featureId, android.view.Menu menu) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(menu, "menu");
        this.menuHostHelper.onMenuClosed(menu);
        super.onPanelClosed(featureId, menu);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(androidx.core.view.MenuProvider provider) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(provider, "provider");
        this.menuHostHelper.addMenuProvider(provider);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(androidx.core.view.MenuProvider provider, androidx.lifecycle.LifecycleOwner owner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(provider, "provider");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(owner, "owner");
        this.menuHostHelper.addMenuProvider(provider, owner);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(androidx.core.view.MenuProvider provider, androidx.lifecycle.LifecycleOwner owner, androidx.lifecycle.Lifecycle.State state) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(provider, "provider");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(owner, "owner");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(state, "state");
        this.menuHostHelper.addMenuProvider(provider, owner, state);
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(androidx.core.view.MenuProvider provider) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(provider, "provider");
        this.menuHostHelper.removeMenuProvider(provider);
    }

    @Override // androidx.core.view.MenuHost
    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public androidx.lifecycle.Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public androidx.lifecycle.ViewModelStore getViewModelStore() {
        if (getApplication() == null) {
            throw new java.lang.IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.".toString());
        }
        ensureViewModelStore();
        androidx.lifecycle.ViewModelStore viewModelStore = this._viewModelStore;
        kotlin.jvm.internal.Intrinsics.checkNotNull(viewModelStore);
        return viewModelStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureViewModelStore() {
        if (this._viewModelStore == null) {
            androidx.activity.ComponentActivity.NonConfigurationInstances nonConfigurationInstances = (androidx.activity.ComponentActivity.NonConfigurationInstances) getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                this._viewModelStore = nonConfigurationInstances.getViewModelStore();
            }
            if (this._viewModelStore == null) {
                this._viewModelStore = new androidx.lifecycle.ViewModelStore();
            }
        }
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public androidx.lifecycle.ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return (androidx.lifecycle.ViewModelProvider.Factory) this.defaultViewModelProviderFactory.getValue();
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public androidx.lifecycle.viewmodel.CreationExtras getDefaultViewModelCreationExtras() {
        androidx.lifecycle.viewmodel.MutableCreationExtras mutableCreationExtras = new androidx.lifecycle.viewmodel.MutableCreationExtras(null, 1, null);
        if (getApplication() != null) {
            androidx.lifecycle.viewmodel.CreationExtras.Key<android.app.Application> key = androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY;
            android.app.Application application = getApplication();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(application, "application");
            mutableCreationExtras.set(key, application);
        }
        mutableCreationExtras.set(androidx.lifecycle.SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        mutableCreationExtras.set(androidx.lifecycle.SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        android.content.Intent intent = getIntent();
        android.os.Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            mutableCreationExtras.set(androidx.lifecycle.SavedStateHandleSupport.DEFAULT_ARGS_KEY, extras);
        }
        return mutableCreationExtras;
    }

    @Override // android.app.Activity
    @kotlin.Deprecated(message = "This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.")
    public void onBackPressed() {
        getOnBackPressedDispatcher().onBackPressed();
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final androidx.activity.OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return (androidx.activity.OnBackPressedDispatcher) this.onBackPressedDispatcher.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addObserverForBackInvoker(final androidx.activity.OnBackPressedDispatcher dispatcher) {
        getLifecycle().addObserver(new androidx.lifecycle.LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
                androidx.activity.ComponentActivity.addObserverForBackInvoker$lambda$7(dispatcher, this, lifecycleOwner, event);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addObserverForBackInvoker$lambda$7(androidx.activity.OnBackPressedDispatcher dispatcher, androidx.activity.ComponentActivity this$0, androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dispatcher, "$dispatcher");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        if (event == androidx.lifecycle.Lifecycle.Event.ON_CREATE) {
            dispatcher.setOnBackInvokedDispatcher(androidx.activity.ComponentActivity.Api33Impl.INSTANCE.getOnBackInvokedDispatcher(this$0));
        }
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final androidx.savedstate.SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    @Override // android.app.Activity
    @kotlin.Deprecated(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartActivityForResult} object for the {@link ActivityResultContract}.")
    public void startActivityForResult(android.content.Intent intent, int requestCode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intent, "intent");
        super.startActivityForResult(intent, requestCode);
    }

    @Override // android.app.Activity
    @kotlin.Deprecated(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartActivityForResult} object for the {@link ActivityResultContract}.")
    public void startActivityForResult(android.content.Intent intent, int requestCode, android.os.Bundle options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intent, "intent");
        super.startActivityForResult(intent, requestCode, options);
    }

    @Override // android.app.Activity
    @kotlin.Deprecated(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartIntentSenderForResult} object for the\n      {@link ActivityResultContract}.")
    public void startIntentSenderForResult(android.content.IntentSender intent, int requestCode, android.content.Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws android.content.IntentSender.SendIntentException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intent, "intent");
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override // android.app.Activity
    @kotlin.Deprecated(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartIntentSenderForResult} object for the\n      {@link ActivityResultContract}.")
    public void startIntentSenderForResult(android.content.IntentSender intent, int requestCode, android.content.Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, android.os.Bundle options) throws android.content.IntentSender.SendIntentException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intent, "intent");
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override // android.app.Activity
    @kotlin.Deprecated(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    protected void onActivityResult(int requestCode, int resultCode, android.content.Intent data) {
        if (this.activityResultRegistry.dispatchResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.app.Activity
    @kotlin.Deprecated(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)} passing\n      in a {@link RequestMultiplePermissions} object for the {@link ActivityResultContract} and\n      handling the result in the {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    public void onRequestPermissionsResult(int requestCode, java.lang.String[] permissions, int[] grantResults) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(permissions, "permissions");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (this.activityResultRegistry.dispatchResult(requestCode, -1, new android.content.Intent().putExtra(androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS, permissions).putExtra(androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS, grantResults)) || android.os.Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> androidx.activity.result.ActivityResultLauncher<I> registerForActivityResult(androidx.activity.result.contract.ActivityResultContract<I, O> contract, androidx.activity.result.ActivityResultRegistry registry, androidx.activity.result.ActivityResultCallback<O> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contract, "contract");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(registry, "registry");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        return registry.register("activity_rq#" + this.nextLocalRequestCode.getAndIncrement(), this, contract, callback);
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> androidx.activity.result.ActivityResultLauncher<I> registerForActivityResult(androidx.activity.result.contract.ActivityResultContract<I, O> contract, androidx.activity.result.ActivityResultCallback<O> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contract, "contract");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        return registerForActivityResult(contract, this.activityResultRegistry, callback);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        java.util.Iterator<androidx.core.util.Consumer<android.content.res.Configuration>> it = this.onConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(newConfig);
        }
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(androidx.core.util.Consumer<android.content.res.Configuration> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.onConfigurationChangedListeners.add(listener);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(androidx.core.util.Consumer<android.content.res.Configuration> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.onConfigurationChangedListeners.remove(listener);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        java.util.Iterator<androidx.core.util.Consumer<java.lang.Integer>> it = this.onTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(java.lang.Integer.valueOf(level));
        }
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(androidx.core.util.Consumer<java.lang.Integer> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.onTrimMemoryListeners.add(listener);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(androidx.core.util.Consumer<java.lang.Integer> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.onTrimMemoryListeners.remove(listener);
    }

    @Override // android.app.Activity
    protected void onNewIntent(android.content.Intent intent) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        java.util.Iterator<androidx.core.util.Consumer<android.content.Intent>> it = this.onNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void addOnNewIntentListener(androidx.core.util.Consumer<android.content.Intent> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.onNewIntentListeners.add(listener);
    }

    @Override // androidx.core.app.OnNewIntentProvider
    public final void removeOnNewIntentListener(androidx.core.util.Consumer<android.content.Intent> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.onNewIntentListeners.remove(listener);
    }

    @Override // android.app.Activity
    @kotlin.Deprecated(message = "Deprecated in android.app.Activity")
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        if (this.dispatchingOnMultiWindowModeChanged) {
            return;
        }
        java.util.Iterator<androidx.core.util.Consumer<androidx.core.app.MultiWindowModeChangedInfo>> it = this.onMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.MultiWindowModeChangedInfo(isInMultiWindowMode));
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, android.content.res.Configuration newConfig) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
            this.dispatchingOnMultiWindowModeChanged = false;
            java.util.Iterator<androidx.core.util.Consumer<androidx.core.app.MultiWindowModeChangedInfo>> it = this.onMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new androidx.core.app.MultiWindowModeChangedInfo(isInMultiWindowMode, newConfig));
            }
        } catch (java.lang.Throwable th) {
            this.dispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void addOnMultiWindowModeChangedListener(androidx.core.util.Consumer<androidx.core.app.MultiWindowModeChangedInfo> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.onMultiWindowModeChangedListeners.add(listener);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void removeOnMultiWindowModeChangedListener(androidx.core.util.Consumer<androidx.core.app.MultiWindowModeChangedInfo> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.onMultiWindowModeChangedListeners.remove(listener);
    }

    @Override // android.app.Activity
    @kotlin.Deprecated(message = "Deprecated in android.app.Activity")
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        if (this.dispatchingOnPictureInPictureModeChanged) {
            return;
        }
        java.util.Iterator<androidx.core.util.Consumer<androidx.core.app.PictureInPictureModeChangedInfo>> it = this.onPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.PictureInPictureModeChangedInfo(isInPictureInPictureMode));
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, android.content.res.Configuration newConfig) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
            this.dispatchingOnPictureInPictureModeChanged = false;
            java.util.Iterator<androidx.core.util.Consumer<androidx.core.app.PictureInPictureModeChangedInfo>> it = this.onPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new androidx.core.app.PictureInPictureModeChangedInfo(isInPictureInPictureMode, newConfig));
            }
        } catch (java.lang.Throwable th) {
            this.dispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void addOnPictureInPictureModeChangedListener(androidx.core.util.Consumer<androidx.core.app.PictureInPictureModeChangedInfo> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.onPictureInPictureModeChangedListeners.add(listener);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void removeOnPictureInPictureModeChangedListener(androidx.core.util.Consumer<androidx.core.app.PictureInPictureModeChangedInfo> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.onPictureInPictureModeChangedListeners.remove(listener);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        java.util.Iterator<java.lang.Runnable> it = this.onUserLeaveHintListeners.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
    }

    @Override // androidx.core.app.OnUserLeaveHintProvider
    public final void addOnUserLeaveHintListener(java.lang.Runnable listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.onUserLeaveHintListeners.add(listener);
    }

    @Override // androidx.core.app.OnUserLeaveHintProvider
    public final void removeOnUserLeaveHintListener(java.lang.Runnable listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        this.onUserLeaveHintListeners.remove(listener);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (androidx.tracing.Trace.isEnabled()) {
                androidx.tracing.Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            getFullyDrawnReporter().fullyDrawnReported();
        } finally {
            androidx.tracing.Trace.endSection();
        }
    }

    private final androidx.activity.ComponentActivity.ReportFullyDrawnExecutor createFullyDrawnExecutor() {
        return new androidx.activity.ComponentActivity.ReportFullyDrawnExecutorImpl();
    }

    /* JADX INFO: compiled from: ComponentActivity.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/activity/ComponentActivity$Api33Impl;", "", "()V", "getOnBackInvokedDispatcher", "Landroid/window/OnBackInvokedDispatcher;", "activity", "Landroid/app/Activity;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Api33Impl {
        public static final androidx.activity.ComponentActivity.Api33Impl INSTANCE = new androidx.activity.ComponentActivity.Api33Impl();

        private Api33Impl() {
        }

        public final android.window.OnBackInvokedDispatcher getOnBackInvokedDispatcher(android.app.Activity activity) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
            android.window.OnBackInvokedDispatcher onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(onBackInvokedDispatcher, "activity.getOnBackInvokedDispatcher()");
            return onBackInvokedDispatcher;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ComponentActivity.kt */
    @kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutorImpl;", "Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutor;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "Ljava/lang/Runnable;", "(Landroidx/activity/ComponentActivity;)V", "currentRunnable", "getCurrentRunnable", "()Ljava/lang/Runnable;", "setCurrentRunnable", "(Ljava/lang/Runnable;)V", "endWatchTimeMillis", "", "getEndWatchTimeMillis", "()J", "onDrawScheduled", "", "getOnDrawScheduled", "()Z", "setOnDrawScheduled", "(Z)V", "activityDestroyed", "", "execute", "runnable", "onDraw", "run", "viewCreated", com.taobao.weex.ui.component.WXBasicComponentType.VIEW, "Landroid/view/View;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    final class ReportFullyDrawnExecutorImpl implements androidx.activity.ComponentActivity.ReportFullyDrawnExecutor, android.view.ViewTreeObserver.OnDrawListener, java.lang.Runnable {
        private java.lang.Runnable currentRunnable;
        private final long endWatchTimeMillis = android.os.SystemClock.uptimeMillis() + ((long) io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH);
        private boolean onDrawScheduled;

        public ReportFullyDrawnExecutorImpl() {
        }

        public final long getEndWatchTimeMillis() {
            return this.endWatchTimeMillis;
        }

        public final java.lang.Runnable getCurrentRunnable() {
            return this.currentRunnable;
        }

        public final void setCurrentRunnable(java.lang.Runnable runnable) {
            this.currentRunnable = runnable;
        }

        public final boolean getOnDrawScheduled() {
            return this.onDrawScheduled;
        }

        public final void setOnDrawScheduled(boolean z) {
            this.onDrawScheduled = z;
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void viewCreated(android.view.View view) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
            if (this.onDrawScheduled) {
                return;
            }
            this.onDrawScheduled = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public void activityDestroyed() {
            androidx.activity.ComponentActivity.this.getWindow().getDecorView().removeCallbacks(this);
            androidx.activity.ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.currentRunnable = runnable;
            android.view.View decorView = androidx.activity.ComponentActivity.this.getWindow().getDecorView();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            if (this.onDrawScheduled) {
                if (kotlin.jvm.internal.Intrinsics.areEqual(android.os.Looper.myLooper(), android.os.Looper.getMainLooper())) {
                    decorView.invalidate();
                    return;
                } else {
                    decorView.postInvalidate();
                    return;
                }
            }
            decorView.postOnAnimation(new java.lang.Runnable() { // from class: androidx.activity.ComponentActivity$ReportFullyDrawnExecutorImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    androidx.activity.ComponentActivity.ReportFullyDrawnExecutorImpl.execute$lambda$0(this.f$0);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void execute$lambda$0(androidx.activity.ComponentActivity.ReportFullyDrawnExecutorImpl this$0) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            java.lang.Runnable runnable = this$0.currentRunnable;
            if (runnable != null) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(runnable);
                runnable.run();
                this$0.currentRunnable = null;
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            java.lang.Runnable runnable = this.currentRunnable;
            if (runnable == null) {
                if (android.os.SystemClock.uptimeMillis() > this.endWatchTimeMillis) {
                    this.onDrawScheduled = false;
                    androidx.activity.ComponentActivity.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.currentRunnable = null;
            if (androidx.activity.ComponentActivity.this.getFullyDrawnReporter().isFullyDrawnReported()) {
                this.onDrawScheduled = false;
                androidx.activity.ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.activity.ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    /* JADX INFO: compiled from: ComponentActivity.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/activity/ComponentActivity$Companion;", "", "()V", "ACTIVITY_RESULT_TAG", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
