package io.dcloud.feature.uniapp.dom;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsStyle implements java.util.Map<java.lang.String, java.lang.Object>, java.lang.Cloneable {
    public static final int UNSET = -1;
    private static final long serialVersionUID = 611132641365274134L;
    protected androidx.collection.ArrayMap<java.lang.String, java.lang.Object> mBindingStyle;
    protected java.util.Map<java.lang.String, java.lang.Object> mPesudoResetStyleMap;
    protected java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> mPesudoStyleMap;
    protected java.util.Map<java.lang.String, java.lang.Object> mStyles;

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract io.dcloud.feature.uniapp.dom.AbsStyle mo401clone();

    public AbsStyle() {
        this.mStyles = new androidx.collection.ArrayMap();
    }

    public AbsStyle(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.mStyles = map;
        processPesudoClasses(map);
    }

    public AbsStyle(java.util.Map<java.lang.String, java.lang.Object> map, boolean z) {
        this();
        putAll(map, z);
    }

    public java.lang.String getBlur() {
        if (get(com.taobao.weex.common.Constants.Name.FILTER) == null) {
            return null;
        }
        return get(com.taobao.weex.common.Constants.Name.FILTER).toString().trim();
    }

    public static com.taobao.weex.ui.component.WXTextDecoration getTextDecoration(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj;
        if (map == null || (obj = map.get(com.taobao.weex.common.Constants.Name.TEXT_DECORATION)) == null) {
            return com.taobao.weex.ui.component.WXTextDecoration.NONE;
        }
        java.lang.String string = obj.toString();
        string.hashCode();
        switch (string) {
            case "line-through":
                return com.taobao.weex.ui.component.WXTextDecoration.LINETHROUGH;
            case "underline":
                return com.taobao.weex.ui.component.WXTextDecoration.UNDERLINE;
            case "none":
                return com.taobao.weex.ui.component.WXTextDecoration.NONE;
            default:
                return com.taobao.weex.ui.component.WXTextDecoration.INVALID;
        }
    }

    public static java.lang.String getTextColor(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj;
        if (map == null || (obj = map.get("color")) == null) {
            return "";
        }
        return obj.toString();
    }

    public static int getFontWeight(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj;
        if (map != null && (obj = map.get(com.taobao.weex.common.Constants.Name.FONT_WEIGHT)) != null) {
            java.lang.String string = obj.toString();
            string.hashCode();
            switch (string) {
                case "600":
                case "700":
                case "800":
                case "900":
                case "bold":
                    return 1;
            }
        }
        return 0;
    }

    public static int getFontStyle(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj;
        return (map == null || (obj = map.get(com.taobao.weex.common.Constants.Name.FONT_STYLE)) == null || !obj.toString().equals(com.taobao.weex.common.Constants.Value.ITALIC)) ? 0 : 2;
    }

    public static int getFontSize(java.util.Map<java.lang.String, java.lang.Object> map, int i, float f) {
        float realPxByWidth;
        if (map == null) {
            realPxByWidth = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(i, f);
        } else {
            int i2 = com.taobao.weex.utils.WXUtils.getInt(map.get(com.taobao.weex.common.Constants.Name.FONT_SIZE));
            if (i2 > 0) {
                i = i2;
            }
            realPxByWidth = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(i, f);
        }
        return (int) realPxByWidth;
    }

    public static java.lang.String getFontFamily(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj;
        if (map == null || (obj = map.get(com.taobao.weex.common.Constants.Name.FONT_FAMILY)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static android.text.Layout.Alignment getTextAlignment(java.util.Map<java.lang.String, java.lang.Object> map) {
        return getTextAlignment(map, false);
    }

    public static android.text.Layout.Alignment getTextAlignment(java.util.Map<java.lang.String, java.lang.Object> map, boolean z) {
        android.text.Layout.Alignment alignment = z ? android.text.Layout.Alignment.ALIGN_OPPOSITE : android.text.Layout.Alignment.ALIGN_NORMAL;
        java.lang.String str = (java.lang.String) map.get(com.taobao.weex.common.Constants.Name.TEXT_ALIGN);
        if (android.text.TextUtils.equals("left", str)) {
            return android.text.Layout.Alignment.ALIGN_NORMAL;
        }
        if (android.text.TextUtils.equals("center", str)) {
            return android.text.Layout.Alignment.ALIGN_CENTER;
        }
        return android.text.TextUtils.equals("right", str) ? android.text.Layout.Alignment.ALIGN_OPPOSITE : alignment;
    }

    public static android.text.TextUtils.TruncateAt getTextOverflow(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (android.text.TextUtils.equals(com.taobao.weex.common.Constants.Name.ELLIPSIS, (java.lang.String) map.get(com.taobao.weex.common.Constants.Name.TEXT_OVERFLOW))) {
            return android.text.TextUtils.TruncateAt.END;
        }
        return null;
    }

    public static int getLines(java.util.Map<java.lang.String, java.lang.Object> map) {
        return com.taobao.weex.utils.WXUtils.getInt(map.get(com.taobao.weex.common.Constants.Name.LINES));
    }

    public static int getLineHeight(java.util.Map<java.lang.String, java.lang.Object> map, float f) {
        int i;
        if (map != null && (i = com.taobao.weex.utils.WXUtils.getInt(map.get(com.taobao.weex.common.Constants.Name.LINE_HEIGHT))) > 0) {
            return (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(i, f);
        }
        return -1;
    }

    public float getBorderRadius() {
        float f = com.taobao.weex.utils.WXUtils.getFloat(get(com.taobao.weex.common.Constants.Name.BORDER_RADIUS));
        if (com.taobao.weex.utils.WXUtils.isUndefined(f)) {
            return Float.NaN;
        }
        return f;
    }

    public java.lang.String getBorderColor() {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.BORDER_COLOR);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public java.lang.String getBorderStyle() {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.BORDER_STYLE);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public boolean isSticky() {
        java.lang.Object obj = get("position");
        if (obj == null) {
            return false;
        }
        return obj.toString().equals("sticky");
    }

    public boolean isFixed() {
        java.lang.Object obj = get("position");
        if (obj == null) {
            return false;
        }
        return obj.toString().equals(com.taobao.weex.common.Constants.Value.FIXED);
    }

    public float getLeft() {
        float f = com.taobao.weex.utils.WXUtils.getFloat(get("left"));
        if (com.taobao.weex.utils.WXUtils.isUndefined(f)) {
            return Float.NaN;
        }
        return f;
    }

    public float getRight() {
        float f = com.taobao.weex.utils.WXUtils.getFloat(get("right"));
        if (com.taobao.weex.utils.WXUtils.isUndefined(f)) {
            return Float.NaN;
        }
        return f;
    }

    public float getTop() {
        float f = com.taobao.weex.utils.WXUtils.getFloat(get("top"));
        if (com.taobao.weex.utils.WXUtils.isUndefined(f)) {
            return Float.NaN;
        }
        return f;
    }

    public float getBottom() {
        float f = com.taobao.weex.utils.WXUtils.getFloat(get("bottom"));
        if (com.taobao.weex.utils.WXUtils.isUndefined(f)) {
            return Float.NaN;
        }
        return f;
    }

    public java.lang.String getBackgroundColor() {
        java.lang.Object obj = get("backgroundColor");
        return obj == null ? "" : obj.toString();
    }

    public int getTimeFontSize(int i) {
        int i2 = com.taobao.weex.utils.WXUtils.getInt(get("timeFontSize"));
        return i2 <= 0 ? i : i2;
    }

    public float getOpacity() {
        java.lang.Object obj = get("opacity");
        if (obj == null) {
            return 1.0f;
        }
        return com.taobao.weex.utils.WXUtils.getFloat(obj);
    }

    public java.lang.String getOverflow() {
        java.lang.Object obj = get(com.taobao.weex.common.Constants.Name.OVERFLOW);
        return obj == null ? "visible" : obj.toString();
    }

    @Override // java.util.Map
    public boolean equals(java.lang.Object obj) {
        return this.mStyles.equals(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.mStyles.hashCode();
    }

    @Override // java.util.Map
    public void clear() {
        this.mStyles.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(java.lang.Object obj) {
        return this.mStyles.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(java.lang.Object obj) {
        return this.mStyles.containsValue(obj);
    }

    @Override // java.util.Map
    public java.util.Set<java.util.Map.Entry<java.lang.String, java.lang.Object>> entrySet() {
        return this.mStyles.entrySet();
    }

    @Override // java.util.Map
    public java.lang.Object get(java.lang.Object obj) {
        return this.mStyles.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.mStyles.isEmpty();
    }

    @Override // java.util.Map
    public java.util.Set<java.lang.String> keySet() {
        return this.mStyles.keySet();
    }

    @Override // java.util.Map
    public java.lang.Object put(java.lang.String str, java.lang.Object obj) {
        if (addBindingStyleIfStatement(str, obj)) {
            return null;
        }
        return this.mStyles.put(str, obj);
    }

    @Override // java.util.Map
    public void putAll(java.util.Map<? extends java.lang.String, ? extends java.lang.Object> map) {
        this.mStyles.putAll(map);
    }

    public void putAll(java.util.Map<? extends java.lang.String, ?> map, boolean z) {
        this.mStyles.putAll(map);
        if (z) {
            return;
        }
        processPesudoClasses(map);
    }

    public void updateStyle(java.util.Map<? extends java.lang.String, ?> map, boolean z) {
        parseBindingStylesStatements(map);
        putAll(map, z);
    }

    public java.util.Map<java.lang.String, java.lang.Object> getPesudoResetStyles() {
        if (this.mPesudoResetStyleMap == null) {
            this.mPesudoResetStyleMap = new androidx.collection.ArrayMap();
        }
        return this.mPesudoResetStyleMap;
    }

    public java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> getPesudoStyles() {
        if (this.mPesudoStyleMap == null) {
            this.mPesudoStyleMap = new androidx.collection.ArrayMap();
        }
        return this.mPesudoStyleMap;
    }

    <T extends java.lang.String, V> void processPesudoClasses(java.util.Map<T, V> map) {
        androidx.collection.ArrayMap arrayMap = null;
        for (java.util.Map.Entry<T, V> entry : map.entrySet()) {
            T key = entry.getKey();
            int iIndexOf = key.indexOf(":");
            if (iIndexOf > 0) {
                initPesudoMapsIfNeed(map);
                java.lang.String strSubstring = key.substring(iIndexOf);
                if (!strSubstring.equals(com.taobao.weex.common.Constants.PSEUDO.ENABLED)) {
                    java.lang.String strReplace = strSubstring.replace(com.taobao.weex.common.Constants.PSEUDO.ENABLED, "");
                    java.util.Map<java.lang.String, java.lang.Object> arrayMap2 = this.mPesudoStyleMap.get(strReplace);
                    if (arrayMap2 == null) {
                        arrayMap2 = new androidx.collection.ArrayMap<>();
                        this.mPesudoStyleMap.put(strReplace, arrayMap2);
                    }
                    arrayMap2.put(key.substring(0, iIndexOf), entry.getValue());
                } else {
                    java.lang.String strSubstring2 = key.substring(0, iIndexOf);
                    if (arrayMap == null) {
                        arrayMap = new androidx.collection.ArrayMap();
                    }
                    arrayMap.put(strSubstring2, entry.getValue());
                    this.mPesudoResetStyleMap.put(strSubstring2, entry.getValue());
                }
            }
        }
        if (arrayMap == null || arrayMap.isEmpty()) {
            return;
        }
        this.mStyles.putAll(arrayMap);
    }

    @Override // java.util.Map
    public java.lang.Object remove(java.lang.Object obj) {
        return this.mStyles.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.mStyles.size();
    }

    @Override // java.util.Map
    public java.util.Collection<java.lang.Object> values() {
        return this.mStyles.values();
    }

    private void initPesudoMapsIfNeed(java.util.Map<? extends java.lang.String, ?> map) {
        if (this.mPesudoStyleMap == null) {
            this.mPesudoStyleMap = new androidx.collection.ArrayMap();
        }
        if (this.mPesudoResetStyleMap == null) {
            this.mPesudoResetStyleMap = new androidx.collection.ArrayMap();
        }
        if (this.mPesudoResetStyleMap.isEmpty()) {
            this.mPesudoResetStyleMap.putAll(map);
        }
    }

    public void parseStatements() {
        java.util.Map<java.lang.String, java.lang.Object> map = this.mStyles;
        if (map != null) {
            this.mStyles = parseBindingStylesStatements(map);
        }
    }

    private java.util.Map<java.lang.String, java.lang.Object> parseBindingStylesStatements(java.util.Map map) {
        if (map != null && map.size() != 0) {
            java.util.Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
                if (addBindingStyleIfStatement((java.lang.String) entry.getKey(), entry.getValue())) {
                    java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> map2 = this.mPesudoStyleMap;
                    if (map2 != null) {
                        map2.remove(entry.getKey());
                    }
                    java.util.Map<java.lang.String, java.lang.Object> map3 = this.mPesudoResetStyleMap;
                    if (map3 != null) {
                        map3.remove(entry.getKey());
                    }
                    it.remove();
                }
            }
        }
        return map;
    }

    private boolean addBindingStyleIfStatement(java.lang.String str, java.lang.Object obj) {
        if (!com.taobao.weex.dom.binding.ELUtils.isBinding(obj)) {
            return false;
        }
        if (this.mBindingStyle == null) {
            this.mBindingStyle = new androidx.collection.ArrayMap<>();
        }
        this.mBindingStyle.put(str, com.taobao.weex.dom.binding.ELUtils.bindingBlock(obj));
        return true;
    }

    public androidx.collection.ArrayMap<java.lang.String, java.lang.Object> getBindingStyle() {
        return this.mBindingStyle;
    }

    public java.lang.String toString() {
        return this.mStyles.toString();
    }
}
