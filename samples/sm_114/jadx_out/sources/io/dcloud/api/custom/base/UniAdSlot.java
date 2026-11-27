package io.dcloud.api.custom.base;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class UniAdSlot {
    private java.lang.String a;
    private int b = 0;
    private int c = 0;
    private int d = 3;
    private java.lang.String e;
    private java.lang.String f;

    public int getAdCount() {
        return this.d;
    }

    public java.lang.String getExtra() {
        return this.e;
    }

    public int getHeight() {
        return this.c;
    }

    public java.lang.String getSlotId() {
        return this.a;
    }

    public java.lang.String getUserId() {
        return this.f;
    }

    public int getWidth() {
        return this.b;
    }

    public void setAdCount(int i) {
        this.d = i;
    }

    public void setExtra(java.lang.String str) {
        this.e = str;
    }

    public void setHeight(int i) {
        this.c = i;
    }

    public void setSlotId(java.lang.String str) {
        this.a = str;
    }

    public void setUserId(java.lang.String str) {
        this.f = str;
    }

    public void setWidth(int i) {
        this.b = i;
    }

    public java.lang.String toString() {
        return "UniAdSlot{slotId='" + this.a + "', width=" + this.b + ", height=" + this.c + ", adCount=" + this.d + ", extra='" + this.e + "', userId='" + this.f + "'}";
    }
}
