package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class r2 {
    private java.lang.String a;
    private int b;
    private int c;

    public r2(java.lang.String str, int i, int i2) {
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public java.lang.String c() {
        return this.a;
    }

    public boolean d() {
        return android.text.TextUtils.isEmpty(this.a);
    }

    public java.lang.String toString() {
        return "IMGText{text='" + this.a + "', color=" + this.b + com.taobao.weex.el.parse.Operators.BLOCK_END;
    }
}
