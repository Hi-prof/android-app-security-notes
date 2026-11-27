package io.dcloud.feature.nativeObj.richtext.dom;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class TextDomElement extends io.dcloud.feature.nativeObj.richtext.dom.DomElement {
    public java.lang.String color;
    public java.lang.String href;
    public java.lang.String text;

    private int getFontStyleInt() {
        return com.taobao.weex.common.Constants.Value.ITALIC.equalsIgnoreCase(getFontStyle()) ? 1 : 0;
    }

    private int getFontWeightInt() {
        return com.taobao.weex.common.Constants.Value.BOLD.equalsIgnoreCase(getFontWeight()) ? 1 : 0;
    }

    java.lang.String getColor() {
        java.util.HashMap<java.lang.String, java.lang.String> map = this.style;
        if (map != null && map.containsKey("color")) {
            return this.style.get("color");
        }
        if (!android.text.TextUtils.isEmpty(this.color) && !"a".equalsIgnoreCase(this.tagName)) {
            return this.color;
        }
        io.dcloud.feature.nativeObj.richtext.dom.DomElement domElement = this.parentDomElement;
        if (domElement == null || !(domElement instanceof io.dcloud.feature.nativeObj.richtext.dom.TextDomElement)) {
            return null;
        }
        return ((io.dcloud.feature.nativeObj.richtext.dom.TextDomElement) domElement).getColor();
    }

    java.lang.String getFontSize() {
        java.util.HashMap<java.lang.String, java.lang.String> map = this.style;
        if (map != null && map.containsKey("font-size")) {
            return this.style.get("font-size");
        }
        io.dcloud.feature.nativeObj.richtext.dom.DomElement domElement = this.parentDomElement;
        if (domElement == null || !(domElement instanceof io.dcloud.feature.nativeObj.richtext.dom.TextDomElement)) {
            return null;
        }
        return ((io.dcloud.feature.nativeObj.richtext.dom.TextDomElement) domElement).getFontSize();
    }

    java.lang.String getFontStyle() {
        java.util.HashMap<java.lang.String, java.lang.String> map = this.style;
        if (map != null && map.containsKey("font-style")) {
            return this.style.get("font-style");
        }
        io.dcloud.feature.nativeObj.richtext.dom.DomElement domElement = this.parentDomElement;
        if (domElement == null || !(domElement instanceof io.dcloud.feature.nativeObj.richtext.dom.TextDomElement)) {
            return null;
        }
        return ((io.dcloud.feature.nativeObj.richtext.dom.TextDomElement) domElement).getFontStyle();
    }

    java.lang.String getFontWeight() {
        java.util.HashMap<java.lang.String, java.lang.String> map = this.style;
        if (map != null && map.containsKey("font-weight")) {
            return this.style.get("font-weight");
        }
        io.dcloud.feature.nativeObj.richtext.dom.DomElement domElement = this.parentDomElement;
        if (domElement == null || !(domElement instanceof io.dcloud.feature.nativeObj.richtext.dom.TextDomElement)) {
            return null;
        }
        return ((io.dcloud.feature.nativeObj.richtext.dom.TextDomElement) domElement).getFontWeight();
    }

    java.lang.String getTextDecoration() {
        java.util.HashMap<java.lang.String, java.lang.String> map = this.style;
        if (map != null && map.containsKey("text-decoration")) {
            return this.style.get("text-decoration");
        }
        io.dcloud.feature.nativeObj.richtext.dom.DomElement domElement = this.parentDomElement;
        if (domElement == null || !(domElement instanceof io.dcloud.feature.nativeObj.richtext.dom.TextDomElement)) {
            return null;
        }
        return ((io.dcloud.feature.nativeObj.richtext.dom.TextDomElement) domElement).getTextDecoration();
    }

    int getTextDecorationInt() {
        java.lang.String textDecoration = getTextDecoration();
        if ("underline".equalsIgnoreCase(textDecoration)) {
            return 1;
        }
        if ("line-through".equalsIgnoreCase(textDecoration)) {
            return 2;
        }
        return "a".equalsIgnoreCase(this.tagName) ? 1 : 0;
    }

    @Override // io.dcloud.feature.nativeObj.richtext.dom.DomElement
    public void makeSpan(io.dcloud.feature.nativeObj.richtext.IAssets iAssets, android.widget.TextView textView, android.text.SpannableStringBuilder spannableStringBuilder) {
        if (android.text.TextUtils.isEmpty(this.text)) {
            return;
        }
        boolean zEqualsIgnoreCase = "a".equalsIgnoreCase(this.tagName);
        boolean zEqualsIgnoreCase2 = com.facebook.common.callercontext.ContextChain.TAG_PRODUCT.equalsIgnoreCase(this.tagName);
        if (zEqualsIgnoreCase2) {
            spannableStringBuilder.append("\n");
        }
        spannableStringBuilder.append((java.lang.CharSequence) this.text);
        float f = io.dcloud.common.util.PdrUtil.parseFloat(getFontSize(), 100.0f, io.dcloud.feature.nativeObj.richtext.span.FontSpan.DEF_FONT_SIZE, 1.0f);
        int defaultColor = iAssets.getDefaultColor(zEqualsIgnoreCase);
        int fontWeightInt = getFontWeightInt();
        int fontStyleInt = getFontStyleInt();
        int textDecorationInt = getTextDecorationInt();
        java.lang.String color = getColor();
        if (!android.text.TextUtils.isEmpty(color)) {
            defaultColor = iAssets.stringToColor(color);
        }
        int i = defaultColor;
        if (zEqualsIgnoreCase) {
            spannableStringBuilder.setSpan(new io.dcloud.feature.nativeObj.richtext.span.AHrefSpan(f, i, fontWeightInt, fontStyleInt, textDecorationInt, this.onClickEvent, this.href), spannableStringBuilder.length() - this.text.length(), spannableStringBuilder.length(), 17);
        } else {
            spannableStringBuilder.setSpan(new io.dcloud.feature.nativeObj.richtext.span.FontSpan(f, i, fontWeightInt, fontStyleInt, textDecorationInt), spannableStringBuilder.length() - this.text.length(), spannableStringBuilder.length(), 17);
        }
        if (zEqualsIgnoreCase2) {
            spannableStringBuilder.append("\n");
        }
    }

    @Override // io.dcloud.feature.nativeObj.richtext.dom.DomElement
    public void parseDomElement(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        super.parseDomElement(xmlPullParser);
        this.color = xmlPullParser.getAttributeValue(xmlPullParser.getNamespace(), "color");
        this.href = xmlPullParser.getAttributeValue(xmlPullParser.getNamespace(), "href");
    }
}
