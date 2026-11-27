package io.dcloud.feature.uniapp.dom;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsCSSShorthand<T extends java.lang.Enum<? extends io.dcloud.feature.uniapp.dom.AbsCSSShorthand.CSSProperty>> implements java.lang.Cloneable {
    private float[] values;

    public enum CORNER implements io.dcloud.feature.uniapp.dom.AbsCSSShorthand.CSSProperty {
        BORDER_TOP_LEFT,
        BORDER_TOP_RIGHT,
        BORDER_BOTTOM_RIGHT,
        BORDER_BOTTOM_LEFT,
        ALL
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public interface CSSProperty {
    }

    public enum EDGE implements io.dcloud.feature.uniapp.dom.AbsCSSShorthand.CSSProperty {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        ALL
    }

    public enum TYPE {
        MARGIN,
        PADDING,
        BORDER
    }

    public AbsCSSShorthand(float[] fArr) {
        replace(fArr);
    }

    public AbsCSSShorthand() {
        this(false);
    }

    AbsCSSShorthand(boolean z) {
        float[] fArr = new float[java.lang.Math.max(io.dcloud.feature.uniapp.dom.AbsCSSShorthand.EDGE.values().length, io.dcloud.feature.uniapp.dom.AbsCSSShorthand.CORNER.values().length)];
        this.values = fArr;
        if (z) {
            java.util.Arrays.fill(fArr, Float.NaN);
        }
    }

    public void set(java.lang.Enum<? extends io.dcloud.feature.uniapp.dom.AbsCSSShorthand.CSSProperty> r1, float f) {
        setInternal(r1, f);
    }

    public void set(io.dcloud.feature.uniapp.dom.AbsCSSShorthand.CORNER corner, float f) {
        setInternal(corner, f);
    }

    public float get(java.lang.Enum<? extends io.dcloud.feature.uniapp.dom.AbsCSSShorthand.CSSProperty> r1) {
        return getInternal(r1);
    }

    public float get(io.dcloud.feature.uniapp.dom.AbsCSSShorthand.CORNER corner) {
        return getInternal(corner);
    }

    public final void replace(float[] fArr) {
        this.values = fArr;
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public io.dcloud.feature.uniapp.dom.AbsCSSShorthand mo399clone() throws java.lang.CloneNotSupportedException {
        return (io.dcloud.feature.uniapp.dom.AbsCSSShorthand) super.clone();
    }

    private void setInternal(java.lang.Enum<? extends io.dcloud.feature.uniapp.dom.AbsCSSShorthand.CSSProperty> r3, float f) {
        if (r3.name().equals(io.dcloud.feature.uniapp.dom.AbsCSSShorthand.EDGE.ALL.name()) || r3.name().equals(io.dcloud.feature.uniapp.dom.AbsCSSShorthand.CORNER.ALL.name())) {
            java.util.Arrays.fill(this.values, f);
        } else {
            this.values[r3.ordinal()] = f;
        }
    }

    private float getInternal(java.lang.Enum<? extends io.dcloud.feature.uniapp.dom.AbsCSSShorthand.CSSProperty> r3) {
        if (r3.name().equals(io.dcloud.feature.uniapp.dom.AbsCSSShorthand.EDGE.ALL.name()) || r3.name().equals(io.dcloud.feature.uniapp.dom.AbsCSSShorthand.CORNER.ALL.name())) {
            return 0.0f;
        }
        return this.values[r3.ordinal()];
    }

    public java.lang.String toString() {
        return android.text.TextUtils.isEmpty(this.values.toString()) ? "" : java.util.Arrays.toString(this.values);
    }
}
