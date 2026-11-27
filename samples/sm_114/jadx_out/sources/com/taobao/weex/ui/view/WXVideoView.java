package com.taobao.weex.ui.view;

/* JADX INFO: loaded from: classes.dex */
public class WXVideoView extends android.widget.VideoView implements com.taobao.weex.ui.view.gesture.WXGestureObservable {
    private com.taobao.weex.ui.view.WXVideoView.VideoPlayListener mVideoPauseListener;
    private com.taobao.weex.ui.view.gesture.WXGesture wxGesture;

    public interface VideoPlayListener {
        void onPause();

        void onStart();
    }

    public WXVideoView(android.content.Context context) {
        super(context);
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(com.taobao.weex.ui.view.gesture.WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public com.taobao.weex.ui.view.gesture.WXGesture getGestureListener() {
        return this.wxGesture;
    }

    public void setOnVideoPauseListener(com.taobao.weex.ui.view.WXVideoView.VideoPlayListener videoPlayListener) {
        this.mVideoPauseListener = videoPlayListener;
    }

    @Override // android.widget.VideoView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        com.taobao.weex.ui.view.gesture.WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? wXGesture.onTouch(this, motionEvent) | zOnTouchEvent : zOnTouchEvent;
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public void start() {
        super.start();
        com.taobao.weex.ui.view.WXVideoView.VideoPlayListener videoPlayListener = this.mVideoPauseListener;
        if (videoPlayListener != null) {
            videoPlayListener.onStart();
        }
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public void pause() {
        super.pause();
        com.taobao.weex.ui.view.WXVideoView.VideoPlayListener videoPlayListener = this.mVideoPauseListener;
        if (videoPlayListener != null) {
            videoPlayListener.onPause();
        }
    }

    public static class Wrapper extends android.widget.FrameLayout implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        private boolean mControls;
        private android.widget.MediaController mMediaController;
        private android.media.MediaPlayer.OnCompletionListener mOnCompletionListener;
        private android.media.MediaPlayer.OnErrorListener mOnErrorListener;
        private android.media.MediaPlayer.OnPreparedListener mOnPreparedListener;
        private android.widget.ProgressBar mProgressBar;
        private android.net.Uri mUri;
        private com.taobao.weex.ui.view.WXVideoView.VideoPlayListener mVideoPlayListener;
        private com.taobao.weex.ui.view.WXVideoView mVideoView;

        public Wrapper(android.content.Context context) {
            super(context);
            this.mControls = true;
            init(context);
        }

        public Wrapper(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mControls = true;
            init(context);
        }

        public Wrapper(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mControls = true;
            init(context);
        }

        private void init(android.content.Context context) {
            setBackgroundColor(com.taobao.weex.utils.WXResourceUtils.getColor("#ee000000"));
            this.mProgressBar = new android.widget.ProgressBar(context);
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
            this.mProgressBar.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            addView(this.mProgressBar);
            getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public android.widget.ProgressBar getProgressBar() {
            return this.mProgressBar;
        }

        public com.taobao.weex.ui.view.WXVideoView getVideoView() {
            return this.mVideoView;
        }

        public com.taobao.weex.ui.view.WXVideoView createIfNotExist() {
            if (this.mVideoView == null) {
                createVideoView();
            }
            return this.mVideoView;
        }

        public android.widget.MediaController getMediaController() {
            return this.mMediaController;
        }

        public void setVideoURI(android.net.Uri uri) {
            this.mUri = uri;
            com.taobao.weex.ui.view.WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.setVideoURI(uri);
            }
        }

        public void start() {
            com.taobao.weex.ui.view.WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.start();
            }
        }

        public void pause() {
            com.taobao.weex.ui.view.WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.pause();
            }
        }

        public void stopPlayback() {
            com.taobao.weex.ui.view.WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.stopPlayback();
            }
        }

        public void resume() {
            com.taobao.weex.ui.view.WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.resume();
            }
        }

        public void setOnErrorListener(android.media.MediaPlayer.OnErrorListener onErrorListener) {
            this.mOnErrorListener = onErrorListener;
            com.taobao.weex.ui.view.WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.setOnErrorListener(onErrorListener);
            }
        }

        public void setOnPreparedListener(android.media.MediaPlayer.OnPreparedListener onPreparedListener) {
            this.mOnPreparedListener = onPreparedListener;
            com.taobao.weex.ui.view.WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.setOnPreparedListener(onPreparedListener);
            }
        }

        public void setOnCompletionListener(android.media.MediaPlayer.OnCompletionListener onCompletionListener) {
            this.mOnCompletionListener = onCompletionListener;
            com.taobao.weex.ui.view.WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.setOnCompletionListener(onCompletionListener);
            }
        }

        public void setOnVideoPauseListener(com.taobao.weex.ui.view.WXVideoView.VideoPlayListener videoPlayListener) {
            this.mVideoPlayListener = videoPlayListener;
            com.taobao.weex.ui.view.WXVideoView wXVideoView = this.mVideoView;
            if (wXVideoView != null) {
                wXVideoView.setOnVideoPauseListener(videoPlayListener);
            }
        }

        public void setControls(boolean z) {
            android.widget.MediaController mediaController;
            this.mControls = z;
            if (this.mVideoView == null || (mediaController = this.mMediaController) == null) {
                return;
            }
            if (!z) {
                mediaController.setVisibility(8);
            } else {
                mediaController.setVisibility(0);
            }
        }

        private synchronized void createVideoView() {
            if (this.mVideoView != null) {
                return;
            }
            android.content.Context context = getContext();
            com.taobao.weex.ui.view.WXVideoView wXVideoView = new com.taobao.weex.ui.view.WXVideoView(context);
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            wXVideoView.setLayoutParams(layoutParams);
            addView(wXVideoView, 0);
            wXVideoView.setOnErrorListener(this.mOnErrorListener);
            wXVideoView.setOnPreparedListener(this.mOnPreparedListener);
            wXVideoView.setOnCompletionListener(this.mOnCompletionListener);
            wXVideoView.setOnVideoPauseListener(this.mVideoPlayListener);
            android.widget.MediaController mediaController = new android.widget.MediaController(context);
            mediaController.setAnchorView(this);
            wXVideoView.setMediaController(mediaController);
            mediaController.setMediaPlayer(wXVideoView);
            if (!this.mControls) {
                mediaController.setVisibility(8);
            } else {
                mediaController.setVisibility(0);
            }
            this.mMediaController = mediaController;
            this.mVideoView = wXVideoView;
            wXVideoView.setZOrderOnTop(true);
            android.net.Uri uri = this.mUri;
            if (uri != null) {
                setVideoURI(uri);
            }
        }

        private void removeSelfFromViewTreeObserver() {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        public boolean createVideoViewIfVisible() {
            android.graphics.Rect rect = new android.graphics.Rect();
            if (this.mVideoView != null) {
                return true;
            }
            if (!getGlobalVisibleRect(rect) || rect.isEmpty()) {
                return false;
            }
            createVideoView();
            return true;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (createVideoViewIfVisible()) {
                removeSelfFromViewTreeObserver();
            }
        }
    }
}
