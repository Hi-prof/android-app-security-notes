package io.dcloud.sdk.core.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public enum AdType {
    AD_FULLSCREEN("full_screen_video"),
    AD_REWARD("rewarded"),
    AD_NONE(""),
    AD_SPLASH("splash"),
    AD_INTERSTITIAL("interstitial"),
    AD_DRAW("draw_flow"),
    AD_CONTENT_PAGE("content_page"),
    AD_TEMPLATE("template");

    private java.lang.String a;

    AdType(java.lang.String str) {
        this.a = str;
    }

    public static io.dcloud.sdk.core.util.AdType getAdType(java.lang.String str) {
        for (io.dcloud.sdk.core.util.AdType adType : values()) {
            if (adType.a.equals(str)) {
                return adType;
            }
        }
        return AD_NONE;
    }

    public java.lang.String getType() {
        return this.a;
    }
}
