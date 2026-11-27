package io.dcloud.js.geolocation.system;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static int p = 2;
    public static int q = 0;
    public static int r = 1;
    public static int s = 0;
    public static int t = 1;
    public static int u = 2;
    private java.util.Timer b;
    private io.dcloud.js.geolocation.system.a.b c;
    private java.util.TimerTask d;
    java.lang.String e;
    java.lang.String h;
    io.dcloud.common.DHInterface.IWebview i;
    private android.content.Context j;
    android.location.LocationManager k;
    public int a = Integer.MAX_VALUE;
    java.lang.String l = null;
    java.lang.String m = null;
    io.dcloud.common.DHInterface.IWebview n = null;
    int o = 0;
    io.dcloud.js.geolocation.system.b f = null;
    io.dcloud.js.geolocation.system.c g = null;

    /* JADX INFO: renamed from: io.dcloud.js.geolocation.system.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class C0068a extends java.util.TimerTask {
        C0068a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            io.dcloud.js.geolocation.system.a aVar = io.dcloud.js.geolocation.system.a.this;
            if (aVar.i == null || aVar.h == null || io.dcloud.common.util.PdrUtil.isEmpty(aVar.l)) {
                return;
            }
            io.dcloud.js.geolocation.system.a aVar2 = io.dcloud.js.geolocation.system.a.this;
            io.dcloud.common.util.Deprecated_JSUtil.excCallbackSuccess(aVar2.i, aVar2.h, aVar2.l, true, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b extends java.util.TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            io.dcloud.js.geolocation.system.a aVar = io.dcloud.js.geolocation.system.a.this;
            if (aVar.f == null && aVar.g == null) {
                return;
            }
            aVar.a(io.dcloud.js.geolocation.system.a.p, "get location fail.", io.dcloud.js.geolocation.system.a.u);
        }
    }

    a(android.content.Context context, java.lang.String str) {
        this.e = str;
        this.j = context;
        this.k = (android.location.LocationManager) context.getSystemService("location");
        if (this.b == null) {
            this.b = new java.util.Timer();
        }
    }

    public void a() {
        c(u);
    }

    boolean b(io.dcloud.common.DHInterface.IWebview iWebview, int i, java.lang.String str, int i2) {
        this.i = iWebview;
        this.h = str;
        this.a = i2;
        return a(i, r);
    }

    void c(int i) {
        a(-1);
        if (this.o <= 0) {
            if (i == s) {
                io.dcloud.js.geolocation.system.b bVar = this.f;
                if (bVar != null) {
                    bVar.b();
                    this.f = null;
                }
            } else if (i == t) {
                io.dcloud.js.geolocation.system.c cVar = this.g;
                if (cVar != null) {
                    cVar.a();
                    this.g = null;
                }
            } else {
                io.dcloud.js.geolocation.system.b bVar2 = this.f;
                if (bVar2 != null) {
                    bVar2.b();
                    this.f = null;
                }
                io.dcloud.js.geolocation.system.c cVar2 = this.g;
                if (cVar2 != null) {
                    cVar2.a();
                    this.g = null;
                }
            }
            if (this.b != null) {
                io.dcloud.js.geolocation.system.a.b bVar3 = this.c;
                if (bVar3 != null) {
                    bVar3.cancel();
                    this.c = null;
                }
                java.util.TimerTask timerTask = this.d;
                if (timerTask != null) {
                    timerTask.cancel();
                    this.d = null;
                }
            }
            this.l = null;
            this.o = 0;
        }
        io.dcloud.common.adapter.util.Logger.d("GeoListener", "mUseCount=" + this.o);
    }

    private java.lang.String a(android.location.Location location, java.lang.String str) {
        return io.dcloud.common.util.StringUtil.format("{latitude:%f,longitude:%f,altitude:%f,accuracy:%f,heading:%f,velocity:%f,altitudeAccuracy:%d,timestamp:new Date('%s'),coordsType:'%s'}", java.lang.Double.valueOf(location.getLatitude()), java.lang.Double.valueOf(location.getLongitude()), java.lang.Double.valueOf(location.getAltitude()), java.lang.Float.valueOf(location.getAccuracy()), java.lang.Float.valueOf(location.getBearing()), java.lang.Float.valueOf(location.getSpeed()), 0, java.lang.Long.valueOf(location.getTime()), str);
    }

    private void b(int i) {
        if (this.b != null) {
            io.dcloud.js.geolocation.system.a.b bVar = this.c;
            if (bVar != null) {
                bVar.cancel();
            }
            io.dcloud.js.geolocation.system.a.b bVar2 = new io.dcloud.js.geolocation.system.a.b();
            this.c = bVar2;
            this.b.schedule(bVar2, i);
        }
    }

    void a(android.location.Location location, int i) {
        java.lang.String str;
        io.dcloud.common.DHInterface.IWebview iWebview;
        android.util.Log.i("geoListener", "successType==" + i);
        java.lang.String strA = a(location, "wgs84");
        java.lang.String str2 = this.m;
        if (str2 != null && (iWebview = this.n) != null) {
            io.dcloud.common.util.Deprecated_JSUtil.excCallbackSuccess(iWebview, str2, strA, true, false);
            c(u);
            this.m = null;
            this.n = null;
        }
        io.dcloud.common.DHInterface.IWebview iWebview2 = this.i;
        if (iWebview2 == null || (str = this.h) == null) {
            return;
        }
        if (this.l == null) {
            io.dcloud.common.util.Deprecated_JSUtil.excCallbackSuccess(iWebview2, str, strA, true, true);
        }
        this.l = strA;
    }

    void a(int i, java.lang.String str, int i2) {
        java.lang.String str2;
        io.dcloud.common.DHInterface.IWebview iWebview;
        android.util.Log.i("geoListener", "failType==" + i2);
        c(i2);
        java.lang.String str3 = this.m;
        if (str3 != null && (iWebview = this.n) != null && this.f == null && this.g == null) {
            io.dcloud.common.util.Deprecated_JSUtil.excCallbackError(iWebview, str3, io.dcloud.common.constant.DOMException.toJSON(i, str), true);
        }
        io.dcloud.common.DHInterface.IWebview iWebview2 = this.i;
        if (iWebview2 == null || (str2 = this.h) == null || this.f != null || this.g != null) {
            return;
        }
        this.l = null;
        io.dcloud.common.util.Deprecated_JSUtil.excCallbackError(iWebview2, str2, io.dcloud.common.constant.DOMException.toJSON(i, str), true);
    }

    void a(io.dcloud.common.DHInterface.IWebview iWebview, int i, java.lang.String str, int i2) {
        this.n = iWebview;
        this.m = str;
        this.a = i2;
        a(i, q);
    }

    private void a(int i) {
        this.o += i;
        io.dcloud.common.adapter.util.Logger.d("GeoListener", "mUseCount=" + this.o);
    }

    private boolean a(int i, int i2) {
        io.dcloud.js.geolocation.system.a.b bVar;
        if (this.o == 0) {
            if (this.f == null && this.k.isProviderEnabled("gps")) {
                this.f = new io.dcloud.js.geolocation.system.b(this.j, this);
            }
            if (this.g == null && this.k.isProviderEnabled("network")) {
                this.g = new io.dcloud.js.geolocation.system.c(this.j, this);
            }
            io.dcloud.js.geolocation.system.b bVar2 = this.f;
            if (bVar2 != null) {
                bVar2.a(i);
            }
            io.dcloud.js.geolocation.system.c cVar = this.g;
            if (cVar != null) {
                cVar.a(i);
            }
            if (i2 == q) {
                b(this.a);
            }
        }
        if (i2 == r) {
            if (this.b != null && (bVar = this.c) != null) {
                bVar.cancel();
            }
            io.dcloud.js.geolocation.system.a.C0068a c0068a = new io.dcloud.js.geolocation.system.a.C0068a();
            this.d = c0068a;
            long j = i;
            this.b.schedule(c0068a, j, j);
        }
        a(1);
        if (this.g != null || this.f != null) {
            return true;
        }
        a(p, "get location fail.", u);
        return false;
    }
}
