package io.dcloud.sdk.core.v3.fs;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCFSAOL extends io.dcloud.sdk.core.v3.base.DCBaseAOL implements io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener {
    private final io.dcloud.p.b5 b;
    private io.dcloud.sdk.core.v3.fs.DCFSAOLListener c;

    public DCFSAOL(android.app.Activity activity) {
        super(activity);
        this.b = new io.dcloud.p.b5(activity, 7);
    }

    public java.lang.String getType() {
        io.dcloud.p.b5 b5Var = this.b;
        return b5Var == null ? "" : b5Var.getType();
    }

    public boolean isValid() {
        io.dcloud.p.b5 b5Var = this.b;
        if (b5Var != null) {
            return b5Var.l();
        }
        return false;
    }

    public void load(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, final io.dcloud.sdk.core.v3.fs.DCFSAOLLoadListener dCFSAOLLoadListener) {
        if (getContext() == null || dCloudAOLSlot == null) {
            if (dCFSAOLLoadListener != null) {
                dCFSAOLLoadListener.onError(-5014, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5014), null);
                return;
            }
            return;
        }
        io.dcloud.p.b5 b5Var = this.b;
        if (b5Var != null) {
            b5Var.a(dCloudAOLSlot, new io.dcloud.p.w2() { // from class: io.dcloud.sdk.core.v3.fs.DCFSAOL.1
                @Override // io.dcloud.p.w2
                public void onError(int i, java.lang.String str, org.json.JSONArray jSONArray) {
                    io.dcloud.sdk.core.v3.fs.DCFSAOLLoadListener dCFSAOLLoadListener2 = dCFSAOLLoadListener;
                    if (dCFSAOLLoadListener2 != null) {
                        dCFSAOLLoadListener2.onError(i, str, jSONArray);
                    }
                }

                @Override // io.dcloud.p.w2
                public void onLoaded() {
                    io.dcloud.sdk.core.v3.fs.DCFSAOLLoadListener dCFSAOLLoadListener2 = dCFSAOLLoadListener;
                    if (dCFSAOLLoadListener2 != null) {
                        dCFSAOLLoadListener2.onFullScreenAOLLoad();
                    }
                }
            });
        } else if (dCFSAOLLoadListener != null) {
            dCFSAOLLoadListener.onError(-5015, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5015), null);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClick() {
        io.dcloud.sdk.core.v3.fs.DCFSAOLListener dCFSAOLListener = this.c;
        if (dCFSAOLListener != null) {
            dCFSAOLListener.onClick();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClose() {
        io.dcloud.sdk.core.v3.fs.DCFSAOLListener dCFSAOLListener = this.c;
        if (dCFSAOLListener != null) {
            dCFSAOLListener.onClose();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onPaidGet(long j, java.lang.String str, int i) {
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShow() {
        io.dcloud.sdk.core.v3.fs.DCFSAOLListener dCFSAOLListener = this.c;
        if (dCFSAOLListener != null) {
            dCFSAOLListener.onShow();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShowError(int i, java.lang.String str) {
        io.dcloud.sdk.core.v3.fs.DCFSAOLListener dCFSAOLListener = this.c;
        if (dCFSAOLListener != null) {
            dCFSAOLListener.onShowError(i, str);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onSkip() {
        io.dcloud.sdk.core.v3.fs.DCFSAOLListener dCFSAOLListener = this.c;
        if (dCFSAOLListener != null) {
            dCFSAOLListener.onSkip();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onVideoPlayEnd() {
        io.dcloud.sdk.core.v3.fs.DCFSAOLListener dCFSAOLListener = this.c;
        if (dCFSAOLListener != null) {
            dCFSAOLListener.onVideoPlayEnd();
        }
    }

    public void setFullScreenAOLListener(io.dcloud.sdk.core.v3.fs.DCFSAOLListener dCFSAOLListener) {
        this.c = dCFSAOLListener;
        io.dcloud.p.b5 b5Var = this.b;
        if (b5Var != null) {
            b5Var.a(this);
        }
    }

    public void show(android.app.Activity activity) {
        io.dcloud.p.b5 b5Var = this.b;
        if (b5Var != null) {
            b5Var.a(activity);
        }
    }
}
