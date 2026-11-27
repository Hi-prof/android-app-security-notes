package io.dcloud.feature.internal.splash;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class SplashView4StreamApp extends android.widget.RelativeLayout implements io.dcloud.feature.internal.splash.ISplash {
    private android.graphics.Bitmap a;
    private android.widget.ImageView b;
    private android.widget.TextView c;

    public SplashView4StreamApp(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.view.View viewInflate = android.view.View.inflate(context, io.dcloud.PdrR.getInt(context, com.taobao.weex.common.Constants.Name.LAYOUT, "dcloud_view_splash"), this);
        ((android.widget.TextView) viewInflate.findViewById(io.dcloud.PdrR.getInt(context, "id", "tv_copyright_splash_dcloud"))).setTypeface(android.graphics.Typeface.create("宋体", 2));
        android.widget.TextView textView = (android.widget.TextView) viewInflate.findViewById(io.dcloud.PdrR.getInt(context, "id", "tv_loading_splash_dcloud"));
        if (!android.text.TextUtils.isEmpty(str2)) {
            textView.setText(str2);
        }
        textView.setTypeface(android.graphics.Typeface.create("宋体", 1));
        android.widget.TextView textView2 = (android.widget.TextView) viewInflate.findViewById(io.dcloud.PdrR.getInt(context, "id", "tv_name_splash_dcloud"));
        this.c = textView2;
        textView2.setTypeface(android.graphics.Typeface.create("宋体", 1));
        if (!android.text.TextUtils.isEmpty(str)) {
            textView2.setText(str);
        }
        android.widget.ImageView imageView = (android.widget.ImageView) viewInflate.findViewById(io.dcloud.PdrR.getInt(context, "id", "iv_icon_splash_dcloud"));
        this.b = imageView;
        android.graphics.Bitmap bitmap = this.a;
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        return true;
    }

    @Override // io.dcloud.feature.internal.splash.ISplash
    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        if (bitmap != null) {
            this.a = bitmap;
            this.b.setImageBitmap(bitmap);
            android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.3f, 1.0f);
            alphaAnimation.setDuration(800L);
            this.b.startAnimation(alphaAnimation);
        }
    }

    @Override // io.dcloud.feature.internal.splash.ISplash
    public void setNameText(java.lang.String str) {
        android.widget.TextView textView = this.c;
        if (textView == null || !android.text.TextUtils.isEmpty(textView.getText())) {
            return;
        }
        this.c.setText(str);
    }

    public SplashView4StreamApp(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SplashView4StreamApp(android.content.Context context, android.graphics.Bitmap bitmap, java.lang.String str) {
        super(context);
        this.a = bitmap;
        a(context, str, null);
    }

    public SplashView4StreamApp(android.content.Context context, android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2) {
        super(context);
        this.a = bitmap;
        a(context, str, str2);
    }
}
