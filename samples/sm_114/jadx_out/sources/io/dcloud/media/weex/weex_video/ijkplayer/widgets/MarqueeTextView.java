package io.dcloud.media.weex.weex_video.ijkplayer.widgets;

/* JADX INFO: loaded from: classes2.dex */
public class MarqueeTextView extends android.widget.TextView {
    boolean isMotion;

    public MarqueeTextView(android.content.Context context) {
        super(context);
        this.isMotion = false;
    }

    public MarqueeTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isMotion = false;
    }

    public MarqueeTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isMotion = false;
    }

    public void startMotion() {
        this.isMotion = true;
        requestFocus();
    }

    public void stopMotion() {
        this.isMotion = false;
        clearFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.isMotion;
    }
}
