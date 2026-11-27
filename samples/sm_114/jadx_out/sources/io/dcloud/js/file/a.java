package io.dcloud.js.file;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: io.dcloud.js.file.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class C0067a {
        long a;
        long b;
        int c = 0;
        int d = 0;

        C0067a() {
        }

        public org.json.JSONObject a() {
            try {
                return new org.json.JSONObject(java.lang.String.format(java.util.Locale.ENGLISH, "{lastModifiedDate : %d,size : %d,directoryCount : %d,fileCount : %d}", java.lang.Long.valueOf(this.a), java.lang.Long.valueOf(this.b), java.lang.Integer.valueOf(this.c), java.lang.Integer.valueOf(this.d)));
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                return new org.json.JSONObject();
            }
        }
    }

    protected static org.json.JSONObject a(java.lang.String str, long j, long j2, java.lang.String str2, java.lang.String str3) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("lastModifiedDate", j);
            jSONObject.put("type", str);
            jSONObject.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, j2);
            jSONObject.put("name", str2);
            jSONObject.put("fullPath", str3);
            return jSONObject;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    protected static org.json.JSONArray b(java.lang.String str, java.lang.String str2) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        java.lang.String str3 = java.io.File.separator;
        sb.append(str.endsWith(str3) ? "" : str3);
        java.lang.String string = sb.toString();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(str2);
        if (str2.endsWith(str3)) {
            str3 = "";
        }
        sb2.append(str3);
        java.lang.String string2 = sb2.toString();
        java.lang.String[] list = new java.io.File(string).list();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                java.lang.String str4 = string + list[i];
                java.io.File file = new java.io.File(str4);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                boolean zIsDirectory = file.isDirectory();
                java.lang.String str5 = list[i];
                java.lang.String str6 = string2 + str5;
                try {
                    jSONObject.put("isDirectory", zIsDirectory);
                    jSONObject.put("isFile", !zIsDirectory);
                    jSONObject.put("name", str5);
                    jSONObject.put("remoteURL", str6);
                    jSONObject.put("fullPath", str4);
                    jSONArray.put(jSONObject);
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONArray;
    }

    protected static org.json.JSONObject a(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("type", i);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("name", str2);
            jSONObject2.put("fullPath", str3);
            jSONObject2.put("remoteURL", str4);
            jSONObject.put("root", jSONObject2);
            return jSONObject;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    protected static org.json.JSONObject a(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("isDirectory", z);
            jSONObject.put("isFile", !z);
            jSONObject.put("name", str);
            jSONObject.put("remoteURL", str3);
            jSONObject.put("fullPath", str2);
            return jSONObject;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    protected static org.json.JSONObject a(java.lang.String str, java.lang.String str2, boolean z, java.lang.String str3, java.lang.String str4, int i, org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            jSONObject2.put("isDirectory", z);
            jSONObject2.put("isFile", !z);
            jSONObject2.put("name", str);
            jSONObject2.put("remoteURL", str3);
            jSONObject2.put("fullPath", str2);
            jSONObject2.put("fsName", str4);
            jSONObject2.put("type", i);
            jSONObject2.put("fsRoot", jSONObject);
            return jSONObject2;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return jSONObject2;
        }
    }

    public static org.json.JSONObject a(java.lang.String str, java.lang.String str2) {
        java.io.File file = new java.io.File(str);
        return a(str2, file.lastModified(), io.dcloud.common.adapter.io.DHFile.getFileSize(file), file.getName(), str);
    }

    public static org.json.JSONObject a(java.lang.String str, boolean z) {
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            return null;
        }
        io.dcloud.js.file.a.C0067a c0067a = new io.dcloud.js.file.a.C0067a();
        c0067a.a = file.lastModified();
        if (file.isDirectory()) {
            java.io.File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (java.io.File file2 : fileArrListFiles) {
                    a(file2, c0067a, z);
                }
            }
        } else {
            c0067a.b = file.length();
        }
        return c0067a.a();
    }

    public static void a(java.io.File file, io.dcloud.js.file.a.C0067a c0067a, boolean z) {
        java.io.File[] fileArrListFiles;
        if (file.isDirectory()) {
            if (z && (fileArrListFiles = file.listFiles()) != null) {
                for (java.io.File file2 : fileArrListFiles) {
                    a(file2, c0067a, z);
                }
            }
            c0067a.c++;
            return;
        }
        c0067a.b += file.length();
        c0067a.d++;
    }
}
