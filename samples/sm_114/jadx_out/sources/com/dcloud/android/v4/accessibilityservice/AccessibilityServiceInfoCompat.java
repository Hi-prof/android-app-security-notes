package com.dcloud.android.v4.accessibilityservice;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AccessibilityServiceInfoCompat {
    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int DEFAULT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;
    private static final com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl IMPL = new com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoJellyBeanMr2();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityServiceInfoIcsImpl extends com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl {
        AccessibilityServiceInfoIcsImpl() {
        }

        @Override // com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public boolean getCanRetrieveWindowContent(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
            return com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompatIcs.getCanRetrieveWindowContent(accessibilityServiceInfo);
        }

        @Override // com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public int getCapabilities(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
            return getCanRetrieveWindowContent(accessibilityServiceInfo) ? 1 : 0;
        }

        @Override // com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public java.lang.String getDescription(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
            return com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompatIcs.getDescription(accessibilityServiceInfo);
        }

        @Override // com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public java.lang.String getId(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
            return com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompatIcs.getId(accessibilityServiceInfo);
        }

        @Override // com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public android.content.pm.ResolveInfo getResolveInfo(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
            return com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompatIcs.getResolveInfo(accessibilityServiceInfo);
        }

        @Override // com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public java.lang.String getSettingsActivityName(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
            return com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompatIcs.getSettingsActivityName(accessibilityServiceInfo);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityServiceInfoJellyBeanMr2 extends com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoIcsImpl {
        AccessibilityServiceInfoJellyBeanMr2() {
        }

        @Override // com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoIcsImpl, com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public int getCapabilities(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
            return com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompatJellyBeanMr2.getCapabilities(accessibilityServiceInfo);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityServiceInfoStubImpl implements com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl {
        AccessibilityServiceInfoStubImpl() {
        }

        @Override // com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public boolean getCanRetrieveWindowContent(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
            return false;
        }

        @Override // com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public int getCapabilities(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
            return 0;
        }

        @Override // com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public java.lang.String getDescription(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }

        @Override // com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public java.lang.String getId(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }

        @Override // com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public android.content.pm.ResolveInfo getResolveInfo(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }

        @Override // com.dcloud.android.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public java.lang.String getSettingsActivityName(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface AccessibilityServiceInfoVersionImpl {
        boolean getCanRetrieveWindowContent(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo);

        int getCapabilities(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo);

        java.lang.String getDescription(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo);

        java.lang.String getId(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo);

        android.content.pm.ResolveInfo getResolveInfo(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo);

        java.lang.String getSettingsActivityName(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo);
    }

    private AccessibilityServiceInfoCompat() {
    }

    public static java.lang.String capabilityToString(int i) {
        if (i == 1) {
            return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
        }
        if (i == 2) {
            return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
        }
        if (i != 4) {
            return i != 8 ? "UNKNOWN" : "CAPABILITY_CAN_FILTER_KEY_EVENTS";
        }
        return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
    }

    public static java.lang.String feedbackTypeToString(int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
        while (i > 0) {
            int iNumberOfTrailingZeros = 1 << java.lang.Integer.numberOfTrailingZeros(i);
            i &= ~iNumberOfTrailingZeros;
            if (sb.length() > 1) {
                sb.append(", ");
            }
            if (iNumberOfTrailingZeros == 1) {
                sb.append("FEEDBACK_SPOKEN");
            } else if (iNumberOfTrailingZeros == 2) {
                sb.append("FEEDBACK_HAPTIC");
            } else if (iNumberOfTrailingZeros == 4) {
                sb.append("FEEDBACK_AUDIBLE");
            } else if (iNumberOfTrailingZeros == 8) {
                sb.append("FEEDBACK_VISUAL");
            } else if (iNumberOfTrailingZeros == 16) {
                sb.append("FEEDBACK_GENERIC");
            }
        }
        sb.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        return sb.toString();
    }

    public static java.lang.String flagToString(int i) {
        if (i == 1) {
            return "DEFAULT";
        }
        if (i == 2) {
            return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
        }
        if (i == 4) {
            return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
        }
        if (i == 8) {
            return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
        }
        if (i == 16) {
            return "FLAG_REPORT_VIEW_IDS";
        }
        if (i != 32) {
            return null;
        }
        return "FLAG_REQUEST_FILTER_KEY_EVENTS";
    }

    public static boolean getCanRetrieveWindowContent(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getCanRetrieveWindowContent(accessibilityServiceInfo);
    }

    public static int getCapabilities(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getCapabilities(accessibilityServiceInfo);
    }

    public static java.lang.String getDescription(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getDescription(accessibilityServiceInfo);
    }

    public static java.lang.String getId(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getId(accessibilityServiceInfo);
    }

    public static android.content.pm.ResolveInfo getResolveInfo(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getResolveInfo(accessibilityServiceInfo);
    }

    public static java.lang.String getSettingsActivityName(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getSettingsActivityName(accessibilityServiceInfo);
    }
}
