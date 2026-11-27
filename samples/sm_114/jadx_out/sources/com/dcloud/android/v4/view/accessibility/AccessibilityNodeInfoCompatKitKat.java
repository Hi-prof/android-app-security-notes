package com.dcloud.android.v4.view.accessibility;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityNodeInfoCompatKitKat {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class CollectionInfo {
        CollectionInfo() {
        }

        static int getColumnCount(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) obj).getColumnCount();
        }

        static int getRowCount(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) obj).getRowCount();
        }

        static boolean isHierarchical(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) obj).isHierarchical();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class CollectionItemInfo {
        CollectionItemInfo() {
        }

        static int getColumnIndex(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnIndex();
        }

        static int getColumnSpan(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnSpan();
        }

        static int getRowIndex(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) obj).getRowIndex();
        }

        static int getRowSpan(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) obj).getRowSpan();
        }

        static boolean isHeading(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) obj).isHeading();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class RangeInfo {
        RangeInfo() {
        }

        static float getCurrent(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo) obj).getCurrent();
        }

        static float getMax(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo) obj).getMax();
        }

        static float getMin(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo) obj).getMin();
        }

        static int getType(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo) obj).getType();
        }
    }

    AccessibilityNodeInfoCompatKitKat() {
    }

    public static boolean canOpenPopup(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).canOpenPopup();
    }

    static java.lang.Object getCollectionInfo(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getCollectionInfo();
    }

    static java.lang.Object getCollectionItemInfo(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getCollectionItemInfo();
    }

    public static android.os.Bundle getExtras(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getExtras();
    }

    public static int getInputType(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getInputType();
    }

    static int getLiveRegion(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getLiveRegion();
    }

    static java.lang.Object getRangeInfo(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getRangeInfo();
    }

    public static boolean isContentInvalid(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isContentInvalid();
    }

    public static boolean isDismissable(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isDismissable();
    }

    public static boolean isMultiLine(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isMultiLine();
    }

    public static java.lang.Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
        return android.view.accessibility.AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z);
    }

    public static java.lang.Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z) {
        return android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z);
    }

    public static void setCanOpenPopup(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setCanOpenPopup(z);
    }

    public static void setCollectionInfo(java.lang.Object obj, java.lang.Object obj2) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setCollectionInfo((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) obj2);
    }

    public static void setCollectionItemInfo(java.lang.Object obj, java.lang.Object obj2) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setCollectionItemInfo((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) obj2);
    }

    public static void setContentInvalid(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setContentInvalid(z);
    }

    public static void setDismissable(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setDismissable(z);
    }

    public static void setInputType(java.lang.Object obj, int i) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setInputType(i);
    }

    static void setLiveRegion(java.lang.Object obj, int i) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setLiveRegion(i);
    }

    public static void setMultiLine(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setMultiLine(z);
    }

    public static void setRangeInfo(java.lang.Object obj, java.lang.Object obj2) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setRangeInfo((android.view.accessibility.AccessibilityNodeInfo.RangeInfo) obj2);
    }
}
