package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class FeatureMessageDispatcher {
    public static java.util.concurrent.CopyOnWriteArrayList<io.dcloud.common.DHInterface.FeatureMessageDispatcher.MessageListener> sFeatureMessage = new java.util.concurrent.CopyOnWriteArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    @java.lang.Deprecated
    public interface MessageListener {
        void onReceiver(java.lang.Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static abstract class StrongMessageListener implements io.dcloud.common.DHInterface.FeatureMessageDispatcher.MessageListener {
        java.lang.Object mFlag;

        public StrongMessageListener(java.lang.Object obj) {
            this.mFlag = obj;
        }

        @Override // io.dcloud.common.DHInterface.FeatureMessageDispatcher.MessageListener
        public abstract void onReceiver(java.lang.Object obj);
    }

    public static boolean contains(java.lang.Object obj) {
        try {
            for (io.dcloud.common.DHInterface.FeatureMessageDispatcher.MessageListener messageListener : sFeatureMessage) {
                if ((messageListener instanceof io.dcloud.common.DHInterface.FeatureMessageDispatcher.StrongMessageListener) && obj.equals(((io.dcloud.common.DHInterface.FeatureMessageDispatcher.StrongMessageListener) messageListener).mFlag)) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void dispatchMessage(java.lang.Object obj, final java.lang.Object obj2) {
        try {
            for (io.dcloud.common.DHInterface.FeatureMessageDispatcher.MessageListener messageListener : sFeatureMessage) {
                if (messageListener instanceof io.dcloud.common.DHInterface.FeatureMessageDispatcher.StrongMessageListener) {
                    if (obj.equals(((io.dcloud.common.DHInterface.FeatureMessageDispatcher.StrongMessageListener) messageListener).mFlag)) {
                        io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.common.DHInterface.FeatureMessageDispatcher.1
                            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
                            public void execute(java.lang.Object obj3) {
                                ((io.dcloud.common.DHInterface.FeatureMessageDispatcher.MessageListener) obj3).onReceiver(obj2);
                            }
                        }, messageListener);
                    }
                } else if (obj2 != null) {
                    io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.common.DHInterface.FeatureMessageDispatcher.2
                        @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
                        public void execute(java.lang.Object obj3) {
                            ((io.dcloud.common.DHInterface.FeatureMessageDispatcher.MessageListener) obj3).onReceiver(obj2);
                        }
                    }, messageListener);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void registerListener(io.dcloud.common.DHInterface.FeatureMessageDispatcher.MessageListener messageListener) {
        sFeatureMessage.add(messageListener);
    }

    public static void unregisterListener(io.dcloud.common.DHInterface.FeatureMessageDispatcher.MessageListener messageListener) {
        sFeatureMessage.remove(messageListener);
    }

    @java.lang.Deprecated
    public static void dispatchMessage(java.lang.Object obj) {
        dispatchMessage(null, obj);
    }
}
