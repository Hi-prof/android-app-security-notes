package com.bun.miitmdid.supplier.msa;

/* JADX INFO: loaded from: classes.dex */
public class a extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Boolean> {
    public com.bun.lib.c a;
    public com.bun.miitmdid.c.e.a b;

    public a(com.bun.lib.c cVar, com.bun.miitmdid.c.e.a aVar) {
        this.a = cVar;
        this.b = aVar;
    }

    protected native java.lang.Boolean a(java.lang.Void... voidArr);

    protected native void a(java.lang.Boolean bool);

    @Override // android.os.AsyncTask
    protected native /* bridge */ /* synthetic */ java.lang.Boolean doInBackground(java.lang.Void[] voidArr);

    @Override // android.os.AsyncTask
    protected native /* bridge */ /* synthetic */ void onPostExecute(java.lang.Boolean bool);
}
