package com.dcloud.zxing2.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class GeneralAppIdDecoder {
    private final com.dcloud.zxing2.common.BitArray information;
    private final com.dcloud.zxing2.oned.rss.expanded.decoders.CurrentParsingState current = new com.dcloud.zxing2.oned.rss.expanded.decoders.CurrentParsingState();
    private final java.lang.StringBuilder buffer = new java.lang.StringBuilder();

    GeneralAppIdDecoder(com.dcloud.zxing2.common.BitArray bitArray) {
        this.information = bitArray;
    }

    private com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedChar decodeAlphanumeric(int i) {
        char c;
        int iExtractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (iExtractNumericValueFromBitArray == 15) {
            return new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedChar(i + 5, '$');
        }
        if (iExtractNumericValueFromBitArray >= 5 && iExtractNumericValueFromBitArray < 15) {
            return new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedChar(i + 5, (char) (iExtractNumericValueFromBitArray + 43));
        }
        int iExtractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 6);
        if (iExtractNumericValueFromBitArray2 >= 32 && iExtractNumericValueFromBitArray2 < 58) {
            return new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedChar(i + 6, (char) (iExtractNumericValueFromBitArray2 + 33));
        }
        switch (iExtractNumericValueFromBitArray2) {
            case 58:
                c = '*';
                break;
            case 59:
                c = com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR;
                break;
            case 60:
                c = '-';
                break;
            case kotlinx.coroutines.internal.LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                c = com.taobao.weex.el.parse.Operators.DOT;
                break;
            case 62:
                c = '/';
                break;
            default:
                throw new java.lang.IllegalStateException("Decoding invalid alphanumeric value: " + iExtractNumericValueFromBitArray2);
        }
        return new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedChar(i + 6, c);
    }

    private com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedChar decodeIsoIec646(int i) throws com.dcloud.zxing2.FormatException {
        int iExtractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (iExtractNumericValueFromBitArray == 15) {
            return new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedChar(i + 5, '$');
        }
        char c = '+';
        if (iExtractNumericValueFromBitArray >= 5 && iExtractNumericValueFromBitArray < 15) {
            return new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedChar(i + 5, (char) (iExtractNumericValueFromBitArray + 43));
        }
        int iExtractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 7);
        if (iExtractNumericValueFromBitArray2 >= 64 && iExtractNumericValueFromBitArray2 < 90) {
            return new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedChar(i + 7, (char) (iExtractNumericValueFromBitArray2 + 1));
        }
        if (iExtractNumericValueFromBitArray2 >= 90 && iExtractNumericValueFromBitArray2 < 116) {
            return new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedChar(i + 7, (char) (iExtractNumericValueFromBitArray2 + 7));
        }
        switch (extractNumericValueFromBitArray(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = '\"';
                break;
            case org.mozilla.universalchardet.prober.HebrewProber.FINAL_KAF /* 234 */:
                c = com.taobao.weex.utils.WXUtils.PERCENT;
                break;
            case org.mozilla.universalchardet.prober.HebrewProber.NORMAL_KAF /* 235 */:
                c = kotlin.text.Typography.amp;
                break;
            case 236:
                c = com.taobao.weex.el.parse.Operators.SINGLE_QUOTE;
                break;
            case org.mozilla.universalchardet.prober.HebrewProber.FINAL_MEM /* 237 */:
                c = com.taobao.weex.el.parse.Operators.BRACKET_START;
                break;
            case org.mozilla.universalchardet.prober.HebrewProber.NORMAL_MEM /* 238 */:
                c = com.taobao.weex.el.parse.Operators.BRACKET_END;
                break;
            case 239:
                c = '*';
                break;
            case org.mozilla.universalchardet.prober.HebrewProber.NORMAL_NUN /* 240 */:
                break;
            case org.mozilla.universalchardet.prober.contextanalysis.SJISContextAnalysis.HIRAGANA_LOWBYTE_END /* 241 */:
                c = com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR;
                break;
            case 242:
                c = '-';
                break;
            case 243:
                c = com.taobao.weex.el.parse.Operators.DOT;
                break;
            case 244:
                c = '/';
                break;
            case org.mozilla.universalchardet.prober.HebrewProber.FINAL_TSADI /* 245 */:
                c = com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE;
                break;
            case org.mozilla.universalchardet.prober.HebrewProber.NORMAL_TSADI /* 246 */:
                c = ';';
                break;
            case 247:
                c = kotlin.text.Typography.less;
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = kotlin.text.Typography.greater;
                break;
            case 250:
                c = com.taobao.weex.el.parse.Operators.CONDITION_IF;
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
        return new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedChar(i + 8, c);
    }

    private com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedNumeric decodeNumeric(int i) throws com.dcloud.zxing2.FormatException {
        int i2 = i + 7;
        if (i2 > this.information.getSize()) {
            int iExtractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 4);
            return iExtractNumericValueFromBitArray == 0 ? new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedNumeric(this.information.getSize(), 10, 10) : new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedNumeric(this.information.getSize(), iExtractNumericValueFromBitArray - 1, 10);
        }
        int iExtractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 7) - 8;
        return new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedNumeric(i2, iExtractNumericValueFromBitArray2 / 11, iExtractNumericValueFromBitArray2 % 11);
    }

    private boolean isAlphaOr646ToNumericLatch(int i) {
        int i2 = i + 3;
        if (i2 > this.information.getSize()) {
            return false;
        }
        while (i < i2) {
            if (this.information.get(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean isAlphaTo646ToAlphaLatch(int i) {
        int i2;
        if (i + 1 > this.information.getSize()) {
            return false;
        }
        for (int i3 = 0; i3 < 5 && (i2 = i3 + i) < this.information.getSize(); i3++) {
            if (i3 == 2) {
                if (!this.information.get(i + 2)) {
                    return false;
                }
            } else if (this.information.get(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNumericToAlphaNumericLatch(int i) {
        int i2;
        if (i + 1 > this.information.getSize()) {
            return false;
        }
        for (int i3 = 0; i3 < 4 && (i2 = i3 + i) < this.information.getSize(); i3++) {
            if (this.information.get(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean isStillAlpha(int i) {
        int iExtractNumericValueFromBitArray;
        if (i + 5 > this.information.getSize()) {
            return false;
        }
        int iExtractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 5);
        if (iExtractNumericValueFromBitArray2 < 5 || iExtractNumericValueFromBitArray2 >= 16) {
            return i + 6 <= this.information.getSize() && (iExtractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 6)) >= 16 && iExtractNumericValueFromBitArray < 63;
        }
        return true;
    }

    private boolean isStillIsoIec646(int i) {
        int iExtractNumericValueFromBitArray;
        if (i + 5 > this.information.getSize()) {
            return false;
        }
        int iExtractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 5);
        if (iExtractNumericValueFromBitArray2 >= 5 && iExtractNumericValueFromBitArray2 < 16) {
            return true;
        }
        if (i + 7 > this.information.getSize()) {
            return false;
        }
        int iExtractNumericValueFromBitArray3 = extractNumericValueFromBitArray(i, 7);
        if (iExtractNumericValueFromBitArray3 < 64 || iExtractNumericValueFromBitArray3 >= 116) {
            return i + 8 <= this.information.getSize() && (iExtractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 8)) >= 232 && iExtractNumericValueFromBitArray < 253;
        }
        return true;
    }

    private boolean isStillNumeric(int i) {
        if (i + 7 > this.information.getSize()) {
            return i + 4 <= this.information.getSize();
        }
        int i2 = i;
        while (true) {
            int i3 = i + 3;
            if (i2 >= i3) {
                return this.information.get(i3);
            }
            if (this.information.get(i2)) {
                return true;
            }
            i2++;
        }
    }

    private com.dcloud.zxing2.oned.rss.expanded.decoders.BlockParsedResult parseAlphaBlock() {
        while (isStillAlpha(this.current.getPosition())) {
            com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedChar decodedCharDecodeAlphanumeric = decodeAlphanumeric(this.current.getPosition());
            this.current.setPosition(decodedCharDecodeAlphanumeric.getNewPosition());
            if (decodedCharDecodeAlphanumeric.isFNC1()) {
                return new com.dcloud.zxing2.oned.rss.expanded.decoders.BlockParsedResult(new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodedCharDecodeAlphanumeric.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
            this.current.incrementPosition(3);
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
            if (this.current.getPosition() + 5 < this.information.getSize()) {
                this.current.incrementPosition(5);
            } else {
                this.current.setPosition(this.information.getSize());
            }
            this.current.setIsoIec646();
        }
        return new com.dcloud.zxing2.oned.rss.expanded.decoders.BlockParsedResult(false);
    }

    private com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedInformation parseBlocks() throws com.dcloud.zxing2.FormatException {
        com.dcloud.zxing2.oned.rss.expanded.decoders.BlockParsedResult numericBlock;
        boolean zIsFinished;
        do {
            int position = this.current.getPosition();
            if (this.current.isAlpha()) {
                numericBlock = parseAlphaBlock();
                zIsFinished = numericBlock.isFinished();
            } else if (this.current.isIsoIec646()) {
                numericBlock = parseIsoIec646Block();
                zIsFinished = numericBlock.isFinished();
            } else {
                numericBlock = parseNumericBlock();
                zIsFinished = numericBlock.isFinished();
            }
            if (position == this.current.getPosition() && !zIsFinished) {
                break;
            }
        } while (!zIsFinished);
        return numericBlock.getDecodedInformation();
    }

    private com.dcloud.zxing2.oned.rss.expanded.decoders.BlockParsedResult parseIsoIec646Block() throws com.dcloud.zxing2.FormatException {
        while (isStillIsoIec646(this.current.getPosition())) {
            com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedChar decodedCharDecodeIsoIec646 = decodeIsoIec646(this.current.getPosition());
            this.current.setPosition(decodedCharDecodeIsoIec646.getNewPosition());
            if (decodedCharDecodeIsoIec646.isFNC1()) {
                return new com.dcloud.zxing2.oned.rss.expanded.decoders.BlockParsedResult(new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodedCharDecodeIsoIec646.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
            this.current.incrementPosition(3);
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
            if (this.current.getPosition() + 5 < this.information.getSize()) {
                this.current.incrementPosition(5);
            } else {
                this.current.setPosition(this.information.getSize());
            }
            this.current.setAlpha();
        }
        return new com.dcloud.zxing2.oned.rss.expanded.decoders.BlockParsedResult(false);
    }

    private com.dcloud.zxing2.oned.rss.expanded.decoders.BlockParsedResult parseNumericBlock() throws com.dcloud.zxing2.FormatException {
        while (isStillNumeric(this.current.getPosition())) {
            com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedNumeric decodedNumericDecodeNumeric = decodeNumeric(this.current.getPosition());
            this.current.setPosition(decodedNumericDecodeNumeric.getNewPosition());
            if (decodedNumericDecodeNumeric.isFirstDigitFNC1()) {
                return new com.dcloud.zxing2.oned.rss.expanded.decoders.BlockParsedResult(decodedNumericDecodeNumeric.isSecondDigitFNC1() ? new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedInformation(this.current.getPosition(), this.buffer.toString()) : new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedInformation(this.current.getPosition(), this.buffer.toString(), decodedNumericDecodeNumeric.getSecondDigit()), true);
            }
            this.buffer.append(decodedNumericDecodeNumeric.getFirstDigit());
            if (decodedNumericDecodeNumeric.isSecondDigitFNC1()) {
                return new com.dcloud.zxing2.oned.rss.expanded.decoders.BlockParsedResult(new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodedNumericDecodeNumeric.getSecondDigit());
        }
        if (isNumericToAlphaNumericLatch(this.current.getPosition())) {
            this.current.setAlpha();
            this.current.incrementPosition(4);
        }
        return new com.dcloud.zxing2.oned.rss.expanded.decoders.BlockParsedResult(false);
    }

    java.lang.String decodeAllCodes(java.lang.StringBuilder sb, int i) throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        java.lang.String str = null;
        while (true) {
            com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedInformation decodedInformationDecodeGeneralPurposeField = decodeGeneralPurposeField(i, str);
            java.lang.String fieldsInGeneralPurpose = com.dcloud.zxing2.oned.rss.expanded.decoders.FieldParser.parseFieldsInGeneralPurpose(decodedInformationDecodeGeneralPurposeField.getNewString());
            if (fieldsInGeneralPurpose != null) {
                sb.append(fieldsInGeneralPurpose);
            }
            java.lang.String strValueOf = decodedInformationDecodeGeneralPurposeField.isRemaining() ? java.lang.String.valueOf(decodedInformationDecodeGeneralPurposeField.getRemainingValue()) : null;
            if (i == decodedInformationDecodeGeneralPurposeField.getNewPosition()) {
                return sb.toString();
            }
            i = decodedInformationDecodeGeneralPurposeField.getNewPosition();
            str = strValueOf;
        }
    }

    com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedInformation decodeGeneralPurposeField(int i, java.lang.String str) throws com.dcloud.zxing2.FormatException {
        this.buffer.setLength(0);
        if (str != null) {
            this.buffer.append(str);
        }
        this.current.setPosition(i);
        com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedInformation blocks = parseBlocks();
        return (blocks == null || !blocks.isRemaining()) ? new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedInformation(this.current.getPosition(), this.buffer.toString()) : new com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedInformation(this.current.getPosition(), this.buffer.toString(), blocks.getRemainingValue());
    }

    int extractNumericValueFromBitArray(int i, int i2) {
        return extractNumericValueFromBitArray(this.information, i, i2);
    }

    static int extractNumericValueFromBitArray(com.dcloud.zxing2.common.BitArray bitArray, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (bitArray.get(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }
}
