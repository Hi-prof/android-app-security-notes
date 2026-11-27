package androidx.webkit;

/* JADX INFO: loaded from: classes.dex */
public class WebSettingsCompat {

    @java.lang.Deprecated
    public static final int DARK_STRATEGY_PREFER_WEB_THEME_OVER_USER_AGENT_DARKENING = 2;

    @java.lang.Deprecated
    public static final int DARK_STRATEGY_USER_AGENT_DARKENING_ONLY = 0;

    @java.lang.Deprecated
    public static final int DARK_STRATEGY_WEB_THEME_DARKENING_ONLY = 1;

    @java.lang.Deprecated
    public static final int FORCE_DARK_AUTO = 1;

    @java.lang.Deprecated
    public static final int FORCE_DARK_OFF = 0;

    @java.lang.Deprecated
    public static final int FORCE_DARK_ON = 2;
    public static final int REQUESTED_WITH_HEADER_MODE_APP_PACKAGE_NAME = 1;
    public static final int REQUESTED_WITH_HEADER_MODE_NO_HEADER = 0;

    @java.lang.annotation.Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ForceDark {
    }

    @java.lang.annotation.Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ForceDarkStrategy {
    }

    @java.lang.annotation.Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface MenuItemFlags {
    }

    @java.lang.annotation.Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface RequestedWithHeaderMode {
    }

    private WebSettingsCompat() {
    }

