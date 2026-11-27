package com.taobao.weex;

/* JADX INFO: loaded from: classes.dex */
public class WXSDKInstance implements io.dcloud.feature.uniapp.AbsSDKInstance {
    public static java.lang.String ACTION_DEBUG_INSTANCE_REFRESH = "DEBUG_INSTANCE_REFRESH";
    public static java.lang.String ACTION_INSTANCE_RELOAD = "INSTANCE_RELOAD";
    public static final java.lang.String BUNDLE_URL = "bundleUrl";
    private static final java.lang.String SOURCE_TEMPLATE_BASE64_MD5 = "templateSourceBase64MD5";
    public static java.lang.String requestUrl = "requestUrl";
    static int sScreenHeight = -1;
    public com.taobao.weex.bridge.WXBridgeManager.BundType bundleType;
    private java.util.List<com.alibaba.fastjson.JSONObject> componentsInfoExceedGPULimit;
    private boolean createInstanceHeartBeat;
    private boolean enableFullScreenHeight;
    private boolean enableLayerType;
    java.util.List<com.taobao.weex.WXSDKInstance.FrameViewEventListener> frameViewEventListeners;
    private boolean hasException;
    public java.util.PriorityQueue<com.taobao.weex.ui.component.WXEmbed> hiddenEmbeds;
    private java.util.Map<java.lang.String, com.taobao.weex.ui.action.GraphicActionAddElement> inactiveAddElementAction;
    private boolean isCommit;
    private boolean isDestroy;
    private boolean isFrameShow;
    private boolean isImmersive;
    public boolean isNewFsEnd;
    private boolean isOnSizeChangedRender;
    private boolean isPreDownLoad;
    private boolean isPreInit;
    private volatile boolean isPreRenderMode;
    private boolean isRenderSuccess;
    private boolean isViewDisAppear;
    private com.taobao.weex.performance.WXInstanceApm mApmForInstance;
    private boolean mAutoAdjustDeviceWidth;
    private java.lang.String mBundleUrl;
    private com.taobao.weex.ComponentObserver mComponentObserver;
    private java.util.Map<java.lang.String, java.lang.String> mContainerInfo;
    private java.util.Map<java.lang.Long, com.taobao.weex.layout.ContentBoxMeasurement> mContentBoxMeasurements;
    protected android.content.Context mContext;
    private boolean mCreateInstance;
    private boolean mCurrentGround;
    private com.taobao.weex.WXSDKInstance.CustomFontNetworkHandler mCustomFontNetworkHandler;
    private int mDefaultFontSize;
    private boolean mDisableSkipFrameworkInit;
    public boolean mEnd;
    public int mExecJSTraceId;
    private com.taobao.weex.ui.flat.FlatGUIContext mFlatGUIContext;
    private com.taobao.weex.WXGlobalEventReceiver mGlobalEventReceiver;
    private java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> mGlobalEvents;
    public boolean mHasCreateFinish;
    private com.taobao.weex.WXHttpListener mHttpListener;
    private com.taobao.weex.WXSDKInstance.ImageNetworkHandler mImageNetworkHandler;
    private final java.lang.String mInstanceId;
    private java.util.List<com.taobao.weex.instance.InstanceOnFireEventInterceptor> mInstanceOnFireEventInterceptorList;
    private float mInstanceViewPortWidth;
    private com.taobao.weex.common.WXRefreshData mLastRefreshData;
    private java.util.List<java.lang.String> mLayerOverFlowListeners;
    private int mMaxDeepLayer;
    private com.taobao.weex.bridge.NativeInvokeHelper mNativeInvokeHelper;
    private boolean mNeedReLoad;
    private boolean mNeedValidate;
    private com.taobao.weex.WXSDKInstance.NestedInstanceInterceptor mNestedInstanceInterceptor;
    com.taobao.weex.IWXInstanceContainerOnSizeListener mOnSizeListener;
    private android.content.Context mOriginalContext;
    private com.taobao.weex.WXSDKInstance mParentInstance;
    private long mRefreshStartTime;
    private com.taobao.weex.render.WXAbstractRenderContainer mRenderContainer;
    private com.taobao.weex.IWXRenderListener mRenderListener;
    public long mRenderStartNanos;
    public long mRenderStartTime;
    private com.taobao.weex.common.WXRenderStrategy mRenderStrategy;
    private java.lang.String mRenderType;
    private boolean mRendered;
    private com.taobao.weex.ui.component.WXComponent mRootComp;
    private android.widget.ScrollView mScrollView;
    private com.taobao.weex.IWXStatisticsListener mStatisticsListener;
    private com.taobao.weex.WXSDKInstance.StreamNetworkHandler mStreamNetworkHandler;
    public com.taobao.weex.utils.tools.TimeCalculator mTimeCalculator;
    private java.lang.String mUniPagePath;
    private boolean mUseScroller;
    private com.taobao.weex.adapter.IWXUserTrackAdapter mUserTrackAdapter;
    private java.util.Map<java.lang.String, java.io.Serializable> mUserTrackParams;
    private java.util.List<com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener> mVisibleListeners;
    private java.util.List<com.taobao.weex.WXSDKInstance.ActionBarHandler> mWXActionbarHandlers;
    private java.util.List<com.taobao.weex.WXSDKInstance.OnBackPressedHandler> mWXBackPressedHandlers;
    private com.taobao.weex.common.WXPerformance mWXPerformance;
    private java.util.List<com.taobao.weex.common.OnWXScrollListener> mWXScrollListeners;
    private com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener mWXScrollViewListener;
    private int maxHiddenEmbedsNum;
    public long[] measureTimes;
    public java.lang.String[] mwxDims;
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> responseHeaders;
    public java.lang.ref.WeakReference<java.lang.String> templateRef;
    private boolean trackComponent;

    public interface ActionBarHandler {
        boolean onSupportNavigateUp();
    }

    public interface CustomFontNetworkHandler {
        java.lang.String fetchLocal(java.lang.String str);
    }

    public interface FrameViewEventListener {
        void onShowAnimationEnd();
    }

    public interface ImageNetworkHandler {
        java.lang.String fetchLocal(java.lang.String str);
    }

