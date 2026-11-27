package io.dcloud.sdk.core.entry;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
@java.lang.Deprecated
public class SplashAOLConfig {
    private int a;
    private int b;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static final class Builder {
        private int a;
        private int b;

        public io.dcloud.sdk.core.entry.SplashAOLConfig build() {
            return new io.dcloud.sdk.core.entry.SplashAOLConfig(this);
        }

        public io.dcloud.sdk.core.entry.SplashAOLConfig.Builder height(int i) {
            this.b = i;
            return this;
        }

        public io.dcloud.sdk.core.entry.SplashAOLConfig.Builder width(int i) {
            this.a = i;
            return this;
        }
    }

    public int getHeight() {
        return this.b;
    }

    public int getWidth() {
        return this.a;
    }

    private SplashAOLConfig(io.dcloud.sdk.core.entry.SplashAOLConfig.Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
    }
}
