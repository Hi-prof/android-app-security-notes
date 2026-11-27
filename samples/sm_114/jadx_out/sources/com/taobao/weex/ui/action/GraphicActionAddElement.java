package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionAddElement extends com.taobao.weex.ui.action.GraphicActionAbstractAddElement {
    private com.taobao.weex.ui.component.WXComponent child;
    private boolean isLayoutRTL;
    private com.taobao.weex.ui.action.GraphicPosition layoutPosition;
    private com.taobao.weex.ui.action.GraphicSize layoutSize;
    private com.taobao.weex.ui.component.WXVContainer parent;

    public GraphicActionAddElement(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2, java.util.Set<java.lang.String> set, float[] fArr, float[] fArr2, float[] fArr3) {
        super(wXSDKInstance, str);
        this.mComponentType = str2;
        this.mParentRef = str3;
        this.mIndex = i;
        this.mStyle = map;
        this.mAttributes = map2;
        this.mEvents = set;
        this.mPaddings = fArr2;
        this.mMargins = fArr;
        this.mBorders = fArr3;
        if (wXSDKInstance.getContext() == null) {
            return;
        }
        if (com.taobao.weex.performance.WXAnalyzerDataTransfer.isInteractionLogOpen()) {
            android.util.Log.d(com.taobao.weex.performance.WXAnalyzerDataTransfer.INTERACTION_TAG, "[client][addelementStart]" + wXSDKInstance.getInstanceId() + "," + str2 + "," + str);
        }
        try {
            this.parent = (com.taobao.weex.ui.component.WXVContainer) com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), this.mParentRef);
            long fixUnixTime = com.taobao.weex.utils.WXUtils.getFixUnixTime();
            com.taobao.weex.ui.component.WXComponent wXComponentCreateComponent = createComponent(wXSDKInstance, this.parent, new com.taobao.weex.ui.action.BasicComponentData(str, this.mComponentType, this.mParentRef));
            this.child = wXComponentCreateComponent;
            wXComponentCreateComponent.setTransition(com.taobao.weex.dom.transition.WXTransition.fromMap(wXComponentCreateComponent.getStyles(), this.child));
            wXSDKInstance.getApmForInstance().componentCreateTime += com.taobao.weex.utils.WXUtils.getFixUnixTime() - fixUnixTime;
            com.taobao.weex.ui.component.WXVContainer wXVContainer = this.parent;
            if (wXVContainer != null && wXVContainer.isIgnoreInteraction) {
                this.child.isIgnoreInteraction = true;
            }
            if (!this.child.isIgnoreInteraction) {
                java.lang.Object obj = this.child.getAttrs() != null ? this.child.getAttrs().get("ignoreInteraction") : null;
                if (io.dcloud.common.constant.AbsoluteConst.FALSE.equals(obj) || com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT.equals(obj)) {
                    this.child.isIgnoreInteraction = false;
                } else if ("1".equals(obj) || io.dcloud.common.constant.AbsoluteConst.TRUE.equals(obj) || this.child.isFixed()) {
                    this.child.isIgnoreInteraction = true;
                }
            }
            com.taobao.weex.performance.WXStateRecord.getInstance().recordAction(wXSDKInstance.getInstanceId(), "addElement");
        } catch (java.lang.ClassCastException unused) {
            androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap();
            com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), this.mParentRef);
            if (this.mStyle != null && !this.mStyle.isEmpty()) {
                arrayMap.put("child.style", this.mStyle.toString());
            }
            if (wXComponent != null && wXComponent.getStyles() != null && !wXComponent.getStyles().isEmpty()) {
                arrayMap.put("parent.style", wXComponent.getStyles().toString());
            }
            if (this.mAttributes != null && !this.mAttributes.isEmpty()) {
                arrayMap.put("child.attr", this.mAttributes.toString());
            }
            if (wXComponent != null && wXComponent.getAttrs() != null && !wXComponent.getAttrs().isEmpty()) {
                arrayMap.put("parent.attr", wXComponent.getAttrs().toString());
            }
            if (this.mEvents != null && !this.mEvents.isEmpty()) {
                arrayMap.put("child.event", this.mEvents.toString());
            }
            if (wXComponent != null && wXComponent.getEvents() != null && !wXComponent.getEvents().isEmpty()) {
                arrayMap.put("parent.event", wXComponent.getEvents().toString());
            }
            if (this.mMargins != null && this.mMargins.length > 0) {
                arrayMap.put("child.margin", java.util.Arrays.toString(this.mMargins));
            }
            if (wXComponent != null && wXComponent.getMargin() != null) {
                arrayMap.put("parent.margin", wXComponent.getMargin().toString());
            }
            if (this.mPaddings != null && this.mPaddings.length > 0) {
                arrayMap.put("child.padding", java.util.Arrays.toString(this.mPaddings));
            }
            if (wXComponent != null && wXComponent.getPadding() != null) {
                arrayMap.put("parent.padding", wXComponent.getPadding().toString());
            }
            if (this.mBorders != null && this.mBorders.length > 0) {
                arrayMap.put("child.border", java.util.Arrays.toString(this.mBorders));
            }
            if (wXComponent != null && wXComponent.getBorder() != null) {
                arrayMap.put("parent.border", wXComponent.getBorder().toString());
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(wXSDKInstance.getInstanceId(), com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_CONTAINER_TYPE, "GraphicActionAddElement", java.lang.String.format(java.util.Locale.ENGLISH, "You are trying to add a %s to a %2$s, which is illegal as %2$s is not a container", str2, com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), this.mParentRef).getComponentType()), arrayMap);
        }
    }

    public void setRTL(boolean z) {
        this.isLayoutRTL = z;
    }

    public void setSize(com.taobao.weex.ui.action.GraphicSize graphicSize) {
        this.layoutSize = graphicSize;
    }

    public void setPosition(com.taobao.weex.ui.action.GraphicPosition graphicPosition) {
        this.layoutPosition = graphicPosition;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.taobao.weex.ui.action.GraphicActionAbstractAddElement, com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        com.taobao.weex.ui.action.GraphicSize graphicSize;
        super.executeAction();
        try {
            if (!android.text.TextUtils.equals(this.mComponentType, "video") && !android.text.TextUtils.equals(this.mComponentType, "videoplus")) {
                this.child.mIsAddElementToTree = true;
            }
            long fixUnixTime = com.taobao.weex.utils.WXUtils.getFixUnixTime();
            this.parent.addChild(this.child, this.mIndex);
            this.parent.createChildViewAt(this.mIndex);
            this.child.setIsLayoutRTL(this.isLayoutRTL);
            com.taobao.weex.ui.action.GraphicPosition graphicPosition = this.layoutPosition;
            if (graphicPosition != null && (graphicSize = this.layoutSize) != null) {
                this.child.setDemission(graphicSize, graphicPosition);
            }
            com.taobao.weex.ui.component.WXComponent wXComponent = this.child;
            wXComponent.applyLayoutAndEvent(wXComponent);
            com.taobao.weex.ui.component.WXComponent wXComponent2 = this.child;
            wXComponent2.bindData(wXComponent2);
            long fixUnixTime2 = com.taobao.weex.utils.WXUtils.getFixUnixTime() - fixUnixTime;
            if (getWXSDKIntance() != null) {
                getWXSDKIntance().getApmForInstance().viewCreateTime += fixUnixTime2;
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("add component failed.", e);
        }
    }
}
