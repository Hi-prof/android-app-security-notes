package io.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ProcessMediator extends android.app.Activity implements io.dcloud.common.DHInterface.IReflectAble {
    public static final int CODE_REQUEST = 1000;
    public static final int CODE_RESULT = 1001;
    public static final java.lang.String LOGIC_CLASS = "__class__";
    public static final java.lang.String PROCESS_ACTIVITY_SOURCE = "process_activity_source";
    public static final java.lang.String REQ_DATA = "req";
    public static final java.lang.String RESULT_ACTION = "mediator_process_result_action";
    public static final java.lang.String RESULT_DATA = "result";
    public static final java.lang.String STYLE_DATA = "style";
    public static boolean isMultiProcess = false;
    private java.lang.String b;
    boolean a = false;
    java.lang.String c = "";
    android.content.BroadcastReceiver d = new io.dcloud.ProcessMediator.a();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface Logic extends io.dcloud.common.DHInterface.IReflectAble {
        void exec(android.content.Context context, android.content.Intent intent);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends android.content.BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if (intent.getAction().equals(io.dcloud.ProcessMediator.this.c)) {
                io.dcloud.ProcessMediator.this.onResult(intent);
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        java.lang.String stringExtra = getIntent().getStringExtra(LOGIC_CLASS);
        if (android.text.TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        isMultiProcess = true;
        java.lang.String stringExtra2 = getIntent().getStringExtra("transaction");
        if (getIntent().hasExtra(PROCESS_ACTIVITY_SOURCE)) {
            this.b = getIntent().getStringExtra(PROCESS_ACTIVITY_SOURCE);
        }
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        boolean zIsEmpty = android.text.TextUtils.isEmpty(stringExtra2);
        java.lang.String str = RESULT_ACTION;
        if (!zIsEmpty) {
            str = RESULT_ACTION + stringExtra2;
        }
        this.c = str;
        intentFilter.addAction(str);
        androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this).registerReceiver(this.d, intentFilter);
        try {
            java.lang.Object objNewInstance = java.lang.Class.forName(stringExtra).newInstance();
            if (objNewInstance instanceof io.dcloud.ProcessMediator.Logic) {
                ((io.dcloud.ProcessMediator.Logic) objNewInstance).exec(this, getIntent());
            }
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.lang.IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (java.lang.InstantiationException e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.b = null;
        isMultiProcess = false;
        androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this).unregisterReceiver(this.d);
    }

    public void onResult(android.content.Intent intent) {
        setResult(1001, intent);
        finishActivity(1000);
        finish();
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.b)) {
            return;
        }
        android.content.Intent intent2 = new android.content.Intent();
        intent2.setClassName(getPackageName(), this.b);
        startActivity(intent2);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
