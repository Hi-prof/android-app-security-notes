package kotlin.text;

/* JADX INFO: compiled from: UHexExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\f\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\r\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u000e*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0012\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00132\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0013*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0017\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00182\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001c\u0010\u001b\u001a\u00020\u0018*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u001c\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u001d2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001c\u0010 \u001a\u00020\u001d*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010!¨\u0006\""}, d2 = {"toHexString", "", "Lkotlin/UByteArray;", "format", "Lkotlin/text/HexFormat;", "toHexString-zHuV2wU", "([BLkotlin/text/HexFormat;)Ljava/lang/String;", "startIndex", "", "endIndex", "toHexString-lZCiFrA", "([BIILkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUByteArray", "(Ljava/lang/String;Lkotlin/text/HexFormat;)[B", "Lkotlin/UByte;", "toHexString-ZQbaR00", "(BLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUByte", "(Ljava/lang/String;Lkotlin/text/HexFormat;)B", "Lkotlin/UShort;", "toHexString-r3ox_E0", "(SLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUShort", "(Ljava/lang/String;Lkotlin/text/HexFormat;)S", "Lkotlin/UInt;", "toHexString-8M7LxHw", "(ILkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUInt", "(Ljava/lang/String;Lkotlin/text/HexFormat;)I", "Lkotlin/ULong;", "toHexString-8UJCm-I", "(JLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToULong", "(Ljava/lang/String;Lkotlin/text/HexFormat;)J", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UHexExtensionsKt {
    /* JADX INFO: renamed from: toHexString-zHuV2wU, reason: not valid java name */
    private static final java.lang.String m1921toHexStringzHuV2wU(byte[] toHexString, kotlin.text.HexFormat format) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(toHexString, "$this$toHexString");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.text.HexExtensionsKt.toHexString(toHexString, format);
    }

    /* JADX INFO: renamed from: toHexString-zHuV2wU$default, reason: not valid java name */
    static /* synthetic */ java.lang.String m1922toHexStringzHuV2wU$default(byte[] toHexString, kotlin.text.HexFormat format, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            format = kotlin.text.HexFormat.INSTANCE.getDefault();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(toHexString, "$this$toHexString");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.text.HexExtensionsKt.toHexString(toHexString, format);
    }

    /* JADX INFO: renamed from: toHexString-lZCiFrA$default, reason: not valid java name */
    static /* synthetic */ java.lang.String m1918toHexStringlZCiFrA$default(byte[] toHexString, int i, int i2, kotlin.text.HexFormat format, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = kotlin.UByteArray.m620getSizeimpl(toHexString);
        }
        if ((i3 & 4) != 0) {
            format = kotlin.text.HexFormat.INSTANCE.getDefault();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(toHexString, "$this$toHexString");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.text.HexExtensionsKt.toHexString(toHexString, i, i2, format);
    }

    /* JADX INFO: renamed from: toHexString-lZCiFrA, reason: not valid java name */
    private static final java.lang.String m1917toHexStringlZCiFrA(byte[] toHexString, int i, int i2, kotlin.text.HexFormat format) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(toHexString, "$this$toHexString");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.text.HexExtensionsKt.toHexString(toHexString, i, i2, format);
    }

    static /* synthetic */ byte[] hexToUByteArray$default(java.lang.String str, kotlin.text.HexFormat format, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            format = kotlin.text.HexFormat.INSTANCE.getDefault();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.UByteArray.m614constructorimpl(kotlin.text.HexExtensionsKt.hexToByteArray(str, format));
    }

    private static final byte[] hexToUByteArray(java.lang.String str, kotlin.text.HexFormat format) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.UByteArray.m614constructorimpl(kotlin.text.HexExtensionsKt.hexToByteArray(str, format));
    }

    /* JADX INFO: renamed from: toHexString-ZQbaR00, reason: not valid java name */
    private static final java.lang.String m1915toHexStringZQbaR00(byte b, kotlin.text.HexFormat format) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.text.HexExtensionsKt.toHexString(b, format);
    }

    /* JADX INFO: renamed from: toHexString-ZQbaR00$default, reason: not valid java name */
    static /* synthetic */ java.lang.String m1916toHexStringZQbaR00$default(byte b, kotlin.text.HexFormat format, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            format = kotlin.text.HexFormat.INSTANCE.getDefault();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.text.HexExtensionsKt.toHexString(b, format);
    }

    private static final byte hexToUByte(java.lang.String str, kotlin.text.HexFormat format) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.UByte.m559constructorimpl(kotlin.text.HexExtensionsKt.hexToByte(str, format));
    }

    static /* synthetic */ byte hexToUByte$default(java.lang.String str, kotlin.text.HexFormat format, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            format = kotlin.text.HexFormat.INSTANCE.getDefault();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.UByte.m559constructorimpl(kotlin.text.HexExtensionsKt.hexToByte(str, format));
    }

    /* JADX INFO: renamed from: toHexString-r3ox_E0, reason: not valid java name */
    private static final java.lang.String m1919toHexStringr3ox_E0(short s, kotlin.text.HexFormat format) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.text.HexExtensionsKt.toHexString(s, format);
    }

    /* JADX INFO: renamed from: toHexString-r3ox_E0$default, reason: not valid java name */
    static /* synthetic */ java.lang.String m1920toHexStringr3ox_E0$default(short s, kotlin.text.HexFormat format, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            format = kotlin.text.HexFormat.INSTANCE.getDefault();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.text.HexExtensionsKt.toHexString(s, format);
    }

    private static final short hexToUShort(java.lang.String str, kotlin.text.HexFormat format) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.UShort.m824constructorimpl(kotlin.text.HexExtensionsKt.hexToShort(str, format));
    }

    static /* synthetic */ short hexToUShort$default(java.lang.String str, kotlin.text.HexFormat format, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            format = kotlin.text.HexFormat.INSTANCE.getDefault();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.UShort.m824constructorimpl(kotlin.text.HexExtensionsKt.hexToShort(str, format));
    }

    /* JADX INFO: renamed from: toHexString-8M7LxHw, reason: not valid java name */
    private static final java.lang.String m1911toHexString8M7LxHw(int i, kotlin.text.HexFormat format) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.text.HexExtensionsKt.toHexString(i, format);
    }

    /* JADX INFO: renamed from: toHexString-8M7LxHw$default, reason: not valid java name */
    static /* synthetic */ java.lang.String m1912toHexString8M7LxHw$default(int i, kotlin.text.HexFormat format, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            format = kotlin.text.HexFormat.INSTANCE.getDefault();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.text.HexExtensionsKt.toHexString(i, format);
    }

    private static final int hexToUInt(java.lang.String str, kotlin.text.HexFormat format) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.UInt.m638constructorimpl(kotlin.text.HexExtensionsKt.hexToInt(str, format));
    }

    static /* synthetic */ int hexToUInt$default(java.lang.String str, kotlin.text.HexFormat format, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            format = kotlin.text.HexFormat.INSTANCE.getDefault();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.UInt.m638constructorimpl(kotlin.text.HexExtensionsKt.hexToInt(str, format));
    }

    /* JADX INFO: renamed from: toHexString-8UJCm-I, reason: not valid java name */
    private static final java.lang.String m1913toHexString8UJCmI(long j, kotlin.text.HexFormat format) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.text.HexExtensionsKt.toHexString(j, format);
    }

    /* JADX INFO: renamed from: toHexString-8UJCm-I$default, reason: not valid java name */
    static /* synthetic */ java.lang.String m1914toHexString8UJCmI$default(long j, kotlin.text.HexFormat format, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            format = kotlin.text.HexFormat.INSTANCE.getDefault();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.text.HexExtensionsKt.toHexString(j, format);
    }

    private static final long hexToULong(java.lang.String str, kotlin.text.HexFormat format) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.ULong.m717constructorimpl(kotlin.text.HexExtensionsKt.hexToLong(str, format));
    }

    static /* synthetic */ long hexToULong$default(java.lang.String str, kotlin.text.HexFormat format, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            format = kotlin.text.HexFormat.INSTANCE.getDefault();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(format, "format");
        return kotlin.ULong.m717constructorimpl(kotlin.text.HexExtensionsKt.hexToLong(str, format));
    }
}
