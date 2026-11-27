package kotlin;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class UByte$$ExternalSyntheticBackport0 {
    public static /* synthetic */ int m(double d) {
        long jDoubleToLongBits = java.lang.Double.doubleToLongBits(d);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public static /* synthetic */ int m(int i, int i2) {
        long j = ((long) i) + ((long) i2);
        int i3 = (int) j;
        if (j == i3) {
            return i3;
        }
        throw new java.lang.ArithmeticException();
    }

    public static /* synthetic */ int m(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static /* synthetic */ int m(java.lang.reflect.Method method) {
        return method.getParameterTypes().length;
    }

    public static /* synthetic */ int m(boolean z) {
        return z ? 1231 : 1237;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ long m610m(long j, long j2) {
        long j3 = j + j2;
        if (((j2 ^ j) < 0) || ((j ^ j3) >= 0)) {
            return j3;
        }
        throw new java.lang.ArithmeticException();
    }

    public static /* synthetic */ void m(java.lang.Object obj) throws java.lang.Exception {
        if (obj instanceof java.lang.AutoCloseable) {
            ((java.lang.AutoCloseable) obj).close();
            return;
        }
        if (obj instanceof java.util.concurrent.ExecutorService) {
            m((java.util.concurrent.ExecutorService) obj);
            return;
        }
        if (obj instanceof android.content.res.TypedArray) {
            ((android.content.res.TypedArray) obj).recycle();
            return;
        }
        if (obj instanceof android.media.MediaMetadataRetriever) {
            ((android.media.MediaMetadataRetriever) obj).release();
            return;
        }
        if (obj instanceof android.media.MediaDrm) {
            ((android.media.MediaDrm) obj).release();
            return;
        }
        if (obj instanceof android.drm.DrmManagerClient) {
            ((android.drm.DrmManagerClient) obj).release();
        } else if (obj instanceof android.content.ContentProviderClient) {
            ((android.content.ContentProviderClient) obj).release();
        } else {
            m$1(obj);
        }
    }

    public static /* synthetic */ void m(java.util.concurrent.ExecutorService executorService) {
        boolean zIsTerminated;
        if ((android.os.Build.VERSION.SDK_INT <= 23 || executorService != java.util.concurrent.ForkJoinPool.commonPool()) && !(zIsTerminated = executorService.isTerminated())) {
            executorService.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = executorService.awaitTermination(1L, java.util.concurrent.TimeUnit.DAYS);
                } catch (java.lang.InterruptedException unused) {
                    if (!z) {
                        executorService.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                java.lang.Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ boolean m611m(java.lang.Object obj) {
        return obj == null;
    }

    public static /* synthetic */ int m$1(int i, int i2) {
        long j = ((long) i) * ((long) i2);
        int i3 = (int) j;
        if (j == i3) {
            return i3;
        }
        throw new java.lang.ArithmeticException();
    }

    public static /* synthetic */ long m$1(long j, long j2) {
        int iNumberOfLeadingZeros = java.lang.Long.numberOfLeadingZeros(j) + java.lang.Long.numberOfLeadingZeros(~j) + java.lang.Long.numberOfLeadingZeros(j2) + java.lang.Long.numberOfLeadingZeros(~j2);
        if (iNumberOfLeadingZeros > 65) {
            return j * j2;
        }
        if (iNumberOfLeadingZeros >= 64) {
            if ((j >= 0) | (j2 != Long.MIN_VALUE)) {
                long j3 = j * j2;
                if (j == 0 || j3 / j == j2) {
                    return j3;
                }
            }
        }
        throw new java.lang.ArithmeticException();
    }

    public static /* synthetic */ void m$1(java.lang.Object obj) {
        throw new java.lang.IllegalArgumentException();
    }

    public static /* synthetic */ int m$2(int i, int i2) {
        long j = ((long) i) - ((long) i2);
        int i3 = (int) j;
        if (j == i3) {
            return i3;
        }
        throw new java.lang.ArithmeticException();
    }

    public static /* synthetic */ long m$2(long j, long j2) {
        long j3 = j - j2;
        if (((j2 ^ j) >= 0) || ((j ^ j3) >= 0)) {
            return j3;
        }
        throw new java.lang.ArithmeticException();
    }

    public static /* synthetic */ int m$3(int i, int i2) {
        return (int) ((((long) i) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT) / (((long) i2) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    public static /* synthetic */ long m$3(long j, long j2) {
        if (j2 < 0) {
            return (j ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ j2) ? j : j - j2;
        }
        if (j >= 0) {
            return j % j2;
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if ((j3 ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ j2)) {
            j2 = 0;
        }
        return j3 - j2;
    }

    public static /* synthetic */ int m$4(int i, int i2) {
        return (int) ((((long) i) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT) % (((long) i2) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    public static /* synthetic */ long m$4(long j, long j2) {
        if (j2 < 0) {
            return (j ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE) ? 0L : 1L;
        }
        if (j >= 0) {
            return j / j2;
        }
        long j3 = ((j >>> 1) / j2) << 1;
        return j3 + ((long) (((j - (j3 * j2)) ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE) ? 0 : 1));
    }
}
