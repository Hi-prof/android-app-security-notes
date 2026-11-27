package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DataUtil {
    public static java.lang.String GBK2Unicode(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (isNeedConvert(cCharAt)) {
                stringBuffer.append("\\u" + java.lang.Integer.toHexString(cCharAt));
            } else {
                stringBuffer.append(cCharAt);
            }
        }
        return stringBuffer.toString();
    }

    public static java.lang.String Unicode2GBK(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (i < length - 1) {
                int i2 = i + 2;
                if ("\\u".equals(str.substring(i, i2))) {
                    i += 6;
                    stringBuffer.append((char) java.lang.Integer.parseInt(str.substring(i2, i), 16));
                }
            }
            stringBuffer.append(str.charAt(i));
            i++;
        }
        return stringBuffer.toString();
    }

    public static void datToJsString(final java.lang.String str, final io.dcloud.common.DHInterface.ICallBack iCallBack) {
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.common.util.DataUtil.1
            @Override // java.lang.Runnable
            public void run() {
                java.lang.String strDatToJsStringSync = io.dcloud.common.util.DataUtil.datToJsStringSync(str);
                if (android.text.TextUtils.isEmpty(strDatToJsStringSync)) {
                    return;
                }
                iCallBack.onCallBack(0, strDatToJsStringSync);
            }
        }, true);
    }

    public static java.lang.String datToJsStringSync(java.lang.String str) {
        java.io.InputStream fileInputStream;
        java.io.File file = new java.io.File(io.dcloud.common.adapter.util.DeviceInfo.sBaseFsRootPath + java.io.File.separator + str);
        boolean z = true;
        if (file.exists()) {
            try {
                fileInputStream = new java.io.FileInputStream(file);
                z = false;
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
                fileInputStream = null;
            }
        } else {
            fileInputStream = io.dcloud.common.adapter.util.PlatformUtil.getResInputStream(str);
        }
        boolean z2 = str.equals(io.dcloud.common.util.BaseInfo.sUniNViewServiceJsPath) ? false : z;
        if (fileInputStream != null) {
            try {
                if (!z2) {
                    return new java.lang.String(io.dcloud.common.util.IOUtil.getBytes(fileInputStream));
                }
                if (!android.text.TextUtils.isEmpty(io.dcloud.p.e1.c())) {
                    return io.dcloud.common.util.AESUtil.decrypt(io.dcloud.p.e1.c(), io.dcloud.p.e1.b(), io.dcloud.common.util.IOUtil.getBytes(fileInputStream));
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static boolean isNeedConvert(char c) {
        return (c & 255) != c;
    }

    public static java.lang.String unicodeToUtf8(java.lang.String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(length);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt == '\\') {
                i += 2;
                char cCharAt2 = str.charAt(i2);
                if (cCharAt2 == 'u') {
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < 4) {
                        int i5 = i + 1;
                        char cCharAt3 = str.charAt(i);
                        switch (cCharAt3) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case com.alibaba.fastjson.asm.Opcodes.LSTORE /* 55 */:
                            case '8':
                            case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
                                i4 = ((i4 << 4) + cCharAt3) - 48;
                                break;
                            default:
                                switch (cCharAt3) {
                                    case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A_CAPITAL /* 65 */:
                                    case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                                    case 'C':
                                    case 'D':
                                    case 'E':
                                    case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_ANIMATION_END /* 70 */:
                                        i4 = (((i4 << 4) + 10) + cCharAt3) - 65;
                                        break;
                                    default:
                                        switch (cCharAt3) {
                                            case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A /* 97 */:
                                            case 'b':
                                            case 'c':
                                            case 'd':
                                            case 'e':
                                            case 'f':
                                                i4 = (((i4 << 4) + 10) + cCharAt3) - 97;
                                                break;
                                            default:
                                                throw new java.lang.IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                                        }
                                        break;
                                }
                                break;
                        }
                        i3++;
                        i = i5;
                    }
                    stringBuffer.append((char) i4);
                } else {
                    if (cCharAt2 == 't') {
                        cCharAt2 = 't';
                    } else if (cCharAt2 == 'r') {
                        cCharAt2 = 'r';
                    } else if (cCharAt2 == 'n') {
                        cCharAt2 = 'n';
                    } else if (cCharAt2 == 'f') {
                        cCharAt2 = 'f';
                    }
                    stringBuffer.append(cCharAt2);
                }
            } else {
                stringBuffer.append(cCharAt);
                i = i2;
            }
        }
        return stringBuffer.toString();
    }

    public static java.lang.String utf8ToUnicode(java.lang.String str) {
        char[] charArray = str.toCharArray();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            java.lang.Character.UnicodeBlock unicodeBlockOf = java.lang.Character.UnicodeBlock.of(charArray[i]);
            if (unicodeBlockOf == java.lang.Character.UnicodeBlock.BASIC_LATIN || unicodeBlockOf == java.lang.Character.UnicodeBlock.LATIN_1_SUPPLEMENT) {
                stringBuffer.append(charArray[i]);
            } else if (unicodeBlockOf == java.lang.Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                stringBuffer.append((char) (charArray[i] - 65248));
            } else {
                stringBuffer.append(("\\u" + java.lang.Integer.toHexString(charArray[i])).toLowerCase(java.util.Locale.ENGLISH));
            }
        }
        return stringBuffer.toString();
    }

    public java.lang.String gbk2utf8(java.lang.String str) {
        return unicodeToUtf8(GBK2Unicode(str));
    }

    public java.lang.String utf82gbk(java.lang.String str) {
        return Unicode2GBK(utf8ToUnicode(str));
    }
}
