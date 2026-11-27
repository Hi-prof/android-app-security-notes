package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractEditComponent extends com.taobao.weex.ui.component.WXComponent<com.taobao.weex.ui.view.WXEditText> {
    private static final int MAX_TEXT_FORMAT_REPEAT = 3;
    private boolean mAutoFocus;
    private java.lang.String mBeforeText;
    private int mEditorAction;
    private java.util.List<android.widget.TextView.OnEditorActionListener> mEditorActionListeners;
    private int mFormatRepeatCount;
    private com.taobao.weex.ui.component.AbstractEditComponent.TextFormatter mFormatter;
    private boolean mIgnoreNextOnInputEvent;
    private final android.view.inputmethod.InputMethodManager mInputMethodManager;
    private boolean mKeepSelectionIndex;
    private java.lang.String mLastValue;
    private int mLineHeight;
    private boolean mListeningKeyboard;
    private java.lang.String mMax;
    private java.lang.String mMin;
    private com.taobao.weex.ui.component.WXComponent.OnClickListener mOnClickListener;
    private android.text.TextPaint mPaint;
    private java.lang.String mReturnKeyType;
    private android.text.TextWatcher mTextChangedEventDispatcher;
    private java.util.List<android.text.TextWatcher> mTextChangedListeners;
    private java.lang.String mType;
    private com.taobao.weex.ui.component.helper.SoftKeyboardDetector.Unregister mUnregister;

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

    public AbstractEditComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        this.mBeforeText = "";
        this.mType = "text";
        this.mMax = null;
        this.mMin = null;
        this.mLastValue = "";
        this.mEditorAction = 6;
        this.mReturnKeyType = null;
        this.mListeningKeyboard = false;
        this.mIgnoreNextOnInputEvent = false;
        this.mKeepSelectionIndex = false;
        this.mFormatter = null;
        this.mFormatRepeatCount = 0;
        this.mPaint = new android.text.TextPaint();
        this.mLineHeight = -1;
        this.mOnClickListener = new com.taobao.weex.ui.component.WXComponent.OnClickListener() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.3
            @Override // com.taobao.weex.ui.component.WXComponent.OnClickListener
            public void onHostViewClick() {
                java.lang.String str = com.taobao.weex.ui.component.AbstractEditComponent.this.mType;
                str.hashCode();
                if (str.equals("date")) {
                    com.taobao.weex.ui.component.AbstractEditComponent.this.hideSoftKeyboard();
                    if (com.taobao.weex.ui.component.AbstractEditComponent.this.getParent() != null) {
                        com.taobao.weex.ui.component.AbstractEditComponent.this.getParent().interceptFocus();
                    }
                    com.taobao.weex.ui.component.helper.WXTimeInputHelper.pickDate(com.taobao.weex.ui.component.AbstractEditComponent.this.mMax, com.taobao.weex.ui.component.AbstractEditComponent.this.mMin, com.taobao.weex.ui.component.AbstractEditComponent.this);
                    return;
                }
                if (str.equals(com.taobao.weex.common.Constants.Value.TIME)) {
                    com.taobao.weex.ui.component.AbstractEditComponent.this.hideSoftKeyboard();
                    if (com.taobao.weex.ui.component.AbstractEditComponent.this.getParent() != null) {
                        com.taobao.weex.ui.component.AbstractEditComponent.this.getParent().interceptFocus();
                    }
                    com.taobao.weex.ui.component.helper.WXTimeInputHelper.pickTime(com.taobao.weex.ui.component.AbstractEditComponent.this);
                }
            }
        };
        this.mInputMethodManager = (android.view.inputmethod.InputMethodManager) getContext().getSystemService("input_method");
        setContentBoxMeasurement(new com.taobao.weex.layout.ContentBoxMeasurement() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.1
            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutAfter(float f, float f2) {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void measureInternal(float f, float f2, int i, int i2) {
                if (com.taobao.weex.dom.CSSConstants.isUndefined(f) || i == com.taobao.weex.layout.MeasureMode.UNSPECIFIED) {
                    f = 0.0f;
                }
                this.mMeasureWidth = f;
                this.mMeasureHeight = com.taobao.weex.ui.component.AbstractEditComponent.this.getMeasureHeight();
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutBefore() {
                com.taobao.weex.ui.component.AbstractEditComponent.this.updateStyleAndAttrs();
            }
        });
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected void layoutDirectionDidChanged(boolean z) {
        int textAlign = getTextAlign((java.lang.String) getStyles().get(com.taobao.weex.common.Constants.Name.TEXT_ALIGN));
        if (textAlign <= 0) {
            textAlign = androidx.core.view.GravityCompat.START;
        }
        if (getHostView() instanceof com.taobao.weex.ui.view.WXEditText) {
            getHostView().setGravity(textAlign | getVerticalGravity());
        }
    }

    protected final float getMeasuredLineHeight() {
        int i = this.mLineHeight;
        return (i == -1 || i <= 0) ? this.mPaint.getFontMetrics(null) : i;
    }

    protected float getMeasureHeight() {
        return getMeasuredLineHeight();
    }

    protected void updateStyleAndAttrs() {
        if (getStyles().size() > 0) {
            int fontSize = getStyles().containsKey(com.taobao.weex.common.Constants.Name.FONT_SIZE) ? com.taobao.weex.dom.WXStyle.getFontSize(getStyles(), getInstance().getDefaultFontSize(), getViewPortWidthForFloat()) : -1;
            java.lang.String fontFamily = getStyles().containsKey(com.taobao.weex.common.Constants.Name.FONT_FAMILY) ? com.taobao.weex.dom.WXStyle.getFontFamily(getStyles()) : null;
            int fontStyle = getStyles().containsKey(com.taobao.weex.common.Constants.Name.FONT_STYLE) ? com.taobao.weex.dom.WXStyle.getFontStyle(getStyles()) : -1;
            int fontWeight = getStyles().containsKey(com.taobao.weex.common.Constants.Name.FONT_WEIGHT) ? com.taobao.weex.dom.WXStyle.getFontWeight(getStyles()) : -1;
            int lineHeight = com.taobao.weex.dom.WXStyle.getLineHeight(getStyles(), getViewPortWidthForFloat());
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
        return wXEditText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(com.taobao.weex.ui.view.WXEditText wXEditText) {
        super.onHostViewInitialized(wXEditText);
        addFocusChangeListener(new com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.2
            @Override // com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener
            public void onFocusChange(boolean z) {
                if (!z) {
                    com.taobao.weex.ui.component.AbstractEditComponent.this.decideSoftKeyboard();
                }
                com.taobao.weex.ui.component.AbstractEditComponent.this.setPseudoClassStatus(com.taobao.weex.common.Constants.PSEUDO.FOCUS, z);
            }
        });
        addKeyboardListener(wXEditText);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean isConsumeTouch() {
        return !isDisabled();
    }

    private void applyOnClickListener() {
        addClickListener(this.mOnClickListener);
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
        android.text.TextWatcher textWatcher = new android.text.TextWatcher() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
                if (com.taobao.weex.ui.component.AbstractEditComponent.this.mTextChangedListeners != null) {
                    java.util.Iterator it = com.taobao.weex.ui.component.AbstractEditComponent.this.mTextChangedListeners.iterator();
                    while (it.hasNext()) {
                        ((android.text.TextWatcher) it.next()).beforeTextChanged(charSequence, i, i2, i3);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
                if (com.taobao.weex.ui.component.AbstractEditComponent.this.mFormatter != null) {
                    java.lang.String str = com.taobao.weex.ui.component.AbstractEditComponent.this.mFormatter.format(com.taobao.weex.ui.component.AbstractEditComponent.this.mFormatter.recover(charSequence.toString()));
                    if (str.equals(charSequence.toString()) || com.taobao.weex.ui.component.AbstractEditComponent.this.mFormatRepeatCount >= 3) {
                        com.taobao.weex.ui.component.AbstractEditComponent.this.mFormatRepeatCount = 0;
                    } else {
                        com.taobao.weex.ui.component.AbstractEditComponent.this.mFormatRepeatCount++;
                        int length = com.taobao.weex.ui.component.AbstractEditComponent.this.mFormatter.format(com.taobao.weex.ui.component.AbstractEditComponent.this.mFormatter.recover(charSequence.subSequence(0, wXEditText.getSelectionStart()).toString())).length();
                        wXEditText.setText(str);
                        wXEditText.setSelection(length);
                        return;
                    }
                }
                if (com.taobao.weex.ui.component.AbstractEditComponent.this.mTextChangedListeners != null) {
                    java.util.Iterator it = com.taobao.weex.ui.component.AbstractEditComponent.this.mTextChangedListeners.iterator();
                    while (it.hasNext()) {
                        ((android.text.TextWatcher) it.next()).onTextChanged(charSequence, i, i2, i3);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(android.text.Editable editable) {
                if (com.taobao.weex.ui.component.AbstractEditComponent.this.mTextChangedListeners != null) {
                    java.util.Iterator it = com.taobao.weex.ui.component.AbstractEditComponent.this.mTextChangedListeners.iterator();
                    while (it.hasNext()) {
                        ((android.text.TextWatcher) it.next()).afterTextChanged(editable);
                    }
                }
            }
        };
        this.mTextChangedEventDispatcher = textWatcher;
        wXEditText.addTextChangedListener(textWatcher);
        wXEditText.setTextSize(0, com.taobao.weex.dom.WXStyle.getFontSize(getStyles(), getInstance().getDefaultFontSize(), getInstance().getInstanceViewPortWidthWithFloat()));
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(java.lang.String str) {
        super.addEvent(str);
        if (getHostView() == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        final com.taobao.weex.ui.view.WXEditText hostView = getHostView();
        if (str.equals(com.taobao.weex.common.Constants.Event.CHANGE)) {
            addFocusChangeListener(new com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.5
                @Override // com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener
                public void onFocusChange(boolean z) {
                    if (z) {
                        com.taobao.weex.ui.component.AbstractEditComponent.this.mLastValue = hostView.getText().toString();
                        return;
                    }
                    java.lang.CharSequence text = hostView.getText();
                    if (text == null) {
                        text = "";
                    }
                    if (text.toString().equals(com.taobao.weex.ui.component.AbstractEditComponent.this.mLastValue)) {
                        return;
                    }
                    com.taobao.weex.ui.component.AbstractEditComponent.this.fireEvent(com.taobao.weex.common.Constants.Event.CHANGE, text.toString());
                    com.taobao.weex.ui.component.AbstractEditComponent.this.mLastValue = hostView.getText().toString();
                }
            });
            addEditorActionListener(new android.widget.TextView.OnEditorActionListener() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.6
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(android.widget.TextView textView, int i, android.view.KeyEvent keyEvent) {
                    if (i != com.taobao.weex.ui.component.AbstractEditComponent.this.mEditorAction) {
                        return false;
                    }
                    java.lang.CharSequence text = hostView.getText();
                    if (text == null) {
                        text = "";
                    }
                    if (!text.toString().equals(com.taobao.weex.ui.component.AbstractEditComponent.this.mLastValue)) {
                        com.taobao.weex.ui.component.AbstractEditComponent.this.fireEvent(com.taobao.weex.common.Constants.Event.CHANGE, text.toString());
                        com.taobao.weex.ui.component.AbstractEditComponent.this.mLastValue = hostView.getText().toString();
                    }
                    if (com.taobao.weex.ui.component.AbstractEditComponent.this.getParent() != null) {
                        com.taobao.weex.ui.component.AbstractEditComponent.this.getParent().interceptFocus();
                    }
                    com.taobao.weex.ui.component.AbstractEditComponent.this.hideSoftKeyboard();
                    return true;
                }
            });
        } else if (str.equals("input")) {
            addTextChangedListener(new android.text.TextWatcher() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.7
                @Override // android.text.TextWatcher
                public void afterTextChanged(android.text.Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
                    if (com.taobao.weex.ui.component.AbstractEditComponent.this.mIgnoreNextOnInputEvent) {
                        com.taobao.weex.ui.component.AbstractEditComponent.this.mIgnoreNextOnInputEvent = false;
                        com.taobao.weex.ui.component.AbstractEditComponent.this.mBeforeText = charSequence.toString();
                    } else {
                        if (com.taobao.weex.ui.component.AbstractEditComponent.this.mBeforeText.equals(charSequence.toString())) {
                            return;
                        }
                        com.taobao.weex.ui.component.AbstractEditComponent.this.mBeforeText = charSequence.toString();
                        com.taobao.weex.ui.component.AbstractEditComponent.this.fireEvent("input", charSequence.toString());
                    }
                }
            });
        }
        if (com.taobao.weex.common.Constants.Event.RETURN.equals(str)) {
            addEditorActionListener(new android.widget.TextView.OnEditorActionListener() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.8
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(android.widget.TextView textView, int i, android.view.KeyEvent keyEvent) {
                    if (i != com.taobao.weex.ui.component.AbstractEditComponent.this.mEditorAction) {
                        return false;
                    }
                    java.util.HashMap map = new java.util.HashMap(2);
                    map.put(com.taobao.weex.common.Constants.Name.RETURN_KEY_TYPE, com.taobao.weex.ui.component.AbstractEditComponent.this.mReturnKeyType);
                    map.put("value", textView.getText().toString());
                    com.taobao.weex.ui.component.AbstractEditComponent.this.fireEvent(com.taobao.weex.common.Constants.Event.RETURN, map);
                    return true;
                }
            });
        }
        if (com.taobao.weex.common.Constants.Event.KEYBOARD.equals(str)) {
            this.mListeningKeyboard = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireEvent(java.lang.String str, java.lang.String str2) {
        if (str != null) {
            java.util.HashMap map = new java.util.HashMap(2);
            map.put("value", str2);
            map.put("timeStamp", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            java.util.HashMap map2 = new java.util.HashMap();
            java.util.HashMap map3 = new java.util.HashMap();
            map3.put("value", str2);
            map2.put(com.taobao.weex.ui.component.list.template.TemplateDom.KEY_ATTRS, map3);
            com.taobao.weex.WXSDKManager.getInstance().fireEvent(getInstanceId(), getRef(), str, map, map2);
        }
    }

    public void performOnChange(java.lang.String str) {
        if (getEvents() != null) {
            com.taobao.weex.dom.WXEvent events = getEvents();
            java.lang.String str2 = com.taobao.weex.common.Constants.Event.CHANGE;
            if (!events.contains(com.taobao.weex.common.Constants.Event.CHANGE)) {
                str2 = null;
            }
            fireEvent(str2, str);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "keepSelectionIndex":
                this.mKeepSelectionIndex = com.taobao.weex.utils.WXUtils.getBoolean(obj, false).booleanValue();
                return true;
            case "placeholderColor":
                java.lang.String string = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string != null) {
                    setPlaceholderColor(string);
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
                setMax(java.lang.String.valueOf(obj));
                return true;
            case "min":
                setMin(java.lang.String.valueOf(obj));
                return true;
            case "type":
                java.lang.String string3 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string3 != null) {
                    setType(string3);
                }
                return true;
            case "color":
                java.lang.String string4 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string4 != null) {
                    setColor(string4);
                }
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
                java.lang.Boolean bool = com.taobao.weex.utils.WXUtils.getBoolean(obj, null);
                if (bool != null && this.mHost != 0) {
                    if (bool.booleanValue()) {
                        ((com.taobao.weex.ui.view.WXEditText) this.mHost).setFocusable(false);
                        ((com.taobao.weex.ui.view.WXEditText) this.mHost).setFocusableInTouchMode(false);
                    } else {
                        ((com.taobao.weex.ui.view.WXEditText) this.mHost).setFocusableInTouchMode(true);
                        ((com.taobao.weex.ui.view.WXEditText) this.mHost).setFocusable(true);
                    }
                }
                return true;
            case "fontSize":
                java.lang.String string5 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string5 != null) {
                    setFontSize(string5);
                }
                return true;
            case "placeholder":
                java.lang.String string6 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string6 != null) {
                    setPlaceholder(string6);
                }
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
            case "autofocus":
                java.lang.Boolean bool3 = com.taobao.weex.utils.WXUtils.getBoolean(obj, null);
                if (bool3 != null) {
                    setAutofocus(bool3.booleanValue());
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
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

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.PLACEHOLDER)
    public void setPlaceholder(java.lang.String str) {
        if (str == null || getHostView() == null) {
            return;
        }
        getHostView().setHint(str);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.PLACEHOLDER_COLOR)
    public void setPlaceholderColor(java.lang.String str) {
        int color;
        if (getHostView() == null || android.text.TextUtils.isEmpty(str) || (color = com.taobao.weex.utils.WXResourceUtils.getColor(str)) == Integer.MIN_VALUE) {
            return;
        }
        getHostView().setHintTextColor(color);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "type")
    public void setType(java.lang.String str) {
        android.util.Log.e("weex", "setType=" + str);
        if (str == null || getHostView() == null || this.mType.equals(str)) {
            return;
        }
        this.mType = str;
        getHostView().setInputType(getInputType(this.mType));
        java.lang.String str2 = this.mType;
        str2.hashCode();
        if (str2.equals("date") || str2.equals(com.taobao.weex.common.Constants.Value.TIME)) {
            applyOnClickListener();
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.AUTOFOCUS)
    public void setAutofocus(boolean z) {
        if (getHostView() == null) {
            return;
        }
        this.mAutoFocus = z;
        com.taobao.weex.ui.view.WXEditText hostView = getHostView();
        if (this.mAutoFocus) {
            hostView.setFocusable(true);
            hostView.requestFocus();
            hostView.setFocusableInTouchMode(true);
            showSoftKeyboard();
            return;
        }
        hideSoftKeyboard();
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "value")
    public void setValue(java.lang.String str) {
        com.taobao.weex.ui.view.WXEditText hostView = getHostView();
        if (hostView == null || android.text.TextUtils.equals(hostView.getText(), str)) {
            return;
        }
        this.mIgnoreNextOnInputEvent = true;
        int selectionStart = hostView.getSelectionStart();
        hostView.setText(str);
        if (!this.mKeepSelectionIndex) {
            selectionStart = str.length();
        }
        if (str == null) {
            selectionStart = 0;
        }
        hostView.setSelection(selectionStart);
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

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.TEXT_ALIGN)
    public void setTextAlign(java.lang.String str) {
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
                return 8194;
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

    @com.taobao.weex.ui.component.WXComponentProp(name = "max")
    public void setMax(java.lang.String str) {
        this.mMax = str;
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.MIN)
    public void setMin(java.lang.String str) {
        this.mMin = str;
    }

    private boolean showSoftKeyboard() {
        if (getHostView() == null) {
            return false;
        }
        getHostView().postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.9
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.ui.component.AbstractEditComponent.this.mInputMethodManager.showSoftInput(com.taobao.weex.ui.component.AbstractEditComponent.this.getHostView(), 1);
            }
        }), 100L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideSoftKeyboard() {
        if (getHostView() != null) {
            getHostView().postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.10
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.ui.component.AbstractEditComponent.this.mInputMethodManager.hideSoftInputFromWindow(com.taobao.weex.ui.component.AbstractEditComponent.this.getHostView().getWindowToken(), 0);
                }
            }), 16L);
        }
    }

    private int getTextAlign(java.lang.String str) {
        int i = isLayoutRTL() ? androidx.core.view.GravityCompat.END : androidx.core.view.GravityCompat.START;
        if (!android.text.TextUtils.isEmpty(str)) {
            if (str.equals("left")) {
                return androidx.core.view.GravityCompat.START;
            }
            if (str.equals("center")) {
                return 17;
            }
            if (str.equals("right")) {
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
        final android.content.Context context;
        com.taobao.weex.ui.view.WXEditText hostView = getHostView();
        if (hostView == null || (context = getContext()) == null || !(context instanceof android.app.Activity)) {
            return;
        }
        hostView.postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.11
            @Override // java.lang.Runnable
            public void run() {
                android.view.View currentFocus = ((android.app.Activity) context).getCurrentFocus();
                if (currentFocus == null || (currentFocus instanceof android.widget.EditText) || currentFocus.isFocused()) {
                    return;
                }
                com.taobao.weex.ui.component.AbstractEditComponent.this.mInputMethodManager.hideSoftInputFromWindow(com.taobao.weex.ui.component.AbstractEditComponent.this.getHostView().getWindowToken(), 0);
            }
        }), 16L);
    }

    @com.taobao.weex.annotation.JSMethod
    public void setSelectionRange(int i, int i2) {
        int length;
        com.taobao.weex.ui.view.WXEditText hostView = getHostView();
        if (hostView == null || i > (length = getHostView().length()) || i2 > length) {
            return;
        }
        focus();
        hostView.setSelection(i, i2);
    }

    @com.taobao.weex.annotation.JSMethod
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

    @com.taobao.weex.annotation.JSMethod
    public void setTextFormatter(com.alibaba.fastjson.JSONObject jSONObject) {
        try {
            java.lang.String string = jSONObject.getString("formatRule");
            java.lang.String string2 = jSONObject.getString("formatReplace");
            java.lang.String string3 = jSONObject.getString("recoverRule");
            java.lang.String string4 = jSONObject.getString("recoverReplace");
            com.taobao.weex.ui.component.AbstractEditComponent.PatternWrapper toPattern = parseToPattern(string, string2);
            com.taobao.weex.ui.component.AbstractEditComponent.PatternWrapper toPattern2 = parseToPattern(string3, string4);
            if (toPattern == null || toPattern2 == null) {
                return;
            }
            this.mFormatter = new com.taobao.weex.ui.component.AbstractEditComponent.TextFormatter(toPattern, toPattern2);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    protected final void addEditorActionListener(android.widget.TextView.OnEditorActionListener onEditorActionListener) {
        com.taobao.weex.ui.view.WXEditText hostView;
        if (onEditorActionListener == null || (hostView = getHostView()) == null) {
            return;
        }
        if (this.mEditorActionListeners == null) {
            this.mEditorActionListeners = new java.util.ArrayList();
            hostView.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.12
                private boolean handled = true;

                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(android.widget.TextView textView, int i, android.view.KeyEvent keyEvent) {
                    for (android.widget.TextView.OnEditorActionListener onEditorActionListener2 : com.taobao.weex.ui.component.AbstractEditComponent.this.mEditorActionListeners) {
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

    public final void addTextChangedListener(android.text.TextWatcher textWatcher) {
        if (this.mTextChangedListeners == null) {
            this.mTextChangedListeners = new java.util.ArrayList();
        }
        this.mTextChangedListeners.add(textWatcher);
    }

    private void addKeyboardListener(com.taobao.weex.ui.view.WXEditText wXEditText) {
        final android.content.Context context;
        if (wXEditText == null || (context = wXEditText.getContext()) == null || !(context instanceof android.app.Activity)) {
            return;
        }
        this.mUnregister = com.taobao.weex.ui.component.helper.SoftKeyboardDetector.registerKeyboardEventListener((android.app.Activity) context, new com.taobao.weex.ui.component.helper.SoftKeyboardDetector.OnKeyboardEventListener() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.13
            @Override // com.taobao.weex.ui.component.helper.SoftKeyboardDetector.OnKeyboardEventListener
            public void onKeyboardEvent(boolean z) {
                if (com.taobao.weex.ui.component.AbstractEditComponent.this.mListeningKeyboard) {
                    if (com.taobao.weex.ui.component.AbstractEditComponent.this.getInstance() == null || com.taobao.weex.ui.component.AbstractEditComponent.this.getInstance().isDestroy()) {
                        return;
                    }
                    java.util.HashMap map = new java.util.HashMap(1);
                    map.put("isShow", java.lang.Boolean.valueOf(z));
                    if (z) {
                        android.graphics.Rect rect = new android.graphics.Rect();
                        ((android.app.Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                        map.put("keyboardSize", java.lang.Float.valueOf(com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(com.taobao.weex.utils.WXViewUtils.getScreenHeight(context) - (rect.bottom - rect.top), com.taobao.weex.ui.component.AbstractEditComponent.this.getInstance().getInstanceViewPortWidthWithFloat())));
                    }
                    com.taobao.weex.ui.component.AbstractEditComponent.this.fireEvent(com.taobao.weex.common.Constants.Event.KEYBOARD, map);
                }
                if (z) {
                    return;
                }
                com.taobao.weex.ui.component.AbstractEditComponent.this.blur();
            }
        });
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        if (getHostView() != null) {
            getHostView().destroy();
        }
        com.taobao.weex.ui.component.helper.SoftKeyboardDetector.Unregister unregister = this.mUnregister;
        if (unregister != null) {
            try {
                unregister.execute();
                this.mUnregister = null;
            } catch (java.lang.Throwable th) {
                com.taobao.weex.utils.WXLogUtils.w("Unregister throw ", th);
            }
        }
    }

    private com.taobao.weex.ui.component.AbstractEditComponent.PatternWrapper parseToPattern(java.lang.String str, java.lang.String str2) {
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
        com.taobao.weex.ui.component.AbstractEditComponent.PatternWrapper patternWrapper = new com.taobao.weex.ui.component.AbstractEditComponent.PatternWrapper();
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

    private static class TextFormatter {
        private com.taobao.weex.ui.component.AbstractEditComponent.PatternWrapper format;
        private com.taobao.weex.ui.component.AbstractEditComponent.PatternWrapper recover;

        private TextFormatter(com.taobao.weex.ui.component.AbstractEditComponent.PatternWrapper patternWrapper, com.taobao.weex.ui.component.AbstractEditComponent.PatternWrapper patternWrapper2) {
            this.format = patternWrapper;
            this.recover = patternWrapper2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public java.lang.String format(java.lang.String str) {
            try {
                com.taobao.weex.ui.component.AbstractEditComponent.PatternWrapper patternWrapper = this.format;
                if (patternWrapper != null) {
                    return patternWrapper.global ? this.format.matcher.matcher(str).replaceAll(this.format.replace) : this.format.matcher.matcher(str).replaceFirst(this.format.replace);
                }
                return str;
            } catch (java.lang.Throwable th) {
                com.taobao.weex.utils.WXLogUtils.w("WXInput", "[format] " + th.getMessage());
                return str;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public java.lang.String recover(java.lang.String str) {
            try {
                com.taobao.weex.ui.component.AbstractEditComponent.PatternWrapper patternWrapper = this.recover;
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
