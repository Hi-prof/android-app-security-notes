package com.taobao.weex.ui.component.helper;

/* JADX INFO: loaded from: classes.dex */
public class WXTimeInputHelper {
    public static void pickDate(java.lang.String str, java.lang.String str2, final com.taobao.weex.ui.component.AbstractEditComponent abstractEditComponent) {
        final com.taobao.weex.ui.view.WXEditText hostView = abstractEditComponent.getHostView();
        com.taobao.weex.appfram.pickers.DatePickerImpl.pickDate(hostView.getContext(), hostView.getText().toString(), str, str2, new com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener() { // from class: com.taobao.weex.ui.component.helper.WXTimeInputHelper.1
            @Override // com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener
            public void onPick(boolean z, java.lang.String str3) {
                if (z) {
                    hostView.setText(str3);
                    abstractEditComponent.performOnChange(str3);
                }
            }
        }, null);
    }

    public static void pickTime(final com.taobao.weex.ui.component.AbstractEditComponent abstractEditComponent) {
        final com.taobao.weex.ui.view.WXEditText hostView = abstractEditComponent.getHostView();
        com.taobao.weex.appfram.pickers.DatePickerImpl.pickTime(hostView.getContext(), hostView.getText().toString(), new com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener() { // from class: com.taobao.weex.ui.component.helper.WXTimeInputHelper.2
            @Override // com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener
            public void onPick(boolean z, java.lang.String str) {
                if (z) {
                    hostView.setText(str);
                    abstractEditComponent.performOnChange(str);
                }
            }
        }, null);
    }
}
