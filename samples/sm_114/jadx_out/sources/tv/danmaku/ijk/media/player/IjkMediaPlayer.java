package tv.danmaku.ijk.media.player;

/* JADX INFO: loaded from: classes2.dex */
public final class IjkMediaPlayer extends tv.danmaku.ijk.media.player.AbstractMediaPlayer {
    public static final int FFP_PROPV_DECODER_AVCODEC = 1;
    public static final int FFP_PROPV_DECODER_MEDIACODEC = 2;
    public static final int FFP_PROPV_DECODER_UNKNOWN = 0;
    public static final int FFP_PROPV_DECODER_VIDEOTOOLBOX = 3;
    public static final int FFP_PROP_FLOAT_DROP_FRAME_RATE = 10007;
    public static final int FFP_PROP_FLOAT_PLAYBACK_RATE = 10003;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS = 20201;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY = 20203;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS = 20202;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_BYTES = 20008;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_DURATION = 20006;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_PACKETS = 20010;
    public static final int FFP_PROP_INT64_AUDIO_DECODER = 20004;
    public static final int FFP_PROP_INT64_BIT_RATE = 20100;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_COUNT_BYTES = 20208;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_FORWARDS = 20206;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_POS = 20207;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_PHYSICAL_POS = 20205;
    public static final int FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION = 20300;
    public static final int FFP_PROP_INT64_LOGICAL_FILE_SIZE = 20209;
    public static final int FFP_PROP_INT64_SELECTED_AUDIO_STREAM = 20002;
    public static final int FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM = 20011;
    public static final int FFP_PROP_INT64_SELECTED_VIDEO_STREAM = 20001;
    public static final int FFP_PROP_INT64_SHARE_CACHE_DATA = 20210;
    public static final int FFP_PROP_INT64_TCP_SPEED = 20200;
    public static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT = 20204;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_BYTES = 20007;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_DURATION = 20005;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_PACKETS = 20009;
    public static final int FFP_PROP_INT64_VIDEO_DECODER = 20003;
    public static final int IJK_LOG_DEBUG = 3;
    public static final int IJK_LOG_DEFAULT = 1;
    public static final int IJK_LOG_ERROR = 6;
    public static final int IJK_LOG_FATAL = 7;
    public static final int IJK_LOG_INFO = 4;
    public static final int IJK_LOG_SILENT = 8;
    public static final int IJK_LOG_UNKNOWN = 0;
    public static final int IJK_LOG_VERBOSE = 2;
    public static final int IJK_LOG_WARN = 5;
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_ERROR = 100;
    private static final int MEDIA_INFO = 200;
    private static final int MEDIA_NOP = 0;
    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    private static final int MEDIA_PREPARED = 1;
    private static final int MEDIA_SEEK_COMPLETE = 4;
    protected static final int MEDIA_SET_VIDEO_SAR = 10001;
    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    private static final int MEDIA_TIMED_TEXT = 99;
    public static final int OPT_CATEGORY_CODEC = 2;
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final int OPT_CATEGORY_PLAYER = 4;
    public static final int OPT_CATEGORY_SWS = 3;
    public static final int PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND = 10001;
    public static final int PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND = 10002;
    public static final int SDL_FCC_RV16 = 909203026;
    public static final int SDL_FCC_RV32 = 842225234;
    public static final int SDL_FCC_YV12 = 842094169;
    private static final java.lang.String TAG = "tv.danmaku.ijk.media.player.IjkMediaPlayer";
    private java.lang.String mDataSource;
    private tv.danmaku.ijk.media.player.IjkMediaPlayer.EventHandler mEventHandler;
    private int mListenerContext;
    private long mNativeAndroidIO;
    private long mNativeMediaDataSource;
    private long mNativeMediaPlayer;
    private int mNativeSurfaceTexture;
    private tv.danmaku.ijk.media.player.IjkMediaPlayer.OnControlMessageListener mOnControlMessageListener;
    private tv.danmaku.ijk.media.player.IjkMediaPlayer.OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    private tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener mOnNativeInvokeListener;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private android.view.SurfaceHolder mSurfaceHolder;
    private int mVideoHeight;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private android.os.PowerManager.WakeLock mWakeLock;
    private static final tv.danmaku.ijk.media.player.IjkLibLoader sLocalLibLoader = new tv.danmaku.ijk.media.player.IjkLibLoader() { // from class: tv.danmaku.ijk.media.player.IjkMediaPlayer.1
        @Override // tv.danmaku.ijk.media.player.IjkLibLoader
        public void loadLibrary(java.lang.String str) throws java.lang.SecurityException, java.lang.UnsatisfiedLinkError {
            java.lang.System.loadLibrary(str);
        }
    };
    private static volatile boolean mIsLibLoaded = false;
    private static volatile boolean mIsNativeInitialized = false;

