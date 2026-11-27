package com.bun.miitmdid.supplier.msa;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.bun.supplier.InnerIdSupplier, com.bun.miitmdid.c.e.a {
    public com.bun.supplier.SupplierListener a;
    private com.bun.miitmdid.supplier.msa.MsaClient b;

    public b(android.content.Context context) {
        if (com.bun.miitmdid.supplier.msa.MsaClient.CheckService(context)) {
            java.lang.String strG = com.bun.lib.sysParamters.g();
            if (!android.text.TextUtils.isEmpty(strG)) {
                com.bun.miitmdid.supplier.msa.MsaClient.StartMsaKlService(context, strG);
            }
            this.b = new com.bun.miitmdid.supplier.msa.MsaClient(context, this);
        }
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
