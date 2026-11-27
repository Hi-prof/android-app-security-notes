package androidtranscoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class MediaTranscoder {
    private static final int MAXIMUM_THREAD = 1;
    private static final java.lang.String TAG = "MediaTranscoder";
    private static volatile androidtranscoder.MediaTranscoder sMediaTranscoder;
    private java.util.concurrent.ThreadPoolExecutor mExecutor = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new java.util.concurrent.ThreadFactory() { // from class: androidtranscoder.MediaTranscoder.1
        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "MediaTranscoder-Worker");
        }
    });

    /* JADX INFO: renamed from: androidtranscoder.MediaTranscoder$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class AnonymousClass4 implements java.util.concurrent.Callable<java.lang.Void> {
        final /* synthetic */ java.util.concurrent.atomic.AtomicReference val$futureReference;
        final /* synthetic */ android.os.Handler val$handler;
        final /* synthetic */ java.io.FileDescriptor val$inFileDescriptor;
        final /* synthetic */ androidtranscoder.MediaTranscoder.Listener val$listener;
        final /* synthetic */ androidtranscoder.format.MediaFormatStrategy val$outFormatStrategy;
        final /* synthetic */ java.lang.String val$outPath;

        AnonymousClass4(android.os.Handler handler, androidtranscoder.MediaTranscoder.Listener listener, java.io.FileDescriptor fileDescriptor, java.lang.String str, androidtranscoder.format.MediaFormatStrategy mediaFormatStrategy, java.util.concurrent.atomic.AtomicReference atomicReference) {
            this.val$handler = handler;
            this.val$listener = listener;
            this.val$inFileDescriptor = fileDescriptor;
            this.val$outPath = str;
            this.val$outFormatStrategy = mediaFormatStrategy;
            this.val$futureReference = atomicReference;
        }

        @Override // java.util.concurrent.Callable
        public java.lang.Void call() throws java.lang.Exception {
            try {
                androidtranscoder.engine.MediaTranscoderEngine mediaTranscoderEngine = new androidtranscoder.engine.MediaTranscoderEngine();
                mediaTranscoderEngine.setProgressCallback(new androidtranscoder.engine.MediaTranscoderEngine.ProgressCallback() { // from class: androidtranscoder.MediaTranscoder.4.1
                    @Override // androidtranscoder.engine.MediaTranscoderEngine.ProgressCallback
                    public void onProgress(final double d) {
                        androidtranscoder.MediaTranscoder.AnonymousClass4.this.val$handler.post(new java.lang.Runnable() { // from class: androidtranscoder.MediaTranscoder.4.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                androidtranscoder.MediaTranscoder.AnonymousClass4.this.val$listener.onTranscodeProgress(d);
                            }
                        });
                    }
                });
                mediaTranscoderEngine.setDataSource(this.val$inFileDescriptor);
                mediaTranscoderEngine.transcodeVideo(this.val$outPath, this.val$outFormatStrategy);
                e = null;
            } catch (java.io.IOException e) {
                e = e;
                android.util.Log.w(androidtranscoder.MediaTranscoder.TAG, "Transcode failed: input file (fd: " + this.val$inFileDescriptor.toString() + ") not found or could not open output file ('" + this.val$outPath + "') .", e);
            } catch (java.lang.InterruptedException e2) {
                e = e2;
                android.util.Log.i(androidtranscoder.MediaTranscoder.TAG, "Cancel transcode video file.", e);
            } catch (java.lang.RuntimeException e3) {
                e = e3;
                android.util.Log.e(androidtranscoder.MediaTranscoder.TAG, "Fatal error while transcoding, this might be invalid format or bug in engine or Android.", e);
            }
            this.val$handler.post(new java.lang.Runnable() { // from class: androidtranscoder.MediaTranscoder.4.2
                @Override // java.lang.Runnable
                public void run() {
                    if (e == null) {
                        androidtranscoder.MediaTranscoder.AnonymousClass4.this.val$listener.onTranscodeCompleted();
                        return;
                    }
                    java.util.concurrent.Future future = (java.util.concurrent.Future) androidtranscoder.MediaTranscoder.AnonymousClass4.this.val$futureReference.get();
                    if (future == null || !future.isCancelled()) {
                        androidtranscoder.MediaTranscoder.AnonymousClass4.this.val$listener.onTranscodeFailed(e);
                    } else {
                        androidtranscoder.MediaTranscoder.AnonymousClass4.this.val$listener.onTranscodeCanceled();
                    }
                }
            });
            if (e == null) {
                return null;
            }
            throw e;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface Listener {
        void onTranscodeCanceled();

        void onTranscodeCompleted();

        void onTranscodeFailed(java.lang.Exception exc);

        void onTranscodeProgress(double d);
    }

    private MediaTranscoder() {
    }

    public static androidtranscoder.MediaTranscoder getInstance() {
        if (sMediaTranscoder == null) {
            synchronized (androidtranscoder.MediaTranscoder.class) {
                if (sMediaTranscoder == null) {
                    sMediaTranscoder = new androidtranscoder.MediaTranscoder();
                }
            }
        }
        return sMediaTranscoder;
    }

    @java.lang.Deprecated
    public java.util.concurrent.Future<java.lang.Void> transcodeVideo(java.io.FileDescriptor fileDescriptor, java.lang.String str, androidtranscoder.MediaTranscoder.Listener listener) {
        return transcodeVideo(fileDescriptor, str, new androidtranscoder.format.MediaFormatStrategy() { // from class: androidtranscoder.MediaTranscoder.2
            @Override // androidtranscoder.format.MediaFormatStrategy
            public android.media.MediaFormat createAudioOutputFormat(android.media.MediaFormat mediaFormat) {
                return null;
            }

            @Override // androidtranscoder.format.MediaFormatStrategy
            public android.media.MediaFormat createVideoOutputFormat(android.media.MediaFormat mediaFormat) {
                return androidtranscoder.format.MediaFormatPresets.getExportPreset960x540();
            }
        }, listener);
    }

    public java.util.concurrent.Future<java.lang.Void> transcodeVideo(java.lang.String str, java.lang.String str2, androidtranscoder.format.MediaFormatStrategy mediaFormatStrategy, final androidtranscoder.MediaTranscoder.Listener listener) throws java.io.IOException {
        final java.io.FileInputStream fileInputStream;
        try {
            fileInputStream = new java.io.FileInputStream(str);
            try {
                return transcodeVideo(fileInputStream.getFD(), str2, mediaFormatStrategy, new androidtranscoder.MediaTranscoder.Listener() { // from class: androidtranscoder.MediaTranscoder.3
                    private void closeStream() {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException e) {
                            android.util.Log.e(androidtranscoder.MediaTranscoder.TAG, "Can't close input stream: ", e);
                        }
                    }

                    @Override // androidtranscoder.MediaTranscoder.Listener
                    public void onTranscodeCanceled() {
                        closeStream();
                        listener.onTranscodeCanceled();
                    }

                    @Override // androidtranscoder.MediaTranscoder.Listener
                    public void onTranscodeCompleted() {
                        closeStream();
                        listener.onTranscodeCompleted();
                    }

                    @Override // androidtranscoder.MediaTranscoder.Listener
                    public void onTranscodeFailed(java.lang.Exception exc) {
                        closeStream();
                        listener.onTranscodeFailed(exc);
                    }

                    @Override // androidtranscoder.MediaTranscoder.Listener
                    public void onTranscodeProgress(double d) {
                        listener.onTranscodeProgress(d);
                    }
                });
            } catch (java.io.IOException e) {
                e = e;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (java.io.IOException e2) {
                        android.util.Log.e(TAG, "Can't close input stream: ", e2);
                    }
                }
                throw e;
            }
        } catch (java.io.IOException e3) {
            e = e3;
            fileInputStream = null;
        }
    }

    public java.util.concurrent.Future<java.lang.Void> transcodeVideo(java.io.FileDescriptor fileDescriptor, java.lang.String str, androidtranscoder.format.MediaFormatStrategy mediaFormatStrategy, androidtranscoder.MediaTranscoder.Listener listener) {
        android.os.Looper looperMyLooper = android.os.Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = android.os.Looper.getMainLooper();
        }
        android.os.Handler handler = new android.os.Handler(looperMyLooper);
        java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
        java.util.concurrent.Future<java.lang.Void> futureSubmit = this.mExecutor.submit(new androidtranscoder.MediaTranscoder.AnonymousClass4(handler, listener, fileDescriptor, str, mediaFormatStrategy, atomicReference));
        atomicReference.set(futureSubmit);
        return futureSubmit;
    }
}
