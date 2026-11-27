package com.taobao.weex.ui.module;

/* JADX INFO: loaded from: classes.dex */
public class WXLocaleModule extends com.taobao.weex.common.WXModule {
    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public java.lang.String getLanguageSync() {
        return getLanguageImpl();
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void getLanguage(com.taobao.weex.bridge.JSCallback jSCallback) {
        jSCallback.invoke(getLanguageImpl());
    }

    private java.lang.String getLanguageImpl() {
        java.util.Locale locale;
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            locale = android.os.LocaleList.getDefault().get(0);
        } else {
            locale = java.util.Locale.getDefault();
        }
        return locale.getLanguage() + com.taobao.weex.el.parse.Operators.SUB + locale.getCountry();
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public java.util.List<java.lang.String> getLanguages() {
        return java.util.Arrays.asList(getLanguageTags().split(","));
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void getLanguages(com.taobao.weex.bridge.JSCallback jSCallback) {
        jSCallback.invoke(getLanguageTags().split(","));
    }

    private java.lang.String getLanguageTags() {
        android.content.res.Resources resources;
        android.content.res.Configuration configuration;
        android.app.Application application = com.taobao.weex.WXEnvironment.getApplication();
        if (application != null && (resources = application.getResources()) != null && (configuration = resources.getConfiguration()) != null) {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                return configuration.getLocales().toLanguageTags();
            }
            java.util.Locale locale = configuration.locale;
            if (locale != null) {
                return toLanguageTag(locale);
            }
            return "";
        }
        return "";
    }

    private java.lang.String toLanguageTag(java.util.Locale locale) {
        return locale.toLanguageTag();
    }
}
