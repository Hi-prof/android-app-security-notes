package com.bun.miitmdid.c.b;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bun.supplier.InnerIdSupplier, com.asus.msa.sdid.IDIDBinderStatusListener {
    private com.bun.supplier.SupplierListener a;
    private com.asus.msa.sdid.SupplementaryDIDManager f;
    private java.lang.String b = "";
    private java.lang.String c = "";
    private java.lang.String d = "";
    private java.lang.String e = "";
    private boolean g = false;
    private boolean h = false;

    public a(android.content.Context context, com.bun.supplier.SupplierListener supplierListener) {
        this.a = supplierListener;
        this.f = new com.asus.msa.sdid.SupplementaryDIDManager(context);
    }

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
    public native void a(com.asus.msa.SupplementaryDID.IDidAidlInterface iDidAidlInterface);

    @Override // com.bun.supplier.InnerIdSupplier
    public native void a(com.bun.supplier.SupplierListener supplierListener);

    @Override // com.bun.supplier.InnerIdSupplier
    public native boolean a();

    @Override // android.os.IInterface
    public native android.os.IBinder asBinder();

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
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
