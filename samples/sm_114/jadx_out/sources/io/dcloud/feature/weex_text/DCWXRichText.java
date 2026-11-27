package io.dcloud.feature.weex_text;

/* JADX INFO: loaded from: classes2.dex */
public class DCWXRichText extends com.taobao.weex.ui.component.WXText {
    public DCWXRichText(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        setContentBoxMeasurement(new io.dcloud.feature.weex_text.DCWXRichText.RichTextContentBoxMeasurement(this));
    }

    static class RichTextContentBoxMeasurement extends io.dcloud.feature.weex_text.DCTextContentBoxMeasurement {
        public RichTextContentBoxMeasurement(com.taobao.weex.ui.component.WXComponent wXComponent) {
            super(wXComponent);
        }

        @Override // io.dcloud.feature.weex_text.DCTextContentBoxMeasurement, com.taobao.weex.layout.measurefunc.TextContentBoxMeasurement
        protected android.text.Spanned createSpanned(java.lang.String str) {
            if (((this.mComponent.getInstance() != null) & (this.mComponent.getInstance().getUIContext() != null)) && !android.text.TextUtils.isEmpty(this.mComponent.getInstanceId())) {
                android.text.Spannable spannable = com.taobao.weex.ui.component.richtext.node.RichTextNode.parse(this.mComponent.getInstance().getUIContext(), this.mComponent.getInstanceId(), this.mComponent.getRef(), str);
                updateSpannable(spannable, com.taobao.weex.ui.component.richtext.node.RichTextNode.createSpanFlag(0));
                return spannable;
            }
            return new android.text.SpannedString("");
        }
    }

    public static class Creator implements com.taobao.weex.ui.ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public com.taobao.weex.ui.component.WXComponent createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
            return new io.dcloud.feature.weex_text.DCWXRichText(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXText, com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.component.richtext.WXRichTextView initComponentHostView(android.content.Context context) {
        return new com.taobao.weex.ui.component.richtext.WXRichTextView(context);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void updateAttrs(java.util.Map<java.lang.String, java.lang.Object> map) {
        super.updateAttrs(map);
        if (map.containsKey("value")) {
            com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: io.dcloud.feature.weex_text.DCWXRichText.1
                @Override // java.lang.Runnable
                public void run() {
                    if (io.dcloud.feature.weex_text.DCWXRichText.this.contentBoxMeasurement instanceof io.dcloud.feature.weex_text.DCWXRichText.RichTextContentBoxMeasurement) {
                        ((io.dcloud.feature.weex_text.DCWXRichText.RichTextContentBoxMeasurement) io.dcloud.feature.weex_text.DCWXRichText.this.contentBoxMeasurement).forceRelayout();
                    }
                }
            });
        }
    }

    @Override // com.taobao.weex.ui.component.WXText, io.dcloud.feature.uniapp.ui.component.AbsBasicComponent
    public void updateExtra(java.lang.Object obj) {
        super.updateExtra(obj);
        if (obj instanceof android.text.Layout) {
            android.text.Layout layout = (android.text.Layout) obj;
            if (getStyles().containsKey("height")) {
                return;
            }
            com.taobao.weex.bridge.WXBridgeManager.getInstance().setStyleHeight(getInstanceId(), getRef(), layout.getHeight());
        }
    }
}
