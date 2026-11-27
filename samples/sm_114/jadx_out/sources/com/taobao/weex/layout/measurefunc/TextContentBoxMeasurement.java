package com.taobao.weex.layout.measurefunc;

/* JADX INFO: loaded from: classes.dex */
public class TextContentBoxMeasurement extends com.taobao.weex.layout.ContentBoxMeasurement {
    private static final android.graphics.Canvas DUMMY_CANVAS = new android.graphics.Canvas();
    private static final java.lang.String ELLIPSIS = "…";
    private java.util.concurrent.atomic.AtomicReference<android.text.Layout> atomicReference;
    private boolean hasBeenMeasured;
    private android.text.Layout layout;
    protected android.text.Layout.Alignment mAlignment;
    protected int mColor;
    protected java.lang.String mFontFamily;
    protected int mFontSize;
    protected int mFontStyle;
    protected int mFontWeight;
    protected boolean mIsColorSet;
    protected int mLineHeight;
    private int mNumberOfLines;
    private java.lang.String mText;
    protected com.taobao.weex.ui.component.WXTextDecoration mTextDecoration;
    protected android.text.TextPaint mTextPaint;
    private float previousWidth;
    private android.text.Spanned spanned;
    private android.text.TextUtils.TruncateAt textOverflow;

    public TextContentBoxMeasurement(com.taobao.weex.ui.component.WXComponent wXComponent) {
        super(wXComponent);
        this.mIsColorSet = false;
        this.hasBeenMeasured = false;
        this.mFontStyle = -1;
        this.mFontWeight = -1;
        this.mNumberOfLines = -1;
        this.mFontSize = -1;
        this.mLineHeight = -1;
        this.previousWidth = Float.NaN;
        this.mFontFamily = null;
        this.mText = null;
        this.mTextDecoration = com.taobao.weex.ui.component.WXTextDecoration.NONE;
        this.atomicReference = new java.util.concurrent.atomic.AtomicReference<>();
    }

    class SetSpanOperation {
        protected final int end;
        protected final int flag;
        protected final int start;
        protected final java.lang.Object what;

        SetSpanOperation(com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement textContentBoxMeasurement, int i, int i2, java.lang.Object obj) {
            this(i, i2, obj, 17);
        }

        SetSpanOperation(int i, int i2, java.lang.Object obj, int i3) {
            this.start = i;
            this.end = i2;
            this.what = obj;
            this.flag = i3;
        }

        public void execute(android.text.Spannable spannable) {
            spannable.setSpan(this.what, this.start, this.end, this.flag);
        }
    }

    @Override // com.taobao.weex.layout.ContentBoxMeasurement
    public void layoutBefore() {
        this.mTextPaint = new android.text.TextPaint(1);
        this.hasBeenMeasured = false;
        updateStyleAndText();
        this.spanned = createSpanned(this.mText);
    }

    @Override // com.taobao.weex.layout.ContentBoxMeasurement
    public void measureInternal(float f, float f2, int i, int i2) {
        this.hasBeenMeasured = true;
        float textWidth = getTextWidth(this.mTextPaint, f, i == com.taobao.weex.layout.MeasureMode.EXACTLY);
        if (textWidth > 0.0f && this.spanned != null) {
            android.text.Layout layoutCreateLayout = createLayout(textWidth, null);
            this.layout = layoutCreateLayout;
            this.previousWidth = layoutCreateLayout.getWidth();
            if (java.lang.Float.isNaN(f)) {
                f = this.layout.getWidth();
            } else {
                f = java.lang.Math.min(this.layout.getWidth(), f);
            }
            if (java.lang.Float.isNaN(f2)) {
                f2 = this.layout.getHeight();
            }
        } else {
            if (i == com.taobao.weex.layout.MeasureMode.UNSPECIFIED) {
                f = 0.0f;
            }
            if (i2 == com.taobao.weex.layout.MeasureMode.UNSPECIFIED) {
                f2 = 0.0f;
            }
        }
        this.mMeasureWidth = f;
        this.mMeasureHeight = f2;
    }

