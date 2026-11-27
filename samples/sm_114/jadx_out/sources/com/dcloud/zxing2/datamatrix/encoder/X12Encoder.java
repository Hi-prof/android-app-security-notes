package com.dcloud.zxing2.datamatrix.encoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class X12Encoder extends com.dcloud.zxing2.datamatrix.encoder.C40Encoder {
    X12Encoder() {
    }

    @Override // com.dcloud.zxing2.datamatrix.encoder.C40Encoder, com.dcloud.zxing2.datamatrix.encoder.Encoder
    public void encode(com.dcloud.zxing2.datamatrix.encoder.EncoderContext encoderContext) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (encoderContext.hasMoreCharacters()) {
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            encodeChar(currentChar, sb);
            if (sb.length() % 3 == 0) {
                com.dcloud.zxing2.datamatrix.encoder.C40Encoder.writeNextTriplet(encoderContext, sb);
                int iLookAheadTest = com.dcloud.zxing2.datamatrix.encoder.HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
                if (iLookAheadTest != getEncodingMode()) {
                    encoderContext.signalEncoderChange(iLookAheadTest);
                    break;
                }
            }
        }
        handleEOD(encoderContext, sb);
    }

    @Override // com.dcloud.zxing2.datamatrix.encoder.C40Encoder
    int encodeChar(char c, java.lang.StringBuilder sb) {
        if (c == '\r') {
            sb.append((char) 0);
        } else if (c == '*') {
            sb.append((char) 1);
        } else if (c == '>') {
            sb.append((char) 2);
        } else if (c == ' ') {
            sb.append((char) 3);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) (c - ','));
        } else if (c < 'A' || c > 'Z') {
            com.dcloud.zxing2.datamatrix.encoder.HighLevelEncoder.illegalCharacter(c);
        } else {
            sb.append((char) (c - '3'));
        }
        return 1;
    }

    @Override // com.dcloud.zxing2.datamatrix.encoder.C40Encoder, com.dcloud.zxing2.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 3;
    }

    @Override // com.dcloud.zxing2.datamatrix.encoder.C40Encoder
    void handleEOD(com.dcloud.zxing2.datamatrix.encoder.EncoderContext encoderContext, java.lang.StringBuilder sb) {
        encoderContext.updateSymbolInfo();
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
        encoderContext.pos -= sb.length();
        if (encoderContext.getRemainingCharacters() > 1 || dataCapacity > 1 || encoderContext.getRemainingCharacters() != dataCapacity) {
            encoderContext.writeCodeword((char) 254);
        }
        if (encoderContext.getNewEncoding() < 0) {
            encoderContext.signalEncoderChange(0);
        }
    }
}
