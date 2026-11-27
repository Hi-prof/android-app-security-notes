package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class Md5Utils {
    public static final java.lang.String ALGORITHM = "MD5";
    public static final java.lang.String DEFAULT_CHARSET = "UTF-8";
    private static final char[] HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] HEX_LOWER_CASE = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static java.lang.String md5(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(ALGORITHM);
            messageDigest.update(str.getBytes("UTF-8"));
            return toHex(messageDigest.digest());
        } catch (java.io.UnsupportedEncodingException | java.security.NoSuchAlgorithmException | java.lang.Exception unused) {
            return str;
        }
    }

    public static java.lang.String md5LowerCase(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(ALGORITHM);
            messageDigest.update(str.getBytes("UTF-8"));
            return toLowerCaseHex(messageDigest.digest());
        } catch (java.io.UnsupportedEncodingException | java.security.NoSuchAlgorithmException | java.lang.Exception unused) {
            return str;
        }
    }

    public static java.lang.String md5LowerCase32Bit(java.lang.String str) {
        try {
            byte[] bytes = str.getBytes();
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(ALGORITHM);
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr = new char[bArrDigest.length * 2];
            int i = 0;
            for (byte b : bArrDigest) {
                int i2 = i + 1;
                char[] cArr2 = HEX;
                cArr[i] = cArr2[(b >>> 4) & 15];
                i += 2;
                cArr[i2] = cArr2[b & 15];
            }
            return new java.lang.String(cArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static java.lang.String toHex(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : bArr) {
            char[] cArr = HEX;
            sb.append(cArr[(b & 240) >> 4]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }

    private static java.lang.String toLowerCaseHex(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : bArr) {
            char[] cArr = HEX_LOWER_CASE;
            sb.append(cArr[(b & 240) >> 4]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }

    public static boolean verifyFileMd5(java.lang.String str, java.lang.String str2) {
        java.lang.String strMd5;
        return str.length() > 0 && (strMd5 = md5(new java.io.File(str))) != null && str2 != null && strMd5.compareToIgnoreCase(str2) == 0;
    }

    public static java.lang.String md5(byte[] bArr) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(ALGORITHM);
            messageDigest.update(bArr);
            return toHex(messageDigest.digest());
        } catch (java.security.NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static java.lang.String md5(java.io.File file) {
        return md5(file, ALGORITHM);
    }

    public static java.lang.String md5(java.io.InputStream inputStream, java.lang.String str) {
        byte[] bArr = new byte[1024];
        try {
            try {
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i > 0) {
                        messageDigest.update(bArr, 0, i);
                    } else {
                        java.lang.String hex = toHex(messageDigest.digest());
                        try {
                            inputStream.close();
                            return hex;
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                            return hex;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
            if (inputStream == null) {
                return null;
            }
            try {
                inputStream.close();
                return null;
            } catch (java.io.IOException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }

    public static java.lang.String md5(java.io.File file, java.lang.String str) throws java.lang.Throwable {
        java.io.InputStream fileInputStream;
        java.io.InputStream inputStream = null;
        try {
            if (io.dcloud.common.util.FileUtil.checkPrivatePath(io.dcloud.application.DCLoudApplicationImpl.self().getContext(), file.getPath())) {
                fileInputStream = new java.io.FileInputStream(file);
            } else {
                fileInputStream = io.dcloud.common.util.FileUtil.getFileInputStream(io.dcloud.application.DCLoudApplicationImpl.self().getContext(), file);
            }
            try {
                java.lang.String strMd5 = md5(fileInputStream, str);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return strMd5;
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                }
                return strMd5;
            } catch (java.lang.Exception unused) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused2) {
            fileInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }
}
