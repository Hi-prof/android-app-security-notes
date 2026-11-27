package com.bumptech.glide.manager;

/* JADX INFO: loaded from: classes.dex */
final class SingletonConnectivityReceiver {
    private static final java.lang.String TAG = "ConnectivityMonitor";
    private static volatile com.bumptech.glide.manager.SingletonConnectivityReceiver instance;
    private final com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor frameworkConnectivityMonitor;
    private boolean isRegistered;
    final java.util.Set<com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener> listeners = new java.util.HashSet();

    private interface FrameworkConnectivityMonitor {
        boolean register();

        void unregister();
    }

    static com.bumptech.glide.manager.SingletonConnectivityReceiver get(android.content.Context context) {
        if (instance == null) {
            synchronized (com.bumptech.glide.manager.SingletonConnectivityReceiver.class) {
                if (instance == null) {
                    instance = new com.bumptech.glide.manager.SingletonConnectivityReceiver(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    static void reset() {
        instance = null;
    }

    private SingletonConnectivityReceiver(final android.content.Context context) {
        com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor frameworkConnectivityMonitorPreApi24;
        com.bumptech.glide.util.GlideSuppliers.GlideSupplier glideSupplierMemorize = com.bumptech.glide.util.GlideSuppliers.memorize(new com.bumptech.glide.util.GlideSuppliers.GlideSupplier<android.net.ConnectivityManager>() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            public android.net.ConnectivityManager get() {
                return (android.net.ConnectivityManager) context.getSystemService("connectivity");
            }
        });
        com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener connectivityListener = new com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.2
            @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
            public void onConnectivityChanged(boolean z) {
                java.util.ArrayList arrayList;
                com.bumptech.glide.util.Util.assertMainThread();
                synchronized (com.bumptech.glide.manager.SingletonConnectivityReceiver.this) {
                    arrayList = new java.util.ArrayList(com.bumptech.glide.manager.SingletonConnectivityReceiver.this.listeners);
                }
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener) it.next()).onConnectivityChanged(z);
                }
            }
        };
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            frameworkConnectivityMonitorPreApi24 = new com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPostApi24(glideSupplierMemorize, connectivityListener);
        } else {
            frameworkConnectivityMonitorPreApi24 = new com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24(context, glideSupplierMemorize, connectivityListener);
        }
        this.frameworkConnectivityMonitor = frameworkConnectivityMonitorPreApi24;
    }

    synchronized void register(com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.listeners.add(connectivityListener);
        maybeRegisterReceiver();
    }

    synchronized void unregister(com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.listeners.remove(connectivityListener);
        maybeUnregisterReceiver();
    }

    private void maybeRegisterReceiver() {
        if (this.isRegistered || this.listeners.isEmpty()) {
            return;
        }
        this.isRegistered = this.frameworkConnectivityMonitor.register();
    }

    private void maybeUnregisterReceiver() {
        if (this.isRegistered && this.listeners.isEmpty()) {
            this.frameworkConnectivityMonitor.unregister();
            this.isRegistered = false;
        }
    }

    private static final class FrameworkConnectivityMonitorPostApi24 implements com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor {
        private final com.bumptech.glide.util.GlideSuppliers.GlideSupplier<android.net.ConnectivityManager> connectivityManager;
        boolean isConnected;
        final com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener listener;
        private final android.net.ConnectivityManager.NetworkCallback networkCallback = new com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPostApi24.AnonymousClass1();

        /* JADX INFO: renamed from: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPostApi24$1, reason: invalid class name */
        class AnonymousClass1 extends android.net.ConnectivityManager.NetworkCallback {
            AnonymousClass1() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(android.net.Network network) {
                postOnConnectivityChange(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(android.net.Network network) {
                postOnConnectivityChange(false);
            }

            private void postOnConnectivityChange(final boolean z) {
                com.bumptech.glide.util.Util.postOnUiThread(new java.lang.Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPostApi24.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPostApi24.AnonymousClass1.this.onConnectivityChange(z);
                    }
                });
            }

            void onConnectivityChange(boolean z) {
                com.bumptech.glide.util.Util.assertMainThread();
                boolean z2 = com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPostApi24.this.isConnected;
                com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPostApi24.this.isConnected = z;
                if (z2 != z) {
                    com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPostApi24.this.listener.onConnectivityChanged(z);
                }
            }
        }

        FrameworkConnectivityMonitorPostApi24(com.bumptech.glide.util.GlideSuppliers.GlideSupplier<android.net.ConnectivityManager> glideSupplier, com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener connectivityListener) {
            this.connectivityManager = glideSupplier;
            this.listener = connectivityListener;
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public boolean register() {
            this.isConnected = this.connectivityManager.get().getActiveNetwork() != null;
            try {
                this.connectivityManager.get().registerDefaultNetworkCallback(this.networkCallback);
                return true;
            } catch (java.lang.RuntimeException e) {
                if (android.util.Log.isLoggable(com.bumptech.glide.manager.SingletonConnectivityReceiver.TAG, 5)) {
                    android.util.Log.w(com.bumptech.glide.manager.SingletonConnectivityReceiver.TAG, "Failed to register callback", e);
                }
                return false;
            }
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public void unregister() {
            this.connectivityManager.get().unregisterNetworkCallback(this.networkCallback);
        }
    }

    private static final class FrameworkConnectivityMonitorPreApi24 implements com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor {
        static final java.util.concurrent.Executor EXECUTOR = android.os.AsyncTask.SERIAL_EXECUTOR;
        private final com.bumptech.glide.util.GlideSuppliers.GlideSupplier<android.net.ConnectivityManager> connectivityManager;
        final android.content.BroadcastReceiver connectivityReceiver = new android.content.BroadcastReceiver() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(android.content.Context context, android.content.Intent intent) {
                com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this.onConnectivityChange();
            }
        };
        final android.content.Context context;
        volatile boolean isConnected;
        volatile boolean isRegistered;
        final com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener listener;

        FrameworkConnectivityMonitorPreApi24(android.content.Context context, com.bumptech.glide.util.GlideSuppliers.GlideSupplier<android.net.ConnectivityManager> glideSupplier, com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener connectivityListener) {
            this.context = context.getApplicationContext();
            this.connectivityManager = glideSupplier;
            this.listener = connectivityListener;
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public boolean register() {
            EXECUTOR.execute(new java.lang.Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this;
                    frameworkConnectivityMonitorPreApi24.isConnected = frameworkConnectivityMonitorPreApi24.isConnected();
                    try {
                        com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this.context.registerReceiver(com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this.connectivityReceiver, new android.content.IntentFilter(io.dcloud.common.util.net.NetCheckReceiver.netACTION));
                        com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this.isRegistered = true;
                    } catch (java.lang.SecurityException e) {
                        if (android.util.Log.isLoggable(com.bumptech.glide.manager.SingletonConnectivityReceiver.TAG, 5)) {
                            android.util.Log.w(com.bumptech.glide.manager.SingletonConnectivityReceiver.TAG, "Failed to register", e);
                        }
                        com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this.isRegistered = false;
                    }
                }
            });
            return true;
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public void unregister() {
            EXECUTOR.execute(new java.lang.Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.3
                @Override // java.lang.Runnable
                public void run() {
                    if (com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this.isRegistered) {
                        com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this.isRegistered = false;
                        com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this.context.unregisterReceiver(com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this.connectivityReceiver);
                    }
                }
            });
        }

        void onConnectivityChange() {
            EXECUTOR.execute(new java.lang.Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.4
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this.isConnected;
                    com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this;
                    frameworkConnectivityMonitorPreApi24.isConnected = frameworkConnectivityMonitorPreApi24.isConnected();
                    if (z != com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this.isConnected) {
                        if (android.util.Log.isLoggable(com.bumptech.glide.manager.SingletonConnectivityReceiver.TAG, 3)) {
                            android.util.Log.d(com.bumptech.glide.manager.SingletonConnectivityReceiver.TAG, "connectivity changed, isConnected: " + com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this.isConnected);
                        }
                        com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi25 = com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this;
                        frameworkConnectivityMonitorPreApi25.notifyChangeOnUiThread(frameworkConnectivityMonitorPreApi25.isConnected);
                    }
                }
            });
        }

        void notifyChangeOnUiThread(final boolean z) {
            com.bumptech.glide.util.Util.postOnUiThread(new java.lang.Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.5
                @Override // java.lang.Runnable
                public void run() {
                    com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.this.listener.onConnectivityChanged(z);
                }
            });
        }

        boolean isConnected() {
            try {
                android.net.NetworkInfo activeNetworkInfo = this.connectivityManager.get().getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            } catch (java.lang.RuntimeException e) {
                if (android.util.Log.isLoggable(com.bumptech.glide.manager.SingletonConnectivityReceiver.TAG, 5)) {
                    android.util.Log.w(com.bumptech.glide.manager.SingletonConnectivityReceiver.TAG, "Failed to determine connectivity status when connectivity changed", e);
                }
                return true;
            }
        }
    }
}
