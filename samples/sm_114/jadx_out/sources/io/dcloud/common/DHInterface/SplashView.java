package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class SplashView extends android.widget.RelativeLayout {
    public static int STYLE_BLACK = 1;
    public static int STYLE_DEFAULT = 0;
    public static int STYLE_WHITE = 2;
    final java.lang.String TAG;
    private boolean hasAdSplash;
    protected boolean mShowSplashScreen;
    protected boolean mShowSplashWaiting;
    int screenHeight;
    int screenWidth;
    boolean showBitmap;

    public SplashView(android.content.Context context, android.graphics.Bitmap bitmap) {
        super(context);
        this.mShowSplashScreen = false;
        this.mShowSplashWaiting = false;
        this.TAG = "SplashView";
        this.showBitmap = false;
        this.hasAdSplash = false;
        setBackgroundColor(-1);
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
        setBackground(android.graphics.NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk()) ? new android.graphics.drawable.NinePatchDrawable(context.getResources(), bitmap, bitmap.getNinePatchChunk(), new android.graphics.Rect(), null) : new android.graphics.drawable.BitmapDrawable(context.getResources(), bitmap));
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view instanceof io.dcloud.feature.internal.splash.ISplash) {
            this.hasAdSplash = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        if (io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight <= 0) {
            io.dcloud.common.adapter.util.Logger.d("SplashView", "paint() before DeviceInfo.updateScreenInfo()");
            io.dcloud.common.adapter.util.DeviceInfo.updateStatusBarHeight((android.app.Activity) getContext());
        }
        io.dcloud.common.adapter.util.Logger.d("SplashView", "dispatchDraw.....");
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.hasAdSplash) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onShowProgressBar(android.view.ViewGroup viewGroup, int i) {
        android.graphics.drawable.Drawable drawable;
        if (this.hasAdSplash) {
            return;
        }
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "showWaiting style=" + i);
        android.widget.ProgressBar progressBar = new android.widget.ProgressBar(getContext());
        int i2 = io.dcloud.common.util.PdrUtil.parseInt("7%", this.screenWidth, -1);
        setGravity(17);
        if (i == STYLE_BLACK) {
            drawable = getContext().getResources().getDrawable(io.dcloud.PdrR.DRAWBLE_PROGRESSBAR_BLACK_SNOW);
        } else {
            drawable = i == STYLE_WHITE ? getContext().getResources().getDrawable(io.dcloud.PdrR.DRAWBLE_PROGRESSBAR_WHITE_SNOW) : null;
        }
        if (drawable != null) {
            progressBar.setIndeterminateDrawable(drawable);
        }
        viewGroup.addView(progressBar, new android.widget.RelativeLayout.LayoutParams(i2, i2));
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "onShowProgressBar");
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return true;
    }

    public void showWaiting() {
        showWaiting(STYLE_DEFAULT);
    }

    public void showWaiting(final int i) {
        post(new java.lang.Runnable() { // from class: io.dcloud.common.DHInterface.SplashView.1
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.common.DHInterface.SplashView splashView = io.dcloud.common.DHInterface.SplashView.this;
                splashView.onShowProgressBar(splashView, i);
            }
        });
    }
}
