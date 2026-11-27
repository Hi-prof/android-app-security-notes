package io.dcloud.feature.weex_text;

/* JADX INFO: loaded from: classes2.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class DCWXText extends com.taobao.weex.ui.component.WXText {
    public DCWXText(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        setContentBoxMeasurement(new io.dcloud.feature.weex_text.DCTextContentBoxMeasurement(this));
    }

    public static class Creator implements com.taobao.weex.ui.ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public com.taobao.weex.ui.component.WXComponent createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
            return new io.dcloud.feature.weex_text.DCWXText(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "selectable")
    public void setSelectable(boolean z) {
        getHostView().enableCopy(true);
    }
}
