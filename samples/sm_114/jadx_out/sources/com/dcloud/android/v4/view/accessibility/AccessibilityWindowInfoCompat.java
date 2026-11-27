package com.dcloud.android.v4.view.accessibility;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AccessibilityWindowInfoCompat {
    private static final com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl IMPL = new com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoApi21Impl();
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private java.lang.Object mInfo;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class AccessibilityWindowInfoApi21Impl extends com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl {
        private AccessibilityWindowInfoApi21Impl() {
            super();
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public void getBoundsInScreen(java.lang.Object obj, android.graphics.Rect rect) {
            com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompatApi21.getBoundsInScreen(obj, rect);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public java.lang.Object getChild(java.lang.Object obj, int i) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompatApi21.getChild(obj, i);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public int getChildCount(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompatApi21.getChildCount(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public int getId(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompatApi21.getId(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public int getLayer(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompatApi21.getLayer(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public java.lang.Object getParent(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompatApi21.getParent(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public java.lang.Object getRoot(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompatApi21.getRoot(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public int getType(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompatApi21.getType(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public boolean isAccessibilityFocused(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompatApi21.isAccessibilityFocused(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public boolean isActive(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompatApi21.isActive(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public boolean isFocused(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompatApi21.isFocused(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public java.lang.Object obtain() {
            return com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompatApi21.obtain();
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public void recycle(java.lang.Object obj) {
            com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompatApi21.recycle(obj);
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public java.lang.Object obtain(java.lang.Object obj) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompatApi21.obtain(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private interface AccessibilityWindowInfoImpl {
        void getBoundsInScreen(java.lang.Object obj, android.graphics.Rect rect);

        java.lang.Object getChild(java.lang.Object obj, int i);

        int getChildCount(java.lang.Object obj);

        int getId(java.lang.Object obj);

        int getLayer(java.lang.Object obj);

        java.lang.Object getParent(java.lang.Object obj);

        java.lang.Object getRoot(java.lang.Object obj);

        int getType(java.lang.Object obj);

        boolean isAccessibilityFocused(java.lang.Object obj);

        boolean isActive(java.lang.Object obj);

        boolean isFocused(java.lang.Object obj);

        java.lang.Object obtain();

        java.lang.Object obtain(java.lang.Object obj);

        void recycle(java.lang.Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class AccessibilityWindowInfoStubImpl implements com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl {
        private AccessibilityWindowInfoStubImpl() {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public void getBoundsInScreen(java.lang.Object obj, android.graphics.Rect rect) {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public java.lang.Object getChild(java.lang.Object obj, int i) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public int getChildCount(java.lang.Object obj) {
            return 0;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public int getId(java.lang.Object obj) {
            return -1;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public int getLayer(java.lang.Object obj) {
            return -1;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public java.lang.Object getParent(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public java.lang.Object getRoot(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public int getType(java.lang.Object obj) {
            return -1;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public boolean isAccessibilityFocused(java.lang.Object obj) {
            return true;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public boolean isActive(java.lang.Object obj) {
            return true;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public boolean isFocused(java.lang.Object obj) {
            return true;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public java.lang.Object obtain() {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public java.lang.Object obtain(java.lang.Object obj) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
        public void recycle(java.lang.Object obj) {
        }
    }

    private AccessibilityWindowInfoCompat(java.lang.Object obj) {
        this.mInfo = obj;
    }

    public static com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat obtain() {
        return wrapNonNullInstance(IMPL.obtain());
    }

    private static java.lang.String typeToString(int i) {
        if (i == 1) {
            return "TYPE_APPLICATION";
        }
        if (i == 2) {
            return "TYPE_INPUT_METHOD";
        }
        if (i != 3) {
            return i != 4 ? "<UNKNOWN>" : "TYPE_ACCESSIBILITY_OVERLAY";
        }
        return "TYPE_SYSTEM";
    }

    static com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat wrapNonNullInstance(java.lang.Object obj) {
        if (obj != null) {
            return new com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat) obj;
        java.lang.Object obj2 = this.mInfo;
        if (obj2 == null) {
            if (accessibilityWindowInfoCompat.mInfo != null) {
                return false;
            }
        } else if (!obj2.equals(accessibilityWindowInfoCompat.mInfo)) {
            return false;
        }
        return true;
    }

    public void getBoundsInScreen(android.graphics.Rect rect) {
        IMPL.getBoundsInScreen(this.mInfo, rect);
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat getChild(int i) {
        return wrapNonNullInstance(IMPL.getChild(this.mInfo, i));
    }

    public int getChildCount() {
        return IMPL.getChildCount(this.mInfo);
    }

    public int getId() {
        return IMPL.getId(this.mInfo);
    }

    public int getLayer() {
        return IMPL.getLayer(this.mInfo);
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat getParent() {
        return wrapNonNullInstance(IMPL.getParent(this.mInfo));
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat getRoot() {
        return com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat.wrapNonNullInstance(IMPL.getRoot(this.mInfo));
    }

    public int getType() {
        return IMPL.getType(this.mInfo);
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

    public boolean isActive() {
        return IMPL.isActive(this.mInfo);
    }

    public boolean isFocused() {
        return IMPL.isFocused(this.mInfo);
    }

    public void recycle() {
        IMPL.recycle(this.mInfo);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("AccessibilityWindowInfo[id=");
        android.graphics.Rect rect = new android.graphics.Rect();
        getBoundsInScreen(rect);
        sb.append(getId());
        sb.append(", type=");
        sb.append(typeToString(getType()));
        sb.append(", layer=");
        sb.append(getLayer());
        sb.append(", bounds=");
        sb.append(rect);
        sb.append(", focused=");
        sb.append(isFocused());
        sb.append(", active=");
        sb.append(isActive());
        sb.append(", hasParent=");
        sb.append(getParent() != null);
        sb.append(", hasChildren=");
        sb.append(getChildCount() > 0);
        sb.append(com.taobao.weex.el.parse.Operators.ARRAY_END);
        return sb.toString();
    }

    public static com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat obtain(com.dcloud.android.v4.view.accessibility.AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        return wrapNonNullInstance(IMPL.obtain(accessibilityWindowInfoCompat.mInfo));
    }
}
