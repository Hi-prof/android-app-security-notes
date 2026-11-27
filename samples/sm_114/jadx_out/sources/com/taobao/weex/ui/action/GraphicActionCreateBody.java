package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionCreateBody extends com.taobao.weex.ui.action.GraphicActionAbstractAddElement {
    private com.taobao.weex.ui.component.WXComponent component;

    public GraphicActionCreateBody(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2, java.util.Set<java.lang.String> set, float[] fArr, float[] fArr2, float[] fArr3) {
        super(wXSDKInstance, str);
        this.mComponentType = str2;
        this.mStyle = map;
        this.mAttributes = map2;
        this.mEvents = set;
        this.mMargins = fArr;
        this.mPaddings = fArr2;
        this.mBorders = fArr3;
        if (wXSDKInstance.getContext() == null) {
            return;
        }
        com.taobao.weex.ui.component.WXComponent wXComponentCreateComponent = createComponent(wXSDKInstance, null, new com.taobao.weex.ui.action.BasicComponentData(getRef(), this.mComponentType, null));
        this.component = wXComponentCreateComponent;
        if (wXComponentCreateComponent == null) {
            return;
        }
        wXComponentCreateComponent.setTransition(com.taobao.weex.dom.transition.WXTransition.fromMap(wXComponentCreateComponent.getStyles(), this.component));
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
        super.executeAction();
        try {
            this.component.createView();
            com.taobao.weex.ui.component.WXComponent wXComponent = this.component;
            wXComponent.applyLayoutAndEvent(wXComponent);
            com.taobao.weex.ui.component.WXComponent wXComponent2 = this.component;
            wXComponent2.bindData(wXComponent2);
            com.taobao.weex.WXSDKInstance wXSDKIntance = getWXSDKIntance();
            com.taobao.weex.ui.component.WXComponent wXComponent3 = this.component;
            if (wXComponent3 instanceof com.taobao.weex.ui.component.WXBaseScroller) {
                com.taobao.weex.ui.component.WXBaseScroller wXBaseScroller = (com.taobao.weex.ui.component.WXBaseScroller) wXComponent3;
                if (wXBaseScroller.getInnerView() instanceof android.widget.ScrollView) {
                    wXSDKIntance.setRootScrollView((android.widget.ScrollView) wXBaseScroller.getInnerView());
                }
            }
            wXSDKIntance.onRootCreated(this.component);
            if (wXSDKIntance.getRenderStrategy() != com.taobao.weex.common.WXRenderStrategy.APPEND_ONCE) {
                wXSDKIntance.onCreateFinish();
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("create body failed.", e);
        }
    }
}
