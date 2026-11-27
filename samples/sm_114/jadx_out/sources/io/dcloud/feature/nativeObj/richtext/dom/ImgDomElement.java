package io.dcloud.feature.nativeObj.richtext.dom;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ImgDomElement extends io.dcloud.feature.nativeObj.richtext.dom.DomElement {
    public java.lang.String height;
    public java.lang.String href;
    io.dcloud.feature.nativeObj.richtext.dom.ImgDomElement.AsycLoader mAsycLoader;
    public java.lang.String src;
    public java.lang.String width;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class AsycLoader {
        public int height;
        java.lang.String href;
        public io.dcloud.feature.nativeObj.richtext.span.ImgSpan self;
        public android.text.SpannableStringBuilder spaned;
        public android.widget.TextView textView;
        public java.lang.String url;
        public int width;

        public AsycLoader(android.widget.TextView textView, android.text.SpannableStringBuilder spannableStringBuilder, io.dcloud.feature.nativeObj.richtext.span.ImgSpan imgSpan, java.lang.String str, int i, int i2, java.lang.String str2) {
            this.textView = textView;
            this.spaned = spannableStringBuilder;
            this.self = imgSpan;
            this.url = str;
            this.width = i;
            this.height = i2;
            this.href = str2;
        }

        public void onComplete(android.graphics.Bitmap bitmap) {
            android.text.SpannableStringBuilder spannableStringBuilder = this.spaned;
            io.dcloud.feature.nativeObj.richtext.span.ImgSpan imgSpan = this.self;
            java.lang.String source = imgSpan.getSource();
            if (bitmap != null) {
                android.graphics.drawable.BitmapDrawable bitmapDrawable = new android.graphics.drawable.BitmapDrawable(bitmap);
                java.lang.StringBuilder sb = new java.lang.StringBuilder("after w=");
                int width = this.width;
                if (width <= 0) {
                    width = bitmap.getWidth();
                }
                sb.append(width);
                sb.append(";h=");
                int height = this.height;
                if (height <= 0) {
                    height = bitmap.getHeight();
                }
                sb.append(height);
                android.util.Log.e("DnetImg", sb.toString());
                int width2 = this.width;
                if (width2 <= 0) {
                    width2 = bitmap.getWidth();
                }
                int height2 = this.height;
                if (height2 <= 0) {
                    height2 = bitmap.getHeight();
                }
                bitmapDrawable.setBounds(0, 0, width2, height2);
                io.dcloud.feature.nativeObj.richtext.span.ImgSpan imgSpan2 = new io.dcloud.feature.nativeObj.richtext.span.ImgSpan(bitmapDrawable, source, 0, imgSpan.getOnClickEvent(), this.href);
                int spanStart = spannableStringBuilder.getSpanStart(imgSpan);
                int spanEnd = spannableStringBuilder.getSpanEnd(imgSpan);
                if (spanStart < 0 || spanEnd < 0) {
                    return;
                }
                spannableStringBuilder.removeSpan(imgSpan);
                spannableStringBuilder.setSpan(imgSpan2, spanStart, spanEnd, 17);
                this.textView.post(new java.lang.Runnable() { // from class: io.dcloud.feature.nativeObj.richtext.dom.ImgDomElement.AsycLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        io.dcloud.feature.nativeObj.richtext.dom.ImgDomElement.AsycLoader asycLoader = io.dcloud.feature.nativeObj.richtext.dom.ImgDomElement.AsycLoader.this;
                        asycLoader.textView.setText(asycLoader.spaned);
                        io.dcloud.feature.nativeObj.richtext.dom.ImgDomElement.AsycLoader.this.textView.requestLayout();
                    }
                });
            }
        }
    }

    public java.lang.String getSrc() {
        return this.src;
    }

    @Override // io.dcloud.feature.nativeObj.richtext.dom.DomElement
    public void makeSpan(io.dcloud.feature.nativeObj.richtext.IAssets iAssets, android.widget.TextView textView, android.text.SpannableStringBuilder spannableStringBuilder) {
        java.lang.String str;
        java.lang.String str2;
        java.util.HashMap<java.lang.String, java.lang.String> map = this.style;
        if (map != null) {
            str = map.get("width");
            str2 = this.style.get("height");
        } else {
            str = null;
            str2 = null;
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = this.height;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = this.width;
        }
        int iConvertWidth = (int) iAssets.convertWidth(str, -2.0f);
        int iConvertHeight = (int) iAssets.convertHeight(str2, -2.0f);
        boolean zIsNetworkUrl = android.webkit.URLUtil.isNetworkUrl(this.src);
        android.graphics.drawable.Drawable drawable = zIsNetworkUrl ? android.content.res.Resources.getSystem().getDrawable(android.R.drawable.screen_background_dark_transparent) : new android.graphics.drawable.BitmapDrawable(android.graphics.BitmapFactory.decodeStream(iAssets.convert2InputStream(this.src)));
        drawable.setBounds(0, 0, iConvertWidth > 0 ? iConvertWidth : drawable.getIntrinsicWidth(), iConvertHeight > 0 ? iConvertHeight : drawable.getIntrinsicHeight());
        io.dcloud.feature.nativeObj.richtext.span.ImgSpan imgSpan = new io.dcloud.feature.nativeObj.richtext.span.ImgSpan(drawable, this.src, 0, this.onClickEvent, this.href);
        spannableStringBuilder.append("￼");
        spannableStringBuilder.setSpan(imgSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
        if (zIsNetworkUrl) {
            iAssets.loadResource(new io.dcloud.feature.nativeObj.richtext.dom.ImgDomElement.AsycLoader(textView, spannableStringBuilder, imgSpan, this.src, iConvertWidth, iConvertHeight, this.href));
        }
    }

    @Override // io.dcloud.feature.nativeObj.richtext.dom.DomElement
    public void parseDomElement(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        super.parseDomElement(xmlPullParser);
        this.src = xmlPullParser.getAttributeValue(xmlPullParser.getNamespace(), "src");
        this.width = xmlPullParser.getAttributeValue(xmlPullParser.getNamespace(), "width");
        this.height = xmlPullParser.getAttributeValue(xmlPullParser.getNamespace(), "height");
        this.href = xmlPullParser.getAttributeValue(xmlPullParser.getNamespace(), "href");
    }
}
