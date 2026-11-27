package io.dcloud.feature.nativeObj.richtext.dom;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class HrDomElement extends io.dcloud.feature.nativeObj.richtext.dom.DomElement {
    java.lang.String align;
    java.lang.String size;
    java.lang.String width;

    java.lang.String getColor() {
        java.util.HashMap<java.lang.String, java.lang.String> map = this.style;
        return (map == null || !map.containsKey("border-color")) ? "#EEEEEE" : this.style.get("border-color");
    }

    @Override // io.dcloud.feature.nativeObj.richtext.dom.DomElement
    public void makeSpan(io.dcloud.feature.nativeObj.richtext.IAssets iAssets, android.widget.TextView textView, android.text.SpannableStringBuilder spannableStringBuilder) {
        int i;
        spannableStringBuilder.append("\n");
        spannableStringBuilder.append("1");
        int iStringToColor = iAssets.stringToColor(getColor());
        if ("left".equalsIgnoreCase(this.align)) {
            i = 1;
        } else {
            i = "right".equalsIgnoreCase(this.align) ? 2 : 0;
        }
        spannableStringBuilder.setSpan(new io.dcloud.feature.nativeObj.richtext.span.HrSpan(i, (int) iAssets.convertHeight(this.size, 1.0f), (int) iAssets.convertWidth(this.width, 1.0f), iStringToColor, (int) iAssets.convertWidth("100%", 1.0f)), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
    }

    @Override // io.dcloud.feature.nativeObj.richtext.dom.DomElement
    public void parseDomElement(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        super.parseDomElement(xmlPullParser);
        this.align = xmlPullParser.getAttributeValue(xmlPullParser.getNamespace(), io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ALIGN);
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(xmlPullParser.getNamespace(), "width");
        this.width = attributeValue;
        if (android.text.TextUtils.isEmpty(attributeValue)) {
            this.width = "100%";
        }
        java.lang.String attributeValue2 = xmlPullParser.getAttributeValue(xmlPullParser.getNamespace(), io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE);
        this.size = attributeValue2;
        if (android.text.TextUtils.isEmpty(attributeValue2)) {
            this.size = "1px";
        }
    }
}
