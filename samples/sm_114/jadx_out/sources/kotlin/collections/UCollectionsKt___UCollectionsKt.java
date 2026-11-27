package kotlin.collections;

/* JADX INFO: compiled from: _UCollections.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0007\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0002\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0002\u0010\b\u001a\u0017\u0010\t\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0007¢\u0006\u0002\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0007¢\u0006\u0002\u0010\u0010\u001a\u0019\u0010\u0011\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0019\u0010\u0011\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0011\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0007¢\u0006\u0004\b\u0017\u0010\u0014\u001a\u0019\u0010\u0011\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0007¢\u0006\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"toUByteArray", "Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "Lkotlin/UInt;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "Lkotlin/ULong;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "Lkotlin/UShort;", "(Ljava/util/Collection;)[S", "sum", "", "sumOfUInt", "(Ljava/lang/Iterable;)I", "sumOfULong", "(Ljava/lang/Iterable;)J", "sumOfUByte", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/UCollectionsKt")
class UCollectionsKt___UCollectionsKt {
    public static final byte[] toUByteArray(java.util.Collection<kotlin.UByte> collection) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] bArrM613constructorimpl = kotlin.UByteArray.m613constructorimpl(collection.size());
        java.util.Iterator<kotlin.UByte> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            kotlin.UByteArray.m624setVurrAj0(bArrM613constructorimpl, i, it.next().getData());
            i++;
        }
        return bArrM613constructorimpl;
    }

    public static final int[] toUIntArray(java.util.Collection<kotlin.UInt> collection) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] iArrM692constructorimpl = kotlin.UIntArray.m692constructorimpl(collection.size());
        java.util.Iterator<kotlin.UInt> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            kotlin.UIntArray.m703setVXSXFK8(iArrM692constructorimpl, i, it.next().getData());
            i++;
        }
        return iArrM692constructorimpl;
    }

    public static final long[] toULongArray(java.util.Collection<kotlin.ULong> collection) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] jArrM771constructorimpl = kotlin.ULongArray.m771constructorimpl(collection.size());
        java.util.Iterator<kotlin.ULong> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            kotlin.ULongArray.m782setk8EXiF4(jArrM771constructorimpl, i, it.next().getData());
            i++;
        }
        return jArrM771constructorimpl;
    }

    public static final short[] toUShortArray(java.util.Collection<kotlin.UShort> collection) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] sArrM876constructorimpl = kotlin.UShortArray.m876constructorimpl(collection.size());
        java.util.Iterator<kotlin.UShort> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            kotlin.UShortArray.m887set01HTLdE(sArrM876constructorimpl, i, it.next().getData());
            i++;
        }
        return sArrM876constructorimpl;
    }

    public static final int sumOfUInt(java.lang.Iterable<kotlin.UInt> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        java.util.Iterator<kotlin.UInt> it = iterable.iterator();
        int iM638constructorimpl = 0;
        while (it.hasNext()) {
            iM638constructorimpl = kotlin.UInt.m638constructorimpl(iM638constructorimpl + it.next().getData());
        }
        return iM638constructorimpl;
    }

    public static final long sumOfULong(java.lang.Iterable<kotlin.ULong> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        java.util.Iterator<kotlin.ULong> it = iterable.iterator();
        long jM717constructorimpl = 0;
        while (it.hasNext()) {
            jM717constructorimpl = kotlin.ULong.m717constructorimpl(jM717constructorimpl + it.next().getData());
        }
        return jM717constructorimpl;
    }

    public static final int sumOfUByte(java.lang.Iterable<kotlin.UByte> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        java.util.Iterator<kotlin.UByte> it = iterable.iterator();
        int iM638constructorimpl = 0;
        while (it.hasNext()) {
            iM638constructorimpl = kotlin.UInt.m638constructorimpl(iM638constructorimpl + kotlin.UInt.m638constructorimpl(it.next().getData() & 255));
        }
        return iM638constructorimpl;
    }

    public static final int sumOfUShort(java.lang.Iterable<kotlin.UShort> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        java.util.Iterator<kotlin.UShort> it = iterable.iterator();
        int iM638constructorimpl = 0;
        while (it.hasNext()) {
            iM638constructorimpl = kotlin.UInt.m638constructorimpl(iM638constructorimpl + kotlin.UInt.m638constructorimpl(it.next().getData() & kotlin.UShort.MAX_VALUE));
        }
        return iM638constructorimpl;
    }
}
