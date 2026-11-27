package com.bun.miitmdid.c;

/* JADX INFO: loaded from: classes.dex */
public enum a {
    UNSUPPORT(-1, "unsupport"),
    HUA_WEI(0, "HUAWEI"),
    XIAOMI(1, "Xiaomi"),
    VIVO(2, "vivo"),
    OPPO(3, "oppo"),
    MOTO(4, "motorola"),
    LENOVO(5, "lenovo"),
    ASUS(6, "asus"),
    SAMSUNG(7, "samsung"),
    MEIZU(8, "meizu"),
    NUBIA(10, "nubia"),
    ZTE(11, "ZTE"),
    ONEPLUS(12, "OnePlus"),
    BLACKSHARK(13, "blackshark"),
    FREEMEOS(30, "freemeos"),
    SSUIOS(31, "ssui");

    private java.lang.String a;

    a(int i, java.lang.String str) {
        this.a = str;
    }

    public static native com.bun.miitmdid.c.a a(java.lang.String str);

    public static native com.bun.miitmdid.c.a valueOf(java.lang.String str);

    public static native com.bun.miitmdid.c.a[] values();
}
