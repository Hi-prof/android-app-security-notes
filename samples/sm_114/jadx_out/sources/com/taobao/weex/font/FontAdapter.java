package com.taobao.weex.font;

/* JADX INFO: loaded from: classes.dex */
public class FontAdapter {
    private java.util.List<com.taobao.weex.font.FontListener> mFontListener = new java.util.concurrent.CopyOnWriteArrayList();

    public void addFontListener(com.taobao.weex.font.FontListener fontListener) {
        this.mFontListener.add(fontListener);
    }

    public void removeFontListener(com.taobao.weex.font.FontListener fontListener) {
        this.mFontListener.remove(fontListener);
    }

    public void onAddFontRule(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        synchronized (this) {
            java.util.Iterator<com.taobao.weex.font.FontListener> it = this.mFontListener.iterator();
            while (it.hasNext()) {
                it.next().onAddFontRule(str, str2, str3);
            }
        }
    }

    public void onFontLoad(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        synchronized (this) {
            java.util.Iterator<com.taobao.weex.font.FontListener> it = this.mFontListener.iterator();
            while (it.hasNext()) {
                it.next().onFontLoad(str, str2, str3);
            }
        }
    }
}
