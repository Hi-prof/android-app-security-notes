package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
public class WXComponentFactory {
    public static com.taobao.weex.ui.component.WXComponent newInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        if (wXSDKInstance != null && !android.text.TextUtils.isEmpty(basicComponentData.mComponentType)) {
            com.taobao.weex.ui.IFComponentHolder component = com.taobao.weex.ui.WXComponentRegistry.getComponent(basicComponentData.mComponentType);
            if (component == null) {
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.e("WXComponentFactory error type:[" + basicComponentData.mComponentType + "] class not found");
                }
                component = com.taobao.weex.ui.WXComponentRegistry.getComponent(com.taobao.weex.ui.component.WXBasicComponentType.CONTAINER);
                if (component == null) {
                    com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(wXSDKInstance.getInstanceId(), com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_COMPONENT_NOT_REGISTER, "createComponent", basicComponentData.mComponentType + " not registered", null);
                    return null;
                }
            }
            try {
                return component.createInstance(wXSDKInstance, wXVContainer, basicComponentData);
            } catch (java.lang.Throwable th) {
                com.taobao.weex.utils.WXLogUtils.e("WXComponentFactory Exception type:[" + basicComponentData.mComponentType + "] ", th);
            }
        }
        return null;
    }
}
