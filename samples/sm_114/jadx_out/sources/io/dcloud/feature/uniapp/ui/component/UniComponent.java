package io.dcloud.feature.uniapp.ui.component;

/* JADX INFO: loaded from: classes2.dex */
public class UniComponent<T extends android.view.View> extends com.taobao.weex.ui.component.WXComponent<T> {
    public io.dcloud.feature.uniapp.UniSDKInstance mUniSDKInstance;

    public interface OnClickListener extends com.taobao.weex.ui.component.WXComponent.OnClickListener {
    }

    public interface OnFocusChangeListener extends com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener {
    }

    public UniComponent(io.dcloud.feature.uniapp.UniSDKInstance uniSDKInstance, io.dcloud.feature.uniapp.ui.component.AbsVContainer absVContainer, int i, io.dcloud.feature.uniapp.ui.action.AbsComponentData absComponentData) {
        super(uniSDKInstance, (com.taobao.weex.ui.component.WXVContainer) absVContainer, i, (com.taobao.weex.ui.action.BasicComponentData) absComponentData);
        this.mUniSDKInstance = uniSDKInstance;
    }

    public UniComponent(io.dcloud.feature.uniapp.UniSDKInstance uniSDKInstance, io.dcloud.feature.uniapp.ui.component.AbsVContainer absVContainer, io.dcloud.feature.uniapp.ui.action.AbsComponentData absComponentData) {
        super(uniSDKInstance, (com.taobao.weex.ui.component.WXVContainer) absVContainer, (com.taobao.weex.ui.action.BasicComponentData) absComponentData);
        this.mUniSDKInstance = uniSDKInstance;
    }

    public io.dcloud.feature.uniapp.UniSDKInstance getUniInstance() {
        return this.mUniSDKInstance;
    }

    protected void updateStyles(io.dcloud.feature.uniapp.ui.component.UniComponent uniComponent) {
        updateStyles(uniComponent);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public final void updateStyles(com.taobao.weex.ui.component.WXComponent wXComponent) {
        super.updateStyles(wXComponent);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public final void bindData(com.taobao.weex.ui.component.WXComponent wXComponent) {
        super.bindData(wXComponent);
    }

    public final io.dcloud.feature.uniapp.ui.component.AbsBasicComponent findUniComponent(java.lang.String str) {
        if (getInstance() == null || str == null) {
            return null;
        }
        return com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getInstanceId(), str);
    }

    public void bindHolder(io.dcloud.feature.uniapp.ui.AbsIComponentHolder absIComponentHolder) {
        super.bindHolder((com.taobao.weex.ui.IFComponentHolder) absIComponentHolder);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public final void bindHolder(com.taobao.weex.ui.IFComponentHolder iFComponentHolder) {
        super.bindHolder(iFComponentHolder);
    }

    public void postAnimation(io.dcloud.feature.uniapp.ui.component.UniAnimationHolder uniAnimationHolder) {
        super.postAnimation((io.dcloud.feature.uniapp.ui.AbsAnimationHolder) uniAnimationHolder);
    }

    protected final void addFocusChangeListener(io.dcloud.feature.uniapp.ui.component.UniComponent.OnFocusChangeListener onFocusChangeListener) {
        super.addFocusChangeListener((com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener) onFocusChangeListener);
    }

    protected final void addClickListener(io.dcloud.feature.uniapp.ui.component.UniComponent.OnClickListener onClickListener) {
        super.addClickListener((com.taobao.weex.ui.component.WXComponent.OnClickListener) onClickListener);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        this.mUniSDKInstance = null;
    }
}
