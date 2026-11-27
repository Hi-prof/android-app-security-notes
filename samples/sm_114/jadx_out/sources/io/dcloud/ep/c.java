package io.dcloud.ep;

/* JADX INFO: compiled from: r8-map-id-b089b3ef14a7698b6fddd362455d593b6c2b269fff47748e8001e74ff4f7bd31 */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private java.util.HashMap a;

    /* JADX INFO: compiled from: r8-map-id-b089b3ef14a7698b6fddd362455d593b6c2b269fff47748e8001e74ff4f7bd31 */
    private static class b {
        public static final io.dcloud.ep.c a = new io.dcloud.ep.c();
    }

    public static io.dcloud.ep.c a() {
        return io.dcloud.ep.c.b.a;
    }

    public void b(java.lang.String str) {
        this.a.remove(str);
    }

    private c() {
        this.a = new java.util.HashMap();
    }

    public void a(java.lang.String str, java.util.Map map) {
        this.a.put(str, map);
    }

    public java.util.Map a(java.lang.String str) {
        return (java.util.Map) this.a.get(str);
    }

    public static void a(java.lang.String str, org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2;
        if (jSONObject == null || !jSONObject.has(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_RESOURCES) || (jSONObject2 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_RESOURCES)) == null) {
            return;
        }
        java.util.HashMap map = new java.util.HashMap();
        java.util.Iterator<java.lang.String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            java.lang.String next = itKeys.next();
            if (jSONObject2.has(next)) {
                try {
                    org.json.JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                    if (jSONObject3 != null && jSONObject3.has(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_ALGORITHM) && jSONObject3.has(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY)) {
                        jSONObject3.getString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_ALGORITHM);
                        map.put(next, jSONObject3.getString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY));
                    }
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        if (map.size() > 0) {
            a().b(str);
            a().a(str, map);
        }
    }

    public static java.lang.String a(android.content.Context context, byte[] bArr) {
        if (bArr != null && bArr.length > 8) {
            if (bArr[0] == 5 && bArr[1] == 15 && bArr[2] == 53 && bArr[3] == 43) {
                byte b2 = bArr[7];
                java.lang.String hexString = java.lang.Integer.toHexString(bArr[5] & 255);
                java.lang.String hexString2 = java.lang.Integer.toHexString(bArr[6] & 255);
                int i = (java.lang.Integer.parseInt(hexString, 16) << 8) + java.lang.Integer.parseInt(hexString2, 16);
                byte[] bArr2 = new byte[i];
                for (int i2 = 0; i2 < i; i2++) {
                    bArr2[i2] = bArr[i2 + 8];
                }
                try {
                    java.lang.String str = new java.lang.String(io.dcloud.ep.d.a(bArr2, io.dcloud.ep.d.a(io.dcloud.ep.b.a(context, b2))));
                    byte[] bArr3 = new byte[(bArr.length - i) - 8];
                    for (int i3 = 0; i3 < (bArr.length - i) - 8; i3++) {
                        bArr3[i3] = bArr[i3 + i + 8];
                    }
                    return io.dcloud.ep.a.a(io.dcloud.ep.a.a(bArr3), str, io.dcloud.common.util.Base64.decodeString(io.dcloud.ep.b.a(), true, 64));
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005d  */
    /* JADX WARN: Code duplicated, block: B:23:0x005f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0062  */
    /* JADX WARN: Code duplicated, block: B:34:0x008a A[Catch: Exception -> 0x0095, TRY_LEAVE, TryCatch #2 {Exception -> 0x0095, blocks: (B:32:0x0084, B:34:0x008a), top: B:69:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0097  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ab A[Catch: Exception -> 0x010b, FileNotFoundException -> 0x0110, TryCatch #3 {FileNotFoundException -> 0x0110, Exception -> 0x010b, blocks: (B:42:0x00a4, B:48:0x00bb, B:52:0x00c5, B:55:0x00d1, B:57:0x00ed, B:60:0x00fe, B:62:0x0105, B:44:0x00ab, B:46:0x00b1), top: B:71:0x00a0 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00c5 A[Catch: Exception -> 0x010b, FileNotFoundException -> 0x0110, TryCatch #3 {FileNotFoundException -> 0x0110, Exception -> 0x010b, blocks: (B:42:0x00a4, B:48:0x00bb, B:52:0x00c5, B:55:0x00d1, B:57:0x00ed, B:60:0x00fe, B:62:0x0105, B:44:0x00ab, B:46:0x00b1), top: B:71:0x00a0 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d1 A[Catch: Exception -> 0x010b, FileNotFoundException -> 0x0110, TryCatch #3 {FileNotFoundException -> 0x0110, Exception -> 0x010b, blocks: (B:42:0x00a4, B:48:0x00bb, B:52:0x00c5, B:55:0x00d1, B:57:0x00ed, B:60:0x00fe, B:62:0x0105, B:44:0x00ab, B:46:0x00b1), top: B:71:0x00a0 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ed A[Catch: Exception -> 0x010b, FileNotFoundException -> 0x0110, TryCatch #3 {FileNotFoundException -> 0x0110, Exception -> 0x010b, blocks: (B:42:0x00a4, B:48:0x00bb, B:52:0x00c5, B:55:0x00d1, B:57:0x00ed, B:60:0x00fe, B:62:0x0105, B:44:0x00ab, B:46:0x00b1), top: B:71:0x00a0 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0105 A[Catch: Exception -> 0x010b, FileNotFoundException -> 0x0110, TRY_LEAVE, TryCatch #3 {FileNotFoundException -> 0x0110, Exception -> 0x010b, blocks: (B:42:0x00a4, B:48:0x00bb, B:52:0x00c5, B:55:0x00d1, B:57:0x00ed, B:60:0x00fe, B:62:0x0105, B:44:0x00ab, B:46:0x00b1), top: B:71:0x00a0 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:? A[RETURN, SYNTHETIC] */
    public static java.io.InputStream a(java.lang.String str, io.dcloud.common.DHInterface.IApp iApp) {
        java.lang.String str2;
        java.io.File file;
        boolean z;
        boolean z2;
        java.io.InputStream fileInputStream;
        byte[] bArrA;
        byte[] bytes;
        java.util.Map mapA;
        android.net.Uri uri;
        if (android.text.TextUtils.isEmpty(str) || iApp == null || android.webkit.URLUtil.isNetworkUrl(str)) {
            return null;
        }
        java.lang.String strStripQuery = io.dcloud.common.util.PdrUtil.stripQuery(io.dcloud.common.util.PdrUtil.stripAnchor(str));
        java.lang.String relPath = io.dcloud.common.adapter.ui.webview.WebResUtil.getRelPath(strStripQuery, iApp);
        try {
            if (io.dcloud.common.adapter.ui.webview.WebResUtil.isWap2appTemplateFile(iApp, relPath) && io.dcloud.common.util.BaseInfo.isWap2AppAppid(iApp.obtainAppId())) {
                java.util.Map mapA2 = a().a("__w2a__template__");
                file = new java.io.File(io.dcloud.common.adapter.ui.webview.WebResUtil.handleWap2appTemplateFilePath(relPath));
                if (mapA2 == null || !mapA2.containsKey(relPath)) {
                    str2 = null;
                } else {
                    str2 = (java.lang.String) mapA2.get(relPath);
                    z = true;
                }
                if (iApp.obtainRunningAppMode() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (file == null) {
                    mapA = a().a(iApp.obtainAppId());
                    if (mapA != null && mapA.containsKey(relPath)) {
                        str2 = (java.lang.String) mapA.get(relPath);
                    }
                    if (strStripQuery.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                        try {
                            uri = android.net.Uri.parse(strStripQuery);
                            if (uri != null) {
                                file = new java.io.File(uri.getPath());
                            }
                        } catch (java.lang.Exception unused) {
                        }
                    } else {
                        file = new java.io.File(strStripQuery);
                    }
                }
                if (file != null && !z2) {
                    return null;
                }
                if (z2 && !z) {
                    fileInputStream = io.dcloud.common.adapter.util.PlatformUtil.getInputStream(str, 0);
                } else if (file == null && file.exists()) {
                    fileInputStream = io.dcloud.common.util.FileUtil.getFileInputStream(iApp.getActivity(), file);
                } else {
                    fileInputStream = null;
                }
                if (!android.text.TextUtils.isEmpty(str2)) {
                    if (z) {
                        bArrA = io.dcloud.common.util.BaseInfo.mW2AE.get(relPath);
                    } else {
                        bArrA = null;
                    }
                    if (bArrA == null) {
                        java.io.DataInputStream dataInputStream = new java.io.DataInputStream(fileInputStream);
                        bytes = io.dcloud.common.util.IOUtil.getBytes(dataInputStream);
                        io.dcloud.common.util.IOUtil.close(dataInputStream);
                        bArrA = io.dcloud.ep.a.a(bytes, str2, io.dcloud.common.util.Base64.decodeString(io.dcloud.ep.b.a(), true, 64));
                        if (bArrA == null) {
                            bArrA = io.dcloud.ep.a.a(bytes, str2, io.dcloud.common.util.Base64.decodeString(io.dcloud.ep.b.a(), true, 64));
                        }
                        if (z && bArrA != null) {
                            io.dcloud.common.util.BaseInfo.mW2AE.put(relPath, bArrA);
                        }
                    }
                    if (bArrA != null) {
                        return null;
                    }
                    fileInputStream = new java.io.ByteArrayInputStream(bArrA);
                }
                return fileInputStream;
            }
            str2 = null;
            file = null;
            if (z2) {
                if (file == null) {
                    fileInputStream = null;
                } else {
                    fileInputStream = null;
                }
            } else if (file == null) {
                fileInputStream = null;
            } else {
                fileInputStream = null;
            }
            if (!android.text.TextUtils.isEmpty(str2)) {
                if (z) {
                    bArrA = io.dcloud.common.util.BaseInfo.mW2AE.get(relPath);
                } else {
                    bArrA = null;
                }
                if (bArrA == null) {
                    java.io.DataInputStream dataInputStream2 = new java.io.DataInputStream(fileInputStream);
                    bytes = io.dcloud.common.util.IOUtil.getBytes(dataInputStream2);
                    io.dcloud.common.util.IOUtil.close(dataInputStream2);
                    bArrA = io.dcloud.ep.a.a(bytes, str2, io.dcloud.common.util.Base64.decodeString(io.dcloud.ep.b.a(), true, 64));
                    if (bArrA == null) {
                        bArrA = io.dcloud.ep.a.a(bytes, str2, io.dcloud.common.util.Base64.decodeString(io.dcloud.ep.b.a(), true, 64));
                    }
                    if (z) {
                        io.dcloud.common.util.BaseInfo.mW2AE.put(relPath, bArrA);
                    }
                }
                if (bArrA != null) {
                    return null;
                }
                fileInputStream = new java.io.ByteArrayInputStream(bArrA);
            }
            return fileInputStream;
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
        z = false;
        if (iApp.obtainRunningAppMode() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (file == null) {
            mapA = a().a(iApp.obtainAppId());
            if (mapA != null) {
                str2 = (java.lang.String) mapA.get(relPath);
            }
            if (strStripQuery.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                uri = android.net.Uri.parse(strStripQuery);
                if (uri != null) {
                    file = new java.io.File(uri.getPath());
                }
            } else {
                file = new java.io.File(strStripQuery);
            }
        }
        if (file != null) {
        }
    }
}
