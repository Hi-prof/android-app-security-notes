package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXText extends com.taobao.weex.ui.component.WXComponent<com.taobao.weex.ui.view.WXTextView> implements com.taobao.weex.ui.flat.FlatComponent<com.taobao.weex.ui.flat.widget.TextWidget> {
    private java.lang.String mFontFamily;
    private com.taobao.weex.ui.flat.widget.TextWidget mTextWidget;
    private android.content.BroadcastReceiver mTypefaceObserver;

    @Override // com.taobao.weex.ui.flat.FlatComponent
    public boolean promoteToView(boolean z) {
        if (getInstance().getFlatUIContext() != null) {
            return getInstance().getFlatUIContext().promoteToView(this, z, com.taobao.weex.ui.component.WXText.class);
        }
        return false;
    }

    @Override // com.taobao.weex.ui.flat.FlatComponent
    public com.taobao.weex.ui.flat.widget.TextWidget getOrCreateFlatWidget() {
        if (this.mTextWidget == null) {
            this.mTextWidget = new com.taobao.weex.ui.flat.widget.TextWidget(getInstance().getFlatUIContext());
        }
        return this.mTextWidget;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean isVirtualComponent() {
        return true ^ promoteToView(true);
    }

    public static class Creator implements com.taobao.weex.ui.ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public com.taobao.weex.ui.component.WXComponent createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
            return new com.taobao.weex.ui.component.WXText(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    @java.lang.Deprecated
    public WXText(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    public WXText(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        setContentBoxMeasurement(new com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.view.WXTextView initComponentHostView(android.content.Context context) {
        com.taobao.weex.ui.view.WXTextView wXTextView = new com.taobao.weex.ui.view.WXTextView(context);
        wXTextView.holdComponent(this);
        return wXTextView;
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    public void updateExtra(java.lang.Object obj) {
        super.updateExtra(obj);
        if (obj instanceof android.text.Layout) {
            android.text.Layout layout = (android.text.Layout) obj;
            if (!promoteToView(true)) {
                getOrCreateFlatWidget().updateTextDrawable(layout);
            } else {
                if (getHostView() == null || obj.equals(getHostView().getTextLayout())) {
                    return;
                }
                getHostView().setTextLayout(layout);
                getHostView().invalidate();
            }
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected void setAriaLabel(java.lang.String str) {
        com.taobao.weex.ui.view.WXTextView hostView = getHostView();
        if (hostView != null) {
            hostView.setAriaLabel(str);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void refreshData(com.taobao.weex.ui.component.WXComponent wXComponent) {
        super.refreshData(wXComponent);
        if (wXComponent instanceof com.taobao.weex.ui.component.WXText) {
            updateExtra(wXComponent.getExtra());
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "fontFamily":
                if (obj != null) {
                    registerTypefaceObserver(obj.toString());
                    break;
                }
            case "fontStyle":
            case "textAlign":
            case "textDecoration":
            case "fontWeight":
            case "lineHeight":
            case "color":
            case "lines":
            case "value":
            case "textOverflow":
            case "fontSize":
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected java.lang.Object convertEmptyProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        if (str.equals("color")) {
            return "black";
        }
        if (str.equals(com.taobao.weex.common.Constants.Name.FONT_SIZE)) {
            return java.lang.Integer.valueOf(getInstance().getDefaultFontSize());
        }
        return super.convertEmptyProperty(str, obj);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected void createViewImpl() {
        if (promoteToView(true)) {
            super.createViewImpl();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        if (com.taobao.weex.WXEnvironment.getApplication() == null || this.mTypefaceObserver == null) {
            return;
        }
        com.taobao.weex.utils.WXLogUtils.d("WXText", "Unregister the typeface observer");
        androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(com.taobao.weex.WXEnvironment.getApplication()).unregisterReceiver(this.mTypefaceObserver);
        this.mTypefaceObserver = null;
    }

    private void registerTypefaceObserver(java.lang.String str) {
        if (com.taobao.weex.WXEnvironment.getApplication() == null) {
            com.taobao.weex.utils.WXLogUtils.w("WXText", "ApplicationContent is null on register typeface observer");
            return;
        }
        this.mFontFamily = str;
        if (this.mTypefaceObserver != null) {
            return;
        }
        this.mTypefaceObserver = new android.content.BroadcastReceiver() { // from class: com.taobao.weex.ui.component.WXText.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(android.content.Context context, android.content.Intent intent) {
                com.taobao.weex.utils.FontDO fontDO;
                java.lang.String stringExtra = intent.getStringExtra(com.taobao.weex.common.Constants.Name.FONT_FAMILY);
                if (!com.taobao.weex.ui.component.WXText.this.mFontFamily.equals(stringExtra) || (fontDO = com.taobao.weex.utils.TypefaceUtil.getFontDO(stringExtra)) == null || fontDO.getTypeface() == null || com.taobao.weex.ui.component.WXText.this.getHostView() == null) {
                    return;
                }
                android.text.Layout textLayout = com.taobao.weex.ui.component.WXText.this.getHostView().getTextLayout();
                if (textLayout != null) {
                    textLayout.getPaint().setTypeface(fontDO.getTypeface());
                } else {
                    com.taobao.weex.utils.WXLogUtils.d("WXText", "Layout not created");
                }
                com.taobao.weex.bridge.WXBridgeManager.getInstance().markDirty(com.taobao.weex.ui.component.WXText.this.getInstanceId(), com.taobao.weex.ui.component.WXText.this.getRef(), true);
                com.taobao.weex.ui.component.WXText.this.forceRelayout();
            }
        };
        androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(com.taobao.weex.WXEnvironment.getApplication()).registerReceiver(this.mTypefaceObserver, new android.content.IntentFilter(com.taobao.weex.utils.TypefaceUtil.ACTION_TYPE_FACE_AVAILABLE));
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected void layoutDirectionDidChanged(boolean z) {
        forceRelayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceRelayout() {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.WXText.2
            @Override // java.lang.Runnable
            public void run() {
                if (com.taobao.weex.ui.component.WXText.this.contentBoxMeasurement instanceof com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement) {
                    ((com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement) com.taobao.weex.ui.component.WXText.this.contentBoxMeasurement).forceRelayout();
                }
            }
        });
    }
}
