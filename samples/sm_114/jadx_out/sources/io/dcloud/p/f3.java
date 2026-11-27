package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class f3 {
    private io.dcloud.p.f3.b a;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface b {
        void a(java.lang.String str, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class c implements java.lang.reflect.InvocationHandler {
        private c() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
            if (method.getName().equalsIgnoreCase("OnSupport") && objArr != null && objArr.length > 0) {
                boolean zBooleanValue = ((java.lang.Boolean) objArr[0]).booleanValue();
                java.lang.Object obj2 = objArr.length > 1 ? objArr[1] : null;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                if (obj2 == null) {
                    sb.append(com.taobao.weex.el.parse.Operators.OR);
                } else {
                    java.lang.Object objInvokeMethod = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(obj2, "getOAID", null, new java.lang.Object[0]);
                    java.lang.Object objInvokeMethod2 = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(obj2, "getVAID", null, new java.lang.Object[0]);
                    java.lang.Object objInvokeMethod3 = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(obj2, "getAAID", null, new java.lang.Object[0]);
                    if (objInvokeMethod == null) {
                        objInvokeMethod = "";
                    }
                    sb.append(objInvokeMethod);
                    sb.append("|");
                    if (objInvokeMethod2 == null) {
                        objInvokeMethod2 = "";
                    }
                    sb.append(objInvokeMethod2);
                    sb.append("|");
                    if (objInvokeMethod3 == null) {
                        objInvokeMethod3 = "";
                    }
                    sb.append(objInvokeMethod3);
                }
                if (io.dcloud.p.f3.this.a != null) {
                    io.dcloud.p.f3.this.a.a(sb.toString(), zBooleanValue);
                }
            }
            return null;
        }
    }

    public f3(io.dcloud.p.f3.b bVar) {
        this.a = bVar;
    }

    public boolean b(android.content.Context context) {
        int iA;
        return (io.dcloud.common.util.PdrUtil.checkIntl() || (iA = a(context)) == 1008612 || iA == 1008613 || iA == 1008611 || iA != 1008614) ? false : true;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Try blocks wrapping queue limit reached! Please report as an issue!
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectExcHandlers(BlockExceptionHandler.java:96)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:62)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:422)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:57)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
        */
    private int a(android.content.Context r11) {
        /*
            r10 = this;
            java.lang.String r0 = "com.bun.miitmdid.core.MdidSdkHelper"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L5d
            java.lang.Class<com.bun.supplier.IIdentifierListener> r1 = com.bun.supplier.IIdentifierListener.class
            goto Lf
        L9:
            java.lang.String r1 = "com.bun.miitmdid.interfaces.IIdentifierListener"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L59
        Lf:
            java.lang.Class r2 = r10.getClass()     // Catch: java.lang.Exception -> L59
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch: java.lang.Exception -> L59
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L59
            r5 = 0
            r4[r5] = r1     // Catch: java.lang.Exception -> L59
            io.dcloud.p.f3$c r6 = new io.dcloud.p.f3$c     // Catch: java.lang.Exception -> L59
            r7 = 0
            r6.<init>()     // Catch: java.lang.Exception -> L59
            java.lang.Object r2 = java.lang.reflect.Proxy.newProxyInstance(r2, r4, r6)     // Catch: java.lang.Exception -> L59
            java.lang.String r4 = "InitSdk"
            r6 = 3
            java.lang.Class[] r8 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L59
            java.lang.Class<android.content.Context> r9 = android.content.Context.class
            r8[r5] = r9     // Catch: java.lang.Exception -> L59
            java.lang.Class r9 = java.lang.Boolean.TYPE     // Catch: java.lang.Exception -> L59
            r8[r3] = r9     // Catch: java.lang.Exception -> L59
            r9 = 2
            r8[r9] = r1     // Catch: java.lang.Exception -> L59
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r4, r8)     // Catch: java.lang.Exception -> L59
            if (r0 == 0) goto L4e
            r0.setAccessible(r3)     // Catch: java.lang.Exception -> L59
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch: java.lang.Exception -> L59
            r1[r5] = r11     // Catch: java.lang.Exception -> L59
            java.lang.Boolean r11 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L59
            r1[r3] = r11     // Catch: java.lang.Exception -> L59
            r1[r9] = r2     // Catch: java.lang.Exception -> L59
            java.lang.Object r7 = r0.invoke(r7, r1)     // Catch: java.lang.Exception -> L59
        L4e:
            boolean r11 = r7 instanceof java.lang.Integer     // Catch: java.lang.Exception -> L59
            if (r11 == 0) goto L59
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch: java.lang.Exception -> L59
            int r11 = r7.intValue()     // Catch: java.lang.Exception -> L59
            return r11
        L59:
            r11 = 1008615(0xf63e7, float:1.41337E-39)
            return r11
        L5d:
            r11 = 1008612(0xf63e4, float:1.413366E-39)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.p.f3.a(android.content.Context):int");
    }
}
