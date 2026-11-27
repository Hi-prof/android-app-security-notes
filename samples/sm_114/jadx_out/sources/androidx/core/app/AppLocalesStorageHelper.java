package androidx.core.app;

/* JADX INFO: loaded from: classes.dex */
public class AppLocalesStorageHelper {
    static final java.lang.String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final boolean DEBUG = false;
    static final java.lang.String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final java.lang.String LOCALE_RECORD_FILE_TAG = "locales";
    static final java.lang.String TAG = "AppLocalesStorageHelper";
    private static final java.lang.Object sAppLocaleStorageSync = new java.lang.Object();

    private AppLocalesStorageHelper() {
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0043 A[EXC_TOP_SPLITTER, PHI: r1
  0x0043: PHI (r1v2 java.lang.String) = (r1v0 java.lang.String), (r1v4 java.lang.String) binds: [B:26:0x0050, B:20:0x0041] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public static java.lang.String readLocales(android.content.Context context) {
        java.lang.String attributeValue;
        synchronized (sAppLocaleStorageSync) {
            attributeValue = "";
            try {
                try {
                    java.io.FileInputStream fileInputStreamOpenFileInput = context.openFileInput(APPLICATION_LOCALES_RECORD_FILE);
                    try {
                        try {
                            org.xmlpull.v1.XmlPullParser xmlPullParserNewPullParser = android.util.Xml.newPullParser();
                            xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, "UTF-8");
                            int depth = xmlPullParserNewPullParser.getDepth();
                            while (true) {
                                int next = xmlPullParserNewPullParser.next();
                                if (next != 1 && (next != 3 || xmlPullParserNewPullParser.getDepth() > depth)) {
                                    if (next != 3 && next != 4 && xmlPullParserNewPullParser.getName().equals(LOCALE_RECORD_FILE_TAG)) {
                                        attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, LOCALE_RECORD_ATTRIBUTE_TAG);
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            if (fileInputStreamOpenFileInput != null) {
                                try {
                                    fileInputStreamOpenFileInput.close();
                                } catch (java.io.IOException unused) {
                                }
                            }
                        } catch (java.io.IOException | org.xmlpull.v1.XmlPullParserException unused2) {
                            android.util.Log.w(TAG, "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                            if (fileInputStreamOpenFileInput != null) {
                                fileInputStreamOpenFileInput.close();
                            }
                        }
                        if (attributeValue.isEmpty()) {
                            context.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
                        }
                    } catch (java.lang.Throwable th) {
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (java.io.IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (java.io.FileNotFoundException unused4) {
                    return "";
                }
            } catch (java.lang.Throwable th2) {
                throw th2;
            }
        }
        return attributeValue;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void persistLocales(android.content.Context context, java.lang.String str) {
        synchronized (sAppLocaleStorageSync) {
            if (str.equals("")) {
                context.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
                return;
            }
            try {
                java.io.FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(APPLICATION_LOCALES_RECORD_FILE, 0);
                org.xmlpull.v1.XmlSerializer xmlSerializerNewSerializer = android.util.Xml.newSerializer();
                try {
                    try {
                        xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                        xmlSerializerNewSerializer.startDocument("UTF-8", true);
                        xmlSerializerNewSerializer.startTag(null, LOCALE_RECORD_FILE_TAG);
                        xmlSerializerNewSerializer.attribute(null, LOCALE_RECORD_ATTRIBUTE_TAG, str);
                        xmlSerializerNewSerializer.endTag(null, LOCALE_RECORD_FILE_TAG);
                        xmlSerializerNewSerializer.endDocument();
                        if (fileOutputStreamOpenFileOutput != null) {
                            try {
                                fileOutputStreamOpenFileOutput.close();
                            } catch (java.io.IOException unused) {
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        if (fileOutputStreamOpenFileOutput != null) {
                            try {
                                fileOutputStreamOpenFileOutput.close();
                            } catch (java.io.IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (java.lang.Exception e) {
                    android.util.Log.w(TAG, "Storing App Locales : Failed to persist app-locales in storage ", e);
                    if (fileOutputStreamOpenFileOutput != null) {
                        fileOutputStreamOpenFileOutput.close();
                    }
                }
            } catch (java.io.FileNotFoundException unused3) {
                android.util.Log.w(TAG, java.lang.String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", APPLICATION_LOCALES_RECORD_FILE));
            }
        }
    }
}
