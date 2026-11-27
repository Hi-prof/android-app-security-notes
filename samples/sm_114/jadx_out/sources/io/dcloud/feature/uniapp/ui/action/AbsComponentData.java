package io.dcloud.feature.uniapp.ui.action;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsComponentData<T extends android.view.View> {
    protected io.dcloud.feature.uniapp.dom.AbsAttr mAttributes;
    private io.dcloud.feature.uniapp.dom.AbsCSSShorthand mBorders;
    public java.lang.String mComponentType;
    protected io.dcloud.feature.uniapp.dom.AbsEvent mEvents;
    private io.dcloud.feature.uniapp.dom.AbsCSSShorthand mMargins;
    private io.dcloud.feature.uniapp.dom.AbsCSSShorthand mPaddings;
    public java.lang.String mParentRef;
    public java.lang.String mRef;
    protected io.dcloud.feature.uniapp.dom.AbsStyle mStyles;
    protected long renderObjectPr = 0;

    @Override // 
    /* JADX INFO: renamed from: clone */
    public abstract io.dcloud.feature.uniapp.ui.action.AbsComponentData<T> mo403clone() throws java.lang.CloneNotSupportedException;

    public AbsComponentData(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.mRef = str;
        this.mComponentType = str2;
        this.mParentRef = str3;
    }

    public void addStyle(java.util.Map<java.lang.String, java.lang.Object> map) {
        addStyle(map, false);
    }

    public final void addStyle(java.util.Map<java.lang.String, java.lang.Object> map, boolean z) {
        if (map == null || map.isEmpty()) {
            return;
        }
        io.dcloud.feature.uniapp.dom.AbsStyle absStyle = this.mStyles;
        if (absStyle == null) {
            this.mStyles = new com.taobao.weex.dom.WXStyle(map);
        } else {
            absStyle.putAll(map, z);
        }
    }

    public final void addAttr(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        io.dcloud.feature.uniapp.dom.AbsAttr absAttr = this.mAttributes;
        if (absAttr == null) {
            this.mAttributes = new com.taobao.weex.dom.WXAttr(map, 0);
        } else {
            absAttr.putAll(map);
        }
    }

    public final void addEvent(java.util.Set<java.lang.String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        if (this.mEvents == null) {
            this.mEvents = new com.taobao.weex.dom.WXEvent();
        }
        this.mEvents.addAll(set);
    }

    public final void addShorthand(float[] fArr, io.dcloud.feature.uniapp.dom.AbsCSSShorthand.TYPE type) {
        if (fArr == null) {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        }
        if (fArr.length == 4) {
            int i = io.dcloud.feature.uniapp.ui.action.AbsComponentData.AnonymousClass1.$SwitchMap$io$dcloud$feature$uniapp$dom$AbsCSSShorthand$TYPE[type.ordinal()];
            if (i == 1) {
                io.dcloud.feature.uniapp.dom.AbsCSSShorthand absCSSShorthand = this.mMargins;
                if (absCSSShorthand == null) {
                    this.mMargins = new com.taobao.weex.dom.CSSShorthand(fArr);
                    return;
                } else {
                    absCSSShorthand.replace(fArr);
                    return;
                }
            }
            if (i == 2) {
                io.dcloud.feature.uniapp.dom.AbsCSSShorthand absCSSShorthand2 = this.mPaddings;
                if (absCSSShorthand2 == null) {
                    this.mPaddings = new com.taobao.weex.dom.CSSShorthand(fArr);
                    return;
                } else {
                    absCSSShorthand2.replace(fArr);
                    return;
                }
            }
            if (i != 3) {
                return;
            }
            io.dcloud.feature.uniapp.dom.AbsCSSShorthand absCSSShorthand3 = this.mBorders;
            if (absCSSShorthand3 == null) {
                this.mBorders = new com.taobao.weex.dom.CSSShorthand(fArr);
            } else {
                absCSSShorthand3.replace(fArr);
            }
        }
    }

    /* JADX INFO: renamed from: io.dcloud.feature.uniapp.ui.action.AbsComponentData$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$dcloud$feature$uniapp$dom$AbsCSSShorthand$TYPE;

        static {
            int[] iArr = new int[io.dcloud.feature.uniapp.dom.AbsCSSShorthand.TYPE.values().length];
            $SwitchMap$io$dcloud$feature$uniapp$dom$AbsCSSShorthand$TYPE = iArr;
            try {
                iArr[io.dcloud.feature.uniapp.dom.AbsCSSShorthand.TYPE.MARGIN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$dcloud$feature$uniapp$dom$AbsCSSShorthand$TYPE[io.dcloud.feature.uniapp.dom.AbsCSSShorthand.TYPE.PADDING.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$dcloud$feature$uniapp$dom$AbsCSSShorthand$TYPE[io.dcloud.feature.uniapp.dom.AbsCSSShorthand.TYPE.BORDER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public final void addShorthand(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            java.lang.String key = it.next().getKey();
            key.hashCode();
            switch (key) {
                case "borderRightWidth":
                    addBorder(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT, io.dcloud.feature.uniapp.utils.UniUtils.fastGetFloat(map.get(key)));
                    break;
                case "paddingLeft":
                    addPadding(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT, io.dcloud.feature.uniapp.utils.UniUtils.fastGetFloat(map.get(key)));
                    break;
                case "borderTopWidth":
                    addBorder(com.taobao.weex.dom.CSSShorthand.EDGE.TOP, io.dcloud.feature.uniapp.utils.UniUtils.fastGetFloat(map.get(key)));
                    break;
                case "borderBottomWidth":
                    addBorder(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM, io.dcloud.feature.uniapp.utils.UniUtils.fastGetFloat(map.get(key)));
                    break;
                case "margin":
                    addMargin(com.taobao.weex.dom.CSSShorthand.EDGE.ALL, io.dcloud.feature.uniapp.utils.UniUtils.fastGetFloat(map.get(key)));
                    break;
                case "marginTop":
                    addMargin(com.taobao.weex.dom.CSSShorthand.EDGE.TOP, io.dcloud.feature.uniapp.utils.UniUtils.fastGetFloat(map.get(key)));
                    break;
                case "padding":
                    addPadding(com.taobao.weex.dom.CSSShorthand.EDGE.ALL, io.dcloud.feature.uniapp.utils.UniUtils.fastGetFloat(map.get(key)));
                    break;
                case "marginBottom":
                    addMargin(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM, io.dcloud.feature.uniapp.utils.UniUtils.fastGetFloat(map.get(key)));
                    break;
                case "borderLeftWidth":
                    addBorder(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT, io.dcloud.feature.uniapp.utils.UniUtils.fastGetFloat(map.get(key)));
                    break;
                case "paddingTop":
                    addPadding(com.taobao.weex.dom.CSSShorthand.EDGE.TOP, io.dcloud.feature.uniapp.utils.UniUtils.fastGetFloat(map.get(key)));
                    break;
                case "paddingBottom":
                    addPadding(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM, io.dcloud.feature.uniapp.utils.UniUtils.fastGetFloat(map.get(key)));
                    break;
                case "paddingRight":
                    addPadding(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT, io.dcloud.feature.uniapp.utils.UniUtils.fastGetFloat(map.get(key)));
                    break;
                case "borderWidth":
                    addBorder(com.taobao.weex.dom.CSSShorthand.EDGE.ALL, io.dcloud.feature.uniapp.utils.UniUtils.fastGetFloat(map.get(key)));
                    break;
                case "marginRight":
                    addMargin(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT, io.dcloud.feature.uniapp.utils.UniUtils.fastGetFloat(map.get(key)));
                    break;
                case "marginLeft":
                    addMargin(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT, io.dcloud.feature.uniapp.utils.UniUtils.fastGetFloat(map.get(key)));
                    break;
            }
        }
    }

    private void addMargin(com.taobao.weex.dom.CSSShorthand.EDGE edge, float f) {
        if (this.mMargins == null) {
            this.mMargins = new com.taobao.weex.dom.CSSShorthand();
        }
        this.mMargins.set(edge, f);
    }

    private void addPadding(com.taobao.weex.dom.CSSShorthand.EDGE edge, float f) {
        if (this.mPaddings == null) {
            this.mPaddings = new com.taobao.weex.dom.CSSShorthand();
        }
        this.mPaddings.set(edge, f);
    }

    private void addBorder(com.taobao.weex.dom.CSSShorthand.EDGE edge, float f) {
        if (this.mBorders == null) {
            this.mBorders = new com.taobao.weex.dom.CSSShorthand();
        }
        this.mBorders.set(edge, f);
    }

    public io.dcloud.feature.uniapp.dom.AbsStyle getStyles() {
        if (this.mStyles == null) {
            this.mStyles = new com.taobao.weex.dom.WXStyle();
        }
        return this.mStyles;
    }

    public io.dcloud.feature.uniapp.dom.AbsAttr getAttrs() {
        if (this.mAttributes == null) {
            this.mAttributes = new com.taobao.weex.dom.WXAttr();
        }
        return this.mAttributes;
    }

    public io.dcloud.feature.uniapp.dom.AbsEvent getEvents() {
        if (this.mEvents == null) {
            this.mEvents = new com.taobao.weex.dom.WXEvent();
        }
        return this.mEvents;
    }

    public io.dcloud.feature.uniapp.dom.AbsCSSShorthand getMargin() {
        if (this.mMargins == null) {
            this.mMargins = new com.taobao.weex.dom.CSSShorthand();
        }
        return this.mMargins;
    }

    public io.dcloud.feature.uniapp.dom.AbsCSSShorthand getPadding() {
        if (this.mPaddings == null) {
            this.mPaddings = new com.taobao.weex.dom.CSSShorthand();
        }
        return this.mPaddings;
    }

    public io.dcloud.feature.uniapp.dom.AbsCSSShorthand getBorder() {
        if (this.mBorders == null) {
            this.mBorders = new com.taobao.weex.dom.CSSShorthand();
        }
        return this.mBorders;
    }

    public final void setMargins(com.taobao.weex.dom.CSSShorthand cSSShorthand) {
        this.mMargins = cSSShorthand;
    }

    public final void setPaddings(com.taobao.weex.dom.CSSShorthand cSSShorthand) {
        this.mPaddings = cSSShorthand;
    }

    public final void setBorders(com.taobao.weex.dom.CSSShorthand cSSShorthand) {
        this.mBorders = cSSShorthand;
    }

    public long getRenderObjectPr() {
        return this.renderObjectPr;
    }

    public boolean isRenderPtrEmpty() {
        return this.renderObjectPr == 0;
    }

    public synchronized void setRenderObjectPr(long j) {
        long j2 = this.renderObjectPr;
        if (j2 != j) {
            if (j2 != 0) {
                throw new java.lang.RuntimeException("RenderObjectPr has " + j + " old renderObjectPtr " + this.renderObjectPr);
            }
            this.renderObjectPr = j;
        }
    }
}
