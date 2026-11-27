package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AsyncTaskHandler {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface IAsyncTaskListener {
        void onCancel();

        void onExecuteBegin();

        void onExecuteEnd(java.lang.Object obj);

        java.lang.Object onExecuting();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class MyAsyncTask extends android.os.AsyncTask<java.lang.String[], java.lang.Integer, java.lang.Object> {
        io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener mListener;

        MyAsyncTask(io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener iAsyncTaskListener) {
            this.mListener = iAsyncTaskListener;
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(java.lang.Object obj) {
            super.onPostExecute(obj);
            this.mListener.onExecuteEnd(obj);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.mListener.onExecuteBegin();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public java.lang.Object doInBackground(java.lang.String[]... strArr) {
            return this.mListener.onExecuting();
        }
    }

    public static void executeAsyncTask(io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener iAsyncTaskListener, java.lang.String[] strArr) {
        new io.dcloud.common.adapter.util.AsyncTaskHandler.MyAsyncTask(iAsyncTaskListener).execute(strArr);
    }

    public static void executeThreadTask(final io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener iAsyncTaskListener) {
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.util.AsyncTaskHandler.1
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener iAsyncTaskListener2 = iAsyncTaskListener;
                if (iAsyncTaskListener2 != null) {
                    iAsyncTaskListener2.onExecuteBegin();
                    final java.lang.Object objOnExecuting = iAsyncTaskListener.onExecuting();
                    io.dcloud.common.adapter.util.MessageHandler.post(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.util.AsyncTaskHandler.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            iAsyncTaskListener.onExecuteEnd(objOnExecuting);
                        }
                    });
                }
            }
        }, true);
    }
}