    public interface OnControlMessageListener {
        java.lang.String onControlResolveSegmentUrl(int i);
    }

    public interface OnMediaCodecSelectListener {
        java.lang.String onMediaCodecSelect(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, java.lang.String str, int i, int i2);
    }

    public interface OnNativeInvokeListener {
        public static final java.lang.String ARG_ERROR = "error";
        public static final java.lang.String ARG_FAMILIY = "family";
        public static final java.lang.String ARG_FD = "fd";
        public static final java.lang.String ARG_HTTP_CODE = "http_code";
        public static final java.lang.String ARG_IP = "ip";
        public static final java.lang.String ARG_OFFSET = "offset";
        public static final java.lang.String ARG_PORT = "port";
        public static final java.lang.String ARG_RETRY_COUNTER = "retry_counter";
        public static final java.lang.String ARG_SEGMENT_INDEX = "segment_index";
        public static final java.lang.String ARG_URL = "url";
        public static final int CTRL_DID_TCP_OPEN = 131074;
        public static final int CTRL_WILL_CONCAT_RESOLVE_SEGMENT = 131079;
        public static final int CTRL_WILL_HTTP_OPEN = 131075;
        public static final int CTRL_WILL_LIVE_OPEN = 131077;
        public static final int CTRL_WILL_TCP_OPEN = 131073;
        public static final int EVENT_DID_HTTP_OPEN = 2;
        public static final int EVENT_DID_HTTP_SEEK = 4;
        public static final int EVENT_WILL_HTTP_OPEN = 1;
        public static final int EVENT_WILL_HTTP_SEEK = 3;

        boolean onNativeInvoke(int i, android.os.Bundle bundle);
    }

    private native java.lang.String _getAudioCodecInfo();

    private static native java.lang.String _getColorFormatName(int i);

    private native int _getLoopCount();

    private native android.os.Bundle _getMediaMeta();

    private native float _getPropertyFloat(int i, float f);

    private native long _getPropertyLong(int i, long j);

    private native java.lang.String _getVideoCodecInfo();

    private native void _pause() throws java.lang.IllegalStateException;

    private native void _release();

    private native void _reset();

    private native void _setAndroidIOCallback(tv.danmaku.ijk.media.player.misc.IAndroidIO iAndroidIO) throws java.lang.IllegalStateException, java.lang.SecurityException, java.lang.IllegalArgumentException;

    private native void _setDataSource(java.lang.String str, java.lang.String[] strArr, java.lang.String[] strArr2) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException;

    private native void _setDataSource(tv.danmaku.ijk.media.player.misc.IMediaDataSource iMediaDataSource) throws java.lang.IllegalStateException, java.lang.SecurityException, java.lang.IllegalArgumentException;

    private native void _setDataSourceFd(int i) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException;

    private native void _setFrameAtTime(java.lang.String str, long j, long j2, int i, int i2) throws java.lang.IllegalStateException, java.lang.IllegalArgumentException;

    private native void _setLoopCount(int i);

    private native void _setOption(int i, java.lang.String str, long j);

    private native void _setOption(int i, java.lang.String str, java.lang.String str2);

    private native void _setPropertyFloat(int i, float f);

    private native void _setPropertyLong(int i, long j);

    private native void _setStreamSelected(int i, boolean z);

    private native void _setVideoSurface(android.view.Surface surface);

    private native void _start() throws java.lang.IllegalStateException;

    private native void _stop() throws java.lang.IllegalStateException;

    private native void native_finalize();

    private static native void native_init();

    private native void native_message_loop(java.lang.Object obj);

    public static native void native_profileBegin(java.lang.String str);

    public static native void native_profileEnd();

    public static native void native_setLogLevel(int i);

    private native void native_setup(java.lang.Object obj);

    public native void _prepareAsync() throws java.lang.IllegalStateException;

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native int getAudioSessionId();

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native long getCurrentPosition();

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native long getDuration();

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native boolean isPlaying();

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native void seekTo(long j) throws java.lang.IllegalStateException;

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native void setVolume(float f, float f2);

    public static void loadLibrariesOnce(tv.danmaku.ijk.media.player.IjkLibLoader ijkLibLoader) {
        synchronized (tv.danmaku.ijk.media.player.IjkMediaPlayer.class) {
            if (!mIsLibLoaded) {
                if (ijkLibLoader == null) {
                    ijkLibLoader = sLocalLibLoader;
                }
                ijkLibLoader.loadLibrary("ijkffmpeg");
                ijkLibLoader.loadLibrary("ijksdl");
                ijkLibLoader.loadLibrary("ijkplayer");
                mIsLibLoaded = true;
            }
        }
    }

