package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Options extends java.util.AbstractList<dc.squareup.okio.ByteString> implements java.util.RandomAccess {
    final dc.squareup.okio.ByteString[] byteStrings;
    final int[] trie;

    private Options(dc.squareup.okio.ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    private static void buildTrieRecursive(long j, dc.squareup.okio.Buffer buffer, int i, java.util.List<dc.squareup.okio.ByteString> list, int i2, int i3, java.util.List<java.lang.Integer> list2) {
        int i4;
        int i5;
        long j2;
        int i6;
        java.util.List<java.lang.Integer> list3;
        long j3;
        int i7;
        java.util.List<dc.squareup.okio.ByteString> list4 = list;
        java.util.List<java.lang.Integer> list5 = list2;
        if (i2 >= i3) {
            throw new java.lang.AssertionError();
        }
        for (int i8 = i2; i8 < i3; i8++) {
            if (list4.get(i8).size() < i) {
                throw new java.lang.AssertionError();
            }
        }
        dc.squareup.okio.ByteString byteString = list.get(i2);
        dc.squareup.okio.ByteString byteString2 = list4.get(i3 - 1);
        if (i == byteString.size()) {
            int iIntValue = list5.get(i2).intValue();
            int i9 = i2 + 1;
            dc.squareup.okio.ByteString byteString3 = list4.get(i9);
            i4 = i9;
            i5 = iIntValue;
            byteString = byteString3;
        } else {
            i4 = i2;
            i5 = -1;
        }
        long j4 = 2;
        if (byteString.getByte(i) == byteString2.getByte(i)) {
            int iMin = java.lang.Math.min(byteString.size(), byteString2.size());
            int i10 = 0;
            int i11 = i;
            while (true) {
                if (i11 >= iMin) {
                    j2 = j4;
                    break;
                }
                j2 = j4;
                if (byteString.getByte(i11) != byteString2.getByte(i11)) {
                    break;
                }
                i10++;
                i11++;
                j4 = j2;
            }
            long jIntCount = j + ((long) intCount(buffer)) + j2 + ((long) i10) + 1;
            buffer.writeInt(-i10);
            buffer.writeInt(i5);
            int i12 = i;
            while (true) {
                i6 = i + i10;
                if (i12 >= i6) {
                    break;
                }
                buffer.writeInt(byteString.getByte(i12) & 255);
                i12++;
            }
            if (i4 + 1 == i3) {
                if (i6 != list4.get(i4).size()) {
                    throw new java.lang.AssertionError();
                }
                buffer.writeInt(list5.get(i4).intValue());
                return;
            } else {
                dc.squareup.okio.Buffer buffer2 = new dc.squareup.okio.Buffer();
                buffer.writeInt((int) ((((long) intCount(buffer2)) + jIntCount) * (-1)));
                buildTrieRecursive(jIntCount, buffer2, i6, list4, i4, i3, list5);
                buffer.write(buffer2, buffer2.size());
                return;
            }
        }
        int i13 = 1;
        for (int i14 = i4 + 1; i14 < i3; i14++) {
            if (list4.get(i14 - 1).getByte(i) != list4.get(i14).getByte(i)) {
                i13++;
            }
        }
        long jIntCount2 = j + ((long) intCount(buffer)) + 2 + ((long) (i13 * 2));
        buffer.writeInt(i13);
        buffer.writeInt(i5);
        for (int i15 = i4; i15 < i3; i15++) {
            byte b = list4.get(i15).getByte(i);
            if (i15 == i4 || b != list4.get(i15 - 1).getByte(i)) {
                buffer.writeInt(b & 255);
            }
        }
        dc.squareup.okio.Buffer buffer3 = new dc.squareup.okio.Buffer();
        int i16 = i4;
        while (i16 < i3) {
            byte b2 = list4.get(i16).getByte(i);
            int i17 = i16 + 1;
            int i18 = i17;
            while (true) {
                if (i18 >= i3) {
                    i18 = i3;
                    break;
                } else if (b2 != list4.get(i18).getByte(i)) {
                    break;
                } else {
                    i18++;
                }
            }
            if (i17 == i18 && i + 1 == list4.get(i16).size()) {
                buffer.writeInt(list5.get(i16).intValue());
                list3 = list5;
                j3 = jIntCount2;
                i7 = i18;
            } else {
                buffer.writeInt((int) ((((long) intCount(buffer3)) + jIntCount2) * (-1)));
                list3 = list5;
                j3 = jIntCount2;
                i7 = i18;
                buildTrieRecursive(j3, buffer3, i + 1, list, i16, i7, list3);
                list4 = list;
            }
            jIntCount2 = j3;
            i16 = i7;
            list5 = list3;
        }
        buffer.write(buffer3, buffer3.size());
    }

    private static int intCount(dc.squareup.okio.Buffer buffer) {
        return (int) (buffer.size() / 4);
    }

    public static dc.squareup.okio.Options of(dc.squareup.okio.ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new dc.squareup.okio.Options(new dc.squareup.okio.ByteString[0], new int[]{0, -1});
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
        if (((dc.squareup.okio.ByteString) arrayList.get(0)).size() == 0) {
            throw new java.lang.IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            dc.squareup.okio.ByteString byteString = (dc.squareup.okio.ByteString) arrayList.get(i3);
            int i4 = i3 + 1;
            int i5 = i4;
            while (i5 < arrayList.size()) {
                dc.squareup.okio.ByteString byteString2 = (dc.squareup.okio.ByteString) arrayList.get(i5);
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
        dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
        buildTrieRecursive(0L, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
        int iIntCount = intCount(buffer);
        int[] iArr = new int[iIntCount];
        for (int i6 = 0; i6 < iIntCount; i6++) {
            iArr[i6] = buffer.readInt();
        }
        if (buffer.exhausted()) {
            return new dc.squareup.okio.Options((dc.squareup.okio.ByteString[]) byteStringArr.clone(), iArr);
        }
        throw new java.lang.AssertionError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.byteStrings.length;
    }

    @Override // java.util.AbstractList, java.util.List
    public dc.squareup.okio.ByteString get(int i) {
        return this.byteStrings[i];
    }
}
