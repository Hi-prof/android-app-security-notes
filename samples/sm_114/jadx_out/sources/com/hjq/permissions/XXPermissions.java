package com.hjq.permissions;

/* JADX INFO: loaded from: classes.dex */
public final class XXPermissions {
    public static final int REQUEST_CODE = 1025;
    private static java.lang.Boolean sCheckMode;
    private static com.hjq.permissions.OnPermissionInterceptor sInterceptor;
    private java.lang.Boolean mCheckMode;
    private final android.content.Context mContext;
    private com.hjq.permissions.OnPermissionInterceptor mInterceptor;
    private final java.util.List<java.lang.String> mPermissions = new java.util.ArrayList();

    public static com.hjq.permissions.XXPermissions with(android.content.Context context) {
        return new com.hjq.permissions.XXPermissions(context);
    }

    public static com.hjq.permissions.XXPermissions with(android.app.Fragment fragment) {
        return with(fragment.getActivity());
    }

    public static com.hjq.permissions.XXPermissions with(androidx.fragment.app.Fragment fragment) {
        return with(fragment.getActivity());
    }

    public static void setCheckMode(boolean z) {
        sCheckMode = java.lang.Boolean.valueOf(z);
    }

    public static void setInterceptor(com.hjq.permissions.OnPermissionInterceptor onPermissionInterceptor) {
        sInterceptor = onPermissionInterceptor;
    }

    public static com.hjq.permissions.OnPermissionInterceptor getInterceptor() {
        if (sInterceptor == null) {
            sInterceptor = new com.hjq.permissions.OnPermissionInterceptor() { // from class: com.hjq.permissions.XXPermissions.1
                @Override // com.hjq.permissions.OnPermissionInterceptor
                public /* synthetic */ void deniedPermissionRequest(android.app.Activity activity, java.util.List list, java.util.List list2, boolean z, com.hjq.permissions.OnPermissionCallback onPermissionCallback) {
                    com.hjq.permissions.OnPermissionInterceptor.CC.$default$deniedPermissionRequest(this, activity, list, list2, z, onPermissionCallback);
                }

                @Override // com.hjq.permissions.OnPermissionInterceptor
                public /* synthetic */ void finishPermissionRequest(android.app.Activity activity, java.util.List list, boolean z, com.hjq.permissions.OnPermissionCallback onPermissionCallback) {
                    com.hjq.permissions.OnPermissionInterceptor.CC.$default$finishPermissionRequest(this, activity, list, z, onPermissionCallback);
                }

                @Override // com.hjq.permissions.OnPermissionInterceptor
                public /* synthetic */ void grantedPermissionRequest(android.app.Activity activity, java.util.List list, java.util.List list2, boolean z, com.hjq.permissions.OnPermissionCallback onPermissionCallback) {
                    com.hjq.permissions.OnPermissionInterceptor.CC.$default$grantedPermissionRequest(this, activity, list, list2, z, onPermissionCallback);
                }

                @Override // com.hjq.permissions.OnPermissionInterceptor
                public /* synthetic */ void launchPermissionRequest(android.app.Activity activity, java.util.List list, com.hjq.permissions.OnPermissionCallback onPermissionCallback) {
                    com.hjq.permissions.PermissionFragment.launch(activity, list, this, onPermissionCallback);
                }
            };
        }
        return sInterceptor;
    }

    private XXPermissions(android.content.Context context) {
        this.mContext = context;
    }

    public com.hjq.permissions.XXPermissions permission(java.lang.String str) {
        if (str == null || com.hjq.permissions.PermissionUtils.containsPermission(this.mPermissions, str)) {
            return this;
        }
        this.mPermissions.add(str);
        return this;
    }

    public com.hjq.permissions.XXPermissions permission(java.lang.String... strArr) {
        return permission(com.hjq.permissions.PermissionUtils.asArrayList(strArr));
    }

    public com.hjq.permissions.XXPermissions permission(java.lang.String[]... strArr) {
        return permission(com.hjq.permissions.PermissionUtils.asArrayLists(strArr));
    }

    public com.hjq.permissions.XXPermissions permission(java.util.List<java.lang.String> list) {
        if (list != null && !list.isEmpty()) {
            for (java.lang.String str : list) {
                if (!com.hjq.permissions.PermissionUtils.containsPermission(this.mPermissions, str)) {
                    this.mPermissions.add(str);
                }
            }
        }
        return this;
    }

    public com.hjq.permissions.XXPermissions interceptor(com.hjq.permissions.OnPermissionInterceptor onPermissionInterceptor) {
        this.mInterceptor = onPermissionInterceptor;
        return this;
    }

    public com.hjq.permissions.XXPermissions unchecked() {
        this.mCheckMode = false;
        return this;
    }