    public static void setOffscreenPreRaster(android.webkit.WebSettings webSettings, boolean z) {
        androidx.webkit.internal.ApiFeature.M m = androidx.webkit.internal.WebViewFeatureInternal.OFF_SCREEN_PRERASTER;
        if (m.isSupportedByFramework()) {
            androidx.webkit.internal.ApiHelperForM.setOffscreenPreRaster(webSettings, z);
        } else {
            if (m.isSupportedByWebView()) {
                getAdapter(webSettings).setOffscreenPreRaster(z);
                return;
            }
            throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public static boolean getOffscreenPreRaster(android.webkit.WebSettings webSettings) {
        androidx.webkit.internal.ApiFeature.M m = androidx.webkit.internal.WebViewFeatureInternal.OFF_SCREEN_PRERASTER;
        if (m.isSupportedByFramework()) {
            return androidx.webkit.internal.ApiHelperForM.getOffscreenPreRaster(webSettings);
        }
        if (m.isSupportedByWebView()) {
            return getAdapter(webSettings).getOffscreenPreRaster();
        }
        throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setSafeBrowsingEnabled(android.webkit.WebSettings webSettings, boolean z) {
        androidx.webkit.internal.ApiFeature.O o = androidx.webkit.internal.WebViewFeatureInternal.SAFE_BROWSING_ENABLE;
        if (o.isSupportedByFramework()) {
            androidx.webkit.internal.ApiHelperForO.setSafeBrowsingEnabled(webSettings, z);
        } else {
            if (o.isSupportedByWebView()) {
                getAdapter(webSettings).setSafeBrowsingEnabled(z);
                return;
            }
            throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public static boolean getSafeBrowsingEnabled(android.webkit.WebSettings webSettings) {
        androidx.webkit.internal.ApiFeature.O o = androidx.webkit.internal.WebViewFeatureInternal.SAFE_BROWSING_ENABLE;
        if (o.isSupportedByFramework()) {
            return androidx.webkit.internal.ApiHelperForO.getSafeBrowsingEnabled(webSettings);
        }
        if (o.isSupportedByWebView()) {
            return getAdapter(webSettings).getSafeBrowsingEnabled();
        }
        throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setDisabledActionModeMenuItems(android.webkit.WebSettings webSettings, int i) {
        androidx.webkit.internal.ApiFeature.N n = androidx.webkit.internal.WebViewFeatureInternal.DISABLED_ACTION_MODE_MENU_ITEMS;
        if (n.isSupportedByFramework()) {
            androidx.webkit.internal.ApiHelperForN.setDisabledActionModeMenuItems(webSettings, i);
        } else {
            if (n.isSupportedByWebView()) {
                getAdapter(webSettings).setDisabledActionModeMenuItems(i);
                return;
            }
            throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public static int getDisabledActionModeMenuItems(android.webkit.WebSettings webSettings) {
        androidx.webkit.internal.ApiFeature.N n = androidx.webkit.internal.WebViewFeatureInternal.DISABLED_ACTION_MODE_MENU_ITEMS;
        if (n.isSupportedByFramework()) {
            return androidx.webkit.internal.ApiHelperForN.getDisabledActionModeMenuItems(webSettings);
        }
        if (n.isSupportedByWebView()) {
            return getAdapter(webSettings).getDisabledActionModeMenuItems();
        }
        throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setWillSuppressErrorPage(android.webkit.WebSettings webSettings, boolean z) {
        if (androidx.webkit.internal.WebViewFeatureInternal.SUPPRESS_ERROR_PAGE.isSupportedByWebView()) {
            getAdapter(webSettings).setWillSuppressErrorPage(z);
            return;
        }
        throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static boolean willSuppressErrorPage(android.webkit.WebSettings webSettings) {
        if (androidx.webkit.internal.WebViewFeatureInternal.SUPPRESS_ERROR_PAGE.isSupportedByWebView()) {
            return getAdapter(webSettings).willSuppressErrorPage();
        }
        throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @java.lang.Deprecated
    public static void setForceDark(android.webkit.WebSettings webSettings, int i) {
        androidx.webkit.internal.ApiFeature.NoFramework noFramework = androidx.webkit.internal.WebViewFeatureInternal.FORCE_DARK;
        if (noFramework.isSupportedByFramework()) {
            androidx.webkit.internal.ApiHelperForQ.setForceDark(webSettings, i);
        } else {
            if (noFramework.isSupportedByWebView()) {
                getAdapter(webSettings).setForceDark(i);
                return;
            }
            throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @java.lang.Deprecated
    public static int getForceDark(android.webkit.WebSettings webSettings) {
        androidx.webkit.internal.ApiFeature.NoFramework noFramework = androidx.webkit.internal.WebViewFeatureInternal.FORCE_DARK;
        if (noFramework.isSupportedByFramework()) {
            return androidx.webkit.internal.ApiHelperForQ.getForceDark(webSettings);
        }
        if (noFramework.isSupportedByWebView()) {
            return getAdapter(webSettings).getForceDark();
        }
        throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setAlgorithmicDarkeningAllowed(android.webkit.WebSettings webSettings, boolean z) {
        if (androidx.webkit.internal.WebViewFeatureInternal.ALGORITHMIC_DARKENING.isSupportedByWebView()) {
            getAdapter(webSettings).setAlgorithmicDarkeningAllowed(z);
            return;
        }
        throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static boolean isAlgorithmicDarkeningAllowed(android.webkit.WebSettings webSettings) {
        if (androidx.webkit.internal.WebViewFeatureInternal.ALGORITHMIC_DARKENING.isSupportedByWebView()) {
            return getAdapter(webSettings).isAlgorithmicDarkeningAllowed();
        }
        throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @java.lang.Deprecated
    public static void setForceDarkStrategy(android.webkit.WebSettings webSettings, int i) {
        if (androidx.webkit.internal.WebViewFeatureInternal.FORCE_DARK_STRATEGY.isSupportedByWebView()) {
            getAdapter(webSettings).setForceDarkStrategy(i);
            return;
        }
        throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @java.lang.Deprecated
    public static int getForceDarkStrategy(android.webkit.WebSettings webSettings) {
        if (androidx.webkit.internal.WebViewFeatureInternal.FORCE_DARK_STRATEGY.isSupportedByWebView()) {
            return getAdapter(webSettings).getForceDark();
        }
        throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setRequestedWithHeaderMode(android.webkit.WebSettings webSettings, int i) {
        if (androidx.webkit.internal.WebViewFeatureInternal.REQUESTED_WITH_HEADER_CONTROL.isSupportedByWebView()) {
            getAdapter(webSettings).setRequestedWithHeaderMode(i);
            return;
        }
        throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static int getRequestedWithHeaderMode(android.webkit.WebSettings webSettings) {
        if (androidx.webkit.internal.WebViewFeatureInternal.REQUESTED_WITH_HEADER_CONTROL.isSupportedByWebView()) {
            return getAdapter(webSettings).getRequestedWithHeaderMode();
        }
        throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setEnterpriseAuthenticationAppLinkPolicyEnabled(android.webkit.WebSettings webSettings, boolean z) {
        if (androidx.webkit.internal.WebViewFeatureInternal.ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY.isSupportedByWebView()) {
            getAdapter(webSettings).setEnterpriseAuthenticationAppLinkPolicyEnabled(z);
            return;
        }
        throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static boolean getEnterpriseAuthenticationAppLinkPolicyEnabled(android.webkit.WebSettings webSettings) {
        if (androidx.webkit.internal.WebViewFeatureInternal.ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY.isSupportedByWebView()) {
            return getAdapter(webSettings).getEnterpriseAuthenticationAppLinkPolicyEnabled();
        }
        throw androidx.webkit.internal.WebViewFeatureInternal.getUnsupportedOperationException();
    }

    private static androidx.webkit.internal.WebSettingsAdapter getAdapter(android.webkit.WebSettings webSettings) {
        return androidx.webkit.internal.WebViewGlueCommunicator.getCompatConverter().convertSettings(webSettings);
    }
}
