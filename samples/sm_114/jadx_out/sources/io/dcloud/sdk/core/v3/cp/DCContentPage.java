package io.dcloud.sdk.core.v3.cp;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCContentPage extends io.dcloud.sdk.core.v3.base.DCBaseAOL implements io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener {
    private io.dcloud.p.j0 b;
    private io.dcloud.sdk.core.v3.cp.DCContentPageVideoListener c;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class ContentPageItem {
        private java.lang.String a;
        private java.lang.String b;
        private java.lang.String c;
        private java.lang.String d;
        private java.lang.String e;

        public java.lang.String getDuration() {
            return this.c;
        }

        public java.lang.String getErrorCode() {
            return this.d;
        }

        public java.lang.String getErrorMsg() {
            return this.e;
        }

        public java.lang.String getId() {
            return this.a;
        }

        public java.lang.String getType() {
            return this.b;
        }

        public void setDuration(java.lang.String str) {
            this.c = str;
        }

        public void setErrorCode(java.lang.String str) {
            this.d = str;
        }

        public void setErrorMsg(java.lang.String str) {
            this.e = str;
        }

        public void setId(java.lang.String str) {
            this.a = str;
        }

        public void setType(java.lang.String str) {
            this.b = str;
        }
    }

    public DCContentPage(android.app.Activity activity) {
        super(activity);
        this.b = new io.dcloud.p.j0(activity, 14);
    }

    public androidx.fragment.app.Fragment getContentPage() {
        io.dcloud.p.j0 j0Var = this.b;
        if (j0Var == null) {
            return null;
        }
        return j0Var.s();
    }

    @java.lang.Deprecated
    public void load(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, final io.dcloud.sdk.core.v3.cp.DCContentPageLoadListener dCContentPageLoadListener) {
        if (getContext() == null || dCloudAOLSlot == null) {
            if (dCContentPageLoadListener != null) {
                dCContentPageLoadListener.onError(-5014, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5014), null);
                return;
            }
            return;
        }
        io.dcloud.p.j0 j0Var = this.b;
        if (j0Var != null) {
            j0Var.a(dCloudAOLSlot, new io.dcloud.p.w2() { // from class: io.dcloud.sdk.core.v3.cp.DCContentPage.1
                @Override // io.dcloud.p.w2
                public void onError(int i, java.lang.String str, org.json.JSONArray jSONArray) {
                    dCContentPageLoadListener.onError(i, str, jSONArray);
                }

                @Override // io.dcloud.p.w2
                public void onLoaded() {
                    dCContentPageLoadListener.onContentPageLoad();
                }
            });
        } else if (dCContentPageLoadListener != null) {
            dCContentPageLoadListener.onError(-5015, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5015), null);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClick() {
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onClose() {
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onComplete(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem) {
        io.dcloud.sdk.core.v3.cp.DCContentPageVideoListener dCContentPageVideoListener = this.c;
        if (dCContentPageVideoListener != null) {
            dCContentPageVideoListener.onComplete(contentPageItem);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onError(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem) {
        io.dcloud.sdk.core.v3.cp.DCContentPageVideoListener dCContentPageVideoListener = this.c;
        if (dCContentPageVideoListener != null) {
            dCContentPageVideoListener.onError(contentPageItem);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onPaidGet(long j, java.lang.String str, int i) {
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onPause(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem) {
        io.dcloud.sdk.core.v3.cp.DCContentPageVideoListener dCContentPageVideoListener = this.c;
        if (dCContentPageVideoListener != null) {
            dCContentPageVideoListener.onPause(contentPageItem);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onResume(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem) {
        io.dcloud.sdk.core.v3.cp.DCContentPageVideoListener dCContentPageVideoListener = this.c;
        if (dCContentPageVideoListener != null) {
            dCContentPageVideoListener.onResume(contentPageItem);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShow() {
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onShowError(int i, java.lang.String str) {
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onSkip() {
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.ContentPageVideoListener
    public void onStart(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem) {
        io.dcloud.sdk.core.v3.cp.DCContentPageVideoListener dCContentPageVideoListener = this.c;
        if (dCContentPageVideoListener != null) {
            dCContentPageVideoListener.onStart(contentPageItem);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
    public void onVideoPlayEnd() {
    }

    public void setContentPageVideoListener(io.dcloud.sdk.core.v3.cp.DCContentPageVideoListener dCContentPageVideoListener) {
        this.c = dCContentPageVideoListener;
        io.dcloud.p.j0 j0Var = this.b;
        if (j0Var != null) {
            j0Var.a(this);
        }
    }

    public void show(android.app.Activity activity) {
        io.dcloud.p.j0 j0Var = this.b;
        if (j0Var != null) {
            j0Var.a(activity);
        }
    }
}
