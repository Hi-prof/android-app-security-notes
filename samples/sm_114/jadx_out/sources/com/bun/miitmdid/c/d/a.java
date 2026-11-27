package com.bun.miitmdid.c.d;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bun.supplier.InnerIdSupplier {
    private android.content.Context a;
    private com.bun.supplier.SupplierListener f;
    private boolean e = false;
    private java.lang.String b = "";
    private java.lang.String c = "";
    private java.lang.String d = "";

    /* JADX INFO: renamed from: com.bun.miitmdid.c.d.a$a, reason: collision with other inner class name */
    class RunnableC0011a implements java.lang.Runnable {
        RunnableC0011a() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    public a(android.content.Context context) {
        this.a = context;
    }

    static native /* synthetic */ android.content.Context a(com.bun.miitmdid.c.d.a aVar);

    static native /* synthetic */ java.lang.String a(com.bun.miitmdid.c.d.a aVar, java.lang.String str);

    private native void b();

    static native /* synthetic */ void b(com.bun.miitmdid.c.d.a aVar);

    @Override // com.bun.supplier.InnerIdSupplier
    public native void a(com.bun.supplier.SupplierListener supplierListener);

    @Override // com.bun.supplier.InnerIdSupplier
    public native boolean a();

    @Override // com.bun.supplier.IdSupplier
    public native java.lang.String getAAID();

    @Override // com.bun.supplier.IdSupplier
    public native java.lang.String getOAID();

    @Override // com.bun.supplier.InnerIdSupplier
    public native java.lang.String getUDID();

    @Override // com.bun.supplier.IdSupplier
    public native java.lang.String getVAID();

    @Override // com.bun.supplier.IdSupplier
    public native boolean isSupported();

    @Override // com.bun.supplier.InnerIdSupplier
    public native void shutDown();
}
