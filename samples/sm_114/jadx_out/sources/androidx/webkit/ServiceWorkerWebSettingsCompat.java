package androidx.webkit;

/* JADX INFO: loaded from: classes.dex */
public abstract class ServiceWorkerWebSettingsCompat {

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface CacheMode {
    }

    public abstract boolean getAllowContentAccess();

    public abstract boolean getAllowFileAccess();

    public abstract boolean getBlockNetworkLoads();

    public abstract int getCacheMode();

    public abstract int getRequestedWithHeaderMode();

    public abstract void setAllowContentAccess(boolean z);

    public abstract void setAllowFileAccess(boolean z);

    public abstract void setBlockNetworkLoads(boolean z);

    public abstract void setCacheMode(int i);

    public abstract void setRequestedWithHeaderMode(int i);
}
