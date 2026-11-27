package com.bun.miitmdid.c.h;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.bun.supplier.InnerIdSupplier {
    private android.content.Context a;

    class a implements java.lang.Runnable {
        final /* synthetic */ com.bun.supplier.SupplierListener a;

        a(com.bun.supplier.SupplierListener supplierListener) {
            this.a = supplierListener;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    public b(android.content.Context context) {
        this.a = context;
    }

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
