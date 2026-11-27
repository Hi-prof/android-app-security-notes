package io.dcloud.feature.gg.dcloud.dcmgr;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class SIAolManager {
    private static io.dcloud.feature.gg.dcloud.dcmgr.SIAolManager instance;
    private long loadTime = 0;
    io.dcloud.p.v wrapper;

    public static io.dcloud.feature.gg.dcloud.dcmgr.SIAolManager getInstance() {
        if (instance == null) {
            synchronized (io.dcloud.feature.gg.dcloud.dcmgr.SIAolManager.class) {
                if (instance == null) {
                    io.dcloud.feature.gg.dcloud.dcmgr.SIAolManager sIAolManager = new io.dcloud.feature.gg.dcloud.dcmgr.SIAolManager();
                    instance = sIAolManager;
                    return sIAolManager;
                }
            }
        }
        return instance;
    }

    public void load(android.app.Activity activity) {
        this.wrapper = new io.dcloud.p.v(activity);
        this.wrapper.a(new io.dcloud.sdk.core.entry.SplashAOLConfig.Builder().width(0).height(0).build(), (io.dcloud.sdk.core.v3.sp.DCSplashAOLLoadListener) null, true);
        this.loadTime = android.os.SystemClock.elapsedRealtime();
    }

    public void show(android.app.Activity activity) {
        io.dcloud.common.DHInterface.IActivityHandler iActivityHandler = io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(activity);
        if (iActivityHandler == null || this.wrapper == null) {
            return;
        }
        android.widget.FrameLayout frameLayoutObtainActivityContentView = iActivityHandler.obtainActivityContentView();
        if (this.wrapper.a(this.loadTime)) {
            this.wrapper.a(activity, "", frameLayoutObtainActivityContentView);
        }
    }
}
