package com.dcloud.zxing2.oned.rss;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DataCharacter {
    private final int checksumPortion;
    private final int value;

    public DataCharacter(int i, int i2) {
        this.value = i;
        this.checksumPortion = i2;
    }

    public final boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.dcloud.zxing2.oned.rss.DataCharacter)) {
            return false;
        }
        com.dcloud.zxing2.oned.rss.DataCharacter dataCharacter = (com.dcloud.zxing2.oned.rss.DataCharacter) obj;
        return this.value == dataCharacter.value && this.checksumPortion == dataCharacter.checksumPortion;
    }

    public final int getChecksumPortion() {
        return this.checksumPortion;
    }

    public final int getValue() {
        return this.value;
    }

    public final int hashCode() {
        return this.value ^ this.checksumPortion;
    }

    public final java.lang.String toString() {
        return this.value + com.taobao.weex.el.parse.Operators.BRACKET_START_STR + this.checksumPortion + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }
}
