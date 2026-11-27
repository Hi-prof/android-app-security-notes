package com.dcloud.zxing2.datamatrix.encoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class C40Encoder implements com.dcloud.zxing2.datamatrix.encoder.Encoder {
    C40Encoder() {
    }

    private int backtrackOneCharacter(com.dcloud.zxing2.datamatrix.encoder.EncoderContext encoderContext, java.lang.StringBuilder sb, java.lang.StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        encoderContext.pos--;
        int iEncodeChar = encodeChar(encoderContext.getCurrentChar(), sb2);
        encoderContext.resetSymbolInfo();
        return iEncodeChar;
    }

    private static java.lang.String encodeToCodewords(java.lang.CharSequence charSequence, int i) {
        int iCharAt = (charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * com.taobao.weex.el.parse.Operators.BRACKET_START) + charSequence.charAt(i + 2) + 1;
        return new java.lang.String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)});
    }

    static void writeNextTriplet(com.dcloud.zxing2.datamatrix.encoder.EncoderContext encoderContext, java.lang.StringBuilder sb) {
        encoderContext.writeCodewords(encodeToCodewords(sb, 0));
        sb.delete(0, 3);
    }

    @Override // com.dcloud.zxing2.datamatrix.encoder.Encoder
    public void encode(com.dcloud.zxing2.datamatrix.encoder.EncoderContext encoderContext) {
        int iLookAheadTest;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (encoderContext.hasMoreCharacters()) {
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            int iEncodeChar = encodeChar(currentChar, sb);
            int codewordCount = encoderContext.getCodewordCount() + ((sb.length() / 3) * 2);
            encoderContext.updateSymbolInfo(codewordCount);
            int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
            if (!encoderContext.hasMoreCharacters()) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                if (sb.length() % 3 == 2 && (dataCapacity < 2 || dataCapacity > 2)) {
                    iEncodeChar = backtrackOneCharacter(encoderContext, sb, sb2, iEncodeChar);
                }
                while (sb.length() % 3 == 1 && ((iEncodeChar <= 3 && dataCapacity != 1) || iEncodeChar > 3)) {
                    iEncodeChar = backtrackOneCharacter(encoderContext, sb, sb2, iEncodeChar);
                }
                break;
            }
            if (sb.length() % 3 == 0 && (iLookAheadTest = com.dcloud.zxing2.datamatrix.encoder.HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode())) != getEncodingMode()) {
                encoderContext.signalEncoderChange(iLookAheadTest);
                break;
            }
        }
        handleEOD(encoderContext, sb);
    }

    int encodeChar(char c, java.lang.StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c >= '0' && c <= '9') {
            sb.append((char) (c - ','));
            return 1;
        }
        if (c >= 'A' && c <= 'Z') {
            sb.append((char) (c - '3'));
            return 1;
        }
        if (c >= 0 && c <= 31) {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        }
        if (c >= '!' && c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        }
        if (c >= ':' && c <= '@') {
            sb.append((char) 1);
            sb.append((char) (c - '+'));
            return 2;
        }
        if (c >= '[' && c <= '_') {
            sb.append((char) 1);
            sb.append((char) (c - 'E'));
            return 2;
        }
        if (c >= '`' && c <= 127) {
            sb.append((char) 2);
            sb.append((char) (c - '`'));
            return 2;
        }
        if (c >= 128) {
            sb.append("\u0001\u001e");
            return encodeChar((char) (c - 128), sb) + 2;
        }
        throw new java.lang.IllegalArgumentException("Illegal character: " + c);
    }

    @Override // com.dcloud.zxing2.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 1;
    }

    void handleEOD(com.dcloud.zxing2.datamatrix.encoder.EncoderContext encoderContext, java.lang.StringBuilder sb) {
        int length = (sb.length() / 3) * 2;
        int length2 = sb.length() % 3;
        int codewordCount = encoderContext.getCodewordCount() + length;
        encoderContext.updateSymbolInfo(codewordCount);
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword((char) 254);
            }
        } else if (dataCapacity == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword((char) 254);
            }
            encoderContext.pos--;
        } else {
            if (length2 != 0) {
                throw new java.lang.IllegalStateException("Unexpected case. Please report!");
            }
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (dataCapacity > 0 || encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword((char) 254);
            }
        }
        encoderContext.signalEncoderChange(0);
    }
}
