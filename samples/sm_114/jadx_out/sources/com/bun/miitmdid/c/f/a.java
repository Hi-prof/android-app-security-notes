package com.bun.miitmdid.c.f;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bun.supplier.InnerIdSupplier {
    private android.content.Context a;

    public a(android.content.Context context) {
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
