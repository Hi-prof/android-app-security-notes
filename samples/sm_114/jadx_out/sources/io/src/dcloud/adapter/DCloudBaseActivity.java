package io.src.dcloud.adapter;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCloudBaseActivity extends androidx.appcompat.app.AppCompatActivity implements io.dcloud.common.DHInterface.IReflectAble {
    public static java.lang.String loadDexDirectInfo;
    private android.app.AlertDialog mDebugDialog;
    private io.src.dcloud.adapter.DCloudBaseActivity.DebugSocketStatusReceiver mDebugSocketStatusReceiver;
    private android.app.Dialog mLoadingPD;
    private io.src.dcloud.adapter.DCloudBaseActivity.SocketCheckReceiver mSocketCheckReceiver;
    private java.lang.String preDebuggingInfoForWeexDebugging2;
    private io.src.dcloud.adapter.DCloudBaseActivity.WeexDebugStartReceiver weexDebugStartReceiver;
    public android.app.Activity that = this;
    private int loadingSecond = 0;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public class DebugSocketStatusReceiver extends android.content.BroadcastReceiver {
        public DebugSocketStatusReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            io.src.dcloud.adapter.DCloudBaseActivity.this.a(intent.getStringExtra(io.dcloud.common.constant.AbsoluteConst.WEEX_DEBUG_CONNECT_BROADCAST_KEY), true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public class SocketCheckReceiver extends android.content.BroadcastReceiver {
        public SocketCheckReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            java.lang.String stringExtra = intent.getStringExtra(io.dcloud.common.constant.AbsoluteConst.WEEX_DEBUG_PING_IP_KEY);
            if (io.src.dcloud.adapter.DCloudBaseActivity.this.mLoadingPD != null) {
                io.src.dcloud.adapter.DCloudBaseActivity.this.loadingSecond = 0;
                ((android.widget.TextView) io.src.dcloud.adapter.DCloudBaseActivity.this.mLoadingPD.findViewById(io.dcloud.base.R.id.debugTV)).setText(context.getString(io.dcloud.base.R.string.dcloud_debug_connecting) + "\n(" + stringExtra + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public class WeexDebugStartReceiver extends android.content.BroadcastReceiver {
        public WeexDebugStartReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            io.src.dcloud.adapter.DCloudBaseActivity.this.preDebuggingInfoForWeexDebugging2 = intent.getStringExtra("debugging_info");
            io.src.dcloud.adapter.DCloudBaseActivity.this.e();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String str;
            boolean z;
            java.lang.Object objInvokeMethod = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex.WeexDevtoolImpl", "getDebugSocketStatus", null, null, null);
            while (true) {
                str = (java.lang.String) objInvokeMethod;
                if (str != null) {
                    z = false;
                    break;
                } else if (io.src.dcloud.adapter.DCloudBaseActivity.this.loadingSecond >= 6) {
                    z = true;
                    break;
                } else {
                    android.os.SystemClock.sleep(1000L);
                    io.src.dcloud.adapter.DCloudBaseActivity.access$208(io.src.dcloud.adapter.DCloudBaseActivity.this);
                    objInvokeMethod = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex.WeexDevtoolImpl", "getDebugSocketStatus", null, null, null);
                }
            }
            io.src.dcloud.adapter.DCloudBaseActivity.this.a(str, false, z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a implements android.content.DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                java.io.File file = new java.io.File(android.os.Environment.getExternalStorageDirectory() + java.io.File.separator + "Android/data/" + io.dcloud.common.util.RuningAcitvityUtil.getAppName(io.src.dcloud.adapter.DCloudBaseActivity.this) + "/apps/" + io.dcloud.common.util.BaseInfo.sDefaultBootApp + "/www/__nvue_debug__");
                if (file.exists()) {
                    file.delete();
                }
                io.src.dcloud.adapter.DCloudBaseActivity.this.startActivity(android.content.Intent.makeRestartActivityTask(io.src.dcloud.adapter.DCloudBaseActivity.this.getPackageManager().getLaunchIntentForPackage(io.src.dcloud.adapter.DCloudBaseActivity.this.getPackageName()).getComponent()));
                java.lang.Runtime.getRuntime().exit(0);
            }
        }

        /* JADX INFO: renamed from: io.src.dcloud.adapter.DCloudBaseActivity$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class DialogInterfaceOnClickListenerC0077b implements android.content.DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0077b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                int iB = io.src.dcloud.adapter.DCloudBaseActivity.this.b();
                if (iB == 1) {
                    io.src.dcloud.adapter.DCloudBaseActivity.this.startActivity(android.content.Intent.makeRestartActivityTask(io.src.dcloud.adapter.DCloudBaseActivity.this.getPackageManager().getLaunchIntentForPackage(io.src.dcloud.adapter.DCloudBaseActivity.this.getPackageName()).getComponent()));
                    java.lang.Runtime.getRuntime().exit(0);
                } else if (iB == 2 && !io.dcloud.common.util.PdrUtil.isEmpty(io.src.dcloud.adapter.DCloudBaseActivity.this.preDebuggingInfoForWeexDebugging2)) {
                    io.src.dcloud.adapter.DCloudBaseActivity.this.f();
                    android.content.Intent intent = new android.content.Intent(io.dcloud.common.constant.AbsoluteConst.WEEX_DEBUG_START_WAITING_CONNECT);
                    intent.putExtra("debugging_info", io.src.dcloud.adapter.DCloudBaseActivity.this.preDebuggingInfoForWeexDebugging2);
                    androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(io.src.dcloud.adapter.DCloudBaseActivity.this.getApplication()).sendBroadcast(intent);
                    io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex.WeexDevtoolImpl", "initDebugEnvironment", null, new java.lang.Class[]{android.app.Application.class, java.lang.String.class}, new java.lang.Object[]{io.src.dcloud.adapter.DCloudBaseActivity.this.getApplication(), io.src.dcloud.adapter.DCloudBaseActivity.this.preDebuggingInfoForWeexDebugging2});
                }
            }
        }

        b(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.src.dcloud.adapter.DCloudBaseActivity.this.a();
            if (io.src.dcloud.adapter.DCloudBaseActivity.this.mDebugDialog == null) {
                io.src.dcloud.adapter.DCloudBaseActivity.this.mDebugDialog = new android.app.AlertDialog.Builder(io.src.dcloud.adapter.DCloudBaseActivity.this).setTitle("").setMessage(this.a).setPositiveButton(io.dcloud.base.R.string.dcloud_debug_reconnection_service, new io.src.dcloud.adapter.DCloudBaseActivity.b.DialogInterfaceOnClickListenerC0077b()).setNegativeButton(io.dcloud.base.R.string.dcloud_common_cancel, new io.src.dcloud.adapter.DCloudBaseActivity.b.a()).setCancelable(false).show();
            } else {
                if (io.src.dcloud.adapter.DCloudBaseActivity.this.mDebugDialog.isShowing()) {
                    return;
                }
                io.src.dcloud.adapter.DCloudBaseActivity.this.mDebugDialog.setMessage(this.a);
                io.src.dcloud.adapter.DCloudBaseActivity.this.mDebugDialog.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        android.app.Dialog dialog = this.mLoadingPD;
        if (dialog != null) {
            dialog.dismiss();
            this.mLoadingPD = null;
        }
    }

    static /* synthetic */ int access$208(io.src.dcloud.adapter.DCloudBaseActivity dCloudBaseActivity) {
        int i = dCloudBaseActivity.loadingSecond;
        dCloudBaseActivity.loadingSecond = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        return c() ? 1 : 2;
    }

    private boolean c() {
        java.lang.String path;
        if (android.os.Build.VERSION.SDK_INT <= 28) {
            path = android.os.Environment.getExternalStorageDirectory() + java.io.File.separator + "Android/data/" + io.dcloud.common.util.RuningAcitvityUtil.getAppName(this);
        } else {
            path = getExternalFilesDir(null).getParentFile().getPath();
        }
        return new java.io.File(path + "/apps/" + io.dcloud.common.util.BaseInfo.sDefaultBootApp + "/www/__nvue_debug__").exists();
    }

    private void d() {
        android.app.Dialog dialog = new android.app.Dialog(this);
        this.mLoadingPD = dialog;
        dialog.getWindow().setGravity(17);
        this.mLoadingPD.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
        this.mLoadingPD.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.mLoadingPD.setCancelable(false);
        this.mLoadingPD.show();
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) android.view.LayoutInflater.from(this).inflate(io.dcloud.base.R.layout.dcloud_weex_debug_progress, (android.view.ViewGroup) null);
        android.widget.TextView textView = (android.widget.TextView) viewGroup.findViewById(io.dcloud.base.R.id.debugTV);
        java.lang.String str = (java.lang.String) io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex.WeexDevtoolImpl", "getCurrentPingIP", null, null, null);
        if (str != null) {
            textView.setText(getString(io.dcloud.base.R.string.dcloud_debug_connecting) + "\n(" + str + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        }
        this.mLoadingPD.setContentView(viewGroup);
        new java.lang.Thread(new io.src.dcloud.adapter.DCloudBaseActivity.a()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (io.dcloud.common.util.BaseInfo.SyncDebug) {
            this.mDebugSocketStatusReceiver = new io.src.dcloud.adapter.DCloudBaseActivity.DebugSocketStatusReceiver();
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this).registerReceiver(this.mDebugSocketStatusReceiver, new android.content.IntentFilter(io.dcloud.common.constant.AbsoluteConst.WEEX_DEBUG_CONNECT_BROADCAST));
            this.mSocketCheckReceiver = new io.src.dcloud.adapter.DCloudBaseActivity.SocketCheckReceiver();
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this).registerReceiver(this.mSocketCheckReceiver, new android.content.IntentFilter(io.dcloud.common.constant.AbsoluteConst.WEEX_DEBUG_PING_BROADCAST));
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (io.dcloud.common.util.BaseInfo.SyncDebug && this.mDebugSocketStatusReceiver != null) {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mDebugSocketStatusReceiver);
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mSocketCheckReceiver);
            this.mDebugSocketStatusReceiver = null;
            this.mSocketCheckReceiver = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (io.dcloud.common.util.BaseInfo.SyncDebug) {
            this.weexDebugStartReceiver = new io.src.dcloud.adapter.DCloudBaseActivity.WeexDebugStartReceiver();
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this).registerReceiver(this.weexDebugStartReceiver, new android.content.IntentFilter(io.dcloud.common.constant.AbsoluteConst.WEEX_DEBUG_START_WAITING_CONNECT));
            loadDexDirectInfo = getIntent().getStringExtra("load_dex_direct_info");
            if (c()) {
                e();
            }
            io.dcloud.common.util.AppRuntime.loadDex(getApplication());
            io.dcloud.common.util.AppRuntime.initWeex(getApplication());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.mDebugSocketStatusReceiver != null) {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mDebugSocketStatusReceiver);
        }
        if (this.mSocketCheckReceiver != null) {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mSocketCheckReceiver);
        }
        if (this.weexDebugStartReceiver != null) {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this).unregisterReceiver(this.weexDebugStartReceiver);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected final void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        onNewIntentImpl(intent);
    }

    public void onNewIntentImpl(android.content.Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, boolean z, boolean z2) {
        if (z2) {
            a();
        }
        a(str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, boolean z) {
        java.lang.String str2;
        if (io.dcloud.common.constant.AbsoluteConst.WEEX_DEBUG_CONNECT_SUCCESS.equalsIgnoreCase(str)) {
            a();
            android.app.AlertDialog alertDialog = this.mDebugDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
                return;
            }
            return;
        }
        if (z) {
            str2 = getString(io.dcloud.base.R.string.dcloud_debug_break_off_reason) + "\n";
        } else {
            str2 = getString(io.dcloud.base.R.string.dcloud_debug_cannot_connect) + "\n";
        }
        new android.os.Handler(android.os.Looper.getMainLooper()).post(new io.src.dcloud.adapter.DCloudBaseActivity.b(str2 + getString(io.dcloud.base.R.string.dcloud_debug_possible_causes)));
    }
}
