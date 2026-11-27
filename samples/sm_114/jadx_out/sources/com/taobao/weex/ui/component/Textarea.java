package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
public class Textarea extends com.taobao.weex.ui.component.AbstractEditComponent {
    public static final int DEFAULT_ROWS = 2;
    private int mNumberOfLines;

    @Override // com.taobao.weex.ui.component.AbstractEditComponent
    protected int getVerticalGravity() {
        return 48;
    }

    public Textarea(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        this.mNumberOfLines = 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.AbstractEditComponent, com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(com.taobao.weex.ui.view.WXEditText wXEditText) {
        wXEditText.setAllowDisableMovement(false);
        super.onHostViewInitialized(wXEditText);
    }

    @Override // com.taobao.weex.ui.component.AbstractEditComponent
    protected void appleStyleAfterCreated(com.taobao.weex.ui.view.WXEditText wXEditText) {
        super.appleStyleAfterCreated(wXEditText);
        java.lang.String str = (java.lang.String) getStyles().get(com.taobao.weex.common.Constants.Name.ROWS);
        int i = 2;
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                i = java.lang.Integer.parseInt(str);
            }
        } catch (java.lang.NumberFormatException e) {
            e.printStackTrace();
        }
        wXEditText.setLines(i);
        wXEditText.setMinLines(i);
    }

    @Override // com.taobao.weex.ui.component.AbstractEditComponent, com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        if (str.equals(com.taobao.weex.common.Constants.Name.ROWS)) {
            java.lang.Integer integer = com.taobao.weex.utils.WXUtils.getInteger(obj, null);
            if (integer == null) {
                return true;
            }
            setRows(integer.intValue());
            return true;
        }
        return super.setProperty(str, obj);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.ROWS)
    public void setRows(int i) {
        com.taobao.weex.ui.view.WXEditText hostView = getHostView();
        if (hostView == null || i <= 0) {
            return;
        }
        hostView.setLines(i);
    }

    @Override // com.taobao.weex.ui.component.AbstractEditComponent
    protected float getMeasureHeight() {
        return getMeasuredLineHeight() * this.mNumberOfLines;
    }

    @Override // com.taobao.weex.ui.component.AbstractEditComponent
    protected void updateStyleAndAttrs() {
        super.updateStyleAndAttrs();
        java.lang.Object obj = getAttrs().get(com.taobao.weex.common.Constants.Name.ROWS);
        if (obj == null) {
            return;
        }
        if (obj instanceof java.lang.String) {
            try {
                int i = java.lang.Integer.parseInt((java.lang.String) obj);
                if (i > 0) {
                    this.mNumberOfLines = i;
                    return;
                }
                return;
            } catch (java.lang.NumberFormatException e) {
                e.printStackTrace();
                return;
            }
        }
        if (obj instanceof java.lang.Integer) {
            this.mNumberOfLines = ((java.lang.Integer) obj).intValue();
        }
    }
}
