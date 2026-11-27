package com.dcloud.android.v4.view.accessibility;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final java.lang.String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final java.lang.String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final java.lang.String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final java.lang.String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final java.lang.String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final java.lang.String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl IMPL;
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private final java.lang.Object mInfo;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class AccessibilityActionCompat {
        private final java.lang.Object mAction;
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_FOCUS = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(1, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLEAR_FOCUS = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(2, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SELECT = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(4, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLEAR_SELECTION = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(8, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLICK = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_LONG_CLICK = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(64, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(128, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(256, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(512, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(1024, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(2048, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_FORWARD = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(4096, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_BACKWARD = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(8192, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_COPY = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PASTE = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CUT = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SET_SELECTION = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_EXPAND = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_COLLAPSE = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_DISMISS = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, (java.lang.CharSequence) null);
        public static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SET_TEXT = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, (java.lang.CharSequence) null);

        public int getId() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionId(this.mAction);
        }

        public java.lang.CharSequence getLabel() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionLabel(this.mAction);
        }

        public AccessibilityActionCompat(int i, java.lang.CharSequence charSequence) {
            this(com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.newAccessibilityAction(i, charSequence));
        }

        private AccessibilityActionCompat(java.lang.Object obj) {
            this.mAction = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityNodeInfoApi21Impl extends com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoKitKatImpl {
        AccessibilityNodeInfoApi21Impl() {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addAction(java.lang.Object obj, java.lang.Object obj2) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.addAction(obj, obj2);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getAccessibilityActionId(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.getAccessibilityActionId(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.CharSequence getAccessibilityActionLabel(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.getAccessibilityActionLabel(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.util.List<java.lang.Object> getActionList(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.getActionList(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.CharSequence getError(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.getError(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getMaxTextLength(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.getMaxTextLength(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getWindow(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.getWindow(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCollectionItemSelected(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.CollectionItemInfo.isSelected(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object newAccessibilityAction(int i, java.lang.CharSequence charSequence) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.newAccessibilityAction(i, charSequence);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoKitKatImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.obtainCollectionInfo(i, i2, z, i3);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoKitKatImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.obtainCollectionItemInfo(i, i2, i3, i4, z, z2);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean removeAction(java.lang.Object obj, java.lang.Object obj2) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.removeAction(obj, obj2);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean removeChild(java.lang.Object obj, android.view.View view) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.removeChild(obj, view);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setError(java.lang.Object obj, java.lang.CharSequence charSequence) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.setError(obj, charSequence);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setMaxTextLength(java.lang.Object obj, int i) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.setMaxTextLength(obj, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean removeChild(java.lang.Object obj, android.view.View view, int i) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi21.removeChild(obj, view, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityNodeInfoApi22Impl extends com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi21Impl {
        AccessibilityNodeInfoApi22Impl() {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getTraversalAfter(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi22.getTraversalAfter(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getTraversalBefore(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi22.getTraversalBefore(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setTraversalAfter(java.lang.Object obj, android.view.View view) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi22.setTraversalAfter(obj, view);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setTraversalBefore(java.lang.Object obj, android.view.View view) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi22.setTraversalBefore(obj, view);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setTraversalAfter(java.lang.Object obj, android.view.View view, int i) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi22.setTraversalAfter(obj, view, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setTraversalBefore(java.lang.Object obj, android.view.View view, int i) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatApi22.setTraversalBefore(obj, view, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityNodeInfoIcsImpl extends com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl {
        AccessibilityNodeInfoIcsImpl() {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addAction(java.lang.Object obj, int i) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.addAction(obj, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addChild(java.lang.Object obj, android.view.View view) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.addChild(obj, view);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.util.List<java.lang.Object> findAccessibilityNodeInfosByText(java.lang.Object obj, java.lang.String str) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(obj, str);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getActions(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.getActions(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void getBoundsInParent(java.lang.Object obj, android.graphics.Rect rect) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.getBoundsInParent(obj, rect);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void getBoundsInScreen(java.lang.Object obj, android.graphics.Rect rect) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.getBoundsInScreen(obj, rect);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getChild(java.lang.Object obj, int i) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.getChild(obj, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getChildCount(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.getChildCount(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.CharSequence getClassName(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.getClassName(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.CharSequence getContentDescription(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.getContentDescription(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.CharSequence getPackageName(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.getPackageName(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getParent(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.getParent(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.CharSequence getText(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.getText(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getWindowId(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.getWindowId(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCheckable(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.isCheckable(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isChecked(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.isChecked(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isClickable(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.isClickable(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isEnabled(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.isEnabled(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isFocusable(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.isFocusable(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isFocused(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.isFocused(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isLongClickable(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.isLongClickable(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isPassword(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.isPassword(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isScrollable(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.isScrollable(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isSelected(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.isSelected(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object obtain() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.obtain();
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean performAction(java.lang.Object obj, int i) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.performAction(obj, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void recycle(java.lang.Object obj) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.recycle(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setBoundsInParent(java.lang.Object obj, android.graphics.Rect rect) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setBoundsInParent(obj, rect);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setBoundsInScreen(java.lang.Object obj, android.graphics.Rect rect) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setBoundsInScreen(obj, rect);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCheckable(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setCheckable(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setChecked(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setChecked(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setClassName(java.lang.Object obj, java.lang.CharSequence charSequence) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setClassName(obj, charSequence);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setClickable(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setClickable(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setContentDescription(java.lang.Object obj, java.lang.CharSequence charSequence) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setContentDescription(obj, charSequence);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setEnabled(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setEnabled(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setFocusable(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setFocusable(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setFocused(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setFocused(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLongClickable(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setLongClickable(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setPackageName(java.lang.Object obj, java.lang.CharSequence charSequence) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setPackageName(obj, charSequence);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setParent(java.lang.Object obj, android.view.View view) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setParent(obj, view);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setPassword(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setPassword(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setScrollable(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setScrollable(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSelected(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setSelected(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSource(java.lang.Object obj, android.view.View view) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setSource(obj, view);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setText(java.lang.Object obj, java.lang.CharSequence charSequence) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.setText(obj, charSequence);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object obtain(android.view.View view) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.obtain(view);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object obtain(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatIcs.obtain(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface AccessibilityNodeInfoImpl {
        void addAction(java.lang.Object obj, int i);

        void addAction(java.lang.Object obj, java.lang.Object obj2);

        void addChild(java.lang.Object obj, android.view.View view);

        void addChild(java.lang.Object obj, android.view.View view, int i);

        boolean canOpenPopup(java.lang.Object obj);

        java.util.List<java.lang.Object> findAccessibilityNodeInfosByText(java.lang.Object obj, java.lang.String str);

        java.util.List<java.lang.Object> findAccessibilityNodeInfosByViewId(java.lang.Object obj, java.lang.String str);

        java.lang.Object findFocus(java.lang.Object obj, int i);

        java.lang.Object focusSearch(java.lang.Object obj, int i);

        int getAccessibilityActionId(java.lang.Object obj);

        java.lang.CharSequence getAccessibilityActionLabel(java.lang.Object obj);

        java.util.List<java.lang.Object> getActionList(java.lang.Object obj);

        int getActions(java.lang.Object obj);

        void getBoundsInParent(java.lang.Object obj, android.graphics.Rect rect);

        void getBoundsInScreen(java.lang.Object obj, android.graphics.Rect rect);

        java.lang.Object getChild(java.lang.Object obj, int i);

        int getChildCount(java.lang.Object obj);

        java.lang.CharSequence getClassName(java.lang.Object obj);

        java.lang.Object getCollectionInfo(java.lang.Object obj);

        int getCollectionInfoColumnCount(java.lang.Object obj);

        int getCollectionInfoRowCount(java.lang.Object obj);

        int getCollectionItemColumnIndex(java.lang.Object obj);

        int getCollectionItemColumnSpan(java.lang.Object obj);

        java.lang.Object getCollectionItemInfo(java.lang.Object obj);

        int getCollectionItemRowIndex(java.lang.Object obj);

        int getCollectionItemRowSpan(java.lang.Object obj);

        java.lang.CharSequence getContentDescription(java.lang.Object obj);

        java.lang.CharSequence getError(java.lang.Object obj);

        android.os.Bundle getExtras(java.lang.Object obj);

        int getInputType(java.lang.Object obj);

        java.lang.Object getLabelFor(java.lang.Object obj);

        java.lang.Object getLabeledBy(java.lang.Object obj);

        int getLiveRegion(java.lang.Object obj);

        int getMaxTextLength(java.lang.Object obj);

        int getMovementGranularities(java.lang.Object obj);

        java.lang.CharSequence getPackageName(java.lang.Object obj);

        java.lang.Object getParent(java.lang.Object obj);

        java.lang.Object getRangeInfo(java.lang.Object obj);

        java.lang.CharSequence getText(java.lang.Object obj);

        int getTextSelectionEnd(java.lang.Object obj);

        int getTextSelectionStart(java.lang.Object obj);

        java.lang.Object getTraversalAfter(java.lang.Object obj);

        java.lang.Object getTraversalBefore(java.lang.Object obj);

        java.lang.String getViewIdResourceName(java.lang.Object obj);

        java.lang.Object getWindow(java.lang.Object obj);

        int getWindowId(java.lang.Object obj);

        boolean isAccessibilityFocused(java.lang.Object obj);

        boolean isCheckable(java.lang.Object obj);

        boolean isChecked(java.lang.Object obj);

        boolean isClickable(java.lang.Object obj);

        boolean isCollectionInfoHierarchical(java.lang.Object obj);

        boolean isCollectionItemHeading(java.lang.Object obj);

        boolean isCollectionItemSelected(java.lang.Object obj);

        boolean isContentInvalid(java.lang.Object obj);

        boolean isDismissable(java.lang.Object obj);

        boolean isEditable(java.lang.Object obj);

        boolean isEnabled(java.lang.Object obj);

        boolean isFocusable(java.lang.Object obj);

        boolean isFocused(java.lang.Object obj);

        boolean isLongClickable(java.lang.Object obj);

        boolean isMultiLine(java.lang.Object obj);

        boolean isPassword(java.lang.Object obj);

        boolean isScrollable(java.lang.Object obj);

        boolean isSelected(java.lang.Object obj);

        boolean isVisibleToUser(java.lang.Object obj);

        java.lang.Object newAccessibilityAction(int i, java.lang.CharSequence charSequence);

        java.lang.Object obtain();

        java.lang.Object obtain(android.view.View view);

        java.lang.Object obtain(android.view.View view, int i);

        java.lang.Object obtain(java.lang.Object obj);

        java.lang.Object obtainCollectionInfo(int i, int i2, boolean z, int i3);

        java.lang.Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2);

        boolean performAction(java.lang.Object obj, int i);

        boolean performAction(java.lang.Object obj, int i, android.os.Bundle bundle);

        void recycle(java.lang.Object obj);

        boolean refresh(java.lang.Object obj);

        boolean removeAction(java.lang.Object obj, java.lang.Object obj2);

        boolean removeChild(java.lang.Object obj, android.view.View view);

        boolean removeChild(java.lang.Object obj, android.view.View view, int i);

        void setAccessibilityFocused(java.lang.Object obj, boolean z);

        void setBoundsInParent(java.lang.Object obj, android.graphics.Rect rect);

        void setBoundsInScreen(java.lang.Object obj, android.graphics.Rect rect);

        void setCanOpenPopup(java.lang.Object obj, boolean z);

        void setCheckable(java.lang.Object obj, boolean z);

        void setChecked(java.lang.Object obj, boolean z);

        void setClassName(java.lang.Object obj, java.lang.CharSequence charSequence);

        void setClickable(java.lang.Object obj, boolean z);

        void setCollectionInfo(java.lang.Object obj, java.lang.Object obj2);

        void setCollectionItemInfo(java.lang.Object obj, java.lang.Object obj2);

        void setContentDescription(java.lang.Object obj, java.lang.CharSequence charSequence);

        void setContentInvalid(java.lang.Object obj, boolean z);

        void setDismissable(java.lang.Object obj, boolean z);

        void setEditable(java.lang.Object obj, boolean z);

        void setEnabled(java.lang.Object obj, boolean z);

        void setError(java.lang.Object obj, java.lang.CharSequence charSequence);

        void setFocusable(java.lang.Object obj, boolean z);

        void setFocused(java.lang.Object obj, boolean z);

        void setInputType(java.lang.Object obj, int i);

        void setLabelFor(java.lang.Object obj, android.view.View view);

        void setLabelFor(java.lang.Object obj, android.view.View view, int i);

        void setLabeledBy(java.lang.Object obj, android.view.View view);

        void setLabeledBy(java.lang.Object obj, android.view.View view, int i);

        void setLiveRegion(java.lang.Object obj, int i);

        void setLongClickable(java.lang.Object obj, boolean z);

        void setMaxTextLength(java.lang.Object obj, int i);

        void setMovementGranularities(java.lang.Object obj, int i);

        void setMultiLine(java.lang.Object obj, boolean z);

        void setPackageName(java.lang.Object obj, java.lang.CharSequence charSequence);

        void setParent(java.lang.Object obj, android.view.View view);

        void setParent(java.lang.Object obj, android.view.View view, int i);

        void setPassword(java.lang.Object obj, boolean z);

        void setRangeInfo(java.lang.Object obj, java.lang.Object obj2);

        void setScrollable(java.lang.Object obj, boolean z);

        void setSelected(java.lang.Object obj, boolean z);

        void setSource(java.lang.Object obj, android.view.View view);

        void setSource(java.lang.Object obj, android.view.View view, int i);

        void setText(java.lang.Object obj, java.lang.CharSequence charSequence);

        void setTextSelection(java.lang.Object obj, int i, int i2);

        void setTraversalAfter(java.lang.Object obj, android.view.View view);

        void setTraversalAfter(java.lang.Object obj, android.view.View view, int i);

        void setTraversalBefore(java.lang.Object obj, android.view.View view);

        void setTraversalBefore(java.lang.Object obj, android.view.View view, int i);

        void setViewIdResourceName(java.lang.Object obj, java.lang.String str);

        void setVisibleToUser(java.lang.Object obj, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityNodeInfoJellybeanImpl extends com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl {
        AccessibilityNodeInfoJellybeanImpl() {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addChild(java.lang.Object obj, android.view.View view, int i) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean.addChild(obj, view, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object findFocus(java.lang.Object obj, int i) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean.findFocus(obj, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object focusSearch(java.lang.Object obj, int i) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean.focusSearch(obj, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getMovementGranularities(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isAccessibilityFocused(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isVisibleToUser(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object obtain(android.view.View view, int i) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean.obtain(view, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean performAction(java.lang.Object obj, int i, android.os.Bundle bundle) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean.performAction(obj, i, bundle);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setAccessibilityFocused(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setMovementGranularities(java.lang.Object obj, int i) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(obj, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setParent(java.lang.Object obj, android.view.View view, int i) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean.setParent(obj, view, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSource(java.lang.Object obj, android.view.View view, int i) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean.setSource(obj, view, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setVisibleToUser(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(obj, z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityNodeInfoJellybeanMr1Impl extends com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanImpl {
        AccessibilityNodeInfoJellybeanMr1Impl() {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getLabelFor(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr1.getLabelFor(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getLabeledBy(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr1.getLabeledBy(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLabelFor(java.lang.Object obj, android.view.View view) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(obj, view);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLabeledBy(java.lang.Object obj, android.view.View view) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(obj, view);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLabelFor(java.lang.Object obj, android.view.View view, int i) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(obj, view, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLabeledBy(java.lang.Object obj, android.view.View view, int i) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(obj, view, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityNodeInfoJellybeanMr2Impl extends com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanMr1Impl {
        AccessibilityNodeInfoJellybeanMr2Impl() {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.util.List<java.lang.Object> findAccessibilityNodeInfosByViewId(java.lang.Object obj, java.lang.String str) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr2.findAccessibilityNodeInfosByViewId(obj, str);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getTextSelectionEnd(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionEnd(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getTextSelectionStart(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionStart(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.String getViewIdResourceName(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr2.getViewIdResourceName(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isEditable(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr2.isEditable(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean refresh(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr2.refresh(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setEditable(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr2.setEditable(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setTextSelection(java.lang.Object obj, int i, int i2) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr2.setTextSelection(obj, i, i2);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setViewIdResourceName(java.lang.Object obj, java.lang.String str) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr2.setViewIdResourceName(obj, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityNodeInfoKitKatImpl extends com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanMr2Impl {
        AccessibilityNodeInfoKitKatImpl() {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean canOpenPopup(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.canOpenPopup(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getCollectionInfo(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.getCollectionInfo(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionInfoColumnCount(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.CollectionInfo.getColumnCount(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionInfoRowCount(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.CollectionInfo.getRowCount(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemColumnIndex(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getColumnIndex(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemColumnSpan(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getColumnSpan(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getCollectionItemInfo(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.getCollectionItemInfo(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemRowIndex(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getRowIndex(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemRowSpan(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getRowSpan(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public android.os.Bundle getExtras(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.getExtras(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getInputType(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.getInputType(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getLiveRegion(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.getLiveRegion(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getRangeInfo(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.getRangeInfo(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCollectionInfoHierarchical(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.CollectionInfo.isHierarchical(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCollectionItemHeading(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.isHeading(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isContentInvalid(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.isContentInvalid(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isDismissable(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.isDismissable(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isMultiLine(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.isMultiLine(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.obtainCollectionInfo(i, i2, z, i3);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.obtainCollectionItemInfo(i, i2, i3, i4, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCanOpenPopup(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.setCanOpenPopup(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCollectionInfo(java.lang.Object obj, java.lang.Object obj2) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.setCollectionInfo(obj, obj2);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCollectionItemInfo(java.lang.Object obj, java.lang.Object obj2) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.setCollectionItemInfo(obj, obj2);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setContentInvalid(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.setContentInvalid(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setDismissable(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.setDismissable(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setInputType(java.lang.Object obj, int i) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.setInputType(obj, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLiveRegion(java.lang.Object obj, int i) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.setLiveRegion(obj, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setMultiLine(java.lang.Object obj, boolean z) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.setMultiLine(obj, z);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setRangeInfo(java.lang.Object obj, java.lang.Object obj2) {
            com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.setRangeInfo(obj, obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityNodeInfoStubImpl implements com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl {
        AccessibilityNodeInfoStubImpl() {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addAction(java.lang.Object obj, int i) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addAction(java.lang.Object obj, java.lang.Object obj2) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addChild(java.lang.Object obj, android.view.View view) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void addChild(java.lang.Object obj, android.view.View view, int i) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean canOpenPopup(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.util.List<java.lang.Object> findAccessibilityNodeInfosByText(java.lang.Object obj, java.lang.String str) {
            return java.util.Collections.EMPTY_LIST;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.util.List<java.lang.Object> findAccessibilityNodeInfosByViewId(java.lang.Object obj, java.lang.String str) {
            return java.util.Collections.EMPTY_LIST;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object findFocus(java.lang.Object obj, int i) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object focusSearch(java.lang.Object obj, int i) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getAccessibilityActionId(java.lang.Object obj) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.CharSequence getAccessibilityActionLabel(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.util.List<java.lang.Object> getActionList(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getActions(java.lang.Object obj) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void getBoundsInParent(java.lang.Object obj, android.graphics.Rect rect) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void getBoundsInScreen(java.lang.Object obj, android.graphics.Rect rect) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getChild(java.lang.Object obj, int i) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getChildCount(java.lang.Object obj) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.CharSequence getClassName(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getCollectionInfo(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionInfoColumnCount(java.lang.Object obj) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionInfoRowCount(java.lang.Object obj) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemColumnIndex(java.lang.Object obj) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemColumnSpan(java.lang.Object obj) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getCollectionItemInfo(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemRowIndex(java.lang.Object obj) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getCollectionItemRowSpan(java.lang.Object obj) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.CharSequence getContentDescription(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.CharSequence getError(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public android.os.Bundle getExtras(java.lang.Object obj) {
            return new android.os.Bundle();
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getInputType(java.lang.Object obj) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getLabelFor(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getLabeledBy(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getLiveRegion(java.lang.Object obj) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getMaxTextLength(java.lang.Object obj) {
            return -1;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getMovementGranularities(java.lang.Object obj) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.CharSequence getPackageName(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getParent(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getRangeInfo(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.CharSequence getText(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getTextSelectionEnd(java.lang.Object obj) {
            return -1;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getTextSelectionStart(java.lang.Object obj) {
            return -1;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getTraversalAfter(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getTraversalBefore(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.String getViewIdResourceName(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object getWindow(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public int getWindowId(java.lang.Object obj) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isAccessibilityFocused(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCheckable(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isChecked(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isClickable(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCollectionInfoHierarchical(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCollectionItemHeading(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isCollectionItemSelected(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isContentInvalid(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isDismissable(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isEditable(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isEnabled(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isFocusable(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isFocused(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isLongClickable(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isMultiLine(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isPassword(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isScrollable(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isSelected(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean isVisibleToUser(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object newAccessibilityAction(int i, java.lang.CharSequence charSequence) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object obtain() {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object obtain(android.view.View view) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object obtain(android.view.View view, int i) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object obtain(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public java.lang.Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean performAction(java.lang.Object obj, int i) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean performAction(java.lang.Object obj, int i, android.os.Bundle bundle) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void recycle(java.lang.Object obj) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean refresh(java.lang.Object obj) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean removeAction(java.lang.Object obj, java.lang.Object obj2) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean removeChild(java.lang.Object obj, android.view.View view) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public boolean removeChild(java.lang.Object obj, android.view.View view, int i) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setAccessibilityFocused(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setBoundsInParent(java.lang.Object obj, android.graphics.Rect rect) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setBoundsInScreen(java.lang.Object obj, android.graphics.Rect rect) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCanOpenPopup(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCheckable(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setChecked(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setClassName(java.lang.Object obj, java.lang.CharSequence charSequence) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setClickable(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCollectionInfo(java.lang.Object obj, java.lang.Object obj2) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setCollectionItemInfo(java.lang.Object obj, java.lang.Object obj2) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setContentDescription(java.lang.Object obj, java.lang.CharSequence charSequence) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setContentInvalid(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setDismissable(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setEditable(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setEnabled(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setError(java.lang.Object obj, java.lang.CharSequence charSequence) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setFocusable(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setFocused(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setInputType(java.lang.Object obj, int i) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLabelFor(java.lang.Object obj, android.view.View view) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLabelFor(java.lang.Object obj, android.view.View view, int i) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLabeledBy(java.lang.Object obj, android.view.View view) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLabeledBy(java.lang.Object obj, android.view.View view, int i) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLiveRegion(java.lang.Object obj, int i) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setLongClickable(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setMaxTextLength(java.lang.Object obj, int i) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setMovementGranularities(java.lang.Object obj, int i) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setMultiLine(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setPackageName(java.lang.Object obj, java.lang.CharSequence charSequence) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setParent(java.lang.Object obj, android.view.View view) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setParent(java.lang.Object obj, android.view.View view, int i) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setPassword(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setRangeInfo(java.lang.Object obj, java.lang.Object obj2) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setScrollable(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSelected(java.lang.Object obj, boolean z) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSource(java.lang.Object obj, android.view.View view) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setSource(java.lang.Object obj, android.view.View view, int i) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setText(java.lang.Object obj, java.lang.CharSequence charSequence) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setTextSelection(java.lang.Object obj, int i, int i2) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setTraversalAfter(java.lang.Object obj, android.view.View view) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setTraversalAfter(java.lang.Object obj, android.view.View view, int i) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setTraversalBefore(java.lang.Object obj, android.view.View view) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setTraversalBefore(java.lang.Object obj, android.view.View view, int i) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setViewIdResourceName(java.lang.Object obj, java.lang.String str) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
        public void setVisibleToUser(java.lang.Object obj, boolean z) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        final java.lang.Object mInfo;

        public static com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat obtain(int i, int i2, boolean z, int i3) {
            return new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat(com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(i, i2, z, i3));
        }

        public int getColumnCount() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getCollectionInfoColumnCount(this.mInfo);
        }

        public int getRowCount() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getCollectionInfoRowCount(this.mInfo);
        }

        public boolean isHierarchical() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isCollectionInfoHierarchical(this.mInfo);
        }

        private CollectionInfoCompat(java.lang.Object obj) {
            this.mInfo = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class CollectionItemInfoCompat {
        private final java.lang.Object mInfo;

        public static com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat(com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(i, i2, i3, i4, z, z2));
        }

        public int getColumnIndex() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnIndex(this.mInfo);
        }

        public int getColumnSpan() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnSpan(this.mInfo);
        }

        public int getRowIndex() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowIndex(this.mInfo);
        }

        public int getRowSpan() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowSpan(this.mInfo);
        }

        public boolean isHeading() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isCollectionItemHeading(this.mInfo);
        }

        public boolean isSelected() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isCollectionItemSelected(this.mInfo);
        }

        private CollectionItemInfoCompat(java.lang.Object obj) {
            this.mInfo = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        private final java.lang.Object mInfo;

        public float getCurrent() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.RangeInfo.getCurrent(this.mInfo);
        }

        public float getMax() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.RangeInfo.getMax(this.mInfo);
        }

        public float getMin() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.RangeInfo.getMin(this.mInfo);
        }

        public int getType() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat.RangeInfo.getType(this.mInfo);
        }

        private RangeInfoCompat(java.lang.Object obj) {
            this.mInfo = obj;
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 22) {
            IMPL = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi22Impl();
        } else {
            IMPL = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi21Impl();
        }
    }

    public AccessibilityNodeInfoCompat(java.lang.Object obj) {
        this.mInfo = obj;
    }

    private static java.lang.String getActionSymbolicName(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public static com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat obtain(android.view.View view) {
        return wrapNonNullInstance(IMPL.obtain(view));
    }

    static com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat wrapNonNullInstance(java.lang.Object obj) {
        if (obj != null) {
            return new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    public void addAction(int i) {
        IMPL.addAction(this.mInfo, i);
    }

    public void addChild(android.view.View view) {
        IMPL.addChild(this.mInfo, view);
    }

    public boolean canOpenPopup() {
        return IMPL.canOpenPopup(this.mInfo);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat) obj;
        java.lang.Object obj2 = this.mInfo;
        if (obj2 == null) {
            if (accessibilityNodeInfoCompat.mInfo != null) {
                return false;
            }
        } else if (!obj2.equals(accessibilityNodeInfoCompat.mInfo)) {
            return false;
        }
        return true;
    }

    public java.util.List<com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<java.lang.Object> listFindAccessibilityNodeInfosByText = IMPL.findAccessibilityNodeInfosByText(this.mInfo, str);
        int size = listFindAccessibilityNodeInfosByText.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat(listFindAccessibilityNodeInfosByText.get(i)));
        }
        return arrayList;
    }

    public java.util.List<com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(java.lang.String str) {
        java.util.List<java.lang.Object> listFindAccessibilityNodeInfosByViewId = IMPL.findAccessibilityNodeInfosByViewId(this.mInfo, str);
        if (listFindAccessibilityNodeInfosByViewId == null) {
            return java.util.Collections.EMPTY_LIST;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.lang.Object> it = listFindAccessibilityNodeInfosByViewId.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat(it.next()));
        }
        return arrayList;
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat findFocus(int i) {
        return wrapNonNullInstance(IMPL.findFocus(this.mInfo, i));
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat focusSearch(int i) {
        return wrapNonNullInstance(IMPL.focusSearch(this.mInfo, i));
    }

    public java.util.List<com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList() {
        java.util.List<java.lang.Object> actionList = IMPL.getActionList(this.mInfo);
        if (actionList == null) {
            return java.util.Collections.EMPTY_LIST;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionList.get(i)));
        }
        return arrayList;
    }

    public int getActions() {
        return IMPL.getActions(this.mInfo);
    }

    public void getBoundsInParent(android.graphics.Rect rect) {
        IMPL.getBoundsInParent(this.mInfo, rect);
    }

    public void getBoundsInScreen(android.graphics.Rect rect) {
        IMPL.getBoundsInScreen(this.mInfo, rect);
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat getChild(int i) {
        return wrapNonNullInstance(IMPL.getChild(this.mInfo, i));
    }

    public int getChildCount() {
        return IMPL.getChildCount(this.mInfo);
    }

    public java.lang.CharSequence getClassName() {
        return IMPL.getClassName(this.mInfo);
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat getCollectionInfo() {
        java.lang.Object collectionInfo = IMPL.getCollectionInfo(this.mInfo);
        if (collectionInfo == null) {
            return null;
        }
        return new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat(collectionInfo);
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat getCollectionItemInfo() {
        java.lang.Object collectionItemInfo = IMPL.getCollectionItemInfo(this.mInfo);
        if (collectionItemInfo == null) {
            return null;
        }
        return new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat(collectionItemInfo);
    }

    public java.lang.CharSequence getContentDescription() {
        return IMPL.getContentDescription(this.mInfo);
    }

    public java.lang.CharSequence getError() {
        return IMPL.getError(this.mInfo);
    }

    public android.os.Bundle getExtras() {
        return IMPL.getExtras(this.mInfo);
    }

    public java.lang.Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        return IMPL.getInputType(this.mInfo);
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat getLabelFor() {
        return wrapNonNullInstance(IMPL.getLabelFor(this.mInfo));
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat getLabeledBy() {
        return wrapNonNullInstance(IMPL.getLabeledBy(this.mInfo));
    }

    public int getLiveRegion() {
        return IMPL.getLiveRegion(this.mInfo);
    }

    public int getMaxTextLength() {
        return IMPL.getMaxTextLength(this.mInfo);
    }

    public int getMovementGranularities() {
        return IMPL.getMovementGranularities(this.mInfo);
    }

    public java.lang.CharSequence getPackageName() {
        return IMPL.getPackageName(this.mInfo);
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(IMPL.getParent(this.mInfo));
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat getRangeInfo() {
        java.lang.Object rangeInfo = IMPL.getRangeInfo(this.mInfo);
        if (rangeInfo == null) {
            return null;
        }
        return new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat(rangeInfo);
    }

    public java.lang.CharSequence getText() {
        return IMPL.getText(this.mInfo);
    }

    public int getTextSelectionEnd() {
        return IMPL.getTextSelectionEnd(this.mInfo);
    }

    public int getTextSelectionStart() {
        return IMPL.getTextSelectionStart(this.mInfo);
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat getTraversalAfter() {
        return wrapNonNullInstance(IMPL.getTraversalAfter(this.mInfo));
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat getTraversalBefore() {
        return wrapNonNullInstance(IMPL.getTraversalBefore(this.mInfo));
    }

    public java.lang.String getViewIdResourceName() {
        return IMPL.getViewIdResourceName(this.mInfo);
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat getWindow() {
        return com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.wrapNonNullInstance(IMPL.getWindow(this.mInfo));
    }

    public int getWindowId() {
        return IMPL.getWindowId(this.mInfo);
    }

    public int hashCode() {
        java.lang.Object obj = this.mInfo;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return IMPL.isAccessibilityFocused(this.mInfo);
    }

    public boolean isCheckable() {
        return IMPL.isCheckable(this.mInfo);
    }

    public boolean isChecked() {
        return IMPL.isChecked(this.mInfo);
    }

    public boolean isClickable() {
        return IMPL.isClickable(this.mInfo);
    }

    public boolean isContentInvalid() {
        return IMPL.isContentInvalid(this.mInfo);
    }

    public boolean isDismissable() {
        return IMPL.isDismissable(this.mInfo);
    }

    public boolean isEditable() {
        return IMPL.isEditable(this.mInfo);
    }

    public boolean isEnabled() {
        return IMPL.isEnabled(this.mInfo);
    }

    public boolean isFocusable() {
        return IMPL.isFocusable(this.mInfo);
    }

    public boolean isFocused() {
        return IMPL.isFocused(this.mInfo);
    }

    public boolean isLongClickable() {
        return IMPL.isLongClickable(this.mInfo);
    }

    public boolean isMultiLine() {
        return IMPL.isMultiLine(this.mInfo);
    }

    public boolean isPassword() {
        return IMPL.isPassword(this.mInfo);
    }

    public boolean isScrollable() {
        return IMPL.isScrollable(this.mInfo);
    }

    public boolean isSelected() {
        return IMPL.isSelected(this.mInfo);
    }

    public boolean isVisibleToUser() {
        return IMPL.isVisibleToUser(this.mInfo);
    }

    public boolean performAction(int i) {
        return IMPL.performAction(this.mInfo, i);
    }

    public void recycle() {
        IMPL.recycle(this.mInfo);
    }

    public boolean refresh() {
        return IMPL.refresh(this.mInfo);
    }

    public boolean removeAction(com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        return IMPL.removeAction(this.mInfo, accessibilityActionCompat.mAction);
    }

    public boolean removeChild(android.view.View view) {
        return IMPL.removeChild(this.mInfo, view);
    }

    public void setAccessibilityFocused(boolean z) {
        IMPL.setAccessibilityFocused(this.mInfo, z);
    }

    public void setBoundsInParent(android.graphics.Rect rect) {
        IMPL.setBoundsInParent(this.mInfo, rect);
    }

    public void setBoundsInScreen(android.graphics.Rect rect) {
        IMPL.setBoundsInScreen(this.mInfo, rect);
    }

    public void setCanOpenPopup(boolean z) {
        IMPL.setCanOpenPopup(this.mInfo, z);
    }

    public void setCheckable(boolean z) {
        IMPL.setCheckable(this.mInfo, z);
    }

    public void setChecked(boolean z) {
        IMPL.setChecked(this.mInfo, z);
    }

    public void setClassName(java.lang.CharSequence charSequence) {
        IMPL.setClassName(this.mInfo, charSequence);
    }

    public void setClickable(boolean z) {
        IMPL.setClickable(this.mInfo, z);
    }

    public void setCollectionInfo(java.lang.Object obj) {
        IMPL.setCollectionInfo(this.mInfo, ((com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat) obj).mInfo);
    }

    public void setCollectionItemInfo(java.lang.Object obj) {
        IMPL.setCollectionItemInfo(this.mInfo, ((com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat) obj).mInfo);
    }

    public void setContentDescription(java.lang.CharSequence charSequence) {
        IMPL.setContentDescription(this.mInfo, charSequence);
    }

    public void setContentInvalid(boolean z) {
        IMPL.setContentInvalid(this.mInfo, z);
    }

    public void setDismissable(boolean z) {
        IMPL.setDismissable(this.mInfo, z);
    }

    public void setEditable(boolean z) {
        IMPL.setEditable(this.mInfo, z);
    }

    public void setEnabled(boolean z) {
        IMPL.setEnabled(this.mInfo, z);
    }

    public void setError(java.lang.CharSequence charSequence) {
        IMPL.setError(this.mInfo, charSequence);
    }

    public void setFocusable(boolean z) {
        IMPL.setFocusable(this.mInfo, z);
    }

    public void setFocused(boolean z) {
        IMPL.setFocused(this.mInfo, z);
    }

    public void setInputType(int i) {
        IMPL.setInputType(this.mInfo, i);
    }

    public void setLabelFor(android.view.View view) {
        IMPL.setLabelFor(this.mInfo, view);
    }

    public void setLabeledBy(android.view.View view) {
        IMPL.setLabeledBy(this.mInfo, view);
    }

    public void setLiveRegion(int i) {
        IMPL.setLiveRegion(this.mInfo, i);
    }

    public void setLongClickable(boolean z) {
        IMPL.setLongClickable(this.mInfo, z);
    }

    public void setMaxTextLength(int i) {
        IMPL.setMaxTextLength(this.mInfo, i);
    }

    public void setMovementGranularities(int i) {
        IMPL.setMovementGranularities(this.mInfo, i);
    }

    public void setMultiLine(boolean z) {
        IMPL.setMultiLine(this.mInfo, z);
    }

    public void setPackageName(java.lang.CharSequence charSequence) {
        IMPL.setPackageName(this.mInfo, charSequence);
    }

    public void setParent(android.view.View view) {
        IMPL.setParent(this.mInfo, view);
    }

    public void setPassword(boolean z) {
        IMPL.setPassword(this.mInfo, z);
    }

    public void setRangeInfo(com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat rangeInfoCompat) {
        IMPL.setRangeInfo(this.mInfo, rangeInfoCompat.mInfo);
    }

    public void setScrollable(boolean z) {
        IMPL.setScrollable(this.mInfo, z);
    }

    public void setSelected(boolean z) {
        IMPL.setSelected(this.mInfo, z);
    }

    public void setSource(android.view.View view) {
        IMPL.setSource(this.mInfo, view);
    }

    public void setText(java.lang.CharSequence charSequence) {
        IMPL.setText(this.mInfo, charSequence);
    }

    public void setTextSelection(int i, int i2) {
        IMPL.setTextSelection(this.mInfo, i, i2);
    }

    public void setTraversalAfter(android.view.View view) {
        IMPL.setTraversalAfter(this.mInfo, view);
    }

    public void setTraversalBefore(android.view.View view) {
        IMPL.setTraversalBefore(this.mInfo, view);
    }

    public void setViewIdResourceName(java.lang.String str) {
        IMPL.setViewIdResourceName(this.mInfo, str);
    }

    public void setVisibleToUser(boolean z) {
        IMPL.setVisibleToUser(this.mInfo, z);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(super.toString());
        android.graphics.Rect rect = new android.graphics.Rect();
        getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(getPackageName());
        sb.append("; className: ");
        sb.append(getClassName());
        sb.append("; text: ");
        sb.append(getText());
        sb.append("; contentDescription: ");
        sb.append(getContentDescription());
        sb.append("; viewId: ");
        sb.append(getViewIdResourceName());
        sb.append("; checkable: ");
        sb.append(isCheckable());
        sb.append("; checked: ");
        sb.append(isChecked());
        sb.append("; focusable: ");
        sb.append(isFocusable());
        sb.append("; focused: ");
        sb.append(isFocused());
        sb.append("; selected: ");
        sb.append(isSelected());
        sb.append("; clickable: ");
        sb.append(isClickable());
        sb.append("; longClickable: ");
        sb.append(isLongClickable());
        sb.append("; enabled: ");
        sb.append(isEnabled());
        sb.append("; password: ");
        sb.append(isPassword());
        sb.append("; scrollable: " + isScrollable());
        sb.append("; [");
        int actions = getActions();
        while (actions != 0) {
            int iNumberOfTrailingZeros = 1 << java.lang.Integer.numberOfTrailingZeros(actions);
            actions &= ~iNumberOfTrailingZeros;
            sb.append(getActionSymbolicName(iNumberOfTrailingZeros));
            if (actions != 0) {
                sb.append(", ");
            }
        }
        sb.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        return sb.toString();
    }

    public static com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat obtain(android.view.View view, int i) {
        return wrapNonNullInstance(IMPL.obtain(view, i));
    }

    public void addAction(com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        IMPL.addAction(this.mInfo, accessibilityActionCompat.mAction);
    }

    public void addChild(android.view.View view, int i) {
        IMPL.addChild(this.mInfo, view, i);
    }

    public boolean performAction(int i, android.os.Bundle bundle) {
        return IMPL.performAction(this.mInfo, i, bundle);
    }

    public boolean removeChild(android.view.View view, int i) {
        return IMPL.removeChild(this.mInfo, view, i);
    }

    public void setLabelFor(android.view.View view, int i) {
        IMPL.setLabelFor(this.mInfo, view, i);
    }

    public void setLabeledBy(android.view.View view, int i) {
        IMPL.setLabeledBy(this.mInfo, view, i);
    }

    public void setParent(android.view.View view, int i) {
        IMPL.setParent(this.mInfo, view, i);
    }

    public void setSource(android.view.View view, int i) {
        IMPL.setSource(this.mInfo, view, i);
    }

    public void setTraversalAfter(android.view.View view, int i) {
        IMPL.setTraversalAfter(this.mInfo, view, i);
    }

    public void setTraversalBefore(android.view.View view, int i) {
        IMPL.setTraversalBefore(this.mInfo, view, i);
    }

    public static com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat obtain() {
        return wrapNonNullInstance(IMPL.obtain());
    }

    public static com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat obtain(com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return wrapNonNullInstance(IMPL.obtain(accessibilityNodeInfoCompat.mInfo));
    }
}
