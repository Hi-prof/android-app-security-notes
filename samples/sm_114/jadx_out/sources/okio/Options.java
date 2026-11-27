package okio;

/* JADX INFO: loaded from: classes2.dex */
public final class Options extends java.util.AbstractList<okio.ByteString> implements java.util.RandomAccess {
    final okio.ByteString[] byteStrings;
    final int[] trie;

    private Options(okio.ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public static okio.Options of(okio.ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new okio.Options(new okio.ByteString[0], new int[]{0, -1});
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(byteStringArr));
        java.util.Collections.sort(arrayList);
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(-1);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.set(java.util.Collections.binarySearch(arrayList, byteStringArr[i2]), java.lang.Integer.valueOf(i2));
        }
        if (((okio.ByteString) arrayList.get(0)).size() == 0) {
            throw new java.lang.IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            okio.ByteString byteString = (okio.ByteString) arrayList.get(i3);
            int i4 = i3 + 1;
            int i5 = i4;
            while (i5 < arrayList.size()) {
                okio.ByteString byteString2 = (okio.ByteString) arrayList.get(i5);
                if (!byteString2.startsWith(byteString)) {
                    break;
                }
                if (byteString2.size() == byteString.size()) {
                    throw new java.lang.IllegalArgumentException("duplicate option: " + byteString2);
                }
                if (((java.lang.Integer) arrayList2.get(i5)).intValue() > ((java.lang.Integer) arrayList2.get(i3)).intValue()) {
                    arrayList.remove(i5);
                    arrayList2.remove(i5);
                } else {
                    i5++;
                }
            }
            i3 = i4;
        }
        okio.Buffer buffer = new okio.Buffer();
        buildTrieRecursive(0L, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
        int iIntCount = intCount(buffer);
        int[] iArr = new int[iIntCount];
        for (int i6 = 0; i6 < iIntCount; i6++) {
            iArr[i6] = buffer.readInt();
        }
        if (!buffer.exhausted()) {
            throw new java.lang.AssertionError();
        }
        return new okio.Options((okio.ByteString[]) byteStringArr.clone(), iArr);
    }

    private static void buildTrieRecursive(long j, okio.Buffer buffer, int i, java.util.List<okio.ByteString> list, int i2, int i3, java.util.List<java.lang.Integer> list2) {
        int i4;
        int i5;
        long j2;
        int i6;
        java.util.List<java.lang.Integer> list3;
        long j3;
        int i7;
        java.util.List<okio.ByteString> list4 = list;
        java.util.List<java.lang.Integer> list5 = list2;
        if (i2 >= i3) {
            throw new java.lang.AssertionError();
        }
        for (int i8 = i2; i8 < i3; i8++) {
            if (list4.get(i8).size() < i) {
                throw new java.lang.AssertionError();
            }
        }
        okio.ByteString byteString = list.get(i2);
        okio.ByteString byteString2 = list4.get(i3 - 1);
        if (i == byteString.size()) {
            int iIntValue = list5.get(i2).intValue();
            int i9 = i2 + 1;
            okio.ByteString byteString3 = list4.get(i9);
            i4 = i9;
            i5 = iIntValue;
            byteString = byteString3;
        } else {
            i4 = i2;
            i5 = -1;
        }
        long j4 = 2;
        if (byteString.getByte(i) != byteString2.getByte(i)) {
            int i10 = 1;
            for (int i11 = i4 + 1; i11 < i3; i11++) {
                if (list4.get(i11 - 1).getByte(i) != list4.get(i11).getByte(i)) {
                    i10++;
                }
            }
            long jIntCount = j + ((long) intCount(buffer)) + 2 + ((long) (i10 * 2));
            buffer.writeInt(i10);
            buffer.writeInt(i5);
            for (int i12 = i4; i12 < i3; i12++) {
                byte b = list4.get(i12).getByte(i);
                if (i12 == i4 || b != list4.get(i12 - 1).getByte(i)) {
                    buffer.writeInt(b & 255);
                }
            }
            okio.Buffer buffer2 = new okio.Buffer();
            int i13 = i4;
            while (i13 < i3) {
                byte b2 = list4.get(i13).getByte(i);
                int i14 = i13 + 1;
                int i15 = i14;
                while (true) {
                    if (i15 >= i3) {
                        i15 = i3;
                        break;
                    } else if (b2 != list4.get(i15).getByte(i)) {
                        break;
                    } else {
                        i15++;
                    }
                }
                if (i14 == i15 && i + 1 == list4.get(i13).size()) {
                    buffer.writeInt(list5.get(i13).intValue());
                    list3 = list5;
                    j3 = jIntCount;
                    i7 = i15;
                } else {
                    buffer.writeInt((int) ((((long) intCount(buffer2)) + jIntCount) * (-1)));
                    list3 = list5;
                    j3 = jIntCount;
                    i7 = i15;
                    buildTrieRecursive(j3, buffer2, i + 1, list, i13, i7, list3);
                    list4 = list;
                }
                jIntCount = j3;
                i13 = i7;
                list5 = list3;
            }
            buffer.write(buffer2, buffer2.size());
            return;
        }
        int iMin = java.lang.Math.min(byteString.size(), byteString2.size());
        int i16 = 0;
        int i17 = i;
        while (true) {
            if (i17 >= iMin) {
                j2 = j4;
                break;
            }
            j2 = j4;
            if (byteString.getByte(i17) != byteString2.getByte(i17)) {
                break;
            }
            i16++;
            i17++;
            j4 = j2;
        }
        long jIntCount2 = j + ((long) intCount(buffer)) + j2 + ((long) i16) + 1;
        buffer.writeInt(-i16);
        buffer.writeInt(i5);
        int i18 = i;
        while (true) {
            i6 = i + i16;
            if (i18 >= i6) {
                break;
            }
            buffer.writeInt(byteString.getByte(i18) & 255);
            i18++;
        }
        if (i4 + 1 == i3) {
            if (i6 != list4.get(i4).size()) {
                throw new java.lang.AssertionError();
            }
            buffer.writeInt(list5.get(i4).intValue());
        } else {
            okio.Buffer buffer3 = new okio.Buffer();
            buffer.writeInt((int) ((((long) intCount(buffer3)) + jIntCount2) * (-1)));
            buildTrieRecursive(jIntCount2, buffer3, i6, list4, i4, i3, list5);
            buffer.write(buffer3, buffer3.size());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public okio.ByteString get(int i) {
        return this.byteStrings[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.byteStrings.length;
    }

    private static int intCount(okio.Buffer buffer) {
        return (int) (buffer.size() / 4);
    }
}
