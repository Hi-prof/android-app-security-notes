package com.hjq.permissions;

/* JADX INFO: loaded from: classes.dex */
public final class PermissionFragment extends android.app.Fragment implements java.lang.Runnable {
    private static final java.lang.String REQUEST_CODE = "request_code";
    private static final java.util.List<java.lang.Integer> REQUEST_CODE_ARRAY = new java.util.ArrayList();
    private static final java.lang.String REQUEST_PERMISSIONS = "request_permissions";
    private com.hjq.permissions.OnPermissionCallback mCallBack;
    private boolean mDangerousRequest;
    private com.hjq.permissions.OnPermissionInterceptor mInterceptor;
    private boolean mRequestFlag;
    private int mScreenOrientation;
    private boolean mSpecialRequest;

    public static void launch(android.app.Activity activity, java.util.List<java.lang.String> list, com.hjq.permissions.OnPermissionInterceptor onPermissionInterceptor, com.hjq.permissions.OnPermissionCallback onPermissionCallback) {
        int iNextInt;
        java.util.List<java.lang.Integer> list2;
        com.hjq.permissions.PermissionFragment permissionFragment = new com.hjq.permissions.PermissionFragment();
        java.util.Random random = new java.util.Random();
        do {
            iNextInt = random.nextInt((int) java.lang.Math.pow(2.0d, 8.0d));
            list2 = REQUEST_CODE_ARRAY;
        } while (list2.contains(java.lang.Integer.valueOf(iNextInt)));
        list2.add(java.lang.Integer.valueOf(iNextInt));
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt(REQUEST_CODE, iNextInt);
        if (list instanceof java.util.ArrayList) {
            bundle.putStringArrayList(REQUEST_PERMISSIONS, (java.util.ArrayList) list);
        } else {
            bundle.putStringArrayList(REQUEST_PERMISSIONS, new java.util.ArrayList<>(list));
        }
        permissionFragment.setArguments(bundle);
        permissionFragment.setRetainInstance(true);
        permissionFragment.setRequestFlag(true);
        permissionFragment.setOnPermissionCallback(onPermissionCallback);
        permissionFragment.setOnPermissionInterceptor(onPermissionInterceptor);
        permissionFragment.attachByActivity(activity);
    }

    public void attachByActivity(android.app.Activity activity) {
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        fragmentManager.beginTransaction().add(this, toString()).commitAllowingStateLoss();
    }

    public void detachByActivity(android.app.Activity activity) {
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        fragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();
    }

    public void setOnPermissionCallback(com.hjq.permissions.OnPermissionCallback onPermissionCallback) {
        this.mCallBack = onPermissionCallback;
    }

    public void setRequestFlag(boolean z) {
        this.mRequestFlag = z;
    }

    public void setOnPermissionInterceptor(com.hjq.permissions.OnPermissionInterceptor onPermissionInterceptor) {
        this.mInterceptor = onPermissionInterceptor;
    }

