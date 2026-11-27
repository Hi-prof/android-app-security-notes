package io.dcloud.share;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public interface IFShareApi extends io.dcloud.common.DHInterface.IReflectAble {
    public static final java.lang.String mLink = "https://ask.dcloud.net.cn/article/287";

    void authorize(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2);

    void dispose();

    void forbid(io.dcloud.common.DHInterface.IWebview iWebview);

    java.lang.String getId();

    java.lang.String getJsonObject(io.dcloud.common.DHInterface.IWebview iWebview);

    void initConfig();

    void send(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2);
}
