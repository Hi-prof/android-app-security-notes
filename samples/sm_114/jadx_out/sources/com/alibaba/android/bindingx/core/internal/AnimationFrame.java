package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
abstract class AnimationFrame {

    interface Callback {
        void doFrame();
    }

    abstract void clear();

    abstract void requestAnimationFrame(com.alibaba.android.bindingx.core.internal.AnimationFrame.Callback callback);

    abstract void terminate();

    AnimationFrame() {
    }

    static com.alibaba.android.bindingx.core.internal.AnimationFrame newInstance() {
        return new com.alibaba.android.bindingx.core.internal.AnimationFrame.ChoreographerAnimationFrameImpl();
    }

    private static class ChoreographerAnimationFrameImpl extends com.alibaba.android.bindingx.core.internal.AnimationFrame implements android.view.Choreographer.FrameCallback {
        private com.alibaba.android.bindingx.core.internal.AnimationFrame.Callback callback;
        private android.view.Choreographer choreographer;
        private boolean isRunning;

        ChoreographerAnimationFrameImpl() {
            if (android.os.Looper.myLooper() == null) {
                android.os.Looper.prepare();
            }
            this.choreographer = android.view.Choreographer.getInstance();
        }

        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        void clear() {
            android.view.Choreographer choreographer = this.choreographer;
            if (choreographer != null) {
                choreographer.removeFrameCallback(this);
            }
            this.isRunning = false;
        }

        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        void terminate() {
            clear();
            this.choreographer = null;
        }

        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        void requestAnimationFrame(com.alibaba.android.bindingx.core.internal.AnimationFrame.Callback callback) {
            this.callback = callback;
            this.isRunning = true;
            android.view.Choreographer choreographer = this.choreographer;
            if (choreographer != null) {
                choreographer.postFrameCallback(this);
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            com.alibaba.android.bindingx.core.internal.AnimationFrame.Callback callback = this.callback;
            if (callback != null) {
                callback.doFrame();
            }
            android.view.Choreographer choreographer = this.choreographer;
            if (choreographer == null || !this.isRunning) {
                return;
            }
            choreographer.postFrameCallback(this);
        }
    }

    private static class HandlerAnimationFrameImpl extends com.alibaba.android.bindingx.core.internal.AnimationFrame implements android.os.Handler.Callback {
        private static final long DEFAULT_DELAY_MILLIS = 16;
        private static final int MSG_FRAME_CALLBACK = 100;
        private com.alibaba.android.bindingx.core.internal.AnimationFrame.Callback callback;
        private boolean isRunning;
        private android.os.Handler mInnerHandler;
        private android.os.HandlerThread mInnerHandlerThread;

        HandlerAnimationFrameImpl() {
            if (this.mInnerHandlerThread != null) {
                terminate();
            }
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("expression-timing-thread");
            this.mInnerHandlerThread = handlerThread;
            handlerThread.start();
            this.mInnerHandler = new android.os.Handler(this.mInnerHandlerThread.getLooper(), this);
        }

        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        void clear() {
            android.os.Handler handler = this.mInnerHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.isRunning = false;
        }

        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        void terminate() {
            clear();
            this.mInnerHandlerThread.quitSafely();
            this.mInnerHandler = null;
            this.mInnerHandlerThread = null;
        }

        @Override // com.alibaba.android.bindingx.core.internal.AnimationFrame
        void requestAnimationFrame(com.alibaba.android.bindingx.core.internal.AnimationFrame.Callback callback) {
            this.callback = callback;
            this.isRunning = true;
            android.os.Handler handler = this.mInnerHandler;
            if (handler != null) {
                handler.sendEmptyMessage(100);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            if (message == null || message.what != 100 || this.mInnerHandler == null) {
                return false;
            }
            com.alibaba.android.bindingx.core.internal.AnimationFrame.Callback callback = this.callback;
            if (callback != null) {
                callback.doFrame();
            }
            if (!this.isRunning) {
                return true;
            }
            this.mInnerHandler.sendEmptyMessageDelayed(100, 16L);
            return true;
        }
    }
}
