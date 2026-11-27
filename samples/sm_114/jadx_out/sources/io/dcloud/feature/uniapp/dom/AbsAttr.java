package io.dcloud.feature.uniapp.dom;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsAttr implements java.util.Map<java.lang.String, java.lang.Object>, java.lang.Cloneable {
    private static final long serialVersionUID = -2619357510079360946L;
    private java.util.Map<java.lang.String, java.lang.Object> attr;
    private androidx.collection.ArrayMap<java.lang.String, java.lang.Object> mBindingAttrs;
    private com.taobao.weex.dom.binding.WXStatement mStatement;
    private java.util.Map<java.lang.String, java.lang.Object> writeAttr;

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract io.dcloud.feature.uniapp.dom.AbsAttr mo400clone();

    public java.util.Map<java.lang.String, java.lang.Object> getAttr() {
        return this.attr;
    }

    public AbsAttr() {
        this.attr = new java.util.HashMap();
    }

    public AbsAttr(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.attr = map;
    }

    public AbsAttr(java.util.Map<java.lang.String, java.lang.Object> map, int i) {
        this.attr = map;
    }

    public static java.lang.String getPrefix(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj;
        if (map == null || (obj = map.get(com.taobao.weex.common.Constants.Name.PREFIX)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static java.lang.String getSuffix(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj;
        if (map == null || (obj = map.get(com.taobao.weex.common.Constants.Name.SUFFIX)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static java.lang.String getValue(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null) {
            return null;
        }
        java.lang.Object obj = map.get("value");
        if (obj == null && (obj = map.get(com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME)) == null) {
            return null;
        }
        return obj.toString();
    }

    public com.taobao.weex.dom.WXImageQuality getImageQuality() {
        java.lang.String str = com.taobao.weex.common.Constants.Name.QUALITY;
        if (!containsKey(com.taobao.weex.common.Constants.Name.QUALITY)) {
            str = com.taobao.weex.common.Constants.Name.IMAGE_QUALITY;
        }
        java.lang.Object obj = get(str);
        com.taobao.weex.dom.WXImageQuality wXImageQuality = com.taobao.weex.dom.WXImageQuality.AUTO;
        if (obj != null) {
            java.lang.String string = obj.toString();
            if (!android.text.TextUtils.isEmpty(string)) {
                try {
                    return com.taobao.weex.dom.WXImageQuality.valueOf(string.toUpperCase(java.util.Locale.US));
                } catch (java.lang.IllegalArgumentException unused) {
                    com.taobao.weex.utils.WXLogUtils.e("Image", "Invalid value image quality. Only low, normal, high, original are valid");
                }
            }
        }
        return wXImageQuality;
    }

    public com.taobao.weex.common.WXImageSharpen getImageSharpen() {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.SHARPEN);
        if (obj == null) {
            obj = get(com.taobao.weex.common.Constants.Name.IMAGE_SHARPEN);
        }
        if (obj == null) {
            return com.taobao.weex.common.WXImageSharpen.UNSHARPEN;
        }
        return obj.toString().equals(com.taobao.weex.common.Constants.Name.SHARPEN) ? com.taobao.weex.common.WXImageSharpen.SHARPEN : com.taobao.weex.common.WXImageSharpen.UNSHARPEN;
    }

    public java.lang.String getImageSrc() {
        java.lang.Object obj = get("src");
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public boolean canRecycled() {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.RECYCLE);
        if (obj == null) {
            return true;
        }
        try {
            return java.lang.Boolean.parseBoolean(java.lang.String.valueOf(obj));
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXAttr] recycle:", e);
            return true;
        }
    }

    public boolean showIndicators() {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.SHOW_INDICATORS);
        if (obj == null) {
            return true;
        }
        try {
            return java.lang.Boolean.parseBoolean(java.lang.String.valueOf(obj));
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXAttr] showIndicators:", e);
            return true;
        }
    }

    public boolean autoPlay() {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.AUTO_PLAY);
        if (obj == null) {
            return false;
        }
        try {
            return java.lang.Boolean.parseBoolean(java.lang.String.valueOf(obj));
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXAttr] autoPlay:", e);
            return false;
        }
    }

    public java.lang.String getScope() {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.SCOPE);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public java.lang.String getLoadMoreRetry() {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.LOADMORERETRY);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public java.lang.String getLoadMoreOffset() {
        java.lang.Object obj = get("loadmoreoffset");
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public java.lang.String optString(java.lang.String str) {
        if (containsKey(str)) {
            java.lang.Object obj = get(str);
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            if (obj != null) {
                return java.lang.String.valueOf(obj);
            }
            return "";
        }
        return "";
    }

    public boolean getIsRecycleImage() {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.RECYCLE_IMAGE);
        if (obj == null) {
            return true;
        }
        try {
            return java.lang.Boolean.parseBoolean(java.lang.String.valueOf(obj));
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXAttr] recycleImage:", e);
            return false;
        }
    }

    public java.lang.String getScrollDirection() {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.SCROLL_DIRECTION);
        if (obj == null) {
            return "vertical";
        }
        return obj.toString();
    }

    public int getOrientation() {
        java.lang.String scrollDirection = getScrollDirection();
        if (!android.text.TextUtils.isEmpty(scrollDirection) && scrollDirection.equals(com.taobao.weex.common.Constants.Value.HORIZONTAL)) {
            return 0;
        }
        java.lang.Object obj = get("orientation");
        return (obj == null || !com.taobao.weex.common.Constants.Value.HORIZONTAL.equals(obj.toString())) ? 1 : 0;
    }

    public float getElevation(float f) {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.ELEVATION);
        if (obj == null) {
            return Float.NaN;
        }
        java.lang.String string = obj.toString();
        if (android.text.TextUtils.isEmpty(string)) {
            return 0.0f;
        }
        return com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(string), f);
    }

    public float getColumnWidth() {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.COLUMN_WIDTH);
        if (obj == null) {
            return -1.0f;
        }
        java.lang.String strValueOf = java.lang.String.valueOf(obj);
        if ("auto".equals(strValueOf)) {
            return -1.0f;
        }
        try {
            float f = java.lang.Float.parseFloat(strValueOf);
            if (f > 0.0f) {
                return f;
            }
            return 0.0f;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXAttr] getColumnWidth:", e);
            return -1.0f;
        }
    }

    public int getColumnCount() {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.COLUMN_COUNT);
        if (obj == null) {
            return -1;
        }
        java.lang.String strValueOf = java.lang.String.valueOf(obj);
        if ("auto".equals(strValueOf)) {
            return -1;
        }
        try {
            int i = java.lang.Integer.parseInt(strValueOf);
            if (i > 0) {
                return i;
            }
            return -1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXAttr] getColumnCount:", e);
            return -1;
        }
    }

    public float getColumnGap() {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.COLUMN_GAP);
        if (obj == null) {
            return 32.0f;
        }
        java.lang.String strValueOf = java.lang.String.valueOf(obj);
        if ("normal".equals(strValueOf)) {
            return 32.0f;
        }
        try {
            float f = java.lang.Float.parseFloat(strValueOf);
            if (f >= 0.0f) {
                return f;
            }
            return -1.0f;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXAttr] getColumnGap:", e);
            return 32.0f;
        }
    }

    public int getLayoutType() {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.LAYOUT);
        if (obj == null) {
            return 1;
        }
        try {
            java.lang.String strValueOf = java.lang.String.valueOf(obj);
            int iHashCode = strValueOf.hashCode();
            if (iHashCode != 3181382) {
                if (iHashCode == 674874986 && strValueOf.equals(com.taobao.weex.common.Constants.Value.MULTI_COLUMN)) {
                    return 3;
                }
            } else if (strValueOf.equals(com.taobao.weex.common.Constants.Value.GRID)) {
                return 2;
            }
            return 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXAttr] getLayoutType:", e);
            return 1;
        }
    }

    @Override // java.util.Map
    public boolean equals(java.lang.Object obj) {
        return this.attr.equals(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.attr.hashCode();
    }

    @Override // java.util.Map
    public void clear() {
        this.attr.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(java.lang.Object obj) {
        return this.attr.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(java.lang.Object obj) {
        return this.attr.containsValue(obj);
    }

    @Override // java.util.Map
    public java.util.Set<java.util.Map.Entry<java.lang.String, java.lang.Object>> entrySet() {
        return this.attr.entrySet();
    }

    @Override // java.util.Map
    public java.lang.Object get(java.lang.Object obj) {
        java.lang.Object obj2;
        java.util.Map<java.lang.String, java.lang.Object> map = this.writeAttr;
        return (map == null || (obj2 = map.get(obj)) == null) ? this.attr.get(obj) : obj2;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.attr.isEmpty();
    }

    @Override // java.util.Map
    public java.util.Set<java.lang.String> keySet() {
        return this.attr.keySet();
    }

    @Override // java.util.Map
    public java.lang.Object put(java.lang.String str, java.lang.Object obj) {
        if (addBindingAttrIfStatement(str, obj)) {
            return null;
        }
        return this.attr.put(str, obj);
    }

    @Override // java.util.Map
    public void putAll(java.util.Map<? extends java.lang.String, ? extends java.lang.Object> map) {
        if (this.writeAttr == null) {
            this.writeAttr = new androidx.collection.ArrayMap();
        }
        this.writeAttr.putAll(map);
    }

    @Override // java.util.Map
    public java.lang.Object remove(java.lang.Object obj) {
        return this.attr.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.attr.size();
    }

    @Override // java.util.Map
    public java.util.Collection<java.lang.Object> values() {
        return this.attr.values();
    }

    public androidx.collection.ArrayMap<java.lang.String, java.lang.Object> getBindingAttrs() {
        return this.mBindingAttrs;
    }

    public com.taobao.weex.dom.binding.WXStatement getStatement() {
        return this.mStatement;
    }

    public void setBindingAttrs(androidx.collection.ArrayMap<java.lang.String, java.lang.Object> arrayMap) {
        this.mBindingAttrs = arrayMap;
    }

    public void setStatement(com.taobao.weex.dom.binding.WXStatement wXStatement) {
        this.mStatement = wXStatement;
    }

    public void parseStatements() {
        java.util.Map<java.lang.String, java.lang.Object> map = this.attr;
        if (map != null) {
            this.attr = filterStatementsFromAttrs(map);
        }
    }

    private java.util.Map<java.lang.String, java.lang.Object> filterStatementsFromAttrs(java.util.Map map) {
        if (map != null && map.size() != 0) {
            java.util.Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
                if (com.taobao.weex.dom.binding.ELUtils.COMPONENT_PROPS.equals(entry.getKey())) {
                    entry.setValue(com.taobao.weex.dom.binding.ELUtils.bindingBlock(entry.getValue()));
                } else if (addBindingAttrIfStatement((java.lang.String) entry.getKey(), entry.getValue())) {
                    it.remove();
                }
            }
        }
        return map;
    }

    private boolean addBindingAttrIfStatement(java.lang.String str, java.lang.Object obj) {
        for (java.lang.String str2 : com.taobao.weex.dom.binding.ELUtils.EXCLUDES_BINDING) {
            if (str.equals(str2)) {
                return false;
            }
        }
        if (com.taobao.weex.dom.binding.ELUtils.isBinding(obj)) {
            if (this.mBindingAttrs == null) {
                this.mBindingAttrs = new androidx.collection.ArrayMap<>();
            }
            this.mBindingAttrs.put(str, com.taobao.weex.dom.binding.ELUtils.bindingBlock(obj));
            return true;
        }
        if (com.taobao.weex.dom.binding.WXStatement.WX_IF.equals(str)) {
            if (this.mStatement == null) {
                this.mStatement = new com.taobao.weex.dom.binding.WXStatement();
            }
            if (obj != null) {
                this.mStatement.put(str, com.taobao.weex.el.parse.Parser.parse(obj.toString()));
            }
            return true;
        }
        if (com.taobao.weex.dom.binding.WXStatement.WX_FOR.equals(str)) {
            if (this.mStatement == null) {
                this.mStatement = new com.taobao.weex.dom.binding.WXStatement();
            }
            java.lang.Object objVforBlock = com.taobao.weex.dom.binding.ELUtils.vforBlock(obj);
            if (objVforBlock != null) {
                this.mStatement.put(str, objVforBlock);
                return true;
            }
        }
        if (com.taobao.weex.dom.binding.WXStatement.WX_ONCE.equals(str)) {
            if (this.mStatement == null) {
                this.mStatement = new com.taobao.weex.dom.binding.WXStatement();
            }
            this.mStatement.put(str, true);
        }
        return false;
    }

    public void skipFilterPutAll(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.attr.putAll(map);
    }

    public void mergeAttr() {
        java.util.Map<java.lang.String, java.lang.Object> map = this.writeAttr;
        if (map != null) {
            this.attr.putAll(map);
            this.writeAttr = null;
        }
    }

    public java.lang.String toString() {
        return this.attr.toString();
    }
}
