package io.dcloud.media.weex.weex_video.ijkplayer.danmaku;

/* JADX INFO: loaded from: classes2.dex */
public class AcFunDanmakuParser extends master.flame.danmaku.danmaku.parser.BaseDanmakuParser {
    @Override // master.flame.danmaku.danmaku.parser.BaseDanmakuParser
    public master.flame.danmaku.danmaku.model.android.Danmakus parse() {
        if (this.mDataSource != null && (this.mDataSource instanceof master.flame.danmaku.danmaku.parser.android.JSONSource)) {
            return doParse(((master.flame.danmaku.danmaku.parser.android.JSONSource) this.mDataSource).data());
        }
        return new master.flame.danmaku.danmaku.model.android.Danmakus();
    }

    protected master.flame.danmaku.danmaku.model.android.Danmakus doParse(org.json.JSONArray jSONArray) {
        master.flame.danmaku.danmaku.model.android.Danmakus danmakus = new master.flame.danmaku.danmaku.model.android.Danmakus();
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    org.json.JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                    if (jSONArray2.length() > 0) {
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            org.json.JSONObject jSONObject = jSONArray2.getJSONObject(i2);
                            if (jSONObject != null) {
                                danmakus = _parse(jSONObject, danmakus);
                            }
                        }
                    }
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return danmakus;
    }

    protected master.flame.danmaku.danmaku.model.android.Danmakus _parse(org.json.JSONObject jSONObject, master.flame.danmaku.danmaku.model.android.Danmakus danmakus) {
        int i;
        if (danmakus == null) {
            danmakus = new master.flame.danmaku.danmaku.model.android.Danmakus();
        }
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                java.lang.String[] strArrSplit = jSONObject.getString("c").split(",");
                if (strArrSplit.length > 0 && (i = java.lang.Integer.parseInt(strArrSplit[2])) != 7) {
                    long j = (long) (java.lang.Float.parseFloat(strArrSplit[0]) * 1000.0f);
                    int i2 = java.lang.Integer.parseInt(strArrSplit[1]) | (-16777216);
                    float f = java.lang.Float.parseFloat(strArrSplit[3]);
                    master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmakuCreateDanmaku = this.mContext.mDanmakuFactory.createDanmaku(i, this.mContext);
                    if (baseDanmakuCreateDanmaku != null) {
                        baseDanmakuCreateDanmaku.setTime(j);
                        baseDanmakuCreateDanmaku.textSize = f * (this.mDispDensity - 0.6f);
                        baseDanmakuCreateDanmaku.textColor = i2;
                        baseDanmakuCreateDanmaku.textShadowColor = i2 <= -16777216 ? -1 : -16777216;
                        master.flame.danmaku.danmaku.util.DanmakuUtils.fillText(baseDanmakuCreateDanmaku, jSONObject.optString(com.taobao.weex.ui.component.WXComponent.PROP_FS_MATCH_PARENT, "...."));
                        baseDanmakuCreateDanmaku.setTimer(this.mTimer);
                        danmakus.addItem(baseDanmakuCreateDanmaku);
                    }
                }
            } catch (java.lang.NumberFormatException | org.json.JSONException unused) {
            }
        }
        return danmakus;
    }
}
