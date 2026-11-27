package androidx.core.os;

/* JADX INFO: loaded from: classes.dex */
public final class LocaleListCompat {
    private static final androidx.core.os.LocaleListCompat sEmptyLocaleList = create(new java.util.Locale[0]);
    private final androidx.core.os.LocaleListInterface mImpl;

    private LocaleListCompat(androidx.core.os.LocaleListInterface localeListInterface) {
        this.mImpl = localeListInterface;
    }

    @java.lang.Deprecated
    public static androidx.core.os.LocaleListCompat wrap(java.lang.Object obj) {
        return wrap(androidx.core.util.HalfKt$$ExternalSyntheticApiModelOutline0.m78m(obj));
    }

    public static androidx.core.os.LocaleListCompat wrap(android.os.LocaleList localeList) {
        return new androidx.core.os.LocaleListCompat(new androidx.core.os.LocaleListPlatformWrapper(localeList));
    }

    public java.lang.Object unwrap() {
        return this.mImpl.getLocaleList();
    }

    public static androidx.core.os.LocaleListCompat create(java.util.Locale... localeArr) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return wrap(androidx.core.os.LocaleListCompat.Api24Impl.createLocaleList(localeArr));
        }
        return new androidx.core.os.LocaleListCompat(new androidx.core.os.LocaleListCompatWrapper(localeArr));
    }

    public java.util.Locale get(int i) {
        return this.mImpl.get(i);
    }

    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    public int size() {
        return this.mImpl.size();
    }

    public int indexOf(java.util.Locale locale) {
        return this.mImpl.indexOf(locale);
    }

    public java.lang.String toLanguageTags() {
        return this.mImpl.toLanguageTags();
    }

    public java.util.Locale getFirstMatch(java.lang.String[] strArr) {
        return this.mImpl.getFirstMatch(strArr);
    }

    public static androidx.core.os.LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    public static androidx.core.os.LocaleListCompat forLanguageTags(java.lang.String str) {
        if (str == null || str.isEmpty()) {
            return getEmptyLocaleList();
        }
        java.lang.String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        java.util.Locale[] localeArr = new java.util.Locale[length];
        for (int i = 0; i < length; i++) {
            localeArr[i] = androidx.core.os.LocaleListCompat.Api21Impl.forLanguageTag(strArrSplit[i]);
        }
        return create(localeArr);
    }

    static java.util.Locale forLanguageTagCompat(java.lang.String str) {
        if (str.contains(com.taobao.weex.el.parse.Operators.SUB)) {
            java.lang.String[] strArrSplit = str.split(com.taobao.weex.el.parse.Operators.SUB, -1);
            if (strArrSplit.length > 2) {
                return new java.util.Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
            }
            if (strArrSplit.length > 1) {
                return new java.util.Locale(strArrSplit[0], strArrSplit[1]);
            }
            if (strArrSplit.length == 1) {
                return new java.util.Locale(strArrSplit[0]);
            }
        } else if (str.contains("_")) {
            java.lang.String[] strArrSplit2 = str.split("_", -1);
            if (strArrSplit2.length > 2) {
                return new java.util.Locale(strArrSplit2[0], strArrSplit2[1], strArrSplit2[2]);
            }
            if (strArrSplit2.length > 1) {
                return new java.util.Locale(strArrSplit2[0], strArrSplit2[1]);
            }
            if (strArrSplit2.length == 1) {
                return new java.util.Locale(strArrSplit2[0]);
            }
        } else {
            return new java.util.Locale(str);
        }
        throw new java.lang.IllegalArgumentException("Can not parse language tag: [" + str + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
    }

    public static androidx.core.os.LocaleListCompat getAdjustedDefault() {
        return android.os.Build.VERSION.SDK_INT >= 24 ? wrap(androidx.core.os.LocaleListCompat.Api24Impl.getAdjustedDefault()) : create(java.util.Locale.getDefault());
    }

    public static androidx.core.os.LocaleListCompat getDefault() {
        return android.os.Build.VERSION.SDK_INT >= 24 ? wrap(androidx.core.os.LocaleListCompat.Api24Impl.getDefault()) : create(java.util.Locale.getDefault());
    }

    public static boolean matchesLanguageAndScript(java.util.Locale locale, java.util.Locale locale2) {
        if (android.os.Build.VERSION.SDK_INT >= 33) {
            return android.os.LocaleList.matchesLanguageAndScript(locale, locale2);
        }
        return androidx.core.os.LocaleListCompat.Api21Impl.matchesLanguageAndScript(locale, locale2);
    }

    static class Api21Impl {
        private static final java.util.Locale[] PSEUDO_LOCALE = {new java.util.Locale("en", "XA"), new java.util.Locale("ar", "XB")};

        private Api21Impl() {
        }

        static boolean matchesLanguageAndScript(java.util.Locale locale, java.util.Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || isPseudoLocale(locale) || isPseudoLocale(locale2)) {
                return false;
            }
            java.lang.String strMaximizeAndGetScript = androidx.core.text.ICUCompat.maximizeAndGetScript(locale);
            if (strMaximizeAndGetScript.isEmpty()) {
                java.lang.String country = locale.getCountry();
                return country.isEmpty() || country.equals(locale2.getCountry());
            }
            return strMaximizeAndGetScript.equals(androidx.core.text.ICUCompat.maximizeAndGetScript(locale2));
        }

        private static boolean isPseudoLocale(java.util.Locale locale) {
            for (java.util.Locale locale2 : PSEUDO_LOCALE) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        static java.util.Locale forLanguageTag(java.lang.String str) {
            return java.util.Locale.forLanguageTag(str);
        }
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof androidx.core.os.LocaleListCompat) && this.mImpl.equals(((androidx.core.os.LocaleListCompat) obj).mImpl);
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public java.lang.String toString() {
        return this.mImpl.toString();
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static android.os.LocaleList createLocaleList(java.util.Locale... localeArr) {
            return new android.os.LocaleList(localeArr);
        }

        static android.os.LocaleList getAdjustedDefault() {
            return android.os.LocaleList.getAdjustedDefault();
        }

        static android.os.LocaleList getDefault() {
            return android.os.LocaleList.getDefault();
        }
    }
}
