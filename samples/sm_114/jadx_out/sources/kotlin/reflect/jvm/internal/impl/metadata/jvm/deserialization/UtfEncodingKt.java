package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

/* JADX INFO: compiled from: utfEncoding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UtfEncodingKt {
    public static final byte[] stringsToBytes(java.lang.String[] strings) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        int length = 0;
        for (java.lang.String str : strings) {
            length += str.length();
        }
        byte[] bArr = new byte[length];
        int i = 0;
        for (java.lang.String str2 : strings) {
            int length2 = str2.length();
            int i2 = 0;
            while (i2 < length2) {
                bArr[i] = (byte) str2.charAt(i2);
                i2++;
                i++;
            }
        }
        return bArr;
    }
}