    public void request(com.hjq.permissions.OnPermissionCallback onPermissionCallback) {
        if (this.mContext == null) {
            return;
        }
        if (this.mInterceptor == null) {
            this.mInterceptor = getInterceptor();
        }
        android.content.Context context = this.mContext;
        com.hjq.permissions.OnPermissionInterceptor onPermissionInterceptor = this.mInterceptor;
        java.util.ArrayList arrayList = new java.util.ArrayList(this.mPermissions);
        boolean zIsCheckMode = isCheckMode(context);
        android.app.Activity activityFindActivity = com.hjq.permissions.PermissionUtils.findActivity(context);
        if (com.hjq.permissions.PermissionChecker.checkActivityStatus(activityFindActivity, zIsCheckMode) && com.hjq.permissions.PermissionChecker.checkPermissionArgument(arrayList, zIsCheckMode)) {
            if (zIsCheckMode) {
                com.hjq.permissions.AndroidManifestInfo androidManifestInfo = com.hjq.permissions.PermissionUtils.getAndroidManifestInfo(context);
                com.hjq.permissions.PermissionChecker.checkMediaLocationPermission(context, arrayList);
                com.hjq.permissions.PermissionChecker.checkStoragePermission(context, arrayList, androidManifestInfo);
                com.hjq.permissions.PermissionChecker.checkBodySensorsPermission(arrayList);
                com.hjq.permissions.PermissionChecker.checkLocationPermission(arrayList);
                com.hjq.permissions.PermissionChecker.checkPictureInPicturePermission(activityFindActivity, arrayList, androidManifestInfo);
                com.hjq.permissions.PermissionChecker.checkNotificationListenerPermission(arrayList, androidManifestInfo);
                com.hjq.permissions.PermissionChecker.checkNearbyDevicesPermission(arrayList, androidManifestInfo);
                com.hjq.permissions.PermissionChecker.checkReadMediaVisualUserSelectedPermission(arrayList);
                com.hjq.permissions.PermissionChecker.checkTargetSdkVersion(context, arrayList);
                com.hjq.permissions.PermissionChecker.checkManifestPermissions(context, arrayList, androidManifestInfo);
            }
            com.hjq.permissions.PermissionChecker.optimizeDeprecatedPermission(arrayList);
            if (!com.hjq.permissions.PermissionApi.isGrantedPermissions(context, arrayList)) {
                onPermissionInterceptor.launchPermissionRequest(activityFindActivity, arrayList, onPermissionCallback);
            } else if (onPermissionCallback != null) {
                onPermissionInterceptor.grantedPermissionRequest(activityFindActivity, arrayList, arrayList, true, onPermissionCallback);
                onPermissionInterceptor.finishPermissionRequest(activityFindActivity, arrayList, true, onPermissionCallback);
            }
        }
    }

    public boolean revokeOnKill() {
        android.content.Context context = this.mContext;
        if (context == null) {
            return false;
        }
        java.util.List<java.lang.String> list = this.mPermissions;
        if (list.isEmpty() || !com.hjq.permissions.AndroidVersion.isAndroid13()) {
            return false;
        }
        try {
            if (list.size() == 1) {
                context.revokeSelfPermissionOnKill(list.get(0));
            } else {
                context.revokeSelfPermissionsOnKill(list);
            }
            return true;
        } catch (java.lang.IllegalArgumentException e) {
            if (isCheckMode(context)) {
                throw e;
            }
            e.printStackTrace();
            return false;
        }
    }

    private boolean isCheckMode(android.content.Context context) {
        if (this.mCheckMode == null) {
            if (sCheckMode == null) {
                sCheckMode = java.lang.Boolean.valueOf(com.hjq.permissions.PermissionUtils.isDebugMode(context));
            }
            this.mCheckMode = sCheckMode;
        }
        return this.mCheckMode.booleanValue();
    }

    public static boolean isGranted(android.content.Context context, java.lang.String... strArr) {
        return isGranted(context, com.hjq.permissions.PermissionUtils.asArrayList(strArr));
    }

    public static boolean isGranted(android.content.Context context, java.lang.String[]... strArr) {
        return isGranted(context, com.hjq.permissions.PermissionUtils.asArrayLists(strArr));
    }

    public static boolean isGranted(android.content.Context context, java.util.List<java.lang.String> list) {
        return com.hjq.permissions.PermissionApi.isGrantedPermissions(context, list);
    }

    public static java.util.List<java.lang.String> getDenied(android.content.Context context, java.lang.String... strArr) {
        return getDenied(context, com.hjq.permissions.PermissionUtils.asArrayList(strArr));
    }

