package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ErrorDialogUtil {
    private static java.util.ArrayList<java.lang.String> list = new java.util.ArrayList<>();

    public static void checkAppKeyErrorTips(android.app.Activity activity) {
        java.lang.String string = activity.getString(io.dcloud.base.R.string.dcloud_offline_fail_tips);
        com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialog = new com.dcloud.android.widget.dialog.DCloudAlertDialog(activity, io.dcloud.common.util.AppRuntime.getAppDarkMode(activity) ? com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME : com.dcloud.android.widget.dialog.DCloudAlertDialog.LIGHT_THEME, io.dcloud.common.util.PdrUtil.isNavigationBarExist(activity));
        dCloudAlertDialog.setTitle(string);
        dCloudAlertDialog.setButton(-2, activity.getString(android.R.string.ok), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.ErrorDialogUtil.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        dCloudAlertDialog.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: io.dcloud.common.util.ErrorDialogUtil.8
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
                return i == 4;
            }
        });
        dCloudAlertDialog.setCancelable(false);
        dCloudAlertDialog.setCanceledOnTouchOutside(false);
        dCloudAlertDialog.show();
    }

    public static android.app.Dialog getLossDialog(final android.app.Activity activity, java.lang.String str, final java.lang.String str2, final java.lang.String str3) {
        if (list.contains(str3)) {
            return null;
        }
        list.add(str3);
        com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialog = new com.dcloud.android.widget.dialog.DCloudAlertDialog(activity, io.dcloud.PdrR.FEATURE_LOSS_STYLE, io.dcloud.common.util.PdrUtil.isNavigationBarExist(activity));
        dCloudAlertDialog.setTitle("HTML5+ Runtime");
        dCloudAlertDialog.setIcon(android.R.drawable.ic_dialog_info);
        dCloudAlertDialog.setMessage(str);
        dCloudAlertDialog.setButton(-1, activity.getString(io.dcloud.base.R.string.dcloud_common_view_details), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.ErrorDialogUtil.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                android.content.Intent intent = new android.content.Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(android.net.Uri.parse(str2));
                activity.startActivity(intent);
            }
        });
        dCloudAlertDialog.setButton(-2, activity.getString(io.dcloud.base.R.string.dcloud_common_ignore), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.ErrorDialogUtil.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dCloudAlertDialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: io.dcloud.common.util.ErrorDialogUtil.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(android.content.DialogInterface dialogInterface) {
                io.dcloud.common.util.ErrorDialogUtil.list.remove(str3);
            }
        });
        return dCloudAlertDialog;
    }

    public static void showErrorTipsAlert(android.app.Activity activity, java.lang.String str, android.content.DialogInterface.OnClickListener onClickListener) {
        com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialog = new com.dcloud.android.widget.dialog.DCloudAlertDialog(activity, io.dcloud.common.util.AppRuntime.getAppDarkMode(activity) ? com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME : com.dcloud.android.widget.dialog.DCloudAlertDialog.LIGHT_THEME, io.dcloud.common.util.PdrUtil.isNavigationBarExist(activity));
        dCloudAlertDialog.setMessage(str);
        dCloudAlertDialog.setButton(-2, activity.getString(android.R.string.ok), onClickListener);
        dCloudAlertDialog.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: io.dcloud.common.util.ErrorDialogUtil.9
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
                return i == 4;
            }
        });
        dCloudAlertDialog.setCancelable(false);
        dCloudAlertDialog.setCanceledOnTouchOutside(false);
        dCloudAlertDialog.show();
    }

    public static android.app.Dialog getLossDialog(final io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, final java.lang.String str2, final java.lang.String str3) {
        if (list.contains(str3)) {
            return null;
        }
        list.add(str3);
        if (iWebview == null || iWebview.getActivity() == null) {
            return null;
        }
        com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialog = new com.dcloud.android.widget.dialog.DCloudAlertDialog(iWebview.getActivity(), io.dcloud.PdrR.FEATURE_LOSS_STYLE, io.dcloud.common.util.PdrUtil.isNavigationBarExist(iWebview.getActivity()));
        dCloudAlertDialog.setTitle("HTML5+ Runtime");
        dCloudAlertDialog.setIcon(android.R.drawable.ic_dialog_info);
        dCloudAlertDialog.setMessage(str);
        dCloudAlertDialog.setButton(-1, iWebview.getContext().getString(io.dcloud.base.R.string.dcloud_common_view_details), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.ErrorDialogUtil.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                android.content.Intent intent = new android.content.Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(android.net.Uri.parse(str2));
                iWebview.getActivity().startActivity(intent);
            }
        });
        dCloudAlertDialog.setButton(-2, iWebview.getContext().getString(io.dcloud.base.R.string.dcloud_common_ignore), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.ErrorDialogUtil.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dCloudAlertDialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: io.dcloud.common.util.ErrorDialogUtil.6
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(android.content.DialogInterface dialogInterface) {
                io.dcloud.common.util.ErrorDialogUtil.list.remove(str3);
            }
        });
        return dCloudAlertDialog;
    }
}
