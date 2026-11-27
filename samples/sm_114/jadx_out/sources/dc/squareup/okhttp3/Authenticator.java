package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface Authenticator {
    public static final dc.squareup.okhttp3.Authenticator NONE = new dc.squareup.okhttp3.Authenticator() { // from class: dc.squareup.okhttp3.Authenticator.1
        @Override // dc.squareup.okhttp3.Authenticator
        public dc.squareup.okhttp3.Request authenticate(dc.squareup.okhttp3.Route route, dc.squareup.okhttp3.Response response) {
            return null;
        }
    };

    dc.squareup.okhttp3.Request authenticate(dc.squareup.okhttp3.Route route, dc.squareup.okhttp3.Response response) throws java.io.IOException;
}
