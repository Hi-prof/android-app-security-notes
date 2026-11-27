package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class SP {
    public static final java.lang.String CHECK_PATH_STREAMAPP = "check_path_streamapp";
    public static final java.lang.String DARK_MODE_BUNDLE_FORMAT = "dc_dark_mode_";
    public static final java.lang.String DARK_MODE_KEY = "dark_mode";
    public static final java.lang.String IS_CREATE_SHORTCUT = "_is_create_shortcut";
    public static final java.lang.String K_COLLECTED = "_dpush_collected_";
    public static final java.lang.String K_CREATED_SHORTCUT = "_created_shortcut";
    public static final java.lang.String K_CREATE_SHORTCUT_NAME = "_create_shortcut_name";
    public static final java.lang.String K_DEVICE_DPUSH_UUID = "_dpush_uuid_";
    public static final java.lang.String K_LAST_POS = "_dpush_last_pos_";
    public static final java.lang.String K_SHORT_CUT_ONE_TIPS = "short_cut_one_tips";
    public static final java.lang.String K_SMART_UPDATE_NEED_UPDATE_ICON = "_smart_update_need_update_icon";
    public static final java.lang.String K_SMART_UPDATE_PACKAGE_DOWNLOAD_SUCCESS = "_smart_update_packge_success";
    public static final java.lang.String K_SMART_UPDATE_PARAMS = "_smart_update_need_update";
    public static final java.lang.String K_STORAGES_SHORTCUT = "SHORTCUT";
    public static final java.lang.String NEED_UPDATE_ICON = "_smart_update_need_update_icon";
    public static final java.lang.String N_BASE = "pdr";
    public static final java.lang.String N_DEVICE_INFO = "device_info";
    private static final java.lang.String N_SMART_UPDATE = "_smart_update";
    public static final java.lang.String N_STORAGES = "_storages";
    public static final java.lang.String RECORD_RUN_SHORT_CUT = "record_run_short_cut";
    public static final java.lang.String REPAIR_FIRST_SHORT_CUT = "repaid_first_short_cut";
    public static final java.lang.String REPORT_UNI_VERIFY_GYUID = "report_uni_verify_GYUID";
    public static final java.lang.String SMART_UPDATE = "pdr";
    public static final java.lang.String STAREMAPP_ALIYUN_SHORT_CUT = "_staremapp_aliyun_short_cut";
    public static final java.lang.String STAREMAPP_ALIYUN_SHORT_CUT_IS_FIRST_CREATED = "_staremapp_aliyun_short_cut_is_first_created";
    public static final java.lang.String STAREMAPP_FIRST_SHORT_CUT = "_staremapp_first_short_cut";
    public static final java.lang.String STAREMAPP_SHORTCUT_GUIDE_IS_FIRST_EMUI = "_staremapp_shortcut_guide_is_first_emui";
    public static final java.lang.String STAREMAPP_SHORTCUT_GUIDE_IS_FIRST_FLYME = "_staremapp_shortcut_guide_is_first_flyme";
    public static final java.lang.String STAREMAPP_SHORTCUT_GUIDE_IS_FIRST_MIUI = "_staremapp_shortcut_guide_is_first_miui";
    public static final java.lang.String STAREMAPP_SHORTCUT_GUIDE_IS_FIRST_VIVO = "_staremapp_shortcut_guide_is_first_vivo";
    public static final java.lang.String STAREMAPP_SHORTCUT_TIP_IS_FIRST = "_staremapp_shortcut_tip_is_first";
    public static final java.lang.String STARTUP_DEVICE_ID = "_deviceId";
    public static final java.lang.String STREAM_APP_NOT_FOUND_SPLASH_AT_SERVER = "_no_splash_at_server";
    public static final java.lang.String UNIMP_CUSTOM_OAID_SAVE_KEY = "unimp_custom_oaid_save_key";
    public static final java.lang.String UPDATE_PACKAGE_DOWNLOAD_SUCCESS = "_smart_update_packge_success";
    public static final java.lang.String UPDATE_PARAMS = "_smart_update_need_update";
    public static final java.lang.String UPDATE_SPLASH_AUTOCLOSE = "__update_splash_autoclose";
    public static final java.lang.String UPDATE_SPLASH_AUTOCLOSE_W2A = "__update_splash_autoclose_w2a";
    public static final java.lang.String UPDATE_SPLASH_DELAY = "__update_splash_delay";
    public static final java.lang.String UPDATE_SPLASH_DELAY_W2A = "__update_splash_delay_w2a";
    public static final java.lang.String UPDATE_SPLASH_IMG_PATH = "update_splash_img_path";
    public static final java.lang.String WELCOME_SPLASH_SHOW = "__welcome_splash_show";
    private static java.util.HashMap<java.lang.String, android.content.SharedPreferences> mBundles;

    public static void clearBundle(android.content.SharedPreferences sharedPreferences) {
        android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    @java.lang.Deprecated
    public static java.lang.String getBundleData(java.lang.String str, java.lang.String str2) {
        return getBundleData(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, str, str2, false);
    }

    public static android.content.SharedPreferences getOrCreateBundle(java.lang.String str, boolean z) {
        return getOrCreateBundle(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, str, z);
    }

    @java.lang.Deprecated
    public static java.lang.String getsBundleData(java.lang.String str, java.lang.String str2) {
        return getsBundleData(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, str, str2);
    }

    @java.lang.Deprecated
    public static io.dcloud.p.h4 getsOrCreateBundle(java.lang.String str) {
        return getsOrCreateBundle(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, str);
    }

    public static boolean hasChanged(android.content.Context context, java.lang.String str, boolean z) {
        android.content.SharedPreferences orCreateBundle = getOrCreateBundle(context, str, z);
        if (orCreateBundle instanceof io.dcloud.common.adapter.util.SharedPreferencesExt) {
            return ((io.dcloud.common.adapter.util.SharedPreferencesExt) orCreateBundle).hasChaged();
        }
        return true;
    }

    public static void removeBundleData(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.remove(str);
        editorEdit.commit();
    }

    public static void setBundleData(android.content.SharedPreferences sharedPreferences, java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    @java.lang.Deprecated
    public static void setsBundleData(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        setsBundleData(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, str, str2, str3);
    }

    public static java.lang.String getBundleData(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return getBundleData(context, str, str2, false);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x000e A[Catch: all -> 0x003c, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000a, B:10:0x000e, B:11:0x0016, B:13:0x0020, B:16:0x0029, B:17:0x002f, B:18:0x0033), top: B:26:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x0020 A[Catch: all -> 0x003c, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000a, B:10:0x000e, B:11:0x0016, B:13:0x0020, B:16:0x0029, B:17:0x002f, B:18:0x0033), top: B:26:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0027 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0029 A[Catch: all -> 0x003c, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000a, B:10:0x000e, B:11:0x0016, B:13:0x0020, B:16:0x0029, B:17:0x002f, B:18:0x0033), top: B:26:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x002f A[Catch: all -> 0x003c, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000a, B:10:0x000e, B:11:0x0016, B:13:0x0020, B:16:0x0029, B:17:0x002f, B:18:0x0033), top: B:26:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x003a A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x003a, please report this as an issue */
    public static synchronized android.content.SharedPreferences getOrCreateBundle(android.content.Context context, java.lang.String str, boolean z) {
        android.content.SharedPreferences sharedPreferences;
        android.content.SharedPreferences sharedPreferences2;
        if (context != null) {
            if (mBundles == null) {
                mBundles = new java.util.HashMap<>(1);
            }
            sharedPreferences = mBundles.get(str);
            if (sharedPreferences == null) {
                return sharedPreferences;
            }
            sharedPreferences2 = io.src.dcloud.adapter.DCloudAdapterUtil.getSharedPreferences(context, str, 0);
            if (sharedPreferences2 == null) {
                if (z) {
                    sharedPreferences2 = new io.dcloud.common.adapter.util.SharedPreferencesExt(context, str);
                } else {
                    sharedPreferences2 = context.getSharedPreferences(str, 0);
                }
            }
            mBundles.put(str, sharedPreferences2);
            return sharedPreferences2;
        }
        android.content.Context context2 = io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext;
        if (context2 != null) {
            context = context2;
        }
        if (mBundles == null) {
            mBundles = new java.util.HashMap<>(1);
        }
        sharedPreferences = mBundles.get(str);
        if (sharedPreferences == null) {
            return sharedPreferences;
        }
        sharedPreferences2 = io.src.dcloud.adapter.DCloudAdapterUtil.getSharedPreferences(context, str, 0);
        if (sharedPreferences2 == null) {
            if (z) {
                sharedPreferences2 = new io.dcloud.common.adapter.util.SharedPreferencesExt(context, str);
            } else {
                sharedPreferences2 = context.getSharedPreferences(str, 0);
            }
        }
        mBundles.put(str, sharedPreferences2);
        return sharedPreferences2;
        throw th;
    }

    public static java.lang.String getsBundleData(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return io.dcloud.p.h4.a(context, str).a(str2, "");
    }

    public static synchronized io.dcloud.p.h4 getsOrCreateBundle(android.content.Context context, java.lang.String str) {
        return io.dcloud.p.h4.a(context, str);
    }

    public static void setsBundleData(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        io.dcloud.p.h4.a(context, str).b(str2, str3);
    }

    @java.lang.Deprecated
    public static java.lang.String getBundleData(java.lang.String str, java.lang.String str2, boolean z) {
        return getBundleData(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, str, str2, z);
    }

    @java.lang.Deprecated
    public static void clearBundle(java.lang.String str) {
        clearBundle(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, str);
    }

    public static java.lang.String getBundleData(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z) {
        return getOrCreateBundle(context, str, z).getString(str2, "");
    }

    public static void removeBundleData(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z) {
        android.content.SharedPreferences.Editor editorEdit = getOrCreateBundle(context, str, z).edit();
        editorEdit.remove(str2);
        editorEdit.commit();
    }

    public static void setBundleData(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        android.content.Context context2;
        if (context == null && (context2 = io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext) != null) {
            context = context2;
        }
        android.content.SharedPreferences.Editor editorEdit = getOrCreateBundle(context, str, z).edit();
        editorEdit.putString(str2, str3);
        editorEdit.commit();
    }

    public static void clearBundle(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences.Editor editorEdit = getOrCreateBundle(context, str).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    public static java.lang.String getBundleData(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        return sharedPreferences.getString(str, "");
    }

    @java.lang.Deprecated
    public static void removeBundleData(java.lang.String str, java.lang.String str2) {
        removeBundleData(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, str, str2, false);
    }

    public static void removeBundleData(android.content.Context context, java.lang.String str, java.lang.String str2) {
        removeBundleData(context, str, str2, false);
    }

    @java.lang.Deprecated
    public static void setBundleData(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        setBundleData(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, str, str2, str3, false);
    }

    public static void setBundleData(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        setBundleData(context, str, str2, str3, false);
    }

    @java.lang.Deprecated
    public static android.content.SharedPreferences getOrCreateBundle(java.lang.String str) {
        return getOrCreateBundle(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, str, false);
    }

    public static android.content.SharedPreferences getOrCreateBundle(android.content.Context context, java.lang.String str) {
        return getOrCreateBundle(context, str, false);
    }
}
