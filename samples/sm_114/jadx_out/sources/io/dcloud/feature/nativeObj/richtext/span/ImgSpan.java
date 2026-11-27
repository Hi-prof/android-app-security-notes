package io.dcloud.feature.nativeObj.richtext.span;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ImgSpan extends android.text.style.ImageSpan implements io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble {
    java.lang.String mHref;
    java.lang.String mOnClickEvent;
    java.lang.String mSrc;

    public ImgSpan(android.graphics.drawable.Drawable drawable, java.lang.String str, int i, java.lang.String str2, java.lang.String str3) {
        super(drawable, str, i);
        this.mOnClickEvent = str2;
        this.mHref = str3;
        this.mSrc = str;
    }

    @Override // io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble
    public java.lang.String getHref() {
        return this.mHref;
    }

    @Override // io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble
    public java.lang.String getOnClickEvent() {
        return this.mOnClickEvent;
    }

    public java.lang.String getSrc() {
        return this.mSrc;
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
