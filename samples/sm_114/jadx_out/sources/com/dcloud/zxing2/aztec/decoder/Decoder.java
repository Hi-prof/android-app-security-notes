package com.dcloud.zxing2.aztec.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Decoder {
    private com.dcloud.zxing2.aztec.AztecDetectorResult ddata;
    private static final java.lang.String[] UPPER_TABLE = {"CTRL_PS", com.taobao.weex.el.parse.Operators.SPACE_STR, "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final java.lang.String[] LOWER_TABLE = {"CTRL_PS", com.taobao.weex.el.parse.Operators.SPACE_STR, "a", "b", "c", "d", "e", "f", "g", "h", com.facebook.common.callercontext.ContextChain.TAG_INFRA, "j", "k", "l", com.taobao.weex.ui.component.WXComponent.PROP_FS_MATCH_PARENT, "n", "o", com.facebook.common.callercontext.ContextChain.TAG_PRODUCT, "q", "r", "s", "t", "u", io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, com.taobao.weex.ui.component.WXComponent.PROP_FS_WRAP_CONTENT, com.taobao.weex.common.Constants.Name.X, com.taobao.weex.common.Constants.Name.Y, "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final java.lang.String[] MIXED_TABLE = {"CTRL_PS", com.taobao.weex.el.parse.Operators.SPACE_STR, "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final java.lang.String[] PUNCT_TABLE = {"", "\r", "\r\n", ". ", ", ", ": ", com.taobao.weex.el.parse.Operators.AND_NOT, io.dcloud.common.util.JSUtil.QUOTE, "#", com.taobao.weex.el.parse.Operators.DOLLAR_STR, "%", "&", "'", com.taobao.weex.el.parse.Operators.BRACKET_START_STR, com.taobao.weex.el.parse.Operators.BRACKET_END_STR, "*", com.taobao.weex.el.parse.Operators.PLUS, ",", com.taobao.weex.el.parse.Operators.SUB, com.taobao.weex.el.parse.Operators.DOT_STR, "/", ":", ";", com.taobao.weex.el.parse.Operators.L, "=", com.taobao.weex.el.parse.Operators.G, com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING, com.taobao.weex.el.parse.Operators.ARRAY_START_STR, com.taobao.weex.el.parse.Operators.ARRAY_END_STR, com.taobao.weex.el.parse.Operators.BLOCK_START_STR, com.taobao.weex.el.parse.Operators.BLOCK_END_STR, "CTRL_UL"};
    private static final java.lang.String[] DIGIT_TABLE = {"CTRL_PS", com.taobao.weex.el.parse.Operators.SPACE_STR, com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT, "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", com.taobao.weex.el.parse.Operators.DOT_STR, "CTRL_UL", "CTRL_US"};

    /* JADX INFO: renamed from: com.dcloud.zxing2.aztec.decoder.Decoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$dcloud$zxing2$aztec$decoder$Decoder$Table;

        static {
            int[] iArr = new int[com.dcloud.zxing2.aztec.decoder.Decoder.Table.values().length];
            $SwitchMap$com$dcloud$zxing2$aztec$decoder$Decoder$Table = iArr;
            try {
                iArr[com.dcloud.zxing2.aztec.decoder.Decoder.Table.UPPER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$aztec$decoder$Decoder$Table[com.dcloud.zxing2.aztec.decoder.Decoder.Table.LOWER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$aztec$decoder$Decoder$Table[com.dcloud.zxing2.aztec.decoder.Decoder.Table.MIXED.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$aztec$decoder$Decoder$Table[com.dcloud.zxing2.aztec.decoder.Decoder.Table.PUNCT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$aztec$decoder$Decoder$Table[com.dcloud.zxing2.aztec.decoder.Decoder.Table.DIGIT.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private boolean[] correctBits(boolean[] zArr) throws com.dcloud.zxing2.FormatException {
        int i;
        com.dcloud.zxing2.common.reedsolomon.GenericGF genericGF;
        if (this.ddata.getNbLayers() <= 2) {
            genericGF = com.dcloud.zxing2.common.reedsolomon.GenericGF.AZTEC_DATA_6;
            i = 6;
        } else {
            i = 8;
            if (this.ddata.getNbLayers() <= 8) {
                genericGF = com.dcloud.zxing2.common.reedsolomon.GenericGF.AZTEC_DATA_8;
            } else if (this.ddata.getNbLayers() <= 22) {
                genericGF = com.dcloud.zxing2.common.reedsolomon.GenericGF.AZTEC_DATA_10;
                i = 10;
            } else {
                genericGF = com.dcloud.zxing2.common.reedsolomon.GenericGF.AZTEC_DATA_12;
                i = 12;
            }
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i;
        if (length < nbDatablocks) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
        int length2 = zArr.length % i;
        int i2 = length - nbDatablocks;
        int[] iArr = new int[length];
        int i3 = 0;
        while (i3 < length) {
            iArr[i3] = readCode(zArr, length2, i);
            i3++;
            length2 += i;
        }
        try {
            new com.dcloud.zxing2.common.reedsolomon.ReedSolomonDecoder(genericGF).decode(iArr, i2);
            int i4 = 1 << i;
            int i5 = i4 - 1;
            int i6 = 0;
            for (int i7 = 0; i7 < nbDatablocks; i7++) {
                int i8 = iArr[i7];
                if (i8 == 0 || i8 == i5) {
                    throw com.dcloud.zxing2.FormatException.getFormatInstance();
                }
                if (i8 == 1 || i8 == i4 - 2) {
                    i6++;
                }
            }
            boolean[] zArr2 = new boolean[(nbDatablocks * i) - i6];
            int i9 = 0;
            for (int i10 = 0; i10 < nbDatablocks; i10++) {
                int i11 = iArr[i10];
                if (i11 == 1 || i11 == i4 - 2) {
                    java.util.Arrays.fill(zArr2, i9, (i9 + i) - 1, i11 > 1);
                    i9 += i - 1;
                } else {
                    int i12 = i - 1;
                    while (i12 >= 0) {
                        int i13 = i9 + 1;
                        zArr2[i9] = ((1 << i12) & i11) != 0;
                        i12--;
                        i9 = i13;
                    }
                }
            }
            return zArr2;
        } catch (com.dcloud.zxing2.common.reedsolomon.ReedSolomonException e) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance(e);
        }
    }

    private static java.lang.String getCharacter(com.dcloud.zxing2.aztec.decoder.Decoder.Table table, int i) {
        int i2 = com.dcloud.zxing2.aztec.decoder.Decoder.AnonymousClass1.$SwitchMap$com$dcloud$zxing2$aztec$decoder$Decoder$Table[table.ordinal()];
        if (i2 == 1) {
            return UPPER_TABLE[i];
        }
        if (i2 == 2) {
            return LOWER_TABLE[i];
        }
        if (i2 == 3) {
            return MIXED_TABLE[i];
        }
        if (i2 == 4) {
            return PUNCT_TABLE[i];
        }
        if (i2 == 5) {
            return DIGIT_TABLE[i];
        }
        throw new java.lang.IllegalStateException("Bad table");
    }

    private static java.lang.String getEncodedData(boolean[] zArr) {
        int length = zArr.length;
        com.dcloud.zxing2.aztec.decoder.Decoder.Table table = com.dcloud.zxing2.aztec.decoder.Decoder.Table.UPPER;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(20);
        com.dcloud.zxing2.aztec.decoder.Decoder.Table table2 = table;
        int i = 0;
        while (i < length) {
            if (table != com.dcloud.zxing2.aztec.decoder.Decoder.Table.BINARY) {
                int i2 = table == com.dcloud.zxing2.aztec.decoder.Decoder.Table.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                int code = readCode(zArr, i, i2);
                i += i2;
                java.lang.String character = getCharacter(table, code);
                if (character.startsWith("CTRL_")) {
                    com.dcloud.zxing2.aztec.decoder.Decoder.Table table3 = getTable(character.charAt(5));
                    if (character.charAt(6) == 'L') {
                        table = table3;
                        table2 = table;
                    } else {
                        table = table3;
                    }
                } else {
                    sb.append(character);
                    table = table2;
                }
            } else {
                if (length - i < 5) {
                    break;
                }
                int code2 = readCode(zArr, i, 5);
                int i3 = i + 5;
                if (code2 == 0) {
                    if (length - i3 < 11) {
                        break;
                    }
                    code2 = readCode(zArr, i3, 11) + 31;
                    i3 = i + 16;
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= code2) {
                        i = i3;
                        break;
                    }
                    if (length - i3 < 8) {
                        i = length;
                        break;
                    }
                    sb.append((char) readCode(zArr, i3, 8));
                    i3 += 8;
                    i4++;
                }
                table = table2;
            }
        }
        return sb.toString();
    }

    private static com.dcloud.zxing2.aztec.decoder.Decoder.Table getTable(char c) {
        if (c == 'B') {
            return com.dcloud.zxing2.aztec.decoder.Decoder.Table.BINARY;
        }
        if (c == 'D') {
            return com.dcloud.zxing2.aztec.decoder.Decoder.Table.DIGIT;
        }
        if (c == 'P') {
            return com.dcloud.zxing2.aztec.decoder.Decoder.Table.PUNCT;
        }
        if (c != 'L') {
            return c != 'M' ? com.dcloud.zxing2.aztec.decoder.Decoder.Table.UPPER : com.dcloud.zxing2.aztec.decoder.Decoder.Table.MIXED;
        }
        return com.dcloud.zxing2.aztec.decoder.Decoder.Table.LOWER;
    }

    public static java.lang.String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static int readCode(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    public com.dcloud.zxing2.common.DecoderResult decode(com.dcloud.zxing2.aztec.AztecDetectorResult aztecDetectorResult) throws com.dcloud.zxing2.FormatException {
        this.ddata = aztecDetectorResult;
        return new com.dcloud.zxing2.common.DecoderResult(null, getEncodedData(correctBits(extractBits(aztecDetectorResult.getBits()))), null, null);
    }

    boolean[] extractBits(com.dcloud.zxing2.common.BitMatrix bitMatrix) {
        boolean zIsCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        int i = nbLayers * 4;
        int i2 = zIsCompact ? i + 11 : i + 14;
        int[] iArr = new int[i2];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, zIsCompact)];
        int i3 = 2;
        if (zIsCompact) {
            for (int i4 = 0; i4 < i2; i4++) {
                iArr[i4] = i4;
            }
        } else {
            int i5 = i2 / 2;
            int i6 = ((i2 + 1) + (((i5 - 1) / 15) * 2)) / 2;
            for (int i7 = 0; i7 < i5; i7++) {
                int i8 = (i7 / 15) + i7;
                iArr[(i5 - i7) - 1] = (i6 - i8) - 1;
                iArr[i5 + i7] = i8 + i6 + 1;
            }
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < nbLayers) {
            int i11 = (nbLayers - i9) * 4;
            int i12 = zIsCompact ? i11 + 9 : i11 + 12;
            int i13 = i9 * 2;
            int i14 = (i2 - 1) - i13;
            int i15 = 0;
            while (i15 < i12) {
                int i16 = i15 * 2;
                int i17 = 0;
                while (i17 < i3) {
                    int i18 = i13 + i17;
                    int i19 = i13 + i15;
                    zArr[i10 + i16 + i17] = bitMatrix.get(iArr[i18], iArr[i19]);
                    int i20 = i14 - i17;
                    zArr[(i12 * 2) + i10 + i16 + i17] = bitMatrix.get(iArr[i19], iArr[i20]);
                    int i21 = iArr[i20];
                    int i22 = i14 - i15;
                    zArr[(i12 * 4) + i10 + i16 + i17] = bitMatrix.get(i21, iArr[i22]);
                    zArr[(i12 * 6) + i10 + i16 + i17] = bitMatrix.get(iArr[i22], iArr[i18]);
                    i17++;
                    i3 = 2;
                }
                i15++;
                i3 = 2;
            }
            i10 += i12 * 8;
            i9++;
            i3 = 2;
        }
        return zArr;
    }
}
