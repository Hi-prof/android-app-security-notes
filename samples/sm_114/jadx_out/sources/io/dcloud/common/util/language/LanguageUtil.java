package io.dcloud.common.util.language;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class LanguageUtil {
    public static final java.lang.String LanguageBroadCastIntent = "language_uni_broad_cast_intent";
    public static final java.lang.String LanguageConfigKey = "language_uni_current_key";
    public static final java.lang.String LanguageConfigSPFile = "language_uni_sp_file";
    private static java.lang.String deviceDefCountry = "";
    private static java.lang.String deviceDefLocalLanguage = "";
    private static java.lang.String sCurrentLocalLanguage = "";

    public static java.util.Locale getCurrentLocal(android.content.Context context, boolean z) {
        if (context == null) {
            return null;
        }
        if (android.os.Build.VERSION.SDK_INT < 24) {
            if (!z) {
                return context.getResources().getConfiguration().locale;
            }
            context.getResources();
            return android.content.res.Resources.getSystem().getConfiguration().locale;
        }
        android.os.LocaleList locales = context.getResources().getConfiguration().getLocales();
        if (z) {
            context.getResources();
            locales = android.content.res.Resources.getSystem().getConfiguration().getLocales();
        }
        return (locales == null || locales.size() <= 0) ? context.getResources().getConfiguration().locale : locales.get(0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0050  */
    public static java.lang.String getCurrentLocaleLanguage(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(sCurrentLocalLanguage)) {
            return sCurrentLocalLanguage;
        }
        byte b = 1;
        java.util.Locale currentLocal = getCurrentLocal(context, true);
        if (currentLocal == null) {
            return deviceDefLocalLanguage;
        }
        java.lang.String languageTag = currentLocal.getLanguage() + com.taobao.weex.el.parse.Operators.SUB + currentLocal.getCountry();
        if (android.os.Build.VERSION.SDK_INT > 21) {
            languageTag = currentLocal.toLanguageTag();
        }
        java.lang.String language = currentLocal.getLanguage();
        language.getClass();
        language.hashCode();
        switch (language.hashCode()) {
            case 3241:
                if (!language.equals("en")) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case 3246:
                if (!language.equals("es")) {
                    b = -1;
                }
                break;
            case 3276:
                if (!language.equals("fr")) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case 3886:
                if (!language.equals("zh")) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                return "en";
            case 1:
                return "es";
            case 2:
                return "fr";
            case 3:
                if (languageTag.equalsIgnoreCase("zh-CN")) {
                    return "zh-Hans";
                }
                if (languageTag.equalsIgnoreCase("zh-HK")) {
                    return "zh-Hant-HK";
                }
                if (languageTag.equalsIgnoreCase("zh-TW")) {
                    return "zh-Hant-TW";
                }
            default:
                return languageTag;
        }
    }

    public static java.lang.String getDeviceDefCountry() {
        return deviceDefCountry;
    }

    public static java.lang.String getDeviceDefLocalLanguage() {
        return deviceDefLocalLanguage;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a8  */
    public static java.lang.String getString(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str) {
        java.lang.String string;
        if (jSONObject != null) {
            java.lang.String currentLocaleLanguage = getCurrentLocaleLanguage(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext);
            if (android.text.TextUtils.isEmpty(currentLocaleLanguage)) {
                string = str;
            } else {
                string = getString(currentLocaleLanguage, jSONObject);
                if (android.text.TextUtils.isEmpty(string)) {
                    if (currentLocaleLanguage.equalsIgnoreCase("zh-CN")) {
                        string = getString("zh-Hans", jSONObject);
                    } else if (currentLocaleLanguage.equalsIgnoreCase("zh-HK")) {
                        string = getString("zh-Hant-HK", jSONObject);
                    } else if (currentLocaleLanguage.equalsIgnoreCase("zh-TW")) {
                        string = getString("zh-Hant-TW", jSONObject);
                    }
                    if (android.text.TextUtils.isEmpty(string)) {
                        java.lang.String[] strArrSplit = currentLocaleLanguage.split(com.taobao.weex.el.parse.Operators.SUB);
                        int length = strArrSplit.length;
                        if (length == 2) {
                            string = getString(strArrSplit[0], jSONObject);
                        } else if (length == 3) {
                            string = getString(strArrSplit[0] + com.taobao.weex.el.parse.Operators.SUB + strArrSplit[2], jSONObject);
                            if (android.text.TextUtils.isEmpty(string)) {
                                string = getString(strArrSplit[0] + com.taobao.weex.el.parse.Operators.SUB + strArrSplit[1], jSONObject);
                            }
                            if (android.text.TextUtils.isEmpty(string)) {
                                string = getString(strArrSplit[0], jSONObject);
                            }
                        }
                    }
                }
            }
        } else {
            string = str;
        }
        return io.dcloud.common.util.PdrUtil.isEmpty(string) ? str : string;
    }

    public static void initAppLanguageForAppBeforeO(android.content.Context context) {
        updateAppBootLanguage(context);
        updateSystemLanguage(context);
    }

    private static void updateAppBootLanguage(android.content.Context context) {
        java.lang.String string;
        java.lang.String string2 = context.getSharedPreferences(LanguageConfigSPFile, 0).getString(LanguageConfigKey, "");
        try {
            string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("DCLOUD_APP_DEFAULT_LANGUAGE");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            string = "";
        }
        if (android.text.TextUtils.isEmpty(string2) && !android.text.TextUtils.isEmpty(string)) {
            string2 = string;
        }
        sCurrentLocalLanguage = "auto".equalsIgnoreCase(string2) ? "" : string2;
        updateDeviceDefLocalLanguage(context);
    }

    public static android.content.Context updateContextLanguageAfterO(android.content.Context context, boolean z) {
        return updateContextLanguageAfterO(context, z, true);
    }

    public static void updateDeviceDefLocalLanguage(java.util.Locale locale) {
        if (locale != null) {
            deviceDefLocalLanguage = locale.getLanguage() + com.taobao.weex.el.parse.Operators.SUB + locale.getCountry();
            deviceDefCountry = locale.getCountry();
            io.dcloud.common.adapter.util.DeviceInfo.sLanguage = deviceDefLocalLanguage;
        }
    }

    public static void updateLanguage(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(LanguageConfigSPFile, 0).edit();
        editorEdit.putString(LanguageConfigKey, str);
        editorEdit.commit();
        sCurrentLocalLanguage = str;
        updateSystemLanguage(context);
    }

    public static void updateSystemLanguage(android.content.Context context) {
        if (context == null) {
            return;
        }
        java.lang.String str = sCurrentLocalLanguage;
        if ("zh-Hant-TW".equals(str) || "zh-Hant".equals(str)) {
            str = "zh-TW";
        } else if ("zh-Hant-HK".equals(str)) {
            str = "zh-HK";
        }
        if (android.os.Build.VERSION.SDK_INT < 24) {
            android.content.res.Resources resources = context.getResources();
            if (android.text.TextUtils.isEmpty(str)) {
                str = deviceDefLocalLanguage;
            }
            java.util.Locale localeForLanguageTag = java.util.Locale.forLanguageTag(str);
            java.util.Locale.setDefault(localeForLanguageTag);
            android.content.res.Configuration configuration = resources.getConfiguration();
            configuration.setLocale(localeForLanguageTag);
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            return;
        }
        android.content.res.Resources resources2 = context.getResources();
        android.util.DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
        android.content.res.Configuration configuration2 = resources2.getConfiguration();
        if (android.text.TextUtils.isEmpty(str)) {
            str = deviceDefLocalLanguage;
        }
        io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m$3();
        android.os.LocaleList localeListM = io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m(new java.util.Locale[]{java.util.Locale.forLanguageTag(str)});
        android.os.LocaleList.setDefault(localeListM);
        configuration2.setLocales(localeListM);
        resources2.updateConfiguration(configuration2, displayMetrics);
    }

    public static android.content.Context wrapContextConfigurationAfterO(android.content.Context context, java.lang.String str) {
        return wrapContextConfigurationAfterO(context, str, true);
    }

    public static android.content.Context updateContextLanguageAfterO(android.content.Context context, boolean z, boolean z2) {
        if (z) {
            updateAppBootLanguage(context);
        }
        return android.text.TextUtils.isEmpty(sCurrentLocalLanguage) ? context : wrapContextConfigurationAfterO(context, sCurrentLocalLanguage, z2);
    }

    public static android.content.Context wrapContextConfigurationAfterO(android.content.Context context, java.lang.String str, boolean z) {
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return context;
        }
        android.content.res.Resources resources = context.getResources();
        android.util.DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        android.content.res.Configuration configuration = resources.getConfiguration();
        io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m$3();
        android.os.LocaleList localeListM = io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m(new java.util.Locale[]{java.util.Locale.forLanguageTag(str)});
        android.os.LocaleList.setDefault(localeListM);
        configuration.setLocales(localeListM);
        resources.updateConfiguration(configuration, displayMetrics);
        return z ? context.createConfigurationContext(configuration) : context;
    }

    public static void updateDeviceDefLocalLanguage(android.content.Context context) {
        updateDeviceDefLocalLanguage(getCurrentLocal(context, true));
    }

    private static java.lang.String getString(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.containsKey(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }
}
