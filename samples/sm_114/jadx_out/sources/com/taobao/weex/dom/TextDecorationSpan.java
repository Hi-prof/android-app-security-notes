package com.taobao.weex.dom;

/* JADX INFO: loaded from: classes.dex */
public class TextDecorationSpan extends android.text.style.CharacterStyle implements android.text.style.UpdateAppearance {
    private final com.taobao.weex.ui.component.WXTextDecoration mTextDecoration;

    public TextDecorationSpan(com.taobao.weex.ui.component.WXTextDecoration wXTextDecoration) {
        this.mTextDecoration = wXTextDecoration;
    }

    /* JADX INFO: renamed from: com.taobao.weex.dom.TextDecorationSpan$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$taobao$weex$ui$component$WXTextDecoration;

        static {
            int[] iArr = new int[com.taobao.weex.ui.component.WXTextDecoration.values().length];
            $SwitchMap$com$taobao$weex$ui$component$WXTextDecoration = iArr;
            try {
                iArr[com.taobao.weex.ui.component.WXTextDecoration.LINETHROUGH.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$taobao$weex$ui$component$WXTextDecoration[com.taobao.weex.ui.component.WXTextDecoration.UNDERLINE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$taobao$weex$ui$component$WXTextDecoration[com.taobao.weex.ui.component.WXTextDecoration.NONE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(android.text.TextPaint textPaint) {
        int i = com.taobao.weex.dom.TextDecorationSpan.AnonymousClass1.$SwitchMap$com$taobao$weex$ui$component$WXTextDecoration[this.mTextDecoration.ordinal()];
        if (i == 1) {
            textPaint.setUnderlineText(false);
            textPaint.setStrikeThruText(true);
        } else if (i == 2) {
            textPaint.setUnderlineText(true);
            textPaint.setStrikeThruText(false);
        } else {
            if (i != 3) {
                return;
            }
            textPaint.setUnderlineText(false);
            textPaint.setStrikeThruText(false);
        }
    }
}
