package io.dcloud.feature.nativeObj.richtext;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class RichTextLayout {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class DefaultAssets implements io.dcloud.feature.nativeObj.richtext.IAssets {
        boolean isClick;
        java.lang.String mCallBackId;
        io.dcloud.feature.nativeObj.NativeView mNativeView;
        io.dcloud.common.DHInterface.IWebview mWebview;

        DefaultAssets(io.dcloud.common.DHInterface.IWebview iWebview) {
            this(iWebview, null);
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public java.io.InputStream convert2InputStream(java.lang.String str) {
            return this.mWebview.obtainApp().obtainResInStream(this.mWebview.obtainFullUrl(), str);
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public float convertHeight(java.lang.String str, float f) {
            io.dcloud.feature.nativeObj.NativeView nativeView = this.mNativeView;
            return nativeView != null ? io.dcloud.common.util.PdrUtil.parseFloat(str, nativeView.mInnerHeight, f, getScale()) : io.dcloud.common.util.PdrUtil.parseFloat(str, this.mWebview.obtainApp().getInt(1), f, getScale());
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public float convertWidth(java.lang.String str, float f) {
            io.dcloud.feature.nativeObj.NativeView nativeView = this.mNativeView;
            return nativeView != null ? io.dcloud.common.util.PdrUtil.parseFloat(str, nativeView.mInnerWidth, f, getScale()) : io.dcloud.common.util.PdrUtil.parseFloat(str, this.mWebview.obtainApp().getInt(0), f, getScale());
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public int getDefaultColor(boolean z) {
            return z ? -16776961 : -16777216;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public java.lang.String getOnClickCallBackId() {
            return this.mCallBackId;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public float getScale() {
            io.dcloud.feature.nativeObj.NativeView nativeView = this.mNativeView;
            return nativeView != null ? nativeView.mCreateScale : this.mWebview.getScale();
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public boolean isClick() {
            return this.isClick;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public void loadResource(final io.dcloud.feature.nativeObj.richtext.dom.ImgDomElement.AsycLoader asycLoader) {
            com.nostra13.dcloudimageloader.core.ImageLoaderL.getInstance().loadImage(asycLoader.url, new com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener() { // from class: io.dcloud.feature.nativeObj.richtext.RichTextLayout.DefaultAssets.1
                @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                public void onLoadingCancelled(java.lang.String str, android.view.View view) {
                }

                @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                public void onLoadingComplete(java.lang.String str, android.view.View view, android.graphics.Bitmap bitmap) {
                    asycLoader.onComplete(bitmap);
                }

                @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                public void onLoadingFailed(java.lang.String str, android.view.View view, com.nostra13.dcloudimageloader.core.assist.FailReason failReason) {
                }

                @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                public void onLoadingStarted(java.lang.String str, android.view.View view) {
                }
            });
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public void setClick(boolean z) {
            this.isClick = z;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public void setOnClickCallBackId(java.lang.String str) {
            this.mCallBackId = str;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public int stringToColor(java.lang.String str) {
            return io.dcloud.common.util.PdrUtil.stringToColor(str);
        }

        DefaultAssets(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.feature.nativeObj.NativeView nativeView) {
            this.isClick = false;
            this.mCallBackId = null;
            this.mWebview = iWebview;
            this.mNativeView = nativeView;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class RichTextLayoutHolder extends android.widget.LinearLayout implements io.dcloud.feature.nativeObj.richtext.IAssets, io.dcloud.feature.nativeObj.INativeViewChildView {
        public boolean isClick;
        java.lang.String mCallBackId;
        io.dcloud.feature.nativeObj.richtext.RichTextLayout.DefaultAssets mDefaultAssets;
        java.lang.String mItemId;
        public android.widget.TextView mMainView;
        io.dcloud.feature.nativeObj.NativeView mNativeView;
        int mNativeViewHeight;
        io.dcloud.common.DHInterface.IWebview mWebView;

        public RichTextLayoutHolder(android.content.Context context, io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.feature.nativeObj.NativeView nativeView, java.lang.String str) {
            super(context);
            this.mMainView = null;
            this.mNativeViewHeight = -2;
            this.mDefaultAssets = null;
            this.isClick = false;
            this.mCallBackId = null;
            this.mWebView = iWebview;
            this.mNativeView = nativeView;
            this.mItemId = str;
            android.widget.TextView textView = new android.widget.TextView(context) { // from class: io.dcloud.feature.nativeObj.richtext.RichTextLayout.RichTextLayoutHolder.1
                @Override // android.widget.TextView, android.view.View
                public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
                    boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
                    java.lang.Object tag = getTag();
                    if ((tag instanceof java.lang.String) && java.lang.Boolean.parseBoolean((java.lang.String) tag)) {
                        return zOnTouchEvent;
                    }
                    return false;
                }
            };
            this.mMainView = textView;
            addView(textView);
            this.mDefaultAssets = new io.dcloud.feature.nativeObj.richtext.RichTextLayout.DefaultAssets(iWebview, nativeView);
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public java.io.InputStream convert2InputStream(java.lang.String str) {
            return this.mDefaultAssets.convert2InputStream(str);
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public float convertHeight(java.lang.String str, float f) {
            return this.mDefaultAssets.convertHeight(str, f);
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public float convertWidth(java.lang.String str, float f) {
            return this.mDefaultAssets.convertWidth(str, f);
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public int getDefaultColor(boolean z) {
            return this.mDefaultAssets.getDefaultColor(z);
        }

        io.dcloud.common.DHInterface.IWebview getIWebview() {
            return this.mWebView;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public java.lang.String getOnClickCallBackId() {
            return this.mCallBackId;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public float getScale() {
            return this.mNativeView.mCreateScale;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public boolean isClick() {
            return this.isClick;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public void loadResource(io.dcloud.feature.nativeObj.richtext.dom.ImgDomElement.AsycLoader asycLoader) {
            this.mDefaultAssets.loadResource(asycLoader);
        }

        @Override // io.dcloud.feature.nativeObj.INativeViewChildView
        public android.view.View obtainMainView() {
            return this.mMainView;
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) getLayoutParams();
            int i3 = layoutParams.width;
            if (i3 != -2 && i3 != -1) {
                i = android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.min(this.mNativeView.mInnerWidth, i3), android.view.View.MeasureSpec.getMode(i));
            }
            int i4 = layoutParams.height;
            if (i4 != -2 && i4 != -1) {
                i2 = android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.min(this.mNativeViewHeight, i4), android.view.View.MeasureSpec.getMode(i2));
            }
            super.onMeasure(i, i2);
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public void setClick(boolean z) {
            this.isClick = z;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public void setOnClickCallBackId(java.lang.String str) {
            this.mCallBackId = str;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public int stringToColor(java.lang.String str) {
            return this.mDefaultAssets.stringToColor(str);
        }

        @Override // io.dcloud.feature.nativeObj.INativeViewChildView
        public void updateLayout() {
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new android.widget.FrameLayout.LayoutParams(this.mNativeView.mInnerWidth, this.mNativeViewHeight);
            }
            io.dcloud.feature.nativeObj.NativeView nativeView = this.mNativeView;
            layoutParams.topMargin = nativeView.mInnerTop + (nativeView.isStatusBar() ? io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight : 0);
            io.dcloud.feature.nativeObj.NativeView nativeView2 = this.mNativeView;
            layoutParams.leftMargin = nativeView2.mInnerLeft;
            layoutParams.width = nativeView2.mInnerWidth;
            int i = nativeView2.mInnerHeight;
            this.mNativeViewHeight = i;
            if (i == 0 && android.text.TextUtils.equals("wrap_content", nativeView2.mStyle.optString("height"))) {
                this.mNativeViewHeight = -2;
            }
            layoutParams.height = this.mNativeViewHeight;
            setLayoutParams(layoutParams);
        }
    }

    public static io.dcloud.feature.nativeObj.richtext.RichTextLayout.RichTextLayoutHolder makeRichText(android.content.Context context, io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.feature.nativeObj.NativeView nativeView, java.lang.String str, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, java.lang.String str2) {
        return makeRichText(new io.dcloud.feature.nativeObj.richtext.RichTextLayout.RichTextLayoutHolder(context, iWebview, nativeView, str2), str, jSONObject, jSONObject2);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0086  */
    /* JADX WARN: Code duplicated, block: B:29:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ff A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x0101 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:56:0x0107 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x0109 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:59:0x010f  */
    public static io.dcloud.feature.nativeObj.richtext.RichTextLayout.RichTextLayoutHolder makeRichText(io.dcloud.feature.nativeObj.richtext.RichTextLayout.RichTextLayoutHolder richTextLayoutHolder, java.lang.String str, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        int iMin;
        int iConvertWidth;
        int iConvertWidth2;
        int iConvertHeight;
        int i;
        io.dcloud.feature.nativeObj.richtext.RichTextParser.updateFromHTML(richTextLayoutHolder, richTextLayoutHolder.mWebView, richTextLayoutHolder.mMainView, str, jSONObject2);
        richTextLayoutHolder.updateLayout();
        io.dcloud.feature.nativeObj.NativeView nativeView = richTextLayoutHolder.mNativeView;
        int i2 = nativeView.mInnerWidth;
        int i3 = nativeView.mInnerHeight;
        boolean zIsNull = jSONObject.isNull("left");
        boolean zIsNull2 = jSONObject.isNull("right");
        boolean zIsNull3 = jSONObject.isNull("top");
        boolean zIsNull4 = jSONObject.isNull("width");
        boolean zIsNull5 = jSONObject.isNull("height");
        boolean z = !zIsNull5;
        boolean zIsNull6 = jSONObject.isNull("bottom");
        int iConvertWidth3 = nativeView.mInnerLeft;
        int iConvertHeight2 = nativeView.mInnerTop;
        if (zIsNull5) {
            iMin = i3;
        } else {
            java.lang.String strOptString = jSONObject.optString("height");
            if (!android.text.TextUtils.isEmpty(strOptString)) {
                if ("wrap_content".equals(strOptString)) {
                    iMin = -2;
                    z = false;
                } else {
                    iMin = (int) java.lang.Math.min(richTextLayoutHolder.mNativeViewHeight, richTextLayoutHolder.convertHeight(strOptString, i3));
                }
            } else {
                iMin = nativeView.mInnerHeight;
            }
        }
        if (zIsNull4) {
            iConvertWidth = i2;
        } else {
            java.lang.String strOptString2 = jSONObject.optString("width");
            if (android.text.TextUtils.isEmpty(strOptString2)) {
                iConvertWidth = i2;
            } else {
                iConvertWidth = (int) richTextLayoutHolder.convertWidth(strOptString2, i2);
            }
        }
        if (!zIsNull3) {
            java.lang.String strOptString3 = jSONObject.optString("top");
            if (!android.text.TextUtils.isEmpty(strOptString3)) {
                iConvertHeight2 = (int) richTextLayoutHolder.convertHeight(strOptString3, i3);
            }
        }
        if (!zIsNull) {
            java.lang.String strOptString4 = jSONObject.optString("left");
            if (!android.text.TextUtils.isEmpty(strOptString4)) {
                iConvertWidth3 = (int) richTextLayoutHolder.convertWidth(strOptString4, i2);
            }
        }
        if (zIsNull2) {
            iConvertWidth2 = 0;
        } else {
            java.lang.String strOptString5 = jSONObject.optString("right");
            if (android.text.TextUtils.isEmpty(strOptString5)) {
                iConvertWidth2 = 0;
            } else {
                iConvertWidth2 = (int) richTextLayoutHolder.convertWidth(strOptString5, i2);
            }
        }
        if (zIsNull6) {
            iConvertHeight = 0;
        } else {
            java.lang.String strOptString6 = jSONObject.optString("bottom");
            if (android.text.TextUtils.isEmpty(strOptString6)) {
                iConvertHeight = 0;
            } else {
                iConvertHeight = (int) richTextLayoutHolder.convertHeight(strOptString6, i3);
            }
        }
        if (zIsNull) {
            if (zIsNull4 && !zIsNull2) {
                i = -iConvertWidth2;
            } else if (!zIsNull4 && zIsNull2) {
                iConvertWidth3 = (i2 - iConvertWidth) / 2;
            } else if (!zIsNull4 && !zIsNull2) {
                iConvertWidth3 = (i2 - iConvertWidth) - iConvertWidth2;
            }
            if (zIsNull3) {
                if (z && !zIsNull6) {
                    iConvertHeight2 = -iConvertHeight;
                } else if (!z && zIsNull6) {
                    iConvertHeight2 = (i3 - iMin) / 2;
                } else if (z && !zIsNull6) {
                    iConvertHeight2 = (i3 - iMin) - iConvertHeight;
                }
            } else if (!z && !zIsNull6) {
                iMin = (i3 - iConvertHeight2) - iConvertHeight;
            }
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(iConvertWidth, iMin);
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = iConvertWidth2;
            layoutParams.bottomMargin = iConvertHeight;
            layoutParams.topMargin = iConvertHeight2;
            richTextLayoutHolder.mMainView.setLayoutParams(layoutParams);
            return richTextLayoutHolder;
        }
        if (zIsNull4 && !zIsNull2) {
            iConvertWidth = (i2 - iConvertWidth3) - iConvertWidth2;
        }
        i = iConvertWidth3;
        if (zIsNull3) {
            if (z) {
                if (!z) {
                    if (z) {
                        iConvertHeight2 = (i3 - iMin) - iConvertHeight;
                    }
                } else if (z) {
                    iConvertHeight2 = (i3 - iMin) - iConvertHeight;
                }
            } else if (!z) {
                if (z) {
                    iConvertHeight2 = (i3 - iMin) - iConvertHeight;
                }
            } else if (z) {
                iConvertHeight2 = (i3 - iMin) - iConvertHeight;
            }
        } else if (!z) {
            iMin = (i3 - iConvertHeight2) - iConvertHeight;
        }
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(iConvertWidth, iMin);
        layoutParams2.leftMargin = i;
        layoutParams2.rightMargin = iConvertWidth2;
        layoutParams2.bottomMargin = iConvertHeight;
        layoutParams2.topMargin = iConvertHeight2;
        richTextLayoutHolder.mMainView.setLayoutParams(layoutParams2);
        return richTextLayoutHolder;
    }

    public static android.widget.TextView makeRichText(java.lang.Object[] objArr) {
        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = ((io.dcloud.common.DHInterface.IFrameView) objArr[0]).obtainWebView();
        java.lang.String str = (java.lang.String) objArr[1];
        org.json.JSONObject jSONObject = (org.json.JSONObject) objArr[2];
        android.widget.TextView textView = new android.widget.TextView(iWebviewObtainWebView.getContext());
        io.dcloud.feature.nativeObj.richtext.RichTextParser.updateFromHTML(new io.dcloud.feature.nativeObj.richtext.RichTextLayout.DefaultAssets(iWebviewObtainWebView) { // from class: io.dcloud.feature.nativeObj.richtext.RichTextLayout.1
            @Override // io.dcloud.feature.nativeObj.richtext.RichTextLayout.DefaultAssets, io.dcloud.feature.nativeObj.richtext.IAssets
            public int getDefaultColor(boolean z) {
                return z ? -16776961 : -1;
            }
        }, iWebviewObtainWebView, textView, str, jSONObject, (io.dcloud.common.DHInterface.ICallBack) objArr[3]);
        return textView;
    }
}
