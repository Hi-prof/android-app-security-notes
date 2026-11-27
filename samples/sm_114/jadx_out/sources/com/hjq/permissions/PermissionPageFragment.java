package com.hjq.permissions;

/* JADX INFO: loaded from: classes.dex */
public final class PermissionPageFragment extends android.app.Fragment implements java.lang.Runnable {
    private static final java.lang.String REQUEST_PERMISSIONS = "request_permissions";
    private com.hjq.permissions.OnPermissionPageCallback mCallBack;
    private boolean mRequestFlag;
    private boolean mStartActivityFlag;

    public static void launch(android.app.Activity activity, java.util.List<java.lang.String> list, com.hjq.permissions.OnPermissionPageCallback onPermissionPageCallback) {
        com.hjq.permissions.PermissionPageFragment permissionPageFragment = new com.hjq.permissions.PermissionPageFragment();
        android.os.Bundle bundle = new android.os.Bundle();
        if (list instanceof java.util.ArrayList) {
            bundle.putStringArrayList(REQUEST_PERMISSIONS, (java.util.ArrayList) list);
        } else {
            bundle.putStringArrayList(REQUEST_PERMISSIONS, new java.util.ArrayList<>(list));
        }
        permissionPageFragment.setArguments(bundle);
        permissionPageFragment.setRetainInstance(true);
        permissionPageFragment.setRequestFlag(true);
        permissionPageFragment.setOnPermissionPageCallback(onPermissionPageCallback);
        permissionPageFragment.attachByActivity(activity);
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

    public void setOnPermissionPageCallback(com.hjq.permissions.OnPermissionPageCallback onPermissionPageCallback) {
        this.mCallBack = onPermissionPageCallback;
    }

    public void setRequestFlag(boolean z) {
        this.mRequestFlag = z;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.mRequestFlag) {
            detachByActivity(getActivity());
            return;
        }
        if (this.mStartActivityFlag) {
            return;
        }
        this.mStartActivityFlag = true;
        android.os.Bundle arguments = getArguments();
        android.app.Activity activity = getActivity();
        if (arguments == null || activity == null) {
            return;
        }
        com.hjq.permissions.StartActivityManager.startActivityForResult(this, com.hjq.permissions.PermissionUtils.getSmartPermissionIntent(getActivity(), arguments.getStringArrayList(REQUEST_PERMISSIONS)), 1025);
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        java.util.ArrayList<java.lang.String> stringArrayList;
        if (i != 1025) {
            return;
        }
        android.app.Activity activity = getActivity();
        android.os.Bundle arguments = getArguments();
        if (activity == null || arguments == null || (stringArrayList = arguments.getStringArrayList(REQUEST_PERMISSIONS)) == null || stringArrayList.isEmpty()) {
            return;
        }
        com.hjq.permissions.PermissionUtils.postActivityResult(stringArrayList, this);
    }

    @Override // java.lang.Runnable
    public void run() {
        android.app.Activity activity;
        if (isAdded() && (activity = getActivity()) != null) {
            com.hjq.permissions.OnPermissionPageCallback onPermissionPageCallback = this.mCallBack;
            this.mCallBack = null;
            if (onPermissionPageCallback == null) {
                detachByActivity(activity);
                return;
            }
            java.util.ArrayList<java.lang.String> stringArrayList = getArguments().getStringArrayList(REQUEST_PERMISSIONS);
            if (stringArrayList == null || stringArrayList.isEmpty()) {
                return;
            }
            if (com.hjq.permissions.PermissionApi.getGrantedPermissions(activity, stringArrayList).size() == stringArrayList.size()) {
                onPermissionPageCallback.onGranted();
            } else {
                onPermissionPageCallback.onDenied();
            }
            detachByActivity(activity);
        }
    }
}
