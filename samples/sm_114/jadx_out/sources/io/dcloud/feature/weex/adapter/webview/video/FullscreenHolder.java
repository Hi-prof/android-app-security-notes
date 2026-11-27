package io.dcloud.feature.weex.adapter.webview.video;

/* JADX INFO: loaded from: classes2.dex */
public class FullscreenHolder extends android.widget.FrameLayout {
    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return true;
    }

    public FullscreenHolder(android.content.Context context) {
        super(context);
        setBackgroundColor(context.getResources().getColor(android.R.color.black));
    }
}
