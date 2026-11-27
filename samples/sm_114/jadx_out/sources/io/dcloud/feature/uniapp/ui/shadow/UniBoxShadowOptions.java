package io.dcloud.feature.uniapp.ui.shadow;

/* JADX INFO: loaded from: classes2.dex */
public class UniBoxShadowOptions {
    private static final java.lang.String TAG = "UniBoxShadowOptions";
    public float hShadow;
    public java.util.List<io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions.IParser> optionParamParsers;
    public float vShadow;
    private float viewport;
    public float blur = 0.0f;
    public float spread = 0.0f;
    public float[] radii = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    public int color = -16777216;
    public boolean isInset = false;
    public int viewWidth = 0;
    public int viewHeight = 0;
    public android.graphics.PointF topLeft = null;

    public interface IParser {
        void parse(java.lang.String str);
    }

    public UniBoxShadowOptions(float f) {
        this.viewport = 750.0f;
        if (750.0f != 0.0f) {
            this.viewport = f;
        }
        this.optionParamParsers = new java.util.ArrayList();
        io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions.IParser iParser = new io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions.IParser() { // from class: io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions.1
            @Override // io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions.IParser
            public void parse(java.lang.String str) {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                float fFloatValue = com.taobao.weex.utils.WXUtils.getFloat(str, java.lang.Float.valueOf(0.0f)).floatValue();
                io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions uniBoxShadowOptions = io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions.this;
                uniBoxShadowOptions.spread = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(fFloatValue, uniBoxShadowOptions.viewport);
                com.taobao.weex.utils.WXLogUtils.w(io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions.TAG, "Experimental box-shadow attribute: spread");
            }
        };
        this.optionParamParsers.add(new io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions.IParser() { // from class: io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions.2
            @Override // io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions.IParser
            public void parse(java.lang.String str) {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                float fFloatValue = com.taobao.weex.utils.WXUtils.getFloat(str, java.lang.Float.valueOf(0.0f)).floatValue();
                io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions uniBoxShadowOptions = io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions.this;
                uniBoxShadowOptions.blur = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(fFloatValue, uniBoxShadowOptions.viewport);
            }
        });
        this.optionParamParsers.add(iParser);
    }

    public io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions scale(float f) {
        if (f <= 0.0f || f > 1.0f) {
            return null;
        }
        io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions uniBoxShadowOptions = new io.dcloud.feature.uniapp.ui.shadow.UniBoxShadowOptions(this.viewport);
        uniBoxShadowOptions.hShadow = this.hShadow * f;
        uniBoxShadowOptions.vShadow = this.vShadow * f;
        uniBoxShadowOptions.blur = this.blur * f;
        uniBoxShadowOptions.spread = this.spread * f;
        int i = 0;
        while (true) {
            float[] fArr = this.radii;
            if (i >= fArr.length) {
                break;
            }
            uniBoxShadowOptions.radii[i] = fArr[i] * f;
            i++;
        }
        uniBoxShadowOptions.viewHeight = (int) (this.viewHeight * f);
        uniBoxShadowOptions.viewWidth = (int) (this.viewWidth * f);
        if (this.topLeft != null) {
            android.graphics.PointF pointF = new android.graphics.PointF();
            uniBoxShadowOptions.topLeft = pointF;
            pointF.x = this.topLeft.x * f;
            uniBoxShadowOptions.topLeft.y = this.topLeft.y * f;
        }
        uniBoxShadowOptions.color = this.color;
        uniBoxShadowOptions.isInset = this.isInset;
        com.taobao.weex.utils.WXLogUtils.d(TAG, "Scaled BoxShadowOptions: [" + f + "] " + uniBoxShadowOptions);
        return uniBoxShadowOptions;
    }

    public android.graphics.Rect getTargetCanvasRect() {
        return new android.graphics.Rect(0, 0, this.viewWidth + (((int) (this.blur + this.spread + java.lang.Math.abs(this.hShadow))) * 2), this.viewHeight + (((int) (this.blur + this.spread + java.lang.Math.abs(this.vShadow))) * 2));
    }

    public java.lang.String toString() {
        java.lang.String str = com.taobao.weex.el.parse.Operators.ARRAY_START_STR + this.radii[0] + "," + this.radii[2] + "," + this.radii[4] + "," + this.radii[6] + com.taobao.weex.el.parse.Operators.ARRAY_END_STR;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("BoxShadowOptions{h-shadow=");
        stringBuffer.append(this.hShadow);
        stringBuffer.append(", v-shadow=").append(this.vShadow);
        stringBuffer.append(", blur=").append(this.blur);
        stringBuffer.append(", spread=").append(this.spread);
        stringBuffer.append(", corner-radius=").append(str);
        stringBuffer.append(", color=#").append(java.lang.Integer.toHexString(this.color));
        stringBuffer.append(", inset=").append(this.isInset);
        stringBuffer.append(com.taobao.weex.el.parse.Operators.BLOCK_END);
        return stringBuffer.toString();
    }
}
