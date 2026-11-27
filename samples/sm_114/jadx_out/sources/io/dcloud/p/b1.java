package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class b1 extends io.dcloud.p.j1 implements io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener {
    public b1(io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL, android.app.Activity activity) {
        super(dCBaseAOL, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener instanceof io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) feedAOLInteractionListener).onEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener instanceof io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) {
            feedAOLInteractionListener.onShowError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener instanceof io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) feedAOLInteractionListener).onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener instanceof io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) feedAOLInteractionListener).onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        io.dcloud.sdk.core.interfaces.AOLLoader.FeedAOLInteractionListener feedAOLInteractionListener = this.e;
        if (feedAOLInteractionListener instanceof io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) feedAOLInteractionListener).onStart();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onEnd() {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.q();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onError() {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b1$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.r();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onPause() {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.s();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onResume() {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b1$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.t();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener
    public void onStart() {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.u();
            }
        });
    }
}
