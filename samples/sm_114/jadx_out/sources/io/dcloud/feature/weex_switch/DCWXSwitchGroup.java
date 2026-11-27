package io.dcloud.feature.weex_switch;

/* JADX INFO: loaded from: classes2.dex */
public class DCWXSwitchGroup extends com.taobao.weex.ui.component.WXComponent<io.dcloud.feature.weex_switch.SwitchGroup> {
    public DCWXSwitchGroup(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        setContentBoxMeasurement(new com.taobao.weex.layout.ContentBoxMeasurement() { // from class: io.dcloud.feature.weex_switch.DCWXSwitchGroup.1
            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutAfter(float f, float f2) {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutBefore() {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void measureInternal(float f, float f2, int i, int i2) {
                int realPxByWidth = (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(31.0f, io.dcloud.feature.weex_switch.DCWXSwitchGroup.this.getInstance().getInstanceViewPortWidthWithFloat());
                int realPxByWidth2 = (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(51.0f, io.dcloud.feature.weex_switch.DCWXSwitchGroup.this.getInstance().getInstanceViewPortWidthWithFloat());
                if (com.taobao.weex.dom.CSSConstants.isUndefined(f2)) {
                    f = realPxByWidth2;
                    f2 = realPxByWidth;
                }
                this.mMeasureWidth = f;
                this.mMeasureHeight = f2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public io.dcloud.feature.weex_switch.SwitchGroup initComponentHostView(android.content.Context context) {
        return new io.dcloud.feature.weex_switch.SwitchGroup(context);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.CHECKED)
    public void setChecked(boolean z) {
        ((io.dcloud.feature.weex_switch.SwitchButton) getHostView().getChildAt(0)).setChecked(z);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.DISABLED)
    public void setDisabled(boolean z) {
        ((io.dcloud.feature.weex_switch.SwitchButton) getHostView().getChildAt(0)).setEnabled(!z);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "color")
    public void setColor(java.lang.String str) {
        ((io.dcloud.feature.weex_switch.SwitchButton) getHostView().getChildAt(0)).setCheckedColor(android.graphics.Color.parseColor(str));
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(java.lang.String str) {
        super.addEvent(str);
        if (str == null || !str.equals(com.taobao.weex.common.Constants.Event.CHANGE) || getHostView() == null) {
            return;
        }
        ((io.dcloud.feature.weex_switch.SwitchButton) getHostView().getChildAt(0)).setOnCheckedChangeListener(new io.dcloud.feature.weex_switch.SwitchButton.OnCheckedChangeListener() { // from class: io.dcloud.feature.weex_switch.DCWXSwitchGroup.2
            @Override // io.dcloud.feature.weex_switch.SwitchButton.OnCheckedChangeListener
            public void onCheckedChanged(io.dcloud.feature.weex_switch.SwitchButton switchButton, boolean z) {
                java.util.HashMap map = new java.util.HashMap();
                java.util.HashMap map2 = new java.util.HashMap();
                map2.put("value", z + "");
                map.put("detail", map2);
                io.dcloud.feature.weex_switch.DCWXSwitchGroup.this.fireEvent(com.taobao.weex.common.Constants.Event.CHANGE, map);
            }
        });
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected void removeEventFromView(java.lang.String str) {
        super.removeEventFromView(str);
        if (getHostView() == null || !com.taobao.weex.common.Constants.Event.CHANGE.equals(str)) {
            return;
        }
        ((io.dcloud.feature.weex_switch.SwitchButton) getHostView().getChildAt(0)).setOnCheckedChangeListener(null);
    }
}
