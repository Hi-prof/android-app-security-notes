package io.dcloud.feature.uniapp.ui.component;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsBasicComponent<T extends android.view.View> {
    private io.dcloud.feature.uniapp.ui.action.AbsComponentData mBasicComponentData;
    private java.lang.String mComponentType;
    private java.lang.Object mExtra;
    private boolean mIsLayoutRTL;
    private com.taobao.weex.ui.action.GraphicPosition mLayoutPosition;
    private com.taobao.weex.ui.action.GraphicSize mLayoutSize;
    private java.lang.String mRef;
    private float mViewPortWidth = 750.0f;

    public AbsBasicComponent(io.dcloud.feature.uniapp.ui.action.AbsComponentData absComponentData) {
        this.mBasicComponentData = absComponentData;
        this.mRef = absComponentData.mRef;
        this.mComponentType = absComponentData.mComponentType;
    }

    public io.dcloud.feature.uniapp.ui.action.AbsComponentData getBasicComponentData() {
        return this.mBasicComponentData;
    }

    protected void bindComponent(io.dcloud.feature.uniapp.ui.component.AbsBasicComponent absBasicComponent) {
        this.mComponentType = absBasicComponent.getComponentType();
        this.mRef = absBasicComponent.getRef();
    }

    public io.dcloud.feature.uniapp.dom.AbsStyle getStyles() {
        return this.mBasicComponentData.getStyles();
    }

    public io.dcloud.feature.uniapp.dom.AbsAttr getAttrs() {
        return this.mBasicComponentData.getAttrs();
    }

    public io.dcloud.feature.uniapp.dom.AbsEvent getEvents() {
        return this.mBasicComponentData.getEvents();
    }

    public io.dcloud.feature.uniapp.dom.AbsCSSShorthand getMargin() {
        return this.mBasicComponentData.getMargin();
    }

    public io.dcloud.feature.uniapp.dom.AbsCSSShorthand getPadding() {
        return this.mBasicComponentData.getPadding();
    }

    public io.dcloud.feature.uniapp.dom.AbsCSSShorthand getBorder() {
        return this.mBasicComponentData.getBorder();
    }

    public final void setMargins(com.taobao.weex.dom.CSSShorthand cSSShorthand) {
        this.mBasicComponentData.setMargins(cSSShorthand);
    }

    public final void setPaddings(com.taobao.weex.dom.CSSShorthand cSSShorthand) {
        this.mBasicComponentData.setPaddings(cSSShorthand);
    }

    public final void setBorders(com.taobao.weex.dom.CSSShorthand cSSShorthand) {
        this.mBasicComponentData.setBorders(cSSShorthand);
    }

    public final void addAttr(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.mBasicComponentData.addAttr(map);
    }

    public final void addStyle(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.mBasicComponentData.addStyle(map);
    }

    public final void addStyle(java.util.Map<java.lang.String, java.lang.Object> map, boolean z) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.mBasicComponentData.addStyle(map, z);
    }

    public final void updateStyle(java.util.Map<java.lang.String, java.lang.Object> map, boolean z) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.mBasicComponentData.getStyles().updateStyle(map, z);
    }

    public final void addEvent(java.util.Set<java.lang.String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        this.mBasicComponentData.addEvent(set);
    }

    public final void addShorthand(java.util.Map<java.lang.String, java.lang.String> map) {
        io.dcloud.feature.uniapp.ui.action.AbsComponentData absComponentData;
        if (map.isEmpty() || (absComponentData = this.mBasicComponentData) == null) {
            return;
        }
        absComponentData.addShorthand(map);
    }

    public float getViewPortWidthForFloat() {
        return this.mViewPortWidth;
    }

    public int getViewPortWidth() {
        return java.lang.Math.round(this.mViewPortWidth);
    }

    public void setViewPortWidth(float f) {
        this.mViewPortWidth = f;
    }

    public java.lang.Object getExtra() {
        return this.mExtra;
    }

    public void updateExtra(java.lang.Object obj) {
        this.mExtra = obj;
    }

    public java.lang.String getComponentType() {
        return this.mComponentType;
    }

    public java.lang.String getRef() {
        return this.mRef;
    }

    public void setIsLayoutRTL(boolean z) {
        this.mIsLayoutRTL = z;
    }

    public boolean isLayoutRTL() {
        return this.mIsLayoutRTL;
    }

    public com.taobao.weex.ui.action.GraphicPosition getLayoutPosition() {
        if (this.mLayoutPosition == null) {
            this.mLayoutPosition = new com.taobao.weex.ui.action.GraphicPosition(0.0f, 0.0f, 0.0f, 0.0f);
        }
        return this.mLayoutPosition;
    }

    protected void setLayoutPosition(com.taobao.weex.ui.action.GraphicPosition graphicPosition) {
        this.mLayoutPosition = graphicPosition;
    }

    public com.taobao.weex.ui.action.GraphicSize getLayoutSize() {
        if (this.mLayoutSize == null) {
            this.mLayoutSize = new com.taobao.weex.ui.action.GraphicSize(0.0f, 0.0f);
        }
        return this.mLayoutSize;
    }

    protected void setLayoutSize(com.taobao.weex.ui.action.GraphicSize graphicSize) {
        this.mLayoutSize = graphicSize;
    }

    public float getCSSLayoutTop() {
        com.taobao.weex.ui.action.GraphicPosition graphicPosition = this.mLayoutPosition;
        if (graphicPosition == null) {
            return 0.0f;
        }
        return graphicPosition.getTop();
    }

    public float getCSSLayoutBottom() {
        com.taobao.weex.ui.action.GraphicPosition graphicPosition = this.mLayoutPosition;
        if (graphicPosition == null) {
            return 0.0f;
        }
        return graphicPosition.getBottom();
    }

    public float getCSSLayoutLeft() {
        com.taobao.weex.ui.action.GraphicPosition graphicPosition = this.mLayoutPosition;
        if (graphicPosition == null) {
            return 0.0f;
        }
        return graphicPosition.getLeft();
    }

    public float getCSSLayoutRight() {
        com.taobao.weex.ui.action.GraphicPosition graphicPosition = this.mLayoutPosition;
        if (graphicPosition == null) {
            return 0.0f;
        }
        return graphicPosition.getRight();
    }

    public float getLayoutWidth() {
        com.taobao.weex.ui.action.GraphicSize graphicSize = this.mLayoutSize;
        if (graphicSize == null) {
            return 0.0f;
        }
        return graphicSize.getWidth();
    }

    public float getLayoutHeight() {
        com.taobao.weex.ui.action.GraphicSize graphicSize = this.mLayoutSize;
        if (graphicSize == null) {
            return 0.0f;
        }
        return graphicSize.getHeight();
    }
}
