package io.dcloud.js.geolocation.system;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class c implements android.location.LocationListener {
    private android.content.Context a;
    private android.location.LocationManager b;
    private io.dcloud.js.geolocation.system.a c;
    private boolean d = false;
    private android.location.Location e;
    private boolean f;

    public c(android.content.Context context, io.dcloud.js.geolocation.system.a aVar) {
        this.f = false;
        this.c = aVar;
        this.a = context;
        this.b = (android.location.LocationManager) context.getSystemService("location");
        this.f = false;
    }

    public void a(int i) {
        if (this.f) {
            return;
        }
        this.f = true;
        this.b.requestLocationUpdates("network", i, 0.0f, this);
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(android.location.Location location) {
        io.dcloud.common.adapter.util.Logger.d("NetworkListener: The location has been updated!");
        this.d = true;
        this.e = location;
        this.c.a(location, io.dcloud.js.geolocation.system.a.t);
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(java.lang.String str) {
        io.dcloud.js.geolocation.system.b bVar;
        this.f = false;
        if (!this.d && ((bVar = this.c.f) == null || !bVar.a())) {
            this.c.a(io.dcloud.js.geolocation.system.a.p, "The provider " + str + " is disabled", io.dcloud.js.geolocation.system.a.t);
        }
        io.dcloud.common.adapter.util.Logger.d("NetworkListener: The provider " + str + " is disabled");
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(java.lang.String str) {
        io.dcloud.common.adapter.util.Logger.d("NetworkListener: The provider " + str + " is enabled");
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(java.lang.String str, int i, android.os.Bundle bundle) {
        io.dcloud.common.adapter.util.Logger.d("NetworkListener: The status of the provider " + str + " has changed");
        if (i == 0) {
            io.dcloud.common.adapter.util.Logger.d("NetworkListener: " + str + " is OUT OF SERVICE");
            return;
        }
        if (i == 1) {
            io.dcloud.common.adapter.util.Logger.d("NetworkListener: " + str + " is TEMPORARILY_UNAVAILABLE");
            return;
        }
        io.dcloud.common.adapter.util.Logger.d("NetworkListener: " + str + " is Available");
    }

    public void a() {
        if (this.f) {
            this.b.removeUpdates(this);
        }
        this.f = false;
    }
}