    public static java.util.List<java.lang.String> getDenied(android.content.Context context, java.lang.String[]... strArr) {
        return getDenied(context, com.hjq.permissions.PermissionUtils.asArrayLists(strArr));
    }

    public static java.util.List<java.lang.String> getDenied(android.content.Context context, java.util.List<java.lang.String> list) {
        return com.hjq.permissions.PermissionApi.getDeniedPermissions(context, list);
    }

    public static boolean isSpecial(java.lang.String str) {
        return com.hjq.permissions.PermissionApi.isSpecialPermission(str);
    }

    public static boolean containsSpecial(java.lang.String... strArr) {
        return containsSpecial(com.hjq.permissions.PermissionUtils.asArrayList(strArr));
    }

    public static boolean containsSpecial(java.util.List<java.lang.String> list) {
        return com.hjq.permissions.PermissionApi.containsSpecialPermission(list);
    }

    public static boolean isDoNotAskAgainPermissions(android.app.Activity activity, java.lang.String... strArr) {
        return isDoNotAskAgainPermissions(activity, com.hjq.permissions.PermissionUtils.asArrayList(strArr));
    }

    public static boolean isDoNotAskAgainPermissions(android.app.Activity activity, java.lang.String[]... strArr) {
        return isDoNotAskAgainPermissions(activity, com.hjq.permissions.PermissionUtils.asArrayLists(strArr));
    }

    public static boolean isDoNotAskAgainPermissions(android.app.Activity activity, java.util.List<java.lang.String> list) {
        return com.hjq.permissions.PermissionApi.isDoNotAskAgainPermissions(activity, list);
    }

    public static void startPermissionActivity(android.content.Context context) {
        startPermissionActivity(context, new java.util.ArrayList(0));
    }

