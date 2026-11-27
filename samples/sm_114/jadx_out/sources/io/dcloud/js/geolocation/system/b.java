package io.dcloud.js.geolocation.system;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class b implements android.location.LocationListener {
    private android.content.Context a;
    private android.location.LocationManager b;
    private io.dcloud.js.geolocation.system.a c;
    private android.location.Location e;
    private boolean f;
    private boolean d = false;
    long g = java.lang.System.currentTimeMillis();

    public b(android.content.Context context, io.dcloud.js.geolocation.system.a aVar) {
        this.f = false;
        this.c = aVar;
        this.a = context;
        this.b = (android.location.LocationManager) context.getSystemService("location");
        this.f = false;
    }

    private void a(boolean z) {
        this.d = z;
        if (z) {
            this.g = java.lang.System.currentTimeMillis();
        }
    }

    public void b() {
        if (this.f) {
            this.b.removeUpdates(this);
        }
        this.f = false;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(android.location.Location location) {
        io.dcloud.common.adapter.util.Logger.d("GpsListener: The location has been updated!");
        a(true);
        this.e = location;
        this.c.a(location, io.dcloud.js.geolocation.system.a.s);
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(java.lang.String str) {
        this.f = false;
        if (this.d) {
            return;
        }
        this.c.a(io.dcloud.js.geolocation.system.a.p, "GPS provider disabled.", io.dcloud.js.geolocation.system.a.s);
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(java.lang.String str) {
        io.dcloud.common.adapter.util.Logger.d("GpsListener: The provider " + str + " is enabled");
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(java.lang.String str, int i, android.os.Bundle bundle) {
        io.dcloud.common.adapter.util.Logger.d("GpsListener: The status of the provider " + str + " has changed");
        if (i == 0) {
            io.dcloud.common.adapter.util.Logger.d("GpsListener: " + str + " is OUT OF SERVICE");
            this.c.a(io.dcloud.js.geolocation.system.a.p, "GPS out of service.", io.dcloud.js.geolocation.system.a.s);
            return;
        }
        if (i == 1) {
            io.dcloud.common.adapter.util.Logger.d("GpsListener: " + str + " is TEMPORARILY_UNAVAILABLE");
            return;
        }
        io.dcloud.common.adapter.util.Logger.d("GpsListener: " + str + " is Available");
    }

    public boolean a() {
        if (java.lang.System.currentTimeMillis() - this.g >= 10000) {
            this.d = false;
        }
        return this.d;
    }

    public void a(int i) {
        if (this.f) {
            return;
        }
        this.f = true;
        this.b.requestLocationUpdates("gps", i, 0.0f, this);
    }
}