    @Override // com.taobao.weex.layout.ContentBoxMeasurement
    public void layoutAfter(float f, float f2) {
        if (this.mComponent != null) {
            if (this.hasBeenMeasured) {
                if (this.layout != null && com.taobao.weex.utils.WXDomUtils.getContentWidth(this.mComponent.getPadding(), this.mComponent.getBorder(), f) != this.previousWidth) {
                    recalculateLayout(f);
                }
            } else {
                updateStyleAndText();
                recalculateLayout(f);
            }
            this.hasBeenMeasured = false;
            android.text.Layout layout = this.layout;
            if (layout != null && !layout.equals(this.atomicReference.get()) && java.lang.Thread.currentThread() != android.os.Looper.getMainLooper().getThread()) {
                warmUpTextLayoutCache(this.layout);
            }
            swap();
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postOnUiThread(new java.lang.Runnable() { // from class: com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement.this.mComponent != null) {
                        com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement.this.mComponent.updateExtra(com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement.this.atomicReference.get());
                    }
                }
            }, this.mComponent.getInstanceId());
        }
    }

    private void updateStyleAndText() {
        updateStyleImp(this.mComponent.getStyles());
        this.mText = com.taobao.weex.dom.WXAttr.getValue(this.mComponent.getAttrs());
    }

    public void forceRelayout() {
        layoutBefore();
        measure(this.previousWidth, Float.NaN, com.taobao.weex.layout.MeasureMode.EXACTLY, com.taobao.weex.layout.MeasureMode.UNSPECIFIED);
        layoutAfter(this.previousWidth, Float.NaN);
    }

    private void updateStyleImp(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map != null) {
            if (map.containsKey(com.taobao.weex.common.Constants.Name.LINES)) {
                int lines = com.taobao.weex.dom.WXStyle.getLines(map);
                if (lines <= 0) {
                    lines = -1;
                }
                this.mNumberOfLines = lines;
            }
            if (map.containsKey(com.taobao.weex.common.Constants.Name.FONT_SIZE)) {
                this.mFontSize = com.taobao.weex.dom.WXStyle.getFontSize(map, this.mComponent.getInstance().getDefaultFontSize(), this.mComponent.getViewPortWidthForFloat());
            }
            if (map.containsKey(com.taobao.weex.common.Constants.Name.FONT_WEIGHT)) {
                this.mFontWeight = com.taobao.weex.dom.WXStyle.getFontWeight(map);
            }
            if (map.containsKey(com.taobao.weex.common.Constants.Name.FONT_STYLE)) {
                this.mFontStyle = com.taobao.weex.dom.WXStyle.getFontStyle(map);
            }
            if (map.containsKey("color")) {
                int color = com.taobao.weex.utils.WXResourceUtils.getColor(com.taobao.weex.dom.WXStyle.getTextColor(map));
                this.mColor = color;
                this.mIsColorSet = color != Integer.MIN_VALUE;
            }
            if (map.containsKey(com.taobao.weex.common.Constants.Name.TEXT_DECORATION)) {
                this.mTextDecoration = com.taobao.weex.dom.WXStyle.getTextDecoration(map);
            }
            if (map.containsKey(com.taobao.weex.common.Constants.Name.FONT_FAMILY)) {
                this.mFontFamily = com.taobao.weex.dom.WXStyle.getFontFamily(map);
            }
            this.mAlignment = com.taobao.weex.dom.WXStyle.getTextAlignment(map, this.mComponent.isLayoutRTL());
            this.textOverflow = com.taobao.weex.dom.WXStyle.getTextOverflow(map);
            int lineHeight = com.taobao.weex.dom.WXStyle.getLineHeight(map, this.mComponent.getViewPortWidthForFloat());
            if (lineHeight != -1) {
                this.mLineHeight = lineHeight;
            }
        }
    }

    protected android.text.Spanned createSpanned(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            android.text.SpannableString spannableString = new android.text.SpannableString(str);
            updateSpannable(spannableString, 17);
            return spannableString;
        }
        return new android.text.SpannableString("");
    }

    protected void updateSpannable(android.text.Spannable spannable, int i) {
        com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement textContentBoxMeasurement;
        android.text.Spannable spannable2;
        int i2;
        int length = spannable.length();
        int i3 = this.mFontSize;
        if (i3 == -1) {
            this.mTextPaint.setTextSize(this.mComponent.getInstance().getDefaultFontSize());
        } else {
            this.mTextPaint.setTextSize(i3);
        }
        if (this.mLineHeight != -1) {
            textContentBoxMeasurement = this;
            spannable2 = spannable;
            i2 = i;
            textContentBoxMeasurement.setSpan(spannable2, new com.taobao.weex.dom.WXLineHeightSpan(this.mLineHeight), 0, length, i2);
        } else {
            textContentBoxMeasurement = this;
            spannable2 = spannable;
            i2 = i;
        }
        textContentBoxMeasurement.setSpan(spannable2, new android.text.style.AlignmentSpan.Standard(textContentBoxMeasurement.mAlignment), 0, length, i2);
        if (textContentBoxMeasurement.mFontStyle != -1 || textContentBoxMeasurement.mFontWeight != -1 || textContentBoxMeasurement.mFontFamily != null) {
            textContentBoxMeasurement.setSpan(spannable2, new com.taobao.weex.dom.WXCustomStyleSpan(textContentBoxMeasurement.mFontStyle, textContentBoxMeasurement.mFontWeight, textContentBoxMeasurement.mFontFamily), 0, length, i2);
        }
        if (textContentBoxMeasurement.mIsColorSet) {
            textContentBoxMeasurement.mTextPaint.setColor(textContentBoxMeasurement.mColor);
        }
        if (textContentBoxMeasurement.mTextDecoration == com.taobao.weex.ui.component.WXTextDecoration.UNDERLINE || textContentBoxMeasurement.mTextDecoration == com.taobao.weex.ui.component.WXTextDecoration.LINETHROUGH) {
            textContentBoxMeasurement.setSpan(spannable2, new com.taobao.weex.dom.TextDecorationSpan(textContentBoxMeasurement.mTextDecoration), 0, length, i2);
        }
    }

    protected void setSpan(android.text.Spannable spannable, java.lang.Object obj, int i, int i2, int i3) {
        spannable.setSpan(obj, i, i2, i3);
    }

    private float getTextWidth(android.text.TextPaint textPaint, float f, boolean z) {
        if (this.mText == null) {
            if (!z) {
                return 0.0f;
            }
        } else if (!z) {
            float desiredWidth = android.text.Layout.getDesiredWidth(this.spanned, textPaint);
            if (com.taobao.weex.utils.WXUtils.isUndefined(f) || desiredWidth < f) {
                return desiredWidth;
            }
        }
        return f;
    }

    private android.text.Layout createLayout(float f, android.text.Layout layout) {
        android.text.SpannableStringBuilder spannableStringBuilder;
        if (this.previousWidth != f || layout == null) {
            layout = new android.text.StaticLayout(this.spanned, this.mTextPaint, (int) java.lang.Math.ceil(f), android.text.Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }
        int i = this.mNumberOfLines;
        if (i != -1 && i > 0 && i < layout.getLineCount()) {
            int i2 = this.mNumberOfLines;
            if (i2 > 1) {
                int lineStart = layout.getLineStart(i2 - 1);
                int lineEnd = layout.getLineEnd(this.mNumberOfLines - 1);
                if (lineStart < lineEnd) {
                    if (lineStart > 0) {
                        spannableStringBuilder = new android.text.SpannableStringBuilder(this.spanned.subSequence(0, lineStart));
                    } else {
                        spannableStringBuilder = new android.text.SpannableStringBuilder();
                    }
                    double d = f;
                    spannableStringBuilder.append((java.lang.CharSequence) truncate(new android.text.SpannableStringBuilder(this.spanned.subSequence(lineStart, lineEnd)), this.mTextPaint, (int) java.lang.Math.ceil(d), this.textOverflow));
                    adjustSpansRange(this.spanned, spannableStringBuilder);
                    this.spanned = spannableStringBuilder;
                    return new android.text.StaticLayout(this.spanned, this.mTextPaint, (int) java.lang.Math.ceil(d), android.text.Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                }
            } else {
                int iCeil = (int) java.lang.Math.ceil(f);
                android.text.Spanned spanned = this.spanned;
                return android.text.StaticLayout.Builder.obtain(spanned, 0, spanned.length(), this.mTextPaint, iCeil).setMaxLines(1).setEllipsize(android.text.TextUtils.TruncateAt.END).setEllipsizedWidth(iCeil).build();
            }
        }
        return layout;
    }

    private android.text.Spanned truncate(android.text.Editable editable, android.text.TextPaint textPaint, int i, android.text.TextUtils.TruncateAt truncateAt) {
        android.text.SpannedString spannedString = new android.text.SpannedString("");
        if (!android.text.TextUtils.isEmpty(editable) && editable.length() > 0) {
            if (truncateAt != null) {
                editable.append(ELLIPSIS);
                for (java.lang.Object obj : editable.getSpans(0, editable.length(), java.lang.Object.class)) {
                    int spanStart = editable.getSpanStart(obj);
                    int spanEnd = editable.getSpanEnd(obj);
                    if (spanStart == 0 && spanEnd == editable.length() - 1) {
                        editable.removeSpan(obj);
                        editable.setSpan(obj, 0, editable.length(), editable.getSpanFlags(obj));
                    }
                }
            }
            while (editable.length() > 1) {
                int length = editable.length();
                int i2 = length - 1;
                if (truncateAt != null) {
                    i2 = length - 2;
                }
                editable.delete(i2, i2 + 1);
                if (new android.text.StaticLayout(editable, textPaint, i, android.text.Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount() <= 1) {
                    return editable;
                }
            }
        }
        return spannedString;
    }

    private void adjustSpansRange(android.text.Spanned spanned, android.text.Spannable spannable) {
        for (java.lang.Object obj : spanned.getSpans(0, spanned.length(), java.lang.Object.class)) {
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (spanStart == 0 && spanEnd == spanned.length()) {
                spannable.removeSpan(obj);
                spannable.setSpan(obj, 0, spannable.length(), spanned.getSpanFlags(obj));
            }
        }
    }

    private void recalculateLayout(float f) {
        float contentWidth = com.taobao.weex.utils.WXDomUtils.getContentWidth(this.mComponent.getPadding(), this.mComponent.getBorder(), f);
        if (contentWidth > 0.0f) {
            android.text.Spanned spannedCreateSpanned = createSpanned(this.mText);
            this.spanned = spannedCreateSpanned;
            if (spannedCreateSpanned != null) {
                android.text.Layout layoutCreateLayout = createLayout(contentWidth, this.layout);
                this.layout = layoutCreateLayout;
                this.previousWidth = layoutCreateLayout.getWidth();
                return;
            }
            this.previousWidth = 0.0f;
        }
    }

    private boolean warmUpTextLayoutCache(android.text.Layout layout) {
        try {
            layout.draw(DUMMY_CANVAS);
            return true;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.eTag("TextWarmUp", e);
            return false;
        }
    }

    private void swap() {
        android.text.Layout layout = this.layout;
        if (layout != null) {
            this.atomicReference.set(layout);
            this.layout = null;
        }
        this.hasBeenMeasured = false;
    }
}
