package com.taobao.weex.ui.component.list;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerTransform {
    private static final java.lang.String TAG = "RecyclerTransform";
    public static final java.lang.String TRANSFORM = "transform";
    private static final java.util.regex.Pattern transformPattern = java.util.regex.Pattern.compile("([a-z]+)\\(([0-9\\.]+),?([0-9\\.]+)?\\)");

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static androidx.recyclerview.widget.RecyclerView.ItemDecoration parseTransforms(int i, java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.util.regex.Matcher matcher = transformPattern.matcher(str);
        float f = 0.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (matcher.find()) {
            java.lang.String strGroup = matcher.group();
            java.lang.String strGroup2 = matcher.group(1);
            try {
                switch (strGroup2.hashCode()) {
                    case -1267206133:
                        if (!strGroup2.equals("opacity")) {
                            com.taobao.weex.utils.WXLogUtils.e(TAG, "Invaild transform expression:" + strGroup);
                        } else {
                            f = java.lang.Float.parseFloat(matcher.group(2));
                        }
                        break;
                    case -925180581:
                        if (!strGroup2.equals("rotate")) {
                            com.taobao.weex.utils.WXLogUtils.e(TAG, "Invaild transform expression:" + strGroup);
                        } else {
                            i4 = java.lang.Integer.parseInt(matcher.group(2));
                        }
                        break;
                    case 109250890:
                        if (!strGroup2.equals("scale")) {
                            com.taobao.weex.utils.WXLogUtils.e(TAG, "Invaild transform expression:" + strGroup);
                        } else {
                            f2 = java.lang.Float.parseFloat(matcher.group(2));
                            f3 = java.lang.Float.parseFloat(matcher.group(3));
                        }
                        break;
                    case 1052832078:
                        if (!strGroup2.equals("translate")) {
                            com.taobao.weex.utils.WXLogUtils.e(TAG, "Invaild transform expression:" + strGroup);
                        } else {
                            i2 = java.lang.Integer.parseInt(matcher.group(2));
                            i3 = java.lang.Integer.parseInt(matcher.group(3));
                        }
                        break;
                    default:
                        com.taobao.weex.utils.WXLogUtils.e(TAG, "Invaild transform expression:" + strGroup);
                        break;
                }
            } catch (java.lang.NumberFormatException e) {
                com.taobao.weex.utils.WXLogUtils.e("", e);
                com.taobao.weex.utils.WXLogUtils.e(TAG, "Invaild transform expression:" + strGroup);
            }
        }
        return new com.taobao.weex.ui.view.listview.adapter.TransformItemDecoration(i == 1, f, i2, i3, i4, f2, f3);
    }
}
