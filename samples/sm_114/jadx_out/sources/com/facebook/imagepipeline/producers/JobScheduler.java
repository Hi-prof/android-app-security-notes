package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class JobScheduler {
    static final java.lang.String QUEUE_TIME_KEY = "queueTime";
    private final java.util.concurrent.Executor mExecutor;
    private final com.facebook.imagepipeline.producers.JobScheduler.JobRunnable mJobRunnable;
    private final int mMinimumJobIntervalMs;
    private final java.lang.Runnable mDoJobRunnable = new java.lang.Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public void run() {
            com.facebook.imagepipeline.producers.JobScheduler.this.doJob();
        }
    };
    private final java.lang.Runnable mSubmitJobRunnable = new java.lang.Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.2
        @Override // java.lang.Runnable
        public void run() {
            com.facebook.imagepipeline.producers.JobScheduler.this.submitJob();
        }
    };

    @javax.annotation.Nullable
    com.facebook.imagepipeline.image.EncodedImage mEncodedImage = null;
    int mStatus = 0;
    com.facebook.imagepipeline.producers.JobScheduler.JobState mJobState = com.facebook.imagepipeline.producers.JobScheduler.JobState.IDLE;
    long mJobSubmitTime = 0;
    long mJobStartTime = 0;

    public interface JobRunnable {
        void run(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage, int i);
    }

    enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    static class JobStartExecutorSupplier {
        private static java.util.concurrent.ScheduledExecutorService sJobStarterExecutor;

        JobStartExecutorSupplier() {
        }

        static java.util.concurrent.ScheduledExecutorService get() {
            if (sJobStarterExecutor == null) {
                sJobStarterExecutor = java.util.concurrent.Executors.newSingleThreadScheduledExecutor();
            }
            return sJobStarterExecutor;
        }
    }

    public JobScheduler(java.util.concurrent.Executor executor, com.facebook.imagepipeline.producers.JobScheduler.JobRunnable jobRunnable, int i) {
        this.mExecutor = executor;
        this.mJobRunnable = jobRunnable;
        this.mMinimumJobIntervalMs = i;
    }

    public void clearJob() {
        com.facebook.imagepipeline.image.EncodedImage encodedImage;
        synchronized (this) {
            encodedImage = this.mEncodedImage;
            this.mEncodedImage = null;
            this.mStatus = 0;
        }
        com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
    }

    public boolean updateJob(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage, int i) {
        com.facebook.imagepipeline.image.EncodedImage encodedImage2;
        if (!shouldProcess(encodedImage, i)) {
            return false;
        }
        synchronized (this) {
            encodedImage2 = this.mEncodedImage;
            this.mEncodedImage = com.facebook.imagepipeline.image.EncodedImage.cloneOrNull(encodedImage);
            this.mStatus = i;
        }
        com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage2);
        return true;
    }

    public boolean scheduleJob() {
        long jMax;
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        synchronized (this) {
            boolean z = false;
            if (!shouldProcess(this.mEncodedImage, this.mStatus)) {
                return false;
            }
            int i = com.facebook.imagepipeline.producers.JobScheduler.AnonymousClass3.$SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[this.mJobState.ordinal()];
            if (i != 1) {
                if (i == 3) {
                    this.mJobState = com.facebook.imagepipeline.producers.JobScheduler.JobState.RUNNING_AND_PENDING;
                }
                jMax = 0;
            } else {
                jMax = java.lang.Math.max(this.mJobStartTime + ((long) this.mMinimumJobIntervalMs), jUptimeMillis);
                this.mJobSubmitTime = jUptimeMillis;
                this.mJobState = com.facebook.imagepipeline.producers.JobScheduler.JobState.QUEUED;
                z = true;
            }
            if (z) {
                enqueueJob(jMax - jUptimeMillis);
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.JobScheduler$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState;

        static {
            int[] iArr = new int[com.facebook.imagepipeline.producers.JobScheduler.JobState.values().length];
            $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState = iArr;
            try {
                iArr[com.facebook.imagepipeline.producers.JobScheduler.JobState.IDLE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[com.facebook.imagepipeline.producers.JobScheduler.JobState.QUEUED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[com.facebook.imagepipeline.producers.JobScheduler.JobState.RUNNING.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[com.facebook.imagepipeline.producers.JobScheduler.JobState.RUNNING_AND_PENDING.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    private void enqueueJob(long j) {
        java.lang.Runnable runnableDecorateRunnable = com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.decorateRunnable(this.mSubmitJobRunnable, "JobScheduler_enqueueJob");
        if (j > 0) {
            com.facebook.imagepipeline.producers.JobScheduler.JobStartExecutorSupplier.get().schedule(runnableDecorateRunnable, j, java.util.concurrent.TimeUnit.MILLISECONDS);
        } else {
            runnableDecorateRunnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitJob() {
        this.mExecutor.execute(com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.decorateRunnable(this.mDoJobRunnable, "JobScheduler_submitJob"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doJob() {
        com.facebook.imagepipeline.image.EncodedImage encodedImage;
        int i;
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        synchronized (this) {
            encodedImage = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.mJobState = com.facebook.imagepipeline.producers.JobScheduler.JobState.RUNNING;
            this.mJobStartTime = jUptimeMillis;
        }
        try {
            if (shouldProcess(encodedImage, i)) {
                this.mJobRunnable.run(encodedImage, i);
            }
        } finally {
            com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
            onJobFinished();
        }
    }

    private void onJobFinished() {
        long jMax;
        boolean z;
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        synchronized (this) {
            if (this.mJobState == com.facebook.imagepipeline.producers.JobScheduler.JobState.RUNNING_AND_PENDING) {
                jMax = java.lang.Math.max(this.mJobStartTime + ((long) this.mMinimumJobIntervalMs), jUptimeMillis);
                this.mJobSubmitTime = jUptimeMillis;
                this.mJobState = com.facebook.imagepipeline.producers.JobScheduler.JobState.QUEUED;
                z = true;
            } else {
                this.mJobState = com.facebook.imagepipeline.producers.JobScheduler.JobState.IDLE;
                jMax = 0;
                z = false;
            }
        }
        if (z) {
            enqueueJob(jMax - jUptimeMillis);
        }
    }

    private static boolean shouldProcess(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage, int i) {
        return com.facebook.imagepipeline.producers.BaseConsumer.isLast(i) || com.facebook.imagepipeline.producers.BaseConsumer.statusHasFlag(i, 4) || com.facebook.imagepipeline.image.EncodedImage.isValid(encodedImage);
    }

    public synchronized long getQueuedTime() {
        return this.mJobStartTime - this.mJobSubmitTime;
    }
}
