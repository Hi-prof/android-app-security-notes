package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DialogUtil {
    public static com.dcloud.android.widget.dialog.DCloudAlertDialog initDialogTheme(android.app.Activity activity, boolean z) {
        int i;
        boolean zIsNavigationBarExist = io.dcloud.common.util.PdrUtil.isNavigationBarExist(activity);
        int i2 = io.dcloud.PdrR.STREAMAPP_DELETE_THEME;
        if (io.dcloud.common.util.AppRuntime.getAppDarkMode(activity)) {
            int i3 = io.dcloud.PdrR.STREAMAPP_DELETE_DARK_THEME;
            i = com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME;
        } else {
            i = com.dcloud.android.widget.dialog.DCloudAlertDialog.LIGHT_THEME;
        }
        return z ? new com.dcloud.android.widget.dialog.DCloudAlertDialog(activity, i, zIsNavigationBarExist) : new com.dcloud.android.widget.dialog.DCloudAlertDialog(activity, i, zIsNavigationBarExist);
    }

    public static void showAlertDialog(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3, final android.view.View.OnClickListener onClickListener, final android.view.View.OnClickListener onClickListener2, android.content.DialogInterface.OnCancelListener onCancelListener, android.content.DialogInterface.OnDismissListener onDismissListener, boolean z, int i, int i2, int i3) {
        if (activity == null) {
            return;
        }
        final android.app.AlertDialog alertDialogInitDialogTheme = initDialogTheme(activity);
        android.view.View viewInflate = android.view.LayoutInflater.from(activity).inflate(io.dcloud.PdrR.STREAMAPP_CUSTOM_ALERT_DIALOG_LAYOUT, (android.view.ViewGroup) null);
        android.widget.TextView textView = (android.widget.TextView) viewInflate.findViewById(io.dcloud.PdrR.STREAMAPP_CUSTOM_ALERT_DIALOG_TITLE);
        android.widget.Button button = (android.widget.Button) viewInflate.findViewById(io.dcloud.PdrR.STREAMAPP_CUSTOM_ALERT_DIALOG_SURE);
        android.widget.Button button2 = (android.widget.Button) viewInflate.findViewById(io.dcloud.PdrR.STREAMAPP_CUSTOM_ALERT_DIALOG_CANCEL);
        if (!android.text.TextUtils.isEmpty(str)) {
            textView.setText(str);
            textView.setGravity(i);
        }
        if (!z) {
            viewInflate.findViewById(io.dcloud.PdrR.STREAMAPP_CUSTOM_ALERT_DIALOG_CUSTOM_LAYOUT).setVisibility(8);
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            button.setText(str2);
        }
        if (!android.text.TextUtils.isEmpty(str3)) {
            button2.setText(str3);
        }
        button.setOnClickListener(new android.view.View.OnClickListener() { // from class: io.dcloud.common.util.DialogUtil.4
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                alertDialogInitDialogTheme.dismiss();
                android.view.View.OnClickListener onClickListener3 = onClickListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                }
            }
        });
        button2.setOnClickListener(new android.view.View.OnClickListener() { // from class: io.dcloud.common.util.DialogUtil.5
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                alertDialogInitDialogTheme.dismiss();
                android.view.View.OnClickListener onClickListener3 = onClickListener2;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                }
            }
        });
        if (onCancelListener != null) {
            alertDialogInitDialogTheme.setOnCancelListener(onCancelListener);
        }
        if (onDismissListener != null) {
            alertDialogInitDialogTheme.setOnDismissListener(onDismissListener);
        }
        alertDialogInitDialogTheme.show();
        alertDialogInitDialogTheme.setContentView(viewInflate);
        android.view.Window window = alertDialogInitDialogTheme.getWindow();
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        window.setGravity(i2);
        window.setLayout(i3, attributes.height);
    }

    public static void showConfirm(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String[] strArr, final io.dcloud.common.DHInterface.ICallBack iCallBack) {
        final com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialog = new com.dcloud.android.widget.dialog.DCloudAlertDialog(activity, io.dcloud.common.util.AppRuntime.getAppDarkMode(activity) ? com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME : com.dcloud.android.widget.dialog.DCloudAlertDialog.LIGHT_THEME, io.dcloud.common.util.PdrUtil.isNavigationBarExist(activity));
        dCloudAlertDialog.setTitle(str);
        dCloudAlertDialog.setCanceledOnTouchOutside(false);
        dCloudAlertDialog.setMessage(str2);
        android.content.DialogInterface.OnClickListener onClickListener = new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.DialogUtil.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                if (i == -2) {
                    dCloudAlertDialog.cancel();
                    dCloudAlertDialog.dismiss();
                } else if (i != -3 && i == -1) {
                    dCloudAlertDialog.dismiss();
                }
                iCallBack.onCallBack(i, null);
            }
        };
        dCloudAlertDialog.setButton(-1, strArr[0], onClickListener);
        dCloudAlertDialog.setButton(-2, strArr[1], onClickListener);
        dCloudAlertDialog.show();
    }

    public static void showDialog(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String[] strArr) {
        final android.app.AlertDialog alertDialogInitDialogTheme = initDialogTheme(activity);
        if (strArr != null && io.dcloud.common.util.PdrUtil.isEmpty(strArr[0])) {
            strArr[0] = io.dcloud.common.adapter.util.AndroidResources.getString(android.R.string.ok);
        }
        if (!io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            alertDialogInitDialogTheme.setTitle(str);
        }
        alertDialogInitDialogTheme.setCanceledOnTouchOutside(true);
        alertDialogInitDialogTheme.setMessage(str2);
        alertDialogInitDialogTheme.setButton(-1, strArr[0], new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.DialogUtil.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                alertDialogInitDialogTheme.dismiss();
            }
        });
        alertDialogInitDialogTheme.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: io.dcloud.common.util.DialogUtil.3
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
                if (keyEvent.getAction() != 1 || i != 4) {
                    return false;
                }
                alertDialogInitDialogTheme.dismiss();
                return true;
            }
        });
        alertDialogInitDialogTheme.show();
    }

    public static android.app.AlertDialog initDialogTheme(android.app.Activity activity) {
        int i;
        boolean zIsNavigationBarExist = io.dcloud.common.util.PdrUtil.isNavigationBarExist(activity);
        int i2 = io.dcloud.PdrR.STREAMAPP_DELETE_THEME;
        if (io.dcloud.common.util.AppRuntime.getAppDarkMode(activity)) {
            int i3 = io.dcloud.PdrR.STREAMAPP_DELETE_DARK_THEME;
            i = com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME;
        } else {
            i = com.dcloud.android.widget.dialog.DCloudAlertDialog.LIGHT_THEME;
        }
        return new com.dcloud.android.widget.dialog.DCloudAlertDialog(activity, i, zIsNavigationBarExist);
    }
}
