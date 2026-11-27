package io.dcloud.feature.weex.config;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidTlsConfig {
    private java.lang.String[] ca;
    private java.lang.String keystore;
    private java.lang.String storePass;

    public java.lang.String getKeystore() {
        return this.keystore;
    }

    public void setKeystore(java.lang.String str) {
        if (str == null) {
            str = "";
        }
        this.keystore = str;
    }

    public java.lang.String getStorePass() {
        return this.storePass;
    }

    public void setStorePass(java.lang.String str) {
        if (str == null) {
            str = "";
        }
        this.storePass = str;
    }

    public java.lang.String[] getCa() {
        return this.ca;
    }

    public void setCa(java.lang.String[] strArr) {
        if (strArr == null) {
            strArr = new java.lang.String[0];
        }
        this.ca = strArr;
    }

    public java.lang.String toString() {
        return "AndroidTlsConfig{keystore='" + this.keystore + "', storePass='" + this.storePass + "', ca=" + java.util.Arrays.toString(this.ca) + com.taobao.weex.el.parse.Operators.BLOCK_END;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            io.dcloud.feature.weex.config.AndroidTlsConfig androidTlsConfig = (io.dcloud.feature.weex.config.AndroidTlsConfig) obj;
            java.lang.String string = java.util.Arrays.toString(this.ca);
            java.lang.String string2 = java.util.Arrays.toString(androidTlsConfig.ca);
            if (this.keystore.equals(androidTlsConfig.keystore) && this.storePass.equals(androidTlsConfig.storePass) && string.equals(string2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (java.util.Objects.hash(this.keystore, this.storePass, java.util.Arrays.toString(this.ca)) * 31) + java.util.Arrays.hashCode(this.ca);
    }
}
