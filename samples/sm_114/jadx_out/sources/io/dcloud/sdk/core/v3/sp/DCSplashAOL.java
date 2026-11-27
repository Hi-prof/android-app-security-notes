package io.dcloud.sdk.core.v3.sp;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCSplashAOL extends io.dcloud.sdk.core.v3.base.DCBaseAOL implements io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener {
    io.dcloud.p.k4 b;
    private io.dcloud.sdk.core.v3.sp.DCSplashAOLListener c;

    public DCSplashAOL(android.app.Activity activity) {
        super(activity);
        this.b = new io.dcloud.p.k4(activity, 1);
    }

    public boolean isSplashOpen() {
        return io.dcloud.p.n.d(getContext());
    }

    public boolean isValid() {
        io.dcloud.p.k4 k4Var = this.b;
        return k4Var != null && k4Var.l();
    }

    public void load(io.dcloud.sdk.core.entry.SplashAOLConfig splashAOLConfig, final io.dcloud.sdk.core.v3.sp.DCSplashAOLLoadListener dCSplashAOLLoadListener) {
        if (getContext() == null || splashAOLConfig == null) {
            if (dCSplashAOLLoadListener != null) {
                dCSplashAOLLoadListener.onError(-5014, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5014), null);
                return;
            }
            return;
        }
        io.dcloud.p.k4 k4Var = this.b;
        if (k4Var != null) {
            k4Var.a(splashAOLConfig, new io.dcloud.p.w2() { // from class: io.dcloud.sdk.core.v3.sp.DCSplashAOL.1
                public void getConfig(org.json.JSONObject jSONObject) {
                    try {
                        dCSplashAOLLoadListener.getClass().getDeclaredMethod("getConfig", org.json.JSONObject.class).invoke(dCSplashAOLLoadListener, jSONObject);
                    } catch (java.lang.Exception unused) {
                    }
                }

                @Override // io.dcloud.p.w2
                public void onError(int i, java.lang.String str, org.json.JSONArray jSONArray) {
                    dCSplashAOLLoadListener.onError(i, str, jSONArray);
                }

                @Override // io.dcloud.p.w2
                public void onLoaded() {
                    dCSplashAOLLoadListener.onSplashAOLLoad();
                }
            });
        } else if (dCSplashAOLLoadListener != null) {
            dCSplashAOLLoadListener.onError(-5015, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5015), null);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClick() {
        io.dcloud.sdk.core.v3.sp.DCSplashAOLListener dCSplashAOLListener = this.c;
        if (dCSplashAOLListener != null) {
            dCSplashAOLListener.onClick();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClose() {
        io.dcloud.sdk.core.v3.sp.DCSplashAOLListener dCSplashAOLListener = this.c;
        if (dCSplashAOLListener != null) {
            dCSplashAOLListener.onClose();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onPaidGet(long j, java.lang.String str, int i) {
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShow() {
        io.dcloud.sdk.core.v3.sp.DCSplashAOLListener dCSplashAOLListener = this.c;
        if (dCSplashAOLListener != null) {
            dCSplashAOLListener.onShow();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShowError(int i, java.lang.String str) {
        io.dcloud.sdk.core.v3.sp.DCSplashAOLListener dCSplashAOLListener = this.c;
        if (dCSplashAOLListener != null) {
            dCSplashAOLListener.onShowError(i, str);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onSkip() {
        io.dcloud.sdk.core.v3.sp.DCSplashAOLListener dCSplashAOLListener = this.c;
        if (dCSplashAOLListener != null) {
            dCSplashAOLListener.onSkip();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onVideoPlayEnd() {
        io.dcloud.sdk.core.v3.sp.DCSplashAOLListener dCSplashAOLListener = this.c;
        if (dCSplashAOLListener != null) {
            dCSplashAOLListener.onVideoPlayEnd();
        }
    }

    public void setSplashAOLListener(io.dcloud.sdk.core.v3.sp.DCSplashAOLListener dCSplashAOLListener) {
        this.c = dCSplashAOLListener;
        io.dcloud.p.k4 k4Var = this.b;
        if (k4Var != null) {
            k4Var.a(this);
        }
    }

    public void show(android.app.Activity activity) {
    }

    @java.lang.Deprecated
    public void showIn(android.view.ViewGroup viewGroup) {
        io.dcloud.p.k4 k4Var = this.b;
        if (k4Var != null) {
            k4Var.a(viewGroup);
        }
    }

    public void show(android.view.ViewGroup viewGroup) {
        showIn(viewGroup);
    }
}
