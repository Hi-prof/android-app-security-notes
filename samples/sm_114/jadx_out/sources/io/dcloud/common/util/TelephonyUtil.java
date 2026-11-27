package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class TelephonyUtil {
    private static java.lang.String AIDKEY = "aid";
    private static java.lang.String AId = "";
    private static java.lang.String IMEI1_KEY = "II1";
    private static java.lang.String IMEI2_KEY = "II2";
    private static java.lang.String[] MultiIMEITemp = null;
    private static java.lang.String MultiIMEI_KEY = "mmikey";
    private static final java.lang.String OLD_UUID_FILE_NAME = ".imei.txt";
    public static final java.lang.String TAG = "TelephonyUtil";
    private static final java.lang.String UUID_FILE_NAME = ".DC4278477faeb9.txt";
    private static boolean isGetAId = false;
    private static boolean isGetMultiIMEI = false;
    private static java.lang.String randomId = null;
    private static java.lang.String sImei = "";
    private static java.lang.String sOriginalImeiAndBakInfo;
    private static java.lang.Boolean isGetRdId = java.lang.Boolean.FALSE;
    private static java.lang.String sIMSI = null;
    private static boolean isGetIMSI = false;
    private static java.lang.String IMSI_KEY = "isi";
    private static java.lang.String sMac = null;
    private static boolean isGetMac = false;
    private static java.lang.String MAC_KEY = "mc";
    private static java.lang.String mImei = "";

    private static boolean checkPseudoData(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str) || str.contains("000000")) {
            return true;
        }
        str.hashCode();
        switch (str) {
            case "020000000000":
            case "9F89C84A559F573636A47FF8DAED0D33":
            case "E3F5536A141811DB40EFD6400F1D0A4E":
            case "00000000-0000-0000-0000-000000000000":
                return true;
            default:
                return false;
        }
    }

    private static java.lang.String createRandomBSFile(android.content.Context context, java.io.File file, java.io.File file2, java.lang.String str) throws java.io.IOException {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        java.lang.String strReplaceAll = java.util.UUID.randomUUID().toString().replaceAll(com.taobao.weex.el.parse.Operators.SUB, "").replaceAll("\n", "");
        byte[] bytes = strReplaceAll.getBytes();
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
            if (!io.dcloud.common.util.FileUtil.needMediaStoreOpenFile(context) && file2 != null) {
                io.dcloud.common.adapter.io.DHFile.copyFile(file.getPath(), file2.getPath());
                return strReplaceAll;
            }
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        }
        return strReplaceAll;
    }

    public static java.lang.String getAId(android.content.Context context) {
        if (!isGetAId) {
            if (androidx.core.content.ContextCompat.checkSelfPermission(context, com.hjq.permissions.Permission.READ_PHONE_STATE) != 0) {
                return AId;
            }
            android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(context, io.dcloud.common.adapter.util.SP.N_DEVICE_INFO);
            if (orCreateBundle.contains(AIDKEY)) {
                java.lang.String string = orCreateBundle.getString(AIDKEY, null);
                if (!io.dcloud.common.util.PdrUtil.isEmpty(string)) {
                    AId = io.dcloud.common.util.Base64.decodeString(string, true, 10);
                }
            } else {
                java.lang.String string2 = android.provider.Settings.Secure.getString(context.getContentResolver(), io.dcloud.p.e1.a("aWZsemdhbFdhbA=="));
                AId = string2;
                io.dcloud.common.adapter.util.SP.setBundleData(orCreateBundle, AIDKEY, io.dcloud.common.util.PdrUtil.isEmpty(string2) ? AId : io.dcloud.common.util.Base64.encodeString(AId, true, 10));
            }
            isGetAId = true;
        }
        return AId;
    }

    private static java.lang.String getAPSubId(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return null;
        }
        if (!io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(context)) {
            return "";
        }
        try {
            java.lang.Object objInvokeMethod = io.dcloud.common.util.ReflectUtils.invokeMethod(context.getSystemService("phone"), io.dcloud.p.e1.a("b218W31qe2t6YWptekFs"), new java.lang.Class[0], new java.lang.Object[0]);
            if (objInvokeMethod != null) {
                return (java.lang.String) objInvokeMethod;
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002d  */
    public static java.lang.String getDCloudDeviceID(android.content.Context context) {
        java.lang.String strJoin;
        java.lang.String bundleData = io.dcloud.common.adapter.util.SP.getBundleData(context, io.dcloud.common.util.BaseInfo.PDR, "android_device_dcloud_id");
        if (!checkPseudoData(bundleData)) {
            return bundleData;
        }
        if (android.os.Build.VERSION.SDK_INT <= 28 || io.dcloud.common.util.PdrUtil.isEmpty(io.dcloud.common.adapter.util.DeviceInfo.oaids)) {
            strJoin = "";
        } else {
            java.lang.String[] strArrSplit = io.dcloud.common.adapter.util.DeviceInfo.oaids.split("\\|");
            if (strArrSplit.length > 0) {
                strJoin = strArrSplit[0];
            } else {
                strJoin = "";
            }
        }
        if (checkPseudoData(strJoin)) {
            java.lang.String[] strArr = MultiIMEITemp;
            strJoin = strArr != null ? android.text.TextUtils.join(",", strArr) : "";
            if (checkPseudoData(strJoin)) {
                strJoin = getRandomId(context);
                if (checkPseudoData(strJoin)) {
                    strJoin = "";
                }
            }
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(strJoin)) {
            return "";
        }
        java.lang.String strMd5LowerCase32Bit = io.dcloud.common.util.Md5Utils.md5LowerCase32Bit(strJoin);
        io.dcloud.common.adapter.util.SP.setBundleData(context, io.dcloud.common.util.BaseInfo.PDR, "android_device_dcloud_id", strMd5LowerCase32Bit);
        return strMd5LowerCase32Bit;
    }

    public static java.lang.String getIMEI(android.content.Context context) {
        return getIMEI(context, true);
    }

    public static java.lang.String[] getMultiIMEI(android.content.Context context) {
        java.lang.String strOptString;
        java.lang.String strOptString2;
        if (androidx.core.content.ContextCompat.checkSelfPermission(context, com.hjq.permissions.Permission.READ_PHONE_STATE) != 0) {
            return null;
        }
        if (io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(context)) {
            return MultiIMEITemp;
        }
        if (isGetMultiIMEI) {
            return MultiIMEITemp;
        }
        android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(context, io.dcloud.common.adapter.util.SP.N_DEVICE_INFO);
        if (orCreateBundle.contains(MultiIMEI_KEY)) {
            java.lang.String string = orCreateBundle.getString(MultiIMEI_KEY, null);
            if (io.dcloud.common.util.PdrUtil.isEmpty(string)) {
                strOptString = null;
                strOptString2 = null;
            } else {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(io.dcloud.common.util.Base64.decodeString(string, true, 10));
                    strOptString = jSONObject.optString(IMEI1_KEY);
                    try {
                        strOptString2 = jSONObject.optString(IMEI2_KEY);
                    } catch (org.json.JSONException unused) {
                        strOptString2 = null;
                    }
                } catch (org.json.JSONException unused2) {
                    strOptString = null;
                }
            }
            isGetMultiIMEI = true;
        } else {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            try {
                strOptString = (java.lang.String) io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(telephonyManager.getClass().getName(), "getDeviceId", telephonyManager);
                if (isUnValid(strOptString)) {
                    strOptString = null;
                }
                try {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put(IMEI1_KEY, strOptString);
                    jSONObject2.put(IMEI2_KEY, (java.lang.Object) null);
                    io.dcloud.common.adapter.util.SP.setBundleData(orCreateBundle, MultiIMEI_KEY, io.dcloud.common.util.Base64.encodeString(jSONObject2.toString(), true, 10));
                } catch (java.lang.Exception unused3) {
                }
            } catch (java.lang.Exception unused4) {
                strOptString = null;
            }
            strOptString2 = null;
        }
        if (!isUnValid(strOptString) && !isUnValid(strOptString2)) {
            MultiIMEITemp = new java.lang.String[]{strOptString, strOptString2};
        } else if (!isUnValid(strOptString)) {
            MultiIMEITemp = new java.lang.String[]{strOptString};
        } else if (isUnValid(strOptString2)) {
            MultiIMEITemp = null;
        } else {
            MultiIMEITemp = new java.lang.String[]{strOptString2};
        }
        isGetMultiIMEI = true;
        return MultiIMEITemp;
    }

    private static java.lang.Object getPhoneInfo(int i, android.content.Context context) {
        try {
            java.lang.Object systemService = context.getSystemService("phone");
            java.lang.String strA = io.dcloud.p.e1.a("b218W31qe2t6YWptekFs");
            int i2 = android.os.Build.VERSION.SDK_INT;
            if (i2 > 21) {
                return io.dcloud.common.util.ReflectUtils.invokeMethod(systemService, strA, new java.lang.Class[]{java.lang.Integer.TYPE}, new java.lang.Object[]{java.lang.Integer.valueOf(i)});
            }
            if (i2 == 21) {
                return io.dcloud.common.util.ReflectUtils.invokeMethod(systemService, strA, new java.lang.Class[]{java.lang.Long.TYPE}, new java.lang.Object[]{java.lang.Integer.valueOf(i)});
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00cb A[Catch: Exception -> 0x010e, all -> 0x011f, TryCatch #0 {Exception -> 0x010e, blocks: (B:30:0x00c4, B:36:0x00e2, B:38:0x00e8, B:40:0x00f2, B:41:0x00fc, B:33:0x00cb, B:35:0x00da), top: B:54:0x00c4 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00da A[Catch: Exception -> 0x010e, all -> 0x011f, TryCatch #0 {Exception -> 0x010e, blocks: (B:30:0x00c4, B:36:0x00e2, B:38:0x00e8, B:40:0x00f2, B:41:0x00fc, B:33:0x00cb, B:35:0x00da), top: B:54:0x00c4 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00e8 A[Catch: Exception -> 0x010e, all -> 0x011f, TryCatch #0 {Exception -> 0x010e, blocks: (B:30:0x00c4, B:36:0x00e2, B:38:0x00e8, B:40:0x00f2, B:41:0x00fc, B:33:0x00cb, B:35:0x00da), top: B:54:0x00c4 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00f2 A[Catch: Exception -> 0x010e, all -> 0x011f, TryCatch #0 {Exception -> 0x010e, blocks: (B:30:0x00c4, B:36:0x00e2, B:38:0x00e8, B:40:0x00f2, B:41:0x00fc, B:33:0x00cb, B:35:0x00da), top: B:54:0x00c4 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0114 A[Catch: all -> 0x011f, Exception -> 0x0121, TryCatch #1 {Exception -> 0x0121, blocks: (B:7:0x000e, B:10:0x0037, B:11:0x0052, B:14:0x0060, B:16:0x0068, B:18:0x0089, B:20:0x00a7, B:22:0x00ad, B:24:0x00b2, B:26:0x00b8, B:42:0x010e, B:44:0x0114, B:45:0x0119), top: B:56:0x000e }] */
    public static java.lang.String getRandomId(android.content.Context context) {
        java.lang.String str;
        java.io.File file;
        java.lang.String strSavePublicFile;
        if (isGetRdId.booleanValue()) {
            return randomId;
        }
        java.lang.String string = null;
        try {
            boolean zNeedMediaStoreOpenFile = io.dcloud.common.util.FileUtil.needMediaStoreOpenFile(context);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(context.getFilesDir());
            java.lang.String str2 = java.io.File.separator;
            sb.append(str2);
            sb.append(OLD_UUID_FILE_NAME);
            java.lang.String string2 = sb.toString();
            java.io.File file2 = new java.io.File(string2);
            if (!file2.exists()) {
                string2 = context.getFilesDir() + str2 + UUID_FILE_NAME;
                file2 = new java.io.File(string2);
            }
            if ("mounted".equalsIgnoreCase(android.os.Environment.getExternalStorageState()) && !zNeedMediaStoreOpenFile && androidx.core.content.ContextCompat.checkSelfPermission(context, com.hjq.permissions.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
                str = android.os.Environment.getExternalStorageDirectory() + str2 + OLD_UUID_FILE_NAME;
                file = new java.io.File(str);
                if (!file.exists()) {
                    str = android.os.Environment.getExternalStorageDirectory() + str2 + UUID_FILE_NAME;
                    file = new java.io.File(str);
                }
            } else {
                str = null;
                file = null;
            }
            if (file2.isDirectory()) {
                file2.delete();
            }
            if (file != null && file.exists() && file.length() > 0) {
                if (zNeedMediaStoreOpenFile) {
                    try {
                        if (android.os.Build.VERSION.SDK_INT < 29) {
                            string = io.dcloud.common.util.IOUtil.toString(new java.io.FileInputStream(file));
                            if (!io.dcloud.common.util.PdrUtil.isEmpty(string)) {
                                string = string.replace("\n", "");
                            }
                        }
                        if (!android.text.TextUtils.isEmpty(string)) {
                            if (!file2.getParentFile().exists()) {
                                file2.getParentFile().mkdirs();
                                file2.createNewFile();
                            }
                            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file2);
                            fileOutputStream.write(string.getBytes());
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                    } catch (java.lang.Exception unused) {
                    }
                    if (android.text.TextUtils.isEmpty(string)) {
                        strSavePublicFile = savePublicFile(file2, file, string2, str, context);
                    }
                } else {
                    string = io.dcloud.common.util.IOUtil.toString(new java.io.FileInputStream(file));
                    if (!io.dcloud.common.util.PdrUtil.isEmpty(string)) {
                        string = string.replace("\n", "");
                    }
                    if (!android.text.TextUtils.isEmpty(string)) {
                        if (!file2.getParentFile().exists()) {
                            file2.getParentFile().mkdirs();
                            file2.createNewFile();
                        }
                        java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file2);
                        fileOutputStream2.write(string.getBytes());
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    }
                    if (android.text.TextUtils.isEmpty(string)) {
                        strSavePublicFile = savePublicFile(file2, file, string2, str, context);
                    }
                }
                randomId = string;
                isGetRdId = java.lang.Boolean.TRUE;
                return string;
            }
            strSavePublicFile = savePublicFile(file2, file, string2, str, context);
            string = strSavePublicFile;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        randomId = string;
        isGetRdId = java.lang.Boolean.TRUE;
        return string;
    }

    public static java.lang.String getSBBS(android.content.Context context, boolean z, boolean z2) {
        return getSBBS(context, z, z2, true);
    }

    private static int getSubId(int i, android.content.Context context) {
        android.net.Uri uri = android.net.Uri.parse("content://telephony/siminfo");
        android.content.ContentResolver contentResolver = context.getContentResolver();
        android.database.Cursor cursorQuery = null;
        try {
            cursorQuery = contentResolver.query(uri, new java.lang.String[]{"_id", "sim_id"}, "sim_id = ?", new java.lang.String[]{java.lang.String.valueOf(i)}, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                cursorQuery.close();
                return i2;
            }
            if (cursorQuery == null) {
                return -1;
            }
        } catch (java.lang.Exception unused) {
            if (cursorQuery == null) {
                return -1;
            }
        } catch (java.lang.Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            cursorQuery.close();
            throw th;
        }
        cursorQuery.close();
        return -1;
    }

    @java.lang.Deprecated
    public static java.lang.String getWifiData(android.content.Context context) {
        java.lang.Object objInvokeMethod;
        java.lang.String strReplace = null;
        if (io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(context)) {
            return null;
        }
        if (isGetMac) {
            return sMac;
        }
        android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(context, io.dcloud.common.adapter.util.SP.N_DEVICE_INFO);
        if (orCreateBundle.contains(MAC_KEY)) {
            java.lang.String string = orCreateBundle.getString(MAC_KEY, null);
            if (!io.dcloud.common.util.PdrUtil.isEmpty(string)) {
                sMac = io.dcloud.common.util.Base64.decodeString(string, true, 10);
            }
        } else {
            java.lang.Object systemService = context.getSystemService(io.dcloud.p.e1.a("f2FuYQ=="));
            if (systemService != null && (objInvokeMethod = io.dcloud.common.util.ReflectUtils.invokeMethod(systemService, io.dcloud.p.e1.a("b218S2dmZm1rfGFnZkFmbmc"), new java.lang.Class[0], new java.lang.Object[0])) != null) {
                java.lang.Object objInvokeMethod2 = io.dcloud.common.util.ReflectUtils.invokeMethod(objInvokeMethod, io.dcloud.p.e1.a("b218RWlrSWxsem17ew"), new java.lang.Class[0], new java.lang.Object[0]);
                java.lang.String str = objInvokeMethod2 != null ? (java.lang.String) objInvokeMethod2 : null;
                if (!android.text.TextUtils.isEmpty(str)) {
                    strReplace = str.replace(":", "");
                }
            }
            sMac = strReplace;
            io.dcloud.common.adapter.util.SP.setBundleData(orCreateBundle, MAC_KEY, io.dcloud.common.util.PdrUtil.isEmpty(strReplace) ? sMac : io.dcloud.common.util.Base64.encodeString(sMac, true, 10));
        }
        isGetMac = true;
        return sMac;
    }

    private static boolean isUnValid(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) || str.contains("Unknown") || str.contains("00000000");
    }

    private static java.lang.String savePublicFile(java.io.File file, java.io.File file2, java.lang.String str, java.lang.String str2, android.content.Context context) throws java.io.IOException {
        java.lang.String string;
        if (!file.exists() || file.length() <= 0) {
            return createRandomBSFile(context, file, file2, UUID_FILE_NAME);
        }
        try {
            string = io.dcloud.common.util.IOUtil.toString(new java.io.FileInputStream(file));
            try {
                if (!io.dcloud.common.util.PdrUtil.isEmpty(string)) {
                    string = string.replaceAll("\n", "");
                }
                if (file2 != null && !io.dcloud.common.util.FileUtil.needMediaStoreOpenFile(context)) {
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                        file2.createNewFile();
                    }
                    io.dcloud.common.adapter.io.DHFile.copyFile(str, str2);
                    return string;
                }
                return string;
            } catch (java.lang.Exception unused) {
                return string == null ? createRandomBSFile(context, file, file2, UUID_FILE_NAME) : string;
            }
        } catch (java.lang.Exception unused2) {
            string = null;
        }
    }

    public static java.lang.String updateIMEI(android.content.Context context) {
        if (!io.dcloud.common.util.PdrUtil.isEmpty(mImei)) {
            return mImei;
        }
        java.lang.String[] multiIMEI = getMultiIMEI(context);
        if (multiIMEI == null) {
            mImei = "";
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str : multiIMEI) {
            sb.append(str);
            sb.append(",");
        }
        if (sb.lastIndexOf(",") >= sb.length() - 1) {
            java.lang.String string = sb.deleteCharAt(sb.length() - 1).toString();
            mImei = string;
            return string;
        }
        java.lang.String string2 = sb.toString();
        mImei = string2;
        return string2;
    }

    public static java.lang.String getIMEI(android.content.Context context, boolean z) {
        return getIMEI(context, z, false);
    }

    /* JADX WARN: Code duplicated, block: B:110:0x012c A[PHI: r4
  0x012c: PHI (r4v16 java.lang.String) = (r4v15 java.lang.String), (r4v17 java.lang.String) binds: [B:108:0x0129, B:100:0x011a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:50:0x0095 A[PHI: r5
  0x0095: PHI (r5v3 java.lang.String) = (r5v2 java.lang.String), (r5v6 java.lang.String) binds: [B:49:0x0093, B:38:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:81:0x00e2  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.StringBuffer] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.lang.CharSequence] */
    public static java.lang.String getSBBS(android.content.Context context, boolean z, boolean z2, boolean z3) throws java.lang.Throwable {
        ?? r12;
        java.lang.String str;
        ?? r3;
        java.lang.String aId;
        java.lang.String strReplace;
        java.lang.String strReplace2;
        ?? stringBuffer = new java.lang.StringBuffer();
        if (z) {
            stringBuffer.append("|");
        }
        java.lang.String str2 = "";
        if (context == null) {
            return z ? "|||||" : "";
        }
        if (io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(context)) {
            r12 = z3;
            r12 = 0;
        }
        if (z && !android.text.TextUtils.isEmpty(sOriginalImeiAndBakInfo)) {
            return sOriginalImeiAndBakInfo;
        }
        if (!isUnValid(sImei) && !z) {
            return sImei;
        }
        if (isUnValid(sImei) || z) {
            try {
                if (r12 != 0) {
                    try {
                        java.lang.String[] multiIMEI = getMultiIMEI(context);
                        if (multiIMEI == null || multiIMEI.length <= 0) {
                            str = "";
                        } else {
                            str = multiIMEI[0];
                            try {
                                if (multiIMEI.length > 1) {
                                    str = str + "," + multiIMEI[1];
                                }
                            } catch (java.lang.Exception e) {
                                e = e;
                                io.dcloud.common.adapter.util.Logger.e(TAG, "getsbbs exception==" + e.getMessage());
                                if (z) {
                                    stringBuffer.append(str).append("|");
                                }
                            }
                        }
                        sImei = str;
                        if (z) {
                            stringBuffer.append(str).append("|");
                        }
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        str = "";
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (z) {
                            stringBuffer.append(str2).append("|");
                        }
                        throw th;
                    }
                } else if (z) {
                    stringBuffer.append("|");
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                str2 = null;
            }
        }
        if (z) {
            stringBuffer.append("|");
        }
        boolean zIsUnValid = isUnValid(sImei);
        ?? r4 = 0;
        randomId = null;
        java.lang.String randomId2 = null;
        if (z) {
            try {
                if (r12 != 0) {
                    try {
                        aId = getAId(context);
                        if (zIsUnValid) {
                            try {
                                sImei = aId;
                            } catch (java.lang.Exception e3) {
                                e = e3;
                                e.printStackTrace();
                                if (z) {
                                    if (android.text.TextUtils.isEmpty(aId)) {
                                        aId = "";
                                    }
                                    stringBuffer.append(aId).append("|");
                                }
                            }
                        }
                        if (z) {
                            if (android.text.TextUtils.isEmpty(aId)) {
                                aId = "";
                            }
                            stringBuffer.append(aId).append("|");
                        }
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        aId = null;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        if (z) {
                            if (!android.text.TextUtils.isEmpty(r4)) {
                                r3 = str2;
                                r3 = r4;
                            }
                            r3 = str2;
                            stringBuffer.append(r3).append("|");
                        }
                        throw th;
                    }
                } else if (z) {
                    stringBuffer.append("|");
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                r4 = r12;
            }
        }
        boolean zIsUnValid2 = isUnValid(sImei);
        if (zIsUnValid2 || z) {
            try {
                try {
                    randomId2 = getRandomId(context);
                    if (zIsUnValid2) {
                        sImei = randomId2;
                    }
                    if (z) {
                        if (!android.text.TextUtils.isEmpty(randomId2)) {
                            strReplace2 = str2;
                            strReplace2 = str2;
                            strReplace2 = randomId2.replace("\n", "");
                        }
                        strReplace2 = str2;
                        strReplace2 = str2;
                        stringBuffer.append(strReplace2).append("|");
                    }
                } catch (java.lang.Exception e5) {
                    e5.printStackTrace();
                    if (z) {
                        if (!android.text.TextUtils.isEmpty(randomId2)) {
                            strReplace2 = str2;
                            strReplace2 = str2;
                            strReplace2 = randomId2.replace("\n", "");
                        }
                        strReplace2 = str2;
                        strReplace2 = str2;
                        stringBuffer.append(strReplace2).append("|");
                    }
                }
            } catch (java.lang.Throwable th5) {
                if (z) {
                    if (!android.text.TextUtils.isEmpty(randomId2)) {
                        strReplace = str2;
                        strReplace = randomId2.replace("\n", "");
                    }
                    strReplace = str2;
                    stringBuffer.append(strReplace).append("|");
                }
                throw th5;
            }
        }
        if (!z) {
            return sImei;
        }
        java.lang.String string = stringBuffer.toString();
        sOriginalImeiAndBakInfo = string;
        return string;
    }

    public static java.lang.String getSimOperator(android.content.Context context) {
        if (io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(context)) {
            return "";
        }
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
        return telephonyManager.getSimState() == 5 ? telephonyManager.getSimOperator() : "";
    }

    public static java.lang.String getIMEI(android.content.Context context, boolean z, boolean z2) {
        return getSBBS(context, z, z2);
    }

    public static java.lang.String getIMEIS(android.content.Context context) {
        try {
            java.lang.String[] multiIMEI = getMultiIMEI(context);
            return multiIMEI != null ? android.text.TextUtils.join(",", multiIMEI) : "";
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String getIMSI(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (androidx.core.content.ContextCompat.checkSelfPermission(context, com.hjq.permissions.Permission.READ_PHONE_STATE) != 0) {
                return "";
            }
            boolean zHasPrivacyForNotShown = io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(context);
            if (!isGetIMSI && !zHasPrivacyForNotShown) {
                java.lang.String str = sIMSI;
                if (str != null) {
                    return str;
                }
                android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(context, io.dcloud.common.adapter.util.SP.N_DEVICE_INFO);
                if (orCreateBundle.contains(IMSI_KEY)) {
                    java.lang.String string = orCreateBundle.getString(IMSI_KEY, null);
                    if (!io.dcloud.common.util.PdrUtil.isEmpty(string)) {
                        sIMSI = io.dcloud.common.util.Base64.decodeString(string, true, 10);
                    }
                } else {
                    int subId = getSubId(0, context);
                    int subId2 = getSubId(1, context);
                    if (subId == -1 && subId2 == -1) {
                        sIMSI = getAPSubId(context);
                    } else {
                        java.lang.String str2 = (java.lang.String) getPhoneInfo(subId, context);
                        java.lang.String str3 = (java.lang.String) getPhoneInfo(subId2, context);
                        if (!io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
                            sIMSI = str2;
                            if (!io.dcloud.common.util.PdrUtil.isEmpty(str3) && !str2.equals(str3)) {
                                sIMSI += "," + str3;
                            }
                        } else if (!io.dcloud.common.util.PdrUtil.isEmpty(str3)) {
                            sIMSI = str3;
                        } else {
                            sIMSI = getAPSubId(context);
                        }
                    }
                    io.dcloud.common.adapter.util.SP.setBundleData(orCreateBundle, IMSI_KEY, io.dcloud.common.util.PdrUtil.isEmpty(sIMSI) ? sIMSI : io.dcloud.common.util.Base64.encodeString(sIMSI, true, 10));
                }
                isGetIMSI = true;
                return sIMSI;
            }
            return sIMSI;
        } catch (java.lang.Exception unused) {
        }
    }
}
