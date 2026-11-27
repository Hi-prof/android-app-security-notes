package io.dcloud.common.util.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NetCheckReceiver extends android.content.BroadcastReceiver {
    public static final java.lang.String netACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final java.lang.String simACTION = "android.intent.action.SIM_STATE_CHANGED";
    io.dcloud.common.DHInterface.AbsMgr mNetMgr;

    NetCheckReceiver(io.dcloud.common.DHInterface.AbsMgr absMgr) {
        this.mNetMgr = absMgr;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        java.lang.String action = intent.getAction();
        if (action != null) {
            if (action.equals(netACTION)) {
                this.mNetMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 1, new java.lang.Object[]{io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onDeviceNetChanged, null, null});
            } else if (action.equals(simACTION)) {
                this.mNetMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 1, new java.lang.Object[]{io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onSimStateChanged, null, null});
            }
        }
    }
}
