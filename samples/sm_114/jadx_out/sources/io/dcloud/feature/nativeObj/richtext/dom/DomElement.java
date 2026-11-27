package io.dcloud.feature.nativeObj.richtext.dom;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DomElement {
    public java.lang.String id;
    public java.lang.String onClickEvent;
    public io.dcloud.feature.nativeObj.richtext.dom.DomElement parentDomElement;
    public java.util.HashMap<java.lang.String, java.lang.String> style;
    public java.lang.String tagName;

    public void makeSpan(io.dcloud.feature.nativeObj.richtext.IAssets iAssets, android.widget.TextView textView, android.text.SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.append("\n");
    }

    public void parseDomElement(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        this.id = xmlPullParser.getAttributeValue(xmlPullParser.getNamespace(), "id");
        this.tagName = xmlPullParser.getName();
        parseStyle(xmlPullParser.getAttributeValue(xmlPullParser.getNamespace(), "style"));
        this.onClickEvent = xmlPullParser.getAttributeValue(xmlPullParser.getNamespace(), "onclick");
    }

    public void parseStyle(java.lang.String str) {
        java.lang.String[] strArrSplit;
        if (str == null || (strArrSplit = str.split(";")) == null || strArrSplit.length <= 0) {
            return;
        }
        this.style = new java.util.HashMap<>(2);
        for (java.lang.String str2 : strArrSplit) {
            try {
                java.lang.String[] strArrSplit2 = str2.split(":");
                this.style.put(strArrSplit2[0].trim(), strArrSplit2[1].trim());
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }
}
