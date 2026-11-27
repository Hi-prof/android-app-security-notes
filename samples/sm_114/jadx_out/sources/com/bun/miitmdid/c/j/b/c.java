package com.bun.miitmdid.c.j.b;

/* JADX INFO: loaded from: classes.dex */
public class c extends android.database.ContentObserver {
    private java.lang.String a;
    private int b;
    private com.bun.miitmdid.c.j.b.b c;

    public c(com.bun.miitmdid.c.j.b.b bVar, int i, java.lang.String str) {
        super(null);
        this.c = bVar;
        this.b = i;
        this.a = str;
    }

    @Override // android.database.ContentObserver
    public native void onChange(boolean z);
}
