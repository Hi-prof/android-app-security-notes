package io.dcloud.media.weex.weex_video.ijkplayer.danmaku;

/* JADX INFO: loaded from: classes2.dex */
public class BiliDanmukuParser extends master.flame.danmaku.danmaku.parser.BaseDanmakuParser {
    private float mDispScaleX;
    private float mDispScaleY;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPercentageNumber(float f) {
        return f >= 0.0f && f <= 1.0f;
    }

    static {
        java.lang.System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
    }

    @Override // master.flame.danmaku.danmaku.parser.BaseDanmakuParser
    public master.flame.danmaku.danmaku.model.android.Danmakus parse() {
        if (this.mDataSource == null) {
            return null;
        }
        master.flame.danmaku.danmaku.parser.android.AndroidFileSource androidFileSource = (master.flame.danmaku.danmaku.parser.android.AndroidFileSource) this.mDataSource;
        try {
            org.xml.sax.XMLReader xMLReaderCreateXMLReader = org.xml.sax.helpers.XMLReaderFactory.createXMLReader();
            io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.XmlContentHandler xmlContentHandler = new io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.XmlContentHandler();
            xMLReaderCreateXMLReader.setContentHandler(xmlContentHandler);
            xMLReaderCreateXMLReader.parse(new org.xml.sax.InputSource(androidFileSource.data()));
            return xmlContentHandler.getResult();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        } catch (org.xml.sax.SAXException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public class XmlContentHandler extends org.xml.sax.helpers.DefaultHandler {
        private static final java.lang.String TRUE_STRING = "true";
        public master.flame.danmaku.danmaku.model.android.Danmakus result = null;
        public master.flame.danmaku.danmaku.model.BaseDanmaku item = null;
        public boolean completed = false;
        public int index = 0;

        public XmlContentHandler() {
        }

        public master.flame.danmaku.danmaku.model.android.Danmakus getResult() {
            return this.result;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws org.xml.sax.SAXException {
            this.result = new master.flame.danmaku.danmaku.model.android.Danmakus();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws org.xml.sax.SAXException {
            this.completed = true;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(java.lang.String str, java.lang.String str2, java.lang.String str3, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
            if (str2.length() == 0) {
                str2 = str3;
            }
            if (str2.toLowerCase(java.util.Locale.getDefault()).trim().equals("d")) {
                java.lang.String[] strArrSplit = attributes.getValue(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT).split(",");
                if (strArrSplit.length > 0) {
                    long j = (long) (java.lang.Float.parseFloat(strArrSplit[0]) * 1000.0f);
                    int i = java.lang.Integer.parseInt(strArrSplit[1]);
                    float f = java.lang.Float.parseFloat(strArrSplit[2]);
                    int i2 = (int) (java.lang.Long.parseLong(strArrSplit[3]) | (-16777216));
                    master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmakuCreateDanmaku = io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.this.mContext.mDanmakuFactory.createDanmaku(i, io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.this.mContext);
                    this.item = baseDanmakuCreateDanmaku;
                    if (baseDanmakuCreateDanmaku != null) {
                        baseDanmakuCreateDanmaku.setTime(j);
                        this.item.textSize = f * (io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.this.mDispDensity - 0.6f);
                        this.item.textColor = i2;
                        this.item.textShadowColor = i2 <= -16777216 ? -1 : -16777216;
                    }
                }
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(java.lang.String str, java.lang.String str2, java.lang.String str3) throws org.xml.sax.SAXException {
            master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku = this.item;
            if (baseDanmaku != null) {
                if (baseDanmaku.duration != null) {
                    if (str2.length() == 0) {
                        str2 = str3;
                    }
                    if (str2.equalsIgnoreCase("d")) {
                        this.item.setTimer(io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.this.mTimer);
                        this.result.addItem(this.item);
                    }
                }
                this.item = null;
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            java.lang.String[] strArr;
            float f;
            float f2;
            char c;
            float f3;
            float f4;
            long j;
            long j2;
            java.lang.String[] strArrSplit;
            master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku = this.item;
            if (baseDanmaku != null) {
                master.flame.danmaku.danmaku.util.DanmakuUtils.fillText(baseDanmaku, decodeXmlString(new java.lang.String(cArr, i, i2)));
                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2 = this.item;
                int i3 = this.index;
                this.index = i3 + 1;
                baseDanmaku2.index = i3;
                java.lang.String strTrim = java.lang.String.valueOf(this.item.text).trim();
                if (this.item.getType() == 7 && strTrim.startsWith(com.taobao.weex.el.parse.Operators.ARRAY_START_STR) && strTrim.endsWith(com.taobao.weex.el.parse.Operators.ARRAY_END_STR)) {
                    try {
                        org.json.JSONArray jSONArray = new org.json.JSONArray(strTrim);
                        int length = jSONArray.length();
                        strArr = new java.lang.String[length];
                        for (int i4 = 0; i4 < length; i4++) {
                            try {
                                strArr[i4] = jSONArray.getString(i4);
                            } catch (org.json.JSONException e) {
                                e = e;
                                e.printStackTrace();
                                if (strArr != null) {
                                }
                                this.item = null;
                                return;
                            }
                        }
                    } catch (org.json.JSONException e2) {
                        e = e2;
                        strArr = null;
                    }
                    if (strArr != null || strArr.length < 5) {
                        this.item = null;
                        return;
                    }
                    this.item.text = strArr[4];
                    float f5 = java.lang.Float.parseFloat(strArr[0]);
                    float f6 = java.lang.Float.parseFloat(strArr[1]);
                    java.lang.String[] strArrSplit2 = strArr[2].split(com.taobao.weex.el.parse.Operators.SUB);
                    int i5 = (int) (master.flame.danmaku.danmaku.model.AlphaValue.MAX * java.lang.Float.parseFloat(strArrSplit2[0]));
                    int i6 = strArrSplit2.length > 1 ? (int) (master.flame.danmaku.danmaku.model.AlphaValue.MAX * java.lang.Float.parseFloat(strArrSplit2[1])) : i5;
                    long j3 = (long) (java.lang.Float.parseFloat(strArr[3]) * 1000.0f);
                    if (strArr.length >= 7) {
                        f = java.lang.Float.parseFloat(strArr[5]);
                        f2 = java.lang.Float.parseFloat(strArr[6]);
                    } else {
                        f = 0.0f;
                        f2 = 0.0f;
                    }
                    if (strArr.length >= 11) {
                        f3 = java.lang.Float.parseFloat(strArr[7]);
                        float f7 = java.lang.Float.parseFloat(strArr[8]);
                        c = 11;
                        j = !"".equals(strArr[9]) ? java.lang.Integer.parseInt(strArr[9]) : j3;
                        j2 = !"".equals(strArr[10]) ? (long) java.lang.Float.parseFloat(strArr[10]) : 0L;
                        f4 = f7;
                    } else {
                        f = f;
                        c = 11;
                        f3 = f5;
                        f4 = f6;
                        j = j3;
                        j2 = 0;
                    }
                    if (io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.this.isPercentageNumber(f5)) {
                        f5 *= 682.0f;
                    }
                    float f8 = f5;
                    if (io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.this.isPercentageNumber(f6)) {
                        f6 *= 438.0f;
                    }
                    float f9 = f6;
                    if (io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.this.isPercentageNumber(f3)) {
                        f3 *= 682.0f;
                    }
                    float f10 = f3;
                    if (io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.this.isPercentageNumber(f4)) {
                        f4 *= 438.0f;
                    }
                    this.item.duration = new master.flame.danmaku.danmaku.model.Duration(j3);
                    this.item.rotationZ = f;
                    this.item.rotationY = f2;
                    io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.this.mContext.mDanmakuFactory.fillTranslationData(this.item, f8, f9, f10, f4, j, j2, io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.this.mDispScaleX, io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.this.mDispScaleY);
                    io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.this.mContext.mDanmakuFactory.fillAlphaData(this.item, i5, i6, j3);
                    if (strArr.length >= 12 && !android.text.TextUtils.isEmpty(strArr[c]) && "true".equals(strArr[c])) {
                        this.item.textShadowColor = 0;
                    }
                    int length2 = strArr.length;
                    int length3 = strArr.length;
                    if (strArr.length < 15 || "".equals(strArr[14]) || (strArrSplit = strArr[14].substring(1).split("L")) == null || strArrSplit.length <= 0) {
                        return;
                    }
                    float[][] fArr = (float[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Float.TYPE, strArrSplit.length, 2);
                    for (int i7 = 0; i7 < strArrSplit.length; i7++) {
                        java.lang.String[] strArrSplit3 = strArrSplit[i7].split(",");
                        fArr[i7][0] = java.lang.Float.parseFloat(strArrSplit3[0]);
                        fArr[i7][1] = java.lang.Float.parseFloat(strArrSplit3[1]);
                    }
                    master.flame.danmaku.danmaku.model.android.DanmakuFactory danmakuFactory = io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.this.mContext.mDanmakuFactory;
                    master.flame.danmaku.danmaku.model.android.DanmakuFactory.fillLinePathData(this.item, fArr, io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.this.mDispScaleX, io.dcloud.media.weex.weex_video.ijkplayer.danmaku.BiliDanmukuParser.this.mDispScaleY);
                }
            }
        }

        private java.lang.String decodeXmlString(java.lang.String str) {
            if (str.contains("&amp;")) {
                str = str.replace("&amp;", "&");
            }
            if (str.contains("&quot;")) {
                str = str.replace("&quot;", io.dcloud.common.util.JSUtil.QUOTE);
            }
            if (str.contains("&gt;")) {
                str = str.replace("&gt;", com.taobao.weex.el.parse.Operators.G);
            }
            return str.contains("&lt;") ? str.replace("&lt;", com.taobao.weex.el.parse.Operators.L) : str;
        }
    }

    @Override // master.flame.danmaku.danmaku.parser.BaseDanmakuParser
    public master.flame.danmaku.danmaku.parser.BaseDanmakuParser setDisplayer(master.flame.danmaku.danmaku.model.IDisplayer iDisplayer) {
        super.setDisplayer(iDisplayer);
        this.mDispScaleX = this.mDispWidth / 682.0f;
        this.mDispScaleY = this.mDispHeight / 438.0f;
        return this;
    }
}
