package io.dcloud.feature.gg.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class GGSplashView extends android.widget.FrameLayout implements io.dcloud.feature.internal.splash.ISplash {
    java.lang.String appid;
    android.view.View bottomIcon;
    android.widget.FrameLayout container;
    android.os.Handler handler;
    io.dcloud.common.DHInterface.ICallBack mCallBack;
    private long pullTime;

    public GGSplashView(android.app.Activity activity) {
        super(activity);
        this.handler = new android.os.Handler(android.os.Looper.getMainLooper());
        initView(activity);
    }

    private void initView(android.app.Activity activity) {
        try {
            android.view.View viewInflate = android.view.LayoutInflater.from(activity).inflate(io.dcloud.PdrR.getInt(activity, com.taobao.weex.common.Constants.Name.LAYOUT, io.dcloud.common.util.PdrUtil.dealString("ilWlkdg}lW{xdi{`")), (android.view.ViewGroup) null);
            viewInflate.setBackgroundColor(getBgColor());
            addView(viewInflate);
            this.container = (android.widget.FrameLayout) viewInflate.findViewById(io.dcloud.PdrR.getInt(activity, "id", io.dcloud.common.util.PdrUtil.dealString("ilWlkdg}lW{xdi{`Wkgf|iafmz")));
            android.graphics.drawable.Drawable icon = getIcon();
            this.bottomIcon = viewInflate.findViewById(io.dcloud.PdrR.getInt(activity, "id", io.dcloud.common.util.PdrUtil.dealString("ilWlkdg}lW{xdi{`Wjg||geWjiz")));
            android.widget.ImageView imageView = (android.widget.ImageView) findViewById(io.dcloud.PdrR.getInt(activity, "id", io.dcloud.common.util.PdrUtil.dealString("ilWlkdg}lWakgfW{afodm")));
            if (icon == null) {
                imageView.setVisibility(8);
                ((android.widget.ImageView) findViewById(io.dcloud.PdrR.getInt(activity, "id", io.dcloud.common.util.PdrUtil.dealString("ilWlkdg}lWakgf")))).setImageDrawable(io.dcloud.feature.gg.AolSplashUtil.getApplicationIcon(activity));
                ((android.widget.TextView) findViewById(io.dcloud.PdrR.getInt(activity, "id", io.dcloud.common.util.PdrUtil.dealString("ilWlkdg}lWfiem")))).setText(io.dcloud.feature.gg.AolSplashUtil.getApplicationName(activity));
            } else {
                imageView.setVisibility(0);
                imageView.setImageDrawable(icon);
                findViewById(io.dcloud.PdrR.getInt(activity, "id", io.dcloud.common.util.PdrUtil.dealString("ilWlkdg}lWfiem"))).setVisibility(8);
                findViewById(io.dcloud.PdrR.getInt(activity, "id", io.dcloud.common.util.PdrUtil.dealString("ilWlkdg}lWakgf"))).setVisibility(8);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    java.lang.String get(java.lang.String str) {
        return io.dcloud.common.adapter.util.SP.getBundleData(io.dcloud.feature.gg.dcloud.ADHandler.AdTag, str);
    }

    public int getBgColor() {
        int iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(get("bg"));
        if (iStringToColor != -1) {
            return iStringToColor;
        }
        return -1;
    }

    public android.view.View getBottomIcon() {
        return this.bottomIcon;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d  */
    public android.graphics.drawable.Drawable getIcon() {
        android.graphics.Bitmap bitmapDecodeStream;
        java.lang.String str = get(com.taobao.weex.ui.component.WXBasicComponentType.IMG);
        if (android.text.TextUtils.isEmpty(str)) {
            bitmapDecodeStream = null;
        } else if (!io.dcloud.common.util.PdrUtil.isDeviceRootDir(str)) {
            bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(io.dcloud.common.adapter.util.PlatformUtil.getInputStream(str, 0));
        } else if (new java.io.File(str).exists()) {
            bitmapDecodeStream = android.graphics.BitmapFactory.decodeFile(str);
        } else {
            bitmapDecodeStream = null;
        }
        if (bitmapDecodeStream != null) {
            return new android.graphics.drawable.BitmapDrawable(bitmapDecodeStream);
        }
        return null;
    }

    public android.widget.FrameLayout getImgContainer() {
        return this.container;
    }

    public void onFinishShow() {
        io.dcloud.common.DHInterface.ICallBack iCallBack = this.mCallBack;
        if (iCallBack != null) {
            iCallBack.onCallBack(1, this.appid);
            this.mCallBack = null;
        }
        android.widget.FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    public void onWillCloseSplash() {
        if (this.container.getChildCount() == 0) {
            onFinishShow();
        }
    }

    public void setAppid(java.lang.String str) {
        this.appid = str;
    }

    public void setCallBack(io.dcloud.common.DHInterface.ICallBack iCallBack) {
        this.mCallBack = iCallBack;
    }

    @Override // io.dcloud.feature.internal.splash.ISplash
    public void setImageBitmap(android.graphics.Bitmap bitmap) {
    }

    @Override // io.dcloud.feature.internal.splash.ISplash
    public void setNameText(java.lang.String str) {
    }

    public void setPullTime(long j) {
        this.pullTime = j;
    }

    public void showAd(final io.dcloud.p.v vVar) {
        if (getParent() != null) {
            vVar.a((android.view.ViewGroup) this.container);
        } else {
            this.handler.postDelayed(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.GGSplashView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (io.dcloud.feature.gg.dcloud.GGSplashView.this.getParent() != null) {
                        vVar.a((android.view.ViewGroup) io.dcloud.feature.gg.dcloud.GGSplashView.this.container);
                    } else {
                        io.dcloud.feature.gg.dcloud.GGSplashView.this.handler.postDelayed(this, 20L);
                    }
                }
            }, 20L);
        }
    }
}
