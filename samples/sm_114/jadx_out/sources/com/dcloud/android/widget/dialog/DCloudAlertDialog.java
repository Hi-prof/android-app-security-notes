package com.dcloud.android.widget.dialog;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DCloudAlertDialog extends android.app.AlertDialog {
    public static final int DARK_THEME = -999;
    public static final int LIGHT_THEME = -998;
    boolean hasNavigationBar;

    public DCloudAlertDialog(android.content.Context context, boolean z) {
        super(context);
        this.hasNavigationBar = z;
    }

    private static int getTheme(android.content.Context context, int i) {
        if (i == -998) {
            return 5;
        }
        if (i == -999) {
            return 4;
        }
        return i;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.hasNavigationBar) {
            super.show();
            return;
        }
        getWindow().addFlags(8);
        super.show();
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 4866);
        getWindow().clearFlags(8);
    }

    public DCloudAlertDialog(android.content.Context context, int i, boolean z) {
        super(context, getTheme(context, i));
        this.hasNavigationBar = z;
    }
}
