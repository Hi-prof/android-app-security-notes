package io.dcloud.sdk.base.service;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DownloadService extends androidx.core.app.JobIntentService {
    private dc.squareup.okhttp3.OkHttpClient a = new dc.squareup.okhttp3.OkHttpClient.Builder().build();
    private java.util.List b = new java.util.ArrayList();
    private final java.lang.Object c = new java.lang.Object();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ io.dcloud.sdk.base.entry.AdData b;
        final /* synthetic */ int c;

        a(android.content.Context context, io.dcloud.sdk.base.entry.AdData adData, int i) {
            this.a = context;
            this.b = adData;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.p.f0.a(this.a, this.b.e(), this.b.j(), "", this.c, this.b.c(), this.b.b(), this.b.d(), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class b implements dc.squareup.okhttp3.Callback {
        private io.dcloud.sdk.base.entry.AdData a;
        private boolean b = false;

        public b(io.dcloud.sdk.base.entry.AdData adData) {
            this.a = adData;
        }

        public java.lang.String a() {
            io.dcloud.sdk.base.entry.AdData adData = this.a;
            return adData != null ? adData.k() : "";
        }

        public dc.squareup.okhttp3.Request b() {
            return new dc.squareup.okhttp3.Request.Builder().url(this.a.l()).build();
        }

        public boolean c() {
            return this.b;
        }

        @Override // dc.squareup.okhttp3.Callback
        public void onFailure(dc.squareup.okhttp3.Call call, java.io.IOException iOException) {
            this.b = true;
            io.dcloud.sdk.base.service.DownloadService.a(io.dcloud.sdk.base.service.DownloadService.this.getApplicationContext(), this.a, 32);
        }

        @Override // dc.squareup.okhttp3.Callback
        public void onResponse(dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.Response response) {
            this.b = true;
            java.lang.String str = io.dcloud.sdk.base.service.DownloadService.this.getApplication().getExternalCacheDir() + io.dcloud.p.f.b + java.lang.System.currentTimeMillis() + io.dcloud.p.f.a;
            dc.squareup.okhttp3.ResponseBody responseBodyBody = response.body();
            if (responseBodyBody != null) {
                io.dcloud.p.m1.a(responseBodyBody.bytes(), 0, str);
                io.dcloud.sdk.base.service.DownloadService.this.a(str, this.a);
            }
            io.dcloud.sdk.base.service.DownloadService.a(io.dcloud.sdk.base.service.DownloadService.this.getApplicationContext(), this.a, 30);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class c extends android.content.BroadcastReceiver {
        private io.dcloud.sdk.base.entry.AdData a;
        private android.app.Application b;
        private long c = java.lang.System.currentTimeMillis();

        public c(io.dcloud.sdk.base.entry.AdData adData, android.app.Application application) {
            this.a = adData;
            this.b = application;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if (android.text.TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED")) {
                if (java.lang.System.currentTimeMillis() - this.c < 60000) {
                    io.dcloud.sdk.base.service.DownloadService.a(io.dcloud.sdk.base.service.DownloadService.this.getApplicationContext(), this.a, 31);
                }
                this.b.unregisterReceiver(this);
            }
        }
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // androidx.core.app.JobIntentService
    protected void onHandleWork(android.content.Intent intent) {
        synchronized (this.c) {
            io.dcloud.sdk.base.entry.AdData adData = (io.dcloud.sdk.base.entry.AdData) intent.getParcelableExtra("data");
            for (io.dcloud.sdk.base.service.DownloadService.b bVar : this.b) {
                if (bVar.a().equals(adData.k()) && !bVar.c()) {
                    return;
                }
            }
            io.dcloud.sdk.base.service.DownloadService.b bVar2 = new io.dcloud.sdk.base.service.DownloadService.b(adData);
            this.b.add(bVar2);
            a(getApplicationContext(), adData, 29);
            this.a.newCall(bVar2.b()).enqueue(bVar2);
            a();
        }
    }

    private void a() {
        java.io.File[] fileArrListFiles;
        try {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - 604800000;
            java.io.File file = new java.io.File(getApplication().getExternalCacheDir() + io.dcloud.p.f.b);
            if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (java.io.File file2 : fileArrListFiles) {
                if (file2.lastModified() < jCurrentTimeMillis) {
                    file2.delete();
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, io.dcloud.sdk.base.entry.AdData adData) {
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        getApplication().registerReceiver(new io.dcloud.sdk.base.service.DownloadService.c(adData, getApplication()), intentFilter);
        try {
            java.lang.Class.forName("io.dcloud.feature.pack.FileUtils").getDeclaredMethod("addFileToSystem", android.content.Context.class, java.lang.String.class, java.lang.String.class).invoke(null, getApplication(), getApplication().getPackageName() + ".dc.fileprovider", str);
        } catch (java.lang.Exception unused) {
        }
    }

    public static void a(android.content.Context context, io.dcloud.sdk.base.entry.AdData adData, int i) {
        io.dcloud.p.x4.a().a(new io.dcloud.sdk.base.service.DownloadService.a(context, adData, i));
    }
}
