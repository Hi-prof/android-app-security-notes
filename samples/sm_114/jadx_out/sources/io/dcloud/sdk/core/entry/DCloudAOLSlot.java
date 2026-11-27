package io.dcloud.sdk.core.entry;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
@java.lang.Deprecated
public class DCloudAOLSlot {
    private java.lang.String a;
    private final java.lang.String b;
    private final java.lang.String c;
    private org.json.JSONObject d;
    private final int e;
    private final boolean f;
    private int g;
    private final java.lang.String h;
    private java.lang.String i;
    private final int j;
    private final int k;
    private int l;
    private io.dcloud.sdk.core.entry.DCloudAOLSlot.DramaConfig m;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static final class Builder {
        private java.lang.String a;
        private java.lang.String b;
        private java.lang.String c;
        private int e;
        private int f;
        private io.dcloud.sdk.core.entry.DCloudAOLSlot.DramaConfig j;
        private int d = 3;
        private boolean g = false;
        private final int h = 1;
        private java.lang.String i = "";

        public io.dcloud.sdk.core.entry.DCloudAOLSlot.Builder adpid(java.lang.String str) {
            this.a = str;
            return this;
        }

        public io.dcloud.sdk.core.entry.DCloudAOLSlot build() {
            return new io.dcloud.sdk.core.entry.DCloudAOLSlot(this);
        }

        public io.dcloud.sdk.core.entry.DCloudAOLSlot.Builder count(int i) {
            this.d = i;
            return this;
        }

        public io.dcloud.sdk.core.entry.DCloudAOLSlot.Builder extra(java.lang.String str) {
            this.c = str;
            return this;
        }

        public io.dcloud.sdk.core.entry.DCloudAOLSlot.Builder height(int i) {
            this.f = i;
            return this;
        }

        public io.dcloud.sdk.core.entry.DCloudAOLSlot.Builder setDramaConfig(io.dcloud.sdk.core.entry.DCloudAOLSlot.DramaConfig dramaConfig) {
            this.j = dramaConfig;
            return this;
        }

        public io.dcloud.sdk.core.entry.DCloudAOLSlot.Builder setEI(java.lang.String str) {
            this.i = str;
            return this;
        }

        public io.dcloud.sdk.core.entry.DCloudAOLSlot.Builder setVideoSoundEnable(boolean z) {
            this.g = z;
            return this;
        }

        public io.dcloud.sdk.core.entry.DCloudAOLSlot.Builder userId(java.lang.String str) {
            this.b = str;
            return this;
        }

        public io.dcloud.sdk.core.entry.DCloudAOLSlot.Builder width(int i) {
            this.e = i;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class DramaConfig {
        private int a = 1;
        private int b = 1;

        public int getFreeCount() {
            return this.a;
        }

        public int getLockCount() {
            return this.b;
        }

        public void setFreeCount(int i) {
            this.a = i;
            if (i > 20) {
                this.a = 20;
            }
        }

        public void setLockCount(int i) {
            this.b = i;
            if (i > 10) {
                this.b = 10;
            }
        }
    }

    public java.lang.String getAdpid() {
        return this.a;
    }

    public org.json.JSONObject getConfig() {
        return this.d;
    }

    public int getCount() {
        return this.e;
    }

    public io.dcloud.sdk.core.entry.DCloudAOLSlot.DramaConfig getDramaConfig() {
        return this.m;
    }

    public java.lang.String getEI() {
        return this.h;
    }

    public java.lang.String getExt() {
        return this.c;
    }

    public java.lang.String getExtra() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("extra", this.c);
            jSONObject.put("ruu", this.i);
        } catch (org.json.JSONException unused) {
        }
        return jSONObject.toString();
    }

    public int getHeight() {
        return this.k;
    }

    public int getOrientation() {
        return this.g;
    }

    public int getType() {
        return this.l;
    }

    public java.lang.String getUserId() {
        return this.b;
    }

    public int getWidth() {
        return this.j;
    }

    public boolean isVideoSoundEnable() {
        return this.f;
    }

    public void setAdpid(java.lang.String str) {
        this.a = str;
    }

    public void setConfig(org.json.JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public void setRID(java.lang.String str) {
        this.i = str;
    }

    public void setType(int i) {
        this.l = i;
    }

    private DCloudAOLSlot(io.dcloud.sdk.core.entry.DCloudAOLSlot.Builder builder) {
        this.g = 1;
        this.l = -1;
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.e = builder.d > 0 ? java.lang.Math.min(builder.d, 3) : 3;
        this.j = builder.e;
        this.k = builder.f;
        this.g = 1;
        this.f = builder.g;
        this.h = builder.i;
        this.m = builder.j;
    }
}
