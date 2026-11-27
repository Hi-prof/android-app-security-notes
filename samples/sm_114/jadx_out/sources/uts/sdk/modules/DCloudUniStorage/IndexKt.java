package uts.sdk.modules.DCloudUniStorage;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000ú\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u0010\u001a\u0010\u00106\u001a\u0004\u0018\u00010\n2\u0006\u00107\u001a\u00020\n\u001a\u0018\u00108\u001a\u0004\u0018\u00010\n2\u0006\u00109\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0010\u001aq\u0010:\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\n26\u0010;\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\u000f2!\u0010<\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\u0001\u001ai\u0010=\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f26\u0010>\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\u000f2!\u0010?\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\u0001\u001a5\u0010@\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u00102#\u0010A\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001\u001aV\u0010B\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00182#\u0010C\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00012!\u0010D\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020E0\u0001\u001a\u000e\u0010g\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020h\u001a\u0016\u0010i\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\n\u001a\u000e\u0010j\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020k\u001a\u0010\u0010l\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0010\u001a\u000e\u0010m\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020n\u001a\u0006\u0010o\u001a\u00020\u001b\u001a\u000e\u0010p\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020q\u001a\u000e\u0010r\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010\u001a\u0010\u0010s\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010t\u001a\u0006\u0010u\u001a\u00020\u0006\"\u0014\u00101\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b2\u00103\"0\u0010F\u001a!\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`G¢\u0006\b\n\u0000\u001a\u0004\bH\u0010I\"E\u0010J\u001a6\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\u000fj\u0002`K¢\u0006\b\n\u0000\u001a\u0004\bL\u0010M\"0\u0010N\u001a!\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`O¢\u0006\b\n\u0000\u001a\u0004\bP\u0010I\"2\u0010Q\u001a#\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001j\u0002`R¢\u0006\b\n\u0000\u001a\u0004\bS\u0010I\"0\u0010T\u001a!\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`U¢\u0006\b\n\u0000\u001a\u0004\bV\u0010I\"\u001b\u0010W\u001a\f\u0012\u0004\u0012\u00020\u001b0!j\u0002`X¢\u0006\b\n\u0000\u001a\u0004\bY\u0010Z\"0\u0010[\u001a!\u0012\u0013\u0012\u00110'¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\\¢\u0006\b\n\u0000\u001a\u0004\b]\u0010I\"0\u0010^\u001a!\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`_¢\u0006\b\n\u0000\u001a\u0004\b`\u0010I\"2\u0010a\u001a#\u0012\u0015\u0012\u0013\u0018\u00010.¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`b¢\u0006\b\n\u0000\u001a\u0004\bc\u0010I\"\u001b\u0010d\u001a\f\u0012\u0004\u0012\u00020\u00060!j\u0002`e¢\u0006\b\n\u0000\u001a\u0004\bf\u0010Z*@\u0010\u0000\"\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010\u0007\"\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010\t\"\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010\u000b\"\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\u0001*j\u0010\u000e\"2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\u000f22\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\u000f*@\u0010\u0013\"\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010\u0015\"\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010\u0016\"\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010\u0017\"\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\u0001*D\u0010\u0019\"\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00012\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001*@\u0010\u001a\"\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010\u001c\"\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010\u001d\"\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010\u001e\"\u001d\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\u0001*\u0016\u0010 \"\b\u0012\u0004\u0012\u00020\u001b0!2\b\u0012\u0004\u0012\u00020\u001b0!*@\u0010\"\"\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010$\"\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010%\"\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010&\"\u001d\u0012\u0013\u0012\u00110'¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110'¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010(\"\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010)\"\u001d\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010+\"\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*@\u0010,\"\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*D\u0010-\"\u001f\u0012\u0015\u0012\u0013\u0018\u00010.¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00060\u00012\u001f\u0012\u0015\u0012\u0013\u0018\u00010.¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00060\u0001*\u0016\u00100\"\b\u0012\u0004\u0012\u00020\u00060!2\b\u0012\u0004\u0012\u00020\u00060!¨\u0006v"}, d2 = {"SetStorageSuccessCallback", "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniStorage/SetStorageSuccess;", "Lkotlin/ParameterName;", "name", com.facebook.common.util.UriUtil.LOCAL_RESOURCE_SCHEME, "", "SetStorageFailCallback", "Lio/dcloud/uniapp/UniError;", "SetStorageCompleteCallback", "", "SetStorage", "Luts/sdk/modules/DCloudUniStorage/SetStorageOptions;", "options", "SetStorageSync", "Lkotlin/Function2;", "", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "data", "GetStorageSuccessCallback", "Luts/sdk/modules/DCloudUniStorage/GetStorageSuccess;", "GetStorageFailCallback", "GetStorageCompleteCallback", "GetStorage", "Luts/sdk/modules/DCloudUniStorage/GetStorageOptions;", "GetStorageSync", "GetStorageInfoSuccessCallback", "Luts/sdk/modules/DCloudUniStorage/GetStorageInfoSuccess;", "GetStorageInfoFailCallback", "GetStorageInfoCompleteCallback", "GetStorageInfo", "Luts/sdk/modules/DCloudUniStorage/GetStorageInfoOptions;", "GetStorageInfoSync", "Lkotlin/Function0;", "RemoveStorageSuccessCallback", "Luts/sdk/modules/DCloudUniStorage/RemoveStorageSuccess;", "RemoveStorageFailCallback", "RemoveStorageCompleteCallback", "RemoveStorage", "Luts/sdk/modules/DCloudUniStorage/RemoveStorageOptions;", "RemoveStorageSync", "ClearStorageSuccessCallback", "Luts/sdk/modules/DCloudUniStorage/ClearStorageSuccess;", "ClearStorageFailCallback", "ClearStorageCompleteCallback", "ClearStorage", "Luts/sdk/modules/DCloudUniStorage/ClearStorageOptions;", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_OPTION, "ClearStorageSync", "STORAGE_DATA_TYPE", "getSTORAGE_DATA_TYPE", "()Ljava/lang/String;", "filterNativeType", "src", "parseValue", "value", "praseGetStorage", "type", "uni_setStorageSync", "saveItemHandler", "removeItemHandler", "uni_setStorageAsync", "saveItemAsyncHandler", "removeItemAsyncHandler", "uni_getStorageSync", "getItemHandler", "uni_getStorageAsync", "getItemAsyncHandler", "includesKey", "", "setStorage", "Luts/sdk/modules/DCloudUniStorage/SetStorage;", "getSetStorage", "()Lkotlin/jvm/functions/Function1;", "setStorageSync", "Luts/sdk/modules/DCloudUniStorage/SetStorageSync;", "getSetStorageSync", "()Lkotlin/jvm/functions/Function2;", "getStorage", "Luts/sdk/modules/DCloudUniStorage/GetStorage;", "getGetStorage", "getStorageSync", "Luts/sdk/modules/DCloudUniStorage/GetStorageSync;", "getGetStorageSync", "getStorageInfo", "Luts/sdk/modules/DCloudUniStorage/GetStorageInfo;", "getGetStorageInfo", "getStorageInfoSync", "Luts/sdk/modules/DCloudUniStorage/GetStorageInfoSync;", "getGetStorageInfoSync", "()Lkotlin/jvm/functions/Function0;", "removeStorage", "Luts/sdk/modules/DCloudUniStorage/RemoveStorage;", "getRemoveStorage", "removeStorageSync", "Luts/sdk/modules/DCloudUniStorage/RemoveStorageSync;", "getRemoveStorageSync", "clearStorage", "Luts/sdk/modules/DCloudUniStorage/ClearStorage;", "getClearStorage", "clearStorageSync", "Luts/sdk/modules/DCloudUniStorage/ClearStorageSync;", "getClearStorageSync", "setStorageByJs", "Luts/sdk/modules/DCloudUniStorage/SetStorageOptionsJSONObject;", "setStorageSyncByJs", "getStorageByJs", "Luts/sdk/modules/DCloudUniStorage/GetStorageOptionsJSONObject;", "getStorageSyncByJs", "getStorageInfoByJs", "Luts/sdk/modules/DCloudUniStorage/GetStorageInfoOptionsJSONObject;", "getStorageInfoSyncByJs", "removeStorageByJs", "Luts/sdk/modules/DCloudUniStorage/RemoveStorageOptionsJSONObject;", "removeStorageSyncByJs", "clearStorageByJs", "Luts/sdk/modules/DCloudUniStorage/ClearStorageOptionsJSONObject;", "clearStorageSyncByJs", "uni-storage_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IndexKt {
    private static final java.lang.String STORAGE_DATA_TYPE = "__TYPE";
    private static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.SetStorageOptions, kotlin.Unit> setStorage = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda35
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public final java.lang.Object invoke2(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniStorage.IndexKt.setStorage$lambda$3((uts.sdk.modules.DCloudUniStorage.SetStorageOptions) obj);
        }
    };
    private static final kotlin.jvm.functions.Function2<java.lang.String, java.lang.Object, kotlin.Unit> setStorageSync = new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda36
        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
            return uts.sdk.modules.DCloudUniStorage.IndexKt.setStorageSync$lambda$6((java.lang.String) obj, obj2);
        }
    };
    private static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.GetStorageOptions, kotlin.Unit> getStorage = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda37
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public final java.lang.Object invoke2(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniStorage.IndexKt.getStorage$lambda$12((uts.sdk.modules.DCloudUniStorage.GetStorageOptions) obj);
        }
    };
    private static final kotlin.jvm.functions.Function1<java.lang.String, java.lang.Object> getStorageSync = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public final java.lang.Object invoke2(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniStorage.IndexKt.getStorageSync$lambda$14((java.lang.String) obj);
        }
    };
    private static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.GetStorageInfoOptions, kotlin.Unit> getStorageInfo = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public final java.lang.Object invoke2(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniStorage.IndexKt.getStorageInfo$lambda$17((uts.sdk.modules.DCloudUniStorage.GetStorageInfoOptions) obj);
        }
    };
    private static final kotlin.jvm.functions.Function0<uts.sdk.modules.DCloudUniStorage.GetStorageInfoSuccess> getStorageInfoSync = new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final java.lang.Object invoke() {
            return uts.sdk.modules.DCloudUniStorage.IndexKt.getStorageInfoSync$lambda$19();
        }
    };
    private static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.RemoveStorageOptions, kotlin.Unit> removeStorage = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public final java.lang.Object invoke2(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniStorage.IndexKt.removeStorage$lambda$21((uts.sdk.modules.DCloudUniStorage.RemoveStorageOptions) obj);
        }
    };
    private static final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> removeStorageSync = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public final java.lang.Object invoke2(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniStorage.IndexKt.removeStorageSync$lambda$22((java.lang.String) obj);
        }
    };
    private static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.ClearStorageOptions, kotlin.Unit> clearStorage = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public final java.lang.Object invoke2(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniStorage.IndexKt.clearStorage$lambda$24((uts.sdk.modules.DCloudUniStorage.ClearStorageOptions) obj);
        }
    };
    private static final kotlin.jvm.functions.Function0<kotlin.Unit> clearStorageSync = new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function0
        public final java.lang.Object invoke() {
            return uts.sdk.modules.DCloudUniStorage.IndexKt.clearStorageSync$lambda$25();
        }
    };

    public static final java.lang.String getSTORAGE_DATA_TYPE() {
        return STORAGE_DATA_TYPE;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0067 A[ORIG_RETURN, RETURN] */
    public static final java.lang.String filterNativeType(java.lang.String src) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(src, "src");
        switch (src) {
            case "UShort":
            case "Int":
            case "Byte":
            case "Long":
            case "UInt":
            case "Float":
            case "Short":
            case "UByte":
            case "ULong":
            case "Double":
                return "number";
            default:
                return src;
        }
    }

    public static final java.lang.Object parseValue(java.lang.Object value) throws java.lang.IllegalAccessException {
        boolean z;
        io.dcloud.uts.Map<java.lang.String, java.lang.Object> map;
        java.lang.String str;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        io.dcloud.uts.UTSArray uTSArray_uA = io.dcloud.uts.UTSArrayKt._uA("object", "string", "number", "boolean", com.taobao.weex.common.Constants.Name.UNDEFINED);
        if (kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSAndroid.INSTANCE.typeof(value), "string")) {
            value = io.dcloud.uts.JSON.parse((java.lang.String) value);
        }
        if (value == null) {
            return null;
        }
        java.lang.String strTypeof = io.dcloud.uts.UTSAndroid.INSTANCE.typeof(value);
        if (uTSArray_uA.indexOf(strTypeof) >= 0 && (((z = value instanceof io.dcloud.uts.UTSJSONObject)) || (value instanceof io.dcloud.uts.Map))) {
            if (z) {
                map = ((io.dcloud.uts.UTSJSONObject) value).toMap();
            } else {
                map = (io.dcloud.uts.Map) value;
            }
            if (map.size() == 2 && map.has("data") && map.has("type")) {
                if (map.get("type") == null) {
                    str = "";
                } else {
                    java.lang.Object obj = map.get("type");
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    str = (java.lang.String) obj;
                }
                if (kotlin.jvm.internal.Intrinsics.areEqual(filterNativeType(io.dcloud.uts.UTSAndroid.INSTANCE.typeof(map.get("data"))), str) && !kotlin.jvm.internal.Intrinsics.areEqual(str, "string")) {
                    return map.get("data");
                }
                if (kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSAndroid.INSTANCE.typeof(map.get("data")), str) && kotlin.jvm.internal.Intrinsics.areEqual(str, "string")) {
                    io.dcloud.uts.UTSRegExp uTSRegExp = new io.dcloud.uts.UTSRegExp("^\\d{4}-\\d{2}-\\d{2}T\\d{2}\\:\\d{2}\\:\\d{2}\\.\\d{3}Z$", "");
                    if (kotlin.jvm.internal.Intrinsics.areEqual(strTypeof, "object")) {
                        java.lang.Object obj2 = map.get("data");
                        kotlin.jvm.internal.Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                        if (uTSRegExp.test((java.lang.String) obj2)) {
                            java.lang.Object obj3 = map.get("data");
                            kotlin.jvm.internal.Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                            return new io.dcloud.uts.Date((java.lang.String) obj3);
                        }
                    }
                    return map.get("data");
                }
            } else if (map.size() >= 1) {
                return "";
            }
        }
        return null;
    }

    public static final java.lang.Object praseGetStorage(java.lang.String type, java.lang.String value) throws java.lang.IllegalAccessException {
        java.lang.Object obj;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        if ((!kotlin.jvm.internal.Intrinsics.areEqual(type, "string") || (kotlin.jvm.internal.Intrinsics.areEqual(type, "string") && kotlin.jvm.internal.Intrinsics.areEqual(value, "{\"type\":\"undefined\"}"))) && (obj = io.dcloud.uts.JSON.parse(value)) != null) {
            java.lang.Object value2 = parseValue(obj);
            if (value2 != null) {
                return value2;
            }
            if (!kotlin.jvm.internal.Intrinsics.areEqual(type, "")) {
                if (kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSAndroid.INSTANCE.typeof(obj), "string")) {
                    java.lang.Object obj2 = io.dcloud.uts.JSON.parse((java.lang.String) obj);
                    java.lang.String strTypeof = io.dcloud.uts.UTSAndroid.INSTANCE.typeof(obj2);
                    if (kotlin.jvm.internal.Intrinsics.areEqual(strTypeof, "number") && kotlin.jvm.internal.Intrinsics.areEqual(type, "date")) {
                        kotlin.jvm.internal.Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Number");
                        return new io.dcloud.uts.Date((java.lang.Number) obj2);
                    }
                    if (io.dcloud.uts.UTSArrayKt._uA("null", "array").indexOf(type) >= 0) {
                        type = "object";
                    }
                    if (kotlin.jvm.internal.Intrinsics.areEqual(strTypeof, type)) {
                        return obj2;
                    }
                }
                return obj;
            }
        }
        return value;
    }

    public static final void uni_setStorageSync(java.lang.String key, java.lang.Object data, kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> saveItemHandler, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> removeItemHandler) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(saveItemHandler, "saveItemHandler");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(removeItemHandler, "removeItemHandler");
        java.lang.String strFilterNativeType = filterNativeType(io.dcloud.uts.UTSAndroid.INSTANCE.typeof(data));
        java.lang.String strStringify = kotlin.jvm.internal.Intrinsics.areEqual(strFilterNativeType, "string") ? (java.lang.String) data : io.dcloud.uts.JSON.stringify(io.dcloud.uts.UTSJSONObjectKt._uO(kotlin.TuplesKt.to("type", strFilterNativeType), kotlin.TuplesKt.to("data", data)));
        if (kotlin.jvm.internal.Intrinsics.areEqual(strFilterNativeType, "string") && parseValue(data) != null) {
            saveItemHandler.invoke(key + STORAGE_DATA_TYPE, strFilterNativeType);
        } else {
            removeItemHandler.invoke2(key + STORAGE_DATA_TYPE);
        }
        if (strStringify == null) {
            strStringify = "";
        }
        saveItemHandler.invoke(key, strStringify);
    }

    public static final void uni_setStorageAsync(uts.sdk.modules.DCloudUniStorage.SetStorageOptions options, kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> saveItemAsyncHandler, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> removeItemAsyncHandler) {
        java.lang.String strStringify;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(saveItemAsyncHandler, "saveItemAsyncHandler");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(removeItemAsyncHandler, "removeItemAsyncHandler");
        java.lang.String strFilterNativeType = filterNativeType(io.dcloud.uts.UTSAndroid.INSTANCE.typeof(options.getData()));
        if (kotlin.jvm.internal.Intrinsics.areEqual(strFilterNativeType, "string")) {
            java.lang.Object data = options.getData();
            kotlin.jvm.internal.Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.String");
            strStringify = (java.lang.String) data;
        } else {
            strStringify = io.dcloud.uts.JSON.stringify(io.dcloud.uts.UTSJSONObjectKt._uO(kotlin.TuplesKt.to("type", strFilterNativeType), kotlin.TuplesKt.to("data", options.getData())));
        }
        if (strStringify == null) {
            io.dcloud.uniapp.UniError uniError = new io.dcloud.uniapp.UniError("uni-storage", (java.lang.Number) (-1), "data can not be stringify");
            kotlin.jvm.functions.Function1<io.dcloud.uniapp.UniError, kotlin.Unit> fail = options.getFail();
            if (fail != null) {
                fail.invoke2(uniError);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = options.getComplete();
            if (complete != null) {
                complete.invoke2(uniError);
                return;
            }
            return;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(strFilterNativeType, "string") && parseValue(options.getData()) != null) {
            saveItemAsyncHandler.invoke(options.getKey() + STORAGE_DATA_TYPE, strFilterNativeType);
        } else {
            removeItemAsyncHandler.invoke2(options.getKey() + STORAGE_DATA_TYPE);
        }
        saveItemAsyncHandler.invoke(options.getKey(), strStringify);
        uts.sdk.modules.DCloudUniStorage.SetStorageSuccess setStorageSuccess = new uts.sdk.modules.DCloudUniStorage.SetStorageSuccess();
        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.SetStorageSuccess, kotlin.Unit> success = options.getSuccess();
        if (success != null) {
            success.invoke2(setStorageSuccess);
        }
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete2 = options.getComplete();
        if (complete2 != null) {
            complete2.invoke2(setStorageSuccess);
        }
    }

    public static final java.lang.Object uni_getStorageSync(java.lang.String key, kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.String> getItemHandler) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(getItemHandler, "getItemHandler");
        java.lang.String strInvoke2 = getItemHandler.invoke2(key);
        java.lang.String strInvoke3 = getItemHandler.invoke2(key + STORAGE_DATA_TYPE);
        if (strInvoke3 == null) {
            strInvoke3 = "";
        }
        java.lang.String lowerCase = io.dcloud.uts.StringKt.toLowerCase(strInvoke3);
        if (!kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSAndroid.INSTANCE.typeof(strInvoke2), "string")) {
            return "";
        }
        if (strInvoke2 == null) {
            strInvoke2 = "";
        }
        return praseGetStorage(lowerCase, strInvoke2);
    }

    public static final void uni_getStorageAsync(uts.sdk.modules.DCloudUniStorage.GetStorageOptions options, kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.String> getItemAsyncHandler, kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.Boolean> includesKey) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(getItemAsyncHandler, "getItemAsyncHandler");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(includesKey, "includesKey");
        if (!includesKey.invoke2(options.getKey()).booleanValue()) {
            io.dcloud.uniapp.UniError uniError = new io.dcloud.uniapp.UniError("uni-storage", (java.lang.Number) (-2), "getStorage:fail data not found");
            kotlin.jvm.functions.Function1<io.dcloud.uniapp.UniError, kotlin.Unit> fail = options.getFail();
            if (fail != null) {
                fail.invoke2(uniError);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = options.getComplete();
            if (complete != null) {
                complete.invoke2(uniError);
                return;
            }
            return;
        }
        java.lang.String strInvoke2 = getItemAsyncHandler.invoke2(options.getKey());
        if (strInvoke2 == null) {
            strInvoke2 = "";
        }
        java.lang.String strInvoke3 = getItemAsyncHandler.invoke2(options.getKey() + STORAGE_DATA_TYPE);
        if (strInvoke3 == null) {
            strInvoke3 = "";
        }
        java.lang.String lowerCase = io.dcloud.uts.StringKt.toLowerCase(strInvoke3);
        if (!kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSAndroid.INSTANCE.typeof(strInvoke2), "string")) {
            uts.sdk.modules.DCloudUniStorage.GetStorageSuccess getStorageSuccess = new uts.sdk.modules.DCloudUniStorage.GetStorageSuccess("");
            kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.GetStorageSuccess, kotlin.Unit> success = options.getSuccess();
            if (success != null) {
                success.invoke2(getStorageSuccess);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete2 = options.getComplete();
            if (complete2 != null) {
                complete2.invoke2(getStorageSuccess);
                return;
            }
            return;
        }
        uts.sdk.modules.DCloudUniStorage.GetStorageSuccess getStorageSuccess2 = new uts.sdk.modules.DCloudUniStorage.GetStorageSuccess(praseGetStorage(lowerCase, strInvoke2));
        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.GetStorageSuccess, kotlin.Unit> success2 = options.getSuccess();
        if (success2 != null) {
            success2.invoke2(getStorageSuccess2);
        }
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete3 = options.getComplete();
        if (complete3 != null) {
            complete3.invoke2(getStorageSuccess2);
        }
    }

    public static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.SetStorageOptions, kotlin.Unit> getSetStorage() {
        return setStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit setStorage$lambda$3(final uts.sdk.modules.DCloudUniStorage.SetStorageOptions setStorageOptions) {
        io.dcloud.uts.UTSTimerKt.setTimeout(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.setStorage$lambda$3$lambda$2(setStorageOptions);
            }
        }, (java.lang.Number) 0);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, io.dcloud.common.util.db.DCStorage] */
    public static final kotlin.Unit setStorage$lambda$3$lambda$2(uts.sdk.modules.DCloudUniStorage.SetStorageOptions setStorageOptions) {
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        objectRef.element = io.dcloud.common.util.db.DCStorage.getDCStorage(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext());
        if (objectRef.element == 0) {
            io.dcloud.uniapp.UniError uniError = new io.dcloud.uniapp.UniError("uni-setStorage", (java.lang.Number) (-1), "storage not found.");
            kotlin.jvm.functions.Function1<io.dcloud.uniapp.UniError, kotlin.Unit> fail = setStorageOptions.getFail();
            if (fail != null) {
                fail.invoke2(uniError);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = setStorageOptions.getComplete();
            if (complete != null) {
                complete.invoke2(uniError);
            }
            return kotlin.Unit.INSTANCE;
        }
        uni_setStorageAsync(setStorageOptions, new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function2
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.setStorage$lambda$3$lambda$2$lambda$0(objectRef, (java.lang.String) obj, (java.lang.String) obj2);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.setStorage$lambda$3$lambda$2$lambda$1(objectRef, (java.lang.String) obj);
            }
        });
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit setStorage$lambda$3$lambda$2$lambda$0(kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.common.util.db.DCStorage> objectRef, java.lang.String str, java.lang.String str2) {
        objectRef.element.performSetItem(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext(), io.dcloud.uts.UTSAndroid.INSTANCE.getAppId(), str, str2);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit setStorage$lambda$3$lambda$2$lambda$1(kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.common.util.db.DCStorage> objectRef, java.lang.String str) {
        objectRef.element.performRemoveItem(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext(), io.dcloud.uts.UTSAndroid.INSTANCE.getAppId(), str);
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function2<java.lang.String, java.lang.Object, kotlin.Unit> getSetStorageSync() {
        return setStorageSync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, io.dcloud.common.util.db.DCStorage] */
    public static final kotlin.Unit setStorageSync$lambda$6(java.lang.String str, java.lang.Object obj) {
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        objectRef.element = io.dcloud.common.util.db.DCStorage.getDCStorage(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext());
        if (objectRef.element == 0) {
            return kotlin.Unit.INSTANCE;
        }
        uni_setStorageSync(str, obj, new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function2
            public final java.lang.Object invoke(java.lang.Object obj2, java.lang.Object obj3) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.setStorageSync$lambda$6$lambda$4(objectRef, (java.lang.String) obj2, (java.lang.String) obj3);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj2) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.setStorageSync$lambda$6$lambda$5(objectRef, (java.lang.String) obj2);
            }
        });
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit setStorageSync$lambda$6$lambda$4(kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.common.util.db.DCStorage> objectRef, java.lang.String str, java.lang.String str2) {
        objectRef.element.performSetItem(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext(), io.dcloud.uts.UTSAndroid.INSTANCE.getAppId(), str, str2);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit setStorageSync$lambda$6$lambda$5(kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.common.util.db.DCStorage> objectRef, java.lang.String str) {
        objectRef.element.performRemoveItem(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext(), io.dcloud.uts.UTSAndroid.INSTANCE.getAppId(), str);
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.GetStorageOptions, kotlin.Unit> getGetStorage() {
        return getStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, io.dcloud.common.util.db.DCStorage] */
    public static final kotlin.Unit getStorage$lambda$12(final uts.sdk.modules.DCloudUniStorage.GetStorageOptions getStorageOptions) {
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        objectRef.element = io.dcloud.common.util.db.DCStorage.getDCStorage(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext());
        if (objectRef.element == 0) {
            io.dcloud.uniapp.UniError uniError = new io.dcloud.uniapp.UniError("uni-setStorage", (java.lang.Number) (-1), "storage not found.");
            kotlin.jvm.functions.Function1<io.dcloud.uniapp.UniError, kotlin.Unit> fail = getStorageOptions.getFail();
            if (fail != null) {
                fail.invoke2(uniError);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = getStorageOptions.getComplete();
            if (complete != null) {
                complete.invoke2(uniError);
            }
            return kotlin.Unit.INSTANCE;
        }
        io.dcloud.uts.UTSTimerKt.setTimeout(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.getStorage$lambda$12$lambda$11(getStorageOptions, objectRef);
            }
        }, (java.lang.Number) 0);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit getStorage$lambda$12$lambda$11(uts.sdk.modules.DCloudUniStorage.GetStorageOptions getStorageOptions, final kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.common.util.db.DCStorage> objectRef) {
        uni_getStorageAsync(getStorageOptions, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.getStorage$lambda$12$lambda$11$lambda$7(objectRef, (java.lang.String) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(uts.sdk.modules.DCloudUniStorage.IndexKt.getStorage$lambda$12$lambda$11$lambda$10(objectRef, (java.lang.String) obj));
            }
        });
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String getStorage$lambda$12$lambda$11$lambda$7(kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.common.util.db.DCStorage> objectRef, java.lang.String str) {
        io.dcloud.common.util.db.DCStorage.StorageInfo storageInfoPerformGetItem = objectRef.element.performGetItem(io.dcloud.uts.UTSAndroid.INSTANCE.getAppId(), str);
        if (storageInfoPerformGetItem == null || storageInfoPerformGetItem.code != 1 || storageInfoPerformGetItem.v == null) {
            return null;
        }
        java.lang.Object obj = storageInfoPerformGetItem.v;
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        return (java.lang.String) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getStorage$lambda$12$lambda$11$lambda$10$lambda$9(java.lang.String str, java.lang.String str2) {
        if (!kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSAndroid.INSTANCE.typeof(str2), "string")) {
            return false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(str2, "null cannot be cast to non-null type kotlin.String");
        return kotlin.jvm.internal.Intrinsics.areEqual(str2, str);
    }

    public static final kotlin.jvm.functions.Function1<java.lang.String, java.lang.Object> getGetStorageSync() {
        return getStorageSync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object getStorageSync$lambda$14(java.lang.String str) {
        return uni_getStorageSync(str, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.getStorageSync$lambda$14$lambda$13((java.lang.String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String getStorageSync$lambda$14$lambda$13(java.lang.String str) {
        io.dcloud.common.util.db.DCStorage.StorageInfo storageInfoPerformGetItem;
        io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext());
        if (dCStorage == null || (storageInfoPerformGetItem = dCStorage.performGetItem(io.dcloud.uts.UTSAndroid.INSTANCE.getAppId(), str)) == null || storageInfoPerformGetItem.code != 1 || storageInfoPerformGetItem.v == null) {
            return "";
        }
        java.lang.Object obj = storageInfoPerformGetItem.v;
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        return (java.lang.String) obj;
    }

    public static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.GetStorageInfoOptions, kotlin.Unit> getGetStorageInfo() {
        return getStorageInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit getStorageInfo$lambda$17(final uts.sdk.modules.DCloudUniStorage.GetStorageInfoOptions getStorageInfoOptions) {
        io.dcloud.uts.UTSTimerKt.setTimeout(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.getStorageInfo$lambda$17$lambda$16(getStorageInfoOptions);
            }
        }, (java.lang.Number) 0);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit getStorageInfo$lambda$17$lambda$16(uts.sdk.modules.DCloudUniStorage.GetStorageInfoOptions getStorageInfoOptions) {
        io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext());
        if (dCStorage == null) {
            io.dcloud.uniapp.UniError uniError = new io.dcloud.uniapp.UniError("uni-setStorage", (java.lang.Number) (-1), "storage not found.");
            kotlin.jvm.functions.Function1<io.dcloud.uniapp.UniError, kotlin.Unit> fail = getStorageInfoOptions.getFail();
            if (fail != null) {
                fail.invoke2(uniError);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = getStorageInfoOptions.getComplete();
            if (complete != null) {
                complete.invoke2(uniError);
            }
        }
        uts.sdk.modules.DCloudUniStorage.GetStorageInfoSuccess getStorageInfoSuccess = new uts.sdk.modules.DCloudUniStorage.GetStorageInfoSuccess(new io.dcloud.uts.UTSArray(), (java.lang.Number) 0, (java.lang.Number) 10240);
        io.dcloud.common.util.db.DCStorage.StorageInfo storageInfoPerformGetAllKeys = dCStorage.performGetAllKeys(io.dcloud.uts.UTSAndroid.INSTANCE.getAppId());
        if (storageInfoPerformGetAllKeys.code == 1 && storageInfoPerformGetAllKeys.v != null) {
            io.dcloud.uts.UTSArray<java.lang.String> uTSArray = new io.dcloud.uts.UTSArray<>();
            java.lang.Object obj = storageInfoPerformGetAllKeys.v;
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.List<kotlin.String>");
            java.util.Iterator it = ((java.util.List) obj).iterator();
            while (it.hasNext()) {
                uTSArray.push((java.lang.String) it.next());
            }
            try {
                getStorageInfoSuccess.setKeys(uTSArray);
                double d = 1024;
                getStorageInfoSuccess.setLimitSize(java.lang.Double.valueOf(dCStorage.getDBMaxLength(io.dcloud.uts.UTSAndroid.INSTANCE.getAppId()).longValue() / d));
                getStorageInfoSuccess.setCurrentSize(java.lang.Double.valueOf(dCStorage.getDBCurrentLength(io.dcloud.uts.UTSAndroid.INSTANCE.getAppId()).longValue() / d));
            } catch (java.lang.Throwable unused) {
            }
            kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.GetStorageInfoSuccess, kotlin.Unit> success = getStorageInfoOptions.getSuccess();
            if (success != null) {
                success.invoke2(getStorageInfoSuccess);
            }
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function0<uts.sdk.modules.DCloudUniStorage.GetStorageInfoSuccess> getGetStorageInfoSync() {
        return getStorageInfoSync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final uts.sdk.modules.DCloudUniStorage.GetStorageInfoSuccess getStorageInfoSync$lambda$19() {
        uts.sdk.modules.DCloudUniStorage.GetStorageInfoSuccess getStorageInfoSuccess = new uts.sdk.modules.DCloudUniStorage.GetStorageInfoSuccess(new io.dcloud.uts.UTSArray(), (java.lang.Number) 0, (java.lang.Number) 10240);
        io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext());
        if (dCStorage != null) {
            io.dcloud.common.util.db.DCStorage.StorageInfo storageInfoPerformGetAllKeys = dCStorage.performGetAllKeys(io.dcloud.uts.UTSAndroid.INSTANCE.getAppId());
            if (storageInfoPerformGetAllKeys.code == 1 && storageInfoPerformGetAllKeys.v != null) {
                io.dcloud.uts.UTSArray<java.lang.String> uTSArray = new io.dcloud.uts.UTSArray<>();
                java.lang.Object obj = storageInfoPerformGetAllKeys.v;
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.List<kotlin.String>");
                java.util.Iterator it = ((java.util.List) obj).iterator();
                while (it.hasNext()) {
                    uTSArray.push((java.lang.String) it.next());
                }
                getStorageInfoSuccess.setKeys(uTSArray);
            }
            try {
                double d = 1024;
                getStorageInfoSuccess.setLimitSize(java.lang.Double.valueOf(dCStorage.getDBMaxLength(io.dcloud.uts.UTSAndroid.INSTANCE.getAppId()).longValue() / d));
                getStorageInfoSuccess.setCurrentSize(java.lang.Double.valueOf(dCStorage.getDBCurrentLength(io.dcloud.uts.UTSAndroid.INSTANCE.getAppId()).longValue() / d));
            } catch (java.lang.Throwable unused) {
            }
        }
        return getStorageInfoSuccess;
    }

    public static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.RemoveStorageOptions, kotlin.Unit> getRemoveStorage() {
        return removeStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit removeStorage$lambda$21(final uts.sdk.modules.DCloudUniStorage.RemoveStorageOptions removeStorageOptions) {
        io.dcloud.uts.UTSTimerKt.setTimeout(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.removeStorage$lambda$21$lambda$20(removeStorageOptions);
            }
        }, (java.lang.Number) 0);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit removeStorage$lambda$21$lambda$20(uts.sdk.modules.DCloudUniStorage.RemoveStorageOptions removeStorageOptions) {
        io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext());
        if (dCStorage == null) {
            io.dcloud.uniapp.UniError uniError = new io.dcloud.uniapp.UniError("uni-removeStorage", (java.lang.Number) (-1), "storage not found.");
            kotlin.jvm.functions.Function1<io.dcloud.uniapp.UniError, kotlin.Unit> fail = removeStorageOptions.getFail();
            if (fail != null) {
                fail.invoke2(uniError);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = removeStorageOptions.getComplete();
            if (complete != null) {
                complete.invoke2(uniError);
            }
            return kotlin.Unit.INSTANCE;
        }
        dCStorage.performRemoveItem(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext(), io.dcloud.uts.UTSAndroid.INSTANCE.getAppId(), removeStorageOptions.getKey());
        uts.sdk.modules.DCloudUniStorage.RemoveStorageSuccess removeStorageSuccess = new uts.sdk.modules.DCloudUniStorage.RemoveStorageSuccess();
        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.RemoveStorageSuccess, kotlin.Unit> success = removeStorageOptions.getSuccess();
        if (success != null) {
            success.invoke2(removeStorageSuccess);
        }
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete2 = removeStorageOptions.getComplete();
        if (complete2 != null) {
            complete2.invoke2(removeStorageSuccess);
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getRemoveStorageSync() {
        return removeStorageSync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit removeStorageSync$lambda$22(java.lang.String str) {
        io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext());
        if (dCStorage == null) {
            return kotlin.Unit.INSTANCE;
        }
        dCStorage.performRemoveItem(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext(), io.dcloud.uts.UTSAndroid.INSTANCE.getAppId(), str);
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.ClearStorageOptions, kotlin.Unit> getClearStorage() {
        return clearStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit clearStorage$lambda$24(final uts.sdk.modules.DCloudUniStorage.ClearStorageOptions clearStorageOptions) {
        io.dcloud.uts.UTSTimerKt.setTimeout(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.clearStorage$lambda$24$lambda$23(clearStorageOptions);
            }
        }, (java.lang.Number) 0);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit clearStorage$lambda$24$lambda$23(uts.sdk.modules.DCloudUniStorage.ClearStorageOptions clearStorageOptions) {
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete;
        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniStorage.ClearStorageSuccess, kotlin.Unit> success;
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete2;
        kotlin.jvm.functions.Function1<io.dcloud.uniapp.UniError, kotlin.Unit> fail;
        io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext());
        if (dCStorage == null) {
            io.dcloud.uniapp.UniError uniError = new io.dcloud.uniapp.UniError("uni-clearStorage", (java.lang.Number) (-1), "error:storage not found.");
            if (clearStorageOptions != null && (fail = clearStorageOptions.getFail()) != null) {
                fail.invoke2(uniError);
            }
            if (clearStorageOptions != null && (complete2 = clearStorageOptions.getComplete()) != null) {
                complete2.invoke2(uniError);
            }
            return kotlin.Unit.INSTANCE;
        }
        dCStorage.performClear(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext(), io.dcloud.uts.UTSAndroid.INSTANCE.getAppId());
        uts.sdk.modules.DCloudUniStorage.ClearStorageSuccess clearStorageSuccess = new uts.sdk.modules.DCloudUniStorage.ClearStorageSuccess();
        if (clearStorageOptions != null && (success = clearStorageOptions.getSuccess()) != null) {
            success.invoke2(clearStorageSuccess);
        }
        if (clearStorageOptions != null && (complete = clearStorageOptions.getComplete()) != null) {
            complete.invoke2(clearStorageSuccess);
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function0<kotlin.Unit> getClearStorageSync() {
        return clearStorageSync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit clearStorageSync$lambda$25() {
        io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext());
        if (dCStorage == null) {
            return kotlin.Unit.INSTANCE;
        }
        dCStorage.performClear(io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext(), io.dcloud.uts.UTSAndroid.INSTANCE.getAppId());
        return kotlin.Unit.INSTANCE;
    }

    public static final void setStorageByJs(final uts.sdk.modules.DCloudUniStorage.SetStorageOptionsJSONObject options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        setStorage.invoke2(new uts.sdk.modules.DCloudUniStorage.SetStorageOptions(options.getKey(), options.getData(), new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.setStorageByJs$lambda$26(options, (uts.sdk.modules.DCloudUniStorage.SetStorageSuccess) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.setStorageByJs$lambda$27(options, (io.dcloud.uniapp.UniError) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.setStorageByJs$lambda$28(options, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit setStorageByJs$lambda$26(uts.sdk.modules.DCloudUniStorage.SetStorageOptionsJSONObject setStorageOptionsJSONObject, uts.sdk.modules.DCloudUniStorage.SetStorageSuccess setStorageSuccess) {
        io.dcloud.uts.UTSCallback success = setStorageOptionsJSONObject.getSuccess();
        if (success != null) {
            success.invoke(setStorageSuccess);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit setStorageByJs$lambda$27(uts.sdk.modules.DCloudUniStorage.SetStorageOptionsJSONObject setStorageOptionsJSONObject, io.dcloud.uniapp.UniError uniError) {
        io.dcloud.uts.UTSCallback fail = setStorageOptionsJSONObject.getFail();
        if (fail != null) {
            fail.invoke(uniError);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit setStorageByJs$lambda$28(uts.sdk.modules.DCloudUniStorage.SetStorageOptionsJSONObject setStorageOptionsJSONObject, java.lang.Object obj) {
        io.dcloud.uts.UTSCallback complete = setStorageOptionsJSONObject.getComplete();
        if (complete != null) {
            complete.invoke(obj);
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final void setStorageSyncByJs(java.lang.String key, java.lang.Object data) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        setStorageSync.invoke(key, data);
    }

    public static final void getStorageByJs(final uts.sdk.modules.DCloudUniStorage.GetStorageOptionsJSONObject options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        getStorage.invoke2(new uts.sdk.modules.DCloudUniStorage.GetStorageOptions(options.getKey(), new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.getStorageByJs$lambda$29(options, (uts.sdk.modules.DCloudUniStorage.GetStorageSuccess) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.getStorageByJs$lambda$30(options, (io.dcloud.uniapp.UniError) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.getStorageByJs$lambda$31(options, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit getStorageByJs$lambda$29(uts.sdk.modules.DCloudUniStorage.GetStorageOptionsJSONObject getStorageOptionsJSONObject, uts.sdk.modules.DCloudUniStorage.GetStorageSuccess getStorageSuccess) {
        io.dcloud.uts.UTSCallback success = getStorageOptionsJSONObject.getSuccess();
        if (success != null) {
            success.invoke(getStorageSuccess);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit getStorageByJs$lambda$30(uts.sdk.modules.DCloudUniStorage.GetStorageOptionsJSONObject getStorageOptionsJSONObject, io.dcloud.uniapp.UniError uniError) {
        io.dcloud.uts.UTSCallback fail = getStorageOptionsJSONObject.getFail();
        if (fail != null) {
            fail.invoke(uniError);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit getStorageByJs$lambda$31(uts.sdk.modules.DCloudUniStorage.GetStorageOptionsJSONObject getStorageOptionsJSONObject, java.lang.Object obj) {
        io.dcloud.uts.UTSCallback complete = getStorageOptionsJSONObject.getComplete();
        if (complete != null) {
            complete.invoke(obj);
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final java.lang.Object getStorageSyncByJs(java.lang.String key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        return getStorageSync.invoke2(key);
    }

    public static final void getStorageInfoByJs(final uts.sdk.modules.DCloudUniStorage.GetStorageInfoOptionsJSONObject options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        getStorageInfo.invoke2(new uts.sdk.modules.DCloudUniStorage.GetStorageInfoOptions(new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.getStorageInfoByJs$lambda$32(options, (uts.sdk.modules.DCloudUniStorage.GetStorageInfoSuccess) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.getStorageInfoByJs$lambda$33(options, (io.dcloud.uniapp.UniError) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.getStorageInfoByJs$lambda$34(options, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit getStorageInfoByJs$lambda$32(uts.sdk.modules.DCloudUniStorage.GetStorageInfoOptionsJSONObject getStorageInfoOptionsJSONObject, uts.sdk.modules.DCloudUniStorage.GetStorageInfoSuccess getStorageInfoSuccess) {
        io.dcloud.uts.UTSCallback success = getStorageInfoOptionsJSONObject.getSuccess();
        if (success != null) {
            success.invoke(getStorageInfoSuccess);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit getStorageInfoByJs$lambda$33(uts.sdk.modules.DCloudUniStorage.GetStorageInfoOptionsJSONObject getStorageInfoOptionsJSONObject, io.dcloud.uniapp.UniError uniError) {
        io.dcloud.uts.UTSCallback fail = getStorageInfoOptionsJSONObject.getFail();
        if (fail != null) {
            fail.invoke(uniError);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit getStorageInfoByJs$lambda$34(uts.sdk.modules.DCloudUniStorage.GetStorageInfoOptionsJSONObject getStorageInfoOptionsJSONObject, java.lang.Object obj) {
        io.dcloud.uts.UTSCallback complete = getStorageInfoOptionsJSONObject.getComplete();
        if (complete != null) {
            complete.invoke(obj);
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final uts.sdk.modules.DCloudUniStorage.GetStorageInfoSuccess getStorageInfoSyncByJs() {
        return getStorageInfoSync.invoke();
    }

    public static final void removeStorageByJs(final uts.sdk.modules.DCloudUniStorage.RemoveStorageOptionsJSONObject options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        removeStorage.invoke2(new uts.sdk.modules.DCloudUniStorage.RemoveStorageOptions(options.getKey(), new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.removeStorageByJs$lambda$35(options, (uts.sdk.modules.DCloudUniStorage.RemoveStorageSuccess) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.removeStorageByJs$lambda$36(options, (io.dcloud.uniapp.UniError) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.removeStorageByJs$lambda$37(options, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit removeStorageByJs$lambda$35(uts.sdk.modules.DCloudUniStorage.RemoveStorageOptionsJSONObject removeStorageOptionsJSONObject, uts.sdk.modules.DCloudUniStorage.RemoveStorageSuccess removeStorageSuccess) {
        io.dcloud.uts.UTSCallback success = removeStorageOptionsJSONObject.getSuccess();
        if (success != null) {
            success.invoke(removeStorageSuccess);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit removeStorageByJs$lambda$36(uts.sdk.modules.DCloudUniStorage.RemoveStorageOptionsJSONObject removeStorageOptionsJSONObject, io.dcloud.uniapp.UniError uniError) {
        io.dcloud.uts.UTSCallback fail = removeStorageOptionsJSONObject.getFail();
        if (fail != null) {
            fail.invoke(uniError);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit removeStorageByJs$lambda$37(uts.sdk.modules.DCloudUniStorage.RemoveStorageOptionsJSONObject removeStorageOptionsJSONObject, java.lang.Object obj) {
        io.dcloud.uts.UTSCallback complete = removeStorageOptionsJSONObject.getComplete();
        if (complete != null) {
            complete.invoke(obj);
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final void removeStorageSyncByJs(java.lang.String key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        removeStorageSync.invoke2(key);
    }

    public static final void clearStorageByJs(final uts.sdk.modules.DCloudUniStorage.ClearStorageOptionsJSONObject clearStorageOptionsJSONObject) {
        clearStorage.invoke2(clearStorageOptionsJSONObject != null ? new uts.sdk.modules.DCloudUniStorage.ClearStorageOptions(new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.clearStorageByJs$lambda$38(clearStorageOptionsJSONObject, (uts.sdk.modules.DCloudUniStorage.ClearStorageSuccess) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.clearStorageByJs$lambda$39(clearStorageOptionsJSONObject, (io.dcloud.uniapp.UniError) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniStorage.IndexKt.clearStorageByJs$lambda$40(clearStorageOptionsJSONObject, obj);
            }
        }) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit clearStorageByJs$lambda$38(uts.sdk.modules.DCloudUniStorage.ClearStorageOptionsJSONObject clearStorageOptionsJSONObject, uts.sdk.modules.DCloudUniStorage.ClearStorageSuccess clearStorageSuccess) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(clearStorageOptionsJSONObject);
        io.dcloud.uts.UTSCallback success = clearStorageOptionsJSONObject.getSuccess();
        if (success != null) {
            success.invoke(clearStorageSuccess);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit clearStorageByJs$lambda$39(uts.sdk.modules.DCloudUniStorage.ClearStorageOptionsJSONObject clearStorageOptionsJSONObject, io.dcloud.uniapp.UniError uniError) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(clearStorageOptionsJSONObject);
        io.dcloud.uts.UTSCallback fail = clearStorageOptionsJSONObject.getFail();
        if (fail != null) {
            fail.invoke(uniError);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit clearStorageByJs$lambda$40(uts.sdk.modules.DCloudUniStorage.ClearStorageOptionsJSONObject clearStorageOptionsJSONObject, java.lang.Object obj) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(clearStorageOptionsJSONObject);
        io.dcloud.uts.UTSCallback complete = clearStorageOptionsJSONObject.getComplete();
        if (complete != null) {
            complete.invoke(obj);
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final void clearStorageSyncByJs() {
        clearStorageSync.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getStorage$lambda$12$lambda$11$lambda$10(kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.common.util.db.DCStorage> objectRef, final java.lang.String str) {
        io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
        io.dcloud.common.util.db.DCStorage.StorageInfo storageInfoPerformGetAllKeys = objectRef.element.performGetAllKeys(io.dcloud.uts.UTSAndroid.INSTANCE.getAppId());
        if (storageInfoPerformGetAllKeys.code == 1 && storageInfoPerformGetAllKeys.v != null) {
            uTSArray = new io.dcloud.uts.UTSArray();
            java.lang.Object obj = storageInfoPerformGetAllKeys.v;
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.List<kotlin.String>");
            java.util.Iterator it = ((java.util.List) obj).iterator();
            while (it.hasNext()) {
                uTSArray.push((java.lang.String) it.next());
            }
        }
        return ((java.lang.String) uTSArray.find(new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniStorage.IndexKt$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj2) {
                return java.lang.Boolean.valueOf(uts.sdk.modules.DCloudUniStorage.IndexKt.getStorage$lambda$12$lambda$11$lambda$10$lambda$9(str, (java.lang.String) obj2));
            }
        })) != null;
    }
}
