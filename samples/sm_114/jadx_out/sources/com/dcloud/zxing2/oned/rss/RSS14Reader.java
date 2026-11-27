package com.dcloud.zxing2.oned.rss;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class RSS14Reader extends com.dcloud.zxing2.oned.rss.AbstractRSSReader {
    private final java.util.List<com.dcloud.zxing2.oned.rss.Pair> possibleLeftPairs = new java.util.ArrayList();
    private final java.util.List<com.dcloud.zxing2.oned.rss.Pair> possibleRightPairs = new java.util.ArrayList();
    private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET = {1, 10, 34, 70, 126};
    private static final int[] INSIDE_ODD_TOTAL_SUBSET = {4, 20, 48, 81};
    private static final int[] OUTSIDE_GSUM = {0, 161, 961, 2015, 2715};
    private static final int[] INSIDE_GSUM = {0, 336, 1036, 1516};
    private static final int[] OUTSIDE_ODD_WIDEST = {8, 6, 4, 3, 1};
    private static final int[] INSIDE_ODD_WIDEST = {2, 4, 6, 8};
    private static final int[][] FINDER_PATTERNS = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    private static void addOrTally(java.util.Collection<com.dcloud.zxing2.oned.rss.Pair> collection, com.dcloud.zxing2.oned.rss.Pair pair) {
        if (pair == null) {
            return;
        }
        for (com.dcloud.zxing2.oned.rss.Pair pair2 : collection) {
            if (pair2.getValue() == pair.getValue()) {
                pair2.incrementCount();
                return;
            }
        }
        collection.add(pair);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x004b A[PHI: r7 r8
  0x004b: PHI (r7v5 boolean) = (r7v3 boolean), (r7v12 boolean) binds: [B:32:0x0049, B:19:0x0033] A[DONT_GENERATE, DONT_INLINE]
  0x004b: PHI (r8v3 boolean) = (r8v1 boolean), (r8v10 boolean) binds: [B:32:0x0049, B:19:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:35:0x004f A[PHI: r7 r8
  0x004f: PHI (r7v6 boolean) = (r7v3 boolean), (r7v12 boolean) binds: [B:34:0x004d, B:21:0x0036] A[DONT_GENERATE, DONT_INLINE]
  0x004f: PHI (r8v4 boolean) = (r8v1 boolean), (r8v10 boolean) binds: [B:34:0x004d, B:21:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:36:0x0052 A[PHI: r7 r8
  0x0052: PHI (r7v8 boolean) = (r7v3 boolean), (r7v12 boolean) binds: [B:34:0x004d, B:21:0x0036] A[DONT_GENERATE, DONT_INLINE]
  0x0052: PHI (r8v8 boolean) = (r8v1 boolean), (r8v10 boolean) binds: [B:34:0x004d, B:21:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    private void adjustOddEvenCounts(boolean z, int i) throws com.dcloud.zxing2.NotFoundException {
        boolean z2;
        boolean z3;
        int iCount = com.dcloud.zxing2.oned.rss.AbstractRSSReader.count(getOddCounts());
        int iCount2 = com.dcloud.zxing2.oned.rss.AbstractRSSReader.count(getEvenCounts());
        int i2 = (iCount + iCount2) - i;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = (iCount & 1) == z;
        boolean z7 = (iCount2 & 1) == 1;
        if (z) {
            if (iCount > 12) {
                z5 = false;
                z2 = true;
            } else {
                z5 = iCount < 4;
                z2 = false;
            }
            if (iCount2 > 12) {
                z3 = true;
            } else if (iCount2 < 4) {
                z3 = false;
                z4 = true;
            } else {
                z3 = false;
            }
        } else {
            if (iCount > 11) {
                z5 = false;
                z2 = true;
            } else {
                z5 = iCount < 5;
                z2 = false;
            }
            if (iCount2 > 10) {
                z3 = true;
            } else if (iCount2 < 4) {
                z3 = false;
                z4 = true;
            } else {
                z3 = false;
            }
        }
        if (i2 == 1) {
            if (z6) {
                if (z7) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                z2 = true;
            } else {
                if (!z7) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                z5 = z5;
                z3 = true;
            }
        } else if (i2 == -1) {
            if (z6) {
                if (z7) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
            } else {
                if (!z7) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                z5 = z5;
                z4 = true;
            }
        } else {
            if (i2 != 0) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
            if (z6) {
                if (!z7) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                if (iCount < iCount2) {
                    z3 = true;
                } else {
                    z4 = true;
                    z2 = true;
                }
            } else {
                if (z7) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                z5 = z5;
            }
        }
        if (z5) {
            if (z2) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
            com.dcloud.zxing2.oned.rss.AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z2) {
            com.dcloud.zxing2.oned.rss.AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z4) {
            if (z3) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
            com.dcloud.zxing2.oned.rss.AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z3) {
            com.dcloud.zxing2.oned.rss.AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }

    private static boolean checkChecksum(com.dcloud.zxing2.oned.rss.Pair pair, com.dcloud.zxing2.oned.rss.Pair pair2) {
        int checksumPortion = (pair.getChecksumPortion() + (pair2.getChecksumPortion() * 16)) % 79;
        int value = (pair.getFinderPattern().getValue() * 9) + pair2.getFinderPattern().getValue();
        if (value > 72) {
            value--;
        }
        if (value > 8) {
            value--;
        }
        return checksumPortion == value;
    }

    private static com.dcloud.zxing2.Result constructResult(com.dcloud.zxing2.oned.rss.Pair pair, com.dcloud.zxing2.oned.rss.Pair pair2) {
        java.lang.String strValueOf = java.lang.String.valueOf((((long) pair.getValue()) * 4537077) + ((long) pair2.getValue()));
        java.lang.StringBuilder sb = new java.lang.StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i = 0;
        for (int i2 = 0; i2 < 13; i2++) {
            int iCharAt = sb.charAt(i2) - '0';
            if ((i2 & 1) == 0) {
                iCharAt *= 3;
            }
            i += iCharAt;
        }
        int i3 = 10 - (i % 10);
        if (i3 == 10) {
            i3 = 0;
        }
        sb.append(i3);
        com.dcloud.zxing2.ResultPoint[] resultPoints = pair.getFinderPattern().getResultPoints();
        com.dcloud.zxing2.ResultPoint[] resultPoints2 = pair2.getFinderPattern().getResultPoints();
        return new com.dcloud.zxing2.Result(java.lang.String.valueOf(sb.toString()), null, new com.dcloud.zxing2.ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, com.dcloud.zxing2.BarcodeFormat.RSS_14);
    }

    private com.dcloud.zxing2.oned.rss.DataCharacter decodeDataCharacter(com.dcloud.zxing2.common.BitArray bitArray, com.dcloud.zxing2.oned.rss.FinderPattern finderPattern, boolean z) throws com.dcloud.zxing2.NotFoundException {
        int[] dataCharacterCounters = getDataCharacterCounters();
        dataCharacterCounters[0] = 0;
        dataCharacterCounters[1] = 0;
        dataCharacterCounters[2] = 0;
        dataCharacterCounters[3] = 0;
        dataCharacterCounters[4] = 0;
        dataCharacterCounters[5] = 0;
        dataCharacterCounters[6] = 0;
        dataCharacterCounters[7] = 0;
        if (z) {
            com.dcloud.zxing2.oned.OneDReader.recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            com.dcloud.zxing2.oned.OneDReader.recordPattern(bitArray, finderPattern.getStartEnd()[1] + 1, dataCharacterCounters);
            int i = 0;
            for (int length = dataCharacterCounters.length - 1; i < length; length--) {
                int i2 = dataCharacterCounters[i];
                dataCharacterCounters[i] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i2;
                i++;
            }
        }
        int i3 = z ? 16 : 15;
        float fCount = com.dcloud.zxing2.oned.rss.AbstractRSSReader.count(dataCharacterCounters) / i3;
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i4 = 0; i4 < dataCharacterCounters.length; i4++) {
            float f = dataCharacterCounters[i4] / fCount;
            int i5 = (int) (0.5f + f);
            if (i5 < 1) {
                i5 = 1;
            } else if (i5 > 8) {
                i5 = 8;
            }
            int i6 = i4 / 2;
            if ((i4 & 1) == 0) {
                oddCounts[i6] = i5;
                oddRoundingErrors[i6] = f - i5;
            } else {
                evenCounts[i6] = i5;
                evenRoundingErrors[i6] = f - i5;
            }
        }
        adjustOddEvenCounts(z, i3);
        int i7 = 0;
        int i8 = 0;
        for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
            int i9 = oddCounts[length2];
            i8 = (i8 * 9) + i9;
            i7 += i9;
        }
        int i10 = 0;
        int i11 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            int i12 = evenCounts[length3];
            i10 = (i10 * 9) + i12;
            i11 += i12;
        }
        int i13 = i8 + (i10 * 3);
        if (!z) {
            if ((i11 & 1) != 0 || i11 > 10 || i11 < 4) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
            int i14 = (10 - i11) / 2;
            int i15 = INSIDE_ODD_WIDEST[i14];
            return new com.dcloud.zxing2.oned.rss.DataCharacter((com.dcloud.zxing2.oned.rss.RSSUtils.getRSSvalue(evenCounts, 9 - i15, false) * INSIDE_ODD_TOTAL_SUBSET[i14]) + com.dcloud.zxing2.oned.rss.RSSUtils.getRSSvalue(oddCounts, i15, true) + INSIDE_GSUM[i14], i13);
        }
        if ((i7 & 1) != 0 || i7 > 12 || i7 < 4) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        int i16 = (12 - i7) / 2;
        int i17 = OUTSIDE_ODD_WIDEST[i16];
        return new com.dcloud.zxing2.oned.rss.DataCharacter((com.dcloud.zxing2.oned.rss.RSSUtils.getRSSvalue(oddCounts, i17, false) * OUTSIDE_EVEN_TOTAL_SUBSET[i16]) + com.dcloud.zxing2.oned.rss.RSSUtils.getRSSvalue(evenCounts, 9 - i17, true) + OUTSIDE_GSUM[i16], i13);
    }

    private com.dcloud.zxing2.oned.rss.Pair decodePair(com.dcloud.zxing2.common.BitArray bitArray, boolean z, int i, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) {
        try {
            int[] iArrFindFinderPattern = findFinderPattern(bitArray, 0, z);
            com.dcloud.zxing2.oned.rss.FinderPattern foundFinderPattern = parseFoundFinderPattern(bitArray, i, z, iArrFindFinderPattern);
            com.dcloud.zxing2.ResultPointCallback resultPointCallback = map == null ? null : (com.dcloud.zxing2.ResultPointCallback) map.get(com.dcloud.zxing2.DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (resultPointCallback != null) {
                float size = (iArrFindFinderPattern[0] + iArrFindFinderPattern[1]) / 2.0f;
                if (z) {
                    size = (bitArray.getSize() - 1) - size;
                }
                resultPointCallback.foundPossibleResultPoint(new com.dcloud.zxing2.ResultPoint(size, i));
            }
            com.dcloud.zxing2.oned.rss.DataCharacter dataCharacterDecodeDataCharacter = decodeDataCharacter(bitArray, foundFinderPattern, true);
            com.dcloud.zxing2.oned.rss.DataCharacter dataCharacterDecodeDataCharacter2 = decodeDataCharacter(bitArray, foundFinderPattern, false);
            return new com.dcloud.zxing2.oned.rss.Pair((dataCharacterDecodeDataCharacter.getValue() * 1597) + dataCharacterDecodeDataCharacter2.getValue(), dataCharacterDecodeDataCharacter.getChecksumPortion() + (dataCharacterDecodeDataCharacter2.getChecksumPortion() * 4), foundFinderPattern);
        } catch (com.dcloud.zxing2.NotFoundException unused) {
            return null;
        }
    }

    private int[] findFinderPattern(com.dcloud.zxing2.common.BitArray bitArray, int i, boolean z) throws com.dcloud.zxing2.NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        boolean z2 = false;
        while (i < size) {
            z2 = !bitArray.get(i);
            if (z == z2) {
                break;
            }
            i++;
        }
        int i2 = i;
        int i3 = 0;
        while (i < size) {
            if (bitArray.get(i) ^ z2) {
                decodeFinderCounters[i3] = decodeFinderCounters[i3] + 1;
            } else {
                if (i3 != 3) {
                    i3++;
                } else {
                    if (com.dcloud.zxing2.oned.rss.AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        return new int[]{i2, i};
                    }
                    i2 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i3--;
                }
                decodeFinderCounters[i3] = 1;
                z2 = !z2;
            }
            i++;
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    private com.dcloud.zxing2.oned.rss.FinderPattern parseFoundFinderPattern(com.dcloud.zxing2.common.BitArray bitArray, int i, boolean z, int[] iArr) throws com.dcloud.zxing2.NotFoundException {
        int i2;
        boolean z2 = bitArray.get(iArr[0]);
        int i3 = iArr[0] - 1;
        while (i3 >= 0 && (bitArray.get(i3) ^ z2)) {
            i3--;
        }
        int i4 = i3 + 1;
        int i5 = iArr[0] - i4;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        java.lang.System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i5;
        int finderValue = com.dcloud.zxing2.oned.rss.AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS);
        int size = iArr[1];
        if (z) {
            int size2 = (bitArray.getSize() - 1) - i4;
            size = (bitArray.getSize() - 1) - size;
            i2 = size2;
        } else {
            i2 = i4;
        }
        return new com.dcloud.zxing2.oned.rss.FinderPattern(finderValue, new int[]{i4, iArr[1]}, i2, size, i);
    }

    @Override // com.dcloud.zxing2.oned.OneDReader
    public com.dcloud.zxing2.Result decodeRow(int i, com.dcloud.zxing2.common.BitArray bitArray, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.NotFoundException {
        addOrTally(this.possibleLeftPairs, decodePair(bitArray, false, i, map));
        bitArray.reverse();
        addOrTally(this.possibleRightPairs, decodePair(bitArray, true, i, map));
        bitArray.reverse();
        int size = this.possibleLeftPairs.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.dcloud.zxing2.oned.rss.Pair pair = this.possibleLeftPairs.get(i2);
            if (pair.getCount() > 1) {
                int size2 = this.possibleRightPairs.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    com.dcloud.zxing2.oned.rss.Pair pair2 = this.possibleRightPairs.get(i3);
                    if (pair2.getCount() > 1 && checkChecksum(pair, pair2)) {
                        return constructResult(pair, pair2);
                    }
                }
            }
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    @Override // com.dcloud.zxing2.oned.OneDReader, com.dcloud.zxing2.Reader
    public void reset() {
        this.possibleLeftPairs.clear();
        this.possibleRightPairs.clear();
    }
}
