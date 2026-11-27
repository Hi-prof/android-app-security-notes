package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IJsInterface {
    @java.lang.Deprecated
    java.lang.String exec(java.lang.String str, java.lang.String str2, java.lang.String str3);

    java.lang.String exec(java.lang.String str, java.lang.String str2, org.json.JSONArray jSONArray);

    void forceStop(java.lang.String str);

    java.lang.String prompt(java.lang.String str, java.lang.String str2);
}
