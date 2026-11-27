package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class RuningAcitvityUtil {
    private static java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<android.app.Activity>> RuningActivitys = new java.util.HashMap<>();
    public static boolean isRuningActivity = false;

    public static void StartActivity(android.content.Context context, android.content.Intent intent) {
        android.content.Intent intent2 = new android.content.Intent(intent);
        intent2.setAction("android.intent.action.VIEW");
        context.startActivity(intent2);
    }

    public static android.app.Activity getActivity(java.lang.String str) {
        java.lang.ref.WeakReference<android.app.Activity> weakReference;
        if (!RuningActivitys.containsKey(str) || (weakReference = RuningActivitys.get(str)) == null) {
            return null;
        }
        return weakReference.get();
    }

    public static java.lang.String getAppName(android.content.Context context) {
        return io.dcloud.common.util.ProcessUtil.getCurrentProcessName(context);
    }

    public static android.app.Activity getTopRuningActivity(android.app.Activity activity) {
        android.app.Activity activity2;
        android.app.Activity activity3 = io.dcloud.application.DCLoudApplicationImpl.self().topActivity;
        if (activity3 != null) {
            java.lang.String localClassName = activity3.getLocalClassName();
            if (RuningActivitys.containsKey(localClassName)) {
                java.lang.ref.WeakReference<android.app.Activity> weakReference = RuningActivitys.get(localClassName);
                if (weakReference != null) {
                    return weakReference.get();
                }
            } else if ("com.g.gysdk.view.ELoginActivity".equals(localClassName) && (activity2 = io.dcloud.application.DCLoudApplicationImpl.self().topActiveMap.get(localClassName).get()) != null) {
                return activity2;
            }
        }
        return activity;
    }

    public static boolean isRunningProcess(android.content.Context context, java.lang.String str) {
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        if (activityManager != null && !android.text.TextUtils.isEmpty(str) && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            java.util.Iterator<android.app.ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                if (android.text.TextUtils.equals(it.next().processName, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void putRuningActivity(android.app.Activity activity) {
        java.lang.String className = activity.getComponentName().getClassName();
        if (RuningActivitys.containsKey(className)) {
            return;
        }
        RuningActivitys.put(className, new java.lang.ref.WeakReference<>(activity));
    }

    public static void removeRuningActivity(java.lang.String str) {
        if (RuningActivitys.containsKey(str)) {
            RuningActivitys.remove(str);
        }
    }
}
