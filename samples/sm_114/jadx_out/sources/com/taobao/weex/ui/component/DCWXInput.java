package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
public class DCWXInput extends com.taobao.weex.ui.component.WXComponent<com.taobao.weex.ui.view.WXEditText> {
    private static final int MAX_TEXT_FORMAT_REPEAT = 3;
    final java.lang.String ADJUST_POSITION;
    final java.lang.String PASSWORD;
    private int cursor;
    boolean isConfirmHold;
    private java.util.concurrent.atomic.AtomicBoolean isLayoutFinished;
    public boolean isNeedConfirm;
    private boolean isPassword;
    float keyboardHeight;
    private java.lang.String mBeforeText;
    private int mEditorAction;
    private java.util.List<android.widget.TextView.OnEditorActionListener> mEditorActionListeners;
    private java.lang.String mFontFamily;
    private int mFormatRepeatCount;
    private com.taobao.weex.ui.component.DCWXInput.TextFormatter mFormatter;
    private com.taobao.weex.WXSDKInstance.FrameViewEventListener mFrameViewEventListener;
    private boolean mIgnoreNextOnInputEvent;
    private final android.view.inputmethod.InputMethodManager mInputMethodManager;
    private int mLineHeight;
    private boolean mListeningConfirm;
    private com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener mOnFocusChangeListener;
    private android.text.TextPaint mPaint;
    private java.lang.String mReturnKeyType;
    private android.text.TextWatcher mTextChangedEventDispatcher;
    private java.util.List<android.text.TextWatcher> mTextChangedListeners;
    protected java.lang.String mType;
    private android.content.BroadcastReceiver mTypefaceObserver;
    private float measureHeight;
    private float measureWidht;
    private com.alibaba.fastjson.JSONObject placeholderStyle;
    private java.lang.String placeholderTextAlign;
    private int selectionEnd;
    private int selectionStart;
    private java.lang.String textAlign;

    private interface ReturnTypes {
        public static final java.lang.String DEFAULT = "default";
        public static final java.lang.String DONE = "done";
        public static final java.lang.String GO = "go";
        public static final java.lang.String NEXT = "next";
        public static final java.lang.String SEARCH = "search";
        public static final java.lang.String SEND = "send";
    }

    protected int getVerticalGravity() {
        return 16;
    }

