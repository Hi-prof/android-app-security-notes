package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
public abstract class WXComponent<T extends android.view.View> extends com.taobao.weex.ui.component.basic.WXBasicComponent<T> implements com.taobao.weex.common.IWXObject, com.taobao.weex.IWXActivityStateListener, com.taobao.weex.ui.component.pesudo.OnActivePseudoListner {
    public static final java.lang.String PROP_FIXED_SIZE = "fixedSize";
    public static final java.lang.String PROP_FS_MATCH_PARENT = "m";
    public static final java.lang.String PROP_FS_WRAP_CONTENT = "w";
    public static final java.lang.String ROOT = "_root";
    public static final int STATE_ALL_FINISH = 2;
    public static final int STATE_DOM_FINISH = 0;
    public static final int STATE_UI_FINISH = 1;
    public static final java.lang.String TYPE = "type";
    public static final int TYPE_COMMON = 0;
    public static final int TYPE_VIRTUAL = 1;
    private int[] EMPTY_STATE_SET;
    private int[] ENABLED_STATE_SET;
    private int[] FOCUSED_ENABLED_STATE_SET;
    private long PRESSED_ANIM_DELAY;
    private long PRESSED_ANIM_DURATION;
    private int[] PRESSED_ENABLED_STATE_SET;
    private java.util.concurrent.ConcurrentLinkedQueue<android.util.Pair<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>>> animations;
    protected com.taobao.weex.layout.ContentBoxMeasurement contentBoxMeasurement;
    public int interactionAbsoluteX;
    public int interactionAbsoluteY;
    public boolean isIgnoreInteraction;
    private boolean isLastLayoutDirectionRTL;
    private boolean isPreventGesture;
    private boolean isUsing;
    private int mAbsoluteX;
    private int mAbsoluteY;
    private io.dcloud.feature.uniapp.ui.AbsAnimationHolder mAnimationHolder;
    private java.util.Set<java.lang.String> mAppendEvents;
    private com.taobao.weex.ui.view.border.BorderDrawable mBackgroundDrawable;
    private io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData mBoxShadowData;
    private io.dcloud.feature.uniapp.ui.shadow.UniNormalBoxShadowDrawable mBoxShadowDrawable;
    private com.taobao.weex.ui.component.WXComponent<T>.OnClickListenerImp mClickEventListener;
    private android.content.Context mContext;
    public int mDeepInComponentTree;
    private float mElevation;
    private int mFixedProp;
    private java.util.List<com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener> mFocusChangeListeners;
    protected com.taobao.weex.ui.view.gesture.WXGesture mGesture;
    private java.util.Set<java.lang.String> mGestureType;
    private boolean mHasAddFocusListener;
    private com.taobao.weex.ui.IFComponentHolder mHolder;
    T mHost;
    private java.util.List<com.taobao.weex.ui.component.WXComponent.OnClickListener> mHostClickListeners;
    private io.dcloud.weex.ViewHover mHover;
    private io.dcloud.feature.uniapp.ui.shadow.UniInsetBoxShadowLayer mInsetBoxShadowDrawable;
    private com.taobao.weex.WXSDKInstance mInstance;
    public boolean mIsAddElementToTree;
    private boolean mIsDestroyed;
    private boolean mIsDisabled;
    private java.lang.String mLastBoxShadowId;
    private boolean mLazy;
    private boolean mNeedLayoutOnAnimation;
    private volatile com.taobao.weex.ui.component.WXVContainer mParent;
    private java.util.concurrent.ConcurrentLinkedQueue<io.dcloud.feature.uniapp.ui.action.UniMethodData> mPendingComponetMethodQueue;
    private com.taobao.weex.ui.component.pesudo.PesudoStatus mPesudoStatus;
    private int mPreRealHeight;
    private int mPreRealLeft;
    private int mPreRealRight;
    private int mPreRealTop;
    private int mPreRealWidth;
    private com.taobao.weex.ui.action.GraphicSize mPseudoResetGraphicSize;
    private android.graphics.drawable.Drawable mRippleBackground;
    private int mStickyOffset;
    public com.taobao.weex.tracing.WXTracing.TraceInfo mTraceInfo;
    private com.taobao.weex.dom.transition.WXTransition mTransition;
    private int mType;
    private java.lang.String mViewTreeKey;
    private boolean waste;

    public static class MeasureOutput {
        public int height;
        public int width;
    }

    public interface OnClickListener {
        void onHostViewClick();
    }

    public interface OnFocusChangeListener {
        void onFocusChange(boolean z);
    }

    @java.lang.annotation.Target({java.lang.annotation.ElementType.PARAMETER})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface RenderState {
    }

    protected void appendEventToDOM(java.lang.String str) {
    }

    public int getLayoutTopOffsetForSibling() {
        return 0;
    }

    protected T initComponentHostView(android.content.Context context) {
        return null;
    }

    protected void layoutDirectionDidChanged(boolean z) {
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public boolean onActivityBack() {
        return false;
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityCreate() {
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityPause() {
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityResume() {
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityStart() {
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityStop() {
    }

    protected void onCreate() {
    }

    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        return false;
    }

    protected void onInvokeUnknownMethod(java.lang.String str, com.alibaba.fastjson.JSONArray jSONArray) {
    }

    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
    }

    public void refreshData(com.taobao.weex.ui.component.WXComponent wXComponent) {
    }

    @java.lang.Deprecated
    public void registerActivityStateListener() {
    }

    public void removeVirtualComponent() {
    }

    @java.lang.Deprecated
    public WXComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    @java.lang.Deprecated
    public WXComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    public WXComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, 0, basicComponentData);
    }

    public WXComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, int i, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(basicComponentData);
        this.mFixedProp = 0;
        this.mAbsoluteY = 0;
        this.mAbsoluteX = 0;
        this.isLastLayoutDirectionRTL = false;
        this.mPreRealWidth = 0;
        this.mPreRealHeight = 0;
        this.mPreRealLeft = 0;
        this.mPreRealRight = 0;
        this.mPreRealTop = 0;
        this.mStickyOffset = 0;
        this.isUsing = false;
        this.mIsDestroyed = false;
        this.mIsDisabled = false;
        this.mType = 0;
        this.mNeedLayoutOnAnimation = false;
        this.mDeepInComponentTree = 0;
        this.mIsAddElementToTree = false;
        this.interactionAbsoluteX = 0;
        this.interactionAbsoluteY = 0;
        this.mHasAddFocusListener = false;
        this.mTraceInfo = new com.taobao.weex.tracing.WXTracing.TraceInfo();
        this.waste = false;
        this.isIgnoreInteraction = false;
        this.mPendingComponetMethodQueue = new java.util.concurrent.ConcurrentLinkedQueue<>();
        this.PRESSED_ANIM_DURATION = 100L;
        this.PRESSED_ANIM_DELAY = 100L;
        this.ENABLED_STATE_SET = new int[]{android.R.attr.state_enabled};
        this.EMPTY_STATE_SET = new int[0];
        this.PRESSED_ENABLED_STATE_SET = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        this.FOCUSED_ENABLED_STATE_SET = new int[]{android.R.attr.state_focused, android.R.attr.state_enabled};
        this.mElevation = 0.0f;
        this.mLazy = false;
        this.isPreventGesture = false;
        this.mInstance = wXSDKInstance;
        this.mContext = wXSDKInstance.getContext();
        this.mParent = wXVContainer;
        this.mType = i;
        if (wXSDKInstance != null) {
            setViewPortWidth(wXSDKInstance.getInstanceViewPortWidthWithFloat());
        }
        onCreate();
        com.taobao.weex.ComponentObserver componentObserver = getInstance().getComponentObserver();
        if (componentObserver != null) {
            componentObserver.onCreate(this);
        }
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    protected final void bindComponent(io.dcloud.feature.uniapp.ui.component.AbsBasicComponent absBasicComponent) {
        super.bindComponent(absBasicComponent);
        if (getInstance() != null) {
            setViewPortWidth(getInstance().getInstanceViewPortWidthWithFloat());
        }
        com.taobao.weex.ui.component.WXComponent wXComponent = (com.taobao.weex.ui.component.WXComponent) absBasicComponent;
        this.mParent = wXComponent.getParent();
        this.mType = wXComponent.getType();
    }

    protected void setContentBoxMeasurement(com.taobao.weex.layout.ContentBoxMeasurement contentBoxMeasurement) {
        this.contentBoxMeasurement = contentBoxMeasurement;
        this.mInstance.addContentBoxMeasurement(getRenderObjectPtr(), contentBoxMeasurement);
        com.taobao.weex.bridge.WXBridgeManager.getInstance().bindMeasurementToRenderObject(getRenderObjectPtr());
    }

    public void setMarginsSupportRTL(android.view.ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        marginLayoutParams.setMargins(i, i2, i3, i4);
        if (marginLayoutParams instanceof android.widget.FrameLayout.LayoutParams) {
            ((android.widget.FrameLayout.LayoutParams) marginLayoutParams).gravity = 51;
        }
    }

    public void updateStyles(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (wXComponent != null) {
            updateProperties(wXComponent.getStyles());
            applyBorder(wXComponent);
        }
    }

    public void updateStyles(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map != null) {
            updateProperties(map);
            applyBorder(this);
        }
    }

    public void updateAttrs(io.dcloud.feature.uniapp.ui.component.AbsBasicComponent absBasicComponent) {
        if (absBasicComponent != null) {
            updateProperties(absBasicComponent.getAttrs());
        }
    }

    public void updateAttrs(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map != null) {
            updateProperties(map);
        }
    }

