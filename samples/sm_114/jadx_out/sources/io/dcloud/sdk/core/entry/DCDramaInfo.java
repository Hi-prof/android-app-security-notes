package io.dcloud.sdk.core.entry;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCDramaInfo {
    private long a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private int e;
    private java.lang.String f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private long l;

    public int getCategoryId() {
        return this.e;
    }

    public java.lang.String getCategoryName() {
        return this.f;
    }

    public java.lang.String getCoverUrl() {
        return this.c;
    }

    public int getCurrentEpisode() {
        return this.g;
    }

    public java.lang.String getDesc() {
        return this.d;
    }

    public long getDramaId() {
        return this.a;
    }

    public long getDuration() {
        return this.l;
    }

    public int getGroupId() {
        return this.i;
    }

    public int getStyleType() {
        return this.k;
    }

    public java.lang.String getTitle() {
        return this.b;
    }

    public int getTotalEpisodes() {
        return this.h;
    }

    public int getUnlockIndex() {
        return this.j;
    }

    public void setCategoryId(int i) {
        this.e = i;
    }

    public void setCategoryName(java.lang.String str) {
        this.f = str;
    }

    public void setCoverUrl(java.lang.String str) {
        this.c = str;
    }

    public void setCurrentEpisode(int i) {
        this.g = i;
    }

    public void setDesc(java.lang.String str) {
        this.d = str;
    }

    public void setDramaId(long j) {
        this.a = j;
    }

    public void setDuration(long j) {
        this.l = j;
    }

    public void setGroupId(int i) {
        this.i = i;
    }

    public void setStyleType(int i) {
        this.k = i;
    }

    public void setTitle(java.lang.String str) {
        this.b = str;
    }

    public void setTotalEpisodes(int i) {
        this.h = i;
    }

    public void setUnlockIndex(int i) {
        this.j = i;
    }

    public org.json.JSONObject toJson() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("id", this.a);
            jSONObject.put("dramaId", this.a);
            java.lang.String str = this.b;
            java.lang.String str2 = "";
            if (str == null) {
                str = "";
            }
            jSONObject.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, str);
            java.lang.String str3 = this.c;
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("coverUrl", str3);
            java.lang.String str4 = this.d;
            if (str4 == null) {
                str4 = "";
            }
            jSONObject.put("desc", str4);
            jSONObject.put("categoryId", this.e);
            java.lang.String str5 = this.f;
            if (str5 != null) {
                str2 = str5;
            }
            jSONObject.put("categoryName", str2);
            jSONObject.put("currentEpisode", this.g);
            jSONObject.put("totalEpisodes", this.h);
            jSONObject.put("groupId", this.i);
            jSONObject.put("unlockIndex", this.j);
            jSONObject.put("styleType", this.k);
            jSONObject.put("duration", this.l);
        } catch (org.json.JSONException unused) {
        }
        return jSONObject;
    }
}
