package com.dcloud.zxing2.datamatrix.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class DecodedBitStreamParser {
    private static final char[] C40_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] C40_SHIFT2_SET_CHARS;
    private static final char[] TEXT_BASIC_SET_CHARS;
    private static final char[] TEXT_SHIFT2_SET_CHARS;
    private static final char[] TEXT_SHIFT3_SET_CHARS;

    /* JADX INFO: renamed from: com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$dcloud$zxing2$datamatrix$decoder$DecodedBitStreamParser$Mode;

        static {
            int[] iArr = new int[com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.values().length];
            $SwitchMap$com$dcloud$zxing2$datamatrix$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.C40_ENCODE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$datamatrix$decoder$DecodedBitStreamParser$Mode[com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$datamatrix$decoder$DecodedBitStreamParser$Mode[com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$datamatrix$decoder$DecodedBitStreamParser$Mode[com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$datamatrix$decoder$DecodedBitStreamParser$Mode[com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', com.taobao.weex.utils.WXUtils.PERCENT, kotlin.text.Typography.amp, com.taobao.weex.el.parse.Operators.SINGLE_QUOTE, com.taobao.weex.el.parse.Operators.BRACKET_START, com.taobao.weex.el.parse.Operators.BRACKET_END, '*', '+', com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR, '-', com.taobao.weex.el.parse.Operators.DOT, '/', com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE, ';', kotlin.text.Typography.less, '=', kotlin.text.Typography.greater, com.taobao.weex.el.parse.Operators.CONDITION_IF, com.taobao.weex.ui.component.list.template.TemplateDom.SEPARATOR, com.taobao.weex.el.parse.Operators.ARRAY_START, '\\', com.taobao.weex.el.parse.Operators.ARRAY_END, '^', '_'};
        C40_SHIFT2_SET_CHARS = cArr;
        TEXT_BASIC_SET_CHARS = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        TEXT_SHIFT2_SET_CHARS = cArr;
        TEXT_SHIFT3_SET_CHARS = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', com.taobao.weex.el.parse.Operators.BLOCK_START, '|', com.taobao.weex.el.parse.Operators.BLOCK_END, '~', 127};
    }

    private DecodedBitStreamParser() {
    }

    static com.dcloud.zxing2.common.DecoderResult decode(byte[] bArr) throws com.dcloud.zxing2.FormatException {
        com.dcloud.zxing2.common.BitSource bitSource = new com.dcloud.zxing2.common.BitSource(bArr);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(100);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(0);
        java.util.ArrayList arrayList = new java.util.ArrayList(1);
        com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode modeDecodeAsciiSegment = com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE;
        do {
            com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode mode = com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE;
            if (modeDecodeAsciiSegment == mode) {
                modeDecodeAsciiSegment = decodeAsciiSegment(bitSource, sb, sb2);
            } else {
                int i = com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.AnonymousClass1.$SwitchMap$com$dcloud$zxing2$datamatrix$decoder$DecodedBitStreamParser$Mode[modeDecodeAsciiSegment.ordinal()];
                if (i == 1) {
                    decodeC40Segment(bitSource, sb);
                } else if (i == 2) {
                    decodeTextSegment(bitSource, sb);
                } else if (i == 3) {
                    decodeAnsiX12Segment(bitSource, sb);
                } else if (i == 4) {
                    decodeEdifactSegment(bitSource, sb);
                } else {
                    if (i != 5) {
                        throw com.dcloud.zxing2.FormatException.getFormatInstance();
                    }
                    decodeBase256Segment(bitSource, sb, arrayList);
                }
                modeDecodeAsciiSegment = mode;
            }
            if (modeDecodeAsciiSegment == com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.PAD_ENCODE) {
                break;
            }
        } while (bitSource.available() > 0);
        if (sb2.length() > 0) {
            sb.append((java.lang.CharSequence) sb2);
        }
        java.lang.String string = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new com.dcloud.zxing2.common.DecoderResult(bArr, string, arrayList, null);
    }

    private static void decodeAnsiX12Segment(com.dcloud.zxing2.common.BitSource bitSource, java.lang.StringBuilder sb) throws com.dcloud.zxing2.FormatException {
        int bits;
        int[] iArr = new int[3];
        while (bitSource.available() != 8 && (bits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(bits, bitSource.readBits(8), iArr);
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    sb.append('\r');
                } else if (i2 == 1) {
                    sb.append('*');
                } else if (i2 == 2) {
                    sb.append(kotlin.text.Typography.greater);
                } else if (i2 == 3) {
                    sb.append(' ');
                } else if (i2 < 14) {
                    sb.append((char) (i2 + 44));
                } else {
                    if (i2 >= 40) {
                        throw com.dcloud.zxing2.FormatException.getFormatInstance();
                    }
                    sb.append((char) (i2 + 51));
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode decodeAsciiSegment(com.dcloud.zxing2.common.BitSource bitSource, java.lang.StringBuilder sb, java.lang.StringBuilder sb2) throws com.dcloud.zxing2.FormatException {
        boolean z = false;
        do {
            int bits = bitSource.readBits(8);
            if (bits == 0) {
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
            }
            if (bits <= 128) {
                if (z) {
                    bits += 128;
                }
                sb.append((char) (bits - 1));
                return com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE;
            }
            if (bits == 129) {
                return com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.PAD_ENCODE;
            }
            if (bits <= 229) {
                int i = bits - 130;
                if (i < 10) {
                    sb.append('0');
                }
                sb.append(i);
            } else {
                if (bits == 230) {
                    return com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.C40_ENCODE;
                }
                if (bits == 231) {
                    return com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.BASE256_ENCODE;
                }
                if (bits == 232) {
                    sb.append((char) 29);
                } else if (bits != 233 && bits != 234) {
                    if (bits == 235) {
                        z = true;
                    } else if (bits == 236) {
                        sb.append("[)>\u001e05\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else if (bits == 237) {
                        sb.append("[)>\u001e06\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else {
                        if (bits == 238) {
                            return com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.ANSIX12_ENCODE;
                        }
                        if (bits == 239) {
                            return com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.TEXT_ENCODE;
                        }
                        if (bits == 240) {
                            return com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.EDIFACT_ENCODE;
                        }
                        if (bits != 241 && bits >= 242 && (bits != 254 || bitSource.available() != 0)) {
                            throw com.dcloud.zxing2.FormatException.getFormatInstance();
                        }
                    }
                }
            }
        } while (bitSource.available() > 0);
        return com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE;
    }

    private static void decodeBase256Segment(com.dcloud.zxing2.common.BitSource bitSource, java.lang.StringBuilder sb, java.util.Collection<byte[]> collection) throws com.dcloud.zxing2.FormatException {
        int byteOffset = bitSource.getByteOffset();
        int i = byteOffset + 2;
        int iUnrandomize255State = unrandomize255State(bitSource.readBits(8), byteOffset + 1);
        if (iUnrandomize255State == 0) {
            iUnrandomize255State = bitSource.available() / 8;
        } else if (iUnrandomize255State >= 250) {
            iUnrandomize255State = ((iUnrandomize255State - 249) * 250) + unrandomize255State(bitSource.readBits(8), i);
            i = byteOffset + 3;
        }
        if (iUnrandomize255State < 0) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[iUnrandomize255State];
        int i2 = 0;
        while (i2 < iUnrandomize255State) {
            if (bitSource.available() < 8) {
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
            }
            bArr[i2] = (byte) unrandomize255State(bitSource.readBits(8), i);
            i2++;
            i++;
        }
        collection.add(bArr);
        try {
            sb.append(new java.lang.String(bArr, "ISO8859_1"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.IllegalStateException("Platform does not support required encoding: " + e);
        }
    }

    private static void decodeC40Segment(com.dcloud.zxing2.common.BitSource bitSource, java.lang.StringBuilder sb) throws com.dcloud.zxing2.FormatException {
        int bits;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (bitSource.available() != 8 && (bits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(bits, bitSource.readBits(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            char[] cArr = C40_SHIFT2_SET_CHARS;
                            if (i3 < cArr.length) {
                                char c = cArr[i3];
                                if (z) {
                                    sb.append((char) (c + 128));
                                    z = false;
                                } else {
                                    sb.append(c);
                                }
                            } else if (i3 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i3 != 30) {
                                    throw com.dcloud.zxing2.FormatException.getFormatInstance();
                                }
                                z = true;
                            }
                        } else {
                            if (i != 3) {
                                throw com.dcloud.zxing2.FormatException.getFormatInstance();
                            }
                            if (z) {
                                sb.append((char) (i3 + 224));
                                z = false;
                            } else {
                                sb.append((char) (i3 + 96));
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i3 + 128));
                        z = false;
                    } else {
                        sb.append((char) i3);
                    }
                    i = 0;
                } else if (i3 < 3) {
                    i = i3 + 1;
                } else {
                    char[] cArr2 = C40_BASIC_SET_CHARS;
                    if (i3 >= cArr2.length) {
                        throw com.dcloud.zxing2.FormatException.getFormatInstance();
                    }
                    char c2 = cArr2[i3];
                    if (z) {
                        sb.append((char) (c2 + 128));
                        z = false;
                    } else {
                        sb.append(c2);
                    }
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeEdifactSegment(com.dcloud.zxing2.common.BitSource bitSource, java.lang.StringBuilder sb) {
        while (bitSource.available() > 16) {
            for (int i = 0; i < 4; i++) {
                int bits = bitSource.readBits(6);
                if (bits == 31) {
                    int bitOffset = 8 - bitSource.getBitOffset();
                    if (bitOffset != 8) {
                        bitSource.readBits(bitOffset);
                        return;
                    }
                    return;
                }
                if ((bits & 32) == 0) {
                    bits |= 64;
                }
                sb.append((char) bits);
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeTextSegment(com.dcloud.zxing2.common.BitSource bitSource, java.lang.StringBuilder sb) throws com.dcloud.zxing2.FormatException {
        int bits;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (bitSource.available() != 8 && (bits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(bits, bitSource.readBits(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            char[] cArr = TEXT_SHIFT2_SET_CHARS;
                            if (i3 < cArr.length) {
                                char c = cArr[i3];
                                if (z) {
                                    sb.append((char) (c + 128));
                                    z = false;
                                } else {
                                    sb.append(c);
                                }
                            } else if (i3 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i3 != 30) {
                                    throw com.dcloud.zxing2.FormatException.getFormatInstance();
                                }
                                z = true;
                            }
                        } else {
                            if (i != 3) {
                                throw com.dcloud.zxing2.FormatException.getFormatInstance();
                            }
                            char[] cArr2 = TEXT_SHIFT3_SET_CHARS;
                            if (i3 >= cArr2.length) {
                                throw com.dcloud.zxing2.FormatException.getFormatInstance();
                            }
                            char c2 = cArr2[i3];
                            if (z) {
                                sb.append((char) (c2 + 128));
                                z = false;
                            } else {
                                sb.append(c2);
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i3 + 128));
                        z = false;
                    } else {
                        sb.append((char) i3);
                    }
                    i = 0;
                } else if (i3 < 3) {
                    i = i3 + 1;
                } else {
                    char[] cArr3 = TEXT_BASIC_SET_CHARS;
                    if (i3 >= cArr3.length) {
                        throw com.dcloud.zxing2.FormatException.getFormatInstance();
                    }
                    char c3 = cArr3[i3];
                    if (z) {
                        sb.append((char) (c3 + 128));
                        z = false;
                    } else {
                        sb.append(c3);
                    }
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void parseTwoBytes(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    private static int unrandomize255State(int i, int i2) {
        int i3 = i - (((i2 * com.alibaba.fastjson.asm.Opcodes.FCMPL) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