    public DCWXInput(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        this.mBeforeText = "";
        this.mType = "text";
        this.isPassword = false;
        this.mEditorAction = 6;
        this.mReturnKeyType = null;
        this.mListeningConfirm = false;
        this.mIgnoreNextOnInputEvent = false;
        this.mFormatter = null;
        this.mFormatRepeatCount = 0;
        this.mPaint = new android.text.TextPaint();
        this.mLineHeight = -1;
        this.ADJUST_POSITION = "adjustPosition";
        this.PASSWORD = com.taobao.weex.common.Constants.Value.PASSWORD;
        this.keyboardHeight = 0.0f;
        this.isConfirmHold = false;
        this.isNeedConfirm = true;
        this.cursor = -1;
        this.selectionStart = Integer.MAX_VALUE;
        this.selectionEnd = Integer.MAX_VALUE;
        this.textAlign = "left";
        this.placeholderStyle = new com.alibaba.fastjson.JSONObject();
        this.measureHeight = -1.0f;
        this.measureWidht = -1.0f;
        this.mOnFocusChangeListener = new com.taobao.weex.ui.component.DCWXInput.AnonymousClass6();
        this.isLayoutFinished = new java.util.concurrent.atomic.AtomicBoolean(false);
        interceptFocusAndBlurEvent();
        this.mInputMethodManager = (android.view.inputmethod.InputMethodManager) getContext().getSystemService("input_method");
        setContentBoxMeasurement(new com.taobao.weex.layout.ContentBoxMeasurement() { // from class: com.taobao.weex.ui.component.DCWXInput.1
            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutAfter(float f, float f2) {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void measureInternal(float f, float f2, int i, int i2) {
                if (com.taobao.weex.ui.component.DCWXInput.this.getBasicComponentData().getStyles() == null || com.taobao.weex.ui.component.DCWXInput.this.getBasicComponentData().getStyles().size() == 0) {
                    com.taobao.weex.ui.component.DCWXInput.this.measureWidht = f;
                }
                if (com.taobao.weex.dom.CSSConstants.isUndefined(f2)) {
                    this.mMeasureHeight = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.ui.component.DCWXInput.this.getInstance().getDefaultFontSize() * 1.4f, com.taobao.weex.ui.component.DCWXInput.this.getInstance().getInstanceViewPortWidthWithFloat());
                    com.taobao.weex.ui.component.DCWXInput.this.measureHeight = this.mMeasureHeight;
                }
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutBefore() {
                com.taobao.weex.ui.component.DCWXInput.this.updateStyleAndAttrs();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void setHostLayoutParams(com.taobao.weex.ui.view.WXEditText wXEditText, int i, int i2, int i3, int i4, int i5, int i6) {
        super.setHostLayoutParams(wXEditText, i, i2, i3, i4, i5, i6);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    protected void setLayoutSize(com.taobao.weex.ui.action.GraphicSize graphicSize) {
        super.setLayoutSize(graphicSize);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected void layoutDirectionDidChanged(boolean z) {
        int textAlign = getTextAlign((java.lang.String) getStyles().get(com.taobao.weex.common.Constants.Name.TEXT_ALIGN));
        if (textAlign <= 0) {
            textAlign = androidx.core.view.GravityCompat.START;
        }
        if (getHostView() != null) {
            getHostView().setGravity(textAlign | getVerticalGravity());
        }
    }

    final float getMeasuredLineHeight() {
        int i = this.mLineHeight;
        return (i == -1 || i <= 0) ? this.mPaint.getFontMetrics(null) : i;
    }

    protected float getMeasureHeight() {
        return com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(getMeasuredLineHeight() >= 50.0f ? getMeasureHeight() : 50.0f, getInstance().getInstanceViewPortWidthWithFloat());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStyleAndAttrs() {
        if (getStyles().size() > 0) {
            int fontSize = getStyles().containsKey(com.taobao.weex.common.Constants.Name.FONT_SIZE) ? com.taobao.weex.dom.WXStyle.getFontSize(getStyles(), getInstance().getDefaultFontSize(), getViewPortWidth()) : -1;
            java.lang.String fontFamily = getStyles().containsKey(com.taobao.weex.common.Constants.Name.FONT_FAMILY) ? com.taobao.weex.dom.WXStyle.getFontFamily(getStyles()) : null;
            int fontStyle = getStyles().containsKey(com.taobao.weex.common.Constants.Name.FONT_STYLE) ? com.taobao.weex.dom.WXStyle.getFontStyle(getStyles()) : -1;
            int fontWeight = getStyles().containsKey(com.taobao.weex.common.Constants.Name.FONT_WEIGHT) ? com.taobao.weex.dom.WXStyle.getFontWeight(getStyles()) : -1;
            int lineHeight = com.taobao.weex.dom.WXStyle.getLineHeight(getStyles(), getViewPortWidth());
            if (lineHeight != -1) {
                this.mLineHeight = lineHeight;
            }
            if (fontSize != -1) {
                this.mPaint.setTextSize(fontSize);
            }
            if (fontFamily != null) {
                com.taobao.weex.utils.TypefaceUtil.applyFontStyle(this.mPaint, fontStyle, fontWeight, fontFamily);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.view.WXEditText initComponentHostView(android.content.Context context) {
        com.taobao.weex.ui.view.WXEditText wXEditText = new com.taobao.weex.ui.view.WXEditText(context, getInstanceId());
        appleStyleAfterCreated(wXEditText);
        wXEditText.setImeOptions(6);
        return wXEditText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(com.taobao.weex.ui.view.WXEditText wXEditText) {
        super.onHostViewInitialized(wXEditText);
        if (this.measureWidht > 0.0f) {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().setStyleWidth(getInstanceId(), getRef(), this.measureWidht);
        }
        if (this.measureHeight > 0.0f) {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().setStyleHeight(getInstanceId(), getRef(), this.measureHeight);
        }
        addFocusChangeListener(new com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener() { // from class: com.taobao.weex.ui.component.DCWXInput.2
            @Override // com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener
            public void onFocusChange(boolean z) {
                if (!z) {
                    com.taobao.weex.ui.component.DCWXInput.this.decideSoftKeyboard();
                }
                com.taobao.weex.ui.component.DCWXInput.this.setPseudoClassStatus(com.taobao.weex.common.Constants.PSEUDO.FOCUS, z);
                if (z) {
                    com.taobao.weex.ui.component.DCWXInput dCWXInput = com.taobao.weex.ui.component.DCWXInput.this;
                    dCWXInput.setTextAlign(dCWXInput.textAlign);
                } else {
                    if (com.taobao.weex.ui.component.DCWXInput.this.getHostView() == null || !io.dcloud.common.util.PdrUtil.isEmpty(com.taobao.weex.ui.component.DCWXInput.this.getHostView().getText().toString())) {
                        return;
                    }
                    com.taobao.weex.ui.component.DCWXInput dCWXInput2 = com.taobao.weex.ui.component.DCWXInput.this;
                    int textAlign = dCWXInput2.getTextAlign(dCWXInput2.placeholderTextAlign == null ? com.taobao.weex.ui.component.DCWXInput.this.textAlign : com.taobao.weex.ui.component.DCWXInput.this.placeholderTextAlign);
                    if (textAlign > 0) {
                        com.taobao.weex.ui.component.DCWXInput.this.getHostView().setGravity(textAlign | com.taobao.weex.ui.component.DCWXInput.this.getVerticalGravity());
                    }
                }
            }
        });
        addKeyboardListener(wXEditText);
        if (this.isNeedConfirm) {
            addEditorChangeListener();
        }
    }

    private void addEditorChangeListener() {
        addEditorActionListener(new android.widget.TextView.OnEditorActionListener() { // from class: com.taobao.weex.ui.component.DCWXInput.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(android.widget.TextView textView, int i, android.view.KeyEvent keyEvent) {
                if (com.taobao.weex.ui.component.DCWXInput.this.mListeningConfirm && i == com.taobao.weex.ui.component.DCWXInput.this.mEditorAction) {
                    java.util.HashMap map = new java.util.HashMap(1);
                    java.util.HashMap map2 = new java.util.HashMap(1);
                    map2.put("value", textView.getText().toString());
                    map.put("detail", map2);
                    com.taobao.weex.ui.component.DCWXInput.this.fireEvent("confirm", map);
                    if (!com.taobao.weex.ui.component.DCWXInput.this.isConfirmHold) {
                        com.taobao.weex.ui.component.DCWXInput.this.blur();
                    }
                    return true;
                }
                return com.taobao.weex.ui.component.DCWXInput.this.isConfirmHold;
            }
        });
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean isConsumeTouch() {
        return !isDisabled();
    }

    protected void appleStyleAfterCreated(final com.taobao.weex.ui.view.WXEditText wXEditText) {
        int textAlign = getTextAlign((java.lang.String) getStyles().get(com.taobao.weex.common.Constants.Name.TEXT_ALIGN));
        if (textAlign <= 0) {
            textAlign = androidx.core.view.GravityCompat.START;
        }
        wXEditText.setGravity(textAlign | getVerticalGravity());
        int color = com.taobao.weex.utils.WXResourceUtils.getColor("#999999");
        if (color != Integer.MIN_VALUE) {
            wXEditText.setHintTextColor(color);
        }
        android.text.TextWatcher textWatcher = new android.text.TextWatcher() { // from class: com.taobao.weex.ui.component.DCWXInput.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
                if (com.taobao.weex.ui.component.DCWXInput.this.mTextChangedListeners != null) {
                    java.util.Iterator it = com.taobao.weex.ui.component.DCWXInput.this.mTextChangedListeners.iterator();
                    while (it.hasNext()) {
                        ((android.text.TextWatcher) it.next()).beforeTextChanged(charSequence, i, i2, i3);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
                if (com.taobao.weex.ui.component.DCWXInput.this.mFormatter != null) {
                    java.lang.String str = com.taobao.weex.ui.component.DCWXInput.this.mFormatter.format(com.taobao.weex.ui.component.DCWXInput.this.mFormatter.recover(charSequence.toString()));
                    if (str.equals(charSequence.toString()) || com.taobao.weex.ui.component.DCWXInput.this.mFormatRepeatCount >= 3) {
                        com.taobao.weex.ui.component.DCWXInput.this.mFormatRepeatCount = 0;
                    } else {
                        com.taobao.weex.ui.component.DCWXInput.this.mFormatRepeatCount++;
                        int length = com.taobao.weex.ui.component.DCWXInput.this.mFormatter.format(com.taobao.weex.ui.component.DCWXInput.this.mFormatter.recover(charSequence.subSequence(0, wXEditText.getSelectionStart()).toString())).length();
                        wXEditText.setText(str);
                        wXEditText.setSelection(length);
                        return;
                    }
                }
                if (com.taobao.weex.ui.component.DCWXInput.this.mTextChangedListeners != null) {
                    java.util.Iterator it = com.taobao.weex.ui.component.DCWXInput.this.mTextChangedListeners.iterator();
                    while (it.hasNext()) {
                        ((android.text.TextWatcher) it.next()).onTextChanged(charSequence, i, i2, i3);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(android.text.Editable editable) {
                if (com.taobao.weex.ui.component.DCWXInput.this.mTextChangedListeners != null) {
                    java.util.Iterator it = com.taobao.weex.ui.component.DCWXInput.this.mTextChangedListeners.iterator();
                    while (it.hasNext()) {
                        ((android.text.TextWatcher) it.next()).afterTextChanged(editable);
                    }
                }
            }
        };
        this.mTextChangedEventDispatcher = textWatcher;
        wXEditText.addTextChangedListener(textWatcher);
        wXEditText.setTextSize(0, com.taobao.weex.dom.WXStyle.getFontSize(getStyles(), getInstance().getDefaultFontSize(), getInstance().getInstanceViewPortWidthWithFloat()));
        wXEditText.setSingleLine(true);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(java.lang.String str) {
        if (getHostView() == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals("input")) {
            addTextChangedListener(new android.text.TextWatcher() { // from class: com.taobao.weex.ui.component.DCWXInput.5
                @Override // android.text.TextWatcher
                public void afterTextChanged(android.text.Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
                    if (com.taobao.weex.ui.component.DCWXInput.this.mIgnoreNextOnInputEvent) {
                        com.taobao.weex.ui.component.DCWXInput.this.mIgnoreNextOnInputEvent = false;
                        com.taobao.weex.ui.component.DCWXInput.this.mBeforeText = charSequence.toString();
                        return;
                    }
                    java.util.HashMap map = new java.util.HashMap(1);
                    java.util.HashMap map2 = new java.util.HashMap(3);
                    map2.put("value", charSequence.toString());
                    map2.put("cursor", java.lang.Integer.valueOf(com.taobao.weex.ui.component.DCWXInput.this.getHostView().getSelectionEnd()));
                    try {
                        if (i2 == 0 && i3 != 0) {
                            java.lang.String string = charSequence.subSequence(i, i3 + i).toString();
                            map2.put("keyCode", java.lang.Integer.valueOf(java.lang.Character.codePointAt(string, string.length() - 1)));
                        } else {
                            if (i2 != 0 && i3 == 0) {
                                java.lang.String string2 = com.taobao.weex.ui.component.DCWXInput.this.mBeforeText.subSequence(i, i2 + i).toString();
                                map2.put("keyCode", java.lang.Integer.valueOf(java.lang.Character.codePointAt(string2, string2.length() - 1)));
                            }
                            com.taobao.weex.ui.component.DCWXInput.this.mBeforeText = charSequence.toString();
                            map.put("detail", map2);
                            com.taobao.weex.ui.component.DCWXInput.this.fireEvent("input", map);
                        }
                    } catch (java.lang.Exception unused) {
                        map2.put("keyCode", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
                    }
                    com.taobao.weex.ui.component.DCWXInput.this.mBeforeText = charSequence.toString();
                    map.put("detail", map2);
                    com.taobao.weex.ui.component.DCWXInput.this.fireEvent("input", map);
                }
            });
        }
        if ("confirm".equals(str)) {
            this.mListeningConfirm = true;
        }
        if (com.taobao.weex.common.Constants.Event.FOCUS.equals(str) || com.taobao.weex.common.Constants.Event.BLUR.equals(str)) {
            setFocusAndBlur();
        }
        super.addEvent(str);
    }

    /* JADX INFO: renamed from: com.taobao.weex.ui.component.DCWXInput$6, reason: invalid class name */
    class AnonymousClass6 implements com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener {
        int count = 0;

        AnonymousClass6() {
        }

        @Override // com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener
        public void onFocusChange(boolean z) {
            com.taobao.weex.ui.view.WXEditText hostView = com.taobao.weex.ui.component.DCWXInput.this.getHostView();
            if (hostView == null) {
                return;
            }
            java.util.HashMap map = new java.util.HashMap(1);
            java.util.HashMap map2 = new java.util.HashMap(1);
            map2.put("value", hostView.getText().toString());
            if (!z) {
                map.put("detail", map2);
                com.taobao.weex.ui.component.DCWXInput.this.fireEvent(com.taobao.weex.common.Constants.Event.BLUR, map);
            } else {
                if (com.taobao.weex.ui.component.DCWXInput.this.keyboardHeight == 0.0f) {
                    fireEventForFocus(hostView);
                    return;
                }
                map2.put("height", java.lang.Float.valueOf(com.taobao.weex.ui.component.DCWXInput.this.keyboardHeight));
                map2.put("value", hostView.getText().toString());
                map.put("detail", map2);
                com.taobao.weex.ui.component.DCWXInput.this.fireEvent(com.taobao.weex.common.Constants.Event.FOCUS, map);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fireEventForFocus(final android.widget.TextView textView) {
            com.taobao.weex.ui.component.DCWXInput.this.getHostView().postDelayed(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.DCWXInput.6.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.taobao.weex.ui.component.DCWXInput.this.keyboardHeight == 0.0f) {
                        com.taobao.weex.ui.component.DCWXInput.AnonymousClass6.this.count++;
                        if (com.taobao.weex.ui.component.DCWXInput.AnonymousClass6.this.count <= 3) {
                            com.taobao.weex.ui.component.DCWXInput.AnonymousClass6.this.fireEventForFocus(textView);
                            return;
                        }
                        java.util.HashMap map = new java.util.HashMap(1);
                        java.util.HashMap map2 = new java.util.HashMap(1);
                        map2.put("value", textView.getText().toString());
                        map2.put("height", java.lang.Float.valueOf(com.taobao.weex.ui.component.DCWXInput.this.keyboardHeight));
                        map.put("detail", map2);
                        com.taobao.weex.ui.component.DCWXInput.this.fireEvent(com.taobao.weex.common.Constants.Event.FOCUS, map);
                        return;
                    }
                    com.taobao.weex.ui.component.DCWXInput.AnonymousClass6.this.count = 0;
                    java.util.HashMap map3 = new java.util.HashMap(1);
                    java.util.HashMap map4 = new java.util.HashMap(1);
                    map4.put("value", textView.getText().toString());
                    map4.put("height", java.lang.Float.valueOf(com.taobao.weex.ui.component.DCWXInput.this.keyboardHeight));
                    map3.put("detail", map4);
                    com.taobao.weex.ui.component.DCWXInput.this.fireEvent(com.taobao.weex.common.Constants.Event.FOCUS, map3);
                }
            }, 200L);
        }
    }

    protected void setFocusAndBlur() {
        if (ismHasFocusChangeListener(this.mOnFocusChangeListener)) {
            return;
        }
        addFocusChangeListener(this.mOnFocusChangeListener);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0011  */
    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "selectionStart":
                int iIntValue = com.taobao.weex.utils.WXUtils.getInteger(obj, Integer.MAX_VALUE).intValue();
                this.selectionStart = iIntValue;
                setSelectionRange(iIntValue, this.selectionEnd);
                return super.setProperty(str, obj);
            case "keepSelectionIndex":
                return true;
            case "selectionEnd":
                int iIntValue2 = com.taobao.weex.utils.WXUtils.getInteger(obj, Integer.MAX_VALUE).intValue();
                this.selectionEnd = iIntValue2;
                setSelectionRange(this.selectionStart, iIntValue2);
                return super.setProperty(str, obj);
            case "placeholderColor":
                java.lang.String string = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string != null) {
                    setPlaceholderColor(string);
                }
                return true;
            case "cursor":
                int i = com.taobao.weex.utils.WXUtils.getInt(obj);
                if (i > 0 && i <= getHostView().getText().length()) {
                    getHostView().setSelection(i);
                } else if (i > getHostView().getText().length()) {
                    getHostView().setSelection(getHostView().getText().length());
                }
                return true;
            case "fontFamily":
                if (obj != null) {
                    try {
                        com.taobao.weex.utils.FontDO fontDO = com.taobao.weex.utils.TypefaceUtil.getFontDO(obj.toString());
                        if (fontDO != null && fontDO.getTypeface() != null && getHostView() != null) {
                            getHostView().setTypeface(fontDO.getTypeface());
                        } else {
                            registerTypefaceObserver(obj.toString());
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                return true;
            case "textAlign":
                java.lang.String string2 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string2 != null) {
                    setTextAlign(string2);
                }
                return true;
            case "maxLength":
                java.lang.Integer integer = com.taobao.weex.utils.WXUtils.getInteger(obj, null);
                if (integer != null) {
                    setMaxLength(integer.intValue());
                }
                return true;
            case "max":
            case "min":
                return true;
            case "color":
                java.lang.String string3 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string3 != null) {
                    setColor(string3);
                }
                return true;
            case "focus":
            case "autoFocus":
                setAutofocus(com.taobao.weex.utils.WXUtils.getBoolean(obj, false).booleanValue());
                return true;
            case "lines":
                java.lang.Integer integer2 = com.taobao.weex.utils.WXUtils.getInteger(obj, null);
                if (integer2 != null) {
                    setLines(integer2.intValue());
                }
                return true;
            case "maxlength":
                java.lang.Integer integer3 = com.taobao.weex.utils.WXUtils.getInteger(obj, null);
                if (integer3 != null) {
                    setMaxLength(integer3.intValue());
                }
                return true;
            case "disabled":
                java.lang.Boolean bool = com.taobao.weex.utils.WXUtils.getBoolean(obj, false);
                getHostView().setFocusable(!bool.booleanValue());
                getHostView().setFocusableInTouchMode(!bool.booleanValue());
                getHostView().setCursorVisible(!bool.booleanValue());
                return true;
            case "confirmHold":
                this.isConfirmHold = com.taobao.weex.utils.WXUtils.getBoolean(obj, false).booleanValue();
                return super.setProperty(str, obj);
            case "fontSize":
                java.lang.String string4 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string4 != null) {
                    setFontSize(string4);
                }
                return true;
            case "placeholder":
                return true;
            case "singleline":
                java.lang.Boolean bool2 = com.taobao.weex.utils.WXUtils.getBoolean(obj, null);
                if (bool2 != null) {
                    setSingleLine(bool2.booleanValue());
                }
                return true;
            case "returnKeyType":
                setReturnKeyType(java.lang.String.valueOf(obj));
                return true;
            case "allowCopyPaste":
                boolean zBooleanValue = com.taobao.weex.utils.WXUtils.getBoolean(obj, true).booleanValue();
                if (getHostView() != null) {
                    getHostView().setAllowCopyPaste(zBooleanValue);
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
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
        this.mTypefaceObserver = new android.content.BroadcastReceiver() { // from class: com.taobao.weex.ui.component.DCWXInput.7
            @Override // android.content.BroadcastReceiver
            public void onReceive(android.content.Context context, android.content.Intent intent) {
                com.taobao.weex.utils.FontDO fontDO;
                java.lang.String stringExtra = intent.getStringExtra(com.taobao.weex.common.Constants.Name.FONT_FAMILY);
                if (!com.taobao.weex.ui.component.DCWXInput.this.mFontFamily.equals(stringExtra) || (fontDO = com.taobao.weex.utils.TypefaceUtil.getFontDO(stringExtra)) == null || fontDO.getTypeface() == null || com.taobao.weex.ui.component.DCWXInput.this.getHostView() == null) {
                    return;
                }
                com.taobao.weex.ui.component.DCWXInput.this.getHostView().setTypeface(fontDO.getTypeface());
            }
        };
        androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(com.taobao.weex.WXEnvironment.getApplication()).registerReceiver(this.mTypefaceObserver, new android.content.IntentFilter(com.taobao.weex.utils.TypefaceUtil.ACTION_TYPE_FACE_AVAILABLE));
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.RETURN_KEY_TYPE)
    public void setReturnKeyType(java.lang.String str) {
        if (getHostView() == null || str.equals(this.mReturnKeyType)) {
            return;
        }
        this.mReturnKeyType = str;
        str.hashCode();
        switch (str) {
            case "search":
                this.mEditorAction = 3;
                break;
            case "go":
                this.mEditorAction = 2;
                break;
            case "done":
                this.mEditorAction = 6;
                break;
            case "next":
                this.mEditorAction = 5;
                break;
            case "send":
                this.mEditorAction = 4;
                break;
            case "default":
                this.mEditorAction = 0;
                break;
        }
        blur();
        getHostView().setImeOptions(this.mEditorAction);
    }

    public void setPlaceholder(java.lang.String str) {
        if (str == null || getHostView() == null) {
            return;
        }
        getHostView().setHint(str);
        setPlaceholderStyle(this.placeholderStyle);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.PLACEHOLDER_COLOR)
    public void setPlaceholderColor(java.lang.String str) {
        int color;
        if (getHostView() == null || android.text.TextUtils.isEmpty(str) || (color = com.taobao.weex.utils.WXResourceUtils.getColor(str)) == Integer.MIN_VALUE) {
            return;
        }
        getHostView().setHintTextColor(color);
    }

    public void setType(java.lang.String str) {
        android.util.Log.e("weex", "setType=" + str);
        if (str == null || getHostView() == null || this.mType.equals(str)) {
            return;
        }
        this.mType = str;
        getHostView().setInputType(getInputType(this.mType));
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.AUTOFOCUS)
    public void setAutofocus(final boolean z) {
        if (getHostView() == null) {
            return;
        }
        final com.taobao.weex.ui.view.WXEditText hostView = getHostView();
        if (!this.isLayoutFinished.get()) {
            if (getInstance().isFrameViewShow()) {
                getHostView().getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.taobao.weex.ui.component.DCWXInput.8
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (com.taobao.weex.ui.component.DCWXInput.this.getInstance() == null) {
                            return;
                        }
                        if (z) {
                            com.taobao.weex.ui.component.DCWXInput.this.isLayoutFinished.set(true);
                            com.taobao.weex.ui.component.DCWXInput.this.hostViewFocus(hostView);
                            com.taobao.weex.ui.component.DCWXInput dCWXInput = com.taobao.weex.ui.component.DCWXInput.this;
                            dCWXInput.setSelectionRange(dCWXInput.selectionStart, com.taobao.weex.ui.component.DCWXInput.this.selectionEnd);
                        } else {
                            hostView.clearFocus();
                        }
                        com.taobao.weex.ui.component.DCWXInput.this.getHostView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
                return;
            }
            if (this.mFrameViewEventListener != null) {
                getInstance().removeFrameViewEventListener(this.mFrameViewEventListener);
            }
            this.mFrameViewEventListener = new com.taobao.weex.WXSDKInstance.FrameViewEventListener() { // from class: com.taobao.weex.ui.component.DCWXInput.9
                @Override // com.taobao.weex.WXSDKInstance.FrameViewEventListener
                public void onShowAnimationEnd() {
                    if (com.taobao.weex.ui.component.DCWXInput.this.getInstance() == null) {
                        return;
                    }
                    if (z) {
                        com.taobao.weex.ui.component.DCWXInput.this.isLayoutFinished.set(true);
                        com.taobao.weex.ui.component.DCWXInput.this.hostViewFocus(hostView);
                        com.taobao.weex.ui.component.DCWXInput dCWXInput = com.taobao.weex.ui.component.DCWXInput.this;
                        dCWXInput.setSelectionRange(dCWXInput.selectionStart, com.taobao.weex.ui.component.DCWXInput.this.selectionEnd);
                    } else {
                        hostView.clearFocus();
                    }
                    com.taobao.weex.ui.component.DCWXInput.this.getInstance().removeFrameViewEventListener(this);
                    com.taobao.weex.ui.component.DCWXInput.this.mFrameViewEventListener = null;
                }
            };
            getInstance().addFrameViewEventListener(this.mFrameViewEventListener);
            return;
        }
        if (z) {
            hostViewFocus(hostView);
        } else {
            hideSoftKeyboard();
        }
        hostView.clearFocus();
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "adjustPosition")
    public void setAdjustPosition(java.lang.Object obj) {
        if (getHostView() != null) {
            getHostView().setInputSoftMode(com.taobao.weex.utils.WXUtils.getBoolean(obj, true).booleanValue() ? io.dcloud.common.core.ui.DCKeyboardManager.SOFT_INPUT_MODE_ADJUST_PAN : io.dcloud.common.core.ui.DCKeyboardManager.SOFT_INPUT_MODE_ADJUST_NOTHING);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hostViewFocus(android.widget.EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.setCursorVisible(true);
        editText.requestFocus();
        showSoftKeyboard();
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "value")
    public void setText(java.lang.String str) {
        com.taobao.weex.ui.view.WXEditText hostView = getHostView();
        if (hostView == null || android.text.TextUtils.equals(hostView.getText(), str)) {
            return;
        }
        this.mIgnoreNextOnInputEvent = true;
        hostView.setText(str);
        int length = this.cursor;
        if (length <= 0) {
            length = str.length();
        }
        if (str == null) {
            length = 0;
        }
        hostView.setSelection(length);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "color")
    public void setColor(java.lang.String str) {
        int color;
        if (getHostView() == null || android.text.TextUtils.isEmpty(str) || (color = com.taobao.weex.utils.WXResourceUtils.getColor(str)) == Integer.MIN_VALUE) {
            return;
        }
        getHostView().setTextColor(color);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.FONT_SIZE)
    public void setFontSize(java.lang.String str) {
        if (getHostView() == null || str == null) {
            return;
        }
        java.util.HashMap map = new java.util.HashMap(1);
        map.put(com.taobao.weex.common.Constants.Name.FONT_SIZE, str);
        getHostView().setTextSize(0, com.taobao.weex.dom.WXStyle.getFontSize(map, getInstance().getDefaultFontSize(), getInstance().getInstanceViewPortWidthWithFloat()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0088  */
    @com.taobao.weex.ui.component.WXComponentProp(name = "placeholderStyle")
    public void setPlaceholderStyle(com.alibaba.fastjson.JSONObject jSONObject) {
        com.alibaba.fastjson.JSONObject jSONObject2 = this.placeholderStyle;
        if (jSONObject2 == null || jSONObject2.isEmpty()) {
            return;
        }
        java.lang.CharSequence hint = getHostView().getHint();
        if (hint == null && getAttrs().containsKey(com.taobao.weex.common.Constants.Name.PLACEHOLDER)) {
            hint = com.taobao.weex.utils.WXUtils.getString(getAttrs().get(com.taobao.weex.common.Constants.Name.PLACEHOLDER), "");
        }
        android.text.SpannableString spannableString = new android.text.SpannableString(hint);
        android.text.style.AbsoluteSizeSpan absoluteSizeSpan = new android.text.style.AbsoluteSizeSpan((int) getHostView().getTextSize());
        android.text.style.ForegroundColorSpan foregroundColorSpan = new android.text.style.ForegroundColorSpan(getHostView().getCurrentHintTextColor());
        android.text.style.BackgroundColorSpan backgroundColorSpan = null;
        android.text.style.StyleSpan styleSpan = null;
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : this.placeholderStyle.entrySet()) {
            java.lang.String key = entry.getKey();
            key.hashCode();
            switch (key) {
                case "font-size":
                case "fontSize":
                    java.lang.String strValueOf = java.lang.String.valueOf(entry.getValue());
                    if (strValueOf.endsWith("px")) {
                        strValueOf = strValueOf.replaceAll("px", "");
                    } else if (strValueOf.endsWith("wx")) {
                        strValueOf = strValueOf.replaceAll("wx", "");
                    }
                    java.util.HashMap map = new java.util.HashMap(1);
                    map.put(com.taobao.weex.common.Constants.Name.FONT_SIZE, strValueOf);
                    absoluteSizeSpan = new android.text.style.AbsoluteSizeSpan(com.taobao.weex.utils.WXUtils.getInteger(java.lang.Integer.valueOf(com.taobao.weex.dom.WXStyle.getFontSize(map, getInstance().getDefaultFontSize(), getInstance().getInstanceViewPortWidthWithFloat())), java.lang.Integer.valueOf(getInstance().getDefaultFontSize())).intValue());
                    break;
                case "textAlign":
                case "text-align":
                    this.placeholderTextAlign = java.lang.String.valueOf(entry.getValue());
                    int textAlign = getTextAlign(java.lang.String.valueOf(entry.getValue()));
                    if (textAlign > 0) {
                        getHostView().setGravity(textAlign | getVerticalGravity());
                        break;
                    } else {
                        break;
                    }
                    break;
                case "fontWeight":
                case "font-weight":
                    java.lang.String strValueOf2 = java.lang.String.valueOf(entry.getValue());
                    strValueOf2.hashCode();
                    switch (strValueOf2) {
                        case "600":
                        case "700":
                        case "800":
                        case "900":
                        case "bold":
                            styleSpan = new android.text.style.StyleSpan(1);
                            break;
                        default:
                            styleSpan = new android.text.style.StyleSpan(0);
                            break;
                    }
                    break;
                case "color":
                    int color = com.taobao.weex.utils.WXResourceUtils.getColor(java.lang.String.valueOf(entry.getValue()));
                    if (color != Integer.MIN_VALUE) {
                        foregroundColorSpan = new android.text.style.ForegroundColorSpan(color);
                        break;
                    } else {
                        break;
                    }
                    break;
                case "background-color":
                case "backgroundColor":
                    int color2 = com.taobao.weex.utils.WXResourceUtils.getColor(java.lang.String.valueOf(entry.getValue()));
                    if (color2 != Integer.MIN_VALUE) {
                        backgroundColorSpan = new android.text.style.BackgroundColorSpan(color2);
                        break;
                    } else {
                        break;
                    }
                    break;
            }
        }
        spannableString.setSpan(absoluteSizeSpan, 0, spannableString.length(), 33);
        if (backgroundColorSpan != null) {
            spannableString.setSpan(backgroundColorSpan, 0, spannableString.length(), 33);
        }
        if (styleSpan != null) {
            spannableString.setSpan(styleSpan, 0, spannableString.length(), 33);
        }
        spannableString.setSpan(foregroundColorSpan, 0, spannableString.length(), 33);
        getHostView().setHint(spannableString);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "placeholderClass")
    public void setPlaceholderClass(com.alibaba.fastjson.JSONObject jSONObject) {
        setPlaceholderStyle(jSONObject);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.TEXT_ALIGN)
    public void setTextAlign(java.lang.String str) {
        this.textAlign = str;
        int textAlign = getTextAlign(str);
        if (textAlign > 0) {
            getHostView().setGravity(textAlign | getVerticalGravity());
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SINGLELINE)
    public void setSingleLine(boolean z) {
        if (getHostView() == null) {
            return;
        }
        getHostView().setSingleLine(z);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.LINES)
    public void setLines(int i) {
        if (getHostView() == null) {
            return;
        }
        getHostView().setLines(i);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.MAX_LENGTH)
    public void setMaxLength(int i) {
        if (getHostView() == null) {
            return;
        }
        if (i == -1) {
            i = Integer.MAX_VALUE;
        }
        getHostView().setFilters(new android.text.InputFilter[]{new android.text.InputFilter.LengthFilter(i)});
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.MAXLENGTH)
    @java.lang.Deprecated
    public void setMaxlength(int i) {
        setMaxLength(i);
    }

    private int getInputType(java.lang.String str) {
        str.hashCode();
        switch (str) {
            case "number":
                return 2;
            case "tel":
                return 3;
            case "url":
                return 17;
            case "date":
                getHostView().setFocusable(false);
                return 0;
            case "text":
                return 1;
            case "time":
                if (getHostView() != null) {
                    getHostView().setFocusable(false);
                }
                return 0;
            case "digit":
                return 8194;
            case "email":
                return 33;
            case "password":
                if (getHostView() != null) {
                    getHostView().setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
                }
                return 129;
            case "datetime":
                return 4;
            default:
                return 1;
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = io.dcloud.feature.uniapp.common.UniConstants.Name.CURSOR_SPACING)
    public void setCursorSpacing(java.lang.String str) {
        if (getHostView() != null) {
            getHostView().setCursorSpacing(io.dcloud.feature.uniapp.utils.UniViewUtils.getRealPxByWidth(io.dcloud.feature.uniapp.utils.UniUtils.getFloat(str), getInstance().getInstanceViewPortWidthWithFloat()));
        }
    }

    private void showSoftKeyboard() {
        if (getHostView() == null) {
            return;
        }
        getHostView().postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.DCWXInput.10
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.ui.component.DCWXInput.this.mInputMethodManager.showSoftInput(com.taobao.weex.ui.component.DCWXInput.this.getHostView(), 1);
            }
        }), 100L);
    }

    void hideSoftKeyboard() {
        if (getHostView() != null) {
            getHostView().postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.DCWXInput.11
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.ui.component.DCWXInput.this.mInputMethodManager.hideSoftInputFromWindow(com.taobao.weex.ui.component.DCWXInput.this.getHostView().getWindowToken(), 0);
                }
            }), 16L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTextAlign(java.lang.String str) {
        int i = isLayoutRTL() ? androidx.core.view.GravityCompat.END : androidx.core.view.GravityCompat.START;
        if (!android.text.TextUtils.isEmpty(str)) {
            str.hashCode();
            switch (str) {
                case "center":
                    return 17;
                case "left":
                    return androidx.core.view.GravityCompat.START;
                case "right":
                    return androidx.core.view.GravityCompat.END;
            }
        }
        return i;
    }

    @com.taobao.weex.annotation.JSMethod
    public void blur() {
        com.taobao.weex.ui.view.WXEditText hostView = getHostView();
        if (hostView == null || !hostView.hasFocus()) {
            return;
        }
        if (getParent() != null) {
            getParent().interceptFocus();
        }
        hostView.clearFocus();
        hideSoftKeyboard();
    }

    public java.lang.String getValue() {
        return getHostView().getText().toString();
    }

    @com.taobao.weex.annotation.JSMethod
    public void setValue(java.lang.String str) {
        getHostView().setText(str);
    }

    @com.taobao.weex.annotation.JSMethod
    public void focus() {
        com.taobao.weex.ui.view.WXEditText hostView = getHostView();
        if (hostView == null || hostView.hasFocus()) {
            return;
        }
        if (getParent() != null) {
            getParent().ignoreFocus();
        }
        hostView.requestFocus();
        hostView.setFocusable(true);
        hostView.setFocusableInTouchMode(true);
        showSoftKeyboard();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void decideSoftKeyboard() {
        com.taobao.weex.ui.view.WXEditText hostView = getHostView();
        if (hostView != null) {
            final android.content.Context context = getContext();
            if (context instanceof android.app.Activity) {
                hostView.postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.DCWXInput.12
                    @Override // java.lang.Runnable
                    public void run() {
                        android.view.View currentFocus = ((android.app.Activity) context).getCurrentFocus();
                        if (currentFocus == null || (currentFocus instanceof android.widget.EditText) || currentFocus.isFocused()) {
                            return;
                        }
                        com.taobao.weex.ui.component.DCWXInput.this.mInputMethodManager.hideSoftInputFromWindow(com.taobao.weex.ui.component.DCWXInput.this.getHostView().getWindowToken(), 0);
                    }
                }), 16L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectionRange(int i, int i2) {
        com.taobao.weex.ui.view.WXEditText hostView;
        if (i2 == Integer.MAX_VALUE || i == Integer.MAX_VALUE || (hostView = getHostView()) == null) {
            return;
        }
        int length = getHostView().length();
        if (i > i2) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 > length) {
            i2 = length;
        }
        hostView.setSelection(i, i2 >= 0 ? i2 : 0);
    }

    @io.dcloud.feature.uniapp.annotation.UniJSMethod
    public void getSelectionRange(java.lang.String str) {
        java.util.HashMap map = new java.util.HashMap(2);
        com.taobao.weex.ui.view.WXEditText hostView = getHostView();
        if (hostView != null) {
            int selectionStart = hostView.getSelectionStart();
            int selectionEnd = hostView.getSelectionEnd();
            if (!hostView.hasFocus()) {
                selectionStart = 0;
                selectionEnd = 0;
            }
            map.put(com.taobao.weex.common.Constants.Name.SELECTION_START, java.lang.Integer.valueOf(selectionStart));
            map.put(com.taobao.weex.common.Constants.Name.SELECTION_END, java.lang.Integer.valueOf(selectionEnd));
        }
        com.taobao.weex.bridge.WXBridgeManager.getInstance().callback(getInstanceId(), str, map, false);
    }

    @io.dcloud.feature.uniapp.annotation.UniJSMethod
    public void getCursor(com.taobao.weex.bridge.JSCallback jSCallback) {
        java.util.HashMap map = new java.util.HashMap(1);
        if (getHostView() != null && getHostView().isFocused()) {
            map.put("cursor", java.lang.Integer.valueOf(getHostView().getSelectionEnd()));
        } else {
            map.put("cursor", 0);
        }
        jSCallback.invoke(map);
    }

    @com.taobao.weex.annotation.JSMethod
    public void setTextFormatter(com.alibaba.fastjson.JSONObject jSONObject) {
        try {
            java.lang.String string = jSONObject.getString("formatRule");
            java.lang.String string2 = jSONObject.getString("formatReplace");
            java.lang.String string3 = jSONObject.getString("recoverRule");
            java.lang.String string4 = jSONObject.getString("recoverReplace");
            com.taobao.weex.ui.component.DCWXInput.PatternWrapper toPattern = parseToPattern(string, string2);
            com.taobao.weex.ui.component.DCWXInput.PatternWrapper toPattern2 = parseToPattern(string3, string4);
            if (toPattern == null || toPattern2 == null) {
                return;
            }
            this.mFormatter = new com.taobao.weex.ui.component.DCWXInput.TextFormatter(toPattern, toPattern2);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private final void addEditorActionListener(android.widget.TextView.OnEditorActionListener onEditorActionListener) {
        com.taobao.weex.ui.view.WXEditText hostView;
        if (onEditorActionListener == null || (hostView = getHostView()) == null) {
            return;
        }
        if (this.mEditorActionListeners == null) {
            this.mEditorActionListeners = new java.util.ArrayList();
            hostView.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() { // from class: com.taobao.weex.ui.component.DCWXInput.13
                private boolean handled = true;

                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(android.widget.TextView textView, int i, android.view.KeyEvent keyEvent) {
                    for (android.widget.TextView.OnEditorActionListener onEditorActionListener2 : com.taobao.weex.ui.component.DCWXInput.this.mEditorActionListeners) {
                        if (onEditorActionListener2 != null) {
                            this.handled = onEditorActionListener2.onEditorAction(textView, i, keyEvent) & this.handled;
                        }
                    }
                    return this.handled;
                }
            });
        }
        this.mEditorActionListeners.add(onEditorActionListener);
    }

    void addTextChangedListener(android.text.TextWatcher textWatcher) {
        if (this.mTextChangedListeners == null) {
            this.mTextChangedListeners = new java.util.ArrayList();
        }
        this.mTextChangedListeners.add(textWatcher);
    }

    private void addKeyboardListener(final com.taobao.weex.ui.view.WXEditText wXEditText) {
        if (wXEditText != null && (wXEditText.getContext() instanceof android.app.Activity)) {
            getHostView().setkeyBoardHeightChangeListener(new io.dcloud.common.core.ui.keyboard.DCEditText.OnKeyboardHeightChangeListener() { // from class: com.taobao.weex.ui.component.DCWXInput.14
                @Override // io.dcloud.common.core.ui.keyboard.DCEditText.OnKeyboardHeightChangeListener
                public void onChange(boolean z, int i) {
                    if (com.taobao.weex.ui.component.DCWXInput.this.getInstance() == null || com.taobao.weex.ui.component.DCWXInput.this.getInstance().isDestroy() || wXEditText == null) {
                        return;
                    }
                    com.taobao.weex.ui.component.DCWXInput dCWXInput = com.taobao.weex.ui.component.DCWXInput.this;
                    dCWXInput.keyboardHeight = (int) com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(i, dCWXInput.getInstance().getInstanceViewPortWidthWithFloat());
                    java.util.HashMap map = new java.util.HashMap(2);
                    map.put("height", java.lang.Float.valueOf(com.taobao.weex.ui.component.DCWXInput.this.keyboardHeight));
                    map.put("duration", 0);
                    java.util.HashMap map2 = new java.util.HashMap(1);
                    map2.put("detail", map);
                    com.taobao.weex.ui.component.DCWXInput.this.fireEvent("keyboardheightchange", map2);
                    if (wXEditText.isFocused()) {
                        java.lang.String str = com.taobao.weex.ui.component.DCWXInput.this.isPassword ? com.taobao.weex.common.Constants.Value.PASSWORD : com.taobao.weex.ui.component.DCWXInput.this.mType;
                        if (!z && !com.taobao.weex.ui.component.DCWXInput.this.isConfirmHold && !str.equalsIgnoreCase(com.taobao.weex.common.Constants.Value.PASSWORD) && !io.dcloud.common.core.ui.DCKeyboardManager.getInstance().getFrontInputType().equals(com.taobao.weex.common.Constants.Value.PASSWORD)) {
                            com.taobao.weex.ui.component.DCWXInput.this.blur();
                        }
                        if (z) {
                            io.dcloud.common.core.ui.DCKeyboardManager.getInstance().setFrontInputType(str);
                        }
                    }
                    if (z) {
                        com.taobao.weex.ui.component.DCWXInput dCWXInput2 = com.taobao.weex.ui.component.DCWXInput.this;
                        dCWXInput2.keyboardHeight = dCWXInput2.keyboardHeight;
                    }
                }
            });
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void updateProperties(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.String strValueOf;
        if (map != null && map.size() > 0) {
            setType(map.containsKey("type") ? java.lang.String.valueOf(map.get("type")) : this.mType);
            java.lang.String str = this.mType;
            if (str != null && str.equals("text") && map.containsKey("confirmType")) {
                if (map.containsKey("confirmType")) {
                    strValueOf = java.lang.String.valueOf(map.get("confirmType"));
                } else {
                    strValueOf = this.mReturnKeyType;
                    if (strValueOf == null) {
                        strValueOf = "done";
                    }
                }
                setReturnKeyType(strValueOf);
            }
            com.taobao.weex.dom.WXAttr attrs = getAttrs();
            java.lang.String str2 = com.taobao.weex.common.Constants.Value.PASSWORD;
            if (attrs.containsKey(com.taobao.weex.common.Constants.Value.PASSWORD)) {
                boolean zBooleanValue = com.taobao.weex.utils.WXUtils.getBoolean(getAttrs().get(com.taobao.weex.common.Constants.Value.PASSWORD), false).booleanValue();
                this.isPassword = zBooleanValue;
                if (!zBooleanValue) {
                    str2 = this.mType;
                }
                if (str2 == null || getHostView() == null) {
                    return;
                } else {
                    getHostView().setInputType(getInputType(str2));
                }
            }
            if (map.containsKey("cursor")) {
                this.cursor = com.taobao.weex.utils.WXUtils.getInteger(map.get("cursor"), 0).intValue();
            }
            if (map.containsKey(com.taobao.weex.common.Constants.Name.SELECTION_START)) {
                this.selectionStart = com.taobao.weex.utils.WXUtils.getInteger(map.get(com.taobao.weex.common.Constants.Name.SELECTION_START), Integer.MAX_VALUE).intValue();
            }
            if (map.containsKey(com.taobao.weex.common.Constants.Name.SELECTION_END)) {
                this.selectionEnd = com.taobao.weex.utils.WXUtils.getInteger(map.get(com.taobao.weex.common.Constants.Name.SELECTION_END), Integer.MAX_VALUE).intValue();
            }
            if (map.containsKey(com.taobao.weex.common.Constants.Name.PLACEHOLDER)) {
                setPlaceholder(com.taobao.weex.utils.WXUtils.getString(map.get(com.taobao.weex.common.Constants.Name.PLACEHOLDER), ""));
            }
            if (map.containsKey("placeholderClass")) {
                this.placeholderStyle.putAll((com.alibaba.fastjson.JSONObject) com.alibaba.fastjson.JSONObject.parse(com.taobao.weex.utils.WXUtils.getString(map.get("placeholderClass"), "{}")));
            }
            if (map.containsKey("placeholderStyle")) {
                this.placeholderStyle.putAll((com.alibaba.fastjson.JSONObject) com.alibaba.fastjson.JSONObject.parse(com.taobao.weex.utils.WXUtils.getString(map.get("placeholderStyle"), "{}")));
            }
            if (map.containsKey("adjustPosition")) {
                setAdjustPosition(map.get("adjustPosition"));
            }
        }
        super.updateProperties(map);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        java.util.List<android.widget.TextView.OnEditorActionListener> list = this.mEditorActionListeners;
        if (list != null) {
            list.clear();
        }
        java.util.List<android.text.TextWatcher> list2 = this.mTextChangedListeners;
        if (list2 != null) {
            list2.clear();
        }
        if (this.mTextChangedEventDispatcher != null) {
            this.mTextChangedEventDispatcher = null;
        }
        if (getHostView() != null) {
            getHostView().destroy();
        }
    }

    private com.taobao.weex.ui.component.DCWXInput.PatternWrapper parseToPattern(java.lang.String str, java.lang.String str2) {
        java.util.regex.Pattern patternCompile;
        if (str == null || str2 == null) {
            return null;
        }
        if (!java.util.regex.Pattern.compile("/[\\S]+/[i]?[m]?[g]?").matcher(str).matches()) {
            com.taobao.weex.utils.WXLogUtils.w("WXInput", "Illegal js pattern syntax: " + str);
            return null;
        }
        java.lang.String strSubstring = str.substring(str.lastIndexOf("/") + 1);
        java.lang.String strSubstring2 = str.substring(str.indexOf("/") + 1, str.lastIndexOf("/"));
        int i = strSubstring.contains(com.facebook.common.callercontext.ContextChain.TAG_INFRA) ? 2 : 0;
        if (strSubstring.contains(com.taobao.weex.ui.component.WXComponent.PROP_FS_MATCH_PARENT)) {
            i |= 32;
        }
        boolean zContains = strSubstring.contains("g");
        try {
            patternCompile = java.util.regex.Pattern.compile(strSubstring2, i);
        } catch (java.util.regex.PatternSyntaxException unused) {
            com.taobao.weex.utils.WXLogUtils.w("WXInput", "Pattern syntax error: " + strSubstring2);
            patternCompile = null;
        }
        if (patternCompile == null) {
            return null;
        }
        com.taobao.weex.ui.component.DCWXInput.PatternWrapper patternWrapper = new com.taobao.weex.ui.component.DCWXInput.PatternWrapper();
        patternWrapper.global = zContains;
        patternWrapper.matcher = patternCompile;
        patternWrapper.replace = str2;
        return patternWrapper;
    }

    private static class PatternWrapper {
        private boolean global;
        private java.util.regex.Pattern matcher;
        private java.lang.String replace;

        private PatternWrapper() {
            this.global = false;
        }
    }

    public static class TextFormatter {
        private com.taobao.weex.ui.component.DCWXInput.PatternWrapper format;
        private com.taobao.weex.ui.component.DCWXInput.PatternWrapper recover;

        private TextFormatter(com.taobao.weex.ui.component.DCWXInput.PatternWrapper patternWrapper, com.taobao.weex.ui.component.DCWXInput.PatternWrapper patternWrapper2) {
            this.format = patternWrapper;
            this.recover = patternWrapper2;
        }

        java.lang.String format(java.lang.String str) {
            try {
                com.taobao.weex.ui.component.DCWXInput.PatternWrapper patternWrapper = this.format;
                if (patternWrapper != null) {
                    return patternWrapper.global ? this.format.matcher.matcher(str).replaceAll(this.format.replace) : this.format.matcher.matcher(str).replaceFirst(this.format.replace);
                }
                return str;
            } catch (java.lang.Throwable th) {
                com.taobao.weex.utils.WXLogUtils.w("WXInput", "[format] " + th.getMessage());
                return str;
            }
        }

        java.lang.String recover(java.lang.String str) {
            try {
                com.taobao.weex.ui.component.DCWXInput.PatternWrapper patternWrapper = this.recover;
                if (patternWrapper != null) {
                    return patternWrapper.global ? this.recover.matcher.matcher(str).replaceAll(this.recover.replace) : this.recover.matcher.matcher(str).replaceFirst(this.recover.replace);
                }
                return str;
            } catch (java.lang.Throwable th) {
                com.taobao.weex.utils.WXLogUtils.w("WXInput", "[formatted] " + th.getMessage());
                return str;
            }
        }
    }
}
