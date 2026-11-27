package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionUpdateStyle extends com.taobao.weex.ui.action.BasicGraphicAction {
    private com.taobao.weex.ui.component.WXComponent component;
    private boolean mIsBorderSet;
    private boolean mIsCausedByPesudo;
    private java.util.Map<java.lang.String, java.lang.Object> mStyle;

    public GraphicActionUpdateStyle(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.String> map2, java.util.Map<java.lang.String, java.lang.String> map3, java.util.Map<java.lang.String, java.lang.String> map4) {
        this(wXSDKInstance, str, map, map2, map3, map4, false);
    }

    public GraphicActionUpdateStyle(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, com.taobao.weex.dom.CSSShorthand cSSShorthand, com.taobao.weex.dom.CSSShorthand cSSShorthand2, com.taobao.weex.dom.CSSShorthand cSSShorthand3, boolean z) {
        super(wXSDKInstance, str);
        this.mStyle = map;
        this.mIsCausedByPesudo = z;
        com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), getRef());
        this.component = wXComponent;
        if (wXComponent == null) {
            return;
        }
        java.util.Map<java.lang.String, java.lang.Object> map2 = this.mStyle;
        if (map2 != null) {
            wXComponent.updateStyle(map2, this.mIsCausedByPesudo);
            if (map.containsKey("transform") && this.component.getTransition() == null) {
                androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap(2);
                arrayMap.put("transform", map.get("transform"));
                arrayMap.put(com.taobao.weex.common.Constants.Name.TRANSFORM_ORIGIN, map.get(com.taobao.weex.common.Constants.Name.TRANSFORM_ORIGIN));
                this.component.addAnimationForElement(arrayMap);
            }
        }
        if (cSSShorthand != null) {
            this.component.setPaddings(cSSShorthand);
        }
        if (cSSShorthand2 != null) {
            this.component.setMargins(cSSShorthand2);
        }
        if (cSSShorthand3 != null) {
            this.mIsBorderSet = true;
            this.component.setBorders(cSSShorthand3);
        }
    }

    public GraphicActionUpdateStyle(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.String> map2, java.util.Map<java.lang.String, java.lang.String> map3, java.util.Map<java.lang.String, java.lang.String> map4, boolean z) {
        super(wXSDKInstance, str);
        this.mStyle = map;
        this.mIsCausedByPesudo = z;
        com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), getRef());
        this.component = wXComponent;
        if (wXComponent == null) {
            return;
        }
        java.util.Map<java.lang.String, java.lang.Object> map5 = this.mStyle;
        if (map5 != null) {
            wXComponent.addStyle(map5, this.mIsCausedByPesudo);
            if (map.containsKey("transform") && this.component.getTransition() == null) {
                androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap(2);
                arrayMap.put("transform", map.get("transform"));
                arrayMap.put(com.taobao.weex.common.Constants.Name.TRANSFORM_ORIGIN, map.get(com.taobao.weex.common.Constants.Name.TRANSFORM_ORIGIN));
                this.component.addAnimationForElement(arrayMap);
                com.taobao.weex.bridge.WXBridgeManager.getInstance().markDirty(this.component.getInstanceId(), this.component.getRef(), true);
            }
        }
        if (map2 != null) {
            this.component.addShorthand(map2);
        }
        if (map3 != null) {
            this.component.addShorthand(map3);
        }
        if (map4 != null) {
            this.mIsBorderSet = true;
            this.component.addShorthand(map4);
        }
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        com.taobao.weex.ui.component.WXComponent wXComponent = this.component;
        if (wXComponent == null || wXComponent.getInstance() == null) {
            return;
        }
        java.util.Map<java.lang.String, java.lang.Object> map = this.mStyle;
        if (map != null && map.size() > 0) {
            if (this.component.getTransition() != null) {
                this.component.getTransition().updateTranstionParams(this.mStyle);
                if (this.component.getTransition().hasTransitionProperty(this.mStyle)) {
                    this.component.getTransition().startTransition(this.mStyle);
                    return;
                }
                return;
            }
            com.taobao.weex.ui.component.WXComponent wXComponent2 = this.component;
            wXComponent2.setTransition(com.taobao.weex.dom.transition.WXTransition.fromMap(this.mStyle, wXComponent2));
            this.component.updateStyles(this.mStyle);
            return;
        }
        if (this.mIsBorderSet) {
            com.taobao.weex.ui.component.WXComponent wXComponent3 = this.component;
            wXComponent3.updateStyles(wXComponent3);
        }
    }
}