    private static void initNativeOnce() {
        synchronized (tv.danmaku.ijk.media.player.IjkMediaPlayer.class) {
            if (!mIsNativeInitialized) {
                native_init();
                mIsNativeInitialized = true;
            }
        }
    }

    public IjkMediaPlayer() {
        this(sLocalLibLoader);
    }

    public IjkMediaPlayer(tv.danmaku.ijk.media.player.IjkLibLoader ijkLibLoader) {
        this.mWakeLock = null;
        initPlayer(ijkLibLoader);
    }

    private void initPlayer(tv.danmaku.ijk.media.player.IjkLibLoader ijkLibLoader) {
        loadLibrariesOnce(ijkLibLoader);
        initNativeOnce();
        android.os.Looper looperMyLooper = android.os.Looper.myLooper();
        if (looperMyLooper != null) {
            this.mEventHandler = new tv.danmaku.ijk.media.player.IjkMediaPlayer.EventHandler(this, looperMyLooper);
        } else {
            android.os.Looper mainLooper = android.os.Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new tv.danmaku.ijk.media.player.IjkMediaPlayer.EventHandler(this, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        native_setup(new java.lang.ref.WeakReference(this));
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(android.view.SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        _setVideoSurface(surfaceHolder != null ? surfaceHolder.getSurface() : null);
        updateSurfaceScreenOn();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(android.view.Surface surface) {
        if (this.mScreenOnWhilePlaying && surface != null) {
            tv.danmaku.ijk.media.player.pragma.DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.mSurfaceHolder = null;
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(android.content.Context context, android.net.Uri uri) throws java.lang.Throwable {
        setDataSource(context, uri, (java.util.Map<java.lang.String, java.lang.String>) null);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0097 A[PHI: r1
  0x0097: PHI (r1v11 android.content.res.AssetFileDescriptor) = (r1v9 android.content.res.AssetFileDescriptor), (r1v12 android.content.res.AssetFileDescriptor) binds: [B:51:0x0095, B:47:0x0090] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:65:? A[SYNTHETIC] */
    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(android.content.Context context, android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.lang.String scheme = uri.getScheme();
        if ("file".equals(scheme)) {
            setDataSource(uri.getPath());
            return;
        }
        if (com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME.equals(scheme) && "settings".equals(uri.getAuthority()) && (uri = android.media.RingtoneManager.getActualDefaultRingtoneUri(context, android.media.RingtoneManager.getDefaultType(uri))) == null) {
            throw new java.io.FileNotFoundException("Failed to resolve default ringtone");
        }
        android.content.res.AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = null;
        try {
            assetFileDescriptorOpenAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                    return;
                }
                return;
            }
            if (assetFileDescriptorOpenAssetFileDescriptor.getDeclaredLength() < 0) {
                try {
                    setDataSource(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                } catch (java.io.IOException unused) {
                } catch (java.lang.SecurityException unused2) {
                    if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                        assetFileDescriptorOpenAssetFileDescriptor.close();
                    }
                    android.util.Log.d(TAG, "Couldn't open file on client side, trying server side");
                    setDataSource(uri.toString(), map);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                        throw th;
                    }
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                    throw th;
                }
            } else {
                try {
                    setDataSource(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor(), assetFileDescriptorOpenAssetFileDescriptor.getStartOffset(), assetFileDescriptorOpenAssetFileDescriptor.getDeclaredLength());
                } catch (java.io.IOException unused3) {
                } catch (java.lang.SecurityException unused4) {
                    if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                        assetFileDescriptorOpenAssetFileDescriptor.close();
                    }
                    android.util.Log.d(TAG, "Couldn't open file on client side, trying server side");
                    setDataSource(uri.toString(), map);
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    th = th;
                    if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                        throw th;
                    }
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                    throw th;
                }
            }
            if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                assetFileDescriptorOpenAssetFileDescriptor.close();
                return;
            }
            return;
        } catch (java.io.IOException unused5) {
        } catch (java.lang.SecurityException unused6) {
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            assetFileDescriptorOpenAssetFileDescriptor.close();
        }
        android.util.Log.d(TAG, "Couldn't open file on client side, trying server side");
        setDataSource(uri.toString(), map);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(java.lang.String str) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        this.mDataSource = str;
        _setDataSource(str, null, null);
    }

    public void setDataSource(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        if (map != null && !map.isEmpty()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":");
                if (!android.text.TextUtils.isEmpty(entry.getValue())) {
                    sb.append(entry.getValue());
                }
                sb.append("\r\n");
                setOption(1, "headers", sb.toString());
                setOption(1, "protocol_whitelist", "async,cache,crypto,file,http,https,ijkhttphook,ijkinject,ijklivehook,ijklongurl,ijksegment,ijktcphook,pipe,rtp,tcp,tls,udp,ijkurlhook,data");
            }
        }
        setDataSource(str);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(java.io.FileDescriptor fileDescriptor) throws java.lang.IllegalStateException, java.io.IOException, java.lang.IllegalArgumentException {
        android.os.ParcelFileDescriptor parcelFileDescriptorDup = android.os.ParcelFileDescriptor.dup(fileDescriptor);
        try {
            _setDataSourceFd(parcelFileDescriptorDup.getFd());
        } finally {
            parcelFileDescriptorDup.close();
        }
    }

    private void setDataSource(java.io.FileDescriptor fileDescriptor, long j, long j2) throws java.lang.IllegalStateException, java.io.IOException, java.lang.IllegalArgumentException {
        setDataSource(fileDescriptor);
    }

    @Override // tv.danmaku.ijk.media.player.AbstractMediaPlayer, tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(tv.danmaku.ijk.media.player.misc.IMediaDataSource iMediaDataSource) throws java.lang.IllegalStateException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        _setDataSource(iMediaDataSource);
    }