    public interface NestedInstanceInterceptor {
        void onCreateNestInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.NestedContainer nestedContainer);
    }

    public interface OnBackPressedHandler {
        boolean onBackPressed();
    }

    public interface OnInstanceVisibleListener {
        void onAppear();

        void onDisappear();
    }

    public interface StreamNetworkHandler {
        java.lang.String fetchLocal(java.lang.String str);
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public boolean isCompilerWithUniapp() {
        return false;
    }

    public void onLayoutChange(android.view.View view) {
    }

    @java.lang.Deprecated
    public void registerActivityStateListener(com.taobao.weex.IWXActivityStateListener iWXActivityStateListener) {
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    @java.lang.Deprecated
    public void reloadImages() {
    }

    @java.lang.Deprecated
    public void setIWXUserTrackAdapter(com.taobao.weex.adapter.IWXUserTrackAdapter iWXUserTrackAdapter) {
    }

    public java.util.List<com.alibaba.fastjson.JSONObject> getComponentsExceedGPULimit() {
        return this.componentsInfoExceedGPULimit;
    }

    public void setComponentsInfoExceedGPULimit(com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.isEmpty()) {
            return;
        }
        this.componentsInfoExceedGPULimit.add(jSONObject);
    }

    public java.util.List<java.lang.String> getLayerOverFlowListeners() {
        return this.mLayerOverFlowListeners;
    }

    public void addLayerOverFlowListener(java.lang.String str) {
        if (this.mLayerOverFlowListeners == null) {
            this.mLayerOverFlowListeners = new java.util.ArrayList();
        }
        this.mLayerOverFlowListeners.add(str);
    }

    public void removeLayerOverFlowListener(java.lang.String str) {
        java.util.List<java.lang.String> list = this.mLayerOverFlowListeners;
        if (list != null) {
            list.remove(str);
        }
    }

    public com.taobao.weex.WXSDKInstance.ImageNetworkHandler getImageNetworkHandler() {
        return this.mImageNetworkHandler;
    }

    public void setImageNetworkHandler(com.taobao.weex.WXSDKInstance.ImageNetworkHandler imageNetworkHandler) {
        this.mImageNetworkHandler = imageNetworkHandler;
    }

    public com.taobao.weex.WXSDKInstance.StreamNetworkHandler getStreamNetworkHandler() {
        return this.mStreamNetworkHandler;
    }

    public void setStreamNetworkHandler(com.taobao.weex.WXSDKInstance.StreamNetworkHandler streamNetworkHandler) {
        this.mStreamNetworkHandler = streamNetworkHandler;
    }

    public com.taobao.weex.WXSDKInstance.CustomFontNetworkHandler getCustomFontNetworkHandler() {
        return this.mCustomFontNetworkHandler;
    }

    public void setCustomFontNetworkHandler(com.taobao.weex.WXSDKInstance.CustomFontNetworkHandler customFontNetworkHandler) {
        this.mCustomFontNetworkHandler = customFontNetworkHandler;
    }

    public void setUseSandBox(boolean z) {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().setSandBoxContext(z);
    }

    public int getMaxHiddenEmbedsNum() {
        return this.maxHiddenEmbedsNum;
    }

    public void setMaxHiddenEmbedsNum(int i) {
        this.maxHiddenEmbedsNum = i;
    }

    public void addInActiveAddElementAction(java.lang.String str, com.taobao.weex.ui.action.GraphicActionAddElement graphicActionAddElement) {
        this.inactiveAddElementAction.put(str, graphicActionAddElement);
    }

    public void removeInActiveAddElmentAction(java.lang.String str) {
        this.inactiveAddElementAction.remove(str);
    }

    public com.taobao.weex.ui.action.GraphicActionAddElement getInActiveAddElementAction(java.lang.String str) {
        return this.inactiveAddElementAction.get(str);
    }

    public void setRenderContainer(com.taobao.weex.RenderContainer renderContainer) {
        setWXAbstractRenderContainer(renderContainer);
    }

    public void setWXAbstractRenderContainer(com.taobao.weex.render.WXAbstractRenderContainer wXAbstractRenderContainer) {
        if (wXAbstractRenderContainer != null) {
            wXAbstractRenderContainer.setSDKInstance(this);
            wXAbstractRenderContainer.addOnLayoutChangeListener(this);
        }
        this.mRenderContainer = wXAbstractRenderContainer;
        if (wXAbstractRenderContainer != null && wXAbstractRenderContainer.getLayoutParams() != null && this.mRenderContainer.getLayoutParams().width == -2) {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.taobao.weex.WXSDKInstance.1
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.bridge.WXBridgeManager.getInstance().setRenderContentWrapContentToCore(true, com.taobao.weex.WXSDKInstance.this.getInstanceId());
                }
            });
        } else {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.taobao.weex.WXSDKInstance.2
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.bridge.WXBridgeManager.getInstance().setRenderContentWrapContentToCore(false, com.taobao.weex.WXSDKInstance.this.getInstanceId());
                }
            });
        }
    }

    public boolean isTrackComponent() {
        return this.trackComponent;
    }

    public void setTrackComponent(boolean z) {
        this.trackComponent = z;
    }

    public boolean isLayerTypeEnabled() {
        return this.enableLayerType;
    }

    public void enableLayerType(boolean z) {
        this.enableLayerType = z;
    }

    public com.taobao.weex.ui.flat.FlatGUIContext getFlatUIContext() {
        return this.mFlatGUIContext;
    }

    public boolean isNeedValidate() {
        return this.mNeedValidate;
    }

    public boolean isNeedReLoad() {
        return this.mNeedReLoad;
    }

    public void setNeedLoad(boolean z) {
        this.mNeedReLoad = z;
    }

    public void setEnableFullScreenHeight(boolean z) {
        this.enableFullScreenHeight = z;
    }

    public boolean isFullScreenHeightEnabled() {
        return this.enableFullScreenHeight;
    }

    public boolean isUseScroller() {
        return this.mUseScroller;
    }

    public void setUseScroller(boolean z) {
        this.mUseScroller = z;
    }

    public void setInstanceViewPortWidth(float f) {
        setInstanceViewPortWidth(f, false);
    }

    public void setInstanceViewPortWidth(float f, boolean z) {
        this.mInstanceViewPortWidth = f;
        com.taobao.weex.WXEnvironment.setViewProt(f);
        if (z) {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().setViewPortWidth(getInstanceId(), this.mInstanceViewPortWidth);
        }
    }

    public void resetDeviceDisplayOfPage() {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().setDeviceDisplayOfPage(getInstanceId(), com.taobao.weex.utils.WXViewUtils.getScreenWidth(getContext()), com.taobao.weex.utils.WXViewUtils.getScreenHeight(getContext()));
    }

    public void setDeviceDisplayOfPage(int i, int i2) {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().setDeviceDisplayOfPage(getInstanceId(), i, i2);
    }

    public void setPageKeepRawCssStyles() {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().setPageArgument(getInstanceId(), "reserveCssStyles", io.dcloud.common.constant.AbsoluteConst.TRUE);
    }

    public void reloadPageLayout() {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().reloadPageLayout(getInstanceId());
    }

    public void setAutoAdjustDeviceWidth(boolean z) {
        this.mAutoAdjustDeviceWidth = z;
    }

    public boolean isAutoAdjustDeviceWidth() {
        return this.mAutoAdjustDeviceWidth;
    }

    private void setDeviceDisplay(float f, float f2, float f3) {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().setDeviceDisplay(getInstanceId(), f, f2, f3);
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public float getInstanceViewPortWidthWithFloat() {
        return this.mInstanceViewPortWidth;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public int getInstanceViewPortWidth() {
        return java.lang.Math.round(this.mInstanceViewPortWidth);
    }

    public WXSDKInstance(android.content.Context context) {
        this.mEnd = false;
        this.mHasCreateFinish = false;
        this.mBundleUrl = "";
        this.mUniPagePath = "";
        this.isDestroy = false;
        this.hasException = false;
        this.isRenderSuccess = false;
        this.createInstanceHeartBeat = false;
        this.isCommit = false;
        this.mGlobalEventReceiver = null;
        this.enableLayerType = true;
        this.mNeedValidate = false;
        this.mNeedReLoad = false;
        this.mUseScroller = false;
        this.mInstanceViewPortWidth = 750.0f;
        this.enableFullScreenHeight = false;
        this.mFlatGUIContext = new com.taobao.weex.ui.flat.FlatGUIContext();
        this.isNewFsEnd = false;
        this.componentsInfoExceedGPULimit = new java.util.LinkedList();
        this.mExecJSTraceId = com.taobao.weex.tracing.WXTracing.nextId();
        this.isViewDisAppear = false;
        this.mwxDims = new java.lang.String[5];
        this.measureTimes = new long[5];
        this.responseHeaders = new java.util.HashMap();
        this.mRenderStrategy = com.taobao.weex.common.WXRenderStrategy.APPEND_ASYNC;
        this.mDisableSkipFrameworkInit = false;
        this.mRenderType = com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE;
        this.mAutoAdjustDeviceWidth = com.taobao.weex.WXEnvironment.AUTO_ADJUST_ENV_DEVICE_WIDTH;
        this.mCurrentGround = false;
        this.inactiveAddElementAction = new java.util.HashMap();
        this.mContentBoxMeasurements = new androidx.collection.ArrayMap();
        this.maxHiddenEmbedsNum = -1;
        this.mVisibleListeners = new java.util.ArrayList();
        this.isPreInit = false;
        this.isPreDownLoad = false;
        this.mHttpListener = null;
        this.mCreateInstance = true;
        this.mGlobalEvents = new java.util.HashMap<>();
        this.mDefaultFontSize = 32;
        this.frameViewEventListeners = new java.util.ArrayList();
        this.isFrameShow = false;
        this.isImmersive = true;
        this.isOnSizeChangedRender = true;
        this.mInstanceId = com.taobao.weex.WXSDKManager.getInstance().generateInstanceId();
        init(context);
    }

    public WXSDKInstance(android.content.Context context, android.content.Context context2) {
        this.mEnd = false;
        this.mHasCreateFinish = false;
        this.mBundleUrl = "";
        this.mUniPagePath = "";
        this.isDestroy = false;
        this.hasException = false;
        this.isRenderSuccess = false;
        this.createInstanceHeartBeat = false;
        this.isCommit = false;
        this.mGlobalEventReceiver = null;
        this.enableLayerType = true;
        this.mNeedValidate = false;
        this.mNeedReLoad = false;
        this.mUseScroller = false;
        this.mInstanceViewPortWidth = 750.0f;
        this.enableFullScreenHeight = false;
        this.mFlatGUIContext = new com.taobao.weex.ui.flat.FlatGUIContext();
        this.isNewFsEnd = false;
        this.componentsInfoExceedGPULimit = new java.util.LinkedList();
        this.mExecJSTraceId = com.taobao.weex.tracing.WXTracing.nextId();
        this.isViewDisAppear = false;
        this.mwxDims = new java.lang.String[5];
        this.measureTimes = new long[5];
        this.responseHeaders = new java.util.HashMap();
        this.mRenderStrategy = com.taobao.weex.common.WXRenderStrategy.APPEND_ASYNC;
        this.mDisableSkipFrameworkInit = false;
        this.mRenderType = com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE;
        this.mAutoAdjustDeviceWidth = com.taobao.weex.WXEnvironment.AUTO_ADJUST_ENV_DEVICE_WIDTH;
        this.mCurrentGround = false;
        this.inactiveAddElementAction = new java.util.HashMap();
        this.mContentBoxMeasurements = new androidx.collection.ArrayMap();
        this.maxHiddenEmbedsNum = -1;
        this.mVisibleListeners = new java.util.ArrayList();
        this.isPreInit = false;
        this.isPreDownLoad = false;
        this.mHttpListener = null;
        this.mCreateInstance = true;
        this.mGlobalEvents = new java.util.HashMap<>();
        this.mDefaultFontSize = 32;
        this.frameViewEventListeners = new java.util.ArrayList();
        this.isFrameShow = false;
        this.isImmersive = true;
        this.isOnSizeChangedRender = true;
        this.mInstanceId = com.taobao.weex.WXSDKManager.getInstance().generateInstanceId();
        this.mOriginalContext = context2;
        init(context);
    }

    public WXSDKInstance() {
        this.mEnd = false;
        this.mHasCreateFinish = false;
        this.mBundleUrl = "";
        this.mUniPagePath = "";
        this.isDestroy = false;
        this.hasException = false;
        this.isRenderSuccess = false;
        this.createInstanceHeartBeat = false;
        this.isCommit = false;
        this.mGlobalEventReceiver = null;
        this.enableLayerType = true;
        this.mNeedValidate = false;
        this.mNeedReLoad = false;
        this.mUseScroller = false;
        this.mInstanceViewPortWidth = 750.0f;
        this.enableFullScreenHeight = false;
        this.mFlatGUIContext = new com.taobao.weex.ui.flat.FlatGUIContext();
        this.isNewFsEnd = false;
        this.componentsInfoExceedGPULimit = new java.util.LinkedList();
        this.mExecJSTraceId = com.taobao.weex.tracing.WXTracing.nextId();
        this.isViewDisAppear = false;
        this.mwxDims = new java.lang.String[5];
        this.measureTimes = new long[5];
        this.responseHeaders = new java.util.HashMap();
        this.mRenderStrategy = com.taobao.weex.common.WXRenderStrategy.APPEND_ASYNC;
        this.mDisableSkipFrameworkInit = false;
        this.mRenderType = com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE;
        this.mAutoAdjustDeviceWidth = com.taobao.weex.WXEnvironment.AUTO_ADJUST_ENV_DEVICE_WIDTH;
        this.mCurrentGround = false;
        this.inactiveAddElementAction = new java.util.HashMap();
        this.mContentBoxMeasurements = new androidx.collection.ArrayMap();
        this.maxHiddenEmbedsNum = -1;
        this.mVisibleListeners = new java.util.ArrayList();
        this.isPreInit = false;
        this.isPreDownLoad = false;
        this.mHttpListener = null;
        this.mCreateInstance = true;
        this.mGlobalEvents = new java.util.HashMap<>();
        this.mDefaultFontSize = 32;
        this.frameViewEventListeners = new java.util.ArrayList();
        this.isFrameShow = false;
        this.isImmersive = true;
        this.isOnSizeChangedRender = true;
        java.lang.String strGenerateInstanceId = com.taobao.weex.WXSDKManager.getInstance().generateInstanceId();
        this.mInstanceId = strGenerateInstanceId;
        this.mWXPerformance = new com.taobao.weex.common.WXPerformance(strGenerateInstanceId);
        this.mApmForInstance = new com.taobao.weex.performance.WXInstanceApm(strGenerateInstanceId);
        com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().put(strGenerateInstanceId, this);
    }

    public WXSDKInstance(android.content.Context context, java.lang.String str) {
        this.mEnd = false;
        this.mHasCreateFinish = false;
        this.mBundleUrl = "";
        this.mUniPagePath = "";
        this.isDestroy = false;
        this.hasException = false;
        this.isRenderSuccess = false;
        this.createInstanceHeartBeat = false;
        this.isCommit = false;
        this.mGlobalEventReceiver = null;
        this.enableLayerType = true;
        this.mNeedValidate = false;
        this.mNeedReLoad = false;
        this.mUseScroller = false;
        this.mInstanceViewPortWidth = 750.0f;
        this.enableFullScreenHeight = false;
        this.mFlatGUIContext = new com.taobao.weex.ui.flat.FlatGUIContext();
        this.isNewFsEnd = false;
        this.componentsInfoExceedGPULimit = new java.util.LinkedList();
        this.mExecJSTraceId = com.taobao.weex.tracing.WXTracing.nextId();
        this.isViewDisAppear = false;
        this.mwxDims = new java.lang.String[5];
        this.measureTimes = new long[5];
        this.responseHeaders = new java.util.HashMap();
        this.mRenderStrategy = com.taobao.weex.common.WXRenderStrategy.APPEND_ASYNC;
        this.mDisableSkipFrameworkInit = false;
        this.mRenderType = com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE;
        this.mAutoAdjustDeviceWidth = com.taobao.weex.WXEnvironment.AUTO_ADJUST_ENV_DEVICE_WIDTH;
        this.mCurrentGround = false;
        this.inactiveAddElementAction = new java.util.HashMap();
        this.mContentBoxMeasurements = new androidx.collection.ArrayMap();
        this.maxHiddenEmbedsNum = -1;
        this.mVisibleListeners = new java.util.ArrayList();
        this.isPreInit = false;
        this.isPreDownLoad = false;
        this.mHttpListener = null;
        this.mCreateInstance = true;
        this.mGlobalEvents = new java.util.HashMap<>();
        this.mDefaultFontSize = 32;
        this.frameViewEventListeners = new java.util.ArrayList();
        this.isFrameShow = false;
        this.isImmersive = true;
        this.isOnSizeChangedRender = true;
        this.mInstanceId = str;
        init(context);
    }

    public com.taobao.weex.ui.component.WXComponent getRootComponent() {
        return this.mRootComp;
    }

    public void setNestedInstanceInterceptor(com.taobao.weex.WXSDKInstance.NestedInstanceInterceptor nestedInstanceInterceptor) {
        this.mNestedInstanceInterceptor = nestedInstanceInterceptor;
    }

    public final com.taobao.weex.WXSDKInstance createNestedInstance(com.taobao.weex.ui.component.NestedContainer nestedContainer) {
        com.taobao.weex.WXSDKInstance wXSDKInstanceNewNestedInstance = newNestedInstance();
        com.taobao.weex.WXSDKInstance.NestedInstanceInterceptor nestedInstanceInterceptor = this.mNestedInstanceInterceptor;
        if (nestedInstanceInterceptor != null) {
            nestedInstanceInterceptor.onCreateNestInstance(wXSDKInstanceNewNestedInstance, nestedContainer);
        }
        if (wXSDKInstanceNewNestedInstance != null) {
            wXSDKInstanceNewNestedInstance.setComponentObserver(getComponentObserver());
        }
        return wXSDKInstanceNewNestedInstance;
    }

    protected com.taobao.weex.WXSDKInstance newNestedInstance() {
        return new com.taobao.weex.WXSDKInstance(this.mContext);
    }

    public boolean isHasException() {
        return this.hasException;
    }

    public void setHasException(boolean z) {
        this.hasException = z;
    }

    public void createInstanceFuncHeartBeat() {
        com.taobao.weex.utils.WXLogUtils.d("createInstanceFuncHeartBeat: " + this.mInstanceId);
        this.createInstanceHeartBeat = true;
    }

    public void addOnInstanceVisibleListener(com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener onInstanceVisibleListener) {
        this.mVisibleListeners.add(onInstanceVisibleListener);
    }

    public void removeOnInstanceVisibleListener(com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener onInstanceVisibleListener) {
        this.mVisibleListeners.remove(onInstanceVisibleListener);
    }

    public void init(android.content.Context context) {
        java.lang.String simpleName;
        com.taobao.weex.utils.cache.RegisterCache.getInstance().idle(true);
        this.mContext = context;
        this.mContainerInfo = new java.util.HashMap(4);
        this.mNativeInvokeHelper = new com.taobao.weex.bridge.NativeInvokeHelper(this.mInstanceId);
        if (this.mWXPerformance == null) {
            this.mWXPerformance = new com.taobao.weex.common.WXPerformance(this.mInstanceId);
        }
        if (this.mApmForInstance == null) {
            this.mApmForInstance = new com.taobao.weex.performance.WXInstanceApm(this.mInstanceId);
        }
        this.mWXPerformance.WXSDKVersion = com.taobao.weex.WXEnvironment.WXSDK_VERSION;
        this.mWXPerformance.JSLibInitTime = com.taobao.weex.WXEnvironment.sJSLibInitTime;
        this.mUserTrackAdapter = com.taobao.weex.WXSDKManager.getInstance().getIWXUserTrackAdapter();
        com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().put(this.mInstanceId, this);
        java.util.Map<java.lang.String, java.lang.String> map = this.mContainerInfo;
        if (context instanceof android.app.Activity) {
            simpleName = context.getClass().getSimpleName();
        } else {
            simpleName = "unKnowContainer";
        }
        map.put(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_PROPERTIES_CONTAINER_NAME, simpleName);
        this.mContainerInfo.put(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_PROPERTIES_INSTANCE_TYPE, "page");
        this.mDisableSkipFrameworkInit = isDisableSkipFrameworkInDataRender();
        this.mTimeCalculator = new com.taobao.weex.utils.tools.TimeCalculator(this);
    }

    public void setComponentObserver(com.taobao.weex.ComponentObserver componentObserver) {
        this.mComponentObserver = componentObserver;
    }

    public com.taobao.weex.ComponentObserver getComponentObserver() {
        return this.mComponentObserver;
    }

    public com.taobao.weex.bridge.NativeInvokeHelper getNativeInvokeHelper() {
        return this.mNativeInvokeHelper;
    }

    @java.lang.Deprecated
    public void setBizType(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.mWXPerformance.bizType = str;
    }

    public android.widget.ScrollView getScrollView() {
        return this.mScrollView;
    }

    public void setRootScrollView(android.widget.ScrollView scrollView) {
        this.mScrollView = scrollView;
        com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener wXScrollViewListener = this.mWXScrollViewListener;
        if (wXScrollViewListener == null || !(scrollView instanceof com.taobao.weex.ui.view.WXScrollView)) {
            return;
        }
        ((com.taobao.weex.ui.view.WXScrollView) scrollView).addScrollViewListener(wXScrollViewListener);
    }

    @java.lang.Deprecated
    public void registerScrollViewListener(com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener wXScrollViewListener) {
        this.mWXScrollViewListener = wXScrollViewListener;
    }

    @java.lang.Deprecated
    public com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener getScrollViewListener() {
        return this.mWXScrollViewListener;
    }

    public void setContainerInfo(java.lang.String str, java.lang.String str2) {
        this.mContainerInfo.put(str, str2);
    }

    public java.util.Map<java.lang.String, java.lang.String> getContainerInfo() {
        return this.mContainerInfo;
    }

    public void render(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str2) {
        render(str, map, str2, com.taobao.weex.common.WXRenderStrategy.APPEND_ASYNC);
    }

    @java.lang.Deprecated
    public void render(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str2, com.taobao.weex.common.WXRenderStrategy wXRenderStrategy) {
        render("default", str, map, str2, wXRenderStrategy);
    }

    public void render(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str3, com.taobao.weex.common.WXRenderStrategy wXRenderStrategy) {
        render(str, new com.taobao.weex.Script(str2), map, str3, wXRenderStrategy);
    }

    public void render(java.lang.String str, com.taobao.weex.Script script, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str2, com.taobao.weex.common.WXRenderStrategy wXRenderStrategy) {
        this.mWXPerformance.beforeInstanceRender(this.mInstanceId);
        if (com.taobao.weex.WXEnvironment.isApkDebugable() && "default".equals(str)) {
            if (getUIContext() != null) {
                new android.app.AlertDialog.Builder(getUIContext()).setTitle("Error: Missing pageName").setMessage("We highly recommend you to set pageName. Call\nWXSDKInstance#render(String pageName, String template, Map<String, Object> options, String jsonInitData, WXRenderStrategy flag)\nto fix it.").show();
                return;
            }
            return;
        }
        renderInternal(str, script, map, str2, wXRenderStrategy);
    }

    public void render(java.lang.String str, byte[] bArr, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str2) {
        render(str, new com.taobao.weex.Script(bArr), map, str2, com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY);
    }

    private void ensureRenderArchor() {
        if (this.mRenderContainer != null || getContext() == null) {
            return;
        }
        setRenderContainer(new com.taobao.weex.RenderContainer(getContext()));
        this.mRenderContainer.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        this.mRenderContainer.setBackgroundColor(0);
        this.mRenderContainer.setSDKInstance(this);
        this.mRenderContainer.addOnLayoutChangeListener(this);
    }

    private void renderInternal(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str3, com.taobao.weex.common.WXRenderStrategy wXRenderStrategy) {
        if (this.mRendered || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        renderInternal(str, new com.taobao.weex.Script(str2), map, str3, wXRenderStrategy);
    }

    public boolean isPreInitMode() {
        return this.isPreInit;
    }

    public boolean isPreDownLoad() {
        return this.isPreDownLoad;
    }

    public void onInstanceReady() {
        com.taobao.weex.utils.WXLogUtils.e("test->", "onInstanceReady");
        this.mApmForInstance.onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_CONTAINER_READY);
        if (this.isPreInit || this.isPreDownLoad) {
            this.mApmForInstance.onInstanceReady(this.isPreDownLoad);
            if (this.isPreDownLoad) {
                this.mHttpListener.onInstanceReady();
            }
        }
    }

    public void preInit(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str3, com.taobao.weex.common.WXRenderStrategy wXRenderStrategy) {
        this.isPreInit = true;
        this.mRenderStrategy = wXRenderStrategy;
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        this.mApmForInstance.isReady = false;
        com.taobao.weex.WXSDKManager.getInstance().createInstance(this, new com.taobao.weex.Script(str2), map, str3);
    }

    public void preDownLoad(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str2, com.taobao.weex.common.WXRenderStrategy wXRenderStrategy) {
        this.isPreDownLoad = true;
        this.mRenderStrategy = wXRenderStrategy;
        this.mApmForInstance.isReady = false;
        renderByUrl(str, str, map, str2, wXRenderStrategy);
    }

    private void renderInternal(java.lang.String str, com.taobao.weex.Script script, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str2, com.taobao.weex.common.WXRenderStrategy wXRenderStrategy) {
        if (this.mRendered || script == null || script.isEmpty()) {
            return;
        }
        com.taobao.weex.utils.tools.LogDetail logDetailCreateLogDetail = this.mTimeCalculator.createLogDetail("renderInternal");
        this.mRenderStrategy = wXRenderStrategy;
        if (!this.mApmForInstance.hasInit()) {
            this.mApmForInstance.doInit();
        }
        this.mApmForInstance.setPageName(str);
        this.mApmForInstance.onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_RENDER_ORGIGIN);
        this.mApmForInstance.doDelayCollectData();
        this.mWXPerformance.pageName = android.text.TextUtils.isEmpty(str) ? "defaultBundleUrl" : str;
        if (android.text.TextUtils.isEmpty(this.mBundleUrl)) {
            this.mBundleUrl = this.mWXPerformance.pageName;
        }
        if (com.taobao.weex.tracing.WXTracing.isAvailable()) {
            com.taobao.weex.tracing.WXTracing.TraceEvent traceEventNewEvent = com.taobao.weex.tracing.WXTracing.newEvent("executeBundleJS", this.mInstanceId, -1);
            traceEventNewEvent.traceId = this.mExecJSTraceId;
            traceEventNewEvent.iid = this.mInstanceId;
            traceEventNewEvent.tname = "JSThread";
            traceEventNewEvent.ph = "B";
            traceEventNewEvent.submit();
            this.mRenderStartNanos = java.lang.System.nanoTime();
        }
        ensureRenderArchor();
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        java.util.Map<java.lang.String, java.lang.Object> map2 = map;
        if (com.taobao.weex.WXEnvironment.sDynamicMode && !android.text.TextUtils.isEmpty(com.taobao.weex.WXEnvironment.sDynamicUrl) && map2.get("dynamicMode") == null) {
            map2.put("dynamicMode", io.dcloud.common.constant.AbsoluteConst.TRUE);
            renderByUrl(str, com.taobao.weex.WXEnvironment.sDynamicUrl, map2, str2, wXRenderStrategy);
            return;
        }
        this.mWXPerformance.JSTemplateSize = script.length() / 1024.0f;
        this.mApmForInstance.addStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_BUNDLE_SIZE, this.mWXPerformance.JSTemplateSize);
        this.mRenderStartTime = java.lang.System.currentTimeMillis();
        com.taobao.weex.WXSDKManager.getInstance().setCrashInfo(com.taobao.weex.WXEnvironment.WEEX_CURRENT_KEY, str);
        com.taobao.weex.bridge.WXParams initParams = com.taobao.weex.bridge.WXBridgeManager.getInstance().getInitParams();
        float f = com.taobao.weex.WXEnvironment.sApplication.getResources().getDisplayMetrics().density;
        int screenWidth = com.taobao.weex.utils.WXViewUtils.getScreenWidth(this.mContext);
        if (!io.dcloud.feature.weex.WeexInstanceMgr.self().getComplier().equalsIgnoreCase("weex")) {
            setInstanceViewPortWidth(screenWidth / f, true);
        }
        if (initParams != null && !android.text.TextUtils.equals(initParams.getDeviceWidth(), java.lang.String.valueOf(screenWidth))) {
            initParams.setDeviceWidth(java.lang.String.valueOf(screenWidth));
            initParams.setDeviceHeight(java.lang.String.valueOf(com.taobao.weex.utils.WXViewUtils.getScreenHeight(this.mContext)));
            com.taobao.weex.WXEnvironment.addCustomOptions("scale", java.lang.Float.toString(f));
            com.taobao.weex.bridge.WXBridgeManager.getInstance().updateInitDeviceParams(initParams.getDeviceWidth(), initParams.getDeviceHeight(), java.lang.Float.toString(f), com.taobao.weex.utils.WXViewUtils.getStatusBarHeight(this.mContext) > 0 ? java.lang.String.valueOf(com.taobao.weex.utils.WXViewUtils.getStatusBarHeight(this.mContext)) : null);
            setDeviceDisplay(com.taobao.weex.utils.WXViewUtils.getScreenWidth(this.mContext), com.taobao.weex.utils.WXViewUtils.getScreenHeight(this.mContext), com.taobao.weex.utils.WXViewUtils.getScreenDensity(this.mContext));
        }
        logDetailCreateLogDetail.taskStart();
        if (isPreInitMode()) {
            getApmForInstance().onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_START);
            com.taobao.weex.bridge.WXBridgeManager.getInstance().loadJsBundleInPreInitMode(getInstanceId(), script.getContent());
        } else {
            com.taobao.weex.WXSDKManager.getInstance().createInstance(this, script, map2, str2);
        }
        logDetailCreateLogDetail.taskEnd();
        this.mRendered = true;
        final com.taobao.weex.adapter.IWXJscProcessManager wXJscProcessManager = com.taobao.weex.WXSDKManager.getInstance().getWXJscProcessManager();
        if (wXJscProcessManager == null || !wXJscProcessManager.shouldReboot()) {
            return;
        }
        com.taobao.weex.WXSDKManager.getInstance().postOnUiThread(new java.lang.Runnable() { // from class: com.taobao.weex.WXSDKInstance.3
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.WXSDKInstance.this.checkWhiteScreen();
                if (com.taobao.weex.WXSDKInstance.this.isDestroy || com.taobao.weex.WXSDKInstance.this.hasException || com.taobao.weex.WXSDKInstance.this.isRenderSuccess) {
                    return;
                }
                android.view.View containerView = com.taobao.weex.WXSDKInstance.this.getContainerView();
                if ((containerView instanceof android.view.ViewGroup) && ((android.view.ViewGroup) containerView).getChildCount() == 0) {
                    if (wXJscProcessManager.withException(com.taobao.weex.WXSDKInstance.this)) {
                        com.taobao.weex.WXSDKInstance.this.onJSException(java.lang.String.valueOf(com.taobao.weex.common.WXErrorCode.WX_ERR_RELOAD_PAGE), "jsc reboot", "jsc reboot");
                    }
                    if (com.taobao.weex.WXSDKInstance.this.createInstanceHeartBeat) {
                        return;
                    }
                    com.taobao.weex.bridge.WXBridgeManager.getInstance().callReportCrashReloadPage(com.taobao.weex.WXSDKInstance.this.mInstanceId, null);
                    com.taobao.weex.utils.WXLogUtils.e("callReportCrashReloadPage with jsc reboot");
                }
            }
        }, wXJscProcessManager.rebootTimeout());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkWhiteScreen() {
        if (!this.isDestroy && com.taobao.weex.performance.WhiteScreenUtils.doWhiteScreenCheck() && com.taobao.weex.performance.WhiteScreenUtils.isWhiteScreen(this)) {
            com.taobao.weex.common.WXErrorCode wXErrorCode = com.taobao.weex.common.WXErrorCode.WX_ERROR_WHITE_SCREEN;
            java.util.HashMap map = new java.util.HashMap(1);
            java.lang.String strTakeViewTreeSnapShot = com.taobao.weex.performance.WhiteScreenUtils.takeViewTreeSnapShot(this);
            if (strTakeViewTreeSnapShot == null) {
                strTakeViewTreeSnapShot = "null viewTreeMsg";
            }
            map.put("viewTree", strTakeViewTreeSnapShot);
            map.put("weexCoreThreadStackTrace", com.taobao.weex.bridge.WXBridgeManager.getInstance().getWeexCoreThreadStackTrace());
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : com.taobao.weex.performance.WXStateRecord.getInstance().getStateInfo().entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(getInstanceId(), wXErrorCode, "checkEmptyScreen", wXErrorCode.getErrorMsg(), map);
        }
    }

    public boolean skipFrameworkInit() {
        return isDataRender() && !this.mDisableSkipFrameworkInit;
    }

    private boolean isDataRender() {
        return getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY || getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER;
    }

    private void renderByUrlInternal(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str3, com.taobao.weex.common.WXRenderStrategy wXRenderStrategy) {
        com.taobao.weex.utils.tools.LogDetail logDetailCreateLogDetail = this.mTimeCalculator.createLogDetail("renderByUrlInternal");
        logDetailCreateLogDetail.taskStart();
        ensureRenderArchor();
        java.lang.String strWrapPageName = wrapPageName(str, str2);
        this.mBundleUrl = str2;
        this.mRenderStrategy = wXRenderStrategy;
        if (com.taobao.weex.WXSDKManager.getInstance().getValidateProcessor() != null) {
            this.mNeedValidate = com.taobao.weex.WXSDKManager.getInstance().getValidateProcessor().needValidate(this.mBundleUrl);
        }
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        java.util.Map<java.lang.String, java.lang.Object> map2 = map;
        if (!map2.containsKey("bundleUrl")) {
            map2.put("bundleUrl", str2);
        }
        getWXPerformance().pageName = strWrapPageName;
        this.mApmForInstance.doInit();
        this.mApmForInstance.setPageName(strWrapPageName);
        android.net.Uri uri = android.net.Uri.parse(str2);
        if (uri != null && android.text.TextUtils.equals(uri.getScheme(), "file")) {
            this.mApmForInstance.onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_START);
            java.lang.String strLoadFileOrAsset = com.taobao.weex.utils.WXFileUtils.loadFileOrAsset(assembleFilePath(uri), this.mContext);
            this.mApmForInstance.onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_END);
            render(strWrapPageName, strLoadFileOrAsset, map2, str3, wXRenderStrategy);
            return;
        }
        com.taobao.weex.common.WXRenderStrategy wXRenderStrategy2 = wXRenderStrategy;
        if (uri != null && uri.getPath() != null && uri.getPath().endsWith(".wlasm")) {
            wXRenderStrategy2 = com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY;
        }
        com.taobao.weex.adapter.IWXHttpAdapter iWXHttpAdapter = com.taobao.weex.WXSDKManager.getInstance().getIWXHttpAdapter();
        com.taobao.weex.common.WXRequest wXRequest = new com.taobao.weex.common.WXRequest();
        wXRequest.url = rewriteUri(android.net.Uri.parse(str2), io.dcloud.feature.uniapp.adapter.AbsURIAdapter.BUNDLE).toString();
        if (!android.text.TextUtils.isEmpty(wXRequest.url)) {
            requestUrl = wXRequest.url;
        } else {
            requestUrl = strWrapPageName;
        }
        if (wXRequest.paramMap == null) {
            wXRequest.paramMap = new java.util.HashMap();
        }
        wXRequest.instanceId = getInstanceId();
        wXRequest.paramMap.put(com.taobao.weex.http.WXHttpUtil.KEY_USER_AGENT, com.taobao.weex.http.WXHttpUtil.assembleUserAgent(this.mContext, com.taobao.weex.WXEnvironment.getConfig()));
        wXRequest.paramMap.put("isBundleRequest", io.dcloud.common.constant.AbsoluteConst.TRUE);
        com.taobao.weex.WXHttpListener wXHttpListener = new com.taobao.weex.WXHttpListener(this, strWrapPageName, map2, str3, wXRenderStrategy2, java.lang.System.currentTimeMillis());
        this.mHttpListener = wXHttpListener;
        wXHttpListener.isPreDownLoadMode = this.isPreDownLoad;
        this.mHttpListener.setSDKInstance(this);
        this.mApmForInstance.onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_DOWN_BUNDLE_START);
        iWXHttpAdapter.sendRequest(wXRequest, this.mHttpListener);
        logDetailCreateLogDetail.taskEnd();
    }

    @java.lang.Deprecated
    public void render(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str3, int i, int i2, com.taobao.weex.common.WXRenderStrategy wXRenderStrategy) {
        render(str, str2, map, str3, wXRenderStrategy);
    }

    public void render(java.lang.String str) {
        render("default", str, (java.util.Map<java.lang.String, java.lang.Object>) null, (java.lang.String) null, this.mRenderStrategy);
    }

    @java.lang.Deprecated
    public void render(java.lang.String str, int i, int i2) {
        render(str);
    }

    @java.lang.Deprecated
    public void renderByUrl(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str3, int i, int i2, com.taobao.weex.common.WXRenderStrategy wXRenderStrategy) {
        renderByUrl(str, str2, map, str3, wXRenderStrategy);
    }

    public void renderByUrl(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str3, com.taobao.weex.common.WXRenderStrategy wXRenderStrategy) {
        renderByUrlInternal(str, str2, map, str3, wXRenderStrategy);
    }

    private java.lang.String wrapPageName(java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.equals(str, "default")) {
            return str;
        }
        com.taobao.weex.utils.WXExceptionUtils.degradeUrl = str2;
        try {
            android.net.Uri uri = android.net.Uri.parse(str2);
            if (uri != null) {
                android.net.Uri.Builder builder = new android.net.Uri.Builder();
                builder.scheme(uri.getScheme());
                builder.authority(uri.getAuthority());
                builder.path(uri.getPath());
                return builder.toString();
            }
        } catch (java.lang.Exception unused) {
        }
        return str2;
    }

    private java.lang.String assembleFilePath(android.net.Uri uri) {
        return (uri == null || uri.getPath() == null) ? "" : uri.getPath().replaceFirst("/", "");
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void reloadPage(boolean z) {
        com.taobao.weex.WXSDKEngine.reload();
        if (z) {
            if (this.mContext != null) {
                android.content.Intent intent = new android.content.Intent();
                intent.setAction(ACTION_INSTANCE_RELOAD);
                intent.putExtra("url", this.mBundleUrl);
                this.mContext.sendBroadcast(intent);
                return;
            }
            return;
        }
        com.taobao.weex.adapter.IWXConfigAdapter wxConfigAdapter = com.taobao.weex.WXSDKManager.getInstance().getWxConfigAdapter();
        if (wxConfigAdapter != null) {
            boolean z2 = java.lang.Boolean.parseBoolean(wxConfigAdapter.getConfig("android_weex_ext_config", "degrade_to_h5_if_not_reload", io.dcloud.common.constant.AbsoluteConst.TRUE));
            com.taobao.weex.utils.WXLogUtils.e("degrade : " + z2);
            if (z2) {
                onJSException(java.lang.String.valueOf(com.taobao.weex.common.WXErrorCode.WX_ERR_RELOAD_PAGE.getErrorCode()), "Do not reloadPage", "Do not reloadPage degradeToH5");
                com.taobao.weex.utils.WXLogUtils.e("Do not reloadPage degradeToH5");
            }
        }
    }

    public void refreshInstance(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null) {
            return;
        }
        refreshInstance(com.taobao.weex.utils.WXJsonUtils.fromObjectToJSONString(map));
    }

    public void refreshInstance(java.lang.String str) {
        if (str == null) {
            return;
        }
        this.mRefreshStartTime = java.lang.System.currentTimeMillis();
        com.taobao.weex.common.WXRefreshData wXRefreshData = this.mLastRefreshData;
        if (wXRefreshData != null) {
            wXRefreshData.isDirty = true;
        }
        this.mLastRefreshData = new com.taobao.weex.common.WXRefreshData(str, false);
        com.taobao.weex.WXSDKManager.getInstance().refreshInstance(this.mInstanceId, this.mLastRefreshData);
    }

    public com.taobao.weex.common.WXRenderStrategy getRenderStrategy() {
        return this.mRenderStrategy;
    }

    public android.content.Context getUIContext() {
        return this.mContext;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public java.lang.String getInstanceId() {
        return this.mInstanceId;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public android.content.Context getContext() {
        return this.mContext;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public int getWeexHeight() {
        com.taobao.weex.render.WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
        if (wXAbstractRenderContainer == null) {
            return 0;
        }
        return wXAbstractRenderContainer.getHeight();
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public int getWeexWidth() {
        com.taobao.weex.render.WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
        if (wXAbstractRenderContainer == null) {
            return 0;
        }
        return wXAbstractRenderContainer.getWidth();
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public com.taobao.weex.adapter.IWXImgLoaderAdapter getImgLoaderAdapter() {
        return com.taobao.weex.WXSDKManager.getInstance().getIWXImgLoaderAdapter();
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public com.taobao.weex.adapter.IDrawableLoader getDrawableLoader() {
        return com.taobao.weex.WXSDKManager.getInstance().getDrawableLoader();
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public com.taobao.weex.adapter.URIAdapter getURIAdapter() {
        return com.taobao.weex.WXSDKManager.getInstance().getURIAdapter();
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public android.net.Uri rewriteUri(android.net.Uri uri, java.lang.String str) {
        return getURIAdapter().rewrite(this, str, uri);
    }

    public com.taobao.weex.adapter.IWXHttpAdapter getWXHttpAdapter() {
        return com.taobao.weex.WXSDKManager.getInstance().getIWXHttpAdapter();
    }

    public com.taobao.weex.IWXStatisticsListener getWXStatisticsListener() {
        return this.mStatisticsListener;
    }

    public com.taobao.weex.appfram.websocket.IWebSocketAdapter getWXWebSocketAdapter() {
        return com.taobao.weex.WXSDKManager.getInstance().getIWXWebSocketAdapter();
    }

    public boolean isPreRenderMode() {
        return this.isPreRenderMode;
    }

    public void setPreRenderMode(final boolean z) {
        com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postOnUiThread(new java.lang.Runnable() { // from class: com.taobao.weex.WXSDKInstance.4
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.WXSDKInstance.this.isPreRenderMode = z;
            }
        }, 0L);
    }

    public void setContext(android.content.Context context) {
        this.mContext = context;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void registerRenderListener(com.taobao.weex.IWXRenderListener iWXRenderListener) {
        this.mRenderListener = iWXRenderListener;
    }

    public void registerStatisticsListener(com.taobao.weex.IWXStatisticsListener iWXStatisticsListener) {
        this.mStatisticsListener = iWXStatisticsListener;
    }

    public void setRenderStartTime(long j) {
        this.mRenderStartTime = j;
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityCreate() {
        com.taobao.weex.bridge.WXModuleManager.onActivityCreate(getInstanceId());
        com.taobao.weex.ui.component.WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onActivityCreate();
        } else if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.w("Warning :Component tree has not build completely,onActivityCreate can not be call!");
        }
        this.mGlobalEventReceiver = new com.taobao.weex.WXGlobalEventReceiver(this);
        try {
            if (android.os.Build.VERSION.SDK_INT >= 33) {
                getContext().registerReceiver(this.mGlobalEventReceiver, new android.content.IntentFilter(com.taobao.weex.WXGlobalEventReceiver.EVENT_ACTION), 4);
            } else {
                getContext().registerReceiver(this.mGlobalEventReceiver, new android.content.IntentFilter(com.taobao.weex.WXGlobalEventReceiver.EVENT_ACTION));
            }
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e(th.getMessage());
            this.mGlobalEventReceiver = null;
        }
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityStart() {
        com.taobao.weex.bridge.WXModuleManager.onActivityStart(getInstanceId());
        com.taobao.weex.ui.component.WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onActivityStart();
        } else if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.w("Warning :Component tree has not build completely,onActivityStart can not be call!");
        }
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        com.taobao.weex.bridge.WXModuleManager.onCreateOptionsMenu(getInstanceId(), menu);
        com.taobao.weex.ui.component.WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onCreateOptionsMenu(menu);
            return true;
        }
        if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
            return true;
        }
        com.taobao.weex.utils.WXLogUtils.w("Warning :Component tree has not build completely,onActivityStart can not be call!");
        return true;
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityPause() {
        onViewDisappear();
        if (!this.isCommit) {
            if (this.mUseScroller) {
                this.mWXPerformance.useScroller = 1;
            }
            this.mWXPerformance.maxDeepViewLayer = getMaxDeepLayer();
            this.mWXPerformance.wxDims = this.mwxDims;
            this.mWXPerformance.measureTimes = this.measureTimes;
            com.taobao.weex.adapter.IWXUserTrackAdapter iWXUserTrackAdapter = this.mUserTrackAdapter;
            if (iWXUserTrackAdapter != null) {
                iWXUserTrackAdapter.commit(this.mContext, null, "load", this.mWXPerformance, getUserTrackParams());
            }
            this.isCommit = true;
        }
        com.taobao.weex.bridge.WXModuleManager.onActivityPause(getInstanceId());
        com.taobao.weex.ui.component.WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onActivityPause();
        } else if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.w("Warning :Component tree has not build completely,onActivityPause can not be call!");
        }
        if (!this.mCurrentGround) {
            com.taobao.weex.utils.WXLogUtils.i("Application to be in the backround");
            android.content.Intent intent = new android.content.Intent(com.taobao.weex.WXGlobalEventReceiver.EVENT_ACTION);
            intent.putExtra(com.taobao.weex.WXGlobalEventReceiver.EVENT_NAME, com.taobao.weex.common.Constants.Event.PAUSE_EVENT);
            intent.putExtra(com.taobao.weex.WXGlobalEventReceiver.EVENT_WX_INSTANCEID, getInstanceId());
            android.content.Context context = this.mContext;
            if (context != null) {
                intent.setPackage(context.getPackageName());
                this.mContext.sendBroadcast(intent);
            } else {
                try {
                    com.taobao.weex.WXEnvironment.getApplication().sendBroadcast(intent);
                } catch (java.lang.Exception e) {
                    com.taobao.weex.utils.WXLogUtils.e("weex", e);
                }
            }
            this.mCurrentGround = true;
        }
        if ((com.taobao.weex.WXEnvironment.isApkDebugable() || com.taobao.weex.WXEnvironment.isPerf()) && this.mApmForInstance != null) {
            com.taobao.weex.utils.WXLogUtils.e("PerformanceData " + this.mApmForInstance.toPerfString());
        }
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityResume() {
        com.taobao.weex.bridge.WXModuleManager.onActivityResume(getInstanceId());
        com.taobao.weex.ui.component.WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onActivityResume();
        } else if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.w("Warning :Component tree has not build completely, onActivityResume can not be call!");
        }
        if (this.mCurrentGround) {
            com.taobao.weex.utils.WXLogUtils.i("Application  to be in the foreground");
            android.content.Intent intent = new android.content.Intent(com.taobao.weex.WXGlobalEventReceiver.EVENT_ACTION);
            intent.putExtra(com.taobao.weex.WXGlobalEventReceiver.EVENT_NAME, com.taobao.weex.common.Constants.Event.RESUME_EVENT);
            intent.putExtra(com.taobao.weex.WXGlobalEventReceiver.EVENT_WX_INSTANCEID, getInstanceId());
            android.content.Context context = this.mContext;
            if (context != null) {
                intent.setPackage(context.getPackageName());
                this.mContext.sendBroadcast(intent);
            } else {
                com.taobao.weex.WXEnvironment.getApplication().sendBroadcast(intent);
            }
            this.mCurrentGround = false;
        }
        onViewAppear();
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityStop() {
        com.taobao.weex.bridge.WXModuleManager.onActivityStop(getInstanceId());
        com.taobao.weex.ui.component.WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onActivityStop();
        } else if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.w("Warning :Component tree has not build completely, onActivityStop can not be call!");
        }
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityDestroy() {
        com.taobao.weex.bridge.WXModuleManager.onActivityDestroy(getInstanceId());
        com.taobao.weex.ui.component.WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onActivityDestroy();
        } else if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.w("Warning :Component tree has not build completely, onActivityDestroy can not be call!");
        }
        this.mTimeCalculator.println();
        destroy();
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public boolean onActivityBack() {
        com.taobao.weex.bridge.WXModuleManager.onActivityBack(getInstanceId());
        com.taobao.weex.ui.component.WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            return wXComponent.onActivityBack();
        }
        if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
            return false;
        }
        com.taobao.weex.utils.WXLogUtils.w("Warning :Component tree has not build completely, onActivityBack can not be call!");
        return false;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public boolean onSupportNavigateUp() {
        java.util.List<com.taobao.weex.WXSDKInstance.ActionBarHandler> list = this.mWXActionbarHandlers;
        if (list == null) {
            return false;
        }
        java.util.Iterator<com.taobao.weex.WXSDKInstance.ActionBarHandler> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().onSupportNavigateUp()) {
                return true;
            }
        }
        return false;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public boolean onBackPressed() {
        java.util.List<com.taobao.weex.WXSDKInstance.OnBackPressedHandler> list = this.mWXBackPressedHandlers;
        if (list != null) {
            java.util.Iterator<com.taobao.weex.WXSDKInstance.OnBackPressedHandler> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().onBackPressed()) {
                    return true;
                }
            }
        }
        com.taobao.weex.ui.component.WXComponent rootComponent = getRootComponent();
        boolean zContains = false;
        if (rootComponent != null) {
            com.taobao.weex.dom.WXEvent events = rootComponent.getEvents();
            if (events.contains(com.taobao.weex.common.Constants.Event.NATIVE_BACK) && com.taobao.weex.utils.WXUtils.getBoolean(rootComponent.fireEventWait(com.taobao.weex.common.Constants.Event.NATIVE_BACK, null).getResult(), false).booleanValue()) {
                return true;
            }
            zContains = events.contains(com.taobao.weex.common.Constants.Event.CLICKBACKITEM);
            if (zContains) {
                fireEvent(rootComponent.getRef(), com.taobao.weex.common.Constants.Event.CLICKBACKITEM, null, null);
            }
        }
        return zContains;
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.taobao.weex.bridge.WXModuleManager.onActivityResult(getInstanceId(), i, i2, intent);
        com.taobao.weex.ui.component.WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onActivityResult(i, i2, intent);
        } else if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.w("Warning :Component tree has not build completely, onActivityResult can not be call!");
        }
    }

    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        com.taobao.weex.bridge.WXModuleManager.onRequestPermissionsResult(getInstanceId(), i, strArr, iArr);
        com.taobao.weex.ui.component.WXComponent wXComponent = this.mRootComp;
        if (wXComponent != null) {
            wXComponent.onRequestPermissionsResult(i, strArr, iArr);
        } else if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.w("Warning :Component tree has not build completely, onRequestPermissionsResult can not be call!");
        }
    }

    public void onViewDisappear() {
        this.isViewDisAppear = false;
        this.mApmForInstance.onDisAppear();
        com.taobao.weex.ui.component.WXComponent rootComponent = getRootComponent();
        if (rootComponent != null) {
            fireEvent(rootComponent.getRef(), com.taobao.weex.common.Constants.Event.VIEWDISAPPEAR, null, null);
            java.util.Iterator<com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener> it = this.mVisibleListeners.iterator();
            while (it.hasNext()) {
                it.next().onDisappear();
            }
        }
    }

    public boolean isViewDisAppear() {
        return this.isViewDisAppear;
    }

    public void onViewAppear() {
        this.isViewDisAppear = true;
        this.mApmForInstance.onAppear();
        com.taobao.weex.ui.component.WXComponent rootComponent = getRootComponent();
        if (rootComponent != null) {
            fireEvent(rootComponent.getRef(), com.taobao.weex.common.Constants.Event.VIEWAPPEAR, null, null);
            java.util.Iterator<com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener> it = this.mVisibleListeners.iterator();
            while (it.hasNext()) {
                it.next().onAppear();
            }
        }
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void onCreateFinish() {
        if (this.mHasCreateFinish || this.mContext == null) {
            return;
        }
        onViewAppear();
        com.taobao.weex.render.WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
        com.taobao.weex.IWXRenderListener iWXRenderListener = this.mRenderListener;
        if (iWXRenderListener != null) {
            iWXRenderListener.onViewCreated(this, wXAbstractRenderContainer);
        }
        com.taobao.weex.IWXStatisticsListener iWXStatisticsListener = this.mStatisticsListener;
        if (iWXStatisticsListener != null) {
            iWXStatisticsListener.onFirstView();
        }
    }

    public void onUpdateFinish() {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d("Instance onUpdateSuccess");
        }
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void runOnUiThread(java.lang.Runnable runnable) {
        com.taobao.weex.WXSDKManager.getInstance().postOnUiThread(runnable, 0L);
    }

    public void onRenderSuccess(int i, int i2) {
        this.isRenderSuccess = true;
        if (!this.isNewFsEnd) {
            getApmForInstance().arriveNewFsRenderTime();
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - this.mRenderStartTime;
        long[] renderFinishTime = com.taobao.weex.bridge.WXBridgeManager.getInstance().getRenderFinishTime(getInstanceId());
        this.mWXPerformance.callBridgeTime = renderFinishTime[0];
        this.mWXPerformance.cssLayoutTime = renderFinishTime[1];
        this.mWXPerformance.parseJsonTime = renderFinishTime[2];
        this.mWXPerformance.totalTime = jCurrentTimeMillis;
        if (this.mWXPerformance.screenRenderTime < 0.001d) {
            this.mWXPerformance.screenRenderTime = jCurrentTimeMillis;
        }
        com.taobao.weex.IWXRenderListener iWXRenderListener = this.mRenderListener;
        if (iWXRenderListener != null && this.mContext != null) {
            iWXRenderListener.onRenderSuccess(this, i, i2);
            if (this.mUserTrackAdapter != null) {
                com.taobao.weex.common.WXPerformance wXPerformance = new com.taobao.weex.common.WXPerformance(this.mInstanceId);
                wXPerformance.errCode = com.taobao.weex.common.WXErrorCode.WX_SUCCESS.getErrorCode();
                wXPerformance.args = getBundleUrl();
                this.mUserTrackAdapter.commit(this.mContext, null, com.taobao.weex.adapter.IWXUserTrackAdapter.JS_BRIDGE, wXPerformance, getUserTrackParams());
            }
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d(com.taobao.weex.utils.WXLogUtils.WEEX_PERF_TAG, this.mWXPerformance.toString());
            }
        }
        if (com.taobao.weex.WXEnvironment.isPerf()) {
            com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.WEEX_PERF_TAG, this.mWXPerformance.getPerfData());
        }
    }

    public void onRefreshSuccess(int i, int i2) {
        com.taobao.weex.IWXRenderListener iWXRenderListener = this.mRenderListener;
        if (iWXRenderListener == null || this.mContext == null) {
            return;
        }
        iWXRenderListener.onRefreshSuccess(this, i, i2);
    }

    public void onChangeElement(com.taobao.weex.ui.component.WXComponent wXComponent, boolean z) {
        if (isDestroy() || this.mRenderContainer == null || this.mWXPerformance == null || wXComponent == null || wXComponent.isIgnoreInteraction || this.mRenderContainer.hasConsumeEvent()) {
            return;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (!this.mHasCreateFinish || jCurrentTimeMillis - this.mWXPerformance.renderTimeOrigin <= 8000) {
            if (wXComponent.mIsAddElementToTree) {
                getWXPerformance().localInteractionViewAddCount++;
                if (!z) {
                    getWXPerformance().interactionViewAddLimitCount++;
                }
                wXComponent.mIsAddElementToTree = false;
            }
            if (z) {
                return;
            }
            this.mApmForInstance.arriveInteraction(wXComponent);
        }
    }

    public void onRenderError(final java.lang.String str, final java.lang.String str2) {
        if (this.mRenderListener == null || this.mContext == null) {
            return;
        }
        com.taobao.weex.utils.WXLogUtils.e("onRenderError " + str + "," + str2);
        runOnUiThread(new java.lang.Runnable() { // from class: com.taobao.weex.WXSDKInstance.5
            @Override // java.lang.Runnable
            public void run() {
                if (com.taobao.weex.WXSDKInstance.this.mRenderListener == null || com.taobao.weex.WXSDKInstance.this.mContext == null) {
                    return;
                }
                com.taobao.weex.WXSDKInstance.this.mRenderListener.onException(com.taobao.weex.WXSDKInstance.this, str, str2);
            }
        });
    }

    public void onJSException(final java.lang.String str, final java.lang.String str2, final java.lang.String str3) {
        this.hasException = true;
        if (this.mRenderListener == null || this.mContext == null) {
            return;
        }
        com.taobao.weex.utils.WXLogUtils.e("onJSException " + str + "," + str3);
        runOnUiThread(new java.lang.Runnable() { // from class: com.taobao.weex.WXSDKInstance.6
            @Override // java.lang.Runnable
            public void run() {
                if (!str.equals(com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_VALIDAPPKEY.getErrorCode())) {
                    if (com.taobao.weex.WXSDKInstance.this.mRenderListener == null || com.taobao.weex.WXSDKInstance.this.mContext == null) {
                        return;
                    }
                    com.taobao.weex.WXSDKInstance.this.mRenderListener.onException(com.taobao.weex.WXSDKInstance.this, str, str2 + str3);
                    return;
                }
                if (com.taobao.weex.WXSDKInstance.this.mContext instanceof android.app.Activity) {
                    io.dcloud.common.util.ErrorDialogUtil.checkAppKeyErrorTips((android.app.Activity) com.taobao.weex.WXSDKInstance.this.mContext);
                }
            }
        });
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        onLayoutChange(view);
    }

    public void firstScreenCreateInstanceTime(long j) {
        if (this.mCreateInstance) {
            this.mWXPerformance.firstScreenJSFExecuteTime = j - this.mRenderStartTime;
            this.mCreateInstance = false;
        }
    }

    public void callJsTime(long j) {
        if (this.mEnd) {
            return;
        }
        this.mWXPerformance.fsCallJsTotalTime += j;
        this.mWXPerformance.fsCallJsTotalNum++;
    }

    public void onComponentCreate(com.taobao.weex.ui.component.WXComponent wXComponent, long j) {
        this.mWXPerformance.mActionAddElementCount++;
        com.taobao.weex.common.WXPerformance wXPerformance = this.mWXPerformance;
        wXPerformance.mActionAddElementSumTime = (int) (((long) wXPerformance.mActionAddElementSumTime) + j);
        if (!this.mEnd) {
            com.taobao.weex.common.WXPerformance wXPerformance2 = this.mWXPerformance;
            wXPerformance2.fsComponentCreateTime = (int) (((long) wXPerformance2.fsComponentCreateTime) + j);
            this.mWXPerformance.fsComponentCount++;
        }
        this.mWXPerformance.componentCount++;
        this.mWXPerformance.componentCreateTime += j;
    }

    public void callActionAddElementTime(long j) {
        com.taobao.weex.common.WXPerformance wXPerformance = this.mWXPerformance;
        wXPerformance.mActionAddElementSumTime = (int) (((long) wXPerformance.mActionAddElementSumTime) + j);
    }

    public void onOldFsRenderTimeLogic() {
        if (this.mEnd) {
            return;
        }
        this.mEnd = true;
        if (this.mStatisticsListener != null && this.mContext != null) {
            runOnUiThread(new java.lang.Runnable() { // from class: com.taobao.weex.WXSDKInstance.7
                @Override // java.lang.Runnable
                public void run() {
                    if (com.taobao.weex.WXSDKInstance.this.mStatisticsListener == null || com.taobao.weex.WXSDKInstance.this.mContext == null) {
                        return;
                    }
                    com.taobao.weex.utils.Trace.beginSection("onFirstScreen");
                    com.taobao.weex.WXSDKInstance.this.mStatisticsListener.onFirstScreen();
                    com.taobao.weex.utils.Trace.endSection();
                }
            });
        }
        this.mApmForInstance.arriveFSRenderTime();
        this.mWXPerformance.fsRenderTime = java.lang.System.currentTimeMillis();
        this.mWXPerformance.screenRenderTime = java.lang.System.currentTimeMillis() - this.mRenderStartTime;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public com.taobao.weex.WXSDKInstance getParentInstance() {
        return this.mParentInstance;
    }

    public void setParentInstance(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        this.mParentInstance = wXSDKInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void destroyView(android.view.View view) {
        try {
            if (view instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    destroyView(viewGroup.getChildAt(i));
                }
                viewGroup.removeViews(0, ((android.view.ViewGroup) view).getChildCount());
                com.taobao.weex.utils.WXReflectionUtils.setValue(view, "mChildrenCount", 0);
            }
            if (view instanceof com.taobao.weex.common.Destroyable) {
                ((com.taobao.weex.common.Destroyable) view).destroy();
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("WXSDKInstance destroyView Exception: ", e);
        }
    }

    public synchronized void destroy() {
        if (!isDestroy()) {
            if (this.mParentInstance != null) {
                this.mParentInstance = null;
            }
            this.mApmForInstance.onEnd();
            if (this.mRendered) {
                com.taobao.weex.WXSDKManager.getInstance().destroyInstance(this.mInstanceId);
            }
            if (this.mGlobalEventReceiver != null) {
                getContext().unregisterReceiver(this.mGlobalEventReceiver);
                this.mGlobalEventReceiver = null;
            }
            com.taobao.weex.ui.component.WXComponent wXComponent = this.mRootComp;
            if (wXComponent != null) {
                wXComponent.destroy();
                this.mRootComp = null;
            }
            com.taobao.weex.render.WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
            if (wXAbstractRenderContainer != null) {
                destroyView(wXAbstractRenderContainer);
            }
            java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> map = this.mGlobalEvents;
            if (map != null) {
                map.clear();
            }
            if (this.mComponentObserver != null) {
                this.mComponentObserver = null;
            }
            java.util.List<java.lang.String> list = this.mLayerOverFlowListeners;
            if (list != null) {
                list.clear();
            }
            getFlatUIContext().destroy();
            this.mFlatGUIContext = null;
            this.mInstanceOnFireEventInterceptorList = null;
            this.mWXScrollListeners = null;
            this.mWXActionbarHandlers = null;
            this.mWXBackPressedHandlers = null;
            this.mRenderContainer = null;
            this.mNestedInstanceInterceptor = null;
            this.mUserTrackAdapter = null;
            this.mScrollView = null;
            this.mContext = null;
            this.mRenderListener = null;
            this.isDestroy = true;
            this.mStatisticsListener = null;
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> map2 = this.responseHeaders;
            if (map2 != null) {
                map2.clear();
            }
            if (this.templateRef != null) {
                this.templateRef = null;
            }
            java.util.Map<java.lang.Long, com.taobao.weex.layout.ContentBoxMeasurement> map3 = this.mContentBoxMeasurements;
            if (map3 != null) {
                map3.clear();
            }
            this.mWXPerformance.afterInstanceDestroy(this.mInstanceId);
            com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.taobao.weex.WXSDKInstance.8
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.bridge.WXBridgeManager.getInstance().onInstanceClose(com.taobao.weex.WXSDKInstance.this.getInstanceId());
                    com.taobao.weex.WXSDKInstance.this.inactiveAddElementAction.clear();
                }
            });
            com.taobao.weex.bridge.WXBridgeManager.getInstance().postDelay(new java.lang.Runnable() { // from class: com.taobao.weex.WXSDKInstance.9
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().remove(com.taobao.weex.WXSDKInstance.this.mInstanceId);
                }
            }, 1000L);
        }
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public boolean isDestroy() {
        return this.isDestroy;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public java.lang.String getBundleUrl() {
        return this.mBundleUrl;
    }

    public java.lang.String getUniPagePath() {
        return this.mUniPagePath;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public android.view.View getRootView() {
        com.taobao.weex.ui.component.WXComponent wXComponent = this.mRootComp;
        if (wXComponent == null) {
            return null;
        }
        return wXComponent.getRealView();
    }

    public android.view.View getContainerView() {
        return this.mRenderContainer;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    @java.lang.Deprecated
    public void setBundleUrl(java.lang.String str) {
        this.mBundleUrl = str;
        if (com.taobao.weex.WXSDKManager.getInstance().getValidateProcessor() != null) {
            this.mNeedValidate = com.taobao.weex.WXSDKManager.getInstance().getValidateProcessor().needValidate(this.mBundleUrl);
        }
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void setUniPagePath(java.lang.String str) {
        this.mUniPagePath = str;
    }

    public void onRootCreated(com.taobao.weex.ui.component.WXComponent wXComponent) {
        this.mRootComp = wXComponent;
        wXComponent.mDeepInComponentTree = 1;
        this.mRenderContainer.addView(wXComponent.getHostView());
        setSize(this.mRenderContainer.getWidth(), this.mRenderContainer.getHeight());
    }

    public void moveFixedView(android.view.View view) {
        if (this.mRenderContainer != null) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (viewGroup != this.mRenderContainer) {
                    viewGroup.removeView(view);
                    this.mRenderContainer.addView(view);
                    return;
                }
                return;
            }
            this.mRenderContainer.addView(view);
        }
    }

    public void removeFixedView(android.view.View view) {
        com.taobao.weex.render.WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
        if (wXAbstractRenderContainer != null) {
            wXAbstractRenderContainer.removeView(view);
        }
    }

    public int getRenderContainerPaddingLeft() {
        com.taobao.weex.render.WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
        if (wXAbstractRenderContainer != null) {
            return wXAbstractRenderContainer.getPaddingLeft();
        }
        return 0;
    }

    public int getRenderContainerPaddingRight() {
        com.taobao.weex.render.WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
        if (wXAbstractRenderContainer != null) {
            return wXAbstractRenderContainer.getPaddingRight();
        }
        return 0;
    }

    public int getRenderContainerPaddingTop() {
        com.taobao.weex.render.WXAbstractRenderContainer wXAbstractRenderContainer = this.mRenderContainer;
        if (wXAbstractRenderContainer != null) {
            return wXAbstractRenderContainer.getPaddingTop();
        }
        return 0;
    }

    public synchronized java.util.List<com.taobao.weex.common.OnWXScrollListener> getWXScrollListeners() {
        return this.mWXScrollListeners;
    }

    public synchronized void registerOnWXScrollListener(com.taobao.weex.common.OnWXScrollListener onWXScrollListener) {
        if (this.mWXScrollListeners == null) {
            this.mWXScrollListeners = new java.util.ArrayList();
        }
        this.mWXScrollListeners.add(onWXScrollListener);
    }

    public synchronized void registerActionbarHandler(com.taobao.weex.WXSDKInstance.ActionBarHandler actionBarHandler) {
        if (actionBarHandler == null) {
            return;
        }
        if (this.mWXActionbarHandlers == null) {
            this.mWXActionbarHandlers = new java.util.ArrayList();
        }
        this.mWXActionbarHandlers.add(actionBarHandler);
    }

    public synchronized void unRegisterActionbarHandler(com.taobao.weex.WXSDKInstance.ActionBarHandler actionBarHandler) {
        java.util.List<com.taobao.weex.WXSDKInstance.ActionBarHandler> list = this.mWXActionbarHandlers;
        if (list != null && actionBarHandler != null) {
            list.remove(actionBarHandler);
        }
    }

    public synchronized void registerBackPressedHandler(com.taobao.weex.WXSDKInstance.OnBackPressedHandler onBackPressedHandler) {
        if (onBackPressedHandler == null) {
            return;
        }
        if (this.mWXBackPressedHandlers == null) {
            this.mWXBackPressedHandlers = new java.util.ArrayList();
        }
        this.mWXBackPressedHandlers.add(onBackPressedHandler);
    }

    public synchronized void unRegisterBackPressedHandler(com.taobao.weex.WXSDKInstance.OnBackPressedHandler onBackPressedHandler) {
        java.util.List<com.taobao.weex.WXSDKInstance.OnBackPressedHandler> list = this.mWXBackPressedHandlers;
        if (list != null && onBackPressedHandler != null) {
            list.remove(onBackPressedHandler);
        }
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void setSize(int i, int i2) {
        if (i > 0) {
            if ((!(i2 > 0) || !(!this.isDestroy)) || !this.mRendered || this.mRenderContainer == null) {
                return;
            }
            if (sScreenHeight < 0) {
                sScreenHeight = com.taobao.weex.utils.WXViewUtils.getScreenHeight(getContext());
            }
            int i3 = sScreenHeight;
            if (i3 > 0) {
                double d = (((double) i2) / ((double) i3)) * 100.0d;
                getApmForInstance().addStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_BODY_RATIO, d <= 100.0d ? d : 100.0d);
            }
            android.view.ViewGroup.LayoutParams layoutParams = this.mRenderContainer.getLayoutParams();
            if (layoutParams != null) {
                final float f = i;
                final float f2 = i2;
                com.taobao.weex.utils.WXViewUtils.getScreenDensity(this.mContext);
                if (this.mRenderContainer.getWidth() != i || this.mRenderContainer.getHeight() != i2) {
                    layoutParams.width = i;
                    layoutParams.height = i2;
                    this.mRenderContainer.setLayoutParams(layoutParams);
                }
                if (this.mRootComp == null || layoutParams == null) {
                    return;
                }
                final boolean z = layoutParams.width == -2;
                final boolean z2 = layoutParams.height == -2;
                com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.taobao.weex.WXSDKInstance.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.taobao.weex.WXSDKInstance.this.mOnSizeListener != null) {
                            com.taobao.weex.WXSDKInstance.this.mOnSizeListener.onSizeChanged(com.taobao.weex.WXSDKInstance.this.getInstanceId(), f, f2, z, z2);
                        } else {
                            com.taobao.weex.bridge.WXBridgeManager.getInstance().setDefaultRootSize(com.taobao.weex.WXSDKInstance.this.getInstanceId(), f, f2, z, z2);
                        }
                    }
                });
            }
        }
    }

    public void setWXInstanceContainerOnSizeListener(com.taobao.weex.IWXInstanceContainerOnSizeListener iWXInstanceContainerOnSizeListener) {
        this.mOnSizeListener = iWXInstanceContainerOnSizeListener;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void fireGlobalEventCallback(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.util.List<java.lang.String> list = this.mGlobalEvents.get(str);
        if (list != null) {
            java.util.Iterator<java.lang.String> it = list.iterator();
            while (it.hasNext()) {
                com.taobao.weex.WXSDKManager.getInstance().callback(this.mInstanceId, it.next(), map, true);
            }
        }
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void fireEvent(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, java.util.List<java.lang.Object> list) {
        fireEvent(str, str2, map, map2, list, null);
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void fireEvent(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, java.util.List<java.lang.Object> list, com.taobao.weex.bridge.EventResult eventResult) {
        onInterceptInstanceEvent(getInstanceId(), str, str2, map, map2);
        com.taobao.weex.common.WXPerformance wXPerformance = this.mWXPerformance;
        if (wXPerformance != null && wXPerformance.fsCallEventTotalNum < Integer.MAX_VALUE) {
            this.mWXPerformance.fsCallEventTotalNum++;
        }
        this.mApmForInstance.updateFSDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_FS_CALL_EVENT_NUM, 1.0d);
        com.taobao.weex.bridge.WXBridgeManager.getInstance().fireEventOnNode(getInstanceId(), str, str2, map, map2, list, eventResult);
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void fireEvent(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        fireEvent(str, str2, map, map2, null);
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void fireEvent(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map) {
        fireEvent(str, str2, map, null);
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void fireEvent(java.lang.String str, java.lang.String str2) {
        fireEvent(str, str2, new java.util.HashMap());
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void addEventListener(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        java.util.List<java.lang.String> arrayList = this.mGlobalEvents.get(str);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
            this.mGlobalEvents.put(str, arrayList);
        }
        arrayList.add(str2);
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void removeEventListener(java.lang.String str, java.lang.String str2) {
        java.util.List<java.lang.String> list;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || (list = this.mGlobalEvents.get(str)) == null) {
            return;
        }
        list.remove(str2);
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void removeEventListener(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.mGlobalEvents.remove(str);
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void fireModuleEvent(java.lang.String str, com.taobao.weex.common.WXModule wXModule, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (android.text.TextUtils.isEmpty(str) || wXModule == null) {
            return;
        }
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put("type", str);
        map2.put("module", wXModule.getModuleName());
        map2.put("data", map);
        java.util.List<java.lang.String> eventCallbacks = wXModule.getEventCallbacks(str);
        if (eventCallbacks != null) {
            for (java.lang.String str2 : eventCallbacks) {
                com.taobao.weex.bridge.SimpleJSCallback simpleJSCallback = new com.taobao.weex.bridge.SimpleJSCallback(this.mInstanceId, str2);
                if (wXModule.isOnce(str2)) {
                    simpleJSCallback.invoke(map2);
                } else {
                    simpleJSCallback.invokeAndKeepAlive(map2);
                }
            }
        }
    }

    public boolean checkModuleEventRegistered(java.lang.String str, com.taobao.weex.common.WXModule wXModule) {
        java.util.List<java.lang.String> eventCallbacks;
        return (wXModule == null || (eventCallbacks = wXModule.getEventCallbacks(str)) == null || eventCallbacks.size() <= 0) ? false : true;
    }

    public com.taobao.weex.common.WXPerformance getWXPerformance() {
        return this.mWXPerformance;
    }

    public com.taobao.weex.performance.WXInstanceApm getApmForInstance() {
        return this.mApmForInstance;
    }

    public java.util.Map<java.lang.String, java.io.Serializable> getUserTrackParams() {
        return this.mUserTrackParams;
    }

    public void addUserTrackParameter(java.lang.String str, java.io.Serializable serializable) {
        if (this.mUserTrackParams == null) {
            this.mUserTrackParams = new java.util.concurrent.ConcurrentHashMap();
        }
        this.mUserTrackParams.put(str, serializable);
    }

    public void clearUserTrackParameters() {
        java.util.Map<java.lang.String, java.io.Serializable> map = this.mUserTrackParams;
        if (map != null) {
            map.clear();
        }
    }

    public void removeUserTrackParameter(java.lang.String str) {
        java.util.Map<java.lang.String, java.io.Serializable> map = this.mUserTrackParams;
        if (map != null) {
            map.remove(str);
        }
    }

    public int getMaxDeepLayer() {
        return this.mMaxDeepLayer;
    }

    public void setMaxDeepLayer(int i) {
        this.mMaxDeepLayer = i;
        this.mApmForInstance.updateMaxStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_MAX_DEEP_VIEW, i);
    }

    public void setMaxDomDeep(int i) {
        this.mApmForInstance.updateMaxStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_MAX_DEEP_DOM, i);
        com.taobao.weex.common.WXPerformance wXPerformance = this.mWXPerformance;
        if (wXPerformance != null && wXPerformance.maxDeepVDomLayer <= i) {
            this.mWXPerformance.maxDeepVDomLayer = i;
        }
    }

    public void onHttpStart() {
        if (this.mEnd) {
            return;
        }
        this.mWXPerformance.fsRequestNum++;
    }

    public java.lang.String getTemplateInfo() {
        java.lang.String template = getTemplate();
        if (template == null) {
            return " template md5 null ,httpHeader:" + com.alibaba.fastjson.JSONObject.toJSONString(this.responseHeaders);
        }
        if (android.text.TextUtils.isEmpty(template)) {
            return " template md5  length 0 ,httpHeader" + com.alibaba.fastjson.JSONObject.toJSONString(this.responseHeaders);
        }
        try {
            byte[] bytes = template.getBytes("UTF-8");
            java.lang.String strMd5 = com.taobao.weex.utils.WXFileUtils.md5(bytes);
            java.lang.String strBase64Md5 = com.taobao.weex.utils.WXFileUtils.base64Md5(bytes);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            arrayList.add(strMd5);
            arrayList2.add(strBase64Md5);
            this.responseHeaders.put("templateSourceMD5", arrayList);
            this.responseHeaders.put(SOURCE_TEMPLATE_BASE64_MD5, arrayList2);
            return " template md5 " + strMd5 + " length " + bytes.length + " base64 md5 " + strBase64Md5 + " response header " + com.alibaba.fastjson.JSONObject.toJSONString(this.responseHeaders);
        } catch (java.lang.Exception unused) {
            return "template md5 getBytes error";
        }
    }

    public boolean isContentMd5Match() {
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = this.responseHeaders;
        if (map == null) {
            return true;
        }
        java.util.List<java.lang.String> list = map.get("Content-Md5");
        if (list == null) {
            list = this.responseHeaders.get("content-md5");
        }
        if (list != null && list.size() > 0) {
            java.lang.String str = list.get(0);
            java.util.List<java.lang.String> list2 = this.responseHeaders.get(SOURCE_TEMPLATE_BASE64_MD5);
            if (list2 == null) {
                getTemplateInfo();
                list2 = this.responseHeaders.get(SOURCE_TEMPLATE_BASE64_MD5);
            }
            if (list2 != null && list2.size() != 0) {
                return str.equals(list2.get(0));
            }
        }
        return true;
    }

    public java.lang.String getTemplate() {
        java.lang.ref.WeakReference<java.lang.String> weakReference = this.templateRef;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void setTemplate(java.lang.String str) {
        this.templateRef = new java.lang.ref.WeakReference<>(str);
    }

    public void OnVSync() {
        if (com.taobao.weex.bridge.WXBridgeManager.getInstance().notifyLayout(getInstanceId())) {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.taobao.weex.WXSDKInstance.11
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.bridge.WXBridgeManager.getInstance().forceLayout(com.taobao.weex.WXSDKInstance.this.getInstanceId());
                }
            });
        }
    }

    public void addContentBoxMeasurement(long j, com.taobao.weex.layout.ContentBoxMeasurement contentBoxMeasurement) {
        this.mContentBoxMeasurements.put(java.lang.Long.valueOf(j), contentBoxMeasurement);
    }

    public com.taobao.weex.layout.ContentBoxMeasurement getContentBoxMeasurement(long j) {
        return this.mContentBoxMeasurements.get(java.lang.Long.valueOf(j));
    }

    private void onInterceptInstanceEvent(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        java.util.List<com.taobao.weex.instance.InstanceOnFireEventInterceptor> list = this.mInstanceOnFireEventInterceptorList;
        if (list == null) {
            return;
        }
        java.util.Iterator<com.taobao.weex.instance.InstanceOnFireEventInterceptor> it = list.iterator();
        while (it.hasNext()) {
            it.next().onInterceptFireEvent(str, str2, str3, map, map2);
        }
    }

    public java.util.List<com.taobao.weex.instance.InstanceOnFireEventInterceptor> getInstanceOnFireEventInterceptorList() {
        if (this.mInstanceOnFireEventInterceptorList == null) {
            this.mInstanceOnFireEventInterceptorList = new java.util.ArrayList();
        }
        return this.mInstanceOnFireEventInterceptorList;
    }

    public void addInstanceOnFireEventInterceptor(com.taobao.weex.instance.InstanceOnFireEventInterceptor instanceOnFireEventInterceptor) {
        if (instanceOnFireEventInterceptor == null || getInstanceOnFireEventInterceptorList().contains(instanceOnFireEventInterceptor)) {
            return;
        }
        getInstanceOnFireEventInterceptorList().add(instanceOnFireEventInterceptor);
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public java.lang.String getRenderType() {
        return this.mRenderType;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void setRenderType(java.lang.String str) {
        this.mRenderType = str;
    }

    private static boolean isDisableSkipFrameworkInDataRender() {
        com.taobao.weex.adapter.IWXConfigAdapter wxConfigAdapter = com.taobao.weex.WXSDKManager.getInstance().getWxConfigAdapter();
        if (wxConfigAdapter == null) {
            return false;
        }
        return io.dcloud.common.constant.AbsoluteConst.TRUE.equals(wxConfigAdapter.getConfig("wxeagle", "disable_skip_framework_init", io.dcloud.common.constant.AbsoluteConst.FALSE));
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public int getDefaultFontSize() {
        return this.mDefaultFontSize;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void setDefaultFontSize(int i) {
        this.mDefaultFontSize = i;
    }

    public void addFrameViewEventListener(com.taobao.weex.WXSDKInstance.FrameViewEventListener frameViewEventListener) {
        if (this.frameViewEventListeners.contains(frameViewEventListener)) {
            return;
        }
        this.frameViewEventListeners.add(frameViewEventListener);
    }

    public synchronized void removeFrameViewEventListener(com.taobao.weex.WXSDKInstance.FrameViewEventListener frameViewEventListener) {
        if (this.frameViewEventListeners.contains(frameViewEventListener)) {
            this.frameViewEventListeners.remove(frameViewEventListener);
        }
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public boolean isFrameViewShow() {
        return this.isFrameShow;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public synchronized void onShowAnimationEnd() {
        this.isFrameShow = true;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(this.frameViewEventListeners);
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.taobao.weex.WXSDKInstance.FrameViewEventListener) it.next()).onShowAnimationEnd();
        }
        arrayList.clear();
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public boolean isImmersive() {
        return this.isImmersive;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public void setImmersive(boolean z) {
        this.isImmersive = z;
    }

    public void setonSizeChangedRnder(boolean z) {
        this.isOnSizeChangedRender = z;
    }

    public boolean isOnSizeChangedRender() {
        return this.isOnSizeChangedRender;
    }

    @Override // io.dcloud.feature.uniapp.AbsSDKInstance
    public android.content.Context getOriginalContext() {
        return this.mOriginalContext;
    }
}
