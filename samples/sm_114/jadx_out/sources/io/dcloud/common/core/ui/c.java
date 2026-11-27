package io.dcloud.common.core.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class c extends io.dcloud.common.core.ui.b {
    io.dcloud.common.core.ui.TabBarWebview C;
    io.dcloud.common.core.ui.b D;

    c(android.content.Context context, io.dcloud.common.core.ui.l lVar, io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.core.ui.a aVar, int i, org.json.JSONObject jSONObject) {
        super(context, lVar, iApp, aVar, i, null);
        io.dcloud.common.core.ui.TabBarWebview tabBarWebview = new io.dcloud.common.core.ui.TabBarWebview(context, iApp, lVar, this, jSONObject);
        this.C = tabBarWebview;
        this.l = tabBarWebview;
        tabBarWebview.setFrameId("tab");
    }

    public void c(io.dcloud.common.core.ui.b bVar) {
        if (this.C.isInsertLauch()) {
            this.C.append(bVar);
            d(bVar);
        }
    }

    public boolean checkPagePathIsTab(java.lang.String str) {
        io.dcloud.common.core.ui.TabBarWebview tabBarWebview = this.C;
        if (tabBarWebview != null) {
            return tabBarWebview.checkPagePathIsTab(str);
        }
        return false;
    }

    public void d(io.dcloud.common.core.ui.b bVar) {
        this.D = bVar;
        io.dcloud.common.core.ui.TabBarWebview tabBarWebview = this.C;
        if (tabBarWebview != null) {
            tabBarWebview.tabItemActive(bVar);
        }
    }

    @Override // io.dcloud.common.core.ui.b, io.dcloud.common.adapter.ui.AdaFrameView, io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem
    public void dispose() {
        super.dispose();
        this.D = null;
        this.C = null;
    }

    @Override // io.dcloud.common.core.ui.b, io.dcloud.common.adapter.ui.AdaFrameView
    protected void initMainView(android.content.Context context, int i, java.lang.Object obj) {
        setMainView(new io.dcloud.p.t4(context));
    }

    public void removeFrameView(io.dcloud.common.core.ui.b bVar) {
        io.dcloud.common.core.ui.TabBarWebview tabBarWebview = this.C;
        if (tabBarWebview != null) {
            tabBarWebview.removeFrameView(bVar);
        }
    }

    public io.dcloud.common.core.ui.b u() {
        return this.D;
    }
}
