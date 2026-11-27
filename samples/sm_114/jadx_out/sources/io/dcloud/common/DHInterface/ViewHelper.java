package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ViewHelper {
    public static android.app.Dialog createDefaultDialog(android.content.Context context, int i, int i2) {
        android.app.Dialog dialog = new android.app.Dialog(context, io.dcloud.PdrR.STYLE_DIALOG_DCLOUD_DEFALUT_DIALOG);
        dialog.requestWindowFeature(1);
        dialog.setContentView(io.dcloud.PdrR.LAYOUT_DIALOG_LAYOUT_DCLOUD_DIALOG);
        dialog.setCanceledOnTouchOutside(true);
        android.view.Window window = dialog.getWindow();
        window.setWindowAnimations(io.dcloud.PdrR.STYLE_DIALOG_STYLE_DCLOUD_ANIM_DIALOG_WINDOW_IN_OUT);
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = i;
        attributes.y = i2;
        attributes.width = context.getResources().getDisplayMetrics().widthPixels;
        attributes.gravity = 48;
        window.setAttributes(attributes);
        return dialog;
    }

    public static void showDefaultDialog(final android.app.Dialog dialog, android.view.View.OnClickListener onClickListener, final android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i) {
        ((android.widget.TextView) dialog.findViewById(io.dcloud.PdrR.ID_DCLOUD_DIALOG_TITLE)).setText(str);
        ((android.widget.TextView) dialog.findViewById(io.dcloud.PdrR.ID_DCLOUD_DIALOG_MSG)).setText(str2);
        ((android.widget.ImageView) dialog.findViewById(io.dcloud.PdrR.ID_DCLOUD_DIALOG_ICON)).setImageBitmap(bitmap);
        android.widget.TextView textView = (android.widget.TextView) dialog.findViewById(io.dcloud.PdrR.ID_DCLOUD_DIALOG_BTN1);
        textView.setOnClickListener(onClickListener);
        textView.setText(str3);
        android.widget.TextView textView2 = (android.widget.TextView) dialog.findViewById(io.dcloud.PdrR.ID_DCLOUD_DIALOG_BTN2);
        textView2.setText(str4);
        textView2.setOnClickListener(onClickListener);
        dialog.show();
        if (i > 0) {
            final java.util.Timer timer = new java.util.Timer();
            timer.schedule(new java.util.TimerTask() { // from class: io.dcloud.common.DHInterface.ViewHelper.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                }
            }, i);
            dialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: io.dcloud.common.DHInterface.ViewHelper.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(android.content.DialogInterface dialogInterface) {
                    timer.cancel();
                    android.graphics.Bitmap bitmap2 = bitmap;
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        return;
                    }
                    bitmap.recycle();
                }
            });
        }
    }
}
