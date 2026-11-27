package io.dcloud.uts.component;

/* JADX INFO: compiled from: UTSComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B/\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u001bH\u0014¢\u0006\u0002\u0010\"J\u0015\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0018J\b\u0010&\u001a\u00020$H\u0014J\b\u0010'\u001a\u00020$H\u0016J\b\u0010(\u001a\u00020$H\u0014J\u001c\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u000f2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\u001e\u00106\u001a\u00020$2\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000205\u0018\u000108H\u0016J\u0006\u00109\u001a\u00020$J\u001c\u0010:\u001a\u00020$2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020508H\u0016J\u0014\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0=H\u0016J\b\u0010>\u001a\u00020$H\u0016J\b\u0010?\u001a\u00020$H\u0016J\r\u0010@\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0016J\b\u0010A\u001a\u00020$H\u0016J\b\u0010B\u001a\u00020$H\u0016J\b\u0010C\u001a\u00020$H\u0016J\b\u0010D\u001a\u00020$H\u0016J\b\u0010E\u001a\u00020$H\u0016J\u0010\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020GH\u0017J\u0018\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020JH\u0016J\u001c\u0010K\u001a\u00020$2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002050LH\u0016J`\u0010Y\u001a\u00020$\"\u0004\b\u0001\u0010\u00012\u0006\u0010Z\u001a\u00020\u000f2@\u0010[\u001a<\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\\\u0012\b\bZ\u0012\u0004\b\b(]\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\\\u0012\b\bZ\u0012\u0004\b\b(^\u0012\u0004\u0012\u00020$0Oj\b\u0012\u0004\u0012\u0002H\u0001`P2\b\b\u0002\u0010_\u001a\u000202JK\u0010Y\u001a\u00020$\"\u0004\b\u0001\u0010\u00012\u0006\u0010Z\u001a\u00020\u000f2+\u0010[\u001a'\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\\\u0012\b\bZ\u0012\u0004\b\b(]\u0012\u0004\u0012\u00020$0Rj\b\u0012\u0004\u0012\u0002H\u0001`S2\b\b\u0002\u0010_\u001a\u000202J6\u0010Y\u001a\u00020$\"\u0004\b\u0001\u0010\u00012\u0006\u0010Z\u001a\u00020\u000f2\u0016\u0010[\u001a\u0012\u0012\u0004\u0012\u00020$0Uj\b\u0012\u0004\u0012\u0002H\u0001`V2\b\b\u0002\u0010_\u001a\u000202J\u0018\u0010e\u001a\u00020$2\u0006\u0010Z\u001a\u00020\u000f2\b\u0010f\u001a\u0004\u0018\u000105J\b\u0010g\u001a\u00020$H\u0016J\u0010\u0010h\u001a\u00020$2\u0006\u0010i\u001a\u00020\u000fH\u0016J\u0018\u0010h\u001a\u00020$2\u0006\u0010i\u001a\u00020\u000f2\u0006\u0010j\u001a\u000205H\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R6\u0010M\u001a*\u0012\u0004\u0012\u00020\u000f\u0012 \u0012\u001e\u0012\u001a\u0012\u0018\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020$0Oj\u0006\u0012\u0002\b\u0003`P0N08X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010Q\u001a&\u0012\u0004\u0012\u00020\u000f\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020$0Rj\u0006\u0012\u0002\b\u0003`S0N08X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010T\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020$0Uj\u0006\u0012\u0002\b\u0003`V0N08X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020\u000f0XX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010`\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010508X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d¨\u0006k"}, d2 = {"Lio/dcloud/uts/component/UTSComponent;", "T", "Landroid/view/View;", "Lio/dcloud/feature/uniapp/ui/component/UniComponent;", "Lio/dcloud/uts/component/IUTSComWrap;", "Lio/dcloud/uts/component/IMeasureAble;", "instance", "Lio/dcloud/feature/uniapp/UniSDKInstance;", "parent", "Lio/dcloud/feature/uniapp/ui/component/AbsVContainer;", "componentData", "Lio/dcloud/feature/uniapp/ui/action/AbsComponentData;", "<init>", "(Lio/dcloud/feature/uniapp/UniSDKInstance;Lio/dcloud/feature/uniapp/ui/component/AbsVContainer;Lio/dcloud/feature/uniapp/ui/action/AbsComponentData;)V", "refLocal", "", "getRefLocal", "()Ljava/lang/String;", "setRefLocal", "(Ljava/lang/String;)V", "$el", "get$el", "()Landroid/view/View;", "set$el", "(Landroid/view/View;)V", "Landroid/view/View;", "$androidContext", "Landroid/content/Context;", "get$androidContext", "()Landroid/content/Context;", "set$androidContext", "(Landroid/content/Context;)V", "initComponentHostView", "context", "(Landroid/content/Context;)Landroid/view/View;", "onHostViewInitialized", "", "host", "onFinishLayout", com.taobao.weex.common.Constants.Event.SLOT_LIFECYCLE.DESTORY, "createViewImpl", "allProperty", "", "Ljava/lang/reflect/Field;", "getAllProperty", "()[Ljava/lang/reflect/Field;", "setAllProperty", "([Ljava/lang/reflect/Field;)V", "[Ljava/lang/reflect/Field;", "setProperty", "", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "param", "", "updateStyles", "styles", "", "utsForceUpdate", "updateUTSProperty", com.taobao.weex.ui.component.list.template.TemplateDom.KEY_ATTRS, "getUTSPropertyTypeMap", "", "created", "NVBeforeLoad", "NVLoad", "NVLoaded", "NVLayouted", "NVBeforeUnload", "NVUnloaded", "unmounted", "NVMeasure", "Lio/dcloud/uts/component/UTSSize;", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "mode", "Lio/dcloud/uts/component/UTSMeasureMode;", "NVUpdateStyles", "Lio/dcloud/uts/Map;", "watchList", "", "Lkotlin/Function2;", "Lio/dcloud/uts/component/Watcher;", "watchOneParamList", "Lkotlin/Function1;", "Lio/dcloud/uts/component/WatcherOneParam;", "watchNoParamList", "Lkotlin/Function0;", "Lio/dcloud/uts/component/WatcherNoParam;", "immediateWatchKeys", "", "$watch", "name", "watcher", "Lkotlin/ParameterName;", "newValue", "oldValue", "immediate", "componentPropertyMap", "getComponentPropertyMap", "()Ljava/util/Map;", "setComponentPropertyMap", "(Ljava/util/Map;)V", "$componentWatchDispatch", "value", "$init", "$emit", "event", "userInput", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class UTSComponent<T extends android.view.View> extends io.dcloud.feature.uniapp.ui.component.UniComponent<T> implements io.dcloud.uts.component.IUTSComWrap<T>, io.dcloud.uts.component.IMeasureAble {
    private android.content.Context $androidContext;
    private T $el;
    private java.lang.reflect.Field[] allProperty;
    private java.util.Map<java.lang.String, java.lang.Object> componentPropertyMap;
    private final java.util.Set<java.lang.String> immediateWatchKeys;
    private java.lang.String refLocal;
    private java.util.Map<java.lang.String, java.util.List<kotlin.jvm.functions.Function2<?, ?, kotlin.Unit>>> watchList;
    private java.util.Map<java.lang.String, java.util.List<kotlin.jvm.functions.Function0<kotlin.Unit>>> watchNoParamList;
    private java.util.Map<java.lang.String, java.util.List<kotlin.jvm.functions.Function1<?, kotlin.Unit>>> watchOneParamList;

    public void $init() {
    }

    public void NVBeforeLoad() {
    }

    public void NVBeforeUnload() {
    }

    public void NVLayouted() {
    }

    public abstract T NVLoad();

    public void NVLoaded() {
    }

    @Override // io.dcloud.uts.component.IMeasureAble
    @kotlin.Deprecated(message = "use NVMeasure(size:UTSSize,mode:UTSMeasureMode) instead", replaceWith = @kotlin.ReplaceWith(expression = "NVMeasure(size,mode)", imports = {}))
    public io.dcloud.uts.component.UTSSize NVMeasure(io.dcloud.uts.component.UTSSize size) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(size, "size");
        return size;
    }

    @Override // io.dcloud.uts.component.IMeasureAble
    public io.dcloud.uts.component.UTSSize NVMeasure(io.dcloud.uts.component.UTSSize size, io.dcloud.uts.component.UTSMeasureMode mode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(size, "size");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mode, "mode");
        return size;
    }

    public void NVUnloaded() {
    }

    public void NVUpdateStyles(io.dcloud.uts.Map<java.lang.String, java.lang.Object> styles) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(styles, "styles");
    }

    public void created() {
    }

    public void unmounted() {
    }

    public void updateUTSProperty(java.util.Map<java.lang.String, java.lang.Object> attrs) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    @Override // io.dcloud.uts.component.IUTSComWrap
    public void wrapComponentHostView(android.view.View view, com.taobao.weex.ui.component.WXComponent<?> wXComponent) {
        io.dcloud.uts.component.IUTSComWrap.CC.$default$wrapComponentHostView(this, view, wXComponent);
    }

    public final java.lang.String getRefLocal() {
        return this.refLocal;
    }

    public final void setRefLocal(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.refLocal = str;
    }

    public final T get$el() {
        return this.$el;
    }

    public final void set$el(T t) {
        this.$el = t;
    }

    public final android.content.Context get$androidContext() {
        return this.$androidContext;
    }

    public final void set$androidContext(android.content.Context context) {
        this.$androidContext = context;
    }

    public UTSComponent(io.dcloud.feature.uniapp.UniSDKInstance uniSDKInstance, io.dcloud.feature.uniapp.ui.component.AbsVContainer<?> absVContainer, io.dcloud.feature.uniapp.ui.action.AbsComponentData<?> absComponentData) {
        super(uniSDKInstance, absVContainer, absComponentData);
        this.refLocal = "";
        this.$androidContext = getContext();
        this.allProperty = new java.lang.reflect.Field[0];
        this.watchList = new java.util.LinkedHashMap();
        this.watchOneParamList = new java.util.LinkedHashMap();
        this.watchNoParamList = new java.util.LinkedHashMap();
        this.immediateWatchKeys = new java.util.LinkedHashSet();
        this.componentPropertyMap = new java.util.LinkedHashMap();
        try {
            created();
        } catch (java.lang.Exception e) {
            io.dcloud.uts.console.INSTANCE.errorV1(e);
            e.printStackTrace();
        }
        java.lang.String ref = getRef();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ref, "getRef(...)");
        this.refLocal = ref;
        this.$androidContext = getContext();
        setContentBoxMeasurement(new com.taobao.weex.layout.ContentBoxMeasurement(this) { // from class: io.dcloud.uts.component.UTSComponent.1
            final /* synthetic */ io.dcloud.uts.component.UTSComponent<T> this$0;

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutAfter(float computedWidth, float computedHeight) {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutBefore() {
            }

            {
                this.this$0 = this;
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void measureInternal(float width, float height, int widthMeasureMode, int heightMeasureMode) {
                io.dcloud.uts.component.UTSSize uTSSizeNVMeasure = this.this$0.NVMeasure(new io.dcloud.uts.component.UTSSize(width, height), new io.dcloud.uts.component.UTSMeasureMode(widthMeasureMode, heightMeasureMode));
                this.mMeasureWidth = uTSSizeNVMeasure.getWidth();
                this.mMeasureHeight = uTSSizeNVMeasure.getHeight();
            }
        });
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected T initComponentHostView(android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        try {
            return (T) NVLoad();
        } catch (java.lang.Exception e) {
            io.dcloud.uts.console.INSTANCE.errorV1(e);
            e.printStackTrace();
            throw new java.lang.IllegalStateException("initComponentView error");
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected void onHostViewInitialized(T host) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(host, "host");
        this.$el = getHostView();
        try {
            NVLoaded();
        } catch (java.lang.Exception e) {
            io.dcloud.uts.console.INSTANCE.errorV1(e);
            e.printStackTrace();
        }
        super.onHostViewInitialized(host);
        try {
            $init();
        } catch (java.lang.Exception e2) {
            io.dcloud.uts.console.INSTANCE.errorV1(e2);
            e2.printStackTrace();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected void onFinishLayout() {
        super.onFinishLayout();
        try {
            NVLayouted();
        } catch (java.lang.Exception e) {
            io.dcloud.uts.console.INSTANCE.errorV1(e);
            e.printStackTrace();
        }
    }

    @Override // io.dcloud.feature.uniapp.ui.component.UniComponent, com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        try {
            NVBeforeUnload();
        } catch (java.lang.Exception e) {
            io.dcloud.uts.console.INSTANCE.errorV1(e);
            e.printStackTrace();
        }
        super.destroy();
        try {
            NVUnloaded();
            unmounted();
        } catch (java.lang.Exception e2) {
            io.dcloud.uts.console.INSTANCE.errorV1(e2);
            e2.printStackTrace();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected void createViewImpl() {
        try {
            NVBeforeLoad();
        } catch (java.lang.Exception e) {
            io.dcloud.uts.console.INSTANCE.errorV1(e);
            e.printStackTrace();
        }
        super.createViewImpl();
    }

    public final java.lang.reflect.Field[] getAllProperty() {
        return this.allProperty;
    }

    public final void setAllProperty(java.lang.reflect.Field[] fieldArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fieldArr, "<set-?>");
        this.allProperty = fieldArr;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String key, java.lang.Object param) {
        java.lang.Integer numValueOf;
        try {
            if (super.setProperty(key, param)) {
                return true;
            }
            if (this.allProperty.length == 0) {
                java.lang.reflect.Field[] declaredFields = getClass().getDeclaredFields();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
                this.allProperty = declaredFields;
            }
            java.lang.reflect.Field field = null;
            for (java.lang.reflect.Field field2 : this.allProperty) {
                if (kotlin.jvm.internal.Intrinsics.areEqual(key, field2.getName())) {
                    field = field2;
                }
            }
            if (field == null) {
                return false;
            }
            if (kotlin.text.StringsKt.equals("boolean", field.getType().getName(), true)) {
                boolean z = java.lang.Boolean.parseBoolean(java.lang.String.valueOf(param));
                field.setAccessible(true);
                field.set(this, java.lang.Boolean.valueOf(z));
                kotlin.jvm.internal.Intrinsics.checkNotNull(key);
                $componentWatchDispatch(key, java.lang.Boolean.valueOf(z));
            } else if (kotlin.text.StringsKt.equals("java.lang.Number", field.getType().getName(), true)) {
                if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) java.lang.String.valueOf(param), (java.lang.CharSequence) com.taobao.weex.el.parse.Operators.DOT_STR, false, 2, (java.lang.Object) null)) {
                    numValueOf = java.lang.Double.valueOf(java.lang.Double.parseDouble(java.lang.String.valueOf(param)));
                } else {
                    numValueOf = java.lang.Integer.valueOf(java.lang.Integer.parseInt(java.lang.String.valueOf(param)));
                }
                field.setAccessible(true);
                field.set(this, numValueOf);
                kotlin.jvm.internal.Intrinsics.checkNotNull(key);
                $componentWatchDispatch(key, numValueOf);
            } else {
                if (!kotlin.text.StringsKt.equals("java.lang.String", field.getType().getName(), true)) {
                    return false;
                }
                field.setAccessible(true);
                field.set(this, param);
                kotlin.jvm.internal.Intrinsics.checkNotNull(key);
                $componentWatchDispatch(key, param);
            }
            return false;
        } catch (java.lang.Exception e) {
            io.dcloud.uts.console.INSTANCE.errorV1(e);
            e.printStackTrace();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void updateStyles(java.util.Map<java.lang.String, java.lang.Object> styles) {
        if (styles != null) {
            try {
                io.dcloud.uts.Map<java.lang.String, java.lang.Object> map = new io.dcloud.uts.Map<>();
                map.putAll(styles);
                NVUpdateStyles(map);
            } catch (java.lang.Exception e) {
                io.dcloud.uts.console.INSTANCE.errorV1(e);
                e.printStackTrace();
            }
        }
        super.updateStyles(styles);
    }

    public final void utsForceUpdate() {
        applyLayoutOnly();
    }

    public java.util.Map<java.lang.String, java.lang.String> getUTSPropertyTypeMap() {
        return new java.util.LinkedHashMap();
    }

    public static /* synthetic */ void $watch$default(io.dcloud.uts.component.UTSComponent uTSComponent, java.lang.String str, kotlin.jvm.functions.Function2 function2, boolean z, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: $watch");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        uTSComponent.$watch(str, function2, z);
    }

    public final <T> void $watch(java.lang.String name, kotlin.jvm.functions.Function2<? super T, ? super T, kotlin.Unit> watcher, boolean immediate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(watcher, "watcher");
        java.util.ArrayList arrayList = this.watchList.get(name);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList();
            this.watchList.put(name, arrayList);
        }
        arrayList.add(watcher);
        if (immediate) {
            this.immediateWatchKeys.add(name);
        }
    }

    public static /* synthetic */ void $watch$default(io.dcloud.uts.component.UTSComponent uTSComponent, java.lang.String str, kotlin.jvm.functions.Function1 function1, boolean z, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: $watch");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        uTSComponent.$watch(str, function1, z);
    }

    public final <T> void $watch(java.lang.String name, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> watcher, boolean immediate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(watcher, "watcher");
        java.util.ArrayList arrayList = this.watchOneParamList.get(name);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList();
            this.watchOneParamList.put(name, arrayList);
        }
        arrayList.add(watcher);
        if (immediate) {
            this.immediateWatchKeys.add(name);
        }
    }

    public static /* synthetic */ void $watch$default(io.dcloud.uts.component.UTSComponent uTSComponent, java.lang.String str, kotlin.jvm.functions.Function0 function0, boolean z, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: $watch");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        uTSComponent.$watch(str, (kotlin.jvm.functions.Function0<kotlin.Unit>) function0, z);
    }

    public final <T> void $watch(java.lang.String name, kotlin.jvm.functions.Function0<kotlin.Unit> watcher, boolean immediate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(watcher, "watcher");
        java.util.ArrayList arrayList = this.watchNoParamList.get(name);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList();
            this.watchNoParamList.put(name, arrayList);
        }
        arrayList.add(watcher);
        if (immediate) {
            this.immediateWatchKeys.add(name);
        }
    }

    public final java.util.Map<java.lang.String, java.lang.Object> getComponentPropertyMap() {
        return this.componentPropertyMap;
    }

    public final void setComponentPropertyMap(java.util.Map<java.lang.String, java.lang.Object> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.componentPropertyMap = map;
    }

    public final void $componentWatchDispatch(java.lang.String name, java.lang.Object value) {
        java.util.List<kotlin.jvm.functions.Function0<kotlin.Unit>> list;
        java.util.List<kotlin.jvm.functions.Function1<?, kotlin.Unit>> list2;
        java.util.List<kotlin.jvm.functions.Function2<?, ?, kotlin.Unit>> list3;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        java.lang.Object obj = this.componentPropertyMap.get(name);
        if (obj == null) {
            obj = value;
        }
        if (this.watchList.containsKey(name) && (list3 = this.watchList.get(name)) != null) {
            java.util.Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                kotlin.jvm.functions.Function2 function2 = (kotlin.jvm.functions.Function2) it.next();
                kotlin.jvm.internal.Intrinsics.checkNotNull(function2, "null cannot be cast to non-null type kotlin.Function2<@[ParameterName(name = \"newValue\")] kotlin.Any?, @[ParameterName(name = \"oldValue\")] kotlin.Any?, kotlin.Unit>");
                ((kotlin.jvm.functions.Function2) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(value, obj);
            }
        }
        if (this.watchOneParamList.containsKey(name) && (list2 = this.watchOneParamList.get(name)) != null) {
            java.util.Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                kotlin.jvm.functions.Function1 function1 = (kotlin.jvm.functions.Function1) it2.next();
                kotlin.jvm.internal.Intrinsics.checkNotNull(function1, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"newValue\")] kotlin.Any?, kotlin.Unit>");
                ((kotlin.jvm.functions.Function1) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke2(value);
            }
        }
        if (this.watchNoParamList.containsKey(name) && (list = this.watchNoParamList.get(name)) != null) {
            java.util.Iterator<T> it3 = list.iterator();
            while (it3.hasNext()) {
                kotlin.jvm.functions.Function0 function0 = (kotlin.jvm.functions.Function0) it3.next();
                kotlin.jvm.internal.Intrinsics.checkNotNull(function0, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
                ((kotlin.jvm.functions.Function0) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(function0, 0)).invoke();
            }
        }
        this.componentPropertyMap.put(name, value);
    }

    public void $emit(java.lang.String event) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        fireEvent(event);
    }

    public void $emit(java.lang.String event, java.lang.Object userInput) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(userInput, "userInput");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put("detail", userInput);
        fireEvent(event, kotlin.collections.MapsKt.toMap(linkedHashMap));
    }
}
