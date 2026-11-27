package io.dcloud.media.weex.weex_video.ijkplayer.media;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidMediaController extends android.widget.MediaController implements io.dcloud.media.weex.weex_video.ijkplayer.media.IMediaController {
    private java.util.ArrayList<android.view.View> mShowOnceArray;

    private void initView(android.content.Context context) {
    }

    public AndroidMediaController(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mShowOnceArray = new java.util.ArrayList<>();
        initView(context);
    }

    public AndroidMediaController(android.content.Context context, boolean z) {
        super(context, z);
        this.mShowOnceArray = new java.util.ArrayList<>();
        initView(context);
    }

    public AndroidMediaController(android.content.Context context) {
        super(context);
        this.mShowOnceArray = new java.util.ArrayList<>();
        initView(context);
    }

    @Override // android.widget.MediaController, io.dcloud.media.weex.weex_video.ijkplayer.media.IMediaController
    public void show() {
        super.show();
    }

    @Override // android.widget.MediaController, io.dcloud.media.weex.weex_video.ijkplayer.media.IMediaController
    public void hide() {
        super.hide();
        java.util.Iterator<android.view.View> it = this.mShowOnceArray.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
        this.mShowOnceArray.clear();
    }

    @Override // io.dcloud.media.weex.weex_video.ijkplayer.media.IMediaController
    public void showOnce(android.view.View view) {
        this.mShowOnceArray.add(view);
        view.setVisibility(0);
        show();
    }
}
