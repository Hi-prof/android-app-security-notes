package com.dcloud.android.widget;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class TabView extends android.widget.FrameLayout {
    private java.lang.String mBackgroundColor;
    private java.lang.String mBackgroundImage;
    private io.dcloud.common.ui.blur.DCBlurDraweeView mBlurDraweeView;
    private java.lang.String mBlurEffect;
    private java.lang.String mBorderStyle;
    private android.view.View mBorderView;
    private com.alibaba.fastjson.JSONArray mCommonList;
    private java.lang.String mCommonSelectedIndex;
    private android.content.Context mContext;
    private java.lang.String mDefaultBackgroundColor;
    private java.lang.String mDefaultBorderColor;
    private java.lang.String mDefaultMaskBackgroundColor;
    private java.lang.String mDefaultSelectedTextColor;
    private java.lang.String mDefaultTextColor;
    private io.dcloud.common.DHInterface.ICallBack mIDoubleCallback;
    private io.dcloud.common.DHInterface.ICallBack mIMaskCallback;
    private io.dcloud.common.DHInterface.ICallBack mIMidCallback;
    private io.dcloud.common.DHInterface.ICallBack mISingleCallback;
    private java.lang.String mIconfontPath;
    private java.lang.String mImageSize;
    private android.widget.LinearLayout mMask;
    private com.alibaba.fastjson.JSONObject mMidButton;
    private android.widget.RelativeLayout mMidButtonView;
    private int mMidIndex;
    private android.view.View.OnTouchListener mMidTouchListener;
    private android.view.View.OnClickListener mOnClickListener;
    private android.view.View.OnClickListener mOnMaskClickListener;
    private float mScale;
    private java.lang.String mSelectedColor;
    private com.alibaba.fastjson.JSONObject mStyleJson;
    private android.widget.LinearLayout mTabBar;
    private int mTabHeight;
    private java.lang.String mTabHeightStr;
    private java.util.ArrayList<android.widget.RelativeLayout> mTabItemViews;
    private java.lang.String mTextColor;
    private java.lang.String mTextSize;
    private java.lang.String mTextTop;
    private io.dcloud.common.DHInterface.IApp mWebApp;
    private int redDotColor;
    private java.lang.String repeatType;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class BackGroundDrawable extends android.graphics.drawable.Drawable {
        private android.graphics.Rect bound;
        private android.graphics.Paint colorPaint;
        private android.graphics.Paint mPaint;
        private android.graphics.Shader mBackgroundBitmap = null;
        private java.lang.String bitmapPath = null;
        private java.lang.String repeat = "no-repeat";
        private int mBackgroundColor = 0;

        BackGroundDrawable() {
        }

        private android.graphics.Shader getShader(java.util.List<java.lang.String> list, float f, float f2) {
            float[] gradientDirection = parseGradientDirection(list.get(0).trim(), f, f2);
            if (gradientDirection == null) {
                return null;
            }
            return new android.graphics.LinearGradient(gradientDirection[0], gradientDirection[1], gradientDirection[2], gradientDirection[3], io.dcloud.common.util.PdrUtil.stringToColor(list.get(1).trim()), io.dcloud.common.util.PdrUtil.stringToColor(list.get(2).trim()), android.graphics.Shader.TileMode.CLAMP);
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
            if (this.repeat.equals("repeat")) {
                return bitmap;
            }
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            float f = i / width;
            float f2 = i2 / height;
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            if (this.repeat.equals("repeat-x")) {
                matrix.preScale(1.0f, f2);
            } else if (this.repeat.equals("repeat-y")) {
                matrix.preScale(f, 1.0f);
            } else {
                matrix.preScale(f, f2);
            }
            return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(android.graphics.Canvas canvas) {
            if (this.bound == null) {
                this.bound = getBounds();
            }
            if (this.mBackgroundBitmap != null) {
                getPaint().setShader(this.mBackgroundBitmap);
                getBackgroundColorPaint().setColor(android.graphics.Color.argb(getBackgroundColorPaint().getAlpha(), 255, 255, 255));
                canvas.drawRect(this.bound, getBackgroundColorPaint());
            } else {
                java.lang.String str = this.bitmapPath;
                if (str != null) {
                    setBackgroundImage(str);
                    this.bitmapPath = null;
                    getBackgroundColorPaint().setColor(android.graphics.Color.argb(getBackgroundColorPaint().getAlpha(), 255, 255, 255));
                    canvas.drawRect(this.bound, getBackgroundColorPaint());
                    getPaint().setShader(this.mBackgroundBitmap);
                } else {
                    getPaint().setColor(this.mBackgroundColor);
                }
            }
            canvas.drawRect(this.bound, getPaint());
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
            } else {
                this.mBackgroundColor = i;
            }
            invalidateSelf();
        }

        public void setBackgroundImage(java.lang.String str) {
            android.graphics.Bitmap bitmapDecodeFile;
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
                java.lang.String iconPath = com.dcloud.android.widget.TabView.this.getIconPath(str);
                if (iconPath.startsWith(io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET)) {
                    try {
                        bitmapDecodeFile = android.graphics.BitmapFactory.decodeStream(com.dcloud.android.widget.TabView.this.getContext().getAssets().open(iconPath.replace(io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET, "")));
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    bitmapDecodeFile = iconPath.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL) ? android.graphics.BitmapFactory.decodeFile(iconPath.replace(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, "")) : null;
                }
                if (bitmapDecodeFile == null) {
                    this.mBackgroundBitmap = null;
                    this.bitmapPath = null;
                    invalidateSelf();
                    return;
                }
                byte[] ninePatchChunk = bitmapDecodeFile.getNinePatchChunk();
                if (ninePatchChunk == null || !android.graphics.NinePatch.isNinePatchChunk(ninePatchChunk)) {
                    bitmapScaleBitmap = scaleBitmap(bitmapDecodeFile, this.bound.width(), this.bound.height());
                } else {
                    android.graphics.drawable.NinePatchDrawable ninePatchDrawable = new android.graphics.drawable.NinePatchDrawable(bitmapDecodeFile, ninePatchChunk, new android.graphics.Rect(), null);
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

        public void setBackgroundRepeat(java.lang.String str, java.lang.String str2) {
            if (io.dcloud.common.util.PdrUtil.isEmpty(str) || str.equals(this.repeat) || android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            this.repeat = str;
            this.mBackgroundBitmap = null;
            setBackgroundImage(str2);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        }
    }

    public TabView(android.content.Context context, android.view.View view, com.alibaba.fastjson.JSONObject jSONObject, float f, io.dcloud.common.DHInterface.IApp iApp) {
        super(context);
        this.mDefaultTextColor = "#7A7E83";
        this.mDefaultSelectedTextColor = "#3cc51f";
        this.mDefaultBorderColor = "#000000";
        this.mDefaultBackgroundColor = io.dcloud.common.util.TitleNViewUtil.TRANSPARENT_BUTTON_TEXT_COLOR;
        this.mDefaultMaskBackgroundColor = "#00000000";
        this.mImageSize = "24px";
        this.mTextTop = "3px";
        this.mTextSize = "10px";
        this.redDotColor = -65536;
        this.mBlurEffect = "none";
        this.mMidTouchListener = new android.view.View.OnTouchListener() { // from class: com.dcloud.android.widget.TabView.3
            long downTime = 0;
            float X = 0.0f;
            float Y = 0.0f;
            boolean downInMid = false;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view2, android.view.MotionEvent motionEvent) {
                if (com.dcloud.android.widget.TabView.this.mMidButtonView == null || com.dcloud.android.widget.TabView.this.mMidButtonView.getParent() == null) {
                    this.downInMid = false;
                } else {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        android.widget.RelativeLayout relativeLayout = com.dcloud.android.widget.TabView.this.mMidButtonView;
                        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
                            this.downInMid = false;
                        } else {
                            this.downInMid = new android.graphics.Rect(relativeLayout.getLeft(), relativeLayout.getTop() + com.dcloud.android.widget.TabView.this.mTabBar.getTop(), relativeLayout.getRight(), relativeLayout.getBottom() + com.dcloud.android.widget.TabView.this.mTabBar.getTop()).contains((int) motionEvent.getX(), (int) motionEvent.getY());
                        }
                        this.downTime = java.lang.System.currentTimeMillis();
                        this.X = motionEvent.getX();
                        this.Y = motionEvent.getY();
                    } else if (action == 1 && this.downInMid && java.lang.System.currentTimeMillis() - this.downTime < 500 && java.lang.Math.abs(motionEvent.getY() - this.Y) < 70.0f && java.lang.Math.abs(motionEvent.getX() - this.X) < 70.0f && com.dcloud.android.widget.TabView.this.mIMidCallback != null) {
                        com.dcloud.android.widget.TabView.this.mIMidCallback.onCallBack(0, null);
                    }
                }
                return this.downInMid;
            }
        };
        this.mOnClickListener = new android.view.View.OnClickListener() { // from class: com.dcloud.android.widget.TabView.4
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view2) {
                int iIntValue = ((java.lang.Integer) view2.getTag()).intValue();
                com.dcloud.android.widget.TabView.this.switchTab(iIntValue);
                if (com.dcloud.android.widget.TabView.this.mISingleCallback != null) {
                    com.dcloud.android.widget.TabView.this.mISingleCallback.onCallBack(iIntValue, null);
                }
            }
        };
        this.mOnMaskClickListener = new android.view.View.OnClickListener() { // from class: com.dcloud.android.widget.TabView.5
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view2) {
                if (com.dcloud.android.widget.TabView.this.mIMaskCallback != null) {
                    com.dcloud.android.widget.TabView.this.mIMaskCallback.onCallBack(0, null);
                }
            }
        };
        this.mMidIndex = 0;
        this.mContext = context;
        this.mScale = f;
        this.mWebApp = iApp;
        setClipChildren(false);
        this.mStyleJson = jSONObject;
        if (jSONObject == null) {
            this.mStyleJson = new com.alibaba.fastjson.JSONObject();
        }
        if (jSONObject.containsKey("iconfontSrc")) {
            java.lang.String string = jSONObject.getString("iconfontSrc");
            if (!io.dcloud.common.util.PdrUtil.isNetPath(string)) {
                this.mIconfontPath = this.mWebApp.convert2AbsFullPath(string);
            }
        }
        this.mTextColor = this.mStyleJson.getString("color");
        this.mSelectedColor = this.mStyleJson.getString("selectedColor");
        this.mBackgroundColor = this.mStyleJson.getString("backgroundColor");
        this.mBackgroundImage = this.mStyleJson.getString(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE);
        this.repeatType = this.mStyleJson.getString("backgroundRepeat");
        if (this.mStyleJson.containsKey("blurEffect")) {
            this.mBlurEffect = this.mStyleJson.getString("blurEffect");
        }
        if (this.mStyleJson.containsKey("redDotColor")) {
            java.lang.String string2 = this.mStyleJson.getString("redDotColor");
            if (!io.dcloud.common.util.PdrUtil.isEmpty(string2)) {
                this.redDotColor = io.dcloud.common.util.PdrUtil.stringToColor(string2);
            }
        }
        this.mBorderStyle = this.mStyleJson.getString(com.taobao.weex.common.Constants.Name.BORDER_STYLE);
        if (this.mStyleJson.containsKey(com.taobao.weex.common.Constants.Name.FONT_SIZE)) {
            this.mTextSize = this.mStyleJson.getString(com.taobao.weex.common.Constants.Name.FONT_SIZE);
        }
        if (this.mStyleJson.containsKey(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON_WIDTH)) {
            this.mImageSize = this.mStyleJson.getString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON_WIDTH);
        }
        float fApplyDimension = android.util.TypedValue.applyDimension(1, 72.0f, getResources().getDisplayMetrics());
        this.mTabHeightStr = !this.mStyleJson.containsKey("height") ? "50px" : this.mStyleJson.getString("height");
        if (this.mStyleJson.containsKey("spacing")) {
            this.mTextTop = this.mStyleJson.getString("spacing");
        }
        this.mTabHeight = (int) io.dcloud.common.util.PdrUtil.parseFloat(this.mTabHeightStr, 0.0f, fApplyDimension, f);
        this.mCommonSelectedIndex = this.mStyleJson.getString("selected") == null ? com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT : this.mStyleJson.getString("selected");
        this.mCommonList = this.mStyleJson.getJSONArray(com.taobao.weex.ui.component.WXBasicComponentType.LIST);
        this.mMidButton = this.mStyleJson.getJSONObject("midButton");
        this.mTabItemViews = new java.util.ArrayList<>();
        this.mBorderView = new android.view.View(context);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, 1);
        layoutParams.bottomMargin = this.mTabHeight;
        layoutParams.gravity = 80;
        addView(this.mBorderView, layoutParams);
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        this.mTabBar = linearLayout;
        linearLayout.setOrientation(0);
        this.mTabBar.setGravity(80);
        this.mTabBar.setClipChildren(false);
        if (this.mBlurEffect.equals(io.dcloud.common.ui.blur.DCBlurDraweeView.LIGHT) || this.mBlurEffect.equals(io.dcloud.common.ui.blur.DCBlurDraweeView.DARK) || this.mBlurEffect.equals(io.dcloud.common.ui.blur.DCBlurDraweeView.EXTRALIGHT)) {
            this.mDefaultBackgroundColor = "#00FFFFFF";
            this.mBlurDraweeView = new io.dcloud.common.ui.blur.DCBlurDraweeView(iApp.getActivity(), true, io.dcloud.common.ui.blur.DCBlurDraweeView.SEMI_AUTOMATICALLY);
            android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-1, this.mTabHeight);
            layoutParams2.gravity = 80;
            this.mBlurDraweeView.setDownscaleFactor(0.3f);
            this.mBlurDraweeView.setBlurRadius(20);
            this.mBlurDraweeView.setBlurEffect(this.mBlurEffect);
            this.mBlurDraweeView.setGravityType(80);
            addView(this.mBlurDraweeView, layoutParams2);
            this.mBlurDraweeView.setBlur(true);
            this.mBlurDraweeView.setRootView(view);
            this.mBlurDraweeView.setBlurLayoutChangeCallBack(new io.dcloud.common.ui.blur.DCBlurDraweeView.BlurLayoutChangeCallBack() { // from class: com.dcloud.android.widget.TabView.1
                @Override // io.dcloud.common.ui.blur.DCBlurDraweeView.BlurLayoutChangeCallBack
                public void setVisibility(int i) {
                    if (com.dcloud.android.widget.TabView.this.mTabBar != null) {
                        com.dcloud.android.widget.TabView.this.mTabBar.setVisibility(i);
                    }
                }
            });
        }
        addView(this.mTabBar, new android.view.ViewGroup.LayoutParams(-1, this.mTabHeight));
        initTabStyle();
        initTabItemStyle();
        setSelectedStyle();
        setOnTouchListener(this.mMidTouchListener);
    }

    private void changeNavigationBarColor(final int i) {
        if (android.os.Build.VERSION.SDK_INT < 26 || this.mContext == null) {
            return;
        }
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new java.lang.Runnable() { // from class: com.dcloud.android.widget.TabView.6
            @Override // java.lang.Runnable
            public void run() {
                android.view.Window window = ((android.app.Activity) com.dcloud.android.widget.TabView.this.mContext).getWindow();
                if (com.dcloud.android.widget.TabView.this.mWebApp instanceof io.dcloud.p.e5) {
                    ((io.dcloud.p.e5) com.dcloud.android.widget.TabView.this.mWebApp).a(i);
                } else {
                    window.setNavigationBarColor(i);
                }
                int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                window.getDecorView().setSystemUiVisibility(io.dcloud.common.util.PdrUtil.isLightColor(i) ? systemUiVisibility | 16 : systemUiVisibility & (-17));
            }
        }, 400L);
    }

    private android.view.ViewGroup getCommonItemByIndex(int i) {
        if (this.mTabItemViews.size() - 1 >= i) {
            return this.mTabItemViews.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getIconPath(java.lang.String str) {
        java.lang.String strConvert2AbsFullPath = this.mWebApp.convert2AbsFullPath(str);
        if (strConvert2AbsFullPath != null && io.dcloud.common.util.PdrUtil.isDeviceRootDir(strConvert2AbsFullPath)) {
            return io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + strConvert2AbsFullPath;
        }
        if (strConvert2AbsFullPath != null && strConvert2AbsFullPath.startsWith("/") && strConvert2AbsFullPath.length() > 1) {
            strConvert2AbsFullPath = strConvert2AbsFullPath.substring(1);
        }
        if (strConvert2AbsFullPath != null && strConvert2AbsFullPath.startsWith("android_asset/")) {
            strConvert2AbsFullPath = strConvert2AbsFullPath.replace("android_asset/", "");
        }
        return io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET + strConvert2AbsFullPath;
    }

    private void initTabItemStyle() {
        for (int i = 0; i < this.mCommonList.size(); i++) {
            setCommonItemStyle(i, (com.alibaba.fastjson.JSONObject) this.mCommonList.get(i));
        }
        updateMidItemStyle();
    }

    private void initTabStyle() {
        com.dcloud.android.widget.TabView.BackGroundDrawable backGroundDrawable;
        if (this.mTabBar.getBackground() instanceof com.dcloud.android.widget.TabView.BackGroundDrawable) {
            backGroundDrawable = (com.dcloud.android.widget.TabView.BackGroundDrawable) this.mTabBar.getBackground();
        } else {
            backGroundDrawable = new com.dcloud.android.widget.TabView.BackGroundDrawable();
            this.mTabBar.setBackground(backGroundDrawable);
        }
        backGroundDrawable.setBackgroundRepeat(this.repeatType, this.mBackgroundImage);
        int iOptColor = optColor(this.mBackgroundColor, this.mDefaultBackgroundColor);
        backGroundDrawable.setBackgroundColor(iOptColor);
        backGroundDrawable.setBackgroundImage(this.mBackgroundImage);
        changeNavigationBarColor(iOptColor);
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.mTabBar.getLayoutParams();
        layoutParams.gravity = 80;
        layoutParams.height = this.mTabHeight;
        this.mTabBar.setLayoutParams(layoutParams);
        this.mBorderView.setBackgroundColor(optColor(this.mBorderStyle, this.mDefaultBorderColor));
    }

    private static int optColor(java.lang.String str, java.lang.String str2) {
        try {
            return str == null ? io.dcloud.common.util.PdrUtil.stringToColor(str2) : io.dcloud.common.util.PdrUtil.stringToColor(str);
        } catch (java.lang.Exception unused) {
            return io.dcloud.common.util.PdrUtil.stringToColor(str2);
        }
    }

    private void placeholder(java.lang.String str, android.widget.ImageView imageView) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.bumptech.glide.Glide.with(getContext()).load(getIconPath(str)).dontAnimate().placeholder(imageView.getDrawable()).into(imageView);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void setCommonItemJson(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.fastjson.JSONObject jSONObject, boolean z) {
        if (i >= this.mCommonList.size()) {
            return;
        }
        com.alibaba.fastjson.JSONObject jSONObject2 = this.mCommonList.getJSONObject(i);
        if (str != null) {
            jSONObject2.put("text", (java.lang.Object) str);
        }
        if (str2 != null) {
            jSONObject2.put("iconPath", (java.lang.Object) str2);
        }
        if (str3 != null) {
            jSONObject2.put("selectedIconPath", (java.lang.Object) str3);
        }
        if (jSONObject != null) {
            if (jSONObject2.containsKey("iconfont")) {
                com.alibaba.fastjson.JSONObject jSONObject3 = jSONObject2.getJSONObject("iconfont");
                if (jSONObject3 != null && (r5 = jSONObject.keySet().iterator()) != null) {
                    for (java.lang.String str4 : jSONObject.keySet()) {
                        jSONObject3.put(str4, (java.lang.Object) jSONObject.getString(str4));
                    }
                }
            } else {
                jSONObject2.put("iconfont", (java.lang.Object) jSONObject);
            }
        }
        jSONObject2.put("visible", (java.lang.Object) java.lang.Boolean.valueOf(z));
        setCommonItemStyle(i, jSONObject2);
    }

    private void setCommonItemStyle(int i, com.alibaba.fastjson.JSONObject jSONObject) {
        android.widget.RelativeLayout relativeLayout;
        int i2;
        pl.droidsonroids.gif.GifDrawable gifDrawable;
        int i3;
        jSONObject.getString("pagePath");
        java.lang.String string = jSONObject.getString("text");
        com.alibaba.fastjson.JSONObject jSONObject2 = jSONObject.getJSONObject("textLocales");
        if (jSONObject2 != null) {
            string = io.dcloud.common.util.language.LanguageUtil.getString(jSONObject2, string);
        }
        java.lang.String string2 = jSONObject.getString("iconPath");
        java.lang.String string3 = jSONObject.getString("selectedIconPath");
        com.alibaba.fastjson.JSONObject jSONObject3 = jSONObject.getJSONObject("iconfont");
        int i4 = java.lang.Integer.parseInt(this.mCommonSelectedIndex);
        boolean booleanValue = jSONObject.containsKey("visible") ? jSONObject.getBooleanValue("visible") : true;
        if (this.mTabItemViews.size() - 1 < i) {
            relativeLayout = (android.widget.RelativeLayout) android.view.LayoutInflater.from(this.mContext).inflate(io.dcloud.base.R.layout.dcloud_tabbar_item, (android.view.ViewGroup) null);
            relativeLayout.setTag(java.lang.Integer.valueOf(i));
            relativeLayout.setOnClickListener(this.mOnClickListener);
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.mTabBar.addView(relativeLayout, layoutParams);
            this.mTabItemViews.add(relativeLayout);
        } else {
            relativeLayout = this.mTabItemViews.get(i);
        }
        android.widget.ImageView imageView = (android.widget.ImageView) relativeLayout.findViewById(io.dcloud.base.R.id.tabIV);
        android.widget.TextView textView = (android.widget.TextView) relativeLayout.findViewById(io.dcloud.base.R.id.iconfontTV);
        if (jSONObject3 != null) {
            imageView.setVisibility(8);
            updateIconfont(textView, jSONObject3, io.dcloud.common.util.PdrUtil.parseFloat(this.mImageSize, 0.0f, 0.0f, this.mScale), i4 == i);
        } else if (io.dcloud.common.util.PdrUtil.isEmpty(string2) && io.dcloud.common.util.PdrUtil.isEmpty(string3)) {
            imageView.setVisibility(8);
            textView.setVisibility(8);
        } else {
            if (io.dcloud.common.util.PdrUtil.isEmpty(string3) || i4 != i) {
                if (io.dcloud.common.util.PdrUtil.isEmpty(string2)) {
                    i2 = 8;
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                    android.widget.LinearLayout.LayoutParams layoutParams2 = (android.widget.LinearLayout.LayoutParams) imageView.getLayoutParams();
                    layoutParams2.height = (int) io.dcloud.common.util.PdrUtil.parseFloat(this.mImageSize, 0.0f, 0.0f, this.mScale);
                    layoutParams2.width = (int) io.dcloud.common.util.PdrUtil.parseFloat(this.mImageSize, 0.0f, 0.0f, this.mScale);
                    imageView.setLayoutParams(layoutParams2);
                    placeholder(string2, imageView);
                }
                textView.setVisibility(i2);
            } else {
                imageView.setVisibility(0);
                android.widget.LinearLayout.LayoutParams layoutParams3 = (android.widget.LinearLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams3.height = (int) io.dcloud.common.util.PdrUtil.parseFloat(this.mImageSize, 0.0f, 0.0f, this.mScale);
                layoutParams3.width = (int) io.dcloud.common.util.PdrUtil.parseFloat(this.mImageSize, 0.0f, 0.0f, this.mScale);
                imageView.setLayoutParams(layoutParams3);
                java.lang.String iconPath = getIconPath(string3);
                try {
                    if (iconPath.startsWith(io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET)) {
                        gifDrawable = new pl.droidsonroids.gif.GifDrawable(this.mContext.getAssets(), iconPath.replace(io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET, ""));
                    } else {
                        gifDrawable = new pl.droidsonroids.gif.GifDrawable(getContext().getContentResolver(), android.net.Uri.parse(iconPath));
                    }
                    gifDrawable.setLoopCount(1);
                    imageView.setImageDrawable(gifDrawable);
                } catch (java.lang.Exception unused) {
                    placeholder(string3, imageView);
                }
            }
            i2 = 8;
            textView.setVisibility(i2);
        }
        android.widget.TextView textView2 = (android.widget.TextView) relativeLayout.findViewById(io.dcloud.base.R.id.tabTV);
        textView2.setTag(jSONObject);
        ((android.graphics.drawable.GradientDrawable) ((android.widget.ImageView) relativeLayout.findViewById(io.dcloud.base.R.id.itemDot)).getDrawable()).setColor(this.redDotColor);
        if (io.dcloud.common.util.PdrUtil.isEmpty(string)) {
            i3 = 8;
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            android.widget.LinearLayout.LayoutParams layoutParams4 = (android.widget.LinearLayout.LayoutParams) textView2.getLayoutParams();
            layoutParams4.topMargin = (int) io.dcloud.common.util.PdrUtil.parseFloat(this.mTextTop, 0.0f, 0.0f, this.mScale);
            textView2.setLayoutParams(layoutParams4);
            textView2.setTextSize(0, io.dcloud.common.util.PdrUtil.parseFloat(this.mTextSize, 0.0f, 0.0f, this.mScale));
            if (i4 != i) {
                textView2.setTextColor(optColor(this.mTextColor, this.mDefaultTextColor));
            } else {
                textView2.setTextColor(optColor(this.mSelectedColor, this.mDefaultSelectedTextColor));
            }
            textView2.setText(string);
            i3 = 8;
        }
        if (booleanValue) {
            relativeLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(i3);
        }
    }

    private void setDotBadgeMarginTop(android.view.ViewGroup viewGroup, android.view.View view) {
        float f;
        float f2;
        android.view.View viewFindViewById = viewGroup.findViewById(io.dcloud.base.R.id.tabIV);
        float height = viewGroup.getHeight() / this.mScale;
        float height2 = viewGroup.findViewById(io.dcloud.base.R.id.contentWrapper).getHeight() / this.mScale;
        float height3 = view.getHeight() / this.mScale;
        float f3 = (height - height2) / 2.0f;
        if (viewFindViewById.getVisibility() == 0) {
            height3 /= 2.0f;
        }
        float f4 = f3 - height3;
        float f5 = 0.0f;
        if (f4 <= 2.0f) {
            height3 = ((f3 <= height3 || f4 >= 2.0f) && (f3 >= height3 || f3 <= 2.0f)) ? 0.0f : f3 - 2.0f;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = (int) ((-height3) * this.mScale);
        if (viewFindViewById.getVisibility() == 0) {
            if (view.getId() == io.dcloud.base.R.id.itemDot) {
                f = this.mScale;
                f2 = -5.0f;
            } else {
                if (view.getId() == io.dcloud.base.R.id.itemBadge) {
                    f = this.mScale;
                    f2 = -9.0f;
                }
                layoutParams.leftMargin = (int) (f5 - ((viewGroup.findViewById(io.dcloud.base.R.id.contentWrapper).getWidth() - viewFindViewById.getWidth()) / 2));
            }
            f5 = f * f2;
            layoutParams.leftMargin = (int) (f5 - ((viewGroup.findViewById(io.dcloud.base.R.id.contentWrapper).getWidth() - viewFindViewById.getWidth()) / 2));
        }
        view.setLayoutParams(layoutParams);
    }

    private void setSelectedStyle() {
        for (int i = 0; i < this.mTabItemViews.size(); i++) {
            java.lang.String str = this.mCommonSelectedIndex;
            if (str != null) {
                int i2 = java.lang.Integer.parseInt(str);
                android.widget.RelativeLayout relativeLayout = this.mTabItemViews.get(i);
                android.widget.TextView textView = (android.widget.TextView) relativeLayout.findViewById(io.dcloud.base.R.id.tabTV);
                final android.widget.ImageView imageView = (android.widget.ImageView) relativeLayout.findViewById(io.dcloud.base.R.id.tabIV);
                android.widget.TextView textView2 = (android.widget.TextView) relativeLayout.findViewById(io.dcloud.base.R.id.iconfontTV);
                com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) textView.getTag();
                com.alibaba.fastjson.JSONObject jSONObject2 = jSONObject.getJSONObject("iconfont");
                if (i2 == i) {
                    textView.setTextColor(optColor(this.mSelectedColor, this.mDefaultSelectedTextColor));
                    if (jSONObject2 != null) {
                        if (jSONObject2.containsKey("selectedText")) {
                            textView2.setText(jSONObject2.getString("selectedText"));
                        }
                        if (jSONObject2.containsKey("selectedColor")) {
                            textView2.setTextColor(io.dcloud.common.util.PdrUtil.stringToColor(jSONObject2.getString("selectedColor")));
                        }
                    } else {
                        java.lang.String string = jSONObject.getString("selectedIconPath");
                        try {
                            java.lang.String iconPath = getIconPath(string);
                            pl.droidsonroids.gif.GifDrawable gifDrawable = iconPath.startsWith(io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET) ? new pl.droidsonroids.gif.GifDrawable(this.mContext.getAssets(), iconPath.replace(io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET, "")) : new pl.droidsonroids.gif.GifDrawable(getContext().getContentResolver(), android.net.Uri.parse(iconPath));
                            gifDrawable.setLoopCount(1);
                            gifDrawable.addAnimationListener(new pl.droidsonroids.gif.AnimationListener() { // from class: com.dcloud.android.widget.TabView.2
                                @Override // pl.droidsonroids.gif.AnimationListener
                                public void onAnimationCompleted(int i3) {
                                    android.graphics.drawable.Drawable drawable = imageView.getDrawable();
                                    if (drawable instanceof pl.droidsonroids.gif.GifDrawable) {
                                        pl.droidsonroids.gif.GifDrawable gifDrawable2 = (pl.droidsonroids.gif.GifDrawable) drawable;
                                        gifDrawable2.seekToFrame(gifDrawable2.getNumberOfFrames());
                                        gifDrawable2.removeAnimationListener(this);
                                    }
                                }
                            });
                            imageView.setImageDrawable(gifDrawable);
                        } catch (java.lang.Exception unused) {
                            placeholder(string, imageView);
                        }
                    }
                } else {
                    textView.setTextColor(optColor(this.mTextColor, this.mDefaultTextColor));
                    if (jSONObject2 != null) {
                        if (jSONObject2.containsKey("text")) {
                            textView2.setText(jSONObject2.getString("text"));
                        }
                        if (jSONObject2.containsKey("color")) {
                            textView2.setTextColor(optColor(jSONObject2.getString("color"), this.mDefaultTextColor));
                        }
                    } else {
                        placeholder(jSONObject.getString("iconPath"), imageView);
                    }
                }
            }
        }
    }

    private void setTabItemStyle() {
        initTabItemStyle();
    }

    private void updateMidItemStyle() {
        com.alibaba.fastjson.JSONObject jSONObject = this.mMidButton;
        boolean booleanValue = (jSONObject == null || !jSONObject.containsKey("visible")) ? true : this.mMidButton.getBooleanValue("visible");
        if (booleanValue) {
            booleanValue = canMidButtonShowDisplayed();
        }
        if (!booleanValue) {
            android.widget.RelativeLayout relativeLayout = this.mMidButtonView;
            if (relativeLayout == null || relativeLayout.getParent() == null) {
                return;
            }
            this.mTabBar.removeView(this.mMidButtonView);
            return;
        }
        com.alibaba.fastjson.JSONObject jSONObject2 = this.mMidButton;
        if (jSONObject2 == null) {
            return;
        }
        float f = jSONObject2.getString("height") != null ? io.dcloud.common.util.PdrUtil.parseFloat(this.mMidButton.getString("height"), 0.0f, 0.0f, this.mScale) : -1.0f;
        float f2 = this.mMidButton.getString("width") != null ? io.dcloud.common.util.PdrUtil.parseFloat(this.mMidButton.getString("width"), 0.0f, 0.0f, this.mScale) : -1.0f;
        java.lang.String string = this.mMidButton.getString("text");
        com.alibaba.fastjson.JSONObject jSONObject3 = this.mMidButton.getJSONObject("textLocales");
        if (jSONObject3 != null) {
            string = io.dcloud.common.util.language.LanguageUtil.getString(jSONObject3, string);
        }
        float f3 = io.dcloud.common.util.PdrUtil.parseFloat(this.mMidButton.getString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON_WIDTH) != null ? this.mMidButton.getString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON_WIDTH) : this.mImageSize, 0.0f, 0.0f, this.mScale);
        java.lang.String string2 = this.mMidButton.getString("iconPath");
        java.lang.String string3 = this.mMidButton.getString(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE);
        com.alibaba.fastjson.JSONObject jSONObject4 = this.mMidButton.getJSONObject("iconfont");
        android.widget.RelativeLayout relativeLayout2 = this.mMidButtonView;
        if (relativeLayout2 == null) {
            relativeLayout2 = (android.widget.RelativeLayout) android.view.LayoutInflater.from(this.mContext).inflate(io.dcloud.base.R.layout.dcloud_tabbar_mid, (android.view.ViewGroup) null);
            this.mMidButtonView = relativeLayout2;
        }
        ((android.graphics.drawable.GradientDrawable) ((android.widget.ImageView) relativeLayout2.findViewById(io.dcloud.base.R.id.itemDot)).getDrawable()).setColor(this.redDotColor);
        float f4 = (int) io.dcloud.common.util.PdrUtil.parseFloat(this.mImageSize, 0.0f, 0.0f, this.mScale);
        float f5 = (int) io.dcloud.common.util.PdrUtil.parseFloat(this.mTextTop, 0.0f, 0.0f, this.mScale);
        float f6 = (int) io.dcloud.common.util.PdrUtil.parseFloat(this.mTextSize, 0.0f, 0.0f, this.mScale);
        android.widget.ImageView imageView = (android.widget.ImageView) relativeLayout2.findViewById(io.dcloud.base.R.id.tabIV);
        android.widget.TextView textView = (android.widget.TextView) relativeLayout2.findViewById(io.dcloud.base.R.id.tabIconTV);
        if (jSONObject4 != null) {
            imageView.setVisibility(8);
            updateIconfont(textView, jSONObject4, f3, false);
        } else if (android.text.TextUtils.isEmpty(string2)) {
            textView.setVisibility(8);
            imageView.setVisibility(8);
        } else {
            textView.setVisibility(8);
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) imageView.getLayoutParams();
            int i = (int) f3;
            layoutParams.height = i;
            layoutParams.width = i;
            imageView.setLayoutParams(layoutParams);
            placeholder(string2, imageView);
            imageView.setVisibility(0);
        }
        android.widget.TextView textView2 = (android.widget.TextView) relativeLayout2.findViewById(io.dcloud.base.R.id.tabTV);
        textView2.setTextSize(0, io.dcloud.common.util.PdrUtil.parseFloat(this.mTextSize, 0.0f, 0.0f, this.mScale));
        textView2.setTextColor(optColor(this.mTextColor, this.mDefaultTextColor));
        textView2.setText(string);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) textView2.getLayoutParams();
        layoutParams2.bottomMargin = (int) ((this.mTabHeight - ((f4 + f5) + f6)) / 2.0f);
        textView2.setLayoutParams(layoutParams2);
        if (android.text.TextUtils.isEmpty(string)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
        }
        placeholder(string3, (android.widget.ImageView) relativeLayout2.findViewById(io.dcloud.base.R.id.bgImg));
        android.widget.LinearLayout.LayoutParams layoutParams3 = new android.widget.LinearLayout.LayoutParams((int) f2, (int) f);
        if (f2 == -1.0f) {
            layoutParams3.weight = 1.0f;
        }
        if (this.mMidButtonView.getParent() != null) {
            this.mTabBar.removeView(this.mMidButtonView);
        }
        this.mTabBar.addView(this.mMidButtonView, this.mMidIndex, layoutParams3);
    }

    public void bringMaskToFront() {
        android.widget.LinearLayout linearLayout = this.mMask;
        if (linearLayout != null) {
            linearLayout.bringToFront();
        }
    }

    public boolean canMidButtonShowDisplayed() {
        int tabItemDisplayedSize = getTabItemDisplayedSize();
        boolean z = tabItemDisplayedSize % 2 == 0;
        if (z) {
            int i = tabItemDisplayedSize / 2;
            int i2 = 0;
            for (int i3 = 0; i3 < this.mCommonList.size(); i3++) {
                com.alibaba.fastjson.JSONObject jSONObject = this.mCommonList.getJSONObject(i3);
                if (jSONObject != null) {
                    if (!jSONObject.containsKey("visible") || jSONObject.getBoolean("visible").booleanValue()) {
                        i2++;
                    }
                    if (i2 == i) {
                        this.mMidIndex = i3 + 1;
                    }
                }
            }
        }
        return z;
    }

    public void dispose() {
        this.mTabItemViews.clear();
        this.mMidButtonView = null;
    }

    public int getMidHeight() {
        com.alibaba.fastjson.JSONObject jSONObject = this.mMidButton;
        if (jSONObject == null) {
            return 0;
        }
        return (int) io.dcloud.common.util.PdrUtil.parseFloat(jSONObject.getString("height"), 0.0f, 0.0f, this.mScale);
    }

    public int getTabHeight() {
        io.dcloud.common.ui.blur.DCBlurDraweeView dCBlurDraweeView = this.mBlurDraweeView;
        if (dCBlurDraweeView == null || !dCBlurDraweeView.checkBlurEffect(this.mBlurEffect)) {
            return this.mTabHeight;
        }
        return 0;
    }

    public java.lang.String getTabHeightStr() {
        io.dcloud.common.ui.blur.DCBlurDraweeView dCBlurDraweeView = this.mBlurDraweeView;
        return (dCBlurDraweeView == null || !dCBlurDraweeView.checkBlurEffect(this.mBlurEffect)) ? this.mTabHeightStr : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
    }

    public int getTabItemDisplayedSize() {
        int i = 0;
        for (int i2 = 0; i2 < this.mCommonList.size(); i2++) {
            com.alibaba.fastjson.JSONObject jSONObject = this.mCommonList.getJSONObject(i2);
            if (jSONObject != null && (!jSONObject.containsKey("visible") || jSONObject.getBoolean("visible").booleanValue())) {
                i++;
            }
        }
        return i;
    }

    public void hideTabBarRedDot(com.alibaba.fastjson.JSONObject jSONObject) {
        android.view.ViewGroup commonItemByIndex = getCommonItemByIndex(jSONObject.getInteger("index").intValue());
        if (commonItemByIndex != null) {
            ((android.widget.ImageView) commonItemByIndex.findViewById(io.dcloud.base.R.id.itemDot)).setVisibility(4);
        }
    }

    public void removeTabBarBadge(com.alibaba.fastjson.JSONObject jSONObject) {
        android.view.ViewGroup commonItemByIndex = getCommonItemByIndex(jSONObject.getInteger("index").intValue());
        if (commonItemByIndex != null) {
            ((android.widget.TextView) commonItemByIndex.findViewById(io.dcloud.base.R.id.itemBadge)).setVisibility(4);
        }
    }

    public void setDoubleCallbackListener(io.dcloud.common.DHInterface.ICallBack iCallBack) {
        this.mIDoubleCallback = iCallBack;
    }

    public void setIWebViewFocusable(boolean z) {
        io.dcloud.common.ui.blur.DCBlurDraweeView dCBlurDraweeView = this.mBlurDraweeView;
        if (dCBlurDraweeView == null || !dCBlurDraweeView.checkBlurEffect(this.mBlurEffect)) {
            return;
        }
        this.mBlurDraweeView.setContentFocusable(z);
    }

    public void setMask(com.alibaba.fastjson.JSONObject jSONObject) {
        java.lang.String string = (jSONObject == null || !jSONObject.containsKey("color")) ? null : jSONObject.getString("color");
        if ("none".equals(string)) {
            if (this.mMask != null) {
                ((android.widget.FrameLayout) getParent()).removeView(this.mMask);
                this.mMask = null;
                return;
            }
            return;
        }
        if (this.mMask == null) {
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(this.mContext);
            this.mMask = linearLayout;
            linearLayout.setOnClickListener(this.mOnMaskClickListener);
            this.mMask.setBackgroundColor(optColor(string, this.mDefaultMaskBackgroundColor));
            ((android.widget.FrameLayout) getParent()).addView(this.mMask, new android.view.ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setMaskCallbackListener(io.dcloud.common.DHInterface.ICallBack iCallBack) {
        this.mIMaskCallback = iCallBack;
    }

    public void setMidCallbackListener(io.dcloud.common.DHInterface.ICallBack iCallBack) {
        this.mIMidCallback = iCallBack;
    }

    public void setSingleCallbackListener(io.dcloud.common.DHInterface.ICallBack iCallBack) {
        this.mISingleCallback = iCallBack;
    }

    public void setTabBarBadge(com.alibaba.fastjson.JSONObject jSONObject) {
        int iIntValue = jSONObject.getInteger("index").intValue();
        java.lang.String string = jSONObject.getString("text");
        android.view.ViewGroup commonItemByIndex = getCommonItemByIndex(iIntValue);
        if (commonItemByIndex != null) {
            android.widget.ImageView imageView = (android.widget.ImageView) commonItemByIndex.findViewById(io.dcloud.base.R.id.itemDot);
            android.widget.TextView textView = (android.widget.TextView) commonItemByIndex.findViewById(io.dcloud.base.R.id.itemBadge);
            imageView.setVisibility(4);
            textView.setText(string);
            setDotBadgeMarginTop(commonItemByIndex, textView);
            textView.setVisibility(0);
        }
    }

    public void setTabBarItem(com.alibaba.fastjson.JSONObject jSONObject) {
        setCommonItemJson(jSONObject.getInteger("index").intValue(), jSONObject.getString("text"), jSONObject.getString("iconPath"), jSONObject.getString("selectedIconPath"), jSONObject.containsKey("iconfont") ? jSONObject.getJSONObject("iconfont") : null, jSONObject.containsKey("visible") ? jSONObject.getBooleanValue("visible") : true);
    }

    public void setTabBarStyle(com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject.containsKey("color")) {
            this.mTextColor = jSONObject.getString("color");
        }
        if (jSONObject.containsKey("selectedColor")) {
            this.mSelectedColor = jSONObject.getString("selectedColor");
        }
        if (jSONObject.containsKey("backgroundColor")) {
            this.mBackgroundColor = jSONObject.getString("backgroundColor");
        }
        if (jSONObject.containsKey(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE)) {
            this.mBackgroundImage = jSONObject.getString(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE);
        }
        if (jSONObject.containsKey(com.taobao.weex.common.Constants.Name.BORDER_STYLE)) {
            this.mBorderStyle = jSONObject.getString(com.taobao.weex.common.Constants.Name.BORDER_STYLE);
        }
        if (jSONObject.containsKey("height")) {
            java.lang.String string = jSONObject.getString("height");
            this.mTabHeightStr = string;
            this.mTabHeight = (int) io.dcloud.common.util.PdrUtil.parseFloat(string, 0.0f, 0.0f, this.mScale);
        }
        if (jSONObject.containsKey("midButton")) {
            this.mMidButton = jSONObject.getJSONObject("midButton");
        }
        if (jSONObject.containsKey(com.taobao.weex.common.Constants.Name.FONT_SIZE)) {
            this.mTextSize = jSONObject.getString(com.taobao.weex.common.Constants.Name.FONT_SIZE);
        }
        if (jSONObject.containsKey(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON_WIDTH)) {
            this.mImageSize = jSONObject.getString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON_WIDTH);
        }
        if (jSONObject.containsKey("backgroundRepeat")) {
            this.repeatType = jSONObject.getString("backgroundRepeat");
        }
        initTabStyle();
        setTabItemStyle();
        setSelectedStyle();
        if (jSONObject.containsKey("redDotColor")) {
            java.lang.String string2 = jSONObject.getString("redDotColor");
            if (io.dcloud.common.util.PdrUtil.isEmpty(string2)) {
                return;
            }
            if (this.redDotColor != io.dcloud.common.util.PdrUtil.stringToColor(string2)) {
                this.redDotColor = io.dcloud.common.util.PdrUtil.stringToColor(string2);
                for (int i = 0; i < this.mTabItemViews.size(); i++) {
                    android.widget.RelativeLayout relativeLayout = this.mTabItemViews.get(i);
                    if (relativeLayout != null) {
                        ((android.graphics.drawable.GradientDrawable) ((android.widget.ImageView) relativeLayout.findViewById(io.dcloud.base.R.id.itemDot)).getDrawable()).setColor(this.redDotColor);
                    }
                }
            }
        }
    }

    public void showTabBarRedDot(com.alibaba.fastjson.JSONObject jSONObject) {
        android.view.ViewGroup commonItemByIndex = getCommonItemByIndex(jSONObject.getInteger("index").intValue());
        if (commonItemByIndex != null) {
            android.widget.ImageView imageView = (android.widget.ImageView) commonItemByIndex.findViewById(io.dcloud.base.R.id.itemDot);
            ((android.widget.TextView) commonItemByIndex.findViewById(io.dcloud.base.R.id.itemBadge)).setVisibility(4);
            setDotBadgeMarginTop(commonItemByIndex, imageView);
            imageView.setVisibility(0);
        }
    }

    public void switchTab(int i) {
        this.mCommonSelectedIndex = java.lang.String.valueOf(i);
        setSelectedStyle();
        io.dcloud.common.ui.blur.DCBlurDraweeView dCBlurDraweeView = this.mBlurDraweeView;
        if (dCBlurDraweeView != null) {
            dCBlurDraweeView.postInvalidate(1000L);
        }
    }

    public void updateIconfont(android.widget.TextView textView, com.alibaba.fastjson.JSONObject jSONObject, float f, boolean z) {
        if (this.mWebApp == null || textView == null || jSONObject == null || android.text.TextUtils.isEmpty(this.mIconfontPath)) {
            return;
        }
        textView.setVisibility(0);
        byte bObtainRunningAppMode = this.mWebApp.obtainRunningAppMode();
        java.lang.String string = jSONObject.getString("text");
        if (jSONObject.containsKey(com.taobao.weex.common.Constants.Name.FONT_SIZE)) {
            textView.setTextSize(0, (int) io.dcloud.common.util.PdrUtil.parseFloat(jSONObject.getString(com.taobao.weex.common.Constants.Name.FONT_SIZE), 0.0f, 0.0f, this.mScale));
        }
        if (z && jSONObject.containsKey("selectedColor")) {
            textView.setTextColor(io.dcloud.common.util.PdrUtil.stringToColor(jSONObject.getString("selectedColor")));
        } else if (jSONObject.containsKey("color")) {
            textView.setTextColor(io.dcloud.common.util.PdrUtil.stringToColor(jSONObject.getString("color")));
        }
        if (this.mIconfontPath.startsWith("/storage") || bObtainRunningAppMode != 1) {
            java.io.File file = new java.io.File(this.mIconfontPath);
            if (file.exists()) {
                textView.setTypeface(android.graphics.Typeface.createFromFile(file));
            }
        } else {
            try {
                textView.setTypeface(android.graphics.Typeface.createFromAsset(getContext().getAssets(), this.mIconfontPath));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        android.view.ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        int i = (int) f;
        layoutParams.height = i;
        layoutParams.width = i;
        textView.setLayoutParams(layoutParams);
        textView.setText(string);
        textView.setVisibility(0);
    }

    public void updateMidButton(com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mMidButton = jSONObject;
        }
        updateMidItemStyle();
    }
}
