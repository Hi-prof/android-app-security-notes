package com.taobao.weex.appfram.clipboard;

/* JADX INFO: loaded from: classes.dex */
public class WXClipboardModule extends com.taobao.weex.common.WXModule implements com.taobao.weex.appfram.clipboard.IWXClipboard {
    private static final java.lang.String DATA = "data";
    private static final java.lang.String RESULT = "result";
    private static final java.lang.String RESULT_FAILED = "failed";
    private static final java.lang.String RESULT_OK = "success";
    private final java.lang.String CLIP_KEY = "WEEX_CLIP_KEY_MAIN";

    @Override // com.taobao.weex.appfram.clipboard.IWXClipboard
    @com.taobao.weex.annotation.JSMethod
    public void setString(java.lang.String str) {
        if (str == null) {
            return;
        }
        ((android.content.ClipboardManager) this.mWXSDKInstance.getContext().getSystemService("clipboard")).setPrimaryClip(android.content.ClipData.newPlainText("WEEX_CLIP_KEY_MAIN", str));
    }

    @Override // com.taobao.weex.appfram.clipboard.IWXClipboard
    @com.taobao.weex.annotation.JSMethod
    public void getString(com.taobao.weex.bridge.JSCallback jSCallback) throws java.lang.Throwable {
        android.content.Context context = this.mWXSDKInstance.getContext();
        android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) context.getSystemService("clipboard");
        java.util.HashMap map = new java.util.HashMap(2);
        android.content.ClipData primaryClip = clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            java.lang.CharSequence charSequenceCoerceToText = coerceToText(context, primaryClip.getItemAt(0));
            map.put("result", charSequenceCoerceToText != null ? "success" : "failed");
            map.put("data", charSequenceCoerceToText != null ? charSequenceCoerceToText : "");
        } else {
            map.put("result", "failed");
            map.put("data", "");
        }
        if (jSCallback != null) {
            jSCallback.invoke(map);
        }
    }

    /* JADX WARN: Code duplicated, block: B:69:0x006b A[EXC_TOP_SPLITTER, PHI: r7
  0x006b: PHI (r7v7 ??) = (r7v6 ??), (r7v9 ??) binds: [B:37:0x0069, B:54:0x0087] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r7v9 */
    private java.lang.CharSequence coerceToText(android.content.Context context, android.content.ClipData.Item item) throws java.lang.Throwable {
        java.io.InputStreamReader inputStreamReader;
        java.io.IOException e;
        java.lang.CharSequence text = item.getText();
        if (text != null) {
            return text;
        }
        android.net.Uri uri = item.getUri();
        ?? r1 = 0;
        inputStreamReader = null;
        r1 = 0;
        java.io.InputStreamReader inputStreamReader2 = null;
        try {
            if (uri == null) {
                android.content.Intent intent = item.getIntent();
                if (intent != null) {
                    return intent.toUri(1);
                }
                return null;
            }
            try {
                context = context.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null).createInputStream();
                try {
                    inputStreamReader = new java.io.InputStreamReader((java.io.InputStream) context, "UTF-8");
                    try {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
                        char[] cArr = new char[8192];
                        while (true) {
                            int i = inputStreamReader.read(cArr);
                            if (i <= 0) {
                                break;
                            }
                            sb.append(cArr, 0, i);
                        }
                        java.lang.String string = sb.toString();
                        try {
                            inputStreamReader.close();
                        } catch (java.io.IOException unused) {
                        }
                        if (context != 0) {
                            try {
                                context.close();
                            } catch (java.io.IOException unused2) {
                            }
                        }
                        return string;
                    } catch (java.io.FileNotFoundException unused3) {
                        inputStreamReader2 = inputStreamReader;
                        context = context;
                        if (inputStreamReader2 != null) {
                            try {
                                inputStreamReader2.close();
                            } catch (java.io.IOException unused4) {
                            }
                        }
                        if (context != 0) {
                            try {
                                context.close();
                            } catch (java.io.IOException unused5) {
                            }
                        }
                        return uri.toString();
                    } catch (java.io.IOException e2) {
                        e = e2;
                        com.taobao.weex.utils.WXLogUtils.w("ClippedData Failure loading text.", e);
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (java.io.IOException unused6) {
                            }
                        }
                        if (context != 0) {
                            context.close();
                        }
                        return uri.toString();
                    }
                } catch (java.io.FileNotFoundException unused7) {
                    context = context;
                } catch (java.io.IOException e3) {
                    e = e3;
                    inputStreamReader = null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (java.io.IOException unused8) {
                        }
                    }
                    if (context == 0) {
                        throw th;
                    }
                    try {
                        context.close();
                        throw th;
                    } catch (java.io.IOException unused9) {
                        throw th;
                    }
                }
            } catch (java.io.FileNotFoundException unused10) {
                context = 0;
            } catch (java.io.IOException e4) {
                inputStreamReader = null;
                e = e4;
                context = 0;
            } catch (java.lang.Throwable th2) {
                th = th2;
                context = 0;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            r1 = item;
        }
    }
}
