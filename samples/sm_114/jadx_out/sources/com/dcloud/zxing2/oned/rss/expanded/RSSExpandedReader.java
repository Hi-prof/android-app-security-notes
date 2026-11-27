package com.dcloud.zxing2.oned.rss.expanded;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class RSSExpandedReader extends com.dcloud.zxing2.oned.rss.AbstractRSSReader {
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int MAX_PAIRS = 11;
    private final java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> pairs = new java.util.ArrayList(11);
    private final java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedRow> rows = new java.util.ArrayList();
    private final int[] startEnd = new int[2];
    private boolean startFromEven;
    private static final int[] SYMBOL_WIDEST = {7, 5, 4, 3, 1};
    private static final int[] EVEN_TOTAL_SUBSET = {4, 20, 52, androidx.core.location.LocationRequestCompat.QUALITY_LOW_POWER, 204};
    private static final int[] GSUM = {0, 348, 1388, 2948, 3988};
    private static final int[][] FINDER_PATTERNS = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] WEIGHTS = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, org.mozilla.universalchardet.prober.contextanalysis.EUCJPContextAnalysis.SINGLE_SHIFT_3, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{com.alibaba.fastjson.asm.Opcodes.INSTANCEOF, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, com.alibaba.fastjson.asm.Opcodes.RET, 85, 44, 132}, new int[]{com.alibaba.fastjson.asm.Opcodes.INVOKEINTERFACE, 133, com.alibaba.fastjson.asm.Opcodes.NEWARRAY, org.mozilla.universalchardet.prober.contextanalysis.EUCJPContextAnalysis.SINGLE_SHIFT_2, 4, 12, 36, androidx.appcompat.app.AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, com.alibaba.fastjson.asm.Opcodes.IFLE, 52, 156}, new int[]{46, 138, 203, com.alibaba.fastjson.asm.Opcodes.NEW, 139, 206, org.mozilla.universalchardet.prober.distributionanalysis.EUCTWDistributionAnalysis.HIGHBYTE_BEGIN, com.alibaba.fastjson.asm.Opcodes.IF_ACMPNE}, new int[]{76, 17, 51, com.alibaba.fastjson.asm.Opcodes.IFEQ, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_10, 119, 146}, new int[]{16, 48, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 10, 30, 90, 59, com.alibaba.fastjson.asm.Opcodes.RETURN}, new int[]{androidx.appcompat.app.AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 116, 137, 200, com.alibaba.fastjson.asm.Opcodes.GETSTATIC, 112, 125, 164}, new int[]{70, 210, com.facebook.imageutils.JfifUtil.MARKER_RST0, 202, com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, org.mozilla.universalchardet.prober.contextanalysis.SJISContextAnalysis.HIRAGANA_HIGHBYTE, 179, 115}, new int[]{134, 191, com.alibaba.fastjson.asm.Opcodes.DCMPL, 31, 93, 68, 204, 190}, new int[]{com.alibaba.fastjson.asm.Opcodes.LCMP, 22, 66, com.alibaba.fastjson.asm.Opcodes.IFNULL, 172, 94, 71, 2}, new int[]{6, 18, 54, com.alibaba.fastjson.asm.Opcodes.IF_ICMPGE, 64, 192, com.alibaba.fastjson.asm.Opcodes.IFNE, 40}, new int[]{120, com.alibaba.fastjson.asm.Opcodes.FCMPL, 25, 75, 14, 42, 126, com.alibaba.fastjson.asm.Opcodes.GOTO}, new int[]{79, 26, 78, 23, 69, 207, com.alibaba.fastjson.asm.Opcodes.IFNONNULL, 175}, new int[]{103, 98, 83, 38, uni.app.UNIGF0182AE.BuildConfig.VERSION_CODE, 131, com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, 124}, new int[]{161, 61, com.alibaba.fastjson.asm.Opcodes.INVOKESPECIAL, kotlinx.coroutines.scheduling.WorkQueueKt.MASK, 170, 88, 53, 159}, new int[]{55, com.alibaba.fastjson.asm.Opcodes.IF_ACMPEQ, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, com.alibaba.fastjson.asm.Opcodes.IF_ICMPNE, 58, 174, 100, 89}};
    private static final int[][] FINDER_PATTERN_SEQUENCES = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    private void adjustOddEvenCounts(int i) throws com.dcloud.zxing2.NotFoundException {
        boolean z;
        boolean z2;
        int iCount = com.dcloud.zxing2.oned.rss.AbstractRSSReader.count(getOddCounts());
        int iCount2 = com.dcloud.zxing2.oned.rss.AbstractRSSReader.count(getEvenCounts());
        int i2 = (iCount + iCount2) - i;
        boolean z3 = false;
        boolean z4 = true;
        boolean z5 = (iCount & 1) == 1;
        boolean z6 = (iCount2 & 1) == 0;
        if (iCount > 13) {
            z4 = false;
            z = true;
        } else {
            z4 = iCount < 4;
            z = false;
        }
        if (iCount2 > 13) {
            z2 = true;
        } else {
            z3 = iCount2 < 4;
            z2 = false;
        }
        if (i2 == 1) {
            if (z5) {
                if (z6) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                z = true;
            } else {
                if (!z6) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                z4 = z4;
                z2 = true;
            }
        } else if (i2 == -1) {
            if (z5) {
                if (z6) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
            } else {
                if (!z6) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                z4 = z4;
                z3 = true;
            }
        } else {
            if (i2 != 0) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
            if (z5) {
                if (!z6) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                if (iCount < iCount2) {
                    z2 = true;
                } else {
                    z3 = true;
                    z = true;
                }
            } else {
                if (z6) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                z4 = z4;
            }
        }
        if (z4) {
            if (z) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
            com.dcloud.zxing2.oned.rss.AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z) {
            com.dcloud.zxing2.oned.rss.AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z3) {
            if (z2) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
            com.dcloud.zxing2.oned.rss.AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z2) {
            com.dcloud.zxing2.oned.rss.AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }

    private boolean checkChecksum() {
        com.dcloud.zxing2.oned.rss.expanded.ExpandedPair expandedPair = this.pairs.get(0);
        com.dcloud.zxing2.oned.rss.DataCharacter leftChar = expandedPair.getLeftChar();
        com.dcloud.zxing2.oned.rss.DataCharacter rightChar = expandedPair.getRightChar();
        if (rightChar == null) {
            return false;
        }
        int checksumPortion = rightChar.getChecksumPortion();
        int i = 2;
        for (int i2 = 1; i2 < this.pairs.size(); i2++) {
            com.dcloud.zxing2.oned.rss.expanded.ExpandedPair expandedPair2 = this.pairs.get(i2);
            checksumPortion += expandedPair2.getLeftChar().getChecksumPortion();
            int i3 = i + 1;
            com.dcloud.zxing2.oned.rss.DataCharacter rightChar2 = expandedPair2.getRightChar();
            if (rightChar2 != null) {
                checksumPortion += rightChar2.getChecksumPortion();
                i += 2;
            } else {
                i = i3;
            }
        }
        return ((i + (-4)) * 211) + (checksumPortion % 211) == leftChar.getValue();
    }

    private java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> checkRows(boolean z) {
        java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> listCheckRows = null;
        if (this.rows.size() > 25) {
            this.rows.clear();
            return null;
        }
        this.pairs.clear();
        if (z) {
            java.util.Collections.reverse(this.rows);
        }
        try {
            listCheckRows = checkRows(new java.util.ArrayList(), 0);
        } catch (com.dcloud.zxing2.NotFoundException unused) {
        }
        if (z) {
            java.util.Collections.reverse(this.rows);
        }
        return listCheckRows;
    }

    static com.dcloud.zxing2.Result constructResult(java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> list) throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        java.lang.String information = com.dcloud.zxing2.oned.rss.expanded.decoders.AbstractExpandedDecoder.createDecoder(com.dcloud.zxing2.oned.rss.expanded.BitArrayBuilder.buildBitArray(list)).parseInformation();
        com.dcloud.zxing2.ResultPoint[] resultPoints = list.get(0).getFinderPattern().getResultPoints();
        com.dcloud.zxing2.ResultPoint[] resultPoints2 = list.get(list.size() - 1).getFinderPattern().getResultPoints();
        return new com.dcloud.zxing2.Result(information, null, new com.dcloud.zxing2.ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, com.dcloud.zxing2.BarcodeFormat.RSS_EXPANDED);
    }

    private void findNextPair(com.dcloud.zxing2.common.BitArray bitArray, java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> list, int i) throws com.dcloud.zxing2.NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        if (i < 0) {
            i = list.isEmpty() ? 0 : list.get(list.size() - 1).getFinderPattern().getStartEnd()[1];
        }
        boolean z = list.size() % 2 != 0;
        if (this.startFromEven) {
            z = !z;
        }
        boolean z2 = false;
        while (i < size) {
            boolean z3 = bitArray.get(i);
            boolean z4 = !z3;
            if (z3) {
                z2 = z4;
                break;
            } else {
                i++;
                z2 = z4;
            }
        }
        boolean z5 = z2;
        int i2 = 0;
        int i3 = i;
        while (i < size) {
            if (bitArray.get(i) ^ z5) {
                decodeFinderCounters[i2] = decodeFinderCounters[i2] + 1;
            } else {
                if (i2 == 3) {
                    if (z) {
                        reverseCounters(decodeFinderCounters);
                    }
                    if (com.dcloud.zxing2.oned.rss.AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        int[] iArr = this.startEnd;
                        iArr[0] = i3;
                        iArr[1] = i;
                        return;
                    }
                    if (z) {
                        reverseCounters(decodeFinderCounters);
                    }
                    i3 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i2--;
                } else {
                    i2++;
                }
                decodeFinderCounters[i2] = 1;
                z5 = !z5;
            }
            i++;
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    private static int getNextSecondBar(com.dcloud.zxing2.common.BitArray bitArray, int i) {
        return bitArray.get(i) ? bitArray.getNextSet(bitArray.getNextUnset(i)) : bitArray.getNextUnset(bitArray.getNextSet(i));
    }

    private static boolean isNotA1left(com.dcloud.zxing2.oned.rss.FinderPattern finderPattern, boolean z, boolean z2) {
        return (finderPattern.getValue() == 0 && z && z2) ? false : true;
    }

    private static boolean isPartialRow(java.lang.Iterable<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> iterable, java.lang.Iterable<com.dcloud.zxing2.oned.rss.expanded.ExpandedRow> iterable2) {
        for (com.dcloud.zxing2.oned.rss.expanded.ExpandedRow expandedRow : iterable2) {
            for (com.dcloud.zxing2.oned.rss.expanded.ExpandedPair expandedPair : iterable) {
                java.util.Iterator<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> it = expandedRow.getPairs().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (expandedPair.equals(it.next())) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static boolean isValidSequence(java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> list) {
        for (int[] iArr : FINDER_PATTERN_SEQUENCES) {
            if (list.size() <= iArr.length) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getFinderPattern().getValue() == iArr[i]) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    private com.dcloud.zxing2.oned.rss.FinderPattern parseFoundFinderPattern(com.dcloud.zxing2.common.BitArray bitArray, int i, boolean z) {
        int nextUnset;
        int i2;
        int i3;
        if (z) {
            int i4 = this.startEnd[0] - 1;
            while (i4 >= 0 && !bitArray.get(i4)) {
                i4--;
            }
            int i5 = i4 + 1;
            int[] iArr = this.startEnd;
            i3 = iArr[0] - i5;
            nextUnset = iArr[1];
            i2 = i5;
        } else {
            int[] iArr2 = this.startEnd;
            int i6 = iArr2[0];
            nextUnset = bitArray.getNextUnset(iArr2[1] + 1);
            i2 = i6;
            i3 = nextUnset - this.startEnd[1];
        }
        int i7 = nextUnset;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        java.lang.System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i3;
        try {
            return new com.dcloud.zxing2.oned.rss.FinderPattern(com.dcloud.zxing2.oned.rss.AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i2, i7}, i2, i7, i);
        } catch (com.dcloud.zxing2.NotFoundException unused) {
            return null;
        }
    }

    private static void removePartialRows(java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> list, java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedRow> list2) {
        java.util.Iterator<com.dcloud.zxing2.oned.rss.expanded.ExpandedRow> it = list2.iterator();
        while (it.hasNext()) {
            com.dcloud.zxing2.oned.rss.expanded.ExpandedRow next = it.next();
            if (next.getPairs().size() != list.size()) {
                java.util.Iterator<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> it2 = next.getPairs().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        it.remove();
                        break;
                    }
                    com.dcloud.zxing2.oned.rss.expanded.ExpandedPair next2 = it2.next();
                    java.util.Iterator<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> it3 = list.iterator();
                    do {
                        if (!it3.hasNext()) {
                            break;
                        }
                    } while (!next2.equals(it3.next()));
                }
            }
        }
    }

    private static void reverseCounters(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    private void storeRow(int i, boolean z) {
        boolean zIsEquivalent = false;
        int i2 = 0;
        boolean zIsEquivalent2 = false;
        while (i2 < this.rows.size()) {
            com.dcloud.zxing2.oned.rss.expanded.ExpandedRow expandedRow = this.rows.get(i2);
            if (expandedRow.getRowNumber() > i) {
                zIsEquivalent = expandedRow.isEquivalent(this.pairs);
                break;
            } else {
                zIsEquivalent2 = expandedRow.isEquivalent(this.pairs);
                i2++;
            }
        }
        if (zIsEquivalent || zIsEquivalent2 || isPartialRow(this.pairs, this.rows)) {
            return;
        }
        this.rows.add(i2, new com.dcloud.zxing2.oned.rss.expanded.ExpandedRow(this.pairs, i, z));
        removePartialRows(this.pairs, this.rows);
    }

    com.dcloud.zxing2.oned.rss.DataCharacter decodeDataCharacter(com.dcloud.zxing2.common.BitArray bitArray, com.dcloud.zxing2.oned.rss.FinderPattern finderPattern, boolean z, boolean z2) throws com.dcloud.zxing2.NotFoundException {
        int[] dataCharacterCounters = getDataCharacterCounters();
        dataCharacterCounters[0] = 0;
        dataCharacterCounters[1] = 0;
        dataCharacterCounters[2] = 0;
        dataCharacterCounters[3] = 0;
        dataCharacterCounters[4] = 0;
        dataCharacterCounters[5] = 0;
        dataCharacterCounters[6] = 0;
        dataCharacterCounters[7] = 0;
        if (z2) {
            com.dcloud.zxing2.oned.OneDReader.recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            com.dcloud.zxing2.oned.OneDReader.recordPattern(bitArray, finderPattern.getStartEnd()[1], dataCharacterCounters);
            int i = 0;
            for (int length = dataCharacterCounters.length - 1; i < length; length--) {
                int i2 = dataCharacterCounters[i];
                dataCharacterCounters[i] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i2;
                i++;
            }
        }
        float fCount = com.dcloud.zxing2.oned.rss.AbstractRSSReader.count(dataCharacterCounters) / 17;
        float f = (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0]) / 15.0f;
        if (java.lang.Math.abs(fCount - f) / f > 0.3f) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i3 = 0; i3 < dataCharacterCounters.length; i3++) {
            float f2 = (dataCharacterCounters[i3] * 1.0f) / fCount;
            int i4 = (int) (0.5f + f2);
            if (i4 < 1) {
                if (f2 < 0.3f) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                i4 = 1;
            } else if (i4 > 8) {
                if (f2 > 8.7f) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                i4 = 8;
            }
            int i5 = i3 / 2;
            if ((i3 & 1) == 0) {
                oddCounts[i5] = i4;
                oddRoundingErrors[i5] = f2 - i4;
            } else {
                evenCounts[i5] = i4;
                evenRoundingErrors[i5] = f2 - i4;
            }
        }
        adjustOddEvenCounts(17);
        int value = (((finderPattern.getValue() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
        int i6 = 0;
        int i7 = 0;
        for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
            if (isNotA1left(finderPattern, z, z2)) {
                i6 += oddCounts[length2] * WEIGHTS[value][length2 * 2];
            }
            i7 += oddCounts[length2];
        }
        int i8 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            if (isNotA1left(finderPattern, z, z2)) {
                i8 += evenCounts[length3] * WEIGHTS[value][(length3 * 2) + 1];
            }
        }
        int i9 = i6 + i8;
        if ((i7 & 1) != 0 || i7 > 13 || i7 < 4) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        int i10 = (13 - i7) / 2;
        int i11 = SYMBOL_WIDEST[i10];
        return new com.dcloud.zxing2.oned.rss.DataCharacter((com.dcloud.zxing2.oned.rss.RSSUtils.getRSSvalue(oddCounts, i11, true) * EVEN_TOTAL_SUBSET[i10]) + com.dcloud.zxing2.oned.rss.RSSUtils.getRSSvalue(evenCounts, 9 - i11, false) + GSUM[i10], i9);
    }

    @Override // com.dcloud.zxing2.oned.OneDReader
    public com.dcloud.zxing2.Result decodeRow(int i, com.dcloud.zxing2.common.BitArray bitArray, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        this.pairs.clear();
        this.startFromEven = false;
        try {
            return constructResult(decodeRow2pairs(i, bitArray));
        } catch (com.dcloud.zxing2.NotFoundException unused) {
            this.pairs.clear();
            this.startFromEven = true;
            return constructResult(decodeRow2pairs(i, bitArray));
        }
    }

    java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> decodeRow2pairs(int i, com.dcloud.zxing2.common.BitArray bitArray) throws com.dcloud.zxing2.NotFoundException {
        while (true) {
            try {
                this.pairs.add(retrieveNextPair(bitArray, this.pairs, i));
            } catch (com.dcloud.zxing2.NotFoundException e) {
                if (this.pairs.isEmpty()) {
                    throw e;
                }
                if (checkChecksum()) {
                    return this.pairs;
                }
                boolean zIsEmpty = this.rows.isEmpty();
                storeRow(i, false);
                if (!zIsEmpty) {
                    java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> listCheckRows = checkRows(false);
                    if (listCheckRows != null) {
                        return listCheckRows;
                    }
                    java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> listCheckRows2 = checkRows(true);
                    if (listCheckRows2 != null) {
                        return listCheckRows2;
                    }
                }
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
        }
    }

    java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedRow> getRows() {
        return this.rows;
    }

    @Override // com.dcloud.zxing2.oned.OneDReader, com.dcloud.zxing2.Reader
    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }

    com.dcloud.zxing2.oned.rss.expanded.ExpandedPair retrieveNextPair(com.dcloud.zxing2.common.BitArray bitArray, java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> list, int i) throws com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.oned.rss.FinderPattern foundFinderPattern;
        com.dcloud.zxing2.oned.rss.DataCharacter dataCharacterDecodeDataCharacter;
        boolean z = list.size() % 2 == 0;
        if (this.startFromEven) {
            z = !z;
        }
        int nextSecondBar = -1;
        boolean z2 = true;
        do {
            findNextPair(bitArray, list, nextSecondBar);
            foundFinderPattern = parseFoundFinderPattern(bitArray, i, z);
            if (foundFinderPattern == null) {
                nextSecondBar = getNextSecondBar(bitArray, this.startEnd[0]);
            } else {
                z2 = false;
            }
        } while (z2);
        com.dcloud.zxing2.oned.rss.DataCharacter dataCharacterDecodeDataCharacter2 = decodeDataCharacter(bitArray, foundFinderPattern, z, true);
        if (!list.isEmpty() && list.get(list.size() - 1).mustBeLast()) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        try {
            dataCharacterDecodeDataCharacter = decodeDataCharacter(bitArray, foundFinderPattern, z, false);
        } catch (com.dcloud.zxing2.NotFoundException unused) {
            dataCharacterDecodeDataCharacter = null;
        }
        return new com.dcloud.zxing2.oned.rss.expanded.ExpandedPair(dataCharacterDecodeDataCharacter2, dataCharacterDecodeDataCharacter, foundFinderPattern, true);
    }

    private java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> checkRows(java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedRow> list, int i) throws com.dcloud.zxing2.NotFoundException {
        while (i < this.rows.size()) {
            com.dcloud.zxing2.oned.rss.expanded.ExpandedRow expandedRow = this.rows.get(i);
            this.pairs.clear();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.pairs.addAll(list.get(i2).getPairs());
            }
            this.pairs.addAll(expandedRow.getPairs());
            if (isValidSequence(this.pairs)) {
                if (checkChecksum()) {
                    return this.pairs;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                arrayList.addAll(list);
                arrayList.add(expandedRow);
                try {
                    return checkRows(arrayList, i + 1);
                } catch (com.dcloud.zxing2.NotFoundException unused) {
                    continue;
                }
            }
            i++;
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }
}
