package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class b5 extends io.dcloud.p.x implements io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener {
    protected io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener r;
    protected io.dcloud.p.w2 s;
    protected io.dcloud.sdk.core.module.DCBaseAOL t;
    private boolean u;
    private boolean v;
    protected boolean w;

    public b5(android.app.Activity activity, int i) {
        super(activity);
        this.u = false;
        this.v = false;
        this.w = false;
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(io.dcloud.p.w2 w2Var) {
        if (w2Var != null) {
            w2Var.onError(-5021, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5021), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(int i, java.lang.String str) {
        io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener != null) {
            vAOLInteractionListener.onShowError(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener != null) {
            vAOLInteractionListener.onClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener != null) {
            vAOLInteractionListener.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener != null) {
            vAOLInteractionListener.onShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener != null) {
            vAOLInteractionListener.onSkip();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener != null) {
            vAOLInteractionListener.onVideoPlayEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener != null) {
            vAOLInteractionListener.onShowError(-5006, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5006));
        }
    }

    @Override // io.dcloud.p.x
    protected void a(final int i, final java.lang.String str, final org.json.JSONArray jSONArray) {
        this.w = false;
        this.t = null;
        io.dcloud.p.c3.b("uniAd-loadError", "code:" + i + ";message:" + str + ";detail:" + java.lang.String.valueOf(jSONArray));
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b5$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(i, str, jSONArray);
            }
        });
    }

    @Override // io.dcloud.p.x
    protected void c(final java.util.List list) {
        this.w = false;
        this.t = null;
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b5$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d(list);
            }
        });
    }

    public void destroy() {
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.t;
        if (dCBaseAOL != null) {
            dCBaseAOL.destroy();
        }
    }

    public java.lang.String getType() {
        return this.t != null ? io.dcloud.p.e.b().c(this.t.getType()) : "";
    }

    public boolean isLoading() {
        return this.w;
    }

    public boolean l() {
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.t;
        return dCBaseAOL != null && dCBaseAOL.isValid();
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClick() {
        a(a(), this.t);
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b5$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m();
            }
        });
        android.app.Activity activityA = a();
        boolean z = this.d == 9;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.d);
        sb.append("_");
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.t;
        sb.append(dCBaseAOL != null ? dCBaseAOL.getType() : "");
        io.dcloud.p.g4.a(activityA, z, sb.toString());
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClose() {
        this.v = false;
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b5$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.n();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onPaidGet(long j, java.lang.String str, int i) {
        a(a(), this.t, j, str, i);
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShow() {
        this.u = true;
        this.v = true;
        b(a(), this.t);
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b5$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.o();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShowError(final int i, final java.lang.String str) {
        this.v = false;
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b5$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d(i, str);
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onSkip() {
        this.v = false;
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b5$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.p();
            }
        });
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onVideoPlayEnd() {
        this.v = false;
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b5$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.q();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(io.dcloud.sdk.core.interfaces.AOLLoader.GetConvertResultListener getConvertResultListener) {
        if (getConvertResultListener != null) {
            getConvertResultListener.onError(-5100, "type:" + getType() + ";code:-1;message:暂无缓存任务");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(java.util.List list) {
        if (list != null && list.size() > 0) {
            io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = (io.dcloud.sdk.core.module.DCBaseAOL) list.get(0);
            this.t = dCBaseAOL;
            dCBaseAOL.setVideoAdCallback(this);
            io.dcloud.p.w2 w2Var = this.s;
            if (w2Var != null) {
                w2Var.onLoaded();
                return;
            }
            return;
        }
        io.dcloud.p.w2 w2Var2 = this.s;
        if (w2Var2 != null) {
            w2Var2.onError(-5005, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5005), null);
        }
    }

    public void b(final io.dcloud.sdk.core.interfaces.AOLLoader.RequestConvertResultListener requestConvertResultListener) {
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.t;
        if (dCBaseAOL != null) {
            dCBaseAOL.requestRetryRewardConvert(requestConvertResultListener);
        } else {
            io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b5$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(requestConvertResultListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(int i, java.lang.String str, org.json.JSONArray jSONArray) {
        io.dcloud.p.w2 w2Var = this.s;
        if (w2Var != null) {
            w2Var.onError(i, str, jSONArray);
        }
    }

    public void a(android.app.Activity activity) {
        if (this.u) {
            io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b5$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.r();
                }
            });
            return;
        }
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.t;
        if (dCBaseAOL instanceof io.dcloud.sdk.core.module.DCBaseAOLLoader) {
            ((io.dcloud.sdk.core.module.DCBaseAOLLoader) dCBaseAOL).show(activity);
        }
    }

    public void a(io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener vAOLInteractionListener) {
        this.r = vAOLInteractionListener;
    }

    public void a(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, final io.dcloud.p.w2 w2Var) {
        if (this.v) {
            io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b5$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    io.dcloud.p.b5.b(w2Var);
                }
            });
            return;
        }
        if (this.w) {
            io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b5$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    io.dcloud.p.b5.a(w2Var);
                }
            });
            return;
        }
        this.u = false;
        a(dCloudAOLSlot);
        this.s = w2Var;
        this.w = true;
        io.dcloud.p.a3.a().post(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(io.dcloud.p.w2 w2Var) {
        if (w2Var != null) {
            w2Var.onError(-5017, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5017), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        this.w = z;
    }

    public void a(final io.dcloud.sdk.core.interfaces.AOLLoader.GetConvertResultListener getConvertResultListener) {
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.t;
        if (dCBaseAOL != null) {
            dCBaseAOL.getRetryRewardResult(getConvertResultListener);
        } else {
            io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.b5$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(getConvertResultListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(io.dcloud.sdk.core.interfaces.AOLLoader.RequestConvertResultListener requestConvertResultListener) {
        if (requestConvertResultListener != null) {
            requestConvertResultListener.onError(-5100, "type:" + getType() + ";code:-1;message:暂无缓存任务");
        }
    }
}
