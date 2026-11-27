package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class u4 {
    private static java.lang.String a = "";
    private static java.lang.String b;
    private static java.lang.String c;

    private static boolean a(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) || str.contains("Unknown") || str.contains("00000000");
    }

    private static java.lang.StringBuilder b(java.io.InputStream inputStream) throws java.io.IOException {
        if (inputStream == null) {
            return null;
        }
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            java.lang.String line = bufferedReader.readLine();
            if (line == null) {
                inputStream.close();
                return sb;
            }
            sb.append(line);
            sb.append("\n");
        }
    }

    /* JADX WARN: Code duplicated, block: B:86:0x0115 A[PHI: r1
  0x0115: PHI (r1v3 java.lang.String) = (r1v1 java.lang.String), (r1v4 java.lang.String) binds: [B:84:0x0112, B:76:0x0103] A[DONT_GENERATE, DONT_INLINE]] */
    public static java.lang.String a(android.content.Context context, boolean z, boolean z2) {
        java.lang.String strA = null;
        try {
            java.lang.String str = io.dcloud.common.util.TelephonyUtil.TAG;
            java.lang.Class cls = java.lang.Boolean.TYPE;
            java.lang.reflect.Method method = io.dcloud.common.util.TelephonyUtil.class.getMethod("getSBBS", android.content.Context.class, cls, cls, cls);
            java.lang.Boolean boolValueOf = java.lang.Boolean.valueOf(io.dcloud.p.c0.a().a(context));
            java.lang.Boolean bool = java.lang.Boolean.TRUE;
            return (java.lang.String) method.invoke(null, context, bool, bool, boolValueOf);
        } catch (java.lang.Exception e) {
            if (io.dcloud.p.w0.a) {
                e.printStackTrace();
            }
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            if (z) {
                stringBuffer.append("|");
            }
            java.lang.String strReplace = "";
            if (context == null) {
                return z ? "|||||" : "";
            }
            if (z2) {
                if (z && !android.text.TextUtils.isEmpty(c)) {
                    return c;
                }
                if (!a(a) && !z) {
                    return a;
                }
            } else {
                if (z && !android.text.TextUtils.isEmpty(b)) {
                    return b;
                }
                if (!a(a) && !z) {
                    return a;
                }
            }
            java.lang.String[] strArrE = io.dcloud.p.y1.e(context);
            if (!a(a) && !z) {
                return a;
            }
            if (strArrE != null) {
                a = android.text.TextUtils.join(",", strArrE);
            } else {
                a = "";
            }
            if (z) {
                stringBuffer.append(a).append("|");
            }
            if (z) {
                stringBuffer.append("|");
            }
            boolean zA = a(a);
            if (!zA && !z) {
                return a;
            }
            java.lang.String strA2 = io.dcloud.p.y1.a(context);
            if (zA) {
                a = strA2;
            }
            if (z) {
                if (android.text.TextUtils.isEmpty(strA2)) {
                    strA2 = "";
                }
                stringBuffer.append(strA2).append("|");
            }
            boolean zA2 = a(a);
            if (!zA2 && !z) {
                return a;
            }
            try {
                try {
                    strA = a(context);
                    if (zA2) {
                        a = strA;
                    }
                    if (z) {
                        if (!android.text.TextUtils.isEmpty(strA)) {
                            strReplace = strA.replace("\n", "");
                        }
                        stringBuffer.append(strReplace).append("|");
                    }
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                    if (z) {
                        if (!android.text.TextUtils.isEmpty(strA)) {
                            strReplace = strA.replace("\n", "");
                        }
                        stringBuffer.append(strReplace).append("|");
                    }
                }
                b = java.net.URLEncoder.encode(android.util.Base64.encodeToString(io.dcloud.p.d.b(stringBuffer.toString().getBytes(), io.dcloud.p.f1.b(), io.dcloud.p.f1.a()), 2)) + "&ie=1";
                java.lang.String string = stringBuffer.toString();
                c = string;
                return z2 ? string : b;
            } catch (java.lang.Throwable th) {
                if (z) {
                    stringBuffer.append(android.text.TextUtils.isEmpty(strA) ? "" : strA.replace("\n", "")).append("|");
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00b8 A[Catch: Exception -> 0x00ed, all -> 0x00fe, TryCatch #1 {Exception -> 0x00ed, blocks: (B:24:0x00b1, B:28:0x00c1, B:30:0x00c7, B:32:0x00d1, B:33:0x00db, B:27:0x00b8), top: B:46:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00c7 A[Catch: Exception -> 0x00ed, all -> 0x00fe, TryCatch #1 {Exception -> 0x00ed, blocks: (B:24:0x00b1, B:28:0x00c1, B:30:0x00c7, B:32:0x00d1, B:33:0x00db, B:27:0x00b8), top: B:46:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00d1 A[Catch: Exception -> 0x00ed, all -> 0x00fe, TryCatch #1 {Exception -> 0x00ed, blocks: (B:24:0x00b1, B:28:0x00c1, B:30:0x00c7, B:32:0x00d1, B:33:0x00db, B:27:0x00b8), top: B:46:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00f3 A[Catch: all -> 0x00fe, Exception -> 0x0100, TryCatch #0 {Exception -> 0x0100, blocks: (B:3:0x0003, B:6:0x002c, B:7:0x0047, B:10:0x0055, B:12:0x0076, B:14:0x0094, B:16:0x009a, B:18:0x009f, B:20:0x00a5, B:34:0x00ed, B:36:0x00f3, B:37:0x00f8), top: B:45:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    public static java.lang.String a(android.content.Context context) {
        java.lang.String str;
        java.io.File file;
        java.lang.String strA;
        java.lang.String strA2 = null;
        try {
            boolean zA = io.dcloud.p.l1.a(context);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(context.getFilesDir());
            java.lang.String str2 = java.io.File.separator;
            sb.append(str2);
            sb.append(".imei.txt");
            java.lang.String string = sb.toString();
            java.io.File file2 = new java.io.File(string);
            if (!file2.exists()) {
                string = context.getFilesDir() + str2 + ".DC4278477faeb9.txt";
                file2 = new java.io.File(string);
            }
            if (!"mounted".equalsIgnoreCase(android.os.Environment.getExternalStorageState()) || zA) {
                str = null;
                file = null;
            } else {
                str = android.os.Environment.getExternalStorageDirectory() + str2 + ".imei.txt";
                file = new java.io.File(str);
                if (!file.exists()) {
                    str = android.os.Environment.getExternalStorageDirectory() + str2 + ".DC4278477faeb9.txt";
                    file = new java.io.File(str);
                }
            }
            if (file2.isDirectory()) {
                file2.delete();
            }
            if (file == null || !file.exists() || file.length() <= 0) {
                strA = a(file2, file, string, str, context);
            } else if (zA) {
                try {
                    if (android.os.Build.VERSION.SDK_INT < 29) {
                        strA2 = a(new java.io.FileInputStream(file));
                    }
                    if (!android.text.TextUtils.isEmpty(strA2)) {
                        if (!file2.getParentFile().exists()) {
                            file2.getParentFile().mkdirs();
                            file2.createNewFile();
                        }
                        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file2);
                        fileOutputStream.write(strA2.getBytes());
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                } catch (java.lang.Exception unused) {
                }
                if (android.text.TextUtils.isEmpty(strA2)) {
                    return strA2;
                }
                strA = a(file2, file, string, str, context);
            } else {
                strA2 = a(new java.io.FileInputStream(file));
                if (!android.text.TextUtils.isEmpty(strA2)) {
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                        file2.createNewFile();
                    }
                    java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file2);
                    fileOutputStream2.write(strA2.getBytes());
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                }
                if (android.text.TextUtils.isEmpty(strA2)) {
                    return strA2;
                }
                strA = a(file2, file, string, str, context);
            }
            return strA;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static java.lang.String a(java.io.File file, java.io.File file2, java.lang.String str, java.lang.String str2, android.content.Context context) {
        java.lang.String strA;
        if (file.exists() && file.length() > 0) {
            try {
                strA = a(new java.io.FileInputStream(file));
                if (file2 != null) {
                    try {
                        if (!io.dcloud.p.l1.a(context)) {
                            if (!file2.getParentFile().exists()) {
                                file2.getParentFile().mkdirs();
                                file2.createNewFile();
                            }
                            io.dcloud.p.v0.a(str, str2);
                            return strA;
                        }
                    } catch (java.lang.Exception unused) {
                        return strA == null ? a(context, file, file2, ".DC4278477faeb9.txt") : strA;
                    }
                }
                return strA;
            } catch (java.lang.Exception unused2) {
                strA = null;
            }
        } else {
            return a(context, file, file2, ".DC4278477faeb9.txt");
        }
    }

    private static java.lang.String a(android.content.Context context, java.io.File file, java.io.File file2, java.lang.String str) throws java.io.IOException {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        java.lang.String strReplace = java.util.UUID.randomUUID().toString().replaceAll(com.taobao.weex.el.parse.Operators.SUB, "").replace("\n", "");
        byte[] bytes = strReplace.getBytes();
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
            if (!io.dcloud.p.l1.a(context)) {
                io.dcloud.p.v0.a(file.getPath(), file2.getPath());
                return strReplace;
            }
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        }
        return strReplace;
    }

    public static java.lang.String a(java.io.InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        return b(inputStream).toString();
    }
}
