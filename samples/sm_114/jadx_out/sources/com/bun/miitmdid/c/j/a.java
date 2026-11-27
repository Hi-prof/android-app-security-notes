package com.bun.miitmdid.c.j;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bun.supplier.InnerIdSupplier {
    private java.lang.String a = "";
    private android.content.Context b;

    /* JADX INFO: renamed from: com.bun.miitmdid.c.j.a$a, reason: collision with other inner class name */
    class RunnableC0014a implements java.lang.Runnable {
        final /* synthetic */ com.bun.supplier.SupplierListener a;

        RunnableC0014a(com.bun.supplier.SupplierListener supplierListener) {
            this.a = supplierListener;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    public a(android.content.Context context) {
        this.b = context;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public native void a(com.bun.supplier.SupplierListener supplierListener);

    public native void a(java.lang.String str);

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
