package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class Birdge implements io.dcloud.common.DHInterface.IJsInterface, io.dcloud.common.adapter.util.MessageHandler.IMessages {
    io.dcloud.common.DHInterface.IJsInterface mJsInterface;

    public Birdge(io.dcloud.common.DHInterface.IJsInterface iJsInterface) {
        this.mJsInterface = iJsInterface;
    }

    @Override // io.dcloud.common.DHInterface.IJsInterface
    @java.lang.Deprecated
    public java.lang.String exec(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return this.mJsInterface.exec(str, str2, str3);
    }

    @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
    public void execute(java.lang.Object obj) {
        this.mJsInterface.forceStop((java.lang.String) obj);
    }

    @Override // io.dcloud.common.DHInterface.IJsInterface
    @android.webkit.JavascriptInterface
    public void forceStop(java.lang.String str) {
        io.dcloud.common.adapter.util.MessageHandler.sendMessage(this, str);
    }

    @Override // io.dcloud.common.DHInterface.IJsInterface
    @android.webkit.JavascriptInterface
    public java.lang.String prompt(java.lang.String str, java.lang.String str2) {
        return this.mJsInterface.prompt(str, str2);
    }

    @Override // io.dcloud.common.DHInterface.IJsInterface
    public java.lang.String exec(java.lang.String str, java.lang.String str2, org.json.JSONArray jSONArray) {
        return this.mJsInterface.exec(str, str2, jSONArray);
    }
}
