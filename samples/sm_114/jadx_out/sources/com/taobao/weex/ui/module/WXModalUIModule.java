package com.taobao.weex.ui.module;

/* JADX INFO: loaded from: classes.dex */
public class WXModalUIModule extends com.taobao.weex.WXSDKEngine.DestroyableModule {
    public static final java.lang.String CANCEL = "Cancel";
    public static final java.lang.String CANCEL_TITLE = "cancelTitle";
    public static final java.lang.String DATA = "data";
    public static final java.lang.String DEFAULT = "default";
    public static final java.lang.String DURATION = "duration";
    public static final java.lang.String GRAVITY = "gravity";
    public static final java.lang.String MESSAGE = "message";
    public static final java.lang.String OK = "OK";
    public static final java.lang.String OK_TITLE = "okTitle";
    public static final java.lang.String RESULT = "result";
    private android.app.Dialog activeDialog;
    private android.widget.Toast toast;

    /* JADX WARN: Code duplicated, block: B:24:0x004c A[PHI: r1 r4
  0x004c: PHI (r1v3 int) = (r1v2 int), (r1v5 int), (r1v5 int), (r1v5 int) binds: [B:23:0x0047, B:13:0x002e, B:15:0x0036, B:17:0x003e] A[DONT_GENERATE, DONT_INLINE]
  0x004c: PHI (r4v3 java.lang.String) = (r4v2 java.lang.String), (r4v4 java.lang.String), (r4v4 java.lang.String), (r4v4 java.lang.String) binds: [B:23:0x0047, B:13:0x002e, B:15:0x0036, B:17:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void toast(com.alibaba.fastjson.JSONObject jSONObject) {
        int iIntValue;
        int i;
        if (this.mWXSDKInstance.getContext() == null) {
            return;
        }
        java.lang.String string = "";
        if (jSONObject != null) {
            try {
                string = jSONObject.getString("message");
                iIntValue = jSONObject.containsKey("duration") ? jSONObject.getInteger("duration").intValue() : 0;
                try {
                    if (jSONObject.containsKey(GRAVITY)) {
                        java.lang.String string2 = jSONObject.getString(GRAVITY);
                        if ((string2 instanceof java.lang.String) && string2.equals("bottom")) {
                            i = 80;
                        } else {
                            i = 17;
                        }
                    } else {
                        i = 17;
                    }
                } catch (java.lang.Exception e) {
                    e = e;
                    com.taobao.weex.utils.WXLogUtils.e("[WXModalUIModule] alert param parse error ", e);
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                iIntValue = 0;
            }
        } else {
            i = 17;
            iIntValue = 0;
        }
        if (android.text.TextUtils.isEmpty(string)) {
            com.taobao.weex.utils.WXLogUtils.e("[WXModalUIModule] toast param parse is null ");
            return;
        }
        int i2 = iIntValue > 3 ? 1 : 0;
        android.widget.Toast toast = this.toast;
        if (toast == null) {
            this.toast = com.dcloud.android.widget.toast.ToastCompat.makeText(this.mWXSDKInstance.getContext(), (java.lang.CharSequence) string, i2);
        } else {
            toast.setDuration(i2);
            this.toast.setText(string);
        }
        if (17 == i) {
            this.toast.setGravity(i, 0, 0);
        }
        this.toast.show();
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void alert(com.alibaba.fastjson.JSONObject jSONObject, final com.taobao.weex.bridge.JSCallback jSCallback) {
        java.lang.String string;
        java.lang.String string2;
        if (this.mWXSDKInstance.getContext() instanceof android.app.Activity) {
            final java.lang.String str = OK;
            if (jSONObject == null) {
                string2 = OK;
                string = "";
            } else {
                try {
                    string = jSONObject.getString("message");
                    try {
                        string2 = jSONObject.getString(OK_TITLE);
                    } catch (java.lang.Exception e) {
                        e = e;
                        com.taobao.weex.utils.WXLogUtils.e("[WXModalUIModule] alert param parse error ", e);
                        string2 = OK;
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    string = "";
                }
            }
            java.lang.String str2 = android.text.TextUtils.isEmpty(string) ? "" : string;
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this.mWXSDKInstance.getContext());
            builder.setMessage(str2);
            if (!android.text.TextUtils.isEmpty(string2)) {
                str = string2;
            }
            builder.setPositiveButton(str, new android.content.DialogInterface.OnClickListener() { // from class: com.taobao.weex.ui.module.WXModalUIModule.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i) {
                    com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                    if (jSCallback2 != null) {
                        jSCallback2.invoke(str);
                    }
                }
            });
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setCanceledOnTouchOutside(false);
            alertDialogCreate.show();
            tracking(alertDialogCreate);
            return;
        }
        com.taobao.weex.utils.WXLogUtils.e("[WXModalUIModule] when call alert mWXSDKInstance.getContext() must instanceof Activity");
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void confirm(com.alibaba.fastjson.JSONObject jSONObject, final com.taobao.weex.bridge.JSCallback jSCallback) {
        java.lang.String string;
        java.lang.String string2;
        java.lang.String string3;
        if (this.mWXSDKInstance.getContext() instanceof android.app.Activity) {
            final java.lang.String str = CANCEL;
            final java.lang.String str2 = OK;
            if (jSONObject == null) {
                string3 = CANCEL;
                string = OK;
                string2 = "";
            } else {
                try {
                    string2 = jSONObject.getString("message");
                    try {
                        string = jSONObject.getString(OK_TITLE);
                        try {
                            string3 = jSONObject.getString(CANCEL_TITLE);
                        } catch (java.lang.Exception e) {
                            e = e;
                            com.taobao.weex.utils.WXLogUtils.e("[WXModalUIModule] confirm param parse error ", e);
                            string3 = CANCEL;
                        }
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        string = OK;
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                    string = OK;
                    string2 = "";
                }
            }
            java.lang.String str3 = android.text.TextUtils.isEmpty(string2) ? "" : string2;
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this.mWXSDKInstance.getContext());
            builder.setMessage(str3);
            if (!android.text.TextUtils.isEmpty(string)) {
                str2 = string;
            }
            if (!android.text.TextUtils.isEmpty(string3)) {
                str = string3;
            }
            builder.setPositiveButton(str2, new android.content.DialogInterface.OnClickListener() { // from class: com.taobao.weex.ui.module.WXModalUIModule.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i) {
                    com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                    if (jSCallback2 != null) {
                        jSCallback2.invoke(str2);
                    }
                }
            });
            builder.setNegativeButton(str, new android.content.DialogInterface.OnClickListener() { // from class: com.taobao.weex.ui.module.WXModalUIModule.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i) {
                    com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                    if (jSCallback2 != null) {
                        jSCallback2.invoke(str);
                    }
                }
            });
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setCanceledOnTouchOutside(false);
            alertDialogCreate.show();
            tracking(alertDialogCreate);
            return;
        }
        com.taobao.weex.utils.WXLogUtils.e("[WXModalUIModule] when call confirm mWXSDKInstance.getContext() must instanceof Activity");
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void prompt(com.alibaba.fastjson.JSONObject jSONObject, final com.taobao.weex.bridge.JSCallback jSCallback) {
        java.lang.String string;
        java.lang.String string2;
        java.lang.String string3;
        java.lang.String string4;
        if (this.mWXSDKInstance.getContext() instanceof android.app.Activity) {
            final java.lang.String str = CANCEL;
            final java.lang.String str2 = OK;
            if (jSONObject == null) {
                string = CANCEL;
                string2 = OK;
                string4 = "";
                string3 = string4;
            } else {
                try {
                    string3 = jSONObject.getString("message");
                    try {
                        string2 = jSONObject.getString(OK_TITLE);
                        try {
                            string = jSONObject.getString(CANCEL_TITLE);
                            try {
                                string4 = jSONObject.getString("default");
                            } catch (java.lang.Exception e) {
                                e = e;
                                com.taobao.weex.utils.WXLogUtils.e("[WXModalUIModule] confirm param parse error ", e);
                                string4 = "";
                            }
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            string = CANCEL;
                        }
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        string = CANCEL;
                        string2 = OK;
                    }
                } catch (java.lang.Exception e4) {
                    e = e4;
                    string = CANCEL;
                    string2 = OK;
                    string3 = "";
                }
            }
            java.lang.String str3 = android.text.TextUtils.isEmpty(string3) ? "" : string3;
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this.mWXSDKInstance.getContext());
            builder.setMessage(str3);
            final android.widget.EditText editText = new android.widget.EditText(this.mWXSDKInstance.getContext());
            editText.setText(string4);
            builder.setView(editText);
            if (!android.text.TextUtils.isEmpty(string2)) {
                str2 = string2;
            }
            if (!android.text.TextUtils.isEmpty(string)) {
                str = string;
            }
            builder.setPositiveButton(str2, new android.content.DialogInterface.OnClickListener() { // from class: com.taobao.weex.ui.module.WXModalUIModule.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i) {
                    if (jSCallback != null) {
                        java.util.HashMap map = new java.util.HashMap();
                        map.put("result", str2);
                        map.put("data", editText.getText().toString());
                        jSCallback.invoke(map);
                    }
                }
            }).setNegativeButton(str, new android.content.DialogInterface.OnClickListener() { // from class: com.taobao.weex.ui.module.WXModalUIModule.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i) {
                    if (jSCallback != null) {
                        java.util.HashMap map = new java.util.HashMap();
                        map.put("result", str);
                        map.put("data", editText.getText().toString());
                        jSCallback.invoke(map);
                    }
                }
            });
            android.app.AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setCanceledOnTouchOutside(false);
            alertDialogCreate.show();
            tracking(alertDialogCreate);
            return;
        }
        com.taobao.weex.utils.WXLogUtils.e("when call prompt mWXSDKInstance.getContext() must instanceof Activity");
    }

    private void tracking(android.app.Dialog dialog) {
        this.activeDialog = dialog;
        dialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.taobao.weex.ui.module.WXModalUIModule.6
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(android.content.DialogInterface dialogInterface) {
                com.taobao.weex.ui.module.WXModalUIModule.this.activeDialog = null;
            }
        });
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        android.app.Dialog dialog = this.activeDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.activeDialog.dismiss();
    }
}
