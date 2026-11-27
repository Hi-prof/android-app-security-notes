package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AssistInputUtil {
    private static final java.lang.String SP_KEY_CURRENT_ADDRESS = "assisiSettingCurrentAddress";
    private static final java.lang.String SP_KEY_DUTY_PARAGRAPH = "assisiSettingDutyParagraph";
    private static final java.lang.String SP_KEY_EMAIL_A = "assisiSettingEmailA";
    private static final java.lang.String SP_KEY_EMAIL_B = "assisiSettingEmailB";
    private static final java.lang.String SP_KEY_HOME_ADDRESS = "assisiSettingHomeAddress";
    private static final java.lang.String SP_KEY_ID = "assisiSettingId";
    private static final java.lang.String SP_KEY_NAME = "assisiSettingName";
    private static final java.lang.String SP_KEY_NAME_B = "assisiSettingNameB";
    private static final java.lang.String SP_KEY_PHONE_A = "assisiSettingPhoneA";
    private static final java.lang.String SP_KEY_PHONE_B = "assisiSettingPhoneB";
    private static final java.lang.String SP_KEY_WORK_ADDRESS = "assisiSettingWorkAddress";
    private static final java.lang.String SP_KEY_WORK_NAME = "assisiSettingWorkName";
    private static final java.lang.String SP_NAME = "assisiSetting";
    private static final int XORNUMBER = 6;

    public static synchronized void changeSaveDataToEncrypt(android.content.Context context) {
        if (context != null) {
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME, 0);
            if (sharedPreferences.getAll().isEmpty()) {
                sharedPreferences.edit().putInt("isEncrypt", 1).commit();
                return;
            }
            if (!sharedPreferences.contains("isEncrypt")) {
                android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                for (java.lang.String str : sharedPreferences.getAll().keySet()) {
                    java.lang.String string = sharedPreferences.getString(str, "");
                    if (!android.text.TextUtils.isEmpty(string)) {
                        editorEdit.putString(str, encrypt(string));
                    }
                }
                editorEdit.putInt("isEncrypt", 1);
                editorEdit.commit();
            }
        }
    }

    public static void clearData(android.content.Context context) {
        if (context != null) {
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(SP_NAME, 0).edit();
            editorEdit.clear();
            editorEdit.commit();
        }
    }

    private static java.lang.String encrypt(java.lang.String str) {
        if (str == null) {
            return null;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str = java.net.URLEncoder.encode(str, "utf-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return io.dcloud.common.util.Base64.encodeString(str, true, 6);
    }

    private static java.lang.String[] getCoreRecordViewSaveData(java.lang.String str) {
        java.lang.String[] strArrSplit = null;
        java.lang.String recordDatas = io.dcloud.common.adapter.ui.RecordView.getRecordDatas(null, str);
        if (!android.text.TextUtils.isEmpty(recordDatas)) {
            if (recordDatas.contains("&")) {
                try {
                    strArrSplit = recordDatas.split("&");
                    if (strArrSplit.length > 0) {
                        if (1 <= strArrSplit.length) {
                            strArrSplit[0] = java.net.URLDecoder.decode(strArrSplit[0], "utf-8");
                        }
                        if (2 <= strArrSplit.length) {
                            strArrSplit[1] = java.net.URLDecoder.decode(strArrSplit[1], "utf-8");
                        }
                    }
                    return strArrSplit;
                } catch (java.io.UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    strArrSplit = new java.lang.String[]{java.net.URLDecoder.decode(recordDatas, "utf-8")};
                    return strArrSplit;
                } catch (java.io.UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return strArrSplit;
    }

    public static java.lang.String getCurrentAddress(android.content.Context context) {
        return context != null ? decrypt(context.getSharedPreferences(SP_NAME, 0).getString(SP_KEY_CURRENT_ADDRESS, "")) : "";
    }

    public static java.lang.String getDutyParagraph(android.content.Context context) {
        return context != null ? decrypt(context.getSharedPreferences(SP_NAME, 0).getString(SP_KEY_DUTY_PARAGRAPH, "")) : "";
    }

    public static java.lang.String getEmailA(android.content.Context context) {
        return context != null ? decrypt(context.getSharedPreferences(SP_NAME, 0).getString(SP_KEY_EMAIL_A, "")) : "";
    }

    public static java.lang.String getEmailB(android.content.Context context) {
        return context != null ? decrypt(context.getSharedPreferences(SP_NAME, 0).getString(SP_KEY_EMAIL_B, "")) : "";
    }

    public static java.lang.String getHomeAddress(android.content.Context context) {
        return context != null ? decrypt(context.getSharedPreferences(SP_NAME, 0).getString(SP_KEY_HOME_ADDRESS, "")) : "";
    }

    public static java.lang.String getId(android.content.Context context) {
        return context != null ? decrypt(context.getSharedPreferences(SP_NAME, 0).getString(SP_KEY_ID, "")) : "";
    }

    public static java.lang.String getName(android.content.Context context) {
        return context != null ? decrypt(context.getSharedPreferences(SP_NAME, 0).getString(SP_KEY_NAME, "")) : "";
    }

    public static java.lang.String getNameB(android.content.Context context) {
        return context != null ? decrypt(context.getSharedPreferences(SP_NAME, 0).getString(SP_KEY_NAME_B, "")) : "";
    }

    public static java.lang.String getPhoneA(android.content.Context context) {
        return context != null ? decrypt(context.getSharedPreferences(SP_NAME, 0).getString(SP_KEY_PHONE_A, "")) : "";
    }

    public static java.lang.String getPhoneB(android.content.Context context) {
        return context != null ? decrypt(context.getSharedPreferences(SP_NAME, 0).getString(SP_KEY_PHONE_B, "")) : "";
    }

    public static java.lang.String[] getRecordViewCompany() {
        return getCoreRecordViewSaveData("company");
    }

    public static java.lang.String[] getRecordViewEmails() {
        return getCoreRecordViewSaveData("email");
    }

    public static java.lang.String[] getRecordViewId() {
        return getCoreRecordViewSaveData("id");
    }

    public static java.lang.String[] getRecordViewNames() {
        return getCoreRecordViewSaveData("nick");
    }

    public static java.lang.String[] getRecordViewPhones() {
        return getCoreRecordViewSaveData(com.taobao.weex.common.Constants.Value.TEL);
    }

    public static java.lang.String[] getRecordViewTax() {
        return getCoreRecordViewSaveData("tax");
    }

    public static java.lang.String getWorkAddress(android.content.Context context) {
        return context != null ? decrypt(context.getSharedPreferences(SP_NAME, 0).getString(SP_KEY_WORK_ADDRESS, "")) : "";
    }

    public static java.lang.String getWorkName(android.content.Context context) {
        return context != null ? decrypt(context.getSharedPreferences(SP_NAME, 0).getString(SP_KEY_WORK_NAME, "")) : "";
    }

    public static void saveAll(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        if (context != null) {
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(SP_NAME, 0).edit();
            if (str != null) {
                editorEdit.putString(SP_KEY_CURRENT_ADDRESS, encrypt(str));
            }
            if (str2 != null) {
                editorEdit.putString(SP_KEY_HOME_ADDRESS, encrypt(str2));
            }
            if (str3 != null) {
                editorEdit.putString(SP_KEY_WORK_ADDRESS, encrypt(str3));
            }
            if (str4 != null) {
                editorEdit.putString(SP_KEY_WORK_NAME, encrypt(str4));
            }
            if (str5 != null) {
                editorEdit.putString(SP_KEY_DUTY_PARAGRAPH, encrypt(str5));
            }
            if (str6 != null) {
                editorEdit.putString(SP_KEY_ID, encrypt(str6));
            }
            editorEdit.putInt("isEncrypt", 1);
            editorEdit.commit();
        }
    }

    public static void saveCompany(android.content.Context context, boolean z, java.lang.String str) {
        java.lang.String strEncode;
        if (context == null || !z) {
            return;
        }
        if (str != null) {
            try {
                strEncode = java.net.URLEncoder.encode(str, "utf-8");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            strEncode = null;
        }
        if (strEncode != null) {
            io.dcloud.common.adapter.ui.RecordView.setRcordDatas(context, (java.lang.String) null, "company", strEncode);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            if (android.text.TextUtils.isEmpty(str)) {
                io.dcloud.common.adapter.ui.RecordView.setAssisBundleData(context, "useAssistSettingCompany", "");
            }
        } else {
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(SP_NAME, 0).edit();
            editorEdit.putString(SP_KEY_WORK_NAME, encrypt(str));
            editorEdit.commit();
            io.dcloud.common.adapter.ui.RecordView.setAssisBundleData(context, "useAssistSettingCompany", "1");
        }
    }

    public static void saveCurrentAddress(android.content.Context context, java.lang.String str) {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        context.getSharedPreferences(SP_NAME, 0).edit().putString(SP_KEY_CURRENT_ADDRESS, encrypt(str)).commit();
    }

    public static void saveEmail(android.content.Context context, boolean z, java.lang.String str, java.lang.String str2) {
        java.lang.String strEncode;
        if (context == null || !z) {
            return;
        }
        if (str != null) {
            try {
                strEncode = java.net.URLEncoder.encode(str, "utf-8");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            strEncode = null;
        }
        if (str2 != null) {
            java.lang.String strEncode2 = java.net.URLEncoder.encode(str2, "utf-8");
            if (android.text.TextUtils.isEmpty(strEncode)) {
                strEncode = strEncode2;
            } else {
                strEncode = strEncode + "&" + strEncode2;
            }
        }
        if (strEncode != null) {
            io.dcloud.common.adapter.ui.RecordView.setRcordDatas(context, (java.lang.String) null, "email", strEncode);
        }
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
                io.dcloud.common.adapter.ui.RecordView.setAssisBundleData(context, "useAssistSettingEmail", "");
                return;
            }
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(SP_NAME, 0).edit();
        editorEdit.putString(SP_KEY_EMAIL_A, encrypt(str));
        editorEdit.putString(SP_KEY_EMAIL_B, encrypt(str2));
        editorEdit.commit();
        io.dcloud.common.adapter.ui.RecordView.setAssisBundleData(context, "useAssistSettingEmail", "1");
    }

    public static void saveId(android.content.Context context, boolean z, java.lang.String str) {
        java.lang.String strEncode;
        if (context == null || !z) {
            return;
        }
        if (str != null) {
            try {
                strEncode = java.net.URLEncoder.encode(str, "utf-8");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            strEncode = null;
        }
        if (strEncode != null) {
            io.dcloud.common.adapter.ui.RecordView.setRcordDatas(context, (java.lang.String) null, "id", strEncode);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            if (android.text.TextUtils.isEmpty(str)) {
                io.dcloud.common.adapter.ui.RecordView.setAssisBundleData(context, "useAssistSettingId", "");
            }
        } else {
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(SP_NAME, 0).edit();
            editorEdit.putString(SP_KEY_ID, encrypt(str));
            editorEdit.commit();
            io.dcloud.common.adapter.ui.RecordView.setAssisBundleData(context, "useAssistSettingId", "1");
        }
    }

    public static void saveName(android.content.Context context, boolean z, java.lang.String str, java.lang.String str2) {
        java.lang.String strEncode;
        if (context == null || !z) {
            return;
        }
        if (str != null) {
            try {
                strEncode = java.net.URLEncoder.encode(str, "utf-8");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            strEncode = null;
        }
        if (str2 != null) {
            java.lang.String strEncode2 = java.net.URLEncoder.encode(str2, "utf-8");
            if (android.text.TextUtils.isEmpty(strEncode)) {
                strEncode = strEncode2;
            } else {
                strEncode = strEncode + "&" + strEncode2;
            }
        }
        if (strEncode != null) {
            io.dcloud.common.adapter.ui.RecordView.setRcordDatas(context, (java.lang.String) null, "nick", strEncode);
        }
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
                io.dcloud.common.adapter.ui.RecordView.setAssisBundleData(context, "useAssistSettingName", "");
                return;
            }
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(SP_NAME, 0).edit();
        editorEdit.putString(SP_KEY_NAME, encrypt(str));
        editorEdit.putString(SP_KEY_NAME_B, encrypt(str2));
        editorEdit.commit();
        io.dcloud.common.adapter.ui.RecordView.setAssisBundleData(context, "useAssistSettingName", "1");
    }

    public static void savePhone(android.content.Context context, boolean z, java.lang.String str, java.lang.String str2) {
        java.lang.String strEncode;
        if (context == null || !z) {
            return;
        }
        if (str != null) {
            try {
                strEncode = java.net.URLEncoder.encode(str, "utf-8");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            strEncode = null;
        }
        if (str2 != null) {
            java.lang.String strEncode2 = java.net.URLEncoder.encode(str2, "utf-8");
            if (android.text.TextUtils.isEmpty(strEncode)) {
                strEncode = strEncode2;
            } else {
                strEncode = strEncode + "&" + strEncode2;
            }
        }
        if (strEncode != null) {
            io.dcloud.common.adapter.ui.RecordView.setRcordDatas(context, (java.lang.String) null, com.taobao.weex.common.Constants.Value.TEL, strEncode);
        }
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
                io.dcloud.common.adapter.ui.RecordView.setAssisBundleData(context, "useAssistSettingPhone", "");
                return;
            }
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(SP_NAME, 0).edit();
        editorEdit.putString(SP_KEY_PHONE_A, encrypt(str));
        editorEdit.putString(SP_KEY_PHONE_B, encrypt(str2));
        editorEdit.commit();
        io.dcloud.common.adapter.ui.RecordView.setAssisBundleData(context, "useAssistSettingPhone", "1");
    }

    public static void saveTax(android.content.Context context, boolean z, java.lang.String str) {
        java.lang.String strEncode;
        if (context == null || !z) {
            return;
        }
        if (str != null) {
            try {
                strEncode = java.net.URLEncoder.encode(str, "utf-8");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            strEncode = null;
        }
        if (strEncode != null) {
            io.dcloud.common.adapter.ui.RecordView.setRcordDatas(context, (java.lang.String) null, "tax", strEncode);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            if (android.text.TextUtils.isEmpty(str)) {
                io.dcloud.common.adapter.ui.RecordView.setAssisBundleData(context, "useAssistSettingTax", "");
            }
        } else {
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(SP_NAME, 0).edit();
            editorEdit.putString(SP_KEY_DUTY_PARAGRAPH, encrypt(str));
            editorEdit.commit();
            io.dcloud.common.adapter.ui.RecordView.setAssisBundleData(context, "useAssistSettingTax", "1");
        }
    }

    public static boolean useAssistSettingCompany() {
        return !android.text.TextUtils.isEmpty(io.dcloud.common.adapter.ui.RecordView.getAssisBundleData("useAssistSettingCompany"));
    }

    public static boolean useAssistSettingEmail() {
        return !android.text.TextUtils.isEmpty(io.dcloud.common.adapter.ui.RecordView.getAssisBundleData("useAssistSettingEmail"));
    }

    public static boolean useAssistSettingId() {
        return !android.text.TextUtils.isEmpty(io.dcloud.common.adapter.ui.RecordView.getAssisBundleData("useAssistSettingId"));
    }

    public static boolean useAssistSettingName() {
        return !android.text.TextUtils.isEmpty(io.dcloud.common.adapter.ui.RecordView.getAssisBundleData("useAssistSettingName"));
    }

    public static boolean useAssistSettingPhone() {
        return !android.text.TextUtils.isEmpty(io.dcloud.common.adapter.ui.RecordView.getAssisBundleData("useAssistSettingPhone"));
    }

    public static boolean useAssistSettingTax() {
        return !android.text.TextUtils.isEmpty(io.dcloud.common.adapter.ui.RecordView.getAssisBundleData("useAssistSettingTax"));
    }

    private static java.lang.String decrypt(java.lang.String str) {
        if (str == null || android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        java.lang.String strDecodeString = io.dcloud.common.util.Base64.decodeString(str, true, 6);
        if (io.dcloud.common.util.PdrUtil.isEmpty(strDecodeString)) {
            return "";
        }
        try {
            return java.net.URLDecoder.decode(strDecodeString, "utf-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return strDecodeString;
        }
    }

    public static void saveAll(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (context != null) {
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(SP_NAME, 0).edit();
            if (str != null) {
                editorEdit.putString(SP_KEY_CURRENT_ADDRESS, encrypt(str));
            }
            if (str2 != null) {
                editorEdit.putString(SP_KEY_HOME_ADDRESS, encrypt(str2));
            }
            if (str3 != null) {
                editorEdit.putString(SP_KEY_WORK_ADDRESS, encrypt(str3));
            }
            editorEdit.putInt("isEncrypt", 1);
            editorEdit.commit();
        }
    }
}
