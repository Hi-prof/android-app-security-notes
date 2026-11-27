package io.dcloud.sdk.core.v3.dw;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCDrawAOL extends io.dcloud.sdk.core.v3.fd.DCFeedAOL implements io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener {
    public DCDrawAOL(io.dcloud.p.j1 j1Var) {
        super(j1Var);
    }

    public android.view.View getDrawAOLView(android.app.Activity activity) {
        return getFeedAOLView(activity);
    }

    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOL, io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLInteractionListener
    public boolean isExpressAd() {
        return true;
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onEnd() {
        io.dcloud.sdk.core.v3.fd.DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener instanceof io.dcloud.sdk.core.v3.dw.DCDrawAOLListener) {
            ((io.dcloud.sdk.core.v3.dw.DCDrawAOLListener) dCFeedAOLListener).onEnd();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onError() {
        io.dcloud.sdk.core.v3.fd.DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener instanceof io.dcloud.sdk.core.v3.dw.DCDrawAOLListener) {
            dCFeedAOLListener.onShowError();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onPause() {
        io.dcloud.sdk.core.v3.fd.DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener instanceof io.dcloud.sdk.core.v3.dw.DCDrawAOLListener) {
            ((io.dcloud.sdk.core.v3.dw.DCDrawAOLListener) dCFeedAOLListener).onPause();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onResume() {
        io.dcloud.sdk.core.v3.fd.DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener instanceof io.dcloud.sdk.core.v3.dw.DCDrawAOLListener) {
            ((io.dcloud.sdk.core.v3.dw.DCDrawAOLListener) dCFeedAOLListener).onResume();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onStart() {
        io.dcloud.sdk.core.v3.fd.DCFeedAOLListener dCFeedAOLListener = this.b;
        if (dCFeedAOLListener instanceof io.dcloud.sdk.core.v3.dw.DCDrawAOLListener) {
            ((io.dcloud.sdk.core.v3.dw.DCDrawAOLListener) dCFeedAOLListener).onStart();
        }
    }

    public void setDrawAOLListener(io.dcloud.sdk.core.v3.dw.DCDrawAOLListener dCDrawAOLListener) {
        this.b = dCDrawAOLListener;
    }
}
