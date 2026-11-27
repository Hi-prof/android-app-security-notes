package io.dcloud.feature.nativeObj.data;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ButtonDataItem {
    private java.lang.String fontSrc;
    private java.lang.String fontType;
    private java.lang.String onclick;
    private java.lang.String text;
    private java.lang.String title;
    private java.lang.String webviewUuid;

    public ButtonDataItem(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        this.text = str;
        this.title = str2;
        this.onclick = str6;
        this.fontSrc = str4;
        this.fontType = str5;
        this.webviewUuid = str3;
    }

    public java.lang.String getFontSrc() {
        return this.fontSrc;
    }

    public java.lang.String getFontType() {
        return this.fontType;
    }

    public java.lang.String getOnclick() {
        return this.onclick;
    }

    public java.lang.String getText() {
        return this.text;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public java.lang.String getWebviewUuid() {
        return this.webviewUuid;
    }

    public void update(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        this.text = str;
        this.title = str2;
        this.onclick = str6;
        this.fontSrc = str4;
        this.fontType = str5;
        this.webviewUuid = str3;
    }
}
