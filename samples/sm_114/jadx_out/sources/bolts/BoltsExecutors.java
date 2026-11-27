package bolts;

/* JADX INFO: loaded from: classes.dex */
final class BoltsExecutors {
    private static final bolts.BoltsExecutors INSTANCE = new bolts.BoltsExecutors();
    private final java.util.concurrent.ExecutorService background;
    private final java.util.concurrent.Executor immediate;
    private final java.util.concurrent.ScheduledExecutorService scheduled;

    private static boolean isAndroidRuntime() {
        java.lang.String property = java.lang.System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(java.util.Locale.US).contains(com.taobao.weex.WXEnvironment.OS);
    }

    private BoltsExecutors() {
        this.background = !isAndroidRuntime() ? java.util.concurrent.Executors.newCachedThreadPool() : bolts.AndroidExecutors.newCachedThreadPool();
        this.scheduled = java.util.concurrent.Executors.newSingleThreadScheduledExecutor();
        this.immediate = new bolts.BoltsExecutors.ImmediateExecutor();
    }

    public static java.util.concurrent.ExecutorService background() {
        return INSTANCE.background;
    }

    static java.util.concurrent.ScheduledExecutorService scheduled() {
        return INSTANCE.scheduled;
    }

    static java.util.concurrent.Executor immediate() {
        return INSTANCE.immediate;
    }

    private static class ImmediateExecutor implements java.util.concurrent.Executor {
        private static final int MAX_DEPTH = 15;
        private java.lang.ThreadLocal<java.lang.Integer> executionDepth;

        private ImmediateExecutor() {
            this.executionDepth = new java.lang.ThreadLocal<>();
        }

        private int incrementDepth() {
            java.lang.Integer num = this.executionDepth.get();
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue() + 1;
            this.executionDepth.set(java.lang.Integer.valueOf(iIntValue));
            return iIntValue;
        }

        private int decrementDepth() {
            java.lang.Integer num = this.executionDepth.get();
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue() - 1;
            if (iIntValue == 0) {
                this.executionDepth.remove();
                return iIntValue;
            }
            this.executionDepth.set(java.lang.Integer.valueOf(iIntValue));
            return iIntValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            try {
                if (incrementDepth() <= 15) {
                    runnable.run();
                } else {
                    bolts.BoltsExecutors.background().execute(runnable);
                }
                decrementDepth();
            } catch (java.lang.Throwable th) {
                decrementDepth();
                throw th;
            }
        }
    }
}
