package io.dcloud.common.util.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NetWorkLoop {
    protected java.lang.Thread mSyncThread;
    private final int MAX_EXE_REQUESTDATA = 5;
    private io.dcloud.common.util.net.NetWorkLoop.LoopComparator mComparator = new io.dcloud.common.util.net.NetWorkLoop.LoopComparator();
    protected java.util.LinkedList<io.dcloud.common.util.net.NetWork> mQuestTask = new java.util.LinkedList<>();
    protected java.util.LinkedList<io.dcloud.common.util.net.NetWork> mExeTask = new java.util.LinkedList<>();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class LoopComparator implements java.util.Comparator<io.dcloud.common.util.net.NetWork> {
        LoopComparator() {
        }

        @Override // java.util.Comparator
        public int compare(io.dcloud.common.util.net.NetWork netWork, io.dcloud.common.util.net.NetWork netWork2) {
            return netWork.mPriority - netWork2.mPriority;
        }
    }

    public synchronized void addNetWork(io.dcloud.common.util.net.NetWork netWork) {
        this.mQuestTask.add(netWork);
        java.util.Collections.sort(this.mQuestTask, this.mComparator);
    }

    public void dispose() {
        this.mSyncThread = null;
        try {
            java.util.LinkedList<io.dcloud.common.util.net.NetWork> linkedList = this.mExeTask;
            if (linkedList != null && linkedList.size() > 0) {
                java.util.Iterator<io.dcloud.common.util.net.NetWork> it = this.mExeTask.iterator();
                while (it.hasNext()) {
                    it.next().dispose();
                }
                this.mExeTask.clear();
                this.mExeTask = null;
            }
            java.util.LinkedList<io.dcloud.common.util.net.NetWork> linkedList2 = this.mQuestTask;
            if (linkedList2 == null || linkedList2.size() <= 0) {
                return;
            }
            java.util.Iterator<io.dcloud.common.util.net.NetWork> it2 = this.mQuestTask.iterator();
            while (it2.hasNext()) {
                it2.next().dispose();
            }
            this.mQuestTask.clear();
            this.mQuestTask = null;
        } catch (java.util.ConcurrentModificationException e) {
            e.printStackTrace();
        }
    }

    protected void execSyncTask(io.dcloud.common.util.net.NetWork netWork) {
        netWork.mNetWorkLoop = this;
        netWork.startWork();
    }

    public synchronized void removeNetWork(final io.dcloud.common.util.net.NetWork netWork) {
        try {
            if (this.mQuestTask.contains(netWork)) {
                this.mQuestTask.remove(netWork);
            }
            if (this.mExeTask.contains(netWork)) {
                this.mExeTask.remove(netWork);
            }
            io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.common.util.net.NetWorkLoop.2
                @Override // java.lang.Runnable
                public void run() {
                    netWork.cancelWork();
                }
            });
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void startThreadPool() {
        java.lang.Thread thread = new java.lang.Thread() { // from class: io.dcloud.common.util.net.NetWorkLoop.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        io.dcloud.common.util.net.NetWorkLoop netWorkLoop = io.dcloud.common.util.net.NetWorkLoop.this;
                        if (netWorkLoop.mSyncThread == null) {
                            return;
                        }
                        if (netWorkLoop.mQuestTask.isEmpty()) {
                            java.lang.Thread.sleep(100L);
                        } else {
                            synchronized (io.dcloud.common.util.net.NetWorkLoop.this.mExeTask) {
                                if (io.dcloud.common.util.net.NetWorkLoop.this.mExeTask.size() < 5) {
                                    synchronized (io.dcloud.common.util.net.NetWorkLoop.this.mQuestTask) {
                                        try {
                                            io.dcloud.common.util.net.NetWork netWork = io.dcloud.common.util.net.NetWorkLoop.this.mQuestTask.get(0);
                                            io.dcloud.common.util.net.NetWorkLoop.this.mExeTask.add(netWork);
                                            io.dcloud.common.util.net.NetWorkLoop.this.mQuestTask.remove(netWork);
                                            io.dcloud.common.util.net.NetWorkLoop.this.execSyncTask(netWork);
                                        } catch (java.lang.Throwable th) {
                                            throw th;
                                        }
                                    }
                                }
                            }
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.mSyncThread = thread;
        thread.start();
    }
}
