package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class a1 extends io.dcloud.p.y4 {
    public a1(android.app.Activity activity, int i) {
        super(activity, i);
    }

    private io.dcloud.sdk.core.module.DCDramaLoader s() {
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.t;
        if (dCBaseAOL instanceof io.dcloud.sdk.core.module.DCDramaLoader) {
            return (io.dcloud.sdk.core.module.DCDramaLoader) dCBaseAOL;
        }
        return null;
    }

    @Override // io.dcloud.p.y4, io.dcloud.p.b5
    public void a(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, io.dcloud.p.w2 w2Var) {
        try {
            java.lang.Class.forName("com.bytedance.sdk.djx.DJXSdk");
            super.a(dCloudAOLSlot, w2Var);
        } catch (java.lang.ClassNotFoundException unused) {
            if (w2Var != null) {
                w2Var.onError(-5051, "当前环境没有穿山甲内容联盟SDK", null);
            }
        }
    }

    public void b(int i, int i2, io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener dramaResultListener) {
        io.dcloud.sdk.core.module.DCDramaLoader dCDramaLoaderS = s();
        if (dCDramaLoaderS != null) {
            dCDramaLoaderS.getDramaHistoryList(i, i2, dramaResultListener);
        } else {
            a("getDramaHistoryList", dramaResultListener);
        }
    }

    public void c(int i, int i2, io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener dramaResultListener) {
        io.dcloud.sdk.core.module.DCDramaLoader dCDramaLoaderS = s();
        if (dCDramaLoaderS != null) {
            dCDramaLoaderS.getDramaRecommendedList(i, i2, dramaResultListener);
        } else {
            a("getDramaRecommendedList", dramaResultListener);
        }
    }

    public io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage t() {
        io.dcloud.sdk.core.module.DCDramaLoader dCDramaLoaderS = s();
        if (dCDramaLoaderS != null) {
            return dCDramaLoaderS.getDramaHomePage();
        }
        return null;
    }

    public io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage a(int i, int i2, java.util.Map map) {
        io.dcloud.sdk.core.module.DCDramaLoader dCDramaLoaderS = s();
        if (dCDramaLoaderS != null) {
            return dCDramaLoaderS.getDramaHomePage(i, i2, map);
        }
        return null;
    }

    public void a(int i, int i2, java.lang.String str, io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener dramaResultListener) {
        io.dcloud.sdk.core.module.DCDramaLoader dCDramaLoaderS = s();
        if (dCDramaLoaderS != null) {
            dCDramaLoaderS.getDramaList(i, i2, str, dramaResultListener);
        } else {
            a("getDramaList", dramaResultListener);
        }
    }

    public void a(int i, int i2, io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener dramaResultListener) {
        io.dcloud.sdk.core.module.DCDramaLoader dCDramaLoaderS = s();
        if (dCDramaLoaderS != null) {
            dCDramaLoaderS.getDramaCollectionList(i, i2, dramaResultListener);
        } else {
            a("getDramaCollectionList", dramaResultListener);
        }
    }

    public void a(java.lang.String str, int i, int i2, boolean z, io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener dramaResultListener) {
        io.dcloud.sdk.core.module.DCDramaLoader dCDramaLoaderS = s();
        if (dCDramaLoaderS != null) {
            dCDramaLoaderS.searchDrama(str, i, i2, z, dramaResultListener);
        } else {
            a("searchDrama", dramaResultListener);
        }
    }

    public void a(java.util.List list, io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener dramaResultListener) {
        io.dcloud.sdk.core.module.DCDramaLoader dCDramaLoaderS = s();
        if (dCDramaLoaderS != null) {
            dCDramaLoaderS.getDramaInfo(list, dramaResultListener);
        } else {
            a("getDramaInfo", dramaResultListener);
        }
    }

    public void a(android.app.Activity activity, long j, int i, int i2, int i3, java.util.Map map, io.dcloud.sdk.core.interfaces.AOLLoader.DramaPageLoaderListener dramaPageLoaderListener) {
        io.dcloud.sdk.core.module.DCDramaLoader dCDramaLoaderS = s();
        if (dCDramaLoaderS != null) {
            dCDramaLoaderS.openDramaDetailPage(activity, j, i, i2, i3, map, dramaPageLoaderListener);
        } else if (dramaPageLoaderListener != null) {
            dramaPageLoaderListener.onError(-5051, "未知错误，请联系官方技术支持。openDramaDetailPage");
        }
    }

    public io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage a(long j, int i, int i2, int i3, java.util.Map map) {
        io.dcloud.sdk.core.module.DCDramaLoader dCDramaLoaderS = s();
        if (dCDramaLoaderS != null) {
            return dCDramaLoaderS.getDramaDetailPage(j, i, i2, i3, map);
        }
        return null;
    }

    private void a(java.lang.String str, io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener dramaResultListener) {
        if (dramaResultListener != null) {
            dramaResultListener.onError(-5051, "未知错误，请联系官方技术支持。" + str);
        }
    }
}
