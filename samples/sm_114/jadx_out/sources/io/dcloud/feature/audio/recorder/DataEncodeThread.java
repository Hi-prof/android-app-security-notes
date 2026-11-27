package io.dcloud.feature.audio.recorder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DataEncodeThread extends java.lang.Thread implements android.media.AudioRecord.OnRecordPositionUpdateListener {
    public static final int PROCESS_STOP = 1;
    private byte[] mBuffer;
    private java.io.FileOutputStream mFileOutputStream;
    private java.lang.String mFormat;
    private io.dcloud.feature.audio.recorder.DataEncodeThread.StopHandler mHandler;
    private java.util.concurrent.CountDownLatch mHandlerInitLatch = new java.util.concurrent.CountDownLatch(1);
    private java.util.List<io.dcloud.feature.audio.recorder.DataEncodeThread.Task> mTasks = java.util.Collections.synchronizedList(new java.util.ArrayList());

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class StopHandler extends android.os.Handler {
        java.lang.ref.WeakReference<io.dcloud.feature.audio.recorder.DataEncodeThread> encodeThread;

        public StopHandler(io.dcloud.feature.audio.recorder.DataEncodeThread dataEncodeThread) {
            this.encodeThread = new java.lang.ref.WeakReference<>(dataEncodeThread);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what == 1) {
                io.dcloud.feature.audio.recorder.DataEncodeThread dataEncodeThread = this.encodeThread.get();
                while (dataEncodeThread.processData() > 0) {
                }
                removeCallbacksAndMessages(null);
                dataEncodeThread.flushAndRelease();
                getLooper().quit();
            }
            super.handleMessage(message);
        }
    }

    public DataEncodeThread(java.io.File file, int i, java.lang.String str) throws java.io.FileNotFoundException {
        this.mFileOutputStream = new java.io.FileOutputStream(file);
        this.mBuffer = new byte[(int) ((((double) (i * 2)) * 1.25d) + 7200.0d)];
        this.mFormat = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flushAndRelease() {
        int length;
        if (this.mFormat.equalsIgnoreCase("aac")) {
            try {
                byte[] bArrOfferEncoder = io.dcloud.feature.audio.aac.AacEncode.getAacEncode().offerEncoder(this.mBuffer);
                this.mBuffer = bArrOfferEncoder;
                length = bArrOfferEncoder.length;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                length = 0;
            }
        } else {
            length = io.dcloud.feature.audio.mp3.SimpleLame.flush(this.mBuffer);
        }
        if (length > 0) {
            try {
                try {
                    this.mFileOutputStream.write(this.mBuffer, 0, length);
                    java.io.FileOutputStream fileOutputStream = this.mFileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            this.mFileOutputStream = null;
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (java.io.IOException e3) {
                    e3.printStackTrace();
                    java.io.FileOutputStream fileOutputStream2 = this.mFileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            this.mFileOutputStream = null;
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                java.io.FileOutputStream fileOutputStream3 = this.mFileOutputStream;
                if (fileOutputStream3 != null) {
                    try {
                        fileOutputStream3.close();
                        this.mFileOutputStream = null;
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
        if (this.mFormat.equalsIgnoreCase("aac")) {
            io.dcloud.feature.audio.aac.AacEncode.getAacEncode().close();
        } else {
            io.dcloud.feature.audio.mp3.SimpleLame.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int processData() {
        int length;
        if (this.mTasks.size() <= 0) {
            return 0;
        }
        io.dcloud.feature.audio.recorder.DataEncodeThread.Task taskRemove = this.mTasks.remove(0);
        short[] data = taskRemove.getData();
        taskRemove.getRightData();
        int readSize = taskRemove.getReadSize();
        short[] data2 = (taskRemove.getRightData() == null || taskRemove.getRightData().length <= 0) ? taskRemove.getData() : taskRemove.getRightData();
        if (this.mFormat.equalsIgnoreCase("aac")) {
            try {
                byte[] bArrOfferEncoder = io.dcloud.feature.audio.aac.AacEncode.getAacEncode().offerEncoder(taskRemove.getByteData());
                this.mBuffer = bArrOfferEncoder;
                length = bArrOfferEncoder.length;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                length = 0;
            }
        } else {
            length = io.dcloud.feature.audio.mp3.SimpleLame.encode(data, data2, readSize, this.mBuffer);
        }
        if (length > 0) {
            try {
                this.mFileOutputStream.write(this.mBuffer, 0, length);
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
            }
        }
        return readSize;
    }

    public void addTask(short[] sArr, int i) {
        this.mTasks.add(new io.dcloud.feature.audio.recorder.DataEncodeThread.Task(sArr, i));
    }

    public android.os.Handler getHandler() {
        try {
            this.mHandlerInitLatch.await();
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
        return this.mHandler;
    }

    @Override // android.media.AudioRecord.OnRecordPositionUpdateListener
    public void onMarkerReached(android.media.AudioRecord audioRecord) {
    }

    @Override // android.media.AudioRecord.OnRecordPositionUpdateListener
    public void onPeriodicNotification(android.media.AudioRecord audioRecord) {
        processData();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        android.os.Looper.prepare();
        this.mHandler = new io.dcloud.feature.audio.recorder.DataEncodeThread.StopHandler(this);
        this.mHandlerInitLatch.countDown();
        android.os.Looper.loop();
    }

    public void addTask(short[] sArr, short[] sArr2, int i) {
        this.mTasks.add(new io.dcloud.feature.audio.recorder.DataEncodeThread.Task(sArr, sArr2, i));
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class Task {
        private byte[] byteRawData;
        private short[] rawData;
        private int readSize;
        private short[] rightData;

        public Task(short[] sArr, int i) {
            this.rawData = (short[]) sArr.clone();
            this.readSize = i;
        }

        public byte[] getByteData() {
            return this.byteRawData;
        }

        public short[] getData() {
            return this.rawData;
        }

        public int getReadSize() {
            return this.readSize;
        }

        public short[] getRightData() {
            return this.rightData;
        }

        public Task(byte[] bArr, int i) {
            this.byteRawData = (byte[]) bArr.clone();
            this.readSize = i;
        }

        public Task(short[] sArr, short[] sArr2, int i) {
            this.rawData = (short[]) sArr.clone();
            this.rightData = (short[]) sArr2.clone();
            this.readSize = i;
        }
    }

    public void addTask(byte[] bArr, int i) {
        this.mTasks.add(new io.dcloud.feature.audio.recorder.DataEncodeThread.Task(bArr, i));
    }
}
