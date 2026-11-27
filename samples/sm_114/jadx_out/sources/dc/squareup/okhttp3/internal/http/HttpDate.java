package dc.squareup.okhttp3.internal.http;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class HttpDate {
    public static final long MAX_DATE = 253402300799999L;
    private static final java.lang.ThreadLocal<java.text.DateFormat> STANDARD_DATE_FORMAT = new java.lang.ThreadLocal<java.text.DateFormat>() { // from class: dc.squareup.okhttp3.internal.http.HttpDate.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public java.text.DateFormat initialValue() {
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", java.util.Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(dc.squareup.okhttp3.internal.Util.UTC);
            return simpleDateFormat;
        }
    };
    private static final java.lang.String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    private static final java.text.DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS = new java.text.DateFormat[15];

    private HttpDate() {
    }

    public static java.lang.String format(java.util.Date date) {
        return STANDARD_DATE_FORMAT.get().format(date);
    }

    public static java.util.Date parse(java.lang.String str) {
        if (str.length() == 0) {
            return null;
        }
        java.text.ParsePosition parsePosition = new java.text.ParsePosition(0);
        java.util.Date date = STANDARD_DATE_FORMAT.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return date;
        }
        java.lang.String[] strArr = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        synchronized (strArr) {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                java.text.DateFormat[] dateFormatArr = BROWSER_COMPATIBLE_DATE_FORMATS;
                java.text.DateFormat simpleDateFormat = dateFormatArr[i];
                if (simpleDateFormat == null) {
                    simpleDateFormat = new java.text.SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[i], java.util.Locale.US);
                    simpleDateFormat.setTimeZone(dc.squareup.okhttp3.internal.Util.UTC);
                    dateFormatArr[i] = simpleDateFormat;
                }
                parsePosition.setIndex(0);
                java.util.Date date2 = simpleDateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return date2;
                }
            }
            return null;
        }
    }
}
