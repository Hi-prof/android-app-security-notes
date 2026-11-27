package io.dcloud.media.weex.weex_video.ijkplayer.danmaku;

/* JADX INFO: loaded from: classes2.dex */
public class StandardDanmaKuParser extends io.dcloud.media.weex.weex_video.ijkplayer.danmaku.AcFunDanmakuParser {
    private int count = 0;

    @Override // io.dcloud.media.weex.weex_video.ijkplayer.danmaku.AcFunDanmakuParser
    protected master.flame.danmaku.danmaku.model.android.Danmakus doParse(org.json.JSONArray jSONArray) {
        master.flame.danmaku.danmaku.model.android.Danmakus danmakus = new master.flame.danmaku.danmaku.model.android.Danmakus();
        if (jSONArray == null) {
            return danmakus;
        }
        this.count = jSONArray.length();
        for (int i = 0; i < this.count; i++) {
            try {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    danmakus = _parse(jSONObject, danmakus);
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                return danmakus;
            }
        }
        return danmakus;
    }

    @Override // io.dcloud.media.weex.weex_video.ijkplayer.danmaku.AcFunDanmakuParser
    protected master.flame.danmaku.danmaku.model.android.Danmakus _parse(org.json.JSONObject jSONObject, master.flame.danmaku.danmaku.model.android.Danmakus danmakus) {
        if (danmakus == null) {
            danmakus = new master.flame.danmaku.danmaku.model.android.Danmakus();
        }
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                java.lang.String strOptString = jSONObject.optString("text", "....");
                java.lang.String string = jSONObject.getString("color");
                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmakuCreateDanmaku = this.mContext.mDanmakuFactory.createDanmaku(1, this.mContext);
                if (baseDanmakuCreateDanmaku != null) {
                    baseDanmakuCreateDanmaku.setTime(jSONObject.optLong(com.taobao.weex.common.Constants.Value.TIME, 0L) * 1000);
                    baseDanmakuCreateDanmaku.textSize = (this.mDispDensity - 0.6f) * 25.0f;
                    int color = android.graphics.Color.parseColor(string);
                    baseDanmakuCreateDanmaku.textColor = color;
                    baseDanmakuCreateDanmaku.textShadowColor = color <= -16777216 ? -1 : -16777216;
                    master.flame.danmaku.danmaku.util.DanmakuUtils.fillText(baseDanmakuCreateDanmaku, strOptString);
                    baseDanmakuCreateDanmaku.setTimer(this.mTimer);
                    danmakus.addItem(baseDanmakuCreateDanmaku);
                }
            } catch (org.json.JSONException unused) {
            }
        }
        return danmakus;
    }
}
