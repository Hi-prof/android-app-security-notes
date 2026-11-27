package io.dcloud.media.video.ijkplayer.danmaku;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseDanmakuData {
    private java.lang.String content;
    private int textColor;
    private float textSize;
    private long time;
    private int type;

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public void setContent(java.lang.String str) {
        this.content = str;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public void setTextSize(float f) {
        this.textSize = f;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public java.lang.String toString() {
        return "BaseDanmakuData{type=" + this.type + ", content='" + this.content + "', time=" + this.time + ", textSize=" + this.textSize + ", textColor=" + this.textColor + com.taobao.weex.el.parse.Operators.BLOCK_END;
    }
}
