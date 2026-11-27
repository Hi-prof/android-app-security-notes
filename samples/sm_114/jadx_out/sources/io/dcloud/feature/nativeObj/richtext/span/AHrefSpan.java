package io.dcloud.feature.nativeObj.richtext.span;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AHrefSpan extends io.dcloud.feature.nativeObj.richtext.span.FontSpan implements io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble {
    java.lang.String mHref;
    java.lang.String strOnClickEvent;

    public AHrefSpan(float f, int i, int i2, int i3, int i4, java.lang.String str, java.lang.String str2) {
        super(f, i, i2, i3, i4);
        this.strOnClickEvent = str;
        this.mHref = str2;
    }

    @Override // io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble
    public java.lang.String getHref() {
        return this.mHref;
    }

    @Override // io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble
    public java.lang.String getOnClickEvent() {
        return this.strOnClickEvent;
    }

    @Override // io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble
    public boolean hasClickEvent() {
        return !android.text.TextUtils.isEmpty(getOnClickEvent());
    }

    @Override // io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble
    public void onClick(android.view.View view, io.dcloud.common.DHInterface.IWebview iWebview) {
        java.lang.String onClickEvent = getOnClickEvent();
        if (android.text.TextUtils.isEmpty(onClickEvent)) {
            return;
        }
        iWebview.executeScript(onClickEvent);
    }
}
