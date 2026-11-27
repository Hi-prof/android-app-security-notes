package io.dcloud.feature.nativeObj.richtext;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class RichTextParser {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class LinkMovementMethodExt extends android.text.method.LinkMovementMethod {
        io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble[] downLinks = null;
        long downTime = 0;
        float downX;
        float downY;
        io.dcloud.feature.nativeObj.richtext.IAssets mAssets;
        io.dcloud.common.DHInterface.ICallBack mObserver;
        io.dcloud.common.DHInterface.IWebview mWebview;

        LinkMovementMethodExt(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.common.DHInterface.ICallBack iCallBack, io.dcloud.feature.nativeObj.richtext.IAssets iAssets) {
            this.mWebview = iWebview;
            this.mObserver = iCallBack;
            this.mAssets = iAssets;
        }

        /* JADX WARN: Code duplicated, block: B:68:0x0130  */
        /* JADX WARN: Code duplicated, block: B:70:0x0135  */
        /* JADX WARN: Code duplicated, block: B:78:0x014d  */
        /* JADX WARN: Code duplicated, block: B:90:0x0173  */
        /* JADX WARN: Code duplicated, block: B:93:0x01af  */
        /* JADX WARN: Code duplicated, block: B:94:0x01c3  */
        /* JADX WARN: Code duplicated, block: B:95:0x01ca  */
        /* JADX WARN: Code duplicated, block: B:97:0x01cd A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:98:0x01ce  */
        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(android.widget.TextView textView, android.text.Spannable spannable, android.view.MotionEvent motionEvent) {
            io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble[] clickSpanAbleArr;
            boolean z;
            java.lang.String str;
            java.lang.String href;
            java.lang.String str2;
            io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble clickSpanAble;
            java.lang.String str3;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int totalPaddingLeft = x - textView.getTotalPaddingLeft();
            int totalPaddingTop = y - textView.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            int scrollY = totalPaddingTop + textView.getScrollY();
            android.text.Layout layout = textView.getLayout();
            int lineForVertical = layout.getLineForVertical(scrollY);
            int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, scrollX);
            android.graphics.Rect rect = new android.graphics.Rect((int) layout.getLineLeft(lineForVertical), layout.getLineTop(lineForVertical), (int) layout.getLineRight(lineForVertical), layout.getLineBottom(lineForVertical));
            textView.setTag(io.dcloud.common.constant.AbsoluteConst.FALSE);
            boolean z2 = true;
            if (rect.contains(scrollX, scrollY)) {
                io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble[] clickSpanAbleArr2 = (io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble.class);
                if (clickSpanAbleArr2 != null && clickSpanAbleArr2.length != 0) {
                    if (action == 1) {
                        io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble[] clickSpanAbleArr3 = this.downLinks;
                        if (clickSpanAbleArr3 != null && clickSpanAbleArr3.length >= clickSpanAbleArr2.length && !this.mAssets.isClick()) {
                            int i = 0;
                            while (true) {
                                if (i < clickSpanAbleArr2.length) {
                                    io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble clickSpanAble2 = clickSpanAbleArr2[i];
                                    if (clickSpanAble2 == this.downLinks[i]) {
                                        int spanFlags = spannable.getSpanFlags(clickSpanAble2);
                                        int spanStart = spannable.getSpanStart(clickSpanAble2);
                                        int spanEnd = spannable.getSpanEnd(clickSpanAble2);
                                        if (spanStart == 0 || spanEnd == spannable.length() || clickSpanAbleArr2.length == 1) {
                                            spanFlags = 18;
                                        }
                                        if ((spanFlags == 17 && offsetForHorizontal >= spanStart && offsetForHorizontal < spanEnd) || ((spanFlags == 18 && offsetForHorizontal >= spanStart && offsetForHorizontal <= spanEnd) || ((spanFlags == 33 && offsetForHorizontal > spanStart && offsetForHorizontal < spanEnd) || (spanFlags == 34 && offsetForHorizontal > spanStart && offsetForHorizontal <= spanEnd)))) {
                                            clickSpanAble2.onClick(textView, this.mWebview);
                                            io.dcloud.common.DHInterface.ICallBack iCallBack = this.mObserver;
                                            if (iCallBack != null) {
                                                iCallBack.onCallBack(0, clickSpanAble2);
                                            }
                                        }
                                    }
                                    i++;
                                }
                            }
                        }
                        this.downLinks = null;
                    } else if (action == 0) {
                        this.downLinks = clickSpanAbleArr2;
                        this.downX = motionEvent.getX();
                        this.downY = motionEvent.getY();
                    } else if (action == 2 && (java.lang.Math.abs(motionEvent.getX() - this.downX) > 20.0f || java.lang.Math.abs(motionEvent.getY() - this.downY) > 20.0f)) {
                        this.downLinks = null;
                    }
                    int i2 = 0;
                    while (true) {
                        if (i2 < clickSpanAbleArr2.length) {
                            if (clickSpanAbleArr2[i2].hasClickEvent()) {
                                textView.setTag(io.dcloud.common.constant.AbsoluteConst.TRUE);
                                clickSpanAbleArr = clickSpanAbleArr2;
                                z = true;
                            } else {
                                i2++;
                            }
                        }
                        if (this.mAssets.isClick()) {
                            textView.setTag(io.dcloud.common.constant.AbsoluteConst.TRUE);
                            if (action != 0) {
                                this.downTime = java.lang.System.currentTimeMillis();
                            } else if ((action != 1 || action == 3) && java.lang.System.currentTimeMillis() - this.downTime < 800) {
                                java.lang.String src = "";
                                if (clickSpanAbleArr != null || clickSpanAbleArr.length <= 0 || (clickSpanAble = clickSpanAbleArr[0]) == null) {
                                    str = "";
                                    href = str;
                                } else {
                                    href = clickSpanAble.getHref();
                                    if (clickSpanAble instanceof io.dcloud.feature.nativeObj.richtext.span.ImgSpan) {
                                        src = ((io.dcloud.feature.nativeObj.richtext.span.ImgSpan) clickSpanAble).getSrc();
                                        str3 = com.taobao.weex.ui.component.WXBasicComponentType.IMG;
                                    } else if (clickSpanAble instanceof io.dcloud.feature.nativeObj.richtext.span.AHrefSpan) {
                                        str3 = "a";
                                    } else {
                                        str = "";
                                    }
                                    java.lang.String str4 = str3;
                                    str = src;
                                    src = str4;
                                }
                                str2 = "{\"tagName\":\"" + src + "\",\"href\":\"" + href + "\",\"src\":\"" + str + "\"}";
                                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.mWebview, this.mAssets.getOnClickCallBackId(), str2, io.dcloud.common.util.JSUtil.OK, true, true);
                                if (this.mWebview.getOpener() != null) {
                                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.mWebview.getOpener(), this.mAssets.getOnClickCallBackId(), str2, io.dcloud.common.util.JSUtil.OK, true, true);
                                }
                            }
                        } else {
                            z2 = z;
                        }
                        if (z2) {
                            return z2;
                        }
                        return super.onTouchEvent(textView, spannable, motionEvent);
                    }
                }
                clickSpanAbleArr = clickSpanAbleArr2;
            } else {
                clickSpanAbleArr = null;
            }
            z = false;
            if (this.mAssets.isClick()) {
                textView.setTag(io.dcloud.common.constant.AbsoluteConst.TRUE);
                if (action != 0) {
                    this.downTime = java.lang.System.currentTimeMillis();
                } else if (action != 1) {
                    java.lang.String src2 = "";
                    if (clickSpanAbleArr != null) {
                        str = "";
                        href = str;
                    } else {
                        str = "";
                        href = str;
                    }
                    str2 = "{\"tagName\":\"" + src2 + "\",\"href\":\"" + href + "\",\"src\":\"" + str + "\"}";
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.mWebview, this.mAssets.getOnClickCallBackId(), str2, io.dcloud.common.util.JSUtil.OK, true, true);
                    if (this.mWebview.getOpener() != null) {
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.mWebview.getOpener(), this.mAssets.getOnClickCallBackId(), str2, io.dcloud.common.util.JSUtil.OK, true, true);
                    }
                } else {
                    java.lang.String src3 = "";
                    if (clickSpanAbleArr != null) {
                        str = "";
                        href = str;
                    } else {
                        str = "";
                        href = str;
                    }
                    str2 = "{\"tagName\":\"" + src3 + "\",\"href\":\"" + href + "\",\"src\":\"" + str + "\"}";
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.mWebview, this.mAssets.getOnClickCallBackId(), str2, io.dcloud.common.util.JSUtil.OK, true, true);
                    if (this.mWebview.getOpener() != null) {
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.mWebview.getOpener(), this.mAssets.getOnClickCallBackId(), str2, io.dcloud.common.util.JSUtil.OK, true, true);
                    }
                }
            } else {
                z2 = z;
            }
            if (z2) {
                return z2;
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    private static void handleEndTag(io.dcloud.feature.nativeObj.richtext.IAssets iAssets, android.widget.TextView textView, android.text.SpannableStringBuilder spannableStringBuilder, io.dcloud.feature.nativeObj.richtext.dom.DomElement domElement) {
        domElement.makeSpan(iAssets, textView, spannableStringBuilder);
    }

    private static io.dcloud.feature.nativeObj.richtext.dom.DomElement handleStartTag(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        io.dcloud.feature.nativeObj.richtext.dom.DomElement textDomElement;
        java.lang.String name = xmlPullParser.getName();
        if (name.equalsIgnoreCase("script") || name.equalsIgnoreCase(io.dcloud.feature.uniapp.adapter.AbsURIAdapter.LINK) || name.equalsIgnoreCase("iframe") || name.equalsIgnoreCase("style") || name.equalsIgnoreCase("meta")) {
            return null;
        }
        if (com.taobao.weex.ui.component.WXBasicComponentType.IMG.equalsIgnoreCase(name)) {
            textDomElement = new io.dcloud.feature.nativeObj.richtext.dom.ImgDomElement();
        } else if ("hr".equalsIgnoreCase(name)) {
            textDomElement = new io.dcloud.feature.nativeObj.richtext.dom.HrDomElement();
        } else if ("br".equalsIgnoreCase(name)) {
            textDomElement = new io.dcloud.feature.nativeObj.richtext.dom.DomElement();
        } else {
            textDomElement = ("a".equalsIgnoreCase(name) || io.dcloud.feature.uniapp.adapter.AbsURIAdapter.FONT.equalsIgnoreCase(name) || com.facebook.common.callercontext.ContextChain.TAG_PRODUCT.equalsIgnoreCase(name)) ? new io.dcloud.feature.nativeObj.richtext.dom.TextDomElement() : new io.dcloud.feature.nativeObj.richtext.dom.TextDomElement();
        }
        textDomElement.parseDomElement(xmlPullParser);
        return textDomElement;
    }

    static android.text.SpannableStringBuilder makeSpannableStringBuilder(io.dcloud.feature.nativeObj.richtext.IAssets iAssets, android.widget.TextView textView, java.lang.String str) {
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        try {
            org.xmlpull.v1.XmlPullParserFactory xmlPullParserFactoryNewInstance = org.xmlpull.v1.XmlPullParserFactory.newInstance();
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
            org.xmlpull.v1.XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
            xmlPullParserNewPullParser.setInput(new java.io.StringReader(str));
            int eventType = xmlPullParserNewPullParser.getEventType();
            io.dcloud.feature.nativeObj.richtext.dom.DomElement domElementHandleStartTag = null;
            io.dcloud.feature.nativeObj.richtext.dom.DomElement domElement = null;
            while (eventType != 1) {
                if (eventType == 0) {
                    try {
                        java.lang.System.out.print("Start document");
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    } catch (org.xmlpull.v1.XmlPullParserException e2) {
                        e2.printStackTrace();
                    }
                } else if (eventType == 2) {
                    java.lang.System.out.println("start-tag=<" + xmlPullParserNewPullParser.getName() + com.taobao.weex.el.parse.Operators.G);
                    domElementHandleStartTag = handleStartTag(xmlPullParserNewPullParser);
                    if (domElementHandleStartTag != null) {
                        domElementHandleStartTag.parentDomElement = domElement;
                        domElement = domElementHandleStartTag;
                    }
                } else if (eventType == 3) {
                    java.lang.System.out.println("end-tag=</" + xmlPullParserNewPullParser.getName() + com.taobao.weex.el.parse.Operators.G);
                    if (domElementHandleStartTag != null) {
                        if (!(domElementHandleStartTag instanceof io.dcloud.feature.nativeObj.richtext.dom.TextDomElement) || ((domElementHandleStartTag instanceof io.dcloud.feature.nativeObj.richtext.dom.TextDomElement) && android.text.TextUtils.isEmpty(((io.dcloud.feature.nativeObj.richtext.dom.TextDomElement) domElementHandleStartTag).text))) {
                            handleEndTag(iAssets, textView, spannableStringBuilder, domElementHandleStartTag);
                        }
                        domElementHandleStartTag = domElementHandleStartTag.parentDomElement;
                        domElement = domElementHandleStartTag;
                    }
                } else if (eventType == 4) {
                    java.lang.System.out.println("[Text:" + xmlPullParserNewPullParser.getText() + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
                    if (domElementHandleStartTag != null && (domElementHandleStartTag instanceof io.dcloud.feature.nativeObj.richtext.dom.TextDomElement)) {
                        ((io.dcloud.feature.nativeObj.richtext.dom.TextDomElement) domElementHandleStartTag).text = xmlPullParserNewPullParser.getText();
                        if (!android.text.TextUtils.isEmpty(((io.dcloud.feature.nativeObj.richtext.dom.TextDomElement) domElementHandleStartTag).text)) {
                            handleEndTag(iAssets, textView, spannableStringBuilder, domElementHandleStartTag);
                        }
                    }
                }
                eventType = xmlPullParserNewPullParser.next();
            }
        } catch (org.xmlpull.v1.XmlPullParserException e3) {
            e3.printStackTrace();
        }
        return spannableStringBuilder;
    }

    static void updateFromHTML(io.dcloud.feature.nativeObj.richtext.IAssets iAssets, io.dcloud.common.DHInterface.IWebview iWebview, android.widget.TextView textView, java.lang.String str, org.json.JSONObject jSONObject) {
        updateFromHTML(iAssets, iWebview, textView, str, jSONObject, null);
    }

    static void updateFromHTML(io.dcloud.feature.nativeObj.richtext.IAssets iAssets, io.dcloud.common.DHInterface.IWebview iWebview, android.widget.TextView textView, java.lang.String str, org.json.JSONObject jSONObject, io.dcloud.common.DHInterface.ICallBack iCallBack) {
        java.lang.String strConvert2AbsFullPath;
        android.graphics.Typeface typefaceCreate;
        if (jSONObject != null) {
            if (jSONObject.has(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY) && (typefaceCreate = android.graphics.Typeface.create(jSONObject.optString(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY), 0)) != null) {
                textView.setTypeface(typefaceCreate);
            }
            if (jSONObject.has("__onClickCallBackId__") && !io.dcloud.common.util.PdrUtil.isEmpty(jSONObject.optString("__onClickCallBackId__"))) {
                iAssets.setClick(true);
                iAssets.setOnClickCallBackId(jSONObject.optString("__onClickCallBackId__"));
            }
            if (jSONObject.has("fontSrc")) {
                java.lang.String strOptString = jSONObject.optString("fontSrc", "");
                if (strOptString.contains("__wap2app.ttf")) {
                    strConvert2AbsFullPath = io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__wap2app.ttf";
                    if (!new java.io.File(strConvert2AbsFullPath).exists()) {
                        strConvert2AbsFullPath = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), strOptString);
                    }
                } else {
                    strConvert2AbsFullPath = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), strOptString);
                }
                android.graphics.Typeface typeface = io.dcloud.feature.nativeObj.NativeTypefaceFactory.getTypeface(iWebview.obtainApp(), strConvert2AbsFullPath);
                if (typeface != null) {
                    textView.setTypeface(typeface);
                }
            }
            if (jSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ALIGN)) {
                java.lang.String strOptString2 = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ALIGN, "");
                if ("center".equalsIgnoreCase(strOptString2)) {
                    textView.setGravity(1);
                } else if ("right".equalsIgnoreCase(strOptString2)) {
                    textView.setGravity(5);
                } else {
                    textView.setGravity(3);
                }
            }
        }
        textView.setText(makeSpannableStringBuilder(iAssets, textView, str.replaceAll("&nbsp", com.taobao.weex.el.parse.Operators.SPACE_STR)));
        textView.setMovementMethod(new io.dcloud.feature.nativeObj.richtext.RichTextParser.LinkMovementMethodExt(iWebview, iCallBack, iAssets));
    }
}
