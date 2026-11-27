package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IFeature {
    public static final java.lang.String F_ACCELEROMETER = "Accelerometer";
    public static final java.lang.String F_AUDIO = "Audio";
    public static final java.lang.String F_BARCODE = "Barcode";
    public static final java.lang.String F_CAMERA = "Camera";
    public static final java.lang.String F_CONSOLE = "Console";
    public static final java.lang.String F_CONTACTS = "Contacts";
    public static final java.lang.String F_DEVICE = "Device";
    public static final java.lang.String F_DOWNLOADER = "Downloader";
    public static final java.lang.String F_EVENTS = "Events";
    public static final java.lang.String F_FILE = "File";
    public static final java.lang.String F_GALLERY = "Gallery";
    public static final java.lang.String F_GEOLOCATION = "Geolocation";
    public static final java.lang.String F_INVOCATION = "Invocation";
    public static final java.lang.String F_MAPS = "Maps";
    public static final java.lang.String F_MESSAGING = "Messaging";
    public static final java.lang.String F_NAVIGATOR = "Navigator";
    public static final java.lang.String F_ORIENTATION = "Orientation";
    public static final java.lang.String F_PAYMENT = "Payment";
    public static final java.lang.String F_PROXIMITY = "Proximity";
    public static final java.lang.String F_PUSH = "Push";
    public static final java.lang.String F_RUNTIME = "Runtime";
    public static final java.lang.String F_SHARE = "Share";
    public static final java.lang.String F_SPEECH = "Speech";
    public static final java.lang.String F_SPLASHSCREEN = "Splashscreen";
    public static final java.lang.String F_STATISTIC = "Statistic";
    public static final java.lang.String F_STORAGE = "Storage";
    public static final java.lang.String F_UI = "UI";
    public static final java.lang.String F_XMLHTTPREQUEST = "XMLHttpRequest";
    public static final java.lang.String F_ZIP = "Zip";

    void dispose(java.lang.String str);

    java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr);

    void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str);
}