    public static void startPermissionActivity(android.content.Context context, java.lang.String... strArr) {
        startPermissionActivity(context, com.hjq.permissions.PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(android.content.Context context, java.lang.String[]... strArr) {
        startPermissionActivity(context, com.hjq.permissions.PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(android.content.Context context, java.util.List<java.lang.String> list) {
        android.app.Activity activityFindActivity = com.hjq.permissions.PermissionUtils.findActivity(context);
        if (activityFindActivity != null) {
            startPermissionActivity(activityFindActivity, list);
            return;
        }
        android.content.Intent smartPermissionIntent = com.hjq.permissions.PermissionUtils.getSmartPermissionIntent(context, list);
        if (!(context instanceof android.app.Activity)) {
            smartPermissionIntent.addFlags(268435456);
        }
        com.hjq.permissions.StartActivityManager.startActivity(context, smartPermissionIntent);
    }

    public static void startPermissionActivity(android.app.Activity activity) {
        startPermissionActivity(activity, (java.util.List<java.lang.String>) new java.util.ArrayList(0));
    }

    public static void startPermissionActivity(android.app.Activity activity, java.lang.String... strArr) {
        startPermissionActivity(activity, (java.util.List<java.lang.String>) com.hjq.permissions.PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(android.app.Activity activity, java.lang.String[]... strArr) {
        startPermissionActivity(activity, (java.util.List<java.lang.String>) com.hjq.permissions.PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(android.app.Activity activity, java.util.List<java.lang.String> list) {
        startPermissionActivity(activity, list, 1025);
    }

    public static void startPermissionActivity(android.app.Activity activity, java.util.List<java.lang.String> list, int i) {
        com.hjq.permissions.StartActivityManager.startActivityForResult(activity, com.hjq.permissions.PermissionUtils.getSmartPermissionIntent(activity, list), i);
    }

    public static void startPermissionActivity(android.app.Activity activity, java.lang.String str, com.hjq.permissions.OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(activity, com.hjq.permissions.PermissionUtils.asArrayList(str), onPermissionPageCallback);
    }

    public static void startPermissionActivity(android.app.Activity activity, java.lang.String[] strArr, com.hjq.permissions.OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(activity, com.hjq.permissions.PermissionUtils.asArrayLists(strArr), onPermissionPageCallback);
    }

    public static void startPermissionActivity(android.app.Activity activity, java.util.List<java.lang.String> list, com.hjq.permissions.OnPermissionPageCallback onPermissionPageCallback) {
        if (list.isEmpty()) {
            com.hjq.permissions.StartActivityManager.startActivity(activity, com.hjq.permissions.PermissionIntentManager.getApplicationDetailsIntent(activity));
        } else {
            com.hjq.permissions.PermissionPageFragment.launch(activity, list, onPermissionPageCallback);
        }
    }

    public static void startPermissionActivity(android.app.Fragment fragment) {
        startPermissionActivity(fragment, new java.util.ArrayList(0));
    }

    public static void startPermissionActivity(android.app.Fragment fragment, java.lang.String... strArr) {
        startPermissionActivity(fragment, com.hjq.permissions.PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(android.app.Fragment fragment, java.lang.String[]... strArr) {
        startPermissionActivity(fragment, com.hjq.permissions.PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(android.app.Fragment fragment, java.util.List<java.lang.String> list) {
        startPermissionActivity(fragment, list, 1025);
    }

    public static void startPermissionActivity(android.app.Fragment fragment, java.util.List<java.lang.String> list, int i) {
        android.app.Activity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        if (list.isEmpty()) {
            com.hjq.permissions.StartActivityManager.startActivity(fragment, com.hjq.permissions.PermissionIntentManager.getApplicationDetailsIntent(activity));
        } else {
            com.hjq.permissions.StartActivityManager.startActivityForResult(fragment, com.hjq.permissions.PermissionUtils.getSmartPermissionIntent(activity, list), i);
        }
    }

    public static void startPermissionActivity(android.app.Fragment fragment, java.lang.String str, com.hjq.permissions.OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(fragment, com.hjq.permissions.PermissionUtils.asArrayList(str), onPermissionPageCallback);
    }

    public static void startPermissionActivity(android.app.Fragment fragment, java.lang.String[] strArr, com.hjq.permissions.OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(fragment, com.hjq.permissions.PermissionUtils.asArrayLists(strArr), onPermissionPageCallback);
    }

    public static void startPermissionActivity(android.app.Fragment fragment, java.util.List<java.lang.String> list, com.hjq.permissions.OnPermissionPageCallback onPermissionPageCallback) {
        android.app.Activity activity = fragment.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (com.hjq.permissions.AndroidVersion.isAndroid4_2() && activity.isDestroyed()) {
            return;
        }
        if (list.isEmpty()) {
            com.hjq.permissions.StartActivityManager.startActivity(fragment, com.hjq.permissions.PermissionIntentManager.getApplicationDetailsIntent(activity));
        } else {
            com.hjq.permissions.PermissionPageFragment.launch(activity, list, onPermissionPageCallback);
        }
    }

    public static void startPermissionActivity(androidx.fragment.app.Fragment fragment) {
        startPermissionActivity(fragment, new java.util.ArrayList());
    }

    public static void startPermissionActivity(androidx.fragment.app.Fragment fragment, java.lang.String... strArr) {
        startPermissionActivity(fragment, com.hjq.permissions.PermissionUtils.asArrayList(strArr));
    }

    public static void startPermissionActivity(androidx.fragment.app.Fragment fragment, java.lang.String[]... strArr) {
        startPermissionActivity(fragment, com.hjq.permissions.PermissionUtils.asArrayLists(strArr));
    }

    public static void startPermissionActivity(androidx.fragment.app.Fragment fragment, java.util.List<java.lang.String> list) {
        startPermissionActivity(fragment, list, 1025);
    }

    public static void startPermissionActivity(androidx.fragment.app.Fragment fragment, java.util.List<java.lang.String> list, int i) {
        androidx.fragment.app.FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return;
        }
        if (list.isEmpty()) {
            com.hjq.permissions.StartActivityManager.startActivity(fragment, com.hjq.permissions.PermissionIntentManager.getApplicationDetailsIntent(activity));
        } else {
            com.hjq.permissions.StartActivityManager.startActivityForResult(fragment, com.hjq.permissions.PermissionUtils.getSmartPermissionIntent(activity, list), i);
        }
    }

    public static void startPermissionActivity(androidx.fragment.app.Fragment fragment, java.lang.String str, com.hjq.permissions.OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(fragment, com.hjq.permissions.PermissionUtils.asArrayList(str), onPermissionPageCallback);
    }

    public static void startPermissionActivity(androidx.fragment.app.Fragment fragment, java.lang.String[] strArr, com.hjq.permissions.OnPermissionPageCallback onPermissionPageCallback) {
        startPermissionActivity(fragment, com.hjq.permissions.PermissionUtils.asArrayLists(strArr), onPermissionPageCallback);
    }

    public static void startPermissionActivity(androidx.fragment.app.Fragment fragment, java.util.List<java.lang.String> list, com.hjq.permissions.OnPermissionPageCallback onPermissionPageCallback) {
        androidx.fragment.app.FragmentActivity activity = fragment.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (com.hjq.permissions.AndroidVersion.isAndroid4_2() && activity.isDestroyed()) {
            return;
        }
        if (list.isEmpty()) {
            com.hjq.permissions.StartActivityManager.startActivity(fragment, com.hjq.permissions.PermissionIntentManager.getApplicationDetailsIntent(activity));
        } else {
            com.hjq.permissions.PermissionPageFragment.launch(activity, list, onPermissionPageCallback);
        }
    }
}
