package com.facebook.common.activitylistener;

/* JADX INFO: loaded from: classes.dex */
public class ActivityListenerManager {
    public static void register(com.facebook.common.activitylistener.ActivityListener activityListener, android.content.Context context) {
        com.facebook.common.activitylistener.ListenableActivity listenableActivity = getListenableActivity(context);
        if (listenableActivity != null) {
            listenableActivity.addActivityListener(new com.facebook.common.activitylistener.ActivityListenerManager.Listener(activityListener));
        }
    }

    @javax.annotation.Nullable
    public static com.facebook.common.activitylistener.ListenableActivity getListenableActivity(android.content.Context context) {
        boolean z = context instanceof com.facebook.common.activitylistener.ListenableActivity;
        java.lang.Object baseContext = context;
        if (!z && (context instanceof android.content.ContextWrapper)) {
            baseContext = context;
            baseContext = ((android.content.ContextWrapper) context).getBaseContext();
        }
        baseContext = context;
        if (baseContext instanceof com.facebook.common.activitylistener.ListenableActivity) {
            return (com.facebook.common.activitylistener.ListenableActivity) baseContext;
        }
        return null;
    }

    private static class Listener extends com.facebook.common.activitylistener.BaseActivityListener {
        private final java.lang.ref.WeakReference<com.facebook.common.activitylistener.ActivityListener> mActivityListenerRef;

        public Listener(com.facebook.common.activitylistener.ActivityListener activityListener) {
            this.mActivityListenerRef = new java.lang.ref.WeakReference<>(activityListener);
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onActivityCreate(android.app.Activity activity) {
            com.facebook.common.activitylistener.ActivityListener listenerOrCleanUp = getListenerOrCleanUp(activity);
            if (listenerOrCleanUp != null) {
                listenerOrCleanUp.onActivityCreate(activity);
            }
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onDestroy(android.app.Activity activity) {
            com.facebook.common.activitylistener.ActivityListener listenerOrCleanUp = getListenerOrCleanUp(activity);
            if (listenerOrCleanUp != null) {
                listenerOrCleanUp.onDestroy(activity);
            }
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onStart(android.app.Activity activity) {
            com.facebook.common.activitylistener.ActivityListener listenerOrCleanUp = getListenerOrCleanUp(activity);
            if (listenerOrCleanUp != null) {
                listenerOrCleanUp.onStart(activity);
            }
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onStop(android.app.Activity activity) {
            com.facebook.common.activitylistener.ActivityListener listenerOrCleanUp = getListenerOrCleanUp(activity);
            if (listenerOrCleanUp != null) {
                listenerOrCleanUp.onStop(activity);
            }
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onResume(android.app.Activity activity) {
            com.facebook.common.activitylistener.ActivityListener listenerOrCleanUp = getListenerOrCleanUp(activity);
            if (listenerOrCleanUp != null) {
                listenerOrCleanUp.onResume(activity);
            }
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onPause(android.app.Activity activity) {
            com.facebook.common.activitylistener.ActivityListener listenerOrCleanUp = getListenerOrCleanUp(activity);
            if (listenerOrCleanUp != null) {
                listenerOrCleanUp.onPause(activity);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @javax.annotation.Nullable
        private com.facebook.common.activitylistener.ActivityListener getListenerOrCleanUp(android.app.Activity activity) {
            com.facebook.common.activitylistener.ActivityListener activityListener = this.mActivityListenerRef.get();
            if (activityListener == null) {
                com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(activity instanceof com.facebook.common.activitylistener.ListenableActivity));
                ((com.facebook.common.activitylistener.ListenableActivity) activity).removeActivityListener(this);
            }
            return activityListener;
        }
    }
}
