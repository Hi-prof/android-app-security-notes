package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
public class DCTextArea extends com.taobao.weex.ui.component.DCWXInput {
    private com.taobao.weex.dom.WXAttr attr;
    private boolean isAutoHeight;
    private boolean isLineChange;
    boolean isShowConfirm;
    private com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener mOnFocusChangeListener;

    @Override // com.taobao.weex.ui.component.DCWXInput
    protected int getVerticalGravity() {
        return 48;
    }

    public DCTextArea(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        this.isAutoHeight = false;
        this.isLineChange = false;
        this.mOnFocusChangeListener = new com.taobao.weex.ui.component.DCTextArea.AnonymousClass2();
        this.isShowConfirm = true;
        this.attr = basicComponentData.getAttrs();
        setContentBoxMeasurement(new com.taobao.weex.layout.ContentBoxMeasurement() { // from class: com.taobao.weex.ui.component.DCTextArea.1
            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutAfter(float f, float f2) {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutBefore() {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void measureInternal(float f, float f2, int i, int i2) {
                if (com.taobao.weex.dom.CSSConstants.isUndefined(f)) {
                    this.mMeasureWidth = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(300.0f, com.taobao.weex.ui.component.DCTextArea.this.getInstance().getInstanceViewPortWidthWithFloat());
                }
                if (com.taobao.weex.dom.CSSConstants.isUndefined(f2)) {
                    if (com.taobao.weex.ui.component.DCTextArea.this.attr.containsKey("autoHeight") && com.taobao.weex.utils.WXUtils.getBoolean(com.taobao.weex.ui.component.DCTextArea.this.attr.get("autoHeight"), false).booleanValue()) {
                        this.mMeasureHeight = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.ui.component.DCTextArea.this.getInstance().getDefaultFontSize() * 1.4f, com.taobao.weex.ui.component.DCTextArea.this.getInstance().getInstanceViewPortWidthWithFloat());
                    } else {
                        this.mMeasureHeight = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(150.0f, com.taobao.weex.ui.component.DCTextArea.this.getInstance().getInstanceViewPortWidthWithFloat());
                    }
                }
            }
        });
    }

    @Override // com.taobao.weex.ui.component.DCWXInput, com.taobao.weex.ui.component.WXComponent
    public void addEvent(java.lang.String str) {
        super.addEvent(str);
        if (str.equals("linechange")) {
            this.isLineChange = true;
        }
    }

    /* JADX INFO: renamed from: com.taobao.weex.ui.component.DCTextArea$2, reason: invalid class name */
    class AnonymousClass2 implements com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener {
        int count = 0;

        AnonymousClass2() {
        }

        @Override // com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener
        public void onFocusChange(boolean z) {
            com.taobao.weex.ui.view.WXEditText hostView = com.taobao.weex.ui.component.DCTextArea.this.getHostView();
            if (hostView == null) {
                return;
            }
            java.util.HashMap map = new java.util.HashMap(1);
            java.util.HashMap map2 = new java.util.HashMap(1);
            map2.put("value", hostView.getText().toString());
            if (!z) {
                map2.put("cursor", java.lang.Integer.valueOf(hostView.getSelectionStart()));
                map.put("detail", map2);
                com.taobao.weex.ui.component.DCTextArea.this.fireEvent(com.taobao.weex.common.Constants.Event.BLUR, map);
            } else {
                if (com.taobao.weex.ui.component.DCTextArea.this.keyboardHeight == 0.0f) {
                    fireEventForFocus(hostView);
                    return;
                }
                map2.put("height", java.lang.Float.valueOf(com.taobao.weex.ui.component.DCTextArea.this.keyboardHeight));
                map2.put("value", hostView.getText().toString());
                map.put("detail", map2);
                com.taobao.weex.ui.component.DCTextArea.this.fireEvent(com.taobao.weex.common.Constants.Event.FOCUS, map);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fireEventForFocus(final android.widget.TextView textView) {
            com.taobao.weex.ui.component.DCTextArea.this.getHostView().postDelayed(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.DCTextArea.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.taobao.weex.ui.component.DCTextArea.this.keyboardHeight == 0.0f) {
                        com.taobao.weex.ui.component.DCTextArea.AnonymousClass2.this.count++;
                        if (com.taobao.weex.ui.component.DCTextArea.AnonymousClass2.this.count <= 3) {
                            com.taobao.weex.ui.component.DCTextArea.AnonymousClass2.this.fireEventForFocus(textView);
                            return;
                        }
                        java.util.HashMap map = new java.util.HashMap(1);
                        java.util.HashMap map2 = new java.util.HashMap(1);
                        map2.put("value", textView.getText().toString());
                        map2.put("height", java.lang.Float.valueOf(com.taobao.weex.ui.component.DCTextArea.this.keyboardHeight));
                        map.put("detail", map2);
                        com.taobao.weex.ui.component.DCTextArea.this.fireEvent(com.taobao.weex.common.Constants.Event.FOCUS, map);
                        return;
                    }
                    com.taobao.weex.ui.component.DCTextArea.AnonymousClass2.this.count = 0;
                    java.util.HashMap map3 = new java.util.HashMap(1);
                    java.util.HashMap map4 = new java.util.HashMap(1);
                    map4.put("value", textView.getText().toString());
                    map4.put("height", java.lang.Float.valueOf(com.taobao.weex.ui.component.DCTextArea.this.keyboardHeight));
                    map3.put("detail", map4);
                    com.taobao.weex.ui.component.DCTextArea.this.fireEvent(com.taobao.weex.common.Constants.Event.FOCUS, map3);
                }
            }, 200L);
        }
    }

