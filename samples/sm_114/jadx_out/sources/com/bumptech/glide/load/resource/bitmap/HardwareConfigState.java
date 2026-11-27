package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public final class HardwareConfigState {
    public static final boolean BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED;
    private static final java.io.File FD_SIZE_LIST;
    public static final boolean HARDWARE_BITMAPS_SUPPORTED;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_P = 20000;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;

    @java.lang.Deprecated
    public static final int NO_MAX_FD_COUNT = -1;
    private static final int REDUCED_MAX_FDS_FOR_HARDWARE_CONFIGS_P = 500;
    private static final java.lang.String TAG = "HardwareConfig";
    private static volatile com.bumptech.glide.load.resource.bitmap.HardwareConfigState instance;
    private int decodesSinceLastFdCheck;
    private boolean isFdSizeBelowHardwareLimit = true;
    private final java.util.concurrent.atomic.AtomicBoolean isHardwareConfigAllowedByAppState = new java.util.concurrent.atomic.AtomicBoolean(false);
    private final int sdkBasedMaxFdCount = 20000;

    static {
        BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED = android.os.Build.VERSION.SDK_INT < 29;
        HARDWARE_BITMAPS_SUPPORTED = android.os.Build.VERSION.SDK_INT >= 28;
        FD_SIZE_LIST = new java.io.File("/proc/self/fd");
    }

    public static com.bumptech.glide.load.resource.bitmap.HardwareConfigState getInstance() {
        if (instance == null) {
            synchronized (com.bumptech.glide.load.resource.bitmap.HardwareConfigState.class) {
                if (instance == null) {
                    instance = new com.bumptech.glide.load.resource.bitmap.HardwareConfigState();
                }
            }
        }
        return instance;
    }

    HardwareConfigState() {
    }

    public void blockHardwareBitmaps() {
        com.bumptech.glide.util.Util.assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(false);
    }

    public void unblockHardwareBitmaps() {
        com.bumptech.glide.util.Util.assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(true);
    }

    public boolean isHardwareConfigAllowed(int i, int i2, boolean z, boolean z2) {
        if (!z) {
            if (android.util.Log.isLoggable(TAG, 2)) {
                android.util.Log.v(TAG, "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!HARDWARE_BITMAPS_SUPPORTED) {
            if (android.util.Log.isLoggable(TAG, 2)) {
                android.util.Log.v(TAG, "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (areHardwareBitmapsBlockedByAppState()) {
            if (android.util.Log.isLoggable(TAG, 2)) {
                android.util.Log.v(TAG, "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z2) {
            if (android.util.Log.isLoggable(TAG, 2)) {
                android.util.Log.v(TAG, "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        if (i < 0 || i2 < 0) {
            if (android.util.Log.isLoggable(TAG, 2)) {
                android.util.Log.v(TAG, "Hardware config disallowed because of invalid dimensions");
            }
            return false;
        }
        if (isFdSizeBelowHardwareLimit()) {
            return true;
        }
        if (android.util.Log.isLoggable(TAG, 2)) {
            android.util.Log.v(TAG, "Hardware config disallowed because there are insufficient FDs");
        }
        return false;
    }

    private boolean areHardwareBitmapsBlockedByAppState() {
        return BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED && !this.isHardwareConfigAllowedByAppState.get();
    }

    boolean setHardwareConfigIfAllowed(int i, int i2, android.graphics.BitmapFactory.Options options, boolean z, boolean z2) {
        boolean zIsHardwareConfigAllowed = isHardwareConfigAllowed(i, i2, z, z2);
        if (zIsHardwareConfigAllowed) {
            options.inPreferredConfig = android.graphics.Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zIsHardwareConfigAllowed;
    }

    private static boolean isHardwareBitmapCountReducedOnApi28ByB139097735() {
        if (android.os.Build.VERSION.SDK_INT != 28) {
            return false;
        }
        java.util.Iterator it = java.util.Arrays.asList("GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013").iterator();
        while (it.hasNext()) {
            if (android.os.Build.MODEL.startsWith((java.lang.String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private int getMaxFdCount() {
        return isHardwareBitmapCountReducedOnApi28ByB139097735() ? REDUCED_MAX_FDS_FOR_HARDWARE_CONFIGS_P : this.sdkBasedMaxFdCount;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        boolean z = true;
        int i = this.decodesSinceLastFdCheck + 1;
        this.decodesSinceLastFdCheck = i;
        if (i >= 50) {
            this.decodesSinceLastFdCheck = 0;
            int length = FD_SIZE_LIST.list().length;
            long maxFdCount = getMaxFdCount();
            if (length >= maxFdCount) {
                z = false;
            }
            this.isFdSizeBelowHardwareLimit = z;
            if (!z && android.util.Log.isLoggable("Downsampler", 5)) {
                android.util.Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + maxFdCount);
            }
        }
        return this.isFdSizeBelowHardwareLimit;
    }
}
