package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class BuildProperties {
    private static java.lang.String BUILD_PROPERTIES_FILE_NAME = ".buildPropertiesMD5.data";
    private static java.lang.String BUILD_PROPERTIES_FILE_PATH = "";
    private static volatile io.dcloud.common.util.BuildProperties ourInstance;
    private java.util.Properties properties;

    private BuildProperties() throws java.lang.Exception {
        java.util.Properties properties = new java.util.Properties();
        this.properties = properties;
        properties.load(new java.io.FileInputStream(new java.io.File(android.os.Environment.getRootDirectory(), "build.prop")));
    }

    public static io.dcloud.common.util.BuildProperties getInstance() throws java.lang.Exception {
        if (ourInstance == null) {
            synchronized (io.dcloud.common.util.BuildProperties.class) {
                if (ourInstance == null) {
                    ourInstance = new io.dcloud.common.util.BuildProperties();
                }
            }
        }
        return ourInstance;
    }

    public boolean containsKey(java.lang.Object obj) {
        return this.properties.containsKey(obj);
    }

    public boolean containsValue(java.lang.Object obj) {
        return this.properties.containsValue(obj);
    }

    public java.util.Set<java.util.Map.Entry<java.lang.Object, java.lang.Object>> entrySet() {
        return this.properties.entrySet();
    }

    public java.lang.String getBuildPropertiesLimit(android.content.Context context) throws java.lang.Throwable {
        if (io.dcloud.common.adapter.util.DeviceInfo.isSDcardExists()) {
            BUILD_PROPERTIES_FILE_PATH = io.dcloud.common.adapter.util.DeviceInfo.sBaseFsCachePath;
        } else {
            if (context == null) {
                return "";
            }
            BUILD_PROPERTIES_FILE_PATH = context.getFilesDir().getAbsolutePath();
        }
        try {
            java.lang.String strMd5 = io.dcloud.common.util.Md5Utils.md5(new java.io.File(android.os.Environment.getRootDirectory(), "build.prop"));
            if (strMd5 != null) {
                java.lang.String str = BUILD_PROPERTIES_FILE_PATH + java.io.File.separator + BUILD_PROPERTIES_FILE_NAME;
                java.io.File file = new java.io.File(str);
                if (file.exists()) {
                    java.lang.String stringFile = io.dcloud.common.util.IOUtil.readStringFile(str);
                    if (!android.text.TextUtils.isEmpty(stringFile) && !stringFile.equals(strMd5)) {
                    }
                } else {
                    file.createNewFile();
                }
                io.dcloud.common.util.IOUtil.writeStringFile(str, strMd5);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                java.util.Properties properties = this.properties;
                if (properties != null) {
                    for (java.util.Map.Entry entry : properties.entrySet()) {
                        jSONObject.put(entry.getKey().toString(), entry.getValue());
                    }
                }
                java.lang.String string = jSONObject.toString();
                if (string != null && !"".equals(string.trim())) {
                    return string;
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public java.lang.String getProperty(java.lang.String str) {
        return this.properties.getProperty(str);
    }

    public boolean isEmpty() {
        return this.properties.isEmpty();
    }

    public java.util.Set keySet() {
        return this.properties.keySet();
    }

    public java.util.Enumeration keys() {
        return this.properties.keys();
    }

    public int size() {
        return this.properties.size();
    }

    public java.util.Collection values() {
        return this.properties.values();
    }

    public java.lang.String getProperty(java.lang.String str, java.lang.String str2) {
        return this.properties.getProperty(str, str2);
    }
}
