package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IConfusionMgr {
    java.lang.String decodeString(java.lang.String str);

    java.lang.String decodeString(java.lang.String str, boolean z, int i);

    java.lang.String decryptStr(java.lang.String str);

    java.lang.String decryptStr(java.lang.String str, byte b);

    java.lang.String encodeString(java.lang.String str, boolean z, int i);

    java.lang.String getCSJClassName();

    java.util.Map<java.lang.String, java.lang.String> getData(java.lang.String str);

    java.io.InputStream getEncryptionInputStream(java.lang.String str, io.dcloud.common.DHInterface.IApp iApp);

    java.lang.String getGDTClassName();

    java.lang.String getKSClassName();

    java.lang.String getODS();

    java.lang.String getS5DS();

    java.lang.String getSIV();

    java.lang.String getSK();

    java.lang.String getSPK();

    java.lang.String getSQK();

    java.lang.String handleEncryption(android.content.Context context, byte[] bArr);

    boolean isV3Encryption();

    void recordEncryptionResources(java.lang.String str, org.json.JSONObject jSONObject);

    boolean recordEncryptionV3Resources(java.lang.String str, java.lang.String str2);

    void removeData(java.lang.String str);
}
