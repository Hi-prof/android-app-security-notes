package io.dcloud.sdk.core.module;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DCDramaLoader extends io.dcloud.sdk.core.module.DCBaseAOLLoader {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface AOLDramaPage {
        void destroy();

        androidx.fragment.app.Fragment getFragment();

        void setDramaAdListener(io.dcloud.sdk.core.interfaces.AOLLoader.DramaRewardListener dramaRewardListener);

        void setDramaListener(io.dcloud.sdk.core.interfaces.AOLLoader.DramaListener dramaListener);

        void setDramaUnlockListener(io.dcloud.sdk.core.interfaces.AOLLoader.DramaUnlockListener dramaUnlockListener);

        void setHideBack(boolean z);

        void setLoadListener(io.dcloud.sdk.core.interfaces.AOLLoader.DramaPageLoaderListener dramaPageLoaderListener);
    }

    public DCDramaLoader(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, android.app.Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    public abstract void getDramaCollectionList(int i, int i2, io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener dramaResultListener);

    public abstract io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage getDramaDetailPage(long j, int i, int i2, int i3, java.util.Map<java.lang.String, java.lang.Object> map);

    public abstract void getDramaHistoryList(int i, int i2, io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener dramaResultListener);

    public abstract io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage getDramaHomePage();

    public abstract io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage getDramaHomePage(int i, int i2, java.util.Map<java.lang.String, java.lang.Object> map);

    public abstract void getDramaInfo(java.util.List<java.lang.Long> list, io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener dramaResultListener);

    public abstract void getDramaList(int i, int i2, java.lang.String str, io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener dramaResultListener);

    public abstract void getDramaRecommendedList(int i, int i2, io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener dramaResultListener);

    public abstract void openDramaDetailPage(android.app.Activity activity, long j, int i, int i2, int i3, java.util.Map<java.lang.String, java.lang.Object> map, io.dcloud.sdk.core.interfaces.AOLLoader.DramaPageLoaderListener dramaPageLoaderListener);

    public abstract void searchDrama(java.lang.String str, int i, int i2, boolean z, io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener dramaResultListener);
}