    @Override // com.taobao.weex.ui.component.DCWXInput
    protected void setFocusAndBlur() {
        if (ismHasFocusChangeListener(this.mOnFocusChangeListener)) {
            return;
        }
        addFocusChangeListener(this.mOnFocusChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.DCWXInput, com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(com.taobao.weex.ui.view.WXEditText wXEditText) {
        this.isNeedConfirm = false;
        wXEditText.setAllowDisableMovement(false);
        super.onHostViewInitialized(wXEditText);
        try {
            com.taobao.weex.ui.component.ConfirmBar.getInstance().createConfirmBar(getContext(), io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(getInstance()).obtainApp());
            com.taobao.weex.ui.component.ConfirmBar.getInstance().addComponent(this);
        } catch (java.lang.Exception unused) {
        }
        if (this.attr.containsKey("autoHeight") && com.taobao.weex.utils.WXUtils.getBoolean(this.attr.get("autoHeight"), false).booleanValue()) {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().setStyleHeight(getInstanceId(), getRef(), com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(getInstance().getDefaultFontSize() * 1.4f, getInstance().getInstanceViewPortWidthWithFloat()));
        }
        watchLine();
    }

    private void watchLine() {
        addTextChangedListener(new android.text.TextWatcher() { // from class: com.taobao.weex.ui.component.DCTextArea.3
            int line = 0;

            @Override // android.text.TextWatcher
            public void afterTextChanged(android.text.Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
                if (com.taobao.weex.ui.component.DCTextArea.this.getHostView().getLineCount() != this.line) {
                    this.line = com.taobao.weex.ui.component.DCTextArea.this.getHostView().getLineCount();
                    int extendedPaddingTop = com.taobao.weex.ui.component.DCTextArea.this.getHostView().getExtendedPaddingTop() + com.taobao.weex.ui.component.DCTextArea.this.getHostView().getExtendedPaddingBottom();
                    final float lineTop = com.taobao.weex.ui.component.DCTextArea.this.getHostView().getLayout().getLineTop(com.taobao.weex.ui.component.DCTextArea.this.getHostView().getLineCount()) + extendedPaddingTop;
                    if (extendedPaddingTop == 0 && com.taobao.weex.ui.component.DCTextArea.this.isAutoHeight) {
                        lineTop = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.ui.component.DCTextArea.this.getInstance().getDefaultFontSize() * 1.4f, com.taobao.weex.ui.component.DCTextArea.this.getInstance().getInstanceViewPortWidthWithFloat()) + com.taobao.weex.ui.component.DCTextArea.this.getHostView().getLayout().getLineTop(com.taobao.weex.ui.component.DCTextArea.this.getHostView().getLineCount() - 1);
                    }
                    if (com.taobao.weex.ui.component.DCTextArea.this.isAutoHeight && lineTop > 0.0f) {
                        com.taobao.weex.WXSDKManager.getInstance().getWXBridgeManager().post(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.DCTextArea.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.taobao.weex.bridge.WXBridgeManager.getInstance().setStyleHeight(com.taobao.weex.ui.component.DCTextArea.this.getInstanceId(), com.taobao.weex.ui.component.DCTextArea.this.getRef(), lineTop);
                                com.taobao.weex.bridge.WXBridgeManager.getInstance().notifyLayout(com.taobao.weex.ui.component.DCTextArea.this.getInstanceId());
                                com.taobao.weex.bridge.WXBridgeManager.getInstance().forceLayout(com.taobao.weex.ui.component.DCTextArea.this.getInstanceId());
                            }
                        });
                    }
                    if (com.taobao.weex.ui.component.DCTextArea.this.isLineChange) {
                        java.util.HashMap map = new java.util.HashMap(3);
                        map.put("lineCount", java.lang.Integer.valueOf(this.line));
                        map.put("height", java.lang.Float.valueOf(com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(lineTop, com.taobao.weex.ui.component.DCTextArea.this.getInstance().getInstanceViewPortWidthWithFloat())));
                        map.put("heightRpx", java.lang.Float.valueOf(lineTop));
                        java.util.HashMap map2 = new java.util.HashMap(1);
                        map2.put("detail", map);
                        com.taobao.weex.ui.component.DCTextArea.this.fireEvent("linechange", map2);
                    }
                }
            }
        });
    }

    @Override // com.taobao.weex.ui.component.DCWXInput
    protected void appleStyleAfterCreated(com.taobao.weex.ui.view.WXEditText wXEditText) {
        super.appleStyleAfterCreated(wXEditText);
        wXEditText.setSingleLine(false);
        wXEditText.setMinLines(1);
        wXEditText.setMaxLines(100);
        wXEditText.setInputType(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_TCP_OPEN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.DCWXInput, com.taobao.weex.ui.component.WXComponent
    public void setHostLayoutParams(com.taobao.weex.ui.view.WXEditText wXEditText, int i, int i2, int i3, int i4, int i5, int i6) {
        super.setHostLayoutParams(wXEditText, i, i2, i3, i4, i5, i6);
    }

    @Override // com.taobao.weex.ui.component.DCWXInput, com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        this.isConfirmHold = com.taobao.weex.utils.WXUtils.getBoolean(obj, true).booleanValue();
        return super.setProperty(str, obj);
    }

    @Override // com.taobao.weex.ui.component.DCWXInput
    public void setType(java.lang.String str) {
        if (getHostView() == null || str == null || getHostView() == null || this.mType.equals(str)) {
            return;
        }
        getHostView().setInputType(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_TCP_OPEN);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "autoHeight")
    public void setAutoHeight(boolean z) {
        this.isAutoHeight = z;
    }

    @Override // com.taobao.weex.ui.component.DCWXInput
    public void setSingleLine(boolean z) {
        getHostView().setSingleLine(false);
    }

    @Override // com.taobao.weex.ui.component.DCWXInput
    protected float getMeasureHeight() {
        if (this.isAutoHeight) {
            return getMeasuredLineHeight();
        }
        return super.getMeasureHeight();
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "showConfirmBar")
    public void setShowConfirmBar(boolean z) {
        this.isShowConfirm = z;
    }

    @Override // com.taobao.weex.ui.component.DCWXInput, com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        com.taobao.weex.ui.component.ConfirmBar.getInstance().removeComponent(this);
    }
}
