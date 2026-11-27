package com.taobao.weex.ui.component.richtext.span;

/* JADX INFO: loaded from: classes.dex */
public class ASpan extends android.text.style.ClickableSpan {
    private java.lang.String mInstanceId;
    private java.lang.String mURL;

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(android.text.TextPaint textPaint) {
    }

    public ASpan(java.lang.String str, java.lang.String str2) {
        this.mInstanceId = str;
        this.mURL = str2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(android.view.View view) {
        com.taobao.weex.utils.ATagUtil.onClick(view, this.mInstanceId, this.mURL);
    }
}
