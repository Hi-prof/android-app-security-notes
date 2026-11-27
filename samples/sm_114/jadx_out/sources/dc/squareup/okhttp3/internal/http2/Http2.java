package dc.squareup.okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Http2 {
    static final byte FLAG_ACK = 1;
    static final byte FLAG_COMPRESSED = 32;
    static final byte FLAG_END_HEADERS = 4;
    static final byte FLAG_END_PUSH_PROMISE = 4;
    static final byte FLAG_END_STREAM = 1;
    static final byte FLAG_NONE = 0;
    static final byte FLAG_PADDED = 8;
    static final byte FLAG_PRIORITY = 32;
    static final int INITIAL_MAX_FRAME_SIZE = 16384;
    static final byte TYPE_CONTINUATION = 9;
    static final byte TYPE_DATA = 0;
    static final byte TYPE_GOAWAY = 7;
    static final byte TYPE_HEADERS = 1;
    static final byte TYPE_PING = 6;
    static final byte TYPE_PRIORITY = 2;
    static final byte TYPE_PUSH_PROMISE = 5;
    static final byte TYPE_RST_STREAM = 3;
    static final byte TYPE_SETTINGS = 4;
    static final byte TYPE_WINDOW_UPDATE = 8;
    static final dc.squareup.okio.ByteString CONNECTION_PREFACE = dc.squareup.okio.ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final java.lang.String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final java.lang.String[] FLAGS = new java.lang.String[64];
    static final java.lang.String[] BINARY = new java.lang.String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            java.lang.String[] strArr = BINARY;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = dc.squareup.okhttp3.internal.Util.format("%8s", java.lang.Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        java.lang.String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i3 = iArr[0];
        strArr2[i3 | 8] = strArr2[i3] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr2[i4];
            int i6 = iArr[0];
            java.lang.String[] strArr3 = FLAGS;
            int i7 = i6 | i5;
            strArr3[i7] = strArr3[i6] + '|' + strArr3[i5];
            strArr3[i7 | 8] = strArr3[i6] + '|' + strArr3[i5] + "|PADDED";
        }
        while (true) {
            java.lang.String[] strArr4 = FLAGS;
            if (i >= strArr4.length) {
                return;
            }
            if (strArr4[i] == null) {
                strArr4[i] = BINARY[i];
            }
            i++;
        }
    }

    private Http2() {
    }

    static java.lang.String formatFlags(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (b != 2 && b != 3) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : BINARY[b2];
            }
            if (b != 7 && b != 8) {
                java.lang.String[] strArr = FLAGS;
                java.lang.String str = b2 < strArr.length ? strArr[b2] : BINARY[b2];
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & org.mozilla.universalchardet.prober.HebrewProber.SPACE) == 0) ? str : str.replace("PRIORITY", com.dmcbig.mediapicker.PickerConfig.COMPRESSED);
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return BINARY[b2];
    }

    static java.lang.String frameLog(boolean z, int i, int i2, byte b, byte b2) {
        java.lang.String[] strArr = FRAME_NAMES;
        return dc.squareup.okhttp3.internal.Util.format("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), b < strArr.length ? strArr[b] : dc.squareup.okhttp3.internal.Util.format("0x%02x", java.lang.Byte.valueOf(b)), formatFlags(b, b2));
    }

    static java.lang.IllegalArgumentException illegalArgument(java.lang.String str, java.lang.Object... objArr) {
        throw new java.lang.IllegalArgumentException(dc.squareup.okhttp3.internal.Util.format(str, objArr));
    }

    static java.io.IOException ioException(java.lang.String str, java.lang.Object... objArr) throws java.io.IOException {
        throw new java.io.IOException(dc.squareup.okhttp3.internal.Util.format(str, objArr));
    }
}
