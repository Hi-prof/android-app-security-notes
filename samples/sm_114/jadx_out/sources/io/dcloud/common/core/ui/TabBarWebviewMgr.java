package io.dcloud.common.core.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class TabBarWebviewMgr {
    private static io.dcloud.common.core.ui.TabBarWebviewMgr mInstance;
    private io.dcloud.common.core.ui.TabBarWebview mLaunchTabBar;

    public static io.dcloud.common.core.ui.TabBarWebviewMgr getInstance() {
        if (mInstance == null) {
            mInstance = new io.dcloud.common.core.ui.TabBarWebviewMgr();
        }
        return mInstance;
    }

    public io.dcloud.common.core.ui.TabBarWebview getLaunchTabBar() {
        return this.mLaunchTabBar;
    }

    public void setLancheTabBar(io.dcloud.common.core.ui.TabBarWebview tabBarWebview) {
        this.mLaunchTabBar = tabBarWebview;
    }
}
