package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class BoxShadowUtil {
    private static final java.lang.String TAG = "BoxShadowUtil";
    private static boolean sBoxShadowEnabled = true;
    private static java.util.regex.Pattern sColorPattern;

    public static void setBoxShadowEnabled(boolean z) {
        sBoxShadowEnabled = z;
        com.taobao.weex.utils.WXLogUtils.w(TAG, "Switch box-shadow status: " + z);
    }

    public static boolean isBoxShadowEnabled() {
        return sBoxShadowEnabled;
    }

    public static void setBoxShadow(final android.view.View view, java.lang.String str, final float[] fArr, float f, final float f2) {
        if (!sBoxShadowEnabled) {
            com.taobao.weex.utils.WXLogUtils.w(TAG, "box-shadow was disabled by config");
            return;
        }
        if (view == null) {
            com.taobao.weex.utils.WXLogUtils.w(TAG, "Target view is null!");
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            view.getOverlay().clear();
            com.taobao.weex.utils.WXLogUtils.d(TAG, "Remove all box-shadow");
            return;
        }
        com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions[] boxShadows = parseBoxShadows(str, f);
        if (boxShadows == null || boxShadows.length == 0) {
            com.taobao.weex.utils.WXLogUtils.w(TAG, "Failed to parse box-shadow: " + str);
            return;
        }
        final java.util.ArrayList arrayList = new java.util.ArrayList();
        final java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions boxShadowOptions : boxShadows) {
            if (boxShadowOptions != null) {
                if (boxShadowOptions.isInset) {
                    arrayList2.add(0, boxShadowOptions);
                } else {
                    arrayList.add(0, boxShadowOptions);
                }
            }
        }
        if (fArr != null) {
            if (fArr.length != 8) {
                com.taobao.weex.utils.WXLogUtils.w(TAG, "Length of radii must be 8");
            } else {
                for (int i = 0; i < fArr.length; i++) {
                    fArr[i] = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(fArr[i], f);
                }
            }
        }
        view.post(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.utils.BoxShadowUtil.1
            @Override // java.lang.Runnable
            public void run() {
                view.getOverlay().clear();
                if (arrayList.size() > 0) {
                    com.taobao.weex.utils.BoxShadowUtil.setNormalBoxShadow(view, arrayList, f2, fArr);
                }
                if (arrayList2.size() > 0) {
                    com.taobao.weex.utils.BoxShadowUtil.setInsetBoxShadow(view, arrayList2, f2, fArr);
                }
            }
        }));
    }

    private static void drawShadow(android.graphics.Canvas canvas, com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions boxShadowOptions) {
        android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, boxShadowOptions.viewWidth + (boxShadowOptions.spread * 2.0f), boxShadowOptions.viewHeight + (boxShadowOptions.spread * 2.0f));
        if (boxShadowOptions.topLeft != null) {
            rectF.offset(boxShadowOptions.topLeft.x, boxShadowOptions.topLeft.y);
        }
        float f = boxShadowOptions.blur;
        float f2 = boxShadowOptions.blur;
        if (boxShadowOptions.hShadow > 0.0f) {
            f += boxShadowOptions.hShadow * 2.0f;
        }
        if (boxShadowOptions.vShadow > 0.0f) {
            f2 += boxShadowOptions.vShadow * 2.0f;
        }
        rectF.offset(f, f2);
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setAntiAlias(true);
        paint.setColor(boxShadowOptions.color);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        if (boxShadowOptions.blur > 0.0f) {
            paint.setMaskFilter(new android.graphics.BlurMaskFilter(boxShadowOptions.blur, android.graphics.BlurMaskFilter.Blur.NORMAL));
        }
        android.graphics.Path path = new android.graphics.Path();
        float[] fArr = new float[8];
        for (int i = 0; i < boxShadowOptions.radii.length; i++) {
            if (boxShadowOptions.radii[i] == 0.0f) {
                fArr[i] = 0.0f;
            } else {
                fArr[i] = boxShadowOptions.radii[i] + boxShadowOptions.spread;
            }
        }
        path.addRoundRect(rectF, fArr, android.graphics.Path.Direction.CCW);
        canvas.drawPath(path, paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setNormalBoxShadow(android.view.View view, java.util.List<com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions> list, float f, float[] fArr) {
        int height = view.getHeight();
        int width = view.getWidth();
        view.getLayoutParams();
        if (height == 0 || width == 0) {
            android.util.Log.w(TAG, "Target view is invisible, ignore set shadow.");
            return;
        }
        int iWidth = 0;
        int iHeight = 0;
        for (com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions boxShadowOptions : list) {
            boxShadowOptions.viewWidth = width;
            boxShadowOptions.viewHeight = height;
            boxShadowOptions.radii = fArr;
            android.graphics.Rect targetCanvasRect = boxShadowOptions.getTargetCanvasRect();
            if (iWidth < targetCanvasRect.width()) {
                iWidth = targetCanvasRect.width();
            }
            if (iHeight < targetCanvasRect.height()) {
                iHeight = targetCanvasRect.height();
            }
        }
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap((int) (iWidth * f), (int) (iHeight * f), android.graphics.Bitmap.Config.ARGB_4444);
        com.taobao.weex.utils.WXLogUtils.d(TAG, "Allocation memory for box-shadow: " + (bitmapCreateBitmap.getAllocationByteCount() / 1024) + " KB");
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        for (com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions boxShadowOptions2 : list) {
            android.graphics.Rect targetCanvasRect2 = boxShadowOptions2.getTargetCanvasRect();
            boxShadowOptions2.topLeft = new android.graphics.PointF((iWidth - targetCanvasRect2.width()) / 2.0f, (iHeight - targetCanvasRect2.height()) / 2.0f);
            drawShadow(canvas, boxShadowOptions2.scale(f));
        }
        com.taobao.weex.utils.BoxShadowUtil.OverflowBitmapDrawable overflowBitmapDrawable = new com.taobao.weex.utils.BoxShadowUtil.OverflowBitmapDrawable(view.getResources(), bitmapCreateBitmap, new android.graphics.Point((iWidth - width) / 2, (iHeight - height) / 2), new android.graphics.Rect(0, 0, width, height), fArr);
        view.getOverlay().add(overflowBitmapDrawable);
        android.view.ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestLayout();
            if (parent instanceof android.view.ViewGroup) {
                ((android.view.ViewGroup) parent).invalidate(overflowBitmapDrawable.getBounds());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setInsetBoxShadow(android.view.View view, java.util.List<com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions> list, float f, float[] fArr) {
        if (view == null || list == null) {
            com.taobao.weex.utils.WXLogUtils.w(TAG, "Illegal arguments");
            return;
        }
        if (view.getWidth() == 0 || view.getHeight() == 0) {
            com.taobao.weex.utils.WXLogUtils.w(TAG, "Target view is invisible, ignore set shadow.");
            return;
        }
        android.graphics.drawable.Drawable[] drawableArr = new android.graphics.drawable.Drawable[list.size()];
        for (int i = 0; i < list.size(); i++) {
            com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions boxShadowOptions = list.get(i);
            drawableArr[i] = new com.taobao.weex.utils.BoxShadowUtil.InsetShadowDrawable(view.getWidth(), view.getHeight(), boxShadowOptions.hShadow, boxShadowOptions.vShadow, boxShadowOptions.blur, boxShadowOptions.spread, boxShadowOptions.color, fArr);
        }
        view.getOverlay().add(new android.graphics.drawable.LayerDrawable(drawableArr));
        view.invalidate();
    }

    public static com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions[] parseBoxShadows(java.lang.String str, float f) {
        int i;
        if (sColorPattern == null) {
            sColorPattern = java.util.regex.Pattern.compile("([rR][gG][bB][aA]?)\\((\\d+\\s*),\\s*(\\d+\\s*),\\s*(\\d+\\s*)(?:,\\s*(\\d+(?:\\.\\d+)?))?\\)");
        }
        java.util.regex.Matcher matcher = sColorPattern.matcher(str);
        while (true) {
            if (!matcher.find()) {
                break;
            }
            java.lang.String strGroup = matcher.group();
            str = str.replace(strGroup, "#" + io.dcloud.common.util.StringUtil.format("%8s", java.lang.Integer.toHexString(com.taobao.weex.utils.WXResourceUtils.getColor(strGroup, -16777216))).replaceAll("\\s", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT));
        }
        java.lang.String[] strArrSplit = str.split(",");
        if (strArrSplit == null || strArrSplit.length <= 0) {
            return null;
        }
        com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions[] boxShadowOptionsArr = new com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions[strArrSplit.length];
        for (i = 0; i < strArrSplit.length; i++) {
            boxShadowOptionsArr[i] = parseBoxShadow(strArrSplit[i], f);
        }
        return boxShadowOptionsArr;
    }

    private static com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions parseBoxShadow(java.lang.String str, float f) {
        com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions boxShadowOptions = new com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions(f);
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.lang.String strReplaceAll = str.replaceAll("\\s*,\\s+", ",");
        if (strReplaceAll.contains("inset")) {
            boxShadowOptions.isInset = true;
            strReplaceAll = strReplaceAll.replace("inset", "");
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(strReplaceAll.trim().split("\\s+")));
        java.lang.String str2 = (java.lang.String) arrayList.get(arrayList.size() - 1);
        if (!android.text.TextUtils.isEmpty(str2) && (str2.startsWith("#") || str2.startsWith("rgb") || com.taobao.weex.utils.WXResourceUtils.isNamedColor(str2))) {
            boxShadowOptions.color = com.taobao.weex.utils.WXResourceUtils.getColor(str2, -16777216);
            arrayList.remove(arrayList.size() - 1);
        }
        try {
            if (arrayList.size() < 2) {
                return null;
            }
            if (!android.text.TextUtils.isEmpty((java.lang.CharSequence) arrayList.get(0))) {
                boxShadowOptions.hShadow = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(((java.lang.String) arrayList.get(0)).trim(), java.lang.Float.valueOf(0.0f)).floatValue(), f);
            }
            if (!android.text.TextUtils.isEmpty((java.lang.CharSequence) arrayList.get(1))) {
                boxShadowOptions.vShadow = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(((java.lang.String) arrayList.get(1)).trim(), java.lang.Float.valueOf(0.0f)).floatValue(), f);
            }
            for (int i = 2; i < arrayList.size(); i++) {
                ((com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions.IParser) boxShadowOptions.optionParamParsers.get(i - 2)).parse((java.lang.String) arrayList.get(i));
            }
            return boxShadowOptions;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return boxShadowOptions;
        }
    }

    private static class OverflowBitmapDrawable extends android.graphics.drawable.BitmapDrawable {
        private int paddingX;
        private int paddingY;
        private float[] radii;
        private android.graphics.Rect viewRect;

        private OverflowBitmapDrawable(android.content.res.Resources resources, android.graphics.Bitmap bitmap, android.graphics.Point point, android.graphics.Rect rect, float[] fArr) {
            super(resources, bitmap);
            this.paddingX = point.x;
            int i = point.y;
            this.paddingY = i;
            this.viewRect = rect;
            this.radii = fArr;
            setBounds(-this.paddingX, -i, rect.width() + this.paddingX, rect.height() + this.paddingY);
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(android.graphics.Canvas canvas) {
            android.graphics.Rect clipBounds = canvas.getClipBounds();
            android.graphics.Rect rect = new android.graphics.Rect(clipBounds);
            rect.inset((-this.paddingX) * 2, (-this.paddingY) * 2);
            try {
                if (com.taobao.weex.WXEnvironment.sApplication.getApplicationInfo().targetSdkVersion > 26) {
                    canvas.clipRect(rect);
                } else {
                    canvas.clipRect(rect, android.graphics.Region.Op.REPLACE);
                }
            } catch (java.lang.NullPointerException unused) {
                canvas.clipRect(rect);
            }
            android.graphics.Path path = new android.graphics.Path();
            path.addRoundRect(new android.graphics.RectF(clipBounds), this.radii, android.graphics.Path.Direction.CCW);
            canvas.clipPath(path, android.graphics.Region.Op.DIFFERENCE);
            canvas.translate(clipBounds.left, clipBounds.top);
            super.draw(canvas);
        }
    }

    private static class InsetShadowDrawable extends android.graphics.drawable.Drawable {
        private static final int BOTTOM_TO_TOP = 3;
        private static final int LEFT_TO_RIGHT = 0;
        private static final int RIGHT_TO_LEFT = 2;
        private static final int TOP_TO_BOTTOM = 1;
        private float blurRadius;
        private float height;
        private android.graphics.Paint paint;
        private android.graphics.Path[] paths;
        private float[] radii;
        private android.graphics.Shader[] shades;
        private int shadowColor;
        private float shadowXSize;
        private float shadowYSize;
        private float width;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        }

        private InsetShadowDrawable(int i, int i2, float f, float f2, float f3, float f4, int i3, float[] fArr) {
            this.shades = new android.graphics.Shader[4];
            this.paths = new android.graphics.Path[4];
            this.blurRadius = f3;
            this.shadowColor = i3;
            this.width = i + (f * 2.0f);
            this.height = i2 + (2.0f * f2);
            this.shadowXSize = f + f4;
            this.shadowYSize = f2 + f4;
            this.radii = fArr;
            setBounds(0, 0, i, i2);
            prepare();
        }

        private void prepare() {
            android.graphics.PointF pointF = new android.graphics.PointF(0.0f, 0.0f);
            android.graphics.PointF pointF2 = new android.graphics.PointF(this.width, 0.0f);
            android.graphics.PointF pointF3 = new android.graphics.PointF(pointF2.x, this.height);
            android.graphics.PointF pointF4 = new android.graphics.PointF(pointF.x, pointF3.y);
            android.graphics.PointF pointF5 = new android.graphics.PointF(this.shadowXSize, this.shadowYSize);
            android.graphics.PointF pointF6 = new android.graphics.PointF(pointF2.x - this.shadowXSize, pointF5.y);
            android.graphics.PointF pointF7 = new android.graphics.PointF(pointF6.x, pointF3.y - this.shadowYSize);
            android.graphics.PointF pointF8 = new android.graphics.PointF(pointF5.x, pointF7.y);
            android.graphics.LinearGradient linearGradient = new android.graphics.LinearGradient(pointF5.x - this.blurRadius, pointF5.y, pointF5.x, pointF5.y, this.shadowColor, 0, android.graphics.Shader.TileMode.CLAMP);
            android.graphics.LinearGradient linearGradient2 = new android.graphics.LinearGradient(pointF5.x, pointF5.y - this.blurRadius, pointF5.x, pointF5.y, this.shadowColor, 0, android.graphics.Shader.TileMode.CLAMP);
            android.graphics.LinearGradient linearGradient3 = new android.graphics.LinearGradient(pointF7.x + this.blurRadius, pointF7.y, pointF7.x, pointF7.y, this.shadowColor, 0, android.graphics.Shader.TileMode.CLAMP);
            android.graphics.LinearGradient linearGradient4 = new android.graphics.LinearGradient(pointF7.x, pointF7.y + this.blurRadius, pointF7.x, pointF7.y, this.shadowColor, 0, android.graphics.Shader.TileMode.CLAMP);
            android.graphics.Shader[] shaderArr = this.shades;
            shaderArr[0] = linearGradient;
            shaderArr[1] = linearGradient2;
            shaderArr[2] = linearGradient3;
            shaderArr[3] = linearGradient4;
            android.graphics.Path path = new android.graphics.Path();
            path.moveTo(pointF.x, pointF.y);
            path.lineTo(pointF5.x, pointF5.y);
            path.lineTo(pointF8.x, pointF8.y);
            path.lineTo(pointF4.x, pointF4.y);
            path.close();
            android.graphics.Path path2 = new android.graphics.Path();
            path2.moveTo(pointF.x, pointF.y);
            path2.lineTo(pointF2.x, pointF2.y);
            path2.lineTo(pointF6.x, pointF6.y);
            path2.lineTo(pointF5.x, pointF5.y);
            path2.close();
            android.graphics.Path path3 = new android.graphics.Path();
            path3.moveTo(pointF2.x, pointF2.y);
            path3.lineTo(pointF3.x, pointF3.y);
            path3.lineTo(pointF7.x, pointF7.y);
            path3.lineTo(pointF6.x, pointF6.y);
            path3.close();
            android.graphics.Path path4 = new android.graphics.Path();
            path4.moveTo(pointF4.x, pointF4.y);
            path4.lineTo(pointF3.x, pointF3.y);
            path4.lineTo(pointF7.x, pointF7.y);
            path4.lineTo(pointF8.x, pointF8.y);
            path4.close();
            android.graphics.Path[] pathArr = this.paths;
            pathArr[0] = path;
            pathArr[1] = path2;
            pathArr[2] = path3;
            pathArr[3] = path4;
            android.graphics.Paint paint = new android.graphics.Paint();
            this.paint = paint;
            paint.setAntiAlias(true);
            this.paint.setStyle(android.graphics.Paint.Style.FILL);
            this.paint.setColor(this.shadowColor);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(android.graphics.Canvas canvas) {
            android.graphics.Rect clipBounds = canvas.getClipBounds();
            android.graphics.Path path = new android.graphics.Path();
            path.addRoundRect(new android.graphics.RectF(clipBounds), this.radii, android.graphics.Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.translate(clipBounds.left, clipBounds.top);
            for (int i = 0; i < 4; i++) {
                android.graphics.Shader shader = this.shades[i];
                android.graphics.Path path2 = this.paths[i];
                this.paint.setShader(shader);
                canvas.drawPath(path2, this.paint);
            }
        }
    }

    public static class BoxShadowOptions {
        public float blur;
        public int color;
        public float hShadow;
        public boolean isInset;
        private java.util.List<com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions.IParser> optionParamParsers;
        public float[] radii;
        public float spread;
        public android.graphics.PointF topLeft;
        public float vShadow;
        public int viewHeight;
        public int viewWidth;
        private float viewport;

        private interface IParser {
            void parse(java.lang.String str);
        }

        private BoxShadowOptions(float f) {
            this.viewport = 750.0f;
            this.blur = 0.0f;
            this.spread = 0.0f;
            this.radii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            this.color = -16777216;
            this.isInset = false;
            this.viewWidth = 0;
            this.viewHeight = 0;
            this.topLeft = null;
            if (750.0f != 0.0f) {
                this.viewport = f;
            }
            this.optionParamParsers = new java.util.ArrayList();
            com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions.IParser iParser = new com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions.IParser() { // from class: com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions.1
                @Override // com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions.IParser
                public void parse(java.lang.String str) {
                    if (android.text.TextUtils.isEmpty(str)) {
                        return;
                    }
                    float fFloatValue = com.taobao.weex.utils.WXUtils.getFloat(str, java.lang.Float.valueOf(0.0f)).floatValue();
                    com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions boxShadowOptions = com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions.this;
                    boxShadowOptions.spread = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(fFloatValue, boxShadowOptions.viewport);
                    com.taobao.weex.utils.WXLogUtils.w(com.taobao.weex.utils.BoxShadowUtil.TAG, "Experimental box-shadow attribute: spread");
                }
            };
            this.optionParamParsers.add(new com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions.IParser() { // from class: com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions.2
                @Override // com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions.IParser
                public void parse(java.lang.String str) {
                    if (android.text.TextUtils.isEmpty(str)) {
                        return;
                    }
                    float fFloatValue = com.taobao.weex.utils.WXUtils.getFloat(str, java.lang.Float.valueOf(0.0f)).floatValue();
                    com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions boxShadowOptions = com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions.this;
                    boxShadowOptions.blur = com.taobao.weex.utils.WXViewUtils.getRealSubPxByWidth(fFloatValue, boxShadowOptions.viewport);
                }
            });
            this.optionParamParsers.add(iParser);
        }

        public com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions scale(float f) {
            if (f <= 0.0f || f > 1.0f) {
                return null;
            }
            com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions boxShadowOptions = new com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions(this.viewport);
            boxShadowOptions.hShadow = this.hShadow * f;
            boxShadowOptions.vShadow = this.vShadow * f;
            boxShadowOptions.blur = this.blur * f;
            boxShadowOptions.spread = this.spread * f;
            int i = 0;
            while (true) {
                float[] fArr = this.radii;
                if (i >= fArr.length) {
                    break;
                }
                boxShadowOptions.radii[i] = fArr[i] * f;
                i++;
            }
            boxShadowOptions.viewHeight = (int) (this.viewHeight * f);
            boxShadowOptions.viewWidth = (int) (this.viewWidth * f);
            if (this.topLeft != null) {
                android.graphics.PointF pointF = new android.graphics.PointF();
                boxShadowOptions.topLeft = pointF;
                pointF.x = this.topLeft.x * f;
                boxShadowOptions.topLeft.y = this.topLeft.y * f;
            }
            boxShadowOptions.color = this.color;
            boxShadowOptions.isInset = this.isInset;
            com.taobao.weex.utils.WXLogUtils.d(com.taobao.weex.utils.BoxShadowUtil.TAG, "Scaled BoxShadowOptions: [" + f + "] " + boxShadowOptions);
            return boxShadowOptions;
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
}