    private void applyBorder(io.dcloud.feature.uniapp.ui.component.AbsBasicComponent absBasicComponent) {
        io.dcloud.feature.uniapp.dom.AbsCSSShorthand border = absBasicComponent.getBorder();
        float f = border.get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT);
        float f2 = border.get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP);
        float f3 = border.get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT);
        float f4 = border.get(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM);
        if (this.mHost == null) {
            return;
        }
        setBorderWidth(com.taobao.weex.common.Constants.Name.BORDER_LEFT_WIDTH, f);
        setBorderWidth(com.taobao.weex.common.Constants.Name.BORDER_TOP_WIDTH, f2);
        setBorderWidth(com.taobao.weex.common.Constants.Name.BORDER_RIGHT_WIDTH, f3);
        setBorderWidth(com.taobao.weex.common.Constants.Name.BORDER_BOTTOM_WIDTH, f4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPadding(io.dcloud.feature.uniapp.dom.AbsCSSShorthand absCSSShorthand, io.dcloud.feature.uniapp.dom.AbsCSSShorthand absCSSShorthand2) {
        int i = (int) (absCSSShorthand.get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT) + absCSSShorthand2.get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT));
        int i2 = (int) (absCSSShorthand.get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP) + absCSSShorthand2.get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP));
        int i3 = (int) (absCSSShorthand.get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT) + absCSSShorthand2.get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT));
        int i4 = (int) (absCSSShorthand.get(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM) + absCSSShorthand2.get(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM));
        if (this instanceof com.taobao.weex.ui.flat.FlatComponent) {
            com.taobao.weex.ui.flat.FlatComponent flatComponent = (com.taobao.weex.ui.flat.FlatComponent) this;
            if (!flatComponent.promoteToView(true)) {
                flatComponent.getOrCreateFlatWidget().setContentBox(i, i2, i3, i4);
                return;
            }
        }
        if (this.mHost != null) {
            io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData uniBoxShadowData = this.mBoxShadowData;
            if (uniBoxShadowData != null) {
                if (uniBoxShadowData.getNormalLeft() > 0) {
                    int normalLeft = this.mBoxShadowData.getNormalLeft() / 2;
                    i += normalLeft;
                    i3 += normalLeft;
                }
                if (this.mBoxShadowData.getNormalTop() > 0) {
                    int normalTop = this.mBoxShadowData.getNormalTop() / 2;
                    i2 += normalTop;
                    i4 += normalTop;
                }
            }
            this.mHost.setPadding(i, i2, i3, i4);
        }
    }

    public void applyComponentEvents() {
        applyEvents();
    }

    private void applyEvents() {
        if (getEvents() == null || getEvents().isEmpty()) {
            return;
        }
        com.taobao.weex.dom.WXEvent events = getEvents();
        int size = events.size();
        for (int i = 0; i < size && i < events.size(); i++) {
            addEvent((java.lang.String) events.get(i));
        }
        setActiveTouchListener();
    }

    public void addEvent(java.lang.String str) {
        if (this.mAppendEvents == null) {
            this.mAppendEvents = new java.util.HashSet();
        }
        if (android.text.TextUtils.isEmpty(str) || this.mAppendEvents.contains(str)) {
            return;
        }
        android.view.KeyEvent.Callback realView = getRealView();
        if (str.equals(com.taobao.weex.common.Constants.Event.LAYEROVERFLOW)) {
            addLayerOverFlowListener(getRef());
        }
        if (str.equals(com.taobao.weex.common.Constants.Event.CLICK)) {
            if (realView == null) {
                return;
            }
            if (this.mClickEventListener == null) {
                this.mClickEventListener = new com.taobao.weex.ui.component.WXComponent.OnClickListenerImp();
            }
            addClickListener(this.mClickEventListener);
        } else if (str.equals(com.taobao.weex.common.Constants.Event.FOCUS) || str.equals(com.taobao.weex.common.Constants.Event.BLUR)) {
            if (!this.mHasAddFocusListener) {
                this.mHasAddFocusListener = true;
                addFocusChangeListener(new com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener() { // from class: com.taobao.weex.ui.component.WXComponent.1
                    @Override // com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener
                    public void onFocusChange(boolean z) {
                        java.util.HashMap map = new java.util.HashMap();
                        map.put("timeStamp", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                        com.taobao.weex.ui.component.WXComponent.this.fireEvent(z ? com.taobao.weex.common.Constants.Event.FOCUS : com.taobao.weex.common.Constants.Event.BLUR, map);
                    }
                });
            }
        } else if (!needGestureDetector(str)) {
            com.taobao.weex.ui.component.Scrollable parentScroller = getParentScroller();
            if (parentScroller == null) {
                return;
            }
            if (str.equals(com.taobao.weex.common.Constants.Event.APPEAR)) {
                parentScroller.bindAppearEvent(this);
            } else if (str.equals(com.taobao.weex.common.Constants.Event.DISAPPEAR)) {
                parentScroller.bindDisappearEvent(this);
            }
        } else {
            if (realView == null) {
                return;
            }
            if (realView instanceof com.taobao.weex.ui.view.gesture.WXGestureObservable) {
                if (this.mGesture == null) {
                    this.mGesture = new com.taobao.weex.ui.view.gesture.WXGesture(this, this.mContext);
                    this.mGesture.setPreventMoveEvent(com.taobao.weex.utils.WXUtils.getBoolean(getAttrs().get(com.taobao.weex.common.Constants.Name.PREVENT_MOVE_EVENT), false).booleanValue());
                }
                if (this.mGestureType == null) {
                    this.mGestureType = new java.util.HashSet();
                }
                if (!io.dcloud.weex.ViewHover.VIEW_HOVER_EVENT.equals(str)) {
                    this.mGestureType.add(str);
                }
                ((com.taobao.weex.ui.view.gesture.WXGestureObservable) realView).registerGestureListener(this.mGesture);
            } else {
                com.taobao.weex.utils.WXLogUtils.e(realView.getClass().getSimpleName() + " don't implement WXGestureObservable, so no gesture is supported.");
            }
        }
        this.mAppendEvents.add(str);
    }

    public void interceptFocusAndBlurEvent() {
        this.mHasAddFocusListener = true;
    }

    public void bindHolder(com.taobao.weex.ui.IFComponentHolder iFComponentHolder) {
        this.mHolder = iFComponentHolder;
    }

    public com.taobao.weex.WXSDKInstance getInstance() {
        return this.mInstance;
    }

    public android.content.Context getContext() {
        return this.mContext;
    }

    protected final com.taobao.weex.ui.component.WXComponent findComponent(java.lang.String str) {
        if (this.mInstance == null || str == null) {
            return null;
        }
        return com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(this.mInstance.getInstanceId(), str);
    }

    public java.lang.String getAttrByKey(java.lang.String str) {
        return "default";
    }

    public void postAnimation(io.dcloud.feature.uniapp.ui.AbsAnimationHolder absAnimationHolder) {
        this.mAnimationHolder = absAnimationHolder;
    }

    public boolean isFlatUIEnabled() {
        return this.mParent != null && this.mParent.isFlatUIEnabled();
    }

    private class OnClickListenerImp implements com.taobao.weex.ui.component.WXComponent.OnClickListener {
        private OnClickListenerImp() {
        }

        @Override // com.taobao.weex.ui.component.WXComponent.OnClickListener
        public void onHostViewClick() {
            java.util.HashMap mapNewHashMapWithExpectedSize = com.taobao.weex.utils.WXDataStructureUtil.newHashMapWithExpectedSize(1);
            java.util.HashMap mapNewHashMapWithExpectedSize2 = com.taobao.weex.utils.WXDataStructureUtil.newHashMapWithExpectedSize(4);
            int[] iArr = new int[2];
            com.taobao.weex.ui.component.WXComponent.this.mHost.getLocationOnScreen(iArr);
            mapNewHashMapWithExpectedSize2.put(com.taobao.weex.common.Constants.Name.X, java.lang.Float.valueOf(com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(iArr[0], com.taobao.weex.ui.component.WXComponent.this.mInstance.getInstanceViewPortWidthWithFloat())));
            mapNewHashMapWithExpectedSize2.put(com.taobao.weex.common.Constants.Name.Y, java.lang.Float.valueOf(com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(iArr[1], com.taobao.weex.ui.component.WXComponent.this.mInstance.getInstanceViewPortWidthWithFloat())));
            mapNewHashMapWithExpectedSize2.put("width", java.lang.Float.valueOf(com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(com.taobao.weex.ui.component.WXComponent.this.getLayoutWidth(), com.taobao.weex.ui.component.WXComponent.this.mInstance.getInstanceViewPortWidthWithFloat())));
            mapNewHashMapWithExpectedSize2.put("height", java.lang.Float.valueOf(com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(com.taobao.weex.ui.component.WXComponent.this.getLayoutHeight(), com.taobao.weex.ui.component.WXComponent.this.mInstance.getInstanceViewPortWidthWithFloat())));
            mapNewHashMapWithExpectedSize.put("position", mapNewHashMapWithExpectedSize2);
            com.taobao.weex.ui.component.WXComponent.this.fireEvent(com.taobao.weex.common.Constants.Event.CLICK, mapNewHashMapWithExpectedSize);
        }
    }

    public java.lang.String getInstanceId() {
        return this.mInstance.getInstanceId();
    }

    public android.graphics.Rect getComponentSize() {
        android.graphics.Rect rect = new android.graphics.Rect();
        if (this.mHost != null && this.mInstance.getContainerView() != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.mHost.getLocationOnScreen(iArr);
            this.mInstance.getContainerView().getLocationOnScreen(iArr2);
            int i = iArr[0] - iArr2[0];
            int i2 = (iArr[1] - this.mStickyOffset) - iArr2[1];
            rect.set(i, i2, ((int) getLayoutWidth()) + i, ((int) getLayoutHeight()) + i2);
        }
        return rect;
    }

    public final void invoke(java.lang.String str, com.alibaba.fastjson.JSONArray jSONArray) {
        if (getHostView() == null || getRealView() == null) {
            this.mPendingComponetMethodQueue.offer(new io.dcloud.feature.uniapp.ui.action.UniMethodData(str, jSONArray));
            return;
        }
        com.taobao.weex.bridge.Invoker methodInvoker = this.mHolder.getMethodInvoker(str);
        if (methodInvoker != null) {
            try {
                getInstance().getNativeInvokeHelper().invoke(this, methodInvoker, jSONArray);
                return;
            } catch (java.lang.Exception e) {
                com.taobao.weex.utils.WXLogUtils.e("[WXComponent] updateProperties :class:" + getClass() + "method:" + methodInvoker.toString() + " function " + com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
                return;
            }
        }
        onInvokeUnknownMethod(str, jSONArray);
    }

    public final void fireEvent(java.lang.String str) {
        fireEvent(str, null);
    }

    public final void fireEvent(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (com.taobao.weex.utils.WXUtils.getBoolean(getAttrs().get("fireEventSyn"), false).booleanValue()) {
            fireEventWait(str, map);
        } else {
            fireEvent(str, map, null, null);
        }
    }

    public final com.taobao.weex.bridge.EventResult fireEventWait(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        com.taobao.weex.bridge.EventResult eventResult = new com.taobao.weex.bridge.EventResult() { // from class: com.taobao.weex.ui.component.WXComponent.2
            @Override // com.taobao.weex.bridge.EventResult
            public void onCallback(java.lang.Object obj) {
                super.onCallback(obj);
                countDownLatch.countDown();
            }
        };
        try {
            fireEvent(str, map, null, eventResult);
            countDownLatch.await(50L, java.util.concurrent.TimeUnit.MILLISECONDS);
            return eventResult;
        } catch (java.lang.Exception e) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.e("fireEventWait", e);
            }
            return eventResult;
        }
    }

    protected final void fireEvent(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        fireEvent(str, map, map2, null);
    }

    private final void fireEvent(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.taobao.weex.bridge.EventResult eventResult) {
        java.lang.String componentId;
        if (this.mInstance != null) {
            java.util.List<java.lang.Object> list = (getEvents() == null || getEvents().getEventBindingArgsValues() == null) ? null : getEvents().getEventBindingArgsValues().get(str);
            if (map != null && (componentId = com.taobao.weex.ui.component.binding.Statements.getComponentId(this)) != null) {
                map.put("componentId", componentId);
            }
            this.mInstance.fireEvent(getRef(), str, map, map2, list, eventResult);
        }
    }

    public java.lang.Object findTypeParent(io.dcloud.feature.uniapp.ui.component.AbsBasicComponent absBasicComponent, java.lang.Class cls) {
        if (absBasicComponent.getClass() == cls) {
            return absBasicComponent;
        }
        com.taobao.weex.ui.component.WXComponent wXComponent = (com.taobao.weex.ui.component.WXComponent) absBasicComponent;
        if (wXComponent.getParent() == null) {
            return null;
        }
        findTypeParent(wXComponent.getParent(), cls);
        return null;
    }

    public boolean isLazy() {
        if (this.mLazy) {
            return true;
        }
        return this.mParent != null && this.mParent.isLazy();
    }

    protected final void addFocusChangeListener(com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener onFocusChangeListener) {
        android.view.View realView;
        if (onFocusChangeListener == null || (realView = getRealView()) == null) {
            return;
        }
        if (this.mFocusChangeListeners == null) {
            this.mFocusChangeListeners = new java.util.ArrayList();
            realView.setFocusable(true);
            realView.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: com.taobao.weex.ui.component.WXComponent.3
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(android.view.View view, boolean z) {
                    for (com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener onFocusChangeListener2 : com.taobao.weex.ui.component.WXComponent.this.mFocusChangeListeners) {
                        if (onFocusChangeListener2 != null) {
                            onFocusChangeListener2.onFocusChange(z);
                        }
                    }
                }
            });
        }
        this.mFocusChangeListeners.add(onFocusChangeListener);
    }

    protected boolean ismHasFocusChangeListener(com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener onFocusChangeListener) {
        java.util.List<com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener> list = this.mFocusChangeListeners;
        if (list != null) {
            return list.contains(onFocusChangeListener);
        }
        return false;
    }

    protected final void addClickListener(com.taobao.weex.ui.component.WXComponent.OnClickListener onClickListener) {
        android.view.View realView;
        if (onClickListener == null || (realView = getRealView()) == null) {
            return;
        }
        if (this.mHostClickListeners == null) {
            this.mHostClickListeners = new java.util.ArrayList();
        }
        if (!realView.hasOnClickListeners()) {
            realView.setClickable(true);
            realView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.taobao.weex.ui.component.WXComponent.4
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    if (com.taobao.weex.ui.component.WXComponent.this.mGesture == null || !com.taobao.weex.ui.component.WXComponent.this.mGesture.isTouchEventConsumedByAdvancedGesture()) {
                        for (com.taobao.weex.ui.component.WXComponent.OnClickListener onClickListener2 : com.taobao.weex.ui.component.WXComponent.this.mHostClickListeners) {
                            if (onClickListener2 != null) {
                                onClickListener2.onHostViewClick();
                            }
                        }
                    }
                }
            });
        }
        this.mHostClickListeners.add(onClickListener);
    }

    protected final void removeClickListener(com.taobao.weex.ui.component.WXComponent.OnClickListener onClickListener) {
        this.mHostClickListeners.remove(onClickListener);
    }

    public void bindData(com.taobao.weex.ui.component.WXComponent wXComponent) {
        bindComponentData(wXComponent);
    }

    protected void bindComponentData(io.dcloud.feature.uniapp.ui.component.AbsBasicComponent absBasicComponent) {
        if (isLazy()) {
            return;
        }
        if (absBasicComponent == null) {
            absBasicComponent = this;
        }
        com.taobao.weex.ui.component.WXComponent wXComponent = (com.taobao.weex.ui.component.WXComponent) absBasicComponent;
        bindComponent(wXComponent);
        updateStyles(wXComponent);
        updateAttrs(absBasicComponent);
        updateExtra(absBasicComponent.getExtra());
    }

    public void applyLayoutAndEvent(io.dcloud.feature.uniapp.ui.component.AbsBasicComponent absBasicComponent) {
        if (isLazy()) {
            return;
        }
        if (absBasicComponent == null) {
            absBasicComponent = this;
        }
        com.taobao.weex.ui.component.WXComponent wXComponent = (com.taobao.weex.ui.component.WXComponent) absBasicComponent;
        bindComponent(wXComponent);
        setSafeLayout(wXComponent);
        setPadding(absBasicComponent.getPadding(), absBasicComponent.getBorder());
        applyEvents();
    }

    public void setDemission(com.taobao.weex.ui.action.GraphicSize graphicSize, com.taobao.weex.ui.action.GraphicPosition graphicPosition) {
        setLayoutPosition(graphicPosition);
        setLayoutSize(graphicSize);
    }

    public void updateDemission(float f, float f2, float f3, float f4, float f5, float f6) {
        getLayoutPosition().update(f, f2, f3, f4);
        getLayoutSize().update(f6, f5);
    }

    public void applyLayoutOnly() {
        if (isLazy()) {
            return;
        }
        setSafeLayout(this);
        setPadding(getPadding(), getBorder());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @java.lang.Deprecated
    public void updateProperties(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map != null) {
            if ((this.mHost != null || isVirtualComponent()) && getInstance() != null) {
                for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map.entrySet()) {
                    java.lang.String key = entry.getKey();
                    java.lang.Object value = entry.getValue();
                    java.lang.String string = com.taobao.weex.utils.WXUtils.getString(value, null);
                    if (key == null) {
                        com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(getInstanceId(), com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_NULL_KEY, "updateProperties", com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_NULL_KEY.getErrorMsg(), null);
                    } else {
                        if (android.text.TextUtils.isEmpty(string)) {
                            value = convertEmptyProperty(key, string);
                        }
                        if (setProperty(key, value)) {
                            continue;
                        } else {
                            if (this.mHolder == null || getInstance() == null) {
                                return;
                            }
                            com.taobao.weex.bridge.Invoker propertyInvoker = this.mHolder.getPropertyInvoker(key);
                            if (propertyInvoker != null) {
                                try {
                                    java.lang.reflect.Type[] parameterTypes = propertyInvoker.getParameterTypes();
                                    if (parameterTypes.length != 1) {
                                        com.taobao.weex.utils.WXLogUtils.e("[WXComponent] setX method only one parameter：" + propertyInvoker);
                                        return;
                                    }
                                    propertyInvoker.invoke(this, com.taobao.weex.utils.WXReflectionUtils.parseArgument(parameterTypes[0], value));
                                } catch (java.lang.Exception e) {
                                    com.taobao.weex.utils.WXLogUtils.e("[WXComponent] updateProperties :class:" + getClass() + "method:" + propertyInvoker.toString() + " function " + com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                readyToRender();
                if (!(this instanceof com.taobao.weex.ui.flat.FlatComponent) || this.mBackgroundDrawable == null) {
                    return;
                }
                com.taobao.weex.ui.flat.FlatComponent flatComponent = (com.taobao.weex.ui.flat.FlatComponent) this;
                if (flatComponent.promoteToView(true) || (flatComponent.getOrCreateFlatWidget() instanceof com.taobao.weex.ui.flat.widget.AndroidViewWidget)) {
                    return;
                }
                flatComponent.getOrCreateFlatWidget().setBackgroundAndBorder(this.mBackgroundDrawable);
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        if (str != null && getInstance() != null) {
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -1989576717:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_RIGHT_COLOR)) {
                        b = 0;
                    }
                    break;
                case -1974639039:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_RIGHT_STYLE)) {
                        b = 1;
                    }
                    break;
                case -1971292586:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_RIGHT_WIDTH)) {
                        b = 2;
                    }
                    break;
                case -1501175880:
                    if (str.equals(com.taobao.weex.common.Constants.Name.PADDING_LEFT)) {
                        b = 3;
                    }
                    break;
                case -1470826662:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_TOP_COLOR)) {
                        b = 4;
                    }
                    break;
                case -1455888984:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_TOP_STYLE)) {
                        b = 5;
                    }
                    break;
                case -1452542531:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_TOP_WIDTH)) {
                        b = 6;
                    }
                    break;
                case -1383228885:
                    if (str.equals("bottom")) {
                        b = 7;
                    }
                    break;
                case -1375815020:
                    if (str.equals(com.taobao.weex.common.Constants.Name.MIN_WIDTH)) {
                        b = 8;
                    }
                    break;
                case -1308858324:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_BOTTOM_COLOR)) {
                        b = 9;
                    }
                    break;
                case -1293920646:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_BOTTOM_STYLE)) {
                        b = 10;
                    }
                    break;
                case -1290574193:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_BOTTOM_WIDTH)) {
                        b = 11;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        b = 12;
                    }
                    break;
                case -1228066334:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_TOP_LEFT_RADIUS)) {
                        b = 13;
                    }
                    break;
                case -1221029593:
                    if (str.equals("height")) {
                        b = 14;
                    }
                    break;
                case -1111969773:
                    if (str.equals(com.taobao.weex.common.Constants.Name.ARIA_HIDDEN)) {
                        b = 15;
                    }
                    break;
                case -1081309778:
                    if (str.equals("margin")) {
                        b = 16;
                    }
                    break;
                case -1063257157:
                    if (str.equals(com.taobao.weex.common.Constants.Name.ALIGN_ITEMS)) {
                        b = 17;
                    }
                    break;
                case -1044792121:
                    if (str.equals(com.taobao.weex.common.Constants.Name.MARGIN_TOP)) {
                        b = 18;
                    }
                    break;
                case -975171706:
                    if (str.equals(com.taobao.weex.common.Constants.Name.FLEX_DIRECTION)) {
                        b = 19;
                    }
                    break;
                case -906066005:
                    if (str.equals(com.taobao.weex.common.Constants.Name.MAX_HEIGHT)) {
                        b = 20;
                    }
                    break;
                case -863700117:
                    if (str.equals(com.taobao.weex.common.Constants.Name.ARIA_LABEL)) {
                        b = 21;
                    }
                    break;
                case -806339567:
                    if (str.equals("padding")) {
                        b = 22;
                    }
                    break;
                case -289173127:
                    if (str.equals(com.taobao.weex.common.Constants.Name.MARGIN_BOTTOM)) {
                        b = 23;
                    }
                    break;
                case -242276144:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_LEFT_COLOR)) {
                        b = 24;
                    }
                    break;
                case -227338466:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_LEFT_STYLE)) {
                        b = 25;
                    }
                    break;
                case -223992013:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_LEFT_WIDTH)) {
                        b = 26;
                    }
                    break;
                case -133587431:
                    if (str.equals(com.taobao.weex.common.Constants.Name.MIN_HEIGHT)) {
                        b = 27;
                    }
                    break;
                case 115029:
                    if (str.equals("top")) {
                        b = 28;
                    }
                    break;
                case 3145721:
                    if (str.equals(com.taobao.weex.common.Constants.Name.FLEX)) {
                        b = 29;
                    }
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        b = 30;
                    }
                    break;
                case 3506294:
                    if (str.equals(com.taobao.weex.common.Constants.Name.ROLE)) {
                        b = 31;
                    }
                    break;
                case 90130308:
                    if (str.equals(com.taobao.weex.common.Constants.Name.PADDING_TOP)) {
                        b = org.mozilla.universalchardet.prober.HebrewProber.SPACE;
                    }
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        b = 33;
                    }
                    break;
                case 113126854:
                    if (str.equals("width")) {
                        b = 34;
                    }
                    break;
                case 202355100:
                    if (str.equals(com.taobao.weex.common.Constants.Name.PADDING_BOTTOM)) {
                        b = 35;
                    }
                    break;
                case 270940796:
                    if (str.equals(com.taobao.weex.common.Constants.Name.DISABLED)) {
                        b = 36;
                    }
                    break;
                case 333432965:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_TOP_RIGHT_RADIUS)) {
                        b = 37;
                    }
                    break;
                case 400381634:
                    if (str.equals(com.taobao.weex.common.Constants.Name.MAX_WIDTH)) {
                        b = 38;
                    }
                    break;
                case 581268560:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_BOTTOM_LEFT_RADIUS)) {
                        b = 39;
                    }
                    break;
                case 588239831:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_BOTTOM_RIGHT_RADIUS)) {
                        b = 40;
                    }
                    break;
                case 713848971:
                    if (str.equals(com.taobao.weex.common.Constants.Name.PADDING_RIGHT)) {
                        b = 41;
                    }
                    break;
                case 717381201:
                    if (str.equals(com.taobao.weex.common.Constants.Name.PREVENT_MOVE_EVENT)) {
                        b = 42;
                    }
                    break;
                case 722830999:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_COLOR)) {
                        b = 43;
                    }
                    break;
                case 737768677:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_STYLE)) {
                        b = 44;
                    }
                    break;
                case 741115130:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_WIDTH)) {
                        b = 45;
                    }
                    break;
                case 743055051:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BOX_SHADOW)) {
                        b = 46;
                    }
                    break;
                case 747463061:
                    if (str.equals(PROP_FIXED_SIZE)) {
                        b = 47;
                    }
                    break;
                case 747804969:
                    if (str.equals("position")) {
                        b = 48;
                    }
                    break;
                case 975087886:
                    if (str.equals(com.taobao.weex.common.Constants.Name.MARGIN_RIGHT)) {
                        b = 49;
                    }
                    break;
                case 1287124693:
                    if (str.equals("backgroundColor")) {
                        b = 50;
                    }
                    break;
                case 1292595405:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE)) {
                        b = 51;
                    }
                    break;
                case 1349188574:
                    if (str.equals(com.taobao.weex.common.Constants.Name.BORDER_RADIUS)) {
                        b = 52;
                    }
                    break;
                case 1744216035:
                    if (str.equals(com.taobao.weex.common.Constants.Name.FLEX_WRAP)) {
                        b = 53;
                    }
                    break;
                case 1767100401:
                    if (str.equals(com.taobao.weex.common.Constants.Name.ALIGN_SELF)) {
                        b = 54;
                    }
                    break;
                case 1860657097:
                    if (str.equals(com.taobao.weex.common.Constants.Name.JUSTIFY_CONTENT)) {
                        b = 55;
                    }
                    break;
                case 1941332754:
                    if (str.equals(com.taobao.weex.common.Constants.Name.VISIBILITY)) {
                        b = 56;
                    }
                    break;
                case 1970934485:
                    if (str.equals(com.taobao.weex.common.Constants.Name.MARGIN_LEFT)) {
                        b = 57;
                    }
                    break;
            }
            switch (b) {
                case 0:
                case 4:
                case 9:
                case 24:
                case 43:
                    java.lang.String string = com.taobao.weex.utils.WXUtils.getString(obj, null);
                    if (string != null) {
                        setBorderColor(str, string);
                    }
                    break;
                case 1:
                case 5:
                case 10:
                case 25:
                case 44:
                    java.lang.String string2 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                    if (string2 != null) {
                        setBorderStyle(str, string2);
                    }
                    return true;
                case 12:
                    java.lang.Float f = com.taobao.weex.utils.WXUtils.getFloat(obj, java.lang.Float.valueOf(1.0f));
                    if (f != null) {
                        setOpacity(f.floatValue());
                        break;
                    }
                case 2:
                case 3:
                case 6:
                case 7:
                case 8:
                case 11:
                case 14:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 22:
                case 23:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 32:
                case 33:
                case 34:
                case 35:
                case 38:
                case 41:
                case 45:
                case 49:
                case 53:
                case 54:
                case com.alibaba.fastjson.asm.Opcodes.LSTORE /* 55 */:
                case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
                    return true;
                case 13:
                case 37:
                case 39:
                case 40:
                case 52:
                    java.lang.Float f2 = com.taobao.weex.utils.WXUtils.getFloat(obj, null);
                    if (f2 != null) {
                        setBorderRadius(str, f2.floatValue());
                    }
                    return true;
                case 15:
                    setAriaHidden(com.taobao.weex.utils.WXUtils.getBoolean(obj, false).booleanValue());
                    return true;
                case 21:
                    setAriaLabel(com.taobao.weex.utils.WXUtils.getString(obj, ""));
                    return true;
                case 31:
                    setRole(com.taobao.weex.utils.WXUtils.getString(obj, ""));
                    return true;
                case 36:
                    java.lang.Boolean bool = com.taobao.weex.utils.WXUtils.getBoolean(obj, null);
                    if (bool != null) {
                        setDisabled(bool.booleanValue());
                        setPseudoClassStatus(com.taobao.weex.common.Constants.PSEUDO.DISABLED, bool.booleanValue());
                    }
                    return true;
                case 42:
                    com.taobao.weex.ui.view.gesture.WXGesture wXGesture = this.mGesture;
                    if (wXGesture != null) {
                        wXGesture.setPreventMoveEvent(com.taobao.weex.utils.WXUtils.getBoolean(obj, false).booleanValue());
                    }
                    return true;
                case 46:
                    try {
                        getHostView();
                        break;
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                    return true;
                case 47:
                    setFixedSize(com.taobao.weex.utils.WXUtils.getString(obj, PROP_FS_MATCH_PARENT));
                    return true;
                case 48:
                    java.lang.String string3 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                    if (string3 != null) {
                        setSticky(string3);
                    }
                    return true;
                case 50:
                    java.lang.String string4 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                    if (string4 != null) {
                        setBackgroundColor(string4);
                    }
                    return true;
                case 51:
                    java.lang.String string5 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                    if (string5 != null && this.mHost != null) {
                        setBackgroundImage(string5);
                    }
                    return true;
                case 56:
                    java.lang.String string6 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                    if (string6 != null) {
                        setVisibility(string6);
                    }
                    return true;
                default:
                    return false;
            }
        }
        return true;
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.ELEVATION)
    public void setElevation(java.lang.String str) {
        initElevation(str);
    }

    protected void initElevation(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.mElevation = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(str, java.lang.Float.valueOf(0.0f)).floatValue(), this.mInstance.getInstanceViewPortWidthWithFloat());
        if (this.mBoxShadowData != null) {
            clearBoxShadow();
        }
        if (android.os.Build.VERSION.SDK_INT == 21) {
            getHostView().setElevation(this.mElevation);
            return;
        }
        android.animation.StateListAnimator stateListAnimator = new android.animation.StateListAnimator();
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.play(android.animation.ObjectAnimator.ofFloat(getHostView(), com.taobao.weex.common.Constants.Name.ELEVATION, this.mElevation).setDuration(0L)).with(android.animation.ObjectAnimator.ofFloat(getHostView(), (android.util.Property<android.view.View, java.lang.Float>) android.view.View.TRANSLATION_Z, 0.0f).setDuration(this.PRESSED_ANIM_DURATION));
        animatorSet.setInterpolator(new androidx.interpolator.view.animation.FastOutLinearInInterpolator());
        stateListAnimator.addState(this.PRESSED_ENABLED_STATE_SET, animatorSet);
        android.animation.AnimatorSet animatorSet2 = new android.animation.AnimatorSet();
        animatorSet2.play(android.animation.ObjectAnimator.ofFloat(getHostView(), com.taobao.weex.common.Constants.Name.ELEVATION, this.mElevation).setDuration(0L)).with(android.animation.ObjectAnimator.ofFloat(getHostView(), (android.util.Property<android.view.View, java.lang.Float>) android.view.View.TRANSLATION_Z, 0.0f).setDuration(this.PRESSED_ANIM_DURATION));
        animatorSet2.setInterpolator(new androidx.interpolator.view.animation.FastOutLinearInInterpolator());
        stateListAnimator.addState(this.FOCUSED_ENABLED_STATE_SET, animatorSet2);
        android.animation.AnimatorSet animatorSet3 = new android.animation.AnimatorSet();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(android.animation.ObjectAnimator.ofFloat(getHostView(), com.taobao.weex.common.Constants.Name.ELEVATION, this.mElevation).setDuration(0L));
        if (android.os.Build.VERSION.SDK_INT >= 22 && android.os.Build.VERSION.SDK_INT <= 24) {
            arrayList.add(android.animation.ObjectAnimator.ofFloat(getHostView(), (android.util.Property<android.view.View, java.lang.Float>) android.view.View.TRANSLATION_Z, getHostView().getTranslationZ()).setDuration(this.PRESSED_ANIM_DELAY));
        }
        arrayList.add(android.animation.ObjectAnimator.ofFloat(getHostView(), (android.util.Property<android.view.View, java.lang.Float>) android.view.View.TRANSLATION_Z, 0.0f).setDuration(this.PRESSED_ANIM_DURATION));
        animatorSet3.playSequentially((android.animation.Animator[]) arrayList.toArray(new android.animation.ObjectAnimator[0]));
        animatorSet3.setInterpolator(new androidx.interpolator.view.animation.FastOutLinearInInterpolator());
        stateListAnimator.addState(this.ENABLED_STATE_SET, animatorSet3);
        android.animation.AnimatorSet animatorSet4 = new android.animation.AnimatorSet();
        animatorSet4.play(android.animation.ObjectAnimator.ofFloat(getHostView(), com.taobao.weex.common.Constants.Name.ELEVATION, 0.0f).setDuration(0L)).with(android.animation.ObjectAnimator.ofFloat(getHostView(), (android.util.Property<android.view.View, java.lang.Float>) android.view.View.TRANSLATION_Z, 0.0f).setDuration(0L));
        animatorSet4.setInterpolator(new androidx.interpolator.view.animation.FastOutLinearInInterpolator());
        stateListAnimator.addState(this.EMPTY_STATE_SET, animatorSet4);
        getHostView().setStateListAnimator(stateListAnimator);
    }

    protected com.taobao.weex.ui.view.border.BorderDrawable getOrCreateBorder() {
        if (this.mBackgroundDrawable == null) {
            this.mBackgroundDrawable = new com.taobao.weex.ui.view.border.BorderDrawable();
            T t = this.mHost;
            if (t != null) {
                com.taobao.weex.utils.WXViewUtils.setBackGround(t, null, this);
                if (this.mRippleBackground == null) {
                    if (this.mBoxShadowDrawable != null) {
                        com.taobao.weex.utils.WXViewUtils.setBackGround(this.mHost, new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.mBoxShadowDrawable, this.mBackgroundDrawable}), this);
                    } else if (this.mInsetBoxShadowDrawable != null) {
                        com.taobao.weex.utils.WXViewUtils.setBackGround(this.mHost, new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.mBackgroundDrawable, this.mInsetBoxShadowDrawable}), this);
                    } else {
                        com.taobao.weex.utils.WXViewUtils.setBackGround(this.mHost, this.mBackgroundDrawable, this);
                    }
                } else if (this.mBoxShadowDrawable != null) {
                    com.taobao.weex.utils.WXViewUtils.setBackGround(this.mHost, new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.mRippleBackground, this.mBoxShadowDrawable, this.mBackgroundDrawable}), this);
                } else if (this.mInsetBoxShadowDrawable != null) {
                    com.taobao.weex.utils.WXViewUtils.setBackGround(this.mHost, new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.mRippleBackground, this.mBackgroundDrawable, this.mInsetBoxShadowDrawable}), this);
                } else {
                    com.taobao.weex.utils.WXViewUtils.setBackGround(this.mHost, new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.mRippleBackground, this.mBackgroundDrawable}), this);
                }
            }
        }
        return this.mBackgroundDrawable;
    }

    public void setSafeLayout(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (android.text.TextUtils.isEmpty(wXComponent.getComponentType()) || android.text.TextUtils.isEmpty(wXComponent.getRef()) || wXComponent.getLayoutPosition() == null || wXComponent.getLayoutSize() == null) {
            return;
        }
        setLayout(wXComponent);
    }

    public void setLayout(com.taobao.weex.ui.component.WXComponent wXComponent) {
        int top;
        int i;
        setLayoutSize(wXComponent.getLayoutSize());
        setLayoutPosition(wXComponent.getLayoutPosition());
        setPaddings(wXComponent.getPadding());
        setMargins(wXComponent.getMargin());
        setBorders(wXComponent.getBorder());
        boolean zIsLayoutRTL = wXComponent.isLayoutRTL();
        setIsLayoutRTL(zIsLayoutRTL);
        if (zIsLayoutRTL != wXComponent.isLastLayoutDirectionRTL) {
            wXComponent.isLastLayoutDirectionRTL = zIsLayoutRTL;
            layoutDirectionDidChanged(zIsLayoutRTL);
        }
        try {
            if (getLayoutSize().getWidth() != 0.0f && getLayoutSize().getHeight() != 0.0f) {
                parseAnimation();
            }
        } catch (java.lang.Exception unused) {
        }
        boolean z = this.mParent == null;
        int childrenLayoutTopOffset = z ? 0 : this.mParent.getChildrenLayoutTopOffset();
        com.taobao.weex.dom.CSSShorthand cSSShorthand = z ? new com.taobao.weex.dom.CSSShorthand() : this.mParent.getPadding();
        com.taobao.weex.dom.CSSShorthand cSSShorthand2 = z ? new com.taobao.weex.dom.CSSShorthand() : this.mParent.getBorder();
        int width = (int) getLayoutSize().getWidth();
        int height = (int) getLayoutSize().getHeight();
        if (isFixed()) {
            int left = (int) (getLayoutPosition().getLeft() - getInstance().getRenderContainerPaddingLeft());
            top = ((int) (getLayoutPosition().getTop() - getInstance().getRenderContainerPaddingTop())) + childrenLayoutTopOffset;
            i = left;
        } else {
            int left2 = (int) ((getLayoutPosition().getLeft() - cSSShorthand.get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT)) - cSSShorthand2.get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT));
            top = ((int) ((getLayoutPosition().getTop() - cSSShorthand.get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP)) - cSSShorthand2.get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP))) + childrenLayoutTopOffset;
            i = left2;
        }
        int i2 = (int) getMargin().get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT);
        int i3 = (int) getMargin().get(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM);
        android.graphics.Point point = new android.graphics.Point((int) getLayoutPosition().getLeft(), (int) getLayoutPosition().getTop());
        if (this.mPreRealWidth == width && this.mPreRealHeight == height && this.mPreRealLeft == i && this.mPreRealRight == i2 && this.mPreRealTop == top) {
            return;
        }
        if ((this instanceof com.taobao.weex.ui.component.list.WXCell) && height >= com.taobao.weex.common.WXPerformance.VIEW_LIMIT_HEIGHT && width >= com.taobao.weex.common.WXPerformance.VIEW_LIMIT_WIDTH) {
            this.mInstance.getApmForInstance().updateDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_CELL_EXCEED_NUM, 1.0d);
            this.mInstance.getWXPerformance().cellExceedNum++;
        }
        this.mAbsoluteY = (int) (z ? 0.0f : this.mParent.getAbsoluteY() + getCSSLayoutTop());
        this.mAbsoluteX = (int) (z ? 0.0f : this.mParent.getAbsoluteX() + getCSSLayoutLeft());
        T t = this.mHost;
        if (t == null) {
            return;
        }
        if (!(t instanceof android.view.ViewGroup) && this.mAbsoluteY + height > this.mInstance.getWeexHeight() + 1) {
            if (!this.mInstance.mEnd) {
                this.mInstance.onOldFsRenderTimeLogic();
            }
            if (!this.mInstance.isNewFsEnd) {
                this.mInstance.isNewFsEnd = true;
                this.mInstance.getApmForInstance().arriveNewFsRenderTime();
            }
        }
        com.taobao.weex.ui.component.WXComponent.MeasureOutput measureOutputMeasure = measure(width, height);
        setComponentLayoutParams(measureOutputMeasure.width, measureOutputMeasure.height, i, top, i2, i3, point);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0071  */
    /* JADX WARN: Multi-variable type inference failed */
    private void setComponentLayoutParams(int i, int i2, int i3, int i4, int i5, int i6, android.graphics.Point point) {
        int i7;
        int i8;
        int i9;
        int normalTop;
        com.taobao.weex.ui.flat.widget.Widget androidViewWidget;
        if (getInstance() == null || getInstance().isDestroy()) {
            return;
        }
        updateBoxShadow(i, i2, false);
        io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData uniBoxShadowData = this.mBoxShadowData;
        if (uniBoxShadowData == null || uniBoxShadowData.getNormalShadows().size() <= 0) {
            i7 = i;
            i8 = i2;
            i9 = i3;
            normalTop = i4;
        } else {
            int normalMaxWidth = this.mBoxShadowData.getNormalMaxWidth();
            int normalMaxHeight = this.mBoxShadowData.getNormalMaxHeight();
            int normalLeft = i3 - (this.mBoxShadowData.getNormalLeft() / 2);
            normalTop = i4 - (this.mBoxShadowData.getNormalTop() / 2);
            i9 = normalLeft;
            i8 = normalMaxHeight;
            i7 = normalMaxWidth;
        }
        com.taobao.weex.ui.flat.FlatGUIContext flatUIContext = getInstance().getFlatUIContext();
        if (flatUIContext != null && flatUIContext.getFlatComponentAncestor(this) != null) {
            if (this instanceof com.taobao.weex.ui.flat.FlatComponent) {
                com.taobao.weex.ui.flat.FlatComponent flatComponent = (com.taobao.weex.ui.flat.FlatComponent) this;
                if (!flatComponent.promoteToView(true)) {
                    androidViewWidget = flatComponent.getOrCreateFlatWidget();
                } else {
                    androidViewWidget = flatUIContext.getAndroidViewWidget(this);
                }
            } else {
                androidViewWidget = flatUIContext.getAndroidViewWidget(this);
            }
            int i10 = normalTop;
            com.taobao.weex.ui.flat.widget.Widget widget = androidViewWidget;
            setWidgetParams(widget, flatUIContext, point, i7, i8, i9, i5, i10, i6);
            return;
        }
        if (this.mHost != null) {
            if (isFixed()) {
                setFixedHostLayoutParams(this.mHost, i7, i8, i9, i5, normalTop, i6);
            } else {
                setHostLayoutParams(this.mHost, i7, i8, i9, i5, normalTop, i6);
            }
            recordInteraction(i, i2);
            this.mPreRealWidth = i;
            this.mPreRealHeight = i2;
            this.mPreRealLeft = i3;
            this.mPreRealRight = i5;
            this.mPreRealTop = i4;
            onFinishLayout();
        }
    }

    private void recordInteraction(int i, int i2) {
        if (this.mIsAddElementToTree) {
            this.mIsAddElementToTree = false;
            if (this.mParent == null) {
                this.interactionAbsoluteX = 0;
                this.interactionAbsoluteY = 0;
            } else {
                float cSSLayoutTop = getCSSLayoutTop();
                float cSSLayoutLeft = getCSSLayoutLeft();
                if (!isFixed()) {
                    cSSLayoutLeft += this.mParent.interactionAbsoluteX;
                }
                this.interactionAbsoluteX = (int) cSSLayoutLeft;
                if (!isFixed()) {
                    cSSLayoutTop += this.mParent.interactionAbsoluteY;
                }
                this.interactionAbsoluteY = (int) cSSLayoutTop;
            }
            if (getInstance().getApmForInstance().instanceRect == null) {
                getInstance().getApmForInstance().instanceRect = new android.graphics.Rect();
            }
            android.graphics.Rect rect = getInstance().getApmForInstance().instanceRect;
            rect.set(0, 0, this.mInstance.getWeexWidth(), this.mInstance.getWeexHeight());
            this.mInstance.onChangeElement(this, !(rect.contains(this.interactionAbsoluteX, this.interactionAbsoluteY) || rect.contains(this.interactionAbsoluteX + i, this.interactionAbsoluteY) || rect.contains(this.interactionAbsoluteX, this.interactionAbsoluteY + i2) || rect.contains(this.interactionAbsoluteX + i, this.interactionAbsoluteY + i2)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0086  */
    private void setWidgetParams(com.taobao.weex.ui.flat.widget.Widget widget, com.taobao.weex.ui.flat.FlatGUIContext flatGUIContext, android.graphics.Point point, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        android.graphics.Point point2 = new android.graphics.Point();
        if (this.mParent == null) {
            i7 = i;
            i8 = i2;
            i9 = i3;
            i10 = i4;
            i11 = i5;
            i12 = i6;
        } else {
            if ((this.mParent instanceof com.taobao.weex.ui.flat.FlatComponent) && flatGUIContext.getFlatComponentAncestor(this.mParent) != null && flatGUIContext.getAndroidViewWidget(this.mParent) == null) {
                point2.set(point.x, point.y);
                i13 = i3;
                i14 = i5;
            } else {
                i13 = i3;
                i14 = i5;
                point2.set(i13, i14);
            }
            if ((this.mParent instanceof com.taobao.weex.ui.flat.FlatComponent) && flatGUIContext.getFlatComponentAncestor(this.mParent) != null && flatGUIContext.getAndroidViewWidget(this.mParent) == null) {
                android.graphics.Point locInFlatContainer = ((com.taobao.weex.ui.flat.FlatComponent) this.mParent).getOrCreateFlatWidget().getLocInFlatContainer();
                point2.offset(locInFlatContainer.x, locInFlatContainer.y);
            }
            android.view.ViewGroup.LayoutParams childLayoutParams = this.mParent.getChildLayoutParams(this, this.mHost, i, i2, i13, i4, i14, i6);
            if (childLayoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
                int i15 = childLayoutParams.width;
                int i16 = childLayoutParams.height;
                android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) childLayoutParams;
                int i17 = marginLayoutParams.leftMargin;
                int i18 = marginLayoutParams.rightMargin;
                int i19 = marginLayoutParams.topMargin;
                i12 = marginLayoutParams.bottomMargin;
                i7 = i15;
                i8 = i16;
                i9 = i17;
                i10 = i18;
                i11 = i19;
            } else {
                i7 = i;
                i8 = i2;
                i9 = i3;
                i10 = i4;
                i11 = i5;
                i12 = i6;
            }
        }
        widget.setLayout(i7, i8, i9, i10, i11, i12, point2);
        int i20 = i7;
        int i21 = i8;
        int i22 = i10;
        int i23 = i12;
        if (widget instanceof com.taobao.weex.ui.flat.widget.AndroidViewWidget) {
            com.taobao.weex.ui.flat.widget.AndroidViewWidget androidViewWidget = (com.taobao.weex.ui.flat.widget.AndroidViewWidget) widget;
            if (androidViewWidget.getView() != null) {
                setHostLayoutParams(androidViewWidget.getView(), i20, i21, point2.x, i22, point2.y, i23);
            }
        }
    }

    protected void setHostLayoutParams(T t, int i, int i2, int i3, int i4, int i5, int i6) {
        android.view.ViewGroup.LayoutParams childLayoutParams;
        android.widget.FrameLayout.LayoutParams layoutParams;
        if (this.mParent == null) {
            layoutParams = new android.widget.FrameLayout.LayoutParams(i, i2);
            setMarginsSupportRTL(layoutParams, i3, i5, i4, i6);
        } else {
            childLayoutParams = this.mParent.getChildLayoutParams(this, t, i, i2, i3, i4, i5, i6);
        }
        if (childLayoutParams == null) {
            childLayoutParams = layoutParams;
            return;
        } else {
            childLayoutParams = layoutParams;
            t.setLayoutParams(childLayoutParams);
        }
    }

    private void setFixedHostLayoutParams(T t, int i, int i2, int i3, int i4, int i5, int i6) {
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = i;
        layoutParams.height = i2;
        setMarginsSupportRTL(layoutParams, i3, i5, i4, i6);
        t.setLayoutParams(layoutParams);
        this.mInstance.moveFixedView(t);
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d("Weex_Fixed_Style", "WXComponent:setLayout :" + i3 + com.taobao.weex.el.parse.Operators.SPACE_STR + i5 + com.taobao.weex.el.parse.Operators.SPACE_STR + i + com.taobao.weex.el.parse.Operators.SPACE_STR + i2);
            java.lang.StringBuilder sb = new java.lang.StringBuilder("WXComponent:setLayout Left:");
            sb.append(getStyles().getLeft());
            sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
            sb.append((int) getStyles().getTop());
            com.taobao.weex.utils.WXLogUtils.d("Weex_Fixed_Style", sb.toString());
        }
    }

    protected void updateBoxShadow(int i, int i2, boolean z) {
        io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData boxShadow;
        android.graphics.drawable.LayerDrawable layerDrawable;
        int top;
        int left;
        if (!io.dcloud.feature.uniapp.utils.UniBoxShadowUtil.isBoxShadowEnabled() || this.mElevation > 0.0f || getStyles().get(com.taobao.weex.common.Constants.Name.ELEVATION) != null || getAttrs().get(com.taobao.weex.common.Constants.Name.ELEVATION) != null) {
            com.taobao.weex.utils.WXLogUtils.w("BoxShadow", "box-shadow disabled");
            if (this.mBoxShadowData != null) {
                clearBoxShadow();
                return;
            }
            return;
        }
        if (getStyles() != null) {
            java.lang.Object obj = getStyles().get(com.taobao.weex.common.Constants.Name.BOX_SHADOW);
            java.lang.Object obj2 = getAttrs().get(com.taobao.weex.common.Constants.Name.SHADOW_QUALITY);
            if (obj != null && i > 0 && i2 > 0) {
                float fFloatValue = com.taobao.weex.utils.WXUtils.getFloat(obj2, java.lang.Float.valueOf(0.5f)).floatValue();
                float instanceViewPortWidthWithFloat = getInstance().getInstanceViewPortWidthWithFloat();
                float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                com.taobao.weex.dom.WXStyle styles = getStyles();
                if (styles != null) {
                    float fFloatValue2 = com.taobao.weex.utils.WXUtils.getFloat(styles.get(com.taobao.weex.common.Constants.Name.BORDER_TOP_LEFT_RADIUS), java.lang.Float.valueOf(0.0f)).floatValue();
                    fArr[0] = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(fFloatValue2, instanceViewPortWidthWithFloat);
                    fArr[1] = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(fFloatValue2, instanceViewPortWidthWithFloat);
                    float fFloatValue3 = com.taobao.weex.utils.WXUtils.getFloat(styles.get(com.taobao.weex.common.Constants.Name.BORDER_TOP_RIGHT_RADIUS), java.lang.Float.valueOf(0.0f)).floatValue();
                    fArr[2] = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(fFloatValue3, instanceViewPortWidthWithFloat);
                    fArr[3] = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(fFloatValue3, instanceViewPortWidthWithFloat);
                    float fFloatValue4 = com.taobao.weex.utils.WXUtils.getFloat(styles.get(com.taobao.weex.common.Constants.Name.BORDER_BOTTOM_RIGHT_RADIUS), java.lang.Float.valueOf(0.0f)).floatValue();
                    fArr[4] = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(fFloatValue4, instanceViewPortWidthWithFloat);
                    fArr[5] = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(fFloatValue4, instanceViewPortWidthWithFloat);
                    float fFloatValue5 = com.taobao.weex.utils.WXUtils.getFloat(styles.get(com.taobao.weex.common.Constants.Name.BORDER_BOTTOM_LEFT_RADIUS), java.lang.Float.valueOf(0.0f)).floatValue();
                    fArr[6] = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(fFloatValue5, instanceViewPortWidthWithFloat);
                    fArr[7] = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(fFloatValue5, instanceViewPortWidthWithFloat);
                    if (styles.containsKey(com.taobao.weex.common.Constants.Name.BORDER_RADIUS)) {
                        float fFloatValue6 = com.taobao.weex.utils.WXUtils.getFloat(styles.get(com.taobao.weex.common.Constants.Name.BORDER_RADIUS), java.lang.Float.valueOf(0.0f)).floatValue();
                        for (int i3 = 0; i3 < 8; i3++) {
                            fArr[i3] = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(fFloatValue6, instanceViewPortWidthWithFloat);
                        }
                    }
                }
                io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData uniBoxShadowData = this.mBoxShadowData;
                if ((uniBoxShadowData == null || !uniBoxShadowData.equalsUniBoxShadowData(obj.toString(), i, i2, fArr)) && (boxShadow = io.dcloud.feature.uniapp.utils.UniBoxShadowUtil.parseBoxShadow(i, i2, obj.toString(), fArr, instanceViewPortWidthWithFloat, fFloatValue)) != null) {
                    this.mBoxShadowData = boxShadow;
                    io.dcloud.feature.uniapp.ui.shadow.UniNormalBoxShadowDrawable normalBoxShadowDrawable = io.dcloud.feature.uniapp.utils.UniBoxShadowUtil.getNormalBoxShadowDrawable(boxShadow, getContext().getResources());
                    io.dcloud.feature.uniapp.ui.shadow.UniInsetBoxShadowLayer insetBoxShadowDrawable = io.dcloud.feature.uniapp.utils.UniBoxShadowUtil.getInsetBoxShadowDrawable(boxShadow);
                    if (normalBoxShadowDrawable == null && insetBoxShadowDrawable == null) {
                        return;
                    }
                    if (normalBoxShadowDrawable != null && boxShadow != null && z && this.mHost != null) {
                        int normalMaxWidth = boxShadow.getNormalMaxWidth();
                        int normalMaxHeight = boxShadow.getNormalMaxHeight();
                        boolean z2 = this.mParent == null;
                        com.taobao.weex.dom.CSSShorthand cSSShorthand = z2 ? new com.taobao.weex.dom.CSSShorthand() : this.mParent.getPadding();
                        com.taobao.weex.dom.CSSShorthand cSSShorthand2 = z2 ? new com.taobao.weex.dom.CSSShorthand() : this.mParent.getBorder();
                        int childrenLayoutTopOffset = z2 ? 0 : this.mParent.getChildrenLayoutTopOffset();
                        if (isFixed()) {
                            left = (int) (getLayoutPosition().getLeft() - getInstance().getRenderContainerPaddingLeft());
                            top = ((int) (getLayoutPosition().getTop() - getInstance().getRenderContainerPaddingTop())) + childrenLayoutTopOffset;
                        } else {
                            int left2 = (int) ((getLayoutPosition().getLeft() - cSSShorthand.get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT)) - cSSShorthand2.get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT));
                            top = ((int) ((getLayoutPosition().getTop() - cSSShorthand.get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP)) - cSSShorthand2.get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP))) + childrenLayoutTopOffset;
                            left = left2;
                        }
                        int i4 = (int) getMargin().get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT);
                        int i5 = (int) getMargin().get(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM);
                        int normalLeft = left - (boxShadow.getNormalLeft() / 2);
                        int normalTop = top - (boxShadow.getNormalTop() / 2);
                        if (isFixed()) {
                            setFixedHostLayoutParams(this.mHost, normalMaxWidth, normalMaxHeight, normalLeft, i4, normalTop, i5);
                        } else {
                            setHostLayoutParams(this.mHost, normalMaxWidth, normalMaxHeight, normalLeft, i4, normalTop, i5);
                        }
                        setPadding(getPadding(), getBorder());
                    }
                    if (this.mBackgroundDrawable != null) {
                        clearBoxShadow();
                        if (this.mRippleBackground == null) {
                            if (normalBoxShadowDrawable != null) {
                                layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{normalBoxShadowDrawable, this.mBackgroundDrawable});
                            } else if (insetBoxShadowDrawable != null) {
                                layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.mBackgroundDrawable, insetBoxShadowDrawable});
                            } else {
                                layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.mBackgroundDrawable});
                            }
                        } else if (normalBoxShadowDrawable != null) {
                            layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.mRippleBackground, normalBoxShadowDrawable, this.mBackgroundDrawable});
                        } else if (insetBoxShadowDrawable != null) {
                            layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.mRippleBackground, this.mBackgroundDrawable, insetBoxShadowDrawable});
                        } else {
                            layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.mRippleBackground, this.mBackgroundDrawable});
                        }
                        com.taobao.weex.utils.WXViewUtils.setBackGround(getHostView(), layerDrawable, this);
                        this.mBoxShadowData = boxShadow;
                        this.mBoxShadowDrawable = normalBoxShadowDrawable;
                        this.mInsetBoxShadowDrawable = insetBoxShadowDrawable;
                        this.mBackgroundDrawable.updateBoxShadowData(boxShadow);
                        return;
                    }
                    clearBoxShadow();
                    this.mBoxShadowData = boxShadow;
                    this.mBoxShadowDrawable = normalBoxShadowDrawable;
                    this.mInsetBoxShadowDrawable = insetBoxShadowDrawable;
                    getOrCreateBorder().updateBoxShadowData(boxShadow);
                    return;
                }
                return;
            }
            return;
        }
        com.taobao.weex.utils.WXLogUtils.w("Can not resolve styles");
    }

    protected void clearBoxShadow() {
        if (!io.dcloud.feature.uniapp.utils.UniBoxShadowUtil.isBoxShadowEnabled()) {
            com.taobao.weex.utils.WXLogUtils.w("BoxShadow", "box-shadow disabled");
            return;
        }
        com.taobao.weex.ui.view.border.BorderDrawable borderDrawable = this.mBackgroundDrawable;
        if (borderDrawable != null) {
            borderDrawable.updateBoxShadowData(null);
        }
        if (getHostView() != null && this.mBackgroundDrawable != null && (getHostView().getBackground() instanceof android.graphics.drawable.LayerDrawable)) {
            if (this.mRippleBackground == null) {
                com.taobao.weex.utils.WXViewUtils.setBackGround(getHostView(), new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.mBackgroundDrawable}), this);
            } else {
                com.taobao.weex.utils.WXViewUtils.setBackGround(getHostView(), new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.mRippleBackground, this.mBackgroundDrawable}), this);
            }
        }
        if (this.mBoxShadowData != null) {
            this.mBoxShadowData = null;
        }
        io.dcloud.feature.uniapp.ui.shadow.UniNormalBoxShadowDrawable uniNormalBoxShadowDrawable = this.mBoxShadowDrawable;
        if (uniNormalBoxShadowDrawable != null) {
            if (uniNormalBoxShadowDrawable.getBitmap() != null) {
                this.mBoxShadowDrawable.getBitmap().recycle();
            }
            this.mBoxShadowDrawable = null;
        }
        if (this.mInsetBoxShadowDrawable != null) {
            this.mInsetBoxShadowDrawable = null;
        }
    }

    protected void onFinishLayout() {
        java.lang.Object obj = getStyles() != null ? getStyles().get(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE) : null;
        if (obj != null) {
            setBackgroundImage(obj.toString());
        }
    }

    protected com.taobao.weex.ui.component.WXComponent.MeasureOutput measure(int i, int i2) {
        com.taobao.weex.ui.component.WXComponent.MeasureOutput measureOutput = new com.taobao.weex.ui.component.WXComponent.MeasureOutput();
        int i3 = this.mFixedProp;
        if (i3 != 0) {
            measureOutput.width = i3;
            measureOutput.height = this.mFixedProp;
            return measureOutput;
        }
        measureOutput.width = i;
        measureOutput.height = i2;
        return measureOutput;
    }

    protected void setAriaHidden(boolean z) {
        android.view.View hostView = getHostView();
        if (hostView != null) {
            hostView.setImportantForAccessibility(z ? 2 : 1);
        }
    }

    protected void setAriaLabel(java.lang.String str) {
        android.view.View hostView = getHostView();
        if (hostView != null) {
            hostView.setContentDescription(str);
        }
    }

    protected void setRole(final java.lang.String str) {
        android.view.View hostView = getHostView();
        if (hostView == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.taobao.weex.adapter.IWXAccessibilityRoleAdapter accessibilityRoleAdapter = com.taobao.weex.WXSDKManager.getInstance().getAccessibilityRoleAdapter();
        if (accessibilityRoleAdapter != null) {
            str = accessibilityRoleAdapter.getRole(str);
        }
        androidx.core.view.ViewCompat.setAccessibilityDelegate(hostView, new androidx.core.view.AccessibilityDelegateCompat() { // from class: com.taobao.weex.ui.component.WXComponent.5
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                try {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setRoleDescription(str);
                } catch (java.lang.Throwable unused) {
                    com.taobao.weex.utils.WXLogUtils.e("SetRole failed!");
                }
            }
        });
    }

    private void setFixedSize(java.lang.String str) {
        android.view.ViewGroup.LayoutParams layoutParams;
        if (PROP_FS_MATCH_PARENT.equals(str)) {
            this.mFixedProp = -1;
        } else if (PROP_FS_WRAP_CONTENT.equals(str)) {
            this.mFixedProp = -2;
        } else {
            this.mFixedProp = 0;
            return;
        }
        T t = this.mHost;
        if (t == null || (layoutParams = t.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = this.mFixedProp;
        layoutParams.width = this.mFixedProp;
        this.mHost.setLayoutParams(layoutParams);
    }

    public android.view.View getRealView() {
        return this.mHost;
    }

    private boolean needGestureDetector(java.lang.String str) {
        if (this.mHost != null) {
            for (com.taobao.weex.ui.view.gesture.WXGestureType.LowLevelGesture lowLevelGesture : com.taobao.weex.ui.view.gesture.WXGestureType.LowLevelGesture.values()) {
                if (str.equals(lowLevelGesture.toString())) {
                    return true;
                }
            }
            for (com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture highLevelGesture : com.taobao.weex.ui.view.gesture.WXGestureType.HighLevelGesture.values()) {
                if (str.equals(highLevelGesture.toString())) {
                    return true;
                }
            }
        }
        return com.taobao.weex.ui.view.gesture.WXGesture.isStopPropagation(str) || str.equals(io.dcloud.weex.ViewHover.VIEW_HOVER_EVENT) || isPreventGesture();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.taobao.weex.ui.component.Scrollable getParentScroller() {
        com.taobao.weex.ui.component.WXComponent parent = this;
        do {
            parent = parent.getParent();
            if (parent == 0) {
                return null;
            }
            if (parent instanceof com.taobao.weex.ui.component.Scrollable) {
                return (com.taobao.weex.ui.component.Scrollable) parent;
            }
        } while (!parent.getRef().equals(ROOT));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.taobao.weex.ui.component.Scrollable getFirstScroller() {
        if (this instanceof com.taobao.weex.ui.component.Scrollable) {
            return (com.taobao.weex.ui.component.Scrollable) this;
        }
        return null;
    }

    public com.taobao.weex.ui.component.WXVContainer getParent() {
        return this.mParent;
    }

    public final void createView() {
        if (isLazy()) {
            return;
        }
        createViewImpl();
    }

    protected void createViewImpl() {
        android.content.Context context = this.mContext;
        if (context != null) {
            T t = (T) initComponentHostView(context);
            this.mHost = t;
            if (t == null && !isVirtualComponent()) {
                initView();
            }
            T t2 = this.mHost;
            if (t2 != null) {
                if (t2.getId() == -1) {
                    this.mHost.setId(com.taobao.weex.utils.WXViewUtils.generateViewId());
                }
                com.taobao.weex.ComponentObserver componentObserver = getInstance().getComponentObserver();
                if (componentObserver != null) {
                    componentObserver.onViewCreated(this, this.mHost);
                }
                invokePendingComponetMethod();
            }
            onHostViewInitialized(this.mHost);
            return;
        }
        com.taobao.weex.utils.WXLogUtils.e("createViewImpl", "Context is null");
    }

    private final void invokePendingComponetMethod() {
        if (this.mPendingComponetMethodQueue.size() > 0) {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.WXComponent.6
                @Override // java.lang.Runnable
                public void run() {
                    while (!com.taobao.weex.ui.component.WXComponent.this.mPendingComponetMethodQueue.isEmpty()) {
                        io.dcloud.feature.uniapp.ui.action.UniMethodData uniMethodData = (io.dcloud.feature.uniapp.ui.action.UniMethodData) com.taobao.weex.ui.component.WXComponent.this.mPendingComponetMethodQueue.poll();
                        if (uniMethodData != null) {
                            com.taobao.weex.ui.component.WXComponent.this.invoke(uniMethodData.getMethod(), uniMethodData.getArgs());
                        }
                    }
                }
            });
        }
    }

    @java.lang.Deprecated
    protected void initView() {
        android.content.Context context = this.mContext;
        if (context != null) {
            T t = (T) initComponentHostView(context);
            this.mHost = t;
            if (t != null) {
                invokePendingComponetMethod();
            }
        }
    }

    protected void onHostViewInitialized(T t) {
        io.dcloud.feature.uniapp.ui.AbsAnimationHolder absAnimationHolder = this.mAnimationHolder;
        if (absAnimationHolder != null) {
            absAnimationHolder.execute(this.mInstance, this);
        }
        setActiveTouchListener();
    }

    public T getHostView() {
        return this.mHost;
    }

    @java.lang.Deprecated
    public android.view.View getView() {
        return this.mHost;
    }

    public int getAbsoluteY() {
        return this.mAbsoluteY;
    }

    public int getAbsoluteX() {
        return this.mAbsoluteX;
    }

    public void removeEvent(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals(com.taobao.weex.common.Constants.Event.LAYEROVERFLOW)) {
            removeLayerOverFlowListener(getRef());
        }
        if (getEvents() != null) {
            getEvents().remove(str);
        }
        java.util.Set<java.lang.String> set = this.mAppendEvents;
        if (set != null) {
            set.remove(str);
        }
        java.util.Set<java.lang.String> set2 = this.mGestureType;
        if (set2 != null) {
            set2.remove(str);
        }
        removeEventFromView(str);
    }

    protected void removeEventFromView(java.lang.String str) {
        if (str.equals(com.taobao.weex.common.Constants.Event.CLICK) && getRealView() != null && this.mHostClickListeners != null) {
            if (this.mClickEventListener == null) {
                this.mClickEventListener = new com.taobao.weex.ui.component.WXComponent.OnClickListenerImp();
            }
            this.mHostClickListeners.remove(this.mClickEventListener);
            if (this.mHostClickListeners.size() < 1) {
                getRealView().setOnClickListener(null);
                getRealView().setClickable(false);
            }
        }
        com.taobao.weex.ui.component.Scrollable parentScroller = getParentScroller();
        if (str.equals(com.taobao.weex.common.Constants.Event.APPEAR) && parentScroller != null) {
            parentScroller.unbindAppearEvent(this);
        }
        if (!str.equals(com.taobao.weex.common.Constants.Event.DISAPPEAR) || parentScroller == null) {
            return;
        }
        parentScroller.unbindDisappearEvent(this);
    }

    public void removeAllEvent() {
        if (getEvents().size() < 1) {
            return;
        }
        com.taobao.weex.dom.WXEvent events = getEvents();
        int size = events.size();
        for (int i = 0; i < size && i < events.size(); i++) {
            java.lang.String str = (java.lang.String) events.get(i);
            if (str != null) {
                removeEventFromView(str);
            }
        }
        java.util.Set<java.lang.String> set = this.mAppendEvents;
        if (set != null) {
            set.clear();
        }
        java.util.Set<java.lang.String> set2 = this.mGestureType;
        if (set2 != null) {
            set2.clear();
        }
        this.mGesture = null;
        if (getRealView() != null && (getRealView() instanceof com.taobao.weex.ui.view.gesture.WXGestureObservable)) {
            ((com.taobao.weex.ui.view.gesture.WXGestureObservable) getRealView()).registerGestureListener(null);
        }
        T t = this.mHost;
        if (t != null) {
            t.setOnFocusChangeListener(null);
            java.util.List<com.taobao.weex.ui.component.WXComponent.OnClickListener> list = this.mHostClickListeners;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.mHostClickListeners.clear();
            this.mHost.setOnClickListener(null);
        }
    }

    public final void removeStickyStyle() {
        com.taobao.weex.ui.component.Scrollable parentScroller;
        if (!isSticky() || (parentScroller = getParentScroller()) == null) {
            return;
        }
        parentScroller.unbindStickStyle(this);
    }

    public boolean isSticky() {
        return getStyles().isSticky();
    }

    public boolean isFixed() {
        return getStyles().isFixed();
    }

    public void setDisabled(boolean z) {
        this.mIsDisabled = z;
        T t = this.mHost;
        if (t == null) {
            return;
        }
        t.setEnabled(!z);
    }

    public boolean isDisabled() {
        return this.mIsDisabled;
    }

    public void setSticky(java.lang.String str) {
        com.taobao.weex.ui.component.Scrollable parentScroller;
        if (android.text.TextUtils.isEmpty(str) || !str.equals("sticky") || (parentScroller = getParentScroller()) == null) {
            return;
        }
        parentScroller.bindStickStyle(this);
    }

    public void setBackgroundColor(java.lang.String str) {
        android.graphics.drawable.LayerDrawable layerDrawable;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        int color = com.taobao.weex.utils.WXResourceUtils.getColor(str);
        if (isRippleEnabled()) {
            android.graphics.drawable.Drawable drawablePrepareBackgroundRipple = prepareBackgroundRipple();
            this.mRippleBackground = drawablePrepareBackgroundRipple;
            if (drawablePrepareBackgroundRipple != null) {
                if (this.mBackgroundDrawable == null) {
                    com.taobao.weex.utils.WXViewUtils.setBackGround(this.mHost, drawablePrepareBackgroundRipple, this);
                    return;
                }
                if (this.mBoxShadowDrawable != null) {
                    layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.mRippleBackground, this.mBoxShadowDrawable, this.mBackgroundDrawable, this.mInsetBoxShadowDrawable});
                } else if (this.mInsetBoxShadowDrawable != null) {
                    layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.mRippleBackground, this.mBackgroundDrawable, this.mInsetBoxShadowDrawable});
                } else {
                    layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.mRippleBackground, this.mBackgroundDrawable});
                }
                com.taobao.weex.utils.WXViewUtils.setBackGround(this.mHost, layerDrawable, this);
                return;
            }
        }
        if (color == 0 && this.mBackgroundDrawable == null) {
            return;
        }
        getOrCreateBorder().setColor(color);
    }

    private android.graphics.drawable.Drawable prepareBackgroundRipple() {
        int color;
        android.graphics.drawable.Drawable drawable = null;
        try {
            if (getStyles() != null && getStyles().getPesudoResetStyles() != null) {
                java.util.Map<java.lang.String, java.lang.Object> pesudoResetStyles = getStyles().getPesudoResetStyles();
                java.lang.Object obj = pesudoResetStyles.get("backgroundColor");
                if (obj != null) {
                    color = com.taobao.weex.utils.WXResourceUtils.getColor(obj.toString(), 0);
                    if (color == 0) {
                        return null;
                    }
                } else {
                    color = 0;
                }
                java.lang.Object obj2 = pesudoResetStyles.get("backgroundColor:active");
                if (obj2 == null) {
                    return null;
                }
                return new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[0]}, new int[]{com.taobao.weex.utils.WXResourceUtils.getColor(obj2.toString(), color)}), new android.graphics.drawable.ColorDrawable(color), drawable) { // from class: com.taobao.weex.ui.component.WXComponent.7
                    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
                    public void draw(android.graphics.Canvas canvas) {
                        if (com.taobao.weex.ui.component.WXComponent.this.mBackgroundDrawable != null) {
                            canvas.clipPath(com.taobao.weex.ui.component.WXComponent.this.mBackgroundDrawable.getContentPath(new android.graphics.RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())));
                        }
                        super.draw(canvas);
                    }
                };
            }
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.w("Exception on create ripple: ", th);
        }
        return null;
    }

    public void setBackgroundImage(java.lang.String str) {
        if ("".equals(str.trim())) {
            getOrCreateBorder().setImage(null);
        } else {
            getOrCreateBorder().setImage(com.taobao.weex.utils.WXResourceUtils.getShader(str, getLayoutSize().getWidth(), getLayoutSize().getHeight()));
        }
    }

    private boolean shouldCancelHardwareAccelerate() {
        com.taobao.weex.adapter.IWXConfigAdapter wxConfigAdapter = com.taobao.weex.WXSDKManager.getInstance().getWxConfigAdapter();
        boolean z = true;
        if (wxConfigAdapter != null) {
            try {
                z = java.lang.Boolean.parseBoolean(wxConfigAdapter.getConfig("android_weex_test_gpu", "cancel_hardware_accelerate", io.dcloud.common.constant.AbsoluteConst.TRUE));
            } catch (java.lang.Exception e) {
                com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
            }
            com.taobao.weex.utils.WXLogUtils.i("cancel_hardware_accelerate : " + z);
        }
        return z;
    }

    public void setOpacity(float f) {
        if (f < 0.0f || f > 1.0f || this.mHost.getAlpha() == f) {
            return;
        }
        int openGLRenderLimitValue = com.taobao.weex.ui.WXRenderManager.getOpenGLRenderLimitValue();
        if (isLayerTypeEnabled()) {
            this.mHost.setLayerType(2, null);
        }
        if (isLayerTypeEnabled() && shouldCancelHardwareAccelerate() && openGLRenderLimitValue > 0) {
            float f2 = openGLRenderLimitValue;
            if (getLayoutHeight() > f2 || getLayoutWidth() > f2) {
                this.mHost.setLayerType(0, null);
            }
        }
        this.mHost.setAlpha(f);
    }

    public void setBorderRadius(java.lang.String str, float f) {
        if (f >= 0.0f) {
            str.hashCode();
            switch (str) {
                case "borderTopLeftRadius":
                    getOrCreateBorder().setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT, com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(f, this.mInstance.getInstanceViewPortWidthWithFloat()));
                    break;
                case "borderTopRightRadius":
                    getOrCreateBorder().setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT, com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(f, this.mInstance.getInstanceViewPortWidthWithFloat()));
                    break;
                case "borderBottomLeftRadius":
                    getOrCreateBorder().setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT, com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(f, this.mInstance.getInstanceViewPortWidthWithFloat()));
                    break;
                case "borderBottomRightRadius":
                    getOrCreateBorder().setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT, com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(f, this.mInstance.getInstanceViewPortWidthWithFloat()));
                    break;
                case "borderRadius":
                    getOrCreateBorder().setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.ALL, com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(f, this.mInstance.getInstanceViewPortWidthWithFloat()));
                    break;
            }
        }
    }

    private void initOutlineProvider(final float f) {
        if (useFeature() && (getHostView() instanceof com.taobao.weex.ui.view.BaseFrameLayout)) {
            getHostView().setOutlineProvider(new android.view.ViewOutlineProvider() { // from class: com.taobao.weex.ui.component.WXComponent.8
                @Override // android.view.ViewOutlineProvider
                public void getOutline(android.view.View view, android.graphics.Outline outline) {
                    if (com.taobao.weex.ui.component.WXComponent.this.getInstance().isDestroy()) {
                        return;
                    }
                    int width = view.getWidth();
                    int height = view.getHeight();
                    if (width == 0 || height == 0 || !com.taobao.weex.ui.component.WXComponent.this.getOrCreateBorder().isRounded()) {
                        return;
                    }
                    android.graphics.Rect rect = new android.graphics.Rect(0, 0, width, height);
                    float f2 = width / (f * 2.0f);
                    if (!java.lang.Float.isNaN(f2) && f2 < 1.0f) {
                        outline.setRoundRect(rect, f2 * f);
                    } else {
                        outline.setRoundRect(rect, f);
                    }
                }
            });
            getHostView().setClipToOutline(true);
        }
    }

    public boolean useFeature() {
        return android.os.Build.VERSION.SDK_INT >= 24;
    }

    public void setBorderWidth(java.lang.String str, float f) {
        if (f >= 0.0f) {
            str.hashCode();
            switch (str) {
                case "borderRightWidth":
                    getOrCreateBorder().setBorderWidth(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT, f);
                    break;
                case "borderTopWidth":
                    getOrCreateBorder().setBorderWidth(com.taobao.weex.dom.CSSShorthand.EDGE.TOP, f);
                    break;
                case "borderBottomWidth":
                    getOrCreateBorder().setBorderWidth(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM, f);
                    break;
                case "borderLeftWidth":
                    getOrCreateBorder().setBorderWidth(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT, f);
                    break;
                case "borderWidth":
                    getOrCreateBorder().setBorderWidth(com.taobao.weex.dom.CSSShorthand.EDGE.ALL, f);
                    break;
            }
        }
    }

    public void setBorderStyle(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        str.hashCode();
        switch (str) {
            case "borderRightStyle":
                getOrCreateBorder().setBorderStyle(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT, str2);
                break;
            case "borderTopStyle":
                getOrCreateBorder().setBorderStyle(com.taobao.weex.dom.CSSShorthand.EDGE.TOP, str2);
                break;
            case "borderBottomStyle":
                getOrCreateBorder().setBorderStyle(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM, str2);
                break;
            case "borderLeftStyle":
                getOrCreateBorder().setBorderStyle(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT, str2);
                break;
            case "borderStyle":
                getOrCreateBorder().setBorderStyle(com.taobao.weex.dom.CSSShorthand.EDGE.ALL, str2);
                break;
        }
    }

    public void setBorderColor(java.lang.String str, java.lang.String str2) {
        int color;
        if (android.text.TextUtils.isEmpty(str2) || (color = com.taobao.weex.utils.WXResourceUtils.getColor(str2)) == Integer.MIN_VALUE) {
            return;
        }
        str.hashCode();
        switch (str) {
            case "borderRightColor":
                getOrCreateBorder().setBorderColor(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT, color);
                break;
            case "borderTopColor":
                getOrCreateBorder().setBorderColor(com.taobao.weex.dom.CSSShorthand.EDGE.TOP, color);
                break;
            case "borderBottomColor":
                getOrCreateBorder().setBorderColor(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM, color);
                break;
            case "borderLeftColor":
                getOrCreateBorder().setBorderColor(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT, color);
                break;
            case "borderColor":
                getOrCreateBorder().setBorderColor(com.taobao.weex.dom.CSSShorthand.EDGE.ALL, color);
                break;
        }
    }

    public java.lang.String getVisibility() {
        try {
            return (java.lang.String) getStyles().get(com.taobao.weex.common.Constants.Name.VISIBILITY);
        } catch (java.lang.Exception unused) {
            return "visible";
        }
    }

    public void setVisibility(java.lang.String str) {
        android.view.View realView = getRealView();
        if (realView != null) {
            if (android.text.TextUtils.equals(str, "visible")) {
                realView.setVisibility(0);
            } else if (android.text.TextUtils.equals(str, "hidden")) {
                realView.setVisibility(8);
            }
        }
    }

    private void updateElevation() {
        float elevation = getAttrs().getElevation(getInstance().getInstanceViewPortWidthWithFloat());
        if (java.lang.Float.isNaN(elevation)) {
            return;
        }
        androidx.core.view.ViewCompat.setElevation(getHostView(), elevation);
    }

    @Override // com.taobao.weex.IWXActivityStateListener
    public void onActivityDestroy() {
        java.util.concurrent.ConcurrentLinkedQueue<io.dcloud.feature.uniapp.ui.action.UniMethodData> concurrentLinkedQueue = this.mPendingComponetMethodQueue;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
    }

    public void recycled() {
        isFixed();
    }

    public void destroy() {
        android.view.View hostView;
        if (getInstance() == null) {
            return;
        }
        clearBoxShadow();
        com.taobao.weex.ComponentObserver componentObserver = getInstance().getComponentObserver();
        if (componentObserver != null) {
            componentObserver.onPreDestory(this);
        }
        if (com.taobao.weex.WXEnvironment.isApkDebugable() && !com.taobao.weex.utils.WXUtils.isUiThread()) {
            throw new com.taobao.weex.common.WXRuntimeException("[WXComponent] destroy can only be called in main thread");
        }
        T t = this.mHost;
        if (t != null && t.getLayerType() == 2 && isLayerTypeEnabled()) {
            this.mHost.setLayerType(0, null);
        }
        removeAllEvent();
        removeStickyStyle();
        if (isFixed() && (hostView = getHostView()) != null) {
            getInstance().removeFixedView(hostView);
        }
        com.taobao.weex.layout.ContentBoxMeasurement contentBoxMeasurement = this.contentBoxMeasurement;
        if (contentBoxMeasurement != null) {
            contentBoxMeasurement.destroy();
            this.contentBoxMeasurement = null;
        }
        this.mIsDestroyed = true;
        java.util.concurrent.ConcurrentLinkedQueue<android.util.Pair<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>>> concurrentLinkedQueue = this.animations;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
        io.dcloud.weex.ViewHover viewHover = this.mHover;
        if (viewHover != null) {
            viewHover.destroy();
            this.mHover = null;
        }
        this.mInstance = null;
        java.util.List<com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener> list = this.mFocusChangeListeners;
        if (list != null) {
            list.clear();
        }
        java.util.List<com.taobao.weex.ui.component.WXComponent.OnClickListener> list2 = this.mHostClickListeners;
        if (list2 != null) {
            list2.clear();
        }
    }

    public boolean isDestoryed() {
        return this.mIsDestroyed;
    }

    public android.view.View detachViewAndClearPreInfo() {
        T t = this.mHost;
        this.mPreRealLeft = 0;
        this.mPreRealRight = 0;
        this.mPreRealWidth = 0;
        this.mPreRealHeight = 0;
        this.mPreRealTop = 0;
        return t;
    }

    public void clearPreLayout() {
        this.mPreRealLeft = 0;
        this.mPreRealRight = 0;
        this.mPreRealWidth = 0;
        this.mPreRealHeight = 0;
        this.mPreRealTop = 0;
    }

    public void computeVisiblePointInViewCoordinate(android.graphics.PointF pointF) {
        android.view.View realView = getRealView();
        pointF.set(realView.getScrollX(), realView.getScrollY());
    }

    public boolean containsGesture(com.taobao.weex.ui.view.gesture.WXGestureType wXGestureType) {
        java.util.Set<java.lang.String> set = this.mGestureType;
        return set != null && set.contains(wXGestureType.toString());
    }

    public boolean containsEvent(java.lang.String str) {
        if (getEvents().contains(str)) {
            return true;
        }
        java.util.Set<java.lang.String> set = this.mAppendEvents;
        return set != null && set.contains(str);
    }

    public void notifyAppearStateChange(java.lang.String str, java.lang.String str2) {
        if (containsEvent(com.taobao.weex.common.Constants.Event.APPEAR) || containsEvent(com.taobao.weex.common.Constants.Event.DISAPPEAR)) {
            java.util.HashMap map = new java.util.HashMap();
            map.put("direction", str2);
            fireEvent(str, map);
        }
    }

    public boolean isUsing() {
        return this.isUsing;
    }

    public void setUsing(boolean z) {
        this.isUsing = z;
    }

    public void readyToRender() {
        if (this.mParent == null || getInstance() == null || !getInstance().isTrackComponent()) {
            return;
        }
        this.mParent.readyToRender();
    }

    public boolean isVirtualComponent() {
        return this.mType == 1;
    }

    public int getType() {
        return this.mType;
    }

    public boolean hasScrollParent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (wXComponent.getParent() == null) {
            return true;
        }
        if (wXComponent.getParent() instanceof com.taobao.weex.ui.component.WXBaseScroller) {
            return false;
        }
        return hasScrollParent(wXComponent.getParent());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0010  */
    protected java.lang.Object convertEmptyProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "borderRightColor":
            case "borderTopColor":
            case "borderBottomColor":
            case "borderLeftColor":
            case "borderColor":
                return "black";
            case "borderRightWidth":
            case "borderTopWidth":
            case "borderBottomWidth":
            case "borderTopLeftRadius":
            case "borderLeftWidth":
            case "borderTopRightRadius":
            case "borderBottomLeftRadius":
            case "borderBottomRightRadius":
            case "borderWidth":
            case "borderRadius":
                return 0;
            case "backgroundColor":
                return "transparent";
            default:
                return obj;
        }
    }

    private void setActiveTouchListener() {
        android.view.View realView;
        if (!getStyles().getPesudoStyles().containsKey(com.taobao.weex.common.Constants.PSEUDO.ACTIVE) || (realView = getRealView()) == null) {
            return;
        }
        realView.setOnTouchListener(new com.taobao.weex.ui.component.pesudo.TouchActivePseudoListener(this, !isConsumeTouch()));
    }

    protected boolean isConsumeTouch() {
        java.util.List<com.taobao.weex.ui.component.WXComponent.OnClickListener> list = this.mHostClickListeners;
        return (list != null && list.size() > 0) || this.mGesture != null;
    }

    @Override // com.taobao.weex.ui.component.pesudo.OnActivePseudoListner
    public void updateActivePseudo(boolean z) {
        if (getInstance() != null) {
            setPseudoClassStatus(com.taobao.weex.common.Constants.PSEUDO.ACTIVE, z);
        }
    }

    protected void setPseudoClassStatus(java.lang.String str, boolean z) {
        com.taobao.weex.dom.WXStyle styles = getStyles();
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> pesudoStyles = styles.getPesudoStyles();
        if (pesudoStyles == null || pesudoStyles.size() == 0) {
            return;
        }
        if (this.mPesudoStatus == null) {
            this.mPesudoStatus = new com.taobao.weex.ui.component.pesudo.PesudoStatus();
        }
        java.util.Map<java.lang.String, java.lang.Object> mapUpdateStatusAndGetUpdateStyles = this.mPesudoStatus.updateStatusAndGetUpdateStyles(str, z, pesudoStyles, styles.getPesudoResetStyles());
        if (mapUpdateStatusAndGetUpdateStyles != null) {
            if (z) {
                this.mPseudoResetGraphicSize = new com.taobao.weex.ui.action.GraphicSize(getLayoutSize().getWidth(), getLayoutSize().getHeight());
                if (mapUpdateStatusAndGetUpdateStyles.keySet().contains("width")) {
                    getLayoutSize().setWidth(com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.parseFloat(styles.getPesudoResetStyles().get("width:active")), getViewPortWidthForFloat()));
                } else if (mapUpdateStatusAndGetUpdateStyles.keySet().contains("height")) {
                    getLayoutSize().setHeight(com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.parseFloat(styles.getPesudoResetStyles().get("height:active")), getViewPortWidthForFloat()));
                }
            } else {
                com.taobao.weex.ui.action.GraphicSize graphicSize = this.mPseudoResetGraphicSize;
                if (graphicSize != null) {
                    setLayoutSize(graphicSize);
                }
            }
        }
        updateStyleByPesudo(mapUpdateStatusAndGetUpdateStyles);
    }

    private void updateStyleByPesudo(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (getInstance() == null) {
            return;
        }
        new com.taobao.weex.ui.action.GraphicActionUpdateStyle(getInstance(), getRef(), map, getPadding(), getMargin(), getBorder(), true).executeActionOnRender();
        if (getLayoutWidth() == 0.0f && getLayoutHeight() == 0.0f) {
            return;
        }
        if (map.containsKey("width")) {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().setStyleWidth(getInstanceId(), getRef(), getLayoutWidth());
        } else if (map.containsKey("height")) {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().setStyleHeight(getInstanceId(), getRef(), getLayoutHeight());
        }
    }

    public int getStickyOffset() {
        return this.mStickyOffset;
    }

    public boolean canRecycled() {
        return !(isFixed() && isSticky()) && getAttrs().canRecycled();
    }

    public void setStickyOffset(int i) {
        this.mStickyOffset = i;
    }

    public boolean isLayerTypeEnabled() {
        return getInstance().isLayerTypeEnabled();
    }

    public void setNeedLayoutOnAnimation(boolean z) {
        this.mNeedLayoutOnAnimation = z;
    }

    public void notifyNativeSizeChanged(int i, int i2) {
        if (this.mNeedLayoutOnAnimation) {
            io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowData uniBoxShadowData = this.mBoxShadowData;
            if (uniBoxShadowData != null && uniBoxShadowData.getNormalShadows().size() > 0) {
                i -= this.mBoxShadowData.getNormalLeft();
                i2 -= this.mBoxShadowData.getNormalTop();
            }
            com.taobao.weex.bridge.WXBridgeManager wXBridgeManager = com.taobao.weex.bridge.WXBridgeManager.getInstance();
            wXBridgeManager.setStyleWidth(getInstanceId(), getRef(), i);
            wXBridgeManager.setStyleHeight(getInstanceId(), getRef(), i2);
        }
    }

    public void onRenderFinish(int i) {
        if (com.taobao.weex.tracing.WXTracing.isAvailable()) {
            double dNanosToMillis = com.taobao.weex.tracing.Stopwatch.nanosToMillis(this.mTraceInfo.uiThreadNanos);
            if (i == 2 || i == 0) {
                com.taobao.weex.tracing.WXTracing.TraceEvent traceEventNewEvent = com.taobao.weex.tracing.WXTracing.newEvent("DomExecute", getInstanceId(), this.mTraceInfo.rootEventId);
                traceEventNewEvent.ph = "X";
                traceEventNewEvent.ts = this.mTraceInfo.domThreadStart;
                traceEventNewEvent.tname = "DOMThread";
                traceEventNewEvent.name = getComponentType();
                traceEventNewEvent.classname = getClass().getSimpleName();
                if (getParent() != null) {
                    traceEventNewEvent.parentRef = getParent().getRef();
                }
                traceEventNewEvent.submit();
            }
            if (i == 2 || i == 1) {
                if (this.mTraceInfo.uiThreadStart != -1) {
                    com.taobao.weex.tracing.WXTracing.TraceEvent traceEventNewEvent2 = com.taobao.weex.tracing.WXTracing.newEvent("UIExecute", getInstanceId(), this.mTraceInfo.rootEventId);
                    traceEventNewEvent2.ph = "X";
                    traceEventNewEvent2.duration = dNanosToMillis;
                    traceEventNewEvent2.ts = this.mTraceInfo.uiThreadStart;
                    traceEventNewEvent2.name = getComponentType();
                    traceEventNewEvent2.classname = getClass().getSimpleName();
                    if (getParent() != null) {
                        traceEventNewEvent2.parentRef = getParent().getRef();
                    }
                    traceEventNewEvent2.submit();
                    return;
                }
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    isLazy();
                }
            }
        }
    }

    protected boolean isRippleEnabled() {
        try {
            return com.taobao.weex.utils.WXUtils.getBoolean(getAttrs().get(com.taobao.weex.common.Constants.Name.RIPPLE_ENABLED), false).booleanValue();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public boolean isWaste() {
        return this.waste;
    }

    public void setWaste(boolean z) {
        if (this.waste != z) {
            this.waste = z;
            if (!com.taobao.weex.ui.component.WXBasicComponentType.RECYCLE_LIST.equals(getParent().getComponentType())) {
                com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils.nativeRenderObjectChildWaste(getRenderObjectPtr(), z);
            }
            if (z) {
                getStyles().put(com.taobao.weex.common.Constants.Name.VISIBILITY, (java.lang.Object) "hidden");
                if (getHostView() == null) {
                    if (this.mLazy) {
                        return;
                    }
                    lazy(true);
                    return;
                }
                getHostView().setVisibility(8);
                return;
            }
            getStyles().put(com.taobao.weex.common.Constants.Name.VISIBILITY, (java.lang.Object) "visible");
            if (getHostView() == null) {
                if (this.mLazy) {
                    if (this.mParent != null && this.mParent.isLazy()) {
                        lazy(false);
                        return;
                    } else {
                        com.taobao.weex.ui.component.binding.Statements.initLazyComponent(this, this.mParent);
                        return;
                    }
                }
                return;
            }
            getHostView().setVisibility(0);
        }
    }

    public java.lang.String getViewTreeKey() {
        if (this.mViewTreeKey == null) {
            if (getParent() == null) {
                this.mViewTreeKey = hashCode() + "_" + getRef();
            } else {
                this.mViewTreeKey = hashCode() + "_" + getRef() + "_" + getParent().indexOf(this);
            }
        }
        return this.mViewTreeKey;
    }

    public com.taobao.weex.dom.transition.WXTransition getTransition() {
        return this.mTransition;
    }

    public void setTransition(com.taobao.weex.dom.transition.WXTransition wXTransition) {
        this.mTransition = wXTransition;
    }

    public void addAnimationForElement(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        if (this.animations == null) {
            this.animations = new java.util.concurrent.ConcurrentLinkedQueue<>();
        }
        this.animations.add(new android.util.Pair<>(getRef(), map));
    }

    private void parseAnimation() {
        com.taobao.weex.ui.animation.WXAnimationBean wXAnimationBeanCreateAnimationBean;
        java.util.concurrent.ConcurrentLinkedQueue<android.util.Pair<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>>> concurrentLinkedQueue = this.animations;
        if (concurrentLinkedQueue == null) {
            return;
        }
        for (android.util.Pair<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> pair : concurrentLinkedQueue) {
            if (!android.text.TextUtils.isEmpty((java.lang.CharSequence) pair.first) && (wXAnimationBeanCreateAnimationBean = createAnimationBean((java.lang.String) pair.first, (java.util.Map) pair.second)) != null) {
                new com.taobao.weex.ui.action.GraphicActionAnimation(getInstance(), getRef(), wXAnimationBeanCreateAnimationBean).executeAction();
            }
        }
        this.animations.clear();
    }

    private com.taobao.weex.ui.animation.WXAnimationBean createAnimationBean(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map != null) {
            try {
                java.lang.Object obj = map.get("transform");
                if ((obj instanceof java.lang.String) && !android.text.TextUtils.isEmpty((java.lang.String) obj)) {
                    java.lang.String str2 = (java.lang.String) map.get(com.taobao.weex.common.Constants.Name.TRANSFORM_ORIGIN);
                    com.taobao.weex.ui.animation.WXAnimationBean wXAnimationBean = new com.taobao.weex.ui.animation.WXAnimationBean();
                    int layoutWidth = (int) getLayoutWidth();
                    int layoutHeight = (int) getLayoutHeight();
                    wXAnimationBean.styles = new com.taobao.weex.ui.animation.WXAnimationBean.Style();
                    wXAnimationBean.styles.init(str2, (java.lang.String) obj, layoutWidth, layoutHeight, com.taobao.weex.WXSDKManager.getInstanceViewPortWidth(getInstanceId()), getInstance());
                    return wXAnimationBean;
                }
            } catch (java.lang.RuntimeException e) {
                com.taobao.weex.utils.WXLogUtils.e("", e);
            }
        }
        return null;
    }

    public void lazy(boolean z) {
        this.mLazy = z;
    }

    public long getRenderObjectPtr() {
        if (getBasicComponentData().isRenderPtrEmpty()) {
            getBasicComponentData().setRenderObjectPr(com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils.nativeGetRenderObject(getInstanceId(), getRef()));
        }
        return getBasicComponentData().getRenderObjectPr();
    }

    public void updateNativeAttr(java.lang.String str, java.lang.Object obj) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            obj = "";
        }
        getBasicComponentData().getAttrs().put(str, obj);
        com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils.nativeUpdateRenderObjectAttr(getRenderObjectPtr(), str, obj.toString());
    }

    public void nativeUpdateAttrs(java.util.Map<java.lang.String, java.lang.Object> map) {
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                updateNativeAttr(entry.getKey(), entry.getValue());
            }
        }
    }

    public void updateNativeStyle(java.lang.String str, java.lang.Object obj) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            obj = "";
        }
        getBasicComponentData().getStyles().put(str, obj);
        com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils.nativeUpdateRenderObjectStyle(getRenderObjectPtr(), str, obj.toString());
    }

    public void updateNativeStyles(java.util.Map<java.lang.String, java.lang.Object> map) {
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                updateNativeStyle(entry.getKey(), entry.getValue());
            }
        }
    }

    public void addLayerOverFlowListener(java.lang.String str) {
        if (getInstance() != null) {
            getInstance().addLayerOverFlowListener(str);
        }
    }

    public void removeLayerOverFlowListener(java.lang.String str) {
        if (getInstance() != null) {
            getInstance().removeLayerOverFlowListener(str);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "hoverClass")
    public void hoverClass(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        if (object != null) {
            io.dcloud.weex.ViewHover viewHover = this.mHover;
            if (viewHover == null) {
                this.mHover = new io.dcloud.weex.ViewHover(this, object);
            } else {
                viewHover.update(object);
            }
            if (getEvents().contains(io.dcloud.weex.ViewHover.VIEW_HOVER_EVENT)) {
                return;
            }
            addEvent(io.dcloud.weex.ViewHover.VIEW_HOVER_EVENT);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "hoverStopPropagation")
    public void hoverStopPropagation(boolean z) {
        if (this.mHover == null) {
            this.mHover = new io.dcloud.weex.ViewHover(this);
        }
        this.mHover.setHoverStopPropagation(z);
        if (!getEvents().contains(io.dcloud.weex.ViewHover.VIEW_HOVER_EVENT)) {
            addEvent(io.dcloud.weex.ViewHover.VIEW_HOVER_EVENT);
        }
        if (this.mParent == null || !z) {
            return;
        }
        this.mParent.setHoverReceiveTouch(false);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "hoverStartTime")
    public void hoverStartTime(int i) {
        if (this.mHover == null) {
            this.mHover = new io.dcloud.weex.ViewHover(this);
        }
        this.mHover.setHoverStartTime(i);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "hoverStayTime")
    public void hoverStayTime(int i) {
        if (this.mHover == null) {
            this.mHover = new io.dcloud.weex.ViewHover(this);
        }
        this.mHover.setHoverStayTime(i);
    }

    public void setHoverClassStatus(boolean z) {
        java.util.Map<java.lang.String, java.lang.Object> mapUpdateStatusAndGetUpdateStyles = this.mHover.updateStatusAndGetUpdateStyles(z);
        if (mapUpdateStatusAndGetUpdateStyles != null) {
            if (z) {
                boolean zContains = mapUpdateStatusAndGetUpdateStyles.keySet().contains("width");
                boolean zContains2 = mapUpdateStatusAndGetUpdateStyles.keySet().contains("height");
                if (zContains || zContains2) {
                    this.mPseudoResetGraphicSize = new com.taobao.weex.ui.action.GraphicSize(getLayoutSize().getWidth(), getLayoutSize().getHeight());
                }
                if (zContains) {
                    getLayoutSize().setWidth(com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.parseFloat(mapUpdateStatusAndGetUpdateStyles.get("width")), getViewPortWidthForFloat()));
                } else if (zContains2) {
                    getLayoutSize().setHeight(com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.parseFloat(mapUpdateStatusAndGetUpdateStyles.get("height")), getViewPortWidthForFloat()));
                }
            } else {
                com.taobao.weex.ui.action.GraphicSize graphicSize = this.mPseudoResetGraphicSize;
                if (graphicSize != null) {
                    setLayoutSize(graphicSize);
                }
            }
        }
        updateStyleByPesudo(mapUpdateStatusAndGetUpdateStyles);
    }

    public void setHoverReceiveTouch(boolean z) {
        if (getHover() != null) {
            getHover().setReceiveTouch(z);
        }
        if (this.mParent != null) {
            this.mParent.setHoverReceiveTouch(z);
        }
    }

    public io.dcloud.weex.ViewHover getHover() {
        return this.mHover;
    }

    public boolean isPreventGesture() {
        return this.isPreventGesture;
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "preventGesture")
    public void setPreventGesture(boolean z) {
        this.isPreventGesture = z;
        addEvent("preventGesture");
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    public float getViewPortWidthForFloat() {
        if (getInstance() != null) {
            return getInstance().getInstanceViewPortWidthWithFloat();
        }
        return 720.0f;
    }
}
