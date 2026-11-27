package kotlin.uuid;

/* JADX INFO: compiled from: Uuid.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a,\u0010\b\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0001\u001a\u0014\u0010\u000e\u001a\u00020\t*\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000fH\u0001\u001a\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u000fH\u0001\u001a\u0019\u0010\u0016\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u0018\u001a\u0019\u0010\u0016\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u0018¨\u0006\u001a"}, d2 = {"uuidFromRandomBytes", "Lkotlin/uuid/Uuid;", "randomBytes", "", "getLongAtCommonImpl", "", "index", "", "formatBytesIntoCommonImpl", "", "dst", "dstOffset", "startIndex", "endIndex", "checkHyphenAt", "", "setLongAtCommonImpl", "value", "uuidParseHexDashCommonImpl", "hexDashString", "uuidParseHexCommonImpl", "hexString", "truncateForErrorMessage", com.taobao.weex.common.Constants.Name.MAX_LENGTH, "truncateForErrorMessage$UuidKt__UuidKt", "maxSize", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/uuid/UuidKt")
class UuidKt__UuidKt extends kotlin.uuid.UuidKt__UuidJVMKt {
    public static final kotlin.uuid.Uuid uuidFromRandomBytes(byte[] randomBytes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(randomBytes, "randomBytes");
        byte b = (byte) (randomBytes[6] & 15);
        randomBytes[6] = b;
        randomBytes[6] = (byte) (b | 64);
        byte b2 = (byte) (randomBytes[8] & 63);
        randomBytes[8] = b2;
        randomBytes[8] = (byte) (b2 | kotlin.jvm.internal.ByteCompanionObject.MIN_VALUE);
        return kotlin.uuid.Uuid.Companion.fromByteArray(randomBytes);
    }

    public static final long getLongAtCommonImpl(byte[] bArr, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (((long) bArr[i + 7]) & 255) | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
    }

    public static final void formatBytesIntoCommonImpl(long j, byte[] dst, int i, int i2, int i3) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dst, "dst");
        int i4 = 7 - i2;
        int i5 = 8 - i3;
        if (i5 > i4) {
            return;
        }
        while (true) {
            int i6 = kotlin.text.HexExtensionsKt.getBYTE_TO_LOWER_CASE_HEX_DIGITS()[(int) ((j >> (i4 << 3)) & 255)];
            int i7 = i + 1;
            dst[i] = (byte) (i6 >> 8);
            i += 2;
            dst[i7] = (byte) i6;
            if (i4 == i5) {
                return;
            } else {
                i4--;
            }
        }
    }

    public static final void checkHyphenAt(java.lang.String str, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.charAt(i) == '-') {
            return;
        }
        throw new java.lang.IllegalArgumentException(("Expected '-' (hyphen) at index " + i + ", but was '" + str.charAt(i) + com.taobao.weex.el.parse.Operators.SINGLE_QUOTE).toString());
    }

    public static final void setLongAtCommonImpl(byte[] bArr, int i, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i2 = 7;
        while (-1 < i2) {
            bArr[i] = (byte) (j >> (i2 << 3));
            i2--;
            i++;
        }
    }

    public static final kotlin.uuid.Uuid uuidParseHexDashCommonImpl(java.lang.String hexDashString) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
        long jHexToLong$default = kotlin.text.HexExtensionsKt.hexToLong$default(hexDashString, 0, 8, null, 4, null);
        kotlin.uuid.UuidKt.checkHyphenAt(hexDashString, 8);
        long jHexToLong$default2 = kotlin.text.HexExtensionsKt.hexToLong$default(hexDashString, 9, 13, null, 4, null);
        kotlin.uuid.UuidKt.checkHyphenAt(hexDashString, 13);
        long jHexToLong$default3 = kotlin.text.HexExtensionsKt.hexToLong$default(hexDashString, 14, 18, null, 4, null);
        kotlin.uuid.UuidKt.checkHyphenAt(hexDashString, 18);
        long jHexToLong$default4 = kotlin.text.HexExtensionsKt.hexToLong$default(hexDashString, 19, 23, null, 4, null);
        kotlin.uuid.UuidKt.checkHyphenAt(hexDashString, 23);
        return kotlin.uuid.Uuid.Companion.fromLongs((jHexToLong$default2 << 16) | (jHexToLong$default << 32) | jHexToLong$default3, (jHexToLong$default4 << 48) | kotlin.text.HexExtensionsKt.hexToLong$default(hexDashString, 24, 36, null, 4, null));
    }

    public static final kotlin.uuid.Uuid uuidParseHexCommonImpl(java.lang.String hexString) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(hexString, "hexString");
        return kotlin.uuid.Uuid.Companion.fromLongs(kotlin.text.HexExtensionsKt.hexToLong$default(hexString, 0, 16, null, 4, null), kotlin.text.HexExtensionsKt.hexToLong$default(hexString, 16, 32, null, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String truncateForErrorMessage$UuidKt__UuidKt(java.lang.String str, int i) {
        if (str.length() <= i) {
            return str;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        kotlin.jvm.internal.Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        java.lang.String strSubstring = str.substring(0, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        sb.append(strSubstring);
        sb.append("...");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String truncateForErrorMessage$UuidKt__UuidKt(byte[] bArr, int i) {
        return kotlin.collections.ArraysKt.joinToString$default(bArr, (java.lang.CharSequence) null, (java.lang.CharSequence) com.taobao.weex.el.parse.Operators.ARRAY_START_STR, (java.lang.CharSequence) com.taobao.weex.el.parse.Operators.ARRAY_END_STR, i, (java.lang.CharSequence) null, (kotlin.jvm.functions.Function1) null, 49, (java.lang.Object) null);
    }
}
