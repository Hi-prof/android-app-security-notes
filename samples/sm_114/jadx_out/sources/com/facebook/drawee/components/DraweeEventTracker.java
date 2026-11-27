package com.facebook.drawee.components;

/* JADX INFO: loaded from: classes.dex */
public class DraweeEventTracker {
    private static final int MAX_EVENTS_TO_TRACK = 20;
    private final java.util.Queue<com.facebook.drawee.components.DraweeEventTracker.Event> mEventQueue = new java.util.concurrent.ArrayBlockingQueue(20);
    private static final com.facebook.drawee.components.DraweeEventTracker sInstance = new com.facebook.drawee.components.DraweeEventTracker();
    private static boolean sEnabled = true;

    public enum Event {
        ON_SET_HIERARCHY,
        ON_CLEAR_HIERARCHY,
        ON_SET_CONTROLLER,
        ON_CLEAR_OLD_CONTROLLER,
        ON_CLEAR_CONTROLLER,
        ON_INIT_CONTROLLER,
        ON_ATTACH_CONTROLLER,
        ON_DETACH_CONTROLLER,
        ON_RELEASE_CONTROLLER,
        ON_DATASOURCE_SUBMIT,
        ON_DATASOURCE_RESULT,
        ON_DATASOURCE_RESULT_INT,
        ON_DATASOURCE_FAILURE,
        ON_DATASOURCE_FAILURE_INT,
        ON_HOLDER_ATTACH,
        ON_HOLDER_DETACH,
        ON_DRAWABLE_SHOW,
        ON_DRAWABLE_HIDE,
        ON_ACTIVITY_START,
        ON_ACTIVITY_STOP,
        ON_RUN_CLEAR_CONTROLLER,
        ON_SCHEDULE_CLEAR_CONTROLLER,
        ON_SAME_CONTROLLER_SKIPPED,
        ON_SUBMIT_CACHE_HIT
    }

    private DraweeEventTracker() {
    }

    public static com.facebook.drawee.components.DraweeEventTracker newInstance() {
        return sEnabled ? new com.facebook.drawee.components.DraweeEventTracker() : sInstance;
    }

    public static void disable() {
        sEnabled = false;
    }

    public void recordEvent(com.facebook.drawee.components.DraweeEventTracker.Event event) {
        if (sEnabled) {
            for (int i = 5; !this.mEventQueue.offer(event) && i > 0; i--) {
                this.mEventQueue.poll();
            }
        }
    }

    public java.lang.String toString() {
        return this.mEventQueue.toString();
    }
}
