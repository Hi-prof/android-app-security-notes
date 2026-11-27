package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public abstract class GraphicActionAbstractAddElement extends com.taobao.weex.ui.action.BasicGraphicAction {
    protected java.util.Map<java.lang.String, java.lang.String> mAttributes;
    protected float[] mBorders;
    protected java.lang.String mComponentType;
    protected java.util.Set<java.lang.String> mEvents;
    protected int mIndex;
    protected float[] mMargins;
    protected float[] mPaddings;
    protected java.lang.String mParentRef;
    protected java.util.Map<java.lang.String, java.lang.String> mStyle;
    private long startTime;

    public GraphicActionAbstractAddElement(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str) {
        super(wXSDKInstance, str);
        this.mIndex = -1;
        this.startTime = java.lang.System.currentTimeMillis();
    }

    protected com.taobao.weex.ui.component.WXComponent createComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (basicComponentData != null) {
            basicComponentData.addStyle(this.mStyle);
            basicComponentData.addAttr(this.mAttributes);
            basicComponentData.addEvent(this.mEvents);
            basicComponentData.addShorthand(this.mMargins, io.dcloud.feature.uniapp.dom.AbsCSSShorthand.TYPE.MARGIN);
            basicComponentData.addShorthand(this.mPaddings, io.dcloud.feature.uniapp.dom.AbsCSSShorthand.TYPE.PADDING);
            basicComponentData.addShorthand(this.mBorders, io.dcloud.feature.uniapp.dom.AbsCSSShorthand.TYPE.BORDER);
        }
        com.taobao.weex.ui.component.WXComponent wXComponentNewInstance = com.taobao.weex.ui.component.WXComponentFactory.newInstance(wXSDKInstance, wXVContainer, basicComponentData);
        com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().registerComponent(getPageId(), getRef(), wXComponentNewInstance);
        java.util.Map<java.lang.String, java.lang.String> map = this.mStyle;
        if (map != null && map.containsKey("transform") && wXComponentNewInstance.getTransition() == null) {
            androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap(2);
            arrayMap.put("transform", this.mStyle.get("transform"));
            arrayMap.put(com.taobao.weex.common.Constants.Name.TRANSFORM_ORIGIN, this.mStyle.get(com.taobao.weex.common.Constants.Name.TRANSFORM_ORIGIN));
            wXComponentNewInstance.addAnimationForElement(arrayMap);
        }
        wXSDKInstance.onComponentCreate(wXComponentNewInstance, java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
        return wXComponentNewInstance;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        getWXSDKIntance().callActionAddElementTime(java.lang.System.currentTimeMillis() - this.startTime);
    }

    public java.lang.String getComponentType() {
        return this.mComponentType;
    }

    public java.lang.String getParentRef() {
        return this.mParentRef;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public java.util.Map<java.lang.String, java.lang.String> getStyle() {
        return this.mStyle;
    }

    public java.util.Map<java.lang.String, java.lang.String> getAttributes() {
        return this.mAttributes;
    }

    public java.util.Set<java.lang.String> getEvents() {
        return this.mEvents;
    }
}
