package com.dcloud.zxing2.datamatrix.encoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class Base256Encoder implements com.dcloud.zxing2.datamatrix.encoder.Encoder {
    Base256Encoder() {
    }

    private static char randomize255State(char c, int i) {
        int i2 = c + ((i * com.alibaba.fastjson.asm.Opcodes.FCMPL) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 - 256);
    }

    @Override // com.dcloud.zxing2.datamatrix.encoder.Encoder
    public void encode(com.dcloud.zxing2.datamatrix.encoder.EncoderContext encoderContext) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append((char) 0);
        while (encoderContext.hasMoreCharacters()) {
            sb.append(encoderContext.getCurrentChar());
            encoderContext.pos++;
            int iLookAheadTest = com.dcloud.zxing2.datamatrix.encoder.HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
            if (iLookAheadTest != getEncodingMode()) {
                encoderContext.signalEncoderChange(iLookAheadTest);
                break;
            }
        }
        int length = sb.length() - 1;
        int codewordCount = encoderContext.getCodewordCount() + length + 1;
        encoderContext.updateSymbolInfo(codewordCount);
        boolean z = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount > 0;
        if (encoderContext.hasMoreCharacters() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length <= 249 || length > 1555) {
                    throw new java.lang.IllegalStateException("Message length not in valid ranges: " + length);
                }
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            encoderContext.writeCodeword(randomize255State(sb.charAt(i), encoderContext.getCodewordCount() + 1));
        }
    }

    @Override // com.dcloud.zxing2.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 5;
    }
}
