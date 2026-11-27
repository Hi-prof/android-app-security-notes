package io.dcloud.feature.weex_text;

/* JADX INFO: loaded from: classes2.dex */
public class DCTextContentBoxMeasurement extends com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement {
    private boolean decode;
    private java.lang.String space;

    public DCTextContentBoxMeasurement(com.taobao.weex.ui.component.WXComponent wXComponent) {
        super(wXComponent);
        this.space = "";
        this.decode = false;
    }

    @Override // com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement, com.taobao.weex.layout.ContentBoxMeasurement
    public void layoutBefore() {
        com.taobao.weex.dom.WXAttr attrs = this.mComponent.getAttrs();
        this.space = (java.lang.String) attrs.get("space");
        this.decode = java.lang.Boolean.valueOf(attrs.containsKey("decode") ? attrs.get("decode").toString() : io.dcloud.common.constant.AbsoluteConst.FALSE).booleanValue();
        super.layoutBefore();
    }

    @Override // com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement
    protected android.text.Spanned createSpanned(java.lang.String str) {
        java.lang.String str2 = this.space;
        if (str2 != null) {
            if (str2.equals("ensp")) {
                str = android.text.Html.fromHtml(str.replaceAll(com.taobao.weex.el.parse.Operators.SPACE_STR, "&ensp;")).toString();
            } else if (this.space.equals("emsp")) {
                str = android.text.Html.fromHtml(str.replaceAll(com.taobao.weex.el.parse.Operators.SPACE_STR, "&emsp;")).toString();
            }
        }
        return super.createSpanned(str);
    }

    @Override // com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement
    protected void updateSpannable(android.text.Spannable spannable, int i) {
        io.dcloud.feature.weex_text.DCTextContentBoxMeasurement dCTextContentBoxMeasurement;
        android.text.Spannable spannable2;
        int i2;
        if (this.mComponent == null || this.mComponent.getInstance() == null) {
            return;
        }
        int length = spannable.length();
        if (this.mFontSize == -1) {
            this.mTextPaint.setTextSize(com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(this.mComponent.getInstance().getDefaultFontSize(), this.mComponent.getInstance().getInstanceViewPortWidthWithFloat()));
        } else {
            this.mTextPaint.setTextSize(this.mFontSize);
        }
        if (this.mLineHeight != -1) {
            dCTextContentBoxMeasurement = this;
            spannable2 = spannable;
            i2 = i;
            dCTextContentBoxMeasurement.setSpan(spannable2, new com.taobao.weex.dom.WXLineHeightSpan(this.mLineHeight), 0, length, i2);
        } else {
            dCTextContentBoxMeasurement = this;
            spannable2 = spannable;
            i2 = i;
        }
        dCTextContentBoxMeasurement.setSpan(spannable2, new android.text.style.AlignmentSpan.Standard(dCTextContentBoxMeasurement.mAlignment), 0, length, i2);
        if (dCTextContentBoxMeasurement.mFontStyle != -1 || dCTextContentBoxMeasurement.mFontWeight != -1 || dCTextContentBoxMeasurement.mFontFamily != null) {
            dCTextContentBoxMeasurement.setSpan(spannable2, new com.taobao.weex.dom.WXCustomStyleSpan(dCTextContentBoxMeasurement.mFontStyle, dCTextContentBoxMeasurement.mFontWeight, dCTextContentBoxMeasurement.mFontFamily), 0, length, i2);
        }
        if (dCTextContentBoxMeasurement.mIsColorSet) {
            dCTextContentBoxMeasurement.mTextPaint.setColor(dCTextContentBoxMeasurement.mColor);
        }
        if (dCTextContentBoxMeasurement.mTextDecoration == com.taobao.weex.ui.component.WXTextDecoration.UNDERLINE || dCTextContentBoxMeasurement.mTextDecoration == com.taobao.weex.ui.component.WXTextDecoration.LINETHROUGH) {
            dCTextContentBoxMeasurement.setSpan(spannable2, new com.taobao.weex.dom.TextDecorationSpan(dCTextContentBoxMeasurement.mTextDecoration), 0, length, i2);
        }
    }
}
