package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class MessageHandler {
    private static android.os.Handler myHandler = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: io.dcloud.common.adapter.util.MessageHandler.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            try {
                java.lang.Object[] objArr = (java.lang.Object[]) message.obj;
                java.lang.Object obj = objArr[0];
                if (obj instanceof io.dcloud.common.adapter.util.MessageHandler.IMessages) {
                    ((io.dcloud.common.adapter.util.MessageHandler.IMessages) obj).execute(objArr[1]);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                io.dcloud.common.adapter.util.Logger.e("MessageHandler.handleMessage e=" + e);
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface IMessages {
        void execute(java.lang.Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface UncheckedCallable {
        void run(io.dcloud.common.adapter.util.MessageHandler.WaitableRunnable waitableRunnable);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static abstract class WaitableRunnable implements java.lang.Runnable {
        private java.lang.Exception mException;
        private java.lang.String mTimeOutKey = "evalJSSync_time_out";
        private java.lang.Object mValue;

        protected WaitableRunnable() {
        }

        private void join() {
            synchronized (this) {
                try {
                    wait(500L);
                    if (this.mValue == null) {
                        this.mValue = this.mTimeOutKey;
                    }
                } catch (java.lang.InterruptedException unused) {
                }
            }
        }

        public void callBack(java.lang.Object obj) {
            this.mValue = obj;
            synchronized (this) {
                notifyAll();
            }
        }

        public java.lang.Object invoke(android.os.Handler handler) {
            if (!handler.post(this)) {
                throw new java.lang.RuntimeException("Handler.post() returned false");
            }
            join();
            if (this.mException == null) {
                return this.mValue;
            }
            throw new java.lang.RuntimeException(this.mException);
        }

        protected abstract void onRun(io.dcloud.common.adapter.util.MessageHandler.WaitableRunnable waitableRunnable);

        @Override // java.lang.Runnable
        public final void run() {
            try {
                onRun(this);
                this.mException = null;
            } catch (java.lang.Exception e) {
                this.mValue = null;
                this.mException = e;
            }
        }
    }

    public static boolean hasCallbacks(java.lang.Runnable runnable) {
        return myHandler.hasCallbacks(runnable);
    }

    public static void post(java.lang.Runnable runnable) {
        myHandler.post(runnable);
    }

    public static java.lang.Object postAndWait(final io.dcloud.common.adapter.util.MessageHandler.UncheckedCallable uncheckedCallable) {
        return new io.dcloud.common.adapter.util.MessageHandler.WaitableRunnable() { // from class: io.dcloud.common.adapter.util.MessageHandler.2
            @Override // io.dcloud.common.adapter.util.MessageHandler.WaitableRunnable
            protected void onRun(io.dcloud.common.adapter.util.MessageHandler.WaitableRunnable waitableRunnable) {
                uncheckedCallable.run(waitableRunnable);
            }
        }.invoke(myHandler);
    }

    public static void postDelayed(java.lang.Runnable runnable, long j) {
        myHandler.postDelayed(runnable, j);
    }

    public static void removeCallbacks(java.lang.Runnable runnable) {
        myHandler.removeCallbacks(runnable);
    }

    public static void removeCallbacksAndMessages() {
    }

    public static void sendMessage(io.dcloud.common.adapter.util.MessageHandler.IMessages iMessages, java.lang.Object obj) {
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = new java.lang.Object[]{iMessages, obj};
        myHandler.sendMessage(messageObtain);
    }

    public static void sendMessage(io.dcloud.common.adapter.util.MessageHandler.IMessages iMessages, long j, java.lang.Object obj) {
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = new java.lang.Object[]{iMessages, obj};
        myHandler.sendMessageDelayed(messageObtain, j);
    }
}
