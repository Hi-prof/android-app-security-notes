package uts.sdk.modules.DCloudUniPrompt;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0004\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020<H\u0016J\u0010\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020<H\u0016J\b\u0010B\u001a\u00020<H\u0016J\b\u0010C\u001a\u00020<H\u0016J\u0010\u0010D\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020HH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R+\u0010%\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010$\u001a\u0004\b&\u0010 \"\u0004\b'\u0010\"R\u001a\u0010)\u001a\u00020*X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Luts/sdk/modules/DCloudUniPrompt/WaitingView;", "", "context", "Landroid/app/Activity;", "style", "Lio/dcloud/uts/UTSJSONObject;", com.taobao.weex.ui.component.WXBasicComponentType.VIEW, "Landroid/view/View;", "<init>", "(Landroid/app/Activity;Lio/dcloud/uts/UTSJSONObject;Landroid/view/View;)V", "Lcom/alibaba/fastjson/JSONObject;", "waitingView", "Landroid/view/ViewGroup;", "waitingRootView", "Landroid/widget/LinearLayout;", "textView", "Landroid/widget/TextView;", "mProgressBar", "Landroid/widget/ProgressBar;", "seaparatorView", "mImageView", "Landroid/widget/ImageView;", "height", "", "width", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_MASK, "", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "", "<set-?>", "screenWidth", "getScreenWidth", "()I", "setScreenWidth", "(I)V", "screenWidth$delegate", "Lkotlin/properties/ReadWriteProperty;", "ScreenHeight", "getScreenHeight", "setScreenHeight", "ScreenHeight$delegate", "density", "", "getDensity", "()Ljava/lang/Number;", "setDensity", "(Ljava/lang/Number;)V", "padding", "textSize", "loadingdDisplay", "loadingHeight", "LoadingIcon", "mBitmap", "Landroid/graphics/Bitmap;", "mpopWindow", "Landroid/widget/PopupWindow;", "currentHandler", "Landroid/os/Handler;", "hostView", "handlerArguments", "", "initView", "passThrough", "ev", "Landroid/view/MotionEvent;", "showWaiting", io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE, "makeBitmap", "getBestScale", "inputStreamToArray", "", "inputStream", "Ljava/io/InputStream;", "uni-prompt_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class WaitingView {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(uts.sdk.modules.DCloudUniPrompt.WaitingView.class, "screenWidth", "getScreenWidth()I", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(uts.sdk.modules.DCloudUniPrompt.WaitingView.class, "ScreenHeight", "getScreenHeight()I", 0))};
    private java.lang.String LoadingIcon;

    /* JADX INFO: renamed from: ScreenHeight$delegate, reason: from kotlin metadata */
    private final kotlin.properties.ReadWriteProperty ScreenHeight;
    private android.app.Activity context;
    private android.os.Handler currentHandler;
    private java.lang.Number density;
    private int height;
    private android.view.View hostView;
    private java.lang.Number loadingHeight;
    private java.lang.String loadingdDisplay;
    private android.graphics.Bitmap mBitmap;
    private android.widget.ImageView mImageView;
    private android.widget.ProgressBar mProgressBar;
    private boolean mask;
    private android.widget.PopupWindow mpopWindow;
    private int padding;

    /* JADX INFO: renamed from: screenWidth$delegate, reason: from kotlin metadata */
    private final kotlin.properties.ReadWriteProperty screenWidth;
    private android.view.View seaparatorView;
    private com.alibaba.fastjson.JSONObject style;
    private int textSize;
    private android.widget.TextView textView;
    private java.lang.String title;
    private android.widget.LinearLayout waitingRootView;
    private android.view.ViewGroup waitingView;
    private int width;

    public int getScreenWidth() {
        return ((java.lang.Number) this.screenWidth.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public void setScreenWidth(int i) {
        this.screenWidth.setValue(this, $$delegatedProperties[0], java.lang.Integer.valueOf(i));
    }

    public int getScreenHeight() {
        return ((java.lang.Number) this.ScreenHeight.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public void setScreenHeight(int i) {
        this.ScreenHeight.setValue(this, $$delegatedProperties[1], java.lang.Integer.valueOf(i));
    }

    public java.lang.Number getDensity() {
        return this.density;
    }

    public void setDensity(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.density = number;
    }

    public WaitingView(android.app.Activity activity, io.dcloud.uts.UTSJSONObject style, android.view.View view) throws java.io.IOException {
        android.content.res.Resources resources;
        android.content.res.Resources resources2;
        android.content.res.Resources resources3;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(style, "style");
        this.height = -2;
        this.width = -2;
        this.title = "";
        this.screenWidth = kotlin.properties.Delegates.INSTANCE.notNull();
        this.ScreenHeight = kotlin.properties.Delegates.INSTANCE.notNull();
        this.density = (java.lang.Number) 0;
        this.loadingdDisplay = "";
        this.loadingHeight = (java.lang.Number) 0;
        this.LoadingIcon = "";
        this.context = activity;
        com.alibaba.fastjson.JSON jSONObject = style.toJSONObject();
        kotlin.jvm.internal.Intrinsics.checkNotNull(jSONObject, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
        this.style = (com.alibaba.fastjson.JSONObject) jSONObject;
        android.util.DisplayMetrics displayMetrics = (activity == null || (resources3 = activity.getResources()) == null) ? null : resources3.getDisplayMetrics();
        kotlin.jvm.internal.Intrinsics.checkNotNull(displayMetrics);
        setScreenWidth(displayMetrics.widthPixels);
        android.util.DisplayMetrics displayMetrics2 = (activity == null || (resources2 = activity.getResources()) == null) ? null : resources2.getDisplayMetrics();
        kotlin.jvm.internal.Intrinsics.checkNotNull(displayMetrics2);
        setScreenHeight(displayMetrics2.heightPixels);
        android.util.DisplayMetrics displayMetrics3 = (activity == null || (resources = activity.getResources()) == null) ? null : resources.getDisplayMetrics();
        kotlin.jvm.internal.Intrinsics.checkNotNull(displayMetrics3);
        setDensity(java.lang.Float.valueOf(displayMetrics3.density));
        android.view.View viewInflate = android.view.LayoutInflater.from(activity).inflate(io.dcloud.uts.prompt.R.layout.uni_app_uni_prompt_loadingview, (android.view.ViewGroup) null, false);
        kotlin.jvm.internal.Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) viewInflate;
        this.waitingView = viewGroup;
        android.view.View viewFindViewById = viewGroup.findViewById(io.dcloud.uts.prompt.R.id.dcloud_pd_root);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.waitingRootView = (android.widget.LinearLayout) viewFindViewById;
        android.view.View viewFindViewById2 = this.waitingView.findViewById(io.dcloud.uts.prompt.R.id.dcloud_pb_loading);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mProgressBar = (android.widget.ProgressBar) viewFindViewById2;
        android.view.View viewFindViewById3 = this.waitingView.findViewById(io.dcloud.uts.prompt.R.id.dcloud_tv_loading);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.textView = (android.widget.TextView) viewFindViewById3;
        android.view.View viewFindViewById4 = this.waitingView.findViewById(io.dcloud.uts.prompt.R.id.dcloud_view_seaparator);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.seaparatorView = viewFindViewById4;
        android.view.View viewFindViewById5 = this.waitingView.findViewById(io.dcloud.uts.prompt.R.id.dcloud_iv_loading);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.mImageView = (android.widget.ImageView) viewFindViewById5;
        this.hostView = view;
        this.textView.setMaxLines(2);
        handlerArguments();
        android.view.ViewGroup.LayoutParams layoutParams = this.waitingRootView.getLayoutParams();
        kotlin.jvm.internal.Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        android.widget.LinearLayout.LayoutParams layoutParams2 = (android.widget.LinearLayout.LayoutParams) layoutParams;
        int i = this.width;
        layoutParams2.width = i > 0 ? io.dcloud.uts.NumberKt.times(java.lang.Integer.valueOf(i), getDensity()).intValue() : i;
        layoutParams2.height = -2;
        this.waitingRootView.setLayoutParams(layoutParams2);
        this.currentHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        initView();
        makeBitmap();
    }

    public void handlerArguments() {
        if (this.style.get("height") != null) {
            java.lang.Object obj = this.style.get("height");
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.height = io.dcloud.uts.NumberKt.parseInt$default((java.lang.String) obj, null, 2, null).intValue();
        }
        if (this.style.get("width") != null) {
            java.lang.Object obj2 = this.style.get("width");
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            this.width = io.dcloud.uts.NumberKt.parseInt$default((java.lang.String) obj2, null, 2, null).intValue();
        }
        if (this.style.get(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_MODAL) != null) {
            java.lang.Object obj3 = this.style.get(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_MODAL);
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            this.mask = ((java.lang.Boolean) obj3).booleanValue();
        }
        java.lang.Object obj4 = this.style.get("name");
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
        this.title = (java.lang.String) obj4;
        if (this.style.get("loading") != null) {
            java.lang.Object obj5 = this.style.get("loading");
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
            com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) obj5;
            java.lang.Object obj6 = jSONObject.get("display");
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.String");
            this.loadingdDisplay = (java.lang.String) obj6;
            if (jSONObject.get(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON) != null) {
                java.lang.Object obj7 = jSONObject.get(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON);
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.String");
                this.LoadingIcon = (java.lang.String) obj7;
            }
            if (jSONObject.get("height") != null) {
                java.lang.Object obj8 = jSONObject.get("height");
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.String");
                this.loadingHeight = java.lang.Integer.valueOf(io.dcloud.uts.NumberKt.parseInt$default((java.lang.String) obj8, null, 2, null).intValue());
            }
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_BLOCK, this.loadingdDisplay)) {
            this.waitingRootView.setOrientation(1);
            return;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_INLINE, this.loadingdDisplay)) {
            this.waitingRootView.setOrientation(0);
        } else if (kotlin.jvm.internal.Intrinsics.areEqual("none", this.loadingdDisplay)) {
            this.seaparatorView.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        }
    }

    public void initView() {
        this.textView.setTextColor(-1);
        this.textView.setGravity(17);
        this.textView.setText(this.title);
        this.textView.setTextSize(0, io.dcloud.uts.NumberKt.times((java.lang.Number) 16, getDensity()).floatValue());
        if (this.title.length() < 1) {
            this.textView.setVisibility(8);
            this.waitingRootView.setPadding(io.dcloud.uts.NumberKt.times((java.lang.Number) 10, getDensity()).intValue(), io.dcloud.uts.NumberKt.times((java.lang.Number) 40, getDensity()).intValue(), io.dcloud.uts.NumberKt.times((java.lang.Number) 10, getDensity()).intValue(), io.dcloud.uts.NumberKt.times((java.lang.Number) 30, getDensity()).intValue());
        } else {
            this.waitingRootView.setPadding(io.dcloud.uts.NumberKt.times((java.lang.Number) 10, getDensity()).intValue(), io.dcloud.uts.NumberKt.times((java.lang.Number) 20, getDensity()).intValue(), io.dcloud.uts.NumberKt.times((java.lang.Number) 10, getDensity()).intValue(), io.dcloud.uts.NumberKt.times((java.lang.Number) 20, getDensity()).intValue());
        }
        android.app.Activity activity = this.context;
        android.graphics.drawable.Drawable drawable = activity != null ? activity.getDrawable(io.dcloud.uts.prompt.R.drawable.uni_app_uni_prompt_circle_white_progress) : null;
        kotlin.jvm.internal.Intrinsics.checkNotNull(drawable);
        if (io.dcloud.uts.NumberKt.compareTo(this.loadingHeight, (java.lang.Number) 0) > 0) {
            this.mProgressBar.setLayoutParams(new android.widget.LinearLayout.LayoutParams(io.dcloud.uts.NumberKt.times(this.loadingHeight, getDensity()).intValue(), io.dcloud.uts.NumberKt.times(this.loadingHeight, getDensity()).intValue()));
        } else {
            int intrinsicHeight = (int) (((double) drawable.getIntrinsicHeight()) * 0.3d);
            this.mProgressBar.setLayoutParams(new android.widget.LinearLayout.LayoutParams(intrinsicHeight, intrinsicHeight));
        }
        this.mProgressBar.setIndeterminateDrawable(drawable);
        this.waitingRootView.setFocusable(true);
        this.waitingRootView.setAlpha(0.9f);
    }

    public boolean passThrough(android.view.MotionEvent ev) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(ev, "ev");
        android.app.Activity activity = this.context;
        if (activity == null) {
            return false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(activity);
        return activity.dispatchTouchEvent(ev);
    }

    public void showWaiting() {
        android.view.View view;
        int i;
        int i2;
        android.app.Activity activity = this.context;
        if (activity != null) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(activity);
            if (activity.isFinishing() || (view = this.hostView) == null) {
                return;
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(view);
            if (view.getWindowToken() == null) {
                return;
            }
            if (android.os.Build.VERSION.SDK_INT < 23 || !this.mask) {
                i = -2;
                i2 = -2;
            } else {
                this.mask = false;
                i = -1;
                i2 = -1;
            }
            android.widget.PopupWindow popupWindow = new android.widget.PopupWindow(this.waitingView, i, i2, this.mask);
            this.mpopWindow = popupWindow;
            android.view.View view2 = this.hostView;
            kotlin.jvm.internal.Intrinsics.checkNotNull(view2);
            popupWindow.showAtLocation(view2, 17, 0, 0);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setOnDismissListener(new uts.sdk.modules.DCloudUniPrompt.WaitingDismissListener());
            popupWindow.setTouchInterceptor(new uts.sdk.modules.DCloudUniPrompt.TouchInterceptorListener(this.mask));
        }
    }

    public void close() {
        android.widget.PopupWindow popupWindow = this.mpopWindow;
        if (popupWindow != null) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(popupWindow, "null cannot be cast to non-null type android.widget.PopupWindow");
            if (popupWindow.isShowing()) {
                android.os.Handler handler = this.currentHandler;
                android.widget.PopupWindow popupWindow2 = this.mpopWindow;
                kotlin.jvm.internal.Intrinsics.checkNotNull(popupWindow2, "null cannot be cast to non-null type android.widget.PopupWindow");
                handler.post(new uts.sdk.modules.DCloudUniPrompt.MainThreadRunnable(popupWindow2));
            }
        }
        if (this.mBitmap != null) {
            this.mBitmap = null;
        }
    }

    public void makeBitmap() throws java.io.IOException {
        java.lang.String resourcePath;
        java.lang.String str = this.LoadingIcon;
        if (str != null) {
            byte[] bArrInputStreamToArray = null;
            bArrInputStreamToArray = null;
            bArrInputStreamToArray = null;
            if (kotlin.jvm.internal.Intrinsics.areEqual(str, "successIcon")) {
                android.app.Activity activity = this.context;
                android.content.res.Resources resources = activity != null ? activity.getResources() : null;
                kotlin.jvm.internal.Intrinsics.checkNotNull(resources);
                kotlin.jvm.internal.Intrinsics.checkNotNull(resources);
                java.io.InputStream inputStreamOpen = resources.getAssets().open("uni-uts/uni-prompt/uni_app_toast_success.png");
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
                bArrInputStreamToArray = inputStreamToArray(inputStreamOpen);
            } else if (kotlin.jvm.internal.Intrinsics.areEqual(this.LoadingIcon, "errorIcon")) {
                android.app.Activity activity2 = this.context;
                android.content.res.Resources resources2 = activity2 != null ? activity2.getResources() : null;
                kotlin.jvm.internal.Intrinsics.checkNotNull(resources2);
                kotlin.jvm.internal.Intrinsics.checkNotNull(resources2);
                java.io.InputStream inputStreamOpen2 = resources2.getAssets().open("uni-uts/uni-prompt/uni_app_toast_error.png");
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inputStreamOpen2, "open(...)");
                bArrInputStreamToArray = inputStreamToArray(inputStreamOpen2);
            } else {
                if (this.LoadingIcon.length() <= 0) {
                    return;
                }
                if (kotlin.text.StringsKt.startsWith$default(this.LoadingIcon, io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, false, 2, (java.lang.Object) null)) {
                    resourcePath = io.dcloud.uts.StringKt.replace(this.LoadingIcon, io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, "");
                } else {
                    resourcePath = io.dcloud.uts.UTSAndroid.INSTANCE.getResourcePath(this.LoadingIcon);
                }
                if (resourcePath != null && resourcePath.length() > 0) {
                    if (kotlin.text.StringsKt.startsWith$default(resourcePath, "/android_asset/", false, 2, (java.lang.Object) null)) {
                        java.lang.String strSlice$default = io.dcloud.uts.StringKt.slice$default(resourcePath, (java.lang.Number) 15, null, 2, null);
                        android.app.Activity activity3 = this.context;
                        android.content.res.Resources resources3 = activity3 != null ? activity3.getResources() : null;
                        kotlin.jvm.internal.Intrinsics.checkNotNull(resources3);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(resources3);
                        java.io.InputStream inputStreamOpen3 = resources3.getAssets().open(strSlice$default);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inputStreamOpen3, "open(...)");
                        bArrInputStreamToArray = inputStreamToArray(inputStreamOpen3);
                    } else {
                        try {
                            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(new java.io.File(resourcePath));
                            bArrInputStreamToArray = inputStreamToArray(fileInputStream);
                            fileInputStream.close();
                        } catch (java.lang.Throwable unused) {
                        }
                    }
                }
            }
            if (bArrInputStreamToArray == null || bArrInputStreamToArray.length == 0) {
                return;
            }
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeByteArray(bArrInputStreamToArray, 0, bArrInputStreamToArray.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            options.inSampleSize = getBestScale(i2);
            options.inJustDecodeBounds = false;
            this.mBitmap = android.graphics.BitmapFactory.decodeByteArray(bArrInputStreamToArray, 0, bArrInputStreamToArray.length, options);
            this.mProgressBar.setVisibility(8);
            this.mImageView.setVisibility(0);
            this.mImageView.setImageBitmap(this.mBitmap);
            if (i % i2 != 0) {
                return;
            }
            android.view.ViewGroup.LayoutParams layoutParams = this.mImageView.getLayoutParams();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(layoutParams, "getLayoutParams(...)");
            if (io.dcloud.uts.NumberKt.compareTo(this.loadingHeight, (java.lang.Number) 0) > 0) {
                layoutParams.height = io.dcloud.uts.NumberKt.times(this.loadingHeight, getDensity()).intValue();
                layoutParams.width = io.dcloud.uts.NumberKt.times(this.loadingHeight, getDensity()).intValue();
            } else {
                android.graphics.Bitmap bitmap = this.mBitmap;
                kotlin.jvm.internal.Intrinsics.checkNotNull(bitmap);
                kotlin.jvm.internal.Intrinsics.checkNotNull(bitmap);
                layoutParams.width = bitmap.getHeight();
                android.graphics.Bitmap bitmap2 = this.mBitmap;
                kotlin.jvm.internal.Intrinsics.checkNotNull(bitmap2);
                kotlin.jvm.internal.Intrinsics.checkNotNull(bitmap2);
                layoutParams.height = bitmap2.getHeight();
            }
            this.mImageView.setLayoutParams(layoutParams);
        }
    }

    public int getBestScale(int height) {
        java.lang.Number numberMinus = io.dcloud.uts.NumberKt.minus(io.dcloud.uts.Math.min(java.lang.Integer.valueOf(getScreenWidth()), java.lang.Integer.valueOf(getScreenHeight())), io.dcloud.uts.NumberKt.times((java.lang.Number) 20, getDensity()));
        if (io.dcloud.uts.NumberKt.compareTo(numberMinus, (java.lang.Number) 0) <= 0 || io.dcloud.uts.NumberKt.compareTo(java.lang.Integer.valueOf(height), numberMinus) <= 0) {
            return 1;
        }
        return io.dcloud.uts.NumberKt.div(java.lang.Integer.valueOf(height), numberMinus).intValue();
    }

    public byte[] inputStreamToArray(java.io.InputStream inputStream) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