    @Override // android.app.Fragment
    public void onAttach(android.content.Context context) {
        super.onAttach(context);
        android.app.Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        int requestedOrientation = activity.getRequestedOrientation();
        this.mScreenOrientation = requestedOrientation;
        if (requestedOrientation != -1) {
            return;
        }
        com.hjq.permissions.PermissionUtils.lockActivityOrientation(activity);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        android.app.Activity activity = getActivity();
        if (activity == null || this.mScreenOrientation != -1 || activity.getRequestedOrientation() == -1) {
            return;
        }
        activity.setRequestedOrientation(-1);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mCallBack = null;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.mRequestFlag) {
            detachByActivity(getActivity());
        } else {
            if (this.mSpecialRequest) {
                return;
            }
            this.mSpecialRequest = true;
            requestSpecialPermission();
        }
    }

    public void requestSpecialPermission() {
        java.util.ArrayList<java.lang.String> stringArrayList;
        android.os.Bundle arguments = getArguments();
        android.app.Activity activity = getActivity();
        if (arguments == null || activity == null || (stringArrayList = arguments.getStringArrayList(REQUEST_PERMISSIONS)) == null || stringArrayList.isEmpty()) {
            return;
        }
        boolean z = false;
        for (java.lang.String str : stringArrayList) {
            if (com.hjq.permissions.PermissionApi.isSpecialPermission(str) && !com.hjq.permissions.PermissionApi.isGrantedPermission(activity, str) && (com.hjq.permissions.AndroidVersion.isAndroid11() || !com.hjq.permissions.PermissionUtils.equalsPermission(str, com.hjq.permissions.Permission.MANAGE_EXTERNAL_STORAGE))) {
                com.hjq.permissions.StartActivityManager.startActivityForResult(this, com.hjq.permissions.PermissionUtils.getSmartPermissionIntent(activity, com.hjq.permissions.PermissionUtils.asArrayList(str)), getArguments().getInt(REQUEST_CODE));
                z = true;
            }
        }
        if (z) {
            return;
        }
        requestDangerousPermission();
    }

    public void requestDangerousPermission() {
        android.app.Activity activity = getActivity();
        android.os.Bundle arguments = getArguments();
        if (activity == null || arguments == null) {
            return;
        }
        int i = arguments.getInt(REQUEST_CODE);
        java.util.ArrayList<java.lang.String> stringArrayList = arguments.getStringArrayList(REQUEST_PERMISSIONS);
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            return;
        }
        if (!com.hjq.permissions.AndroidVersion.isAndroid6()) {
            int size = stringArrayList.size();
            int[] iArr = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = com.hjq.permissions.PermissionApi.isGrantedPermission(activity, stringArrayList.get(i2)) ? 0 : -1;
            }
            onRequestPermissionsResult(i, (java.lang.String[]) stringArrayList.toArray(new java.lang.String[0]), iArr);
            return;
        }
        if (com.hjq.permissions.AndroidVersion.isAndroid13() && stringArrayList.size() >= 2 && com.hjq.permissions.PermissionUtils.containsPermission(stringArrayList, com.hjq.permissions.Permission.BODY_SENSORS_BACKGROUND)) {
            java.util.ArrayList arrayList = new java.util.ArrayList(stringArrayList);
            arrayList.remove(com.hjq.permissions.Permission.BODY_SENSORS_BACKGROUND);
            splitTwiceRequestPermission(activity, stringArrayList, arrayList, i);
            return;
        }
        if (com.hjq.permissions.AndroidVersion.isAndroid10() && stringArrayList.size() >= 2 && com.hjq.permissions.PermissionUtils.containsPermission(stringArrayList, com.hjq.permissions.Permission.ACCESS_BACKGROUND_LOCATION)) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList(stringArrayList);
            arrayList2.remove(com.hjq.permissions.Permission.ACCESS_BACKGROUND_LOCATION);
            splitTwiceRequestPermission(activity, stringArrayList, arrayList2, i);
        } else {
            if (com.hjq.permissions.AndroidVersion.isAndroid10() && com.hjq.permissions.PermissionUtils.containsPermission(stringArrayList, com.hjq.permissions.Permission.ACCESS_MEDIA_LOCATION) && com.hjq.permissions.PermissionUtils.containsPermission(stringArrayList, com.hjq.permissions.Permission.READ_EXTERNAL_STORAGE)) {
                java.util.ArrayList arrayList3 = new java.util.ArrayList(stringArrayList);
                arrayList3.remove(com.hjq.permissions.Permission.ACCESS_MEDIA_LOCATION);
                splitTwiceRequestPermission(activity, stringArrayList, arrayList3, i);
                return;
            }
            requestPermissions((java.lang.String[]) stringArrayList.toArray(new java.lang.String[stringArrayList.size() - 1]), i);
        }
    }

    public void splitTwiceRequestPermission(android.app.Activity activity, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2, int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        java.util.Iterator<java.lang.String> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.remove(it.next());
        }
        launch(activity, list2, new com.hjq.permissions.OnPermissionInterceptor() { // from class: com.hjq.permissions.PermissionFragment.1
            @Override // com.hjq.permissions.OnPermissionInterceptor
            public /* synthetic */ void deniedPermissionRequest(android.app.Activity activity2, java.util.List list3, java.util.List list4, boolean z, com.hjq.permissions.OnPermissionCallback onPermissionCallback) {
                com.hjq.permissions.OnPermissionInterceptor.CC.$default$deniedPermissionRequest(this, activity2, list3, list4, z, onPermissionCallback);
            }

            @Override // com.hjq.permissions.OnPermissionInterceptor
            public /* synthetic */ void finishPermissionRequest(android.app.Activity activity2, java.util.List list3, boolean z, com.hjq.permissions.OnPermissionCallback onPermissionCallback) {
                com.hjq.permissions.OnPermissionInterceptor.CC.$default$finishPermissionRequest(this, activity2, list3, z, onPermissionCallback);
            }

            @Override // com.hjq.permissions.OnPermissionInterceptor
            public /* synthetic */ void grantedPermissionRequest(android.app.Activity activity2, java.util.List list3, java.util.List list4, boolean z, com.hjq.permissions.OnPermissionCallback onPermissionCallback) {
                com.hjq.permissions.OnPermissionInterceptor.CC.$default$grantedPermissionRequest(this, activity2, list3, list4, z, onPermissionCallback);
            }

            @Override // com.hjq.permissions.OnPermissionInterceptor
            public /* synthetic */ void launchPermissionRequest(android.app.Activity activity2, java.util.List list3, com.hjq.permissions.OnPermissionCallback onPermissionCallback) {
                com.hjq.permissions.PermissionFragment.launch(activity2, list3, this, onPermissionCallback);
            }
        }, new com.hjq.permissions.PermissionFragment.AnonymousClass2(activity, arrayList, list, i));
    }

    /* JADX INFO: renamed from: com.hjq.permissions.PermissionFragment$2, reason: invalid class name */
    class AnonymousClass2 implements com.hjq.permissions.OnPermissionCallback {
        final /* synthetic */ android.app.Activity val$activity;
        final /* synthetic */ java.util.List val$allPermissions;
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ java.util.ArrayList val$secondPermissions;

        AnonymousClass2(android.app.Activity activity, java.util.ArrayList arrayList, java.util.List list, int i) {
            this.val$activity = activity;
            this.val$secondPermissions = arrayList;
            this.val$allPermissions = list;
            this.val$requestCode = i;
        }

        @Override // com.hjq.permissions.OnPermissionCallback
        public void onGranted(java.util.List<java.lang.String> list, boolean z) {
            if (z && com.hjq.permissions.PermissionFragment.this.isAdded()) {
                long j = com.hjq.permissions.AndroidVersion.isAndroid13() ? 150L : 0L;
                final android.app.Activity activity = this.val$activity;
                final java.util.ArrayList arrayList = this.val$secondPermissions;
                final java.util.List list2 = this.val$allPermissions;
                final int i = this.val$requestCode;
                com.hjq.permissions.PermissionUtils.postDelayed(new java.lang.Runnable() { // from class: com.hjq.permissions.PermissionFragment$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m398lambda$onGranted$0$comhjqpermissionsPermissionFragment$2(activity, arrayList, list2, i);
                    }
                }, j);
            }
        }

        /* JADX INFO: renamed from: lambda$onGranted$0$com-hjq-permissions-PermissionFragment$2, reason: not valid java name */
        /* synthetic */ void m398lambda$onGranted$0$comhjqpermissionsPermissionFragment$2(android.app.Activity activity, final java.util.ArrayList arrayList, final java.util.List list, final int i) {
            com.hjq.permissions.PermissionFragment.launch(activity, arrayList, new com.hjq.permissions.OnPermissionInterceptor() { // from class: com.hjq.permissions.PermissionFragment.2.1
                @Override // com.hjq.permissions.OnPermissionInterceptor
                public /* synthetic */ void deniedPermissionRequest(android.app.Activity activity2, java.util.List list2, java.util.List list3, boolean z, com.hjq.permissions.OnPermissionCallback onPermissionCallback) {
                    com.hjq.permissions.OnPermissionInterceptor.CC.$default$deniedPermissionRequest(this, activity2, list2, list3, z, onPermissionCallback);
                }

                @Override // com.hjq.permissions.OnPermissionInterceptor
                public /* synthetic */ void finishPermissionRequest(android.app.Activity activity2, java.util.List list2, boolean z, com.hjq.permissions.OnPermissionCallback onPermissionCallback) {
                    com.hjq.permissions.OnPermissionInterceptor.CC.$default$finishPermissionRequest(this, activity2, list2, z, onPermissionCallback);
                }

                @Override // com.hjq.permissions.OnPermissionInterceptor
                public /* synthetic */ void grantedPermissionRequest(android.app.Activity activity2, java.util.List list2, java.util.List list3, boolean z, com.hjq.permissions.OnPermissionCallback onPermissionCallback) {
                    com.hjq.permissions.OnPermissionInterceptor.CC.$default$grantedPermissionRequest(this, activity2, list2, list3, z, onPermissionCallback);
                }

                @Override // com.hjq.permissions.OnPermissionInterceptor
                public /* synthetic */ void launchPermissionRequest(android.app.Activity activity2, java.util.List list2, com.hjq.permissions.OnPermissionCallback onPermissionCallback) {
                    com.hjq.permissions.PermissionFragment.launch(activity2, list2, this, onPermissionCallback);
                }
            }, new com.hjq.permissions.OnPermissionCallback() { // from class: com.hjq.permissions.PermissionFragment.2.2
                @Override // com.hjq.permissions.OnPermissionCallback
                public void onGranted(java.util.List<java.lang.String> list2, boolean z) {
                    if (z && com.hjq.permissions.PermissionFragment.this.isAdded()) {
                        int[] iArr = new int[list.size()];
                        java.util.Arrays.fill(iArr, 0);
                        com.hjq.permissions.PermissionFragment.this.onRequestPermissionsResult(i, (java.lang.String[]) list.toArray(new java.lang.String[0]), iArr);
                    }
                }

                @Override // com.hjq.permissions.OnPermissionCallback
                public void onDenied(java.util.List<java.lang.String> list2, boolean z) {
                    if (com.hjq.permissions.PermissionFragment.this.isAdded()) {
                        int[] iArr = new int[list.size()];
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            iArr[i2] = com.hjq.permissions.PermissionUtils.containsPermission(arrayList, (java.lang.String) list.get(i2)) ? -1 : 0;
                        }
                        com.hjq.permissions.PermissionFragment.this.onRequestPermissionsResult(i, (java.lang.String[]) list.toArray(new java.lang.String[0]), iArr);
                    }
                }
            });
        }

        @Override // com.hjq.permissions.OnPermissionCallback
        public void onDenied(java.util.List<java.lang.String> list, boolean z) {
            if (com.hjq.permissions.PermissionFragment.this.isAdded()) {
                int[] iArr = new int[this.val$allPermissions.size()];
                java.util.Arrays.fill(iArr, -1);
                com.hjq.permissions.PermissionFragment.this.onRequestPermissionsResult(this.val$requestCode, (java.lang.String[]) this.val$allPermissions.toArray(new java.lang.String[0]), iArr);
            }
        }
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            return;
        }
        android.os.Bundle arguments = getArguments();
        android.app.Activity activity = getActivity();
        if (activity == null || arguments == null || this.mInterceptor == null || i != arguments.getInt(REQUEST_CODE)) {
            return;
        }
        com.hjq.permissions.OnPermissionCallback onPermissionCallback = this.mCallBack;
        this.mCallBack = null;
        com.hjq.permissions.OnPermissionInterceptor onPermissionInterceptor = this.mInterceptor;
        this.mInterceptor = null;
        com.hjq.permissions.PermissionUtils.optimizePermissionResults(activity, strArr, iArr);
        java.util.ArrayList arrayListAsArrayList = com.hjq.permissions.PermissionUtils.asArrayList(strArr);
        REQUEST_CODE_ARRAY.remove(java.lang.Integer.valueOf(i));
        detachByActivity(activity);
        java.util.List<java.lang.String> grantedPermissions = com.hjq.permissions.PermissionApi.getGrantedPermissions(arrayListAsArrayList, iArr);
        if (grantedPermissions.size() == arrayListAsArrayList.size()) {
            onPermissionInterceptor.grantedPermissionRequest(activity, arrayListAsArrayList, grantedPermissions, true, onPermissionCallback);
            onPermissionInterceptor.finishPermissionRequest(activity, arrayListAsArrayList, false, onPermissionCallback);
            return;
        }
        java.util.List<java.lang.String> deniedPermissions = com.hjq.permissions.PermissionApi.getDeniedPermissions(arrayListAsArrayList, iArr);
        onPermissionInterceptor.deniedPermissionRequest(activity, arrayListAsArrayList, deniedPermissions, com.hjq.permissions.PermissionApi.isDoNotAskAgainPermissions(activity, deniedPermissions), onPermissionCallback);
        if (!grantedPermissions.isEmpty()) {
            onPermissionInterceptor.grantedPermissionRequest(activity, arrayListAsArrayList, grantedPermissions, false, onPermissionCallback);
        }
        onPermissionInterceptor.finishPermissionRequest(activity, arrayListAsArrayList, false, onPermissionCallback);
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        java.util.ArrayList<java.lang.String> stringArrayList;
        android.app.Activity activity = getActivity();
        android.os.Bundle arguments = getArguments();
        if (activity == null || arguments == null || this.mDangerousRequest || i != arguments.getInt(REQUEST_CODE) || (stringArrayList = arguments.getStringArrayList(REQUEST_PERMISSIONS)) == null || stringArrayList.isEmpty()) {
            return;
        }
        this.mDangerousRequest = true;
        com.hjq.permissions.PermissionUtils.postActivityResult(stringArrayList, this);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isAdded()) {
            requestDangerousPermission();
        }
    }
}