    public void setAndroidIOCallback(tv.danmaku.ijk.media.player.misc.IAndroidIO iAndroidIO) throws java.lang.IllegalStateException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        _setAndroidIOCallback(iAndroidIO);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public java.lang.String getDataSource() {
        return this.mDataSource;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws java.lang.IllegalStateException {
        _prepareAsync();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws java.lang.IllegalStateException {
        stayAwake(true);
        _start();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws java.lang.IllegalStateException {
        stayAwake(false);
        _stop();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws java.lang.IllegalStateException {
        stayAwake(false);
        _pause();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setWakeMode(android.content.Context context, int i) {
        boolean z;
        android.os.PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                this.mWakeLock.release();
                z = true;
            } else {
                z = false;
            }
            this.mWakeLock = null;
        } else {
            z = false;
        }
        android.os.PowerManager.WakeLock wakeLockNewWakeLock = ((android.os.PowerManager) context.getSystemService("power")).newWakeLock(i | 536870912, tv.danmaku.ijk.media.player.IjkMediaPlayer.class.getName());
        this.mWakeLock = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
        if (z) {
            this.mWakeLock.acquire();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        if (this.mScreenOnWhilePlaying != z) {
            if (z && this.mSurfaceHolder == null) {
                tv.danmaku.ijk.media.player.pragma.DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z;
            updateSurfaceScreenOn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stayAwake(boolean z) {
        android.os.PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z;
        updateSurfaceScreenOn();
    }

    private void updateSurfaceScreenOn() {
        android.view.SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public tv.danmaku.ijk.media.player.misc.IjkTrackInfo[] getTrackInfo() {
        tv.danmaku.ijk.media.player.IjkMediaMeta ijkMediaMeta;
        android.os.Bundle mediaMeta = getMediaMeta();
        if (mediaMeta == null || (ijkMediaMeta = tv.danmaku.ijk.media.player.IjkMediaMeta.parse(mediaMeta)) == null || ijkMediaMeta.mStreams == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta ijkStreamMeta : ijkMediaMeta.mStreams) {
            tv.danmaku.ijk.media.player.misc.IjkTrackInfo ijkTrackInfo = new tv.danmaku.ijk.media.player.misc.IjkTrackInfo(ijkStreamMeta);
            if (ijkStreamMeta.mType.equalsIgnoreCase("video")) {
                ijkTrackInfo.setTrackType(1);
            } else if (ijkStreamMeta.mType.equalsIgnoreCase("audio")) {
                ijkTrackInfo.setTrackType(2);
            } else if (ijkStreamMeta.mType.equalsIgnoreCase("timedtext")) {
                ijkTrackInfo.setTrackType(3);
            }
            arrayList.add(ijkTrackInfo);
        }
        return (tv.danmaku.ijk.media.player.misc.IjkTrackInfo[]) arrayList.toArray(new tv.danmaku.ijk.media.player.misc.IjkTrackInfo[arrayList.size()]);
    }

    public int getSelectedTrack(int i) {
        long j_getPropertyLong;
        if (i == 1) {
            j_getPropertyLong = _getPropertyLong(FFP_PROP_INT64_SELECTED_VIDEO_STREAM, -1L);
        } else if (i == 2) {
            j_getPropertyLong = _getPropertyLong(FFP_PROP_INT64_SELECTED_AUDIO_STREAM, -1L);
        } else {
            if (i != 3) {
                return -1;
            }
            j_getPropertyLong = _getPropertyLong(FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM, -1L);
        }
        return (int) j_getPropertyLong;
    }

    public void selectTrack(int i) {
        _setStreamSelected(i, true);
    }

    public void deselectTrack(int i) {
        _setStreamSelected(i, false);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return this.mVideoSarNum;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return this.mVideoSarDen;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        stayAwake(false);
        updateSurfaceScreenOn();
        resetListeners();
        _release();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        stayAwake(false);
        _reset();
        this.mEventHandler.removeCallbacksAndMessages(null);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z) {
        int i = !z ? 1 : 0;
        setOption(4, "loop", i);
        _setLoopCount(i);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return _getLoopCount() != 1;
    }

    public void setSpeed(float f) {
        _setPropertyFloat(10003, f);
    }

    public float getSpeed(float f) {
        return _getPropertyFloat(10003, 0.0f);
    }

    public int getVideoDecoder() {
        return (int) _getPropertyLong(FFP_PROP_INT64_VIDEO_DECODER, 0L);
    }

    public float getVideoOutputFramesPerSecond() {
        return _getPropertyFloat(10002, 0.0f);
    }

    public float getVideoDecodeFramesPerSecond() {
        return _getPropertyFloat(10001, 0.0f);
    }

    public long getVideoCachedDuration() {
        return _getPropertyLong(FFP_PROP_INT64_VIDEO_CACHED_DURATION, 0L);
    }

    public long getAudioCachedDuration() {
        return _getPropertyLong(FFP_PROP_INT64_AUDIO_CACHED_DURATION, 0L);
    }

    public long getVideoCachedBytes() {
        return _getPropertyLong(FFP_PROP_INT64_VIDEO_CACHED_BYTES, 0L);
    }

    public long getAudioCachedBytes() {
        return _getPropertyLong(FFP_PROP_INT64_AUDIO_CACHED_BYTES, 0L);
    }

    public long getVideoCachedPackets() {
        return _getPropertyLong(FFP_PROP_INT64_VIDEO_CACHED_PACKETS, 0L);
    }

    public long getAudioCachedPackets() {
        return _getPropertyLong(FFP_PROP_INT64_AUDIO_CACHED_PACKETS, 0L);
    }

    public long getAsyncStatisticBufBackwards() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS, 0L);
    }

    public long getAsyncStatisticBufForwards() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS, 0L);
    }

    public long getAsyncStatisticBufCapacity() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY, 0L);
    }

    public long getTrafficStatisticByteCount() {
        return _getPropertyLong(FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT, 0L);
    }

    public long getCacheStatisticPhysicalPos() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_PHYSICAL_POS, 0L);
    }

