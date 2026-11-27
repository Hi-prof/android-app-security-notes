package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class FrameBitmapView extends android.view.View {
    public static java.lang.String BOLD = "bold";
    public static java.lang.String ITALIC = "italic";
    public static java.lang.String NORMAL = "normal";
    private boolean isInit;
    private float mBitmapCX;
    private float mBitmapCY;
    private int mCutIndex;
    private android.graphics.RectF mCutRectF;
    private float mFontCX;
    private float mFontCY;
    private int mHeight;
    private io.dcloud.common.adapter.ui.FrameBitmapView.ClearAnimationListener mListener;
    private io.dcloud.common.DHInterface.INativeBitmap mNativeBitmap;
    private android.graphics.Paint mPaint;
    private float mScale;
    private boolean mStopAnimation;
    android.graphics.RectF mTextRect;
    private java.lang.String mTextValue;
    private java.lang.String mTexts;
    private int mWidth;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface ClearAnimationListener {
        void onAnimationEnd();
    }

    public FrameBitmapView(android.app.Activity activity) {
        super(activity);
        this.mTextRect = null;
        this.mCutIndex = 0;
        this.isInit = false;
        this.mStopAnimation = false;
        this.mPaint = new android.graphics.Paint();
    }

    static /* synthetic */ int access$208(io.dcloud.common.adapter.ui.FrameBitmapView frameBitmapView) {
        int i = frameBitmapView.mCutIndex;
        frameBitmapView.mCutIndex = i + 1;
        return i;
    }

    public static float getFontHeight(android.graphics.Paint paint) {
        android.graphics.Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) java.lang.Math.ceil(fontMetrics.bottom - fontMetrics.top);
    }

    public static float getFontLeading(android.graphics.Paint paint) {
        android.graphics.Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.leading - fontMetrics.ascent;
    }

    public static float getFontlength(android.graphics.Paint paint, java.lang.String str) {
        return paint.measureText(str);
    }

    private void initBitmapXY() {
        float f = this.mWidth;
        float f2 = this.mHeight;
        if (this.mNativeBitmap.getBitmap() != null) {
            this.mBitmapCX = (f / 2.0f) - (this.mNativeBitmap.getBitmap().getWidth() / 2);
            this.mBitmapCY = (f2 / 2.0f) - (this.mNativeBitmap.getBitmap().getHeight() / 2);
        }
    }

    private void initTextData() {
        java.lang.String strOptString;
        java.lang.String strOptString2;
        java.lang.String strOptString3;
        java.lang.String strOptString4 = "";
        if (android.text.TextUtils.isEmpty(this.mTexts)) {
            if (this.mNativeBitmap == null) {
                setVisibility(8);
                return;
            }
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(this.mTexts);
            this.mTextValue = jSONObject.optString("value", "");
            java.lang.String strOptString5 = this.mWidth + "px";
            java.lang.String strOptString6 = "44px";
            java.lang.String strOptString7 = "16px";
            java.lang.String strOptString8 = "#000000";
            java.lang.String strOptString9 = NORMAL;
            java.lang.String strOptString10 = "center";
            java.lang.String strOptString11 = "0px";
            if (jSONObject.has("textRect")) {
                org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("textRect");
                strOptString = jSONObject2.optString("top", "0px");
                strOptString2 = jSONObject2.optString("left", "0px");
                strOptString5 = jSONObject2.optString("width", strOptString5);
                strOptString6 = jSONObject2.optString("height", "44px");
            } else {
                strOptString = "0px";
                strOptString2 = strOptString;
            }
            if (jSONObject.has("textStyles")) {
                org.json.JSONObject jSONObject3 = jSONObject.getJSONObject("textStyles");
                strOptString7 = jSONObject3.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "16px");
                strOptString8 = jSONObject3.optString("color", "#000000");
                strOptString3 = jSONObject3.optString("weight", strOptString9);
                strOptString9 = jSONObject3.optString("style", strOptString9);
                strOptString4 = jSONObject3.optString(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY, "");
                strOptString10 = jSONObject3.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ALIGN, "center");
                strOptString11 = jSONObject3.optString("margin", "0px");
            } else {
                strOptString3 = strOptString9;
            }
            int i = this.mWidth;
            int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString2, i, i, this.mScale);
            int i2 = this.mHeight;
            int iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString, i2, i2, this.mScale);
            int i3 = this.mWidth;
            int iConvertToScreenInt3 = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString5, i3, i3, this.mScale);
            int i4 = this.mHeight;
            int iConvertToScreenInt4 = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString6, i4, i4, this.mScale);
            int i5 = this.mHeight;
            int iConvertToScreenInt5 = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString7, i5, i5, this.mScale);
            int iConvertToScreenInt6 = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString11, iConvertToScreenInt3, iConvertToScreenInt4, this.mScale);
            this.mPaint.setTextSize(iConvertToScreenInt5);
            this.mPaint.setColor(io.dcloud.common.util.PdrUtil.stringToColor(strOptString8));
            if (!android.text.TextUtils.isEmpty(strOptString4)) {
                this.mPaint.setTypeface(android.graphics.Typeface.create(strOptString4, 0));
            }
            this.mTextRect = new android.graphics.RectF(iConvertToScreenInt + iConvertToScreenInt6, iConvertToScreenInt2 + iConvertToScreenInt6, iConvertToScreenInt3 - iConvertToScreenInt6, iConvertToScreenInt4 - iConvertToScreenInt6);
            this.mPaint.setFakeBoldText(strOptString3.equals(BOLD));
            if (strOptString9.equals(ITALIC)) {
                this.mPaint.setTextSkewX(-0.5f);
            }
            float fontlength = getFontlength(this.mPaint, this.mTextValue);
            float fontHeight = getFontHeight(this.mPaint);
            if (strOptString10.equals("right")) {
                android.graphics.RectF rectF = this.mTextRect;
                this.mFontCX = rectF.right - fontlength;
                this.mFontCY = rectF.top + (((int) (rectF.height() - fontHeight)) / 2);
            } else if (strOptString10.equals("left")) {
                android.graphics.RectF rectF2 = this.mTextRect;
                this.mFontCX = rectF2.left;
                this.mFontCY = rectF2.top + (((int) (rectF2.height() - fontHeight)) / 2);
            } else {
                android.graphics.RectF rectF3 = this.mTextRect;
                this.mFontCX = rectF3.left + (((int) (rectF3.width() - fontlength)) / 2);
                android.graphics.RectF rectF4 = this.mTextRect;
                this.mFontCY = rectF4.top + (((int) (rectF4.height() - fontHeight)) / 2);
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public void clearData() {
        this.mNativeBitmap = null;
        this.mTextValue = null;
        this.mFontCX = 0.0f;
        this.mFontCY = 0.0f;
        this.mCutIndex = 0;
        this.mCutRectF = null;
        this.mListener = null;
        this.mStopAnimation = false;
        this.isInit = false;
    }

    public void configurationChanged(int i, int i2) {
        if (this.mNativeBitmap != null) {
            this.mWidth = i;
            this.mHeight = i2;
            initBitmapXY();
            initTextData();
            invalidate();
        }
    }

    public void injectionData(java.lang.Object obj, java.lang.String str, int i, int i2, float f) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mTexts = str;
        this.mScale = f;
        this.mNativeBitmap = (io.dcloud.common.DHInterface.INativeBitmap) obj;
        this.isInit = true;
        initBitmapXY();
        initTextData();
        bringToFront();
        invalidate();
    }

    public boolean isInit() {
        return this.isInit;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        this.mPaint.setAntiAlias(true);
        canvas.save();
        android.graphics.RectF rectF = this.mCutRectF;
        if (rectF != null) {
            canvas.clipRect(rectF);
        }
        canvas.restore();
        io.dcloud.common.DHInterface.INativeBitmap iNativeBitmap = this.mNativeBitmap;
        if (iNativeBitmap != null && iNativeBitmap.getBitmap() != null) {
            canvas.save();
            canvas.drawBitmap(this.mNativeBitmap.getBitmap(), this.mBitmapCX, this.mBitmapCY, this.mPaint);
            canvas.restore();
        }
        if (android.text.TextUtils.isEmpty(this.mTextValue)) {
            return;
        }
        canvas.save();
        canvas.clipRect(this.mTextRect);
        io.dcloud.common.adapter.util.CanvasHelper.drawString(canvas, this.mTextValue, (int) this.mFontCX, (int) this.mFontCY, 17, this.mPaint);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return true;
    }

    public void runClearAnimation(int i, int i2, io.dcloud.common.adapter.ui.FrameBitmapView.ClearAnimationListener clearAnimationListener) {
        this.mListener = clearAnimationListener;
        runClearAnimation(i, i2);
    }

    public void setStopAnimation(boolean z) {
        this.mStopAnimation = z;
    }

    public void runClearAnimation(final int i, final int i2) {
        postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.FrameBitmapView.1
            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.common.adapter.ui.FrameBitmapView.this.mStopAnimation) {
                    if (io.dcloud.common.adapter.ui.FrameBitmapView.this.mListener != null) {
                        io.dcloud.common.adapter.ui.FrameBitmapView.this.mListener.onAnimationEnd();
                        return;
                    }
                    return;
                }
                io.dcloud.common.adapter.ui.FrameBitmapView.access$208(io.dcloud.common.adapter.ui.FrameBitmapView.this);
                int height = io.dcloud.common.adapter.ui.FrameBitmapView.this.mNativeBitmap.getBitmap().getHeight();
                io.dcloud.common.adapter.ui.FrameBitmapView.this.mCutRectF = new android.graphics.RectF(0.0f, (height / i) * io.dcloud.common.adapter.ui.FrameBitmapView.this.mCutIndex, io.dcloud.common.adapter.ui.FrameBitmapView.this.mNativeBitmap.getBitmap().getWidth(), height);
                io.dcloud.common.adapter.ui.FrameBitmapView.this.invalidate();
                int i3 = io.dcloud.common.adapter.ui.FrameBitmapView.this.mCutIndex;
                int i4 = i;
                if (i3 < i4) {
                    io.dcloud.common.adapter.ui.FrameBitmapView.this.runClearAnimation(i4, i2);
                } else if (io.dcloud.common.adapter.ui.FrameBitmapView.this.mListener != null) {
                    io.dcloud.common.adapter.ui.FrameBitmapView.this.mListener.onAnimationEnd();
                }
            }
        }, i2);
    }
}
