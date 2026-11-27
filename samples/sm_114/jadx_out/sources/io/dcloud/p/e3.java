package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e3 {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class a {
        public long a;
        public long b;
        public long c;
        public long d;
    }

    public static long a() {
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static long b() {
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static io.dcloud.p.e3.a a(android.content.Context context) {
        io.dcloud.p.e3.a aVar = new io.dcloud.p.e3.a();
        try {
            android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
            android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            aVar.b = memoryInfo.availMem;
            aVar.a = memoryInfo.totalMem;
            aVar.c = a();
            aVar.d = b();
            return aVar;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return aVar;
        }
    }
}
