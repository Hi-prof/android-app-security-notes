package com.dcloud.zxing2.datamatrix.encoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class EdifactEncoder implements com.dcloud.zxing2.datamatrix.encoder.Encoder {
    EdifactEncoder() {
    }

    private static void encodeChar(char c, java.lang.StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c < '@' || c > '^') {
            com.dcloud.zxing2.datamatrix.encoder.HighLevelEncoder.illegalCharacter(c);
        } else {
            sb.append((char) (c - com.taobao.weex.ui.component.list.template.TemplateDom.SEPARATOR));
        }
    }

    private static java.lang.String encodeToCodewords(java.lang.CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length == 0) {
            throw new java.lang.IllegalStateException("StringBuilder must not be empty");
        }
        int iCharAt = (charSequence.charAt(i) << 18) + ((length >= 2 ? charSequence.charAt(i + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i + 3) : (char) 0);
        char c = (char) ((iCharAt >> 16) & 255);
        char c2 = (char) ((iCharAt >> 8) & 255);
        char c3 = (char) (iCharAt & 255);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(3);
        sb.append(c);
        if (length >= 2) {
            sb.append(c2);
        }
        if (length >= 3) {
            sb.append(c3);
        }
        return sb.toString();
    }

    private static void handleEOD(com.dcloud.zxing2.datamatrix.encoder.EncoderContext encoderContext, java.lang.CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                encoderContext.signalEncoderChange(0);
                return;
            }
            boolean z = true;
            if (length == 1) {
                encoderContext.updateSymbolInfo();
                int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
                if (encoderContext.getRemainingCharacters() == 0 && dataCapacity <= 2) {
                    encoderContext.signalEncoderChange(0);
                    return;
                }
            }
            if (length > 4) {
                throw new java.lang.IllegalStateException("Count must not exceed 4");
            }
            int i = length - 1;
            java.lang.String strEncodeToCodewords = encodeToCodewords(charSequence, 0);
            if (encoderContext.hasMoreCharacters() || i > 2) {
                z = false;
            }
            if (i <= 2) {
                encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + i);
                if (encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount() >= 3) {
                    encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + strEncodeToCodewords.length());
                    z = false;
                }
            }
            if (z) {
                encoderContext.resetSymbolInfo();
                encoderContext.pos -= i;
            } else {
                encoderContext.writeCodewords(strEncodeToCodewords);
            }
            encoderContext.signalEncoderChange(0);
        } catch (java.lang.Throwable th) {
            encoderContext.signalEncoderChange(0);
            throw th;
        }
    }

    @Override // com.dcloud.zxing2.datamatrix.encoder.Encoder
    public void encode(com.dcloud.zxing2.datamatrix.encoder.EncoderContext encoderContext) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (encoderContext.hasMoreCharacters()) {
            encodeChar(encoderContext.getCurrentChar(), sb);
            encoderContext.pos++;
            if (sb.length() >= 4) {
                encoderContext.writeCodewords(encodeToCodewords(sb, 0));
                sb.delete(0, 4);
                if (com.dcloud.zxing2.datamatrix.encoder.HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                    encoderContext.signalEncoderChange(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        handleEOD(encoderContext, sb);
    }

    @Override // com.dcloud.zxing2.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 4;
    }
}
