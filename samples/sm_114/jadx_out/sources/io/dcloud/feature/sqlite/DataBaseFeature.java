package io.dcloud.feature.sqlite;

/* JADX INFO: loaded from: classes2.dex */
public class DataBaseFeature extends io.dcloud.common.DHInterface.StandardFeature {
    public java.util.HashMap<java.lang.String, android.database.sqlite.SQLiteDatabase> map = new java.util.HashMap<>();
    private java.lang.String resultMessage = "{'code':%d,'message':\"%s\"}";

    /* JADX WARN: Code duplicated, block: B:9:0x0027  */
    public void openDatabase(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        int i;
        java.lang.String strOptString = jSONArray.optString(0);
        java.lang.String strOptString2 = jSONArray.optString(1);
        java.lang.String strOptString3 = jSONArray.optString(2);
        if (io.dcloud.common.util.PdrUtil.isEmpty(strOptString2) || io.dcloud.common.util.PdrUtil.isEmpty(strOptString3)) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strOptString, io.dcloud.common.util.StringUtil.format(this.resultMessage, -1404, io.dcloud.common.constant.DOMException.toString("parameter can't be null")), io.dcloud.common.util.JSUtil.ERROR, true, false);
            return;
        }
        if (strOptString3.startsWith(io.dcloud.common.util.BaseInfo.REL_PRIVATE_WWW_DIR)) {
            i = 1;
        } else {
            i = 268435456;
            if (!io.dcloud.common.util.PdrUtil.isDeviceRootDir(strOptString3) && !strOptString3.startsWith(io.dcloud.common.util.BaseInfo.REL_PRIVATE_DOC_DIR) && !strOptString3.startsWith(io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOCUMENTS_DIR) && !strOptString3.startsWith(io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOWNLOADS_DIR)) {
                i = 1;
            }
        }
        java.lang.String strConvert2AbsFullPath = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), strOptString3);
        if (!io.dcloud.common.util.PdrUtil.isDeviceRootDir(strConvert2AbsFullPath)) {
            java.lang.String str = io.dcloud.common.adapter.util.DeviceInfo.sBaseFsRootPath + strConvert2AbsFullPath;
            if (!new java.io.File(str).exists()) {
                io.dcloud.common.adapter.io.DHFile.copyAssetsFile(strConvert2AbsFullPath, str);
            }
            strConvert2AbsFullPath = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), str);
            i = 1;
        }
        if (!new java.io.File(strConvert2AbsFullPath).exists() && i == 1) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strOptString, io.dcloud.common.util.StringUtil.format(this.resultMessage, -1403, io.dcloud.common.constant.DOMException.toString("Cannot create file private directory,such as:\\'www\\'")), io.dcloud.common.util.JSUtil.ERROR, true, false);
            return;
        }
        java.io.File file = new java.io.File(strConvert2AbsFullPath);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                file.createNewFile();
            } catch (java.io.IOException unused) {
            }
        }
        if (this.map.containsKey(strOptString2)) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strOptString, io.dcloud.common.util.StringUtil.format(this.resultMessage, -1402, io.dcloud.common.constant.DOMException.toString("Same Name Already Open")), io.dcloud.common.util.JSUtil.ERROR, true, false);
            return;
        }
        try {
            this.map.put(strOptString2, android.database.sqlite.SQLiteDatabase.openDatabase(strConvert2AbsFullPath, null, i, null));
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strOptString, "{}", io.dcloud.common.util.JSUtil.OK, true, false);
        } catch (java.lang.Exception e) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("code", -1404);
                jSONObject.put("message", io.dcloud.common.constant.DOMException.toString(e.toString()));
            } catch (org.json.JSONException unused2) {
            }
            io.dcloud.common.util.JSUtil.execCallback(iWebview, strOptString, jSONObject, io.dcloud.common.util.JSUtil.ERROR, false);
        }
    }

    public java.lang.String isOpenDatabase(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(0);
        if (io.dcloud.common.util.PdrUtil.isEmpty(jSONObjectOptJSONObject)) {
            return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(com.taobao.weex.common.Constants.Name.UNDEFINED, false);
        }
        java.lang.String strOptString = jSONObjectOptJSONObject.optString("name");
        java.lang.String strOptString2 = jSONObjectOptJSONObject.optString(io.dcloud.common.constant.AbsoluteConst.XML_PATH);
        if (io.dcloud.common.util.PdrUtil.isEmpty(strOptString) || io.dcloud.common.util.PdrUtil.isEmpty(strOptString2)) {
            return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(com.taobao.weex.common.Constants.Name.UNDEFINED, false);
        }
        java.util.Iterator<java.lang.String> it = this.map.keySet().iterator();
        while (it.hasNext()) {
            android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.map.get(it.next());
            java.lang.String strConvert2AbsFullPath = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), strOptString2);
            if (!io.dcloud.common.util.PdrUtil.isDeviceRootDir(strConvert2AbsFullPath)) {
                strConvert2AbsFullPath = io.dcloud.common.adapter.util.DeviceInfo.sBaseFsRootPath + strConvert2AbsFullPath;
            }
            if (strConvert2AbsFullPath.equalsIgnoreCase(sQLiteDatabase.getPath())) {
                return io.dcloud.common.util.JSUtil.wrapJsVar(true);
            }
        }
        if (this.map.containsKey(strOptString)) {
            return io.dcloud.common.util.JSUtil.wrapJsVar(true);
        }
        return io.dcloud.common.util.JSUtil.wrapJsVar(false);
    }

    public void closeDatabase(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        java.lang.String strOptString = jSONArray.optString(0);
        java.lang.String strOptString2 = jSONArray.optString(1);
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.map.get(strOptString2);
        if (io.dcloud.common.util.PdrUtil.isEmpty(strOptString2)) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strOptString, io.dcloud.common.util.StringUtil.format(this.resultMessage, -1404, io.dcloud.common.constant.DOMException.toString("parameter can't be null")), io.dcloud.common.util.JSUtil.ERROR, true, false);
        } else {
            if (sQLiteDatabase == null) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strOptString, io.dcloud.common.util.StringUtil.format(this.resultMessage, java.lang.Integer.valueOf(io.dcloud.common.constant.DOMException.CODE_STATISTICS_SERVICE_INVALID), io.dcloud.common.constant.DOMException.toString("Not Open")), io.dcloud.common.util.JSUtil.ERROR, true, false);
                return;
            }
            sQLiteDatabase.close();
            this.map.remove(strOptString2);
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strOptString, "{}", io.dcloud.common.util.JSUtil.OK, true, false);
        }
    }

    public void transaction(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.common.DHInterface.IWebview iWebview2;
        java.lang.Exception exc;
        java.lang.String strOptString = jSONArray.optString(0);
        java.lang.String strOptString2 = jSONArray.optString(1);
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.map.get(strOptString2);
        java.lang.String strOptString3 = jSONArray.optString(2);
        if (io.dcloud.common.util.PdrUtil.isEmpty(strOptString2) || io.dcloud.common.util.PdrUtil.isEmpty(strOptString3)) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strOptString, io.dcloud.common.util.StringUtil.format(this.resultMessage, -1404, io.dcloud.common.constant.DOMException.toString("parameter can't be null")), io.dcloud.common.util.JSUtil.ERROR, true, false);
            return;
        }
        if (sQLiteDatabase == null) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strOptString, io.dcloud.common.util.StringUtil.format(this.resultMessage, java.lang.Integer.valueOf(io.dcloud.common.constant.DOMException.CODE_STATISTICS_SERVICE_INVALID), io.dcloud.common.constant.DOMException.toString("Not Open")), io.dcloud.common.util.JSUtil.ERROR, true, false);
            return;
        }
        try {
            try {
                if (strOptString3.equals("begin")) {
                    sQLiteDatabase.beginTransaction();
                } else if (strOptString3.equals("commit")) {
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                } else {
                    if (!strOptString3.equals("rollback")) {
                        try {
                            iWebview2 = iWebview;
                            try {
                                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview2, strOptString, io.dcloud.common.util.StringUtil.format(this.resultMessage, -1404, io.dcloud.common.constant.DOMException.toString("Operation Error")), io.dcloud.common.util.JSUtil.ERROR, true, false);
                                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview2, strOptString, "{}", io.dcloud.common.util.JSUtil.OK, true, false);
                            } catch (java.lang.Exception e) {
                                e = e;
                            }
                        } catch (java.lang.Exception e2) {
                            iWebview2 = iWebview;
                            exc = e2;
                        }
                    } else {
                        sQLiteDatabase.endTransaction();
                    }
                    exc = e;
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    try {
                        jSONObject.put("code", -1404);
                        jSONObject.put("message", io.dcloud.common.constant.DOMException.toString(exc.toString()));
                    } catch (org.json.JSONException unused) {
                    }
                    io.dcloud.common.util.JSUtil.execCallback(iWebview2, strOptString, jSONObject, io.dcloud.common.util.JSUtil.ERROR, false);
                    return;
                }
                iWebview2 = iWebview;
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview2, strOptString, "{}", io.dcloud.common.util.JSUtil.OK, true, false);
            } catch (java.lang.Exception e3) {
                exc = e3;
                iWebview2 = iWebview;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            iWebview2 = iWebview;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [io.dcloud.common.DHInterface.IWebview] */
    /* JADX WARN: Type inference failed for: r4v6, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r4v7, types: [io.dcloud.common.DHInterface.IWebview] */
    public void executeSql(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        ?? jSONArray2;
        java.lang.String strOptString = jSONArray.optString(0);
        java.lang.String strOptString2 = jSONArray.optString(1);
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.map.get(strOptString2);
        java.lang.String strOptString3 = jSONArray.optString(2);
        if (io.dcloud.common.util.PdrUtil.isEmpty(strOptString2) || io.dcloud.common.util.PdrUtil.isEmpty(strOptString3)) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strOptString, io.dcloud.common.util.StringUtil.format(this.resultMessage, -1404, io.dcloud.common.constant.DOMException.toString("parameter can't be null")), io.dcloud.common.util.JSUtil.ERROR, true, false);
            return;
        }
        if (sQLiteDatabase == null) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strOptString, io.dcloud.common.util.StringUtil.format(this.resultMessage, java.lang.Integer.valueOf(io.dcloud.common.constant.DOMException.CODE_STATISTICS_SERVICE_INVALID), io.dcloud.common.constant.DOMException.toString("Not Open")), io.dcloud.common.util.JSUtil.ERROR, true, false);
            return;
        }
        try {
            jSONArray2 = new org.json.JSONArray(strOptString3);
            try {
                if (jSONArray2.length() > 0) {
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        java.lang.String strOptString4 = jSONArray2.optString(i);
                        if (!android.text.TextUtils.isEmpty(strOptString4.trim())) {
                            sQLiteDatabase.execSQL(strOptString4);
                        }
                    }
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strOptString, "{}", io.dcloud.common.util.JSUtil.OK, true, false);
                    return;
                }
                jSONArray2 = iWebview;
                java.lang.String str = this.resultMessage;
                java.lang.String string = io.dcloud.common.constant.DOMException.toString("parameter can't be null");
                try {
                    java.lang.Object[] objArr = new java.lang.Object[2];
                    try {
                        objArr[0] = -1404;
                        objArr[1] = string;
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(jSONArray2, strOptString, io.dcloud.common.util.StringUtil.format(str, objArr), io.dcloud.common.util.JSUtil.ERROR, true, false);
                        return;
                    } catch (java.lang.Exception e) {
                        e = e;
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            jSONArray2 = iWebview;
        }
        try {
            if (e instanceof android.database.SQLException) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("code", -1404);
                    jSONObject.put("message", io.dcloud.common.constant.DOMException.toString(e.toString()));
                } catch (org.json.JSONException unused) {
                }
                io.dcloud.common.util.JSUtil.execCallback((io.dcloud.common.DHInterface.IWebview) jSONArray2, strOptString, jSONObject, io.dcloud.common.util.JSUtil.ERROR, false);
                return;
            }
            sQLiteDatabase.execSQL(strOptString3);
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(jSONArray2, strOptString, "{}", io.dcloud.common.util.JSUtil.OK, true, false);
        } catch (java.lang.Exception e5) {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                jSONObject2.put("code", -1404);
                jSONObject2.put("message", io.dcloud.common.constant.DOMException.toString(e5.toString()));
            } catch (org.json.JSONException unused2) {
            }
            io.dcloud.common.util.JSUtil.execCallback((io.dcloud.common.DHInterface.IWebview) jSONArray2, strOptString, jSONObject2, io.dcloud.common.util.JSUtil.ERROR, false);
        }
    }

    public void selectSql(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        java.lang.String str;
        java.lang.String str2 = "code";
        java.lang.String strOptString = jSONArray.optString(0);
        java.lang.String strOptString2 = jSONArray.optString(1);
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.map.get(strOptString2);
        if (sQLiteDatabase == null) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strOptString, io.dcloud.common.util.StringUtil.format(this.resultMessage, java.lang.Integer.valueOf(io.dcloud.common.constant.DOMException.CODE_STATISTICS_SERVICE_INVALID), io.dcloud.common.constant.DOMException.toString("Not Open")), io.dcloud.common.util.JSUtil.ERROR, true, false);
            return;
        }
        java.lang.String strOptString3 = jSONArray.optString(2);
        if (io.dcloud.common.util.PdrUtil.isEmpty(strOptString2) || io.dcloud.common.util.PdrUtil.isEmpty(strOptString3)) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strOptString, io.dcloud.common.util.StringUtil.format(this.resultMessage, -1404, io.dcloud.common.constant.DOMException.toString("parameter can't be null")), io.dcloud.common.util.JSUtil.ERROR, true, false);
            return;
        }
        try {
            android.database.Cursor cursorRawQuery = sQLiteDatabase.rawQuery(strOptString3, null);
            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
            try {
                if (cursorRawQuery.moveToFirst()) {
                    java.lang.String[] columnNames = cursorRawQuery.getColumnNames();
                    while (true) {
                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                        int i = 0;
                        while (i < columnNames.length) {
                            int type = cursorRawQuery.getType(i);
                            if (type == 0) {
                                str = str2;
                                jSONObject.put(columnNames[i], org.json.JSONObject.NULL);
                            } else if (type == 1 || type == 2) {
                                str = str2;
                                try {
                                    try {
                                        jSONObject.put(columnNames[i], new java.math.BigDecimal(java.lang.String.valueOf(cursorRawQuery.getDouble(i))).doubleValue());
                                    } catch (org.json.JSONException unused) {
                                    }
                                } catch (java.lang.Exception e) {
                                    e = e;
                                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                                    try {
                                        jSONObject2.put(str, -1404);
                                        jSONObject2.put("message", io.dcloud.common.constant.DOMException.toString(e.toString()));
                                    } catch (org.json.JSONException unused2) {
                                    }
                                    io.dcloud.common.util.JSUtil.execCallback(iWebview, strOptString, jSONObject2, io.dcloud.common.util.JSUtil.ERROR, false);
                                    return;
                                }
                            } else {
                                if (type == 3) {
                                    jSONObject.put(columnNames[i], cursorRawQuery.getString(i));
                                } else if (type == 4) {
                                    try {
                                        jSONObject.put(columnNames[i], java.util.Arrays.toString(cursorRawQuery.getBlob(i)));
                                    } catch (org.json.JSONException unused3) {
                                    }
                                }
                                str = str2;
                            }
                            i++;
                            str2 = str;
                        }
                        str = str2;
                        jSONArray2.put(jSONObject);
                        if (!cursorRawQuery.moveToNext()) {
                            break;
                        } else {
                            str2 = str;
                        }
                    }
                } else {
                    str = str2;
                }
                cursorRawQuery.close();
                io.dcloud.common.util.JSUtil.execCallback(iWebview, strOptString, jSONArray2, io.dcloud.common.util.JSUtil.OK, false);
            } catch (java.lang.Exception e2) {
                e = e2;
                str = str2;
            }
        } catch (java.lang.Exception e3) {
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            try {
                jSONObject3.put(str2, -1404);
                jSONObject3.put("message", io.dcloud.common.constant.DOMException.toString(e3.toString()));
            } catch (org.json.JSONException unused4) {
            }
            io.dcloud.common.util.JSUtil.execCallback(iWebview, strOptString, jSONObject3, io.dcloud.common.util.JSUtil.ERROR, false);
        }
    }
}
