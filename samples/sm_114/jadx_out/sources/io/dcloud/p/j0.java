package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class j0 extends io.dcloud.p.b5 implements io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener {
    public j0(android.app.Activity activity, int i) {
        super(activity, i);
    }

    @Override // io.dcloud.p.b5
    public void a(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, io.dcloud.p.w2 w2Var) {
        try {
            java.lang.Class.forName("com.kwad.sdk.api.KsContentPage");
            super.a(dCloudAOLSlot, w2Var);
        } catch (java.lang.ClassNotFoundException unused) {
            if (w2Var != null) {
                w2Var.onError(-5050, "当前环境没有快手内容联盟SDK", null);
            }
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onComplete(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem) {
        io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener instanceof io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener) vAOLInteractionListener).onComplete(contentPageItem);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onError(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem) {
        io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener instanceof io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener) vAOLInteractionListener).onError(contentPageItem);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onPause(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem) {
        io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener instanceof io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener) vAOLInteractionListener).onPause(contentPageItem);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onResume(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem) {
        io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener instanceof io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener) vAOLInteractionListener).onResume(contentPageItem);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onStart(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem) {
        io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener instanceof io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener) vAOLInteractionListener).onStart(contentPageItem);
        }
    }

    public androidx.fragment.app.Fragment s() {
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.t;
        if (dCBaseAOL != null) {
            try {
                return (androidx.fragment.app.Fragment) dCBaseAOL.getClass().getDeclaredMethod("getContentPage", null).invoke(this.t, null);
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }
}
