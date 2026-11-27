package com.dcloud.zxing2.client.result;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class VINResultParser extends com.dcloud.zxing2.client.result.ResultParser {
    private static final java.util.regex.Pattern IOQ = java.util.regex.Pattern.compile("[IOQ]");
    private static final java.util.regex.Pattern AZ09 = java.util.regex.Pattern.compile("[A-Z0-9]{17}");

    private static char checkChar(int i) {
        if (i < 10) {
            return (char) (i + 48);
        }
        if (i == 10) {
            return 'X';
        }
        throw new java.lang.IllegalArgumentException();
    }

    private static boolean checkChecksum(java.lang.CharSequence charSequence) {
        int i = 0;
        int iVinPositionWeight = 0;
        while (i < charSequence.length()) {
            int i2 = i + 1;
            iVinPositionWeight += vinPositionWeight(i2) * vinCharValue(charSequence.charAt(i));
            i = i2;
        }
        return charSequence.charAt(8) == checkChar(iVinPositionWeight % 11);
    }

    private static java.lang.String countryCode(java.lang.CharSequence charSequence) {
        char cCharAt = charSequence.charAt(0);
        char cCharAt2 = charSequence.charAt(1);
        if (cCharAt == '9') {
            if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                return "BR";
            }
            if (cCharAt2 < '3' || cCharAt2 > '9') {
                return null;
            }
            return "BR";
        }
        if (cCharAt == 'S') {
            if (cCharAt2 >= 'A' && cCharAt2 <= 'M') {
                return "UK";
            }
            if (cCharAt2 < 'N' || cCharAt2 > 'T') {
                return null;
            }
            return "DE";
        }
        if (cCharAt == 'Z') {
            if (cCharAt2 < 'A' || cCharAt2 > 'R') {
                return null;
            }
            return "IT";
        }
        switch (cCharAt) {
            case '1':
            case '4':
            case '5':
                return "US";
            case '2':
                return "CA";
            case '3':
                if (cCharAt2 < 'A' || cCharAt2 > 'W') {
                    return null;
                }
                return "MX";
            default:
                switch (cCharAt) {
                    case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_BACKGROUND_SET_WEBPARENT /* 74 */:
                        if (cCharAt2 < 'A' || cCharAt2 > 'T') {
                            return null;
                        }
                        return "JP";
                    case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_UPDATE_BACKGROUND /* 75 */:
                        if (cCharAt2 < 'L' || cCharAt2 > 'R') {
                            return null;
                        }
                        return "KO";
                    case io.dcloud.common.DHInterface.IMgr.WindowEvent.CHECK_RESTART_TOP_WEBVIEW /* 76 */:
                        return "CN";
                    case 'M':
                        if (cCharAt2 < 'A' || cCharAt2 > 'E') {
                            return null;
                        }
                        return "IN";
                    default:
                        switch (cCharAt) {
                            case 'V':
                                if (cCharAt2 >= 'F' && cCharAt2 <= 'R') {
                                    return "FR";
                                }
                                if (cCharAt2 < 'S' || cCharAt2 > 'W') {
                                    return null;
                                }
                                return "ES";
                            case com.alibaba.fastjson.asm.Opcodes.POP /* 87 */:
                                return "DE";
                            case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_EXTENDED /* 88 */:
                                if (cCharAt2 == '0') {
                                    return "RU";
                                }
                                if (cCharAt2 < '3' || cCharAt2 > '9') {
                                    return null;
                                }
                                return "RU";
                            default:
                                return null;
                        }
                }
        }
    }

    private static int modelYear(char c) {
        if (c >= 'E' && c <= 'H') {
            return c + 1915;
        }
        if (c >= 'J' && c <= 'N') {
            return c + 1914;
        }
        if (c == 'P') {
            return 1993;
        }
        if (c >= 'R' && c <= 'T') {
            return c + 1912;
        }
        if (c >= 'V' && c <= 'Y') {
            return c + 1911;
        }
        if (c >= '1' && c <= '9') {
            return c + 1952;
        }
        if (c < 'A' || c > 'D') {
            throw new java.lang.IllegalArgumentException();
        }
        return c + 1945;
    }

    private static int vinCharValue(char c) {
        if (c >= 'A' && c <= 'I') {
            return c - '@';
        }
        if (c >= 'J' && c <= 'R') {
            return c - 'I';
        }
        if (c >= 'S' && c <= 'Z') {
            return c - 'Q';
        }
        if (c < '0' || c > '9') {
            throw new java.lang.IllegalArgumentException();
        }
        return c - '0';
    }

    private static int vinPositionWeight(int i) {
        if (i >= 1 && i <= 7) {
            return 9 - i;
        }
        if (i == 8) {
            return 10;
        }
        if (i == 9) {
            return 0;
        }
        if (i < 10 || i > 17) {
            throw new java.lang.IllegalArgumentException();
        }
        return 19 - i;
    }

    @Override // com.dcloud.zxing2.client.result.ResultParser
    public com.dcloud.zxing2.client.result.VINParsedResult parse(com.dcloud.zxing2.Result result) {
        if (result.getBarcodeFormat() != com.dcloud.zxing2.BarcodeFormat.CODE_39) {
            return null;
        }
        java.lang.String strTrim = IOQ.matcher(result.getText()).replaceAll("").trim();
        if (!AZ09.matcher(strTrim).matches()) {
            return null;
        }
        try {
            if (!checkChecksum(strTrim)) {
                return null;
            }
            java.lang.String strSubstring = strTrim.substring(0, 3);
            return new com.dcloud.zxing2.client.result.VINParsedResult(strTrim, strSubstring, strTrim.substring(3, 9), strTrim.substring(9, 17), countryCode(strSubstring), strTrim.substring(3, 8), modelYear(strTrim.charAt(9)), strTrim.charAt(10), strTrim.substring(11));
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }
}
