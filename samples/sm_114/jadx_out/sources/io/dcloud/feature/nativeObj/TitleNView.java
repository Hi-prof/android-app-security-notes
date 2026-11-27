package io.dcloud.feature.nativeObj;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class TitleNView extends io.dcloud.feature.nativeObj.NativeView implements io.dcloud.common.DHInterface.ITitleNView {
    private final java.lang.String CLOSE;
    private final java.lang.String MENU;
    private android.widget.LinearLayout centerSearchLayout;
    private android.widget.TextView closeBt;
    private java.util.concurrent.atomic.AtomicBoolean isSetText;
    private io.dcloud.feature.nativeObj.TitleNView.BadgeLinearLayout mBackButton;
    private io.dcloud.feature.nativeObj.TitleNView.BackGroundDrawable mBackGroundDrawable;
    private android.view.View mBackgroudView;
    private io.dcloud.common.ui.blur.DCBlurDraweeView mBlurDraweeView;
    public java.lang.String mBlurEffect;
    private java.util.ArrayList<java.lang.Object> mButtons;
    private com.dcloud.android.widget.CapsuleLayout mCapsuleLayout;
    private android.widget.TextView mHomeButton;
    protected io.dcloud.feature.nativeObj.TitleNView.IWebviewStateListenerImpl mIWebviewStateListenerImpl;
    private android.widget.LinearLayout mLeftButtonLayout;
    private java.lang.String mMenuButtonFontSize;
    private java.lang.String mMenuButtonFontWeight;
    private int mMenuButtonTextColor;
    private java.util.ArrayList<io.dcloud.feature.nativeObj.data.ButtonDataItem> mMenuButtons;
    private io.dcloud.feature.nativeObj.TitleNView.Progress mProgress;
    private android.widget.LinearLayout mRightButtonLayout;
    private android.view.View mSplitLine;
    private android.widget.RelativeLayout mTitleNViewLayout;
    private android.widget.TextView mTitleView;
    private android.widget.RelativeLayout mTitlelayout;
    public int maxButton;
    private android.widget.TextView menuBt;
    private int redDotColor;
    private android.widget.EditText searchInput;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class BackGroundDrawable extends android.graphics.drawable.Drawable {
        private android.graphics.Rect bound;
        private android.graphics.Paint colorPaint;
        private android.graphics.Paint mPaint;
        private int shadow5PX;
        private android.graphics.Paint shadowPaint;
        private android.graphics.Shader mBackgroundBitmap = null;
        private java.lang.String bitmapPath = null;
        private java.lang.String repeatType = "no-repeat";
        private int mBackgroundColor = 0;
        private java.lang.String shadowColor = "";
        private int shadowColorInt = 0;
        private int height = 0;
        private int offset = 0;

        public BackGroundDrawable() {
            this.shadow5PX = io.dcloud.common.util.PdrUtil.convertToScreenInt("10px", io.dcloud.feature.nativeObj.TitleNView.this.mInnerWidth, 0, io.dcloud.feature.nativeObj.TitleNView.this.mCreateScale);
        }

        private android.graphics.Shader getShader(java.util.List<java.lang.String> list, float f, float f2) {
            float[] gradientDirection = parseGradientDirection(list.get(0).trim(), f, f2);
            if (gradientDirection == null) {
                return null;
            }
            return new android.graphics.LinearGradient(gradientDirection[0], gradientDirection[1], gradientDirection[2], gradientDirection[3], io.dcloud.common.util.PdrUtil.stringToColor(list.get(1).trim()), io.dcloud.common.util.PdrUtil.stringToColor(list.get(2).trim()), android.graphics.Shader.TileMode.CLAMP);
        }

        private android.graphics.Paint getShadowPaint() {
            if (this.shadowPaint == null) {
                this.shadowPaint = new android.graphics.Paint();
            }
            return this.shadowPaint;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:7:0x0032  */
        private float[] parseGradientDirection(java.lang.String str, float f, float f2) {
            byte b = 4;
            float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
            if (!android.text.TextUtils.isEmpty(str)) {
                str = str.replaceAll("\\s*", "").toLowerCase(java.util.Locale.ENGLISH);
            }
            str.getClass();
            str.hashCode();
            switch (str.hashCode()) {
                case -1352032154:
                    if (!str.equals("tobottom")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case -1137407871:
                    if (!str.equals("toright")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case -868157182:
                    if (!str.equals("toleft")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case -172068863:
                    if (!str.equals("totopleft")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 110550266:
                    if (!str.equals("totop")) {
                        b = -1;
                    }
                    break;
                case 1176531318:
                    if (!str.equals("tobottomright")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    fArr[3] = f2;
                    return fArr;
                case 1:
                    fArr[2] = f;
                    return fArr;
                case 2:
                    fArr[0] = f;
                    return fArr;
                case 3:
                    fArr[0] = f;
                    fArr[1] = f2;
                    return fArr;
                case 4:
                    fArr[1] = f2;
                    return fArr;
                case 5:
                    fArr[2] = f;
                    fArr[3] = f2;
                    return fArr;
                default:
                    return null;
            }
        }

        private java.util.List<java.lang.String> parseGradientValues(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            str.getClass();
            try {
                if (str.startsWith("linear-gradient")) {
                    java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str.substring(str.indexOf(com.taobao.weex.el.parse.Operators.BRACKET_START_STR) + 1, str.lastIndexOf(com.taobao.weex.el.parse.Operators.BRACKET_END_STR)), ",");
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    while (true) {
                        java.lang.String str2 = null;
                        while (stringTokenizer.hasMoreTokens()) {
                            java.lang.String strNextToken = stringTokenizer.nextToken();
                            if (strNextToken.contains(com.taobao.weex.el.parse.Operators.BRACKET_START_STR)) {
                                str2 = strNextToken + ",";
                            } else if (strNextToken.contains(com.taobao.weex.el.parse.Operators.BRACKET_END_STR)) {
                                arrayList.add(str2 + strNextToken);
                            } else if (str2 != null) {
                                str2 = str2 + strNextToken + ",";
                            } else {
                                arrayList.add(strNextToken);
                            }
                        }
                        return arrayList;
                    }
                }
            } catch (java.lang.Exception unused) {
            }
            return null;
        }

        private android.graphics.Bitmap scaleBitmap(android.graphics.Bitmap bitmap, int i, int i2) {
            if (bitmap == null) {
                return null;
            }
            if (this.repeatType.equals("repeat")) {
                return bitmap;
            }
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            float f = i / width;
            float f2 = i2 / height;
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            if (this.repeatType.equals("repeat-x")) {
                matrix.preScale(1.0f, f2);
            } else if (this.repeatType.equals("repeat-y")) {
                matrix.preScale(f, 1.0f);
            } else {
                matrix.preScale(f, f2);
            }
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return bitmapCreateBitmap;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(android.graphics.Canvas canvas) {
            updatebound();
            if (this.mBackgroundBitmap != null) {
                getPaint().setShader(this.mBackgroundBitmap);
                getBackgroundColorPaint().setColor(android.graphics.Color.argb(getBackgroundColorPaint().getAlpha(), 255, 255, 255));
                canvas.drawRect(this.bound, getBackgroundColorPaint());
            } else {
                java.lang.String str = this.bitmapPath;
                if (str != null) {
                    setBackgroundImage(str);
                    this.bitmapPath = null;
                    getPaint().setShader(this.mBackgroundBitmap);
                    getBackgroundColorPaint().setColor(android.graphics.Color.argb(getBackgroundColorPaint().getAlpha(), 255, 255, 255));
                    canvas.drawRect(this.bound, getBackgroundColorPaint());
                } else {
                    getPaint().setColor(this.mBackgroundColor);
                }
            }
            canvas.drawRect(this.bound, getPaint());
            if (!io.dcloud.common.util.PdrUtil.isEmpty(this.shadowColor)) {
                android.graphics.Rect rect = this.bound;
                int i = rect.left;
                int i2 = rect.bottom;
                int i3 = rect.right;
                int i4 = this.height;
                if (i4 == 0) {
                    i4 = this.shadow5PX;
                }
                android.graphics.Rect rect2 = new android.graphics.Rect(i, i2, i3, i4 + i2 + this.offset);
                android.graphics.Paint shadowPaint = getShadowPaint();
                int i5 = rect2.top;
                int i6 = this.offset;
                shadowPaint.setShader(new android.graphics.LinearGradient(0.0f, i5 - i6, 0.0f, rect2.bottom - i6, this.shadowColorInt, 0, android.graphics.Shader.TileMode.CLAMP));
                canvas.drawRect(rect2, getShadowPaint());
            }
            if (this.mBackgroundBitmap != null) {
                getPaint().setShader(null);
            }
        }

        public android.graphics.Paint getBackgroundColorPaint() {
            if (this.colorPaint == null) {
                this.colorPaint = new android.graphics.Paint();
            }
            return this.colorPaint;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        public android.graphics.Paint getPaint() {
            if (this.mPaint == null) {
                this.mPaint = new android.graphics.Paint(1);
            }
            return this.mPaint;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            if (this.mBackgroundBitmap == null && this.bitmapPath == null) {
                return;
            }
            getPaint().setAlpha(i);
            getBackgroundColorPaint().setAlpha(i);
        }

        public void setBackgroundColor(int i) {
            if (this.mBackgroundBitmap != null) {
                setAlpha(android.graphics.Color.alpha(i));
            }
            this.mBackgroundColor = i;
            getShadowPaint().setAlpha(android.graphics.Color.alpha(i));
            invalidateSelf();
        }

        public void setBackgroundImage(java.lang.String str) {
            android.graphics.Bitmap bitmapDecodeStream;
            android.graphics.Bitmap bitmapScaleBitmap;
            android.graphics.Rect rect = this.bound;
            if (rect == null || rect.width() == 0) {
                this.bitmapPath = str;
                return;
            }
            if (str == null) {
                return;
            }
            java.util.List<java.lang.String> gradientValues = parseGradientValues(str);
            if (gradientValues == null || gradientValues.size() != 3) {
                java.lang.String strConvert2AbsFullPath = io.dcloud.feature.nativeObj.TitleNView.this.mWebView.obtainApp().convert2AbsFullPath(io.dcloud.feature.nativeObj.TitleNView.this.mWebView.obtainFullUrl(), str);
                if (io.dcloud.common.util.PdrUtil.isDeviceRootDir(strConvert2AbsFullPath)) {
                    bitmapDecodeStream = android.graphics.BitmapFactory.decodeFile(strConvert2AbsFullPath);
                } else {
                    try {
                        bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(io.dcloud.feature.nativeObj.TitleNView.this.mWebView.getContext().getAssets().open(strConvert2AbsFullPath));
                    } catch (java.lang.Exception unused) {
                        bitmapDecodeStream = null;
                    }
                }
                if (bitmapDecodeStream == null) {
                    this.mBackgroundBitmap = null;
                    this.bitmapPath = null;
                    invalidateSelf();
                    return;
                }
                byte[] ninePatchChunk = bitmapDecodeStream.getNinePatchChunk();
                if (ninePatchChunk == null || !android.graphics.NinePatch.isNinePatchChunk(ninePatchChunk)) {
                    bitmapScaleBitmap = scaleBitmap(bitmapDecodeStream, this.bound.width(), this.bound.height());
                } else {
                    android.graphics.drawable.NinePatchDrawable ninePatchDrawable = new android.graphics.drawable.NinePatchDrawable(bitmapDecodeStream, ninePatchChunk, new android.graphics.Rect(), null);
                    bitmapScaleBitmap = android.graphics.Bitmap.createBitmap(this.bound.width(), this.bound.height(), android.graphics.Bitmap.Config.ARGB_8888);
                    android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapScaleBitmap);
                    ninePatchDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    ninePatchDrawable.draw(canvas);
                }
                if (bitmapScaleBitmap == null) {
                    this.mBackgroundBitmap = null;
                } else {
                    android.graphics.Shader.TileMode tileMode = android.graphics.Shader.TileMode.REPEAT;
                    this.mBackgroundBitmap = new android.graphics.BitmapShader(bitmapScaleBitmap, tileMode, tileMode);
                }
            } else {
                this.mBackgroundBitmap = getShader(gradientValues, this.bound.width(), this.bound.height());
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        }

        public void setRepeatType(java.lang.String str, java.lang.String str2) {
            if (io.dcloud.common.util.PdrUtil.isEmpty(str) || this.repeatType.equals(str)) {
                return;
            }
            this.repeatType = str;
            this.mBackgroundBitmap = null;
            updatebound();
            setBackgroundImage(str2);
        }

        public void updatebound() {
            android.view.View view;
            if (this.bound == null) {
                this.bound = new android.graphics.Rect();
            }
            io.dcloud.feature.nativeObj.TitleNView titleNView = io.dcloud.feature.nativeObj.TitleNView.this;
            if (titleNView.isImmersed && titleNView.isStatusBarHas()) {
                this.bound.top = io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
            } else {
                this.bound.top = 0;
            }
            io.dcloud.feature.nativeObj.TitleNView titleNView2 = io.dcloud.feature.nativeObj.TitleNView.this;
            if (titleNView2.isStatusBar && (view = titleNView2.mStatusbarView) != null && view.getVisibility() == 0) {
                this.bound.top = io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
            }
            android.graphics.Rect rect = this.bound;
            io.dcloud.feature.nativeObj.TitleNView titleNView3 = io.dcloud.feature.nativeObj.TitleNView.this;
            int i = titleNView3.mInnerHeight;
            rect.bottom = rect.top + i;
            if (titleNView3.isStatusBar && titleNView3.isImmersed) {
                rect.bottom = i + io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
            }
            rect.left = 0;
            rect.right = getBounds().right;
        }

        public void setShadowColor(org.json.JSONObject jSONObject) {
            java.lang.String strOptString = jSONObject.has("color") ? jSONObject.optString("color") : "";
            java.lang.String strOptString2 = jSONObject.has("height") ? jSONObject.optString("height") : "10px";
            java.lang.String strOptString3 = jSONObject.has("offset") ? jSONObject.optString("offset") : "0px";
            io.dcloud.feature.nativeObj.TitleNView titleNView = io.dcloud.feature.nativeObj.TitleNView.this;
            this.height = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString2, titleNView.mInnerWidth, 0, titleNView.mCreateScale);
            io.dcloud.feature.nativeObj.TitleNView titleNView2 = io.dcloud.feature.nativeObj.TitleNView.this;
            this.offset = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString3, titleNView2.mInnerWidth, 0, titleNView2.mCreateScale);
            if (strOptString.equals(this.shadowColor)) {
                return;
            }
            this.shadowColor = strOptString;
            this.shadowColorInt = io.dcloud.common.util.PdrUtil.stringToColor(strOptString);
            invalidateSelf();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class IWebviewStateListenerImpl implements io.dcloud.common.DHInterface.IWebviewStateListener {
        private java.lang.ref.SoftReference<io.dcloud.feature.nativeObj.TitleNView.Progress> mProgress;

        public IWebviewStateListenerImpl(io.dcloud.feature.nativeObj.TitleNView.Progress progress) {
            this.mProgress = new java.lang.ref.SoftReference<>(progress);
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            if (this.mProgress.get() == null || this.mProgress.get().getParent() == null || this.mProgress.get().getVisibility() != 0) {
                return null;
            }
            if (i == 3) {
                this.mProgress.get().updateProgress(((java.lang.Integer) obj).intValue());
                return null;
            }
            if ((i != 1 && i != 5) || this.mProgress.get() == null || this.mProgress.get().isFinish()) {
                return null;
            }
            this.mProgress.get().finishProgress();
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class Progress extends com.dcloud.android.widget.DCProgressView {
        Progress(android.content.Context context) {
            super(context);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class SearchInputDrawable extends android.graphics.drawable.Drawable {
        private android.graphics.Paint mPaint;
        private int radius;

        public SearchInputDrawable(int i, int i2) {
            android.graphics.Paint paint = new android.graphics.Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(i);
            this.radius = i2;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(android.graphics.Canvas canvas) {
            android.graphics.RectF rectF = new android.graphics.RectF(getBounds());
            float f = this.radius;
            canvas.drawRoundRect(rectF, f, f, this.mPaint);
        }

        @Override // android.graphics.drawable.Drawable
        public int getAlpha() {
            return this.mPaint.getAlpha();
        }

        public int getDrawableColor() {
            android.graphics.Paint paint = this.mPaint;
            if (paint != null) {
                return paint.getColor();
            }
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.mPaint.setAlpha(i);
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(android.graphics.ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        public void setDrawableColor(int i) {
            android.graphics.Paint paint = this.mPaint;
            if (paint != null) {
                paint.setColor(i);
            }
            invalidateSelf();
        }
    }

    public TitleNView(android.content.Context context, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
        super(context, iWebview, str, str2, jSONObject);
        this.mTitleView = null;
        this.mBackButton = null;
        this.mHomeButton = null;
        this.mTitleNViewLayout = null;
        this.mLeftButtonLayout = null;
        this.mRightButtonLayout = null;
        this.centerSearchLayout = null;
        this.mButtons = new java.util.ArrayList<>();
        this.mMenuButtonTextColor = -16777216;
        this.mMenuButtonFontSize = "22px";
        this.mMenuButtonFontWeight = "normal";
        this.maxButton = 2;
        this.mBlurEffect = "none";
        this.isSetText = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.menuBt = null;
        this.closeBt = null;
        this.CLOSE = io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE;
        this.MENU = io.dcloud.common.constant.AbsoluteConst.EVENTS_MENU;
        setTag("titleNView");
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            initCapsuleLayout();
        }
    }

    private void addButtonOnClickListener(final java.lang.String str, final io.dcloud.common.DHInterface.IWebview iWebview, android.view.View view) {
        view.setOnClickListener(new android.view.View.OnClickListener() { // from class: io.dcloud.feature.nativeObj.TitleNView.12
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view2) {
                io.dcloud.feature.nativeObj.TitleNView.this.buttonOnclick(str, iWebview);
            }
        });
    }

    private android.widget.TextView addSelect(android.view.ViewGroup viewGroup, android.widget.TextView textView, int i) {
        android.widget.TextView textView2 = new android.widget.TextView(getContext());
        textView2.setText("\ue661");
        textView2.setTypeface(android.graphics.Typeface.createFromAsset(getContext().getAssets(), "fonts/dcloud_iconfont.ttf"));
        textView2.setSingleLine();
        textView2.setLines(1);
        textView2.setGravity(17);
        textView2.setIncludeFontPadding(false);
        textView2.getPaint().setTextSize(io.dcloud.common.util.PdrUtil.convertToScreenInt("15px", this.mInnerWidth, i, this.mCreateScale));
        viewGroup.addView(textView2, new android.widget.LinearLayout.LayoutParams(-2, -1));
        return textView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buttonOnclick(java.lang.String str, io.dcloud.common.DHInterface.IWebview iWebview) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (str.toLowerCase(java.util.Locale.ENGLISH).startsWith(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT)) {
            io.dcloud.common.DHInterface.IFrameView iFrameView = this.mFrameViewParent;
            if (iFrameView != null && iFrameView.obtainWindowMgr() != null && this.mFrameViewParent.obtainApp() != null) {
                java.lang.Object objProcessEvent = this.mFrameViewParent.obtainWindowMgr().processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 47, this.mFrameViewParent.obtainApp().obtainAppId());
                if (objProcessEvent instanceof io.dcloud.common.DHInterface.IFrameView) {
                    io.dcloud.common.DHInterface.IFrameView iFrameView2 = (io.dcloud.common.DHInterface.IFrameView) objProcessEvent;
                    if (iFrameView2.obtainWebView() != null && iFrameView2.obtainWebView().obtainWindowView() != null) {
                        iFrameView2.obtainWebView().loadUrl(str);
                        return;
                    }
                }
            }
            io.dcloud.common.DHInterface.IWebview iWebview2 = this.mWebView;
            if (iWebview2 != null && iWebview2.obtainWindowView() != null) {
                this.mWebView.loadUrl(str);
                return;
            } else if (iWebview != null && iWebview.obtainWindowView() != null) {
                iWebview.loadUrl(str);
                return;
            }
        }
        if (iWebview != null) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, "", io.dcloud.common.util.JSUtil.OK, false, true);
            if (iWebview.getOpener() != null) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview.getOpener(), str, "", io.dcloud.common.util.JSUtil.OK, false, true);
            }
        }
    }

    private void caculateTitleMargin() {
        android.widget.RelativeLayout relativeLayout = this.mTitlelayout;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt("10px", this.mInnerWidth, 0, this.mCreateScale);
            initLeftButtonLayout();
            initRightButtonLayout();
            int width = this.mLeftButtonLayout.getWidth();
            int width2 = this.mRightButtonLayout.getWidth();
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.mTitlelayout.getLayoutParams();
            int i = iConvertToScreenInt / 2;
            int i2 = this.mInnerHeight - i;
            android.widget.TextView textView = this.mTitleView;
            int iMin = ((int) java.lang.Math.min(((this.mTitleNViewLayout.getWidth() - i2) - (textView != null ? textView.getPaint().measureText("张磊 ") : 0.0f)) / 2.0f, java.lang.Math.max(width, width2))) + i;
            if (layoutParams.rightMargin == iMin) {
                return;
            }
            int[] rules = layoutParams.getRules();
            if (rules == null || rules.length <= 0 || rules[1] <= 0) {
                layoutParams.rightMargin = iMin;
                layoutParams.leftMargin = iMin;
            } else {
                layoutParams.rightMargin = iMin;
            }
            this.mTitlelayout.setLayoutParams(layoutParams);
            this.mTitlelayout.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void capsuleButtonClick(java.lang.String str) {
        io.dcloud.common.DHInterface.IWebview iWebview = this.mWebView;
        if (iWebview == null || iWebview.obtainFrameView() == null) {
            return;
        }
        str.getClass();
        if (str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_MENU)) {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("appid", this.mWebView.obtainApp().obtainAppId());
            bundle.putString("type", io.dcloud.common.constant.AbsoluteConst.EVENTS_MENU);
            io.dcloud.common.DHInterface.IWebview iWebview2 = this.mWebView;
            iWebview2.obtainFrameView().obtainWindowMgr().processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 80, new java.lang.Object[]{iWebview2, bundle});
            if (io.dcloud.common.adapter.util.UniMPConfig.isCapsuleMenuIntercept) {
                return;
            }
            showCapsuleMenu(getMenuArray());
            return;
        }
        if (!str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE)) {
            throw new java.lang.IllegalStateException("Unexpected value: " + str);
        }
        android.os.Bundle bundle2 = new android.os.Bundle();
        bundle2.putString("appid", this.mWebView.obtainApp().obtainAppId());
        bundle2.putString("type", io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE);
        io.dcloud.common.DHInterface.IWebview iWebview3 = this.mWebView;
        java.lang.Object[] objArr = {iWebview3, bundle2};
        io.dcloud.common.DHInterface.AbsMgr absMgrObtainWindowMgr = iWebview3.obtainFrameView().obtainWindowMgr();
        io.dcloud.common.DHInterface.IMgr.MgrType mgrType = io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr;
        absMgrObtainWindowMgr.processEvent(mgrType, 80, objArr);
        if (io.dcloud.common.adapter.util.UniMPConfig.isCapsuleCloseIntercept) {
            return;
        }
        this.mWebView.obtainFrameView().obtainWindowMgr().processEvent(mgrType, 20, this.mWebView.obtainApp().obtainAppId());
    }

    private android.view.View createButton(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str9, java.lang.String str10, boolean z, java.lang.String str11, boolean z2, java.lang.String str12, java.lang.String str13) {
        int iStringToColor;
        int iStringToColor2;
        java.lang.String str14;
        int iStringToColor3;
        int iConvertToScreenInt;
        io.dcloud.feature.nativeObj.TitleNView.BadgeRelateiveLayout badgeRelateiveLayout = new io.dcloud.feature.nativeObj.TitleNView.BadgeRelateiveLayout(this, getContext(), this.mCreateScale, this.redDotColor);
        badgeRelateiveLayout.setOrientation(0);
        badgeRelateiveLayout.setGravity(17);
        badgeRelateiveLayout.setPadding(0, 0, 0, 0);
        android.widget.TextView textView = new android.widget.TextView(getContext());
        textView.setGravity(17);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TitleNView.Button.");
        sb.append(str == null ? "" : str);
        textView.setTag(sb.toString());
        textView.setId(android.view.View.generateViewId());
        textView.setSingleLine();
        textView.setLines(1);
        textView.setIncludeFontPadding(false);
        if (!io.dcloud.common.util.PdrUtil.isEmpty(str12) && (iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(str12, this.mAppScreenWidth, 0, this.mCreateScale)) > 0) {
            textView.setEllipsize(android.text.TextUtils.TruncateAt.END);
            textView.setMaxWidth(iConvertToScreenInt);
        }
        try {
            iStringToColor = android.graphics.Color.parseColor(str2);
        } catch (java.lang.Exception unused) {
            iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(str2);
        }
        try {
            iStringToColor2 = android.graphics.Color.parseColor(str3);
        } catch (java.lang.Exception unused2) {
            iStringToColor2 = io.dcloud.common.util.PdrUtil.stringToColor(str3);
        }
        int i = iStringToColor2;
        textView.setTextColor(createColorStateList(iStringToColor, i));
        if (com.taobao.weex.common.Constants.Value.BOLD.equals(str4)) {
            textView.getPaint().setFakeBoldText(true);
        }
        setTextAndFont(str, str6, str7, textView, android.text.TextUtils.isEmpty(str7));
        if (android.text.TextUtils.isEmpty(str5)) {
            str14 = "transparent".equals(str9) ? "22px" : "27px";
        } else {
            str14 = "17px";
        }
        int iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt(str14, this.mInnerWidth, 0, this.mCreateScale);
        textView.getPaint().setTextSize(io.dcloud.common.util.PdrUtil.convertToScreenInt(str5, this.mInnerWidth, iConvertToScreenInt2, this.mCreateScale));
        try {
            iStringToColor3 = android.graphics.Color.parseColor(str10);
        } catch (java.lang.Exception unused3) {
            iStringToColor3 = io.dcloud.common.util.PdrUtil.stringToColor(str10);
        }
        io.dcloud.feature.nativeObj.NativeViewBackButtonDrawable nativeViewBackButtonDrawable = new io.dcloud.feature.nativeObj.NativeViewBackButtonDrawable("transparent".equals(str9) ? iStringToColor3 : 0);
        nativeViewBackButtonDrawable.setWidth(str13);
        badgeRelateiveLayout.addView(textView, new android.widget.LinearLayout.LayoutParams(-2, -1, 1.0f));
        if (z2) {
            addSelect(badgeRelateiveLayout, textView, iConvertToScreenInt2).setTextColor(createColorStateList(iStringToColor, i));
            textView.setEllipsize(android.text.TextUtils.TruncateAt.END);
        }
        badgeRelateiveLayout.setBackground(nativeViewBackButtonDrawable);
        addButtonOnClickListener(str8, iWebview, badgeRelateiveLayout);
        badgeRelateiveLayout.setBadgeStr(str11);
        badgeRelateiveLayout.setDrawRedDot(z);
        this.mButtons.add(badgeRelateiveLayout);
        return badgeRelateiveLayout;
    }

    private android.content.res.ColorStateList createColorStateList(int i, int i2) {
        return new android.content.res.ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled, android.R.attr.state_focused}, new int[]{android.R.attr.state_enabled}, new int[]{android.R.attr.state_focused}, new int[]{android.R.attr.state_window_focused}, new int[0]}, new int[]{i2, i, i, i, i, i});
    }

    private android.widget.TextView getCapsuleButton(java.lang.String str) {
        android.widget.TextView textView = new android.widget.TextView(getContext());
        textView.setGravity(17);
        textView.setId(android.view.View.generateViewId());
        textView.setSingleLine();
        textView.setLines(1);
        textView.setIncludeFontPadding(false);
        textView.getPaint().setFakeBoldText(true);
        textView.getPaint().setTextSize(io.dcloud.common.util.PdrUtil.convertToScreenInt("19px", this.mInnerWidth, 0, this.mCreateScale));
        android.graphics.Typeface typefaceCreateFromAsset = android.graphics.Typeface.createFromAsset(getContext().getAssets(), "fonts/dcloud_iconfont.ttf");
        if (typefaceCreateFromAsset != null) {
            textView.setTypeface(typefaceCreateFromAsset);
        }
        return textView;
    }

    private java.lang.String getIconPath(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isNetPath(str)) {
            return str;
        }
        java.lang.String strConvert2AbsFullPath = this.mApp.convert2AbsFullPath(this.mWebView.obtainFullUrl(), str);
        if (strConvert2AbsFullPath != null && io.dcloud.common.util.PdrUtil.isDeviceRootDir(strConvert2AbsFullPath)) {
            return io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + strConvert2AbsFullPath;
        }
        if (strConvert2AbsFullPath != null && strConvert2AbsFullPath.startsWith("/") && strConvert2AbsFullPath.length() > 1) {
            strConvert2AbsFullPath = strConvert2AbsFullPath.substring(1);
        }
        return io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET + strConvert2AbsFullPath;
    }

    private org.json.JSONArray getMenuArray() {
        org.json.JSONObject jSONObject;
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        for (int i = 0; i < this.mMenuButtons.size(); i++) {
            io.dcloud.feature.nativeObj.data.ButtonDataItem buttonDataItem = this.mMenuButtons.get(i);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                jSONObject2.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, android.text.TextUtils.isEmpty(buttonDataItem.getTitle()) ? buttonDataItem.getText() : buttonDataItem.getTitle());
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject2);
        }
        if (this.mMenuButtons.size() > 0) {
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            try {
                jSONObject3.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "");
                jSONObject3.put("type", "interval");
                jSONArray.put(jSONObject3);
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (io.dcloud.feature.internal.sdk.SDK.sDefaultMenuButton != null) {
            try {
                org.json.JSONObject jSONObject4 = new org.json.JSONObject(io.dcloud.feature.internal.sdk.SDK.sDefaultMenuButton);
                if (jSONObject4.has(io.dcloud.common.constant.AbsoluteConst.EVENTS_MENU) && (jSONObject = jSONObject4.getJSONObject(io.dcloud.common.constant.AbsoluteConst.EVENTS_MENU)) != null && jSONObject.has("buttons")) {
                    org.json.JSONArray jSONArray2 = jSONObject.getJSONArray("buttons");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        jSONArray.put(jSONArray2.getJSONObject(i2));
                    }
                }
            } catch (org.json.JSONException e3) {
                e3.printStackTrace();
            }
        }
        return jSONArray;
    }

    private void initCapsuleLayout() {
        org.json.JSONObject jSONObject;
        if (this.mCapsuleLayout == null && io.dcloud.feature.internal.sdk.SDK.isCapsule) {
            this.mMenuButtons = new java.util.ArrayList<>();
            int iConvertToScreenInt = this.mInnerHeight - io.dcloud.common.util.PdrUtil.convertToScreenInt("12px", this.mAppScreenWidth, 0, this.mCreateScale);
            com.dcloud.android.widget.CapsuleLayout capsuleLayout = new com.dcloud.android.widget.CapsuleLayout(getContext(), iConvertToScreenInt / 2);
            this.mCapsuleLayout = capsuleLayout;
            capsuleLayout.setId(android.view.View.generateViewId());
            this.mCapsuleLayout.setGravity(16);
            this.mCapsuleLayout.setOrientation(0);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, iConvertToScreenInt);
            layoutParams.addRule(15);
            layoutParams.addRule(11);
            float f = this.mCreateScale;
            int i = (int) (13.0f * f);
            int i2 = (int) (f * 10.0f);
            layoutParams.rightMargin = i;
            initTitleNViewLayout();
            this.mTitleNViewLayout.addView(this.mCapsuleLayout, layoutParams);
            if (this.menuBt == null) {
                android.widget.TextView capsuleButton = getCapsuleButton(io.dcloud.common.constant.AbsoluteConst.EVENTS_MENU);
                this.menuBt = capsuleButton;
                capsuleButton.setText("\ue606");
            }
            this.menuBt.setTextColor(-16777216);
            android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = i;
            layoutParams2.gravity = 17;
            layoutParams2.rightMargin = i2;
            this.mCapsuleLayout.addButtonView(this.menuBt, layoutParams2, com.dcloud.android.widget.CapsuleLayout.ButtonType.LIFT, new android.view.View.OnClickListener() { // from class: io.dcloud.feature.nativeObj.TitleNView.13
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    io.dcloud.feature.nativeObj.TitleNView.this.capsuleButtonClick(io.dcloud.common.constant.AbsoluteConst.EVENTS_MENU);
                }
            });
            this.mCapsuleLayout.addIntervalView(this.mCreateScale);
            if (this.closeBt == null) {
                android.widget.TextView capsuleButton2 = getCapsuleButton(io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE);
                this.closeBt = capsuleButton2;
                capsuleButton2.setText("\ue650");
            }
            this.closeBt.setTextColor(-16777216);
            android.widget.LinearLayout.LayoutParams layoutParams3 = new android.widget.LinearLayout.LayoutParams(-2, -2);
            layoutParams3.rightMargin = i;
            layoutParams3.gravity = 17;
            layoutParams3.leftMargin = i2;
            this.mCapsuleLayout.addButtonView(this.closeBt, layoutParams3, com.dcloud.android.widget.CapsuleLayout.ButtonType.RIGHT, new android.view.View.OnClickListener() { // from class: io.dcloud.feature.nativeObj.TitleNView.14
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    io.dcloud.feature.nativeObj.TitleNView.this.capsuleButtonClick(io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE);
                }
            });
            if (android.text.TextUtils.isEmpty(io.dcloud.feature.internal.sdk.SDK.sDefaultMenuButton)) {
                return;
            }
            try {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(io.dcloud.feature.internal.sdk.SDK.sDefaultMenuButton);
                if (jSONObject2.has(io.dcloud.common.constant.AbsoluteConst.EVENTS_MENU) && (jSONObject = jSONObject2.getJSONObject(io.dcloud.common.constant.AbsoluteConst.EVENTS_MENU)) != null) {
                    if (jSONObject.has("textColor")) {
                        this.mMenuButtonTextColor = io.dcloud.common.util.PdrUtil.stringToColor(jSONObject.getString("textColor"));
                    }
                    if (jSONObject.has(com.taobao.weex.common.Constants.Name.FONT_SIZE) && !android.text.TextUtils.isEmpty(jSONObject.getString(com.taobao.weex.common.Constants.Name.FONT_SIZE))) {
                        this.mMenuButtonFontSize = jSONObject.getString(com.taobao.weex.common.Constants.Name.FONT_SIZE);
                    }
                    if (jSONObject.has(com.taobao.weex.common.Constants.Name.FONT_WEIGHT)) {
                        if (com.taobao.weex.common.Constants.Value.BOLD.equals(jSONObject.getString(com.taobao.weex.common.Constants.Name.FONT_WEIGHT))) {
                            this.mMenuButtonFontWeight = com.taobao.weex.common.Constants.Value.BOLD;
                        } else {
                            this.mMenuButtonFontWeight = "normal";
                        }
                    }
                }
                if (jSONObject2.has("capsuleButtonStyle")) {
                    setCapsuleButtonStyle(jSONObject2.getJSONObject("capsuleButtonStyle"));
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void initCenterSearchLayout() {
        if (this.centerSearchLayout == null) {
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(getContext());
            this.centerSearchLayout = linearLayout;
            linearLayout.setId(android.view.View.generateViewId());
            this.centerSearchLayout.setGravity(16);
            this.centerSearchLayout.setOrientation(0);
            this.centerSearchLayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -1));
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, this.mInnerHeight - io.dcloud.common.util.PdrUtil.convertToScreenInt("12px", this.mAppScreenWidth, 0, this.mCreateScale));
            android.widget.LinearLayout linearLayout2 = this.mRightButtonLayout;
            if (linearLayout2 != null) {
                layoutParams.addRule(0, linearLayout2.getId());
            } else {
                layoutParams.addRule(11);
            }
            android.widget.LinearLayout linearLayout3 = this.mLeftButtonLayout;
            if (linearLayout3 != null) {
                layoutParams.addRule(1, linearLayout3.getId());
            } else {
                layoutParams.addRule(9);
            }
            layoutParams.addRule(15);
            layoutParams.rightMargin = io.dcloud.common.util.PdrUtil.convertToScreenInt("5px", this.mAppScreenWidth, 0, this.mCreateScale);
            layoutParams.leftMargin = io.dcloud.common.util.PdrUtil.convertToScreenInt("5px", this.mAppScreenWidth, 0, this.mCreateScale);
            this.mTitleNViewLayout.addView(this.centerSearchLayout, layoutParams);
        }
    }

    private void initLeftButtonLayout() {
        if (this.mLeftButtonLayout == null) {
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(getContext());
            this.mLeftButtonLayout = linearLayout;
            linearLayout.setId(android.view.View.generateViewId());
            this.mLeftButtonLayout.setGravity(16);
            this.mLeftButtonLayout.setOrientation(0);
            this.mLeftButtonLayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -1));
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -1);
            layoutParams.addRule(15);
            layoutParams.addRule(9);
            this.mTitleNViewLayout.addView(this.mLeftButtonLayout, layoutParams);
        }
    }

    private void initRightButtonLayout() {
        if (this.mRightButtonLayout == null) {
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(getContext());
            this.mRightButtonLayout = linearLayout;
            linearLayout.setId(android.view.View.generateViewId());
            this.mRightButtonLayout.setGravity(16);
            this.mRightButtonLayout.setOrientation(0);
            this.mRightButtonLayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -1));
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -1);
            layoutParams.addRule(15);
            com.dcloud.android.widget.CapsuleLayout capsuleLayout = this.mCapsuleLayout;
            if (capsuleLayout != null) {
                layoutParams.addRule(0, capsuleLayout.getId());
            } else {
                layoutParams.addRule(11);
            }
            this.mTitleNViewLayout.addView(this.mRightButtonLayout, layoutParams);
        }
    }

    private void initTitleNViewLayout() {
        io.dcloud.common.DHInterface.IFrameView iFrameView;
        if (this.mTitleNViewLayout == null) {
            this.mTitleNViewLayout = new android.widget.RelativeLayout(getContext());
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, this.mInnerHeight);
            android.view.ViewParent parent = getParent();
            int i = 0;
            if (android.text.TextUtils.equals(this.mStyle.optString("position", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE), io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE) || parent == null || !(parent instanceof android.view.ViewGroup)) {
                iFrameView = this.mFrameViewParent;
                if (iFrameView != null && iFrameView.obtainApp().obtainStatusBarMgr().isImmersive) {
                    i = io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                }
            } else {
                int i2 = 0;
                while (true) {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) parent;
                    if (i2 >= viewGroup.getChildCount()) {
                        break;
                    }
                    java.lang.Object tag = viewGroup.getChildAt(i2).getTag();
                    if (tag == null || !"StatusBar".equalsIgnoreCase(tag.toString())) {
                        i2++;
                    }
                }
                iFrameView = this.mFrameViewParent;
                if (iFrameView != null) {
                    i = io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                }
            }
            layoutParams.topMargin = i;
            addView(this.mTitleNViewLayout, layoutParams);
        }
    }

    public static boolean isBase64Image(java.lang.String str) {
        return java.util.regex.Pattern.compile("^data:image/.*;base64,").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isStatusBarHas() {
        io.dcloud.common.DHInterface.IWebview iWebview = this.mWebView;
        if (iWebview == null || iWebview.obtainFrameView() == null) {
            return false;
        }
        return ((io.dcloud.common.adapter.ui.AdaFrameItem) this.mWebView.obtainFrameView()).obtainFrameOptions().isStatusbar;
    }

    private void layoutSubtitleIcon(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, android.widget.ImageView imageView, android.widget.TextView textView, int i, java.lang.String str7, java.lang.String str8) {
        char c;
        pl.droidsonroids.gif.GifDrawable gifDrawable;
        int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt("10px", this.mInnerWidth, 0, this.mCreateScale);
        if (-1 == this.mTitlelayout.indexOfChild(imageView)) {
            this.mTitlelayout.addView(imageView);
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            imageView.setVisibility(8);
        } else {
            int iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt(str8, this.mInnerWidth, 0, this.mCreateScale);
            if (iConvertToScreenInt2 <= 0) {
                iConvertToScreenInt2 = this.mInnerHeight - iConvertToScreenInt;
            }
            int i2 = this.mInnerHeight;
            if (iConvertToScreenInt2 > i2) {
                iConvertToScreenInt2 = i2;
            }
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(iConvertToScreenInt2, iConvertToScreenInt2);
            layoutParams.addRule(9);
            layoutParams.addRule(15);
            layoutParams.rightMargin = iConvertToScreenInt / 2;
            int iConvertToScreenInt3 = io.dcloud.common.util.PdrUtil.convertToScreenInt(str2, this.mInnerWidth, 0, this.mCreateScale);
            boolean zIsBase64Image = isBase64Image(str);
            if (zIsBase64Image) {
                c = 1;
                gifDrawable = new pl.droidsonroids.gif.GifDrawable(android.util.Base64.decode(str.replaceFirst("^data:image/.*;base64,", ""), 0));
            } else {
                c = 1;
                try {
                    gifDrawable = new pl.droidsonroids.gif.GifDrawable(getContext().getContentResolver(), android.net.Uri.parse(getIconPath(str)));
                } catch (java.io.IOException | java.lang.Exception unused) {
                    gifDrawable = null;
                }
            }
            if (iConvertToScreenInt3 <= 0) {
                com.bumptech.glide.RequestManager requestManagerWith = com.bumptech.glide.Glide.with(getContext());
                if (gifDrawable != null) {
                    imageView.setImageDrawable(gifDrawable);
                    imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                } else {
                    requestManagerWith.load(zIsBase64Image ? android.util.Base64.decode(str.replaceFirst("^data:image/.*;base64,", ""), 0) : getIconPath(str)).transform(new com.bumptech.glide.load.resource.bitmap.CenterCrop()).into(imageView);
                }
            } else {
                com.bumptech.glide.RequestManager requestManagerWith2 = com.bumptech.glide.Glide.with(getContext());
                if (gifDrawable != null) {
                    gifDrawable.setTransform(new io.dcloud.feature.nativeObj.GIFCornerRadiusTransform(iConvertToScreenInt3, iConvertToScreenInt2));
                    imageView.setImageDrawable(gifDrawable);
                    imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                } else {
                    com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> requestBuilderLoad = requestManagerWith2.load(zIsBase64Image ? android.util.Base64.decode(str.replaceFirst("^data:image/.*;base64,", ""), 0) : getIconPath(str));
                    com.bumptech.glide.load.resource.bitmap.CenterCrop centerCrop = new com.bumptech.glide.load.resource.bitmap.CenterCrop();
                    com.bumptech.glide.load.resource.bitmap.RoundedCorners roundedCorners = new com.bumptech.glide.load.resource.bitmap.RoundedCorners(iConvertToScreenInt3);
                    com.bumptech.glide.load.Transformation[] transformationArr = new com.bumptech.glide.load.Transformation[2];
                    transformationArr[0] = centerCrop;
                    transformationArr[c] = roundedCorners;
                    requestBuilderLoad.transform(new com.bumptech.glide.load.MultiTransformation(transformationArr)).into(imageView);
                }
            }
            if (-1 == this.mTitlelayout.indexOfChild(imageView)) {
                this.mTitlelayout.addView(imageView, layoutParams);
            } else {
                imageView.setLayoutParams(layoutParams);
            }
            imageView.setVisibility(0);
        }
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(10);
        if (imageView.getVisibility() == 0 || str7.equals("left") || str7.equals("auto")) {
            layoutParams2.addRule(1, imageView.getId());
        } else {
            layoutParams2.addRule(14);
        }
        if (-1 == this.mTitlelayout.indexOfChild(this.mTitleView)) {
            this.mTitlelayout.addView(this.mTitleView, layoutParams2);
        } else {
            this.mTitleView.setLayoutParams(layoutParams2);
        }
        if (-1 == this.mTitlelayout.indexOfChild(textView)) {
            this.mTitlelayout.addView(textView);
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(str3)) {
            textView.setVisibility(8);
        } else {
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(3, this.mTitleView.getId());
            if (imageView.getVisibility() == 0 || str7.equals("left") || str7.equals("auto")) {
                layoutParams3.addRule(1, imageView.getId());
            } else {
                layoutParams3.addRule(14);
            }
            textView.setText(str3);
            if ("clip".equals(str6)) {
                textView.setEllipsize(null);
            } else {
                textView.setEllipsize(android.text.TextUtils.TruncateAt.END);
            }
            textView.setSingleLine();
            textView.setLines(1);
            textView.setTextColor(io.dcloud.common.util.PdrUtil.isEmpty(str4) ? i : io.dcloud.common.util.PdrUtil.stringToColor(str4));
            textView.getPaint().setTextSize(io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.PdrUtil.isEmpty(str5) ? "12px" : str5, this.mInnerWidth, 0, this.mCreateScale));
            if (-1 == this.mTitlelayout.indexOfChild(textView)) {
                this.mTitlelayout.addView(textView, layoutParams3);
            } else {
                textView.setLayoutParams(layoutParams3);
            }
            textView.setVisibility(0);
        }
        if (textView.getVisibility() == 0) {
            android.widget.RelativeLayout.LayoutParams layoutParams4 = (android.widget.RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            layoutParams4.addRule(10);
            layoutParams4.removeRule(15);
            this.mTitleView.setLayoutParams(layoutParams2);
            return;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams5 = (android.widget.RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
        layoutParams5.removeRule(10);
        layoutParams5.addRule(15);
        this.mTitleView.setLayoutParams(layoutParams2);
    }

    private void setButtonColor(android.view.View view, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        int iStringToColor;
        int iStringToColor2;
        int iStringToColor3;
        if (view != null) {
            android.graphics.drawable.Drawable background = view.getBackground();
            if (background != null && (background instanceof io.dcloud.feature.nativeObj.NativeViewBackButtonDrawable)) {
                try {
                    iStringToColor3 = android.graphics.Color.parseColor(str);
                } catch (java.lang.Exception unused) {
                    iStringToColor3 = io.dcloud.common.util.PdrUtil.stringToColor(str);
                }
                io.dcloud.feature.nativeObj.NativeViewBackButtonDrawable nativeViewBackButtonDrawable = (io.dcloud.feature.nativeObj.NativeViewBackButtonDrawable) background;
                if (iStringToColor3 != nativeViewBackButtonDrawable.getDrawableColor()) {
                    nativeViewBackButtonDrawable.setDrawableColor(iStringToColor3);
                }
            }
            try {
                iStringToColor = android.graphics.Color.parseColor(str2);
            } catch (java.lang.Exception unused2) {
                iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(str2);
            }
            try {
                iStringToColor2 = android.graphics.Color.parseColor(str3);
            } catch (java.lang.Exception unused3) {
                iStringToColor2 = io.dcloud.common.util.PdrUtil.stringToColor(str3);
            }
            if ((view instanceof android.widget.RelativeLayout) || (view instanceof io.dcloud.feature.nativeObj.TitleNView.BadgeRelateiveLayout)) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    android.widget.TextView textView = (android.widget.TextView) viewGroup.getChildAt(i);
                    if (iStringToColor != textView.getTextColors().getDefaultColor()) {
                        textView.setTextColor(createColorStateList(iStringToColor, iStringToColor2));
                    }
                }
                return;
            }
            if (view instanceof android.widget.TextView) {
                android.widget.TextView textView2 = (android.widget.TextView) view;
                if (iStringToColor != textView2.getTextColors().getDefaultColor()) {
                    textView2.setTextColor(createColorStateList(iStringToColor, iStringToColor2));
                    return;
                }
                return;
            }
            if (view instanceof android.widget.LinearLayout) {
                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) view;
                for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                    android.view.View childAt = linearLayout.getChildAt(i2);
                    if (childAt instanceof android.widget.TextView) {
                        android.widget.TextView textView3 = (android.widget.TextView) childAt;
                        if (iStringToColor != textView3.getTextColors().getDefaultColor()) {
                            textView3.setTextColor(createColorStateList(iStringToColor, iStringToColor2));
                        }
                    } else if (childAt instanceof android.widget.RelativeLayout) {
                        android.widget.TextView textView4 = (android.widget.TextView) ((android.widget.RelativeLayout) childAt).getChildAt(0);
                        if (iStringToColor != textView4.getTextColors().getDefaultColor()) {
                            textView4.setTextColor(createColorStateList(iStringToColor, iStringToColor2));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextAndFont(java.lang.String str, java.lang.String str2, java.lang.String str3, android.widget.TextView textView, boolean z) {
        android.graphics.Typeface typeface;
        java.lang.String strConvert2AbsFullPath;
        if (z || str3.equals("none")) {
            textView.setText(str);
            if (this.mApp == null || this.mWebView == null || android.text.TextUtils.isEmpty(str2)) {
                typeface = null;
            } else {
                if (str2.contains("__wap2app.ttf")) {
                    strConvert2AbsFullPath = io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__wap2app.ttf";
                    if (!new java.io.File(strConvert2AbsFullPath).exists()) {
                        strConvert2AbsFullPath = this.mWebView.obtainApp().convert2AbsFullPath(this.mWebView.obtainFullUrl(), str2);
                    }
                } else {
                    strConvert2AbsFullPath = this.mWebView.obtainApp().convert2AbsFullPath(this.mWebView.obtainFullUrl(), str2);
                }
                typeface = io.dcloud.feature.nativeObj.NativeTypefaceFactory.getTypeface(this.mWebView.obtainApp(), strConvert2AbsFullPath);
            }
        } else {
            typeface = android.graphics.Typeface.createFromAsset(getContext().getAssets(), "fonts/dcloud_iconfont.ttf");
            str3.hashCode();
            switch (str3) {
                case "forward":
                    str = "\ue600";
                    break;
                case "back":
                    str = "\ue601";
                    break;
                case "home":
                    str = "\ue605";
                    break;
                case "menu":
                    str = "\ue606";
                    break;
                case "close":
                    str = "\ue650";
                    break;
                case "share":
                    str = "\ue602";
                    break;
                case "favorite":
                    str = "\ue604";
                    break;
            }
            textView.setText(str);
        }
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextGravity(java.lang.String str, java.lang.String str2) {
        int iHashCode = str.hashCode();
        if (iHashCode == -1364013995) {
            str.equals("center");
        } else if (iHashCode != 3317767) {
            if (iHashCode == 108511772 && str.equals("right")) {
                this.searchInput.setGravity(androidx.core.view.GravityCompat.END);
                this.searchInput.setHint("\ue660 " + str2);
                return;
            }
        } else if (str.equals("left")) {
            this.searchInput.setGravity(androidx.core.view.GravityCompat.START);
            this.searchInput.setHint(str2);
            return;
        }
        this.searchInput.setGravity(17);
        this.searchInput.setHint("\ue660 " + str2);
    }

    private void updateCapsuleLayout() {
        com.dcloud.android.widget.CapsuleLayout capsuleLayout = this.mCapsuleLayout;
        if (capsuleLayout == null || capsuleLayout.isDiy) {
            return;
        }
        java.lang.String backgroundColor = getBackgroundColor();
        if (android.text.TextUtils.isEmpty(backgroundColor)) {
            return;
        }
        if (this.mCapsuleLayout.checkColorToStyle(io.dcloud.common.util.PdrUtil.stringToColor(backgroundColor)) == 1) {
            this.closeBt.setTextColor(-16777216);
            this.menuBt.setTextColor(-16777216);
        } else {
            this.closeBt.setTextColor(-1);
            this.menuBt.setTextColor(-1);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void addBackButton(java.lang.String str, java.lang.String str2, java.lang.String str3, org.json.JSONObject jSONObject) {
        android.widget.TextView textView;
        android.widget.TextView textView2;
        android.widget.TextView textView3;
        java.lang.String str4;
        java.lang.String strChangeColorAlpha;
        int iStringToColor;
        int iStringToColor2;
        initTitleNViewLayout();
        initLeftButtonLayout();
        io.dcloud.feature.nativeObj.TitleNView.BadgeLinearLayout badgeLinearLayout = this.mBackButton;
        if (badgeLinearLayout == null) {
            io.dcloud.feature.nativeObj.TitleNView.BadgeLinearLayout badgeLinearLayout2 = new io.dcloud.feature.nativeObj.TitleNView.BadgeLinearLayout(this, getContext(), this.mCreateScale, this.redDotColor);
            this.mBackButton = badgeLinearLayout2;
            badgeLinearLayout2.setContentDescription(getResources().getString(io.dcloud.base.R.string.dcloud_titlenview_back_button_description));
            this.mBackButton.setTag("TitleNView.BackButton");
            this.mBackButton.setGravity(17);
            textView = new android.widget.TextView(getContext());
            textView.setGravity(17);
            textView.setId(android.view.View.generateViewId());
            textView.setIncludeFontPadding(false);
            textView2 = new android.widget.TextView(getContext());
            textView2.setGravity(17);
            textView2.setIncludeFontPadding(false);
            textView3 = new android.widget.TextView(getContext());
            textView3.setGravity(17);
            textView3.setIncludeFontPadding(false);
            textView3.setTextColor(-1);
            textView3.setVisibility(8);
            android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(getContext());
            relativeLayout.setGravity(16);
            this.mBackButton.addView(textView, new android.widget.LinearLayout.LayoutParams(-2, 500));
            this.mBackButton.addView(relativeLayout, new android.widget.LinearLayout.LayoutParams(-2, -1));
            relativeLayout.addView(textView2, new android.widget.RelativeLayout.LayoutParams(-2, -1));
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(15);
            relativeLayout.addView(textView3, layoutParams);
        } else {
            textView = (android.widget.TextView) badgeLinearLayout.getChildAt(0);
            android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) this.mBackButton.getChildAt(1);
            textView2 = (android.widget.TextView) relativeLayout2.getChildAt(0);
            textView3 = (android.widget.TextView) relativeLayout2.getChildAt(1);
        }
        io.dcloud.common.DHInterface.IFrameView iFrameView = this.mFrameViewParent;
        if (iFrameView == null || 5 != iFrameView.getFrameType()) {
            textView.setText((jSONObject == null || !jSONObject.has("text")) ? "\ue601" : jSONObject.optString("text"));
        } else {
            textView.setText((jSONObject == null || !jSONObject.has("text")) ? "\ue650" : jSONObject.optString("text"));
        }
        textView.setTypeface(android.graphics.Typeface.createFromAsset(getContext().getAssets(), "fonts/dcloud_iconfont.ttf"));
        textView2.setText((jSONObject == null || !jSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE)) ? "" : jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE));
        this.mBackButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: io.dcloud.feature.nativeObj.TitleNView.3
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                android.app.Activity activity;
                io.dcloud.common.DHInterface.IApp iApp = io.dcloud.feature.nativeObj.TitleNView.this.mApp;
                if (iApp == null || (activity = iApp.getActivity()) == null) {
                    return;
                }
                activity.onBackPressed();
            }
        });
        java.lang.String strOptString = "16px";
        if ("transparent".equals(str3)) {
            textView.getPaint().setTextSize(io.dcloud.common.util.PdrUtil.convertToScreenInt((jSONObject == null || !jSONObject.has(com.taobao.weex.common.Constants.Name.FONT_SIZE)) ? "22px" : jSONObject.optString(com.taobao.weex.common.Constants.Name.FONT_SIZE), this.mInnerWidth, 0, this.mCreateScale));
            textView2.getPaint().setTextSize(io.dcloud.common.util.PdrUtil.convertToScreenInt((jSONObject == null || !jSONObject.has("titleSize")) ? "16px" : jSONObject.optString("titleSize"), this.mInnerWidth, 0, this.mCreateScale));
            io.dcloud.common.DHInterface.IFrameView iFrameView2 = this.mFrameViewParent;
            if (iFrameView2 == null || 5 != iFrameView2.getFrameType()) {
                this.mBackButton.setPadding(0, 0, io.dcloud.common.util.PdrUtil.convertToScreenInt("2px", this.mInnerWidth, 0, this.mCreateScale), 0);
            } else {
                this.mBackButton.setPadding(0, 0, 0, 0);
            }
            io.dcloud.feature.nativeObj.NativeViewBackButtonDrawable nativeViewBackButtonDrawable = new io.dcloud.feature.nativeObj.NativeViewBackButtonDrawable(io.dcloud.common.util.PdrUtil.stringToColor((jSONObject == null || !jSONObject.has("background")) ? io.dcloud.common.util.TitleNViewUtil.TRANSPARENT_BUTTON_BACKGROUND_COLOR : jSONObject.optString("background")));
            nativeViewBackButtonDrawable.setWidth("backButton");
            this.mBackButton.setBackground(nativeViewBackButtonDrawable);
            str4 = io.dcloud.common.util.TitleNViewUtil.TRANSPARENT_BUTTON_TEXT_COLOR;
            strChangeColorAlpha = io.dcloud.common.util.TitleNViewUtil.changeColorAlpha(io.dcloud.common.util.TitleNViewUtil.TRANSPARENT_BUTTON_TEXT_COLOR, 0.3f);
        } else {
            textView.getPaint().setTextSize(io.dcloud.common.util.PdrUtil.convertToScreenInt((jSONObject == null || !jSONObject.has(com.taobao.weex.common.Constants.Name.FONT_SIZE)) ? "27px" : jSONObject.optString(com.taobao.weex.common.Constants.Name.FONT_SIZE), this.mInnerWidth, 0, this.mCreateScale));
            textView2.getPaint().setTextSize(io.dcloud.common.util.PdrUtil.convertToScreenInt((jSONObject == null || !jSONObject.has("titleSize")) ? "16px" : jSONObject.optString("titleSize"), this.mInnerWidth, 0, this.mCreateScale));
            str4 = str;
            strChangeColorAlpha = str2;
        }
        if (jSONObject != null && jSONObject.has("badgeSize")) {
            strOptString = jSONObject.optString("badgeSize");
        }
        int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString, this.mInnerWidth, 0, this.mCreateScale);
        textView3.getPaint().setTextSize(iConvertToScreenInt);
        android.view.ViewGroup.LayoutParams layoutParams2 = textView3.getLayoutParams();
        layoutParams2.height = io.dcloud.common.util.PdrUtil.convertToScreenInt("2px", this.mInnerWidth, 0, this.mCreateScale) + iConvertToScreenInt;
        textView3.setLayoutParams(layoutParams2);
        textView3.setMinWidth(layoutParams2.height);
        int i = iConvertToScreenInt / 4;
        textView3.setPadding(i, getPaddingTop(), i, getPaddingBottom());
        java.lang.String strOptString2 = (jSONObject == null || !jSONObject.has(com.taobao.weex.common.Constants.Name.FONT_WEIGHT)) ? "normal" : jSONObject.optString(com.taobao.weex.common.Constants.Name.FONT_WEIGHT);
        if (strOptString2.equals("normal")) {
            textView.getPaint().setFakeBoldText(false);
        } else if (strOptString2.equals(com.taobao.weex.common.Constants.Value.BOLD)) {
            textView.getPaint().setFakeBoldText(true);
        }
        java.lang.String strOptString3 = (jSONObject == null || !jSONObject.has("titleWeight")) ? "normal" : jSONObject.optString("titleWeight");
        if (strOptString3.equals("normal")) {
            textView2.getPaint().setFakeBoldText(false);
        } else if (strOptString3.equals(com.taobao.weex.common.Constants.Value.BOLD)) {
            textView2.getPaint().setFakeBoldText(true);
        }
        java.lang.String strOptString4 = null;
        java.lang.String strOptString5 = (jSONObject == null || !jSONObject.has("badgeText")) ? null : jSONObject.optString("badgeText");
        this.mBackButton.setBadgeStr(strOptString5);
        this.mBackButton.setDrawRedDot(jSONObject != null && jSONObject.has("redDot") && jSONObject.optBoolean("redDot"));
        if (io.dcloud.common.util.PdrUtil.isEmpty(strOptString5)) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(strOptString5, android.widget.TextView.BufferType.SPANNABLE);
            textView3.setVisibility(0);
        }
        java.lang.String strOptString6 = (jSONObject == null || !jSONObject.has("badgeBackground")) ? null : jSONObject.optString("badgeBackground");
        if (jSONObject != null && jSONObject.has("badgeColor")) {
            strOptString4 = jSONObject.optString("badgeColor");
        }
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        if (io.dcloud.common.util.PdrUtil.isEmpty(strOptString6)) {
            gradientDrawable.setColor(-65536);
        } else {
            gradientDrawable.setColor(io.dcloud.common.util.PdrUtil.stringToColor(strOptString6));
        }
        gradientDrawable.setCornerRadius(layoutParams2.height / 2);
        textView3.setBackground(gradientDrawable);
        if (!io.dcloud.common.util.PdrUtil.isEmpty(strOptString4)) {
            textView3.setTextColor(io.dcloud.common.util.PdrUtil.stringToColor(strOptString4));
        }
        try {
            iStringToColor = android.graphics.Color.parseColor(str4);
        } catch (java.lang.Exception unused) {
            iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(str4);
        }
        try {
            iStringToColor2 = android.graphics.Color.parseColor(strChangeColorAlpha);
        } catch (java.lang.Exception unused2) {
            iStringToColor2 = io.dcloud.common.util.PdrUtil.stringToColor(strChangeColorAlpha);
        }
        textView.setTextColor(createColorStateList(iStringToColor, iStringToColor2));
        textView2.setTextColor(createColorStateList(iStringToColor, iStringToColor2));
        if (this.mBackButton.getParent() != null) {
            ((android.view.ViewGroup) this.mBackButton.getParent()).removeView(this.mBackButton);
        }
        if (-1 == this.mLeftButtonLayout.indexOfChild(this.mBackButton)) {
            int iConvertToScreenInt2 = this.mInnerHeight - io.dcloud.common.util.PdrUtil.convertToScreenInt("12px", this.mAppScreenWidth, 0, this.mCreateScale);
            android.widget.LinearLayout.LayoutParams layoutParams3 = new android.widget.LinearLayout.LayoutParams(-2, iConvertToScreenInt2);
            layoutParams3.leftMargin = io.dcloud.common.util.PdrUtil.convertToScreenInt("5px", this.mAppScreenWidth, 0, this.mCreateScale);
            this.mBackButton.setMinimumWidth(iConvertToScreenInt2);
            this.mLeftButtonLayout.addView(this.mBackButton, 0, layoutParams3);
        }
        this.mBackButton.setVisibility(0);
        requestLayout();
        caculateTitleMargin();
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void addHomeButton(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        int iStringToColor;
        int iStringToColor2;
        initTitleNViewLayout();
        initLeftButtonLayout();
        initRightButtonLayout();
        if (this.mHomeButton == null) {
            android.widget.TextView textView = new android.widget.TextView(getContext());
            this.mHomeButton = textView;
            textView.setGravity(17);
            this.mHomeButton.setTag("TitleNView.HomeButton");
            this.mHomeButton.setTypeface(android.graphics.Typeface.createFromAsset(getContext().getAssets(), "fonts/dcloud_iconfont.ttf"));
            this.mHomeButton.setText("\ue605");
            this.mHomeButton.setIncludeFontPadding(false);
            this.mHomeButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: io.dcloud.feature.nativeObj.TitleNView.4
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    io.dcloud.common.DHInterface.IApp iApp = io.dcloud.feature.nativeObj.TitleNView.this.mApp;
                    if (iApp == null || iApp.getActivity() == null) {
                        return;
                    }
                    io.dcloud.feature.nativeObj.TitleNView.this.mFrameViewParent.obtainWebAppRootView().goHome(io.dcloud.feature.nativeObj.TitleNView.this.mFrameViewParent);
                }
            });
            if ("transparent".equals(str3)) {
                this.mHomeButton.getPaint().setTextSize(io.dcloud.common.util.PdrUtil.convertToScreenInt("22px", this.mInnerWidth, 0, this.mCreateScale));
                io.dcloud.feature.nativeObj.NativeViewBackButtonDrawable nativeViewBackButtonDrawable = new io.dcloud.feature.nativeObj.NativeViewBackButtonDrawable(android.graphics.Color.parseColor(io.dcloud.common.util.TitleNViewUtil.TRANSPARENT_BUTTON_BACKGROUND_COLOR));
                nativeViewBackButtonDrawable.setWidth("");
                this.mHomeButton.setBackground(nativeViewBackButtonDrawable);
                str2 = io.dcloud.common.util.TitleNViewUtil.changeColorAlpha(io.dcloud.common.util.TitleNViewUtil.TRANSPARENT_BUTTON_TEXT_COLOR, 0.3f);
                str = io.dcloud.common.util.TitleNViewUtil.TRANSPARENT_BUTTON_TEXT_COLOR;
            } else {
                this.mHomeButton.getPaint().setTextSize(io.dcloud.common.util.PdrUtil.convertToScreenInt("27px", this.mInnerWidth, 0, this.mCreateScale));
            }
            try {
                iStringToColor = android.graphics.Color.parseColor(str);
            } catch (java.lang.Exception unused) {
                iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(str);
            }
            try {
                iStringToColor2 = android.graphics.Color.parseColor(str2);
            } catch (java.lang.Exception unused2) {
                iStringToColor2 = io.dcloud.common.util.PdrUtil.stringToColor(str2);
            }
            this.mHomeButton.setTextColor(createColorStateList(iStringToColor, iStringToColor2));
        }
        int iConvertToScreenInt = this.mInnerHeight - io.dcloud.common.util.PdrUtil.convertToScreenInt("12px", this.mAppScreenWidth, 0, this.mCreateScale);
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(iConvertToScreenInt, iConvertToScreenInt);
        if (this.mHomeButton.getParent() != null) {
            ((android.view.ViewGroup) this.mHomeButton.getParent()).removeView(this.mHomeButton);
        }
        if (this.mRightButtonLayout.getChildCount() == 0) {
            layoutParams.rightMargin = io.dcloud.common.util.PdrUtil.convertToScreenInt("5px", this.mAppScreenWidth, 0, this.mCreateScale);
            this.mRightButtonLayout.addView(this.mHomeButton, 0, layoutParams);
        } else if (this.mRightButtonLayout.getChildCount() == 1 && -1 == this.mRightButtonLayout.indexOfChild(this.mHomeButton)) {
            layoutParams.rightMargin = io.dcloud.common.util.PdrUtil.convertToScreenInt("5px", this.mAppScreenWidth, 0, this.mCreateScale);
            this.mRightButtonLayout.addView(this.mHomeButton, 0, layoutParams);
        } else if (this.mRightButtonLayout.getChildCount() == 2 && -1 == this.mRightButtonLayout.indexOfChild(this.mHomeButton)) {
            if (this.mLeftButtonLayout.getChildCount() == 1 && this.mBackButton != null && -1 == this.mLeftButtonLayout.indexOfChild(this.mHomeButton)) {
                layoutParams.leftMargin = io.dcloud.common.util.PdrUtil.convertToScreenInt("5px", this.mAppScreenWidth, 0, this.mCreateScale);
                this.mLeftButtonLayout.addView(this.mHomeButton, 1, layoutParams);
            } else if (this.mLeftButtonLayout.getChildCount() == 2 && -1 == this.mLeftButtonLayout.indexOfChild(this.mHomeButton)) {
                android.widget.LinearLayout linearLayout = this.mLeftButtonLayout;
                linearLayout.removeView(linearLayout.getChildAt(1));
                layoutParams.leftMargin = io.dcloud.common.util.PdrUtil.convertToScreenInt("5px", this.mAppScreenWidth, 0, this.mCreateScale);
                this.mLeftButtonLayout.addView(this.mHomeButton, 1, layoutParams);
            }
        }
        this.mHomeButton.setVisibility(0);
        requestLayout();
        caculateTitleMargin();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x006c  */
    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void addLeftButton(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str11, java.lang.String str12, boolean z, java.lang.String str13, boolean z2, java.lang.String str14) {
        int iConvertToScreenInt;
        android.view.View viewCreateButton = createButton(str, str3, str4, str5, str6, str7, str8, str10, iWebview, str11, str12, z, str13, z2, str14, str9);
        initTitleNViewLayout();
        initLeftButtonLayout();
        if (-1 == this.mLeftButtonLayout.indexOfChild(viewCreateButton)) {
            int iConvertToScreenInt2 = this.mInnerHeight - io.dcloud.common.util.PdrUtil.convertToScreenInt("12px", this.mAppScreenWidth, 0, this.mCreateScale);
            int iConvertToScreenInt3 = io.dcloud.common.util.PdrUtil.convertToScreenInt(str14, this.mAppScreenWidth, -1, this.mCreateScale);
            int iConvertToScreenInt4 = io.dcloud.common.util.PdrUtil.convertToScreenInt(str9, this.mAppScreenWidth, -1, this.mCreateScale);
            java.lang.String str15 = "5px";
            if (iConvertToScreenInt3 > 0 && iConvertToScreenInt4 > iConvertToScreenInt3) {
                iConvertToScreenInt = -2;
            } else if (io.dcloud.common.util.PdrUtil.isEmpty(str9)) {
                iConvertToScreenInt = iConvertToScreenInt2;
            } else if (str9.equals("auto")) {
                iConvertToScreenInt = -2;
            } else {
                iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(str9, this.mAppScreenWidth, iConvertToScreenInt2, this.mCreateScale);
                str15 = "0px";
            }
            int iConvertToScreenInt5 = io.dcloud.common.util.PdrUtil.convertToScreenInt(str15, this.mAppScreenWidth, 0, this.mCreateScale);
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(iConvertToScreenInt, iConvertToScreenInt2);
            layoutParams.leftMargin = iConvertToScreenInt5;
            this.mLeftButtonLayout.addView(viewCreateButton, layoutParams);
            if (!io.dcloud.common.util.PdrUtil.isEmpty(str9) && str9.equals("auto") && z2) {
                viewCreateButton.setPadding(iConvertToScreenInt5, viewCreateButton.getPaddingTop(), iConvertToScreenInt5, viewCreateButton.getPaddingBottom());
            }
        }
        caculateTitleMargin();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00a9  */
    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void addRightButton(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str11, java.lang.String str12, boolean z, java.lang.String str13, boolean z2, java.lang.String str14) {
        int iConvertToScreenInt;
        initTitleNViewLayout();
        initRightButtonLayout();
        if ((this.maxButton <= 2 || this.mRightButtonLayout.getChildCount() > this.maxButton - 2) && this.mMenuButtons != null) {
            io.dcloud.feature.nativeObj.data.ButtonDataItem buttonDataItem = new io.dcloud.feature.nativeObj.data.ButtonDataItem(str, str2, iWebview != null ? iWebview.getWebviewUUID() : null, str7, str8, str10);
            this.mMenuButtons.add(buttonDataItem);
            this.mButtons.add(buttonDataItem);
            return;
        }
        android.view.View viewCreateButton = createButton(str, str3, str4, str5, str6, str7, str8, str10, iWebview, str11, str12, z, str13, z2, str14, str9);
        if (-1 == this.mRightButtonLayout.indexOfChild(viewCreateButton)) {
            int iConvertToScreenInt2 = this.mInnerHeight - io.dcloud.common.util.PdrUtil.convertToScreenInt("12px", this.mAppScreenWidth, 0, this.mCreateScale);
            int iConvertToScreenInt3 = io.dcloud.common.util.PdrUtil.convertToScreenInt(str14, this.mAppScreenWidth, -1, this.mCreateScale);
            int iConvertToScreenInt4 = io.dcloud.common.util.PdrUtil.convertToScreenInt(str9, this.mAppScreenWidth, -1, this.mCreateScale);
            java.lang.String str15 = "5px";
            if (iConvertToScreenInt3 > 0 && iConvertToScreenInt4 > iConvertToScreenInt3) {
                iConvertToScreenInt = -2;
            } else if (io.dcloud.common.util.PdrUtil.isEmpty(str9)) {
                iConvertToScreenInt = iConvertToScreenInt2;
            } else if (str9.equals("auto")) {
                iConvertToScreenInt = -2;
            } else {
                iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(str9, this.mAppScreenWidth, iConvertToScreenInt2, this.mCreateScale);
                str15 = "0px";
            }
            int iConvertToScreenInt5 = io.dcloud.common.util.PdrUtil.convertToScreenInt(str15, this.mAppScreenWidth, 0, this.mCreateScale);
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(iConvertToScreenInt, iConvertToScreenInt2);
            layoutParams.rightMargin = iConvertToScreenInt5;
            this.mRightButtonLayout.addView(viewCreateButton, 0, layoutParams);
            if (!io.dcloud.common.util.PdrUtil.isEmpty(str9) && str9.equals("auto") && z2) {
                viewCreateButton.setPadding(iConvertToScreenInt5, viewCreateButton.getPaddingTop(), iConvertToScreenInt5, viewCreateButton.getPaddingBottom());
            }
        }
        caculateTitleMargin();
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void addSearchInput(final java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, boolean z, final boolean z2, final io.dcloud.common.DHInterface.IWebview iWebview) {
        boolean z3;
        final android.widget.TextView textView;
        int iStringToColor;
        int iStringToColor2;
        int iStringToColor3;
        initTitleNViewLayout();
        initLeftButtonLayout();
        initRightButtonLayout();
        initCenterSearchLayout();
        android.widget.RelativeLayout relativeLayout = this.mTitlelayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        android.graphics.Typeface typefaceCreateFromAsset = android.graphics.Typeface.createFromAsset(getContext().getAssets(), "fonts/dcloud_iconfont.ttf");
        int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt("13px", this.mInnerWidth, 0, this.mCreateScale);
        int iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt("8px", this.mAppScreenWidth, 0, this.mCreateScale);
        if (this.searchInput == null) {
            android.widget.TextView textView2 = new android.widget.TextView(getContext());
            textView2.setGravity(17);
            textView2.setTypeface(typefaceCreateFromAsset);
            textView2.setText("\ue660 ");
            textView2.setIncludeFontPadding(false);
            float f = iConvertToScreenInt;
            textView2.getPaint().setTextSize(f);
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = iConvertToScreenInt2;
            this.centerSearchLayout.addView(textView2, layoutParams);
            android.widget.EditText editText = new android.widget.EditText(getContext());
            this.searchInput = editText;
            editText.setTag("TitleNView.SearchInput");
            int i = iConvertToScreenInt2 / 2;
            this.searchInput.setPadding(0, i, 0, i);
            this.searchInput.setPaddingRelative(0, i, 0, i);
            this.searchInput.setIncludeFontPadding(false);
            this.searchInput.setGravity(17);
            this.searchInput.setSingleLine();
            this.searchInput.setLines(1);
            this.searchInput.setTypeface(typefaceCreateFromAsset);
            this.searchInput.setImeOptions(3);
            this.searchInput.getPaint().setTextSize(f);
            this.searchInput.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
            z3 = true;
        } else {
            z3 = false;
        }
        initTitleNViewLayout();
        if (this.searchInput.getParent() != null) {
            ((android.view.ViewGroup) this.searchInput.getParent()).removeView(this.searchInput);
        }
        if (-1 == this.centerSearchLayout.indexOfChild(this.searchInput)) {
            this.centerSearchLayout.addView(this.searchInput, 1, new android.widget.LinearLayout.LayoutParams(-1, -2, 1.0f));
        }
        android.widget.TextView textView3 = this.centerSearchLayout.getChildAt(0) instanceof android.widget.TextView ? (android.widget.TextView) this.centerSearchLayout.getChildAt(0) : null;
        if (textView3 != null) {
            if (str.equalsIgnoreCase("left")) {
                textView3.setVisibility(0);
            } else if (this.searchInput.getText() == null || this.searchInput.getText().toString().length() <= 0) {
                textView3.setVisibility(8);
            } else {
                textView3.setVisibility(0);
            }
        }
        if (this.centerSearchLayout.getChildCount() > 2) {
            textView = (android.widget.TextView) this.centerSearchLayout.getChildAt(2);
        } else {
            android.widget.TextView textView4 = new android.widget.TextView(getContext());
            textView4.setGravity(17);
            textView4.setTypeface(typefaceCreateFromAsset);
            textView4.setText("\ue650");
            textView4.setTextColor(-1);
            textView4.setTextSize(0, iConvertToScreenInt);
            textView4.setIncludeFontPadding(false);
            textView4.getPaint().setFakeBoldText(true);
            android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
            gradientDrawable.setCornerRadius(100.0f);
            gradientDrawable.setColor(-4802890);
            textView4.setBackground(gradientDrawable);
            int i2 = iConvertToScreenInt2 / 4;
            textView4.setPadding(i2, i2, i2, i2);
            android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
            layoutParams2.rightMargin = iConvertToScreenInt2;
            this.centerSearchLayout.addView(textView4, 2, layoutParams2);
            textView4.setOnClickListener(new android.view.View.OnClickListener() { // from class: io.dcloud.feature.nativeObj.TitleNView.5
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    io.dcloud.feature.nativeObj.TitleNView.this.searchInput.setText("");
                }
            });
            textView4.setVisibility(8);
            textView = textView4;
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
            iStringToColor = android.graphics.Color.parseColor("#8fffffff");
        } else {
            try {
                iStringToColor = android.graphics.Color.parseColor(str2);
            } catch (java.lang.Exception unused) {
                iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(str2);
            }
        }
        int iConvertToScreenInt3 = io.dcloud.common.util.PdrUtil.isEmpty(str3) ? 0 : io.dcloud.common.util.PdrUtil.convertToScreenInt(str3, this.mInnerWidth, 0, this.mCreateScale);
        java.lang.String str7 = !io.dcloud.common.util.PdrUtil.isEmpty(str4) ? str4 : "";
        this.searchInput.setHint("\ue660 " + str7);
        if (io.dcloud.common.util.PdrUtil.isEmpty(str5)) {
            iStringToColor2 = android.graphics.Color.parseColor("#CCCCCC");
        } else {
            try {
                iStringToColor2 = android.graphics.Color.parseColor(str5);
            } catch (java.lang.Exception unused2) {
                iStringToColor2 = io.dcloud.common.util.PdrUtil.stringToColor(str5);
            }
        }
        if (textView3 != null) {
            textView3.setTextColor(iStringToColor2);
        }
        this.searchInput.setHintTextColor(iStringToColor2);
        this.searchInput.setEllipsize(android.text.TextUtils.TruncateAt.END);
        this.searchInput.setBackground(null);
        this.centerSearchLayout.setBackground(new io.dcloud.feature.nativeObj.TitleNView.SearchInputDrawable(iStringToColor, iConvertToScreenInt3));
        if (io.dcloud.common.util.PdrUtil.isEmpty(str6)) {
            iStringToColor3 = -16777216;
        } else {
            try {
                iStringToColor3 = android.graphics.Color.parseColor(str6);
            } catch (java.lang.Exception unused3) {
                iStringToColor3 = io.dcloud.common.util.PdrUtil.stringToColor(str6);
            }
        }
        this.searchInput.setTextColor(iStringToColor3);
        if (z3) {
            this.searchInput.addTextChangedListener(new android.text.TextWatcher() { // from class: io.dcloud.feature.nativeObj.TitleNView.6
                @Override // android.text.TextWatcher
                public void afterTextChanged(android.text.Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(java.lang.CharSequence charSequence, int i3, int i4, int i5) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(java.lang.CharSequence charSequence, int i3, int i4, int i5) {
                    if (charSequence.toString().length() > 0) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    java.lang.String jsResponseText = io.dcloud.common.util.JSUtil.toJsResponseText(charSequence.toString());
                    io.dcloud.common.DHInterface.IWebview iWebview2 = io.dcloud.feature.nativeObj.TitleNView.this.mWebView;
                    if (iWebview2 != null && iWebview2.obtainFrameView() != null && (io.dcloud.feature.nativeObj.TitleNView.this.mWebView.obtainFrameView() instanceof io.dcloud.common.adapter.ui.AdaFrameView)) {
                        ((io.dcloud.common.adapter.ui.AdaFrameView) io.dcloud.feature.nativeObj.TitleNView.this.mWebView.obtainFrameView()).dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENT_TITLENVIEW_SEARCHINPUT_CHANGED, io.dcloud.common.util.StringUtil.format("{text:\"%s\"}", jsResponseText));
                        return;
                    }
                    io.dcloud.common.DHInterface.IWebview iWebview3 = iWebview;
                    if (iWebview3 == null || iWebview3.obtainFrameView() == null || !(iWebview.obtainFrameView() instanceof io.dcloud.common.adapter.ui.AdaFrameView)) {
                        return;
                    }
                    ((io.dcloud.common.adapter.ui.AdaFrameView) iWebview.obtainFrameView()).dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENT_TITLENVIEW_SEARCHINPUT_CHANGED, io.dcloud.common.util.StringUtil.format("{text:\"%s\"}", jsResponseText));
                }
            });
        }
        final java.lang.String str8 = str7;
        final android.widget.TextView textView5 = textView3;
        this.searchInput.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() { // from class: io.dcloud.feature.nativeObj.TitleNView.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(android.view.View view, boolean z4) {
                if (!io.dcloud.feature.nativeObj.TitleNView.this.isSetText.get()) {
                    io.dcloud.common.DHInterface.IWebview iWebview2 = io.dcloud.feature.nativeObj.TitleNView.this.mWebView;
                    if (iWebview2 != null && iWebview2.obtainFrameView() != null && (io.dcloud.feature.nativeObj.TitleNView.this.mWebView.obtainFrameView() instanceof io.dcloud.common.adapter.ui.AdaFrameView)) {
                        ((io.dcloud.common.adapter.ui.AdaFrameView) io.dcloud.feature.nativeObj.TitleNView.this.mWebView.obtainFrameView()).dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENT_TITLENVIEW_SEARCHINPUT_FOCUSCHANGED, io.dcloud.common.util.StringUtil.format("{focus:%b}", java.lang.Boolean.valueOf(z4)));
                    }
                    io.dcloud.common.DHInterface.IWebview iWebview3 = iWebview;
                    if (iWebview3 != null && iWebview3.obtainFrameView() != null && (iWebview.obtainFrameView() instanceof io.dcloud.common.adapter.ui.AdaFrameView)) {
                        ((io.dcloud.common.adapter.ui.AdaFrameView) iWebview.obtainFrameView()).dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENT_TITLENVIEW_SEARCHINPUT_FOCUSCHANGED, io.dcloud.common.util.StringUtil.format("{focus:%b}", java.lang.Boolean.valueOf(z4)));
                    }
                }
                if (z4) {
                    io.dcloud.feature.nativeObj.TitleNView.this.searchInput.setGravity(3);
                    textView5.setVisibility(0);
                    io.dcloud.feature.nativeObj.TitleNView.this.searchInput.setHint(str8);
                } else if (io.dcloud.feature.nativeObj.TitleNView.this.searchInput.getText().toString().length() < 1) {
                    io.dcloud.feature.nativeObj.TitleNView.this.setTextGravity(str, str8);
                    if (str.equalsIgnoreCase("left")) {
                        textView5.setVisibility(0);
                    } else {
                        textView5.setVisibility(8);
                    }
                }
            }
        });
        this.searchInput.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() { // from class: io.dcloud.feature.nativeObj.TitleNView.8
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(android.widget.TextView textView6, int i3, android.view.KeyEvent keyEvent) {
                if (i3 == 3) {
                    java.lang.String jsResponseText = io.dcloud.common.util.JSUtil.toJsResponseText(textView6.getText().toString());
                    io.dcloud.common.DHInterface.IWebview iWebview2 = io.dcloud.feature.nativeObj.TitleNView.this.mWebView;
                    if (iWebview2 != null && iWebview2.obtainFrameView() != null && (io.dcloud.feature.nativeObj.TitleNView.this.mWebView.obtainFrameView() instanceof io.dcloud.common.adapter.ui.AdaFrameView)) {
                        ((io.dcloud.common.adapter.ui.AdaFrameView) io.dcloud.feature.nativeObj.TitleNView.this.mWebView.obtainFrameView()).dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENT_TITLENVIEW_SEARCHINPUT_CONFIRMED, io.dcloud.common.util.StringUtil.format("{text:\"%s\"}", jsResponseText));
                        return true;
                    }
                    io.dcloud.common.DHInterface.IWebview iWebview3 = iWebview;
                    if (iWebview3 != null && iWebview3.obtainFrameView() != null && (iWebview.obtainFrameView() instanceof io.dcloud.common.adapter.ui.AdaFrameView)) {
                        ((io.dcloud.common.adapter.ui.AdaFrameView) iWebview.obtainFrameView()).dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENT_TITLENVIEW_SEARCHINPUT_CONFIRMED, io.dcloud.common.util.StringUtil.format("{text:\"%s\"}", jsResponseText));
                    }
                }
                return false;
            }
        });
        if (this.searchInput.getText() == null || this.searchInput.getText().toString().length() < 1) {
            setTextGravity(str, str8);
        }
        boolean z4 = !z;
        this.searchInput.setCursorVisible(z4);
        this.searchInput.setFocusable(z4);
        this.searchInput.setFocusableInTouchMode(z4);
        final io.dcloud.common.DHInterface.IWebview iWebview2 = this.mWebView;
        if (iWebview2 == null) {
            iWebview2 = iWebview;
        }
        try {
            final boolean zDidCloseSplash = ((io.dcloud.common.DHInterface.IWebAppRootView) ((io.dcloud.common.adapter.ui.AdaFrameView) iWebview2.obtainFrameView()).getParent()).didCloseSplash();
            if (!zDidCloseSplash) {
                iWebview2.obtainApp().registerSysEventListener(new io.dcloud.common.DHInterface.ISysEventListener() { // from class: io.dcloud.feature.nativeObj.TitleNView.9
                    @Override // io.dcloud.common.DHInterface.ISysEventListener
                    public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
                        io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType2;
                        if (z2 && sysEventType == (sysEventType2 = io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onSplashclosed)) {
                            io.dcloud.feature.nativeObj.TitleNView.this.searchInput.requestFocus();
                            if (!io.dcloud.common.adapter.util.DeviceInfo.isIMEShow) {
                                io.dcloud.common.adapter.util.DeviceInfo.showIME(io.dcloud.feature.nativeObj.TitleNView.this.searchInput);
                            }
                            iWebview2.obtainApp().unregisterSysEventListener(this, sysEventType2);
                        }
                        if (z2) {
                            return false;
                        }
                        io.dcloud.common.adapter.util.DeviceInfo.hideIME(io.dcloud.feature.nativeObj.TitleNView.this.searchInput);
                        return false;
                    }
                }, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onSplashclosed);
            }
            iWebview2.obtainFrameView().addFrameViewListener(new io.dcloud.common.DHInterface.IEventCallback() { // from class: io.dcloud.feature.nativeObj.TitleNView.10
                @Override // io.dcloud.common.DHInterface.IEventCallback
                public java.lang.Object onCallBack(java.lang.String str9, java.lang.Object obj) {
                    if (!io.dcloud.common.constant.AbsoluteConst.EVENTS_SHOW_ANIMATION_END.equalsIgnoreCase(str9) || !z2 || !zDidCloseSplash) {
                        return null;
                    }
                    io.dcloud.feature.nativeObj.TitleNView.this.searchInput.requestFocus();
                    if (!io.dcloud.common.adapter.util.DeviceInfo.isIMEShow) {
                        io.dcloud.common.adapter.util.DeviceInfo.showIME(io.dcloud.feature.nativeObj.TitleNView.this.searchInput);
                    }
                    iWebview2.obtainFrameView().removeFrameViewListener(this);
                    return null;
                }
            });
        } catch (java.lang.Exception unused4) {
        }
        if (!z2) {
            io.dcloud.common.adapter.util.DeviceInfo.hideIME(this.searchInput);
        }
        if (z) {
            this.searchInput.setOnClickListener(new android.view.View.OnClickListener() { // from class: io.dcloud.feature.nativeObj.TitleNView.11
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    io.dcloud.common.DHInterface.IWebview iWebview3 = io.dcloud.feature.nativeObj.TitleNView.this.mWebView;
                    if (iWebview3 != null && iWebview3.obtainFrameView() != null && (io.dcloud.feature.nativeObj.TitleNView.this.mWebView.obtainFrameView() instanceof io.dcloud.common.adapter.ui.AdaFrameView)) {
                        ((io.dcloud.common.adapter.ui.AdaFrameView) io.dcloud.feature.nativeObj.TitleNView.this.mWebView.obtainFrameView()).dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENT_TITLENVIEW_SEARCHINPUT_CLICKED, java.lang.String.format(com.taobao.weex.el.parse.Operators.SPACE_STR, new java.lang.Object[0]));
                        return;
                    }
                    io.dcloud.common.DHInterface.IWebview iWebview4 = iWebview;
                    if (iWebview4 == null || iWebview4.obtainFrameView() == null || !(iWebview.obtainFrameView() instanceof io.dcloud.common.adapter.ui.AdaFrameView)) {
                        return;
                    }
                    ((io.dcloud.common.adapter.ui.AdaFrameView) iWebview.obtainFrameView()).dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENT_TITLENVIEW_SEARCHINPUT_CLICKED, java.lang.String.format(com.taobao.weex.el.parse.Operators.SPACE_STR, new java.lang.Object[0]));
                }
            });
        }
        this.searchInput.setVisibility(0);
        requestLayout();
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void clearButtons() {
        android.widget.LinearLayout linearLayout = this.mRightButtonLayout;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        android.widget.LinearLayout linearLayout2 = this.mLeftButtonLayout;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
        }
        java.util.ArrayList<io.dcloud.feature.nativeObj.data.ButtonDataItem> arrayList = this.mMenuButtons;
        if (arrayList != null) {
            arrayList.clear();
        }
        java.util.ArrayList<java.lang.Object> arrayList2 = this.mButtons;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
    }

    @Override // io.dcloud.feature.nativeObj.NativeView
    public void clearNativeViewData() {
        io.dcloud.common.DHInterface.IFrameView iFrameView = this.mFrameViewParent;
        if (iFrameView != null && (iFrameView instanceof io.dcloud.common.adapter.ui.AdaFrameView)) {
            ((io.dcloud.common.adapter.ui.AdaFrameView) iFrameView).removeNativeViewChild(this);
        }
        postDelayed(new java.lang.Runnable() { // from class: io.dcloud.feature.nativeObj.TitleNView.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    io.dcloud.feature.nativeObj.TitleNView.this.setVisibility(8);
                    if (io.dcloud.feature.nativeObj.TitleNView.this.getParent() != null) {
                        ((android.view.ViewGroup) io.dcloud.feature.nativeObj.TitleNView.this.getParent()).removeView(io.dcloud.feature.nativeObj.TitleNView.this);
                    }
                    io.dcloud.feature.nativeObj.TitleNView.this.clearViewData();
                    if (io.dcloud.feature.nativeObj.TitleNView.this.mButtons != null) {
                        java.util.ArrayList arrayList = io.dcloud.feature.nativeObj.TitleNView.this.mButtons;
                        int size = arrayList.size();
                        int i = 0;
                        while (i < size) {
                            java.lang.Object obj = arrayList.get(i);
                            i++;
                            if (obj instanceof io.dcloud.feature.nativeObj.TitleNView.BadgeRelateiveLayout) {
                                android.view.View view = (android.view.View) obj;
                                if (view.getBackground() != null) {
                                    view.getBackground().setCallback(null);
                                }
                            }
                        }
                        io.dcloud.feature.nativeObj.TitleNView.this.mButtons.clear();
                    }
                    io.dcloud.feature.nativeObj.TitleNView.this.mFrameViewParent = null;
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }, 200);
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void clearSearchInput() {
        android.widget.LinearLayout linearLayout = this.centerSearchLayout;
        if (linearLayout == null || this.mTitleNViewLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        this.mTitleNViewLayout.removeView(this.centerSearchLayout);
        this.centerSearchLayout = null;
        this.searchInput = null;
        android.widget.RelativeLayout relativeLayout = this.mTitlelayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public java.lang.String getBackgroundColor() {
        return getStyleBackgroundColor();
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public java.lang.String getStatusBarColor() {
        org.json.JSONObject jSONObjectOptJSONObject;
        int iStringToColor;
        if (!this.isImmersed) {
            return "{color:-1,alpha:true}";
        }
        if (this.mStyle.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR) && (jSONObjectOptJSONObject = this.mStyle.optJSONObject(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR)) != null && jSONObjectOptJSONObject.has("backgroundnoalpha")) {
            java.lang.String strOptString = jSONObjectOptJSONObject.optString("backgroundnoalpha");
            try {
                iStringToColor = android.graphics.Color.parseColor(strOptString);
            } catch (java.lang.Exception unused) {
                iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(strOptString);
            }
            return "{color:" + iStringToColor + ",alpha:false}";
        }
        android.view.View view = this.mStatusbarView;
        if (view != null) {
            android.graphics.drawable.Drawable background = view.getBackground();
            if (!(background instanceof android.graphics.drawable.ColorDrawable)) {
                return "{color:-1,alpha:true}";
            }
            return "{color:" + ((android.graphics.drawable.ColorDrawable) background).getColor() + ",alpha:true}";
        }
        android.view.ViewParent parent = getParent();
        if (!android.text.TextUtils.equals(this.mStyle.optString("position", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE), io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE) || parent == null || !(parent instanceof android.view.ViewGroup)) {
            return "{color:-1,alpha:true}";
        }
        int i = 0;
        while (true) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) parent;
            if (i >= viewGroup.getChildCount()) {
                return "{color:-1,alpha:true}";
            }
            java.lang.Object tag = viewGroup.getChildAt(i).getTag();
            if (tag != null && "StatusBar".equalsIgnoreCase(tag.toString())) {
                android.graphics.drawable.Drawable background2 = viewGroup.getChildAt(i).getBackground();
                if (background2 instanceof android.graphics.drawable.ColorDrawable) {
                    return "{color:" + ((android.graphics.drawable.ColorDrawable) background2).getColor() + ",alpha:true}";
                }
            }
            i++;
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public int getTitleColor() {
        return this.mTitleView.getTextColors().getDefaultColor();
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public java.lang.String getTitleNViewSearchInputText() {
        android.widget.EditText editText = this.searchInput;
        return editText != null ? editText.getText().toString() : "";
    }

    @Override // io.dcloud.feature.nativeObj.NativeView, io.dcloud.common.DHInterface.INativeView
    public java.lang.String getViewType() {
        return io.dcloud.common.constant.AbsoluteConst.NATIVE_TITLE_N_VIEW;
    }

    @Override // io.dcloud.feature.nativeObj.NativeView
    protected void init() {
        android.view.View view;
        super.init();
        if (this.mStyle.has("blurEffect")) {
            this.mBlurEffect = this.mStyle.optString("blurEffect", "none");
        }
        if (this.mBackgroudView == null) {
            android.view.View view2 = new android.view.View(getContext());
            this.mBackgroudView = view2;
            addView(view2, 0, new android.widget.FrameLayout.LayoutParams(-1, -1));
        }
        updateCapsuleLayout();
        this.redDotColor = -65536;
        if (this.mStyle != null) {
            if (this.mBackGroundDrawable == null) {
                io.dcloud.feature.nativeObj.TitleNView.BackGroundDrawable backGroundDrawable = new io.dcloud.feature.nativeObj.TitleNView.BackGroundDrawable();
                this.mBackGroundDrawable = backGroundDrawable;
                this.mBackgroudView.setBackground(backGroundDrawable);
            }
            if (this.mStyle.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR) && this.mStyle.has(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE) && (view = this.mStatusbarView) != null) {
                view.setVisibility(8);
            }
            this.mBackGroundDrawable.setBackgroundColor(this.mBackGroundColor);
            this.mBackGroundDrawable.updatebound();
            this.mBackGroundDrawable.setBackgroundImage(this.mBackgroundImageSrc);
            this.mBackGroundDrawable.setAlpha(android.graphics.Color.alpha(this.mBackGroundColor));
            this.mBackGroundDrawable.invalidateSelf();
            if (this.mStyle.has("redDotColor") && !io.dcloud.common.util.PdrUtil.isEmpty(this.mStyle.optString("redDotColor"))) {
                this.redDotColor = io.dcloud.common.util.PdrUtil.stringToColor(this.mStyle.optString("redDotColor"));
            }
        }
        if ((io.dcloud.common.ui.blur.DCBlurDraweeView.LIGHT.equals(this.mBlurEffect) || io.dcloud.common.ui.blur.DCBlurDraweeView.DARK.equals(this.mBlurEffect) || io.dcloud.common.ui.blur.DCBlurDraweeView.EXTRALIGHT.equals(this.mBlurEffect)) && this.mBlurDraweeView == null) {
            int i = this.mInnerHeight;
            if (this.isStatusBar && this.isImmersed) {
                i += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
            }
            if (this.mWebView.obtainWindowView() instanceof io.dcloud.common.DHInterface.IX5WebView) {
                this.mBlurDraweeView = new io.dcloud.common.ui.blur.DCBlurDraweeView(getContext(), false, "none");
            } else {
                this.mBlurDraweeView = new io.dcloud.common.ui.blur.DCBlurDraweeView(getContext(), true, io.dcloud.common.ui.blur.DCBlurDraweeView.SEMI_AUTOMATICALLY);
            }
            addView(this.mBlurDraweeView, 0, new android.widget.FrameLayout.LayoutParams(-1, i));
            this.mBlurDraweeView.setGravityType(48);
            this.mBlurDraweeView.setBlurEffect(this.mBlurEffect);
            this.mBlurDraweeView.setBlurRadius(20);
            this.mBlurDraweeView.setDownscaleFactor(0.3f);
            this.mBlurDraweeView.setRootView(this.mWebView.obtainFrameView().obtainMainView());
            this.mBlurDraweeView.setBlurLayoutChangeCallBack(new io.dcloud.common.ui.blur.DCBlurDraweeView.BlurLayoutChangeCallBack() { // from class: io.dcloud.feature.nativeObj.TitleNView.1
                @Override // io.dcloud.common.ui.blur.DCBlurDraweeView.BlurLayoutChangeCallBack
                public void setVisibility(int i2) {
                    io.dcloud.feature.nativeObj.NativeView.NativeCanvasView nativeCanvasView = io.dcloud.feature.nativeObj.TitleNView.this.mCanvasView;
                    if (nativeCanvasView != null) {
                        nativeCanvasView.setVisibility(i2);
                    }
                    if (io.dcloud.feature.nativeObj.TitleNView.this.mTitleNViewLayout != null) {
                        io.dcloud.feature.nativeObj.TitleNView.this.mTitleNViewLayout.setVisibility(i2);
                    }
                    android.view.View view3 = io.dcloud.feature.nativeObj.TitleNView.this.mStatusbarView;
                    if (view3 != null && view3.getVisibility() != 8) {
                        io.dcloud.feature.nativeObj.TitleNView.this.mStatusbarView.setVisibility(i2);
                    }
                    if (io.dcloud.feature.nativeObj.TitleNView.this.mBackgroudView != null) {
                        io.dcloud.feature.nativeObj.TitleNView.this.mBackgroudView.setVisibility(i2);
                    }
                }
            });
        }
    }

    @Override // io.dcloud.feature.nativeObj.NativeView
    protected void measureChildViewToTop(int i) {
        super.measureChildViewToTop(i);
        android.widget.RelativeLayout relativeLayout = this.mTitleNViewLayout;
        if (relativeLayout == null || relativeLayout.getLayoutParams() == null) {
            return;
        }
        ((android.widget.FrameLayout.LayoutParams) this.mTitleNViewLayout.getLayoutParams()).topMargin = i;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        caculateTitleMargin();
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void reMeasure() {
        measureFitViewParent(false);
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void removeBackButton() {
        io.dcloud.feature.nativeObj.TitleNView.BadgeLinearLayout badgeLinearLayout = this.mBackButton;
        if (badgeLinearLayout != null) {
            badgeLinearLayout.setVisibility(8);
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void removeHomeButton() {
        android.widget.TextView textView = this.mHomeButton;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void removeSplitLine() {
        android.widget.RelativeLayout relativeLayout;
        android.view.View view = this.mSplitLine;
        if (view != null && (relativeLayout = this.mTitleNViewLayout) != null) {
            relativeLayout.removeView(view);
        }
        this.mSplitLine = null;
    }

    @Override // io.dcloud.feature.nativeObj.NativeView
    public void resetNativeView() {
        int iIntValue;
        io.dcloud.common.DHInterface.IFrameView iFrameView = this.mFrameViewParent;
        if (iFrameView != null) {
            try {
                java.lang.String titleNViewId = io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(iFrameView);
                if (this.mOverlayMaps.containsKey(titleNViewId)) {
                    java.lang.Integer num = this.mOverlayMaps.get(titleNViewId);
                    iIntValue = num.intValue();
                    this.mOverlayMaps.clear();
                    this.mOverlayMaps.put(titleNViewId, num);
                } else {
                    this.mOverlayMaps.clear();
                    iIntValue = -1;
                }
                if (-1 != iIntValue) {
                    io.dcloud.feature.nativeObj.NativeView.Overlay overlay = this.mOverlays.get(iIntValue);
                    java.util.Iterator<io.dcloud.feature.nativeObj.NativeView.Overlay> it = this.mOverlays.iterator();
                    while (it.hasNext()) {
                        io.dcloud.feature.nativeObj.NativeView.Overlay next = it.next();
                        if (next != overlay) {
                            io.dcloud.feature.nativeObj.NativeBitmap nativeBitmap = next.mNativeBitmap;
                            if (nativeBitmap != null) {
                                nativeBitmap.recycle(true);
                            }
                            it.remove();
                        }
                    }
                } else {
                    clearViewData();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } else {
            clearViewData();
        }
        clearAnimate();
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setBackButtonColor(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        setButtonColor(this.mBackButton, str, str2, str3);
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setBackgroundColor(java.lang.String str) {
        setStyleBackgroundColor(str);
        updateCapsuleLayout();
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setBackgroundImage(java.lang.String str) {
        if (this.mBackgroundImageSrc.equals(str)) {
            return;
        }
        this.mBackgroundImageSrc = str;
        if (this.mBackGroundDrawable == null) {
            this.mBackGroundDrawable = new io.dcloud.feature.nativeObj.TitleNView.BackGroundDrawable();
        }
        this.mBackGroundDrawable.setBackgroundImage(this.mBackgroundImageSrc);
        this.mBackgroudView.setBackground(this.mBackGroundDrawable);
        this.mBackGroundDrawable.invalidateSelf();
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setBackgroundRepeat(java.lang.String str) {
        io.dcloud.feature.nativeObj.TitleNView.BackGroundDrawable backGroundDrawable = this.mBackGroundDrawable;
        if (backGroundDrawable != null) {
            backGroundDrawable.setRepeatType(str, this.mBackgroundImageSrc);
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setBadgeText(org.json.JSONObject jSONObject, boolean z) {
        int iOptInt = jSONObject.optInt("index");
        java.lang.String strOptString = jSONObject.optString("text");
        if (!z) {
            strOptString = "";
        }
        if (iOptInt >= this.mButtons.size() || iOptInt < 0) {
            return;
        }
        java.lang.Object obj = this.mButtons.get(iOptInt);
        if (obj instanceof io.dcloud.feature.nativeObj.TitleNView.BadgeRelateiveLayout) {
            ((io.dcloud.feature.nativeObj.TitleNView.BadgeRelateiveLayout) obj).setBadgeStr(strOptString);
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setButtonColorByIndex(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.Object obj = this.mButtons.get(i);
        if (obj == null || !(obj instanceof android.view.View)) {
            return;
        }
        setButtonColor((android.view.View) obj, str, str2, str3);
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setButtonsColor(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        for (int i = 0; i < this.mButtons.size(); i++) {
            setButtonColorByIndex(i, str, str2, str3);
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setCapsuleButtonStyle(org.json.JSONObject jSONObject) {
        com.dcloud.android.widget.CapsuleLayout capsuleLayout = this.mCapsuleLayout;
        if (capsuleLayout == null || jSONObject == null) {
            return;
        }
        capsuleLayout.isDiy = true;
        if (jSONObject.has("backgroundColor")) {
            this.mCapsuleLayout.setBackgroundColor(io.dcloud.common.util.PdrUtil.stringToColor(jSONObject.optString("backgroundColor")));
        }
        if (jSONObject.has(com.taobao.weex.common.Constants.Name.BORDER_COLOR)) {
            this.mCapsuleLayout.setRoundColor(io.dcloud.common.util.PdrUtil.stringToColor(jSONObject.optString(com.taobao.weex.common.Constants.Name.BORDER_COLOR)));
        }
        if (jSONObject.has("highlightColor")) {
            int iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(jSONObject.optString("highlightColor"));
            android.widget.TextView textView = this.menuBt;
            if (textView != null) {
                this.mCapsuleLayout.setButtonSelectColor(textView, com.dcloud.android.widget.CapsuleLayout.ButtonType.LIFT, iStringToColor);
            }
            android.widget.TextView textView2 = this.closeBt;
            if (textView2 != null) {
                this.mCapsuleLayout.setButtonSelectColor(textView2, com.dcloud.android.widget.CapsuleLayout.ButtonType.RIGHT, iStringToColor);
            }
        }
        if (jSONObject.has("textColor")) {
            int iStringToColor2 = io.dcloud.common.util.PdrUtil.stringToColor(jSONObject.optString("textColor"));
            android.widget.TextView textView3 = this.menuBt;
            if (textView3 != null) {
                textView3.setTextColor(iStringToColor2);
            }
            android.widget.TextView textView4 = this.closeBt;
            if (textView4 != null) {
                textView4.setTextColor(iStringToColor2);
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setHomeButtonColor(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        setButtonColor(this.mHomeButton, str, str2, str3);
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setIconSubTitleStyle(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9) {
        android.widget.ImageView imageView;
        android.widget.TextView textView;
        android.widget.RelativeLayout relativeLayout = this.mTitlelayout;
        if (relativeLayout != null) {
            if (relativeLayout.getChildAt(0) instanceof android.widget.ImageView) {
                imageView = (android.widget.ImageView) this.mTitlelayout.getChildAt(0);
            } else {
                imageView = new android.widget.ImageView(getContext());
                imageView.setId(android.view.View.generateViewId());
            }
            android.widget.ImageView imageView2 = imageView;
            if (this.mTitlelayout.getChildAt(2) instanceof android.widget.TextView) {
                textView = (android.widget.TextView) this.mTitlelayout.getChildAt(2);
            } else {
                textView = new android.widget.TextView(getContext());
                textView.setId(android.view.View.generateViewId());
            }
            layoutSubtitleIcon(str, str2, str3, str4, str5, str6, imageView2, textView, io.dcloud.common.util.PdrUtil.stringToColor(str7), str8, str9);
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setProgress(java.lang.String str, java.lang.String str2) {
        int iStringToColor;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            io.dcloud.feature.nativeObj.TitleNView.Progress progress = this.mProgress;
            if (progress != null) {
                if (progress.isFinish()) {
                    this.mProgress.setVisibility(0);
                    return;
                } else {
                    this.mProgress.finishProgress();
                    return;
                }
            }
            return;
        }
        if (this.mProgress == null) {
            io.dcloud.feature.nativeObj.TitleNView.Progress progress2 = new io.dcloud.feature.nativeObj.TitleNView.Progress(getContext());
            this.mProgress = progress2;
            progress2.setTag("TitleNView.Progress");
        }
        try {
            iStringToColor = android.graphics.Color.parseColor(str2);
        } catch (java.lang.Exception unused) {
            iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(str2);
        }
        this.mProgress.setColorInt(iStringToColor);
        this.mProgress.setHeightInt(io.dcloud.common.util.PdrUtil.convertToScreenInt(str, this.mInnerWidth, 0, this.mCreateScale));
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setRedDot(org.json.JSONObject jSONObject, boolean z) {
        int iOptInt = jSONObject.optInt("index");
        if (iOptInt >= this.mButtons.size() || iOptInt < 0) {
            return;
        }
        java.lang.Object obj = this.mButtons.get(iOptInt);
        if (obj instanceof io.dcloud.feature.nativeObj.TitleNView.BadgeRelateiveLayout) {
            ((io.dcloud.feature.nativeObj.TitleNView.BadgeRelateiveLayout) obj).setDrawRedDot(z);
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setRedDotColor(int i) {
        if (this.redDotColor != i) {
            this.redDotColor = i;
            this.mBackButton.setRedDotColor(i);
            if (this.mButtons.size() > 0) {
                java.util.ArrayList<java.lang.Object> arrayList = this.mButtons;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    java.lang.Object obj = arrayList.get(i2);
                    i2++;
                    if (obj instanceof io.dcloud.feature.nativeObj.TitleNView.BadgeRelateiveLayout) {
                        ((io.dcloud.feature.nativeObj.TitleNView.BadgeRelateiveLayout) obj).setRedDotColor(this.redDotColor);
                    }
                }
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setSearchInputColor(java.lang.String str) {
        android.graphics.drawable.Drawable background;
        int iStringToColor;
        android.widget.LinearLayout linearLayout = this.centerSearchLayout;
        if (linearLayout == null || (background = linearLayout.getBackground()) == null || !(background instanceof io.dcloud.feature.nativeObj.TitleNView.SearchInputDrawable)) {
            return;
        }
        try {
            iStringToColor = android.graphics.Color.parseColor(str);
        } catch (java.lang.Exception unused) {
            iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(str);
        }
        io.dcloud.feature.nativeObj.TitleNView.SearchInputDrawable searchInputDrawable = (io.dcloud.feature.nativeObj.TitleNView.SearchInputDrawable) background;
        if (iStringToColor != searchInputDrawable.getDrawableColor()) {
            searchInputDrawable.setDrawableColor(iStringToColor);
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setSearchInputFocus(boolean z) {
        android.widget.EditText editText = this.searchInput;
        if (editText != null) {
            if (!z) {
                editText.clearFocus();
                io.dcloud.common.adapter.util.DeviceInfo.hideIME(this.searchInput);
            } else {
                io.dcloud.common.adapter.util.DeviceInfo.hideIME(editText);
                if (this.searchInput.requestFocus()) {
                    io.dcloud.common.adapter.util.DeviceInfo.showIME(this.searchInput);
                }
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setShadow(org.json.JSONObject jSONObject) {
        io.dcloud.feature.nativeObj.TitleNView.BackGroundDrawable backGroundDrawable = this.mBackGroundDrawable;
        if (backGroundDrawable != null) {
            backGroundDrawable.setShadowColor(jSONObject);
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setSplitLine(java.lang.String str, java.lang.String str2) {
        int iStringToColor;
        if (this.mSplitLine == null) {
            android.view.View view = new android.view.View(getContext());
            this.mSplitLine = view;
            view.setTag("TitleNView.SplitLine");
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mSplitLine.setLayoutParams(layoutParams);
        }
        initTitleNViewLayout();
        android.widget.RelativeLayout relativeLayout = this.mTitleNViewLayout;
        if (relativeLayout != null && -1 == relativeLayout.indexOfChild(this.mSplitLine)) {
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            this.mTitleNViewLayout.addView(this.mSplitLine, layoutParams2);
        }
        try {
            iStringToColor = android.graphics.Color.parseColor(str2);
        } catch (java.lang.Exception unused) {
            iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(str2);
        }
        this.mSplitLine.setBackgroundColor(iStringToColor);
        this.mSplitLine.getLayoutParams().height = io.dcloud.common.util.PdrUtil.convertToScreenInt(str, this.mInnerWidth, 0, this.mCreateScale);
        this.mSplitLine.requestLayout();
        this.mSplitLine.invalidate();
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setStatusBarColor(int i) {
        if (!this.isImmersed) {
            return;
        }
        if (this.mStatusbarView != null) {
            if (android.text.TextUtils.isEmpty(this.mBackgroundImageSrc) || !isStatusBar()) {
                this.mStatusbarView.setBackgroundColor(i);
                this.mStatusbarView.invalidate();
                return;
            }
            return;
        }
        android.view.ViewParent parent = getParent();
        if (!android.text.TextUtils.equals(this.mStyle.optString("position", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE), io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE) || parent == null || !(parent instanceof android.view.ViewGroup)) {
            return;
        }
        int i2 = 0;
        while (true) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) parent;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            android.view.View childAt = viewGroup.getChildAt(i2);
            if (childAt.getTag() != null && "StatusBar".equalsIgnoreCase(childAt.getTag().toString())) {
                childAt.setBackgroundColor(i);
                childAt.invalidate();
                return;
            }
            i2++;
        }
    }

    @Override // io.dcloud.feature.nativeObj.NativeView, io.dcloud.common.DHInterface.INativeView
    public void setStyleBackgroundColor(int i) {
        this.mBackGroundDrawable.setBackgroundColor(i);
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setTitle(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, java.lang.String str11, java.lang.String str12) {
        android.widget.ImageView imageView;
        android.widget.TextView textView;
        int iStringToColor;
        initTitleNViewLayout();
        initLeftButtonLayout();
        if (this.mTitlelayout == null) {
            this.mTitlelayout = new android.widget.RelativeLayout(getContext());
        }
        if (this.mTitlelayout.getChildAt(0) instanceof android.widget.ImageView) {
            imageView = (android.widget.ImageView) this.mTitlelayout.getChildAt(0);
        } else {
            imageView = new android.widget.ImageView(getContext());
            imageView.setId(android.view.View.generateViewId());
        }
        android.widget.ImageView imageView2 = imageView;
        if (this.mTitleView == null) {
            android.widget.TextView textView2 = new android.widget.TextView(getContext());
            this.mTitleView = textView2;
            textView2.setTag("TitleNView.Title");
            this.mTitleView.setLines(1);
            this.mTitleView.setSingleLine(true);
            this.mTitleView.setIncludeFontPadding(false);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.mTitleView.setLayoutParams(layoutParams);
            if ("clip".equals(str4)) {
                this.mTitleView.setEllipsize(null);
            } else {
                this.mTitleView.setEllipsize(android.text.TextUtils.TruncateAt.END);
            }
            this.mTitleView.setId(android.view.View.generateViewId());
        }
        if (this.mTitlelayout.getChildAt(2) instanceof android.widget.TextView) {
            textView = (android.widget.TextView) this.mTitlelayout.getChildAt(2);
        } else {
            textView = new android.widget.TextView(getContext());
            textView.setId(android.view.View.generateViewId());
        }
        android.widget.TextView textView3 = textView;
        if (!android.text.TextUtils.isEmpty(str) && !str.equals(this.mTitleView.getText())) {
            this.mTitleView.setText(str);
        }
        this.mTitleView.getPaint().setTextSize(io.dcloud.common.util.PdrUtil.convertToScreenInt(str3, this.mInnerWidth, io.dcloud.common.util.PdrUtil.convertToScreenInt("17px", this.mInnerWidth, 0, this.mCreateScale), this.mCreateScale));
        try {
            iStringToColor = android.graphics.Color.parseColor(str2);
        } catch (java.lang.Exception unused) {
            iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(str2);
        }
        int i = iStringToColor;
        this.mTitleView.setTextColor(i);
        if (-1 == this.mTitleNViewLayout.indexOfChild(this.mTitlelayout)) {
            this.mTitleNViewLayout.addView(this.mTitlelayout);
        }
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt("88px", this.mInnerWidth, 0, this.mCreateScale);
        if (str5.equals("left") || str5.equals("auto")) {
            layoutParams2.addRule(1, this.mLeftButtonLayout.getId());
            layoutParams2.addRule(15);
            layoutParams2.removeRule(13);
            layoutParams2.leftMargin = io.dcloud.common.util.PdrUtil.convertToScreenInt("10px", this.mInnerWidth, 0, this.mCreateScale);
        } else {
            layoutParams2.addRule(13);
            layoutParams2.removeRule(1);
            layoutParams2.removeRule(15);
            layoutParams2.leftMargin = iConvertToScreenInt;
        }
        layoutSubtitleIcon(str6, str7, str8, str9, str10, str11, imageView2, textView3, i, str5, str12);
        layoutParams2.rightMargin = iConvertToScreenInt;
        this.mTitlelayout.setLayoutParams(layoutParams2);
        android.widget.EditText editText = this.searchInput;
        if (editText == null || editText.getVisibility() != 0) {
            return;
        }
        this.mTitlelayout.setVisibility(4);
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setTitleAlign(java.lang.String str) {
        android.widget.RelativeLayout relativeLayout = this.mTitlelayout;
        if (relativeLayout == null) {
            return;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        if (str.equals("left") || str.equals("auto")) {
            layoutParams.addRule(1, this.mLeftButtonLayout.getId());
            layoutParams.addRule(15);
            layoutParams.removeRule(13);
            layoutParams.leftMargin = io.dcloud.common.util.PdrUtil.convertToScreenInt("5px", this.mInnerWidth, 0, this.mCreateScale);
        } else {
            layoutParams.addRule(13);
            layoutParams.removeRule(1);
            layoutParams.removeRule(15);
            layoutParams.leftMargin = layoutParams.rightMargin;
        }
        this.mTitlelayout.setLayoutParams(layoutParams);
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setTitleColor(java.lang.String str) {
        int iStringToColor;
        android.widget.TextView textView = this.mTitleView;
        if (textView != null) {
            int defaultColor = textView.getTextColors().getDefaultColor();
            try {
                iStringToColor = android.graphics.Color.parseColor(str);
            } catch (java.lang.Exception unused) {
                iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(str);
            }
            if (iStringToColor != defaultColor) {
                this.mTitleView.setTextColor(iStringToColor);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:109:0x01d7  */
    @Override // io.dcloud.common.DHInterface.ITitleNView
    public boolean setTitleNViewButtonStyle(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str10, java.lang.String str11, java.lang.String str12, java.lang.String str13, java.lang.String str14, java.lang.String str15, java.lang.String str16, java.lang.String str17) {
        int iStringToColor;
        int i2;
        int i3;
        int iStringToColor2;
        int iStringToColor3;
        if (i >= this.mButtons.size() || i < 0) {
            return false;
        }
        java.lang.Object obj = this.mButtons.get(i);
        if (obj instanceof android.view.View) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) obj;
            if (viewGroup.getChildCount() >= 1) {
                android.widget.TextView textView = (android.widget.TextView) viewGroup.getChildAt(0);
                if (io.dcloud.common.util.PdrUtil.isEmpty(str3) || io.dcloud.common.util.PdrUtil.isEmpty(str4)) {
                    iStringToColor = -1;
                    i2 = -1;
                } else {
                    try {
                        iStringToColor3 = android.graphics.Color.parseColor(str3);
                    } catch (java.lang.Exception unused) {
                        iStringToColor3 = io.dcloud.common.util.PdrUtil.stringToColor(str3);
                    }
                    try {
                        iStringToColor = android.graphics.Color.parseColor(str4);
                    } catch (java.lang.Exception unused2) {
                        iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(str4);
                    }
                    textView.setTextColor(createColorStateList(iStringToColor3, iStringToColor));
                    i2 = iStringToColor3;
                }
                if (!io.dcloud.common.util.PdrUtil.isEmpty(str5)) {
                    if (com.taobao.weex.common.Constants.Value.BOLD.equals(str5)) {
                        textView.getPaint().setFakeBoldText(true);
                    } else {
                        textView.getPaint().setFakeBoldText(false);
                    }
                    textView.postInvalidate();
                }
                if (!io.dcloud.common.util.PdrUtil.isEmpty(str6)) {
                    textView.setTextSize(0, io.dcloud.common.util.PdrUtil.convertToScreenInt(str6, this.mInnerWidth, 0, this.mCreateScale));
                }
                if (!io.dcloud.common.util.PdrUtil.isEmpty(str8) || !io.dcloud.common.util.PdrUtil.isEmpty(str)) {
                    setTextAndFont(str, str7, str8, textView, io.dcloud.common.util.PdrUtil.isEmpty(str8));
                }
                android.graphics.drawable.Drawable background = viewGroup.getBackground();
                if (!io.dcloud.common.util.PdrUtil.isEmpty(str10) && str15.equals("transparent")) {
                    try {
                        iStringToColor2 = android.graphics.Color.parseColor(str10);
                    } catch (java.lang.Exception unused3) {
                        iStringToColor2 = io.dcloud.common.util.PdrUtil.stringToColor(str10);
                    }
                    boolean z = background instanceof io.dcloud.feature.nativeObj.NativeViewBackButtonDrawable;
                    if (z) {
                        ((io.dcloud.feature.nativeObj.NativeViewBackButtonDrawable) background).setWidth(str14);
                    }
                    if (z) {
                        io.dcloud.feature.nativeObj.NativeViewBackButtonDrawable nativeViewBackButtonDrawable = (io.dcloud.feature.nativeObj.NativeViewBackButtonDrawable) background;
                        if (iStringToColor2 != nativeViewBackButtonDrawable.getDrawableColor()) {
                            nativeViewBackButtonDrawable.setDrawableColor(iStringToColor2);
                        }
                    }
                }
                if (str12 != null && (viewGroup instanceof io.dcloud.feature.nativeObj.TitleNView.BadgeRelateiveLayout)) {
                    ((io.dcloud.feature.nativeObj.TitleNView.BadgeRelateiveLayout) viewGroup).setBadgeStr(str12);
                }
                if ((viewGroup instanceof io.dcloud.feature.nativeObj.TitleNView.BadgeRelateiveLayout) && !io.dcloud.common.util.PdrUtil.isEmpty(str11)) {
                    ((io.dcloud.feature.nativeObj.TitleNView.BadgeRelateiveLayout) viewGroup).setDrawRedDot(java.lang.Boolean.parseBoolean(str11));
                }
                if (viewGroup.getChildCount() >= 2 && !io.dcloud.common.util.PdrUtil.isEmpty(str13)) {
                    android.widget.TextView textView2 = (android.widget.TextView) viewGroup.getChildAt(1);
                    if (java.lang.Boolean.parseBoolean(str13)) {
                        textView2.setVisibility(0);
                        textView.setEllipsize(android.text.TextUtils.TruncateAt.END);
                    } else {
                        textView2.setVisibility(8);
                        textView.setEllipsize(null);
                    }
                } else if (!io.dcloud.common.util.PdrUtil.isEmpty(str13) && java.lang.Boolean.parseBoolean(str13)) {
                    android.widget.TextView textViewAddSelect = addSelect(viewGroup, textView, 0);
                    if (-1 != i2 && -1 != i3) {
                        i3 = iStringToColor;
                        textViewAddSelect.setTextColor(createColorStateList(i2, i3));
                    }
                }
                if (str9 != null) {
                    addButtonOnClickListener(str9, iWebview, viewGroup);
                }
                if (io.dcloud.common.util.PdrUtil.isEmpty(str14) || !str14.equals("auto") || io.dcloud.common.util.PdrUtil.isEmpty(str13) || !java.lang.Boolean.parseBoolean(str13)) {
                    viewGroup.setPadding(0, textView.getPaddingTop(), 0, textView.getPaddingBottom());
                } else {
                    int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt("5px", this.mAppScreenWidth, 0, this.mCreateScale);
                    viewGroup.setPadding(iConvertToScreenInt, textView.getPaddingTop(), iConvertToScreenInt, textView.getPaddingBottom());
                }
                if (!io.dcloud.common.util.PdrUtil.isEmpty(str16) || !io.dcloud.common.util.PdrUtil.isEmpty(str14)) {
                    int iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt(str16, this.mAppScreenWidth, 0, this.mCreateScale);
                    int iConvertToScreenInt3 = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.PdrUtil.isEmpty(str14) ? str17 : str14, this.mAppScreenWidth, 0, this.mCreateScale);
                    if (iConvertToScreenInt2 > 0) {
                        textView.setEllipsize(android.text.TextUtils.TruncateAt.END);
                        textView.setMaxWidth(iConvertToScreenInt2);
                    }
                    android.view.ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    int iConvertToScreenInt4 = layoutParams.width;
                    if (iConvertToScreenInt2 > 0 && iConvertToScreenInt3 > iConvertToScreenInt2) {
                        iConvertToScreenInt4 = -2;
                    } else if (!io.dcloud.common.util.PdrUtil.isEmpty(str14)) {
                        if (str14.equals("auto")) {
                            iConvertToScreenInt4 = -2;
                        } else {
                            iConvertToScreenInt4 = io.dcloud.common.util.PdrUtil.convertToScreenInt(str14, this.mAppScreenWidth, layoutParams.height, this.mCreateScale);
                        }
                    }
                    layoutParams.width = iConvertToScreenInt4;
                    viewGroup.setLayoutParams(layoutParams);
                }
                caculateTitleMargin();
            } else if (obj instanceof io.dcloud.feature.nativeObj.data.ButtonDataItem) {
                ((io.dcloud.feature.nativeObj.data.ButtonDataItem) obj).update(str, str2, iWebview != null ? iWebview.getWebviewUUID() : null, str7, str8, str9);
            }
        }
        return true;
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setTitleNViewFocusable(boolean z) {
        io.dcloud.common.ui.blur.DCBlurDraweeView dCBlurDraweeView = this.mBlurDraweeView;
        if (dCBlurDraweeView == null || !dCBlurDraweeView.checkBlurEffect(this.mBlurEffect)) {
            return;
        }
        this.mBlurDraweeView.setContentFocusable(z);
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setTitleNViewPadding(int i, int i2, int i3, int i4) {
        initTitleNViewLayout();
        this.mTitleNViewLayout.setPadding(i, i2, i3, i4);
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setTitleNViewSearchInputText(java.lang.String str) {
        android.widget.EditText editText = this.searchInput;
        if (editText != null) {
            editText.setText(str);
            this.searchInput.setSelection(str.length());
            if (this.searchInput.isFocusable()) {
                return;
            }
            this.isSetText.set(true);
            this.searchInput.setFocusable(true);
            this.searchInput.setFocusableInTouchMode(true);
            this.searchInput.requestFocus();
            this.searchInput.setFocusable(false);
            this.searchInput.setFocusableInTouchMode(false);
            this.isSetText.set(false);
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setTitleOverflow(java.lang.String str) {
        if (this.mTitleView == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if ("clip".equals(str)) {
            this.mTitleView.setEllipsize(null);
        } else {
            this.mTitleView.setEllipsize(android.text.TextUtils.TruncateAt.END);
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setTitleSize(java.lang.String str) {
        if (this.mTitleView == null || android.text.TextUtils.isEmpty(str) || !str.endsWith("px")) {
            return;
        }
        float textSize = this.mTitleView.getPaint().getTextSize();
        float fConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(str, this.mInnerWidth, 0, this.mCreateScale);
        if (textSize != fConvertToScreenInt) {
            this.mTitleView.getPaint().setTextSize(fConvertToScreenInt);
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setTitleText(java.lang.String str) {
        if (this.mTitleView == null || android.text.TextUtils.isEmpty(str) || str.equals(this.mTitleView.getText())) {
            return;
        }
        this.mTitleView.setText(str);
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void startProgress() {
        io.dcloud.feature.nativeObj.TitleNView.Progress progress = this.mProgress;
        if (progress != null) {
            progress.setVisibility(0);
            this.mProgress.setAlphaInt(255);
            this.mProgress.setCurProgress(0);
            this.mProgress.setWebviewProgress(0);
            android.widget.RelativeLayout relativeLayout = this.mTitleNViewLayout;
            if (relativeLayout != null && -1 == relativeLayout.indexOfChild(this.mProgress)) {
                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, (int) this.mProgress.getHeightInt());
                layoutParams.addRule(12);
                this.mTitleNViewLayout.addView(this.mProgress, layoutParams);
            }
            io.dcloud.common.DHInterface.IFrameView iFrameView = this.mFrameViewParent;
            if (iFrameView == null || iFrameView.obtainWebView() == null || this.mFrameViewParent.obtainWebView().obtainWindowView() == null) {
                return;
            }
            if (this.mIWebviewStateListenerImpl != null) {
                this.mFrameViewParent.obtainWebView().removeStateListener(this.mIWebviewStateListenerImpl);
            }
            this.mIWebviewStateListenerImpl = new io.dcloud.feature.nativeObj.TitleNView.IWebviewStateListenerImpl(this.mProgress);
            this.mFrameViewParent.obtainWebView().addStateListener(this.mIWebviewStateListenerImpl);
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void stopProgress() {
        io.dcloud.feature.nativeObj.TitleNView.Progress progress = this.mProgress;
        if (progress == null || progress.isFinish()) {
            return;
        }
        this.mProgress.finishProgress();
    }

    private void showCapsuleMenu(final org.json.JSONArray jSONArray) {
        try {
            io.dcloud.feature.ui.nativeui.a aVar = new io.dcloud.feature.ui.nativeui.a(this.mWebView.getActivity());
            aVar.a(new io.dcloud.feature.ui.nativeui.a.b() { // from class: io.dcloud.feature.nativeObj.TitleNView.15
                @Override // io.dcloud.feature.ui.nativeui.a.b
                public void initCancelText(android.widget.TextView textView) {
                    android.text.TextPaint paint = textView.getPaint();
                    if (io.dcloud.feature.nativeObj.TitleNView.this.mMenuButtonFontWeight.equals(com.taobao.weex.common.Constants.Value.BOLD)) {
                        paint.setFakeBoldText(true);
                    } else {
                        paint.setFakeBoldText(false);
                    }
                }

                @Override // io.dcloud.feature.ui.nativeui.a.b
                public void initTextItem(int i, android.widget.TextView textView, java.lang.String str) {
                    android.widget.TextView textView2;
                    if (io.dcloud.feature.nativeObj.TitleNView.this.mMenuButtons.size() > i) {
                        io.dcloud.feature.nativeObj.data.ButtonDataItem buttonDataItem = (io.dcloud.feature.nativeObj.data.ButtonDataItem) io.dcloud.feature.nativeObj.TitleNView.this.mMenuButtons.get(i);
                        textView2 = textView;
                        io.dcloud.feature.nativeObj.TitleNView.this.setTextAndFont(str, buttonDataItem.getFontSrc(), buttonDataItem.getFontType(), textView2, android.text.TextUtils.isEmpty(buttonDataItem.getFontType()));
                    } else {
                        textView2 = textView;
                        if (jSONArray.length() > i) {
                            if (jSONArray.optJSONObject(i).optString("type", "").equals("interval")) {
                                textView2.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(android.graphics.Color.parseColor("#e5e5e5")));
                                textView2.getLayoutParams().height = 10;
                                return;
                            }
                            textView2.setText(str);
                        }
                    }
                    android.text.TextPaint paint = textView2.getPaint();
                    if (io.dcloud.feature.nativeObj.TitleNView.this.mMenuButtonFontWeight.equals(com.taobao.weex.common.Constants.Value.BOLD)) {
                        paint.setFakeBoldText(true);
                    } else {
                        paint.setFakeBoldText(false);
                    }
                    textView2.setTextColor(io.dcloud.feature.nativeObj.TitleNView.this.mMenuButtonTextColor);
                }

                @Override // io.dcloud.feature.ui.nativeui.a.b
                public boolean onDismiss(int i) {
                    int i2 = i - 1;
                    return i2 > 0 && jSONArray.length() > i2 && jSONArray.optJSONObject(i2).optString("type", "").equals("interval");
                }

                @Override // io.dcloud.feature.ui.nativeui.a.b
                public void onItemClick(int i) {
                    int i2 = i - 1;
                    if (i2 < 0) {
                        return;
                    }
                    if (io.dcloud.feature.nativeObj.TitleNView.this.mMenuButtons.size() > i2) {
                        io.dcloud.feature.nativeObj.data.ButtonDataItem buttonDataItem = (io.dcloud.feature.nativeObj.data.ButtonDataItem) io.dcloud.feature.nativeObj.TitleNView.this.mMenuButtons.get(i2);
                        if (buttonDataItem != null) {
                            io.dcloud.common.DHInterface.AbsMgr absMgrObtainWindowMgr = io.dcloud.feature.nativeObj.TitleNView.this.mWebView.obtainFrameView().obtainWindowMgr();
                            io.dcloud.common.DHInterface.IMgr.MgrType mgrType = io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr;
                            io.dcloud.common.DHInterface.IApp iApp = io.dcloud.feature.nativeObj.TitleNView.this.mApp;
                            java.lang.Object objProcessEvent = absMgrObtainWindowMgr.processEvent(mgrType, 10, new java.lang.Object[]{iApp, io.dcloud.common.constant.AbsoluteConst.F_UI, "findWebview", new java.lang.String[]{iApp.obtainAppId(), buttonDataItem.getWebviewUuid()}});
                            io.dcloud.common.DHInterface.IWebview iWebview = (objProcessEvent == null || !(objProcessEvent instanceof io.dcloud.common.DHInterface.IWebview)) ? null : (io.dcloud.common.DHInterface.IWebview) objProcessEvent;
                            if (iWebview == null) {
                                iWebview = io.dcloud.feature.nativeObj.TitleNView.this.mWebView;
                            }
                            io.dcloud.feature.nativeObj.TitleNView.this.buttonOnclick(buttonDataItem.getOnclick(), iWebview);
                            return;
                        }
                        return;
                    }
                    if (jSONArray.length() > i2) {
                        org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                        if (!jSONObjectOptJSONObject.optString("type", "").equals("interval") && jSONObjectOptJSONObject.has("id")) {
                            java.lang.String strOptString = jSONObjectOptJSONObject.optString("id");
                            android.os.Bundle bundle = new android.os.Bundle();
                            bundle.putString("id", strOptString);
                            bundle.putString("appid", io.dcloud.feature.nativeObj.TitleNView.this.mWebView.obtainApp().obtainAppId());
                            io.dcloud.common.DHInterface.IWebview iWebview2 = io.dcloud.feature.nativeObj.TitleNView.this.mWebView;
                            iWebview2.obtainFrameView().obtainWindowMgr().processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 77, new java.lang.Object[]{iWebview2, bundle});
                        }
                    }
                }
            });
            aVar.b(getContext().getString(io.dcloud.base.R.string.dcloud_common_cancel)).d(this.mMenuButtonTextColor).a(io.dcloud.common.util.PdrUtil.parseFloat(this.mMenuButtonFontSize, 0.0f, 0.0f, 1.0f)).a(jSONArray).a(true).b(false).e(0);
            aVar.j();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class BadgeLinearLayout extends android.widget.LinearLayout {
        private java.lang.String badgeStr;
        android.graphics.Rect canvasRect;
        float circle4PX;
        float circle8PX;
        private boolean isDrawRedDot;
        private android.graphics.Paint redDotPaint;
        android.text.TextPaint textPaint;

        public BadgeLinearLayout(android.content.Context context) {
            super(context);
            this.isDrawRedDot = false;
            this.badgeStr = "";
            this.canvasRect = new android.graphics.Rect();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(android.graphics.Canvas canvas) {
            super.dispatchDraw(canvas);
            canvas.getClipBounds(this.canvasRect);
            if (this.isDrawRedDot && io.dcloud.common.util.PdrUtil.isEmpty(this.badgeStr)) {
                android.graphics.Rect rect = this.canvasRect;
                float f = rect.right;
                float f2 = this.circle4PX;
                canvas.drawCircle(f - f2, rect.top + f2, f2, this.redDotPaint);
            }
        }

        @Override // android.view.View
        public void draw(android.graphics.Canvas canvas) {
            super.draw(canvas);
        }

        public void setBadgeStr(java.lang.String str) {
            if (str == null || str.equals(this.badgeStr)) {
                return;
            }
            if (str.length() > 4) {
                this.badgeStr = str.trim().substring(0, 3) + "…";
            } else {
                this.badgeStr = str.trim();
            }
            postInvalidate();
        }

        public void setDrawRedDot(boolean z) {
            if (this.isDrawRedDot != z) {
                this.isDrawRedDot = z;
                postInvalidate();
            }
        }

        public void setRedDotColor(int i) {
            this.redDotPaint.setColor(i);
            postInvalidate();
        }

        public BadgeLinearLayout(io.dcloud.feature.nativeObj.TitleNView titleNView, android.content.Context context, float f, int i) {
            this(context);
            android.graphics.Paint paint = new android.graphics.Paint();
            this.redDotPaint = paint;
            paint.setColor(i);
            this.redDotPaint.setAntiAlias(true);
            android.text.TextPaint textPaint = new android.text.TextPaint();
            this.textPaint = textPaint;
            textPaint.setColor(-1);
            this.textPaint.setFakeBoldText(true);
            this.textPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
            float fConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt("8px", 0, 0, f);
            this.circle8PX = fConvertToScreenInt;
            this.textPaint.setTextSize(fConvertToScreenInt);
            this.circle4PX = io.dcloud.common.util.PdrUtil.convertToScreenInt("4px", 0, 0, f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class BadgeRelateiveLayout extends android.widget.LinearLayout {
        private java.lang.String badgeStr;
        android.graphics.Rect canvasRect;
        float circle4PX;
        float circle8PX;
        private boolean isDrawRedDot;
        private android.graphics.Paint redDotPaint;
        android.text.TextPaint textPaint;

        public BadgeRelateiveLayout(android.content.Context context) {
            super(context);
            this.isDrawRedDot = false;
            this.badgeStr = "";
            this.canvasRect = new android.graphics.Rect();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(android.graphics.Canvas canvas) {
            super.dispatchDraw(canvas);
            canvas.getClipBounds(this.canvasRect);
            if (this.isDrawRedDot && io.dcloud.common.util.PdrUtil.isEmpty(this.badgeStr)) {
                android.graphics.Rect rect = this.canvasRect;
                float f = rect.right;
                float f2 = this.circle4PX;
                canvas.drawCircle(f - f2, rect.top + f2, f2, this.redDotPaint);
            }
            if (this.badgeStr.length() > 0) {
                android.graphics.Rect rect2 = new android.graphics.Rect();
                android.text.TextPaint textPaint = this.textPaint;
                java.lang.String str = this.badgeStr;
                textPaint.getTextBounds(str, 0, str.length(), rect2);
                android.graphics.Paint paint = new android.graphics.Paint(this.redDotPaint);
                paint.setColor(-65536);
                float fAbs = (this.canvasRect.right - java.lang.Math.abs(rect2.width())) - this.circle8PX;
                android.graphics.Rect rect3 = this.canvasRect;
                int i = rect3.top;
                android.graphics.RectF rectF = new android.graphics.RectF(fAbs, i, rect3.right, i + java.lang.Math.abs(rect2.height()) + this.circle4PX);
                canvas.drawRoundRect(rectF, rectF.height() / 2.0f, rectF.height() / 2.0f, paint);
                android.graphics.Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
                canvas.drawText(this.badgeStr, rectF.centerX(), (rectF.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f), this.textPaint);
            }
        }

        @Override // android.view.View
        public void draw(android.graphics.Canvas canvas) {
            super.draw(canvas);
        }

        public void setBadgeStr(java.lang.String str) {
            if (str == null || str.equals(this.badgeStr)) {
                return;
            }
            if (str.length() > 4) {
                this.badgeStr = str.trim().substring(0, 3) + "…";
            } else {
                this.badgeStr = str.trim();
            }
            postInvalidate();
        }

        public void setDrawRedDot(boolean z) {
            if (this.isDrawRedDot != z) {
                this.isDrawRedDot = z;
                postInvalidate();
            }
        }

        public void setRedDotColor(int i) {
            this.redDotPaint.setColor(i);
            postInvalidate();
        }

        public BadgeRelateiveLayout(io.dcloud.feature.nativeObj.TitleNView titleNView, android.content.Context context, float f, int i) {
            this(context);
            android.graphics.Paint paint = new android.graphics.Paint();
            this.redDotPaint = paint;
            paint.setColor(i);
            this.redDotPaint.setAntiAlias(true);
            android.text.TextPaint textPaint = new android.text.TextPaint();
            this.textPaint = textPaint;
            textPaint.setColor(-1);
            this.textPaint.setFakeBoldText(true);
            this.textPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
            float fConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt("8px", 0, 0, f);
            this.circle8PX = fConvertToScreenInt;
            this.textPaint.setTextSize(fConvertToScreenInt);
            this.circle4PX = io.dcloud.common.util.PdrUtil.convertToScreenInt("4px", 0, 0, f);
        }
    }

    @Override // io.dcloud.common.DHInterface.ITitleNView
    public void setTitleColor(int i) {
        android.widget.TextView textView = this.mTitleView;
        if (textView == null || i == textView.getTextColors().getDefaultColor()) {
            return;
        }
        this.mTitleView.setTextColor(i);
    }
}
