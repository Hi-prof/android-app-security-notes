package io.dcloud.sdk.core.v3.rew;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCRewAOL extends io.dcloud.sdk.core.v3.base.DCBaseAOL implements io.dcloud.sdk.core.interfaces.AOLLoader.RewVAOLInteractionListener {
    private io.dcloud.p.z3 b;
    private io.dcloud.sdk.core.v3.rew.DCRewAOLListener c;

    public DCRewAOL(android.app.Activity activity) {
        super(activity);
        this.b = new io.dcloud.p.z3(activity);
    }

    public void destroy() {
        io.dcloud.p.z3 z3Var = this.b;
        if (z3Var != null) {
            z3Var.destroy();
        }
    }

    public void getRetryRewardResult(io.dcloud.sdk.core.interfaces.AOLLoader.GetConvertResultListener getConvertResultListener) {
        this.b.a(getConvertResultListener);
    }

    public java.lang.String getType() {
        io.dcloud.p.z3 z3Var = this.b;
        return z3Var == null ? "" : z3Var.getType();
    }

    public boolean isValid() {
        io.dcloud.p.z3 z3Var = this.b;
        if (z3Var != null) {
            return z3Var.l();
        }
        return false;
    }

    public void load(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, final io.dcloud.sdk.core.v3.rew.DCRewAOLLoadListener dCRewAOLLoadListener) {
        if (getContext() == null || dCloudAOLSlot == null) {
            if (dCRewAOLLoadListener != null) {
                dCRewAOLLoadListener.onError(-5014, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5014), null);
                return;
            }
            return;
        }
        io.dcloud.p.z3 z3Var = this.b;
        if (z3Var != null) {
            z3Var.a(dCloudAOLSlot, new io.dcloud.p.w2() { // from class: io.dcloud.sdk.core.v3.rew.DCRewAOL.1
                @Override // io.dcloud.p.w2
                public void onError(int i, java.lang.String str, org.json.JSONArray jSONArray) {
                    io.dcloud.sdk.core.v3.rew.DCRewAOLLoadListener dCRewAOLLoadListener2 = dCRewAOLLoadListener;
                    if (dCRewAOLLoadListener2 != null) {
                        dCRewAOLLoadListener2.onError(i, str, jSONArray);
                    }
                }

                @Override // io.dcloud.p.w2
                public void onLoaded() {
                    io.dcloud.sdk.core.v3.rew.DCRewAOLLoadListener dCRewAOLLoadListener2 = dCRewAOLLoadListener;
                    if (dCRewAOLLoadListener2 != null) {
                        dCRewAOLLoadListener2.onRewardAOLLoad();
                    }
                }
            });
        } else if (dCRewAOLLoadListener != null) {
            dCRewAOLLoadListener.onError(-5015, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5015), null);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClick() {
        io.dcloud.sdk.core.v3.rew.DCRewAOLListener dCRewAOLListener = this.c;
        if (dCRewAOLListener != null) {
            dCRewAOLListener.onClick();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClose() {
        io.dcloud.sdk.core.v3.rew.DCRewAOLListener dCRewAOLListener = this.c;
        if (dCRewAOLListener != null) {
            dCRewAOLListener.onClose();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onPaidGet(long j, java.lang.String str, int i) {
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.RewVAOLInteractionListener
    public void onReward(org.json.JSONObject jSONObject) {
        io.dcloud.sdk.core.v3.rew.DCRewAOLListener dCRewAOLListener = this.c;
        if (dCRewAOLListener != null) {
            dCRewAOLListener.onReward(jSONObject);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShow() {
        io.dcloud.sdk.core.v3.rew.DCRewAOLListener dCRewAOLListener = this.c;
        if (dCRewAOLListener != null) {
            dCRewAOLListener.onShow();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShowError(int i, java.lang.String str) {
        io.dcloud.sdk.core.v3.rew.DCRewAOLListener dCRewAOLListener = this.c;
        if (dCRewAOLListener != null) {
            dCRewAOLListener.onShowError(i, str);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onSkip() {
        io.dcloud.sdk.core.v3.rew.DCRewAOLListener dCRewAOLListener = this.c;
        if (dCRewAOLListener != null) {
            dCRewAOLListener.onSkip();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onVideoPlayEnd() {
        io.dcloud.sdk.core.v3.rew.DCRewAOLListener dCRewAOLListener = this.c;
        if (dCRewAOLListener != null) {
            dCRewAOLListener.onVideoPlayEnd();
        }
    }

    public void requestRetryRewardConvert(io.dcloud.sdk.core.interfaces.AOLLoader.RequestConvertResultListener requestConvertResultListener) {
        this.b.b(requestConvertResultListener);
    }

    public void setRewardAOLListener(io.dcloud.sdk.core.v3.rew.DCRewAOLListener dCRewAOLListener) {
        this.c = dCRewAOLListener;
        io.dcloud.p.z3 z3Var = this.b;
        if (z3Var != null) {
            z3Var.a(this);
        }
    }

    public void show(android.app.Activity activity) {
        io.dcloud.p.z3 z3Var = this.b;
        if (z3Var != null) {
            z3Var.a(activity);
        }
    }
}
