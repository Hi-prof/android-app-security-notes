package com.bun.miitmdid.c.g;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.bun.supplier.InnerIdSupplier, com.bun.miitmdid.c.e.a {
    private com.bun.miitmdid.c.g.a a;
    private com.bun.supplier.SupplierListener b;

    public b(android.content.Context context, com.bun.supplier.SupplierListener supplierListener) {
        this.b = supplierListener;
        this.a = new com.bun.miitmdid.c.g.a(context, this);
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public native void a(com.bun.supplier.SupplierListener supplierListener);

    @Override // com.bun.miitmdid.c.e.a
    public native void a(boolean z);

    @Override // com.bun.supplier.InnerIdSupplier
    public native boolean a();

    @Override // com.bun.miitmdid.c.e.a
    public native void b();

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
