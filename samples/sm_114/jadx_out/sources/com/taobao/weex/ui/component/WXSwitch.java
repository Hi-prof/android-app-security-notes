package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXSwitch extends com.taobao.weex.ui.component.WXComponent<com.taobao.weex.ui.view.WXSwitchView> {
    private android.widget.CompoundButton.OnCheckedChangeListener mListener;

    @java.lang.Deprecated
    public WXSwitch(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    public WXSwitch(final com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        setContentBoxMeasurement(new com.taobao.weex.layout.ContentBoxMeasurement() { // from class: com.taobao.weex.ui.component.WXSwitch.1
            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutAfter(float f, float f2) {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutBefore() {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void measureInternal(float f, float f2, int i, int i2) {
                int iMakeMeasureSpec;
                this.mMeasureWidth = 0.0f;
                this.mMeasureHeight = 0.0f;
                try {
                    com.taobao.weex.ui.view.WXSwitchView wXSwitchView = new com.taobao.weex.ui.view.WXSwitchView(wXSDKInstance.getContext());
                    int iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                    if (java.lang.Float.isNaN(f)) {
                        iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                    } else {
                        iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec((int) f, Integer.MIN_VALUE);
                    }
                    wXSwitchView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    this.mMeasureWidth = wXSwitchView.getMeasuredWidth();
                    this.mMeasureHeight = wXSwitchView.getMeasuredHeight();
                } catch (java.lang.RuntimeException e) {
                    com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.view.WXSwitchView initComponentHostView(android.content.Context context) {
        return new com.taobao.weex.ui.view.WXSwitchView(context);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(java.lang.String str) {
        super.addEvent(str);
        if (str == null || !str.equals(com.taobao.weex.common.Constants.Event.CHANGE) || getHostView() == null) {
            return;
        }
        if (this.mListener == null) {
            this.mListener = new android.widget.CompoundButton.OnCheckedChangeListener() { // from class: com.taobao.weex.ui.component.WXSwitch.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
                    java.util.HashMap map = new java.util.HashMap(2);
                    map.put("value", java.lang.Boolean.valueOf(z));
                    java.util.HashMap map2 = new java.util.HashMap();
                    java.util.HashMap map3 = new java.util.HashMap();
                    map3.put(com.taobao.weex.common.Constants.Name.CHECKED, java.lang.Boolean.toString(z));
                    map2.put(com.taobao.weex.ui.component.list.template.TemplateDom.KEY_ATTRS, map3);
                    com.taobao.weex.ui.component.WXSwitch.this.fireEvent(com.taobao.weex.common.Constants.Event.CHANGE, map, map2);
                }
            };
        }
        getHostView().setOnCheckedChangeListener(this.mListener);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected void removeEventFromView(java.lang.String str) {
        super.removeEventFromView(str);
        if (getHostView() == null || !com.taobao.weex.common.Constants.Event.CHANGE.equals(str)) {
            return;
        }
        getHostView().setOnCheckedChangeListener(null);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        if (str.equals(com.taobao.weex.common.Constants.Name.CHECKED)) {
            java.lang.Boolean bool = com.taobao.weex.utils.WXUtils.getBoolean(obj, null);
            if (bool == null) {
                return true;
            }
            setChecked(bool.booleanValue());
            return true;
        }
        return super.setProperty(str, obj);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.CHECKED)
    public void setChecked(boolean z) {
        getHostView().setOnCheckedChangeListener(null);
        getHostView().setChecked(z);
        getHostView().setOnCheckedChangeListener(this.mListener);
    }
}
