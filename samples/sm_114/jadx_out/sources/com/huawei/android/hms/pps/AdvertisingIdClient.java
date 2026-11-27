package com.huawei.android.hms.pps;

/* JADX INFO: loaded from: classes.dex */
public class AdvertisingIdClient {

    public static final class Info {
        private final java.lang.String advertisingId;
        private final boolean limitAdTrackingEnabled;

        Info(java.lang.String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        public final native java.lang.String getId();

        public final native boolean isLimitAdTrackingEnabled();
    }

    public static native com.huawei.android.hms.pps.AdvertisingIdClient.Info getAdvertisingIdInfo(android.content.Context context);

    private static native java.lang.String getTag();
}
