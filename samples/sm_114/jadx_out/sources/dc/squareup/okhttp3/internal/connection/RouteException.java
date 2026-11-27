package dc.squareup.okhttp3.internal.connection;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class RouteException extends java.lang.RuntimeException {
    private java.io.IOException firstException;
    private java.io.IOException lastException;

    public RouteException(java.io.IOException iOException) {
        super(iOException);
        this.firstException = iOException;
        this.lastException = iOException;
    }

    public void addConnectException(java.io.IOException iOException) {
        dc.squareup.okhttp3.internal.Util.addSuppressedIfPossible(this.firstException, iOException);
        this.lastException = iOException;
    }

    public java.io.IOException getFirstConnectException() {
        return this.firstException;
    }

    public java.io.IOException getLastConnectException() {
        return this.lastException;
    }
}
