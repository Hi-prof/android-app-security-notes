package io.dcloud.api.custom.type.draw;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class UniAdCustomDrawAd extends io.dcloud.api.custom.type.feed.UniAdCustomNativeAd {
    public void onVideoPlayEnd() {
        io.dcloud.p.x1 x1Var = this.a;
        if (x1Var instanceof io.dcloud.p.x1.a) {
            ((io.dcloud.p.x1.a) x1Var).onVideoPlayEnd();
        }
    }

    public void onVideoPlayError() {
        io.dcloud.p.x1 x1Var = this.a;
        if (x1Var instanceof io.dcloud.p.x1.a) {
            ((io.dcloud.p.x1.a) x1Var).a();
        }
    }

    public void onVideoPlayPause() {
        io.dcloud.p.x1 x1Var = this.a;
        if (x1Var instanceof io.dcloud.p.x1.a) {
            ((io.dcloud.p.x1.a) x1Var).c();
        }
    }

    public void onVideoPlayResume() {
        io.dcloud.p.x1 x1Var = this.a;
        if (x1Var instanceof io.dcloud.p.x1.a) {
            ((io.dcloud.p.x1.a) x1Var).h();
        }
    }

    public void onVideoPlayStart() {
        io.dcloud.p.x1 x1Var = this.a;
        if (x1Var instanceof io.dcloud.p.x1.a) {
            ((io.dcloud.p.x1.a) x1Var).d();
        }
    }
}
