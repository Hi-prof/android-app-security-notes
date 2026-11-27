package io.dcloud.feature.weex.config;

/* JADX INFO: loaded from: classes2.dex */
public class MimeInfoParser {
    java.util.HashSet<java.lang.String> registerFileTypeSet = new java.util.HashSet<>();
    java.util.HashSet<java.lang.String> registerFileFormatSet = new java.util.HashSet<>();
    java.util.HashSet<java.lang.String> registerEncodeFormatSet = new java.util.HashSet<>();
    final java.lang.String DATA_FLAG = "data:";
    final java.lang.String FILE_TYPE_FLAG = "/";
    final java.lang.String FILE_FORMAT_FLAG = ";";
    final java.lang.String ENCODE_FORMAT_FLAG = ",";

    public static io.dcloud.feature.weex.config.MimeInfoParser getInstance() {
        return new io.dcloud.feature.weex.config.MimeInfoParser();
    }

    private MimeInfoParser() {
        this.registerFileTypeSet.add("keystore");
        this.registerFileTypeSet.add("cert");
        this.registerFileFormatSet.add("p12");
        this.registerFileFormatSet.add("pem");
        this.registerEncodeFormatSet.add("filepath");
        this.registerEncodeFormatSet.add("base64");
        this.registerEncodeFormatSet.add("text");
    }

    public static java.io.InputStream getFilePathStream(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str) {
        if (wXSDKInstance != null) {
            try {
                java.io.File file = new java.io.File(new java.net.URI(wXSDKInstance.getURIAdapter().rewrite(wXSDKInstance, "file", android.net.Uri.parse(str)).toString()));
                if (file.exists()) {
                    return new java.io.FileInputStream(file);
                }
                java.io.File file2 = new java.io.File(io.dcloud.feature.weex.config.UniPathParser.getAndroidPath(str));
                if (file2.exists()) {
                    return new java.io.FileInputStream(file2);
                }
                return null;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static class MimeInfo {
        private java.lang.String dataContent;
        private java.lang.String encodeFormat;
        private java.lang.String fileFormat;
        private java.lang.String fileType;

        public java.io.InputStream getDataBytes(com.taobao.weex.WXSDKInstance wXSDKInstance) {
            if ("base64".equals(this.encodeFormat)) {
                return new java.io.ByteArrayInputStream(android.util.Base64.decode(this.dataContent, 2));
            }
            if ("text".equals(this.encodeFormat)) {
                return new java.io.ByteArrayInputStream(this.dataContent.getBytes());
            }
            if ("filepath".equals(this.encodeFormat) && wXSDKInstance != null) {
                try {
                    return new java.io.FileInputStream(new java.io.File(new java.net.URI(wXSDKInstance.getURIAdapter().rewrite(wXSDKInstance, "file", android.net.Uri.parse(this.dataContent)).toString())));
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isValid(io.dcloud.feature.weex.config.MimeInfoParser mimeInfoParser) {
            return (android.text.TextUtils.isEmpty(this.fileType) || android.text.TextUtils.isEmpty(this.fileFormat) || android.text.TextUtils.isEmpty(this.encodeFormat) || android.text.TextUtils.isEmpty(this.dataContent) || !mimeInfoParser.registerFileTypeSet.contains(this.fileType) || !mimeInfoParser.registerFileFormatSet.contains(this.fileFormat) || !mimeInfoParser.registerEncodeFormatSet.contains(this.encodeFormat)) ? false : true;
        }

        public java.lang.String getFileType() {
            return this.fileType;
        }

        public void setFileType(java.lang.String str) {
            this.fileType = str;
        }

        public java.lang.String getFileFormat() {
            return this.fileFormat;
        }

        public void setFileFormat(java.lang.String str) {
            this.fileFormat = str;
        }

        public java.lang.String getEncodeFormat() {
            return this.encodeFormat;
        }

        public void setEncodeFormat(java.lang.String str) {
            this.encodeFormat = str;
        }

        public java.lang.String getDataContent() {
            return this.dataContent;
        }

        public void setDataContent(java.lang.String str) {
            this.dataContent = str;
        }
    }

    public io.dcloud.feature.weex.config.MimeInfoParser.MimeInfo obtainMimeInfo(java.lang.String str) {
        io.dcloud.feature.weex.config.MimeInfoParser.MimeInfo mimeInfo = parseMimeInfo(str);
        if (mimeInfo == null || mimeInfo.isValid(this)) {
            return mimeInfo;
        }
        return null;
    }

    private io.dcloud.feature.weex.config.MimeInfoParser.MimeInfo parseMimeInfo(java.lang.String str) {
        io.dcloud.feature.weex.config.MimeInfoParser.MimeInfo mimeInfo = new io.dcloud.feature.weex.config.MimeInfoParser.MimeInfo();
        if (!str.startsWith("data:") || !str.contains("/") || !str.contains(";") || !str.contains(",")) {
            return null;
        }
        java.lang.String strSubstring = str.substring(5);
        java.lang.String strSubstring2 = strSubstring.substring(0, strSubstring.indexOf("/"));
        mimeInfo.fileType = strSubstring2;
        java.lang.String strSubstring3 = strSubstring.substring((strSubstring2 + "/").length());
        java.lang.String strSubstring4 = strSubstring3.substring(0, strSubstring3.indexOf(";"));
        mimeInfo.fileFormat = strSubstring4;
        java.lang.String strSubstring5 = strSubstring3.substring((strSubstring4 + ";").length());
        java.lang.String strSubstring6 = strSubstring5.substring(0, strSubstring5.indexOf(","));
        mimeInfo.encodeFormat = strSubstring6;
        mimeInfo.dataContent = strSubstring5.substring((strSubstring6 + ",").length());
        return mimeInfo;
    }
}