    public long getCacheStatisticFileForwards() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_FILE_FORWARDS, 0L);
    }

    public long getCacheStatisticFilePos() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_FILE_POS, 0L);
    }

    public long getCacheStatisticCountBytes() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_COUNT_BYTES, 0L);
    }

    public long getFileSize() {
        return _getPropertyLong(FFP_PROP_INT64_LOGICAL_FILE_SIZE, 0L);
    }

    public long getBitRate() {
        return _getPropertyLong(FFP_PROP_INT64_BIT_RATE, 0L);
    }

    public long getTcpSpeed() {
        return _getPropertyLong(FFP_PROP_INT64_TCP_SPEED, 0L);
    }

    public long getSeekLoadDuration() {
        return _getPropertyLong(FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION, 0L);
    }

    public float getDropFrameRate() {
        return _getPropertyFloat(10007, 0.0f);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public tv.danmaku.ijk.media.player.MediaInfo getMediaInfo() {
        tv.danmaku.ijk.media.player.MediaInfo mediaInfo = new tv.danmaku.ijk.media.player.MediaInfo();
        mediaInfo.mMediaPlayerName = "ijkplayer";
        java.lang.String str_getVideoCodecInfo = _getVideoCodecInfo();
        if (!android.text.TextUtils.isEmpty(str_getVideoCodecInfo)) {
            java.lang.String[] strArrSplit = str_getVideoCodecInfo.split(",");
            if (strArrSplit.length >= 2) {
                mediaInfo.mVideoDecoder = strArrSplit[0];
                mediaInfo.mVideoDecoderImpl = strArrSplit[1];
            } else if (strArrSplit.length >= 1) {
                mediaInfo.mVideoDecoder = strArrSplit[0];
                mediaInfo.mVideoDecoderImpl = "";
            }
        }
        java.lang.String str_getAudioCodecInfo = _getAudioCodecInfo();
        if (!android.text.TextUtils.isEmpty(str_getAudioCodecInfo)) {
            java.lang.String[] strArrSplit2 = str_getAudioCodecInfo.split(",");
            if (strArrSplit2.length >= 2) {
                mediaInfo.mAudioDecoder = strArrSplit2[0];
                mediaInfo.mAudioDecoderImpl = strArrSplit2[1];
            } else if (strArrSplit2.length >= 1) {
                mediaInfo.mAudioDecoder = strArrSplit2[0];
                mediaInfo.mAudioDecoderImpl = "";
            }
        }
        try {
            mediaInfo.mMeta = tv.danmaku.ijk.media.player.IjkMediaMeta.parse(_getMediaMeta());
            return mediaInfo;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return mediaInfo;
        }
    }

    public void setOption(int i, java.lang.String str, java.lang.String str2) {
        _setOption(i, str, str2);
    }

    public void setOption(int i, java.lang.String str, long j) {
        _setOption(i, str, j);
    }

    public android.os.Bundle getMediaMeta() {
        return _getMediaMeta();
    }

    public static java.lang.String getColorFormatName(int i) {
        return _getColorFormatName(i);
    }

    protected void finalize() throws java.lang.Throwable {
        super.finalize();
        native_finalize();
    }

    public void setCacheShare(int i) {
        _setPropertyLong(FFP_PROP_INT64_SHARE_CACHE_DATA, i);
    }

    private static class EventHandler extends android.os.Handler {
        private final java.lang.ref.WeakReference<tv.danmaku.ijk.media.player.IjkMediaPlayer> mWeakPlayer;

        public EventHandler(tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer, android.os.Looper looper) {
            super(looper);
            this.mWeakPlayer = new java.lang.ref.WeakReference<>(ijkMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer = this.mWeakPlayer.get();
            if (ijkMediaPlayer != null) {
                if (ijkMediaPlayer.mNativeMediaPlayer != 0) {
                    int i = message.what;
                    if (i != 0) {
                        if (i == 1) {
                            ijkMediaPlayer.notifyOnPrepared();
                            return;
                        }
                        if (i == 2) {
                            ijkMediaPlayer.stayAwake(false);
                            ijkMediaPlayer.notifyOnCompletion();
                            return;
                        }
                        if (i == 3) {
                            long j = message.arg1;
                            if (j < 0) {
                                j = 0;
                            }
                            long duration = ijkMediaPlayer.getDuration();
                            long j2 = duration > 0 ? (j * 100) / duration : 0L;
                            ijkMediaPlayer.notifyOnBufferingUpdate((int) (j2 < 100 ? j2 : 100L));
                            return;
                        }
                        if (i == 4) {
                            ijkMediaPlayer.notifyOnSeekComplete();
                            return;
                        }
                        if (i == 5) {
                            ijkMediaPlayer.mVideoWidth = message.arg1;
                            ijkMediaPlayer.mVideoHeight = message.arg2;
                            ijkMediaPlayer.notifyOnVideoSizeChanged(ijkMediaPlayer.mVideoWidth, ijkMediaPlayer.mVideoHeight, ijkMediaPlayer.mVideoSarNum, ijkMediaPlayer.mVideoSarDen);
                            return;
                        }
                        if (i == tv.danmaku.ijk.media.player.IjkMediaPlayer.MEDIA_TIMED_TEXT) {
                            if (message.obj == null) {
                                ijkMediaPlayer.notifyOnTimedText(null);
                                return;
                            } else {
                                ijkMediaPlayer.notifyOnTimedText(new tv.danmaku.ijk.media.player.IjkTimedText(new android.graphics.Rect(0, 0, 1, 1), (java.lang.String) message.obj));
                                return;
                            }
                        }
                        if (i == 100) {
                            tv.danmaku.ijk.media.player.pragma.DebugLog.e(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, "Error (" + message.arg1 + "," + message.arg2 + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
                            if (!ijkMediaPlayer.notifyOnError(message.arg1, message.arg2)) {
                                ijkMediaPlayer.notifyOnCompletion();
                            }
                            ijkMediaPlayer.stayAwake(false);
                            return;
                        }
                        if (i == 200) {
                            if (message.arg1 == 3) {
                                tv.danmaku.ijk.media.player.pragma.DebugLog.i(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, "Info: MEDIA_INFO_VIDEO_RENDERING_START\n");
                            }
                            ijkMediaPlayer.notifyOnInfo(message.arg1, message.arg2);
                            return;
                        } else {
                            if (i != 10001) {
                                tv.danmaku.ijk.media.player.pragma.DebugLog.e(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, "Unknown message type " + message.what);
                                return;
                            }
                            ijkMediaPlayer.mVideoSarNum = message.arg1;
                            ijkMediaPlayer.mVideoSarDen = message.arg2;
                            ijkMediaPlayer.notifyOnVideoSizeChanged(ijkMediaPlayer.mVideoWidth, ijkMediaPlayer.mVideoHeight, ijkMediaPlayer.mVideoSarNum, ijkMediaPlayer.mVideoSarDen);
                            return;
                        }
                    }
                    return;
                }
            }
            tv.danmaku.ijk.media.player.pragma.DebugLog.w(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, "IjkMediaPlayer went away with unhandled events");
        }
    }

    private static void postEventFromNative(java.lang.Object obj, int i, int i2, int i3, java.lang.Object obj2) {
        tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || (ijkMediaPlayer = (tv.danmaku.ijk.media.player.IjkMediaPlayer) ((java.lang.ref.WeakReference) obj).get()) == null) {
            return;
        }
        if (i == 200 && i2 == 2) {
            ijkMediaPlayer.start();
        }
        tv.danmaku.ijk.media.player.IjkMediaPlayer.EventHandler eventHandler = ijkMediaPlayer.mEventHandler;
        if (eventHandler != null) {
            ijkMediaPlayer.mEventHandler.sendMessage(eventHandler.obtainMessage(i, i2, i3, obj2));
        }
    }

    public void setOnControlMessageListener(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnControlMessageListener onControlMessageListener) {
        this.mOnControlMessageListener = onControlMessageListener;
    }

    public void setOnNativeInvokeListener(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener onNativeInvokeListener) {
        this.mOnNativeInvokeListener = onNativeInvokeListener;
    }

    private static boolean onNativeInvoke(java.lang.Object obj, int i, android.os.Bundle bundle) {
        tv.danmaku.ijk.media.player.IjkMediaPlayer.OnControlMessageListener onControlMessageListener;
        tv.danmaku.ijk.media.player.pragma.DebugLog.ifmt(TAG, "onNativeInvoke %d", java.lang.Integer.valueOf(i));
        if (obj == null || !(obj instanceof java.lang.ref.WeakReference)) {
            throw new java.lang.IllegalStateException("<null weakThiz>.onNativeInvoke()");
        }
        tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer = (tv.danmaku.ijk.media.player.IjkMediaPlayer) ((java.lang.ref.WeakReference) obj).get();
        if (ijkMediaPlayer == null) {
            throw new java.lang.IllegalStateException("<null weakPlayer>.onNativeInvoke()");
        }
        tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener onNativeInvokeListener = ijkMediaPlayer.mOnNativeInvokeListener;
        if (onNativeInvokeListener != null && onNativeInvokeListener.onNativeInvoke(i, bundle)) {
            return true;
        }
        if (i != 131079 || (onControlMessageListener = ijkMediaPlayer.mOnControlMessageListener) == null) {
            return false;
        }
        int i2 = bundle.getInt(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_SEGMENT_INDEX, -1);
        if (i2 < 0) {
            throw new java.security.InvalidParameterException("onNativeInvoke(invalid segment index)");
        }
        java.lang.String strOnControlResolveSegmentUrl = onControlMessageListener.onControlResolveSegmentUrl(i2);
        if (strOnControlResolveSegmentUrl == null) {
            throw new java.lang.RuntimeException(new java.io.IOException("onNativeInvoke() = <NULL newUrl>"));
        }
        bundle.putString("url", strOnControlResolveSegmentUrl);
        return true;
    }

    public void setOnMediaCodecSelectListener(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnMediaCodecSelectListener onMediaCodecSelectListener) {
        this.mOnMediaCodecSelectListener = onMediaCodecSelectListener;
    }

    @Override // tv.danmaku.ijk.media.player.AbstractMediaPlayer
    public void resetListeners() {
        super.resetListeners();
        this.mOnMediaCodecSelectListener = null;
    }

    private static java.lang.String onSelectCodec(java.lang.Object obj, java.lang.String str, int i, int i2) {
        tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || !(obj instanceof java.lang.ref.WeakReference) || (ijkMediaPlayer = (tv.danmaku.ijk.media.player.IjkMediaPlayer) ((java.lang.ref.WeakReference) obj).get()) == null) {
            return null;
        }
        tv.danmaku.ijk.media.player.IjkMediaPlayer.OnMediaCodecSelectListener onMediaCodecSelectListener = ijkMediaPlayer.mOnMediaCodecSelectListener;
        if (onMediaCodecSelectListener == null) {
            onMediaCodecSelectListener = tv.danmaku.ijk.media.player.IjkMediaPlayer.DefaultMediaCodecSelector.sInstance;
        }
        return onMediaCodecSelectListener.onMediaCodecSelect(ijkMediaPlayer, str, i, i2);
    }

    public static class DefaultMediaCodecSelector implements tv.danmaku.ijk.media.player.IjkMediaPlayer.OnMediaCodecSelectListener {
        public static final tv.danmaku.ijk.media.player.IjkMediaPlayer.DefaultMediaCodecSelector sInstance = new tv.danmaku.ijk.media.player.IjkMediaPlayer.DefaultMediaCodecSelector();

        @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.OnMediaCodecSelectListener
        public java.lang.String onMediaCodecSelect(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, java.lang.String str, int i, int i2) {
            java.lang.String[] supportedTypes;
            java.lang.String str2;
            tv.danmaku.ijk.media.player.IjkMediaCodecInfo ijkMediaCodecInfo;
            java.lang.String str3 = null;
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            int i3 = 1;
            android.util.Log.i(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, java.lang.String.format(java.util.Locale.US, "onSelectCodec: mime=%s, profile=%d, level=%d", str, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)));
            java.util.ArrayList<tv.danmaku.ijk.media.player.IjkMediaCodecInfo> arrayList = new java.util.ArrayList();
            int codecCount = android.media.MediaCodecList.getCodecCount();
            int i4 = 0;
            while (i4 < codecCount) {
                android.media.MediaCodecInfo codecInfoAt = android.media.MediaCodecList.getCodecInfoAt(i4);
                java.lang.String str4 = tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG;
                java.util.Locale locale = java.util.Locale.US;
                java.lang.Object[] objArr = new java.lang.Object[i3];
                objArr[0] = codecInfoAt.getName();
                android.util.Log.d(str4, java.lang.String.format(locale, "  found codec: %s", objArr));
                if (!codecInfoAt.isEncoder() && (supportedTypes = codecInfoAt.getSupportedTypes()) != null) {
                    int length = supportedTypes.length;
                    int i5 = 0;
                    while (i5 < length) {
                        java.lang.String str5 = supportedTypes[i5];
                        if (android.text.TextUtils.isEmpty(str5)) {
                            str2 = str3;
                        } else {
                            java.lang.String str6 = tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG;
                            java.util.Locale locale2 = java.util.Locale.US;
                            java.lang.Object[] objArr2 = new java.lang.Object[i3];
                            objArr2[0] = str5;
                            str2 = str3;
                            android.util.Log.d(str6, java.lang.String.format(locale2, "    mime: %s", objArr2));
                            if (str5.equalsIgnoreCase(str) && (ijkMediaCodecInfo = tv.danmaku.ijk.media.player.IjkMediaCodecInfo.setupCandidate(codecInfoAt, str)) != null) {
                                arrayList.add(ijkMediaCodecInfo);
                                android.util.Log.i(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, java.lang.String.format(java.util.Locale.US, "candidate codec: %s rank=%d", codecInfoAt.getName(), java.lang.Integer.valueOf(ijkMediaCodecInfo.mRank)));
                                ijkMediaCodecInfo.dumpProfileLevels(str);
                            }
                            i5++;
                            str3 = str2;
                            i3 = 1;
                        }
                        i5++;
                        str3 = str2;
                        i3 = 1;
                    }
                }
                i4++;
                str3 = str3;
                i3 = 1;
            }
            java.lang.String str7 = str3;
            if (arrayList.isEmpty()) {
                return str7;
            }
            tv.danmaku.ijk.media.player.IjkMediaCodecInfo ijkMediaCodecInfo2 = (tv.danmaku.ijk.media.player.IjkMediaCodecInfo) arrayList.get(0);
            for (tv.danmaku.ijk.media.player.IjkMediaCodecInfo ijkMediaCodecInfo3 : arrayList) {
                if (ijkMediaCodecInfo3.mRank > ijkMediaCodecInfo2.mRank) {
                    ijkMediaCodecInfo2 = ijkMediaCodecInfo3;
                }
            }
            if (ijkMediaCodecInfo2.mRank < 600) {
                android.util.Log.w(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, java.lang.String.format(java.util.Locale.US, "unaccetable codec: %s", ijkMediaCodecInfo2.mCodecInfo.getName()));
                return str7;
            }
            android.util.Log.i(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, java.lang.String.format(java.util.Locale.US, "selected codec: %s rank=%d", ijkMediaCodecInfo2.mCodecInfo.getName(), java.lang.Integer.valueOf(ijkMediaCodecInfo2.mRank)));
            return ijkMediaCodecInfo2.mCodecInfo.getName();
        }
    }
}
